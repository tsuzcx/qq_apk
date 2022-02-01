package com.tencent.mm.plugin.flash.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.facedetect.b.n;

public final class g
  implements a
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(264657);
    paramString1 = new n(paramLong, paramString3, paramString4, paramString1, paramString2, paramInt1, paramFloat, paramInt2);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    AppMethodBeat.o(264657);
  }
  
  public final String fuT()
  {
    return "verify_result";
  }
  
  public final int getType()
  {
    return 1080;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.e.g
 * JD-Core Version:    0.7.0.1
 */