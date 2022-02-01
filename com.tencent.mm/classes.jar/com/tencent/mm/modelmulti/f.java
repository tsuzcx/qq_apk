package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.j;
import com.tencent.mm.an.o;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.protocal.protobuf.dcj;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class f
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.compatible.util.f.a khd;
  private final MTimerHandler lAo;
  private final Queue<a> lMI;
  private StringBuilder lSF;
  WeakReference<j> lSV;
  final dci lSW;
  int lSX;
  boolean lSY;
  int lSZ;
  int lTa;
  private boolean lTb;
  private int retryCount;
  
  public f(j paramj)
  {
    AppMethodBeat.i(132552);
    this.lSV = null;
    this.lSW = new dci();
    this.lSF = new StringBuilder();
    this.lSX = 0;
    this.lSY = false;
    this.lSZ = 0;
    this.lTa = 0;
    this.retryCount = 3;
    this.lTb = false;
    this.lMI = new LinkedList();
    this.lAo = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132550);
        if ((!com.tencent.mm.kernel.h.aHB()) || (b.aGE()))
        {
          Log.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.a(f.this))
        {
          Log.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[] { Integer.valueOf(f.this.hashCode()) });
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.b(f.this).isEmpty())
        {
          Log.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(132550);
          return false;
        }
        Log.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.c(f.this).avE()), Integer.valueOf(f.b(f.this).size()), Integer.valueOf(f.d(f.this)), Boolean.valueOf(f.e(f.this)), Integer.valueOf(f.f(f.this)), Integer.valueOf(f.g(f.this)) });
        com.tencent.mm.kernel.h.aHH();
        long l = com.tencent.mm.kernel.h.aHG().kcF.beginTransaction(Thread.currentThread().getId());
        Object localObject1 = new c();
        ((c)localObject1).dC("NetSceneInit");
        int i;
        int j;
        label266:
        Object localObject2;
        boolean bool;
        label310:
        Object localObject3;
        if (f.e(f.this))
        {
          i = 40;
          j = 0;
          if (j >= i) {
            break label1083;
          }
          localObject2 = (f.a)f.b(f.this).peek();
          if (((f.a)localObject2).lTg != 2147483647) {
            break label630;
          }
          if (((f.a)localObject2).lTf != null) {
            break label624;
          }
          bool = true;
          Assert.assertTrue("in Queue tail , resp should be null", bool);
          com.tencent.mm.kernel.h.aHH();
          localObject3 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(8198, null);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(8195, localObject3);
          MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.avK()).edit().putString("notify_sync_key_keybuf", (String)localObject3).commit();
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(8197, "");
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(8198, "");
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(15, Integer.valueOf(1));
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().hxT();
          Log.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.c(f.this).avE()), Integer.valueOf(f.d(f.this)), Integer.valueOf(f.g(f.this)), Integer.valueOf(((f.a)localObject2).errType), Integer.valueOf(((f.a)localObject2).errCode) });
          com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(132549);
              f.h(f.this).onSceneEnd(this.lTd.errType, this.lTd.errCode, this.lTd.errMsg, f.this);
              AppMethodBeat.o(132549);
            }
          });
          bool = false;
        }
        for (;;)
        {
          label565:
          ((c)localObject1).dD("NetSceneInit");
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l);
          localObject1 = f.this;
          if (((f)localObject1).lSV == null) {
            Log.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progressRef is null");
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
            localObject3 = ((f.a)localObject2).lTf.TJN;
            if ((localObject3 != null) && (((LinkedList)localObject3).size() > ((f.a)localObject2).lMX))
            {
              ((LinkedList)localObject3).size();
              if (((c)localObject1).a((abu)((LinkedList)localObject3).get(((f.a)localObject2).lMX), true)) {}
            }
            else
            {
              f.b(f.this).poll();
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().i(8197, Util.encodeHexString(z.a(((f.a)localObject2).lTf.TJJ)));
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().i(8198, Util.encodeHexString(z.a(((f.a)localObject2).lTf.TJK)));
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().i(16, Integer.valueOf(0));
              Log.i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s, cur[%s], max[%s]", new Object[] { Long.valueOf(((f.a)localObject2).lTf.Saq), Util.encodeHexString(z.a(((f.a)localObject2).lTf.TJJ)), Util.encodeHexString(z.a(((f.a)localObject2).lTf.TJK)) });
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().i(8196, Long.valueOf(((f.a)localObject2).lTf.Saq));
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().hxT();
              bool = true;
              break label565;
            }
            ((f.a)localObject2).lMX += 1;
            f.i(f.this);
            j += 1;
            break label266;
            localObject2 = (j)((f)localObject1).lSV.get();
            if (localObject2 != null) {
              break label944;
            }
            Log.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
          }
          label944:
          label957:
          float f1;
          if (((f)localObject1).lSX > 50)
          {
            i = 50;
            f1 = 1.0F;
            if (((f)localObject1).lSY) {
              break label1043;
            }
          }
          for (j = i;; j = (int)((100 - i) * f1 + i))
          {
            Log.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[] { Integer.valueOf(((f)localObject1).lTa), Integer.valueOf(((f)localObject1).lSZ), Float.valueOf(f1), Integer.valueOf(i) });
            ((j)localObject2).a(j, 100, (q)localObject1);
            break;
            i = ((f)localObject1).lSX;
            break label957;
            label1043:
            float f2 = ((f)localObject1).lTa / ((f)localObject1).lSZ;
            f1 = f2;
            if (f2 > 1.0F) {
              f1 = 1.0F;
            }
          }
          label1083:
          bool = true;
        }
      }
    }, true);
    Log.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.lSF.append("stack:" + Util.getStack() + " time:" + Util.nowSecond());
    this.lSV = new WeakReference(paramj);
    AppMethodBeat.o(132552);
  }
  
  private int a(com.tencent.mm.network.g paramg, eae parameae1, eae parameae2)
  {
    AppMethodBeat.i(132554);
    this.lSF.append(" lastd:" + this.lastdispatch + " dotime:" + Util.nowSecond() + " net:" + NetStatusUtil.getNetType(MMApplicationContext.getContext()));
    b localb = new b();
    eae localeae = parameae1;
    if (parameae1 == null)
    {
      com.tencent.mm.kernel.h.aHH();
      localeae = z.aN(Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(8197, null))));
    }
    parameae1 = parameae2;
    if (parameae2 == null)
    {
      com.tencent.mm.kernel.h.aHH();
      parameae1 = z.aN(Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(8198, null))));
    }
    com.tencent.mm.kernel.h.aHH();
    if ((Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(16, null)) != 0) && ((localeae == null) || (localeae.Ufv <= 0))) {
      localb.getReqObj().setSceneStatus(7);
    }
    for (;;)
    {
      this.lSW.TJJ = localeae;
      this.lSW.TJK = parameae1;
      ((u.a)localb.getReqObj()).RBU = this.lSW;
      Log.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.khd.avE()), Integer.valueOf(this.lSX), this.lSW.UserName, this.lSW.vhq, Integer.valueOf(localb.getReqObj().getSceneStatus()), Util.encodeHexString(z.a(localeae)), Util.encodeHexString(z.a(parameae1)) });
      this.lSX += 1;
      int i = dispatch(paramg, localb, this);
      AppMethodBeat.o(132554);
      return i;
      com.tencent.mm.kernel.h.aHH();
      if (Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(8195, null)).length() <= 0) {
        localb.getReqObj().setSceneStatus(3);
      } else {
        localb.getReqObj().setSceneStatus(4);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, dcj paramdcj)
  {
    AppMethodBeat.i(132557);
    a locala = new a();
    locala.lTg = paramInt1;
    locala.errCode = paramInt3;
    locala.errType = paramInt2;
    locala.errMsg = paramString;
    locala.lTf = paramdcj;
    this.lMI.add(locala);
    if (this.lAo.stopped()) {
      this.lAo.startTimer(50L);
    }
    AppMethodBeat.o(132557);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(132556);
    Log.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[] { Util.getStack() });
    super.cancel();
    this.lTb = true;
    AppMethodBeat.o(132556);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(132553);
    this.khd = new com.tencent.mm.compatible.util.f.a();
    this.callback = parami;
    parami = this.lSW;
    com.tencent.mm.kernel.h.aHH();
    parami.UserName = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null));
    if (!Util.isNullOrNil(this.lSW.UserName)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("by DK: req.UserName is null", bool);
      this.lSW.vhq = LocaleUtil.getApplicationLanguage();
      int i = a(paramg, null, null);
      AppMethodBeat.o(132553);
      return i;
    }
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132558);
    String str = this.lSF.toString();
    AppMethodBeat.o(132558);
    return str;
  }
  
  public final int getType()
  {
    return 139;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132555);
    this.lSF.append(" endtime:" + Util.nowSecond());
    Log.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramInt1) });
    if ((paramInt2 == 4) && ((paramInt3 == -100) || (paramInt3 == -2023)))
    {
      Log.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.lTb = true;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(132555);
      return;
    }
    if (((paramInt2 != 0) || (paramInt3 != 0)) && ((paramInt2 != 4) || (paramInt3 != -17)))
    {
      Log.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", new Object[] { Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (this.retryCount > 0)
      {
        this.retryCount -= 1;
        if (a(dispatcher(), null, null) != -1) {}
      }
      else
      {
        this.lTb = true;
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(132555);
      return;
    }
    params = ((u.b)params.getRespObj()).RBV;
    this.lSZ += params.TJM;
    Log.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(this.khd.avE()), Integer.valueOf(this.lSZ), Integer.valueOf(this.lSX), Integer.valueOf(params.Saq) });
    a(this.lSX - 1, paramInt2, paramInt3, paramString, params);
    if (((params.Saq & 0x7) != 0) && (!securityLimitCountReach()))
    {
      if (a(dispatcher(), params.TJJ, params.TJK) == -1)
      {
        Log.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
        a(2147483647, 3, -1, "", null);
        AppMethodBeat.o(132555);
      }
    }
    else
    {
      Log.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.khd.avE()), Integer.valueOf(this.lSX) });
      this.lSY = true;
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
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
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
    int lMX = 0;
    dcj lTf;
    int lTg = 0;
    
    a() {}
  }
  
  public static final class b
    extends o
  {
    private final u.a lTh;
    private final u.b lTi;
    
    public b()
    {
      AppMethodBeat.i(132551);
      this.lTh = new u.a();
      this.lTi = new u.b();
      AppMethodBeat.o(132551);
    }
    
    public final l.d getReqObjImp()
    {
      return this.lTh;
    }
    
    public final l.e getRespObj()
    {
      return this.lTi;
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