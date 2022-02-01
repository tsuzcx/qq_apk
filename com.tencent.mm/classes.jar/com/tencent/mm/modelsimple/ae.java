package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ab;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fwh;
import com.tencent.mm.protocal.protobuf.fwi;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class ae
  extends com.tencent.mm.am.p
  implements m
{
  private com.tencent.mm.am.h callback;
  public long oTt;
  public c rr;
  
  public ae(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, true);
  }
  
  public ae(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(43059);
    this.oTt = 0L;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fwh();
    ((c.a)localObject).otF = new fwi();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/newverifypasswd";
    ((c.a)localObject).funcId = 384;
    ((c.a)localObject).otG = 182;
    ((c.a)localObject).respCmdId = 1000000182;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fwh)c.b.b(this.rr.otB);
    ((fwh)localObject).YIq = paramInt1;
    ((fwh)localObject).abAU = paramInt2;
    ((fwh)localObject).abUf = Util.getFullPasswordMD5(paramString1);
    ((fwh)localObject).YOL = Util.getCutPasswordMD5(paramString1);
    ((fwh)localObject).aaAR = new etl().btH(paramString2);
    ((fwh)localObject).abUg = new etl().btH(paramString3);
    ((fwh)localObject).YOP = new etl().btH(paramString4);
    if ((paramInt1 == 5) || (paramInt1 == 2))
    {
      this.oTt = new com.tencent.mm.b.p(z.bAL()).longValue();
      if (paramBoolean1)
      {
        paramString1 = com.tencent.mm.kernel.h.baC().aZE().g(this.oTt, paramString3);
        ((fwh)localObject).YMf = new gol().df(paramString1);
      }
    }
    else
    {
      paramString1 = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(47, null));
      ((fwh)localObject).YOQ = new gol().df(Util.decodeHexString(paramString1));
      paramInt2 = ((fwh)localObject).YIq;
      if (((fwh)localObject).YMf != null) {
        break label387;
      }
      paramInt1 = -1;
      label301:
      if (((fwh)localObject).YMf != null) {
        break label399;
      }
    }
    label387:
    label399:
    for (paramString1 = "null";; paramString1 = Util.secPrint(Util.dumpHex(((fwh)localObject).YMf.aaxD.Op)))
    {
      Log.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), paramString1 });
      AppMethodBeat.o(43059);
      return;
      paramString1 = com.tencent.mm.kernel.h.baC().aZE().a(this.oTt, Util.getFullPasswordMD5(paramString1), paramBoolean2);
      break;
      paramInt1 = ((fwh)localObject).YMf.abwJ;
      break label301;
    }
  }
  
  public ae(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, false, 0);
  }
  
  public final String bIQ()
  {
    AppMethodBeat.i(43061);
    try
    {
      String str = ((fwi)c.c.b(this.rr.otC)).Njp;
      AppMethodBeat.o(43061);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", localException, "", new Object[0]);
      AppMethodBeat.o(43061);
    }
    return null;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(43060);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(43060);
    return i;
  }
  
  public final int getType()
  {
    return 384;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43062);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (fwh)c.b.b(this.rr.otB);
    params = (fwi)c.c.b(this.rr.otC);
    if ((params.YJl != null) && (params.YJl.abwJ > 0))
    {
      Log.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.h.baC().aZE().b(this.oTt, w.a(params.YJl))), Integer.valueOf(params.YJl.abwJ) });
      if (com.tencent.mm.kernel.h.baz()) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgT, Boolean.TRUE);
      }
    }
    int i;
    label290:
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.h.baE().ban().B(77830, params.Njp);
      com.tencent.mm.kernel.h.baE().ban().B(32, paramArrayOfByte.abUf);
      com.tencent.mm.kernel.h.baE().ban().B(33, paramArrayOfByte.YOL);
      com.tencent.mm.kernel.h.baE().ban().B(46, Util.encodeHexString(w.a(params.YJr)));
      paramArrayOfByte = Util.encodeHexString(w.a(paramArrayOfByte.YOQ));
      com.tencent.mm.kernel.h.baE().ban().B(47, paramArrayOfByte);
      com.tencent.mm.kernel.h.baE().mCE.B(18, paramArrayOfByte);
      com.tencent.mm.kernel.h.baE().ban().B(-1535680990, params.YJq);
      if (params.YJr == null)
      {
        paramInt1 = 0;
        if (params.YJq != null) {
          break label369;
        }
        i = 0;
        if (params.Njp != null) {
          break label382;
        }
        j = 0;
        label301:
        Log.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43062);
      return;
      paramInt1 = params.YJr.abwJ;
      break;
      label369:
      i = params.YJq.length();
      break label290;
      label382:
      j = params.Njp.length();
      break label301;
      if (paramInt2 == 4)
      {
        com.tencent.mm.kernel.h.baE().ban().B(32, "");
        com.tencent.mm.kernel.h.baE().ban().B(33, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ae
 * JD-Core Version:    0.7.0.1
 */