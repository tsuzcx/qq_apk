package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.mz.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.luggage.f.f;
import com.tencent.mm.plugin.game.luggage.h;
import com.tencent.mm.plugin.game.luggage.h.a;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public class av
  extends com.tencent.mm.sdk.b.c<mz>
{
  private static volatile String dKk;
  private static volatile long ueq;
  private static volatile long uer;
  private static Set<String> ues;
  private static Set<String> uet;
  private long ueu;
  private b uev;
  
  static
  {
    AppMethodBeat.i(41650);
    ues = new HashSet();
    uet = new HashSet();
    AppMethodBeat.o(41650);
  }
  
  public av()
  {
    AppMethodBeat.i(161130);
    this.__eventId = mz.class.getName().hashCode();
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
        ad.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore, preload: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        boolean bool = paramBundle.getBoolean("is_luggage", false);
        str1 = paramBundle.getString("call_raw_url");
        str2 = paramBundle.getString("float_layer_url");
        localGameWebPerformanceInfo = GameWebPerformanceInfo.wg(str1);
        if (!bool) {
          break label282;
        }
        com.tencent.luggage.d.p localp = h.alt(str1);
        if (localp != null)
        {
          if (paramBoolean)
          {
            ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
            paramBundle.putBoolean("has_preload_webcore", true);
            a(paramd, paramBundle);
            AppMethodBeat.o(41643);
            return;
          }
          com.tencent.mm.ipcinvoker.p.z(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41633);
              ((f)this.tTv.Cm()).onResume();
              ((f)this.tTv.Cm()).setBlockNetworkImage(false);
              AppMethodBeat.o(41633);
            }
          });
          com.tencent.mm.plugin.game.luggage.g.a(localp, str1, true);
          continue;
        }
        if (!paramBoolean) {
          break label257;
        }
      }
      finally {}
      if (localGameWebPerformanceInfo.gsp != 0L)
      {
        paramd.be(paramBundle);
        AppMethodBeat.o(41643);
      }
      else if (!alV(str1))
      {
        ad.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
        GameWebPerformanceInfo.wi(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
      }
      else
      {
        alV(str2);
        localGameWebPerformanceInfo.gsh = 1;
        localGameWebPerformanceInfo.gss = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.g.yhR.n(939L, 0L, 1L);
        h.a(i.class, str1, new h.a()
        {
          public final void BJ()
          {
            AppMethodBeat.i(41635);
            ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            com.tencent.mm.ipcinvoker.p.z(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(41634);
                com.tencent.luggage.d.p localp = h.alt(av.7.this.ueA);
                if (localp != null)
                {
                  ((f)localp.Cm()).setBlockNetworkImage(true);
                  ((f)localp.Cm()).onPause();
                }
                av.7.this.tTu.gst = System.currentTimeMillis();
                av.b(av.7.this.ueB, av.7.this.cWK);
                AppMethodBeat.o(41634);
              }
            });
            AppMethodBeat.o(41635);
          }
        });
        AppMethodBeat.o(41643);
        continue;
        label257:
        alV(str2);
        alV(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
        continue;
        label282:
        alV(str2);
        alV(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
      }
    }
  }
  
  private void a(final mz parammz, Bundle paramBundle)
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(41642);
      ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
      aq.aA(this.uev);
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41631);
          ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", new Object[] { Integer.valueOf(1000), av.dKk });
          av.alW("");
          AppMethodBeat.o(41631);
        }
      }, 1000L);
      if (parammz == null) {
        AppMethodBeat.o(41642);
      }
      for (;;)
      {
        return;
        if (bt.isNullOrNil(parammz.dAU.group)) {
          break label125;
        }
        if (!ues.contains(parammz.dAU.group)) {
          break;
        }
        ues.remove(parammz.dAU.group);
        AppMethodBeat.o(41642);
      }
      ues.add(parammz.dAU.group);
    }
    finally {}
    label125:
    final Context localContext;
    label144:
    String str;
    if (parammz.dAU.context != null)
    {
      localContext = parammz.dAU.context;
      if (parammz.dAU.intent == null) {
        parammz.dAU.intent = new Intent();
      }
      str = parammz.dAU.intent.getStringExtra("rawUrl");
      ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
      parammz.dAU.intent.putExtra("start_activity_time", System.currentTimeMillis());
      switch (parammz.dAU.type)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        long l = System.currentTimeMillis() - ueq;
        ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[] { Long.valueOf(l) });
        try
        {
          parammz.dAU.context = null;
          label293:
          com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.wepkg.utils.d.aKY(str), null, -1L, l, null);
          AppMethodBeat.o(41642);
          break;
          localContext = aj.getContext();
          break label144;
          com.tencent.mm.bs.d.b(localContext, "webview", ".ui.tools.WebViewUI", parammz.dAU.intent);
          continue;
          com.tencent.mm.bs.d.b(localContext, "webview", ".ui.tools.TransparentWebViewUI", parammz.dAU.intent);
          continue;
          if (paramBundle != null) {
            bool = paramBundle.getBoolean("has_preload_webcore", false);
          }
          paramBundle = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41632);
              com.tencent.mm.bs.d.b(localContext, "webview", ".ui.tools.WebViewUI", parammz.dAU.intent);
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
        catch (Exception parammz)
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
      paramd.be(paramBundle);
    }
    AppMethodBeat.o(41645);
  }
  
  private boolean a(final mz parammz)
  {
    AppMethodBeat.i(41641);
    ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", new Object[] { Integer.valueOf(parammz.dAU.type) });
    if (parammz.dAU.intent == null)
    {
      AppMethodBeat.o(41641);
      return false;
    }
    if (parammz.dAU.type == 3)
    {
      ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.ueu), Long.valueOf(this.ueu) });
      if (System.currentTimeMillis() - this.ueu < 500L)
      {
        ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
        AppMethodBeat.o(41641);
        return false;
      }
    }
    this.ueu = System.currentTimeMillis();
    switch (parammz.dAU.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41641);
      return false;
      int i = parammz.dAU.type;
      int j = hashCode();
      int k = parammz.hashCode();
      long l = Thread.currentThread().getId();
      boolean bool;
      label222:
      Object localObject1;
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        bool = true;
        ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l), Boolean.valueOf(bool) });
        localObject1 = "";
      }
      try
      {
        str = parammz.dAU.intent.getStringExtra("rawUrl");
        localObject1 = str;
      }
      catch (Exception localException)
      {
        String str;
        label296:
        break label296;
      }
      str = parammz.dAU.intent.getStringExtra("game_float_layer_url");
      try
      {
        if (bt.nullAsNil(dKk).equalsIgnoreCase((String)localObject1))
        {
          ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
          return false;
          bool = false;
          break label222;
        }
        dKk = (String)localObject1;
        ueq = System.currentTimeMillis();
        uer = System.currentTimeMillis();
        if (aj.cnC()) {
          com.tencent.mm.plugin.wepkg.utils.b.EFR = com.tencent.mm.plugin.game.commlib.a.cWR();
        }
        if (com.tencent.mm.plugin.wepkg.utils.d.aLb((String)localObject1))
        {
          ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.aKY((String)localObject1) });
          Object localObject2 = com.tencent.mm.b.g.getMessageDigest(bt.nullAsNil((String)localObject1).getBytes()) + "_" + System.currentTimeMillis();
          parammz.dAU.group = ((String)localObject2);
          this.uev = new b(parammz);
          aq.o(this.uev, 500L);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("is_wepkg_disable", com.tencent.mm.plugin.wepkg.utils.b.EFR);
          ((Bundle)localObject2).putString("call_raw_url", (String)localObject1);
          if (!bt.isNullOrNil(str)) {
            ((Bundle)localObject2).putString("float_layer_url", str);
          }
          if (parammz.dAU.type == 2) {
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
      ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + com.tencent.mm.plugin.wepkg.utils.b.EFR);
      a(parammz, null);
      continue;
      parammz = parammz.dAU.intent.getStringExtra("rawUrl");
      if ((!uet.contains(parammz)) && (com.tencent.mm.plugin.wepkg.utils.d.aLb(parammz)))
      {
        uet.add(parammz);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("call_raw_url", parammz);
        ((Bundle)localObject1).putBoolean("preload_webcore", true);
        ((Bundle)localObject1).putBoolean("is_luggage", true);
        com.tencent.mm.plugin.game.luggage.b.b((Parcelable)localObject1, a.class, new com.tencent.mm.ipcinvoker.d() {});
        com.tencent.mm.ipcinvoker.p.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41630);
            if (av.bdb().contains(parammz))
            {
              ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
              av.bdb().remove(parammz);
              com.tencent.mm.plugin.report.service.g.yhR.n(939L, 3L, 1L);
            }
            AppMethodBeat.o(41630);
          }
        }, 10000L);
      }
    }
  }
  
  private static boolean alV(String paramString)
  {
    AppMethodBeat.i(41644);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.wepkg.utils.d.aLb(paramString)))
    {
      AppMethodBeat.o(41644);
      return false;
    }
    ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", new Object[] { paramString });
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.wg(paramString);
    localGameWebPerformanceInfo.gsq = System.currentTimeMillis();
    paramString = com.tencent.mm.plugin.wepkg.c.aKq(paramString);
    localGameWebPerformanceInfo.gsr = System.currentTimeMillis();
    if ((paramString != null) && (paramString.eXV()))
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
    private final mz ueG;
    
    public b(mz parammz)
    {
      this.ueG = parammz;
    }
    
    public final void run()
    {
      AppMethodBeat.i(41640);
      ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
      av.a(av.this, this.ueG, null);
      com.tencent.mm.plugin.report.service.g.yhR.n(939L, 2L, 1L);
      AppMethodBeat.o(41640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.av
 * JD-Core Version:    0.7.0.1
 */