package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.nr.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.luggage.h.a;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

public class av
  extends IListener<nr>
{
  private static volatile String edo;
  private static volatile long xHQ;
  private static volatile long xHR;
  private static Set<String> xHS;
  private static Set<String> xHT;
  private long xHU;
  private b xHV;
  
  static
  {
    AppMethodBeat.i(41650);
    xHS = new HashSet();
    xHT = new HashSet();
    AppMethodBeat.o(41650);
  }
  
  public av()
  {
    AppMethodBeat.i(161130);
    this.__eventId = nr.class.getName().hashCode();
    AppMethodBeat.o(161130);
  }
  
  private static void a(final Bundle paramBundle, boolean paramBoolean, final com.tencent.mm.ipcinvoker.d paramd)
  {
    for (;;)
    {
      String str1;
      String str2;
      final GameWebPerformanceInfo localGameWebPerformanceInfo;
      try
      {
        AppMethodBeat.i(41643);
        Log.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore, preload: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        boolean bool = paramBundle.getBoolean("is_luggage", false);
        str1 = paramBundle.getString("call_raw_url");
        str2 = paramBundle.getString("float_layer_url");
        localGameWebPerformanceInfo = GameWebPerformanceInfo.Fd(str1);
        if (!bool) {
          break label281;
        }
        com.tencent.luggage.d.p localp = com.tencent.mm.plugin.game.luggage.h.azD(str1);
        if (localp != null)
        {
          if (paramBoolean)
          {
            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
            paramBundle.putBoolean("has_preload_webcore", true);
            a(paramd, paramBundle);
            AppMethodBeat.o(41643);
            return;
          }
          com.tencent.mm.ipcinvoker.p.y(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41633);
              ((com.tencent.mm.plugin.game.luggage.g.h)this.xwm.LG()).onResume();
              ((com.tencent.mm.plugin.game.luggage.g.h)this.xwm.LG()).setBlockNetworkImage(false);
              AppMethodBeat.o(41633);
            }
          });
          com.tencent.mm.plugin.game.luggage.g.a(localp, str1);
          continue;
        }
        if (!paramBoolean) {
          break label256;
        }
      }
      finally {}
      if (localGameWebPerformanceInfo.hhF != 0L)
      {
        paramd.bn(paramBundle);
        AppMethodBeat.o(41643);
      }
      else if (!aAm(str1))
      {
        Log.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
        GameWebPerformanceInfo.Ff(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
      }
      else
      {
        aAm(str2);
        localGameWebPerformanceInfo.hhx = 1;
        localGameWebPerformanceInfo.hhI = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.CyF.n(939L, 0L, 1L);
        com.tencent.mm.plugin.game.luggage.h.a(i.class, str1, new h.a()
        {
          public final void callback()
          {
            AppMethodBeat.i(41635);
            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            com.tencent.mm.ipcinvoker.p.y(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(41634);
                com.tencent.luggage.d.p localp = com.tencent.mm.plugin.game.luggage.h.azD(av.7.this.xIa);
                if (localp != null)
                {
                  ((com.tencent.mm.plugin.game.luggage.g.h)localp.LG()).setBlockNetworkImage(true);
                  ((com.tencent.mm.plugin.game.luggage.g.h)localp.LG()).onPause();
                }
                av.7.this.xwl.hhJ = System.currentTimeMillis();
                av.b(av.7.this.xIb, av.7.this.doj);
                AppMethodBeat.o(41634);
              }
            });
            AppMethodBeat.o(41635);
          }
        });
        AppMethodBeat.o(41643);
        continue;
        label256:
        aAm(str2);
        aAm(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
        continue;
        label281:
        aAm(str2);
        aAm(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
      }
    }
  }
  
  private void a(final nr paramnr, Bundle paramBundle)
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(41642);
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
      MMHandlerThread.removeRunnable(this.xHV);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41631);
          Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", new Object[] { Integer.valueOf(1000), av.edo });
          av.aAn("");
          AppMethodBeat.o(41631);
        }
      }, 1000L);
      if (paramnr == null) {
        AppMethodBeat.o(41642);
      }
      for (;;)
      {
        return;
        if (Util.isNullOrNil(paramnr.dTO.group)) {
          break label125;
        }
        if (!xHS.contains(paramnr.dTO.group)) {
          break;
        }
        xHS.remove(paramnr.dTO.group);
        AppMethodBeat.o(41642);
      }
      xHS.add(paramnr.dTO.group);
    }
    finally {}
    label125:
    final Context localContext;
    label144:
    String str;
    if (paramnr.dTO.context != null)
    {
      localContext = paramnr.dTO.context;
      if (paramnr.dTO.intent == null) {
        paramnr.dTO.intent = new Intent();
      }
      str = paramnr.dTO.intent.getStringExtra("rawUrl");
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
      paramnr.dTO.intent.putExtra("start_activity_time", System.currentTimeMillis());
      switch (paramnr.dTO.type)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        long l = System.currentTimeMillis() - xHQ;
        Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[] { Long.valueOf(l) });
        try
        {
          paramnr.dTO.context = null;
          label293:
          com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.wepkg.utils.d.bcO(str), null, -1L, l, null);
          AppMethodBeat.o(41642);
          break;
          localContext = MMApplicationContext.getContext();
          break label144;
          c.b(localContext, "webview", ".ui.tools.WebViewUI", paramnr.dTO.intent);
          continue;
          c.b(localContext, "webview", ".ui.tools.TransparentWebViewUI", paramnr.dTO.intent);
          continue;
          if (paramBundle != null) {
            bool = paramBundle.getBoolean("has_preload_webcore", false);
          }
          paramBundle = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41632);
              c.b(localContext, "webview", ".ui.tools.WebViewUI", paramnr.dTO.intent);
              AppMethodBeat.o(41632);
            }
          };
          if (bool) {}
          for (l = 100L;; l = 0L)
          {
            com.tencent.mm.ipcinvoker.p.postDelayed(paramBundle, l);
            break;
          }
        }
        catch (Exception paramnr)
        {
          break label293;
        }
      }
    }
  }
  
  private static void a(com.tencent.mm.ipcinvoker.d paramd, Bundle paramBundle)
  {
    AppMethodBeat.i(41645);
    if (paramd != null) {
      paramd.bn(paramBundle);
    }
    AppMethodBeat.o(41645);
  }
  
  private boolean a(final nr paramnr)
  {
    AppMethodBeat.i(41641);
    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", new Object[] { Integer.valueOf(paramnr.dTO.type) });
    if (paramnr.dTO.intent == null)
    {
      AppMethodBeat.o(41641);
      return false;
    }
    if (paramnr.dTO.type == 3)
    {
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.xHU), Long.valueOf(this.xHU) });
      if (System.currentTimeMillis() - this.xHU < 500L)
      {
        Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
        AppMethodBeat.o(41641);
        return false;
      }
    }
    this.xHU = System.currentTimeMillis();
    switch (paramnr.dTO.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41641);
      return false;
      int i = paramnr.dTO.type;
      int j = hashCode();
      int k = paramnr.hashCode();
      long l = Thread.currentThread().getId();
      boolean bool;
      label222:
      Object localObject1;
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        bool = true;
        Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l), Boolean.valueOf(bool) });
        localObject1 = "";
      }
      try
      {
        str = paramnr.dTO.intent.getStringExtra("rawUrl");
        localObject1 = str;
      }
      catch (Exception localException)
      {
        String str;
        label296:
        break label296;
      }
      str = paramnr.dTO.intent.getStringExtra("game_float_layer_url");
      try
      {
        if (Util.nullAsNil(edo).equalsIgnoreCase((String)localObject1))
        {
          Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
          return false;
          bool = false;
          break label222;
        }
        edo = (String)localObject1;
        xHQ = System.currentTimeMillis();
        xHR = System.currentTimeMillis();
        if (com.tencent.mm.plugin.wepkg.utils.d.bcR((String)localObject1))
        {
          Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.bcO((String)localObject1) });
          Object localObject2 = com.tencent.mm.b.g.getMessageDigest(Util.nullAsNil((String)localObject1).getBytes()) + "_" + System.currentTimeMillis();
          paramnr.dTO.group = ((String)localObject2);
          this.xHV = new b(paramnr);
          MMHandlerThread.postToMainThreadDelayed(this.xHV, 500L);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("call_raw_url", (String)localObject1);
          if (!Util.isNullOrNil(str)) {
            ((Bundle)localObject2).putString("float_layer_url", str);
          }
          if (paramnr.dTO.type == 2) {
            ((Bundle)localObject2).putBoolean("is_luggage", true);
          }
          com.tencent.mm.plugin.game.luggage.b.b((Parcelable)localObject2, a.class, new com.tencent.mm.ipcinvoker.d() {});
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(41641);
      }
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page.");
      a(paramnr, null);
      continue;
      paramnr = paramnr.dTO.intent.getStringExtra("rawUrl");
      if ((!xHT.contains(paramnr)) && (com.tencent.mm.plugin.wepkg.utils.d.bcR(paramnr)))
      {
        xHT.add(paramnr);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("call_raw_url", paramnr);
        ((Bundle)localObject1).putBoolean("preload_webcore", true);
        ((Bundle)localObject1).putBoolean("is_luggage", true);
        com.tencent.mm.plugin.game.luggage.b.b((Parcelable)localObject1, a.class, new com.tencent.mm.ipcinvoker.d() {});
        com.tencent.mm.ipcinvoker.p.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41630);
            if (av.byX().contains(paramnr))
            {
              Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
              av.byX().remove(paramnr);
              com.tencent.mm.plugin.report.service.h.CyF.n(939L, 3L, 1L);
            }
            AppMethodBeat.o(41630);
          }
        }, 10000L);
      }
    }
  }
  
  private static boolean aAm(String paramString)
  {
    AppMethodBeat.i(41644);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.wepkg.utils.d.bcR(paramString)))
    {
      AppMethodBeat.o(41644);
      return false;
    }
    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", new Object[] { paramString });
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.Fd(paramString);
    localGameWebPerformanceInfo.hhG = System.currentTimeMillis();
    paramString = com.tencent.mm.plugin.wepkg.d.bcd(paramString);
    localGameWebPerformanceInfo.hhH = System.currentTimeMillis();
    if ((paramString != null) && (paramString.dTL()))
    {
      AppMethodBeat.o(41644);
      return true;
    }
    AppMethodBeat.o(41644);
    return false;
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  final class b
    implements Runnable
  {
    private final nr xIg;
    
    public b(nr paramnr)
    {
      this.xIg = paramnr;
    }
    
    public final void run()
    {
      AppMethodBeat.i(41640);
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
      av.a(av.this, this.xIg, null);
      com.tencent.mm.plugin.report.service.h.CyF.n(939L, 2L, 1L);
      AppMethodBeat.o(41640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.av
 * JD-Core Version:    0.7.0.1
 */