package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.i.j;
import com.tencent.mm.plugin.appbrand.m.k.b;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.protocal.protobuf.cun;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.cur;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
  implements com.tencent.mm.plugin.appbrand.i.i
{
  l bER;
  private Activity gQx;
  public String hlN;
  s hlO;
  public p hlP;
  com.tencent.luggage.sdk.b.a.c.c hlQ;
  public u hlR;
  k.b hlS;
  
  public n()
  {
    AppMethodBeat.i(101840);
    this.hlP = new p();
    this.hlS = new k.b()
    {
      public final void AM(String paramAnonymousString)
      {
        AppMethodBeat.i(101831);
        ab.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[] { paramAnonymousString });
        n.this.hlR.AT(paramAnonymousString);
        AppMethodBeat.o(101831);
      }
      
      public final void AN(String paramAnonymousString)
      {
        AppMethodBeat.i(101835);
        ab.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[] { paramAnonymousString });
        AppMethodBeat.o(101835);
      }
      
      public final void N(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(101834);
        ab.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        l locall = n.this.bER;
        if ((!locall.ayY()) && (locall.hlF < 10L)) {}
        for (paramAnonymousInt = i;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt != 0)
          {
            com.tencent.mm.plugin.appbrand.s.m.aNS().o(new n.2.1(this), 1000L);
            locall = n.this.bER;
            locall.hlF += 1;
          }
          n.this.hlP.azl();
          n.this.bER.hlt = System.currentTimeMillis();
          n.this.hlR.azv();
          n.this.bER.setStatus(5);
          n.this.hlR.AT(paramAnonymousString);
          AppMethodBeat.o(101834);
          return;
        }
      }
      
      public final void azd()
      {
        AppMethodBeat.i(101830);
        ab.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
        n.this.bER.hlt = System.currentTimeMillis();
        n.this.bER.hlF = 0;
        if (!bo.isNullOrNil(n.this.bER.ayU())) {
          n.a(n.this);
        }
        p localp = n.this.hlP;
        localp.azl();
        localp.mTimer = new Timer();
        p.4 local4 = new p.4(localp);
        localp.mTimer.schedule(local4, 100L, 1000L);
        AppMethodBeat.o(101830);
      }
      
      public final void aze()
      {
        AppMethodBeat.i(101832);
        n.this.bER.hlt = System.currentTimeMillis();
        AppMethodBeat.o(101832);
      }
      
      public final void h(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(101833);
        n.this.bER.hlt = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            paramAnonymousByteBuffer = d.m(paramAnonymousByteBuffer);
            paramAnonymousByteBuffer = (ctv)new ctv().parseFrom(paramAnonymousByteBuffer);
            if (paramAnonymousByteBuffer.wPX == null)
            {
              ab.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
              AppMethodBeat.o(101833);
              return;
            }
            localObject1 = paramAnonymousByteBuffer.wPX.pW;
            switch (paramAnonymousByteBuffer.vA)
            {
            case 1006: 
              ab.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[] { Integer.valueOf(paramAnonymousByteBuffer.vA) });
              AppMethodBeat.o(101833);
              return;
            }
          }
          catch (Throwable paramAnonymousByteBuffer)
          {
            ab.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", new Object[] { Log.getStackTraceString(paramAnonymousByteBuffer) });
            AppMethodBeat.o(101833);
            return;
          }
          Object localObject1 = (cuk)new cuk().parseFrom((byte[])localObject1);
          Object localObject2 = n.this.hlP;
          if (t.a(((p)localObject2).bER, paramAnonymousByteBuffer, ((cuk)localObject1).ydi, ((p)localObject2).hlR, (p)localObject2))
          {
            ab.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[] { Integer.valueOf(((cuk)localObject1).ydj), Integer.valueOf(((cuk)localObject1).ydk) });
            ((p)localObject2).bER.cZ(((cuk)localObject1).ydj, ((cuk)localObject1).ydk);
            ((p)localObject2).db(((cuk)localObject1).ydj, ((cuk)localObject1).ydk);
          }
          q.a(paramAnonymousByteBuffer, (k)n.this.bER.hlC.get(paramAnonymousByteBuffer.eAx));
          continue;
          localObject1 = (cun)new cun().parseFrom((byte[])localObject1);
          t.a(n.this.bER, paramAnonymousByteBuffer, ((cun)localObject1).ydi, n.this.hlR, n.this.hlP);
          n.this.bER.hlt = System.currentTimeMillis();
          continue;
          localObject2 = (cur)new cur().parseFrom((byte[])localObject1);
          localObject1 = n.this;
          if (t.a(((n)localObject1).bER, paramAnonymousByteBuffer, ((cur)localObject2).ydi, ((n)localObject1).hlR, ((n)localObject1).hlP))
          {
            ab.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
            if (((cur)localObject2).yds == null)
            {
              ab.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
            }
            else if (((cur)localObject2).yds.yda)
            {
              ((n)localObject1).bER.hlo = ((cur)localObject2).yds;
              ((n)localObject1).onReady();
            }
            else
            {
              ab.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
              ((n)localObject1).bER.setStatus(2);
              localObject2 = new cuo();
              ((cuo)localObject2).ydg = ((n)localObject1).bER.hlk;
              ((cuo)localObject2).ydb = ((n)localObject1).bER.hlp.eeu;
              ((cuo)localObject2).username = "";
              ((cuo)localObject2).ydr = ((n)localObject1).bER.hlp.hlI;
              localObject2 = t.a(1003, (com.tencent.mm.bv.a)localObject2);
              ((n)localObject1).hlO.a((ctv)localObject2);
              continue;
              localObject1 = (cup)new cup().parseFrom((byte[])localObject1);
              if (t.a(n.this.bER, paramAnonymousByteBuffer, ((cup)localObject1).ydi, n.this.hlR, n.this.hlP))
              {
                n.b(n.this);
                continue;
                if (n.this.hlQ.isRunning())
                {
                  localObject1 = n.this.hlP;
                  ab.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                  ((p)localObject1).azj();
                  localObject1 = ((p)localObject1).hlR;
                  ((u)localObject1).azv();
                  al.d(new u.6((u)localObject1));
                }
                else
                {
                  localObject1 = n.this.hlP;
                  ab.i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
                  ((p)localObject1).azj();
                  localObject1 = ((p)localObject1).hlR;
                  ((u)localObject1).setVisibility(8);
                  if ((((u)localObject1).getParent() instanceof ViewGroup))
                  {
                    ((ViewGroup)((u)localObject1).getParent()).removeView((View)localObject1);
                    ((u)localObject1).removeAllViews();
                  }
                  ((u)localObject1).hmw = null;
                  continue;
                  localObject1 = (cuu)new cuu().parseFrom((byte[])localObject1);
                  localObject2 = n.this.hlP;
                  ab.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                  if (t.a(((p)localObject2).bER, paramAnonymousByteBuffer, ((cuu)localObject1).ydi, ((p)localObject2).hlR, (p)localObject2))
                  {
                    ((p)localObject2).u(((cuu)localObject1).ycV);
                    ((p)localObject2).bER.nB(((cuu)localObject1).ydv);
                    ((p)localObject2).azk();
                    continue;
                    localObject1 = (cuc)new cuc().parseFrom((byte[])localObject1);
                    n.this.hlP.u(((cuc)localObject1).ycV);
                    continue;
                    n.this.onReady();
                    continue;
                    n.this.bER.setStatus(4);
                    n.this.hlP.quit();
                  }
                }
              }
            }
          }
        }
      }
    };
    com.tencent.mm.sdk.b.a.ymk.b(new n.4(this));
    AppMethodBeat.o(101840);
  }
  
  private void azb()
  {
    AppMethodBeat.i(140825);
    ab.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
    api localapi = new api();
    ((com.tencent.mm.plugin.appbrand.networking.a)this.hlQ.q(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", localapi, apj.class).c(new n.3(this));
    AppMethodBeat.o(140825);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(101841);
    this.bER = paraml;
    this.hlQ = this.bER.hlj;
    this.gQx = ((Activity)this.hlQ.getContext());
    this.hlR = new u(this.gQx, this.bER, new n.1(this));
    this.hlR.g(this.hlQ.wj().gPC);
    connect();
    if (bo.isNullOrNil(this.bER.ayU())) {
      azb();
    }
    AppMethodBeat.o(101841);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(101848);
    this.hlP.a(paramo);
    AppMethodBeat.o(101848);
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(101843);
    evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(101843);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(101844);
    evaluateJavascript(paramString3, paramValueCallback);
    AppMethodBeat.o(101844);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  final void connect()
  {
    AppMethodBeat.i(101846);
    if (this.hlO == null)
    {
      this.hlO = new s((com.tencent.mm.plugin.appbrand.m.a)this.hlQ.U(com.tencent.mm.plugin.appbrand.m.a.class));
      this.hlP.a(this.hlO, this.bER, this.hlR);
    }
    if (this.bER.aza())
    {
      this.hlO.a("ws://localhost:" + this.bER.hlp.hlL, this.hlS);
      AppMethodBeat.o(101846);
      return;
    }
    this.hlO.a("wss://wxagame.weixin.qq.com/remote/", this.hlS);
    AppMethodBeat.o(101846);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(101845);
    this.hlP.quit();
    this.hlP.azl();
    AppMethodBeat.o(101845);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(101842);
    if (this.bER == null)
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("FATAL");
      }
      AppMethodBeat.o(101842);
      return;
    }
    if (this.bER.ayX())
    {
      AppMethodBeat.o(101842);
      return;
    }
    if (!this.bER.isReady())
    {
      this.bER.hlA.add(new Pair(paramString, paramValueCallback));
      this.hlN = null;
      AppMethodBeat.o(101842);
      return;
    }
    Object localObject = new cua();
    ((cua)localObject).ycU = this.bER.hlv.incrementAndGet();
    ((cua)localObject).script = paramString;
    o localo = t.a((com.tencent.mm.bv.a)localObject, this.bER, "evaluateJavascript");
    this.hlP.a(localo);
    int i = ((cua)localObject).ycU;
    localObject = new b();
    if (!bo.isNullOrNil(this.hlN))
    {
      ((b)localObject).cnC = this.hlN;
      this.hlN = null;
    }
    for (;;)
    {
      ((b)localObject).hlb = System.currentTimeMillis();
      ((b)localObject).size = paramString.length();
      ((b)localObject).hla = paramValueCallback;
      this.bER.hlE.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(101842);
      return;
      ((b)localObject).cnC = q.AP(paramString);
    }
  }
  
  final void onReady()
  {
    AppMethodBeat.i(101847);
    ab.i("MicroMsg.RemoteDebugJsEngine", "onReady");
    this.bER.setStatus(3);
    ab.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
    Iterator localIterator = this.bER.hlA.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
    }
    this.bER.hlA.clear();
    this.hlP.da(this.bER.ayV(), 2147483647);
    this.hlR.azv();
    AppMethodBeat.o(101847);
  }
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final <T extends j> T v(Class<T> paramClass)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.n
 * JD-Core Version:    0.7.0.1
 */