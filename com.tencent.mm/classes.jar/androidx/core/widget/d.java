package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public EdgeEffect bww;
  
  @Deprecated
  public d(Context paramContext)
  {
    AppMethodBeat.i(195327);
    this.bww = new EdgeEffect(paramContext);
    AppMethodBeat.o(195327);
  }
  
  public static void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(195333);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
      AppMethodBeat.o(195333);
      return;
    }
    paramEdgeEffect.onPull(paramFloat1);
    AppMethodBeat.o(195333);
  }
  
  @Deprecated
  public final boolean Fi()
  {
    AppMethodBeat.i(195352);
    this.bww.onRelease();
    boolean bool = this.bww.isFinished();
    AppMethodBeat.o(195352);
    return bool;
  }
  
  @Deprecated
  public final boolean as(float paramFloat)
  {
    AppMethodBeat.i(195345);
    this.bww.onPull(paramFloat);
    AppMethodBeat.o(195345);
    return true;
  }
  
  @Deprecated
  public final boolean d(Canvas paramCanvas)
  {
    AppMethodBeat.i(195363);
    boolean bool = this.bww.draw(paramCanvas);
    AppMethodBeat.o(195363);
    return bool;
  }
  
  @Deprecated
  public final boolean eE(int paramInt)
  {
    AppMethodBeat.i(195357);
    this.bww.onAbsorb(paramInt);
    AppMethodBeat.o(195357);
    return true;
  }
  
  @Deprecated
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195339);
    this.bww.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(195339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.widget.d
 * JD-Core Version:    0.7.0.1
 */