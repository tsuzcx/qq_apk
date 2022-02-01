package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.cun;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public ah(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(112858);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cun();
    ((b.a)localObject).hQG = new cuo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
    ((b.a)localObject).funcId = 1275;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    ((cun)this.rr.hQD.hQJ).HFq = paramLinkedList;
    if (paramLinkedList != null)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (cha)paramLinkedList.next();
        ae.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", new Object[] { ((cha)localObject).dJb, ((cha)localObject).oGg, Integer.valueOf(((cha)localObject).HsT), Integer.valueOf(((cha)localObject).HsU) });
      }
    }
    AppMethodBeat.o(112858);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112860);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ah
 * JD-Core Version:    0.7.0.1
 */