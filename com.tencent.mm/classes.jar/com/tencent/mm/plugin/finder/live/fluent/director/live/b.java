package com.tencent.mm.plugin.finder.live.fluent.director.live;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.a.b;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.w.a.a.a.c;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/live/SwitchInWindowDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/director/live/SwitchInLiveDirector;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "(Landroid/content/Context;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "windowContainerView", "Landroid/widget/FrameLayout;", "getWindowContainerView", "()Landroid/widget/FrameLayout;", "setWindowContainerView", "(Landroid/widget/FrameLayout;)V", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "Lkotlin/Lazy;", "addMaskToTargetView", "", "attachTransitionContainerView", "calculateTargetRect", "Landroid/graphics/Rect;", "getTag", "", "getTransitionDuration", "", "switchInLiveFinish", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  FrameLayout CDh;
  private final Activity activity;
  private final j rfk;
  
  public b(Context paramContext, Activity paramActivity)
  {
    super(paramContext);
    AppMethodBeat.i(352182);
    this.activity = paramActivity;
    this.rfk = k.cm((kotlin.g.a.a)new c(paramContext));
    AppMethodBeat.o(352182);
  }
  
  private final WindowManager getWindowManager()
  {
    AppMethodBeat.i(352190);
    WindowManager localWindowManager = (WindowManager)this.rfk.getValue();
    AppMethodBeat.o(352190);
    return localWindowManager;
  }
  
  public final long ejA()
  {
    AppMethodBeat.i(352263);
    long l = com.tencent.mm.plugin.finder.live.fluent.director.base.a.ejJ();
    AppMethodBeat.o(352263);
    return l;
  }
  
  public final void ejC()
  {
    AppMethodBeat.i(352231);
    Object localObject = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    localObject = com.tencent.mm.plugin.finder.live.fluent.util.a.ejY();
    this.CDh = new FrameLayout(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(wR(), ejW());
    if (!ejX()) {
      localLayoutParams.gravity = 17;
    }
    FrameLayout localFrameLayout = this.CDh;
    if (localFrameLayout != null) {
      localFrameLayout.addView((View)this.CCY, (ViewGroup.LayoutParams)localLayoutParams);
    }
    getWindowManager().addView((View)this.CDh, (ViewGroup.LayoutParams)localObject);
    localObject = this.CCY;
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a(this));
      }
    }
    AppMethodBeat.o(352231);
  }
  
  public final Rect ejE()
  {
    int i1 = 0;
    AppMethodBeat.i(352257);
    int i2 = bd.bs(MMApplicationContext.getContext(), a.c.Edge_A);
    int i3 = bd.bs(MMApplicationContext.getContext(), a.c.finder_0_75_A);
    int m = bd.bs(MMApplicationContext.getContext(), a.c.finder_1_25_A);
    Object localObject = ejL();
    label60:
    int i;
    label62:
    label66:
    label81:
    label95:
    label100:
    int j;
    label102:
    label106:
    label121:
    int k;
    label142:
    label146:
    label153:
    int i4;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label388;
      }
      i = 1;
      if (i == 0) {
        break label401;
      }
      if (localObject != null) {
        break label407;
      }
      i = bd.bs(MMApplicationContext.getContext(), a.b.float_ball_voip_view_video_width);
      localObject = ejL();
      if (localObject != null) {
        break label416;
      }
      localObject = null;
      if (localObject != null) {
        break label447;
      }
      j = 1;
      if (j == 0) {
        break label460;
      }
      if (localObject != null) {
        break label466;
      }
      j = bd.bs(MMApplicationContext.getContext(), a.b.float_ball_voip_view_video_height);
      localObject = Integer.valueOf(d.cZh());
      if (((Number)localObject).intValue() < 0) {
        break label475;
      }
      k = 1;
      if (k == 0) {
        break label480;
      }
      if (localObject != null) {
        break label486;
      }
      k = 0;
      i4 = d.cZi();
      localObject = Integer.valueOf(m);
      ((Number)localObject).intValue();
      if (k == 0) {
        break label495;
      }
      m = 1;
      label181:
      if (m == 0) {
        break label501;
      }
      label186:
      if (localObject != null) {
        break label507;
      }
      m = 0;
      label194:
      localObject = Integer.valueOf(bf.bk((Context)this.activity) / 2);
      ((Number)localObject).intValue();
      if (ejX()) {
        break label517;
      }
      n = 1;
      label230:
      if (n == 0) {
        break label523;
      }
      label235:
      if (localObject != null) {
        break label529;
      }
    }
    label388:
    label517:
    label523:
    label529:
    for (int n = i1;; n = ((Integer)localObject).intValue())
    {
      Log.i(this.TAG, "calculateTargetRect offestLeft: " + m + " left: " + k + " top: " + i4 + " navigateHeight: " + n);
      localObject = new Rect(k + i2 + m, i4 + i3 + i2 + n, i + (k + m) + i2, j + i4 + i3 + i2 + n);
      AppMethodBeat.o(352257);
      return localObject;
      localObject = ((com.tencent.mm.plugin.finder.live.fluent.params.a)localObject).CDp;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = Integer.valueOf(((Point)localObject).x);
      break;
      if (((Integer)localObject).intValue() != 0) {
        break label60;
      }
      i = 0;
      break label62;
      label401:
      localObject = null;
      break label66;
      label407:
      i = ((Integer)localObject).intValue();
      break label81;
      label416:
      localObject = ((com.tencent.mm.plugin.finder.live.fluent.params.a)localObject).CDp;
      if (localObject == null)
      {
        localObject = null;
        break label95;
      }
      localObject = Integer.valueOf(((Point)localObject).y);
      break label95;
      label447:
      if (((Integer)localObject).intValue() != 0) {
        break label100;
      }
      j = 0;
      break label102;
      label460:
      localObject = null;
      break label106;
      label466:
      j = ((Integer)localObject).intValue();
      break label121;
      label475:
      k = 0;
      break label142;
      label480:
      localObject = null;
      break label146;
      label486:
      k = ((Integer)localObject).intValue();
      break label153;
      label495:
      m = 0;
      break label181;
      label501:
      localObject = null;
      break label186;
      label507:
      m = ((Integer)localObject).intValue();
      break label194;
      n = 0;
      break label230;
      localObject = null;
      break label235;
    }
  }
  
  public final void ejM()
  {
    AppMethodBeat.i(352238);
    super.ejM();
    com.tencent.mm.plugin.finder.live.fluent.util.a locala = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    com.tencent.mm.plugin.finder.live.fluent.util.a.ba((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(352238);
  }
  
  public final void ejV()
  {
    AppMethodBeat.i(352221);
    Object localObject1 = ejT();
    ImageView localImageView;
    if (localObject1 != null)
    {
      localObject1 = ((TXCloudVideoView)localObject1).getVideoView();
      if (localObject1 != null)
      {
        localObject1 = ((TextureView)localObject1).getBitmap();
        if (localObject1 != null)
        {
          localImageView = ejU();
          localImageView.setImageBitmap((Bitmap)localObject1);
          localObject1 = ejL();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.fluent.params.a)localObject1).CDo;
            if (!(localObject1 instanceof com.tencent.mm.live.core.view.a)) {
              break label144;
            }
          }
        }
      }
    }
    label144:
    for (localObject1 = (com.tencent.mm.live.core.view.a)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((com.tencent.mm.live.core.view.a)localObject1).findViewWithTag("nearby-live-fluent-preview-view-tag");
        if (localObject2 != null) {
          ((com.tencent.mm.live.core.view.a)localObject1).removeView((View)localObject2);
        }
        localImageView.setTag("nearby-live-fluent-preview-view-tag");
        localObject2 = new RelativeLayout.LayoutParams(ejI().width(), ejI().height());
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((com.tencent.mm.live.core.view.a)localObject1).addView((View)localImageView, (ViewGroup.LayoutParams)localObject2);
      }
      AppMethodBeat.o(352221);
      return;
    }
  }
  
  public final String getTag()
  {
    return "SwitchInWindowDirector";
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/fluent/director/live/SwitchInWindowDirector$attachTransitionContainerView$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a(b paramb) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(352222);
      Object localObject = this.CDi.CCY;
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        }
      }
      Log.i(this.CDi.TAG, "addCoverViewContainerToWindow onPreDraw");
      localObject = this.CDi.parentView;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(4);
      }
      AppMethodBeat.o(352222);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/WindowManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<WindowManager>
  {
    c(Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.live.b
 * JD-Core Version:    0.7.0.1
 */