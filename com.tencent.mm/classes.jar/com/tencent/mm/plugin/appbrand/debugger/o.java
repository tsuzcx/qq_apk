package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.o.k.b;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.dzz;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eab;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eag;
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

public final class o
  implements i
{
  m coY;
  public String kbs;
  private Activity kbt;
  u kbu;
  q kbv;
  com.tencent.luggage.sdk.b.a.c.c kbw;
  public w kbx;
  k.b kby;
  
  public o()
  {
    AppMethodBeat.i(147025);
    this.kbv = new q();
    this.kby = new k.b()
    {
      public final void Ob(String paramAnonymousString)
      {
        AppMethodBeat.i(147017);
        ad.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[] { paramAnonymousString });
        o.this.kbx.Oi(paramAnonymousString);
        AppMethodBeat.o(147017);
      }
      
      public final void Oc(String paramAnonymousString)
      {
        AppMethodBeat.i(147021);
        ad.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[] { paramAnonymousString });
        AppMethodBeat.o(147021);
      }
      
      public final void aa(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(147020);
        ad.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        m localm = o.this.coY;
        if ((!localm.isQuit()) && (localm.kbk < 10L)) {}
        for (paramAnonymousInt = i;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt != 0)
          {
            com.tencent.mm.plugin.appbrand.z.m.bBp().k(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147015);
                o.this.connect();
                AppMethodBeat.o(147015);
              }
            }, 1000L);
            localm = o.this.coY;
            localm.kbk += 1;
          }
          o.this.kbv.beU();
          o.this.coY.kaY = System.currentTimeMillis();
          o.this.kbx.bfe();
          o.this.coY.setStatus(5);
          o.this.kbx.Oi(paramAnonymousString);
          AppMethodBeat.o(147020);
          return;
        }
      }
      
      public final void beM()
      {
        AppMethodBeat.i(147016);
        ad.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
        o.this.coY.kaY = System.currentTimeMillis();
        o.this.coY.kbk = 0;
        if (!bt.isNullOrNil(o.this.coY.beE())) {
          o.a(o.this);
        }
        q localq = o.this.kbv;
        localq.beU();
        localq.mTimer = new Timer();
        q.4 local4 = new q.4(localq);
        localq.mTimer.schedule(local4, 100L, 1000L);
        AppMethodBeat.o(147016);
      }
      
      public final void beN()
      {
        AppMethodBeat.i(147018);
        o.this.coY.kaY = System.currentTimeMillis();
        AppMethodBeat.o(147018);
      }
      
      public final void k(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(147019);
        o.this.coY.kaY = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            paramAnonymousByteBuffer = d.p(paramAnonymousByteBuffer);
            paramAnonymousByteBuffer = (dzh)new dzh().parseFrom(paramAnonymousByteBuffer);
            if (paramAnonymousByteBuffer.Gdx == null)
            {
              ad.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
              AppMethodBeat.o(147019);
              return;
            }
            localObject1 = paramAnonymousByteBuffer.Gdx.zr;
            switch (paramAnonymousByteBuffer.EN)
            {
            case 1006: 
              ad.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[] { Integer.valueOf(paramAnonymousByteBuffer.EN) });
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
          Object localObject1 = (dzw)new dzw().parseFrom((byte[])localObject1);
          Object localObject2 = o.this.kbv;
          if (v.a(((q)localObject2).coY, paramAnonymousByteBuffer, ((dzw)localObject1).HMV, ((q)localObject2).kbx, (q)localObject2))
          {
            ad.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[] { Integer.valueOf(((dzw)localObject1).HMW), Integer.valueOf(((dzw)localObject1).HMX) });
            ((q)localObject2).coY.dH(((dzw)localObject1).HMW, ((dzw)localObject1).HMX);
            ((q)localObject2).dJ(((dzw)localObject1).HMW, ((dzw)localObject1).HMX);
          }
          r.a(paramAnonymousByteBuffer, (l)o.this.coY.kbh.get(paramAnonymousByteBuffer.uuid));
          continue;
          localObject1 = (dzz)new dzz().parseFrom((byte[])localObject1);
          v.a(o.this.coY, paramAnonymousByteBuffer, ((dzz)localObject1).HMV, o.this.kbx, o.this.kbv);
          o.this.coY.kaY = System.currentTimeMillis();
          continue;
          localObject2 = (ead)new ead().parseFrom((byte[])localObject1);
          localObject1 = o.this;
          if (v.a(((o)localObject1).coY, paramAnonymousByteBuffer, ((ead)localObject2).HMV, ((o)localObject1).kbx, ((o)localObject1).kbv))
          {
            ad.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
            if (((ead)localObject2).HNf == null)
            {
              ad.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
            }
            else if (((ead)localObject2).HNf.HMO)
            {
              ((o)localObject1).coY.kaT = ((ead)localObject2).HNf;
              ((o)localObject1).onReady();
            }
            else
            {
              ad.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
              ((o)localObject1).coY.setStatus(2);
              localObject2 = new eaa();
              ((eaa)localObject2).HMT = ((o)localObject1).coY.kaP;
              ((eaa)localObject2).Fsb = ((o)localObject1).coY.kaU.roomId;
              ((eaa)localObject2).username = "";
              ((eaa)localObject2).HNe = ((o)localObject1).coY.kaU.kbn;
              localObject2 = v.a(1003, (com.tencent.mm.bx.a)localObject2);
              ((o)localObject1).kbu.a((dzh)localObject2);
              continue;
              localObject1 = (eab)new eab().parseFrom((byte[])localObject1);
              if (v.a(o.this.coY, paramAnonymousByteBuffer, ((eab)localObject1).HMV, o.this.kbx, o.this.kbv))
              {
                o.b(o.this);
                continue;
                if (o.this.kbw.isRunning())
                {
                  localObject1 = o.this.kbv;
                  ad.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                  ((q)localObject1).beS();
                  localObject1 = ((q)localObject1).kbx;
                  ((w)localObject1).bfe();
                  aq.f(new w.6((w)localObject1));
                }
                else
                {
                  localObject1 = o.this.kbv;
                  ad.i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
                  ((q)localObject1).beS();
                  localObject1 = ((q)localObject1).kbx;
                  ((w)localObject1).setVisibility(8);
                  if ((((w)localObject1).getParent() instanceof ViewGroup))
                  {
                    ((ViewGroup)((w)localObject1).getParent()).removeView((View)localObject1);
                    ((w)localObject1).removeAllViews();
                  }
                  ((w)localObject1).kca = null;
                  continue;
                  localObject1 = (eag)new eag().parseFrom((byte[])localObject1);
                  localObject2 = o.this.kbv;
                  ad.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                  if (v.a(((q)localObject2).coY, paramAnonymousByteBuffer, ((eag)localObject1).HMV, ((q)localObject2).kbx, (q)localObject2))
                  {
                    ((q)localObject2).v(((eag)localObject1).HMK);
                    ((q)localObject2).coY.sk(((eag)localObject1).HNi);
                    ((q)localObject2).beT();
                    continue;
                    localObject1 = (dzo)new dzo().parseFrom((byte[])localObject1);
                    o.this.kbv.v(((dzo)localObject1).HMK);
                    continue;
                    o.this.onReady();
                    continue;
                    o.this.coY.setStatus(4);
                    o.this.kbv.quit();
                  }
                }
              }
            }
          }
        }
      }
    };
    com.tencent.mm.sdk.b.a.IbL.b(new o.4(this));
    AppMethodBeat.o(147025);
  }
  
  private void beK()
  {
    AppMethodBeat.i(147035);
    ad.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
    bhv localbhv = new bhv();
    ((com.tencent.mm.plugin.appbrand.networking.b)this.kbw.K(com.tencent.mm.plugin.appbrand.networking.b.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", localbhv, bhw.class).c(new o.3(this));
    AppMethodBeat.o(147035);
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    return null;
  }
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(147033);
    this.kbv.Z(paramInt, paramString);
    AppMethodBeat.o(147033);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(147026);
    this.coY = paramm;
    this.kbw = this.coY.kaO;
    this.kbt = ((Activity)this.kbw.getContext());
    this.kbx = new w(this.kbt, this.coY, new w.a()
    {
      public final void beL()
      {
        AppMethodBeat.i(147014);
        o.this.destroy();
        g.a(o.this.kbw.getAppId(), g.d.jwl);
        if (o.this.kbw.En() != null) {
          o.this.kbw.En().finish();
        }
        AppMethodBeat.o(147014);
      }
    });
    this.kbx.c(this.kbw.En().jwJ);
    connect();
    if (bt.isNullOrNil(this.coY.beE())) {
      beK();
    }
    AppMethodBeat.o(147026);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(147034);
    this.kbv.a(paramp);
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
    if (this.kbu == null)
    {
      this.kbu = new u((com.tencent.mm.plugin.appbrand.o.a)this.kbw.ar(com.tencent.mm.plugin.appbrand.o.a.class));
      this.kbv.a(this.kbu, this.coY, this.kbx);
    }
    if (this.coY.beJ())
    {
      this.kbu.a("ws://localhost:" + this.coY.kaU.kbq, this.kby);
      AppMethodBeat.o(147031);
      return;
    }
    this.kbu.a("wss://wxagame.weixin.qq.com/remote/", this.kby);
    AppMethodBeat.o(147031);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(147030);
    this.kbv.quit();
    this.kbv.beU();
    AppMethodBeat.o(147030);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(147027);
    if (this.coY == null)
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("FATAL");
      }
      AppMethodBeat.o(147027);
      return;
    }
    if (this.coY.beH())
    {
      AppMethodBeat.o(147027);
      return;
    }
    if (!this.coY.isReady())
    {
      this.coY.kbf.add(new Pair(paramString, paramValueCallback));
      this.kbs = null;
      AppMethodBeat.o(147027);
      return;
    }
    Object localObject = new dzm();
    ((dzm)localObject).HMJ = this.coY.kba.incrementAndGet();
    ((dzm)localObject).script = paramString;
    p localp = v.a((com.tencent.mm.bx.a)localObject, this.coY, "evaluateJavascript");
    this.kbv.a(localp);
    int i = ((dzm)localObject).HMJ;
    localObject = new c();
    if (!bt.isNullOrNil(this.kbs))
    {
      ((c)localObject).dln = this.kbs;
      this.kbs = null;
    }
    for (;;)
    {
      ((c)localObject).kaJ = System.currentTimeMillis();
      ((c)localObject).size = paramString.length();
      ((c)localObject).kaI = paramValueCallback;
      this.coY.kbj.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(147027);
      return;
      ((c)localObject).dln = r.Oe(paramString);
    }
  }
  
  final void onReady()
  {
    AppMethodBeat.i(147032);
    ad.i("MicroMsg.RemoteDebugJsEngine", "onReady");
    this.coY.setStatus(3);
    ad.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
    Iterator localIterator = this.coY.kbf.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
    }
    this.coY.kbf.clear();
    this.kbv.dI(this.coY.beF(), 2147483647);
    this.kbx.bfe();
    AppMethodBeat.o(147032);
  }
  
  public final void setJsExceptionHandler(h paramh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o
 * JD-Core Version:    0.7.0.1
 */