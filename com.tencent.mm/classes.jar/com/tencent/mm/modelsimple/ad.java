package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dvq;
import com.tencent.mm.protocal.protobuf.dvr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;

public final class ad
  extends n
  implements k
{
  private f callback;
  public long ipu;
  public b rr;
  
  public ad(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, true);
  }
  
  public ad(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(43059);
    this.ipu = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dvq();
    ((b.a)localObject).hQG = new dvr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newverifypasswd";
    ((b.a)localObject).funcId = 384;
    ((b.a)localObject).hQH = 182;
    ((b.a)localObject).respCmdId = 1000000182;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dvq)this.rr.hQD.hQJ;
    ((dvq)localObject).OpCode = paramInt1;
    ((dvq)localObject).HLl = paramInt2;
    ((dvq)localObject).IaX = bu.aSw(paramString1);
    ((dvq)localObject).FWJ = bu.aSv(paramString1);
    ((dvq)localObject).GYt = new cxn().aQV(paramString2);
    ((dvq)localObject).IaY = new cxn().aQV(paramString3);
    ((dvq)localObject).FWN = new cxn().aQV(paramString4);
    if ((paramInt1 == 5) || (paramInt1 == 2))
    {
      this.ipu = new p(v.aAB()).longValue();
      if (paramBoolean1)
      {
        paramString1 = g.ajP().aiR().e(this.ipu, paramString3);
        ((dvq)localObject).FUo = new SKBuiltinBuffer_t().setBuffer(paramString1);
      }
    }
    else
    {
      paramString1 = bu.nullAsNil((String)g.ajR().ajA().get(47, null));
      ((dvq)localObject).FWO = new SKBuiltinBuffer_t().setBuffer(bu.aSx(paramString1));
      paramInt2 = ((dvq)localObject).OpCode;
      if (((dvq)localObject).FUo != null) {
        break label387;
      }
      paramInt1 = -1;
      label301:
      if (((dvq)localObject).FUo != null) {
        break label399;
      }
    }
    label387:
    label399:
    for (paramString1 = "null";; paramString1 = bu.aSM(bu.cE(((dvq)localObject).FUo.getBufferToBytes())))
    {
      ae.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), paramString1 });
      AppMethodBeat.o(43059);
      return;
      paramString1 = g.ajP().aiR().a(this.ipu, bu.aSw(paramString1), paramBoolean2);
      break;
      paramInt1 = ((dvq)localObject).FUo.getILen();
      break label301;
    }
  }
  
  public ad(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, false, 0);
  }
  
  public final String aHN()
  {
    AppMethodBeat.i(43061);
    try
    {
      String str = ((dvr)this.rr.hQE.hQJ).xrf;
      AppMethodBeat.o(43061);
      return str;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", localException, "", new Object[0]);
      AppMethodBeat.o(43061);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(43060);
    this.callback = paramf;
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
    paramArrayOfByte = (dvq)this.rr.hQD.hQJ;
    paramq = (dvr)this.rr.hQE.hQJ;
    if ((paramq.FRu != null) && (paramq.FRu.getILen() > 0)) {
      ae.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[] { Boolean.valueOf(g.ajP().aiR().a(this.ipu, com.tencent.mm.platformtools.z.a(paramq.FRu))), Integer.valueOf(paramq.FRu.getILen()) });
    }
    int i;
    label269:
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.ajR().ajA().set(77830, paramq.xrf);
      g.ajR().ajA().set(32, paramArrayOfByte.IaX);
      g.ajR().ajA().set(33, paramArrayOfByte.FWJ);
      g.ajR().ajA().set(46, bu.cH(com.tencent.mm.platformtools.z.a(paramq.FRA)));
      paramArrayOfByte = bu.cH(com.tencent.mm.platformtools.z.a(paramArrayOfByte.FWO));
      g.ajR().ajA().set(47, paramArrayOfByte);
      g.ajR().gDO.set(18, paramArrayOfByte);
      g.ajR().ajA().set(-1535680990, paramq.FRz);
      if (paramq.FRA == null)
      {
        paramInt1 = 0;
        if (paramq.FRz != null) {
          break label348;
        }
        i = 0;
        if (paramq.xrf != null) {
          break label361;
        }
        j = 0;
        label280:
        ae.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43062);
      return;
      paramInt1 = paramq.FRA.getILen();
      break;
      label348:
      i = paramq.FRz.length();
      break label269;
      label361:
      j = paramq.xrf.length();
      break label280;
      if (paramInt2 == 4)
      {
        g.ajR().ajA().set(32, "");
        g.ajR().ajA().set(33, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ad
 * JD-Core Version:    0.7.0.1
 */