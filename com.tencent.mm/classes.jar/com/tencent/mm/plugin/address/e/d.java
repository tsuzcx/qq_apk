package com.tencent.mm.plugin.address.e;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static void xJ(String paramString)
  {
    AppMethodBeat.i(17013);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new b();
      b.xJ(paramString);
      AppMethodBeat.o(17013);
      return;
    }
    new c();
    c.xJ(paramString);
    AppMethodBeat.o(17013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.d
 * JD-Core Version:    0.7.0.1
 */