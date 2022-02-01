package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class b
  extends q
  implements m
{
  private i callback;
  private d rr;
  private bng sXh;
  public bnh sXi;
  
  public b(String paramString1, String paramString2, float paramFloat, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(186388);
    d.a locala = new d.a();
    locala.iLN = new bng();
    locala.iLO = new bnh();
    locala.funcId = 2726;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckresult";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.sXh = ((bng)this.rr.iLK.iLR);
    this.sXh.person_id = paramString1;
    this.sXh.action_data = paramString2;
    this.sXh.LVP = ((int)paramFloat);
    this.sXh.LVQ = paramString3;
    this.sXh.KRe = paramString4;
    this.sXh.scene = paramInt;
    this.sXh.LjH = paramString5;
    this.sXh.qGp = paramString6;
    this.sXh.LUV = ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.b.class)).elk();
    this.sXh.LVR = com.tencent.mm.bw.b.cD(paramArrayOfByte);
    this.sXh.LVS = paramBoolean;
    Log.i("MicroMsg.NetSceneGetFaceCheckResult", "create GetFaceCheckResult, personId: %s, actionData: %s, reductionRatio: %s, videoFileid: %s, scene: %s, takeMessage: %s, packageName: %s，hash: %s", new Object[] { paramString1, paramString2, Float.valueOf(paramFloat), paramString3, Integer.valueOf(paramInt), paramString5, paramString6, Arrays.toString(paramArrayOfByte) });
    AppMethodBeat.o(186388);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(104199);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(104199);
    return i;
  }
  
  public final int getType()
  {
    return 2726;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104200);
    Log.i("MicroMsg.NetSceneGetFaceCheckResult", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = h.CyF;
    if (paramInt3 == 0) {}
    for (long l = 54L;; l = 55L)
    {
      paramArrayOfByte.idkeyStat(917L, l, 1L, false);
      this.sXi = ((bnh)((d)params).iLL.iLR);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104200);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.b
 * JD-Core Version:    0.7.0.1
 */