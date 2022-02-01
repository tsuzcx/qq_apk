package com.tencent.mm.plugin.flash.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.facedetect.b.o;

public final class f
  implements a
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(264658);
    paramString1 = new o(paramLong, paramString1, paramString2);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    AppMethodBeat.o(264658);
  }
  
  public final String fuT()
  {
    return "faceregister_ticket";
  }
  
  public final int getType()
  {
    return 918;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.e.f
 * JD-Core Version:    0.7.0.1
 */