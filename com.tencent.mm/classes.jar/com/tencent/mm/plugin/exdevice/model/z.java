package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class z
  extends n
  implements k
{
  private f gCo;
  b gux;
  private String qjH;
  
  public z(LinkedList<bcq> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23424);
    this.qjH = "";
    this.gux = null;
    this.gCo = null;
    this.qjH = paramString2;
    paramString2 = new b.a();
    paramString2.hQF = new bcr();
    paramString2.hQG = new bcs();
    paramString2.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
    paramString2.funcId = 543;
    paramString2.hQH = 0;
    paramString2.respCmdId = 0;
    this.gux = paramString2.aDS();
    paramString2 = (bcr)this.gux.hQD.hQJ;
    if (!bu.isNullOrNil(paramString1))
    {
      bcp localbcp = new bcp();
      localbcp.FVg = paramString1;
      paramString2.GSp = localbcp;
    }
    paramString2.GSo = paramLinkedList;
    AppMethodBeat.o(23424);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23425);
    this.gCo = paramf;
    int i = dispatch(parame, this.gux, this);
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
    ae.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gCo != null) {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.z
 * JD-Core Version:    0.7.0.1
 */