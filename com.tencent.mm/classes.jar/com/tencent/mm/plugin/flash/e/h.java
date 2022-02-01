package com.tencent.mm.plugin.flash.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.facedetect.b.p;

public final class h
  implements a
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2, i parami)
  {
    AppMethodBeat.i(194096);
    paramString1 = new p(paramLong, paramString1, paramString2);
    com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
    AppMethodBeat.o(194096);
  }
  
  public final String epR()
  {
    return "faceregister_ticket";
  }
  
  public final int getType()
  {
    return 930;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.e.h
 * JD-Core Version:    0.7.0.1
 */