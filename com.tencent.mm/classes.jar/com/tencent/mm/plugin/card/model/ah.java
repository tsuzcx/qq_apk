package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgg;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public ah(LinkedList<cgg> paramLinkedList)
  {
    AppMethodBeat.i(112858);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ctt();
    ((b.a)localObject).hNN = new ctu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
    ((b.a)localObject).funcId = 1275;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    ((ctt)this.rr.hNK.hNQ).HlQ = paramLinkedList;
    if (paramLinkedList != null)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (cgg)paramLinkedList.next();
        ad.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", new Object[] { ((cgg)localObject).dHX, ((cgg)localObject).ozE, Integer.valueOf(((cgg)localObject).GZs), Integer.valueOf(((cgg)localObject).GZt) });
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
    ad.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ah
 * JD-Core Version:    0.7.0.1
 */