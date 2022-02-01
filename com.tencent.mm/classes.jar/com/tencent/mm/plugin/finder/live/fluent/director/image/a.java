package com.tencent.mm.plugin.finder.live.fluent.director.image;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.fluent.c;
import com.tencent.mm.plugin.finder.live.fluent.director.base.b;
import com.tencent.mm.plugin.finder.live.fluent.g;
import com.tencent.mm.plugin.finder.live.fluent.h;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.w.a.a.a.c;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/image/SwitchInImageDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/director/base/BaseSwitchInDirector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attachTransitionContainerView", "", "calculateSourceRect", "Landroid/graphics/Rect;", "calculateTargetRect", "createTransitionContainerView", "Landroid/view/View;", "detachTransitionContainerView", "getScaleRate", "", "getSourceHeight", "", "getSourceWidth", "getTag", "", "onAnimationEnd", "p0", "Landroid/animation/Animator;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(352172);
    AppMethodBeat.o(352172);
  }
  
  private final int ejR()
  {
    AppMethodBeat.i(352178);
    int i = (int)(getScaleRate() * ejI().width());
    AppMethodBeat.o(352178);
    return i;
  }
  
  private final int ejS()
  {
    AppMethodBeat.i(352184);
    int i = (int)(getScaleRate() * ejI().height());
    AppMethodBeat.o(352184);
    return i;
  }
  
  private float getScaleRate()
  {
    AppMethodBeat.i(352193);
    if (this.parentView == null)
    {
      AppMethodBeat.o(352193);
      return 1.0F;
    }
    ViewGroup localViewGroup = this.parentView;
    s.checkNotNull(localViewGroup);
    float f = localViewGroup.getHeight() / ejI().height();
    localViewGroup = this.parentView;
    s.checkNotNull(localViewGroup);
    f = k.bt(localViewGroup.getWidth() / ejI().width(), f);
    AppMethodBeat.o(352193);
    return f;
  }
  
  public final View ejB()
  {
    AppMethodBeat.i(352218);
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(getContext());
    localRoundedCornerFrameLayout.setRadius(getContext().getResources().getDimension(a.c.Edge_A));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = ejK();
    if ((localObject instanceof c)) {}
    for (localObject = (c)localObject;; localObject = null)
    {
      if (localObject != null) {
        localImageView.setImageDrawable(((ImageView)((c)localObject).CCk).getDrawable());
      }
      localRoundedCornerFrameLayout.addView((View)localImageView, (ViewGroup.LayoutParams)localLayoutParams);
      localObject = (View)localRoundedCornerFrameLayout;
      AppMethodBeat.o(352218);
      return localObject;
    }
  }
  
  public final void ejC()
  {
    ViewGroup localViewGroup = null;
    AppMethodBeat.i(352227);
    Object localObject = this.parentView;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(8);
    }
    localObject = this.parentView;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ViewGroup)localObject).getParent())
    {
      if ((localObject instanceof ViewGroup)) {
        localViewGroup = (ViewGroup)localObject;
      }
      if (localViewGroup != null) {
        localViewGroup.addView(ejy(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(ejR(), ejS()));
      }
      AppMethodBeat.o(352227);
      return;
    }
  }
  
  public final void ejD()
  {
    AppMethodBeat.i(352235);
    Object localObject = this.parentView;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof ViewGroup)) {
        break label54;
      }
    }
    label54:
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(ejy());
      }
      AppMethodBeat.o(352235);
      return;
      localObject = ((ViewGroup)localObject).getParent();
      break;
    }
  }
  
  public final Rect ejE()
  {
    AppMethodBeat.i(352245);
    Object localObject = ejK();
    s.checkNotNull(localObject);
    localObject = ((h)localObject).CCC;
    AppMethodBeat.o(352245);
    return localObject;
  }
  
  public final Rect ejF()
  {
    AppMethodBeat.i(352254);
    Rect localRect = new Rect(0, 0, ejR(), ejS());
    AppMethodBeat.o(352254);
    return localRect;
  }
  
  public final String getTag()
  {
    return "SwitchInImageDirector";
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(352261);
    super.onAnimationEnd(paramAnimator);
    paramAnimator = g.CCu;
    g.eju();
    AppMethodBeat.o(352261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.image.a
 * JD-Core Version:    0.7.0.1
 */