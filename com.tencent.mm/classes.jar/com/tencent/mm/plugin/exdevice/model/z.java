package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class z
  extends m
  implements k
{
  private f eGj;
  private String lFB;
  b lFp;
  
  public z(LinkedList<alc> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(19355);
    this.lFB = "";
    this.lFp = null;
    this.eGj = null;
    this.lFB = paramString2;
    paramString2 = new b.a();
    paramString2.fsX = new ald();
    paramString2.fsY = new ale();
    paramString2.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
    paramString2.funcId = 543;
    paramString2.reqCmdId = 0;
    paramString2.respCmdId = 0;
    this.lFp = paramString2.ado();
    paramString2 = (ald)this.lFp.fsV.fta;
    if (!bo.isNullOrNil(paramString1))
    {
      alb localalb = new alb();
      localalb.wuS = paramString1;
      paramString2.xcc = localalb;
    }
    paramString2.xcb = paramLinkedList;
    AppMethodBeat.o(19355);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19356);
    this.eGj = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(19356);
    return i;
  }
  
  public final int getType()
  {
    return 543;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19357);
    ab.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.eGj != null) {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(19357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.z
 * JD-Core Version:    0.7.0.1
 */