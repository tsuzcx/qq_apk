package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.i;
import com.tencent.mm.am.n;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.dua;
import com.tencent.mm.protocal.protobuf.dub;
import com.tencent.mm.protocal.protobuf.gol;
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
import com.tencent.mm.storage.aq;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class k
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private f.a mHw;
  private final Queue<a> oFp;
  WeakReference<i> oLO;
  final dua oLP;
  int oLQ;
  boolean oLR;
  int oLS;
  int oLT;
  private boolean oLU;
  private StringBuilder oLy;
  private final MTimerHandler orP;
  private int retryCount;
  
  public k(i parami)
  {
    AppMethodBeat.i(132552);
    this.oLO = null;
    this.oLP = new dua();
    this.oLy = new StringBuilder();
    this.oLQ = 0;
    this.oLR = false;
    this.oLS = 0;
    this.oLT = 0;
    this.retryCount = 3;
    this.oLU = false;
    this.oFp = new LinkedList();
    this.orP = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132550);
        if ((!com.tencent.mm.kernel.h.baz()) || (b.aZG()))
        {
          Log.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
          AppMethodBeat.o(132550);
          return false;
        }
        if (k.a(k.this))
        {
          Log.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[] { Integer.valueOf(k.this.hashCode()) });
          AppMethodBeat.o(132550);
          return false;
        }
        if (k.b(k.this).isEmpty())
        {
          Log.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(132550);
          return false;
        }
        Log.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[] { Integer.valueOf(k.this.hashCode()), Long.valueOf(k.c(k.this).aPY()), Integer.valueOf(k.b(k.this).size()), Integer.valueOf(k.d(k.this)), Boolean.valueOf(k.e(k.this)), Integer.valueOf(k.f(k.this)), Integer.valueOf(k.g(k.this)) });
        com.tencent.mm.kernel.h.baF();
        long l = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
        Object localObject1 = new c();
        ((c)localObject1).fT("NetSceneInit");
        int i;
        int j;
        label266:
        Object localObject2;
        boolean bool;
        label310:
        Object localObject3;
        if (k.e(k.this))
        {
          i = 40;
          j = 0;
          if (j >= i) {
            break label1083;
          }
          localObject2 = (k.a)k.b(k.this).peek();
          if (((k.a)localObject2).oLZ != 2147483647) {
            break label630;
          }
          if (((k.a)localObject2).oLY != null) {
            break label624;
          }
          bool = true;
          Assert.assertTrue("in Queue tail , resp should be null", bool);
          com.tencent.mm.kernel.h.baF();
          localObject3 = (String)com.tencent.mm.kernel.h.baE().ban().d(8198, null);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(8195, localObject3);
          MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aQe()).edit().putString("notify_sync_key_keybuf", (String)localObject3).commit();
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(8197, "");
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(8198, "");
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(15, Integer.valueOf(1));
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().iZy();
          Log.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[] { Integer.valueOf(k.this.hashCode()), Long.valueOf(k.c(k.this).aPY()), Integer.valueOf(k.d(k.this)), Integer.valueOf(k.g(k.this)), Integer.valueOf(((k.a)localObject2).errType), Integer.valueOf(((k.a)localObject2).errCode) });
          com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(132549);
              k.h(k.this).onSceneEnd(this.oLW.errType, this.oLW.errCode, this.oLW.errMsg, k.this);
              AppMethodBeat.o(132549);
            }
          });
          bool = false;
        }
        for (;;)
        {
          label565:
          ((c)localObject1).fU("NetSceneInit");
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().mCN.endTransaction(l);
          localObject1 = k.this;
          if (((k)localObject1).oLO == null) {
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
            localObject3 = ((k.a)localObject2).oLY.aaZC;
            if ((localObject3 != null) && (((LinkedList)localObject3).size() > ((k.a)localObject2).oFE))
            {
              ((LinkedList)localObject3).size();
              if (((c)localObject1).a((adw)((LinkedList)localObject3).get(((k.a)localObject2).oFE), true)) {}
            }
            else
            {
              k.b(k.this).poll();
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().B(8197, Util.encodeHexString(w.a(((k.a)localObject2).oLY.aaZy)));
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().B(8198, Util.encodeHexString(w.a(((k.a)localObject2).oLY.aaZz)));
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().B(16, Integer.valueOf(0));
              Log.i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s, cur[%s], max[%s]", new Object[] { Long.valueOf(((k.a)localObject2).oLY.YYp), Util.encodeHexString(w.a(((k.a)localObject2).oLY.aaZy)), Util.encodeHexString(w.a(((k.a)localObject2).oLY.aaZz)) });
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().B(8196, Long.valueOf(((k.a)localObject2).oLY.YYp));
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().iZy();
              bool = true;
              break label565;
            }
            ((k.a)localObject2).oFE += 1;
            k.i(k.this);
            j += 1;
            break label266;
            localObject2 = (i)((k)localObject1).oLO.get();
            if (localObject2 != null) {
              break label944;
            }
            Log.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
          }
          label944:
          label957:
          float f1;
          if (((k)localObject1).oLQ > 50)
          {
            i = 50;
            f1 = 1.0F;
            if (((k)localObject1).oLR) {
              break label1043;
            }
          }
          for (j = i;; j = (int)((100 - i) * f1 + i))
          {
            Log.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[] { Integer.valueOf(((k)localObject1).oLT), Integer.valueOf(((k)localObject1).oLS), Float.valueOf(f1), Integer.valueOf(i) });
            ((i)localObject2).a(j, 100, (p)localObject1);
            break;
            i = ((k)localObject1).oLQ;
            break label957;
            label1043:
            float f2 = ((k)localObject1).oLT / ((k)localObject1).oLS;
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
    this.oLy.append("stack:" + Util.getStack() + " time:" + Util.nowSecond());
    this.oLO = new WeakReference(parami);
    AppMethodBeat.o(132552);
  }
  
  private int a(com.tencent.mm.network.g paramg, gol paramgol1, gol paramgol2)
  {
    AppMethodBeat.i(132554);
    this.oLy.append(" lastd:" + this.lastdispatch + " dotime:" + Util.nowSecond() + " net:" + NetStatusUtil.getNetType(MMApplicationContext.getContext()));
    b localb = new b();
    gol localgol = paramgol1;
    if (paramgol1 == null)
    {
      com.tencent.mm.kernel.h.baF();
      localgol = w.aN(Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8197, null))));
    }
    paramgol1 = paramgol2;
    if (paramgol2 == null)
    {
      com.tencent.mm.kernel.h.baF();
      paramgol1 = w.aN(Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8198, null))));
    }
    com.tencent.mm.kernel.h.baF();
    if ((Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(16, null)) != 0) && ((localgol == null) || (localgol.abwJ <= 0))) {
      localb.getReqObj().setSceneStatus(7);
    }
    for (;;)
    {
      this.oLP.aaZy = localgol;
      this.oLP.aaZz = paramgol1;
      ((u.a)localb.getReqObj()).Yyx = this.oLP;
      Log.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.mHw.aPY()), Integer.valueOf(this.oLQ), this.oLP.UserName, this.oLP.yts, Integer.valueOf(localb.getReqObj().getSceneStatus()), Util.encodeHexString(w.a(localgol)), Util.encodeHexString(w.a(paramgol1)) });
      this.oLQ += 1;
      int i = dispatch(paramg, localb, this);
      AppMethodBeat.o(132554);
      return i;
      com.tencent.mm.kernel.h.baF();
      if (Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8195, null)).length() <= 0) {
        localb.getReqObj().setSceneStatus(3);
      } else {
        localb.getReqObj().setSceneStatus(4);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, dub paramdub)
  {
    AppMethodBeat.i(132557);
    a locala = new a();
    locala.oLZ = paramInt1;
    locala.errCode = paramInt3;
    locala.errType = paramInt2;
    locala.errMsg = paramString;
    locala.oLY = paramdub;
    this.oFp.add(locala);
    if (this.orP.stopped()) {
      this.orP.startTimer(50L);
    }
    AppMethodBeat.o(132557);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(132556);
    Log.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[] { Util.getStack() });
    super.cancel();
    this.oLU = true;
    AppMethodBeat.o(132556);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(132553);
    this.mHw = new f.a();
    this.callback = paramh;
    paramh = this.oLP;
    com.tencent.mm.kernel.h.baF();
    paramh.UserName = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, null));
    if (!Util.isNullOrNil(this.oLP.UserName)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("by DK: req.UserName is null", bool);
      this.oLP.yts = LocaleUtil.getApplicationLanguage();
      int i = a(paramg, null, null);
      AppMethodBeat.o(132553);
      return i;
    }
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132558);
    String str = this.oLy.toString();
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
    this.oLy.append(" endtime:" + Util.nowSecond());
    Log.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramInt1) });
    if ((paramInt2 == 4) && ((paramInt3 == -100) || (paramInt3 == -2023)))
    {
      Log.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.oLU = true;
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
        this.oLU = true;
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(132555);
      return;
    }
    params = ((u.b)params.getRespObj()).Yyy;
    this.oLS += params.aaZB;
    Log.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(this.mHw.aPY()), Integer.valueOf(this.oLS), Integer.valueOf(this.oLQ), Integer.valueOf(params.YYp) });
    a(this.oLQ - 1, paramInt2, paramInt3, paramString, params);
    if (((params.YYp & 0x7) != 0) && (!securityLimitCountReach()))
    {
      if (a(dispatcher(), params.aaZy, params.aaZz) == -1)
      {
        Log.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
        a(2147483647, 3, -1, "", null);
        AppMethodBeat.o(132555);
      }
    }
    else
    {
      Log.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.mHw.aPY()), Integer.valueOf(this.oLQ) });
      this.oLR = true;
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
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
    int oFE = 0;
    dub oLY;
    int oLZ = 0;
    
    a() {}
  }
  
  public static final class b
    extends n
  {
    private final u.a oMa;
    private final u.b oMb;
    
    public b()
    {
      AppMethodBeat.i(132551);
      this.oMa = new u.a();
      this.oMb = new u.b();
      AppMethodBeat.o(132551);
    }
    
    public final l.d getReqObjImp()
    {
      return this.oMa;
    }
    
    public final l.e getRespObj()
    {
      return this.oMb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.k
 * JD-Core Version:    0.7.0.1
 */