package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.a.o.a;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.s.k.b;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.ffr;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.protocal.protobuf.ffy;
import com.tencent.mm.protocal.protobuf.fga;
import com.tencent.mm.protocal.protobuf.fgg;
import com.tencent.mm.protocal.protobuf.fgj;
import com.tencent.mm.protocal.protobuf.fgl;
import com.tencent.mm.protocal.protobuf.fgn;
import com.tencent.mm.protocal.protobuf.fgq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class q
  implements com.tencent.mm.plugin.appbrand.m.i
{
  private o cAD;
  private Activity mContext;
  public String odb;
  private w odc;
  public s odd;
  private com.tencent.luggage.sdk.b.a.c.d ode;
  public y odf;
  k.b odg;
  
  public q()
  {
    AppMethodBeat.i(147025);
    this.odd = new s();
    this.odg = new k.b()
    {
      public final void afG(String paramAnonymousString)
      {
        AppMethodBeat.i(147017);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[] { paramAnonymousString });
        q.e(q.this).afO(paramAnonymousString);
        AppMethodBeat.o(147017);
      }
      
      public final void afH(String paramAnonymousString)
      {
        AppMethodBeat.i(147021);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[] { paramAnonymousString });
        AppMethodBeat.o(147021);
      }
      
      public final void ag(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(147020);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        o localo = q.b(q.this);
        if ((!localo.isQuit()) && (localo.ocT < 10L)) {}
        for (paramAnonymousInt = i;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt != 0)
          {
            m.clV().i(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147015);
                q.h(q.this);
                AppMethodBeat.o(147015);
              }
            }, 1000L);
            localo = q.b(q.this);
            localo.ocT += 1;
          }
          q.d(q.this).bMq();
          q.b(q.this).ocH = System.currentTimeMillis();
          q.e(q.this).bMA();
          q.b(q.this).setStatus(5);
          q.e(q.this).afO(paramAnonymousString);
          AppMethodBeat.o(147020);
          return;
        }
      }
      
      public final void bMi()
      {
        AppMethodBeat.i(147016);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
        q.b(q.this).ocH = System.currentTimeMillis();
        q.b(q.this).ocT = 0;
        if (!Util.isNullOrNil(q.b(q.this).bMa())) {
          q.c(q.this);
        }
        s locals = q.d(q.this);
        locals.bMq();
        s.4 local4 = new s.4(locals);
        locals.odx = com.tencent.e.h.ZvG.b(local4, 100L, 1000L);
        AppMethodBeat.o(147016);
      }
      
      public final void bMj()
      {
        AppMethodBeat.i(147018);
        q.b(q.this).ocH = System.currentTimeMillis();
        AppMethodBeat.o(147018);
      }
      
      public final void h(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(147019);
        q.b(q.this).ocH = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            paramAnonymousByteBuffer = com.tencent.mm.plugin.appbrand.ac.d.m(paramAnonymousByteBuffer);
            paramAnonymousByteBuffer = (ffr)new ffr().parseFrom(paramAnonymousByteBuffer);
            if (paramAnonymousByteBuffer.Sth == null)
            {
              com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
              AppMethodBeat.o(147019);
              return;
            }
            localObject = paramAnonymousByteBuffer.Sth.UH;
            switch (paramAnonymousByteBuffer.Vh)
            {
            case 1006: 
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[] { Integer.valueOf(paramAnonymousByteBuffer.Vh) });
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
          Object localObject = (fgg)new fgg().parseFrom((byte[])localObject);
          s locals = q.d(q.this);
          if (x.a(locals.cAD, paramAnonymousByteBuffer, ((fgg)localObject).UGy, locals.odf, locals))
          {
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[] { Integer.valueOf(((fgg)localObject).UGz), Integer.valueOf(((fgg)localObject).UGA) });
            locals.cAD.er(((fgg)localObject).UGz, ((fgg)localObject).UGA);
            locals.et(((fgg)localObject).UGz, ((fgg)localObject).UGA);
          }
          t.a(paramAnonymousByteBuffer, (n)q.b(q.this).ocQ.get(paramAnonymousByteBuffer.uuid));
          continue;
          localObject = (fgj)new fgj().parseFrom((byte[])localObject);
          x.a(q.b(q.this), paramAnonymousByteBuffer, ((fgj)localObject).UGy, q.e(q.this), q.d(q.this));
          q.b(q.this).ocH = System.currentTimeMillis();
          continue;
          localObject = (fgn)new fgn().parseFrom((byte[])localObject);
          q.a(q.this, (fgn)localObject, paramAnonymousByteBuffer);
          continue;
          localObject = (fgl)new fgl().parseFrom((byte[])localObject);
          if (x.a(q.b(q.this), paramAnonymousByteBuffer, ((fgl)localObject).UGy, q.e(q.this), q.d(q.this)))
          {
            q.f(q.this);
            continue;
            if (q.a(q.this).isRunning())
            {
              localObject = q.d(q.this);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
              ((s)localObject).bMo();
              localObject = ((s)localObject).odf;
              ((y)localObject).bMA();
              MMHandlerThread.postToMainThread(new y.6((y)localObject));
            }
            else
            {
              localObject = q.d(q.this);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
              ((s)localObject).bMo();
              localObject = ((s)localObject).odf;
              ((y)localObject).setVisibility(8);
              if ((((y)localObject).getParent() instanceof ViewGroup))
              {
                ((ViewGroup)((y)localObject).getParent()).removeView((View)localObject);
                ((y)localObject).removeAllViews();
              }
              ((y)localObject).odJ = null;
              continue;
              localObject = (fgq)new fgq().parseFrom((byte[])localObject);
              locals = q.d(q.this);
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
              if (x.a(locals.cAD, paramAnonymousByteBuffer, ((fgq)localObject).UGy, locals.odf, locals))
              {
                locals.w(((fgq)localObject).UGn);
                locals.cAD.zw(((fgq)localObject).UGL);
                locals.bMp();
                continue;
                localObject = (ffy)new ffy().parseFrom((byte[])localObject);
                q.d(q.this).w(((ffy)localObject).UGn);
                continue;
                q.g(q.this);
                continue;
                q.b(q.this).setStatus(4);
                q.d(q.this).quit();
              }
            }
          }
        }
      }
    };
    EventCenter.instance.add(new IListener()
    {
      private boolean a(com.tencent.mm.f.a.o paramAnonymouso)
      {
        AppMethodBeat.i(147023);
        if ((paramAnonymouso == null) || (paramAnonymouso.fuU == null) || (paramAnonymouso.fuU.fuX == null))
        {
          AppMethodBeat.o(147023);
          return true;
        }
        long l = System.currentTimeMillis();
        if (q.b(q.this).ocD.cBI == 1) {
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RemoteDebugJsEngine", "NEW_REMOTE_DEBUG_TYPE and do onReceiveNetworkHeader");
        }
        for (;;)
        {
          try
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("api_name", paramAnonymouso.fuU.fuV);
            ((JSONObject)localObject).put("task_id", paramAnonymouso.fuU.fuW);
            ((JSONObject)localObject).put("request_headers", paramAnonymouso.fuU.fuX.toString());
            ((JSONObject)localObject).put("timestamp", l);
            if (q.d(q.this) != null)
            {
              paramAnonymouso = q.d(q.this);
              localObject = ((JSONObject)localObject).toString();
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RemoteDebugMsgMrg", "onReceiveNetworkHeader data:%s", new Object[] { localObject });
              localObject = "typeof DebuggerConnection.onReceiveNetworkHeader === 'function' && DebuggerConnection.onReceiveNetworkHeader('" + com.tencent.mm.plugin.appbrand.utils.t.anl((String)localObject) + "')";
              paramAnonymouso.cAD.ocx.getJsRuntime().evaluateJavascript((String)localObject, null);
            }
            AppMethodBeat.o(147023);
            return true;
          }
          catch (Exception paramAnonymouso)
          {
            com.tencent.mm.sdk.platformtools.Log.printDebugStack("MicroMsg.RemoteDebugJsEngine", "", new Object[] { paramAnonymouso });
            continue;
          }
          Object localObject = new fga();
          ((fga)localObject).fuV = paramAnonymouso.fuU.fuV;
          ((fga)localObject).fuW = paramAnonymouso.fuU.fuW;
          ((fga)localObject).UGo = paramAnonymouso.fuU.fuX.toString();
          ((fga)localObject).timestamp = l;
          paramAnonymouso = x.a((com.tencent.mm.cd.a)localObject, q.b(q.this), "networkDebugAPI");
          q.this.a(paramAnonymouso);
        }
      }
    });
    AppMethodBeat.o(147025);
  }
  
  private void NR()
  {
    AppMethodBeat.i(147032);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "onReady");
    this.cAD.setStatus(3);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
    Iterator localIterator = this.cAD.ocO.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
    }
    this.cAD.ocO.clear();
    this.odd.es(this.cAD.bMb(), 2147483647);
    this.odf.bMA();
    AppMethodBeat.o(147032);
  }
  
  private void bMg()
  {
    AppMethodBeat.i(147035);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
    cce localcce = new cce();
    com.tencent.mm.plugin.appbrand.networking.c localc = (com.tencent.mm.plugin.appbrand.networking.c)this.ode.K(com.tencent.mm.plugin.appbrand.networking.c.class);
    this.ode.getAppId();
    localc.a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", localcce, ccf.class).c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(147035);
  }
  
  private void connect()
  {
    AppMethodBeat.i(147031);
    if (this.odc == null)
    {
      this.odc = new w((com.tencent.mm.plugin.appbrand.s.a)this.ode.au(com.tencent.mm.plugin.appbrand.s.a.class));
      this.odd.a(this.odc, this.cAD, this.odf);
    }
    if (this.cAD.bMf())
    {
      this.odc.a("ws://localhost:" + this.cAD.ocD.ocZ, this.odg);
      AppMethodBeat.o(147031);
      return;
    }
    this.odc.a("wss://wxagame.weixin.qq.com/remote/", this.odg);
    AppMethodBeat.o(147031);
  }
  
  public final <T extends j> T Q(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(147026);
    this.cAD = paramo;
    this.ode = this.cAD.ocx;
    this.mContext = ((Activity)this.ode.getContext());
    this.odf = new y(this.mContext, this.cAD, new y.a()
    {
      public final void bMh()
      {
        AppMethodBeat.i(147014);
        q.this.destroy();
        k.a(q.a(q.this).getAppId(), k.d.ntb);
        if (q.a(q.this).QM() != null) {
          q.a(q.this).QM().finish();
        }
        AppMethodBeat.o(147014);
      }
    });
    this.odf.U(this.ode.QM());
    connect();
    if (Util.isNullOrNil(this.cAD.bMa())) {
      bMg();
    }
    AppMethodBeat.o(147026);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(147034);
    this.odd.a(paramr);
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
  
  public final void af(int paramInt, String paramString)
  {
    AppMethodBeat.i(147033);
    this.odd.af(paramInt, paramString);
    AppMethodBeat.o(147033);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(147030);
    this.odd.quit();
    this.odd.bMq();
    AppMethodBeat.o(147030);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(147027);
    if (this.cAD == null)
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("FATAL");
      }
      AppMethodBeat.o(147027);
      return;
    }
    if (this.cAD.bMd())
    {
      AppMethodBeat.o(147027);
      return;
    }
    if (!this.cAD.isReady())
    {
      this.cAD.ocO.add(new Pair(paramString, paramValueCallback));
      this.odb = null;
      AppMethodBeat.o(147027);
      return;
    }
    Object localObject = new ffw();
    ((ffw)localObject).UGm = this.cAD.ocJ.incrementAndGet();
    ((ffw)localObject).script = paramString;
    r localr = x.a((com.tencent.mm.cd.a)localObject, this.cAD, "evaluateJavascript");
    this.odd.a(localr);
    int i = ((ffw)localObject).UGm;
    localObject = new c();
    if (!Util.isNullOrNil(this.odb))
    {
      ((c)localObject).event = this.odb;
      this.odb = null;
    }
    for (;;)
    {
      ((c)localObject).oco = System.currentTimeMillis();
      ((c)localObject).size = paramString.length();
      ((c)localObject).ocn = paramValueCallback;
      this.cAD.ocS.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(147027);
      return;
      ((c)localObject).event = t.afJ(paramString);
    }
  }
  
  public final void setJsExceptionHandler(com.tencent.mm.plugin.appbrand.m.h paramh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.q
 * JD-Core Version:    0.7.0.1
 */