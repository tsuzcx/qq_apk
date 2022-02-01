package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public class j
  extends f
{
  public int iwA = 0;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20240);
    if (paramb.type == 2000)
    {
      this.iwA = 0;
      Log.i("MicroMsg.AppContentTransferMsgPiece", "hasTransferAddress: %s", new Object[] { Integer.valueOf(this.iwA) });
    }
    AppMethodBeat.o(20240);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(20239);
    j localj = new j();
    AppMethodBeat.o(20239);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ag.j
 * JD-Core Version:    0.7.0.1
 */