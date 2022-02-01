package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class i
{
  public OverScroller bwz;
  
  private i(Context paramContext, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(195367);
    if (paramInterpolator != null) {}
    for (paramContext = new OverScroller(paramContext, paramInterpolator);; paramContext = new OverScroller(paramContext))
    {
      this.bwz = paramContext;
      AppMethodBeat.o(195367);
      return;
    }
  }
  
  @Deprecated
  public static i a(Context paramContext, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(195359);
    paramContext = new i(paramContext, paramInterpolator);
    AppMethodBeat.o(195359);
    return paramContext;
  }
  
  @Deprecated
  public final int Fo()
  {
    AppMethodBeat.i(195390);
    int i = this.bwz.getCurrX();
    AppMethodBeat.o(195390);
    return i;
  }
  
  @Deprecated
  public final int Fp()
  {
    AppMethodBeat.i(195400);
    int i = this.bwz.getCurrY();
    AppMethodBeat.o(195400);
    return i;
  }
  
  @Deprecated
  public final int Fq()
  {
    AppMethodBeat.i(195412);
    int i = this.bwz.getFinalX();
    AppMethodBeat.o(195412);
    return i;
  }
  
  @Deprecated
  public final int Fr()
  {
    AppMethodBeat.i(195419);
    int i = this.bwz.getFinalY();
    AppMethodBeat.o(195419);
    return i;
  }
  
  @Deprecated
  public final boolean Fs()
  {
    AppMethodBeat.i(195427);
    boolean bool = this.bwz.computeScrollOffset();
    AppMethodBeat.o(195427);
    return bool;
  }
  
  @Deprecated
  public final void Ft()
  {
    AppMethodBeat.i(195455);
    this.bwz.abortAnimation();
    AppMethodBeat.o(195455);
  }
  
  @Deprecated
  public final boolean isFinished()
  {
    AppMethodBeat.i(195379);
    boolean bool = this.bwz.isFinished();
    AppMethodBeat.o(195379);
    return bool;
  }
  
  @Deprecated
  public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(195438);
    this.bwz.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(195438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.widget.i
 * JD-Core Version:    0.7.0.1
 */