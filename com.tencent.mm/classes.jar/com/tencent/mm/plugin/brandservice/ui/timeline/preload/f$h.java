package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.m;
import a.f.b.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"format", "", "kotlin.jvm.PlatformType", "", "digits", "", "invoke"})
final class f$h
  extends k
  implements m<Float, Integer, String>
{
  public static final h kbw;
  
  static
  {
    AppMethodBeat.i(14815);
    kbw = new h();
    AppMethodBeat.o(14815);
  }
  
  f$h()
  {
    super(2);
  }
  
  public static String d(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(14814);
    String str = String.format("%." + paramInt + 'f', new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(14814);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.h
 * JD-Core Version:    0.7.0.1
 */