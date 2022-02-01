package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.ap.a;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.view.i;
import com.tencent.mm.plugin.finder.viewmodel.b.a;
import com.tencent.mm.plugin.finder.viewmodel.b.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isHasShowSlideLeftTip", "", "()Z", "setHasShowSlideLeftTip", "(Z)V", "isLiveOnTopItem", "setLiveOnTopItem", "isRefreshInterceptor", "setRefreshInterceptor", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "Lkotlin/Lazy;", "tabType", "", "getTabType", "()I", "tipsLayout", "Landroid/view/View;", "getTipsLayout", "()Landroid/view/View;", "tipsLayout$delegate", "gotoMachine", "", "hideTips", "insertItemToHot", "objet", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isTipsShow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "refreshSlideLeftTipsLayout", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "report23179", "currentFeedId", "", "recommendFeedId", "setShowCountIncrease", "shouldShowTips", "startPreLoadMedia", "finderObject", "Companion", "plugin-finder_release"})
public final class x
  extends UIComponent
{
  public static final a BkA;
  public static bjs Bkx;
  public static boolean Bky;
  public static long Bkz;
  public boolean Bku;
  public boolean Bkv;
  public boolean Bkw;
  final int fEH;
  private final kotlin.f xoT;
  private final kotlin.f zQX;
  
  static
  {
    AppMethodBeat.i(272686);
    BkA = new a((byte)0);
    AppMethodBeat.o(272686);
  }
  
  public x(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(272685);
    this.zQX = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.xoT = kotlin.g.ar((kotlin.g.a.a)c.BkC);
    this.fEH = 4;
    AppMethodBeat.o(272685);
  }
  
  public x(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(272684);
    this.zQX = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.xoT = kotlin.g.ar((kotlin.g.a.a)c.BkC);
    this.fEH = 4;
    AppMethodBeat.o(272684);
  }
  
  public static void ab(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272683);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    Object localObject = n.zWF;
    localObject = n.Mp(paramLong1);
    n localn = n.zWF;
    localh.a(23179, new Object[] { localObject, n.Mp(paramLong2) });
    AppMethodBeat.o(272683);
  }
  
  public static void ekE()
  {
    AppMethodBeat.i(272682);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.VEo, 0);
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VEo, Integer.valueOf(i + 1));
    AppMethodBeat.o(272682);
  }
  
  public final void J(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(272680);
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    Object localObject2 = ((aj)com.tencent.mm.ui.component.g.b(getActivity()).i(aj.class)).ekY();
    localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = com.tencent.mm.ui.component.g.b(getActivity()).i(FinderHomeUIC.class);
    p.j(localObject1, "UICProvider.of(activity)…inderHomeUIC::class.java)");
    localObject1 = ((FinderHomeUIC)localObject1).RR(this.fEH);
    if (paramFinderObject != null)
    {
      Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
      localObject3 = j.listOf(paramFinderObject);
      Object localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject3 = (Iterable)c.a.a((List)localObject3, com.tencent.mm.plugin.finder.utils.aj.QY(this.fEH), (bid)localObject2);
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject5;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (FinderItem)((Iterator)localObject3).next();
        localObject5 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        ((Collection)localObject2).add(c.a.a((FinderItem)localObject4));
      }
      localObject2 = new LinkedList((Collection)localObject2);
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.ui.component.g.Xox;
        localObject3 = ((ar)com.tencent.mm.ui.component.g.h((Fragment)localObject1).i(ar.class)).elz();
        int i;
        if (!((Collection)localObject2).isEmpty())
        {
          i = 1;
          if (i != 0)
          {
            localObject4 = ((LinkedList)localObject2).get(0);
            p.j(localObject4, "rvFeedList[0]");
            localObject4 = (bu)localObject4;
            if (localObject3 != null)
            {
              localObject5 = ((FinderTimelineFeedLoader)localObject3).getDataListJustForAdapter();
              if (localObject5 != null)
              {
                this.Bkw = true;
                if (((Collection)localObject5).isEmpty()) {
                  break label760;
                }
                i = 1;
                label302:
                if (i == 0) {
                  break label765;
                }
                bu localbu = (bu)((DataBuffer)localObject5).get(0);
                if (((bu)localObject4).mf() != localbu.mf())
                {
                  ((DataBuffer)localObject5).add(0, localObject4);
                  ((FinderTimelineFeedLoader)localObject3).dispatcher().onChanged();
                  localObject3 = ((FinderTimelineFeedLoader)localObject3).wlv;
                  if (localObject3 != null)
                  {
                    localObject3 = (RecyclerView)((WeakReference)localObject3).get();
                    if (localObject3 != null)
                    {
                      localObject4 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                      com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject4).aFh(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC", "insertItemToHot", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                      ((RecyclerView)localObject3).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject4).sf(0)).intValue());
                      com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC", "insertItemToHot", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                    }
                  }
                }
                label459:
                localObject3 = FinderItem.Companion;
                localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
                paramFinderObject = FinderItem.a.b(paramFinderObject, com.tencent.mm.plugin.finder.utils.aj.QY(this.fEH));
                localObject3 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
                paramFinderObject = c.a.a(paramFinderObject);
                localObject3 = new LinkedList();
                ((LinkedList)localObject3).addAll((Collection)paramFinderObject.feedObject.getMediaList());
                localObject4 = new o(paramFinderObject, j.t((Collection)localObject3));
                localObject3 = new LinkedList();
                ((LinkedList)localObject3).add(localObject4);
                paramFinderObject.feedObject.setReplaceLongVideoToNormal(com.tencent.mm.plugin.finder.utils.aj.a(com.tencent.mm.plugin.finder.utils.aj.AGc, this.fEH, 0, 2));
                Log.i("FinderFriendsLeftSlideGuideUIC", "startPreLoadMedia");
                localObject4 = (com.tencent.mm.plugin.finder.preload.worker.b)this.xoT.getValue();
                localObject5 = com.tencent.mm.plugin.finder.utils.aj.AGc;
                i = com.tencent.mm.plugin.finder.utils.aj.QP(this.fEH);
                localObject5 = FeedData.Companion;
                ((com.tencent.mm.plugin.finder.preload.worker.b)localObject4).a(i, FeedData.a.j(paramFinderObject.feedObject), j.t((Collection)localObject3), 0);
                paramFinderObject = com.tencent.mm.ui.component.g.Xox;
                paramFinderObject = ((ar)com.tencent.mm.ui.component.g.h((Fragment)localObject1).i(ar.class)).xDV;
                if (paramFinderObject == null) {
                  p.bGy("presenter");
                }
                localObject3 = paramFinderObject.getVideoCore().ANA;
                if (localObject3 != null)
                {
                  localObject4 = new StringBuilder();
                  if (localObject1 == null) {
                    break label784;
                  }
                  paramFinderObject = localObject1.getClass();
                  if (paramFinderObject == null) {
                    break label784;
                  }
                }
              }
            }
          }
        }
        label784:
        for (paramFinderObject = paramFinderObject.getSimpleName();; paramFinderObject = null)
        {
          FinderVideoAutoPlayManager.a((FinderVideoAutoPlayManager)localObject3, paramFinderObject + "#onAttach", false);
          Log.i("FinderFriendsLeftSlideGuideUIC", "insertItemToHot， ".concat(String.valueOf(localObject2)));
          AppMethodBeat.o(272680);
          return;
          i = 0;
          break;
          label760:
          i = 0;
          break label302;
          label765:
          ((DataBuffer)localObject5).add(0, localObject4);
          ((FinderTimelineFeedLoader)localObject3).dispatcher().onChanged();
          break label459;
        }
      }
      AppMethodBeat.o(272680);
      return;
    }
    AppMethodBeat.o(272680);
  }
  
  public final View dNu()
  {
    AppMethodBeat.i(272675);
    View localView = (View)this.zQX.getValue();
    AppMethodBeat.o(272675);
    return localView;
  }
  
  public final boolean ekD()
  {
    AppMethodBeat.i(272681);
    View localView = dNu();
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      AppMethodBeat.o(272681);
      return true;
    }
    AppMethodBeat.o(272681);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(272678);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    ((FinderHomeUIC)com.tencent.mm.ui.component.g.b(getActivity()).i(FinderHomeUIC.class)).Bls.add(new b(this));
    AppMethodBeat.o(272678);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(272676);
    super.onCreateAfter(paramBundle);
    paramBundle = (ViewStub)findViewById(b.f.finder_slide_left_tips_vs);
    if (paramBundle != null)
    {
      paramBundle.inflate();
      AppMethodBeat.o(272676);
      return;
    }
    AppMethodBeat.o(272676);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(272679);
    super.onDestroy();
    Bkx = null;
    Bky = false;
    View localView = dNu();
    if (localView != null)
    {
      if ((localView.getVisibility() == 0) && (this.Bku))
      {
        localView.setVisibility(8);
        ekE();
      }
      AppMethodBeat.o(272679);
      return;
    }
    AppMethodBeat.o(272679);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC$Companion;", "", "()V", "TAG", "", "currentJumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamJumpInfo;", "getCurrentJumpInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamJumpInfo;", "setCurrentJumpInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamJumpInfo;)V", "isInterceptorData", "", "()Z", "setInterceptorData", "(Z)V", "lastId", "", "getLastId", "()J", "setLastId", "(J)V", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC$onCreate$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class b
    implements i
  {
    public final void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(279966);
      Object localObject = x.a(this.BkB);
      if (localObject != null)
      {
        if ((((View)localObject).getVisibility() == 0) && (this.BkB.Bku))
        {
          ((View)localObject).setVisibility(8);
          x.ekF();
          if ((paramInt4 == this.BkB.fEH) && (this.BkB.Bkw))
          {
            localObject = com.tencent.mm.ui.component.g.Xox;
            localObject = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RI(this.BkB.fEH);
            ((b.a)localObject).a(b.e.BgQ);
            ((b.a)localObject).BgA = System.currentTimeMillis();
            this.BkB.Bkw = false;
          }
        }
        AppMethodBeat.o(279966);
        return;
      }
      AppMethodBeat.o(279966);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(279965);
      p.k(paramFinderHomeTabFragment, "fragment");
      AppMethodBeat.o(279965);
    }
    
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    public static final c BkC;
    
    static
    {
      AppMethodBeat.i(287954);
      BkC = new c();
      AppMethodBeat.o(287954);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "click", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC$refreshSlideLeftTipsLayout$1$1$1", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC$$special$$inlined$let$lambda$1"})
  public static final class d
    implements View.OnClickListener
  {
    public d(bjr parambjr, FinderItem paramFinderItem, x paramx, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277291);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC$refreshSlideLeftTipsLayout$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      p.j(paramView, "click");
      paramView.setVisibility(8);
      if (this.BkB.Bkw)
      {
        paramView = com.tencent.mm.ui.component.g.Xox;
        paramView = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RI(this.BkB.fEH);
        paramView.a(b.e.BgQ);
        paramView.BgA = System.currentTimeMillis();
        this.BkB.Bkw = false;
      }
      x.b(this.BkB);
      x.ekF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC$refreshSlideLeftTipsLayout$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277291);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<View>
  {
    e(x paramx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.x
 * JD-Core Version:    0.7.0.1
 */