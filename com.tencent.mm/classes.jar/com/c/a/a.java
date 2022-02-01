package com.c.a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;

public final class a
  implements k.c
{
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(130925);
    if (paramj.method.equals("getPlatformVersion"))
    {
      paramd.df("Android " + Build.VERSION.RELEASE);
      AppMethodBeat.o(130925);
      return;
    }
    paramd.dmQ();
    AppMethodBeat.o(130925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.c.a.a
 * JD-Core Version:    0.7.0.1
 */