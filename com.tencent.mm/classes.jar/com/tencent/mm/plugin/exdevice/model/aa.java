package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.protocal.protobuf.bvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class aa
  extends q
  implements m
{
  private i jQg;
  d jTk;
  private String vgj;
  
  public aa(LinkedList<bvr> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23424);
    this.vgj = "";
    this.jTk = null;
    this.jQg = null;
    this.vgj = paramString2;
    paramString2 = new d.a();
    paramString2.lBU = new bvs();
    paramString2.lBV = new bvt();
    paramString2.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
    paramString2.funcId = 543;
    paramString2.lBW = 0;
    paramString2.respCmdId = 0;
    this.jTk = paramString2.bgN();
    paramString2 = (bvs)d.b.b(this.jTk.lBR);
    if (!Util.isNullOrNil(paramString1))
    {
      bvq localbvq = new bvq();
      localbvq.RPP = paramString1;
      paramString2.TfB = localbvq;
    }
    paramString2.TfA = paramLinkedList;
    AppMethodBeat.o(23424);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23425);
    this.jQg = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(23425);
    return i;
  }
  
  public final int getType()
  {
    return 543;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23426);
    Log.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.aa
 * JD-Core Version:    0.7.0.1
 */