package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class c
  extends q
  implements m
{
  private i callback;
  private d rr;
  private buw wDh;
  public bux wDi;
  
  public c(String paramString1, String paramString2, float paramFloat, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramFloat, paramString3, paramString4, paramInt, paramString5, paramString6, paramArrayOfByte, paramBoolean, 1, 0L, 0.0D, 0.0D);
  }
  
  public c(String paramString1, String paramString2, float paramFloat, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt2, long paramLong, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(195253);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new buw();
    ((d.a)localObject).lBV = new bux();
    ((d.a)localObject).funcId = 2726;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/getfacecheckresult";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    this.wDh = ((buw)d.b.b(this.rr.lBR));
    this.wDh.person_id = paramString1;
    this.wDh.action_data = paramString2;
    this.wDh.TeT = paramFloat;
    this.wDh.TeW = paramString3;
    this.wDh.RRZ = paramString4;
    this.wDh.scene = paramInt1;
    this.wDh.SkY = paramString5;
    this.wDh.ufq = paramString6;
    localObject = ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.b.class)).eUT();
    paramString4 = (String)localObject;
    if (localObject == null)
    {
      Log.i("MicroMsg.NetSceneGetFaceCheckResult", "payGenActionLocation == nul");
      paramString4 = new dji();
    }
    if (paramString4.longitude == 0.0D) {
      paramString4.longitude = paramDouble1;
    }
    if (paramString4.latitude == 0.0D) {
      paramString4.latitude = paramDouble2;
    }
    this.wDh.TdD = paramString4;
    this.wDh.TeX = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.wDh.TeY = paramBoolean;
    this.wDh.live_type = paramInt2;
    this.wDh.TeV = paramLong;
    Log.i("MicroMsg.NetSceneGetFaceCheckResult", "create GetFaceCheckResult, personId: %s, actionData: %s, reductionRatio: %s, videoFileid: %s, scene: %s, takeMessage: %s, packageName: %s，hash: %s,checkAliveType:%s bioId:%s payGenActionLocation.longitude：%s payGenActionLocation.latitude:%s ,signContract:%s", new Object[] { paramString1, paramString2, Float.valueOf(paramFloat), paramString3, Integer.valueOf(paramInt1), paramString5, paramString6, Arrays.toString(paramArrayOfByte), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Double.valueOf(paramString4.longitude), Double.valueOf(paramString4.latitude), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(195253);
  }
  
  public final int doScene(g paramg, i parami)
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
    paramArrayOfByte = com.tencent.mm.plugin.report.service.h.IzE;
    if (paramInt3 == 0) {}
    for (long l = 54L;; l = 55L)
    {
      paramArrayOfByte.idkeyStat(917L, l, 1L, false);
      this.wDi = ((bux)d.c.b(((d)params).lBS));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104200);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.c
 * JD-Core Version:    0.7.0.1
 */