package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.mr.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.game.luggage.f;
import com.tencent.mm.plugin.game.luggage.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.Set;

public class av
  extends c<mr>
{
  private static volatile String dxX;
  private static volatile long tgA;
  private static Set<String> tgB;
  private static Set<String> tgC;
  private static volatile long tgz;
  private long tgD;
  private b tgE;
  
  static
  {
    AppMethodBeat.i(41650);
    tgB = new HashSet();
    tgC = new HashSet();
    AppMethodBeat.o(41650);
  }
  
  public av()
  {
    AppMethodBeat.i(161130);
    this.__eventId = mr.class.getName().hashCode();
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
        ac.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore, preload: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        boolean bool = paramBundle.getBoolean("is_luggage", false);
        str1 = paramBundle.getString("call_raw_url");
        str2 = paramBundle.getString("float_layer_url");
        localGameWebPerformanceInfo = GameWebPerformanceInfo.tq(str1);
        if (!bool) {
          break label282;
        }
        k localk = f.agW(str1);
        if (localk != null)
        {
          if (paramBoolean)
          {
            ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
            paramBundle.putBoolean("has_preload_webcore", true);
            a(paramd, paramBundle);
            AppMethodBeat.o(41643);
            return;
          }
          p.z(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41633);
              ((com.tencent.mm.plugin.game.luggage.d.e)this.sWM.AN()).onResume();
              ((com.tencent.mm.plugin.game.luggage.d.e)this.sWM.AN()).setBlockNetworkImage(false);
              AppMethodBeat.o(41633);
            }
          });
          com.tencent.mm.plugin.game.luggage.e.a(localk, str1, true);
          continue;
        }
        if (!paramBoolean) {
          break label257;
        }
      }
      finally {}
      if (localGameWebPerformanceInfo.fYT != 0L)
      {
        paramd.bc(paramBundle);
        AppMethodBeat.o(41643);
      }
      else if (!aht(str1))
      {
        ac.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
        GameWebPerformanceInfo.ts(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
      }
      else
      {
        aht(str2);
        localGameWebPerformanceInfo.fYL = 1;
        localGameWebPerformanceInfo.fYW = System.currentTimeMillis();
        h.wUl.n(939L, 0L, 1L);
        f.a(com.tencent.mm.plugin.game.luggage.g.class, str1, new f.a()
        {
          public final void Am()
          {
            AppMethodBeat.i(41635);
            ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            p.z(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(41634);
                k localk = f.agW(av.7.this.tgJ);
                if (localk != null)
                {
                  ((com.tencent.mm.plugin.game.luggage.d.e)localk.AN()).setBlockNetworkImage(true);
                  ((com.tencent.mm.plugin.game.luggage.d.e)localk.AN()).onPause();
                }
                av.7.this.sWL.fYX = System.currentTimeMillis();
                av.b(av.7.this.tgK, av.7.this.cLw);
                AppMethodBeat.o(41634);
              }
            });
            AppMethodBeat.o(41635);
          }
        });
        AppMethodBeat.o(41643);
        continue;
        label257:
        aht(str2);
        aht(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
        continue;
        label282:
        aht(str2);
        aht(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
      }
    }
  }
  
  private void a(final mr parammr, Bundle paramBundle)
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(41642);
      ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
      ap.aB(this.tgE);
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41631);
          ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", new Object[] { Integer.valueOf(1000), av.dxX });
          av.ahu("");
          AppMethodBeat.o(41631);
        }
      }, 1000L);
      if (parammr == null) {
        AppMethodBeat.o(41642);
      }
      for (;;)
      {
        return;
        if (bs.isNullOrNil(parammr.dph.group)) {
          break label125;
        }
        if (!tgB.contains(parammr.dph.group)) {
          break;
        }
        tgB.remove(parammr.dph.group);
        AppMethodBeat.o(41642);
      }
      tgB.add(parammr.dph.group);
    }
    finally {}
    label125:
    final Context localContext;
    label144:
    String str;
    if (parammr.dph.context != null)
    {
      localContext = parammr.dph.context;
      if (parammr.dph.intent == null) {
        parammr.dph.intent = new Intent();
      }
      str = parammr.dph.intent.getStringExtra("rawUrl");
      ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
      parammr.dph.intent.putExtra("start_activity_time", System.currentTimeMillis());
      switch (parammr.dph.type)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        long l = System.currentTimeMillis() - tgz;
        ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[] { Long.valueOf(l) });
        try
        {
          parammr.dph.context = null;
          label293:
          com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.wepkg.utils.d.aFy(str), null, -1L, l, null);
          AppMethodBeat.o(41642);
          break;
          localContext = ai.getContext();
          break label144;
          com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.WebViewUI", parammr.dph.intent);
          continue;
          com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.TransparentWebViewUI", parammr.dph.intent);
          continue;
          if (paramBundle != null) {
            bool = paramBundle.getBoolean("has_preload_webcore", false);
          }
          paramBundle = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41632);
              com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.WebViewUI", parammr.dph.intent);
              AppMethodBeat.o(41632);
            }
          };
          if (bool) {}
          for (l = 100L;; l = 0L)
          {
            p.postDelayed(paramBundle, l);
            break;
          }
        }
        catch (Exception parammr)
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
      paramd.bc(paramBundle);
    }
    AppMethodBeat.o(41645);
  }
  
  private boolean a(final mr parammr)
  {
    AppMethodBeat.i(41641);
    ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", new Object[] { Integer.valueOf(parammr.dph.type) });
    if (parammr.dph.intent == null)
    {
      AppMethodBeat.o(41641);
      return false;
    }
    if (parammr.dph.type == 3)
    {
      ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.tgD), Long.valueOf(this.tgD) });
      if (System.currentTimeMillis() - this.tgD < 500L)
      {
        ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
        AppMethodBeat.o(41641);
        return false;
      }
    }
    this.tgD = System.currentTimeMillis();
    switch (parammr.dph.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41641);
      return false;
      int i = parammr.dph.type;
      int j = hashCode();
      int k = parammr.hashCode();
      long l = Thread.currentThread().getId();
      boolean bool;
      label222:
      Object localObject1;
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        bool = true;
        ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l), Boolean.valueOf(bool) });
        localObject1 = "";
      }
      try
      {
        str = parammr.dph.intent.getStringExtra("rawUrl");
        localObject1 = str;
      }
      catch (Exception localException)
      {
        String str;
        label296:
        break label296;
      }
      str = parammr.dph.intent.getStringExtra("game_float_layer_url");
      try
      {
        if (bs.nullAsNil(dxX).equalsIgnoreCase((String)localObject1))
        {
          ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
          return false;
          bool = false;
          break label222;
        }
        dxX = (String)localObject1;
        tgz = System.currentTimeMillis();
        tgA = System.currentTimeMillis();
        if (ai.ciE()) {
          com.tencent.mm.plugin.wepkg.utils.b.DbS = com.tencent.mm.plugin.game.commlib.a.cOw();
        }
        if (com.tencent.mm.plugin.wepkg.utils.d.aFB((String)localObject1))
        {
          ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.aFy((String)localObject1) });
          Object localObject2 = com.tencent.mm.b.g.getMessageDigest(bs.nullAsNil((String)localObject1).getBytes()) + "_" + System.currentTimeMillis();
          parammr.dph.group = ((String)localObject2);
          this.tgE = new b(parammr);
          ap.n(this.tgE, 500L);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("is_wepkg_disable", com.tencent.mm.plugin.wepkg.utils.b.DbS);
          ((Bundle)localObject2).putString("call_raw_url", (String)localObject1);
          if (!bs.isNullOrNil(str)) {
            ((Bundle)localObject2).putString("float_layer_url", str);
          }
          if (parammr.dph.type == 2) {
            ((Bundle)localObject2).putBoolean("is_luggage", true);
          }
          com.tencent.mm.plugin.game.luggage.a.b((Parcelable)localObject2, a.class, new com.tencent.mm.ipcinvoker.d() {});
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(41641);
      }
      ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + com.tencent.mm.plugin.wepkg.utils.b.DbS);
      a(parammr, null);
      continue;
      parammr = parammr.dph.intent.getStringExtra("rawUrl");
      if ((!tgC.contains(parammr)) && (com.tencent.mm.plugin.wepkg.utils.d.aFB(parammr)))
      {
        tgC.add(parammr);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("call_raw_url", parammr);
        ((Bundle)localObject1).putBoolean("preload_webcore", true);
        ((Bundle)localObject1).putBoolean("is_luggage", true);
        com.tencent.mm.plugin.game.luggage.a.b((Parcelable)localObject1, a.class, new com.tencent.mm.ipcinvoker.d() {});
        p.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41630);
            if (av.beW().contains(parammr))
            {
              ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
              av.beW().remove(parammr);
              h.wUl.n(939L, 3L, 1L);
            }
            AppMethodBeat.o(41630);
          }
        }, 10000L);
      }
    }
  }
  
  private static boolean aht(String paramString)
  {
    AppMethodBeat.i(41644);
    if ((bs.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.wepkg.utils.d.aFB(paramString)))
    {
      AppMethodBeat.o(41644);
      return false;
    }
    ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", new Object[] { paramString });
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.tq(paramString);
    localGameWebPerformanceInfo.fYU = System.currentTimeMillis();
    paramString = com.tencent.mm.plugin.wepkg.b.aEQ(paramString);
    localGameWebPerformanceInfo.fYV = System.currentTimeMillis();
    if ((paramString != null) && (paramString.eJc()))
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
    private final mr tgP;
    
    public b(mr parammr)
    {
      this.tgP = parammr;
    }
    
    public final void run()
    {
      AppMethodBeat.i(41640);
      ac.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
      av.a(av.this, this.tgP, null);
      h.wUl.n(939L, 2L, 1L);
      AppMethodBeat.o(41640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.av
 * JD-Core Version:    0.7.0.1
 */