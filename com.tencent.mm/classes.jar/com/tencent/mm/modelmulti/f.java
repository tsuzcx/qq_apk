package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class f
  extends n
  implements k
{
  com.tencent.mm.ak.f callback;
  com.tencent.mm.compatible.util.f.a gIr;
  private final aw hPc;
  final Queue<a> ibp;
  WeakReference<com.tencent.mm.ak.g> ihB;
  final cdd ihC;
  int ihD;
  boolean ihE;
  int ihF;
  int ihG;
  boolean ihH;
  private StringBuilder ihk;
  private int retryCount;
  
  public f(com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(132552);
    this.ihB = null;
    this.ihC = new cdd();
    this.ihk = new StringBuilder();
    this.ihD = 0;
    this.ihE = false;
    this.ihF = 0;
    this.ihG = 0;
    this.retryCount = 3;
    this.ihH = false;
    this.ibp = new LinkedList();
    this.hPc = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132550);
        if ((!com.tencent.mm.kernel.g.ajM()) || (a.aiT()))
        {
          ae.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.this.ihH)
        {
          ae.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[] { Integer.valueOf(f.this.hashCode()) });
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.this.ibp.isEmpty())
        {
          ae.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(132550);
          return false;
        }
        ae.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.gIr.abs()), Integer.valueOf(f.this.ibp.size()), Integer.valueOf(f.this.ihD), Boolean.valueOf(f.this.ihE), Integer.valueOf(f.this.ihG), Integer.valueOf(f.this.ihF) });
        com.tencent.mm.kernel.g.ajS();
        long l = com.tencent.mm.kernel.g.ajR().gDX.yi(Thread.currentThread().getId());
        Object localObject1 = new c();
        ((c)localObject1).ds("NetSceneInit");
        int i;
        int j;
        label266:
        Object localObject2;
        boolean bool;
        label310:
        Object localObject3;
        if (f.this.ihE)
        {
          i = 40;
          j = 0;
          if (j >= i) {
            break label1093;
          }
          localObject2 = (f.a)f.this.ibp.peek();
          if (((f.a)localObject2).ihM != 2147483647) {
            break label630;
          }
          if (((f.a)localObject2).ihL != null) {
            break label624;
          }
          bool = true;
          Assert.assertTrue("in Queue tail , resp should be null", bool);
          com.tencent.mm.kernel.g.ajS();
          localObject3 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(8198, null);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(8195, localObject3);
          ak.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.abv()).edit().putString("notify_sync_key_keybuf", (String)localObject3).commit();
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(8197, "");
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(8198, "");
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(15, Integer.valueOf(1));
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().fuc();
          ae.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.gIr.abs()), Integer.valueOf(f.this.ihD), Integer.valueOf(f.this.ihF), Integer.valueOf(((f.a)localObject2).errType), Integer.valueOf(((f.a)localObject2).errCode) });
          com.tencent.mm.kernel.g.ajU().aw(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(132549);
              f.this.callback.onSceneEnd(this.ihJ.errType, this.ihJ.errCode, this.ihJ.errMsg, f.this);
              AppMethodBeat.o(132549);
            }
          });
          bool = false;
        }
        for (;;)
        {
          label565:
          ((c)localObject1).dt("NetSceneInit");
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().gDX.sW(l);
          localObject1 = f.this;
          if (((f)localObject1).ihB == null) {
            ae.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progressRef is null");
          }
          for (;;)
          {
            AppMethodBeat.o(132550);
            return bool;
            i = 10;
            break;
            label624:
            bool = false;
            break label310;
            label630:
            localObject3 = ((f.a)localObject2).ihL.HpF;
            if ((localObject3 != null) && (((LinkedList)localObject3).size() > ((f.a)localObject2).ibE))
            {
              ((LinkedList)localObject3).size();
              if (((c)localObject1).a((zx)((LinkedList)localObject3).get(((f.a)localObject2).ibE), true)) {}
            }
            else
            {
              f.this.ibp.poll();
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().set(8197, bu.cH(z.a(((f.a)localObject2).ihL.HpB)));
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().set(8198, bu.cH(z.a(((f.a)localObject2).ihL.HpC)));
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().set(16, Integer.valueOf(0));
              ae.i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s, cur[%s], max[%s]", new Object[] { Long.valueOf(((f.a)localObject2).ihL.GeQ), bu.cH(z.a(((f.a)localObject2).ihL.HpB)), bu.cH(z.a(((f.a)localObject2).ihL.HpC)) });
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().set(8196, Long.valueOf(((f.a)localObject2).ihL.GeQ));
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().fuc();
              bool = true;
              break label565;
            }
            ((f.a)localObject2).ibE += 1;
            localObject2 = f.this;
            ((f)localObject2).ihG += 1;
            j += 1;
            break label266;
            localObject2 = (com.tencent.mm.ak.g)((f)localObject1).ihB.get();
            if (localObject2 != null) {
              break label954;
            }
            ae.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
          }
          label954:
          label967:
          float f1;
          if (((f)localObject1).ihD > 50)
          {
            i = 50;
            f1 = 1.0F;
            if (((f)localObject1).ihE) {
              break label1053;
            }
          }
          for (j = i;; j = (int)((100 - i) * f1 + i))
          {
            ae.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[] { Integer.valueOf(((f)localObject1).ihG), Integer.valueOf(((f)localObject1).ihF), Float.valueOf(f1), Integer.valueOf(i) });
            ((com.tencent.mm.ak.g)localObject2).a(j, 100, (n)localObject1);
            break;
            i = ((f)localObject1).ihD;
            break label967;
            label1053:
            float f2 = ((f)localObject1).ihG / ((f)localObject1).ihF;
            f1 = f2;
            if (f2 > 1.0F) {
              f1 = 1.0F;
            }
          }
          label1093:
          bool = true;
        }
      }
    }, true);
    ae.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    this.ihk.append("stack:" + bu.fpN() + " time:" + bu.aRi());
    this.ihB = new WeakReference(paramg);
    AppMethodBeat.o(132552);
  }
  
  private int a(com.tencent.mm.network.e parame, SKBuiltinBuffer_t paramSKBuiltinBuffer_t1, SKBuiltinBuffer_t paramSKBuiltinBuffer_t2)
  {
    AppMethodBeat.i(132554);
    this.ihk.append(" lastd:" + this.lastdispatch + " dotime:" + bu.aRi() + " net:" + az.getNetType(ak.getContext()));
    b localb = new b();
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = paramSKBuiltinBuffer_t1;
    if (paramSKBuiltinBuffer_t1 == null)
    {
      com.tencent.mm.kernel.g.ajS();
      localSKBuiltinBuffer_t = z.al(bu.aSx(bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(8197, null))));
    }
    paramSKBuiltinBuffer_t1 = paramSKBuiltinBuffer_t2;
    if (paramSKBuiltinBuffer_t2 == null)
    {
      com.tencent.mm.kernel.g.ajS();
      paramSKBuiltinBuffer_t1 = z.al(bu.aSx(bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(8198, null))));
    }
    com.tencent.mm.kernel.g.ajS();
    if ((bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(16, null)) != 0) && ((localSKBuiltinBuffer_t == null) || (localSKBuiltinBuffer_t.getILen() <= 0))) {
      localb.getReqObj().setSceneStatus(7);
    }
    for (;;)
    {
      this.ihC.HpB = localSKBuiltinBuffer_t;
      this.ihC.HpC = paramSKBuiltinBuffer_t1;
      ((u.a)localb.getReqObj()).FGT = this.ihC;
      ae.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.gIr.abs()), Integer.valueOf(this.ihD), this.ihC.nIJ, this.ihC.qkN, Integer.valueOf(localb.getReqObj().getSceneStatus()), bu.cH(z.a(localSKBuiltinBuffer_t)), bu.cH(z.a(paramSKBuiltinBuffer_t1)) });
      this.ihD += 1;
      int i = dispatch(parame, localb, this);
      AppMethodBeat.o(132554);
      return i;
      com.tencent.mm.kernel.g.ajS();
      if (bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(8195, null)).length() <= 0) {
        localb.getReqObj().setSceneStatus(3);
      } else {
        localb.getReqObj().setSceneStatus(4);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, cde paramcde)
  {
    AppMethodBeat.i(132557);
    a locala = new a();
    locala.ihM = paramInt1;
    locala.errCode = paramInt3;
    locala.errType = paramInt2;
    locala.errMsg = paramString;
    locala.ihL = paramcde;
    this.ibp.add(locala);
    if (this.hPc.foU()) {
      this.hPc.ay(50L, 50L);
    }
    AppMethodBeat.o(132557);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(132556);
    ae.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[] { bu.fpN() });
    super.cancel();
    this.ihH = true;
    AppMethodBeat.o(132556);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(132553);
    this.gIr = new com.tencent.mm.compatible.util.f.a();
    this.callback = paramf;
    paramf = this.ihC;
    com.tencent.mm.kernel.g.ajS();
    paramf.nIJ = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, null));
    if (!bu.isNullOrNil(this.ihC.nIJ)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("by DK: req.UserName is null", bool);
      this.ihC.qkN = ad.fom();
      int i = a(parame, null, null);
      AppMethodBeat.o(132553);
      return i;
    }
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132558);
    String str = this.ihk.toString();
    AppMethodBeat.o(132558);
    return str;
  }
  
  public final int getType()
  {
    return 139;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132555);
    this.ihk.append(" endtime:" + bu.aRi());
    ae.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramInt1) });
    if ((paramInt2 == 4) && (paramInt3 == -100))
    {
      ae.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.ihH = true;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(132555);
      return;
    }
    if (((paramInt2 != 0) || (paramInt3 != 0)) && ((paramInt2 != 4) || (paramInt3 != -17)))
    {
      ae.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", new Object[] { Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (this.retryCount > 0)
      {
        this.retryCount -= 1;
        if (a(dispatcher(), null, null) != -1) {}
      }
      else
      {
        this.ihH = true;
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(132555);
      return;
    }
    paramq = ((u.b)paramq.getRespObj()).FGU;
    this.ihF += paramq.HpE;
    ae.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(this.gIr.abs()), Integer.valueOf(this.ihF), Integer.valueOf(this.ihD), Integer.valueOf(paramq.GeQ) });
    a(this.ihD - 1, paramInt2, paramInt3, paramString, paramq);
    if (((paramq.GeQ & 0x7) != 0) && (!securityLimitCountReach()))
    {
      if (a(dispatcher(), paramq.HpB, paramq.HpC) == -1)
      {
        ae.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
        a(2147483647, 3, -1, "", null);
        AppMethodBeat.o(132555);
      }
    }
    else
    {
      ae.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.gIr.abs()), Integer.valueOf(this.ihD) });
      this.ihE = true;
      a(2147483647, 0, 0, "", null);
    }
    AppMethodBeat.o(132555);
  }
  
  public final int securityLimitCount()
  {
    return 500;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(132559);
    boolean bool = super.securityLimitCountReach();
    AppMethodBeat.o(132559);
    return bool;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    int errCode;
    String errMsg;
    int errType;
    int ibE = 0;
    cde ihL;
    int ihM = 0;
    
    a() {}
  }
  
  public static final class b
    extends l
  {
    private final u.a ihN;
    private final u.b ihO;
    
    public b()
    {
      AppMethodBeat.i(132551);
      this.ihN = new u.a();
      this.ihO = new u.b();
      AppMethodBeat.o(132551);
    }
    
    public final l.d getReqObjImp()
    {
      return this.ihN;
    }
    
    public final l.e getRespObj()
    {
      return this.ihO;
    }
    
    public final int getType()
    {
      return 139;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/newinit";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.f
 * JD-Core Version:    0.7.0.1
 */