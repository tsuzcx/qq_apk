package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

public class i
  extends f
{
  public int fgo = 0;
  
  public final f Yk()
  {
    AppMethodBeat.i(16196);
    i locali = new i();
    AppMethodBeat.o(16196);
    return locali;
  }
  
  public final void a(Map<String, String> paramMap, j.b paramb)
  {
    AppMethodBeat.i(16197);
    if (paramb.type == 2000)
    {
      this.fgo = 0;
      ab.i("MicroMsg.AppContentTransferMsgPiece", "hasTransferAddress: %s", new Object[] { Integer.valueOf(this.fgo) });
    }
    AppMethodBeat.o(16197);
  }
  
  public final void b(StringBuilder paramStringBuilder, j.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.af.i
 * JD-Core Version:    0.7.0.1
 */