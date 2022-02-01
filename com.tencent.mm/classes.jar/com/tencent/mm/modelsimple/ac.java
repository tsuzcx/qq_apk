package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.djn;
import com.tencent.mm.protocal.protobuf.djo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;

public final class ac
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public long hsH;
  public b rr;
  
  public ac(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, true);
  }
  
  public ac(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(43059);
    this.hsH = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new djn();
    ((b.a)localObject).gUV = new djo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newverifypasswd";
    ((b.a)localObject).funcId = 384;
    ((b.a)localObject).reqCmdId = 182;
    ((b.a)localObject).respCmdId = 1000000182;
    this.rr = ((b.a)localObject).atI();
    localObject = (djn)this.rr.gUS.gUX;
    ((djn)localObject).OpCode = paramInt1;
    ((djn)localObject).Ekd = paramInt2;
    ((djn)localObject).Ezq = bt.aGc(paramString1);
    ((djn)localObject).CGs = bt.aGb(paramString1);
    ((djn)localObject).DzX = new cmf().aEE(paramString2);
    ((djn)localObject).Ezr = new cmf().aEE(paramString3);
    ((djn)localObject).CGw = new cmf().aEE(paramString4);
    if ((paramInt1 == 5) || (paramInt1 == 2))
    {
      this.hsH = new p(u.aqF()).longValue();
      if (paramBoolean1)
      {
        paramString1 = com.tencent.mm.kernel.g.afz().aeA().e(this.hsH, paramString3);
        ((djn)localObject).CDX = new SKBuiltinBuffer_t().setBuffer(paramString1);
      }
    }
    else
    {
      paramString1 = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(47, null));
      ((djn)localObject).CGx = new SKBuiltinBuffer_t().setBuffer(bt.aGd(paramString1));
      paramInt2 = ((djn)localObject).OpCode;
      if (((djn)localObject).CDX != null) {
        break label387;
      }
      paramInt1 = -1;
      label301:
      if (((djn)localObject).CDX != null) {
        break label399;
      }
    }
    label387:
    label399:
    for (paramString1 = "null";; paramString1 = bt.aGs(bt.cv(((djn)localObject).CDX.getBufferToBytes())))
    {
      ad.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), paramString1 });
      AppMethodBeat.o(43059);
      return;
      paramString1 = com.tencent.mm.kernel.g.afz().aeA().a(this.hsH, bt.aGc(paramString1), paramBoolean2);
      break;
      paramInt1 = ((djn)localObject).CDX.getILen();
      break label301;
    }
  }
  
  public ac(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, false, 0);
  }
  
  public final String axz()
  {
    AppMethodBeat.i(43061);
    try
    {
      String str = ((djo)this.rr.gUT.gUX).Ddo;
      AppMethodBeat.o(43061);
      return str;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", localException, "", new Object[0]);
      AppMethodBeat.o(43061);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(43060);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43060);
    return i;
  }
  
  public final int getType()
  {
    return 384;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43062);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (djn)this.rr.gUS.gUX;
    paramq = (djo)this.rr.gUT.gUX;
    if ((paramq.CBe != null) && (paramq.CBe.getILen() > 0)) {
      ad.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.afz().aeA().a(this.hsH, com.tencent.mm.platformtools.z.a(paramq.CBe))), Integer.valueOf(paramq.CBe.getILen()) });
    }
    int i;
    label269:
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.afB().afk().set(77830, paramq.Ddo);
      com.tencent.mm.kernel.g.afB().afk().set(32, paramArrayOfByte.Ezq);
      com.tencent.mm.kernel.g.afB().afk().set(33, paramArrayOfByte.CGs);
      com.tencent.mm.kernel.g.afB().afk().set(46, bt.cy(com.tencent.mm.platformtools.z.a(paramq.CBk)));
      paramArrayOfByte = bt.cy(com.tencent.mm.platformtools.z.a(paramArrayOfByte.CGx));
      com.tencent.mm.kernel.g.afB().afk().set(47, paramArrayOfByte);
      com.tencent.mm.kernel.g.afB().gcR.set(18, paramArrayOfByte);
      com.tencent.mm.kernel.g.afB().afk().set(-1535680990, paramq.CBj);
      if (paramq.CBk == null)
      {
        paramInt1 = 0;
        if (paramq.CBj != null) {
          break label348;
        }
        i = 0;
        if (paramq.Ddo != null) {
          break label361;
        }
        j = 0;
        label280:
        ad.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43062);
      return;
      paramInt1 = paramq.CBk.getILen();
      break;
      label348:
      i = paramq.CBj.length();
      break label269;
      label361:
      j = paramq.Ddo.length();
      break label280;
      if (paramInt2 == 4)
      {
        com.tencent.mm.kernel.g.afB().afk().set(32, "");
        com.tencent.mm.kernel.g.afB().afk().set(33, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ac
 * JD-Core Version:    0.7.0.1
 */