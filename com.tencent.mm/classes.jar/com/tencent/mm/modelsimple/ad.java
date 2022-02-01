package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ac;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eps;
import com.tencent.mm.protocal.protobuf.ept;
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
  public long jkB;
  public d rr;
  
  public ad(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, true);
  }
  
  public ad(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(43059);
    this.jkB = 0L;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eps();
    ((d.a)localObject).iLO = new ept();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/newverifypasswd";
    ((d.a)localObject).funcId = 384;
    ((d.a)localObject).iLP = 182;
    ((d.a)localObject).respCmdId = 1000000182;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eps)this.rr.iLK.iLR;
    ((eps)localObject).OpCode = paramInt1;
    ((eps)localObject).MWU = paramInt2;
    ((eps)localObject).Nnm = Util.getFullPasswordMD5(paramString1);
    ((eps)localObject).KQv = Util.getCutPasswordMD5(paramString1);
    ((eps)localObject).Mdj = new dqi().bhy(paramString2);
    ((eps)localObject).Nnn = new dqi().bhy(paramString3);
    ((eps)localObject).KQz = new dqi().bhy(paramString4);
    if ((paramInt1 == 5) || (paramInt1 == 2))
    {
      this.jkB = new p(com.tencent.mm.model.z.aTX()).longValue();
      if (paramBoolean1)
      {
        paramString1 = com.tencent.mm.kernel.g.aAf().azh().e(this.jkB, paramString3);
        ((eps)localObject).KNX = new SKBuiltinBuffer_t().setBuffer(paramString1);
      }
    }
    else
    {
      paramString1 = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(47, null));
      ((eps)localObject).KQA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(paramString1));
      paramInt2 = ((eps)localObject).OpCode;
      if (((eps)localObject).KNX != null) {
        break label387;
      }
      paramInt1 = -1;
      label301:
      if (((eps)localObject).KNX != null) {
        break label399;
      }
    }
    label387:
    label399:
    for (paramString1 = "null";; paramString1 = Util.secPrint(Util.dumpHex(((eps)localObject).KNX.getBufferToBytes())))
    {
      Log.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), paramString1 });
      AppMethodBeat.o(43059);
      return;
      paramString1 = com.tencent.mm.kernel.g.aAf().azh().a(this.jkB, Util.getFullPasswordMD5(paramString1), paramBoolean2);
      break;
      paramInt1 = ((eps)localObject).KNX.getILen();
      break label301;
    }
  }
  
  public ad(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, false, 0);
  }
  
  public final String bbG()
  {
    AppMethodBeat.i(43061);
    try
    {
      String str = ((ept)this.rr.iLL.iLR).Bri;
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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
    paramArrayOfByte = (eps)this.rr.iLK.iLR;
    params = (ept)this.rr.iLL.iLR;
    if ((params.KLb != null) && (params.KLb.getILen() > 0))
    {
      Log.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.aAf().azh().a(this.jkB, com.tencent.mm.platformtools.z.a(params.KLb))), Integer.valueOf(params.KLb.getILen()) });
      if (com.tencent.mm.kernel.g.aAc()) {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oou, Boolean.TRUE);
      }
    }
    int i;
    label290:
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(77830, params.Bri);
      com.tencent.mm.kernel.g.aAh().azQ().set(32, paramArrayOfByte.Nnm);
      com.tencent.mm.kernel.g.aAh().azQ().set(33, paramArrayOfByte.KQv);
      com.tencent.mm.kernel.g.aAh().azQ().set(46, Util.encodeHexString(com.tencent.mm.platformtools.z.a(params.KLh)));
      paramArrayOfByte = Util.encodeHexString(com.tencent.mm.platformtools.z.a(paramArrayOfByte.KQA));
      com.tencent.mm.kernel.g.aAh().azQ().set(47, paramArrayOfByte);
      com.tencent.mm.kernel.g.aAh().hqB.set(18, paramArrayOfByte);
      com.tencent.mm.kernel.g.aAh().azQ().set(-1535680990, params.KLg);
      if (params.KLh == null)
      {
        paramInt1 = 0;
        if (params.KLg != null) {
          break label369;
        }
        i = 0;
        if (params.Bri != null) {
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
      paramInt1 = params.KLh.getILen();
      break;
      label369:
      i = params.KLg.length();
      break label290;
      label382:
      j = params.Bri.length();
      break label301;
      if (paramInt2 == 4)
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(32, "");
        com.tencent.mm.kernel.g.aAh().azQ().set(33, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ad
 * JD-Core Version:    0.7.0.1
 */