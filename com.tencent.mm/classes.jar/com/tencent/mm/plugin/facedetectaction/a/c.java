package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.protocal.protobuf.ebs;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class c
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.am.c rr;
  private cju zZs;
  public cjv zZt;
  
  public c(String paramString1, String paramString2, float paramFloat, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramFloat, paramString3, paramString4, paramInt, paramString5, paramString6, paramArrayOfByte, paramBoolean, 1, 0L, 0.0D, 0.0D);
  }
  
  public c(String paramString1, String paramString2, float paramFloat, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt2, long paramLong, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(262600);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cju();
    ((c.a)localObject).otF = new cjv();
    ((c.a)localObject).funcId = 2726;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/getfacecheckresult";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.zZs = ((cju)c.b.b(this.rr.otB));
    this.zZs.person_id = paramString1;
    this.zZs.action_data = paramString2;
    this.zZs.aasn = paramFloat;
    this.zZs.aasq = paramString3;
    this.zZs.YPz = paramString4;
    this.zZs.scene = paramInt1;
    this.zZs.Zji = paramString5;
    this.zZs.xlr = paramString6;
    localObject = ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.b.class)).gdF();
    paramString4 = (String)localObject;
    if (localObject == null)
    {
      Log.i("MicroMsg.NetSceneGetFaceCheckResult", "payGenActionLocation == nul");
      paramString4 = new ebs();
    }
    if (paramString4.longitude == 0.0D) {
      paramString4.longitude = paramDouble1;
    }
    if (paramString4.latitude == 0.0D) {
      paramString4.latitude = paramDouble2;
    }
    this.zZs.aaqS = paramString4;
    this.zZs.aasr = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.zZs.aass = paramBoolean;
    this.zZs.live_type = paramInt2;
    this.zZs.aasp = paramLong;
    Log.i("MicroMsg.NetSceneGetFaceCheckResult", "create GetFaceCheckResult, personId: %s, actionData: %s, reductionRatio: %s, videoFileid: %s, scene: %s, takeMessage: %s, packageName: %s，hash: %s,checkAliveType:%s bioId:%s payGenActionLocation.longitude：%s payGenActionLocation.latitude:%s ,signContract:%s", new Object[] { paramString1, paramString2, Float.valueOf(paramFloat), paramString3, Integer.valueOf(paramInt1), paramString5, paramString6, Arrays.toString(paramArrayOfByte), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Double.valueOf(paramString4.longitude), Double.valueOf(paramString4.latitude), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(262600);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(104199);
    this.callback = paramh;
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
    paramArrayOfByte = com.tencent.mm.plugin.report.service.h.OAn;
    if (paramInt3 == 0) {}
    for (long l = 54L;; l = 55L)
    {
      paramArrayOfByte.idkeyStat(917L, l, 1L, false);
      this.zZt = ((cjv)c.c.b(((com.tencent.mm.am.c)params).otC));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104200);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.c
 * JD-Core Version:    0.7.0.1
 */