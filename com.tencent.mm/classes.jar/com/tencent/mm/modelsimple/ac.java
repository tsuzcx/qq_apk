package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class ac
  extends m
  implements k
{
  private f callback;
  public long fQd;
  public b rr;
  
  public ac(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, true);
  }
  
  public ac(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(60000);
    this.fQd = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cqc();
    ((b.a)localObject).fsY = new cqd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newverifypasswd";
    ((b.a)localObject).funcId = 384;
    ((b.a)localObject).reqCmdId = 182;
    ((b.a)localObject).respCmdId = 1000000182;
    this.rr = ((b.a)localObject).ado();
    localObject = (cqc)this.rr.fsV.fta;
    ((cqc)localObject).OpCode = paramInt1;
    ((cqc)localObject).xMf = paramInt2;
    ((cqc)localObject).xYG = bo.apP(paramString1);
    ((cqc)localObject).wwj = bo.apO(paramString1);
    ((cqc)localObject).xgV = new bwc().aoF(paramString2);
    ((cqc)localObject).xYH = new bwc().aoF(paramString3);
    ((cqc)localObject).wwn = new bwc().aoF(paramString4);
    if ((paramInt1 == 5) || (paramInt1 == 2))
    {
      this.fQd = new p(r.Zm()).longValue();
      if (paramBoolean1)
      {
        paramString1 = g.RJ().QN().d(this.fQd, paramString3);
        ((cqc)localObject).wuh = new SKBuiltinBuffer_t().setBuffer(paramString1);
      }
    }
    else
    {
      paramString1 = bo.nullAsNil((String)g.RL().Ru().get(47, null));
      ((cqc)localObject).wwo = new SKBuiltinBuffer_t().setBuffer(bo.apQ(paramString1));
      paramInt2 = ((cqc)localObject).OpCode;
      if (((cqc)localObject).wuh != null) {
        break label387;
      }
      paramInt1 = -1;
      label301:
      if (((cqc)localObject).wuh != null) {
        break label399;
      }
    }
    label387:
    label399:
    for (paramString1 = "null";; paramString1 = bo.aqg(bo.cd(((cqc)localObject).wuh.getBufferToBytes())))
    {
      ab.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), paramString1 });
      AppMethodBeat.o(60000);
      return;
      paramString1 = g.RJ().QN().a(this.fQd, bo.apP(paramString1), paramBoolean2);
      break;
      paramInt1 = ((cqc)localObject).wuh.getILen();
      break label301;
    }
  }
  
  public ac(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, false, 0);
  }
  
  public final String agx()
  {
    AppMethodBeat.i(60002);
    try
    {
      String str = ((cqd)this.rr.fsW.fta).wQf;
      AppMethodBeat.o(60002);
      return str;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", localException, "", new Object[0]);
      AppMethodBeat.o(60002);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(60001);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(60001);
    return i;
  }
  
  public final int getType()
  {
    return 384;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(60003);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (cqc)this.rr.fsV.fta;
    paramq = (cqd)this.rr.fsW.fta;
    if ((paramq.wrN != null) && (paramq.wrN.getILen() > 0)) {
      ab.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[] { Boolean.valueOf(g.RJ().QN().a(this.fQd, aa.a(paramq.wrN))), Integer.valueOf(paramq.wrN.getILen()) });
    }
    int i;
    label269:
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.RL().Ru().set(77830, paramq.wQf);
      g.RL().Ru().set(32, paramArrayOfByte.xYG);
      g.RL().Ru().set(33, paramArrayOfByte.wwj);
      g.RL().Ru().set(46, bo.cg(aa.a(paramq.wrT)));
      paramArrayOfByte = bo.cg(aa.a(paramArrayOfByte.wwo));
      g.RL().Ru().set(47, paramArrayOfByte);
      g.RL().eHM.set(18, paramArrayOfByte);
      g.RL().Ru().set(-1535680990, paramq.wrS);
      if (paramq.wrT == null)
      {
        paramInt1 = 0;
        if (paramq.wrS != null) {
          break label348;
        }
        i = 0;
        if (paramq.wQf != null) {
          break label361;
        }
        j = 0;
        label280:
        ab.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(60003);
      return;
      paramInt1 = paramq.wrT.getILen();
      break;
      label348:
      i = paramq.wrS.length();
      break label269;
      label361:
      j = paramq.wQf.length();
      break label280;
      if (paramInt2 == 4)
      {
        g.RL().Ru().set(32, "");
        g.RL().Ru().set(33, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ac
 * JD-Core Version:    0.7.0.1
 */