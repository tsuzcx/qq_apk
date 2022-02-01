package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.dng;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public ah(LinkedList<cxh> paramLinkedList)
  {
    AppMethodBeat.i(112858);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dng();
    ((d.a)localObject).iLO = new dnh();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
    ((d.a)localObject).funcId = 1275;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    ((dng)this.rr.iLK.iLR).MQA = paramLinkedList;
    if (paramLinkedList != null)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (cxh)paramLinkedList.next();
        Log.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", new Object[] { ((cxh)localObject).eaO, ((cxh)localObject).pTM, Integer.valueOf(((cxh)localObject).MBP), Integer.valueOf(((cxh)localObject).MBQ) });
      }
    }
    AppMethodBeat.o(112858);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112860);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112860);
    return i;
  }
  
  public final int getType()
  {
    return 1275;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112859);
    Log.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ah
 * JD-Core Version:    0.7.0.1
 */