package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ac;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.fad;
import com.tencent.mm.protocal.protobuf.fae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class ad
  extends q
  implements m
{
  private i callback;
  public long maC;
  public d rr;
  
  public ad(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, true);
  }
  
  public ad(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(43059);
    this.maC = 0L;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fad();
    ((d.a)localObject).lBV = new fae();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/newverifypasswd";
    ((d.a)localObject).funcId = 384;
    ((d.a)localObject).lBW = 182;
    ((d.a)localObject).respCmdId = 1000000182;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fad)d.b.b(this.rr.lBR);
    ((fad)localObject).RLe = paramInt1;
    ((fad)localObject).Ujp = paramInt2;
    ((fad)localObject).UAd = Util.getFullPasswordMD5(paramString1);
    ((fad)localObject).RRt = Util.getCutPasswordMD5(paramString1);
    ((fad)localObject).TmK = new eaf().btQ(paramString2);
    ((fad)localObject).UAe = new eaf().btQ(paramString3);
    ((fad)localObject).RRx = new eaf().btQ(paramString4);
    if ((paramInt1 == 5) || (paramInt1 == 2))
    {
      this.maC = new p(com.tencent.mm.model.z.bcY()).longValue();
      if (paramBoolean1)
      {
        paramString1 = h.aHE().aGC().f(this.maC, paramString3);
        ((fad)localObject).ROR = new eae().dc(paramString1);
      }
    }
    else
    {
      paramString1 = Util.nullAsNil((String)h.aHG().aHp().b(47, null));
      ((fad)localObject).RRy = new eae().dc(Util.decodeHexString(paramString1));
      paramInt2 = ((fad)localObject).RLe;
      if (((fad)localObject).ROR != null) {
        break label387;
      }
      paramInt1 = -1;
      label301:
      if (((fad)localObject).ROR != null) {
        break label399;
      }
    }
    label387:
    label399:
    for (paramString1 = "null";; paramString1 = Util.secPrint(Util.dumpHex(((fad)localObject).ROR.Tkb.UH)))
    {
      Log.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), paramString1 });
      AppMethodBeat.o(43059);
      return;
      paramString1 = h.aHE().aGC().a(this.maC, Util.getFullPasswordMD5(paramString1), paramBoolean2);
      break;
      paramInt1 = ((fad)localObject).ROR.Ufv;
      break label301;
    }
  }
  
  public ad(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, false, 0);
  }
  
  public final String bkW()
  {
    AppMethodBeat.i(43061);
    try
    {
      String str = ((fae)d.c.b(this.rr.lBS)).HlB;
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
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(43060);
    this.callback = parami;
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
    paramArrayOfByte = (fad)d.b.b(this.rr.lBR);
    params = (fae)d.c.b(this.rr.lBS);
    if ((params.RLX != null) && (params.RLX.Ufv > 0))
    {
      Log.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[] { Boolean.valueOf(h.aHE().aGC().a(this.maC, com.tencent.mm.platformtools.z.a(params.RLX))), Integer.valueOf(params.RLX.Ufv) });
      if (h.aHB()) {
        h.aHG().aHp().set(ar.a.VDS, Boolean.TRUE);
      }
    }
    int i;
    label290:
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      h.aHG().aHp().i(77830, params.HlB);
      h.aHG().aHp().i(32, paramArrayOfByte.UAd);
      h.aHG().aHp().i(33, paramArrayOfByte.RRt);
      h.aHG().aHp().i(46, Util.encodeHexString(com.tencent.mm.platformtools.z.a(params.RMd)));
      paramArrayOfByte = Util.encodeHexString(com.tencent.mm.platformtools.z.a(paramArrayOfByte.RRy));
      h.aHG().aHp().i(47, paramArrayOfByte);
      h.aHG().kcw.i(18, paramArrayOfByte);
      h.aHG().aHp().i(-1535680990, params.RMc);
      if (params.RMd == null)
      {
        paramInt1 = 0;
        if (params.RMc != null) {
          break label369;
        }
        i = 0;
        if (params.HlB != null) {
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
      paramInt1 = params.RMd.Ufv;
      break;
      label369:
      i = params.RMc.length();
      break label290;
      label382:
      j = params.HlB.length();
      break label301;
      if (paramInt2 == 4)
      {
        h.aHG().aHp().i(32, "");
        h.aHG().aHp().i(33, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ad
 * JD-Core Version:    0.7.0.1
 */