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
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.p.k.b;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.dtn;
import com.tencent.mm.protocal.protobuf.dts;
import com.tencent.mm.protocal.protobuf.dtu;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.protocal.protobuf.dua;
import com.tencent.mm.protocal.protobuf.duc;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.duh;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.protocal.protobuf.dum;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  l ceH;
  public String jHg;
  private Activity jHh;
  t jHi;
  p jHj;
  com.tencent.luggage.sdk.b.a.c.c jHk;
  public v jHl;
  k.b jHm;
  
  public n()
  {
    AppMethodBeat.i(147025);
    this.jHj = new p();
    this.jHm = new k.b()
    {
      public final void KH(String paramAnonymousString)
      {
        AppMethodBeat.i(147017);
        ac.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[] { paramAnonymousString });
        n.this.jHl.KO(paramAnonymousString);
        AppMethodBeat.o(147017);
      }
      
      public final void KI(String paramAnonymousString)
      {
        AppMethodBeat.i(147021);
        ac.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[] { paramAnonymousString });
        AppMethodBeat.o(147021);
      }
      
      public final void Y(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(147020);
        ac.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        l locall = n.this.ceH;
        if ((!locall.isQuit()) && (locall.jGY < 10L)) {}
        for (paramAnonymousInt = i;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt != 0)
          {
            com.tencent.mm.plugin.appbrand.z.l.bxj().j(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147015);
                n.this.connect();
                AppMethodBeat.o(147015);
              }
            }, 1000L);
            locall = n.this.ceH;
            locall.jGY += 1;
          }
          n.this.jHj.bbq();
          n.this.ceH.jGM = System.currentTimeMillis();
          n.this.jHl.bbA();
          n.this.ceH.setStatus(5);
          n.this.jHl.KO(paramAnonymousString);
          AppMethodBeat.o(147020);
          return;
        }
      }
      
      public final void bbi()
      {
        AppMethodBeat.i(147016);
        ac.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
        n.this.ceH.jGM = System.currentTimeMillis();
        n.this.ceH.jGY = 0;
        if (!bs.isNullOrNil(n.this.ceH.bba())) {
          n.a(n.this);
        }
        p localp = n.this.jHj;
        localp.bbq();
        localp.mTimer = new Timer();
        p.4 local4 = new p.4(localp);
        localp.mTimer.schedule(local4, 100L, 1000L);
        AppMethodBeat.o(147016);
      }
      
      public final void bbj()
      {
        AppMethodBeat.i(147018);
        n.this.ceH.jGM = System.currentTimeMillis();
        AppMethodBeat.o(147018);
      }
      
      public final void l(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(147019);
        n.this.ceH.jGM = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            paramAnonymousByteBuffer = d.q(paramAnonymousByteBuffer);
            paramAnonymousByteBuffer = (dtn)new dtn().parseFrom(paramAnonymousByteBuffer);
            if (paramAnonymousByteBuffer.Ewb == null)
            {
              ac.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
              AppMethodBeat.o(147019);
              return;
            }
            localObject1 = paramAnonymousByteBuffer.Ewb.xy;
            switch (paramAnonymousByteBuffer.CW)
            {
            case 1006: 
              ac.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[] { Integer.valueOf(paramAnonymousByteBuffer.CW) });
              AppMethodBeat.o(147019);
              return;
            }
          }
          catch (Throwable paramAnonymousByteBuffer)
          {
            ac.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", new Object[] { Log.getStackTraceString(paramAnonymousByteBuffer) });
            AppMethodBeat.o(147019);
            return;
          }
          Object localObject1 = (duc)new duc().parseFrom((byte[])localObject1);
          Object localObject2 = n.this.jHj;
          if (u.a(((p)localObject2).ceH, paramAnonymousByteBuffer, ((duc)localObject1).GbY, ((p)localObject2).jHl, (p)localObject2))
          {
            ac.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[] { Integer.valueOf(((duc)localObject1).GbZ), Integer.valueOf(((duc)localObject1).Gca) });
            ((p)localObject2).ceH.dF(((duc)localObject1).GbZ, ((duc)localObject1).Gca);
            ((p)localObject2).dH(((duc)localObject1).GbZ, ((duc)localObject1).Gca);
          }
          q.a(paramAnonymousByteBuffer, (k)n.this.ceH.jGV.get(paramAnonymousByteBuffer.uuid));
          continue;
          localObject1 = (duf)new duf().parseFrom((byte[])localObject1);
          u.a(n.this.ceH, paramAnonymousByteBuffer, ((duf)localObject1).GbY, n.this.jHl, n.this.jHj);
          n.this.ceH.jGM = System.currentTimeMillis();
          continue;
          localObject2 = (duj)new duj().parseFrom((byte[])localObject1);
          localObject1 = n.this;
          if (u.a(((n)localObject1).ceH, paramAnonymousByteBuffer, ((duj)localObject2).GbY, ((n)localObject1).jHl, ((n)localObject1).jHj))
          {
            ac.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
            if (((duj)localObject2).Gci == null)
            {
              ac.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
            }
            else if (((duj)localObject2).Gci.GbR)
            {
              ((n)localObject1).ceH.jGH = ((duj)localObject2).Gci;
              ((n)localObject1).onReady();
            }
            else
            {
              ac.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
              ((n)localObject1).ceH.setStatus(2);
              localObject2 = new dug();
              ((dug)localObject2).GbW = ((n)localObject1).ceH.jGD;
              ((dug)localObject2).DMW = ((n)localObject1).ceH.jGI.roomId;
              ((dug)localObject2).username = "";
              ((dug)localObject2).Gch = ((n)localObject1).ceH.jGI.jHb;
              localObject2 = u.a(1003, (com.tencent.mm.bw.a)localObject2);
              ((n)localObject1).jHi.a((dtn)localObject2);
              continue;
              localObject1 = (duh)new duh().parseFrom((byte[])localObject1);
              if (u.a(n.this.ceH, paramAnonymousByteBuffer, ((duh)localObject1).GbY, n.this.jHl, n.this.jHj))
              {
                n.b(n.this);
                continue;
                if (n.this.jHk.isRunning())
                {
                  localObject1 = n.this.jHj;
                  ac.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                  ((p)localObject1).bbo();
                  localObject1 = ((p)localObject1).jHl;
                  ((v)localObject1).bbA();
                  ap.f(new v.6((v)localObject1));
                }
                else
                {
                  localObject1 = n.this.jHj;
                  ac.i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
                  ((p)localObject1).bbo();
                  localObject1 = ((p)localObject1).jHl;
                  ((v)localObject1).setVisibility(8);
                  if ((((v)localObject1).getParent() instanceof ViewGroup))
                  {
                    ((ViewGroup)((v)localObject1).getParent()).removeView((View)localObject1);
                    ((v)localObject1).removeAllViews();
                  }
                  ((v)localObject1).jHO = null;
                  continue;
                  localObject1 = (dum)new dum().parseFrom((byte[])localObject1);
                  localObject2 = n.this.jHj;
                  ac.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                  if (u.a(((p)localObject2).ceH, paramAnonymousByteBuffer, ((dum)localObject1).GbY, ((p)localObject2).jHl, (p)localObject2))
                  {
                    ((p)localObject2).v(((dum)localObject1).GbN);
                    ((p)localObject2).ceH.rI(((dum)localObject1).Gcl);
                    ((p)localObject2).bbp();
                    continue;
                    localObject1 = (dtu)new dtu().parseFrom((byte[])localObject1);
                    n.this.jHj.v(((dtu)localObject1).GbN);
                    continue;
                    n.this.onReady();
                    continue;
                    n.this.ceH.setStatus(4);
                    n.this.jHj.quit();
                  }
                }
              }
            }
          }
        }
      }
    };
    com.tencent.mm.sdk.b.a.GpY.b(new com.tencent.mm.sdk.b.c()
    {
      private boolean a(com.tencent.mm.g.a.m paramAnonymousm)
      {
        AppMethodBeat.i(147023);
        if ((paramAnonymousm == null) || (paramAnonymousm.cYH == null) || (paramAnonymousm.cYH.cYK == null))
        {
          AppMethodBeat.o(147023);
          return true;
        }
        dtw localdtw = new dtw();
        localdtw.cYI = paramAnonymousm.cYH.cYI;
        localdtw.cYJ = paramAnonymousm.cYH.cYJ;
        localdtw.GbO = paramAnonymousm.cYH.cYK.toString();
        localdtw.timestamp = System.currentTimeMillis();
        paramAnonymousm = u.a(localdtw, n.this.ceH, "networkDebugAPI");
        n.this.a(paramAnonymousm);
        AppMethodBeat.o(147023);
        return true;
      }
    });
    AppMethodBeat.o(147025);
  }
  
  private void bbg()
  {
    AppMethodBeat.i(147035);
    ac.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
    bdp localbdp = new bdp();
    ((com.tencent.mm.plugin.appbrand.networking.a)this.jHk.K(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", localbdp, bdq.class).c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(147035);
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    return null;
  }
  
  public final void X(int paramInt, String paramString)
  {
    AppMethodBeat.i(147033);
    this.jHj.X(paramInt, paramString);
    AppMethodBeat.o(147033);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(147026);
    this.ceH = paraml;
    this.jHk = this.ceH.jGC;
    this.jHh = ((Activity)this.jHk.getContext());
    this.jHl = new v(this.jHh, this.ceH, new v.a()
    {
      public final void bbh()
      {
        AppMethodBeat.i(147014);
        n.this.destroy();
        g.a(n.this.jHk.getAppId(), g.d.jdc);
        if (n.this.jHk.CO() != null) {
          n.this.jHk.CO().finish();
        }
        AppMethodBeat.o(147014);
      }
    });
    this.jHl.h(this.jHk.CO().jdA);
    connect();
    if (bs.isNullOrNil(this.ceH.bba())) {
      bbg();
    }
    AppMethodBeat.o(147026);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(147034);
    this.jHj.a(paramo);
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
    if (this.jHi == null)
    {
      this.jHi = new t((com.tencent.mm.plugin.appbrand.p.a)this.jHk.ar(com.tencent.mm.plugin.appbrand.p.a.class));
      this.jHj.a(this.jHi, this.ceH, this.jHl);
    }
    if (this.ceH.bbf())
    {
      this.jHi.a("ws://localhost:" + this.ceH.jGI.jHe, this.jHm);
      AppMethodBeat.o(147031);
      return;
    }
    this.jHi.a("wss://wxagame.weixin.qq.com/remote/", this.jHm);
    AppMethodBeat.o(147031);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(147030);
    this.jHj.quit();
    this.jHj.bbq();
    AppMethodBeat.o(147030);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(147027);
    if (this.ceH == null)
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("FATAL");
      }
      AppMethodBeat.o(147027);
      return;
    }
    if (this.ceH.bbd())
    {
      AppMethodBeat.o(147027);
      return;
    }
    if (!this.ceH.isReady())
    {
      this.ceH.jGT.add(new Pair(paramString, paramValueCallback));
      this.jHg = null;
      AppMethodBeat.o(147027);
      return;
    }
    Object localObject = new dts();
    ((dts)localObject).GbM = this.ceH.jGO.incrementAndGet();
    ((dts)localObject).script = paramString;
    o localo = u.a((com.tencent.mm.bw.a)localObject, this.ceH, "evaluateJavascript");
    this.jHj.a(localo);
    int i = ((dts)localObject).GbM;
    localObject = new b();
    if (!bs.isNullOrNil(this.jHg))
    {
      ((b)localObject).cZV = this.jHg;
      this.jHg = null;
    }
    for (;;)
    {
      ((b)localObject).jGx = System.currentTimeMillis();
      ((b)localObject).size = paramString.length();
      ((b)localObject).jGw = paramValueCallback;
      this.ceH.jGX.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(147027);
      return;
      ((b)localObject).cZV = q.KK(paramString);
    }
  }
  
  final void onReady()
  {
    AppMethodBeat.i(147032);
    ac.i("MicroMsg.RemoteDebugJsEngine", "onReady");
    this.ceH.setStatus(3);
    ac.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
    Iterator localIterator = this.ceH.jGT.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
    }
    this.ceH.jGT.clear();
    this.jHj.dG(this.ceH.bbb(), 2147483647);
    this.jHl.bbA();
    AppMethodBeat.o(147032);
  }
  
  public final void setJsExceptionHandler(h paramh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.n
 * JD-Core Version:    0.7.0.1
 */