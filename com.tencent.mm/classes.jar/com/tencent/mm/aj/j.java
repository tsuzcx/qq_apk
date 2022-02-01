package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class j
  extends f
{
  public int llN = 0;
  public String llO;
  public String llP;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20240);
    if (paramb.type == 2000)
    {
      this.llN = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.has_transfer_address"), 0);
      this.llO = Util.nullAs((String)paramMap.get(".msg.appmsg.wcpayinfo.receiver_username"), "");
      this.llP = Util.nullAs((String)paramMap.get(".msg.appmsg.wcpayinfo.payer_username"), "");
      Log.i("MicroMsg.AppContentTransferMsgPiece", "hasTransferAddress: %s", new Object[] { Integer.valueOf(this.llN) });
    }
    AppMethodBeat.o(20240);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(20239);
    j localj = new j();
    AppMethodBeat.o(20239);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.j
 * JD-Core Version:    0.7.0.1
 */