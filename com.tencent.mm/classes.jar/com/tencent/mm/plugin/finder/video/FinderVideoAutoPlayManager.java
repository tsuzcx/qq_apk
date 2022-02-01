package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProvider;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.p.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.q;
import d.g.b.y.a;
import d.l;
import d.v;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "tabType", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;I)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "hasTryMoreAgainSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "isLocked", "", "isResume", "lockKV", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaRect", "Landroid/graphics/Rect;", "mediaViewLocation", "", "preCenterFeedId", "", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "getTabType", "()I", "check2Play", "", "mediaIndex", "playPosition", "check2SendShowCommentMsg", "centerFeedId", "check2ShowCommentInput", "feedId", "getNearbyDistance", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isAsync", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "isUserVisibleFocused", "lock", "scene", "isLock", "unLockAfterCheck", "onCreate", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onEventHappen", "ev", "onPause", "onRelease", "onResume", "onStart", "onStop", "pauseAllVideo", "without", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "playFocusHolder", "focusHolder", "focusMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "playMultiVideoHolder", "playSingleVideoHolder", "prepareHolder", "setup", "Companion", "plugin-finder_release"})
public final class FinderVideoAutoPlayManager
  extends d
  implements UILifecycleObserver
{
  public static final FinderVideoAutoPlayManager.a tac;
  private boolean aIe;
  private final MMActivity activity;
  private final int dvm;
  final RecyclerView gpr;
  private final aq hXp;
  private boolean isResume;
  private final Rect sXx;
  private final int[] sZX;
  private long sZY;
  private final HashSet<String> sZZ;
  private final HashSet<String> taa;
  private final FinderVideoRecycler tab;
  
  static
  {
    AppMethodBeat.i(168029);
    tac = new FinderVideoAutoPlayManager.a((byte)0);
    AppMethodBeat.o(168029);
  }
  
  public FinderVideoAutoPlayManager(MMActivity paramMMActivity, RecyclerView paramRecyclerView, FinderVideoRecycler paramFinderVideoRecycler, int paramInt)
  {
    AppMethodBeat.i(205405);
    this.activity = paramMMActivity;
    this.gpr = paramRecyclerView;
    this.tab = paramFinderVideoRecycler;
    this.dvm = paramInt;
    this.sZX = new int[2];
    this.hXp = new aq(Looper.getMainLooper(), (aq.a)new b(this));
    this.sZY = -1L;
    this.sZZ = new HashSet();
    this.sXx = new Rect();
    this.taa = new HashSet();
    AppMethodBeat.o(205405);
  }
  
  private final void U(RecyclerView.w paramw)
  {
    AppMethodBeat.i(168020);
    if (paramw != null)
    {
      paramw = paramw.auu;
      if (paramw == null) {}
    }
    for (paramw = (FinderVideoLayout)paramw.findViewById(2131299975);; paramw = null)
    {
      this.tab.E((d.g.a.b)new d(paramw));
      AppMethodBeat.o(168020);
      return;
    }
  }
  
  private static void a(RecyclerView.w paramw, bvz parambvz, long paramLong)
  {
    AppMethodBeat.i(205403);
    if (paramw != null)
    {
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramw.auu.findViewById(2131299975);
      if (localFinderVideoLayout != null)
      {
        localFinderVideoLayout.play(paramw.lN());
        AppMethodBeat.o(205403);
        return;
      }
      ae.e("Finder.VideoAutoPlayManager", "playFocusHolder videoContainer is null! mediaId=" + parambvz.mediaId + "] feedId=" + paramLong);
    }
    AppMethodBeat.o(205403);
  }
  
  private static void b(RecyclerView.w paramw, bvz parambvz, long paramLong)
  {
    AppMethodBeat.i(205404);
    if (paramw != null)
    {
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramw.auu.findViewById(2131299975);
      if (localFinderVideoLayout != null)
      {
        ae.d("Finder.VideoAutoPlayManager", "prepareToPlay ".concat(String.valueOf(paramLong)));
        paramw.lN();
        localFinderVideoLayout.cPc();
        AppMethodBeat.o(205404);
        return;
      }
      ae.e("Finder.VideoAutoPlayManager", "prepareHolder videoContainer is null! mediaId=" + parambvz.mediaId + "] feedId=" + paramLong);
      AppMethodBeat.o(205404);
      return;
    }
    AppMethodBeat.o(205404);
  }
  
  private final void xI(long paramLong)
  {
    AppMethodBeat.i(205402);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if ((((Number)com.tencent.mm.plugin.finder.storage.b.cKF().value()).intValue() == 1) && (this.sZY != paramLong))
    {
      this.sZY = paramLong;
      ae.i("Finder.VideoAutoPlayManager", "send show comment msg,feedId:".concat(String.valueOf(paramLong)));
      this.hXp.removeMessages(2);
      localObject = this.hXp.obtainMessage(2);
      ((Message)localObject).obj = Long.valueOf(paramLong);
      this.hXp.sendMessageDelayed((Message)localObject, 5000L);
    }
    AppMethodBeat.o(205402);
  }
  
  private final void y(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(205401);
    Object localObject1 = paramRecyclerView.getLayoutManager();
    final int i;
    final int j;
    Object localObject2;
    final y.a locala;
    Object localObject3;
    if ((localObject1 instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)localObject1).km();
      j = ((LinearLayoutManager)localObject1).ko();
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.b(paramRecyclerView, i, j, 8);
      xI(((p.a)localObject2).duw);
      locala = new y.a();
      locala.NiT = false;
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject3 = ((p.a)localObject2).rVa;
      BaseFinderFeed localBaseFinderFeed = ((p.a)localObject2).rZB;
      localObject1 = ((p.a)localObject2).rZB;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if (localObject1 != null)
        {
          localObject1 = ((FinderItem)localObject1).getMediaList();
          if (localObject1 != null) {
            localObject1 = (bvz)j.jm((List)localObject1);
          }
        }
      }
      while ((localObject3 != null) && (localBaseFinderFeed != null) && (localObject1 != null))
      {
        if (((e)localObject3).lM() != ((e)localObject3).lN())
        {
          localObject4 = "[check2Play] holder=" + localObject3 + " centerId=" + ((p.a)localObject2).duw + " first=" + i + " end=" + j + " adapterPosition=" + ((e)localObject3).lN() + " layoutPosition=" + ((e)localObject3).lM() + " isInLayout=" + paramRecyclerView.isInLayout();
          ae.e("Finder.VideoAutoPlayManager", (String)localObject4);
          com.tencent.mm.plugin.report.service.g.yxI.f(20251, new Object[] { Integer.valueOf(1), localObject4 });
          localObject4 = ((e)localObject3).hashCode() + '_' + ((e)localObject3).lN() + '_' + ((e)localObject3).lM() + '_' + ((e)localObject3).lP();
          if (!this.taa.contains(localObject4))
          {
            paramRecyclerView.post((Runnable)new e((String)localObject4, this, (p.a)localObject2, i, j, paramRecyclerView, locala));
            AppMethodBeat.o(205401);
            return;
            localObject1 = null;
            continue;
          }
        }
        Object localObject4 = com.tencent.mm.ui.component.a.KEX;
        localObject4 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).GS(this.dvm);
        if (localObject4 != null) {
          ((f)localObject4).g(paramRecyclerView, 6);
        }
        paramRecyclerView = (FinderMediaBanner)((e)localObject3).GD(2131302203);
        paramRecyclerView.getGlobalVisibleRect(this.sXx);
        d.g.b.p.g(paramRecyclerView, "banner");
        i = paramRecyclerView.getHeight();
        ae.d("Finder.VideoAutoPlayManager", "check2Play bannerHeight:" + i + " mediaRect:" + this.sXx.height());
        if ((this.sXx.height() < i / 2.5F) || (localBaseFinderFeed.feedObject.getMediaType() != 4)) {
          break label1057;
        }
        U((RecyclerView.w)localObject3);
        a((RecyclerView.w)localObject3, (bvz)localObject1, localBaseFinderFeed.feedObject.getId());
        locala.NiT = true;
        paramRecyclerView = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
        d.g.b.p.g(paramRecyclerView, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
        if (((com.tencent.mm.plugin.thumbplayer.a.a)paramRecyclerView).isOpenTPPlayerBgPrepare())
        {
          localObject1 = null;
          paramRecyclerView = (List)((p.a)localObject2).sXA;
          i = 0;
          paramRecyclerView = paramRecyclerView.iterator();
          label633:
          if (!paramRecyclerView.hasNext()) {
            break label1077;
          }
          if (((p.a)paramRecyclerView.next()).duw != ((p.a)localObject2).duw) {
            break label1065;
          }
          j = 1;
          label665:
          if (j == 0) {
            break label1070;
          }
          label669:
          if (i == -1) {
            break label1136;
          }
          j = i - 1;
          i += 1;
          if ((j < 0) || (j >= ((p.a)localObject2).sXA.size())) {
            break label1131;
          }
          paramRecyclerView = (p.a)((p.a)localObject2).sXA.get(j);
          label711:
          if ((i < 0) || (i >= ((p.a)localObject2).sXA.size())) {
            break label1128;
          }
          localObject1 = (p.a)((p.a)localObject2).sXA.get(i);
        }
      }
    }
    for (;;)
    {
      localObject3 = new StringBuilder("check2Play preFeed:");
      if (paramRecyclerView != null)
      {
        localObject2 = Long.valueOf(paramRecyclerView.duw);
        label766:
        localObject3 = ((StringBuilder)localObject3).append(localObject2).append(" nextFeed:");
        if (paramRecyclerView == null) {
          break label1088;
        }
        localObject2 = Long.valueOf(paramRecyclerView.duw);
        label794:
        ae.d("Finder.VideoAutoPlayManager", localObject2);
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (paramRecyclerView == null) {
          break label1094;
        }
        localObject2 = paramRecyclerView.rVa;
        label824:
        if (paramRecyclerView == null) {
          break label1100;
        }
        localObject3 = paramRecyclerView.rZB;
        label834:
        if (paramRecyclerView == null) {
          break label1106;
        }
        paramRecyclerView = paramRecyclerView.rZB;
        if (paramRecyclerView == null) {
          break label1106;
        }
        paramRecyclerView = paramRecyclerView.feedObject;
        if (paramRecyclerView == null) {
          break label1106;
        }
        paramRecyclerView = paramRecyclerView.getMediaList();
        if (paramRecyclerView == null) {
          break label1106;
        }
        paramRecyclerView = (bvz)j.jm((List)paramRecyclerView);
        label876:
        if ((localObject2 != null) && (localObject3 != null) && (paramRecyclerView != null) && (((BaseFinderFeed)localObject3).feedObject.getMediaType() == 4)) {
          b((RecyclerView.w)localObject2, paramRecyclerView, ((BaseFinderFeed)localObject3).lP());
        }
        paramRecyclerView = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (localObject1 == null) {
          break label1111;
        }
        paramRecyclerView = ((p.a)localObject1).rVa;
        label931:
        if (localObject1 == null) {
          break label1116;
        }
        localObject2 = ((p.a)localObject1).rZB;
        label943:
        if (localObject1 == null) {
          break label1122;
        }
        localObject1 = ((p.a)localObject1).rZB;
        if (localObject1 == null) {
          break label1122;
        }
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if (localObject1 == null) {
          break label1122;
        }
        localObject1 = ((FinderItem)localObject1).getMediaList();
        if (localObject1 == null) {
          break label1122;
        }
      }
      label1057:
      label1065:
      label1070:
      label1077:
      label1088:
      label1094:
      label1100:
      label1106:
      label1111:
      label1116:
      label1122:
      for (localObject1 = (bvz)j.jm((List)localObject1);; localObject1 = null)
      {
        if ((paramRecyclerView != null) && (localObject2 != null) && (localObject1 != null) && (((BaseFinderFeed)localObject2).feedObject.getMediaType() == 4)) {
          b((RecyclerView.w)paramRecyclerView, (bvz)localObject1, ((BaseFinderFeed)localObject2).lP());
        }
        if (!locala.NiT) {
          U(null);
        }
        AppMethodBeat.o(205401);
        return;
        U(null);
        break;
        j = 0;
        break label665;
        i += 1;
        break label633;
        i = -1;
        break label669;
        localObject2 = null;
        break label766;
        localObject2 = null;
        break label794;
        localObject2 = null;
        break label824;
        localObject3 = null;
        break label834;
        paramRecyclerView = null;
        break label876;
        paramRecyclerView = null;
        break label931;
        localObject2 = null;
        break label943;
      }
      label1128:
      continue;
      label1131:
      paramRecyclerView = null;
      break label711;
      label1136:
      paramRecyclerView = null;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(168015);
    d.g.b.p.h(paramb, "ev");
    if ((paramb instanceof h)) {
      this.gpr.post((Runnable)new c(this, paramb));
    }
    AppMethodBeat.o(168015);
  }
  
  public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(168021);
    d.g.b.p.h(paramc, "dispatcher");
    d.g.b.p.h(paramb, "event");
    if ((paramb instanceof h))
    {
      if ((((h)paramb).type == 3) || (((h)paramb).type == 0) || (((h)paramb).type == 8) || (((h)paramb).type == 5))
      {
        AppMethodBeat.o(168021);
        return true;
      }
      AppMethodBeat.o(168021);
      return false;
    }
    AppMethodBeat.o(168021);
    return false;
  }
  
  public final boolean cAA()
  {
    return false;
  }
  
  public final void f(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(205398);
    d.g.b.p.h(paramString, "scene");
    ae.i("Finder.VideoAutoPlayManager", "[lock] scene=" + paramString + " isLock=" + paramBoolean1 + " lockSize=" + this.sZZ.size() + " unLockAfterCheck=" + paramBoolean2);
    if (paramBoolean1)
    {
      this.sZZ.add(paramString);
      this.aIe = true;
    }
    for (;;)
    {
      this.hXp.removeMessages(1);
      if ((!this.aIe) && (paramBoolean2)) {
        this.hXp.sendEmptyMessage(1);
      }
      AppMethodBeat.o(205398);
      return;
      this.sZZ.remove(paramString);
      if (this.sZZ.size() <= 0) {
        this.aIe = false;
      }
    }
  }
  
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168022);
    d.g.b.p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168022);
  }
  
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168027);
    d.g.b.p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168027);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168025);
    d.g.b.p.h(paramLifecycleOwner, "var1");
    this.hXp.removeMessages(1);
    this.hXp.removeMessages(2);
    this.isResume = false;
    AppMethodBeat.o(168025);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(168016);
    super.onRelease();
    this.hXp.removeCallbacksAndMessages(null);
    AppMethodBeat.o(168016);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168024);
    d.g.b.p.h(paramLifecycleOwner, "var1");
    paramLifecycleOwner = com.tencent.mm.ui.component.a.KEX;
    paramLifecycleOwner = com.tencent.mm.ui.component.a.s(this.activity).get(FinderHomeUIC.class);
    d.g.b.p.g(paramLifecycleOwner, "UICProvider.of(activity)…inderHomeUIC::class.java)");
    if ((((FinderHomeUIC)paramLifecycleOwner).cQU() == this.dvm) && (!this.hXp.hasMessages(1))) {
      this.hXp.sendEmptyMessage(1);
    }
    this.isResume = true;
    AppMethodBeat.o(168024);
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168023);
    d.g.b.p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168023);
  }
  
  public final void onStop(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168026);
    d.g.b.p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168026);
  }
  
  public final void setup()
  {
    AppMethodBeat.i(168013);
    Object localObject = this.activity;
    if (localObject != null) {
      a((MMActivity)localObject, (UILifecycleObserver)this);
    }
    localObject = com.tencent.mm.ui.component.a.KEX;
    localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).GQ(this.dvm);
    if (localObject != null) {
      ((c)localObject).a((d)this);
    }
    if (!this.hXp.hasMessages(1)) {
      this.hXp.sendEmptyMessageDelayed(1, 500L);
    }
    AppMethodBeat.o(168013);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements aq.a
  {
    b(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(168011);
      if (paramMessage.what == 1)
      {
        ae.i("Finder.VideoAutoPlayManager", "data change to check play...");
        FinderVideoAutoPlayManager.a(this.tad, this.tad.gpr);
      }
      for (;;)
      {
        AppMethodBeat.o(168011);
        return true;
        if (paramMessage.what == 2)
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new v("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(168011);
            throw paramMessage;
          }
          FinderVideoAutoPlayManager.xJ(((Long)paramMessage).longValue());
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, com.tencent.mm.plugin.finder.event.base.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(205395);
      ae.d("Finder.VideoAutoPlayManager", "ScrollEvent " + ((h)paramb).type);
      FinderVideoAutoPlayManager.a(this.tad, this.tad.gpr);
      AppMethodBeat.o(205395);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<o, Boolean>
  {
    d(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager$playMultiVideoHolder$1$1"})
  static final class e
    implements Runnable
  {
    e(String paramString, FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, p.a parama, int paramInt1, int paramInt2, RecyclerView paramRecyclerView, y.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(205396);
      FinderVideoAutoPlayManager.a(jdField_this).add(this.kAY);
      FinderVideoAutoPlayManager.a(jdField_this, paramRecyclerView);
      AppMethodBeat.o(205396);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, String paramString, RecyclerView paramRecyclerView) {}
    
    public final void run()
    {
      AppMethodBeat.i(205397);
      FinderVideoAutoPlayManager.a(this.tad).add(this.kAY);
      FinderVideoAutoPlayManager.a(this.tad, this.rWI);
      AppMethodBeat.o(205397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager
 * JD-Core Version:    0.7.0.1
 */