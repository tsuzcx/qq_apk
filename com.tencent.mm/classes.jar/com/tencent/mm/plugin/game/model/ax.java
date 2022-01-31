package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.luggage.e.k;
import com.tencent.mm.a.g;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.h.a.kp;
import com.tencent.mm.h.a.kp.a;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.plugin.game.luggage.i.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;

public class ax
  extends com.tencent.mm.sdk.b.c<kp>
{
  private static volatile String caS;
  private static volatile long kRk;
  private static volatile long kRl;
  private static Set<String> kRm = new HashSet();
  private static Set<String> kRn = new HashSet();
  private long kRo;
  private ax.b wuz;
  
  public ax()
  {
    this.udX = kp.class.getName().hashCode();
  }
  
  private static void a(final Bundle paramBundle, boolean paramBoolean, final com.tencent.mm.ipcinvoker.c paramc)
  {
    for (;;)
    {
      String str;
      final GameWebPerformanceInfo localGameWebPerformanceInfo;
      Object localObject;
      try
      {
        y.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore, preload: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        boolean bool = paramBundle.getBoolean("is_luggage", false);
        str = paramBundle.getString("call_raw_url");
        localGameWebPerformanceInfo = GameWebPerformanceInfo.fv(str);
        if (!bool) {
          break label268;
        }
        localObject = i.EI(str);
        if (localObject != null)
        {
          if (paramBoolean)
          {
            y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
            paramBundle.putBoolean("has_preload_webcore", true);
            a(paramc, paramBundle);
            return;
          }
          l.m(new ax.6((com.tencent.mm.plugin.game.luggage.h)localObject));
          ((com.tencent.mm.plugin.game.luggage.h)localObject).aG(str, true);
          continue;
        }
        if (!paramBoolean) {
          break label238;
        }
      }
      finally {}
      if (localGameWebPerformanceInfo.dCF != 0L)
      {
        paramc.U(paramBundle);
      }
      else
      {
        localGameWebPerformanceInfo.dCG = System.currentTimeMillis();
        localObject = com.tencent.mm.plugin.wepkg.b.UM(str);
        localGameWebPerformanceInfo.dCH = System.currentTimeMillis();
        if (localObject == null)
        {
          y.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
          GameWebPerformanceInfo.fw(str);
          a(paramc, paramBundle);
        }
        else
        {
          localGameWebPerformanceInfo.dCC = 1;
          localGameWebPerformanceInfo.dCI = System.currentTimeMillis();
          com.tencent.mm.plugin.report.service.h.nFQ.h(939L, 0L, 1L);
          i.a(com.tencent.mm.plugin.game.luggage.c.class, str, new i.a()
          {
            public final void pQ()
            {
              y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
              l.m(new Runnable()
              {
                public final void run()
                {
                  com.tencent.mm.plugin.game.luggage.h localh = i.EI(ax.7.this.kRu);
                  if (localh != null)
                  {
                    ((com.tencent.mm.plugin.game.luggage.c)localh.qp()).setBlockNetworkImage(true);
                    ((com.tencent.mm.plugin.game.luggage.c)localh.qp()).onPause();
                  }
                  ax.7.this.kMV.dCJ = System.currentTimeMillis();
                  ax.b(ax.7.this.kRv, ax.7.this.byv);
                }
              });
            }
          });
          continue;
          label238:
          localGameWebPerformanceInfo.dCG = System.currentTimeMillis();
          com.tencent.mm.plugin.wepkg.b.UM(str);
          localGameWebPerformanceInfo.dCH = System.currentTimeMillis();
          a(paramc, paramBundle);
          continue;
          label268:
          localGameWebPerformanceInfo.dCG = System.currentTimeMillis();
          com.tencent.mm.plugin.wepkg.b.UM(str);
          localGameWebPerformanceInfo.dCH = System.currentTimeMillis();
          a(paramc, paramBundle);
        }
      }
    }
  }
  
  private void a(final kp paramkp, Bundle paramBundle)
  {
    boolean bool = false;
    try
    {
      y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
      ai.S(this.wuz);
      ai.l(new ax.4(this), 1000L);
      if (paramkp == null) {}
      for (;;)
      {
        return;
        if (bk.bl(paramkp.bTG.group)) {
          break label110;
        }
        if (!kRm.contains(paramkp.bTG.group)) {
          break;
        }
        kRm.remove(paramkp.bTG.group);
      }
      kRm.add(paramkp.bTG.group);
    }
    finally {}
    label110:
    final Context localContext;
    label129:
    String str;
    if (paramkp.bTG.context != null)
    {
      localContext = paramkp.bTG.context;
      if (paramkp.bTG.intent == null) {
        paramkp.bTG.intent = new Intent();
      }
      str = paramkp.bTG.intent.getStringExtra("rawUrl");
      switch (paramkp.bTG.type)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        long l = System.currentTimeMillis() - kRk;
        y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[] { Long.valueOf(l) });
        try
        {
          paramkp.bTG.context = null;
          label237:
          com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.wepkg.utils.d.Vq(str), null, -1L, l, null);
          break;
          localContext = ae.getContext();
          break label129;
          com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.game.GameWebViewUI", paramkp.bTG.intent);
          continue;
          com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.TransparentWebViewUI", paramkp.bTG.intent);
          continue;
          paramkp.bTG.intent.putExtra("start_activity_time", System.currentTimeMillis());
          if (paramBundle != null) {
            bool = paramBundle.getBoolean("has_preload_webcore", false);
          }
          paramBundle = new Runnable()
          {
            public final void run()
            {
              com.tencent.mm.br.d.b(localContext, "game", ".luggage.LuggageGameWebViewUI", paramkp.bTG.intent);
            }
          };
          if (bool) {}
          for (l = 100L;; l = 0L)
          {
            l.postDelayed(paramBundle, l);
            break;
          }
        }
        catch (Exception paramkp)
        {
          break label237;
        }
      }
    }
  }
  
  private static void a(com.tencent.mm.ipcinvoker.c paramc, Bundle paramBundle)
  {
    if (paramc != null) {
      paramc.U(paramBundle);
    }
  }
  
  private boolean a(kp paramkp)
  {
    y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", new Object[] { Integer.valueOf(paramkp.bTG.type) });
    if (paramkp.bTG.type == 3)
    {
      y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.kRo), Long.valueOf(this.kRo) });
      if (System.currentTimeMillis() - this.kRo < 500L) {
        y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
      }
    }
    label258:
    do
    {
      return false;
      this.kRo = System.currentTimeMillis();
      switch (paramkp.bTG.type)
      {
      default: 
        return false;
      case 0: 
      case 1: 
      case 2: 
        int i = paramkp.bTG.type;
        int j = hashCode();
        int k = paramkp.hashCode();
        long l = Thread.currentThread().getId();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {}
        for (boolean bool = true;; bool = false)
        {
          y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l), Boolean.valueOf(bool) });
          localObject1 = "";
          try
          {
            localObject2 = paramkp.bTG.intent.getStringExtra("rawUrl");
            localObject1 = localObject2;
          }
          catch (Exception localException)
          {
            Object localObject2;
            break label258;
          }
          try
          {
            if (!bk.pm(caS).equalsIgnoreCase((String)localObject1)) {
              break;
            }
            y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
            return false;
          }
          finally {}
        }
        caS = (String)localObject1;
        kRk = System.currentTimeMillis();
        kRl = System.currentTimeMillis();
        if (ae.cqV()) {
          com.tencent.mm.plugin.wepkg.utils.b.rQh = com.tencent.mm.plugin.game.commlib.a.aYo();
        }
        if (com.tencent.mm.plugin.wepkg.utils.d.Vt((String)localObject1))
        {
          y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.Vq((String)localObject1) });
          localObject2 = g.o(bk.pm((String)localObject1).getBytes()) + "_" + System.currentTimeMillis();
          paramkp.bTG.group = ((String)localObject2);
          this.wuz = new ax.b(this, paramkp);
          ai.l(this.wuz, 500L);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("is_wepkg_disable", com.tencent.mm.plugin.wepkg.utils.b.rQh);
          ((Bundle)localObject2).putString("call_raw_url", (String)localObject1);
          if (paramkp.bTG.type == 2) {
            ((Bundle)localObject2).putBoolean("is_luggage", true);
          }
          ToolsProcessIPCService.a((Parcelable)localObject2, ax.a.class, new ax.1(this, paramkp));
          return false;
        }
        y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + com.tencent.mm.plugin.wepkg.utils.b.rQh);
        a(paramkp, null);
        return false;
      case 3: 
        paramkp = paramkp.bTG.intent.getStringExtra("rawUrl");
      }
    } while ((kRn.contains(paramkp)) || (!com.tencent.mm.plugin.wepkg.utils.d.Vt(paramkp)));
    kRn.add(paramkp);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("call_raw_url", paramkp);
    ((Bundle)localObject1).putBoolean("preload_webcore", true);
    ((Bundle)localObject1).putBoolean("is_luggage", true);
    ToolsProcessIPCService.a((Parcelable)localObject1, ax.a.class, new ax.2(this, paramkp));
    l.postDelayed(new ax.3(this, paramkp), 10000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ax
 * JD-Core Version:    0.7.0.1
 */