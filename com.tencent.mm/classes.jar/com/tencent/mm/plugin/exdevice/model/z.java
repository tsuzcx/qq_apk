package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class z
  extends n
  implements k
{
  b fYA;
  private g gfX;
  private String pzx;
  
  public z(LinkedList<axy> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23424);
    this.pzx = "";
    this.fYA = null;
    this.gfX = null;
    this.pzx = paramString2;
    paramString2 = new b.a();
    paramString2.hvt = new axz();
    paramString2.hvu = new aya();
    paramString2.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
    paramString2.funcId = 543;
    paramString2.reqCmdId = 0;
    paramString2.respCmdId = 0;
    this.fYA = paramString2.aAz();
    paramString2 = (axz)this.fYA.hvr.hvw;
    if (!bs.isNullOrNil(paramString1))
    {
      axx localaxx = new axx();
      localaxx.DXp = paramString1;
      paramString2.EPE = localaxx;
    }
    paramString2.EPD = paramLinkedList;
    AppMethodBeat.o(23424);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23425);
    this.gfX = paramg;
    int i = dispatch(parame, this.fYA, this);
    AppMethodBeat.o(23425);
    return i;
  }
  
  public final int getType()
  {
    return 543;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23426);
    ac.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.z
 * JD-Core Version:    0.7.0.1
 */