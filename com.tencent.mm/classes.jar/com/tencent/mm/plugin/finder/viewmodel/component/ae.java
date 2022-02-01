package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.a.a;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.HorizontalVideoPreviewLayout;
import com.tencent.mm.plugin.finder.view.HorizontalVideoSeekBarLayout;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.thumbplayer.render.MMSurfaceViewRender;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "currHorizontalHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "currOrientation", "", "currVideoView", "Landroid/view/View;", "eventFocusHolder", "horizontalPos", "indexOriginalParent", "isFirstDrag", "", "isResumed", "isRvIdle", "notRecreateWhenOrientationChange", "observer", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "orientationEventListener", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "orientationLayout", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC$HDRHorizontalVideoPreviewLayout;", "getOrientationLayout", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC$HDRHorizontalVideoPreviewLayout;", "orientationLayout$delegate", "Lkotlin/Lazy;", "originalParams", "Landroid/view/ViewGroup$LayoutParams;", "originalParent", "Landroid/view/ViewGroup;", "attachOrientationLayer", "", "isDetach", "checkCanLandscape", "enterLandScape", "exitLandScape", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "resetToPortrait", "Companion", "HDRHorizontalVideoPreviewLayout", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends UIComponent
{
  public static final ae.a GQD;
  private final kotlin.j GQE;
  private ViewGroup GQF;
  private int GQG;
  private ViewGroup.LayoutParams GQH;
  private View GQI;
  private com.tencent.mm.view.recyclerview.j GQJ;
  private com.tencent.mm.view.recyclerview.j GQK;
  private int GQL;
  private int GQM;
  private boolean GQN;
  private boolean GQO;
  private boolean GQP;
  private final com.tencent.mm.bj.a GQQ;
  private final d GQR;
  private boolean cqi;
  
  static
  {
    AppMethodBeat.i(339074);
    GQD = new ae.a((byte)0);
    AppMethodBeat.o(339074);
  }
  
  public ae(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338801);
    this.GQE = kotlin.k.cm((kotlin.g.a.a)new d(this, paramAppCompatActivity));
    this.GQG = -1;
    this.GQL = 1;
    this.GQM = -1;
    this.GQQ = new com.tencent.mm.bj.a((Context)paramAppCompatActivity, new ae..ExternalSyntheticLambda0(this, paramAppCompatActivity));
    this.GQR = ((d)new c(this, paramAppCompatActivity));
    AppMethodBeat.o(338801);
  }
  
  private static final void a(int paramInt, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(338928);
    s.u(paramRecyclerView, "$it");
    if (paramInt > 0)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC", "resetToPortrait$lambda-18$lambda-16", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "Undefined", "scrollToPosition", "(I)V");
      paramRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC", "resetToPortrait$lambda-18$lambda-16", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "Undefined", "scrollToPosition", "(I)V");
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (!(paramRecyclerView instanceof WxRecyclerAdapter)) {
        break label137;
      }
    }
    label137:
    for (paramRecyclerView = (WxRecyclerAdapter)paramRecyclerView;; paramRecyclerView = null)
    {
      if ((paramRecyclerView != null) && (paramRecyclerView.getItemCount() > 0)) {
        paramRecyclerView.e(0, paramRecyclerView.getItemCount(), new kotlin.r(Integer.valueOf(30), Integer.valueOf(1)));
      }
      AppMethodBeat.o(338928);
      return;
    }
  }
  
  private static final void a(ae paramae)
  {
    AppMethodBeat.i(338912);
    s.u(paramae, "this$0");
    paramae = paramae.GQF;
    if (paramae != null) {
      paramae.requestLayout();
    }
    AppMethodBeat.o(338912);
  }
  
  private static final void a(ae paramae, AppCompatActivity paramAppCompatActivity, a.a parama1, a.a parama2)
  {
    boolean bool3 = false;
    int i = 1;
    AppMethodBeat.i(338900);
    s.u(paramae, "this$0");
    s.u(paramAppCompatActivity, "$activity");
    if (!paramae.isUserVisibleFocused())
    {
      AppMethodBeat.o(338900);
      return;
    }
    boolean bool1;
    if ((paramae.cqi) && (parama1 != parama2))
    {
      parama1 = com.tencent.mm.ui.component.k.aeZF;
      parama1 = ((i)com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(i.class)).ATy;
      if ((parama1 == null) || (parama1.fkp() != true)) {
        break label264;
      }
      bool1 = true;
      parama1 = com.tencent.mm.ui.component.k.aeZF;
      paramAppCompatActivity = ((r)com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(r.class)).fny();
      if (paramAppCompatActivity != null) {
        break label270;
      }
    }
    label264:
    label270:
    for (boolean bool2 = false;; bool2 = paramAppCompatActivity.fkp())
    {
      paramAppCompatActivity = new StringBuilder("[onConfigurationChanged] isDrawerOpen=").append(bool1).append(" isLikeDrawerOpen=").append(bool2).append(" newOrientation=").append(parama2).append(", isLandscapeVideo = ");
      if (paramae.GQJ != null) {
        bool3 = true;
      }
      Log.i("FinderVideoOrientationUIC", bool3);
      if ((!bool1) && (!bool2) && ((parama2 == a.a.pvT) || (parama2 == a.a.pvV)))
      {
        if ((paramae.GQJ == null) && (paramae.GQP)) {
          paramae.fnQ();
        }
        if (paramae.GQJ != null) {
          i = -1;
        }
        if (i != paramae.getContext().getRequestedOrientation()) {
          paramae.getContext().setRequestedOrientation(i);
        }
      }
      AppMethodBeat.o(338900);
      return;
      bool1 = false;
      break;
    }
  }
  
  private final b fnP()
  {
    AppMethodBeat.i(338813);
    b localb = (b)this.GQE.getValue();
    AppMethodBeat.o(338813);
    return localb;
  }
  
  private final boolean fnQ()
  {
    boolean bool2 = false;
    Object localObject4 = null;
    AppMethodBeat.i(338849);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
    if (com.tencent.mm.plugin.finder.utils.av.fgj())
    {
      AppMethodBeat.o(338849);
      return false;
    }
    if ((getActivity() instanceof FinderHomeUI))
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(getActivity()).q(FinderHomeUIC.class)).getActiveFragment().getView();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label160;
        }
      }
    }
    label160:
    for (Object localObject2 = null;; localObject2 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView())
    {
      if (localObject2 != null) {
        break label170;
      }
      localObject1 = (ae)this;
      Log.e("FinderVideoOrientationUIC", "checkCanLandscape, recyclerView is null");
      ((ae)localObject1).GQJ = null;
      ((ae)localObject1).getContext().setRequestedOrientation(1);
      AppMethodBeat.o(338849);
      return false;
      localObject1 = (RefreshLoadMoreLayout)((View)localObject1).findViewById(e.e.rl_layout);
      break;
      localObject1 = (RefreshLoadMoreLayout)findViewById(e.e.rl_layout);
      break;
    }
    label170:
    Object localObject5 = new Rect();
    int n = ((RecyclerView)localObject2).getChildCount();
    int k;
    int i;
    Object localObject3;
    int m;
    int j;
    if (n > 0)
    {
      k = 0;
      i = 0;
      localObject3 = null;
      m = k + 1;
      View localView = ((RecyclerView)localObject2).getChildAt(k);
      j = i;
      localObject1 = localObject3;
      if (localView.getGlobalVisibleRect((Rect)localObject5))
      {
        j = i;
        localObject1 = localObject3;
        if (i < ((Rect)localObject5).height())
        {
          localObject1 = ((RecyclerView)localObject2).by(localView);
          if (!(localObject1 instanceof com.tencent.mm.view.recyclerview.j)) {
            break label585;
          }
          localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
          j = ((Rect)localObject5).height();
        }
      }
      if (m < n) {}
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        localObject2 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.finder_banner_video_layout);
        bool1 = bool2;
        if (localObject2 != null)
        {
          Log.i("FinderVideoOrientationUIC", s.X("checkCanLandscape: videoView = ", ((FinderVideoLayout)localObject2).getVideoView()));
          localObject2 = ((FinderVideoLayout)localObject2).getVideoView();
          if (!(localObject2 instanceof View)) {
            break label591;
          }
          localObject2 = (View)localObject2;
          label349:
          bool1 = bool2;
          if (localObject2 != null)
          {
            localObject5 = new StringBuilder("checkCanLandscape: pos = ").append(((com.tencent.mm.view.recyclerview.j)localObject1).KJ()).append(", itemViewType = ").append(((RecyclerView.v)localObject1).caO).append(", height = ").append(((View)localObject2).getHeight()).append(", width = ").append(((View)localObject2).getWidth()).append(", isTpView = ").append(localObject2 instanceof FinderThumbPlayerProxy).append(", isSurfaceView = ");
            if (!(localObject2 instanceof FinderThumbPlayerProxy)) {
              break label597;
            }
            localObject3 = (FinderThumbPlayerProxy)localObject2;
            label455:
            if (localObject3 != null) {
              break label603;
            }
            localObject3 = null;
            label463:
            Log.i("FinderVideoOrientationUIC", localObject3 instanceof MMSurfaceViewRender);
            bool1 = bool2;
            if (((RecyclerView.v)localObject1).caO == 4)
            {
              bool1 = bool2;
              if (((View)localObject2).getHeight() < ((View)localObject2).getWidth())
              {
                bool1 = bool2;
                if ((localObject2 instanceof FinderThumbPlayerProxy))
                {
                  bool1 = bool2;
                  if ((((FinderThumbPlayerProxy)localObject2).getRenderView() instanceof MMSurfaceViewRender)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
      localObject2 = localObject4;
      if (bool1) {
        localObject2 = localObject1;
      }
      this.GQJ = ((com.tencent.mm.view.recyclerview.j)localObject2);
      if (localObject1 == null) {}
      for (i = -1;; i = ((com.tencent.mm.view.recyclerview.j)localObject1).KJ())
      {
        this.GQM = i;
        AppMethodBeat.o(338849);
        return bool1;
        label585:
        localObject1 = null;
        break;
        label591:
        localObject2 = null;
        break label349;
        label597:
        localObject3 = null;
        break label455;
        label603:
        localObject3 = ((FinderThumbPlayerProxy)localObject3).getRenderView();
        break label463;
      }
      k = m;
      i = j;
      localObject3 = localObject1;
      break;
      localObject1 = null;
    }
  }
  
  private final void fnR()
  {
    AppMethodBeat.i(338861);
    getContext().setRequestedOrientation(1);
    AppMethodBeat.o(338861);
  }
  
  private final void vo(boolean paramBoolean)
  {
    AppMethodBeat.i(338878);
    Object localObject = getActivity().getWindow().getDecorView();
    if ((localObject instanceof ViewGroup)) {
      localObject = (ViewGroup)localObject;
    }
    while (localObject != null) {
      if (paramBoolean)
      {
        ((ViewGroup)localObject).removeView((View)fnP());
        AppMethodBeat.o(338878);
        return;
        localObject = null;
      }
      else
      {
        ((ViewGroup)localObject).removeView((View)fnP());
        ((ViewGroup)localObject).addView((View)fnP(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      }
    }
    AppMethodBeat.o(338878);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(339164);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    if (((av)com.tencent.mm.ui.component.k.d(getActivity()).q(av.class)).onBackPressed())
    {
      AppMethodBeat.o(339164);
      return true;
    }
    if ((this.GQK != null) && (getContext().getResources().getConfiguration().orientation == 2))
    {
      fnR();
      AppMethodBeat.o(339164);
      return true;
    }
    AppMethodBeat.o(339164);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    boolean bool2 = false;
    Object localObject1 = null;
    AppMethodBeat.i(339192);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Object localObject2 = new StringBuilder("onConfigurationChanged: newConfig = ").append(paramConfiguration.orientation).append(", isLandscape = ");
    if (paramConfiguration.orientation == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("FinderVideoOrientationUIC", bool1 + ", currOrientation = " + this.GQL + ", activity = " + getActivity().getClass().getSimpleName());
      if (this.GQL != paramConfiguration.orientation) {
        break;
      }
      AppMethodBeat.o(339192);
      return;
    }
    this.GQL = paramConfiguration.orientation;
    label273:
    label474:
    int i;
    if (paramConfiguration.orientation == 1)
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility() & 0xFFFFF7F9);
      paramConfiguration = com.tencent.mm.ui.component.k.aeZF;
      paramConfiguration = com.tencent.mm.ui.component.k.d(getActivity()).q(av.class);
      s.s(paramConfiguration, "UICProvider.of(activity)…edControlUIC::class.java)");
      av.a((av)paramConfiguration, false, false, 0.0F, 4);
      localObject1 = this.GQI;
      if (localObject1 != null)
      {
        if (!(localObject1 instanceof FinderThumbPlayerProxy)) {
          break label651;
        }
        paramConfiguration = (FinderThumbPlayerProxy)localObject1;
        if (paramConfiguration != null) {
          paramConfiguration.fjj();
        }
        fnP().removeView((View)localObject1);
        paramConfiguration = this.GQF;
        if (!(paramConfiguration instanceof FinderVideoLayout)) {
          break label656;
        }
        paramConfiguration = (FinderVideoLayout)paramConfiguration;
        if (paramConfiguration != null)
        {
          localObject2 = paramConfiguration.getVideoCore().GpZ;
          if (localObject2 != null) {
            ((FinderVideoAutoPlayManager)localObject2).i("FinderHDRVideoOrientationUIC", false, true);
          }
          paramConfiguration.setEnablePlay(true);
          fnP().s(paramConfiguration);
        }
        paramConfiguration = this.GQF;
        if (paramConfiguration != null) {
          paramConfiguration.removeView((View)localObject1);
        }
        paramConfiguration = this.GQF;
        if (paramConfiguration != null) {
          paramConfiguration.addView((View)localObject1, this.GQG, this.GQH);
        }
        if (!((FinderThumbPlayerProxy)localObject1).isPlaying())
        {
          ((FinderThumbPlayerProxy)localObject1).getCurrentPlayMs();
          paramConfiguration = this.GQF;
          if (paramConfiguration != null) {
            paramConfiguration.post(new ae..ExternalSyntheticLambda2(this));
          }
        }
        this.GQF = null;
        this.GQI = null;
        this.GQG = -1;
        this.GQH = null;
        if ((localObject1 instanceof t))
        {
          ((FinderThumbPlayerProxy)localObject1).setInterceptDetach(false);
          ((FinderThumbPlayerProxy)localObject1).setPreview(false);
        }
      }
      paramConfiguration = this.GQK;
      if (paramConfiguration != null)
      {
        localObject1 = paramConfiguration.getRecyclerView();
        if (localObject1 != null)
        {
          if (!(localObject1 instanceof FinderRecyclerView)) {
            break label661;
          }
          paramConfiguration = (FinderRecyclerView)localObject1;
          if (paramConfiguration != null) {
            paramConfiguration.a((RecyclerView.l)paramConfiguration.getScrollEventAdapter());
          }
          i = this.GQM;
          ((RecyclerView)localObject1).post(new ae..ExternalSyntheticLambda1(i, (RecyclerView)localObject1));
          paramConfiguration = this.GQK;
          if (paramConfiguration != null) {
            break label666;
          }
          localObject1 = null;
          label522:
          localObject2 = new StringBuilder("resetToPortrait: pos = ").append(i).append(", desc = ");
          if (localObject1 != null) {
            break label678;
          }
          paramConfiguration = null;
          label551:
          localObject2 = ((StringBuilder)localObject2).append(paramConfiguration).append(" nickname = ");
          if (localObject1 != null) {
            break label731;
          }
          paramConfiguration = null;
          label572:
          Log.i("FinderVideoOrientationUIC", paramConfiguration + ", activity = " + getActivity().getClass().getSimpleName());
        }
      }
      fnP().setFullSeekBar(null);
      paramConfiguration = this.GQK;
      if (paramConfiguration == null) {}
      for (paramConfiguration = null;; paramConfiguration = paramConfiguration.getRecyclerView())
      {
        if (paramConfiguration != null) {
          paramConfiguration.setLayoutFrozen(false);
        }
        this.GQK = null;
        vo(true);
        AppMethodBeat.o(339192);
        return;
        label651:
        paramConfiguration = null;
        break;
        label656:
        paramConfiguration = null;
        break label273;
        label661:
        paramConfiguration = null;
        break label474;
        label666:
        localObject1 = (BaseFinderFeed)paramConfiguration.CSA;
        break label522;
        label678:
        paramConfiguration = ((BaseFinderFeed)localObject1).feedObject;
        if (paramConfiguration == null)
        {
          paramConfiguration = null;
          break label551;
        }
        paramConfiguration = paramConfiguration.getDescription();
        if (paramConfiguration == null)
        {
          paramConfiguration = null;
          break label551;
        }
        paramConfiguration = paramConfiguration.substring(0, Math.min(paramConfiguration.length(), 3));
        s.s(paramConfiguration, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        break label551;
        label731:
        paramConfiguration = ((BaseFinderFeed)localObject1).feedObject;
        if (paramConfiguration == null)
        {
          paramConfiguration = null;
          break label572;
        }
        paramConfiguration = paramConfiguration.getNickName();
        break label572;
      }
    }
    paramConfiguration = com.tencent.mm.plugin.finder.utils.av.GiL;
    if (com.tencent.mm.plugin.finder.utils.av.fgj()) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (!bool1)
      {
        Log.e("FinderVideoOrientationUIC", "onConfigurationChanged: enterLandScape failed");
        getContext().setRequestedOrientation(1);
      }
      AppMethodBeat.o(339192);
      return;
      if ((getActivity() instanceof FinderHomeUI))
      {
        paramConfiguration = com.tencent.mm.ui.component.k.aeZF;
        paramConfiguration = ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(getActivity()).q(FinderHomeUIC.class)).getActiveFragment().getView();
        if (paramConfiguration == null)
        {
          paramConfiguration = null;
          label848:
          if (paramConfiguration != null) {
            break label903;
          }
        }
      }
      label903:
      for (paramConfiguration = (Configuration)localObject1;; paramConfiguration = paramConfiguration.getRecyclerView())
      {
        if (paramConfiguration != null) {
          break label911;
        }
        Log.e("FinderVideoOrientationUIC", "enterLandScape, recyclerView is null");
        bool1 = bool2;
        break;
        paramConfiguration = (RefreshLoadMoreLayout)paramConfiguration.findViewById(e.e.rl_layout);
        break label848;
        paramConfiguration = (RefreshLoadMoreLayout)findViewById(e.e.rl_layout);
        break label848;
      }
      label911:
      paramConfiguration = paramConfiguration.getLayoutManager();
      if (paramConfiguration == null)
      {
        paramConfiguration = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
        AppMethodBeat.o(339192);
        throw paramConfiguration;
      }
      localObject1 = (FinderLinearLayoutManager)paramConfiguration;
      paramConfiguration = this.GQJ;
      i = ((FinderLinearLayoutManager)localObject1).Ju();
      if (paramConfiguration == null)
      {
        Log.e("FinderVideoOrientationUIC", s.X("enterLandScape, holder is null, first pos = ", Integer.valueOf(i)));
        bool1 = bool2;
      }
      else if (paramConfiguration.caO != 4)
      {
        Log.e("FinderVideoOrientationUIC", s.X("enterLandScape, holder is null, pos = ", Integer.valueOf(paramConfiguration.KJ())));
        bool1 = bool2;
      }
      else
      {
        i = paramConfiguration.KJ();
        localObject1 = (BaseFinderFeed)paramConfiguration.CSA;
        localObject2 = new StringBuilder("enterLandScape: pos = ").append(i).append(", desc = ");
        String str = ((BaseFinderFeed)localObject1).feedObject.getDescription();
        int j = Math.min(str.length(), 3);
        if (str == null)
        {
          paramConfiguration = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(339192);
          throw paramConfiguration;
        }
        str = str.substring(0, j);
        s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.i("FinderVideoOrientationUIC", str + " nickname = " + ((BaseFinderFeed)localObject1).feedObject.getNickName() + ", activity = " + getActivity().getClass().getSimpleName());
        if (i > 0) {
          this.GQM = i;
        }
        this.GQK = paramConfiguration;
        getActivity().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility() | 0x806);
        localObject2 = fnP();
        s.s(localObject1, "item");
        bool1 = ((b)localObject2).m(paramConfiguration, (BaseFinderFeed)localObject1);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(339121);
    super.onCreate(paramBundle);
    this.GQQ.enable();
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = ((Iterable)((as)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(as.class)).fox()).iterator();
    while (paramBundle.hasNext())
    {
      com.tencent.mm.plugin.finder.event.base.c localc = (com.tencent.mm.plugin.finder.event.base.c)paramBundle.next();
      if (localc != null) {
        localc.a(this.GQR);
      }
    }
    getContext().setRequestedOrientation(1);
    paramBundle = getActivity().getPackageManager().getActivityInfo(getActivity().getComponentName(), 128);
    s.s(paramBundle, "activity.packageManager.…ageManager.GET_META_DATA)");
    boolean bool;
    if ((paramBundle.configChanges & 0x80) > 0)
    {
      bool = true;
      this.GQO = bool;
      paramBundle = getActivity();
      if (!(paramBundle instanceof MMFinderUI)) {
        break label182;
      }
    }
    label182:
    for (paramBundle = (MMFinderUI)paramBundle;; paramBundle = null)
    {
      if (paramBundle != null) {
        paramBundle.FVH = this.GQO;
      }
      AppMethodBeat.o(339121);
      return;
      bool = false;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(339153);
    super.onDestroy();
    this.GQQ.disable();
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((Iterable)((as)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(as.class)).fox()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.finder.event.base.c localc = (com.tencent.mm.plugin.finder.event.base.c)((Iterator)localObject).next();
      if (localc != null) {
        localc.b(this.GQR);
      }
    }
    AppMethodBeat.o(339153);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(339142);
    super.onPause();
    this.cqi = false;
    AppMethodBeat.o(339142);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(339130);
    super.onResume();
    this.cqi = true;
    AppMethodBeat.o(339130);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC$HDRHorizontalVideoPreviewLayout;", "Lcom/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addPreview", "", "focusHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onFloatBallBtnClick", "", "simpleViewHolder", "onPlayBtnClick", "newIsPlaying", "onSpeedCtrlBtnClick", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends HorizontalVideoPreviewLayout
  {
    public b()
    {
      super();
      AppMethodBeat.i(337433);
      int i = (int)getResources().getDimension(e.c.Edge_3_5_A);
      int j = (int)getResources().getDimension(e.c.Edge_3A);
      this$1 = new FrameLayout.LayoutParams(i, i);
      ae.this.topMargin = j;
      ae.this.setMarginStart(j);
      ae.this.gravity = 8388611;
      getIconLayout().setLayoutParams((ViewGroup.LayoutParams)ae.this);
      getIconLayout().setOnClickListener(new ae.b..ExternalSyntheticLambda0(ae.this));
      AppMethodBeat.o(337433);
    }
    
    private static final void a(com.tencent.mm.view.recyclerview.j paramj, ae paramae)
    {
      AppMethodBeat.i(337458);
      s.u(paramj, "$focusHolder");
      s.u(paramae, "this$0");
      paramj = paramj.getRecyclerView();
      paramae = com.tencent.mm.hellhoundlib.b.c.a(ae.d(paramae), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramj, paramae.aYi(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC$HDRHorizontalVideoPreviewLayout", "addPreview$lambda-11$lambda-3", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC;)V", "Undefined", "scrollToPosition", "(I)V");
      paramj.scrollToPosition(((Integer)paramae.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramj, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC$HDRHorizontalVideoPreviewLayout", "addPreview$lambda-11$lambda-3", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC;)V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(337458);
    }
    
    private static final void b(ae paramae, View paramView)
    {
      AppMethodBeat.i(337447);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramae);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC$HDRHorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramae, "this$0");
      ae.b(paramae);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC$HDRHorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(337447);
    }
    
    private static final void fnS() {}
    
    public final void flE()
    {
      AppMethodBeat.i(337535);
      List localList = p.listOf(new View[] { (View)getIconLayout(), (View)getLongVideoSeekBarLayout() });
      Object localObject1 = ae.c(ae.this);
      if ((localObject1 instanceof FinderThumbPlayerProxy)) {}
      for (localObject1 = (FinderThumbPlayerProxy)localObject1;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          Object localObject2 = ae.this;
          com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
          localObject2 = com.tencent.mm.ui.component.k.d(((ae)localObject2).getActivity()).q(av.class);
          s.s(localObject2, "UICProvider.of(activity)…edControlUIC::class.java)");
          av.a((av)localObject2, localList, (FinderThumbPlayerProxy)localObject1, 0, true, null, 16);
        }
        AppMethodBeat.o(337535);
        return;
      }
    }
    
    public final boolean m(com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(337527);
      s.u(paramj, "focusHolder");
      s.u(paramBaseFinderFeed, "item");
      Object localObject1 = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
      if (localObject1 != null)
      {
        Object localObject2 = ae.this;
        Log.i("HorizontalVideoPreviewLayout", "FinderVideoOrientationUIC addPreview: videoView = " + ((FinderVideoLayout)localObject1).getVideoView() + ", activity = " + ((ae)localObject2).getActivity().getClass().getSimpleName());
        if ((((FinderVideoLayout)localObject1).getVideoView() instanceof FinderThumbPlayerProxy)) {}
        while (localObject1 != null)
        {
          Object localObject3 = ae.this;
          localObject2 = ((FinderVideoLayout)localObject1).getVideoCore().GpZ;
          if (localObject2 != null) {
            FinderVideoAutoPlayManager.a((FinderVideoAutoPlayManager)localObject2, "FinderHDRVideoOrientationUIC", true);
          }
          localObject2 = ((FinderVideoLayout)localObject1).getVideoView();
          if (localObject2 == null)
          {
            paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy");
            AppMethodBeat.o(337527);
            throw paramj;
            localObject1 = null;
          }
          else
          {
            FinderThumbPlayerProxy localFinderThumbPlayerProxy = (FinderThumbPlayerProxy)localObject2;
            localFinderThumbPlayerProxy.fjj();
            ae.a((ae)localObject3, (View)localFinderThumbPlayerProxy);
            paramj.getRecyclerView().post(new ae.b..ExternalSyntheticLambda1(paramj, (ae)localObject3));
            localObject2 = com.tencent.mm.ui.component.k.aeZF;
            ((com.tencent.mm.plugin.finder.share.a)com.tencent.mm.ui.component.k.d(((ae)localObject3).getActivity()).q(com.tencent.mm.plugin.finder.share.a.class)).ePC();
            localFinderThumbPlayerProxy.setPreview(true);
            localFinderThumbPlayerProxy.setInterceptDetach(true);
            ae.e((ae)localObject3);
            localObject2 = paramj.getRecyclerView();
            if ((localObject2 instanceof FinderRecyclerView)) {}
            for (localObject2 = (FinderRecyclerView)localObject2;; localObject2 = null)
            {
              if (localObject2 != null) {
                ((FinderRecyclerView)localObject2).b((RecyclerView.l)((FinderRecyclerView)localObject2).getScrollEventAdapter());
              }
              localObject2 = localFinderThumbPlayerProxy.getParent();
              if (localObject2 != null) {
                break;
              }
              paramj = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(337527);
              throw paramj;
            }
            ae.a((ae)localObject3, (ViewGroup)localObject2);
            localObject2 = ae.f((ae)localObject3);
            if ((localObject2 instanceof FinderVideoLayout)) {
              ((FinderVideoLayout)localObject2).setEnablePlay(false);
            }
            localObject2 = ae.f((ae)localObject3);
            int i;
            int j;
            label555:
            float f1;
            if (localObject2 == null)
            {
              i = 0;
              ae.a((ae)localObject3, i);
              ae.a((ae)localObject3, new ViewGroup.LayoutParams(localFinderThumbPlayerProxy.getWidth(), localFinderThumbPlayerProxy.getHeight()));
              localObject2 = ae.f((ae)localObject3);
              if (localObject2 != null) {
                ((ViewGroup)localObject2).removeView((View)localFinderThumbPlayerProxy);
              }
              if ((!com.tencent.mm.n.a.aTj()) && (!((FinderVideoLayout)localObject1).lAj))
              {
                localObject2 = com.tencent.mm.ui.component.k.aeZF;
                ((bi)com.tencent.mm.ui.component.k.cn(cn.class).cq(bi.class)).fpt();
              }
              i = kotlin.k.k.qu(((ae)localObject3).getActivity().getResources().getDisplayMetrics().widthPixels, ((ae)localObject3).getActivity().getResources().getDisplayMetrics().heightPixels);
              j = kotlin.k.k.qv(((ae)localObject3).getActivity().getResources().getDisplayMetrics().widthPixels, ((ae)localObject3).getActivity().getResources().getDisplayMetrics().heightPixels);
              if (!paramBaseFinderFeed.feedObject.isLongVideo()) {
                break label735;
              }
              localObject2 = paramBaseFinderFeed.feedObject.getLongVideoMediaList();
              localObject3 = com.tencent.mm.plugin.finder.utils.av.GiL;
              f1 = com.tencent.mm.plugin.finder.utils.av.hI((List)localObject2);
              float f2 = 1.0F * j / i;
              localObject2 = new FrameLayout.LayoutParams(-1, -1);
              ((FrameLayout.LayoutParams)localObject2).gravity = 17;
              if (f1 <= f2) {
                break label747;
              }
              ((FrameLayout.LayoutParams)localObject2).width = kotlin.h.a.eH(j / f1);
            }
            for (((FrameLayout.LayoutParams)localObject2).height = j;; ((FrameLayout.LayoutParams)localObject2).height = kotlin.h.a.eH(f1 * i))
            {
              addView((View)localFinderThumbPlayerProxy, 1, (ViewGroup.LayoutParams)localObject2);
              a((FinderVideoLayout)localObject1, localFinderThumbPlayerProxy, paramj, paramBaseFinderFeed.feedObject.isLongVideo());
              HorizontalVideoPreviewLayout.a((HorizontalVideoPreviewLayout)this, localFinderThumbPlayerProxy);
              if (!localFinderThumbPlayerProxy.isPlaying())
              {
                localFinderThumbPlayerProxy.getCurrentPlayMs();
                post(ae.b..ExternalSyntheticLambda2.INSTANCE);
              }
              localObject1 = getLongVideoSeekBarLayout().getLayoutParams();
              if (localObject1 != null) {
                break label770;
              }
              paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
              AppMethodBeat.o(337527);
              throw paramj;
              i = ((ViewGroup)localObject2).indexOfChild((View)localFinderThumbPlayerProxy);
              break;
              label735:
              localObject2 = paramBaseFinderFeed.feedObject.getMediaList();
              break label555;
              label747:
              ((FrameLayout.LayoutParams)localObject2).width = i;
            }
            label770:
            ((FrameLayout.LayoutParams)localObject1).gravity = 80;
            getLongVideoSeekBarLayout().requestLayout();
            setFullSeekBar((FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout));
            paramj = paramBaseFinderFeed.feedObject.getDescriptionFullSpan();
            if (paramj == null) {
              paramj = null;
            }
            for (;;)
            {
              if (paramj == null)
              {
                getLongVideoSeekBarLayout().getDescTv().setVisibility(8);
                getLongVideoSeekBarLayout().getHiddenTv().setText(null);
              }
              getLongVideoSeekBarLayout().getHiddenTv().setVisibility(4);
              AppMethodBeat.o(337527);
              return true;
              if (((CharSequence)paramj).length() > 0)
              {
                i = 1;
                label876:
                if (i == 0) {
                  break label896;
                }
              }
              for (;;)
              {
                if (paramj != null) {
                  break label901;
                }
                paramj = null;
                break;
                i = 0;
                break label876;
                label896:
                paramj = null;
              }
              label901:
              getLongVideoSeekBarLayout().getDescTv().setText((CharSequence)paramj);
              getLongVideoSeekBarLayout().getHiddenTv().setText((CharSequence)paramj);
              paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.av.GiL;
              com.tencent.mm.plugin.finder.utils.av.a(getLongVideoSeekBarLayout().getDescTv(), (Spannable)paramj);
              paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.av.GiL;
              com.tencent.mm.plugin.finder.utils.av.a(getLongVideoSeekBarLayout().getHiddenTv(), (Spannable)paramj);
              getLongVideoSeekBarLayout().getDescTv().setVisibility(0);
              paramj = ah.aiuX;
            }
          }
        }
      }
      AppMethodBeat.o(337527);
      return false;
    }
    
    public final void tv(boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends d
  {
    c(ae paramae, AppCompatActivity paramAppCompatActivity) {}
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(337412);
      s.u(paramb, "ev");
      if (this.GQS.getContext().getResources().getConfiguration().orientation == 2)
      {
        AppMethodBeat.o(337412);
        return;
      }
      if ((paramb instanceof c.a))
      {
        if (((c.a)paramb).type == 17)
        {
          if ((ae.g(this.GQS) != null) && (this.GQS.getContext().getResources().getConfiguration().orientation == 1))
          {
            Log.i("FinderVideoOrientationUIC", s.X("PlayEventSubscriber.PlayEvent.VIDEO_CLICK_PAUSE: set portrait, activity = ", paramAppCompatActivity.getClass().getSimpleName()));
            this.GQS.getContext().setRequestedOrientation(1);
          }
          AppMethodBeat.o(337412);
          return;
        }
        AppMethodBeat.o(337412);
        return;
      }
      if (!(paramb instanceof h))
      {
        AppMethodBeat.o(337412);
        return;
      }
      if (!ae.h(this.GQS))
      {
        Log.e("FinderVideoOrientationUIC", s.X("onEventHappen: error, need to set orientation into android:configChanges in AndroidManifest.xml, activity = ", paramAppCompatActivity));
        AppMethodBeat.o(337412);
        return;
      }
      ae localae = this.GQS;
      if (((h)paramb).type == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ae.a(localae, bool);
        if (((h)paramb).type != 1) {
          break;
        }
        if (!ae.i(this.GQS)) {
          this.GQS.getContext().setRequestedOrientation(1);
        }
        ae.j(this.GQS);
        ae.b(this.GQS, true);
        AppMethodBeat.o(337412);
        return;
      }
      ae.b(this.GQS, false);
      bool = ae.k(this.GQS);
      Log.i("FinderVideoOrientationUIC", "onEventHappen: ev = " + paramb + ", isLandScapeVideo = " + bool + ", activity = " + paramAppCompatActivity.getClass().getSimpleName());
      AppMethodBeat.o(337412);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(337418);
      s.u(paramc, "dispatcher");
      s.u(paramb, "event");
      if ((((paramb instanceof h)) && ((((h)paramb).type == 0) || (((h)paramb).type == 4) || (((h)paramb).type == 5) || (((h)paramb).type == 1) || (((h)paramb).type == 7))) || (((paramb instanceof c.a)) && (((c.a)paramb).type == 17)))
      {
        AppMethodBeat.o(337418);
        return true;
      }
      AppMethodBeat.o(337418);
      return false;
    }
    
    public final boolean dXA()
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC$HDRHorizontalVideoPreviewLayout;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHDRVideoOrientationUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ae.b>
  {
    d(ae paramae, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ae
 * JD-Core Version:    0.7.0.1
 */