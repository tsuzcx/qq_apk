package com.b.a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.j;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;

public final class a
  implements k.c
{
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(130925);
    if (paramj.method.equals("getPlatformVersion"))
    {
      paramd.ay("Android " + Build.VERSION.RELEASE);
      AppMethodBeat.o(130925);
      return;
    }
    paramd.Av();
    AppMethodBeat.o(130925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.a
 * JD-Core Version:    0.7.0.1
 */