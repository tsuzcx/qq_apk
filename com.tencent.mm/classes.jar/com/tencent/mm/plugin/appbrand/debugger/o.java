package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.mm.plugin.appbrand.o.k.b;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.protocal.protobuf.ebr;
import com.tencent.mm.protocal.protobuf.ebs;
import com.tencent.mm.protocal.protobuf.ebu;
import com.tencent.mm.protocal.protobuf.ebx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  m cpc;
  public String keJ;
  private Activity keK;
  u keL;
  q keM;
  com.tencent.luggage.sdk.b.a.c.c keN;
  public w keO;
  k.b keP;
  
  public o()
  {
    AppMethodBeat.i(147025);
    this.keM = new q();
    this.keP = new k.b()
    {
      public final void OI(String paramAnonymousString)
      {
        AppMethodBeat.i(147017);
        ae.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[] { paramAnonymousString });
        o.this.keO.OP(paramAnonymousString);
        AppMethodBeat.o(147017);
      }
      
      public final void OJ(String paramAnonymousString)
      {
        AppMethodBeat.i(147021);
        ae.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[] { paramAnonymousString });
        AppMethodBeat.o(147021);
      }
      
      public final void aa(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(147020);
        ae.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        m localm = o.this.cpc;
        if ((!localm.isQuit()) && (localm.keB < 10L)) {}
        for (paramAnonymousInt = i;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt != 0)
          {
            com.tencent.mm.plugin.appbrand.y.m.bCj().k(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147015);
                o.this.connect();
                AppMethodBeat.o(147015);
              }
            }, 1000L);
            localm = o.this.cpc;
            localm.keB += 1;
          }
          o.this.keM.bfC();
          o.this.cpc.keo = System.currentTimeMillis();
          o.this.keO.bfM();
          o.this.cpc.setStatus(5);
          o.this.keO.OP(paramAnonymousString);
          AppMethodBeat.o(147020);
          return;
        }
      }
      
      public final void bfu()
      {
        AppMethodBeat.i(147016);
        ae.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
        o.this.cpc.keo = System.currentTimeMillis();
        o.this.cpc.keB = 0;
        if (!bu.isNullOrNil(o.this.cpc.bfm())) {
          o.a(o.this);
        }
        q localq = o.this.keM;
        localq.bfC();
        localq.mTimer = new Timer();
        q.4 local4 = new q.4(localq);
        localq.mTimer.schedule(local4, 100L, 1000L);
        AppMethodBeat.o(147016);
      }
      
      public final void bfv()
      {
        AppMethodBeat.i(147018);
        o.this.cpc.keo = System.currentTimeMillis();
        AppMethodBeat.o(147018);
      }
      
      public final void k(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(147019);
        o.this.cpc.keo = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            paramAnonymousByteBuffer = d.p(paramAnonymousByteBuffer);
            paramAnonymousByteBuffer = (eay)new eay().parseFrom(paramAnonymousByteBuffer);
            if (paramAnonymousByteBuffer.Gwe == null)
            {
              ae.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
              AppMethodBeat.o(147019);
              return;
            }
            localObject1 = paramAnonymousByteBuffer.Gwe.zr;
            switch (paramAnonymousByteBuffer.EN)
            {
            case 1006: 
              ae.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[] { Integer.valueOf(paramAnonymousByteBuffer.EN) });
              AppMethodBeat.o(147019);
              return;
            }
          }
          catch (Throwable paramAnonymousByteBuffer)
          {
            ae.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", new Object[] { Log.getStackTraceString(paramAnonymousByteBuffer) });
            AppMethodBeat.o(147019);
            return;
          }
          Object localObject1 = (ebn)new ebn().parseFrom((byte[])localObject1);
          Object localObject2 = o.this.keM;
          if (v.a(((q)localObject2).cpc, paramAnonymousByteBuffer, ((ebn)localObject1).Ihc, ((q)localObject2).keO, (q)localObject2))
          {
            ae.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[] { Integer.valueOf(((ebn)localObject1).Ihd), Integer.valueOf(((ebn)localObject1).Ihe) });
            ((q)localObject2).cpc.dH(((ebn)localObject1).Ihd, ((ebn)localObject1).Ihe);
            ((q)localObject2).dJ(((ebn)localObject1).Ihd, ((ebn)localObject1).Ihe);
          }
          r.a(paramAnonymousByteBuffer, (l)o.this.cpc.kex.get(paramAnonymousByteBuffer.uuid));
          continue;
          localObject1 = (ebq)new ebq().parseFrom((byte[])localObject1);
          v.a(o.this.cpc, paramAnonymousByteBuffer, ((ebq)localObject1).Ihc, o.this.keO, o.this.keM);
          o.this.cpc.keo = System.currentTimeMillis();
          continue;
          localObject2 = (ebu)new ebu().parseFrom((byte[])localObject1);
          localObject1 = o.this;
          if (v.a(((o)localObject1).cpc, paramAnonymousByteBuffer, ((ebu)localObject2).Ihc, ((o)localObject1).keO, ((o)localObject1).keM))
          {
            ae.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
            if (((ebu)localObject2).Ihm == null)
            {
              ae.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
            }
            else if (((ebu)localObject2).Ihm.IgV)
            {
              ((o)localObject1).cpc.kej = ((ebu)localObject2).Ihm;
              ((o)localObject1).onReady();
            }
            else
            {
              ae.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
              ((o)localObject1).cpc.setStatus(2);
              localObject2 = new ebr();
              ((ebr)localObject2).Iha = ((o)localObject1).cpc.kef;
              ((ebr)localObject2).FKz = ((o)localObject1).cpc.kek.roomId;
              ((ebr)localObject2).username = "";
              ((ebr)localObject2).Ihl = ((o)localObject1).cpc.kek.keE;
              localObject2 = v.a(1003, (com.tencent.mm.bw.a)localObject2);
              ((o)localObject1).keL.a((eay)localObject2);
              continue;
              localObject1 = (ebs)new ebs().parseFrom((byte[])localObject1);
              if (v.a(o.this.cpc, paramAnonymousByteBuffer, ((ebs)localObject1).Ihc, o.this.keO, o.this.keM))
              {
                o.b(o.this);
                continue;
                if (o.this.keN.isRunning())
                {
                  localObject1 = o.this.keM;
                  ae.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                  ((q)localObject1).bfA();
                  localObject1 = ((q)localObject1).keO;
                  ((w)localObject1).bfM();
                  ar.f(new w.6((w)localObject1));
                }
                else
                {
                  localObject1 = o.this.keM;
                  ae.i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
                  ((q)localObject1).bfA();
                  localObject1 = ((q)localObject1).keO;
                  ((w)localObject1).setVisibility(8);
                  if ((((w)localObject1).getParent() instanceof ViewGroup))
                  {
                    ((ViewGroup)((w)localObject1).getParent()).removeView((View)localObject1);
                    ((w)localObject1).removeAllViews();
                  }
                  ((w)localObject1).kfr = null;
                  continue;
                  localObject1 = (ebx)new ebx().parseFrom((byte[])localObject1);
                  localObject2 = o.this.keM;
                  ae.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                  if (v.a(((q)localObject2).cpc, paramAnonymousByteBuffer, ((ebx)localObject1).Ihc, ((q)localObject2).keO, (q)localObject2))
                  {
                    ((q)localObject2).v(((ebx)localObject1).IgR);
                    ((q)localObject2).cpc.sn(((ebx)localObject1).Ihp);
                    ((q)localObject2).bfB();
                    continue;
                    localObject1 = (ebf)new ebf().parseFrom((byte[])localObject1);
                    o.this.keM.v(((ebf)localObject1).IgR);
                    continue;
                    o.this.onReady();
                    continue;
                    o.this.cpc.setStatus(4);
                    o.this.keM.quit();
                  }
                }
              }
            }
          }
        }
      }
    };
    com.tencent.mm.sdk.b.a.IvT.b(new o.4(this));
    AppMethodBeat.o(147025);
  }
  
  private void bfs()
  {
    AppMethodBeat.i(147035);
    ae.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
    bil localbil = new bil();
    ((com.tencent.mm.plugin.appbrand.networking.c)this.keN.K(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", localbil, bim.class).c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(147035);
  }
  
  public final <T extends j> T P(Class<T> paramClass)
  {
    return null;
  }
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(147033);
    this.keM.Z(paramInt, paramString);
    AppMethodBeat.o(147033);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(147026);
    this.cpc = paramm;
    this.keN = this.cpc.kee;
    this.keK = ((Activity)this.keN.getContext());
    this.keO = new w(this.keK, this.cpc, new o.1(this));
    this.keO.S(this.keN.Eq());
    connect();
    if (bu.isNullOrNil(this.cpc.bfm())) {
      bfs();
    }
    AppMethodBeat.o(147026);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(147034);
    this.keM.a(paramp);
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
    if (this.keL == null)
    {
      this.keL = new u((com.tencent.mm.plugin.appbrand.o.a)this.keN.ar(com.tencent.mm.plugin.appbrand.o.a.class));
      this.keM.a(this.keL, this.cpc, this.keO);
    }
    if (this.cpc.bfr())
    {
      this.keL.a("ws://localhost:" + this.cpc.kek.keH, this.keP);
      AppMethodBeat.o(147031);
      return;
    }
    this.keL.a("wss://wxagame.weixin.qq.com/remote/", this.keP);
    AppMethodBeat.o(147031);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(147030);
    this.keM.quit();
    this.keM.bfC();
    AppMethodBeat.o(147030);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(147027);
    if (this.cpc == null)
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("FATAL");
      }
      AppMethodBeat.o(147027);
      return;
    }
    if (this.cpc.bfp())
    {
      AppMethodBeat.o(147027);
      return;
    }
    if (!this.cpc.isReady())
    {
      this.cpc.kev.add(new Pair(paramString, paramValueCallback));
      this.keJ = null;
      AppMethodBeat.o(147027);
      return;
    }
    Object localObject = new ebd();
    ((ebd)localObject).IgQ = this.cpc.keq.incrementAndGet();
    ((ebd)localObject).script = paramString;
    p localp = v.a((com.tencent.mm.bw.a)localObject, this.cpc, "evaluateJavascript");
    this.keM.a(localp);
    int i = ((ebd)localObject).IgQ;
    localObject = new c();
    if (!bu.isNullOrNil(this.keJ))
    {
      ((c)localObject).dmp = this.keJ;
      this.keJ = null;
    }
    for (;;)
    {
      ((c)localObject).kdZ = System.currentTimeMillis();
      ((c)localObject).size = paramString.length();
      ((c)localObject).kdY = paramValueCallback;
      this.cpc.keA.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(147027);
      return;
      ((c)localObject).dmp = r.OL(paramString);
    }
  }
  
  final void onReady()
  {
    AppMethodBeat.i(147032);
    ae.i("MicroMsg.RemoteDebugJsEngine", "onReady");
    this.cpc.setStatus(3);
    ae.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
    Iterator localIterator = this.cpc.kev.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
    }
    this.cpc.kev.clear();
    this.keM.dI(this.cpc.bfn(), 2147483647);
    this.keO.bfM();
    AppMethodBeat.o(147032);
  }
  
  public final void setJsExceptionHandler(h paramh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o
 * JD-Core Version:    0.7.0.1
 */