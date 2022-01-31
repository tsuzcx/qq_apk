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
  private RadialGradient IJ;
  private Paint IK = new Paint();
  
  c$a(c paramc, int paramInt)
  {
    paramc.II = paramInt;
    aB((int)rect().width());
  }
  
  private void aB(int paramInt)
  {
    float f1 = paramInt / 2;
    float f2 = paramInt / 2;
    float f3 = this.IL.II;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.IJ = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, localTileMode);
    this.IK.setShader(this.IJ);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    int i = this.IL.getWidth();
    int j = this.IL.getHeight();
    paramCanvas.drawCircle(i / 2, j / 2, i / 2, this.IK);
    paramCanvas.drawCircle(i / 2, j / 2, i / 2 - this.IL.II, paramPaint);
  }
  
  protected final void onResize(float paramFloat1, float paramFloat2)
  {
    super.onResize(paramFloat1, paramFloat2);
    aB((int)paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.widget.c.a
 * JD-Core Version:    0.7.0.1
 */