package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.s.k.b;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.protocal.protobuf.evk;
import com.tencent.mm.protocal.protobuf.evm;
import com.tencent.mm.protocal.protobuf.evu;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.protocal.protobuf.evz;
import com.tencent.mm.protocal.protobuf.ewb;
import com.tencent.mm.protocal.protobuf.ewe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

public final class o
  implements i
{
  private m cBt;
  public String lit;
  private u liu;
  private q liv;
  private com.tencent.luggage.sdk.b.a.c.d liw;
  public w lix;
  k.b liy;
  private Activity mContext;
  
  public o()
  {
    AppMethodBeat.i(147025);
    this.liv = new q();
    this.liy = new k.b()
    {
      public final void XT(String paramAnonymousString)
      {
        AppMethodBeat.i(147017);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[] { paramAnonymousString });
        o.f(o.this).Ya(paramAnonymousString);
        AppMethodBeat.o(147017);
      }
      
      public final void XU(String paramAnonymousString)
      {
        AppMethodBeat.i(147021);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[] { paramAnonymousString });
        AppMethodBeat.o(147021);
      }
      
      public final void ae(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(147020);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        m localm = o.d(o.this);
        if ((!localm.isQuit()) && (localm.lil < 10L)) {}
        for (paramAnonymousInt = i;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt != 0)
          {
            com.tencent.mm.plugin.appbrand.ac.m.bZn().j(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147015);
                o.h(o.this);
                AppMethodBeat.o(147015);
              }
            }, 1000L);
            localm = o.d(o.this);
            localm.lil += 1;
          }
          o.e(o.this).bAV();
          o.d(o.this).lhZ = System.currentTimeMillis();
          o.f(o.this).bBf();
          o.d(o.this).setStatus(5);
          o.f(o.this).Ya(paramAnonymousString);
          AppMethodBeat.o(147020);
          return;
        }
      }
      
      public final void bAN()
      {
        AppMethodBeat.i(147016);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
        o.d(o.this).lhZ = System.currentTimeMillis();
        o.d(o.this).lil = 0;
        if (!Util.isNullOrNil(o.d(o.this).bAF())) {
          o.a(o.this);
        }
        q localq = o.e(o.this);
        localq.bAV();
        localq.mTimer = new Timer();
        q.4 local4 = new q.4(localq);
        localq.mTimer.schedule(local4, 100L, 1000L);
        AppMethodBeat.o(147016);
      }
      
      public final void bAO()
      {
        AppMethodBeat.i(147018);
        o.d(o.this).lhZ = System.currentTimeMillis();
        AppMethodBeat.o(147018);
      }
      
      public final void k(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(147019);
        o.d(o.this).lhZ = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            paramAnonymousByteBuffer = com.tencent.mm.plugin.appbrand.ac.d.p(paramAnonymousByteBuffer);
            paramAnonymousByteBuffer = (evf)new evf().parseFrom(paramAnonymousByteBuffer);
            if (paramAnonymousByteBuffer.LrK == null)
            {
              com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
              AppMethodBeat.o(147019);
              return;
            }
            localObject = paramAnonymousByteBuffer.LrK.zy;
            switch (paramAnonymousByteBuffer.EX)
            {
            case 1006: 
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[] { Integer.valueOf(paramAnonymousByteBuffer.EX) });
              AppMethodBeat.o(147019);
              return;
            }
          }
          catch (Throwable paramAnonymousByteBuffer)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", new Object[] { android.util.Log.getStackTraceString(paramAnonymousByteBuffer) });
            AppMethodBeat.o(147019);
            return;
          }
          Object localObject = (evu)new evu().parseFrom((byte[])localObject);
          q localq = o.e(o.this);
          if (v.a(localq.cBt, paramAnonymousByteBuffer, ((evu)localObject).NtA, localq.lix, localq))
          {
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[] { Integer.valueOf(((evu)localObject).NtB), Integer.valueOf(((evu)localObject).NtC) });
            localq.cBt.dS(((evu)localObject).NtB, ((evu)localObject).NtC);
            localq.dU(((evu)localObject).NtB, ((evu)localObject).NtC);
          }
          r.a(paramAnonymousByteBuffer, (l)o.d(o.this).lii.get(paramAnonymousByteBuffer.uuid));
          continue;
          localObject = (evx)new evx().parseFrom((byte[])localObject);
          v.a(o.d(o.this), paramAnonymousByteBuffer, ((evx)localObject).NtA, o.f(o.this), o.e(o.this));
          o.d(o.this).lhZ = System.currentTimeMillis();
          continue;
          localObject = (ewb)new ewb().parseFrom((byte[])localObject);
          o.a(o.this, (ewb)localObject, paramAnonymousByteBuffer);
          continue;
          localObject = (evz)new evz().parseFrom((byte[])localObject);
          if (v.a(o.d(o.this), paramAnonymousByteBuffer, ((evz)localObject).NtA, o.f(o.this), o.e(o.this)))
          {
            o.b(o.this);
            continue;
            if (o.c(o.this).isRunning())
            {
              localObject = o.e(o.this);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
              ((q)localObject).bAT();
              localObject = ((q)localObject).lix;
              ((w)localObject).bBf();
              MMHandlerThread.postToMainThread(new w.6((w)localObject));
            }
            else
            {
              localObject = o.e(o.this);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
              ((q)localObject).bAT();
              localObject = ((q)localObject).lix;
              ((w)localObject).setVisibility(8);
              if ((((w)localObject).getParent() instanceof ViewGroup))
              {
                ((ViewGroup)((w)localObject).getParent()).removeView((View)localObject);
                ((w)localObject).removeAllViews();
              }
              ((w)localObject).lja = null;
              continue;
              localObject = (ewe)new ewe().parseFrom((byte[])localObject);
              localq = o.e(o.this);
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
              if (v.a(localq.cBt, paramAnonymousByteBuffer, ((ewe)localObject).NtA, localq.lix, localq))
              {
                localq.v(((ewe)localObject).Ntp);
                localq.cBt.wj(((ewe)localObject).NtN);
                localq.bAU();
                continue;
                localObject = (evm)new evm().parseFrom((byte[])localObject);
                o.e(o.this).v(((evm)localObject).Ntp);
                continue;
                o.g(o.this);
                continue;
                o.d(o.this).setStatus(4);
                o.e(o.this).quit();
              }
            }
          }
        }
      }
    };
    EventCenter.instance.add(new o.4(this));
    AppMethodBeat.o(147025);
  }
  
  private void bAL()
  {
    AppMethodBeat.i(147035);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
    bum localbum = new bum();
    com.tencent.mm.plugin.appbrand.networking.c localc = (com.tencent.mm.plugin.appbrand.networking.c)this.liw.M(com.tencent.mm.plugin.appbrand.networking.c.class);
    this.liw.getAppId();
    localc.a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", localbum, bun.class).c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(147035);
  }
  
  private void connect()
  {
    AppMethodBeat.i(147031);
    if (this.liu == null)
    {
      this.liu = new u((com.tencent.mm.plugin.appbrand.s.a)this.liw.av(com.tencent.mm.plugin.appbrand.s.a.class));
      this.liv.a(this.liu, this.cBt, this.lix);
    }
    if (this.cBt.bAK())
    {
      this.liu.a("ws://localhost:" + this.cBt.lhV.lir, this.liy);
      AppMethodBeat.o(147031);
      return;
    }
    this.liu.a("wss://wxagame.weixin.qq.com/remote/", this.liy);
    AppMethodBeat.o(147031);
  }
  
  private void onReady()
  {
    AppMethodBeat.i(147032);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onReady");
    this.cBt.setStatus(3);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
    Iterator localIterator = this.cBt.lig.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
    }
    this.cBt.lig.clear();
    this.liv.dT(this.cBt.bAG(), 2147483647);
    this.lix.bBf();
    AppMethodBeat.o(147032);
  }
  
  public final <T extends j> T R(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(147026);
    this.cBt = paramm;
    this.liw = this.cBt.lhP;
    this.mContext = ((Activity)this.liw.getContext());
    this.lix = new w(this.mContext, this.cBt, new o.1(this));
    this.lix.T(this.liw.NP());
    connect();
    if (Util.isNullOrNil(this.cBt.bAF())) {
      bAL();
    }
    AppMethodBeat.o(147026);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(147034);
    this.liv.a(paramp);
    AppMethodBeat.o(147034);
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(147028);
    evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(147028);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(147029);
    evaluateJavascript(paramString3, paramValueCallback);
    AppMethodBeat.o(147029);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(147033);
    this.liv.ad(paramInt, paramString);
    AppMethodBeat.o(147033);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public final void destroy()
  {
    AppMethodBeat.i(147030);
    this.liv.quit();
    this.liv.bAV();
    AppMethodBeat.o(147030);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(147027);
    if (this.cBt == null)
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("FATAL");
      }
      AppMethodBeat.o(147027);
      return;
    }
    if (this.cBt.bAI())
    {
      AppMethodBeat.o(147027);
      return;
    }
    if (!this.cBt.isReady())
    {
      this.cBt.lig.add(new Pair(paramString, paramValueCallback));
      this.lit = null;
      AppMethodBeat.o(147027);
      return;
    }
    Object localObject = new evk();
    ((evk)localObject).Nto = this.cBt.lib.incrementAndGet();
    ((evk)localObject).script = paramString;
    p localp = v.a((com.tencent.mm.bw.a)localObject, this.cBt, "evaluateJavascript");
    this.liv.a(localp);
    int i = ((evk)localObject).Nto;
    localObject = new c();
    if (!Util.isNullOrNil(this.lit))
    {
      ((c)localObject).event = this.lit;
      this.lit = null;
    }
    for (;;)
    {
      ((c)localObject).lhG = System.currentTimeMillis();
      ((c)localObject).size = paramString.length();
      ((c)localObject).lhF = paramValueCallback;
      this.cBt.lik.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(147027);
      return;
      ((c)localObject).event = r.XW(paramString);
    }
  }
  
  public final void setJsExceptionHandler(h paramh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o
 * JD-Core Version:    0.7.0.1
 */