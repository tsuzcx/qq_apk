package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class c
  extends ImageView
{
  Animation.AnimationListener IH;
  int II;
  
  c(Context paramContext)
  {
    super(paramContext);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.II = ((int)(3.5F * f));
    if (dP())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      t.i(this, f * 4.0F);
    }
    for (;;)
    {
      paramContext.getPaint().setColor(-328966);
      t.a(this, paramContext);
      return;
      paramContext = new ShapeDrawable(new c.a(this, this.II));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.II, j, i, 503316480);
      i = this.II;
      setPadding(i, i, i, i);
    }
  }
  
  private static boolean dP()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public final void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (this.IH != null) {
      this.IH.onAnimationEnd(getAnimation());
    }
  }
  
  public final void onAnimationStart()
  {
    super.onAnimationStart();
    if (this.IH != null) {
      this.IH.onAnimationStart(getAnimation());
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!dP()) {
      setMeasuredDimension(getMeasuredWidth() + this.II * 2, getMeasuredHeight() + this.II * 2);
    }
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.c
 * JD-Core Version:    0.7.0.1
 */