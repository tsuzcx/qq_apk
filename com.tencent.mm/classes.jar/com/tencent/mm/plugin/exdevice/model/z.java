package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class z
  extends n
  implements k
{
  b fUF;
  private g gbr;
  private String oWm;
  
  public z(LinkedList<aus> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23424);
    this.oWm = "";
    this.fUF = null;
    this.gbr = null;
    this.oWm = paramString2;
    paramString2 = new b.a();
    paramString2.gUU = new aut();
    paramString2.gUV = new auu();
    paramString2.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
    paramString2.funcId = 543;
    paramString2.reqCmdId = 0;
    paramString2.respCmdId = 0;
    this.fUF = paramString2.atI();
    paramString2 = (aut)this.fUF.gUS.gUX;
    if (!bt.isNullOrNil(paramString1))
    {
      aur localaur = new aur();
      localaur.CEP = paramString1;
      paramString2.Duv = localaur;
    }
    paramString2.Duu = paramLinkedList;
    AppMethodBeat.o(23424);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23425);
    this.gbr = paramg;
    int i = dispatch(parame, this.fUF, this);
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
    if (this.gbr != null) {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.z
 * JD-Core Version:    0.7.0.1
 */