package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dxe;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g
  extends q
  implements m
{
  private i callback;
  public String pTY;
  public int pTZ;
  public String pUa;
  private final d rr;
  
  public g(int paramInt1, LinkedList<dxg> paramLinkedList, String paramString1, String paramString2, dxy paramdxy, int paramInt2, eck parameck)
  {
    AppMethodBeat.i(112972);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dxe();
    ((d.a)localObject).iLO = new dxf();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sharecarditem";
    ((d.a)localObject).funcId = 902;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dxe)this.rr.iLK.iLR;
    ((dxe)localObject).MXj = paramInt1;
    ((dxe)localObject).iAd = paramLinkedList;
    ((dxe)localObject).gTT = paramString1;
    ((dxe)localObject).LTz = paramString2;
    Log.i("MicroMsg.NetSceneShareCardItem", "list length is " + paramLinkedList.size());
    ((dxe)localObject).MXk = paramdxy;
    ((dxe)localObject).eaQ = paramInt2;
    ((dxe)localObject).KDj = parameck;
    AppMethodBeat.o(112972);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(112974);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112974);
    return i;
  }
  
  public final int getType()
  {
    return 902;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112973);
    Log.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
      params = (dxf)this.rr.iLL.iLR;
      if (params != null)
      {
        this.pTY = params.pTY;
        this.pTZ = params.pTZ;
        this.pUa = params.pUa;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112973);
      return;
      params = (dxf)this.rr.iLL.iLR;
      if (params != null)
      {
        this.pTY = params.pTY;
        this.pTZ = params.pTZ;
        this.pUa = params.pUa;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.g
 * JD-Core Version:    0.7.0.1
 */