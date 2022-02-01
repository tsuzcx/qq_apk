package com.tencent.mm.plugin.flash.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.facedetect.b.u;

public final class c
  implements a
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(264646);
    paramString1 = new u(paramLong, paramString1, paramString2);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    AppMethodBeat.o(264646);
  }
  
  public final String fuT()
  {
    return "faceverify_ticket";
  }
  
  public final int getType()
  {
    return 930;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.e.c
 * JD-Core Version:    0.7.0.1
 */