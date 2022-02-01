package com.tencent.mm.plugin.card.d;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static void TF(String paramString)
  {
    AppMethodBeat.i(113870);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new o();
      o.TF(paramString);
      AppMethodBeat.o(113870);
      return;
    }
    new p();
    p.TF(paramString);
    AppMethodBeat.o(113870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.q
 * JD-Core Version:    0.7.0.1
 */