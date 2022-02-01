package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Arrays;

public final class b
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private axe qFp;
  public axf qFq;
  private com.tencent.mm.ak.b rr;
  
  public b(String paramString1, String paramString2, float paramFloat, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104198);
    b.a locala = new b.a();
    locala.hvt = new axe();
    locala.hvu = new axf();
    locala.funcId = 2726;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckresult";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.qFp = ((axe)this.rr.hvr.hvw);
    this.qFp.person_id = paramString1;
    this.qFp.action_data = paramString2;
    this.qFp.EPd = ((int)paramFloat);
    this.qFp.EPe = paramString3;
    this.qFp.DZy = paramString4;
    this.qFp.scene = paramInt;
    this.qFp.Epl = paramString5;
    this.qFp.oGB = paramString6;
    this.qFp.EOb = ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).deU();
    this.qFp.EPf = com.tencent.mm.bw.b.cc(paramArrayOfByte);
    ac.i("MicroMsg.NetSceneGetFaceCheckResult", "create GetFaceCheckResult, personId: %s, actionData: %s, reductionRatio: %s, videoFileid: %s, scene: %s, takeMessage: %s, packageName: %s，hash: %s", new Object[] { paramString1, paramString2, Float.valueOf(paramFloat), paramString3, Integer.valueOf(paramInt), paramString5, paramString6, Arrays.toString(paramArrayOfByte) });
    AppMethodBeat.o(104198);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(104199);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(104199);
    return i;
  }
  
  public final int getType()
  {
    return 2726;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104200);
    ac.i("MicroMsg.NetSceneGetFaceCheckResult", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = h.wUl;
    if (paramInt3 == 0) {}
    for (long l = 54L;; l = 55L)
    {
      paramArrayOfByte.idkeyStat(917L, l, 1L, false);
      this.qFq = ((axf)((com.tencent.mm.ak.b)paramq).hvs.hvw);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104200);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.b
 * JD-Core Version:    0.7.0.1
 */