package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dut;
import com.tencent.mm.protocal.protobuf.duu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;

public final class ac
  extends n
  implements k
{
  private f callback;
  public long imA;
  public b rr;
  
  public ac(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, true);
  }
  
  public ac(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(43059);
    this.imA = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dut();
    ((b.a)localObject).hNN = new duu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newverifypasswd";
    ((b.a)localObject).funcId = 384;
    ((b.a)localObject).hNO = 182;
    ((b.a)localObject).respCmdId = 1000000182;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dut)this.rr.hNK.hNQ;
    ((dut)localObject).OpCode = paramInt1;
    ((dut)localObject).HrJ = paramInt2;
    ((dut)localObject).HHk = bt.aQZ(paramString1);
    ((dut)localObject).FEo = bt.aQY(paramString1);
    ((dut)localObject).GEQ = new cwt().aPy(paramString2);
    ((dut)localObject).HHl = new cwt().aPy(paramString3);
    ((dut)localObject).FEs = new cwt().aPy(paramString4);
    if ((paramInt1 == 5) || (paramInt1 == 2))
    {
      this.imA = new p(u.aAl()).longValue();
      if (paramBoolean1)
      {
        paramString1 = g.ajA().aiC().e(this.imA, paramString3);
        ((dut)localObject).FBT = new SKBuiltinBuffer_t().setBuffer(paramString1);
      }
    }
    else
    {
      paramString1 = bt.nullAsNil((String)g.ajC().ajl().get(47, null));
      ((dut)localObject).FEt = new SKBuiltinBuffer_t().setBuffer(bt.aRa(paramString1));
      paramInt2 = ((dut)localObject).OpCode;
      if (((dut)localObject).FBT != null) {
        break label387;
      }
      paramInt1 = -1;
      label301:
      if (((dut)localObject).FBT != null) {
        break label399;
      }
    }
    label387:
    label399:
    for (paramString1 = "null";; paramString1 = bt.aRp(bt.cB(((dut)localObject).FBT.getBufferToBytes())))
    {
      ad.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), paramString1 });
      AppMethodBeat.o(43059);
      return;
      paramString1 = g.ajA().aiC().a(this.imA, bt.aQZ(paramString1), paramBoolean2);
      break;
      paramInt1 = ((dut)localObject).FBT.getILen();
      break label301;
    }
  }
  
  public ac(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, false, 0);
  }
  
  public final String aHw()
  {
    AppMethodBeat.i(43061);
    try
    {
      String str = ((duu)this.rr.hNL.hNQ).xbo;
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
    paramArrayOfByte = (dut)this.rr.hNK.hNQ;
    paramq = (duu)this.rr.hNL.hNQ;
    if ((paramq.FyW != null) && (paramq.FyW.getILen() > 0)) {
      ad.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[] { Boolean.valueOf(g.ajA().aiC().a(this.imA, com.tencent.mm.platformtools.z.a(paramq.FyW))), Integer.valueOf(paramq.FyW.getILen()) });
    }
    int i;
    label269:
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.ajC().ajl().set(77830, paramq.xbo);
      g.ajC().ajl().set(32, paramArrayOfByte.HHk);
      g.ajC().ajl().set(33, paramArrayOfByte.FEo);
      g.ajC().ajl().set(46, bt.cE(com.tencent.mm.platformtools.z.a(paramq.Fzc)));
      paramArrayOfByte = bt.cE(com.tencent.mm.platformtools.z.a(paramArrayOfByte.FEt));
      g.ajC().ajl().set(47, paramArrayOfByte);
      g.ajC().gBh.set(18, paramArrayOfByte);
      g.ajC().ajl().set(-1535680990, paramq.Fzb);
      if (paramq.Fzc == null)
      {
        paramInt1 = 0;
        if (paramq.Fzb != null) {
          break label348;
        }
        i = 0;
        if (paramq.xbo != null) {
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
      paramInt1 = paramq.Fzc.getILen();
      break;
      label348:
      i = paramq.Fzb.length();
      break label269;
      label361:
      j = paramq.xbo.length();
      break label280;
      if (paramInt2 == 4)
      {
        g.ajC().ajl().set(32, "");
        g.ajC().ajl().set(33, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ac
 * JD-Core Version:    0.7.0.1
 */