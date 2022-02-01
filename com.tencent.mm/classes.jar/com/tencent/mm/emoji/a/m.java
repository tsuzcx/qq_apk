package com.tencent.mm.emoji.a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class m
{
  private static boolean gkB = false;
  private static boolean gkC = false;
  private static boolean gkD = false;
  private static boolean gkE = false;
  private static boolean gkF = false;
  private static boolean gkG = false;
  
  public static boolean aeT()
  {
    AppMethodBeat.i(104462);
    if ((com.tencent.mm.n.g.acA().getInt("EmotionRewardOption", 0) & 0x1) == 1)
    {
      AppMethodBeat.o(104462);
      return false;
    }
    AppMethodBeat.o(104462);
    return true;
  }
  
  public static boolean aeU()
  {
    AppMethodBeat.i(104463);
    if ((com.tencent.mm.n.g.acA().getInt("EmotionRewardOption", 0) & 0x2) == 2)
    {
      AppMethodBeat.o(104463);
      return false;
    }
    AppMethodBeat.o(104463);
    return true;
  }
  
  public static boolean aeV()
  {
    AppMethodBeat.i(104464);
    if ((com.tencent.mm.n.g.acA().getInt("EmotionRewardOption", 0) & 0x4) == 4)
    {
      AppMethodBeat.o(104464);
      return true;
    }
    AppMethodBeat.o(104464);
    return false;
  }
  
  public static int aeW()
  {
    AppMethodBeat.i(104465);
    int i = bt.getInt(com.tencent.mm.n.g.acA().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104465);
    return i;
  }
  
  public static int aeX()
  {
    AppMethodBeat.i(104466);
    int i = bt.getInt(com.tencent.mm.n.g.acA().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104466);
    return i;
  }
  
  public static String aeY()
  {
    AppMethodBeat.i(104467);
    String str = com.tencent.mm.n.g.acA().getValue("C2CEmojiNotAutoDownloadTimeRange");
    AppMethodBeat.o(104467);
    return str;
  }
  
  public static String aeZ()
  {
    AppMethodBeat.i(104468);
    String str = com.tencent.mm.n.g.acA().getValue("EmotionPanelConfigName");
    AppMethodBeat.o(104468);
    return str;
  }
  
  public static boolean afa()
  {
    AppMethodBeat.i(104469);
    if (!gkB)
    {
      int i = com.tencent.mm.n.g.acA().getInt("EnableEmoticonExternUrl", 0);
      int j = MMWXGFJNI.getErrorCode();
      if ((i & 0x1) != 1) {
        break label138;
      }
      if ((afh()) || (afi())) {
        break label131;
      }
      gkE = true;
      if (j < 0)
      {
        gkE = false;
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      gkB = true;
      ad.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[] { Boolean.valueOf(gkE) });
      boolean bool = gkE;
      AppMethodBeat.o(104469);
      return bool;
      label131:
      gkE = false;
      break;
      label138:
      gkE = false;
      break;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 5L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 6L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 7L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 8L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 9L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 10L, 1L, false);
    }
  }
  
  public static boolean afb()
  {
    AppMethodBeat.i(104470);
    int j;
    if (!gkC)
    {
      int i = com.tencent.mm.n.g.acA().getInt("EnableEmoticonExternUrl", 0);
      j = MMWXGFJNI.getErrorCode();
      if ((i & 0x2) != 2) {
        break label115;
      }
      if ((afh()) || (afi())) {
        break label103;
      }
      gkF = true;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 1L, 1L, false);
    }
    for (;;)
    {
      if (j < 0) {
        gkF = false;
      }
      gkC = true;
      ad.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[] { Boolean.valueOf(gkF) });
      boolean bool = gkF;
      AppMethodBeat.o(104470);
      return bool;
      label103:
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 0L, 1L, false);
      label115:
      gkF = false;
    }
  }
  
  public static boolean afc()
  {
    AppMethodBeat.i(104471);
    if (!gkD) {
      if ((com.tencent.mm.n.g.acA().getInt("EnableEmoticonExternUrl", 0) & 0x4) != 4) {
        break label65;
      }
    }
    label65:
    for (gkG = true;; gkG = false)
    {
      gkD = true;
      ad.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", new Object[] { Boolean.valueOf(gkG) });
      boolean bool = gkG;
      AppMethodBeat.o(104471);
      return bool;
    }
  }
  
  public static boolean afd()
  {
    AppMethodBeat.i(104472);
    if ((com.tencent.mm.n.g.acA().getInt("ShowEmoticonCameraEntrance", 3) & 0x1) > 0)
    {
      AppMethodBeat.o(104472);
      return true;
    }
    AppMethodBeat.o(104472);
    return false;
  }
  
  public static boolean afe()
  {
    AppMethodBeat.i(104473);
    if ((com.tencent.mm.n.g.acA().getInt("ShowEmoticonCameraEntrance", 3) & 0x2) > 0)
    {
      AppMethodBeat.o(104473);
      return true;
    }
    AppMethodBeat.o(104473);
    return false;
  }
  
  public static boolean aff()
  {
    AppMethodBeat.i(104475);
    if (com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IFJ, 1) == 0)
    {
      AppMethodBeat.o(104475);
      return true;
    }
    AppMethodBeat.o(104475);
    return false;
  }
  
  public static boolean afg()
  {
    AppMethodBeat.i(104476);
    if (com.tencent.mm.n.g.acA().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0)
    {
      AppMethodBeat.o(104476);
      return false;
    }
    AppMethodBeat.o(104476);
    return true;
  }
  
  private static boolean afh()
  {
    boolean bool = true;
    AppMethodBeat.i(104478);
    PackageManager localPackageManager = aj.getContext().getPackageManager();
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
  
  private static boolean afi()
  {
    boolean bool = true;
    AppMethodBeat.i(104479);
    PackageManager localPackageManager = aj.getContext().getPackageManager();
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
  
  public static boolean afj()
  {
    AppMethodBeat.i(104480);
    int i = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IFK, 0);
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
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qwz, false);
    AppMethodBeat.o(104480);
    return bool;
  }
  
  public static boolean isSpringFestivalEnable()
  {
    AppMethodBeat.i(104474);
    ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qwo, 0);
    com.tencent.mm.n.g.acA().getInt("EmotionSpringFestivalPendantSwitch", 0);
    AppMethodBeat.o(104474);
    return false;
  }
  
  public static boolean isStickerEnable()
  {
    AppMethodBeat.i(104477);
    int i = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IFO, 0);
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
    int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qwB, 9);
    AppMethodBeat.o(177029);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.m
 * JD-Core Version:    0.7.0.1
 */