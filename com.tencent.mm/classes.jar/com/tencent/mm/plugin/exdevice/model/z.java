package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class z
  extends n
  implements k
{
  b grW;
  private f gzH;
  private String qdc;
  
  public z(LinkedList<bca> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23424);
    this.qdc = "";
    this.grW = null;
    this.gzH = null;
    this.qdc = paramString2;
    paramString2 = new b.a();
    paramString2.hNM = new bcb();
    paramString2.hNN = new bcc();
    paramString2.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
    paramString2.funcId = 543;
    paramString2.hNO = 0;
    paramString2.respCmdId = 0;
    this.grW = paramString2.aDC();
    paramString2 = (bcb)this.grW.hNK.hNQ;
    if (!bt.isNullOrNil(paramString1))
    {
      bbz localbbz = new bbz();
      localbbz.FCL = paramString1;
      paramString2.GyP = localbbz;
    }
    paramString2.GyO = paramLinkedList;
    AppMethodBeat.o(23424);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23425);
    this.gzH = paramf;
    int i = dispatch(parame, this.grW, this);
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
    ad.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gzH != null) {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.z
 * JD-Core Version:    0.7.0.1
 */