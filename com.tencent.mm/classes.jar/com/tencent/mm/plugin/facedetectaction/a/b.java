package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.protobuf.aki;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends m
  implements k
{
  private f callback;
  private aki mqb;
  public akj mqc;
  private com.tencent.mm.ai.b rr;
  
  public b(String paramString1, String paramString2, float paramFloat, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    AppMethodBeat.i(673);
    b.a locala = new b.a();
    locala.fsX = new aki();
    locala.fsY = new akj();
    locala.funcId = 2726;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckresult";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.mqb = ((aki)this.rr.fsV.fta);
    this.mqb.person_id = paramString1;
    this.mqb.xby = paramString2;
    this.mqb.xbB = ((int)paramFloat);
    this.mqb.xbC = paramString3;
    this.mqb.xbD = paramString4;
    this.mqb.scene = paramInt;
    this.mqb.wKp = paramString5;
    this.mqb.kWn = paramString6;
    this.mqb.xaW = ((c)g.E(c.class)).bSo();
    ab.i("MicroMsg.NetSceneGetFaceCheckResult", "create GetFaceCheckResult, personId: %s, actionData: %s, reductionRatio: %s, videoFileid: %s, scene: %s, takeMessage: %s, packageName: %s", new Object[] { paramString1, paramString2, Float.valueOf(paramFloat), paramString3, Integer.valueOf(paramInt), paramString5, paramString6 });
    AppMethodBeat.o(673);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(674);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(674);
    return i;
  }
  
  public final int getType()
  {
    return 2726;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(675);
    ab.i("MicroMsg.NetSceneGetFaceCheckResult", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = h.qsU;
    if (paramInt3 == 0) {}
    for (long l = 54L;; l = 55L)
    {
      paramArrayOfByte.idkeyStat(917L, l, 1L, false);
      this.mqc = ((akj)((com.tencent.mm.ai.b)paramq).fsW.fta);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(675);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.b
 * JD-Core Version:    0.7.0.1
 */