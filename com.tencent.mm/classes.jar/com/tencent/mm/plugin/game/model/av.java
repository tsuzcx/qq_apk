package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.oo;
import com.tencent.mm.f.a.oo.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.f;
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

public class av
  extends IListener<oo>
{
  private static volatile long CLU;
  private static volatile long CLV;
  private static Set<String> CLW;
  private static Set<String> CLX;
  private static volatile String fXu;
  private long CLY;
  private b CLZ;
  
  static
  {
    AppMethodBeat.i(41650);
    CLW = new HashSet();
    CLX = new HashSet();
    AppMethodBeat.o(41650);
  }
  
  public av()
  {
    AppMethodBeat.i(161130);
    this.__eventId = oo.class.getName().hashCode();
    AppMethodBeat.o(161130);
  }
  
  private static void a(final Bundle paramBundle, boolean paramBoolean, final f paramf)
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
        localGameWebPerformanceInfo = GameWebPerformanceInfo.LZ(str1);
        if (!bool) {
          break label281;
        }
        p localp = com.tencent.mm.plugin.game.luggage.h.aJn(str1);
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
          s.y(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41633);
              ((com.tencent.mm.plugin.game.luggage.g.h)this.CAh.Ow()).onResume();
              ((com.tencent.mm.plugin.game.luggage.g.h)this.CAh.Ow()).setBlockNetworkImage(false);
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
      if (localGameWebPerformanceInfo.jTD != 0L)
      {
        paramf.aH(paramBundle);
        AppMethodBeat.o(41643);
      }
      else if (!aJY(str1))
      {
        Log.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
        GameWebPerformanceInfo.Mb(str1);
        a(paramf, paramBundle);
        AppMethodBeat.o(41643);
      }
      else
      {
        aJY(str2);
        localGameWebPerformanceInfo.jTv = 1;
        localGameWebPerformanceInfo.jTG = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.IzE.p(939L, 0L, 1L);
        com.tencent.mm.plugin.game.luggage.h.a(i.class, str1, new h.a()
        {
          public final void callback()
          {
            AppMethodBeat.i(41635);
            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            s.y(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(41634);
                p localp = com.tencent.mm.plugin.game.luggage.h.aJn(av.7.this.CMe);
                if (localp != null)
                {
                  ((com.tencent.mm.plugin.game.luggage.g.h)localp.Ow()).setBlockNetworkImage(true);
                  ((com.tencent.mm.plugin.game.luggage.g.h)localp.Ow()).onPause();
                }
                av.7.this.CAg.jTH = System.currentTimeMillis();
                av.b(av.7.this.CMf, av.7.this.fgO);
                AppMethodBeat.o(41634);
              }
            });
            AppMethodBeat.o(41635);
          }
        });
        AppMethodBeat.o(41643);
        continue;
        label256:
        aJY(str2);
        aJY(str1);
        a(paramf, paramBundle);
        AppMethodBeat.o(41643);
        continue;
        label281:
        aJY(str2);
        aJY(str1);
        a(paramf, paramBundle);
        AppMethodBeat.o(41643);
      }
    }
  }
  
  private void a(final oo paramoo, Bundle paramBundle)
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(41642);
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
      MMHandlerThread.removeRunnable(this.CLZ);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41631);
          Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", new Object[] { Integer.valueOf(1000), av.fXu });
          av.aJZ("");
          AppMethodBeat.o(41631);
        }
      }, 1000L);
      if (paramoo == null) {
        AppMethodBeat.o(41642);
      }
      for (;;)
      {
        return;
        if (Util.isNullOrNil(paramoo.fNq.group)) {
          break label125;
        }
        if (!CLW.contains(paramoo.fNq.group)) {
          break;
        }
        CLW.remove(paramoo.fNq.group);
        AppMethodBeat.o(41642);
      }
      CLW.add(paramoo.fNq.group);
    }
    finally {}
    label125:
    final Context localContext;
    label144:
    String str;
    if (paramoo.fNq.context != null)
    {
      localContext = paramoo.fNq.context;
      if (paramoo.fNq.intent == null) {
        paramoo.fNq.intent = new Intent();
      }
      str = paramoo.fNq.intent.getStringExtra("rawUrl");
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
      paramoo.fNq.intent.putExtra("start_activity_time", System.currentTimeMillis());
      switch (paramoo.fNq.type)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        long l = System.currentTimeMillis() - CLU;
        Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[] { Long.valueOf(l) });
        try
        {
          paramoo.fNq.context = null;
          label293:
          com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.wepkg.utils.d.boN(str), null, -1L, l, null);
          AppMethodBeat.o(41642);
          break;
          localContext = MMApplicationContext.getContext();
          break label144;
          c.b(localContext, "webview", ".ui.tools.WebViewUI", paramoo.fNq.intent);
          continue;
          c.b(localContext, "webview", ".ui.tools.TransparentWebViewUI", paramoo.fNq.intent);
          continue;
          if (paramBundle != null) {
            bool = paramBundle.getBoolean("has_preload_webcore", false);
          }
          paramBundle = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41632);
              c.b(localContext, "webview", ".ui.tools.WebViewUI", paramoo.fNq.intent);
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
        catch (Exception paramoo)
        {
          break label293;
        }
      }
    }
  }
  
  private static void a(f paramf, Bundle paramBundle)
  {
    AppMethodBeat.i(41645);
    if (paramf != null) {
      paramf.aH(paramBundle);
    }
    AppMethodBeat.o(41645);
  }
  
  private boolean a(final oo paramoo)
  {
    AppMethodBeat.i(41641);
    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", new Object[] { Integer.valueOf(paramoo.fNq.type) });
    if (paramoo.fNq.intent == null)
    {
      AppMethodBeat.o(41641);
      return false;
    }
    if (paramoo.fNq.type == 3)
    {
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.CLY), Long.valueOf(this.CLY) });
      if (System.currentTimeMillis() - this.CLY < 500L)
      {
        Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
        AppMethodBeat.o(41641);
        return false;
      }
    }
    this.CLY = System.currentTimeMillis();
    switch (paramoo.fNq.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41641);
      return false;
      int i = paramoo.fNq.type;
      int j = hashCode();
      int k = paramoo.hashCode();
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
        str = paramoo.fNq.intent.getStringExtra("rawUrl");
        localObject1 = str;
      }
      catch (Exception localException)
      {
        String str;
        label296:
        break label296;
      }
      str = paramoo.fNq.intent.getStringExtra("game_float_layer_url");
      try
      {
        if (Util.nullAsNil(fXu).equalsIgnoreCase((String)localObject1))
        {
          Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
          return false;
          bool = false;
          break label222;
        }
        fXu = (String)localObject1;
        CLU = System.currentTimeMillis();
        CLV = System.currentTimeMillis();
        if (com.tencent.mm.plugin.wepkg.utils.d.boQ((String)localObject1))
        {
          Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.boN((String)localObject1) });
          Object localObject2 = com.tencent.mm.b.g.getMessageDigest(Util.nullAsNil((String)localObject1).getBytes()) + "_" + System.currentTimeMillis();
          paramoo.fNq.group = ((String)localObject2);
          this.CLZ = new b(paramoo);
          MMHandlerThread.postToMainThreadDelayed(this.CLZ, 500L);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("call_raw_url", (String)localObject1);
          if (!Util.isNullOrNil(str)) {
            ((Bundle)localObject2).putString("float_layer_url", str);
          }
          if (paramoo.fNq.type == 2) {
            ((Bundle)localObject2).putBoolean("is_luggage", true);
          }
          b.b((Parcelable)localObject2, a.class, new f() {});
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(41641);
      }
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page.");
      a(paramoo, null);
      continue;
      paramoo = paramoo.fNq.intent.getStringExtra("rawUrl");
      if ((!CLX.contains(paramoo)) && (com.tencent.mm.plugin.wepkg.utils.d.boQ(paramoo)))
      {
        CLX.add(paramoo);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("call_raw_url", paramoo);
        ((Bundle)localObject1).putBoolean("preload_webcore", true);
        ((Bundle)localObject1).putBoolean("is_luggage", true);
        b.b((Parcelable)localObject1, a.class, new f() {});
        s.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41630);
            if (av.bKm().contains(paramoo))
            {
              Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
              av.bKm().remove(paramoo);
              com.tencent.mm.plugin.report.service.h.IzE.p(939L, 3L, 1L);
            }
            AppMethodBeat.o(41630);
          }
        }, 10000L);
      }
    }
  }
  
  private static boolean aJY(String paramString)
  {
    AppMethodBeat.i(41644);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.wepkg.utils.d.boQ(paramString)))
    {
      AppMethodBeat.o(41644);
      return false;
    }
    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", new Object[] { paramString });
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.LZ(paramString);
    localGameWebPerformanceInfo.jTE = System.currentTimeMillis();
    paramString = e.bod(paramString);
    localGameWebPerformanceInfo.jTF = System.currentTimeMillis();
    if ((paramString != null) && (paramString.ewT()))
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
    private final oo CMk;
    
    public b(oo paramoo)
    {
      this.CMk = paramoo;
    }
    
    public final void run()
    {
      AppMethodBeat.i(41640);
      Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
      av.a(av.this, this.CMk, null);
      com.tencent.mm.plugin.report.service.h.IzE.p(939L, 2L, 1L);
      AppMethodBeat.o(41640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.av
 * JD-Core Version:    0.7.0.1
 */