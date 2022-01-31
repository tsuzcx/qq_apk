package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.ld.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.luggage.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

public class aw
  extends com.tencent.mm.sdk.b.c<ld>
{
  private static volatile String cJr;
  private static volatile long npm;
  private static volatile long npn;
  private static Set<String> npo;
  private static Set<String> npp;
  private long npq;
  private aw.b npr;
  
  static
  {
    AppMethodBeat.i(111486);
    npo = new HashSet();
    npp = new HashSet();
    AppMethodBeat.o(111486);
  }
  
  public aw()
  {
    AppMethodBeat.i(111476);
    this.__eventId = ld.class.getName().hashCode();
    AppMethodBeat.o(111476);
  }
  
  private static boolean Qc(String paramString)
  {
    AppMethodBeat.i(111480);
    if ((bo.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.wepkg.utils.d.akP(paramString)))
    {
      AppMethodBeat.o(111480);
      return false;
    }
    ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", new Object[] { paramString });
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.lN(paramString);
    localGameWebPerformanceInfo.eAb = System.currentTimeMillis();
    paramString = com.tencent.mm.plugin.wepkg.b.akg(paramString);
    localGameWebPerformanceInfo.eAc = System.currentTimeMillis();
    if (paramString != null)
    {
      AppMethodBeat.o(111480);
      return true;
    }
    AppMethodBeat.o(111480);
    return false;
  }
  
  private static void a(Bundle paramBundle, boolean paramBoolean, com.tencent.mm.ipcinvoker.c paramc)
  {
    for (;;)
    {
      String str1;
      String str2;
      GameWebPerformanceInfo localGameWebPerformanceInfo;
      try
      {
        AppMethodBeat.i(111479);
        ab.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore, preload: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        boolean bool = paramBundle.getBoolean("is_luggage", false);
        str1 = paramBundle.getString("call_raw_url");
        str2 = paramBundle.getString("float_layer_url");
        localGameWebPerformanceInfo = GameWebPerformanceInfo.lN(str1);
        if (!bool) {
          break label282;
        }
        k localk = com.tencent.mm.plugin.game.luggage.d.PR(str1);
        if (localk != null)
        {
          if (paramBoolean)
          {
            ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
            paramBundle.putBoolean("has_preload_webcore", true);
            a(paramc, paramBundle);
            AppMethodBeat.o(111479);
            return;
          }
          l.q(new aw.6(localk));
          com.tencent.mm.plugin.game.luggage.c.a(localk, str1, true);
          continue;
        }
        if (!paramBoolean) {
          break label257;
        }
      }
      finally {}
      if (localGameWebPerformanceInfo.eAa != 0L)
      {
        paramc.ad(paramBundle);
        AppMethodBeat.o(111479);
      }
      else if (!Qc(str1))
      {
        ab.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
        GameWebPerformanceInfo.lP(str1);
        a(paramc, paramBundle);
        AppMethodBeat.o(111479);
      }
      else
      {
        Qc(str2);
        localGameWebPerformanceInfo.ezS = 1;
        localGameWebPerformanceInfo.eAd = System.currentTimeMillis();
        h.qsU.j(939L, 0L, 1L);
        com.tencent.mm.plugin.game.luggage.d.a(e.class, str1, new aw.7(str1, localGameWebPerformanceInfo, paramc, paramBundle));
        AppMethodBeat.o(111479);
        continue;
        label257:
        Qc(str2);
        Qc(str1);
        a(paramc, paramBundle);
        AppMethodBeat.o(111479);
        continue;
        label282:
        Qc(str2);
        Qc(str1);
        a(paramc, paramBundle);
        AppMethodBeat.o(111479);
      }
    }
  }
  
  private void a(ld paramld, Bundle paramBundle)
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(111478);
      ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
      al.ae(this.npr);
      al.p(new aw.4(this), 1000L);
      if (paramld == null) {
        AppMethodBeat.o(111478);
      }
      for (;;)
      {
        return;
        if (bo.isNullOrNil(paramld.cBn.group)) {
          break label125;
        }
        if (!npo.contains(paramld.cBn.group)) {
          break;
        }
        npo.remove(paramld.cBn.group);
        AppMethodBeat.o(111478);
      }
      npo.add(paramld.cBn.group);
    }
    finally {}
    label125:
    Context localContext;
    label144:
    String str;
    if (paramld.cBn.context != null)
    {
      localContext = paramld.cBn.context;
      if (paramld.cBn.intent == null) {
        paramld.cBn.intent = new Intent();
      }
      str = paramld.cBn.intent.getStringExtra("rawUrl");
      ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
      paramld.cBn.intent.putExtra("start_activity_time", System.currentTimeMillis());
      switch (paramld.cBn.type)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        long l = System.currentTimeMillis() - npm;
        ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[] { Long.valueOf(l) });
        try
        {
          paramld.cBn.context = null;
          label293:
          com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.wepkg.utils.d.akM(str), null, -1L, l, null);
          AppMethodBeat.o(111478);
          break;
          localContext = ah.getContext();
          break label144;
          com.tencent.mm.bq.d.b(localContext, "webview", ".ui.tools.game.GameWebViewUI", paramld.cBn.intent);
          continue;
          com.tencent.mm.bq.d.b(localContext, "webview", ".ui.tools.TransparentWebViewUI", paramld.cBn.intent);
          continue;
          if (paramBundle != null) {
            bool = paramBundle.getBoolean("has_preload_webcore", false);
          }
          paramBundle = new aw.5(this, localContext, paramld);
          if (bool) {}
          for (l = 100L;; l = 0L)
          {
            l.postDelayed(paramBundle, l);
            break;
          }
        }
        catch (Exception paramld)
        {
          break label293;
        }
      }
    }
  }
  
  private static void a(com.tencent.mm.ipcinvoker.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(111481);
    if (paramc != null) {
      paramc.ad(paramBundle);
    }
    AppMethodBeat.o(111481);
  }
  
  private boolean a(final ld paramld)
  {
    AppMethodBeat.i(111477);
    ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", new Object[] { Integer.valueOf(paramld.cBn.type) });
    if (paramld.cBn.intent == null)
    {
      AppMethodBeat.o(111477);
      return false;
    }
    if (paramld.cBn.type == 3)
    {
      ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.npq), Long.valueOf(this.npq) });
      if (System.currentTimeMillis() - this.npq < 500L)
      {
        ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
        AppMethodBeat.o(111477);
        return false;
      }
    }
    this.npq = System.currentTimeMillis();
    switch (paramld.cBn.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111477);
      return false;
      int i = paramld.cBn.type;
      int j = hashCode();
      int k = paramld.hashCode();
      long l = Thread.currentThread().getId();
      boolean bool;
      label222:
      Object localObject1;
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        bool = true;
        ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l), Boolean.valueOf(bool) });
        localObject1 = "";
      }
      try
      {
        str = paramld.cBn.intent.getStringExtra("rawUrl");
        localObject1 = str;
      }
      catch (Exception localException)
      {
        String str;
        label296:
        break label296;
      }
      str = paramld.cBn.intent.getStringExtra("game_float_layer_url");
      try
      {
        if (bo.nullAsNil(cJr).equalsIgnoreCase((String)localObject1))
        {
          ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
          return false;
          bool = false;
          break label222;
        }
        cJr = (String)localObject1;
        npm = System.currentTimeMillis();
        npn = System.currentTimeMillis();
        if (ah.brt()) {
          com.tencent.mm.plugin.wepkg.utils.b.vGZ = com.tencent.mm.plugin.game.commlib.a.bFd();
        }
        if (com.tencent.mm.plugin.wepkg.utils.d.akP((String)localObject1))
        {
          ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.akM((String)localObject1) });
          Object localObject2 = g.w(bo.nullAsNil((String)localObject1).getBytes()) + "_" + System.currentTimeMillis();
          paramld.cBn.group = ((String)localObject2);
          this.npr = new aw.b(this, paramld);
          al.p(this.npr, 500L);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("is_wepkg_disable", com.tencent.mm.plugin.wepkg.utils.b.vGZ);
          ((Bundle)localObject2).putString("call_raw_url", (String)localObject1);
          if (!bo.isNullOrNil(str)) {
            ((Bundle)localObject2).putString("float_layer_url", str);
          }
          if (paramld.cBn.type == 2) {
            ((Bundle)localObject2).putBoolean("is_luggage", true);
          }
          ToolsProcessIPCService.a((Parcelable)localObject2, aw.a.class, new aw.1(this, paramld));
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(111477);
      }
      ab.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + com.tencent.mm.plugin.wepkg.utils.b.vGZ);
      a(paramld, null);
      continue;
      paramld = paramld.cBn.intent.getStringExtra("rawUrl");
      if ((!npp.contains(paramld)) && (com.tencent.mm.plugin.wepkg.utils.d.akP(paramld)))
      {
        npp.add(paramld);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("call_raw_url", paramld);
        ((Bundle)localObject1).putBoolean("preload_webcore", true);
        ((Bundle)localObject1).putBoolean("is_luggage", true);
        ToolsProcessIPCService.a((Parcelable)localObject1, aw.a.class, new com.tencent.mm.ipcinvoker.c() {});
        l.postDelayed(new aw.3(this, paramld), 10000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw
 * JD-Core Version:    0.7.0.1
 */