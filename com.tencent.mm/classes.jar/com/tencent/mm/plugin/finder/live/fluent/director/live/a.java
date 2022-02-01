package com.tencent.mm.plugin.finder.live.fluent.director.live;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.fluent.animate.b.a;
import com.tencent.mm.plugin.finder.live.fluent.director.base.b;
import com.tencent.mm.plugin.finder.live.fluent.f;
import com.tencent.mm.plugin.finder.live.fluent.h;
import com.tencent.mm.plugin.finder.live.fluent.h.a;
import com.tencent.mm.plugin.finder.live.fluent.j.b;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.w.a.a.a.b;
import com.tencent.mm.w.a.a.a.c;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/live/SwitchInLiveDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/director/base/BaseSwitchInDirector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "coverViewContainer", "Landroid/widget/FrameLayout;", "getCoverViewContainer", "()Landroid/widget/FrameLayout;", "setCoverViewContainer", "(Landroid/widget/FrameLayout;)V", "maskView", "Landroid/widget/ImageView;", "getMaskView", "()Landroid/widget/ImageView;", "setMaskView", "(Landroid/widget/ImageView;)V", "originVideoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "getOriginVideoView", "()Lcom/tencent/rtmp/ui/TXCloudVideoView;", "setOriginVideoView", "(Lcom/tencent/rtmp/ui/TXCloudVideoView;)V", "addMaskToTargetView", "", "addPreviewView", "coverView", "addTransition", "builder", "Lcom/tencent/mm/plugin/finder/live/fluent/animate/FluentTransitionConfig$Builder;", "addView", "attachTransitionContainerView", "calculateSourceRect", "Landroid/graphics/Rect;", "calculateTargetRect", "createCoverView", "createTransitionContainerView", "Landroid/view/View;", "detachTransitionContainerView", "getParentHeight", "", "getParentWidth", "getTag", "", "getTransitionDuration", "", "isGameLandscapeVideo", "", "isLandscapeVideo", "setInParams", "params", "Lcom/tencent/mm/plugin/finder/live/fluent/params/FinderFluentSwitchInParams;", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends b
{
  public static final a CDe;
  FrameLayout CCY;
  private ImageView CDf;
  private TXCloudVideoView CDg;
  
  static
  {
    AppMethodBeat.i(352230);
    CDe = new a((byte)0);
    AppMethodBeat.o(352230);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(352203);
    AppMethodBeat.o(352203);
  }
  
  private static final void a(a parama, float paramFloat1, float paramFloat2, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(352223);
    s.u(parama, "this$0");
    if (paramValueAnimator == null) {}
    for (paramValueAnimator = null; paramValueAnimator == null; paramValueAnimator = paramValueAnimator.getAnimatedValue())
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(352223);
      throw parama;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramValueAnimator = parama.CDf;
    if (paramValueAnimator != null)
    {
      if (parama.ejX())
      {
        paramValueAnimator.setScaleX(1.0F - f * (1.0F - paramFloat1));
        AppMethodBeat.o(352223);
        return;
      }
      paramValueAnimator.setScaleY(1.0F - f * (1.0F - paramFloat2));
    }
    AppMethodBeat.o(352223);
  }
  
  private static final void a(a parama, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(352212);
    s.u(parama, "this$0");
    parama = parama.CCY;
    if (parama != null)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(352212);
        throw parama;
      }
      parama.setBackgroundColor(((Integer)paramValueAnimator).intValue());
    }
    AppMethodBeat.o(352212);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(352375);
    s.u(parama, "builder");
    super.a(parama);
    int i = getContext().getResources().getColor(a.b.black);
    int j = getContext().getResources().getColor(a.b.translucent);
    Object localObject = ejK();
    s.checkNotNull(localObject);
    float f1 = ((h)localObject).hKI * ejI().height() / ejI().width();
    float f2 = ejI().width();
    localObject = ejK();
    s.checkNotNull(localObject);
    f2 = f2 / ((h)localObject).hKI / ejI().height();
    localObject = ValueAnimator.ofObject((TypeEvaluator)new ArgbEvaluator(), new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    ((ValueAnimator)localObject).addUpdateListener(new a..ExternalSyntheticLambda0(this));
    ah localah = ah.aiuX;
    s.s(localObject, "ofObject(ArgbEvaluator()…          }\n            }");
    parama = parama.c((ValueAnimator)localObject);
    localObject = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).addUpdateListener(new a..ExternalSyntheticLambda1(this, f1, f2));
    localah = ah.aiuX;
    s.s(localObject, "ofFloat(0.0f, 1.0f).appl…}\n            }\n        }");
    parama.c((ValueAnimator)localObject);
    AppMethodBeat.o(352375);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.fluent.params.a parama)
  {
    AppMethodBeat.i(352267);
    s.u(parama, "params");
    this.CDg = parama.CDn;
    super.a(parama);
    AppMethodBeat.o(352267);
  }
  
  public long ejA()
  {
    AppMethodBeat.i(352312);
    Object localObject = ejK();
    if (localObject == null) {}
    for (localObject = null; (localObject == h.a.CCD) && (!ejX()); localObject = ((h)localObject).CCA)
    {
      AppMethodBeat.o(352312);
      return 0L;
    }
    long l = super.ejA();
    AppMethodBeat.o(352312);
    return l;
  }
  
  public final View ejB()
  {
    FrameLayout localFrameLayout = null;
    AppMethodBeat.i(352280);
    this.CCY = new FrameLayout(getContext());
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(getContext());
    Object localObject = ejK();
    label104:
    int i;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != h.a.CCD) {
        localRoundedCornerFrameLayout.setRadius(getContext().getResources().getDimension(a.c.Edge_A));
      }
      this.CDf = ejU();
      ImageView localImageView = this.CDf;
      if (localImageView != null)
      {
        localObject = this.CDg;
        if (localObject != null) {
          break label250;
        }
        localObject = localFrameLayout;
        localImageView.setImageBitmap((Bitmap)localObject);
      }
      if (!ejX()) {
        break label273;
      }
      i = ejH().width();
      label125:
      if (!ejX()) {
        break label278;
      }
    }
    label273:
    label278:
    for (int j = ejH().height();; j = -1)
    {
      localObject = new FrameLayout.LayoutParams(i, j);
      if (ejX())
      {
        ((FrameLayout.LayoutParams)localObject).topMargin = ejH().top;
        ((FrameLayout.LayoutParams)localObject).leftMargin = ejH().left;
      }
      localRoundedCornerFrameLayout.addView((View)this.CDf, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(i, j));
      localFrameLayout = this.CCY;
      if (localFrameLayout != null) {
        localFrameLayout.addView((View)localRoundedCornerFrameLayout, (ViewGroup.LayoutParams)localObject);
      }
      localObject = (View)localRoundedCornerFrameLayout;
      AppMethodBeat.o(352280);
      return localObject;
      localObject = ((h)localObject).CCA;
      break;
      label250:
      TextureView localTextureView = ((TXCloudVideoView)localObject).getVideoView();
      localObject = localFrameLayout;
      if (localTextureView == null) {
        break label104;
      }
      localObject = localTextureView.getBitmap();
      break label104;
      i = -1;
      break label125;
    }
  }
  
  public void ejC()
  {
    ViewGroup localViewGroup = null;
    AppMethodBeat.i(352303);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(wR(), ejW());
    if (!ejX()) {
      localLayoutParams.gravity = 17;
    }
    Object localObject = this.parentView;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ViewGroup)localObject).getParent())
    {
      if ((localObject instanceof ViewGroup)) {
        localViewGroup = (ViewGroup)localObject;
      }
      if (localViewGroup != null) {
        localViewGroup.addView((View)this.CCY, (ViewGroup.LayoutParams)localLayoutParams);
      }
      localObject = this.parentView;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
      AppMethodBeat.o(352303);
      return;
    }
  }
  
  public final void ejD()
  {
    AppMethodBeat.i(352319);
    ejV();
    AppMethodBeat.o(352319);
  }
  
  public Rect ejE()
  {
    AppMethodBeat.i(352329);
    Object localObject = ejK();
    if (localObject == null) {}
    for (localObject = null; (localObject == h.a.CCD) && (!ejX()); localObject = ((h)localObject).CCA)
    {
      localObject = ejF();
      AppMethodBeat.o(352329);
      return localObject;
    }
    localObject = ejK();
    s.checkNotNull(localObject);
    localObject = ((h)localObject).CCC;
    AppMethodBeat.o(352329);
    return localObject;
  }
  
  public final Rect ejF()
  {
    AppMethodBeat.i(352339);
    Object localObject = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    localObject = ejK();
    s.checkNotNull(localObject);
    localObject = com.tencent.mm.plugin.finder.live.fluent.util.a.d((h)localObject);
    AppMethodBeat.o(352339);
    return localObject;
  }
  
  public final TXCloudVideoView ejT()
  {
    return this.CDg;
  }
  
  public final ImageView ejU()
  {
    AppMethodBeat.i(352289);
    ImageView localImageView = new ImageView(getContext());
    if (ejX()) {
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    for (;;)
    {
      AppMethodBeat.o(352289);
      return localImageView;
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  public void ejV()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(352349);
    Object localObject1 = this.CDg;
    Object localObject2;
    Object localObject3;
    float f1;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((TextureView)localObject1).setSurfaceTextureListener((TextureView.SurfaceTextureListener)new j.b("SwitchInLiveDirector"));
      }
      localObject1 = this.CDg;
      if (localObject1 != null)
      {
        localObject1 = ((TXCloudVideoView)localObject1).getVideoView();
        if (localObject1 != null)
        {
          localObject1 = ((TextureView)localObject1).getBitmap();
          if (localObject1 != null)
          {
            localObject2 = ejU();
            if (!ejX())
            {
              localObject3 = this.CDf;
              if (localObject3 != null) {
                break label263;
              }
              f1 = 1.0F;
              label93:
              ((ImageView)localObject2).setScaleX(f1);
              localObject3 = this.CDf;
              if (localObject3 != null) {
                break label272;
              }
              f1 = f2;
              label112:
              ((ImageView)localObject2).setScaleY(f1);
            }
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
            localObject1 = ejK();
            if (!(localObject1 instanceof f)) {
              break label281;
            }
            localObject1 = (f)localObject1;
            label141:
            if (localObject1 != null)
            {
              localObject1 = ((f)localObject1).mUN;
              if (!(localObject1 instanceof FrameLayout)) {
                break label286;
              }
            }
          }
        }
      }
    }
    label263:
    label272:
    label281:
    label286:
    for (localObject1 = (FrameLayout)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject3 = ((FrameLayout)localObject1).findViewWithTag("nearby-live-fluent-preview-view-tag");
        if (localObject3 != null) {
          ((FrameLayout)localObject1).removeView((View)localObject3);
        }
        ((ImageView)localObject2).setTag("nearby-live-fluent-preview-view-tag");
        localObject2 = (View)localObject2;
        localObject3 = new FrameLayout.LayoutParams(ejI().width(), ejI().height());
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        ah localah = ah.aiuX;
        ((FrameLayout)localObject1).addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject3);
      }
      AppMethodBeat.o(352349);
      return;
      localObject1 = ((TXCloudVideoView)localObject1).getVideoView();
      break;
      f1 = ((ImageView)localObject3).getScaleX();
      break label93;
      f1 = ((ImageView)localObject3).getScaleY();
      break label112;
      localObject1 = null;
      break label141;
    }
  }
  
  public final int ejW()
  {
    AppMethodBeat.i(352362);
    if (ejX())
    {
      i = ejx();
      AppMethodBeat.o(352362);
      return i;
    }
    int i = ejH().height();
    AppMethodBeat.o(352362);
    return i;
  }
  
  public final boolean ejX()
  {
    AppMethodBeat.i(352385);
    h localh = ejK();
    s.checkNotNull(localh);
    if (localh.hKI >= 1.0F)
    {
      AppMethodBeat.o(352385);
      return true;
    }
    AppMethodBeat.o(352385);
    return false;
  }
  
  public String getTag()
  {
    return "SwitchInLiveDirector";
  }
  
  public final int wR()
  {
    AppMethodBeat.i(352356);
    if (ejX())
    {
      i = ejw();
      AppMethodBeat.o(352356);
      return i;
    }
    int i = ejH().width();
    AppMethodBeat.o(352356);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/live/SwitchInLiveDirector$Companion;", "", "()V", "NEARBY_LIVE_FLUENT_PREVIEW_VIEW_TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.live.a
 * JD-Core Version:    0.7.0.1
 */