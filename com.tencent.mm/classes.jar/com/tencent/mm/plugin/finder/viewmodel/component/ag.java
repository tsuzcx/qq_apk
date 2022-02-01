package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.Settings.System;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.a.a;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.HorizontalVideoPreviewLayout;
import com.tencent.mm.plugin.finder.view.HorizontalVideoSeekBarLayout;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.thumbplayer.render.MMSurfaceViewRender;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "horizontalFeedId", "", "horizontalLayout", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$InnerHorizontalVideoPreviewLayout;", "getHorizontalLayout", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$InnerHorizontalVideoPreviewLayout;", "horizontalLayout$delegate", "Lkotlin/Lazy;", "isExiting", "", "isPauseManual", "isPauseWhenEnterHorizontalPreview", "()Z", "setPauseWhenEnterHorizontalPreview", "(Z)V", "isResumed", "orientationEventListener", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "screenHeight", "", "screenWidth", "attachHorizontalLayout", "", "isRemove", "exitType", "checkAlreadyHorizontal", "enterHorizontal", "orientation", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "exitHorizontal", "finish", "Lkotlin/Function0;", "handleOnConfigurationChanged", "handleOrientationChanged", "isEnableHorizontal", "context", "Landroid/content/Context;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "AnimInfo", "Companion", "InnerHorizontalVideoPreviewLayout", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends UIComponent
{
  public static final ag.b GRH;
  private final com.tencent.mm.bj.a GQQ;
  public boolean GRI;
  private boolean GRJ;
  private long GRK;
  private boolean GRL;
  private final kotlin.j GRM;
  private boolean cqi;
  private int pvg;
  private int sJv;
  
  static
  {
    AppMethodBeat.i(338890);
    GRH = new ag.b((byte)0);
    AppMethodBeat.o(338890);
  }
  
  public ag(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338769);
    this.GQQ = new com.tencent.mm.bj.a((Context)getActivity(), new ag..ExternalSyntheticLambda0(this));
    this.GRM = kotlin.k.cm((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(338769);
  }
  
  public ag(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338774);
    this.GQQ = new com.tencent.mm.bj.a((Context)getActivity(), new ag..ExternalSyntheticLambda0(this));
    this.GRM = kotlin.k.cm((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(338774);
  }
  
  private final void U(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(338821);
    Log.i("Finder.HorizontalVideoPreviewUIC", "[attachHorizontalLayout] isRemove=" + paramBoolean + " exitType=" + paramInt);
    Object localObject = getActivity().getWindow().getDecorView();
    if ((localObject instanceof ViewGroup)) {
      localObject = (ViewGroup)localObject;
    }
    while (localObject != null) {
      if (paramBoolean)
      {
        ((ViewGroup)localObject).removeView((View)fob());
        AppMethodBeat.o(338821);
        return;
        localObject = null;
      }
      else
      {
        ((ViewGroup)localObject).removeView((View)fob());
        ((ViewGroup)localObject).addView((View)fob(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      }
    }
    AppMethodBeat.o(338821);
  }
  
  private final void Vj(final int paramInt)
  {
    AppMethodBeat.i(338805);
    if ((!fob().nvB) || (this.GRL))
    {
      Log.i("Finder.HorizontalVideoPreviewUIC", "exitHorizontal: failed");
      AppMethodBeat.o(338805);
      return;
    }
    this.GRL = true;
    final FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)findViewById(e.e.media_banner);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(av.class);
    s.s(localObject, "UICProvider.of(activity)…edControlUIC::class.java)");
    av.a((av)localObject, false, false, 0.0F, 4);
    if ((fob().getPreview() instanceof t))
    {
      fob().c(paramInt, (kotlin.g.a.a)new d(this, paramInt, localFinderMediaBanner, null));
      AppMethodBeat.o(338805);
      return;
    }
    fob().c(paramInt, (kotlin.g.a.a)new e(this, paramInt, localFinderMediaBanner, null));
    AppMethodBeat.o(338805);
  }
  
  private final void a(a.a parama)
  {
    int m = 1;
    AppMethodBeat.i(338798);
    if ((parama == a.a.pvS) || (parama == a.a.pvU))
    {
      a(this, 0, 2);
      AppMethodBeat.o(338798);
      return;
    }
    Object localObject1;
    int i;
    label150:
    label155:
    label160:
    Object localObject4;
    int k;
    Object localObject7;
    Object localObject6;
    Object localObject5;
    label261:
    int n;
    int j;
    Object localObject3;
    Object localObject2;
    if ((parama == a.a.pvT) || (parama == a.a.pvV))
    {
      this.GRJ = false;
      if (fob().nvB)
      {
        Log.i("Finder.HorizontalVideoPreviewUIC", "enterHorizontal: failed, horizontalLayout isPreviewing");
        AppMethodBeat.o(338798);
        return;
      }
      localObject1 = getActivity().getWindow().getDecorView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject1 = (ViewGroup)localObject1;
        if (localObject1 == null) {
          break label155;
        }
        if (((ViewGroup)localObject1).findViewById(e.e.finder_horizontal_preview_layout) == null) {
          break label150;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label160;
        }
        Log.e("Finder.HorizontalVideoPreviewUIC", "enterHorizontal: error, already have horizontal preview layout");
        AppMethodBeat.o(338798);
        return;
        localObject1 = null;
        break;
        i = 0;
        continue;
        i = 0;
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(av.class);
      s.s(localObject1, "UICProvider.of(activity)…edControlUIC::class.java)");
      av.a((av)localObject1, false, false, 0.0F, 6);
      localObject1 = (RefreshLoadMoreLayout)findViewById(e.e.rl_layout);
      if (localObject1 == null)
      {
        localObject4 = null;
        if (localObject4 == null) {
          break label1196;
        }
        Rect localRect = new Rect();
        int i1 = ((RecyclerView)localObject4).getChildCount();
        if (i1 <= 0) {
          break label1196;
        }
        k = 0;
        i = 0;
        localObject7 = null;
        localObject6 = null;
        localObject5 = null;
        n = k + 1;
        View localView = ((RecyclerView)localObject4).getChildAt(k);
        j = i;
        localObject1 = localObject7;
        localObject3 = localObject6;
        localObject2 = localObject5;
        if (localView.getGlobalVisibleRect(localRect))
        {
          j = i;
          localObject1 = localObject7;
          localObject3 = localObject6;
          localObject2 = localObject5;
          if (i < localRect.height())
          {
            localObject2 = localView.findViewById(e.e.media_banner);
            localObject3 = localView.findViewById(e.e.text_content);
            j = localRect.height();
            localObject1 = localView;
          }
        }
        if (n < i1) {
          break label1175;
        }
        localObject5 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject5;
      }
    }
    for (;;)
    {
      localObject5 = (FinderMediaBanner)localObject3;
      label410:
      label431:
      label485:
      label497:
      label503:
      boolean bool;
      if (localObject5 != null)
      {
        localObject5 = ((FinderMediaBanner)localObject5).getPagerView();
        if (localObject5 != null)
        {
          localObject6 = (FinderMediaBanner)localObject3;
          if (localObject6 == null)
          {
            i = 0;
            localObject6 = ((RecyclerHorizontalViewPager)localObject5).fU(i);
            if (localObject1 == null) {
              break label497;
            }
            if (localObject4 != null) {
              break label485;
            }
            localObject4 = null;
            if (!(localObject4 instanceof com.tencent.mm.view.recyclerview.j)) {
              break label497;
            }
          }
          for (localObject4 = (com.tencent.mm.view.recyclerview.j)localObject4;; localObject4 = null)
          {
            if (localObject4 != null) {
              break label503;
            }
            Log.e("Finder.HorizontalVideoPreviewUIC", "enterHorizontal: cannot find target view holder");
            AppMethodBeat.o(338798);
            return;
            localObject4 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
            break;
            i = ((FinderMediaBanner)localObject6).getFocusPosition();
            break label410;
            localObject4 = ((RecyclerView)localObject4).by((View)localObject1);
            break label431;
          }
          localObject5 = ((com.tencent.mm.view.recyclerview.j)localObject4).CSA;
          if (((localObject5 instanceof BaseFinderFeed)) && (!((BaseFinderFeed)localObject5).feedObject.isPostFinish()))
          {
            Log.i("Finder.HorizontalVideoPreviewUIC", "enterHorizontal: posting feed don't allow to horizon");
            AppMethodBeat.o(338798);
            return;
          }
          long l;
          if ((localObject5 instanceof BaseFinderFeed))
          {
            l = ((BaseFinderFeed)localObject5).bZA();
            this.GRK = l;
            if ((localObject6 == null) || (((RecyclerView.v)localObject6).caO != 4)) {
              break label661;
            }
            i = 1;
            label587:
            if (i == 0) {
              break label957;
            }
            localObject6 = (FinderVideoLayout)((RecyclerView.v)localObject6).caK.findViewById(e.e.finder_banner_video_layout);
            if (localObject6 == null) {
              break label957;
            }
            localObject7 = ((FinderVideoLayout)localObject6).getVideoView();
            if ((localObject7 == null) || (((t)localObject7).isPlaying())) {
              break label666;
            }
          }
          label661:
          label666:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label671;
            }
            Log.w("Finder.HorizontalVideoPreviewUIC", "playing false");
            AppMethodBeat.o(338798);
            return;
            l = 0L;
            break;
            i = 0;
            break label587;
          }
          label671:
          if ((((FinderVideoLayout)localObject6).getVideoView() instanceof FinderThumbPlayerProxy))
          {
            localObject7 = ((FinderVideoLayout)localObject6).getVideoView();
            if (localObject7 == null)
            {
              parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy");
              AppMethodBeat.o(338798);
              throw parama;
            }
            if ((((FinderThumbPlayerProxy)localObject7).getRenderView() instanceof MMSurfaceViewRender))
            {
              Log.w("Finder.HorizontalVideoPreviewUIC", "enterHorizontal return for MMSurfaceViewRender");
              AppMethodBeat.o(338798);
              return;
            }
          }
          localObject6 = ((FinderVideoLayout)localObject6).getVideoView();
          if ((localObject6 != null) && (((t)localObject6).getVideoView().getHeight() < ((t)localObject6).getVideoView().getWidth()))
          {
            if (((t)localObject6).isPlaying()) {
              break label964;
            }
            bool = true;
            this.GRJ = bool;
            localObject3 = (FinderMediaBanner)localObject3;
            if (localObject3 != null) {
              ((FinderMediaBanner)localObject3).setFrozenRecyclerView(true);
            }
            ((t)localObject6).setPreview(true);
            ((t)localObject6).setInterceptDetach(true);
            U(false, -1);
            localObject3 = fob();
            localObject6 = ((t)localObject6).getVideoView();
            if (parama != a.a.pvT) {
              break label970;
            }
            i = 90;
            label861:
            if (!(localObject5 instanceof BaseFinderFeed)) {
              break label976;
            }
            parama = (BaseFinderFeed)localObject5;
            label875:
            if (parama != null) {
              break label981;
            }
            bool = false;
            label882:
            ((c)localObject3).a((View)localObject6, i, (View)localObject1, (com.tencent.mm.view.recyclerview.j)localObject4, bool);
            if ((MMNeat7extView)localObject2 != null)
            {
              if (!(localObject5 instanceof com.tencent.mm.plugin.finder.model.ah)) {
                break label1005;
              }
              parama = (com.tencent.mm.plugin.finder.model.ah)localObject5;
              label918:
              if (parama != null) {
                break label1010;
              }
              parama = null;
            }
          }
        }
      }
      for (;;)
      {
        if (parama == null)
        {
          fob().getLongVideoSeekBarLayout().getDescTv().setVisibility(8);
          fob().getLongVideoSeekBarLayout().getHiddenTv().setText(null);
        }
        label957:
        AppMethodBeat.o(338798);
        return;
        label964:
        bool = false;
        break;
        label970:
        i = -90;
        break label861;
        label976:
        parama = null;
        break label875;
        label981:
        parama = parama.feedObject;
        if (parama == null)
        {
          bool = false;
          break label882;
        }
        bool = parama.isLongVideo();
        break label882;
        label1005:
        parama = null;
        break label918;
        label1010:
        parama = parama.feedObject;
        if (parama == null)
        {
          parama = null;
        }
        else
        {
          parama = parama.getDescriptionFullSpan();
          if (parama == null)
          {
            parama = null;
          }
          else
          {
            if (((CharSequence)parama).length() > 0)
            {
              i = m;
              label1053:
              if (i == 0) {
                break label1071;
              }
            }
            for (;;)
            {
              if (parama != null) {
                break label1076;
              }
              parama = null;
              break;
              i = 0;
              break label1053;
              label1071:
              parama = null;
            }
            label1076:
            fob().getLongVideoSeekBarLayout().getDescTv().setText((CharSequence)parama);
            fob().getLongVideoSeekBarLayout().getHiddenTv().setText((CharSequence)parama);
            localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
            com.tencent.mm.plugin.finder.utils.av.a(fob().getLongVideoSeekBarLayout().getDescTv(), (Spannable)parama);
            localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
            com.tencent.mm.plugin.finder.utils.av.a(fob().getLongVideoSeekBarLayout().getHiddenTv(), (Spannable)parama);
            fob().getLongVideoSeekBarLayout().getDescTv().setVisibility(0);
            parama = kotlin.ah.aiuX;
          }
        }
      }
      label1175:
      k = n;
      i = j;
      localObject7 = localObject1;
      localObject6 = localObject3;
      localObject5 = localObject2;
      break label261;
      label1196:
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
    }
  }
  
  private static final void a(ag paramag, a.a parama)
  {
    AppMethodBeat.i(338841);
    s.u(paramag, "this$0");
    s.s(parama, "newOrientation");
    paramag.a(parama);
    AppMethodBeat.o(338841);
  }
  
  private static final void a(ag paramag, a.a parama1, a.a parama2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(338855);
    s.u(paramag, "this$0");
    Context localContext = (Context)paramag.getContext();
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVp().bmg()).intValue() == 1)
    {
      i = 1;
      if ((i == 0) || (Settings.System.getInt(localContext.getContentResolver(), "accelerometer_rotation", 1) != 1)) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label91;
      }
      AppMethodBeat.o(338855);
      return;
      i = 0;
      break;
    }
    label91:
    if (!paramag.isUserVisibleFocused())
    {
      AppMethodBeat.o(338855);
      return;
    }
    if ((paramag.cqi) && (parama1 != parama2))
    {
      parama1 = com.tencent.mm.ui.component.k.aeZF;
      parama1 = ((i)com.tencent.mm.ui.component.k.d(paramag.getActivity()).q(i.class)).ATy;
      boolean bool1;
      if ((parama1 != null) && (parama1.fkp() == true))
      {
        bool1 = true;
        parama1 = com.tencent.mm.ui.component.k.aeZF;
        parama1 = ((r)com.tencent.mm.ui.component.k.d(paramag.getActivity()).q(r.class)).fny();
        if (parama1 != null) {
          break label277;
        }
      }
      for (;;)
      {
        Log.i("Finder.HorizontalVideoPreviewUIC", "[onConfigurationChanged] isDrawerOpen=" + bool1 + " isLikeDrawerOpen=" + bool2 + " newOrientation=" + parama2);
        if ((bool1) || (bool2)) {
          break label298;
        }
        if (!paramag.fob().isAnimating) {
          break label286;
        }
        paramag.fob().setRunAfterAnim(new ag..ExternalSyntheticLambda1(paramag, parama2));
        AppMethodBeat.o(338855);
        return;
        bool1 = false;
        break;
        label277:
        bool2 = parama1.fkp();
      }
      label286:
      s.s(parama2, "newOrientation");
      paramag.a(parama2);
    }
    label298:
    AppMethodBeat.o(338855);
  }
  
  private final c fob()
  {
    AppMethodBeat.i(338832);
    c localc = (c)this.GRM.getValue();
    AppMethodBeat.o(338832);
    return localc;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(338945);
    if (fob().nvB)
    {
      a(this, 0, 3);
      AppMethodBeat.o(338945);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(338945);
    return bool;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(338916);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    int i = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), paramConfiguration.screenWidthDp);
    int j = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), paramConfiguration.screenHeightDp);
    Log.i("Finder.HorizontalVideoPreviewUIC", "onConfigurationChanged width:" + i + " height:" + j + " screenWidth:" + this.sJv + " screenHeight:" + this.pvg);
    if ((i != this.sJv) || (j != this.pvg))
    {
      Log.i("Finder.HorizontalVideoPreviewUIC", "onConfigurationChanged");
      paramConfiguration = (RefreshLoadMoreLayout)findViewById(e.e.rl_layout);
      if (paramConfiguration != null) {
        break label212;
      }
      paramConfiguration = null;
      if (paramConfiguration != null) {
        break label220;
      }
      paramConfiguration = null;
      label147:
      if (!(paramConfiguration instanceof WxRecyclerAdapter)) {
        break label228;
      }
    }
    label212:
    label220:
    label228:
    for (paramConfiguration = (WxRecyclerAdapter)paramConfiguration;; paramConfiguration = null)
    {
      if ((paramConfiguration != null) && (paramConfiguration.getItemCount() > 0)) {
        paramConfiguration.e(0, paramConfiguration.getItemCount(), new kotlin.r(Integer.valueOf(30), Integer.valueOf(1)));
      }
      this.sJv = i;
      this.pvg = j;
      AppMethodBeat.o(338916);
      return;
      paramConfiguration = paramConfiguration.getRecyclerView();
      break;
      paramConfiguration = paramConfiguration.getAdapter();
      break label147;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338920);
    super.onCreate(paramBundle);
    this.GQQ.enable();
    AppMethodBeat.o(338920);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338938);
    super.onDestroy();
    this.GQQ.disable();
    AppMethodBeat.o(338938);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(338935);
    super.onPause();
    this.cqi = false;
    AppMethodBeat.o(338935);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338926);
    super.onResume();
    this.cqi = true;
    Object localObject = fob().getPreview();
    if ((localObject instanceof t)) {}
    for (localObject = (t)localObject;; localObject = null)
    {
      if ((localObject != null) && (!this.GRJ))
      {
        ((t)localObject).setVideoViewFocused(true);
        ((t)localObject).r(null);
      }
      AppMethodBeat.o(338926);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$InnerHorizontalVideoPreviewLayout;", "Lcom/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animInfo", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "getAnimInfo", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "setAnimInfo", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;)V", "currRotation", "indexOriginalParent", "getIndexOriginalParent", "()I", "setIndexOriginalParent", "(I)V", "isAnimating", "", "()Z", "setAnimating", "(Z)V", "isPreviewing", "setPreviewing", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "originalParams", "Landroid/view/ViewGroup$LayoutParams;", "getOriginalParams", "()Landroid/view/ViewGroup$LayoutParams;", "setOriginalParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "originalParent", "Landroid/view/ViewGroup;", "getOriginalParent", "()Landroid/view/ViewGroup;", "setOriginalParent", "(Landroid/view/ViewGroup;)V", "pivotOffset", "getPivotOffset", "pivotOffset$delegate", "Lkotlin/Lazy;", "preview", "getPreview", "setPreview", "runAfterAnim", "Ljava/lang/Runnable;", "getRunAfterAnim", "()Ljava/lang/Runnable;", "setRunAfterAnim", "(Ljava/lang/Runnable;)V", "addPreview", "", "view", "rotation", "feedId", "", "simpleViewHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isLongVideo", "checkShowSeekBar", "onFloatBallBtnClick", "onPlayBtnClick", "newIsPlaying", "onSpeedCtrlBtnClick", "removePreview", "exitType", "finish", "Lkotlin/Function0;", "resetPreviewVideoView", "toggleCtrlViews", "forceShow", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends HorizontalVideoPreviewLayout
  {
    private ViewGroup GQF;
    private int GQG;
    private ViewGroup.LayoutParams GQH;
    private final kotlin.j GRN;
    private int GRO;
    private View GRP;
    private ag.a GRQ;
    private Runnable GRR;
    private View caK;
    boolean isAnimating;
    boolean nvB;
    
    public c()
    {
      super();
      AppMethodBeat.i(337480);
      this.GRN = kotlin.k.cm((kotlin.g.a.a)new c(this));
      getIconLayout().setOnClickListener(new ag.c..ExternalSyntheticLambda0(ag.this));
      this.GQG = -1;
      this.GRQ = new ag.a(1.0F, 0.0F, 0.0F, 0.0F);
      AppMethodBeat.o(337480);
    }
    
    private static final void a(ag paramag, View paramView)
    {
      AppMethodBeat.i(337492);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramag);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$InnerHorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramag, "this$0");
      ag.a(paramag, 0, 3);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$InnerHorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(337492);
    }
    
    private final int getPivotOffset()
    {
      AppMethodBeat.i(337485);
      int i = ((Number)this.GRN.getValue()).intValue();
      AppMethodBeat.o(337485);
      return i;
    }
    
    public final void a(View paramView1, final int paramInt, View paramView2, com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean)
    {
      AppMethodBeat.i(337596);
      s.u(paramView1, "view");
      s.u(paramj, "simpleViewHolder");
      Object localObject1 = bb.FuK;
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)ag.this.getActivity());
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
      {
        bb.a((bui)localObject1, "video_card", 2);
        getSeekTimeLayout().setVisibility(8);
        this.GRO = paramInt;
        this.nvB = true;
        this.caK = paramView2;
        this.GRP = paramView1;
        setFullSeekBar((FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout));
        localObject1 = paramView1.getParent();
        if (localObject1 != null) {
          break;
        }
        paramView1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(337596);
        throw paramView1;
      }
      this.GQF = ((ViewGroup)localObject1);
      localObject1 = this.GQF;
      if ((localObject1 instanceof FinderVideoLayout)) {
        ((FinderVideoLayout)localObject1).setEnablePlay(false);
      }
      localObject1 = this.GQF;
      if (localObject1 == null) {}
      for (int i = 0;; i = ((ViewGroup)localObject1).indexOfChild(paramView1))
      {
        this.GQG = i;
        this.GQH = new ViewGroup.LayoutParams(paramView1.getWidth(), paramView1.getHeight());
        getBgView().setAlpha(0.0F);
        localObject1 = aw.bf(getContext());
        i = paramView1.getHeight();
        float f1 = paramView1.getWidth() * 1.0F / i;
        int j = ((Point)localObject1).x;
        int k = kotlin.h.a.eH(f1 * j);
        f1 = 1.0F * j / i;
        Object localObject2 = new int[2];
        Rect localRect = new Rect();
        paramView1.getLocationInWindow((int[])localObject2);
        paramView1.getDrawingRect(localRect);
        localRect.offset(localObject2[0], localObject2[1]);
        localObject2 = this.GQF;
        if (localObject2 != null) {
          ((ViewGroup)localObject2).removeView(paramView1);
        }
        localObject2 = new FrameLayout.LayoutParams(k, j);
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        kotlin.ah localah = kotlin.ah.aiuX;
        addView(paramView1, 1, (ViewGroup.LayoutParams)localObject2);
        paramView1.setPivotX(k / 2.0F);
        paramView1.setPivotY(j / 2.0F);
        paramView1.setScaleX(1.0F / f1);
        paramView1.setScaleY(1.0F / f1);
        f1 = localRect.centerX();
        float f2 = ((Point)localObject1).x / 2.0F;
        float f3 = localRect.centerY();
        float f4 = ((Point)localObject1).y / 2.0F;
        paramView1.setTranslationX(f1 - f2);
        paramView1.setTranslationY(f3 - f4);
        this.GRQ = new ag.a(paramView1.getScaleX(), paramView1.getTranslationX(), paramView1.getTranslationY(), paramView1.getRotation());
        paramView1.animate().rotation(paramInt).translationX(0.0F).translationY(0.0F).scaleX(1.0F).scaleY(1.0F).setDuration(400L).setListener((Animator.AnimatorListener)new a(paramView2, this)).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).start();
        this.isAnimating = true;
        getIconLayout().animate().setListener(null).cancel();
        getBgView().animate().setDuration(400L).alpha(1.0F).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).start();
        getIconLayout().animate().setDuration(400L).alpha(1.0F).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).start();
        getFgView().setVisibility(8);
        paramView1 = getIconLayout().getLayoutParams();
        if (paramView1 != null) {
          break;
        }
        paramView1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(337596);
        throw paramView1;
      }
      paramView1 = (FrameLayout.LayoutParams)paramView1;
      i = bf.getStatusBarHeight((Context)ag.this.getActivity());
      if (paramInt > 0)
      {
        paramView1.setMarginEnd((int)getResources().getDimension(e.c.Edge_3A));
        paramView1.setMarginStart(0);
        paramView1.topMargin = (i + (int)getResources().getDimension(e.c.Edge_2A));
        paramView1.bottomMargin = 0;
        paramView1.gravity = 8388661;
        getIconLayout().setRotation(90.0F);
        getIconLayout().bringToFront();
        getSeekTimeLayout().setRotation(90.0F);
        paramView1 = this.GQF;
        if (!(paramView1 instanceof FinderVideoLayout)) {
          break label947;
        }
        paramView1 = (FinderVideoLayout)paramView1;
        label806:
        paramView2 = this.GRP;
        if (!(paramView2 instanceof FinderThumbPlayerProxy)) {
          break label952;
        }
      }
      label947:
      label952:
      for (paramView2 = (FinderThumbPlayerProxy)paramView2;; paramView2 = null)
      {
        if ((paramView1 != null) && (paramView2 != null))
        {
          a(paramView1, paramView2, paramj, paramBoolean);
          c(paramView2, paramInt);
          com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new b(this, paramInt));
        }
        AppMethodBeat.o(337596);
        return;
        getIconLayout().setRotation(-90.0F);
        getSeekTimeLayout().setRotation(-90.0F);
        paramView1.setMarginEnd(0);
        paramView1.setMarginStart((int)getResources().getDimension(e.c.Edge_3A));
        paramView1.topMargin = 0;
        paramView1.bottomMargin = ((int)getResources().getDimension(e.c.Edge_3A));
        paramView1.gravity = 8388691;
        getIconLayout().bringToFront();
        break;
        paramView1 = null;
        break label806;
      }
    }
    
    public final void c(final int paramInt, final kotlin.g.a.a<kotlin.ah> parama)
    {
      AppMethodBeat.i(337616);
      s.u(parama, "finish");
      this.GRO = 0;
      final View localView = this.GRP;
      if (localView != null)
      {
        final ag localag = ag.this;
        getLongVideoSeekBarLayout().animate().setListener(null).cancel();
        getIconLayout().animate().setListener(null).cancel();
        getLongVideoSeekBarLayout().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(400L).alpha(0.0F).start();
        getIconLayout().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(400L).alpha(0.0F).start();
        getBgView().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(400L).alpha(0.0F).start();
        getLongVideoSeekBarLayout().getDescTv().setMaxLines(2);
        getLongVideoSeekBarLayout().getHiddenTv().setVisibility(4);
        getFgView().setVisibility(8);
        localView.animate().cancel();
        localView.animate().rotation(getAnimInfo().rotation).translationX(getAnimInfo().ayc).translationY(getAnimInfo().ayd).scaleX(getAnimInfo().scale).scaleY(getAnimInfo().scale).setDuration(400L).setListener((Animator.AnimatorListener)new d(this, localView, parama, localag, paramInt)).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).start();
        setAnimating(true);
      }
      setFullSeekBar(null);
      AppMethodBeat.o(337616);
    }
    
    public final void flE()
    {
      AppMethodBeat.i(337602);
      List localList = p.listOf(new View[] { (View)getIconLayout(), (View)getLongVideoSeekBarLayout() });
      Object localObject1 = this.GRP;
      if ((localObject1 instanceof FinderThumbPlayerProxy)) {}
      for (localObject1 = (FinderThumbPlayerProxy)localObject1;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          Object localObject2 = ag.this;
          com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
          localObject2 = com.tencent.mm.ui.component.k.d(((ag)localObject2).getActivity()).q(av.class);
          s.s(localObject2, "UICProvider.of(activity)…edControlUIC::class.java)");
          av.a((av)localObject2, localList, (FinderThumbPlayerProxy)localObject1, this.GRO, true, null, 16);
        }
        AppMethodBeat.o(337602);
        return;
      }
    }
    
    public final ag.a getAnimInfo()
    {
      return this.GRQ;
    }
    
    public final int getIndexOriginalParent()
    {
      return this.GQG;
    }
    
    public final View getItemView()
    {
      return this.caK;
    }
    
    public final ViewGroup.LayoutParams getOriginalParams()
    {
      return this.GQH;
    }
    
    public final ViewGroup getOriginalParent()
    {
      return this.GQF;
    }
    
    public final View getPreview()
    {
      return this.GRP;
    }
    
    public final Runnable getRunAfterAnim()
    {
      return this.GRR;
    }
    
    public final void setAnimInfo(ag.a parama)
    {
      AppMethodBeat.i(337566);
      s.u(parama, "<set-?>");
      this.GRQ = parama;
      AppMethodBeat.o(337566);
    }
    
    public final void setAnimating(boolean paramBoolean)
    {
      this.isAnimating = paramBoolean;
    }
    
    public final void setIndexOriginalParent(int paramInt)
    {
      this.GQG = paramInt;
    }
    
    public final void setItemView(View paramView)
    {
      this.caK = paramView;
    }
    
    public final void setOriginalParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      this.GQH = paramLayoutParams;
    }
    
    public final void setOriginalParent(ViewGroup paramViewGroup)
    {
      this.GQF = paramViewGroup;
    }
    
    public final void setPreview(View paramView)
    {
      this.GRP = paramView;
    }
    
    public final void setPreviewing(boolean paramBoolean)
    {
      this.nvB = paramBoolean;
    }
    
    public final void setRunAfterAnim(Runnable paramRunnable)
    {
      this.GRR = paramRunnable;
    }
    
    public final void tv(boolean paramBoolean)
    {
      AppMethodBeat.i(337606);
      ag localag = ag.this;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ag.a(localag, paramBoolean);
        AppMethodBeat.o(337606);
        return;
      }
    }
    
    public final void vb(boolean paramBoolean)
    {
      AppMethodBeat.i(337610);
      if (!(this.GRP instanceof FinderThumbPlayerProxy))
      {
        AppMethodBeat.o(337610);
        return;
      }
      super.vb(paramBoolean);
      AppMethodBeat.o(337610);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$InnerHorizontalVideoPreviewLayout$addPreview$2", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends com.tencent.mm.plugin.finder.animation.a
    {
      a(View paramView, ag.c paramc) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(338587);
        s.u(paramAnimator, "animation");
        paramAnimator = this.mkO;
        if (paramAnimator == null) {}
        for (paramAnimator = null;; paramAnimator = paramAnimator.findViewById(e.e.avatar_iv))
        {
          if (paramAnimator != null) {
            paramAnimator.setVisibility(4);
          }
          jdField_this.setAnimating(false);
          com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new a(jdField_this));
          AppMethodBeat.o(338587);
          return;
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<kotlin.ah>
      {
        a(ag.c paramc)
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<kotlin.ah>
    {
      b(ag.c paramc, int paramInt)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<Integer>
    {
      c(ag.c paramc)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$InnerHorizontalVideoPreviewLayout$removePreview$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      extends com.tencent.mm.plugin.finder.animation.a
    {
      d(ag.c paramc, View paramView, kotlin.g.a.a<kotlin.ah> parama, ag paramag, int paramInt) {}
      
      private static final void a(ag.c paramc, kotlin.g.a.a parama, ag paramag, int paramInt)
      {
        AppMethodBeat.i(338644);
        s.u(paramc, "this$0");
        s.u(parama, "$finish");
        s.u(paramag, "this$1");
        ag.c.a(paramc);
        parama.invoke();
        parama = bb.FuK;
        parama = as.GSQ;
        parama = as.a.hu((Context)paramag.getActivity());
        if (parama == null)
        {
          parama = null;
          if (paramInt != 0) {
            break label117;
          }
          paramag = "transpose_video_card";
          label66:
          if (paramInt != 0) {
            break label123;
          }
        }
        label117:
        label123:
        for (paramInt = 3;; paramInt = 1)
        {
          bb.a(parama, paramag, paramInt);
          paramc.setPreviewing(false);
          paramc.setAnimating(false);
          com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new a(paramc));
          AppMethodBeat.o(338644);
          return;
          parama = parama.fou();
          break;
          paramag = "transpose_video_card_exitArrow";
          break label66;
        }
      }
      
      private static final void b(ag.c paramc)
      {
        AppMethodBeat.i(338634);
        s.u(paramc, "this$0");
        paramc = paramc.getItemView();
        if (paramc == null) {}
        for (paramc = null;; paramc = paramc.findViewById(e.e.avatar_iv))
        {
          if (paramc != null) {
            paramc.setVisibility(0);
          }
          AppMethodBeat.o(338634);
          return;
        }
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(338664);
        s.u(paramAnimator, "animation");
        localView.post(new ag.c.d..ExternalSyntheticLambda1(this.GRT, parama, localag, paramInt));
        AppMethodBeat.o(338664);
      }
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(338658);
        super.onAnimationStart(paramAnimator);
        this.GRT.post(new ag.c.d..ExternalSyntheticLambda0(this.GRT));
        AppMethodBeat.o(338658);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<kotlin.ah>
      {
        a(ag.c paramc)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(ag paramag, int paramInt, FinderMediaBanner paramFinderMediaBanner, kotlin.g.a.a<kotlin.ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    e(ag paramag, int paramInt, FinderMediaBanner paramFinderMediaBanner, kotlin.g.a.a<kotlin.ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$InnerHorizontalVideoPreviewLayout;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ag.c>
  {
    f(ag paramag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ag
 * JD-Core Version:    0.7.0.1
 */