package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class z
  extends q
  implements m
{
  private i heq;
  d hhm;
  private String rAC;
  
  public z(LinkedList<boc> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23424);
    this.rAC = "";
    this.hhm = null;
    this.heq = null;
    this.rAC = paramString2;
    paramString2 = new d.a();
    paramString2.iLN = new bod();
    paramString2.iLO = new boe();
    paramString2.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
    paramString2.funcId = 543;
    paramString2.iLP = 0;
    paramString2.respCmdId = 0;
    this.hhm = paramString2.aXF();
    paramString2 = (bod)this.hhm.iLK.iLR;
    if (!Util.isNullOrNil(paramString1))
    {
      bob localbob = new bob();
      localbob.KOR = paramString1;
      paramString2.LWu = localbob;
    }
    paramString2.LWt = paramLinkedList;
    AppMethodBeat.o(23424);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23425);
    this.heq = parami;
    int i = dispatch(paramg, this.hhm, this);
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
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.z
 * JD-Core Version:    0.7.0.1
 */