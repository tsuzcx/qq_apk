package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class ad
  extends p
  implements m
{
  private h mAY;
  c mtC;
  private String ysi;
  
  public ad(LinkedList<ckt> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23424);
    this.ysi = "";
    this.mtC = null;
    this.mAY = null;
    this.ysi = paramString2;
    paramString2 = new c.a();
    paramString2.otE = new cku();
    paramString2.otF = new ckv();
    paramString2.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
    paramString2.funcId = 543;
    paramString2.otG = 0;
    paramString2.respCmdId = 0;
    this.mtC = paramString2.bEF();
    paramString2 = (cku)c.b.b(this.mtC.otB);
    if (!Util.isNullOrNil(paramString1))
    {
      cks localcks = new cks();
      localcks.YNd = paramString1;
      paramString2.aasV = localcks;
    }
    paramString2.aasU = paramLinkedList;
    AppMethodBeat.o(23424);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23425);
    this.mAY = paramh;
    int i = dispatch(paramg, this.mtC, this);
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
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad
 * JD-Core Version:    0.7.0.1
 */