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
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class f
  extends n
  implements k
{
  com.tencent.mm.ak.g callback;
  com.tencent.mm.compatible.util.f.a gma;
  final Queue<a> hFS;
  WeakReference<com.tencent.mm.ak.h> hLP;
  final bxs hLQ;
  int hLR;
  boolean hLS;
  int hLT;
  int hLU;
  boolean hLV;
  private StringBuilder hLy;
  private final au htR;
  private int retryCount;
  
  public f(com.tencent.mm.ak.h paramh)
  {
    AppMethodBeat.i(132552);
    this.hLP = null;
    this.hLQ = new bxs();
    this.hLy = new StringBuilder();
    this.hLR = 0;
    this.hLS = false;
    this.hLT = 0;
    this.hLU = 0;
    this.retryCount = 3;
    this.hLV = false;
    this.hFS = new LinkedList();
    this.htR = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132550);
        if ((!com.tencent.mm.kernel.g.agM()) || (a.afS()))
        {
          ac.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.this.hLV)
        {
          ac.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[] { Integer.valueOf(f.this.hashCode()) });
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.this.hFS.isEmpty())
        {
          ac.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(132550);
          return false;
        }
        ac.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.gma.YH()), Integer.valueOf(f.this.hFS.size()), Integer.valueOf(f.this.hLR), Boolean.valueOf(f.this.hLS), Integer.valueOf(f.this.hLU), Integer.valueOf(f.this.hLT) });
        com.tencent.mm.kernel.g.agS();
        long l = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
        Object localObject1 = new c();
        ((c)localObject1).jdMethod_do("NetSceneInit");
        int i;
        int j;
        label266:
        Object localObject2;
        boolean bool;
        label310:
        Object localObject3;
        if (f.this.hLS)
        {
          i = 40;
          j = 0;
          if (j >= i) {
            break label1093;
          }
          localObject2 = (f.a)f.this.hFS.peek();
          if (((f.a)localObject2).hMa != 2147483647) {
            break label630;
          }
          if (((f.a)localObject2).hLZ != null) {
            break label624;
          }
          bool = true;
          Assert.assertTrue("in Queue tail , resp should be null", bool);
          com.tencent.mm.kernel.g.agS();
          localObject3 = (String)com.tencent.mm.kernel.g.agR().agA().get(8198, null);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(8195, localObject3);
          ai.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.YK()).edit().putString("notify_sync_key_keybuf", (String)localObject3).commit();
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(8197, "");
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(8198, "");
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(15, Integer.valueOf(1));
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().faa();
          ac.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.gma.YH()), Integer.valueOf(f.this.hLR), Integer.valueOf(f.this.hLT), Integer.valueOf(((f.a)localObject2).errType), Integer.valueOf(((f.a)localObject2).errCode) });
          com.tencent.mm.kernel.g.agU().az(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(132549);
              f.this.callback.onSceneEnd(this.hLX.errType, this.hLX.errCode, this.hLX.errMsg, f.this);
              AppMethodBeat.o(132549);
            }
          });
          bool = false;
        }
        for (;;)
        {
          label565:
          ((c)localObject1).dp("NetSceneInit");
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().ghG.qL(l);
          localObject1 = f.this;
          if (((f)localObject1).hLP == null) {
            ac.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progressRef is null");
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
            localObject3 = ((f.a)localObject2).hLZ.Fmw;
            if ((localObject3 != null) && (((LinkedList)localObject3).size() > ((f.a)localObject2).hGg))
            {
              ((LinkedList)localObject3).size();
              if (((c)localObject1).a((xv)((LinkedList)localObject3).get(((f.a)localObject2).hGg), true)) {}
            }
            else
            {
              f.this.hFS.poll();
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agR().agA().set(8197, bs.cx(z.a(((f.a)localObject2).hLZ.Fms)));
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agR().agA().set(8198, bs.cx(z.a(((f.a)localObject2).hLZ.Fmt)));
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agR().agA().set(16, Integer.valueOf(0));
              ac.i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s, cur[%s], max[%s]", new Object[] { Long.valueOf(((f.a)localObject2).hLZ.EfS), bs.cx(z.a(((f.a)localObject2).hLZ.Fms)), bs.cx(z.a(((f.a)localObject2).hLZ.Fmt)) });
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agR().agA().set(8196, Long.valueOf(((f.a)localObject2).hLZ.EfS));
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agR().agA().faa();
              bool = true;
              break label565;
            }
            ((f.a)localObject2).hGg += 1;
            localObject2 = f.this;
            ((f)localObject2).hLU += 1;
            j += 1;
            break label266;
            localObject2 = (com.tencent.mm.ak.h)((f)localObject1).hLP.get();
            if (localObject2 != null) {
              break label954;
            }
            ac.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
          }
          label954:
          label967:
          float f1;
          if (((f)localObject1).hLR > 50)
          {
            i = 50;
            f1 = 1.0F;
            if (((f)localObject1).hLS) {
              break label1053;
            }
          }
          for (j = i;; j = (int)((100 - i) * f1 + i))
          {
            ac.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[] { Integer.valueOf(((f)localObject1).hLU), Integer.valueOf(((f)localObject1).hLT), Float.valueOf(f1), Integer.valueOf(i) });
            ((com.tencent.mm.ak.h)localObject2).a(j, 100, (n)localObject1);
            break;
            i = ((f)localObject1).hLR;
            break label967;
            label1053:
            float f2 = ((f)localObject1).hLU / ((f)localObject1).hLT;
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
    ac.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    this.hLy.append("stack:" + bs.eWi() + " time:" + bs.aNx());
    this.hLP = new WeakReference(paramh);
    AppMethodBeat.o(132552);
  }
  
  private int a(com.tencent.mm.network.e parame, SKBuiltinBuffer_t paramSKBuiltinBuffer_t1, SKBuiltinBuffer_t paramSKBuiltinBuffer_t2)
  {
    AppMethodBeat.i(132554);
    this.hLy.append(" lastd:" + this.lastdispatch + " dotime:" + bs.aNx() + " net:" + ax.getNetType(ai.getContext()));
    b localb = new b();
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = paramSKBuiltinBuffer_t1;
    if (paramSKBuiltinBuffer_t1 == null)
    {
      com.tencent.mm.kernel.g.agS();
      localSKBuiltinBuffer_t = z.al(bs.aLu(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8197, null))));
    }
    paramSKBuiltinBuffer_t1 = paramSKBuiltinBuffer_t2;
    if (paramSKBuiltinBuffer_t2 == null)
    {
      com.tencent.mm.kernel.g.agS();
      paramSKBuiltinBuffer_t1 = z.al(bs.aLu(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8198, null))));
    }
    com.tencent.mm.kernel.g.agS();
    if ((bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(16, null)) != 0) && ((localSKBuiltinBuffer_t == null) || (localSKBuiltinBuffer_t.getILen() <= 0))) {
      localb.getReqObj().setSceneStatus(7);
    }
    for (;;)
    {
      this.hLQ.Fms = localSKBuiltinBuffer_t;
      this.hLQ.Fmt = paramSKBuiltinBuffer_t1;
      ((u.a)localb.getReqObj()).DJo = this.hLQ;
      ac.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.gma.YH()), Integer.valueOf(this.hLR), this.hLQ.ncR, this.hLQ.pAD, Integer.valueOf(localb.getReqObj().getSceneStatus()), bs.cx(z.a(localSKBuiltinBuffer_t)), bs.cx(z.a(paramSKBuiltinBuffer_t1)) });
      this.hLR += 1;
      int i = dispatch(parame, localb, this);
      AppMethodBeat.o(132554);
      return i;
      com.tencent.mm.kernel.g.agS();
      if (bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8195, null)).length() <= 0) {
        localb.getReqObj().setSceneStatus(3);
      } else {
        localb.getReqObj().setSceneStatus(4);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, bxt parambxt)
  {
    AppMethodBeat.i(132557);
    a locala = new a();
    locala.hMa = paramInt1;
    locala.errCode = paramInt3;
    locala.errType = paramInt2;
    locala.errMsg = paramString;
    locala.hLZ = parambxt;
    this.hFS.add(locala);
    if (this.htR.eVs()) {
      this.htR.au(50L, 50L);
    }
    AppMethodBeat.o(132557);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(132556);
    ac.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[] { bs.eWi() });
    super.cancel();
    this.hLV = true;
    AppMethodBeat.o(132556);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(132553);
    this.gma = new com.tencent.mm.compatible.util.f.a();
    this.callback = paramg;
    paramg = this.hLQ;
    com.tencent.mm.kernel.g.agS();
    paramg.ncR = ((String)com.tencent.mm.kernel.g.agR().agA().get(2, null));
    if (!bs.isNullOrNil(this.hLQ.ncR)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("by DK: req.UserName is null", bool);
      this.hLQ.pAD = ab.eUO();
      int i = a(parame, null, null);
      AppMethodBeat.o(132553);
      return i;
    }
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132558);
    String str = this.hLy.toString();
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
    this.hLy.append(" endtime:" + bs.aNx());
    ac.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramInt1) });
    if ((paramInt2 == 4) && (paramInt3 == -100))
    {
      ac.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.hLV = true;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(132555);
      return;
    }
    if (((paramInt2 != 0) || (paramInt3 != 0)) && ((paramInt2 != 4) || (paramInt3 != -17)))
    {
      ac.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", new Object[] { Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (this.retryCount > 0)
      {
        this.retryCount -= 1;
        if (a(dispatcher(), null, null) != -1) {}
      }
      else
      {
        this.hLV = true;
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(132555);
      return;
    }
    paramq = ((u.b)paramq.getRespObj()).DJp;
    this.hLT += paramq.Fmv;
    ac.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(this.gma.YH()), Integer.valueOf(this.hLT), Integer.valueOf(this.hLR), Integer.valueOf(paramq.EfS) });
    a(this.hLR - 1, paramInt2, paramInt3, paramString, paramq);
    if (((paramq.EfS & 0x7) != 0) && (!securityLimitCountReach()))
    {
      if (a(dispatcher(), paramq.Fms, paramq.Fmt) == -1)
      {
        ac.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
        a(2147483647, 3, -1, "", null);
        AppMethodBeat.o(132555);
      }
    }
    else
    {
      ac.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.gma.YH()), Integer.valueOf(this.hLR) });
      this.hLS = true;
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
    return n.b.hwa;
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
    int hGg = 0;
    bxt hLZ;
    int hMa = 0;
    
    a() {}
  }
  
  public static final class b
    extends l
  {
    private final u.a hMb;
    private final u.b hMc;
    
    public b()
    {
      AppMethodBeat.i(132551);
      this.hMb = new u.a();
      this.hMc = new u.b();
      AppMethodBeat.o(132551);
    }
    
    public final l.d getReqObjImp()
    {
      return this.hMb;
    }
    
    public final l.e getRespObj()
    {
      return this.hMc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.f
 * JD-Core Version:    0.7.0.1
 */