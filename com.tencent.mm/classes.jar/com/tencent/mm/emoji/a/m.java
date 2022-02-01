package com.tencent.mm.emoji.a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class m
{
  private static boolean fRb = false;
  private static boolean fRc = false;
  private static boolean fRd = false;
  private static boolean fRe = false;
  private static boolean fRf = false;
  private static boolean fRg = false;
  
  public static boolean acA()
  {
    AppMethodBeat.i(104473);
    if ((com.tencent.mm.m.g.ZY().getInt("ShowEmoticonCameraEntrance", 3) & 0x2) > 0)
    {
      AppMethodBeat.o(104473);
      return true;
    }
    AppMethodBeat.o(104473);
    return false;
  }
  
  public static boolean acB()
  {
    AppMethodBeat.i(104475);
    if (com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GTe, 1) == 0)
    {
      AppMethodBeat.o(104475);
      return true;
    }
    AppMethodBeat.o(104475);
    return false;
  }
  
  public static boolean acC()
  {
    AppMethodBeat.i(104476);
    if (com.tencent.mm.m.g.ZY().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0)
    {
      AppMethodBeat.o(104476);
      return false;
    }
    AppMethodBeat.o(104476);
    return true;
  }
  
  private static boolean acD()
  {
    boolean bool = true;
    AppMethodBeat.i(104478);
    PackageManager localPackageManager = ai.getContext().getPackageManager();
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
  
  private static boolean acE()
  {
    boolean bool = true;
    AppMethodBeat.i(104479);
    PackageManager localPackageManager = ai.getContext().getPackageManager();
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
  
  public static boolean acF()
  {
    AppMethodBeat.i(104480);
    int i = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GTf, 0);
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
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pSb, false);
    AppMethodBeat.o(104480);
    return bool;
  }
  
  public static boolean acp()
  {
    AppMethodBeat.i(104462);
    if ((com.tencent.mm.m.g.ZY().getInt("EmotionRewardOption", 0) & 0x1) == 1)
    {
      AppMethodBeat.o(104462);
      return false;
    }
    AppMethodBeat.o(104462);
    return true;
  }
  
  public static boolean acq()
  {
    AppMethodBeat.i(104463);
    if ((com.tencent.mm.m.g.ZY().getInt("EmotionRewardOption", 0) & 0x2) == 2)
    {
      AppMethodBeat.o(104463);
      return false;
    }
    AppMethodBeat.o(104463);
    return true;
  }
  
  public static boolean acr()
  {
    AppMethodBeat.i(104464);
    if ((com.tencent.mm.m.g.ZY().getInt("EmotionRewardOption", 0) & 0x4) == 4)
    {
      AppMethodBeat.o(104464);
      return true;
    }
    AppMethodBeat.o(104464);
    return false;
  }
  
  public static int acs()
  {
    AppMethodBeat.i(104465);
    int i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104465);
    return i;
  }
  
  public static int act()
  {
    AppMethodBeat.i(104466);
    int i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104466);
    return i;
  }
  
  public static String acu()
  {
    AppMethodBeat.i(104467);
    String str = com.tencent.mm.m.g.ZY().getValue("C2CEmojiNotAutoDownloadTimeRange");
    AppMethodBeat.o(104467);
    return str;
  }
  
  public static String acv()
  {
    AppMethodBeat.i(104468);
    String str = com.tencent.mm.m.g.ZY().getValue("EmotionPanelConfigName");
    AppMethodBeat.o(104468);
    return str;
  }
  
  public static boolean acw()
  {
    AppMethodBeat.i(104469);
    if (!fRb)
    {
      int i = com.tencent.mm.m.g.ZY().getInt("EnableEmoticonExternUrl", 0);
      int j = MMWXGFJNI.getErrorCode();
      if ((i & 0x1) != 1) {
        break label138;
      }
      if ((acD()) || (acE())) {
        break label131;
      }
      fRe = true;
      if (j < 0)
      {
        fRe = false;
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      fRb = true;
      ac.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[] { Boolean.valueOf(fRe) });
      boolean bool = fRe;
      AppMethodBeat.o(104469);
      return bool;
      label131:
      fRe = false;
      break;
      label138:
      fRe = false;
      break;
      h.wUl.idkeyStat(711L, 5L, 1L, false);
      continue;
      h.wUl.idkeyStat(711L, 6L, 1L, false);
      continue;
      h.wUl.idkeyStat(711L, 7L, 1L, false);
      continue;
      h.wUl.idkeyStat(711L, 8L, 1L, false);
      continue;
      h.wUl.idkeyStat(711L, 9L, 1L, false);
      continue;
      h.wUl.idkeyStat(711L, 10L, 1L, false);
    }
  }
  
  public static boolean acx()
  {
    AppMethodBeat.i(104470);
    int j;
    if (!fRc)
    {
      int i = com.tencent.mm.m.g.ZY().getInt("EnableEmoticonExternUrl", 0);
      j = MMWXGFJNI.getErrorCode();
      if ((i & 0x2) != 2) {
        break label115;
      }
      if ((acD()) || (acE())) {
        break label103;
      }
      fRf = true;
      h.wUl.idkeyStat(711L, 1L, 1L, false);
    }
    for (;;)
    {
      if (j < 0) {
        fRf = false;
      }
      fRc = true;
      ac.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[] { Boolean.valueOf(fRf) });
      boolean bool = fRf;
      AppMethodBeat.o(104470);
      return bool;
      label103:
      h.wUl.idkeyStat(711L, 0L, 1L, false);
      label115:
      fRf = false;
    }
  }
  
  public static boolean acy()
  {
    AppMethodBeat.i(104471);
    if (!fRd) {
      if ((com.tencent.mm.m.g.ZY().getInt("EnableEmoticonExternUrl", 0) & 0x4) != 4) {
        break label65;
      }
    }
    label65:
    for (fRg = true;; fRg = false)
    {
      fRd = true;
      ac.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", new Object[] { Boolean.valueOf(fRg) });
      boolean bool = fRg;
      AppMethodBeat.o(104471);
      return bool;
    }
  }
  
  public static boolean acz()
  {
    AppMethodBeat.i(104472);
    if ((com.tencent.mm.m.g.ZY().getInt("ShowEmoticonCameraEntrance", 3) & 0x1) > 0)
    {
      AppMethodBeat.o(104472);
      return true;
    }
    AppMethodBeat.o(104472);
    return false;
  }
  
  public static boolean isSpringFestivalEnable()
  {
    AppMethodBeat.i(104474);
    ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pRQ, 0);
    com.tencent.mm.m.g.ZY().getInt("EmotionSpringFestivalPendantSwitch", 0);
    AppMethodBeat.o(104474);
    return false;
  }
  
  public static boolean isStickerEnable()
  {
    AppMethodBeat.i(104477);
    int i = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GTj, 0);
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
    int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pSd, 9);
    AppMethodBeat.o(177029);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.m
 * JD-Core Version:    0.7.0.1
 */