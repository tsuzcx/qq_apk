package com.tencent.mm.emoji.a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class m
{
  private static boolean gmV = false;
  private static boolean gmW = false;
  private static boolean gmX = false;
  private static boolean gmY = false;
  private static boolean gmZ = false;
  private static boolean gna = false;
  
  public static boolean afh()
  {
    AppMethodBeat.i(104462);
    if ((com.tencent.mm.n.g.acL().getInt("EmotionRewardOption", 0) & 0x1) == 1)
    {
      AppMethodBeat.o(104462);
      return false;
    }
    AppMethodBeat.o(104462);
    return true;
  }
  
  public static boolean afi()
  {
    AppMethodBeat.i(104463);
    if ((com.tencent.mm.n.g.acL().getInt("EmotionRewardOption", 0) & 0x2) == 2)
    {
      AppMethodBeat.o(104463);
      return false;
    }
    AppMethodBeat.o(104463);
    return true;
  }
  
  public static boolean afj()
  {
    AppMethodBeat.i(104464);
    if ((com.tencent.mm.n.g.acL().getInt("EmotionRewardOption", 0) & 0x4) == 4)
    {
      AppMethodBeat.o(104464);
      return true;
    }
    AppMethodBeat.o(104464);
    return false;
  }
  
  public static int afk()
  {
    AppMethodBeat.i(104465);
    int i = bu.getInt(com.tencent.mm.n.g.acL().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104465);
    return i;
  }
  
  public static int afl()
  {
    AppMethodBeat.i(104466);
    int i = bu.getInt(com.tencent.mm.n.g.acL().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104466);
    return i;
  }
  
  public static String afm()
  {
    AppMethodBeat.i(104467);
    String str = com.tencent.mm.n.g.acL().getValue("C2CEmojiNotAutoDownloadTimeRange");
    AppMethodBeat.o(104467);
    return str;
  }
  
  public static String afn()
  {
    AppMethodBeat.i(104468);
    String str = com.tencent.mm.n.g.acL().getValue("EmotionPanelConfigName");
    AppMethodBeat.o(104468);
    return str;
  }
  
  public static boolean afo()
  {
    AppMethodBeat.i(104469);
    if (!gmV)
    {
      int i = com.tencent.mm.n.g.acL().getInt("EnableEmoticonExternUrl", 0);
      int j = MMWXGFJNI.getErrorCode();
      if ((i & 0x1) != 1) {
        break label138;
      }
      if ((afv()) || (afw())) {
        break label131;
      }
      gmY = true;
      if (j < 0)
      {
        gmY = false;
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      gmV = true;
      ae.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[] { Boolean.valueOf(gmY) });
      boolean bool = gmY;
      AppMethodBeat.o(104469);
      return bool;
      label131:
      gmY = false;
      break;
      label138:
      gmY = false;
      break;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 5L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 6L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 7L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 8L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 9L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 10L, 1L, false);
    }
  }
  
  public static boolean afp()
  {
    AppMethodBeat.i(104470);
    int j;
    if (!gmW)
    {
      int i = com.tencent.mm.n.g.acL().getInt("EnableEmoticonExternUrl", 0);
      j = MMWXGFJNI.getErrorCode();
      if ((i & 0x2) != 2) {
        break label115;
      }
      if ((afv()) || (afw())) {
        break label103;
      }
      gmZ = true;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 1L, 1L, false);
    }
    for (;;)
    {
      if (j < 0) {
        gmZ = false;
      }
      gmW = true;
      ae.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[] { Boolean.valueOf(gmZ) });
      boolean bool = gmZ;
      AppMethodBeat.o(104470);
      return bool;
      label103:
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 0L, 1L, false);
      label115:
      gmZ = false;
    }
  }
  
  public static boolean afq()
  {
    AppMethodBeat.i(104471);
    if (!gmX) {
      if ((com.tencent.mm.n.g.acL().getInt("EnableEmoticonExternUrl", 0) & 0x4) != 4) {
        break label65;
      }
    }
    label65:
    for (gna = true;; gna = false)
    {
      gmX = true;
      ae.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", new Object[] { Boolean.valueOf(gna) });
      boolean bool = gna;
      AppMethodBeat.o(104471);
      return bool;
    }
  }
  
  public static boolean afr()
  {
    AppMethodBeat.i(104472);
    if ((com.tencent.mm.n.g.acL().getInt("ShowEmoticonCameraEntrance", 3) & 0x1) > 0)
    {
      AppMethodBeat.o(104472);
      return true;
    }
    AppMethodBeat.o(104472);
    return false;
  }
  
  public static boolean afs()
  {
    AppMethodBeat.i(104473);
    if ((com.tencent.mm.n.g.acL().getInt("ShowEmoticonCameraEntrance", 3) & 0x2) > 0)
    {
      AppMethodBeat.o(104473);
      return true;
    }
    AppMethodBeat.o(104473);
    return false;
  }
  
  public static boolean aft()
  {
    AppMethodBeat.i(104475);
    if (com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.Jaj, 1) == 0)
    {
      AppMethodBeat.o(104475);
      return true;
    }
    AppMethodBeat.o(104475);
    return false;
  }
  
  public static boolean afu()
  {
    AppMethodBeat.i(104476);
    if (com.tencent.mm.n.g.acL().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0)
    {
      AppMethodBeat.o(104476);
      return false;
    }
    AppMethodBeat.o(104476);
    return true;
  }
  
  private static boolean afv()
  {
    boolean bool = true;
    AppMethodBeat.i(104478);
    PackageManager localPackageManager = ak.getContext().getPackageManager();
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
  
  private static boolean afw()
  {
    boolean bool = true;
    AppMethodBeat.i(104479);
    PackageManager localPackageManager = ak.getContext().getPackageManager();
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
  
  public static boolean afx()
  {
    AppMethodBeat.i(104480);
    int i = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.Jak, 0);
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
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qDy, false);
    AppMethodBeat.o(104480);
    return bool;
  }
  
  public static boolean isSpringFestivalEnable()
  {
    AppMethodBeat.i(104474);
    ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qDn, 0);
    com.tencent.mm.n.g.acL().getInt("EmotionSpringFestivalPendantSwitch", 0);
    AppMethodBeat.o(104474);
    return false;
  }
  
  public static boolean isStickerEnable()
  {
    AppMethodBeat.i(104477);
    int i = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.Jao, 0);
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
    int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qDA, 9);
    AppMethodBeat.o(177029);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.m
 * JD-Core Version:    0.7.0.1
 */