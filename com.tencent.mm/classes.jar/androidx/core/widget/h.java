package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class h
{
  public OverScroller Qi;
  
  private h(Context paramContext, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(253105);
    if (paramInterpolator != null) {}
    for (paramContext = new OverScroller(paramContext, paramInterpolator);; paramContext = new OverScroller(paramContext))
    {
      this.Qi = paramContext;
      AppMethodBeat.o(253105);
      return;
    }
  }
  
  @Deprecated
  public static h a(Context paramContext, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(253103);
    paramContext = new h(paramContext, paramInterpolator);
    AppMethodBeat.o(253103);
    return paramContext;
  }
  
  @Deprecated
  public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(253107);
    this.Qi.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(253107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.widget.h
 * JD-Core Version:    0.7.0.1
 */