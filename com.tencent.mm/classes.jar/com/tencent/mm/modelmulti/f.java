package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.protocal.protobuf.cck;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class f
  extends n
  implements k
{
  com.tencent.mm.al.f callback;
  com.tencent.mm.compatible.util.f.a gFK;
  private final av hMj;
  final Queue<a> hYx;
  WeakReference<com.tencent.mm.al.g> ieJ;
  final ccj ieK;
  int ieL;
  boolean ieM;
  int ieN;
  int ieO;
  boolean ieP;
  private StringBuilder ies;
  private int retryCount;
  
  public f(com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(132552);
    this.ieJ = null;
    this.ieK = new ccj();
    this.ies = new StringBuilder();
    this.ieL = 0;
    this.ieM = false;
    this.ieN = 0;
    this.ieO = 0;
    this.retryCount = 3;
    this.ieP = false;
    this.hYx = new LinkedList();
    this.hMj = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132550);
        if ((!com.tencent.mm.kernel.g.ajx()) || (a.aiE()))
        {
          ad.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.this.ieP)
        {
          ad.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[] { Integer.valueOf(f.this.hashCode()) });
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.this.hYx.isEmpty())
        {
          ad.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(132550);
          return false;
        }
        ad.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.gFK.abj()), Integer.valueOf(f.this.hYx.size()), Integer.valueOf(f.this.ieL), Boolean.valueOf(f.this.ieM), Integer.valueOf(f.this.ieO), Integer.valueOf(f.this.ieN) });
        com.tencent.mm.kernel.g.ajD();
        long l = com.tencent.mm.kernel.g.ajC().gBq.xO(Thread.currentThread().getId());
        Object localObject1 = new c();
        ((c)localObject1).dr("NetSceneInit");
        int i;
        int j;
        label266:
        Object localObject2;
        boolean bool;
        label310:
        Object localObject3;
        if (f.this.ieM)
        {
          i = 40;
          j = 0;
          if (j >= i) {
            break label1093;
          }
          localObject2 = (f.a)f.this.hYx.peek();
          if (((f.a)localObject2).ieU != 2147483647) {
            break label630;
          }
          if (((f.a)localObject2).ieT != null) {
            break label624;
          }
          bool = true;
          Assert.assertTrue("in Queue tail , resp should be null", bool);
          com.tencent.mm.kernel.g.ajD();
          localObject3 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(8198, null);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(8195, localObject3);
          aj.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.abm()).edit().putString("notify_sync_key_keybuf", (String)localObject3).commit();
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(8197, "");
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(8198, "");
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(15, Integer.valueOf(1));
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().fqc();
          ad.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.gFK.abj()), Integer.valueOf(f.this.ieL), Integer.valueOf(f.this.ieN), Integer.valueOf(((f.a)localObject2).errType), Integer.valueOf(((f.a)localObject2).errCode) });
          com.tencent.mm.kernel.g.ajF().ay(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(132549);
              f.this.callback.onSceneEnd(this.ieR.errType, this.ieR.errCode, this.ieR.errMsg, f.this);
              AppMethodBeat.o(132549);
            }
          });
          bool = false;
        }
        for (;;)
        {
          label565:
          ((c)localObject1).ds("NetSceneInit");
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().gBq.sJ(l);
          localObject1 = f.this;
          if (((f)localObject1).ieJ == null) {
            ad.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progressRef is null");
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
            localObject3 = ((f.a)localObject2).ieT.GWf;
            if ((localObject3 != null) && (((LinkedList)localObject3).size() > ((f.a)localObject2).hYM))
            {
              ((LinkedList)localObject3).size();
              if (((c)localObject1).a((zu)((LinkedList)localObject3).get(((f.a)localObject2).hYM), true)) {}
            }
            else
            {
              f.this.hYx.poll();
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajC().ajl().set(8197, bt.cE(z.a(((f.a)localObject2).ieT.GWb)));
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajC().ajl().set(8198, bt.cE(z.a(((f.a)localObject2).ieT.GWc)));
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajC().ajl().set(16, Integer.valueOf(0));
              ad.i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s, cur[%s], max[%s]", new Object[] { Long.valueOf(((f.a)localObject2).ieT.FMr), bt.cE(z.a(((f.a)localObject2).ieT.GWb)), bt.cE(z.a(((f.a)localObject2).ieT.GWc)) });
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajC().ajl().set(8196, Long.valueOf(((f.a)localObject2).ieT.FMr));
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajC().ajl().fqc();
              bool = true;
              break label565;
            }
            ((f.a)localObject2).hYM += 1;
            localObject2 = f.this;
            ((f)localObject2).ieO += 1;
            j += 1;
            break label266;
            localObject2 = (com.tencent.mm.al.g)((f)localObject1).ieJ.get();
            if (localObject2 != null) {
              break label954;
            }
            ad.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
          }
          label954:
          label967:
          float f1;
          if (((f)localObject1).ieL > 50)
          {
            i = 50;
            f1 = 1.0F;
            if (((f)localObject1).ieM) {
              break label1053;
            }
          }
          for (j = i;; j = (int)((100 - i) * f1 + i))
          {
            ad.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[] { Integer.valueOf(((f)localObject1).ieO), Integer.valueOf(((f)localObject1).ieN), Float.valueOf(f1), Integer.valueOf(i) });
            ((com.tencent.mm.al.g)localObject2).a(j, 100, (n)localObject1);
            break;
            i = ((f)localObject1).ieL;
            break label967;
            label1053:
            float f2 = ((f)localObject1).ieO / ((f)localObject1).ieN;
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
    ad.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    this.ies.append("stack:" + bt.flS() + " time:" + bt.aQJ());
    this.ieJ = new WeakReference(paramg);
    AppMethodBeat.o(132552);
  }
  
  private int a(com.tencent.mm.network.e parame, SKBuiltinBuffer_t paramSKBuiltinBuffer_t1, SKBuiltinBuffer_t paramSKBuiltinBuffer_t2)
  {
    AppMethodBeat.i(132554);
    this.ies.append(" lastd:" + this.lastdispatch + " dotime:" + bt.aQJ() + " net:" + ay.getNetType(aj.getContext()));
    b localb = new b();
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = paramSKBuiltinBuffer_t1;
    if (paramSKBuiltinBuffer_t1 == null)
    {
      com.tencent.mm.kernel.g.ajD();
      localSKBuiltinBuffer_t = z.al(bt.aRa(bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(8197, null))));
    }
    paramSKBuiltinBuffer_t1 = paramSKBuiltinBuffer_t2;
    if (paramSKBuiltinBuffer_t2 == null)
    {
      com.tencent.mm.kernel.g.ajD();
      paramSKBuiltinBuffer_t1 = z.al(bt.aRa(bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(8198, null))));
    }
    com.tencent.mm.kernel.g.ajD();
    if ((bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(16, null)) != 0) && ((localSKBuiltinBuffer_t == null) || (localSKBuiltinBuffer_t.getILen() <= 0))) {
      localb.getReqObj().setSceneStatus(7);
    }
    for (;;)
    {
      this.ieK.GWb = localSKBuiltinBuffer_t;
      this.ieK.GWc = paramSKBuiltinBuffer_t1;
      ((u.a)localb.getReqObj()).Fov = this.ieK;
      ad.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.gFK.abj()), Integer.valueOf(this.ieL), this.ieK.nDo, this.ieK.qei, Integer.valueOf(localb.getReqObj().getSceneStatus()), bt.cE(z.a(localSKBuiltinBuffer_t)), bt.cE(z.a(paramSKBuiltinBuffer_t1)) });
      this.ieL += 1;
      int i = dispatch(parame, localb, this);
      AppMethodBeat.o(132554);
      return i;
      com.tencent.mm.kernel.g.ajD();
      if (bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(8195, null)).length() <= 0) {
        localb.getReqObj().setSceneStatus(3);
      } else {
        localb.getReqObj().setSceneStatus(4);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, cck paramcck)
  {
    AppMethodBeat.i(132557);
    a locala = new a();
    locala.ieU = paramInt1;
    locala.errCode = paramInt3;
    locala.errType = paramInt2;
    locala.errMsg = paramString;
    locala.ieT = paramcck;
    this.hYx.add(locala);
    if (this.hMj.fkZ()) {
      this.hMj.az(50L, 50L);
    }
    AppMethodBeat.o(132557);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(132556);
    ad.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[] { bt.flS() });
    super.cancel();
    this.ieP = true;
    AppMethodBeat.o(132556);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(132553);
    this.gFK = new com.tencent.mm.compatible.util.f.a();
    this.callback = paramf;
    paramf = this.ieK;
    com.tencent.mm.kernel.g.ajD();
    paramf.nDo = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, null));
    if (!bt.isNullOrNil(this.ieK.nDo)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("by DK: req.UserName is null", bool);
      this.ieK.qei = ac.fks();
      int i = a(parame, null, null);
      AppMethodBeat.o(132553);
      return i;
    }
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132558);
    String str = this.ies.toString();
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
    this.ies.append(" endtime:" + bt.aQJ());
    ad.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramInt1) });
    if ((paramInt2 == 4) && (paramInt3 == -100))
    {
      ad.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.ieP = true;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(132555);
      return;
    }
    if (((paramInt2 != 0) || (paramInt3 != 0)) && ((paramInt2 != 4) || (paramInt3 != -17)))
    {
      ad.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", new Object[] { Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (this.retryCount > 0)
      {
        this.retryCount -= 1;
        if (a(dispatcher(), null, null) != -1) {}
      }
      else
      {
        this.ieP = true;
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(132555);
      return;
    }
    paramq = ((u.b)paramq.getRespObj()).Fow;
    this.ieN += paramq.GWe;
    ad.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(this.gFK.abj()), Integer.valueOf(this.ieN), Integer.valueOf(this.ieL), Integer.valueOf(paramq.FMr) });
    a(this.ieL - 1, paramInt2, paramInt3, paramString, paramq);
    if (((paramq.FMr & 0x7) != 0) && (!securityLimitCountReach()))
    {
      if (a(dispatcher(), paramq.GWb, paramq.GWc) == -1)
      {
        ad.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
        a(2147483647, 3, -1, "", null);
        AppMethodBeat.o(132555);
      }
    }
    else
    {
      ad.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.gFK.abj()), Integer.valueOf(this.ieL) });
      this.ieM = true;
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
    return n.b.hOp;
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
    int hYM = 0;
    cck ieT;
    int ieU = 0;
    
    a() {}
  }
  
  public static final class b
    extends l
  {
    private final u.a ieV;
    private final u.b ieW;
    
    public b()
    {
      AppMethodBeat.i(132551);
      this.ieV = new u.a();
      this.ieW = new u.b();
      AppMethodBeat.o(132551);
    }
    
    public final l.d getReqObjImp()
    {
      return this.ieV;
    }
    
    public final l.e getRespObj()
    {
      return this.ieW;
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