package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class c
  extends ImageView
{
  Animation.AnimationListener SD;
  int SE;
  
  c(Context paramContext)
  {
    super(paramContext);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.SE = ((int)(3.5F * f));
    if (fN())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      u.l(this, f * 4.0F);
    }
    for (;;)
    {
      paramContext.getPaint().setColor(-328966);
      u.a(this, paramContext);
      return;
      paramContext = new ShapeDrawable(new a(this.SE));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.SE, j, i, 503316480);
      i = this.SE;
      setPadding(i, i, i, i);
    }
  }
  
  private static boolean fN()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public final void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (this.SD != null) {
      this.SD.onAnimationEnd(getAnimation());
    }
  }
  
  public final void onAnimationStart()
  {
    super.onAnimationStart();
    if (this.SD != null) {
      this.SD.onAnimationStart(getAnimation());
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!fN()) {
      setMeasuredDimension(getMeasuredWidth() + this.SE * 2, getMeasuredHeight() + this.SE * 2);
    }
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
  }
  
  final class a
    extends OvalShape
  {
    private RadialGradient SF;
    private Paint SG = new Paint();
    
    a(int paramInt)
    {
      c.this.SE = paramInt;
      aU((int)rect().width());
    }
    
    private void aU(int paramInt)
    {
      float f1 = paramInt / 2;
      float f2 = paramInt / 2;
      float f3 = c.this.SE;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.SF = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, localTileMode);
      this.SG.setShader(this.SF);
    }
    
    public final void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int i = c.this.getWidth();
      int j = c.this.getHeight();
      paramCanvas.drawCircle(i / 2, j / 2, i / 2, this.SG);
      paramCanvas.drawCircle(i / 2, j / 2, i / 2 - c.this.SE, paramPaint);
    }
    
    protected final void onResize(float paramFloat1, float paramFloat2)
    {
      super.onResize(paramFloat1, paramFloat2);
      aU((int)paramFloat1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.c
 * JD-Core Version:    0.7.0.1
 */