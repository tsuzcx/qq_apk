package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Arrays;

public final class b
  extends n
  implements k
{
  private f callback;
  private bbe rpg;
  public bbf rph;
  private com.tencent.mm.al.b rr;
  
  public b(String paramString1, String paramString2, float paramFloat, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(213174);
    b.a locala = new b.a();
    locala.hNM = new bbe();
    locala.hNN = new bbf();
    locala.funcId = 2726;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckresult";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.rpg = ((bbe)this.rr.hNK.hNQ);
    this.rpg.person_id = paramString1;
    this.rpg.action_data = paramString2;
    this.rpg.Gyk = ((int)paramFloat);
    this.rpg.Gyl = paramString3;
    this.rpg.FEW = paramString4;
    this.rpg.scene = paramInt;
    this.rpg.FWx = paramString5;
    this.rpg.pkf = paramString6;
    this.rpg.Gxf = ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).dos();
    this.rpg.Gym = com.tencent.mm.bx.b.cj(paramArrayOfByte);
    this.rpg.Gyn = paramBoolean;
    ad.i("MicroMsg.NetSceneGetFaceCheckResult", "create GetFaceCheckResult, personId: %s, actionData: %s, reductionRatio: %s, videoFileid: %s, scene: %s, takeMessage: %s, packageName: %s，hash: %s", new Object[] { paramString1, paramString2, Float.valueOf(paramFloat), paramString3, Integer.valueOf(paramInt), paramString5, paramString6, Arrays.toString(paramArrayOfByte) });
    AppMethodBeat.o(213174);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(104199);
    this.callback = paramf;
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
    ad.i("MicroMsg.NetSceneGetFaceCheckResult", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = com.tencent.mm.plugin.report.service.g.yhR;
    if (paramInt3 == 0) {}
    for (long l = 54L;; l = 55L)
    {
      paramArrayOfByte.idkeyStat(917L, l, 1L, false);
      this.rph = ((bbf)((com.tencent.mm.al.b)paramq).hNL.hNQ);
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