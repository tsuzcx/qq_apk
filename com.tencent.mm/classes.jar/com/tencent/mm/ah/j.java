package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

public class j
  extends f
{
  public int hCu = 0;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20240);
    if (paramb.type == 2000)
    {
      this.hCu = 0;
      ae.i("MicroMsg.AppContentTransferMsgPiece", "hasTransferAddress: %s", new Object[] { Integer.valueOf(this.hCu) });
    }
    AppMethodBeat.o(20240);
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(20239);
    j localj = new j();
    AppMethodBeat.o(20239);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.j
 * JD-Core Version:    0.7.0.1
 */