package com.tencent.mm.plugin.hardcoder;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.b.i;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PluginHardcoder
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, b
{
  private static String Jmx = "OPPO A57|OPPO R11t|PRO 7 Plus|M15|15 Lite|15 Plus|MP16|MP17|SM-N9600|SM-N9608|MI 8|Nokia X7|Nokia X6|HLTE311T|HLTE213T";
  private static String Jmy = "OPPO|vivo|Xiaomi|meizu|Meizu|samsung|Meitu|HMD Global|Hisense|asus|Lenovo|HUAWEI|GREE|TOSOT";
  private Runnable JmA;
  private IListener Jmz;
  
  public PluginHardcoder()
  {
    AppMethodBeat.i(130770);
    this.Jmz = new IListener(com.tencent.mm.app.f.hfK) {};
    this.JmA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267132);
        Log.i("MicroMsg.PluginHardcoder", "reportHardcoderRunnable start to run");
        h.baF();
        long l1 = ((Long)h.baE().ban().get(at.a.acNU, Long.valueOf(0L))).longValue();
        long l2 = System.currentTimeMillis();
        if ((l2 - l1 > 86400000L) || (l1 > l2))
        {
          h.baF();
          h.baE().ban().set(at.a.acNU, Long.valueOf(l2));
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(267134);
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
                AppMethodBeat.o(267134);
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
        AppMethodBeat.o(267132);
      }
    };
    AppMethodBeat.o(130770);
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
        WXHardCoderJNI.initHardCoder(a.fKh(), a.fKh(), new PluginHardcoder.1.1(this));
        long l2 = SystemClock.elapsedRealtime();
        Log.i("MicroMsg.PluginHardcoder", "configure initHardCoder[%d %d %d %d] take[%d]ms tid[%s, %s]", new Object[] { Long.valueOf(com.tencent.mm.kernel.a.a.mDT), Long.valueOf(com.tencent.mm.kernel.a.a.mDU), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - com.tencent.mm.kernel.a.a.mDT), localThread.getName(), Long.valueOf(localThread.getId()) });
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
      this.Jmz.alive();
      reloadHardcoderConfig();
      paramc = MMApplicationContext.getContext().getSharedPreferences("hardcoder_setting", 0);
      h.baF();
      h.baC();
      if (com.tencent.mm.kernel.b.getUin() != 0)
      {
        h.baF();
        h.baC();
        int i = i.jdMethod_do(com.tencent.mm.kernel.b.getUin(), 100);
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
    if (MMApplicationContext.isMMProcess()) {
      this.Jmz.dead();
    }
    AppMethodBeat.o(130775);
  }
  
  public void reloadHardcoderConfig()
  {
    AppMethodBeat.i(130776);
    SharedPreferences.Editor localEditor = MMApplicationContext.getContext().getSharedPreferences("hardcoder_setting", 0).edit();
    Object localObject1 = com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_enable", "1", false, true);
    int i;
    label55:
    boolean bool1;
    label69:
    label103:
    label115:
    int j;
    label149:
    label161:
    long l;
    if (WXHardCoderJNI.getEnable())
    {
      i = 1;
      if (Util.getInt((String)localObject1, i) <= 0) {
        break label369;
      }
      bool2 = true;
      if ((!bool2) || (WXHardCoderJNI.getEnable())) {
        break label375;
      }
      bool1 = true;
      localEditor.putBoolean("KEY_HC_ENABLE", bool2);
      localObject1 = com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_bgenable", "1", false, true);
      if (!WXHardCoderJNI.hcBgEnable) {
        break label381;
      }
      i = 1;
      if (Util.getInt((String)localObject1, i) <= 0) {
        break label386;
      }
      bool2 = true;
      localEditor.putBoolean("KEY_HC_BG_ENABLE", bool2);
      localObject1 = com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_debug", "1", false, true);
      if (!WXHardCoderJNI.getDebug()) {
        break label392;
      }
      i = 1;
      if (Util.getInt((String)localObject1, i) <= 0) {
        break label397;
      }
      bool2 = true;
      localEditor.putBoolean("KEY_HC_DEBUG", bool2);
      localEditor.putInt("KEY_HC_KV_PER", Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_kvper", "50", false, true), WXHardCoderJNI.hcUinHash));
      localEditor.putInt("KEY_HC_KV_FT", Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_kvft", "30", false, true), WXHardCoderJNI.hcUinHash));
      h.baF();
      h.baC();
      j = i.jdMethod_do(com.tencent.mm.kernel.b.getUin(), 100);
      localEditor.putInt("KEY_HC_UIN_HASH", j);
      l = Util.getLong(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_scene", "523518", false, true), -1L);
      localObject1 = WXHardCoderJNI.flagKeyMap.entrySet().iterator();
      label291:
      if (!((Iterator)localObject1).hasNext()) {
        break label409;
      }
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      str1 = (String)((Map.Entry)localObject2).getValue();
      if ((((Long)((Map.Entry)localObject2).getKey()).longValue() & l) == 0L) {
        break label403;
      }
    }
    label386:
    label392:
    label397:
    label403:
    for (boolean bool2 = true;; bool2 = false)
    {
      localEditor.putBoolean(str1, bool2);
      break label291;
      i = 0;
      break;
      label369:
      bool2 = false;
      break label55;
      label375:
      bool1 = false;
      break label69;
      label381:
      i = 0;
      break label103;
      bool2 = false;
      break label115;
      i = 0;
      break label149;
      bool2 = false;
      break label161;
    }
    label409:
    int k = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_margin", "30", false, true), WXHardCoderJNI.hcTimeoutMargin);
    localEditor.putInt("KEY_HC_TIMEOUT_MARGIN", k);
    int m = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_retryitv", "300", false, true), WXHardCoderJNI.hcRetryInterval);
    localEditor.putInt("KEY_HC_RETRY_INTERVAL", m);
    localObject1 = Util.nullAs(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_model", Jmx, false, true), Jmx);
    Object localObject2 = com.tencent.mm.compatible.deviceinfo.q.aPo();
    String str1 = Util.nullAs(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_manufacturer", Jmy, false, true), Jmy);
    String str2 = Build.MANUFACTURER;
    if ((str1.length() > 0) || (((String)localObject1).length() > 0))
    {
      bool2 = str1.contains(str2);
      if (bool2) {
        break label801;
      }
      bool2 = ((String)localObject1).contains((CharSequence)localObject2);
    }
    label784:
    label801:
    for (;;)
    {
      if (bool2)
      {
        i = 10;
        WXHardCoderJNI.reportIDKey(true, i, 1, true);
        localEditor.putBoolean("KEY_HC_ENABLE", bool2);
        if ((!bool2) || (WXHardCoderJNI.getEnable())) {
          break label784;
        }
        bool1 = true;
        label610:
        Log.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig check manufacturer[%s] manufacturerlist[%s] model[%s] modellist[%s] enable[%b] init[%b]", new Object[] { str2, str1, localObject2, localObject1, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      }
      for (;;)
      {
        localEditor.apply();
        Log.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig enable[%b] init[%b] bgEnable[%b] debug[%b] uinHash[%d] kv[%b, %b] sceneFlag[%d] margin[%d] retryInterval[%d] model[%s]", new Object[] { Boolean.valueOf(WXHardCoderJNI.getEnable()), Boolean.valueOf(bool1), Boolean.valueOf(WXHardCoderJNI.hcBgEnable), Boolean.valueOf(WXHardCoderJNI.getDebug()), Integer.valueOf(j), Boolean.valueOf(WXHardCoderJNI.hcKVPerReport), Boolean.valueOf(WXHardCoderJNI.hcKVFtReport), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(m), localObject1 });
        AppMethodBeat.o(130776);
        return;
        i = 11;
        break;
        bool1 = false;
        break label610;
        WXHardCoderJNI.reportIDKey(true, 12, 1, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder
 * JD-Core Version:    0.7.0.1
 */