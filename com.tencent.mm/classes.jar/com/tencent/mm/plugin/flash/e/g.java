package com.tencent.mm.plugin.flash.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.facedetect.b.m;

public final class g
  implements a
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2, i parami)
  {
    AppMethodBeat.i(186706);
    paramString1 = new m(paramLong, paramString3, paramString4, paramString1, paramString2, paramInt1, paramFloat, paramInt2);
    com.tencent.mm.kernel.g.azz().a(paramString1, 0);
    AppMethodBeat.o(186706);
  }
  
  public final String getResultKey()
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