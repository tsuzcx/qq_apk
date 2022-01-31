package com.tencent.mm.plugin.hardcoder;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PluginHardcoder
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, b
{
  private k.a foV;
  private com.tencent.mm.sdk.b.c nGN;
  private Runnable nGO;
  
  public PluginHardcoder()
  {
    AppMethodBeat.i(60256);
    this.foV = new PluginHardcoder.2(this);
    this.nGN = new PluginHardcoder.3(this);
    this.nGO = new PluginHardcoder.4(this);
    AppMethodBeat.o(60256);
  }
  
  private void reloadHardcoderConfig()
  {
    AppMethodBeat.i(60262);
    Object localObject1 = com.tencent.mm.model.c.c.abU().me("100282");
    ab.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest[%s][%b][%s]", new Object[] { localObject1, Boolean.valueOf(((com.tencent.mm.storage.c)localObject1).isValid()), ((com.tencent.mm.storage.c)localObject1).dvN() });
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
      ab.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest valid!");
      localEditor = ah.getContext().getSharedPreferences("hardcoder_setting", 0).edit();
      localObject1 = ((com.tencent.mm.storage.c)localObject1).dvN();
      localObject2 = (String)((Map)localObject1).get("enable");
      if (WXHardCoderJNI.getEnable())
      {
        i = 1;
        if (bo.getInt((String)localObject2, i) <= 0) {
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
        if (bo.getInt((String)localObject2, i) <= 0) {
          break label452;
        }
        bool2 = true;
        localEditor.putBoolean("KEY_HC_BG_ENABLE", bool2);
        localObject2 = (String)((Map)localObject1).get("debug");
        if (!WXHardCoderJNI.getDebug()) {
          break label458;
        }
        i = 1;
        if (bo.getInt((String)localObject2, i) <= 0) {
          break label463;
        }
        bool2 = true;
        localEditor.putBoolean("KEY_HC_DEBUG", bool2);
        localEditor.putInt("KEY_HC_KV_PER", bo.getInt((String)((Map)localObject1).get("kvper"), WXHardCoderJNI.hcUinHash));
        localEditor.putInt("KEY_HC_KV_FT", bo.getInt((String)((Map)localObject1).get("kvft"), WXHardCoderJNI.hcUinHash));
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RJ();
        j = i.bQ(com.tencent.mm.kernel.a.getUin(), 100);
        localEditor.putInt("KEY_HC_UIN_HASH", j);
        l = bo.getLong((String)((Map)localObject1).get("scene"), -1L);
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
      k = bo.getInt((String)((Map)localObject1).get("margin"), WXHardCoderJNI.hcTimeoutMargin);
      localEditor.putInt("KEY_HC_TIMEOUT_MARGIN", k);
      m = bo.getInt((String)((Map)localObject1).get("retryitv"), WXHardCoderJNI.hcRetryInterval);
      localEditor.putInt("KEY_HC_RETRY_INTERVAL", m);
      localObject2 = bo.bf((String)((Map)localObject1).get("model"), "");
      localObject3 = Build.MODEL;
      localObject1 = bo.bf((String)((Map)localObject1).get("manufacturer"), "");
      str = Build.MANUFACTURER;
      if ((((String)localObject1).length() <= 0) && (((String)localObject2).length() <= 0)) {
        break label873;
      }
      bool2 = ((String)localObject1).contains(str);
      if (bool2) {
        break label884;
      }
      bool2 = ((String)localObject2).contains((CharSequence)localObject3);
    }
    label672:
    label867:
    label873:
    label884:
    for (;;)
    {
      if (bool2)
      {
        i = 10;
        WXHardCoderJNI.reportIDKey(true, i, 1, true);
        localEditor.putBoolean("KEY_HC_ENABLE", bool2);
        if ((!bool2) || (WXHardCoderJNI.getEnable())) {
          break label867;
        }
        bool1 = true;
        ab.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig check manufacturer[%s] manufacturerlist[%s] model[%s] modellist[%s] enable[%b] init[%b]", new Object[] { str, localObject1, localObject3, localObject2, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      }
      for (;;)
      {
        localEditor.apply();
        WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_ABTEST);
        ab.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig enable[%b] init[%b] bgEnable[%b] debug[%b] uinHash[%d] kv[%b, %b] sceneFlag[%d] margin[%d] retryInterval[%d] model[%s]", new Object[] { Boolean.valueOf(WXHardCoderJNI.getEnable()), Boolean.valueOf(bool1), Boolean.valueOf(WXHardCoderJNI.hcBgEnable), Boolean.valueOf(WXHardCoderJNI.getDebug()), Integer.valueOf(j), Boolean.valueOf(WXHardCoderJNI.hcKVPerReport), Boolean.valueOf(WXHardCoderJNI.hcKVFtReport), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(m), localObject2 });
        if (bool1) {
          WXHardCoderJNI.initHardCoder(a.bHO(), a.bHO());
        }
        AppMethodBeat.o(60262);
        return;
        i = 11;
        break;
        bool1 = false;
        break label672;
        WXHardCoderJNI.reportIDKey(true, 12, 1, true);
      }
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(60259);
    com.tencent.mm.sdk.g.d.post(new PluginHardcoder.1(this), "initHardCoder");
    AppMethodBeat.o(60259);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(60258);
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    dependsOn(com.tencent.mm.plugin.report.c.class);
    AppMethodBeat.o(60258);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(60257);
    alias(b.class);
    AppMethodBeat.o(60257);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(60260);
    if (ah.brt())
    {
      com.tencent.mm.sdk.b.a.ymk.b(this.nGN);
      com.tencent.mm.model.c.c.abU().add(this.foV);
      ab.i("MicroMsg.PluginHardcoder", "onAccountInitialized abTestListener[%s]", new Object[] { this.foV });
      paramc = ah.getContext().getSharedPreferences("hardcoder_setting", 0);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RJ();
      if (com.tencent.mm.kernel.a.getUin() != 0)
      {
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RJ();
        int i = i.bQ(com.tencent.mm.kernel.a.getUin(), 100);
        if (i != paramc.getInt("KEY_HC_UIN_HASH", 0))
        {
          ab.i("MicroMsg.PluginHardcoder", "onAccountInitialized hardcoder uinHash[%d] reloadSPConfig", new Object[] { Integer.valueOf(i) });
          paramc.edit().putInt("KEY_HC_UIN_HASH", i).apply();
          WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_POST_RESET);
        }
      }
    }
    AppMethodBeat.o(60260);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(60261);
    if (ah.brt())
    {
      com.tencent.mm.model.c.c.abU().remove(this.foV);
      com.tencent.mm.sdk.b.a.ymk.d(this.nGN);
    }
    AppMethodBeat.o(60261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder
 * JD-Core Version:    0.7.0.1
 */