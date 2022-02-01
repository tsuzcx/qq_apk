package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.sdk.platformtools.Log;

public final class aj
  extends q
  implements m
{
  private i callback;
  public boolean idt;
  public String pTY;
  public b pUz;
  private final d rr;
  
  public aj(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, b paramb)
  {
    AppMethodBeat.i(112864);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bil();
    ((d.a)localObject).iLO = new bim();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getavailablecard";
    ((d.a)localObject).funcId = 1059;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bil)this.rr.iLK.iLR;
    ((bil)localObject).app_id = paramString1;
    ((bil)localObject).qcJ = paramInt1;
    ((bil)localObject).qcK = paramString2;
    ((bil)localObject).qcL = paramString3;
    ((bil)localObject).time_stamp = paramInt2;
    ((bil)localObject).qcM = paramString4;
    ((bil)localObject).pRX = paramString5;
    ((bil)localObject).qcN = paramString6;
    ((bil)localObject).pUz = paramb;
    if ("INVOICE".equalsIgnoreCase(paramString6))
    {
      ((bil)localObject).LSC = 1;
      AppMethodBeat.o(112864);
      return;
    }
    ((bil)localObject).LSC = 0;
    AppMethodBeat.o(112864);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112865);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112865);
    return i;
  }
  
  public final int getType()
  {
    return 1059;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112866);
    Log.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bim)this.rr.iLL.iLR;
      this.pTY = params.pTY;
      this.pUz = params.pUz;
      if (params.LSD == 0) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      this.idt = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aj
 * JD-Core Version:    0.7.0.1
 */