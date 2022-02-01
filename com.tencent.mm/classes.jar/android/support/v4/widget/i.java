package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class i
{
  public EdgeEffect Uv;
  
  @Deprecated
  public i(Context paramContext)
  {
    this.Uv = new EdgeEffect(paramContext);
  }
  
  public static void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
      return;
    }
    paramEdgeEffect.onPull(paramFloat1);
  }
  
  @Deprecated
  public final boolean G(float paramFloat)
  {
    this.Uv.onPull(paramFloat);
    return true;
  }
  
  @Deprecated
  public final boolean aX(int paramInt)
  {
    this.Uv.onAbsorb(paramInt);
    return true;
  }
  
  @Deprecated
  public final boolean draw(Canvas paramCanvas)
  {
    return this.Uv.draw(paramCanvas);
  }
  
  @Deprecated
  public final boolean ga()
  {
    this.Uv.onRelease();
    return this.Uv.isFinished();
  }
  
  @Deprecated
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.Uv.setSize(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.i
 * JD-Core Version:    0.7.0.1
 */