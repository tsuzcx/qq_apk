package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.cor;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public ah(LinkedList<cbp> paramLinkedList)
  {
    AppMethodBeat.i(112858);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new coq();
    ((b.a)localObject).hvu = new cor();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
    ((b.a)localObject).funcId = 1275;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    ((coq)this.rr.hvr.hvw).FBD = paramLinkedList;
    if (paramLinkedList != null)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (cbp)paramLinkedList.next();
        ac.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", new Object[] { ((cbp)localObject).dvO, ((cbp)localObject).nWk, Integer.valueOf(((cbp)localObject).FpI), Integer.valueOf(((cbp)localObject).FpJ) });
      }
    }
    AppMethodBeat.o(112858);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112860);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112860);
    return i;
  }
  
  public final int getType()
  {
    return 1275;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112859);
    ac.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ah
 * JD-Core Version:    0.7.0.1
 */