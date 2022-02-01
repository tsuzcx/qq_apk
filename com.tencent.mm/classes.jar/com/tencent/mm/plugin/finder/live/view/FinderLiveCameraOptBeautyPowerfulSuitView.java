package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.utils.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/Animator;", "onModeSwitch", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuitMode", "", "getOnModeSwitch", "()Lkotlin/jvm/functions/Function1;", "setOnModeSwitch", "(Lkotlin/jvm/functions/Function1;)V", "onSuitSwitch", "suit", "getOnSuitSwitch", "setOnSuitSwitch", "value", "getSuit", "()I", "setSuit", "(I)V", "suitMode", "getSuitMode", "()Z", "setSuitMode", "(Z)V", "executeMakeSureNumberColor", "onDetachedFromWindow", "switchModeByUser", "mode", "switchSuitByUser", "suitSelect", "Companion", "plugin-finder_release"})
public final class FinderLiveCameraOptBeautyPowerfulSuitView
  extends RelativeLayout
{
  public static final FinderLiveCameraOptBeautyPowerfulSuitView.a yTs;
  private Animator VU;
  private HashMap _$_findViewCache;
  private kotlin.g.a.b<? super Boolean, x> yTo;
  private kotlin.g.a.b<? super Integer, x> yTp;
  private int yTq;
  private boolean yTr;
  
  static
  {
    AppMethodBeat.i(284456);
    yTs = new FinderLiveCameraOptBeautyPowerfulSuitView.a((byte)0);
    AppMethodBeat.o(284456);
  }
  
  public FinderLiveCameraOptBeautyPowerfulSuitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public FinderLiveCameraOptBeautyPowerfulSuitView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(284454);
    this.yTq = -1000;
    this.yTr = true;
    View.inflate(paramContext, b.g.finder_live_beauty_powerful_panel_suit_view, (ViewGroup)this);
    paramContext = (LinearLayout)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_go_to_details_1);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(274888);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FinderLiveCameraOptBeautyPowerfulSuitView.b(this.yTt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(274888);
        }
      });
    }
    paramContext = (LinearLayout)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_go_to_details_2);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(279373);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FinderLiveCameraOptBeautyPowerfulSuitView.b(this.yTt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279373);
        }
      });
    }
    paramContext = (LinearLayout)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_go_to_details_3);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(290547);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FinderLiveCameraOptBeautyPowerfulSuitView.b(this.yTt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(290547);
        }
      });
    }
    paramContext = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group_bg_1);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(285504);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FinderLiveCameraOptBeautyPowerfulSuitView.a(this.yTt, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(285504);
        }
      });
    }
    paramContext = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group_bg_2);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(271138);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FinderLiveCameraOptBeautyPowerfulSuitView.a(this.yTt, 1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(271138);
        }
      });
    }
    paramContext = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group_bg_3);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(256488);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FinderLiveCameraOptBeautyPowerfulSuitView.a(this.yTt, 2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(256488);
        }
      });
    }
    paramContext = (RelativeLayout)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_1);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(228428);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!this.yTt.getSuitMode()) {
            FinderLiveCameraOptBeautyPowerfulSuitView.a(this.yTt, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(228428);
        }
      });
    }
    paramContext = (RelativeLayout)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_2);
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(265516);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!this.yTt.getSuitMode()) {
            FinderLiveCameraOptBeautyPowerfulSuitView.a(this.yTt, 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(265516);
        }
      });
    }
    paramContext = (RelativeLayout)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_3);
    if (paramContext != null)
    {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276627);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!this.yTt.getSuitMode()) {
            FinderLiveCameraOptBeautyPowerfulSuitView.a(this.yTt, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276627);
        }
      });
      AppMethodBeat.o(284454);
      return;
    }
    AppMethodBeat.o(284454);
  }
  
  private final void dEY()
  {
    int m = 1;
    AppMethodBeat.i(284452);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = ((Context)localObject).getResources();
    int i;
    int j;
    label78:
    int k;
    if (this.yTr)
    {
      i = b.c.hot_tab_BW_100_Alpha_0_8;
      i = ((Resources)localObject).getColor(i);
      localObject = getContext();
      p.j(localObject, "context");
      localObject = ((Context)localObject).getResources();
      if (!this.yTr) {
        break label338;
      }
      j = b.c.finder_live_black_Alpha_80;
      j = ((Resources)localObject).getColor(j);
      localObject = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_1);
      if (this.yTq != 0) {
        break label345;
      }
      k = j;
      label106:
      ((TextView)localObject).setTextColor(k);
      localObject = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_2);
      if (this.yTq != 1) {
        break label350;
      }
      k = j;
      label134:
      ((TextView)localObject).setTextColor(k);
      localObject = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_3);
      if (this.yTq != 2) {
        break label355;
      }
      label160:
      ((TextView)localObject).setTextColor(j);
      if (this.yTr) {
        break label375;
      }
      localObject = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_1);
      Typeface localTypeface;
      if (localObject != null)
      {
        localTypeface = ((TextView)localObject).getTypeface();
        if (this.yTq != 0) {
          break label360;
        }
        i = 1;
        label206:
        ((TextView)localObject).setTypeface(localTypeface, i);
      }
      localObject = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_2);
      if (localObject != null)
      {
        localTypeface = ((TextView)localObject).getTypeface();
        if (this.yTq != 1) {
          break label365;
        }
        i = 1;
        label248:
        ((TextView)localObject).setTypeface(localTypeface, i);
      }
      localObject = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_3);
      if (localObject != null)
      {
        localTypeface = ((TextView)localObject).getTypeface();
        if (this.yTq != 2) {
          break label370;
        }
        i = m;
        label291:
        ((TextView)localObject).setTypeface(localTypeface, i);
      }
    }
    for (;;)
    {
      localObject = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_1);
      p.j(localObject, "finder_live_camera_opt_p…_beauty_powerful_number_1");
      f.i((TextView)localObject);
      AppMethodBeat.o(284452);
      return;
      i = b.c.hot_tab_BW_100_Alpha_0_3;
      break;
      label338:
      j = b.c.hot_tab_BW_100_Alpha_0_9;
      break label78;
      label345:
      k = i;
      break label106;
      label350:
      k = i;
      break label134;
      label355:
      j = i;
      break label160;
      label360:
      i = 0;
      break label206;
      label365:
      i = 0;
      break label248;
      label370:
      i = 0;
      break label291;
      label375:
      localObject = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_1);
      p.j(localObject, "finder_live_camera_opt_p…_beauty_powerful_number_1");
      f.t((TextView)localObject);
      localObject = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_2);
      p.j(localObject, "finder_live_camera_opt_p…_beauty_powerful_number_2");
      f.t((TextView)localObject);
      localObject = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_3);
      p.j(localObject, "finder_live_camera_opt_p…_beauty_powerful_number_3");
      f.t((TextView)localObject);
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(284459);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(284459);
    return localView1;
  }
  
  public final kotlin.g.a.b<Boolean, x> getOnModeSwitch()
  {
    return this.yTo;
  }
  
  public final kotlin.g.a.b<Integer, x> getOnSuitSwitch()
  {
    return this.yTp;
  }
  
  public final int getSuit()
  {
    return this.yTq;
  }
  
  public final boolean getSuitMode()
  {
    return this.yTr;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(284453);
    super.onDetachedFromWindow();
    Animator localAnimator = this.VU;
    if (localAnimator != null)
    {
      localAnimator.cancel();
      AppMethodBeat.o(284453);
      return;
    }
    AppMethodBeat.o(284453);
  }
  
  public final void setOnModeSwitch(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.yTo = paramb;
  }
  
  public final void setOnSuitSwitch(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.yTp = paramb;
  }
  
  public final void setSuit(int paramInt)
  {
    AppMethodBeat.i(284450);
    Object localObject2 = new StringBuilder("#suit set value=").append(paramInt).append(' ').append("field=").append(this.yTq).append(' ').append("isAnimatorRunning=");
    Object localObject1 = this.VU;
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((Animator)localObject1).isRunning());; localObject1 = null)
    {
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulSuitView", localObject1);
      if (paramInt == this.yTq) {
        break;
      }
      localObject1 = this.VU;
      if ((localObject1 == null) || (((Animator)localObject1).isRunning() != true)) {
        break label126;
      }
      AppMethodBeat.o(284450);
      return;
    }
    AppMethodBeat.o(284450);
    return;
    label126:
    this.yTq = paramInt;
    paramInt = b.e.selector_finder_live_camera_opt_panel_beauty_powerful_number_circle_bg_normal;
    int i = b.e.selector_finder_live_camera_opt_panel_beauty_powerful_number_circle_bg_select;
    localObject1 = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_none_tips);
    p.j(localObject1, "finder_live_camera_opt_p…beauty_powerful_none_tips");
    ((TextView)localObject1).setVisibility(4);
    localObject1 = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_1_line);
    p.j(localObject1, "finder_live_camera_opt_p…_powerful_area_top_1_line");
    ((View)localObject1).setVisibility(4);
    localObject1 = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_2_line);
    p.j(localObject1, "finder_live_camera_opt_p…_powerful_area_top_2_line");
    ((View)localObject1).setVisibility(4);
    localObject1 = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_3_line);
    p.j(localObject1, "finder_live_camera_opt_p…_powerful_area_top_3_line");
    ((View)localObject1).setVisibility(4);
    _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group_bg_1).setBackgroundResource(paramInt);
    _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group_bg_2).setBackgroundResource(paramInt);
    _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group_bg_3).setBackgroundResource(paramInt);
    localObject1 = (LinearLayout)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_go_to_details_1);
    p.j(localObject1, "finder_live_camera_opt_p…_powerful_go_to_details_1");
    ((LinearLayout)localObject1).setVisibility(4);
    localObject1 = (LinearLayout)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_go_to_details_2);
    p.j(localObject1, "finder_live_camera_opt_p…_powerful_go_to_details_2");
    ((LinearLayout)localObject1).setVisibility(4);
    localObject1 = (LinearLayout)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_go_to_details_3);
    p.j(localObject1, "finder_live_camera_opt_p…_powerful_go_to_details_3");
    ((LinearLayout)localObject1).setVisibility(4);
    View localView;
    switch (this.yTq)
    {
    default: 
      localObject1 = null;
      localObject2 = null;
      localView = null;
      if (this.yTq == -1)
      {
        localObject1 = (TextView)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_none_tips);
        p.j(localObject1, "finder_live_camera_opt_p…beauty_powerful_none_tips");
        ((TextView)localObject1).setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      dEY();
      AppMethodBeat.o(284450);
      return;
      localView = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_1_line);
      localObject2 = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group_bg_1);
      localObject1 = (View)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_go_to_details_1);
      break;
      localView = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_2_line);
      localObject2 = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group_bg_2);
      localObject1 = (View)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_go_to_details_2);
      break;
      localView = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_3_line);
      localObject2 = _$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group_bg_3);
      localObject1 = (View)_$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_go_to_details_3);
      break;
      if (localView != null) {
        localView.setVisibility(0);
      }
      if (localObject2 != null) {
        ((View)localObject2).setBackgroundResource(i);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
  }
  
  public final void setSuitMode(boolean paramBoolean)
  {
    int j = 24;
    AppMethodBeat.i(284451);
    Object localObject2 = new StringBuilder("#mode set value=").append(paramBoolean).append(' ').append("field=").append(this.yTr).append(' ').append("isAnimatorRunning=");
    Object localObject1 = this.VU;
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((Animator)localObject1).isRunning());; localObject1 = null)
    {
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulSuitView", localObject1);
      if (paramBoolean == this.yTr) {
        break;
      }
      localObject1 = this.VU;
      if ((localObject1 == null) || (((Animator)localObject1).isRunning() != true)) {
        break label138;
      }
      AppMethodBeat.o(284451);
      return;
    }
    AppMethodBeat.o(284451);
    return;
    label138:
    this.yTr = paramBoolean;
    localObject1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    final int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 11);
    localObject2 = new b(com.tencent.mm.ci.a.fromDPToPix(getContext(), 95), com.tencent.mm.ci.a.fromDPToPix(getContext(), 67), i, this);
    ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new f((b)localObject2));
    ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new g((b)localObject2));
    ((ValueAnimator)localObject1).setDuration(200L);
    localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    Object localObject3 = new h(this);
    ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i((h)localObject3, this));
    ((ValueAnimator)localObject2).addListener((Animator.AnimatorListener)new j((h)localObject3, this));
    ((ValueAnimator)localObject2).setDuration(200L);
    localObject3 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    Object localObject4 = getContext();
    final int k;
    if (this.yTr)
    {
      i = 17;
      k = com.tencent.mm.ci.a.fromDPToPix((Context)localObject4, i);
      localObject4 = getContext();
      if (!this.yTr) {
        break label579;
      }
    }
    label579:
    for (i = j;; i = 17)
    {
      i = com.tencent.mm.ci.a.fromDPToPix((Context)localObject4, i);
      localObject4 = new k(this);
      ((ValueAnimator)localObject3).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new l((k)localObject4, k, i));
      ((ValueAnimator)localObject3).addListener((Animator.AnimatorListener)new m((k)localObject4, k, i));
      ((ValueAnimator)localObject3).setDuration(200L);
      localObject4 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      Object localObject5 = new c(this);
      ((ValueAnimator)localObject4).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new d((c)localObject5, this));
      ((ValueAnimator)localObject4).addListener((Animator.AnimatorListener)new e((c)localObject5, this));
      ((ValueAnimator)localObject4).setDuration(200L);
      localObject5 = new AnimatorSet();
      ((AnimatorSet)localObject5).play((Animator)localObject1).with((Animator)localObject2).with((Animator)localObject3).with((Animator)localObject4);
      ((AnimatorSet)localObject5).start();
      this.VU = ((Animator)localObject5);
      dEY();
      AppMethodBeat.o(284451);
      return;
      i = 24;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"execute", "", "progress", "", "invoke", "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepOne$1$1"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Float, x>
  {
    b(int paramInt1, int paramInt2, int paramInt3, FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView)
    {
      super();
    }
    
    public final void bh(float paramFloat)
    {
      AppMethodBeat.i(281418);
      int i;
      if (FinderLiveCameraOptBeautyPowerfulSuitView.a(jdField_this)) {
        i = kotlin.h.a.dm(this.yTu * paramFloat);
      }
      for (int j = kotlin.h.a.dm(this.yTv * paramFloat);; j = kotlin.h.a.dm(this.yTv * (1.0F - paramFloat)))
      {
        j += i;
        localObject = (TextView)jdField_this._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_1);
        p.j(localObject, "finder_live_camera_opt_p…_beauty_powerful_number_1");
        localObject = ((TextView)localObject).getLayoutParams();
        if (localObject != null) {
          break;
        }
        localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(281418);
        throw ((Throwable)localObject);
        i = kotlin.h.a.dm(this.yTu * (1.0F - paramFloat));
      }
      Object localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = j;
      TextView localTextView = (TextView)jdField_this._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_1);
      p.j(localTextView, "finder_live_camera_opt_p…_beauty_powerful_number_1");
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (TextView)jdField_this._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_2);
      p.j(localObject, "finder_live_camera_opt_p…_beauty_powerful_number_2");
      localObject = ((TextView)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(281418);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      localTextView = (TextView)jdField_this._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_2);
      p.j(localTextView, "finder_live_camera_opt_p…_beauty_powerful_number_2");
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (TextView)jdField_this._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_3);
      p.j(localObject, "finder_live_camera_opt_p…_beauty_powerful_number_3");
      localObject = ((TextView)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(281418);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = j;
      localTextView = (TextView)jdField_this._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_3);
      p.j(localTextView, "finder_live_camera_opt_p…_beauty_powerful_number_3");
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(281418);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"execute", "", "progress", "", "invoke", "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepFour$1$1"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Float, x>
  {
    c(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView)
    {
      super();
    }
    
    public final void bh(float paramFloat)
    {
      AppMethodBeat.i(291713);
      Object localObject = (TextView)this.yTt._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_title);
      p.j(localObject, "finder_live_camera_opt_panel_beauty_powerful_title");
      ((TextView)localObject).setAlpha(paramFloat);
      localObject = (RelativeLayout)this.yTt._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_1);
      p.j(localObject, "finder_live_camera_opt_p…eauty_powerful_area_top_1");
      ((RelativeLayout)localObject).setAlpha(1.0F - paramFloat);
      localObject = (RelativeLayout)this.yTt._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_2);
      p.j(localObject, "finder_live_camera_opt_p…eauty_powerful_area_top_2");
      ((RelativeLayout)localObject).setAlpha(1.0F - paramFloat);
      localObject = (RelativeLayout)this.yTt._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_area_top_3);
      p.j(localObject, "finder_live_camera_opt_p…eauty_powerful_area_top_3");
      ((RelativeLayout)localObject).setAlpha(1.0F - paramFloat);
      AppMethodBeat.o(291713);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepFour$1$2"})
  static final class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d(FinderLiveCameraOptBeautyPowerfulSuitView.c paramc, FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(270284);
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(270284);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      if (FinderLiveCameraOptBeautyPowerfulSuitView.a(jdField_this)) {}
      for (;;)
      {
        this.yTx.bh(f);
        AppMethodBeat.o(270284);
        return;
        f = 1.0F - f;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepFour$1$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(FinderLiveCameraOptBeautyPowerfulSuitView.c paramc, FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(278354);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.yTx;
      if (FinderLiveCameraOptBeautyPowerfulSuitView.a(jdField_this)) {}
      for (float f = 1.0F;; f = 0.0F)
      {
        paramAnimator.bh(f);
        AppMethodBeat.o(278354);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepOne$1$2"})
  static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(FinderLiveCameraOptBeautyPowerfulSuitView.b paramb) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(284971);
      FinderLiveCameraOptBeautyPowerfulSuitView.b localb = this.yTy;
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(284971);
        throw paramValueAnimator;
      }
      localb.bh(((Float)paramValueAnimator).floatValue());
      AppMethodBeat.o(284971);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepOne$1$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class g
    extends AnimatorListenerAdapter
  {
    g(FinderLiveCameraOptBeautyPowerfulSuitView.b paramb) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(271723);
      super.onAnimationEnd(paramAnimator);
      this.yTy.bh(1.0F);
      AppMethodBeat.o(271723);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"execute", "", "progress", "", "invoke", "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepTwo$1$1"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Float, x>
  {
    h(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView)
    {
      super();
    }
    
    public final void bh(float paramFloat)
    {
      AppMethodBeat.i(255112);
      LinearLayout localLinearLayout = (LinearLayout)this.yTt._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group);
      p.j(localLinearLayout, "finder_live_camera_opt_panel_beauty_powerful_group");
      localLinearLayout.setAlpha(paramFloat);
      AppMethodBeat.o(255112);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepTwo$1$2"})
  static final class i
    implements ValueAnimator.AnimatorUpdateListener
  {
    i(FinderLiveCameraOptBeautyPowerfulSuitView.h paramh, FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(225335);
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(225335);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      if (FinderLiveCameraOptBeautyPowerfulSuitView.a(jdField_this)) {}
      for (;;)
      {
        this.yTz.bh(f);
        AppMethodBeat.o(225335);
        return;
        f = 1.0F - f;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepTwo$1$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class j
    extends AnimatorListenerAdapter
  {
    j(FinderLiveCameraOptBeautyPowerfulSuitView.h paramh, FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(266014);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.yTz;
      float f;
      if (FinderLiveCameraOptBeautyPowerfulSuitView.a(jdField_this))
      {
        f = 1.0F;
        paramAnimator.bh(f);
        paramAnimator = (LinearLayout)jdField_this._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_group);
        p.j(paramAnimator, "finder_live_camera_opt_panel_beauty_powerful_group");
        if (!FinderLiveCameraOptBeautyPowerfulSuitView.a(jdField_this)) {
          break label80;
        }
      }
      label80:
      for (int i = 0;; i = 8)
      {
        paramAnimator.setVisibility(i);
        AppMethodBeat.o(266014);
        return;
        f = 0.0F;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"execute", "", "from", "", "to", "progress", "", "invoke", "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepThree$1$1"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, Integer, Float, x>
  {
    k(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView)
    {
      super();
    }
    
    public final void e(int paramInt1, int paramInt2, float paramFloat)
    {
      AppMethodBeat.i(276838);
      float f = paramInt2 - paramInt1;
      paramFloat = paramInt1 + f * paramFloat;
      ((TextView)this.yTt._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_1)).setTextSize(0, paramFloat);
      ((TextView)this.yTt._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_2)).setTextSize(0, paramFloat);
      ((TextView)this.yTt._$_findCachedViewById(b.f.finder_live_camera_opt_panel_beauty_powerful_number_3)).setTextSize(0, paramFloat);
      AppMethodBeat.o(276838);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepThree$1$2"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(FinderLiveCameraOptBeautyPowerfulSuitView.k paramk, int paramInt1, int paramInt2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(288094);
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(288094);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      this.yTA.e(k, i, f);
      AppMethodBeat.o(288094);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepThree$1$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class m
    extends AnimatorListenerAdapter
  {
    m(FinderLiveCameraOptBeautyPowerfulSuitView.k paramk, int paramInt1, int paramInt2) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(290827);
      super.onAnimationEnd(paramAnimator);
      this.yTA.e(k, i, 1.0F);
      AppMethodBeat.o(290827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCameraOptBeautyPowerfulSuitView
 * JD-Core Version:    0.7.0.1
 */