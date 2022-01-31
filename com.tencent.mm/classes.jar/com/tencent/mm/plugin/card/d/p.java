package com.tencent.mm.plugin.card.d;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public static void xJ(String paramString)
  {
    AppMethodBeat.i(88942);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new n();
      n.xJ(paramString);
      AppMethodBeat.o(88942);
      return;
    }
    new o();
    o.xJ(paramString);
    AppMethodBeat.o(88942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.p
 * JD-Core Version:    0.7.0.1
 */