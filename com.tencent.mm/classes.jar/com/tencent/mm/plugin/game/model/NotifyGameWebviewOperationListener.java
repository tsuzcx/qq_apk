package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.py;
import com.tencent.mm.autogen.a.py.a;
import com.tencent.mm.br.c;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.plugin.game.luggage.b;
import com.tencent.mm.plugin.game.luggage.h.a;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.plugin.wepkg.e;
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

public class NotifyGameWebviewOperationListener
  extends IListener<py>
{
  private static volatile long IGa;
  private static volatile long IGb;
  private static Set<String> IGc;
  private static Set<String> IGd;
  private static volatile String idu;
  private long IGe;
  private b IGf;
  
  static
  {
    AppMethodBeat.i(41650);
    IGc = new HashSet();
    IGd = new HashSet();
    AppMethodBeat.o(41650);
  }
  
  public NotifyGameWebviewOperationListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161130);
    this.__eventId = py.class.getName().hashCode();
    AppMethodBeat.o(161130);
  }
  
  private static void a(final Bundle paramBundle, boolean paramBoolean, final com.tencent.mm.ipcinvoker.f paramf)
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
        localGameWebPerformanceInfo = GameWebPerformanceInfo.EI(str1);
        if (!bool) {
          break label281;
        }
        p localp = com.tencent.mm.plugin.game.luggage.h.aFZ(str1);
        if (localp != null)
        {
          if (paramBoolean)
          {
            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
            paramBundle.putBoolean("has_preload_webcore", true);
            a(paramf, paramBundle);
            AppMethodBeat.o(41643);
            return;
          }
          s.D(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41633);
              ((com.tencent.mm.plugin.game.luggage.page.h)NotifyGameWebviewOperationListener.this.aoE()).onResume();
              ((com.tencent.mm.plugin.game.luggage.page.h)NotifyGameWebviewOperationListener.this.aoE()).setBlockNetworkImage(false);
              AppMethodBeat.o(41633);
            }
          });
          com.tencent.mm.plugin.game.luggage.g.b(localp, str1);
          continue;
        }
        if (!paramBoolean) {
          break label256;
        }
      }
      finally {}
      if (localGameWebPerformanceInfo.mtV != 0L)
      {
        paramf.onCallback(paramBundle);
        AppMethodBeat.o(41643);
      }
      else if (!aGO(str1))
      {
        Log.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
        GameWebPerformanceInfo.EK(str1);
        a(paramf, paramBundle);
        AppMethodBeat.o(41643);
      }
      else
      {
        aGO(str2);
        localGameWebPerformanceInfo.mtN = 1;
        localGameWebPerformanceInfo.mtY = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.OAn.p(939L, 0L, 1L);
        com.tencent.mm.plugin.game.luggage.h.a(i.class, str1, new h.a()
        {
          public final void callback()
          {
            AppMethodBeat.i(41635);
            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            s.D(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(41634);
                p localp = com.tencent.mm.plugin.game.luggage.h.aFZ(NotifyGameWebviewOperationListener.this);
                if (localp != null)
                {
                  ((com.tencent.mm.plugin.game.luggage.page.h)localp.aoE()).setBlockNetworkImage(true);
                  ((com.tencent.mm.plugin.game.luggage.page.h)localp.aoE()).onPause();
                }
                NotifyGameWebviewOperationListener.7.this.ItQ.mtZ = System.currentTimeMillis();
                NotifyGameWebviewOperationListener.b(NotifyGameWebviewOperationListener.7.this.IGl, NotifyGameWebviewOperationListener.7.this.hkZ);
                AppMethodBeat.o(41634);
              }
            });
            AppMethodBeat.o(41635);
          }
        });
        AppMethodBeat.o(41643);
        continue;
        label256:
        aGO(str2);
        aGO(str1);
        a(paramf, paramBundle);
        AppMethodBeat.o(41643);
        continue;
        label281:
        aGO(str2);
        aGO(str1);
        a(paramf, paramBundle);
        AppMethodBeat.o(41643);
      }
    }
  }
  
  private void a(final py parampy, Bundle paramBundle)
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(41642);
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
      MMHandlerThread.removeRunnable(this.IGf);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41631);
          Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", new Object[] { Integer.valueOf(1000), NotifyGameWebviewOperationListener.idu });
          NotifyGameWebviewOperationListener.aGP("");
          AppMethodBeat.o(41631);
        }
      }, 1000L);
      if (parampy == null) {
        AppMethodBeat.o(41642);
      }
      for (;;)
      {
        return;
        if (Util.isNullOrNil(parampy.hTd.group)) {
          break label125;
        }
        if (!IGc.contains(parampy.hTd.group)) {
          break;
        }
        IGc.remove(parampy.hTd.group);
        AppMethodBeat.o(41642);
      }
      IGc.add(parampy.hTd.group);
    }
    finally {}
    label125:
    final Context localContext;
    label144:
    String str;
    if (parampy.hTd.context != null)
    {
      localContext = parampy.hTd.context;
      if (parampy.hTd.intent == null) {
        parampy.hTd.intent = new Intent();
      }
      str = parampy.hTd.intent.getStringExtra("rawUrl");
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
      parampy.hTd.intent.putExtra("start_activity_time", System.currentTimeMillis());
      switch (parampy.hTd.type)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        long l = System.currentTimeMillis() - IGa;
        Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[] { Long.valueOf(l) });
        try
        {
          parampy.hTd.context = null;
          label293:
          com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.wepkg.utils.d.boB(str), null, -1L, l, null);
          AppMethodBeat.o(41642);
          break;
          localContext = MMApplicationContext.getContext();
          break label144;
          c.b(localContext, "webview", ".ui.tools.WebViewUI", parampy.hTd.intent);
          continue;
          c.b(localContext, "webview", ".ui.tools.TransparentWebViewUI", parampy.hTd.intent);
          continue;
          if (paramBundle != null) {
            bool = paramBundle.getBoolean("has_preload_webcore", false);
          }
          paramBundle = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41632);
              c.b(localContext, "webview", ".ui.tools.WebViewUI", parampy.hTd.intent);
              AppMethodBeat.o(41632);
            }
          };
          if (bool) {}
          for (l = 100L;; l = 0L)
          {
            s.postDelayed(paramBundle, l);
            break;
          }
        }
        catch (Exception parampy)
        {
          break label293;
        }
      }
    }
  }
  
  private static void a(com.tencent.mm.ipcinvoker.f paramf, Bundle paramBundle)
  {
    AppMethodBeat.i(41645);
    if (paramf != null) {
      paramf.onCallback(paramBundle);
    }
    AppMethodBeat.o(41645);
  }
  
  private boolean a(final py parampy)
  {
    AppMethodBeat.i(41641);
    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", new Object[] { Integer.valueOf(parampy.hTd.type) });
    if (parampy.hTd.intent == null)
    {
      AppMethodBeat.o(41641);
      return false;
    }
    if (parampy.hTd.type == 3)
    {
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.IGe), Long.valueOf(this.IGe) });
      if (System.currentTimeMillis() - this.IGe < 500L)
      {
        Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
        AppMethodBeat.o(41641);
        return false;
      }
    }
    this.IGe = System.currentTimeMillis();
    switch (parampy.hTd.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41641);
      return false;
      int i = parampy.hTd.type;
      int j = hashCode();
      int k = parampy.hashCode();
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
        str = parampy.hTd.intent.getStringExtra("rawUrl");
        localObject1 = str;
      }
      catch (Exception localException)
      {
        String str;
        label296:
        break label296;
      }
      str = parampy.hTd.intent.getStringExtra("game_float_layer_url");
      try
      {
        if (Util.nullAsNil(idu).equalsIgnoreCase((String)localObject1))
        {
          Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
          return false;
          bool = false;
          break label222;
        }
        idu = (String)localObject1;
        IGa = System.currentTimeMillis();
        IGb = System.currentTimeMillis();
        if (com.tencent.mm.plugin.wepkg.utils.d.boE((String)localObject1))
        {
          Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.boB((String)localObject1) });
          Object localObject2 = com.tencent.mm.b.g.getMessageDigest(Util.nullAsNil((String)localObject1).getBytes()) + "_" + System.currentTimeMillis();
          parampy.hTd.group = ((String)localObject2);
          this.IGf = new b(parampy);
          MMHandlerThread.postToMainThreadDelayed(this.IGf, 500L);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("call_raw_url", (String)localObject1);
          if (!Util.isNullOrNil(str)) {
            ((Bundle)localObject2).putString("float_layer_url", str);
          }
          if (parampy.hTd.type == 2) {
            ((Bundle)localObject2).putBoolean("is_luggage", true);
          }
          b.b((Parcelable)localObject2, a.class, new com.tencent.mm.ipcinvoker.f() {});
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(41641);
      }
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page.");
      a(parampy, null);
      continue;
      parampy = parampy.hTd.intent.getStringExtra("rawUrl");
      if ((!IGd.contains(parampy)) && (com.tencent.mm.plugin.wepkg.utils.d.boE(parampy)))
      {
        IGd.add(parampy);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("call_raw_url", parampy);
        ((Bundle)localObject1).putBoolean("preload_webcore", true);
        ((Bundle)localObject1).putBoolean("is_luggage", true);
        b.b((Parcelable)localObject1, a.class, new com.tencent.mm.ipcinvoker.f() {});
        s.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41630);
            if (NotifyGameWebviewOperationListener.cjM().contains(parampy))
            {
              Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
              NotifyGameWebviewOperationListener.cjM().remove(parampy);
              com.tencent.mm.plugin.report.service.h.OAn.p(939L, 3L, 1L);
            }
            AppMethodBeat.o(41630);
          }
        }, 10000L);
      }
    }
  }
  
  private static boolean aGO(String paramString)
  {
    AppMethodBeat.i(41644);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.wepkg.utils.d.boE(paramString)))
    {
      AppMethodBeat.o(41644);
      return false;
    }
    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", new Object[] { paramString });
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.EI(paramString);
    localGameWebPerformanceInfo.mtW = System.currentTimeMillis();
    paramString = e.bnR(paramString);
    localGameWebPerformanceInfo.mtX = System.currentTimeMillis();
    if ((paramString != null) && (paramString.fEO()))
    {
      AppMethodBeat.o(41644);
      return true;
    }
    AppMethodBeat.o(41644);
    return false;
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  final class b
    implements Runnable
  {
    private final py IGq;
    
    public b(py parampy)
    {
      this.IGq = parampy;
    }
    
    public final void run()
    {
      AppMethodBeat.i(41640);
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
      NotifyGameWebviewOperationListener.a(NotifyGameWebviewOperationListener.this, this.IGq, null);
      com.tencent.mm.plugin.report.service.h.OAn.p(939L, 2L, 1L);
      AppMethodBeat.o(41640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.NotifyGameWebviewOperationListener
 * JD-Core Version:    0.7.0.1
 */