package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.SpanWatcher;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class z$2
  implements SpanWatcher
{
  z$2(z paramz) {}
  
  public final void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123829);
    if (aj.bB(paramObject)) {
      ab.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", new Object[] { paramSpannable, paramObject.getClass().getSimpleName() });
    }
    AppMethodBeat.o(123829);
  }
  
  public final void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(123831);
    if (aj.bB(paramObject)) {
      ab.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", new Object[] { paramSpannable, paramObject.getClass().getSimpleName() });
    }
    AppMethodBeat.o(123831);
  }
  
  public final void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123830);
    if (aj.bB(paramObject))
    {
      ab.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", new Object[] { paramSpannable, paramObject.getClass().getSimpleName() });
      z.c(this.jnU).removeCallbacks(z.b(this.jnU));
      z.c(this.jnU).postDelayed(z.b(this.jnU), 100L);
    }
    AppMethodBeat.o(123830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.z.2
 * JD-Core Version:    0.7.0.1
 */