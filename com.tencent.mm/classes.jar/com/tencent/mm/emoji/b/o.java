package com.tencent.mm.emoji.b;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class o
{
  private static boolean jIM = false;
  private static boolean jIN = false;
  private static boolean jIO = false;
  private static boolean jIP = false;
  private static boolean jIQ = false;
  private static boolean jIR = false;
  
  public static boolean aBQ()
  {
    AppMethodBeat.i(104462);
    if ((com.tencent.mm.n.h.axc().getInt("EmotionRewardOption", 0) & 0x1) == 1)
    {
      AppMethodBeat.o(104462);
      return false;
    }
    AppMethodBeat.o(104462);
    return true;
  }
  
  public static boolean aBR()
  {
    AppMethodBeat.i(104463);
    if ((com.tencent.mm.n.h.axc().getInt("EmotionRewardOption", 0) & 0x2) == 2)
    {
      AppMethodBeat.o(104463);
      return false;
    }
    AppMethodBeat.o(104463);
    return true;
  }
  
  public static boolean aBS()
  {
    AppMethodBeat.i(104464);
    if ((com.tencent.mm.n.h.axc().getInt("EmotionRewardOption", 0) & 0x4) == 4)
    {
      AppMethodBeat.o(104464);
      return true;
    }
    AppMethodBeat.o(104464);
    return false;
  }
  
  public static int aBT()
  {
    AppMethodBeat.i(104465);
    int i = Util.getInt(com.tencent.mm.n.h.axc().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104465);
    return i;
  }
  
  public static int aBU()
  {
    AppMethodBeat.i(104466);
    int i = Util.getInt(com.tencent.mm.n.h.axc().getValue("CaptureEmojiMaxSize"), 300);
    AppMethodBeat.o(104466);
    return i;
  }
  
  public static String aBV()
  {
    AppMethodBeat.i(104467);
    String str = com.tencent.mm.n.h.axc().getValue("C2CEmojiNotAutoDownloadTimeRange");
    AppMethodBeat.o(104467);
    return str;
  }
  
  public static String aBW()
  {
    AppMethodBeat.i(104468);
    String str = com.tencent.mm.n.h.axc().getValue("EmotionPanelConfigName");
    AppMethodBeat.o(104468);
    return str;
  }
  
  public static boolean aBX()
  {
    AppMethodBeat.i(104469);
    if (!jIM)
    {
      int i = com.tencent.mm.n.h.axc().getInt("EnableEmoticonExternUrl", 0);
      int j = MMWXGFJNI.getErrorCode();
      if ((i & 0x1) != 1) {
        break label138;
      }
      if ((aCe()) || (aCf())) {
        break label131;
      }
      jIP = true;
      if (j < 0)
      {
        jIP = false;
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      jIM = true;
      Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[] { Boolean.valueOf(jIP) });
      boolean bool = jIP;
      AppMethodBeat.o(104469);
      return bool;
      label131:
      jIP = false;
      break;
      label138:
      jIP = false;
      break;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 5L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 6L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 7L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 8L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 9L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 10L, 1L, false);
    }
  }
  
  public static boolean aBY()
  {
    AppMethodBeat.i(104470);
    int j;
    if (!jIN)
    {
      int i = com.tencent.mm.n.h.axc().getInt("EnableEmoticonExternUrl", 0);
      j = MMWXGFJNI.getErrorCode();
      if ((i & 0x2) != 2) {
        break label115;
      }
      if ((aCe()) || (aCf())) {
        break label103;
      }
      jIQ = true;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 1L, 1L, false);
    }
    for (;;)
    {
      if (j < 0) {
        jIQ = false;
      }
      jIN = true;
      Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[] { Boolean.valueOf(jIQ) });
      boolean bool = jIQ;
      AppMethodBeat.o(104470);
      return bool;
      label103:
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 0L, 1L, false);
      label115:
      jIQ = false;
    }
  }
  
  public static boolean aBZ()
  {
    AppMethodBeat.i(104471);
    if (!jIO) {
      if ((com.tencent.mm.n.h.axc().getInt("EnableEmoticonExternUrl", 0) & 0x4) != 4) {
        break label65;
      }
    }
    label65:
    for (jIR = true;; jIR = false)
    {
      jIO = true;
      Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", new Object[] { Boolean.valueOf(jIR) });
      boolean bool = jIR;
      AppMethodBeat.o(104471);
      return bool;
    }
  }
  
  public static boolean aCa()
  {
    AppMethodBeat.i(104472);
    if ((com.tencent.mm.n.h.axc().getInt("ShowEmoticonCameraEntrance", 3) & 0x1) > 0)
    {
      AppMethodBeat.o(104472);
      return true;
    }
    AppMethodBeat.o(104472);
    return false;
  }
  
  public static boolean aCb()
  {
    AppMethodBeat.i(104473);
    if ((com.tencent.mm.n.h.axc().getInt("ShowEmoticonCameraEntrance", 3) & 0x2) > 0)
    {
      AppMethodBeat.o(104473);
      return true;
    }
    AppMethodBeat.o(104473);
    return false;
  }
  
  public static boolean aCc()
  {
    AppMethodBeat.i(104475);
    if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vxf, 1) == 0)
    {
      AppMethodBeat.o(104475);
      return true;
    }
    AppMethodBeat.o(104475);
    return false;
  }
  
  public static boolean aCd()
  {
    AppMethodBeat.i(104476);
    if (com.tencent.mm.n.h.axc().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0)
    {
      AppMethodBeat.o(104476);
      return false;
    }
    AppMethodBeat.o(104476);
    return true;
  }
  
  private static boolean aCe()
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
  
  private static boolean aCf()
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
  
  public static boolean aCg()
  {
    AppMethodBeat.i(104480);
    int i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vxg, 0);
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
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vCX, false);
    AppMethodBeat.o(104480);
    return bool;
  }
  
  public static boolean isSpringFestivalEnable()
  {
    AppMethodBeat.i(104474);
    ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vCM, 0);
    com.tencent.mm.n.h.axc().getInt("EmotionSpringFestivalPendantSwitch", 0);
    AppMethodBeat.o(104474);
    return false;
  }
  
  public static boolean isStickerEnable()
  {
    AppMethodBeat.i(104477);
    int i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vxk, 0);
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
    int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vCZ, 9);
    AppMethodBeat.o(177029);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.o
 * JD-Core Version:    0.7.0.1
 */