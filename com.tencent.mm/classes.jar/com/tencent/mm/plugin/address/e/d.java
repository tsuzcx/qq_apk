package com.tencent.mm.plugin.address.e;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static void KG(String paramString)
  {
    AppMethodBeat.i(21056);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new b();
      b.KG(paramString);
      AppMethodBeat.o(21056);
      return;
    }
    new c();
    c.KG(paramString);
    AppMethodBeat.o(21056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.d
 * JD-Core Version:    0.7.0.1
 */