package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.n.j;
import com.tencent.mm.plugin.appbrand.t.j.b;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.cro;
import com.tencent.mm.protocal.protobuf.gcd;
import com.tencent.mm.protocal.protobuf.gci;
import com.tencent.mm.protocal.protobuf.gck;
import com.tencent.mm.protocal.protobuf.gcs;
import com.tencent.mm.protocal.protobuf.gcv;
import com.tencent.mm.protocal.protobuf.gcx;
import com.tencent.mm.protocal.protobuf.gcz;
import com.tencent.mm.protocal.protobuf.gdc;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class q
  implements com.tencent.mm.plugin.appbrand.n.i
{
  private o esY;
  private Activity mContext;
  public String rdR;
  private w rdS;
  public s rdT;
  private com.tencent.luggage.sdk.b.a.d.d rdU;
  public y rdV;
  private boolean rdW;
  j.b rdX;
  
  public q()
  {
    AppMethodBeat.i(147025);
    this.rdT = new s();
    this.rdW = false;
    this.rdX = new j.b()
    {
      public final void Yf(String paramAnonymousString)
      {
        AppMethodBeat.i(147017);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[] { paramAnonymousString });
        q.g(q.this).Yn(paramAnonymousString);
        if (!TextUtils.isEmpty(q.b(q.this).eoY))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "connect wsEndpoint %s fail, reset it empty", new Object[] { q.b(q.this).eoY });
          MMHandlerThread.postToMainThread(new y.2(q.g(q.this), q.b(q.this).eoY));
          q.b(q.this).eoY = "";
        }
        AppMethodBeat.o(147017);
      }
      
      public final void Yg(String paramAnonymousString)
      {
        AppMethodBeat.i(147021);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[] { paramAnonymousString });
        AppMethodBeat.o(147021);
      }
      
      public final void ap(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(147020);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if ((!TextUtils.isEmpty(q.b(q.this).eoY)) && (q.h(q.this)))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose with ws lan");
          if (q.a(q.this).isRunning()) {
            q.g(q.this).aEj();
          }
          q.a(q.this, false);
        }
        label236:
        for (;;)
        {
          q.f(q.this).clQ();
          q.b(q.this).rdx = System.currentTimeMillis();
          q.g(q.this).cma();
          q.b(q.this).setStatus(5);
          q.g(q.this).Yn(paramAnonymousString);
          AppMethodBeat.o(147020);
          return;
          o localo = q.b(q.this);
          if ((!localo.isQuit()) && (localo.rdJ < 10L)) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = 0)
          {
            if (paramAnonymousInt == 0) {
              break label236;
            }
            com.tencent.mm.plugin.appbrand.af.o.cNm().j(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147015);
                q.i(q.this);
                AppMethodBeat.o(147015);
              }
            }, 1000L);
            localo = q.b(q.this);
            localo.rdJ += 1;
            break;
          }
        }
      }
      
      public final void clI()
      {
        AppMethodBeat.i(147016);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
        q.b(q.this).rdx = System.currentTimeMillis();
        q.b(q.this).rdJ = 0;
        if (!TextUtils.isEmpty(q.b(q.this).eoY))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen with wsEndpoint");
          q.a(q.this, true);
          q.c(q.this);
          q.d(q.this);
          AppMethodBeat.o(147016);
          return;
        }
        if (!Util.isNullOrNil(q.b(q.this).clA())) {
          q.e(q.this);
        }
        s locals = q.f(q.this);
        locals.clQ();
        s.4 local4 = new s.4(locals);
        locals.rep = com.tencent.threadpool.h.ahAA.b(local4, 100L, 1000L);
        AppMethodBeat.o(147016);
      }
      
      public final void clJ()
      {
        AppMethodBeat.i(147018);
        q.b(q.this).rdx = System.currentTimeMillis();
        AppMethodBeat.o(147018);
      }
      
      public final void n(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(147019);
        q.b(q.this).rdx = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            paramAnonymousByteBuffer = com.tencent.mm.plugin.appbrand.af.d.s(paramAnonymousByteBuffer);
            paramAnonymousByteBuffer = (gcd)new gcd().parseFrom(paramAnonymousByteBuffer);
            if (paramAnonymousByteBuffer.Zsu == null)
            {
              com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
              AppMethodBeat.o(147019);
              return;
            }
            localObject = paramAnonymousByteBuffer.Zsu.Op;
            switch (paramAnonymousByteBuffer.bUl)
            {
            case 1006: 
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[] { Integer.valueOf(paramAnonymousByteBuffer.bUl) });
              AppMethodBeat.o(147019);
              return;
            }
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", new Object[] { android.util.Log.getStackTraceString(paramAnonymousByteBuffer) });
            AppMethodBeat.o(147019);
            return;
          }
          Object localObject = (gcs)new gcs().parseFrom((byte[])localObject);
          s locals = q.f(q.this);
          if (x.a(locals.esY, paramAnonymousByteBuffer, ((gcs)localObject).acaH, locals.rdV, locals))
          {
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[] { Integer.valueOf(((gcs)localObject).acaI), Integer.valueOf(((gcs)localObject).acaJ) });
            locals.esY.fk(((gcs)localObject).acaI, ((gcs)localObject).acaJ);
            locals.fm(((gcs)localObject).acaI, ((gcs)localObject).acaJ);
          }
          t.a(paramAnonymousByteBuffer, (n)q.b(q.this).rdG.get(paramAnonymousByteBuffer.uuid));
          continue;
          localObject = (gcv)new gcv().parseFrom((byte[])localObject);
          x.a(q.b(q.this), paramAnonymousByteBuffer, ((gcv)localObject).acaH, q.g(q.this), q.f(q.this));
          q.b(q.this).rdx = System.currentTimeMillis();
          continue;
          localObject = (gcz)new gcz().parseFrom((byte[])localObject);
          q.a(q.this, (gcz)localObject, paramAnonymousByteBuffer);
          continue;
          localObject = (gcx)new gcx().parseFrom((byte[])localObject);
          if (x.a(q.b(q.this), paramAnonymousByteBuffer, ((gcx)localObject).acaH, q.g(q.this), q.f(q.this)))
          {
            q.c(q.this);
            continue;
            if (q.a(q.this).isRunning())
            {
              localObject = q.f(q.this);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
              ((s)localObject).clO();
              ((s)localObject).rdV.aEj();
            }
            else
            {
              localObject = q.f(q.this);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
              ((s)localObject).clO();
              localObject = ((s)localObject).rdV;
              ((y)localObject).setVisibility(8);
              if ((((y)localObject).getParent() instanceof ViewGroup))
              {
                ((ViewGroup)((y)localObject).getParent()).removeView((View)localObject);
                ((y)localObject).removeAllViews();
              }
              ((y)localObject).ewc = null;
              continue;
              localObject = (gdc)new gdc().parseFrom((byte[])localObject);
              locals = q.f(q.this);
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
              if (x.a(locals.esY, paramAnonymousByteBuffer, ((gdc)localObject).acaH, locals.rdV, locals))
              {
                locals.z(((gdc)localObject).acaw);
                locals.esY.zL(((gdc)localObject).acaU);
                locals.clP();
                continue;
                localObject = (gck)new gck().parseFrom((byte[])localObject);
                q.f(q.this).z(((gck)localObject).acaw);
                continue;
                q.d(q.this);
                continue;
                q.b(q.this).setStatus(4);
                q.f(q.this).quit();
              }
            }
          }
        }
      }
    };
    new RemoteDebugJsEngine.4(this, f.hfK).alive();
    AppMethodBeat.o(147025);
  }
  
  private void clG()
  {
    AppMethodBeat.i(147035);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
    crn localcrn = new crn();
    com.tencent.mm.plugin.appbrand.networking.c localc = (com.tencent.mm.plugin.appbrand.networking.c)this.rdU.T(com.tencent.mm.plugin.appbrand.networking.c.class);
    this.rdU.getAppId();
    localc.a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", localcrn, cro.class).c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(147035);
  }
  
  private void connect()
  {
    AppMethodBeat.i(147031);
    if (this.rdS == null)
    {
      this.rdS = new w((com.tencent.mm.plugin.appbrand.t.a)this.rdU.aN(com.tencent.mm.plugin.appbrand.t.a.class));
      this.rdT.a(this.rdS, this.esY, this.rdV);
    }
    this.rdW = false;
    if (!TextUtils.isEmpty(this.esY.eoY))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "connect wsEndpoint url:%s", new Object[] { this.esY.eoY });
      this.rdS.a(this.esY.eoY, this.rdX);
      AppMethodBeat.o(147031);
      return;
    }
    if (this.esY.clF())
    {
      this.rdS.a("ws://localhost:" + this.esY.rdu.rdP, this.rdX);
      AppMethodBeat.o(147031);
      return;
    }
    this.rdS.a("wss://wxagame.weixin.qq.com/remote/", this.rdX);
    AppMethodBeat.o(147031);
  }
  
  private void onReady()
  {
    AppMethodBeat.i(147032);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onReady");
    this.esY.setStatus(3);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
    Iterator localIterator = this.esY.rdE.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
    }
    this.esY.rdE.clear();
    this.rdT.fl(this.esY.clB(), 2147483647);
    this.rdV.cma();
    AppMethodBeat.o(147032);
  }
  
  public final <T extends j> T Z(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(147026);
    this.esY = paramo;
    this.rdU = this.esY.rdo;
    this.mContext = ((Activity)this.rdU.getContext());
    this.rdV = new y(this.mContext, this.esY, new y.a()
    {
      public final void clH()
      {
        AppMethodBeat.i(147014);
        q.this.destroy();
        k.a(q.a(q.this).getAppId(), k.d.qrG);
        if (q.a(q.this).aqZ() != null) {
          q.a(q.this).aqZ().finish();
        }
        AppMethodBeat.o(147014);
      }
    });
    this.rdV.aa(this.rdU.aqZ());
    connect();
    if (Util.isNullOrNil(this.esY.clA())) {
      clG();
    }
    AppMethodBeat.o(147026);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(147034);
    this.rdT.a(paramr);
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
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public final void ao(int paramInt, String paramString)
  {
    AppMethodBeat.i(147033);
    this.rdT.ao(paramInt, paramString);
    AppMethodBeat.o(147033);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(147030);
    this.rdT.quit();
    this.rdT.clQ();
    AppMethodBeat.o(147030);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(147027);
    if (this.esY == null)
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("FATAL");
      }
      AppMethodBeat.o(147027);
      return;
    }
    if (this.esY.clD())
    {
      AppMethodBeat.o(147027);
      return;
    }
    if (!this.esY.isReady())
    {
      this.esY.rdE.add(new Pair(paramString, paramValueCallback));
      this.rdR = null;
      AppMethodBeat.o(147027);
      return;
    }
    Object localObject = new gci();
    ((gci)localObject).acav = this.esY.rdz.incrementAndGet();
    ((gci)localObject).script = paramString;
    r localr = x.a((com.tencent.mm.bx.a)localObject, this.esY, "evaluateJavascript");
    this.rdT.a(localr);
    int i = ((gci)localObject).acav;
    localObject = new c();
    if (!Util.isNullOrNil(this.rdR))
    {
      ((c)localObject).event = this.rdR;
      this.rdR = null;
    }
    for (;;)
    {
      ((c)localObject).rdg = System.currentTimeMillis();
      ((c)localObject).size = paramString.length();
      ((c)localObject).rdf = paramValueCallback;
      this.esY.rdI.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(147027);
      return;
      ((c)localObject).event = t.Yi(paramString);
    }
  }
  
  public final void setJsExceptionHandler(com.tencent.mm.plugin.appbrand.n.h paramh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.q
 * JD-Core Version:    0.7.0.1
 */