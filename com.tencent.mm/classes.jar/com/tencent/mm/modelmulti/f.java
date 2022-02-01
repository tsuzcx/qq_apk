package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.ctk;
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
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class f
  extends q
  implements m
{
  i callback;
  com.tencent.mm.compatible.util.f.a hvh;
  private final MTimerHandler iKj;
  final Queue<a> iWn;
  int jcA;
  int jcB;
  boolean jcC;
  private StringBuilder jcf;
  WeakReference<j> jcw;
  final ctj jcx;
  int jcy;
  boolean jcz;
  private int retryCount;
  
  public f(j paramj)
  {
    AppMethodBeat.i(132552);
    this.jcw = null;
    this.jcx = new ctj();
    this.jcf = new StringBuilder();
    this.jcy = 0;
    this.jcz = false;
    this.jcA = 0;
    this.jcB = 0;
    this.retryCount = 3;
    this.jcC = false;
    this.iWn = new LinkedList();
    this.iKj = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132550);
        if ((!com.tencent.mm.kernel.g.aAc()) || (a.azj()))
        {
          Log.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.this.jcC)
        {
          Log.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[] { Integer.valueOf(f.this.hashCode()) });
          AppMethodBeat.o(132550);
          return false;
        }
        if (f.this.iWn.isEmpty())
        {
          Log.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(132550);
          return false;
        }
        Log.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.hvh.apr()), Integer.valueOf(f.this.iWn.size()), Integer.valueOf(f.this.jcy), Boolean.valueOf(f.this.jcz), Integer.valueOf(f.this.jcB), Integer.valueOf(f.this.jcA) });
        com.tencent.mm.kernel.g.aAi();
        long l = com.tencent.mm.kernel.g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
        Object localObject1 = new c();
        ((c)localObject1).dz("NetSceneInit");
        int i;
        int j;
        label266:
        Object localObject2;
        boolean bool;
        label310:
        Object localObject3;
        if (f.this.jcz)
        {
          i = 40;
          j = 0;
          if (j >= i) {
            break label1093;
          }
          localObject2 = (f.a)f.this.iWn.peek();
          if (((f.a)localObject2).jcH != 2147483647) {
            break label630;
          }
          if (((f.a)localObject2).jcG != null) {
            break label624;
          }
          bool = true;
          Assert.assertTrue("in Queue tail , resp should be null", bool);
          com.tencent.mm.kernel.g.aAi();
          localObject3 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(8198, null);
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(8195, localObject3);
          MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aps()).edit().putString("notify_sync_key_keybuf", (String)localObject3).commit();
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(8197, "");
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(8198, "");
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(15, Integer.valueOf(1));
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().gBI();
          Log.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.hvh.apr()), Integer.valueOf(f.this.jcy), Integer.valueOf(f.this.jcA), Integer.valueOf(((f.a)localObject2).errType), Integer.valueOf(((f.a)localObject2).errCode) });
          com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(132549);
              f.this.callback.onSceneEnd(this.jcE.errType, this.jcE.errCode, this.jcE.errMsg, f.this);
              AppMethodBeat.o(132549);
            }
          });
          bool = false;
        }
        for (;;)
        {
          label565:
          ((c)localObject1).dA("NetSceneInit");
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().hqK.endTransaction(l);
          localObject1 = f.this;
          if (((f)localObject1).jcw == null) {
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
            localObject3 = ((f.a)localObject2).jcG.Mym;
            if ((localObject3 != null) && (((LinkedList)localObject3).size() > ((f.a)localObject2).iWC))
            {
              ((LinkedList)localObject3).size();
              if (((c)localObject1).a((abn)((LinkedList)localObject3).get(((f.a)localObject2).iWC), true)) {}
            }
            else
            {
              f.this.iWn.poll();
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAh().azQ().set(8197, Util.encodeHexString(z.a(((f.a)localObject2).jcG.Myi)));
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAh().azQ().set(8198, Util.encodeHexString(z.a(((f.a)localObject2).jcG.Myj)));
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAh().azQ().set(16, Integer.valueOf(0));
              Log.i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s, cur[%s], max[%s]", new Object[] { Long.valueOf(((f.a)localObject2).jcG.KZh), Util.encodeHexString(z.a(((f.a)localObject2).jcG.Myi)), Util.encodeHexString(z.a(((f.a)localObject2).jcG.Myj)) });
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAh().azQ().set(8196, Long.valueOf(((f.a)localObject2).jcG.KZh));
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAh().azQ().gBI();
              bool = true;
              break label565;
            }
            ((f.a)localObject2).iWC += 1;
            localObject2 = f.this;
            ((f)localObject2).jcB += 1;
            j += 1;
            break label266;
            localObject2 = (j)((f)localObject1).jcw.get();
            if (localObject2 != null) {
              break label954;
            }
            Log.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
          }
          label954:
          label967:
          float f1;
          if (((f)localObject1).jcy > 50)
          {
            i = 50;
            f1 = 1.0F;
            if (((f)localObject1).jcz) {
              break label1053;
            }
          }
          for (j = i;; j = (int)((100 - i) * f1 + i))
          {
            Log.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[] { Integer.valueOf(((f)localObject1).jcB), Integer.valueOf(((f)localObject1).jcA), Float.valueOf(f1), Integer.valueOf(i) });
            ((j)localObject2).a(j, 100, (q)localObject1);
            break;
            i = ((f)localObject1).jcy;
            break label967;
            label1053:
            float f2 = ((f)localObject1).jcB / ((f)localObject1).jcA;
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
    Log.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.jcf.append("stack:" + Util.getStack() + " time:" + Util.nowSecond());
    this.jcw = new WeakReference(paramj);
    AppMethodBeat.o(132552);
  }
  
  private int a(com.tencent.mm.network.g paramg, SKBuiltinBuffer_t paramSKBuiltinBuffer_t1, SKBuiltinBuffer_t paramSKBuiltinBuffer_t2)
  {
    AppMethodBeat.i(132554);
    this.jcf.append(" lastd:" + this.lastdispatch + " dotime:" + Util.nowSecond() + " net:" + NetStatusUtil.getNetType(MMApplicationContext.getContext()));
    b localb = new b();
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = paramSKBuiltinBuffer_t1;
    if (paramSKBuiltinBuffer_t1 == null)
    {
      com.tencent.mm.kernel.g.aAi();
      localSKBuiltinBuffer_t = z.aC(Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8197, null))));
    }
    paramSKBuiltinBuffer_t1 = paramSKBuiltinBuffer_t2;
    if (paramSKBuiltinBuffer_t2 == null)
    {
      com.tencent.mm.kernel.g.aAi();
      paramSKBuiltinBuffer_t1 = z.aC(Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8198, null))));
    }
    com.tencent.mm.kernel.g.aAi();
    if ((Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(16, null)) != 0) && ((localSKBuiltinBuffer_t == null) || (localSKBuiltinBuffer_t.getILen() <= 0))) {
      localb.getReqObj().setSceneStatus(7);
    }
    for (;;)
    {
      this.jcx.Myi = localSKBuiltinBuffer_t;
      this.jcx.Myj = paramSKBuiltinBuffer_t1;
      ((u.a)localb.getReqObj()).KAe = this.jcx;
      Log.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.hvh.apr()), Integer.valueOf(this.jcy), this.jcx.UserName, this.jcx.rBI, Integer.valueOf(localb.getReqObj().getSceneStatus()), Util.encodeHexString(z.a(localSKBuiltinBuffer_t)), Util.encodeHexString(z.a(paramSKBuiltinBuffer_t1)) });
      this.jcy += 1;
      int i = dispatch(paramg, localb, this);
      AppMethodBeat.o(132554);
      return i;
      com.tencent.mm.kernel.g.aAi();
      if (Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8195, null)).length() <= 0) {
        localb.getReqObj().setSceneStatus(3);
      } else {
        localb.getReqObj().setSceneStatus(4);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, ctk paramctk)
  {
    AppMethodBeat.i(132557);
    a locala = new a();
    locala.jcH = paramInt1;
    locala.errCode = paramInt3;
    locala.errType = paramInt2;
    locala.errMsg = paramString;
    locala.jcG = paramctk;
    this.iWn.add(locala);
    if (this.iKj.stopped()) {
      this.iKj.startTimer(50L);
    }
    AppMethodBeat.o(132557);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(132556);
    Log.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[] { Util.getStack() });
    super.cancel();
    this.jcC = true;
    AppMethodBeat.o(132556);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(132553);
    this.hvh = new com.tencent.mm.compatible.util.f.a();
    this.callback = parami;
    parami = this.jcx;
    com.tencent.mm.kernel.g.aAi();
    parami.UserName = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null));
    if (!Util.isNullOrNil(this.jcx.UserName)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("by DK: req.UserName is null", bool);
      this.jcx.rBI = LocaleUtil.getApplicationLanguage();
      int i = a(paramg, null, null);
      AppMethodBeat.o(132553);
      return i;
    }
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132558);
    String str = this.jcf.toString();
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
    this.jcf.append(" endtime:" + Util.nowSecond());
    Log.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramInt1) });
    if ((paramInt2 == 4) && ((paramInt3 == -100) || (paramInt3 == -2023)))
    {
      Log.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.jcC = true;
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
        this.jcC = true;
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(132555);
      return;
    }
    params = ((u.b)params.getRespObj()).KAf;
    this.jcA += params.Myl;
    Log.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(this.hvh.apr()), Integer.valueOf(this.jcA), Integer.valueOf(this.jcy), Integer.valueOf(params.KZh) });
    a(this.jcy - 1, paramInt2, paramInt3, paramString, params);
    if (((params.KZh & 0x7) != 0) && (!securityLimitCountReach()))
    {
      if (a(dispatcher(), params.Myi, params.Myj) == -1)
      {
        Log.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
        a(2147483647, 3, -1, "", null);
        AppMethodBeat.o(132555);
      }
    }
    else
    {
      Log.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.hvh.apr()), Integer.valueOf(this.jcy) });
      this.jcz = true;
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
    return q.b.iMq;
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
    int iWC = 0;
    ctk jcG;
    int jcH = 0;
    
    a() {}
  }
  
  public static final class b
    extends o
  {
    private final u.a jcI;
    private final u.b jcJ;
    
    public b()
    {
      AppMethodBeat.i(132551);
      this.jcI = new u.a();
      this.jcJ = new u.b();
      AppMethodBeat.o(132551);
    }
    
    public final l.d getReqObjImp()
    {
      return this.jcI;
    }
    
    public final l.e getRespObj()
    {
      return this.jcJ;
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