package com.tencent.mm.plugin.flash.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;

public final class c
  implements a
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2, i parami)
  {
    AppMethodBeat.i(186702);
    paramString1 = new com.tencent.mm.plugin.facedetect.b.t(paramLong, paramString1, paramString2);
    g.azz().a(paramString1, 0);
    AppMethodBeat.o(186702);
  }
  
  public final String getResultKey()
  {
    return "faceverify_ticket";
  }
  
  public final int getType()
  {
    return 930;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.e.c
 * JD-Core Version:    0.7.0.1
 */