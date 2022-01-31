package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class e
  extends m
  implements k
{
  f callback;
  g.a eMo;
  final Queue<e.a> fCO;
  private StringBuilder fIa;
  WeakReference<com.tencent.mm.ai.g> fIj;
  final bga fIk;
  int fIl;
  boolean fIm;
  int fIn;
  int fIo;
  boolean fIp;
  private final ap frx;
  private int retryCount;
  
  public e(com.tencent.mm.ai.g paramg)
  {
    AppMethodBeat.i(58362);
    this.fIj = null;
    this.fIk = new bga();
    this.fIa = new StringBuilder();
    this.fIl = 0;
    this.fIm = false;
    this.fIn = 0;
    this.fIo = 0;
    this.retryCount = 3;
    this.fIp = false;
    this.fCO = new LinkedList();
    this.frx = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new e.1(this), true);
    ab.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    this.fIa.append("stack:" + bo.dtY() + " time:" + bo.aox());
    this.fIj = new WeakReference(paramg);
    AppMethodBeat.o(58362);
  }
  
  private int a(com.tencent.mm.network.e parame, SKBuiltinBuffer_t paramSKBuiltinBuffer_t1, SKBuiltinBuffer_t paramSKBuiltinBuffer_t2)
  {
    AppMethodBeat.i(58364);
    this.fIa.append(" lastd:" + this.lastdispatch + " dotime:" + bo.aox() + " net:" + at.getNetType(ah.getContext()));
    e.b localb = new e.b();
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = paramSKBuiltinBuffer_t1;
    if (paramSKBuiltinBuffer_t1 == null)
    {
      com.tencent.mm.kernel.g.RM();
      localSKBuiltinBuffer_t = com.tencent.mm.platformtools.aa.ac(bo.apQ(bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(8197, null))));
    }
    paramSKBuiltinBuffer_t1 = paramSKBuiltinBuffer_t2;
    if (paramSKBuiltinBuffer_t2 == null)
    {
      com.tencent.mm.kernel.g.RM();
      paramSKBuiltinBuffer_t1 = com.tencent.mm.platformtools.aa.ac(bo.apQ(bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(8198, null))));
    }
    com.tencent.mm.kernel.g.RM();
    if ((bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(16, null)) != 0) && ((localSKBuiltinBuffer_t == null) || (localSKBuiltinBuffer_t.getILen() <= 0))) {
      localb.getReqObj().setSceneStatus(7);
    }
    for (;;)
    {
      this.fIk.xuQ = localSKBuiltinBuffer_t;
      this.fIk.xuR = paramSKBuiltinBuffer_t1;
      ((s.a)localb.getReqObj()).wiK = this.fIk;
      ab.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.eMo.Mm()), Integer.valueOf(this.fIl), this.fIk.jJA, this.fIk.lGH, Integer.valueOf(localb.getReqObj().getSceneStatus()), bo.cg(com.tencent.mm.platformtools.aa.a(localSKBuiltinBuffer_t)), bo.cg(com.tencent.mm.platformtools.aa.a(paramSKBuiltinBuffer_t1)) });
      this.fIl += 1;
      int i = dispatch(parame, localb, this);
      AppMethodBeat.o(58364);
      return i;
      com.tencent.mm.kernel.g.RM();
      if (bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(8195, null)).length() <= 0) {
        localb.getReqObj().setSceneStatus(3);
      } else {
        localb.getReqObj().setSceneStatus(4);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, bgb parambgb)
  {
    AppMethodBeat.i(58367);
    e.a locala = new e.a(this);
    locala.fIu = paramInt1;
    locala.errCode = paramInt3;
    locala.errType = paramInt2;
    locala.errMsg = paramString;
    locala.fIt = parambgb;
    this.fCO.add(locala);
    if (this.frx.dtj()) {
      this.frx.ag(50L, 50L);
    }
    AppMethodBeat.o(58367);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(58366);
    ab.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[] { bo.dtY() });
    super.cancel();
    this.fIp = true;
    AppMethodBeat.o(58366);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(58363);
    this.eMo = new g.a();
    this.callback = paramf;
    paramf = this.fIk;
    com.tencent.mm.kernel.g.RM();
    paramf.jJA = ((String)com.tencent.mm.kernel.g.RL().Ru().get(2, null));
    if (!bo.isNullOrNil(this.fIk.jJA)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("by DK: req.UserName is null", bool);
      this.fIk.lGH = com.tencent.mm.sdk.platformtools.aa.dsG();
      int i = a(parame, null, null);
      AppMethodBeat.o(58363);
      return i;
    }
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(58368);
    String str = this.fIa.toString();
    AppMethodBeat.o(58368);
    return str;
  }
  
  public final int getType()
  {
    return 139;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58365);
    this.fIa.append(" endtime:" + bo.aox());
    ab.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramInt1) });
    if ((paramInt2 == 4) && (paramInt3 == -100))
    {
      ab.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.fIp = true;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(58365);
      return;
    }
    if (((paramInt2 != 0) || (paramInt3 != 0)) && ((paramInt2 != 4) || (paramInt3 != -17)))
    {
      ab.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", new Object[] { Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (this.retryCount > 0)
      {
        this.retryCount -= 1;
        if (a(dispatcher(), null, null) != -1) {}
      }
      else
      {
        this.fIp = true;
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(58365);
      return;
    }
    paramq = ((s.b)paramq.getRespObj()).wiL;
    this.fIn += paramq.xuT;
    ab.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(this.eMo.Mm()), Integer.valueOf(this.fIn), Integer.valueOf(this.fIl), Integer.valueOf(paramq.wBX) });
    a(this.fIl - 1, paramInt2, paramInt3, paramString, paramq);
    if (((paramq.wBX & 0x7) != 0) && (!securityLimitCountReach()))
    {
      if (a(dispatcher(), paramq.xuQ, paramq.xuR) == -1)
      {
        ab.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
        a(2147483647, 3, -1, "", null);
        AppMethodBeat.o(58365);
      }
    }
    else
    {
      ab.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.eMo.Mm()), Integer.valueOf(this.fIl) });
      this.fIm = true;
      a(2147483647, 0, 0, "", null);
    }
    AppMethodBeat.o(58365);
  }
  
  public final int securityLimitCount()
  {
    return 500;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(138432);
    boolean bool = super.securityLimitCountReach();
    AppMethodBeat.o(138432);
    return bool;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.e
 * JD-Core Version:    0.7.0.1
 */