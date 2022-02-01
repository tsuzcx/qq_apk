package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.mi.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.game.luggage.f;
import com.tencent.mm.plugin.game.luggage.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public class av
  extends c<mi>
{
  private static volatile String dAl;
  private static volatile long rYH;
  private static volatile long rYI;
  private static Set<String> rYJ;
  private static Set<String> rYK;
  private long rYL;
  private b rYM;
  
  static
  {
    AppMethodBeat.i(41650);
    rYJ = new HashSet();
    rYK = new HashSet();
    AppMethodBeat.o(41650);
  }
  
  public av()
  {
    AppMethodBeat.i(161130);
    this.__eventId = mi.class.getName().hashCode();
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
        localGameWebPerformanceInfo = GameWebPerformanceInfo.qd(str1);
        if (!bool) {
          break label282;
        }
        k localk = f.ace(str1);
        if (localk != null)
        {
          if (paramBoolean)
          {
            ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
            paramBundle.putBoolean("has_preload_webcore", true);
            a(paramd, paramBundle);
            AppMethodBeat.o(41643);
            return;
          }
          p.y(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41633);
              ((com.tencent.mm.plugin.game.luggage.d.e)this.rOW.Bj()).onResume();
              ((com.tencent.mm.plugin.game.luggage.d.e)this.rOW.Bj()).setBlockNetworkImage(false);
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
      if (localGameWebPerformanceInfo.fUY != 0L)
      {
        paramd.bf(paramBundle);
        AppMethodBeat.o(41643);
      }
      else if (!acB(str1))
      {
        ad.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
        GameWebPerformanceInfo.qf(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
      }
      else
      {
        acB(str2);
        localGameWebPerformanceInfo.fUQ = 1;
        localGameWebPerformanceInfo.fVb = System.currentTimeMillis();
        h.vKh.m(939L, 0L, 1L);
        f.a(com.tencent.mm.plugin.game.luggage.g.class, str1, new f.a()
        {
          public final void AI()
          {
            AppMethodBeat.i(41635);
            ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            p.y(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(41634);
                k localk = f.ace(av.7.this.rYR);
                if (localk != null)
                {
                  ((com.tencent.mm.plugin.game.luggage.d.e)localk.Bj()).setBlockNetworkImage(true);
                  ((com.tencent.mm.plugin.game.luggage.d.e)localk.Bj()).onPause();
                }
                av.7.this.rOV.fVc = System.currentTimeMillis();
                av.b(av.7.this.rYS, av.7.this.cOb);
                AppMethodBeat.o(41634);
              }
            });
            AppMethodBeat.o(41635);
          }
        });
        AppMethodBeat.o(41643);
        continue;
        label257:
        acB(str2);
        acB(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
        continue;
        label282:
        acB(str2);
        acB(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
      }
    }
  }
  
  private void a(final mi parammi, Bundle paramBundle)
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(41642);
      ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
      aq.az(this.rYM);
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41631);
          ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", new Object[] { Integer.valueOf(1000), av.dAl });
          av.acC("");
          AppMethodBeat.o(41631);
        }
      }, 1000L);
      if (parammi == null) {
        AppMethodBeat.o(41642);
      }
      for (;;)
      {
        return;
        if (bt.isNullOrNil(parammi.drw.group)) {
          break label125;
        }
        if (!rYJ.contains(parammi.drw.group)) {
          break;
        }
        rYJ.remove(parammi.drw.group);
        AppMethodBeat.o(41642);
      }
      rYJ.add(parammi.drw.group);
    }
    finally {}
    label125:
    final Context localContext;
    label144:
    String str;
    if (parammi.drw.context != null)
    {
      localContext = parammi.drw.context;
      if (parammi.drw.intent == null) {
        parammi.drw.intent = new Intent();
      }
      str = parammi.drw.intent.getStringExtra("rawUrl");
      ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
      parammi.drw.intent.putExtra("start_activity_time", System.currentTimeMillis());
      switch (parammi.drw.type)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        long l = System.currentTimeMillis() - rYH;
        ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[] { Long.valueOf(l) });
        try
        {
          parammi.drw.context = null;
          label293:
          com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.wepkg.utils.d.aAg(str), null, -1L, l, null);
          AppMethodBeat.o(41642);
          break;
          localContext = aj.getContext();
          break label144;
          com.tencent.mm.bs.d.b(localContext, "webview", ".ui.tools.WebViewUI", parammi.drw.intent);
          continue;
          com.tencent.mm.bs.d.b(localContext, "webview", ".ui.tools.TransparentWebViewUI", parammi.drw.intent);
          continue;
          if (paramBundle != null) {
            bool = paramBundle.getBoolean("has_preload_webcore", false);
          }
          paramBundle = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41632);
              com.tencent.mm.bs.d.b(localContext, "webview", ".ui.tools.WebViewUI", parammi.drw.intent);
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
        catch (Exception parammi)
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
      paramd.bf(paramBundle);
    }
    AppMethodBeat.o(41645);
  }
  
  private boolean a(final mi parammi)
  {
    AppMethodBeat.i(41641);
    ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", new Object[] { Integer.valueOf(parammi.drw.type) });
    if (parammi.drw.intent == null)
    {
      AppMethodBeat.o(41641);
      return false;
    }
    if (parammi.drw.type == 3)
    {
      ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.rYL), Long.valueOf(this.rYL) });
      if (System.currentTimeMillis() - this.rYL < 500L)
      {
        ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
        AppMethodBeat.o(41641);
        return false;
      }
    }
    this.rYL = System.currentTimeMillis();
    switch (parammi.drw.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41641);
      return false;
      int i = parammi.drw.type;
      int j = hashCode();
      int k = parammi.hashCode();
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
        str = parammi.drw.intent.getStringExtra("rawUrl");
        localObject1 = str;
      }
      catch (Exception localException)
      {
        String str;
        label296:
        break label296;
      }
      str = parammi.drw.intent.getStringExtra("game_float_layer_url");
      try
      {
        if (bt.nullAsNil(dAl).equalsIgnoreCase((String)localObject1))
        {
          ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
          return false;
          bool = false;
          break label222;
        }
        dAl = (String)localObject1;
        rYH = System.currentTimeMillis();
        rYI = System.currentTimeMillis();
        if (aj.cbv()) {
          com.tencent.mm.plugin.wepkg.utils.b.BJJ = com.tencent.mm.plugin.game.commlib.a.cBn();
        }
        if (com.tencent.mm.plugin.wepkg.utils.d.aAj((String)localObject1))
        {
          ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.aAg((String)localObject1) });
          Object localObject2 = com.tencent.mm.b.g.getMessageDigest(bt.nullAsNil((String)localObject1).getBytes()) + "_" + System.currentTimeMillis();
          parammi.drw.group = ((String)localObject2);
          this.rYM = new b(parammi);
          aq.n(this.rYM, 500L);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("is_wepkg_disable", com.tencent.mm.plugin.wepkg.utils.b.BJJ);
          ((Bundle)localObject2).putString("call_raw_url", (String)localObject1);
          if (!bt.isNullOrNil(str)) {
            ((Bundle)localObject2).putString("float_layer_url", str);
          }
          if (parammi.drw.type == 2) {
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
      ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + com.tencent.mm.plugin.wepkg.utils.b.BJJ);
      a(parammi, null);
      continue;
      parammi = parammi.drw.intent.getStringExtra("rawUrl");
      if ((!rYK.contains(parammi)) && (com.tencent.mm.plugin.wepkg.utils.d.aAj(parammi)))
      {
        rYK.add(parammi);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("call_raw_url", parammi);
        ((Bundle)localObject1).putBoolean("preload_webcore", true);
        ((Bundle)localObject1).putBoolean("is_luggage", true);
        com.tencent.mm.plugin.game.luggage.a.b((Parcelable)localObject1, a.class, new com.tencent.mm.ipcinvoker.d() {});
        p.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41630);
            if (av.aXZ().contains(parammi))
            {
              ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
              av.aXZ().remove(parammi);
              h.vKh.m(939L, 3L, 1L);
            }
            AppMethodBeat.o(41630);
          }
        }, 10000L);
      }
    }
  }
  
  private static boolean acB(String paramString)
  {
    AppMethodBeat.i(41644);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.wepkg.utils.d.aAj(paramString)))
    {
      AppMethodBeat.o(41644);
      return false;
    }
    ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", new Object[] { paramString });
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.qd(paramString);
    localGameWebPerformanceInfo.fUZ = System.currentTimeMillis();
    paramString = com.tencent.mm.plugin.wepkg.b.azz(paramString);
    localGameWebPerformanceInfo.fVa = System.currentTimeMillis();
    if ((paramString != null) && (paramString.etJ()))
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
    private final mi rYX;
    
    public b(mi parammi)
    {
      this.rYX = parammi;
    }
    
    public final void run()
    {
      AppMethodBeat.i(41640);
      ad.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
      av.a(av.this, this.rYX, null);
      h.vKh.m(939L, 2L, 1L);
      AppMethodBeat.o(41640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.av
 * JD-Core Version:    0.7.0.1
 */