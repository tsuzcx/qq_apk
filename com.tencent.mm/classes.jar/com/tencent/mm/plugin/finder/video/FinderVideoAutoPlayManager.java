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
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.n.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.k;
import d.g.b.v.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "tabType", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;I)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "hasTryMoreAgainSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "isLocked", "", "isResume", "lockKV", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaRect", "Landroid/graphics/Rect;", "mediaViewLocation", "", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "getTabType", "()I", "check2Play", "", "mediaIndex", "playPosition", "getNearbyDistance", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isAsync", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "isUserVisibleFocused", "lock", "scene", "isLock", "unLockAfterCheck", "onCreate", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onEventHappen", "ev", "onPause", "onRelease", "onResume", "onStart", "onStop", "pauseAllVideo", "without", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "playFocusHolder", "focusHolder", "focusMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "playMultiVideoHolder", "playSingleVideoHolder", "prepareHolder", "setup", "Companion", "plugin-finder_release"})
public final class FinderVideoAutoPlayManager
  extends d
  implements UILifecycleObserver
{
  public static final FinderVideoAutoPlayManager.a rSm;
  private boolean aGn;
  private final MMActivity activity;
  private final int diw;
  final RecyclerView fTr;
  private final ao hBR;
  private boolean isResume;
  private final Rect rPL;
  private final int[] rSi;
  private final HashSet<String> rSj;
  private final HashSet<String> rSk;
  private final FinderVideoRecycler rSl;
  
  static
  {
    AppMethodBeat.i(168029);
    rSm = new FinderVideoAutoPlayManager.a((byte)0);
    AppMethodBeat.o(168029);
  }
  
  public FinderVideoAutoPlayManager(MMActivity paramMMActivity, RecyclerView paramRecyclerView, FinderVideoRecycler paramFinderVideoRecycler, int paramInt)
  {
    AppMethodBeat.i(203845);
    this.activity = paramMMActivity;
    this.fTr = paramRecyclerView;
    this.rSl = paramFinderVideoRecycler;
    this.diw = paramInt;
    this.rSi = new int[2];
    this.hBR = new ao(Looper.getMainLooper(), (ao.a)new c(this));
    this.rSj = new HashSet();
    this.rPL = new Rect();
    this.rSk = new HashSet();
    AppMethodBeat.o(203845);
  }
  
  private final void D(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(210203);
    Object localObject1 = paramRecyclerView.getLayoutManager();
    final int i;
    final int j;
    Object localObject2;
    final v.a locala;
    Object localObject3;
    if ((localObject1 instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)localObject1).jW();
      j = ((LinearLayoutManager)localObject1).jY();
      localObject1 = n.rPN;
      localObject2 = n.b(paramRecyclerView, i, j, 8);
      locala = new v.a();
      locala.KUL = false;
      localObject1 = n.rPN;
      localObject3 = ((n.a)localObject2).raq;
      BaseFinderFeed localBaseFinderFeed = ((n.a)localObject2).rdD;
      localObject1 = ((n.a)localObject2).rdD;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if (localObject1 != null)
        {
          localObject1 = ((FinderItem)localObject1).getMediaList();
          if (localObject1 != null) {
            localObject1 = (bqs)j.iP((List)localObject1);
          }
        }
      }
      while ((localObject3 != null) && (localBaseFinderFeed != null) && (localObject1 != null))
      {
        if (((e)localObject3).lu() != ((e)localObject3).lv())
        {
          localObject4 = "[check2Play] holder=" + localObject3 + " centerId=" + ((n.a)localObject2).dig + " first=" + i + " end=" + j + " adapterPosition=" + ((e)localObject3).lv() + " layoutPosition=" + ((e)localObject3).lu() + " isInLayout=" + paramRecyclerView.isInLayout();
          ac.e("Finder.VideoAutoPlayManager", (String)localObject4);
          com.tencent.mm.plugin.report.service.h.wUl.f(20251, new Object[] { Integer.valueOf(1), localObject4 });
          localObject4 = ((e)localObject3).hashCode() + '_' + ((e)localObject3).lv() + '_' + ((e)localObject3).lu() + '_' + ((e)localObject3).lx();
          if (!this.rSk.contains(localObject4))
          {
            paramRecyclerView.post((Runnable)new b((String)localObject4, this, (n.a)localObject2, i, j, paramRecyclerView, locala));
            AppMethodBeat.o(210203);
            return;
            localObject1 = null;
            continue;
          }
        }
        Object localObject4 = a.IrY;
        localObject4 = ((FinderReporterUIC)a.q(this.activity).get(FinderReporterUIC.class)).Ff(this.diw);
        if (localObject4 != null) {
          ((f)localObject4).g(paramRecyclerView, 6);
        }
        paramRecyclerView = (FinderMediaBanner)((e)localObject3).adJ(2131302203);
        paramRecyclerView.getGlobalVisibleRect(this.rPL);
        k.g(paramRecyclerView, "banner");
        i = paramRecyclerView.getHeight();
        ac.d("Finder.VideoAutoPlayManager", "check2Play bannerHeight:" + i + " mediaRect:" + this.rPL.height());
        if ((this.rPL.height() < i / 2.5F) || (localBaseFinderFeed.feedObject.getMediaType() != 4)) {
          break label1022;
        }
        U((RecyclerView.w)localObject3);
        a((RecyclerView.w)localObject3, (bqs)localObject1, localBaseFinderFeed.feedObject.getId());
        locala.KUL = true;
        localObject1 = null;
        paramRecyclerView = (List)((n.a)localObject2).uGK;
        i = 0;
        paramRecyclerView = paramRecyclerView.iterator();
        label598:
        if (!paramRecyclerView.hasNext()) {
          break label1042;
        }
        if (((n.a)paramRecyclerView.next()).dig != ((n.a)localObject2).dig) {
          break label1030;
        }
        j = 1;
        label630:
        if (j == 0) {
          break label1035;
        }
        label634:
        if (i == -1) {
          break label1101;
        }
        j = i - 1;
        i += 1;
        if ((j < 0) || (j >= ((n.a)localObject2).uGK.size())) {
          break label1096;
        }
        paramRecyclerView = (n.a)((n.a)localObject2).uGK.get(j);
        label676:
        if ((i < 0) || (i >= ((n.a)localObject2).uGK.size())) {
          break label1093;
        }
        localObject1 = (n.a)((n.a)localObject2).uGK.get(i);
      }
    }
    for (;;)
    {
      localObject3 = new StringBuilder("check2Play preFeed:");
      if (paramRecyclerView != null)
      {
        localObject2 = Long.valueOf(paramRecyclerView.dig);
        label731:
        localObject3 = ((StringBuilder)localObject3).append(localObject2).append(" nextFeed:");
        if (paramRecyclerView == null) {
          break label1053;
        }
        localObject2 = Long.valueOf(paramRecyclerView.dig);
        label759:
        ac.d("Finder.VideoAutoPlayManager", localObject2);
        localObject2 = n.rPN;
        if (paramRecyclerView == null) {
          break label1059;
        }
        localObject2 = paramRecyclerView.raq;
        label790:
        if (paramRecyclerView == null) {
          break label1065;
        }
        localObject3 = paramRecyclerView.rdD;
        label800:
        if (paramRecyclerView == null) {
          break label1071;
        }
        paramRecyclerView = paramRecyclerView.rdD;
        if (paramRecyclerView == null) {
          break label1071;
        }
        paramRecyclerView = paramRecyclerView.feedObject;
        if (paramRecyclerView == null) {
          break label1071;
        }
        paramRecyclerView = paramRecyclerView.getMediaList();
        if (paramRecyclerView == null) {
          break label1071;
        }
        paramRecyclerView = (bqs)j.iP((List)paramRecyclerView);
        label842:
        if ((localObject2 != null) && (localObject3 != null) && (paramRecyclerView != null) && (((BaseFinderFeed)localObject3).feedObject.getMediaType() == 4)) {
          b((RecyclerView.w)localObject2, paramRecyclerView, ((BaseFinderFeed)localObject3).lx());
        }
        paramRecyclerView = n.rPN;
        if (localObject1 == null) {
          break label1076;
        }
        paramRecyclerView = ((n.a)localObject1).raq;
        label897:
        if (localObject1 == null) {
          break label1081;
        }
        localObject2 = ((n.a)localObject1).rdD;
        label909:
        if (localObject1 == null) {
          break label1087;
        }
        localObject1 = ((n.a)localObject1).rdD;
        if (localObject1 == null) {
          break label1087;
        }
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if (localObject1 == null) {
          break label1087;
        }
        localObject1 = ((FinderItem)localObject1).getMediaList();
        if (localObject1 == null) {
          break label1087;
        }
      }
      label1030:
      label1035:
      label1042:
      label1053:
      label1059:
      label1065:
      label1071:
      label1076:
      label1081:
      label1087:
      for (localObject1 = (bqs)j.iP((List)localObject1);; localObject1 = null)
      {
        if ((paramRecyclerView != null) && (localObject2 != null) && (localObject1 != null) && (((BaseFinderFeed)localObject2).feedObject.getMediaType() == 4)) {
          b((RecyclerView.w)paramRecyclerView, (bqs)localObject1, ((BaseFinderFeed)localObject2).lx());
        }
        if (!locala.KUL) {
          U(null);
        }
        AppMethodBeat.o(210203);
        return;
        label1022:
        U(null);
        break;
        j = 0;
        break label630;
        i += 1;
        break label598;
        i = -1;
        break label634;
        localObject2 = null;
        break label731;
        localObject2 = null;
        break label759;
        localObject2 = null;
        break label790;
        localObject3 = null;
        break label800;
        paramRecyclerView = null;
        break label842;
        paramRecyclerView = null;
        break label897;
        localObject2 = null;
        break label909;
      }
      label1093:
      continue;
      label1096:
      paramRecyclerView = null;
      break label676;
      label1101:
      paramRecyclerView = null;
    }
  }
  
  private final void U(RecyclerView.w paramw)
  {
    AppMethodBeat.i(168020);
    if (paramw != null)
    {
      paramw = paramw.asD;
      if (paramw == null) {}
    }
    for (paramw = (FinderVideoLayout)paramw.findViewById(2131299975);; paramw = null)
    {
      this.rSl.C((d.g.a.b)new e(paramw));
      AppMethodBeat.o(168020);
      return;
    }
  }
  
  private static void a(RecyclerView.w paramw, bqs parambqs, long paramLong)
  {
    AppMethodBeat.i(210204);
    if (paramw != null)
    {
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramw.asD.findViewById(2131299975);
      if (localFinderVideoLayout != null)
      {
        localFinderVideoLayout.play(paramw.lv());
        AppMethodBeat.o(210204);
        return;
      }
      ac.e("Finder.VideoAutoPlayManager", "playFocusHolder videoContainer is null! mediaId=" + parambqs.mediaId + "] feedId=" + paramLong);
    }
    AppMethodBeat.o(210204);
  }
  
  private static void b(RecyclerView.w paramw, bqs parambqs, long paramLong)
  {
    AppMethodBeat.i(210205);
    if (paramw != null)
    {
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramw.asD.findViewById(2131299975);
      if (localFinderVideoLayout != null)
      {
        ac.d("Finder.VideoAutoPlayManager", "prepareToPlay ".concat(String.valueOf(paramLong)));
        paramw.lv();
        localFinderVideoLayout.cMP();
        AppMethodBeat.o(210205);
        return;
      }
      ac.e("Finder.VideoAutoPlayManager", "prepareHolder videoContainer is null! mediaId=" + parambqs.mediaId + "] feedId=" + paramLong);
      AppMethodBeat.o(210205);
      return;
    }
    AppMethodBeat.o(210205);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(168015);
    k.h(paramb, "ev");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) {
      this.fTr.post((Runnable)new d(this, paramb));
    }
    AppMethodBeat.o(168015);
  }
  
  public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(168021);
    k.h(paramc, "dispatcher");
    k.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 3) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 8) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5))
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
  
  public final boolean csW()
  {
    return false;
  }
  
  public final void e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(203842);
    k.h(paramString, "scene");
    ac.i("Finder.VideoAutoPlayManager", "[lock] scene=" + paramString + " isLock=" + paramBoolean1 + " lockSize=" + this.rSj.size() + " unLockAfterCheck=" + paramBoolean2);
    if (paramBoolean1)
    {
      this.rSj.add(paramString);
      this.aGn = true;
    }
    for (;;)
    {
      this.hBR.removeMessages(1);
      if ((!this.aGn) && (paramBoolean2)) {
        this.hBR.sendEmptyMessage(1);
      }
      AppMethodBeat.o(203842);
      return;
      this.rSj.remove(paramString);
      if (this.rSj.size() <= 0) {
        this.aGn = false;
      }
    }
  }
  
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168022);
    k.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168022);
  }
  
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168027);
    k.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168027);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168025);
    k.h(paramLifecycleOwner, "var1");
    this.hBR.removeMessages(1);
    this.isResume = false;
    AppMethodBeat.o(168025);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(168016);
    super.onRelease();
    this.hBR.removeCallbacksAndMessages(null);
    AppMethodBeat.o(168016);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168024);
    k.h(paramLifecycleOwner, "var1");
    paramLifecycleOwner = a.IrY;
    paramLifecycleOwner = a.q(this.activity).get(FinderHomeUIC.class);
    k.g(paramLifecycleOwner, "UICProvider.of(activity)…inderHomeUIC::class.java)");
    if ((((FinderHomeUIC)paramLifecycleOwner).cFV() == this.diw) && (!this.hBR.hasMessages(1))) {
      this.hBR.sendEmptyMessage(1);
    }
    this.isResume = true;
    AppMethodBeat.o(168024);
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168023);
    k.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168023);
  }
  
  public final void onStop(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168026);
    k.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168026);
  }
  
  public final void setup()
  {
    AppMethodBeat.i(168013);
    Object localObject = this.activity;
    if (localObject != null) {
      a((MMActivity)localObject, (UILifecycleObserver)this);
    }
    localObject = a.IrY;
    localObject = ((FinderReporterUIC)a.q(this.activity).get(FinderReporterUIC.class)).Fd(this.diw);
    if (localObject != null) {
      ((c)localObject).a((d)this);
    }
    if (!this.hBR.hasMessages(1)) {
      this.hBR.sendEmptyMessageDelayed(1, 500L);
    }
    AppMethodBeat.o(168013);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager$playMultiVideoHolder$1$1"})
  static final class b
    implements Runnable
  {
    b(String paramString, FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, n.a parama, int paramInt1, int paramInt2, RecyclerView paramRecyclerView, v.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(210201);
      FinderVideoAutoPlayManager.a(jdField_this).add(this.kdj);
      FinderVideoAutoPlayManager.a(jdField_this, paramRecyclerView);
      AppMethodBeat.o(210201);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class c
    implements ao.a
  {
    c(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(168011);
      if (paramMessage.what == 1)
      {
        ac.i("Finder.VideoAutoPlayManager", "data change to check play...");
        FinderVideoAutoPlayManager.a(this.rSn, this.rSn.fTr);
      }
      AppMethodBeat.o(168011);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, com.tencent.mm.plugin.finder.event.base.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(203841);
      ac.d("Finder.VideoAutoPlayManager", "ScrollEvent " + ((com.tencent.mm.plugin.finder.event.base.h)paramb).type);
      FinderVideoAutoPlayManager.a(this.rSn, this.rSn.fTr);
      AppMethodBeat.o(203841);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<o, Boolean>
  {
    e(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager
 * JD-Core Version:    0.7.0.1
 */