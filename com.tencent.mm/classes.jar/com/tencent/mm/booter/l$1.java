package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ab;

final class l$1
  implements b.a
{
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(15854);
    if (paramBoolean)
    {
      ab.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
      l.ab(paramFloat2);
      l.ac(paramFloat1);
      l.access$202(true);
      if (l.Iv() != null)
      {
        l.Iv().c(l.Iw());
        l.access$202(false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(15854);
      return false;
      ab.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.l.1
 * JD-Core Version:    0.7.0.1
 */