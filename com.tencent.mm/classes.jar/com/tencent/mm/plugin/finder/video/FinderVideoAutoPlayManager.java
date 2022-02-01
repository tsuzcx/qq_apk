package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProvider;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.i.b;
import com.tencent.mm.plugin.finder.report.j.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.i.e;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashSet;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "tabType", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;I)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "isLocked", "", "isResume", "lockKV", "Ljava/util/HashSet;", "", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaRect", "Landroid/graphics/Rect;", "mediaViewLocation", "", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "getTabType", "()I", "check2Play", "", "mediaIndex", "playPosition", "getNearbyDistance", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isAsync", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "lock", "scene", "isLock", "unLockAfterCheck", "onCreate", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onEventHappen", "ev", "onPause", "onRelease", "onResume", "onStart", "onStop", "pauseAllVideo", "without", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "playFocusHolder", "focusHolder", "focusMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaList", "Ljava/util/LinkedList;", "feedId", "", "nonceId", "setup", "Companion", "plugin-finder_release"})
public final class FinderVideoAutoPlayManager
  extends f
  implements UILifecycleObserver
{
  public static final a qTD;
  private final int IoU;
  private final HashSet<String> Lcr;
  private final FinderVideoRecycler Lcs;
  private boolean aFx;
  private final MMActivity activity;
  final RecyclerView fPw;
  private final ap hbq;
  private boolean isResume;
  private final Rect qSZ;
  private final int[] qTB;
  
  static
  {
    AppMethodBeat.i(168029);
    qTD = new a((byte)0);
    AppMethodBeat.o(168029);
  }
  
  public FinderVideoAutoPlayManager(MMActivity paramMMActivity, RecyclerView paramRecyclerView, FinderVideoRecycler paramFinderVideoRecycler, int paramInt)
  {
    AppMethodBeat.i(199781);
    this.activity = paramMMActivity;
    this.fPw = paramRecyclerView;
    this.Lcs = paramFinderVideoRecycler;
    this.IoU = paramInt;
    this.qTB = new int[2];
    this.hbq = new ap(Looper.getMainLooper(), (ap.a)new b(this));
    this.Lcr = new HashSet();
    this.qSZ = new Rect();
    AppMethodBeat.o(199781);
  }
  
  private final void U(RecyclerView.v paramv)
  {
    AppMethodBeat.i(168020);
    if (paramv != null)
    {
      paramv = paramv.arI;
      if (paramv == null) {}
    }
    for (paramv = (FinderVideoLayout)paramv.findViewById(2131299975);; paramv = null)
    {
      this.Lcs.J((b)new c(paramv));
      AppMethodBeat.o(168020);
      return;
    }
  }
  
  private static void a(RecyclerView.v paramv, bmd parambmd, long paramLong)
  {
    AppMethodBeat.i(168019);
    if (paramv != null)
    {
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramv.arI.findViewById(2131299975);
      if (localFinderVideoLayout != null)
      {
        localFinderVideoLayout.play(paramv.ln());
        AppMethodBeat.o(168019);
        return;
      }
      ad.e("Finder.VideoAutoPlayManager", "videoContainer is null! mediaId=" + parambmd.mediaId + "] feedId=" + paramLong);
    }
    AppMethodBeat.o(168019);
  }
  
  private final void k(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168017);
    this.hbq.removeMessages(1);
    if (!this.isResume)
    {
      ad.w("Finder.VideoAutoPlayManager", "activity is not resume");
      AppMethodBeat.o(168017);
      return;
    }
    if (this.aFx)
    {
      ad.w("Finder.VideoAutoPlayManager", "isLocked=" + this.aFx + " lockKV=" + this.Lcr);
      AppMethodBeat.o(168017);
      return;
    }
    Object localObject1;
    if (paramInt2 != -1)
    {
      localObject1 = paramRecyclerView.cj(paramInt2);
      if (!(localObject1 instanceof com.tencent.mm.view.recyclerview.e)) {
        break label303;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.e)localObject1;
    }
    BaseFinderFeed localBaseFinderFeed;
    Object localObject2;
    long l;
    while (localObject1 != null)
    {
      localBaseFinderFeed = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.e)localObject1).fjf();
      localObject2 = localBaseFinderFeed.feedObject.getMediaList();
      if (paramInt1 >= ((LinkedList)localObject2).size())
      {
        ad.w("Finder.VideoAutoPlayManager", "mediaIndex=" + paramInt1 + " >= " + ((LinkedList)localObject2).size());
        AppMethodBeat.o(168017);
        return;
        localObject1 = paramRecyclerView.getLayoutManager();
        if ((localObject1 instanceof LinearLayoutManager))
        {
          paramInt2 = ((LinearLayoutManager)localObject1).jO();
          int i = ((LinearLayoutManager)localObject1).jQ();
          localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
          l = com.tencent.mm.plugin.finder.utils.i.j(paramRecyclerView, paramInt2, i).feedId;
          localObject1 = paramRecyclerView.getAdapter();
          if ((localObject1 instanceof com.tencent.mm.view.recyclerview.d))
          {
            localObject1 = ((com.tencent.mm.view.recyclerview.d)localObject1).L(l, true);
            if ((localObject1 instanceof com.tencent.mm.view.recyclerview.e))
            {
              localObject1 = (com.tencent.mm.view.recyclerview.e)localObject1;
              continue;
            }
            ad.e("Finder.VideoAutoPlayManager", "[check2Play] holder=".concat(String.valueOf(localObject1)));
          }
        }
        label303:
        localObject1 = null;
      }
      else
      {
        Object localObject3 = com.tencent.mm.ui.component.a.LCX;
        localObject3 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).ahX(this.IoU);
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.finder.event.base.e)localObject3).g(paramRecyclerView, 6);
        }
        paramRecyclerView = (FinderMediaBanner)((com.tencent.mm.view.recyclerview.e)localObject1).abq(2131302203);
        paramRecyclerView.getGlobalVisibleRect(this.qSZ);
        k.g(paramRecyclerView, "banner");
        paramInt1 = paramRecyclerView.getHeight();
        if ((this.qSZ.height() < paramInt1 / 2.5F) || (localBaseFinderFeed.feedObject.getMediaType() != 4)) {
          break label508;
        }
        paramRecyclerView = (bmd)((LinkedList)localObject2).getFirst();
        U((RecyclerView.v)localObject1);
        localObject2 = (RecyclerView.v)localObject1;
        k.g(paramRecyclerView, "first");
        l = localBaseFinderFeed.feedObject.getId();
        localBaseFinderFeed.feedObject.getObjectNonceId();
        a((RecyclerView.v)localObject2, paramRecyclerView, l);
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        paramRecyclerView = (FinderVideoAutoPlayManager)this;
        ad.e("Finder.VideoAutoPlayManager", "focusHolder is null");
        paramRecyclerView.U(null);
        paramRecyclerView = y.JfV;
      }
      AppMethodBeat.o(168017);
      return;
      label508:
      if ((this.qSZ.height() >= paramInt1 / 2.5F) && (localBaseFinderFeed.feedObject.getMediaType() == 8))
      {
        localObject2 = ((LinkedList)localObject2).get(paramRecyclerView.getFocusPosition());
        k.g(localObject2, "mediaList[banner.focusPosition]");
        localObject2 = (bmd)localObject2;
        if (((bmd)localObject2).mediaType == 4)
        {
          paramRecyclerView = paramRecyclerView.getPagerView().cj(paramRecyclerView.getFocusPosition());
          U(paramRecyclerView);
          l = localBaseFinderFeed.feedObject.getId();
          localBaseFinderFeed.feedObject.getObjectNonceId();
          a(paramRecyclerView, (bmd)localObject2, l);
        }
        else
        {
          U(null);
        }
      }
      else
      {
        U(null);
      }
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(168015);
    k.h(paramc, "ev");
    if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.i))
    {
      a(this, this.fPw, 0, 0, 6);
      AppMethodBeat.o(168015);
      return;
    }
    if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.a))
    {
      if (((com.tencent.mm.plugin.finder.event.base.a)paramc).ahc == null)
      {
        this.hbq.removeMessages(1);
        this.hbq.sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(168015);
      }
    }
    else
    {
      if ((paramc instanceof i.b))
      {
        a(this, this.fPw, ((i.b)paramc).index, 0, 4);
        ad.i("Finder.VideoAutoPlayManager", "[PageChangeEvent] ".concat(String.valueOf(paramc)));
        AppMethodBeat.o(168015);
        return;
      }
      if ((paramc instanceof j.a))
      {
        k(this.fPw, 0, ((j.a)paramc).qvB);
        ad.i("Finder.VideoAutoPlayManager", "[PlayEvent] ".concat(String.valueOf(paramc)));
      }
    }
    AppMethodBeat.o(168015);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.d paramd, c paramc)
  {
    AppMethodBeat.i(168021);
    k.h(paramd, "dispatcher");
    k.h(paramc, "event");
    if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.i))
    {
      if ((((com.tencent.mm.plugin.finder.event.base.i)paramc).type == 3) || (((com.tencent.mm.plugin.finder.event.base.i)paramc).type == 0))
      {
        AppMethodBeat.o(168021);
        return true;
      }
      AppMethodBeat.o(168021);
      return false;
    }
    if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.a))
    {
      AppMethodBeat.o(168021);
      return true;
    }
    if ((paramc instanceof i.b))
    {
      AppMethodBeat.o(168021);
      return true;
    }
    if ((paramc instanceof j.a))
    {
      AppMethodBeat.o(168021);
      return true;
    }
    AppMethodBeat.o(168021);
    return false;
  }
  
  public final boolean clc()
  {
    return false;
  }
  
  public final void m(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(199779);
    k.h(paramString, "scene");
    ad.i("Finder.VideoAutoPlayManager", "scene=" + paramString + " isLock=" + paramBoolean1 + " unLockAfterCheck=" + paramBoolean2);
    if (paramBoolean1)
    {
      this.Lcr.add(paramString);
      this.aFx = true;
    }
    for (;;)
    {
      this.hbq.removeMessages(1);
      if ((!this.aFx) && (paramBoolean2)) {
        this.hbq.sendEmptyMessage(1);
      }
      AppMethodBeat.o(199779);
      return;
      this.Lcr.remove(paramString);
      if (this.Lcr.size() <= 0) {
        this.aFx = false;
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
    this.hbq.removeMessages(1);
    this.isResume = false;
    AppMethodBeat.o(168025);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(168016);
    super.onRelease();
    this.hbq.removeCallbacksAndMessages(null);
    AppMethodBeat.o(168016);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168024);
    k.h(paramLifecycleOwner, "var1");
    if (!this.hbq.hasMessages(1)) {
      this.hbq.sendEmptyMessage(1);
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
    localObject = com.tencent.mm.ui.component.a.LCX;
    localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).ahW(this.IoU);
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.event.base.d)localObject).a((f)this);
    }
    if (!this.hbq.hasMessages(1)) {
      this.hbq.sendEmptyMessageDelayed(1, 500L);
    }
    AppMethodBeat.o(168013);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager$Companion;", "", "()V", "BASE_LINE", "", "DELAY_CHECK_TIME", "", "TAG", "", "WHAT_CHECK_PLAY", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
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
        FinderVideoAutoPlayManager.a(this.qTE, this.qTE.fPw, 0, 0, 6);
      }
      AppMethodBeat.o(168011);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<o, Boolean>
  {
    c(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager
 * JD-Core Version:    0.7.0.1
 */