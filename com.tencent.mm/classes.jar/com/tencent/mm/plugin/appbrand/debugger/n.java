package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.q.k.b;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.protocal.protobuf.doj;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.protocal.protobuf.dos;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class n
  implements i
{
  l chM;
  public String jgR;
  private Activity jgS;
  t jgT;
  p jgU;
  com.tencent.luggage.sdk.b.a.c.c jgV;
  public v jgW;
  k.b jgX;
  
  public n()
  {
    AppMethodBeat.i(147025);
    this.jgU = new p();
    this.jgX = new k.b()
    {
      public final void GD(String paramAnonymousString)
      {
        AppMethodBeat.i(147017);
        ad.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[] { paramAnonymousString });
        n.this.jgW.GK(paramAnonymousString);
        AppMethodBeat.o(147017);
      }
      
      public final void GE(String paramAnonymousString)
      {
        AppMethodBeat.i(147021);
        ad.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[] { paramAnonymousString });
        AppMethodBeat.o(147021);
      }
      
      public final void X(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(147020);
        ad.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        l locall = n.this.chM;
        if ((!locall.isQuit()) && (locall.jgJ < 10L)) {}
        for (paramAnonymousInt = i;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt != 0)
          {
            com.tencent.mm.plugin.appbrand.aa.l.bqm().j(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147015);
                n.this.connect();
                AppMethodBeat.o(147015);
              }
            }, 1000L);
            locall = n.this.chM;
            locall.jgJ += 1;
          }
          n.this.jgU.aUs();
          n.this.chM.jgx = System.currentTimeMillis();
          n.this.jgW.aUC();
          n.this.chM.setStatus(5);
          n.this.jgW.GK(paramAnonymousString);
          AppMethodBeat.o(147020);
          return;
        }
      }
      
      public final void aUk()
      {
        AppMethodBeat.i(147016);
        ad.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
        n.this.chM.jgx = System.currentTimeMillis();
        n.this.chM.jgJ = 0;
        if (!bt.isNullOrNil(n.this.chM.aUc())) {
          n.a(n.this);
        }
        p localp = n.this.jgU;
        localp.aUs();
        localp.mTimer = new Timer();
        p.4 local4 = new p.4(localp);
        localp.mTimer.schedule(local4, 100L, 1000L);
        AppMethodBeat.o(147016);
      }
      
      public final void aUl()
      {
        AppMethodBeat.i(147018);
        n.this.chM.jgx = System.currentTimeMillis();
        AppMethodBeat.o(147018);
      }
      
      public final void l(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(147019);
        n.this.chM.jgx = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            paramAnonymousByteBuffer = d.q(paramAnonymousByteBuffer);
            paramAnonymousByteBuffer = (dnw)new dnw().parseFrom(paramAnonymousByteBuffer);
            if (paramAnonymousByteBuffer.DcU == null)
            {
              ad.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
              AppMethodBeat.o(147019);
              return;
            }
            localObject1 = paramAnonymousByteBuffer.DcU.wA;
            switch (paramAnonymousByteBuffer.BX)
            {
            case 1006: 
              ad.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[] { Integer.valueOf(paramAnonymousByteBuffer.BX) });
              AppMethodBeat.o(147019);
              return;
            }
          }
          catch (Throwable paramAnonymousByteBuffer)
          {
            ad.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", new Object[] { Log.getStackTraceString(paramAnonymousByteBuffer) });
            AppMethodBeat.o(147019);
            return;
          }
          Object localObject1 = (dol)new dol().parseFrom((byte[])localObject1);
          Object localObject2 = n.this.jgU;
          if (u.a(((p)localObject2).chM, paramAnonymousByteBuffer, ((dol)localObject1).EEM, ((p)localObject2).jgW, (p)localObject2))
          {
            ad.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[] { Integer.valueOf(((dol)localObject1).EEN), Integer.valueOf(((dol)localObject1).EEO) });
            ((p)localObject2).chM.dF(((dol)localObject1).EEN, ((dol)localObject1).EEO);
            ((p)localObject2).dH(((dol)localObject1).EEN, ((dol)localObject1).EEO);
          }
          q.a(paramAnonymousByteBuffer, (k)n.this.chM.jgG.get(paramAnonymousByteBuffer.uuid));
          continue;
          localObject1 = (doo)new doo().parseFrom((byte[])localObject1);
          u.a(n.this.chM, paramAnonymousByteBuffer, ((doo)localObject1).EEM, n.this.jgW, n.this.jgU);
          n.this.chM.jgx = System.currentTimeMillis();
          continue;
          localObject2 = (dos)new dos().parseFrom((byte[])localObject1);
          localObject1 = n.this;
          if (u.a(((n)localObject1).chM, paramAnonymousByteBuffer, ((dos)localObject2).EEM, ((n)localObject1).jgW, ((n)localObject1).jgU))
          {
            ad.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
            if (((dos)localObject2).EEW == null)
            {
              ad.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
            }
            else if (((dos)localObject2).EEW.EEE)
            {
              ((n)localObject1).chM.jgs = ((dos)localObject2).EEW;
              ((n)localObject1).onReady();
            }
            else
            {
              ad.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
              ((n)localObject1).chM.setStatus(2);
              localObject2 = new dop();
              ((dop)localObject2).EEK = ((n)localObject1).chM.jgo;
              ((dop)localObject2).EEF = ((n)localObject1).chM.jgt.roomId;
              ((dop)localObject2).username = "";
              ((dop)localObject2).EEV = ((n)localObject1).chM.jgt.jgM;
              localObject2 = u.a(1003, (com.tencent.mm.bx.a)localObject2);
              ((n)localObject1).jgT.a((dnw)localObject2);
              continue;
              localObject1 = (doq)new doq().parseFrom((byte[])localObject1);
              if (u.a(n.this.chM, paramAnonymousByteBuffer, ((doq)localObject1).EEM, n.this.jgW, n.this.jgU))
              {
                n.b(n.this);
                continue;
                if (n.this.jgV.isRunning())
                {
                  localObject1 = n.this.jgU;
                  ad.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                  ((p)localObject1).aUq();
                  localObject1 = ((p)localObject1).jgW;
                  ((v)localObject1).aUC();
                  aq.f(new v.6((v)localObject1));
                }
                else
                {
                  localObject1 = n.this.jgU;
                  ad.i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
                  ((p)localObject1).aUq();
                  localObject1 = ((p)localObject1).jgW;
                  ((v)localObject1).setVisibility(8);
                  if ((((v)localObject1).getParent() instanceof ViewGroup))
                  {
                    ((ViewGroup)((v)localObject1).getParent()).removeView((View)localObject1);
                    ((v)localObject1).removeAllViews();
                  }
                  ((v)localObject1).jhz = null;
                  continue;
                  localObject1 = (dov)new dov().parseFrom((byte[])localObject1);
                  localObject2 = n.this.jgU;
                  ad.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                  if (u.a(((p)localObject2).chM, paramAnonymousByteBuffer, ((dov)localObject1).EEM, ((p)localObject2).jgW, (p)localObject2))
                  {
                    ((p)localObject2).v(((dov)localObject1).EEA);
                    ((p)localObject2).chM.qV(((dov)localObject1).EEZ);
                    ((p)localObject2).aUr();
                    continue;
                    localObject1 = (dod)new dod().parseFrom((byte[])localObject1);
                    n.this.jgU.v(((dod)localObject1).EEA);
                    continue;
                    n.this.onReady();
                    continue;
                    n.this.chM.setStatus(4);
                    n.this.jgU.quit();
                  }
                }
              }
            }
          }
        }
      }
    };
    com.tencent.mm.sdk.b.a.ESL.b(new com.tencent.mm.sdk.b.c()
    {
      private boolean a(com.tencent.mm.g.a.m paramAnonymousm)
      {
        AppMethodBeat.i(147023);
        if ((paramAnonymousm == null) || (paramAnonymousm.dbl == null) || (paramAnonymousm.dbl.dbo == null))
        {
          AppMethodBeat.o(147023);
          return true;
        }
        dof localdof = new dof();
        localdof.dbm = paramAnonymousm.dbl.dbm;
        localdof.dbn = paramAnonymousm.dbl.dbn;
        localdof.EEB = paramAnonymousm.dbl.dbo.toString();
        localdof.timestamp = System.currentTimeMillis();
        paramAnonymousm = u.a(localdof, n.this.chM, "networkDebugAPI");
        n.this.a(paramAnonymousm);
        AppMethodBeat.o(147023);
        return true;
      }
    });
    AppMethodBeat.o(147025);
  }
  
  private void aUi()
  {
    AppMethodBeat.i(147035);
    ad.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
    azx localazx = new azx();
    ((com.tencent.mm.plugin.appbrand.networking.a)this.jgV.K(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", localazx, azy.class).c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(147035);
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    return null;
  }
  
  public final void W(int paramInt, String paramString)
  {
    AppMethodBeat.i(147033);
    this.jgU.W(paramInt, paramString);
    AppMethodBeat.o(147033);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(147026);
    this.chM = paraml;
    this.jgV = this.chM.jgn;
    this.jgS = ((Activity)this.jgV.getContext());
    this.jgW = new v(this.jgS, this.chM, new v.a()
    {
      public final void aUj()
      {
        AppMethodBeat.i(147014);
        n.this.destroy();
        g.a(n.this.jgV.getAppId(), g.d.iDc);
        if (n.this.jgV.Dl() != null) {
          n.this.jgV.Dl().finish();
        }
        AppMethodBeat.o(147014);
      }
    });
    this.jgW.h(this.jgV.Dl().iDA);
    connect();
    if (bt.isNullOrNil(this.chM.aUc())) {
      aUi();
    }
    AppMethodBeat.o(147026);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(147034);
    this.jgU.a(paramo);
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
  
  final void connect()
  {
    AppMethodBeat.i(147031);
    if (this.jgT == null)
    {
      this.jgT = new t((com.tencent.mm.plugin.appbrand.q.a)this.jgV.ar(com.tencent.mm.plugin.appbrand.q.a.class));
      this.jgU.a(this.jgT, this.chM, this.jgW);
    }
    if (this.chM.aUh())
    {
      this.jgT.a("ws://localhost:" + this.chM.jgt.jgP, this.jgX);
      AppMethodBeat.o(147031);
      return;
    }
    this.jgT.a("wss://wxagame.weixin.qq.com/remote/", this.jgX);
    AppMethodBeat.o(147031);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(147030);
    this.jgU.quit();
    this.jgU.aUs();
    AppMethodBeat.o(147030);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(147027);
    if (this.chM == null)
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("FATAL");
      }
      AppMethodBeat.o(147027);
      return;
    }
    if (this.chM.aUf())
    {
      AppMethodBeat.o(147027);
      return;
    }
    if (!this.chM.isReady())
    {
      this.chM.jgE.add(new Pair(paramString, paramValueCallback));
      this.jgR = null;
      AppMethodBeat.o(147027);
      return;
    }
    Object localObject = new dob();
    ((dob)localObject).EEz = this.chM.jgz.incrementAndGet();
    ((dob)localObject).script = paramString;
    o localo = u.a((com.tencent.mm.bx.a)localObject, this.chM, "evaluateJavascript");
    this.jgU.a(localo);
    int i = ((dob)localObject).EEz;
    localObject = new b();
    if (!bt.isNullOrNil(this.jgR))
    {
      ((b)localObject).dcx = this.jgR;
      this.jgR = null;
    }
    for (;;)
    {
      ((b)localObject).jgi = System.currentTimeMillis();
      ((b)localObject).size = paramString.length();
      ((b)localObject).jgh = paramValueCallback;
      this.chM.jgI.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(147027);
      return;
      ((b)localObject).dcx = q.GG(paramString);
    }
  }
  
  final void onReady()
  {
    AppMethodBeat.i(147032);
    ad.i("MicroMsg.RemoteDebugJsEngine", "onReady");
    this.chM.setStatus(3);
    ad.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
    Iterator localIterator = this.chM.jgE.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
    }
    this.chM.jgE.clear();
    this.jgU.dG(this.chM.aUd(), 2147483647);
    this.jgW.aUC();
    AppMethodBeat.o(147032);
  }
  
  public final void setJsExceptionHandler(h paramh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.n
 * JD-Core Version:    0.7.0.1
 */