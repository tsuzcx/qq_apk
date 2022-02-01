package com.tencent.mm.plugin.flash.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.b.n;

public final class f
  implements a
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2, i parami)
  {
    AppMethodBeat.i(186705);
    paramString1 = new n(paramLong, paramString1, paramString2);
    g.azz().a(paramString1, 0);
    AppMethodBeat.o(186705);
  }
  
  public final String getResultKey()
  {
    return "faceregister_ticket";
  }
  
  public final int getType()
  {
    return 918;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.e.f
 * JD-Core Version:    0.7.0.1
 */