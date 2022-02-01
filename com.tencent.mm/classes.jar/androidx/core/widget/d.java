package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public EdgeEffect Qf;
  
  @Deprecated
  public d(Context paramContext)
  {
    AppMethodBeat.i(252445);
    this.Qf = new EdgeEffect(paramContext);
    AppMethodBeat.o(252445);
  }
  
  public static void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(252451);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
      AppMethodBeat.o(252451);
      return;
    }
    paramEdgeEffect.onPull(paramFloat1);
    AppMethodBeat.o(252451);
  }
  
  @Deprecated
  public final boolean a(Canvas paramCanvas)
  {
    AppMethodBeat.i(252457);
    boolean bool = this.Qf.draw(paramCanvas);
    AppMethodBeat.o(252457);
    return bool;
  }
  
  @Deprecated
  public final boolean bJ(int paramInt)
  {
    AppMethodBeat.i(252455);
    this.Qf.onAbsorb(paramInt);
    AppMethodBeat.o(252455);
    return true;
  }
  
  @Deprecated
  public final boolean hD()
  {
    AppMethodBeat.i(252453);
    this.Qf.onRelease();
    boolean bool = this.Qf.isFinished();
    AppMethodBeat.o(252453);
    return bool;
  }
  
  @Deprecated
  public final boolean m(float paramFloat)
  {
    AppMethodBeat.i(252449);
    this.Qf.onPull(paramFloat);
    AppMethodBeat.o(252449);
    return true;
  }
  
  @Deprecated
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252447);
    this.Qf.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(252447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.widget.d
 * JD-Core Version:    0.7.0.1
 */