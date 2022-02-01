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
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.q;
import d.g.b.y.a;
import d.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "tabType", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;I)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "hasTryMoreAgainSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "isLocked", "", "isResume", "lockKV", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaRect", "Landroid/graphics/Rect;", "mediaViewLocation", "", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "getTabType", "()I", "check2Play", "", "mediaIndex", "playPosition", "getNearbyDistance", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isAsync", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "isUserVisibleFocused", "lock", "scene", "isLock", "unLockAfterCheck", "onCreate", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onEventHappen", "ev", "onPause", "onRelease", "onResume", "onStart", "onStop", "pauseAllVideo", "without", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "playFocusHolder", "focusHolder", "focusMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "playMultiVideoHolder", "playSingleVideoHolder", "prepareHolder", "setup", "Companion", "plugin-finder_release"})
public final class FinderVideoAutoPlayManager
  extends d
  implements UILifecycleObserver
{
  public static final a sOQ;
  private boolean aIe;
  private final MMActivity activity;
  private final int duh;
  final RecyclerView gmV;
  private final ap hUx;
  private boolean isResume;
  private final Rect sMm;
  private final int[] sOM;
  private final HashSet<String> sON;
  private final HashSet<String> sOO;
  private final FinderVideoRecycler sOP;
  
  static
  {
    AppMethodBeat.i(168029);
    sOQ = new a((byte)0);
    AppMethodBeat.o(168029);
  }
  
  public FinderVideoAutoPlayManager(MMActivity paramMMActivity, RecyclerView paramRecyclerView, FinderVideoRecycler paramFinderVideoRecycler, int paramInt)
  {
    AppMethodBeat.i(204782);
    this.activity = paramMMActivity;
    this.gmV = paramRecyclerView;
    this.sOP = paramFinderVideoRecycler;
    this.duh = paramInt;
    this.sOM = new int[2];
    this.hUx = new ap(Looper.getMainLooper(), (ap.a)new b(this));
    this.sON = new HashSet();
    this.sMm = new Rect();
    this.sOO = new HashSet();
    AppMethodBeat.o(204782);
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
      this.sOP.D((d.g.a.b)new d(paramw));
      AppMethodBeat.o(168020);
      return;
    }
  }
  
  private static void a(RecyclerView.w paramw, bvf parambvf, long paramLong)
  {
    AppMethodBeat.i(204780);
    if (paramw != null)
    {
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramw.auu.findViewById(2131299975);
      if (localFinderVideoLayout != null)
      {
        localFinderVideoLayout.play(paramw.lN());
        AppMethodBeat.o(204780);
        return;
      }
      ad.e("Finder.VideoAutoPlayManager", "playFocusHolder videoContainer is null! mediaId=" + parambvf.mediaId + "] feedId=" + paramLong);
    }
    AppMethodBeat.o(204780);
  }
  
  private static void b(RecyclerView.w paramw, bvf parambvf, long paramLong)
  {
    AppMethodBeat.i(204781);
    if (paramw != null)
    {
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramw.auu.findViewById(2131299975);
      if (localFinderVideoLayout != null)
      {
        ad.d("Finder.VideoAutoPlayManager", "prepareToPlay ".concat(String.valueOf(paramLong)));
        paramw.lN();
        localFinderVideoLayout.cMt();
        AppMethodBeat.o(204781);
        return;
      }
      ad.e("Finder.VideoAutoPlayManager", "prepareHolder videoContainer is null! mediaId=" + parambvf.mediaId + "] feedId=" + paramLong);
      AppMethodBeat.o(204781);
      return;
    }
    AppMethodBeat.o(204781);
  }
  
  private final void y(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(204779);
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
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.b(paramRecyclerView, i, j, 8);
      locala = new y.a();
      locala.MLQ = false;
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject3 = ((p.a)localObject2).rMM;
      BaseFinderFeed localBaseFinderFeed = ((p.a)localObject2).rQZ;
      localObject1 = ((p.a)localObject2).rQZ;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if (localObject1 != null)
        {
          localObject1 = ((FinderItem)localObject1).getMediaList();
          if (localObject1 != null) {
            localObject1 = (bvf)j.jd((List)localObject1);
          }
        }
      }
      while ((localObject3 != null) && (localBaseFinderFeed != null) && (localObject1 != null))
      {
        if (((e)localObject3).lM() != ((e)localObject3).lN())
        {
          localObject4 = "[check2Play] holder=" + localObject3 + " centerId=" + ((p.a)localObject2).dtq + " first=" + i + " end=" + j + " adapterPosition=" + ((e)localObject3).lN() + " layoutPosition=" + ((e)localObject3).lM() + " isInLayout=" + paramRecyclerView.isInLayout();
          ad.e("Finder.VideoAutoPlayManager", (String)localObject4);
          com.tencent.mm.plugin.report.service.g.yhR.f(20251, new Object[] { Integer.valueOf(1), localObject4 });
          localObject4 = ((e)localObject3).hashCode() + '_' + ((e)localObject3).lN() + '_' + ((e)localObject3).lM() + '_' + ((e)localObject3).lP();
          if (!this.sOO.contains(localObject4))
          {
            paramRecyclerView.post((Runnable)new e((String)localObject4, this, (p.a)localObject2, i, j, paramRecyclerView, locala));
            AppMethodBeat.o(204779);
            return;
            localObject1 = null;
            continue;
          }
        }
        Object localObject4 = com.tencent.mm.ui.component.a.KiD;
        localObject4 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).Gv(this.duh);
        if (localObject4 != null) {
          ((f)localObject4).g(paramRecyclerView, 6);
        }
        paramRecyclerView = (FinderMediaBanner)((e)localObject3).Gd(2131302203);
        paramRecyclerView.getGlobalVisibleRect(this.sMm);
        d.g.b.p.g(paramRecyclerView, "banner");
        i = paramRecyclerView.getHeight();
        ad.d("Finder.VideoAutoPlayManager", "check2Play bannerHeight:" + i + " mediaRect:" + this.sMm.height());
        if ((this.sMm.height() < i / 2.5F) || (localBaseFinderFeed.feedObject.getMediaType() != 4)) {
          break label1048;
        }
        U((RecyclerView.w)localObject3);
        a((RecyclerView.w)localObject3, (bvf)localObject1, localBaseFinderFeed.feedObject.getId());
        locala.MLQ = true;
        paramRecyclerView = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
        d.g.b.p.g(paramRecyclerView, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
        if (((com.tencent.mm.plugin.thumbplayer.a.a)paramRecyclerView).isOpenTPPlayerBgPrepare())
        {
          localObject1 = null;
          paramRecyclerView = (List)((p.a)localObject2).sMp;
          i = 0;
          paramRecyclerView = paramRecyclerView.iterator();
          label624:
          if (!paramRecyclerView.hasNext()) {
            break label1068;
          }
          if (((p.a)paramRecyclerView.next()).dtq != ((p.a)localObject2).dtq) {
            break label1056;
          }
          j = 1;
          label656:
          if (j == 0) {
            break label1061;
          }
          label660:
          if (i == -1) {
            break label1127;
          }
          j = i - 1;
          i += 1;
          if ((j < 0) || (j >= ((p.a)localObject2).sMp.size())) {
            break label1122;
          }
          paramRecyclerView = (p.a)((p.a)localObject2).sMp.get(j);
          label702:
          if ((i < 0) || (i >= ((p.a)localObject2).sMp.size())) {
            break label1119;
          }
          localObject1 = (p.a)((p.a)localObject2).sMp.get(i);
        }
      }
    }
    for (;;)
    {
      localObject3 = new StringBuilder("check2Play preFeed:");
      if (paramRecyclerView != null)
      {
        localObject2 = Long.valueOf(paramRecyclerView.dtq);
        label757:
        localObject3 = ((StringBuilder)localObject3).append(localObject2).append(" nextFeed:");
        if (paramRecyclerView == null) {
          break label1079;
        }
        localObject2 = Long.valueOf(paramRecyclerView.dtq);
        label785:
        ad.d("Finder.VideoAutoPlayManager", localObject2);
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (paramRecyclerView == null) {
          break label1085;
        }
        localObject2 = paramRecyclerView.rMM;
        label815:
        if (paramRecyclerView == null) {
          break label1091;
        }
        localObject3 = paramRecyclerView.rQZ;
        label825:
        if (paramRecyclerView == null) {
          break label1097;
        }
        paramRecyclerView = paramRecyclerView.rQZ;
        if (paramRecyclerView == null) {
          break label1097;
        }
        paramRecyclerView = paramRecyclerView.feedObject;
        if (paramRecyclerView == null) {
          break label1097;
        }
        paramRecyclerView = paramRecyclerView.getMediaList();
        if (paramRecyclerView == null) {
          break label1097;
        }
        paramRecyclerView = (bvf)j.jd((List)paramRecyclerView);
        label867:
        if ((localObject2 != null) && (localObject3 != null) && (paramRecyclerView != null) && (((BaseFinderFeed)localObject3).feedObject.getMediaType() == 4)) {
          b((RecyclerView.w)localObject2, paramRecyclerView, ((BaseFinderFeed)localObject3).lP());
        }
        paramRecyclerView = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (localObject1 == null) {
          break label1102;
        }
        paramRecyclerView = ((p.a)localObject1).rMM;
        label922:
        if (localObject1 == null) {
          break label1107;
        }
        localObject2 = ((p.a)localObject1).rQZ;
        label934:
        if (localObject1 == null) {
          break label1113;
        }
        localObject1 = ((p.a)localObject1).rQZ;
        if (localObject1 == null) {
          break label1113;
        }
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if (localObject1 == null) {
          break label1113;
        }
        localObject1 = ((FinderItem)localObject1).getMediaList();
        if (localObject1 == null) {
          break label1113;
        }
      }
      label1048:
      label1056:
      label1061:
      label1068:
      label1079:
      label1085:
      label1091:
      label1097:
      label1102:
      label1107:
      label1113:
      for (localObject1 = (bvf)j.jd((List)localObject1);; localObject1 = null)
      {
        if ((paramRecyclerView != null) && (localObject2 != null) && (localObject1 != null) && (((BaseFinderFeed)localObject2).feedObject.getMediaType() == 4)) {
          b((RecyclerView.w)paramRecyclerView, (bvf)localObject1, ((BaseFinderFeed)localObject2).lP());
        }
        if (!locala.MLQ) {
          U(null);
        }
        AppMethodBeat.o(204779);
        return;
        U(null);
        break;
        j = 0;
        break label656;
        i += 1;
        break label624;
        i = -1;
        break label660;
        localObject2 = null;
        break label757;
        localObject2 = null;
        break label785;
        localObject2 = null;
        break label815;
        localObject3 = null;
        break label825;
        paramRecyclerView = null;
        break label867;
        paramRecyclerView = null;
        break label922;
        localObject2 = null;
        break label934;
      }
      label1119:
      continue;
      label1122:
      paramRecyclerView = null;
      break label702;
      label1127:
      paramRecyclerView = null;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(168015);
    d.g.b.p.h(paramb, "ev");
    if ((paramb instanceof h)) {
      this.gmV.post((Runnable)new c(this, paramb));
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
  
  public final boolean cyW()
  {
    return false;
  }
  
  public final void f(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(204776);
    d.g.b.p.h(paramString, "scene");
    ad.i("Finder.VideoAutoPlayManager", "[lock] scene=" + paramString + " isLock=" + paramBoolean1 + " lockSize=" + this.sON.size() + " unLockAfterCheck=" + paramBoolean2);
    if (paramBoolean1)
    {
      this.sON.add(paramString);
      this.aIe = true;
    }
    for (;;)
    {
      this.hUx.removeMessages(1);
      if ((!this.aIe) && (paramBoolean2)) {
        this.hUx.sendEmptyMessage(1);
      }
      AppMethodBeat.o(204776);
      return;
      this.sON.remove(paramString);
      if (this.sON.size() <= 0) {
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
    this.hUx.removeMessages(1);
    this.isResume = false;
    AppMethodBeat.o(168025);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(168016);
    super.onRelease();
    this.hUx.removeCallbacksAndMessages(null);
    AppMethodBeat.o(168016);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168024);
    d.g.b.p.h(paramLifecycleOwner, "var1");
    paramLifecycleOwner = com.tencent.mm.ui.component.a.KiD;
    paramLifecycleOwner = com.tencent.mm.ui.component.a.s(this.activity).get(FinderHomeUIC.class);
    d.g.b.p.g(paramLifecycleOwner, "UICProvider.of(activity)…inderHomeUIC::class.java)");
    if ((((FinderHomeUIC)paramLifecycleOwner).cOp() == this.duh) && (!this.hUx.hasMessages(1))) {
      this.hUx.sendEmptyMessage(1);
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
    localObject = com.tencent.mm.ui.component.a.KiD;
    localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).Gt(this.duh);
    if (localObject != null) {
      ((c)localObject).a((d)this);
    }
    if (!this.hUx.hasMessages(1)) {
      this.hUx.sendEmptyMessageDelayed(1, 500L);
    }
    AppMethodBeat.o(168013);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager$Companion;", "", "()V", "BASE_LINE", "", "DELAY_CHECK_TIME", "", "TAG", "", "WHAT_CHECK_PLAY", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements ap.a
  {
    b(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(168011);
      if (paramMessage.what == 1)
      {
        ad.i("Finder.VideoAutoPlayManager", "data change to check play...");
        FinderVideoAutoPlayManager.a(this.sOR, this.sOR.gmV);
      }
      AppMethodBeat.o(168011);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, com.tencent.mm.plugin.finder.event.base.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(204773);
      ad.d("Finder.VideoAutoPlayManager", "ScrollEvent " + ((h)paramb).type);
      FinderVideoAutoPlayManager.a(this.sOR, this.sOR.gmV);
      AppMethodBeat.o(204773);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<o, Boolean>
  {
    d(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager$playMultiVideoHolder$1$1"})
  static final class e
    implements Runnable
  {
    e(String paramString, FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, p.a parama, int paramInt1, int paramInt2, RecyclerView paramRecyclerView, y.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(204774);
      FinderVideoAutoPlayManager.a(jdField_this).add(this.kxJ);
      FinderVideoAutoPlayManager.a(jdField_this, paramRecyclerView);
      AppMethodBeat.o(204774);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, String paramString, RecyclerView paramRecyclerView) {}
    
    public final void run()
    {
      AppMethodBeat.i(204775);
      FinderVideoAutoPlayManager.a(this.sOR).add(this.kxJ);
      FinderVideoAutoPlayManager.a(this.sOR, this.rOk);
      AppMethodBeat.o(204775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager
 * JD-Core Version:    0.7.0.1
 */