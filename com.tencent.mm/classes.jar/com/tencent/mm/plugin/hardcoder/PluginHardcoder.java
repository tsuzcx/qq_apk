package com.tencent.mm.plugin.hardcoder;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hardcoder.WXHardCoderJNI.GetParametersCallback;
import com.tencent.mm.hardcoder.WXHardCoderJNI.SystemEventCallback;
import com.tencent.mm.hardcoder.c.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginHardcoder
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, b
{
  private k.a gQD;
  private com.tencent.mm.sdk.b.c sut;
  private Runnable suu;
  
  public PluginHardcoder()
  {
    AppMethodBeat.i(130770);
    this.gQD = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(130766);
        ad.i("MicroMsg.PluginHardcoder", "abTestListener onNotifyChange stack[%s]", new Object[] { bt.eGN() });
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
          com.tencent.mm.kernel.g.afE().m(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(130765);
              PluginHardcoder.access$000(PluginHardcoder.this);
              AppMethodBeat.o(130765);
            }
          }, 100L);
        }
        AppMethodBeat.o(130766);
      }
    };
    this.sut = new com.tencent.mm.sdk.b.c() {};
    this.suu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130769);
        ad.i("MicroMsg.PluginHardcoder", "reportHardcoderRunnable start to run");
        com.tencent.mm.kernel.g.afC();
        long l1 = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FlT, Long.valueOf(0L))).longValue();
        long l2 = System.currentTimeMillis();
        if ((l2 - l1 > 86400000L) || (l1 > l2))
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FlT, Long.valueOf(l2));
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(130768);
              long l = Thread.currentThread().getId();
              String str = Thread.currentThread().getName();
              boolean bool;
              if ((WXHardCoderJNI.isCheckEnv()) && (WXHardCoderJNI.isRunning() > 0))
              {
                bool = true;
                ad.i("MicroMsg.PluginHardcoder", "reportHardCoder tid[%d, %s], running[%b]", new Object[] { Long.valueOf(l), str, Boolean.valueOf(bool) });
                WXHardCoderJNI.reportIDKey(true, 0, 1, false);
                WXHardCoderJNI.readServerAddr(true);
                if ((!WXHardCoderJNI.isCheckEnv()) || (WXHardCoderJNI.isRunning() <= 0)) {
                  break label127;
                }
                i = 4;
                label92:
                WXHardCoderJNI.reportIDKey(true, i, 1, false);
                if (!WXHardCoderJNI.isHCEnable()) {
                  break label132;
                }
              }
              label132:
              for (int i = 6;; i = 7)
              {
                WXHardCoderJNI.reportIDKey(true, i, 1, false);
                AppMethodBeat.o(130768);
                return;
                bool = false;
                break;
                label127:
                i = 5;
                break label92;
              }
            }
          }, "reportHardCoder");
        }
        AppMethodBeat.o(130769);
      }
    };
    AppMethodBeat.o(130770);
  }
  
  private void reloadHardcoderConfig()
  {
    AppMethodBeat.i(130776);
    Object localObject1 = com.tencent.mm.model.c.d.aty().qu("100282");
    ad.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest[%s][%b][%s]", new Object[] { localObject1, Boolean.valueOf(((com.tencent.mm.storage.c)localObject1).isValid()), ((com.tencent.mm.storage.c)localObject1).eJy() });
    SharedPreferences.Editor localEditor;
    Object localObject2;
    int i;
    boolean bool2;
    label122:
    boolean bool1;
    label136:
    label170:
    label182:
    label216:
    label228:
    int j;
    long l;
    label357:
    Object localObject3;
    String str;
    label435:
    label441:
    label447:
    label452:
    label458:
    label463:
    label469:
    label475:
    int k;
    int m;
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      ad.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest valid!");
      localEditor = aj.getContext().getSharedPreferences("hardcoder_setting", 0).edit();
      localObject1 = ((com.tencent.mm.storage.c)localObject1).eJy();
      localObject2 = (String)((Map)localObject1).get("enable");
      if (WXHardCoderJNI.getEnable())
      {
        i = 1;
        if (bt.getInt((String)localObject2, i) <= 0) {
          break label435;
        }
        bool2 = true;
        if ((!bool2) || (WXHardCoderJNI.getEnable())) {
          break label441;
        }
        bool1 = true;
        localEditor.putBoolean("KEY_HC_ENABLE", bool2);
        localObject2 = (String)((Map)localObject1).get("bgenable");
        if (!WXHardCoderJNI.hcBgEnable) {
          break label447;
        }
        i = 1;
        if (bt.getInt((String)localObject2, i) <= 0) {
          break label452;
        }
        bool2 = true;
        localEditor.putBoolean("KEY_HC_BG_ENABLE", bool2);
        localObject2 = (String)((Map)localObject1).get("debug");
        if (!WXHardCoderJNI.getDebug()) {
          break label458;
        }
        i = 1;
        if (bt.getInt((String)localObject2, i) <= 0) {
          break label463;
        }
        bool2 = true;
        localEditor.putBoolean("KEY_HC_DEBUG", bool2);
        localEditor.putInt("KEY_HC_KV_PER", bt.getInt((String)((Map)localObject1).get("kvper"), WXHardCoderJNI.hcUinHash));
        localEditor.putInt("KEY_HC_KV_FT", bt.getInt((String)((Map)localObject1).get("kvft"), WXHardCoderJNI.hcUinHash));
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afz();
        j = i.cf(com.tencent.mm.kernel.a.getUin(), 100);
        localEditor.putInt("KEY_HC_UIN_HASH", j);
        l = bt.getLong((String)((Map)localObject1).get("scene"), -1L);
        localObject2 = WXHardCoderJNI.flagKeyMap.entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label475;
        }
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        str = (String)((Map.Entry)localObject3).getValue();
        if ((((Long)((Map.Entry)localObject3).getKey()).longValue() & l) == 0L) {
          break label469;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        localEditor.putBoolean(str, bool2);
        break label357;
        i = 0;
        break;
        bool2 = false;
        break label122;
        bool1 = false;
        break label136;
        i = 0;
        break label170;
        bool2 = false;
        break label182;
        i = 0;
        break label216;
        bool2 = false;
        break label228;
      }
      k = bt.getInt((String)((Map)localObject1).get("margin"), WXHardCoderJNI.hcTimeoutMargin);
      localEditor.putInt("KEY_HC_TIMEOUT_MARGIN", k);
      m = bt.getInt((String)((Map)localObject1).get("retryitv"), WXHardCoderJNI.hcRetryInterval);
      localEditor.putInt("KEY_HC_RETRY_INTERVAL", m);
      localObject2 = bt.by((String)((Map)localObject1).get("model"), "");
      localObject3 = Build.MODEL;
      localObject1 = bt.by((String)((Map)localObject1).get("manufacturer"), "");
      str = Build.MANUFACTURER;
      if ((((String)localObject1).length() <= 0) && (((String)localObject2).length() <= 0)) {
        break label875;
      }
      bool2 = ((String)localObject1).contains(str);
      if (bool2) {
        break label886;
      }
      bool2 = ((String)localObject2).contains((CharSequence)localObject3);
    }
    label673:
    label869:
    label875:
    label886:
    for (;;)
    {
      if (bool2)
      {
        i = 10;
        WXHardCoderJNI.reportIDKey(true, i, 1, true);
        localEditor.putBoolean("KEY_HC_ENABLE", bool2);
        if ((!bool2) || (WXHardCoderJNI.getEnable())) {
          break label869;
        }
        bool1 = true;
        ad.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig check manufacturer[%s] manufacturerlist[%s] model[%s] modellist[%s] enable[%b] init[%b]", new Object[] { str, localObject1, localObject3, localObject2, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      }
      for (;;)
      {
        localEditor.apply();
        WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_ABTEST);
        ad.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig enable[%b] init[%b] bgEnable[%b] debug[%b] uinHash[%d] kv[%b, %b] sceneFlag[%d] margin[%d] retryInterval[%d] model[%s]", new Object[] { Boolean.valueOf(WXHardCoderJNI.getEnable()), Boolean.valueOf(bool1), Boolean.valueOf(WXHardCoderJNI.hcBgEnable), Boolean.valueOf(WXHardCoderJNI.getDebug()), Integer.valueOf(j), Boolean.valueOf(WXHardCoderJNI.hcKVPerReport), Boolean.valueOf(WXHardCoderJNI.hcKVFtReport), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(m), localObject2 });
        if (bool1) {
          WXHardCoderJNI.initHardCoder(a.cFF(), a.cFF(), null);
        }
        AppMethodBeat.o(130776);
        return;
        i = 11;
        break;
        bool1 = false;
        break label673;
        WXHardCoderJNI.reportIDKey(true, 12, 1, true);
      }
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(130773);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130764);
        Thread localThread = Thread.currentThread();
        long l1 = SystemClock.elapsedRealtime();
        WXHardCoderJNI.initHardCoder(a.cFF(), a.cFF(), new c.a()
        {
          public final void dt(boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(130763);
            ad.i("MicroMsg.PluginHardcoder", "configure initHardCoder callback, connect:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
            if ((paramAnonymous2Boolean) && (aj.cbv()))
            {
              WXHardCoderJNI.registerSystemEventCallback(new WXHardCoderJNI.SystemEventCallback()
              {
                public final void onEvent(int paramAnonymous3Int)
                {
                  AppMethodBeat.i(130761);
                  ad.i("MicroMsg.PluginHardcoder", "configure SystemEventCallback onEvent eventCode[%d]", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  jj localjj = new jj();
                  localjj.dnz.keycode = paramAnonymous3Int;
                  com.tencent.mm.sdk.b.a.ESL.l(localjj);
                  AppMethodBeat.o(130761);
                }
              });
              ad.i("MicroMsg.PluginHardcoder", "configure registerGetParametersCallback ret:%d", new Object[] { Integer.valueOf(WXHardCoderJNI.registerGetParametersCallback(1, new WXHardCoderJNI.GetParametersCallback()
              {
                public final void onGetParameters(int paramAnonymous3Int, JSONObject paramAnonymous3JSONObject)
                {
                  AppMethodBeat.i(130762);
                  ad.i("MicroMsg.PluginHardcoder", "configure GetParametersCallback onGetParameters type[%d]", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  if (paramAnonymous3Int == 1) {
                    try
                    {
                      String str1 = paramAnonymous3JSONObject.getString("HCMinQPKey");
                      String str2 = paramAnonymous3JSONObject.getString("HCMaxQPKey");
                      paramAnonymous3JSONObject = paramAnonymous3JSONObject.getString("HCQPSceneKey");
                      ad.i("MicroMsg.PluginHardcoder", "onGetParameters, minkey:%s, maxKey:%s, sceneKey:%s", new Object[] { str1, str2, paramAnonymous3JSONObject });
                      ax localax = ax.aFC("HardcoderQP");
                      localax.encode("HCMinQPKey", str1);
                      localax.encode("HCMaxQPKey", str2);
                      localax.encode("HCQPSceneKey", paramAnonymous3JSONObject);
                      AppMethodBeat.o(130762);
                      return;
                    }
                    catch (JSONException paramAnonymous3JSONObject) {}
                  }
                  AppMethodBeat.o(130762);
                }
              }, new String[] { "HCMinQPKey", "HCMaxQPKey", "HCQPSceneKey" })) });
            }
            AppMethodBeat.o(130763);
          }
        });
        long l2 = SystemClock.elapsedRealtime();
        ad.i("MicroMsg.PluginHardcoder", "configure initHardCoder[%d %d %d %d] take[%d]ms tid[%s, %s]", new Object[] { Long.valueOf(com.tencent.mm.kernel.a.a.ged), Long.valueOf(com.tencent.mm.kernel.a.a.gee), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - com.tencent.mm.kernel.a.a.ged), localThread.getName(), Long.valueOf(localThread.getId()) });
        AppMethodBeat.o(130764);
      }
    }, "initHardCoder");
    AppMethodBeat.o(130773);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(130772);
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    dependsOn(com.tencent.mm.plugin.report.c.class);
    AppMethodBeat.o(130772);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(130771);
    alias(b.class);
    AppMethodBeat.o(130771);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(130774);
    if (aj.cbv())
    {
      com.tencent.mm.sdk.b.a.ESL.b(this.sut);
      com.tencent.mm.model.c.d.aty().add(this.gQD);
      ad.i("MicroMsg.PluginHardcoder", "onAccountInitialized abTestListener[%s]", new Object[] { this.gQD });
      paramc = aj.getContext().getSharedPreferences("hardcoder_setting", 0);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afz();
      if (com.tencent.mm.kernel.a.getUin() != 0)
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afz();
        int i = i.cf(com.tencent.mm.kernel.a.getUin(), 100);
        if (i != paramc.getInt("KEY_HC_UIN_HASH", 0))
        {
          ad.i("MicroMsg.PluginHardcoder", "onAccountInitialized hardcoder uinHash[%d] reloadSPConfig", new Object[] { Integer.valueOf(i) });
          paramc.edit().putInt("KEY_HC_UIN_HASH", i).apply();
          WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_POST_RESET);
        }
      }
    }
    AppMethodBeat.o(130774);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(130775);
    if (aj.cbv())
    {
      com.tencent.mm.model.c.d.aty().remove(this.gQD);
      com.tencent.mm.sdk.b.a.ESL.d(this.sut);
    }
    AppMethodBeat.o(130775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder
 * JD-Core Version:    0.7.0.1
 */