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
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.xd;
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
import com.tencent.mm.storage.ab;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class f
  extends n
  implements k
{
  com.tencent.mm.al.g callback;
  private final av gTs;
  com.tencent.mm.compatible.util.f.a ghu;
  final Queue<a> hfp;
  private StringBuilder hkV;
  WeakReference<com.tencent.mm.al.h> hlm;
  final btb hln;
  int hlo;
  boolean hlp;
  int hlq;
  int hlr;
  boolean hls;
  private int retryCount;
  
  public f(com.tencent.mm.al.h paramh)
  {
    AppMethodBeat.i(132552);
    this.hlm = null;
    this.hln = new btb();
    this.hkV = new StringBuilder();
    this.hlo = 0;
    this.hlp = false;
    this.hlq = 0;
    this.hlr = 0;
    this.retryCount = 3;
    this.hls = false;
    this.hfp = new LinkedList();
    this.gTs = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132550);
        if ((!com.tencent.mm.kernel.g.afw()) || (a.aeC()))
        {
          ad.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.this.hls)
        {
          ad.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[] { Integer.valueOf(f.this.hashCode()) });
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.this.hfp.isEmpty())
        {
          ad.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(132550);
          return false;
        }
        ad.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.ghu.XK()), Integer.valueOf(f.this.hfp.size()), Integer.valueOf(f.this.hlo), Boolean.valueOf(f.this.hlp), Integer.valueOf(f.this.hlr), Integer.valueOf(f.this.hlq) });
        com.tencent.mm.kernel.g.afC();
        long l = com.tencent.mm.kernel.g.afB().gda.rb(Thread.currentThread().getId());
        Object localObject1 = new c();
        ((c)localObject1).dn("NetSceneInit");
        int i;
        int j;
        label266:
        Object localObject2;
        boolean bool;
        label310:
        Object localObject3;
        if (f.this.hlp)
        {
          i = 40;
          j = 0;
          if (j >= i) {
            break label1093;
          }
          localObject2 = (f.a)f.this.hfp.peek();
          if (((f.a)localObject2).hlx != 2147483647) {
            break label630;
          }
          if (((f.a)localObject2).hlw != null) {
            break label624;
          }
          bool = true;
          Assert.assertTrue("in Queue tail , resp should be null", bool);
          com.tencent.mm.kernel.g.afC();
          localObject3 = (String)com.tencent.mm.kernel.g.afB().afk().get(8198, null);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(8195, localObject3);
          aj.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.XN()).edit().putString("notify_sync_key_keybuf", (String)localObject3).commit();
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(8197, "");
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(8198, "");
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(15, Integer.valueOf(1));
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().eKy();
          ad.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.ghu.XK()), Integer.valueOf(f.this.hlo), Integer.valueOf(f.this.hlq), Integer.valueOf(((f.a)localObject2).errType), Integer.valueOf(((f.a)localObject2).errCode) });
          com.tencent.mm.kernel.g.afE().ax(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(132549);
              f.this.callback.onSceneEnd(this.hlu.errType, this.hlu.errCode, this.hlu.errMsg, f.this);
              AppMethodBeat.o(132549);
            }
          });
          bool = false;
        }
        for (;;)
        {
          label565:
          ((c)localObject1).jdMethod_do("NetSceneInit");
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().gda.mX(l);
          localObject1 = f.this;
          if (((f)localObject1).hlm == null) {
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
            localObject3 = ((f.a)localObject2).hlw.DQf;
            if ((localObject3 != null) && (((LinkedList)localObject3).size() > ((f.a)localObject2).hfD))
            {
              ((LinkedList)localObject3).size();
              if (((c)localObject1).a((xd)((LinkedList)localObject3).get(((f.a)localObject2).hfD), true)) {}
            }
            else
            {
              f.this.hfp.poll();
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afB().afk().set(8197, bt.cy(z.a(((f.a)localObject2).hlw.DQb)));
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afB().afk().set(8198, bt.cy(z.a(((f.a)localObject2).hlw.DQc)));
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afB().afk().set(16, Integer.valueOf(0));
              ad.i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s, cur[%s], max[%s]", new Object[] { Long.valueOf(((f.a)localObject2).hlw.CNq), bt.cy(z.a(((f.a)localObject2).hlw.DQb)), bt.cy(z.a(((f.a)localObject2).hlw.DQc)) });
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afB().afk().set(8196, Long.valueOf(((f.a)localObject2).hlw.CNq));
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afB().afk().eKy();
              bool = true;
              break label565;
            }
            ((f.a)localObject2).hfD += 1;
            localObject2 = f.this;
            ((f)localObject2).hlr += 1;
            j += 1;
            break label266;
            localObject2 = (com.tencent.mm.al.h)((f)localObject1).hlm.get();
            if (localObject2 != null) {
              break label954;
            }
            ad.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
          }
          label954:
          label967:
          float f1;
          if (((f)localObject1).hlo > 50)
          {
            i = 50;
            f1 = 1.0F;
            if (((f)localObject1).hlp) {
              break label1053;
            }
          }
          for (j = i;; j = (int)((100 - i) * f1 + i))
          {
            ad.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[] { Integer.valueOf(((f)localObject1).hlr), Integer.valueOf(((f)localObject1).hlq), Float.valueOf(f1), Integer.valueOf(i) });
            ((com.tencent.mm.al.h)localObject2).a(j, 100, (n)localObject1);
            break;
            i = ((f)localObject1).hlo;
            break label967;
            label1053:
            float f2 = ((f)localObject1).hlr / ((f)localObject1).hlq;
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
    ad.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    this.hkV.append("stack:" + bt.eGN() + " time:" + bt.aGK());
    this.hlm = new WeakReference(paramh);
    AppMethodBeat.o(132552);
  }
  
  private int a(com.tencent.mm.network.e parame, SKBuiltinBuffer_t paramSKBuiltinBuffer_t1, SKBuiltinBuffer_t paramSKBuiltinBuffer_t2)
  {
    AppMethodBeat.i(132554);
    this.hkV.append(" lastd:" + this.lastdispatch + " dotime:" + bt.aGK() + " net:" + ay.getNetType(aj.getContext()));
    b localb = new b();
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = paramSKBuiltinBuffer_t1;
    if (paramSKBuiltinBuffer_t1 == null)
    {
      com.tencent.mm.kernel.g.afC();
      localSKBuiltinBuffer_t = z.am(bt.aGd(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8197, null))));
    }
    paramSKBuiltinBuffer_t1 = paramSKBuiltinBuffer_t2;
    if (paramSKBuiltinBuffer_t2 == null)
    {
      com.tencent.mm.kernel.g.afC();
      paramSKBuiltinBuffer_t1 = z.am(bt.aGd(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8198, null))));
    }
    com.tencent.mm.kernel.g.afC();
    if ((bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(16, null)) != 0) && ((localSKBuiltinBuffer_t == null) || (localSKBuiltinBuffer_t.getILen() <= 0))) {
      localb.getReqObj().setSceneStatus(7);
    }
    for (;;)
    {
      this.hln.DQb = localSKBuiltinBuffer_t;
      this.hln.DQc = paramSKBuiltinBuffer_t1;
      ((u.a)localb.getReqObj()).CqW = this.hln;
      ad.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.ghu.XK()), Integer.valueOf(this.hlo), this.hln.mAQ, this.hln.oXs, Integer.valueOf(localb.getReqObj().getSceneStatus()), bt.cy(z.a(localSKBuiltinBuffer_t)), bt.cy(z.a(paramSKBuiltinBuffer_t1)) });
      this.hlo += 1;
      int i = dispatch(parame, localb, this);
      AppMethodBeat.o(132554);
      return i;
      com.tencent.mm.kernel.g.afC();
      if (bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8195, null)).length() <= 0) {
        localb.getReqObj().setSceneStatus(3);
      } else {
        localb.getReqObj().setSceneStatus(4);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, btc parambtc)
  {
    AppMethodBeat.i(132557);
    a locala = new a();
    locala.hlx = paramInt1;
    locala.errCode = paramInt3;
    locala.errType = paramInt2;
    locala.errMsg = paramString;
    locala.hlw = parambtc;
    this.hfp.add(locala);
    if (this.gTs.eFX()) {
      this.gTs.av(50L, 50L);
    }
    AppMethodBeat.o(132557);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(132556);
    ad.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[] { bt.eGN() });
    super.cancel();
    this.hls = true;
    AppMethodBeat.o(132556);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(132553);
    this.ghu = new com.tencent.mm.compatible.util.f.a();
    this.callback = paramg;
    paramg = this.hln;
    com.tencent.mm.kernel.g.afC();
    paramg.mAQ = ((String)com.tencent.mm.kernel.g.afB().afk().get(2, null));
    if (!bt.isNullOrNil(this.hln.mAQ)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("by DK: req.UserName is null", bool);
      this.hln.oXs = ac.eFu();
      int i = a(parame, null, null);
      AppMethodBeat.o(132553);
      return i;
    }
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132558);
    String str = this.hkV.toString();
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
    this.hkV.append(" endtime:" + bt.aGK());
    ad.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramInt1) });
    if ((paramInt2 == 4) && (paramInt3 == -100))
    {
      ad.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.hls = true;
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
        this.hls = true;
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(132555);
      return;
    }
    paramq = ((u.b)paramq.getRespObj()).CqX;
    this.hlq += paramq.DQe;
    ad.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(this.ghu.XK()), Integer.valueOf(this.hlq), Integer.valueOf(this.hlo), Integer.valueOf(paramq.CNq) });
    a(this.hlo - 1, paramInt2, paramInt3, paramString, paramq);
    if (((paramq.CNq & 0x7) != 0) && (!securityLimitCountReach()))
    {
      if (a(dispatcher(), paramq.DQb, paramq.DQc) == -1)
      {
        ad.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
        a(2147483647, 3, -1, "", null);
        AppMethodBeat.o(132555);
      }
    }
    else
    {
      ad.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.ghu.XK()), Integer.valueOf(this.hlo) });
      this.hlp = true;
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
    return n.b.gVB;
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
    int hfD = 0;
    btc hlw;
    int hlx = 0;
    
    a() {}
  }
  
  public static final class b
    extends l
  {
    private final u.a hly;
    private final u.b hlz;
    
    public b()
    {
      AppMethodBeat.i(132551);
      this.hly = new u.a();
      this.hlz = new u.b();
      AppMethodBeat.o(132551);
    }
    
    public final l.d getReqObjImp()
    {
      return this.hly;
    }
    
    public final l.e getRespObj()
    {
      return this.hlz;
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