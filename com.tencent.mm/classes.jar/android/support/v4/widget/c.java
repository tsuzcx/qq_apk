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
import android.support.v4.view.t;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class c
  extends ImageView
{
  Animation.AnimationListener Sq;
  int Sr;
  
  c(Context paramContext)
  {
    super(paramContext);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.Sr = ((int)(3.5F * f));
    if (fG())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      t.k(this, f * 4.0F);
    }
    for (;;)
    {
      paramContext.getPaint().setColor(-328966);
      t.a(this, paramContext);
      return;
      paramContext = new ShapeDrawable(new a(this.Sr));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.Sr, j, i, 503316480);
      i = this.Sr;
      setPadding(i, i, i, i);
    }
  }
  
  private static boolean fG()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public final void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (this.Sq != null) {
      this.Sq.onAnimationEnd(getAnimation());
    }
  }
  
  public final void onAnimationStart()
  {
    super.onAnimationStart();
    if (this.Sq != null) {
      this.Sq.onAnimationStart(getAnimation());
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!fG()) {
      setMeasuredDimension(getMeasuredWidth() + this.Sr * 2, getMeasuredHeight() + this.Sr * 2);
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
    private RadialGradient Ss;
    private Paint St = new Paint();
    
    a(int paramInt)
    {
      c.this.Sr = paramInt;
      aT((int)rect().width());
    }
    
    private void aT(int paramInt)
    {
      float f1 = paramInt / 2;
      float f2 = paramInt / 2;
      float f3 = c.this.Sr;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.Ss = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, localTileMode);
      this.St.setShader(this.Ss);
    }
    
    public final void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int i = c.this.getWidth();
      int j = c.this.getHeight();
      paramCanvas.drawCircle(i / 2, j / 2, i / 2, this.St);
      paramCanvas.drawCircle(i / 2, j / 2, i / 2 - c.this.Sr, paramPaint);
    }
    
    protected final void onResize(float paramFloat1, float paramFloat2)
    {
      super.onResize(paramFloat1, paramFloat2);
      aT((int)paramFloat1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.c
 * JD-Core Version:    0.7.0.1
 */