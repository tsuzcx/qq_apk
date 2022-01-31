package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class i
{
  private static final b KR = new b();
  public EdgeEffect KQ;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      KR = new a();
      return;
    }
  }
  
  @Deprecated
  public i(Context paramContext)
  {
    this.KQ = new EdgeEffect(paramContext);
  }
  
  public static void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    KR.a(paramEdgeEffect, paramFloat1, paramFloat2);
  }
  
  @Deprecated
  public final boolean D(float paramFloat)
  {
    this.KQ.onPull(paramFloat);
    return true;
  }
  
  @Deprecated
  public final boolean aI(int paramInt)
  {
    this.KQ.onAbsorb(paramInt);
    return true;
  }
  
  @Deprecated
  public final boolean dL()
  {
    this.KQ.onRelease();
    return this.KQ.isFinished();
  }
  
  @Deprecated
  public final boolean draw(Canvas paramCanvas)
  {
    return this.KQ.draw(paramCanvas);
  }
  
  @Deprecated
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.KQ.setSize(paramInt1, paramInt2);
  }
  
  static final class a
    extends i.b
  {
    public final void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
    {
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
    }
  }
  
  static class b
  {
    public void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
    {
      paramEdgeEffect.onPull(paramFloat1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.i
 * JD-Core Version:    0.7.0.1
 */