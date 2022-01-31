package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

final class c$a
  extends OvalShape
{
  private RadialGradient Jb;
  private Paint Jc = new Paint();
  
  c$a(c paramc, int paramInt)
  {
    paramc.Ja = paramInt;
    aE((int)rect().width());
  }
  
  private void aE(int paramInt)
  {
    float f1 = paramInt / 2;
    float f2 = paramInt / 2;
    float f3 = this.Jd.Ja;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.Jb = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, localTileMode);
    this.Jc.setShader(this.Jb);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    int i = this.Jd.getWidth();
    int j = this.Jd.getHeight();
    paramCanvas.drawCircle(i / 2, j / 2, i / 2, this.Jc);
    paramCanvas.drawCircle(i / 2, j / 2, i / 2 - this.Jd.Ja, paramPaint);
  }
  
  protected final void onResize(float paramFloat1, float paramFloat2)
  {
    super.onResize(paramFloat1, paramFloat2);
    aE((int)paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.widget.c.a
 * JD-Core Version:    0.7.0.1
 */