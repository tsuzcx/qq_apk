package com.tencent.mm.emoji.b;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class n
{
  private static boolean gXN = false;
  private static boolean gXO = false;
  private static boolean gXP = false;
  private static boolean gXQ = false;
  private static boolean gXR = false;
  private static boolean gXS = false;
  
  public static boolean auV()
  {
    AppMethodBeat.i(104462);
    if ((com.tencent.mm.n.h.aqJ().getInt("EmotionRewardOption", 0) & 0x1) == 1)
    {
      AppMethodBeat.o(104462);
      return false;
    }
    AppMethodBeat.o(104462);
    return true;
  }
  
  public static boolean auW()
  {
    AppMethodBeat.i(104463);
    if ((com.tencent.mm.n.h.aqJ().getInt("EmotionRewardOption", 0) & 0x2) == 2)
    {
      AppMethodBeat.o(104463);
      return false;
    }
    AppMethodBeat.o(104463);
    return true;
  }
  
  public static boolean auX()
  {
    AppMethodBeat.i(104464);
    if ((com.tencent.mm.n.h.aqJ().getInt("EmotionRewardOption", 0) & 0x4) == 4)
    {
      AppMethodBeat.o(104464);
      return true;
    }
    AppMethodBeat.o(104464);
    return false;
  }
  
  public static int auY()
  {
    AppMethodBeat.i(104465);
    int i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104465);
    return i;
  }
  
  public static int auZ()
  {
    AppMethodBeat.i(104466);
    int i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104466);
    return i;
  }
  
  public static String ava()
  {
    AppMethodBeat.i(104467);
    String str = com.tencent.mm.n.h.aqJ().getValue("C2CEmojiNotAutoDownloadTimeRange");
    AppMethodBeat.o(104467);
    return str;
  }
  
  public static String avb()
  {
    AppMethodBeat.i(104468);
    String str = com.tencent.mm.n.h.aqJ().getValue("EmotionPanelConfigName");
    AppMethodBeat.o(104468);
    return str;
  }
  
  public static boolean avc()
  {
    AppMethodBeat.i(104469);
    if (!gXN)
    {
      int i = com.tencent.mm.n.h.aqJ().getInt("EnableEmoticonExternUrl", 0);
      int j = MMWXGFJNI.getErrorCode();
      if ((i & 0x1) != 1) {
        break label138;
      }
      if ((avj()) || (avk())) {
        break label131;
      }
      gXQ = true;
      if (j < 0)
      {
        gXQ = false;
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      gXN = true;
      Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[] { Boolean.valueOf(gXQ) });
      boolean bool = gXQ;
      AppMethodBeat.o(104469);
      return bool;
      label131:
      gXQ = false;
      break;
      label138:
      gXQ = false;
      break;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(711L, 5L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(711L, 6L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(711L, 7L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(711L, 8L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(711L, 9L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(711L, 10L, 1L, false);
    }
  }
  
  public static boolean avd()
  {
    AppMethodBeat.i(104470);
    int j;
    if (!gXO)
    {
      int i = com.tencent.mm.n.h.aqJ().getInt("EnableEmoticonExternUrl", 0);
      j = MMWXGFJNI.getErrorCode();
      if ((i & 0x2) != 2) {
        break label115;
      }
      if ((avj()) || (avk())) {
        break label103;
      }
      gXR = true;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(711L, 1L, 1L, false);
    }
    for (;;)
    {
      if (j < 0) {
        gXR = false;
      }
      gXO = true;
      Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[] { Boolean.valueOf(gXR) });
      boolean bool = gXR;
      AppMethodBeat.o(104470);
      return bool;
      label103:
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(711L, 0L, 1L, false);
      label115:
      gXR = false;
    }
  }
  
  public static boolean ave()
  {
    AppMethodBeat.i(104471);
    if (!gXP) {
      if ((com.tencent.mm.n.h.aqJ().getInt("EnableEmoticonExternUrl", 0) & 0x4) != 4) {
        break label65;
      }
    }
    label65:
    for (gXS = true;; gXS = false)
    {
      gXP = true;
      Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", new Object[] { Boolean.valueOf(gXS) });
      boolean bool = gXS;
      AppMethodBeat.o(104471);
      return bool;
    }
  }
  
  public static boolean avf()
  {
    AppMethodBeat.i(104472);
    if ((com.tencent.mm.n.h.aqJ().getInt("ShowEmoticonCameraEntrance", 3) & 0x1) > 0)
    {
      AppMethodBeat.o(104472);
      return true;
    }
    AppMethodBeat.o(104472);
    return false;
  }
  
  public static boolean avg()
  {
    AppMethodBeat.i(104473);
    if ((com.tencent.mm.n.h.aqJ().getInt("ShowEmoticonCameraEntrance", 3) & 0x2) > 0)
    {
      AppMethodBeat.o(104473);
      return true;
    }
    AppMethodBeat.o(104473);
    return false;
  }
  
  public static boolean avh()
  {
    AppMethodBeat.i(104475);
    if (g.aAh().azQ().getInt(ar.a.OiP, 1) == 0)
    {
      AppMethodBeat.o(104475);
      return true;
    }
    AppMethodBeat.o(104475);
    return false;
  }
  
  public static boolean avi()
  {
    AppMethodBeat.i(104476);
    if (com.tencent.mm.n.h.aqJ().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0)
    {
      AppMethodBeat.o(104476);
      return false;
    }
    AppMethodBeat.o(104476);
    return true;
  }
  
  private static boolean avj()
  {
    boolean bool = true;
    AppMethodBeat.i(104478);
    PackageManager localPackageManager = MMApplicationContext.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
      AppMethodBeat.o(104478);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
  
  private static boolean avk()
  {
    boolean bool = true;
    AppMethodBeat.i(104479);
    PackageManager localPackageManager = MMApplicationContext.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app", 1);
      AppMethodBeat.o(104479);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
  
  public static boolean avl()
  {
    AppMethodBeat.i(104480);
    int i = g.aAh().azQ().getInt(ar.a.OiQ, 0);
    if (i == 1)
    {
      AppMethodBeat.o(104480);
      return true;
    }
    if (i == 2)
    {
      AppMethodBeat.o(104480);
      return false;
    }
    boolean bool = ((b)g.af(b.class)).a(b.a.rWs, false);
    AppMethodBeat.o(104480);
    return bool;
  }
  
  public static boolean isSpringFestivalEnable()
  {
    AppMethodBeat.i(104474);
    ((b)g.af(b.class)).a(b.a.rWh, 0);
    com.tencent.mm.n.h.aqJ().getInt("EmotionSpringFestivalPendantSwitch", 0);
    AppMethodBeat.o(104474);
    return false;
  }
  
  public static boolean isStickerEnable()
  {
    AppMethodBeat.i(104477);
    int i = g.aAh().azQ().getInt(ar.a.OiU, 0);
    if (i == 1)
    {
      AppMethodBeat.o(104477);
      return true;
    }
    if (i == 2)
    {
      AppMethodBeat.o(104477);
      return false;
    }
    AppMethodBeat.o(104477);
    return true;
  }
  
  public static int stickerRecommendCount()
  {
    AppMethodBeat.i(177029);
    int i = ((b)g.af(b.class)).a(b.a.rWu, 9);
    AppMethodBeat.o(177029);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.n
 * JD-Core Version:    0.7.0.1
 */