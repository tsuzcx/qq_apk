package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.TimeInterpolator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isHasShowSlideLeftTip", "", "()Z", "setHasShowSlideLeftTip", "(Z)V", "isLiveOnTopItem", "setLiveOnTopItem", "isRefreshInterceptor", "setRefreshInterceptor", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "Lkotlin/Lazy;", "tabType", "", "getTabType", "()I", "tipsLayout", "Landroid/view/View;", "getTipsLayout", "()Landroid/view/View;", "tipsLayout$delegate", "clearMachineRedDot", "", "gotoMachine", "hideTips", "insertItemToHot", "objet", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isTipsShow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "refreshSlideLeftTipsLayout", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "report23179", "currentFeedId", "", "recommendFeedId", "setShowCountIncrease", "shouldShowTips", "startPreLoadMedia", "finderObject", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends UIComponent
{
  public static final a GQn;
  public static bwd GQr;
  public static boolean GQs;
  private static long GQt;
  private final j AMt;
  private final j Fdg;
  boolean GQo;
  public boolean GQp;
  public boolean GQq;
  final int hJx;
  
  static
  {
    AppMethodBeat.i(338990);
    GQn = new a((byte)0);
    AppMethodBeat.o(338990);
  }
  
  public ab(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338836);
    this.Fdg = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.AMt = kotlin.k.cm((kotlin.g.a.a)c.GQv);
    this.hJx = 4;
    AppMethodBeat.o(338836);
  }
  
  public ab(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338819);
    this.Fdg = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.AMt = kotlin.k.cm((kotlin.g.a.a)c.GQv);
    this.hJx = 4;
    AppMethodBeat.o(338819);
  }
  
  private final void Q(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(338881);
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    Object localObject2 = ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou();
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(FinderHomeUIC.class);
    s.s(localObject1, "UICProvider.of(activity)…inderHomeUIC::class.java)");
    localObject1 = ((FinderHomeUIC)localObject1).Vi(this.hJx);
    Object localObject3;
    Object localObject4;
    Object localObject5;
    int i;
    if (paramFinderObject != null)
    {
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      localObject3 = kotlin.a.p.listOf(paramFinderObject);
      localObject4 = av.GiL;
      localObject3 = (Iterable)com.tencent.mm.plugin.finder.storage.logic.d.a.a((List)localObject3, av.Ui(this.hJx), (bui)localObject2);
      localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (FinderItem)((Iterator)localObject3).next();
        localObject5 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        ((Collection)localObject2).add(com.tencent.mm.plugin.finder.storage.logic.d.a.a((FinderItem)localObject4));
      }
      localObject2 = new LinkedList((Collection)localObject2);
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.ui.component.k.aeZF;
        localObject3 = ((bd)com.tencent.mm.ui.component.k.y((Fragment)localObject1).q(bd.class)).fpq();
        if (((Collection)localObject2).isEmpty()) {
          break label697;
        }
        i = 1;
        if (i != 0)
        {
          localObject4 = ((LinkedList)localObject2).get(0);
          s.s(localObject4, "rvFeedList[0]");
          localObject4 = (cc)localObject4;
          if (localObject3 != null)
          {
            localObject5 = ((FinderTimelineFeedLoader)localObject3).getDataListJustForAdapter();
            if (localObject5 != null)
            {
              this.GQq = true;
              if (((Collection)localObject5).isEmpty()) {
                break label702;
              }
              i = 1;
              label300:
              if (i == 0) {
                break label707;
              }
              cc localcc = (cc)((DataBuffer)localObject5).get(0);
              if (((cc)localObject4).bZA() != localcc.bZA())
              {
                ((DataBuffer)localObject5).add(0, localObject4);
                ((FinderTimelineFeedLoader)localObject3).dispatcher().onChanged();
                localObject3 = ((FinderTimelineFeedLoader)localObject3).zHB;
                if (localObject3 != null)
                {
                  localObject3 = (RecyclerView)((WeakReference)localObject3).get();
                  if (localObject3 != null)
                  {
                    localObject4 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject4).aYi(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC", "insertItemToHot", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                    ((RecyclerView)localObject3).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject4).sb(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC", "insertItemToHot", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                  }
                }
              }
              label457:
              localObject3 = FinderItem.Companion;
              localObject3 = av.GiL;
              paramFinderObject = FinderItem.a.e(paramFinderObject, av.Ui(this.hJx));
              localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
              paramFinderObject = com.tencent.mm.plugin.finder.storage.logic.d.a.a(paramFinderObject);
              localObject3 = new LinkedList();
              ((LinkedList)localObject3).addAll((Collection)paramFinderObject.feedObject.getMediaList());
              localObject4 = new r(paramFinderObject, kotlin.a.p.J((Collection)localObject3));
              localObject3 = new LinkedList();
              ((LinkedList)localObject3).add(localObject4);
              paramFinderObject.feedObject.setReplaceLongVideoToNormal(true);
              Log.i("FinderFriendsLeftSlideGuideUIC", "startPreLoadMedia");
              localObject4 = (com.tencent.mm.plugin.finder.preload.worker.b)this.AMt.getValue();
              localObject5 = av.GiL;
              i = av.Uc(this.hJx);
              localObject5 = FeedData.Companion;
              ((com.tencent.mm.plugin.finder.preload.worker.b)localObject4).a(i, FeedData.a.n(paramFinderObject.feedObject), kotlin.a.p.J((Collection)localObject3), 0);
              paramFinderObject = com.tencent.mm.ui.component.k.aeZF;
              localObject3 = ((bd)com.tencent.mm.ui.component.k.y((Fragment)localObject1).q(bd.class)).getVideoCore().GpZ;
              if (localObject3 != null)
              {
                paramFinderObject = localObject1.getClass();
                if (paramFinderObject != null) {
                  break label726;
                }
              }
            }
          }
        }
      }
    }
    label697:
    label702:
    label707:
    label726:
    for (paramFinderObject = null;; paramFinderObject = paramFinderObject.getSimpleName())
    {
      FinderVideoAutoPlayManager.a((FinderVideoAutoPlayManager)localObject3, s.X(paramFinderObject, "#onAttach"), false);
      Log.i("FinderFriendsLeftSlideGuideUIC", s.X("insertItemToHot， ", localObject2));
      AppMethodBeat.o(338881);
      return;
      i = 0;
      break;
      i = 0;
      break label300;
      ((DataBuffer)localObject5).add(0, localObject4);
      ((FinderTimelineFeedLoader)localObject3).dispatcher().onChanged();
      break label457;
    }
  }
  
  private static final void a(ab paramab, View paramView)
  {
    AppMethodBeat.i(338927);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramab);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramab, "this$0");
    paramView.setVisibility(8);
    if (paramab.GQq)
    {
      paramView = com.tencent.mm.ui.component.k.aeZF;
      paramView = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(paramab.hJx);
      paramView.a(d.d.GKO);
      paramView.GKz = System.currentTimeMillis();
      paramab.GQq = false;
    }
    paramView = com.tencent.mm.ui.component.k.aeZF;
    paramView = com.tencent.mm.ui.component.k.d(paramab.getActivity()).q(FinderHomeUIC.class);
    s.s(paramView, "UICProvider.of(activity)…inderHomeUIC::class.java)");
    paramView = (FinderHomeUIC)paramView;
    localObject = new Bundle();
    ((Bundle)localObject).putInt("Source", 4);
    paramView.u(paramab.hJx, (Bundle)localObject);
    fnK();
    fnJ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338927);
  }
  
  public static void fnJ()
  {
    AppMethodBeat.i(338898);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adhL, 0);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adhL, Integer.valueOf(i + 1));
    AppMethodBeat.o(338898);
  }
  
  private static void fnK()
  {
    AppMethodBeat.i(338909);
    i locali = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
    locali.hH("finder_tl_hot_tab", "onLeftSlide");
    locali.TL("finder_tl_hot_tab");
    AppMethodBeat.o(338909);
  }
  
  public final View eIW()
  {
    AppMethodBeat.i(339003);
    View localView = (View)this.Fdg.getValue();
    AppMethodBeat.o(339003);
    return localView;
  }
  
  public final boolean fnI()
  {
    AppMethodBeat.i(339059);
    View localView = eIW();
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      AppMethodBeat.o(339059);
      return true;
    }
    AppMethodBeat.o(339059);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(339017);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(getActivity()).q(FinderHomeUIC.class)).GRB.add(new b(this));
    AppMethodBeat.o(339017);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(339009);
    super.onCreateAfter(paramBundle);
    paramBundle = (ViewStub)findViewById(e.e.finder_slide_left_tips_vs);
    if (paramBundle != null) {
      paramBundle.inflate();
    }
    AppMethodBeat.o(339009);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(339023);
    super.onDestroy();
    GQr = null;
    GQs = false;
    View localView = eIW();
    if ((localView != null) && (localView.getVisibility() == 0) && (this.GQo))
    {
      localView.setVisibility(8);
      fnJ();
    }
    AppMethodBeat.o(339023);
  }
  
  public final void t(BaseFinderFeed paramBaseFinderFeed)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    AppMethodBeat.i(339050);
    s.u(paramBaseFinderFeed, "item");
    Object localObject2 = new StringBuilder("refreshSlideLeftTipsLayout， ");
    Object localObject1 = paramBaseFinderFeed.streamDivider;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Integer.valueOf(((bwc)localObject1).aadB))
    {
      Log.i("FinderFriendsLeftSlideGuideUIC", localObject1 + ", " + this.GQo + ", " + this.GQp);
      if (!this.GQo) {
        break;
      }
      AppMethodBeat.o(339050);
      return;
    }
    if (this.GQp)
    {
      this.GQp = false;
      AppMethodBeat.o(339050);
      return;
    }
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    boolean bool;
    int i;
    label271:
    bwc localbwc;
    if (((FinderHomeUIC)com.tencent.mm.ui.component.k.d(getActivity()).q(FinderHomeUIC.class)).fnX() == 1)
    {
      bool = true;
      i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adhL, 0);
      localObject1 = new StringBuilder("shouldShowGuide，");
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      Log.i("FinderFriendsLeftSlideGuideUIC", ((Number)com.tencent.mm.plugin.finder.storage.d.eWL().bmg()).intValue() + ", " + bool + ", " + i);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.eWL().bmg()).intValue() != 1) || (!bool) || (i >= 3)) {
        break label325;
      }
      i = 1;
      if (i == 0) {
        break label875;
      }
      localbwc = paramBaseFinderFeed.streamDivider;
      if (localbwc != null) {
        break label330;
      }
      localObject1 = localObject4;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label868;
      }
      paramBaseFinderFeed = ((ab)this).eIW();
      if (paramBaseFinderFeed != null) {
        paramBaseFinderFeed.setVisibility(8);
      }
      AppMethodBeat.o(339050);
      return;
      bool = false;
      break;
      label325:
      i = 0;
      break label271;
      label330:
      localObject1 = localbwc.aaee;
      long l1;
      if (localObject1 == null)
      {
        l1 = 0L;
        label345:
        if ((localbwc.aadB != 11) || (GQt == l1)) {
          break label845;
        }
        GQr = localbwc.aaee;
        GQt = l1;
        localObject1 = eIW();
        if (localObject1 != null) {
          break label788;
        }
        localObject2 = null;
        label391:
        localObject1 = eIW();
        if (localObject1 != null) {
          break label804;
        }
        localObject1 = null;
        label405:
        Object localObject5 = (CharSequence)localbwc.wording;
        if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
          break label820;
        }
        i = 1;
        label432:
        if ((i == 0) && (localObject2 != null)) {
          ((TextView)localObject2).setText((CharSequence)localbwc.wording);
        }
        localObject2 = FinderItem.Companion;
        localObject2 = localbwc.aaee;
        if (localObject2 != null) {
          break label825;
        }
        localObject2 = null;
        label474:
        s.checkNotNull(localObject2);
        s.s(localObject2, "it.jump_info?.objet!!");
        localObject2 = FinderItem.a.e((FinderObject)localObject2, 512);
        localObject5 = ((FinderItem)localObject2).getMediaList();
        if (((LinkedList)localObject5).size() > 0)
        {
          localObject5 = (dji)kotlin.a.p.oL((List)localObject5);
          if (localObject5 != null)
          {
            localObject5 = new n((dji)localObject5, v.FKZ, null, null, 12);
            Object localObject6 = com.tencent.mm.plugin.finder.loader.p.ExI;
            localObject6 = com.tencent.mm.plugin.finder.loader.p.eCl();
            s.checkNotNull(localObject1);
            com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
            ((com.tencent.mm.loader.d)localObject6).a(localObject5, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
          }
        }
        localObject5 = eIW();
        localObject1 = localObject4;
        if (localObject5 == null) {
          continue;
        }
        ((View)localObject5).setOnClickListener(new ab..ExternalSyntheticLambda0(this));
        if (((View)localObject5).getVisibility() == 8)
        {
          this.GQo = true;
          ((View)localObject5).setVisibility(0);
          ((View)localObject5).setAlpha(0.0F);
          ((View)localObject5).animate().alpha(1.0F).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(300L).start();
          localObject1 = localbwc.aaee;
          if (localObject1 != null) {
            break label835;
          }
        }
      }
      label788:
      label804:
      label820:
      label825:
      label835:
      for (localObject1 = localObject3;; localObject1 = ((bwd)localObject1).aaef)
      {
        Q((FinderObject)localObject1);
        l1 = ((FinderItem)localObject2).getId();
        long l2 = paramBaseFinderFeed.feedObject.getId();
        paramBaseFinderFeed = com.tencent.mm.plugin.report.service.h.OAn;
        localObject1 = z.FrZ;
        localObject1 = z.pL(l1);
        localObject2 = z.FrZ;
        paramBaseFinderFeed.b(23179, new Object[] { localObject1, z.pL(l2) });
        localObject1 = ah.aiuX;
        break;
        localObject1 = ((bwd)localObject1).aaef;
        if (localObject1 == null)
        {
          l1 = 0L;
          break label345;
        }
        l1 = ((FinderObject)localObject1).id;
        break label345;
        localObject2 = (TextView)((View)localObject1).findViewById(e.e.tv_tips_word);
        break label391;
        localObject1 = (ImageView)((View)localObject1).findViewById(e.e.iv_video_img);
        break label405;
        i = 0;
        break label432;
        localObject2 = ((bwd)localObject2).aaef;
        break label474;
      }
      label845:
      paramBaseFinderFeed = eIW();
      if (paramBaseFinderFeed != null) {
        paramBaseFinderFeed.setVisibility(8);
      }
      localObject1 = ah.aiuX;
    }
    label868:
    AppMethodBeat.o(339050);
    return;
    label875:
    paramBaseFinderFeed = eIW();
    if (paramBaseFinderFeed != null) {
      paramBaseFinderFeed.setVisibility(8);
    }
    AppMethodBeat.o(339050);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC$Companion;", "", "()V", "TAG", "", "currentJumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamJumpInfo;", "getCurrentJumpInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamJumpInfo;", "setCurrentJumpInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamJumpInfo;)V", "isInterceptorData", "", "()Z", "setInterceptorData", "(Z)V", "lastId", "", "getLastId", "()J", "setLastId", "(J)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFriendsLeftSlideGuideUIC$onCreate$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.finder.view.h
  {
    b(ab paramab) {}
    
    public final void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(338594);
      Object localObject = ab.a(this.GQu);
      if (localObject != null)
      {
        ab localab = this.GQu;
        if ((((View)localObject).getVisibility() == 0) && (localab.GQo))
        {
          ((View)localObject).setVisibility(8);
          ab.fnN();
          if ((paramInt4 == localab.hJx) && (localab.GQq))
          {
            localObject = com.tencent.mm.ui.component.k.aeZF;
            localObject = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(localab.hJx);
            ((com.tencent.mm.plugin.finder.viewmodel.d.a)localObject).a(d.d.GKO);
            ((com.tencent.mm.plugin.finder.viewmodel.d.a)localObject).GKz = System.currentTimeMillis();
            localab.GQq = false;
            ab.fnO();
          }
        }
      }
      AppMethodBeat.o(338594);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(338579);
      s.u(paramFinderHomeTabFragment, "fragment");
      AppMethodBeat.o(338579);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(338601);
      s.u(this, "this");
      AppMethodBeat.o(338601);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    public static final c GQv;
    
    static
    {
      AppMethodBeat.i(338573);
      GQv = new c();
      AppMethodBeat.o(338573);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(ab paramab)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ab
 * JD-Core Version:    0.7.0.1
 */