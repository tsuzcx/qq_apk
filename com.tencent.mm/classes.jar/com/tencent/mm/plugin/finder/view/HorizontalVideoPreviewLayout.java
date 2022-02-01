package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.loader.v;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar.b;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "currentTimeTv", "Landroid/widget/TextView;", "getCurrentTimeTv", "()Landroid/widget/TextView;", "currentTimeTv$delegate", "Lkotlin/Lazy;", "downX", "downY", "fgView", "getFgView", "fullSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "getFullSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "setFullSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;)V", "hasStartTrackMove", "", "iconLayout", "getIconLayout", "()Landroid/widget/FrameLayout;", "longVideoSeekBarLayout", "Lcom/tencent/mm/plugin/finder/view/HorizontalVideoSeekBarLayout;", "getLongVideoSeekBarLayout", "()Lcom/tencent/mm/plugin/finder/view/HorizontalVideoSeekBarLayout;", "longVideoSeekBarLayout$delegate", "moveTime", "realScreenHeight", "getRealScreenHeight", "()I", "realScreenWidth", "getRealScreenWidth", "seekTimeLayout", "getSeekTimeLayout", "seekTimeLayout$delegate", "startTime", "totalTimeTv", "getTotalTimeTv", "totalTimeTv$delegate", "touchSlop", "getTouchSlop", "touchSlop$delegate", "attachSeekBar", "", "originVideoLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "videoView", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "simpleViewHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isLongVideo", "attachTouchListener", "rotation", "detachSeekBar", "makeTimeString", "", "d", "onFloatBallBtnClick", "onPlayBtnClick", "newIsPlaying", "onSpeedCtrlBtnClick", "setCurrentTime", "time", "toggleCtrlViews", "forceShow", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class HorizontalVideoPreviewLayout
  extends FrameLayout
{
  public static final HorizontalVideoPreviewLayout.a GED = new HorizontalVideoPreviewLayout.a((byte)0);
  private final View AhP;
  private boolean Fmh;
  private final kotlin.j Fmi;
  private int Fmj;
  private final View GEE;
  private final FrameLayout GEF;
  private final kotlin.j GEG;
  private final int GEH;
  private final int GEI;
  private final kotlin.j GEJ;
  private final kotlin.j GEK;
  private FinderFullSeekBarLayout GEL;
  private final kotlin.j GmS;
  private int qjs;
  private int qjt;
  private int startTime;
  
  public HorizontalVideoPreviewLayout(Context paramContext)
  {
    super(paramContext);
    paramContext = new View(getContext());
    paramContext.setBackgroundColor(-16777216);
    Object localObject = ah.aiuX;
    this.AhP = paramContext;
    paramContext = new View(getContext());
    paramContext.setVisibility(8);
    paramContext.setBackgroundColor(paramContext.getResources().getColor(e.b.hot_tab_BW_0_Alpha_0_5));
    localObject = ah.aiuX;
    this.GEE = paramContext;
    this.GEF = new FrameLayout(getContext());
    this.GEG = k.cm((kotlin.g.a.a)new h(this));
    this.GEJ = k.cm((kotlin.g.a.a)new i(this));
    this.GmS = k.cm((kotlin.g.a.a)new g(this));
    this.GEK = k.cm((kotlin.g.a.a)new j(this));
    setId(e.e.finder_horizontal_preview_layout);
    addView(this.AhP, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView(this.GEE, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    int i = (int)getResources().getDimension(e.c.Edge_3A);
    int j = (int)getResources().getDimension(e.c.Edge_3_5_A);
    getIconLayout().setPivotX(j / 2.0F);
    getIconLayout().setPivotY(j / 2.0F);
    paramContext = new WeImageView(getContext());
    paramContext.setImageResource(e.g.icons_filled_back2);
    paramContext.setIconColor(-1);
    this.GEF.addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = (View)this.GEF;
    localObject = new FrameLayout.LayoutParams(j, j);
    ((FrameLayout.LayoutParams)localObject).setMarginEnd(i);
    ((FrameLayout.LayoutParams)localObject).bottomMargin = i;
    ((FrameLayout.LayoutParams)localObject).gravity = 8388661;
    ah localah = ah.aiuX;
    addView(paramContext, (ViewGroup.LayoutParams)localObject);
    setOnClickListener(new HorizontalVideoPreviewLayout..ExternalSyntheticLambda2(this));
    paramContext = bf.bf(getContext());
    this.GEH = Math.max(paramContext.x, paramContext.y);
    this.GEI = Math.min(paramContext.x, paramContext.y);
    getLongVideoSeekBarLayout().setVisibility(4);
    paramContext = (View)getLongVideoSeekBarLayout();
    localObject = new FrameLayout.LayoutParams(this.GEH, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 8388611;
    localah = ah.aiuX;
    addView(paramContext, (ViewGroup.LayoutParams)localObject);
    paramContext = getSeekTimeLayout();
    localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    localah = ah.aiuX;
    addView(paramContext, (ViewGroup.LayoutParams)localObject);
    getSeekTimeLayout().setVisibility(8);
    this.Fmi = k.cm((kotlin.g.a.a)new k(this));
  }
  
  public HorizontalVideoPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new View(getContext());
    paramContext.setBackgroundColor(-16777216);
    paramAttributeSet = ah.aiuX;
    this.AhP = paramContext;
    paramContext = new View(getContext());
    paramContext.setVisibility(8);
    paramContext.setBackgroundColor(paramContext.getResources().getColor(e.b.hot_tab_BW_0_Alpha_0_5));
    paramAttributeSet = ah.aiuX;
    this.GEE = paramContext;
    this.GEF = new FrameLayout(getContext());
    this.GEG = k.cm((kotlin.g.a.a)new h(this));
    this.GEJ = k.cm((kotlin.g.a.a)new i(this));
    this.GmS = k.cm((kotlin.g.a.a)new g(this));
    this.GEK = k.cm((kotlin.g.a.a)new j(this));
    setId(e.e.finder_horizontal_preview_layout);
    addView(this.AhP, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView(this.GEE, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    int i = (int)getResources().getDimension(e.c.Edge_3A);
    int j = (int)getResources().getDimension(e.c.Edge_3_5_A);
    getIconLayout().setPivotX(j / 2.0F);
    getIconLayout().setPivotY(j / 2.0F);
    paramContext = new WeImageView(getContext());
    paramContext.setImageResource(e.g.icons_filled_back2);
    paramContext.setIconColor(-1);
    this.GEF.addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = (View)this.GEF;
    paramAttributeSet = new FrameLayout.LayoutParams(j, j);
    paramAttributeSet.setMarginEnd(i);
    paramAttributeSet.bottomMargin = i;
    paramAttributeSet.gravity = 8388661;
    ah localah = ah.aiuX;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    setOnClickListener(new HorizontalVideoPreviewLayout..ExternalSyntheticLambda2(this));
    paramContext = bf.bf(getContext());
    this.GEH = Math.max(paramContext.x, paramContext.y);
    this.GEI = Math.min(paramContext.x, paramContext.y);
    getLongVideoSeekBarLayout().setVisibility(4);
    paramContext = (View)getLongVideoSeekBarLayout();
    paramAttributeSet = new FrameLayout.LayoutParams(this.GEH, -2);
    paramAttributeSet.gravity = 8388611;
    localah = ah.aiuX;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = getSeekTimeLayout();
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    localah = ah.aiuX;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    getSeekTimeLayout().setVisibility(8);
    this.Fmi = k.cm((kotlin.g.a.a)new k(this));
  }
  
  public HorizontalVideoPreviewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new View(getContext());
    paramContext.setBackgroundColor(-16777216);
    paramAttributeSet = ah.aiuX;
    this.AhP = paramContext;
    paramContext = new View(getContext());
    paramContext.setVisibility(8);
    paramContext.setBackgroundColor(paramContext.getResources().getColor(e.b.hot_tab_BW_0_Alpha_0_5));
    paramAttributeSet = ah.aiuX;
    this.GEE = paramContext;
    this.GEF = new FrameLayout(getContext());
    this.GEG = k.cm((kotlin.g.a.a)new h(this));
    this.GEJ = k.cm((kotlin.g.a.a)new i(this));
    this.GmS = k.cm((kotlin.g.a.a)new g(this));
    this.GEK = k.cm((kotlin.g.a.a)new j(this));
    setId(e.e.finder_horizontal_preview_layout);
    addView(this.AhP, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView(this.GEE, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramInt = (int)getResources().getDimension(e.c.Edge_3A);
    int i = (int)getResources().getDimension(e.c.Edge_3_5_A);
    getIconLayout().setPivotX(i / 2.0F);
    getIconLayout().setPivotY(i / 2.0F);
    paramContext = new WeImageView(getContext());
    paramContext.setImageResource(e.g.icons_filled_back2);
    paramContext.setIconColor(-1);
    this.GEF.addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = (View)this.GEF;
    paramAttributeSet = new FrameLayout.LayoutParams(i, i);
    paramAttributeSet.setMarginEnd(paramInt);
    paramAttributeSet.bottomMargin = paramInt;
    paramAttributeSet.gravity = 8388661;
    ah localah = ah.aiuX;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    setOnClickListener(new HorizontalVideoPreviewLayout..ExternalSyntheticLambda2(this));
    paramContext = bf.bf(getContext());
    this.GEH = Math.max(paramContext.x, paramContext.y);
    this.GEI = Math.min(paramContext.x, paramContext.y);
    getLongVideoSeekBarLayout().setVisibility(4);
    paramContext = (View)getLongVideoSeekBarLayout();
    paramAttributeSet = new FrameLayout.LayoutParams(this.GEH, -2);
    paramAttributeSet.gravity = 8388611;
    localah = ah.aiuX;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = getSeekTimeLayout();
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    localah = ah.aiuX;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    getSeekTimeLayout().setVisibility(8);
    this.Fmi = k.cm((kotlin.g.a.a)new k(this));
  }
  
  private static String Bf(int paramInt)
  {
    if (paramInt < 10) {
      return s.X("0", Integer.valueOf(paramInt));
    }
    return String.valueOf(paramInt);
  }
  
  private static final void a(TextView paramTextView, HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextView);
    localb.cH(paramHorizontalVideoPreviewLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextView, "$tv");
    s.u(paramHorizontalVideoPreviewLayout, "this$0");
    int i = paramTextView.getLineCount();
    if ((paramTextView.getVisibility() == 0) && (i > 0))
    {
      paramView = paramTextView.getLayout();
      if (paramView != null) {
        break label230;
      }
      i = 0;
      if (i > 0)
      {
        paramView = paramHorizontalVideoPreviewLayout.getLongVideoSeekBarLayout().getHiddenTv();
        paramView.setVisibility(0);
        paramView.scrollTo(0, 0);
        paramTextView.setVisibility(4);
        paramHorizontalVideoPreviewLayout.getFgView().setVisibility(0);
        paramTextView = bb.FuK;
        paramTextView = as.GSQ;
        paramTextView = paramHorizontalVideoPreviewLayout.getContext();
        s.s(paramTextView, "context");
        paramTextView = as.a.hu(paramTextView);
        if (paramTextView != null) {
          break label241;
        }
      }
    }
    label230:
    label241:
    for (paramTextView = null;; paramTextView = paramTextView.fou())
    {
      bb.a(paramTextView, "transpose_video_card_caption", 1);
      paramTextView = new f(paramHorizontalVideoPreviewLayout);
      paramHorizontalVideoPreviewLayout.getFgView().setOnClickListener((View.OnClickListener)paramTextView);
      paramHorizontalVideoPreviewLayout.getLongVideoSeekBarLayout().getHiddenTv().setOnClickListener((View.OnClickListener)paramTextView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      i = paramView.getEllipsisCount(i - 1);
      break;
    }
  }
  
  private static final void a(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderThumbPlayerProxy paramFinderThumbPlayerProxy, HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout, FinderVideoLayout paramFinderVideoLayout, View paramView)
  {
    boolean bool2 = true;
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLongVideoPlayerSeekBar);
    localb.cH(paramFinderThumbPlayerProxy);
    localb.cH(paramHorizontalVideoPreviewLayout);
    localb.cH(paramFinderVideoLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLongVideoPlayerSeekBar, "$it");
    s.u(paramFinderThumbPlayerProxy, "$videoView");
    s.u(paramHorizontalVideoPreviewLayout, "this$0");
    s.u(paramFinderVideoLayout, "$originVideoLayout");
    boolean bool3 = paramFinderLongVideoPlayerSeekBar.dxE();
    if (!bool3)
    {
      bool1 = true;
      paramFinderThumbPlayerProxy.setVideoViewFocused(bool1);
      if (!bool3) {
        break label256;
      }
      paramView = paramHorizontalVideoPreviewLayout.getFullSeekBar();
      if (paramView != null) {
        paramView.fiH();
      }
      paramFinderThumbPlayerProxy.pause();
      label148:
      if (bool3) {
        break label288;
      }
      bool1 = true;
      label156:
      paramHorizontalVideoPreviewLayout.tv(bool1);
      if (bool3) {
        break label294;
      }
    }
    label256:
    label288:
    label294:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramFinderLongVideoPlayerSeekBar.setIsPlay(bool1);
      if (bool3)
      {
        paramFinderLongVideoPlayerSeekBar = paramFinderVideoLayout.getPlayInfo();
        if (paramFinderLongVideoPlayerSeekBar != null)
        {
          paramFinderThumbPlayerProxy = paramFinderVideoLayout.getVideoPlayBehavior();
          if (paramFinderThumbPlayerProxy != null) {
            paramFinderThumbPlayerProxy.a(paramFinderLongVideoPlayerSeekBar.feed.getExpectId(), paramFinderLongVideoPlayerSeekBar.EEv.ExE, (x)paramFinderLongVideoPlayerSeekBar.EEv);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      bool1 = false;
      break;
      paramFinderVideoLayout.setSelectedToPlay(true);
      paramView = paramHorizontalVideoPreviewLayout.getFullSeekBar();
      if (paramView != null) {
        paramView.aCk("HorizontalClick");
      }
      paramFinderThumbPlayerProxy.bNU();
      break label148;
      bool1 = false;
      break label156;
    }
  }
  
  private static final void a(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramHorizontalVideoPreviewLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramHorizontalVideoPreviewLayout, "this$0");
    paramHorizontalVideoPreviewLayout.vb(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final boolean a(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout, int paramInt, FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderThumbPlayerProxy paramFinderThumbPlayerProxy, View paramView, MotionEvent paramMotionEvent)
  {
    s.u(paramHorizontalVideoPreviewLayout, "this$0");
    s.u(paramFinderLongVideoPlayerSeekBar, "$seekBar");
    s.u(paramFinderThumbPlayerProxy, "$videoView");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      paramHorizontalVideoPreviewLayout.qjs = ((int)paramMotionEvent.getX());
      paramHorizontalVideoPreviewLayout.qjt = ((int)paramMotionEvent.getY());
      return true;
      if (paramMotionEvent.getPointerCount() > 1) {
        return false;
      }
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int i;
      float f2;
      float f1;
      if (paramInt == 0) {
        if ((Math.abs((j - paramHorizontalVideoPreviewLayout.qjs) / (k - paramHorizontalVideoPreviewLayout.qjt)) > 1.0F) && (Math.abs(j - paramHorizontalVideoPreviewLayout.qjs) > paramHorizontalVideoPreviewLayout.getTouchSlop()))
        {
          i = 1;
          if ((!paramHorizontalVideoPreviewLayout.Fmh) && (i == 0)) {
            continue;
          }
          if (!paramHorizontalVideoPreviewLayout.Fmh)
          {
            paramView = paramFinderLongVideoPlayerSeekBar.getOnSeekStart();
            if (paramView != null) {
              paramView.invoke();
            }
            paramHorizontalVideoPreviewLayout.startTime = paramFinderThumbPlayerProxy.getCurrentPlaySecond();
            paramFinderThumbPlayerProxy.pause();
            paramFinderLongVideoPlayerSeekBar.setIsPlay(false);
            Log.i("HorizontalVideoPreviewLayout", "onHorizontalPreviewTouch: start track move, startTime = " + paramHorizontalVideoPreviewLayout.startTime + " videoTotalTime=" + paramFinderLongVideoPlayerSeekBar.getVideoTotalTime());
          }
          paramHorizontalVideoPreviewLayout.Fmh = true;
          f2 = (k - paramHorizontalVideoPreviewLayout.qjt) / paramHorizontalVideoPreviewLayout.getHeight();
          if (paramInt != 0) {
            break label393;
          }
          f1 = (j - paramHorizontalVideoPreviewLayout.qjs) / paramHorizontalVideoPreviewLayout.getWidth();
        }
      }
      for (;;)
      {
        paramInt = paramHorizontalVideoPreviewLayout.startTime;
        paramHorizontalVideoPreviewLayout.Fmj = (kotlin.h.a.eH(f1 * paramFinderLongVideoPlayerSeekBar.getVideoTotalTime()) + paramInt);
        paramFinderLongVideoPlayerSeekBar.seek(paramHorizontalVideoPreviewLayout.Fmj);
        paramHorizontalVideoPreviewLayout.d(paramFinderThumbPlayerProxy, paramHorizontalVideoPreviewLayout.Fmj);
        return true;
        i = 0;
        break;
        if ((Math.abs((k - paramHorizontalVideoPreviewLayout.qjt) / (j - paramHorizontalVideoPreviewLayout.qjs)) > 1.0F) && (Math.abs(k - paramHorizontalVideoPreviewLayout.qjt) > paramHorizontalVideoPreviewLayout.getTouchSlop()))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        label393:
        f1 = f2;
        if (paramInt < 0) {
          f1 = -f2;
        }
      }
      if (paramHorizontalVideoPreviewLayout.Fmh)
      {
        Log.i("HorizontalVideoPreviewLayout", s.X("onHorizontalPreviewTouch: seek end, target time = ", Integer.valueOf(paramHorizontalVideoPreviewLayout.Fmj)));
        paramView = paramFinderLongVideoPlayerSeekBar.getOnSeekEnd();
        if (paramView != null) {
          paramView.invoke();
        }
        paramHorizontalVideoPreviewLayout.Fmh = false;
        paramHorizontalVideoPreviewLayout.startTime = 0;
        paramInt = paramFinderThumbPlayerProxy.getVideoDuration();
        paramFinderThumbPlayerProxy.setVideoViewFocused(true);
        paramView = paramHorizontalVideoPreviewLayout.getFullSeekBar();
        if (paramView != null) {
          paramView.aCk("HorizontalSeek");
        }
        if (paramHorizontalVideoPreviewLayout.Fmj >= paramInt) {
          paramInt -= 1;
        }
        for (;;)
        {
          paramFinderThumbPlayerProxy.a(paramInt, true, 3);
          paramFinderThumbPlayerProxy.bNU();
          paramFinderLongVideoPlayerSeekBar.setIsPlay(true);
          paramHorizontalVideoPreviewLayout.Fmj = 0;
          return true;
          paramInt = paramHorizontalVideoPreviewLayout.Fmj;
        }
      }
      if ((Math.abs(paramMotionEvent.getX() - paramHorizontalVideoPreviewLayout.qjs) < paramHorizontalVideoPreviewLayout.getTouchSlop()) && (Math.abs(paramMotionEvent.getY() - paramHorizontalVideoPreviewLayout.qjt) < paramHorizontalVideoPreviewLayout.getTouchSlop()))
      {
        Log.i("HorizontalVideoPreviewLayout", "onHorizontalPreviewTouch: performClick");
        paramHorizontalVideoPreviewLayout.performClick();
      }
    }
  }
  
  private static final void b(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramHorizontalVideoPreviewLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramHorizontalVideoPreviewLayout, "this$0");
    paramHorizontalVideoPreviewLayout.flE();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private final int getTouchSlop()
  {
    return ((Number)this.Fmi.getValue()).intValue();
  }
  
  protected final void a(final FinderVideoLayout paramFinderVideoLayout, final FinderThumbPlayerProxy paramFinderThumbPlayerProxy, final com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean)
  {
    s.u(paramFinderVideoLayout, "originVideoLayout");
    s.u(paramFinderThumbPlayerProxy, "videoView");
    s.u(paramj, "simpleViewHolder");
    paramFinderVideoLayout.setLongVideoSeekBar(getLongVideoSeekBarLayout().getLongVideoSeekBar());
    paramj = getLongVideoSeekBarLayout().getLongVideoSeekBar();
    paramj.setOnSeekStart((kotlin.g.a.a)new b(this));
    paramj.setOnSeekEnd((kotlin.g.a.a)new c(this));
    paramj.setPlayStatusListener((FinderLongVideoPlayerSeekBar.b)new d(this, paramFinderThumbPlayerProxy, paramj));
    paramj.setPlayBtnOnClickListener(new HorizontalVideoPreviewLayout..ExternalSyntheticLambda1(paramj, paramFinderThumbPlayerProxy, this, paramFinderVideoLayout));
    int i = paramFinderThumbPlayerProxy.getVideoDuration();
    paramj.setVideoTotalTime(i);
    getTotalTimeTv().setText((CharSequence)(Bf(i / 60) + ':' + Bf(i % 60)));
    long l = paramFinderThumbPlayerProxy.getCurrentPlayMs() / 1000L;
    paramj.seek((int)l);
    d(paramFinderThumbPlayerProxy, (int)l);
    paramj.setIsPlay(paramFinderThumbPlayerProxy.isPlaying());
    paramj.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new e(paramj, paramFinderThumbPlayerProxy, this, paramFinderVideoLayout));
    getLongVideoSeekBarLayout().getFloatingBallBtn().setVisibility(8);
    if (paramBoolean)
    {
      getLongVideoSeekBarLayout().getSpeedCtrlBtn().setVisibility(0);
      getLongVideoSeekBarLayout().getSpeedCtrlBtn().setOnClickListener(new HorizontalVideoPreviewLayout..ExternalSyntheticLambda3(this));
    }
    for (;;)
    {
      paramFinderVideoLayout = getLongVideoSeekBarLayout().getDescTv();
      paramFinderVideoLayout.setOnClickListener(new HorizontalVideoPreviewLayout..ExternalSyntheticLambda0(paramFinderVideoLayout, this));
      return;
      getLongVideoSeekBarLayout().getSpeedCtrlBtn().setVisibility(8);
    }
  }
  
  protected final void c(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, int paramInt)
  {
    s.u(paramFinderThumbPlayerProxy, "videoView");
    setOnTouchListener(new HorizontalVideoPreviewLayout..ExternalSyntheticLambda4(this, paramInt, getLongVideoSeekBarLayout().getLongVideoSeekBar(), paramFinderThumbPlayerProxy));
  }
  
  protected final void d(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, int paramInt)
  {
    s.u(paramFinderThumbPlayerProxy, "videoView");
    paramInt = androidx.core.b.a.clamp(paramInt, 0, paramFinderThumbPlayerProxy.getVideoDuration());
    getCurrentTimeTv().setText((CharSequence)(Bf(paramInt / 60) + ':' + Bf(paramInt % 60)));
  }
  
  public abstract void flE();
  
  protected final View getBgView()
  {
    return this.AhP;
  }
  
  public final TextView getCurrentTimeTv()
  {
    Object localObject = this.GmS.getValue();
    s.s(localObject, "<get-currentTimeTv>(...)");
    return (TextView)localObject;
  }
  
  protected final View getFgView()
  {
    return this.GEE;
  }
  
  public final FinderFullSeekBarLayout getFullSeekBar()
  {
    return this.GEL;
  }
  
  protected final FrameLayout getIconLayout()
  {
    return this.GEF;
  }
  
  public final HorizontalVideoSeekBarLayout getLongVideoSeekBarLayout()
  {
    return (HorizontalVideoSeekBarLayout)this.GEG.getValue();
  }
  
  protected final int getRealScreenHeight()
  {
    return this.GEH;
  }
  
  public final int getRealScreenWidth()
  {
    return this.GEI;
  }
  
  public final View getSeekTimeLayout()
  {
    Object localObject = this.GEJ.getValue();
    s.s(localObject, "<get-seekTimeLayout>(...)");
    return (View)localObject;
  }
  
  public final TextView getTotalTimeTv()
  {
    Object localObject = this.GEK.getValue();
    s.s(localObject, "<get-totalTimeTv>(...)");
    return (TextView)localObject;
  }
  
  public final void s(FinderVideoLayout paramFinderVideoLayout)
  {
    s.u(paramFinderVideoLayout, "originVideoLayout");
    paramFinderVideoLayout.setLongVideoSeekBar(null);
    paramFinderVideoLayout = getLongVideoSeekBarLayout().getLongVideoSeekBar();
    paramFinderVideoLayout.setIplaySeekCallback(null);
    paramFinderVideoLayout.setPlayBtnOnClickListener(null);
    paramFinderVideoLayout.setOnSeekStart(null);
    paramFinderVideoLayout.setOnSeekEnd(null);
    paramFinderVideoLayout.setPlayStatusListener(null);
  }
  
  public final void setFullSeekBar(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
  {
    this.GEL = paramFinderFullSeekBarLayout;
  }
  
  public abstract void tv(boolean paramBoolean);
  
  protected void vb(boolean paramBoolean)
  {
    int j = 0;
    int i;
    if ((paramBoolean) || (getLongVideoSeekBarLayout().getVisibility() != 0))
    {
      i = 1;
      localObject = getLongVideoSeekBarLayout();
      if (i == 0) {
        break label91;
      }
      label28:
      ((HorizontalVideoSeekBarLayout)localObject).setVisibility(j);
      if (i != 0)
      {
        localObject = bb.FuK;
        localObject = as.GSQ;
        localObject = getContext();
        s.s(localObject, "context");
        localObject = as.a.hu((Context)localObject);
        if (localObject != null) {
          break label96;
        }
      }
    }
    label91:
    label96:
    for (Object localObject = null;; localObject = ((as)localObject).fou())
    {
      bb.a((bui)localObject, "transpose_video_card", 1);
      return;
      i = 0;
      break;
      j = 4;
      break label28;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout$attachSeekBar$1$3", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "onPlayStatusChange", "", "isPlay", "", "onProgress", "times", "", "onReplay", "onSeekTo", "timeStamp", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements FinderLongVideoPlayerSeekBar.b
  {
    d(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout, FinderThumbPlayerProxy paramFinderThumbPlayerProxy, FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar) {}
    
    public final void qU(long paramLong)
    {
      AppMethodBeat.i(344248);
      this.GEM.d(paramFinderThumbPlayerProxy, (int)(paramLong / 1000L));
      if (paramFinderThumbPlayerProxy.isPlaying()) {
        paramj.setIsPlay(true);
      }
      AppMethodBeat.o(344248);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout$attachSeekBar$1$5", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "onSeeking", "currentTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    e(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderThumbPlayerProxy paramFinderThumbPlayerProxy, HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void blc()
    {
      AppMethodBeat.i(344284);
      paramFinderThumbPlayerProxy.pause();
      this.GqO.setIsPlay(false);
      kotlin.g.a.a locala = this.GqO.getOnSeekStart();
      if (locala != null) {
        locala.invoke();
      }
      AppMethodBeat.o(344284);
    }
    
    public final void tS(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(344276);
      paramFinderThumbPlayerProxy.setVideoViewFocused(true);
      Object localObject1 = jdField_this.getFullSeekBar();
      if (localObject1 != null) {
        ((FinderFullSeekBarLayout)localObject1).aCk("HorizontalSeek");
      }
      paramFinderThumbPlayerProxy.a(paramInt, true, 3);
      paramFinderThumbPlayerProxy.bNU();
      this.GqO.setIsPlay(true);
      localObject1 = this.GqO.getOnSeekEnd();
      if (localObject1 != null) {
        ((kotlin.g.a.a)localObject1).invoke();
      }
      localObject1 = paramFinderVideoLayout.getPlayInfo();
      FinderThumbPlayerProxy localFinderThumbPlayerProxy;
      long l;
      if (localObject1 != null)
      {
        if (!((FinderVideoLayout.b)localObject1).GqL) {
          break label211;
        }
        if (localObject1 != null)
        {
          Object localObject3 = paramFinderVideoLayout;
          localFinderThumbPlayerProxy = paramFinderThumbPlayerProxy;
          localObject3 = ((FinderVideoLayout)localObject3).getVideoPlayBehavior();
          if (localObject3 != null) {
            ((c.b)localObject3).d(((FinderVideoLayout.b)localObject1).feed.getExpectId(), ((FinderVideoLayout.b)localObject1).EEv.ExE, localFinderThumbPlayerProxy.getCurrentPlaySecond(), paramInt, (x)((FinderVideoLayout.b)localObject1).EEv);
          }
          l = ((FinderVideoLayout.b)localObject1).feed.getExpectId();
          if (localFinderThumbPlayerProxy != null) {
            break label217;
          }
        }
      }
      label211:
      label217:
      for (localObject1 = localObject2;; localObject1 = localFinderThumbPlayerProxy.getVideoMediaId())
      {
        FinderVideoLayout.b(l, (String)localObject1, localFinderThumbPlayerProxy.getCurrentPlaySecond(), paramInt);
        AppMethodBeat.o(344276);
        return;
        localObject1 = null;
        break;
      }
    }
    
    public final void tT(int paramInt)
    {
      AppMethodBeat.i(344290);
      jdField_this.d(paramFinderThumbPlayerProxy, paramInt);
      AppMethodBeat.o(344290);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout$attachSeekBar$3$1$closeDetailTextListener$1", "Landroid/view/View$OnClickListener;", "tvScrollY", "", "getTvScrollY", "()I", "setTvScrollY", "(I)V", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements View.OnClickListener
  {
    private int GEP;
    
    f(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout)
    {
      AppMethodBeat.i(344283);
      this.GEP = this.GEM.getLongVideoSeekBarLayout().getHiddenTv().getScrollY();
      AppMethodBeat.o(344283);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(344294);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout$attachSeekBar$3$1$closeDetailTextListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      if ((this.GEM.getFgView().getVisibility() == 0) && (this.GEP == this.GEM.getLongVideoSeekBarLayout().getHiddenTv().getScrollY()))
      {
        this.GEM.getFgView().setVisibility(8);
        this.GEM.getLongVideoSeekBarLayout().getHiddenTv().setVisibility(4);
        this.GEM.getLongVideoSeekBarLayout().getDescTv().setVisibility(0);
        paramView = bb.FuK;
        paramView = as.GSQ;
        paramView = this.GEM.getContext();
        s.s(paramView, "context");
        paramView = as.a.hu(paramView);
        if (paramView != null) {
          break label182;
        }
      }
      label182:
      for (paramView = null;; paramView = paramView.fou())
      {
        bb.a(paramView, "transpose_video_card_caption_detail", 1);
        this.GEP = this.GEM.getLongVideoSeekBarLayout().getHiddenTv().getScrollY();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/HorizontalVideoPreviewLayout$attachSeekBar$3$1$closeDetailTextListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(344294);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<TextView>
  {
    g(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/HorizontalVideoSeekBarLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<HorizontalVideoSeekBarLayout>
  {
    h(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<View>
  {
    i(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<TextView>
  {
    j(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<Integer>
  {
    k(HorizontalVideoPreviewLayout paramHorizontalVideoPreviewLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.HorizontalVideoPreviewLayout
 * JD-Core Version:    0.7.0.1
 */