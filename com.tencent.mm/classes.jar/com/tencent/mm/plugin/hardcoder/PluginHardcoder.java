package com.tencent.mm.plugin.hardcoder;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PluginHardcoder
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, b
{
  private IListener Dti;
  private Runnable Dtj;
  private MStorage.IOnStorageChange lxt;
  
  public PluginHardcoder()
  {
    AppMethodBeat.i(130770);
    this.lxt = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(130766);
        Log.i("MicroMsg.PluginHardcoder", "abTestListener onNotifyChange stack[%s]", new Object[] { Util.getStack() });
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
          h.aHJ().postToWorkerDelayed(new Runnable()
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
    this.Dti = new IListener() {};
    this.Dtj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130769);
        Log.i("MicroMsg.PluginHardcoder", "reportHardcoderRunnable start to run");
        h.aHH();
        long l1 = ((Long)h.aHG().aHp().get(ar.a.Vmz, Long.valueOf(0L))).longValue();
        long l2 = System.currentTimeMillis();
        if ((l2 - l1 > 86400000L) || (l1 > l2))
        {
          h.aHH();
          h.aHG().aHp().set(ar.a.Vmz, Long.valueOf(l2));
          ThreadPool.post(new Runnable()
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
                Log.i("MicroMsg.PluginHardcoder", "reportHardCoder tid[%d, %s], running[%b]", new Object[] { Long.valueOf(l), str, Boolean.valueOf(bool) });
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
    Object localObject1 = com.tencent.mm.model.c.d.bgB().Mu("100282");
    Log.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest[%s][%b][%s]", new Object[] { localObject1, Boolean.valueOf(((com.tencent.mm.storage.c)localObject1).isValid()), ((com.tencent.mm.storage.c)localObject1).hvz() });
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
      Log.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest valid!");
      localEditor = MMApplicationContext.getContext().getSharedPreferences("hardcoder_setting", 0).edit();
      localObject1 = ((com.tencent.mm.storage.c)localObject1).hvz();
      localObject2 = (String)((Map)localObject1).get("enable");
      if (WXHardCoderJNI.getEnable())
      {
        i = 1;
        if (Util.getInt((String)localObject2, i) <= 0) {
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
        if (Util.getInt((String)localObject2, i) <= 0) {
          break label452;
        }
        bool2 = true;
        localEditor.putBoolean("KEY_HC_BG_ENABLE", bool2);
        localObject2 = (String)((Map)localObject1).get("debug");
        if (!WXHardCoderJNI.getDebug()) {
          break label458;
        }
        i = 1;
        if (Util.getInt((String)localObject2, i) <= 0) {
          break label463;
        }
        bool2 = true;
        localEditor.putBoolean("KEY_HC_DEBUG", bool2);
        localEditor.putInt("KEY_HC_KV_PER", Util.getInt((String)((Map)localObject1).get("kvper"), WXHardCoderJNI.hcUinHash));
        localEditor.putInt("KEY_HC_KV_FT", Util.getInt((String)((Map)localObject1).get("kvft"), WXHardCoderJNI.hcUinHash));
        h.aHH();
        h.aHE();
        j = i.cA(com.tencent.mm.kernel.b.getUin(), 100);
        localEditor.putInt("KEY_HC_UIN_HASH", j);
        l = Util.getLong((String)((Map)localObject1).get("scene"), -1L);
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
      k = Util.getInt((String)((Map)localObject1).get("margin"), WXHardCoderJNI.hcTimeoutMargin);
      localEditor.putInt("KEY_HC_TIMEOUT_MARGIN", k);
      m = Util.getInt((String)((Map)localObject1).get("retryitv"), WXHardCoderJNI.hcRetryInterval);
      localEditor.putInt("KEY_HC_RETRY_INTERVAL", m);
      localObject2 = Util.nullAs((String)((Map)localObject1).get("model"), "");
      localObject3 = Build.MODEL;
      localObject1 = Util.nullAs((String)((Map)localObject1).get("manufacturer"), "");
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
        Log.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig check manufacturer[%s] manufacturerlist[%s] model[%s] modellist[%s] enable[%b] init[%b]", new Object[] { str, localObject1, localObject3, localObject2, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      }
      for (;;)
      {
        localEditor.apply();
        WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_ABTEST);
        Log.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig enable[%b] init[%b] bgEnable[%b] debug[%b] uinHash[%d] kv[%b, %b] sceneFlag[%d] margin[%d] retryInterval[%d] model[%s]", new Object[] { Boolean.valueOf(WXHardCoderJNI.getEnable()), Boolean.valueOf(bool1), Boolean.valueOf(WXHardCoderJNI.hcBgEnable), Boolean.valueOf(WXHardCoderJNI.getDebug()), Integer.valueOf(j), Boolean.valueOf(WXHardCoderJNI.hcKVPerReport), Boolean.valueOf(WXHardCoderJNI.hcKVFtReport), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(m), localObject2 });
        if (bool1) {
          WXHardCoderJNI.initHardCoder(a.eCg(), a.eCg(), null);
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
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(130773);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130764);
        Thread localThread = Thread.currentThread();
        long l1 = SystemClock.elapsedRealtime();
        WXHardCoderJNI.initHardCoder(a.eCg(), a.eCg(), new PluginHardcoder.1.1(this));
        long l2 = SystemClock.elapsedRealtime();
        Log.i("MicroMsg.PluginHardcoder", "configure initHardCoder[%d %d %d %d] take[%d]ms tid[%s, %s]", new Object[] { Long.valueOf(com.tencent.mm.kernel.a.a.kdJ), Long.valueOf(com.tencent.mm.kernel.a.a.kdK), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - com.tencent.mm.kernel.a.a.kdJ), localThread.getName(), Long.valueOf(localThread.getId()) });
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
  
  public void execute(g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(130771);
    alias(b.class);
    AppMethodBeat.o(130771);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(130774);
    if (MMApplicationContext.isMMProcess())
    {
      EventCenter.instance.add(this.Dti);
      com.tencent.mm.model.c.d.bgB().add(this.lxt);
      Log.i("MicroMsg.PluginHardcoder", "onAccountInitialized abTestListener[%s]", new Object[] { this.lxt });
      paramc = MMApplicationContext.getContext().getSharedPreferences("hardcoder_setting", 0);
      h.aHH();
      h.aHE();
      if (com.tencent.mm.kernel.b.getUin() != 0)
      {
        h.aHH();
        h.aHE();
        int i = i.cA(com.tencent.mm.kernel.b.getUin(), 100);
        if (i != paramc.getInt("KEY_HC_UIN_HASH", 0))
        {
          Log.i("MicroMsg.PluginHardcoder", "onAccountInitialized hardcoder uinHash[%d] reloadSPConfig", new Object[] { Integer.valueOf(i) });
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
    if (MMApplicationContext.isMMProcess())
    {
      com.tencent.mm.model.c.d.bgB().remove(this.lxt);
      EventCenter.instance.removeListener(this.Dti);
    }
    AppMethodBeat.o(130775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder
 * JD-Core Version:    0.7.0.1
 */