package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.na;
import com.tencent.mm.g.a.na.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.luggage.f.f;
import com.tencent.mm.plugin.game.luggage.h;
import com.tencent.mm.plugin.game.luggage.h.a;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Set;

public class av
  extends com.tencent.mm.sdk.b.c<na>
{
  private static volatile String dLz;
  private static Set<String> upA;
  private static volatile long upx;
  private static volatile long upy;
  private static Set<String> upz;
  private long upB;
  private b upC;
  
  static
  {
    AppMethodBeat.i(41650);
    upz = new HashSet();
    upA = new HashSet();
    AppMethodBeat.o(41650);
  }
  
  public av()
  {
    AppMethodBeat.i(161130);
    this.__eventId = na.class.getName().hashCode();
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
        ae.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore, preload: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        boolean bool = paramBundle.getBoolean("is_luggage", false);
        str1 = paramBundle.getString("call_raw_url");
        str2 = paramBundle.getString("float_layer_url");
        localGameWebPerformanceInfo = GameWebPerformanceInfo.wP(str1);
        if (!bool) {
          break label282;
        }
        com.tencent.luggage.d.p localp = h.amr(str1);
        if (localp != null)
        {
          if (paramBoolean)
          {
            ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
            paramBundle.putBoolean("has_preload_webcore", true);
            a(paramd, paramBundle);
            AppMethodBeat.o(41643);
            return;
          }
          com.tencent.mm.ipcinvoker.p.x(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41633);
              ((f)this.uen.Cp()).onResume();
              ((f)this.uen.Cp()).setBlockNetworkImage(false);
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
      if (localGameWebPerformanceInfo.guQ != 0L)
      {
        paramd.be(paramBundle);
        AppMethodBeat.o(41643);
      }
      else if (!amV(str1))
      {
        ae.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
        GameWebPerformanceInfo.wR(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
      }
      else
      {
        amV(str2);
        localGameWebPerformanceInfo.guI = 1;
        localGameWebPerformanceInfo.guT = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.g.yxI.n(939L, 0L, 1L);
        h.a(i.class, str1, new h.a()
        {
          public final void BK()
          {
            AppMethodBeat.i(41635);
            ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            com.tencent.mm.ipcinvoker.p.x(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(41634);
                com.tencent.luggage.d.p localp = h.amr(av.7.this.upH);
                if (localp != null)
                {
                  ((f)localp.Cp()).setBlockNetworkImage(true);
                  ((f)localp.Cp()).onPause();
                }
                av.7.this.uem.guU = System.currentTimeMillis();
                av.b(av.7.this.upI, av.7.this.cXH);
                AppMethodBeat.o(41634);
              }
            });
            AppMethodBeat.o(41635);
          }
        });
        AppMethodBeat.o(41643);
        continue;
        label257:
        amV(str2);
        amV(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
        continue;
        label282:
        amV(str2);
        amV(str1);
        a(paramd, paramBundle);
        AppMethodBeat.o(41643);
      }
    }
  }
  
  private void a(final na paramna, Bundle paramBundle)
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(41642);
      ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
      ar.ay(this.upC);
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41631);
          ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", new Object[] { Integer.valueOf(1000), av.dLz });
          av.amW("");
          AppMethodBeat.o(41631);
        }
      }, 1000L);
      if (paramna == null) {
        AppMethodBeat.o(41642);
      }
      for (;;)
      {
        return;
        if (bu.isNullOrNil(paramna.dBZ.group)) {
          break label125;
        }
        if (!upz.contains(paramna.dBZ.group)) {
          break;
        }
        upz.remove(paramna.dBZ.group);
        AppMethodBeat.o(41642);
      }
      upz.add(paramna.dBZ.group);
    }
    finally {}
    label125:
    final Context localContext;
    label144:
    String str;
    if (paramna.dBZ.context != null)
    {
      localContext = paramna.dBZ.context;
      if (paramna.dBZ.intent == null) {
        paramna.dBZ.intent = new Intent();
      }
      str = paramna.dBZ.intent.getStringExtra("rawUrl");
      ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
      paramna.dBZ.intent.putExtra("start_activity_time", System.currentTimeMillis());
      switch (paramna.dBZ.type)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        long l = System.currentTimeMillis() - upx;
        ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[] { Long.valueOf(l) });
        try
        {
          paramna.dBZ.context = null;
          label293:
          com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.wepkg.utils.d.aMu(str), null, -1L, l, null);
          AppMethodBeat.o(41642);
          break;
          localContext = ak.getContext();
          break label144;
          com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.WebViewUI", paramna.dBZ.intent);
          continue;
          com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.TransparentWebViewUI", paramna.dBZ.intent);
          continue;
          if (paramBundle != null) {
            bool = paramBundle.getBoolean("has_preload_webcore", false);
          }
          paramBundle = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41632);
              com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.WebViewUI", paramna.dBZ.intent);
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
        catch (Exception paramna)
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
  
  private boolean a(final na paramna)
  {
    AppMethodBeat.i(41641);
    ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", new Object[] { Integer.valueOf(paramna.dBZ.type) });
    if (paramna.dBZ.intent == null)
    {
      AppMethodBeat.o(41641);
      return false;
    }
    if (paramna.dBZ.type == 3)
    {
      ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.upB), Long.valueOf(this.upB) });
      if (System.currentTimeMillis() - this.upB < 500L)
      {
        ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
        AppMethodBeat.o(41641);
        return false;
      }
    }
    this.upB = System.currentTimeMillis();
    switch (paramna.dBZ.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41641);
      return false;
      int i = paramna.dBZ.type;
      int j = hashCode();
      int k = paramna.hashCode();
      long l = Thread.currentThread().getId();
      boolean bool;
      label222:
      Object localObject1;
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        bool = true;
        ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l), Boolean.valueOf(bool) });
        localObject1 = "";
      }
      try
      {
        str = paramna.dBZ.intent.getStringExtra("rawUrl");
        localObject1 = str;
      }
      catch (Exception localException)
      {
        String str;
        label296:
        break label296;
      }
      str = paramna.dBZ.intent.getStringExtra("game_float_layer_url");
      try
      {
        if (bu.nullAsNil(dLz).equalsIgnoreCase((String)localObject1))
        {
          ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
          return false;
          bool = false;
          break label222;
        }
        dLz = (String)localObject1;
        upx = System.currentTimeMillis();
        upy = System.currentTimeMillis();
        if (ak.cpe()) {
          com.tencent.mm.plugin.wepkg.utils.b.EYn = com.tencent.mm.plugin.game.commlib.a.cZv();
        }
        if (com.tencent.mm.plugin.wepkg.utils.d.aMx((String)localObject1))
        {
          ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.aMu((String)localObject1) });
          Object localObject2 = com.tencent.mm.b.g.getMessageDigest(bu.nullAsNil((String)localObject1).getBytes()) + "_" + System.currentTimeMillis();
          paramna.dBZ.group = ((String)localObject2);
          this.upC = new b(paramna);
          ar.o(this.upC, 500L);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("is_wepkg_disable", com.tencent.mm.plugin.wepkg.utils.b.EYn);
          ((Bundle)localObject2).putString("call_raw_url", (String)localObject1);
          if (!bu.isNullOrNil(str)) {
            ((Bundle)localObject2).putString("float_layer_url", str);
          }
          if (paramna.dBZ.type == 2) {
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
      ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + com.tencent.mm.plugin.wepkg.utils.b.EYn);
      a(paramna, null);
      continue;
      paramna = paramna.dBZ.intent.getStringExtra("rawUrl");
      if ((!upA.contains(paramna)) && (com.tencent.mm.plugin.wepkg.utils.d.aMx(paramna)))
      {
        upA.add(paramna);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("call_raw_url", paramna);
        ((Bundle)localObject1).putBoolean("preload_webcore", true);
        ((Bundle)localObject1).putBoolean("is_luggage", true);
        com.tencent.mm.plugin.game.luggage.b.b((Parcelable)localObject1, a.class, new com.tencent.mm.ipcinvoker.d() {});
        com.tencent.mm.ipcinvoker.p.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41630);
            if (av.bdG().contains(paramna))
            {
              ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
              av.bdG().remove(paramna);
              com.tencent.mm.plugin.report.service.g.yxI.n(939L, 3L, 1L);
            }
            AppMethodBeat.o(41630);
          }
        }, 10000L);
      }
    }
  }
  
  private static boolean amV(String paramString)
  {
    AppMethodBeat.i(41644);
    if ((bu.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.wepkg.utils.d.aMx(paramString)))
    {
      AppMethodBeat.o(41644);
      return false;
    }
    ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", new Object[] { paramString });
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.wP(paramString);
    localGameWebPerformanceInfo.guR = System.currentTimeMillis();
    paramString = com.tencent.mm.plugin.wepkg.c.aLM(paramString);
    localGameWebPerformanceInfo.guS = System.currentTimeMillis();
    if ((paramString != null) && (paramString.fbH()))
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
    private final na upN;
    
    public b(na paramna)
    {
      this.upN = paramna;
    }
    
    public final void run()
    {
      AppMethodBeat.i(41640);
      ae.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
      av.a(av.this, this.upN, null);
      com.tencent.mm.plugin.report.service.g.yxI.n(939L, 2L, 1L);
      AppMethodBeat.o(41640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.av
 * JD-Core Version:    0.7.0.1
 */