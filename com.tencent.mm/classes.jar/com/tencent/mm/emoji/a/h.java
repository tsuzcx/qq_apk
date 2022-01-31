package com.tencent.mm.emoji.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class h
{
  private static boolean ewY = false;
  private static boolean ewZ = false;
  private static boolean exa = false;
  private static boolean exb = false;
  private static boolean exc = false;
  private static boolean exd = false;
  
  public static boolean OH()
  {
    AppMethodBeat.i(62250);
    if ((com.tencent.mm.m.g.Nq().getInt("EmotionRewardOption", 0) & 0x1) == 1)
    {
      AppMethodBeat.o(62250);
      return false;
    }
    AppMethodBeat.o(62250);
    return true;
  }
  
  public static boolean OI()
  {
    AppMethodBeat.i(62251);
    if ((com.tencent.mm.m.g.Nq().getInt("EmotionRewardOption", 0) & 0x2) == 2)
    {
      AppMethodBeat.o(62251);
      return false;
    }
    AppMethodBeat.o(62251);
    return true;
  }
  
  public static boolean OJ()
  {
    AppMethodBeat.i(62252);
    if ((com.tencent.mm.m.g.Nq().getInt("EmotionRewardOption", 0) & 0x4) == 4)
    {
      AppMethodBeat.o(62252);
      return true;
    }
    AppMethodBeat.o(62252);
    return false;
  }
  
  public static int OK()
  {
    AppMethodBeat.i(62253);
    int i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(62253);
    return i;
  }
  
  public static int OL()
  {
    AppMethodBeat.i(62254);
    int i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(62254);
    return i;
  }
  
  public static String OM()
  {
    AppMethodBeat.i(62255);
    String str = com.tencent.mm.m.g.Nq().getValue("C2CEmojiNotAutoDownloadTimeRange");
    AppMethodBeat.o(62255);
    return str;
  }
  
  public static String ON()
  {
    AppMethodBeat.i(62256);
    String str = com.tencent.mm.m.g.Nq().getValue("EmotionPanelConfigName");
    AppMethodBeat.o(62256);
    return str;
  }
  
  public static boolean OO()
  {
    AppMethodBeat.i(62257);
    if (!ewY)
    {
      int i = com.tencent.mm.m.g.Nq().getInt("EnableEmoticonExternUrl", 0);
      int j = MMWXGFJNI.getErrorCode();
      if ((i & 0x1) != 1) {
        break label138;
      }
      if ((OV()) || (OW())) {
        break label131;
      }
      exb = true;
      if (j < 0)
      {
        exb = false;
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      ewY = true;
      ab.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[] { Boolean.valueOf(exb) });
      boolean bool = exb;
      AppMethodBeat.o(62257);
      return bool;
      label131:
      exb = false;
      break;
      label138:
      exb = false;
      break;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 5L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 6L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 7L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 8L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 9L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 10L, 1L, false);
    }
  }
  
  public static boolean OP()
  {
    AppMethodBeat.i(62258);
    int j;
    if (!ewZ)
    {
      int i = com.tencent.mm.m.g.Nq().getInt("EnableEmoticonExternUrl", 0);
      j = MMWXGFJNI.getErrorCode();
      if ((i & 0x2) != 2) {
        break label115;
      }
      if ((OV()) || (OW())) {
        break label103;
      }
      exc = true;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 1L, 1L, false);
    }
    for (;;)
    {
      if (j < 0) {
        exc = false;
      }
      ewZ = true;
      ab.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[] { Boolean.valueOf(exc) });
      boolean bool = exc;
      AppMethodBeat.o(62258);
      return bool;
      label103:
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 0L, 1L, false);
      label115:
      exc = false;
    }
  }
  
  public static boolean OQ()
  {
    AppMethodBeat.i(62259);
    if (!exa) {
      if ((com.tencent.mm.m.g.Nq().getInt("EnableEmoticonExternUrl", 0) & 0x4) != 4) {
        break label65;
      }
    }
    label65:
    for (exd = true;; exd = false)
    {
      exa = true;
      ab.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", new Object[] { Boolean.valueOf(exd) });
      boolean bool = exd;
      AppMethodBeat.o(62259);
      return bool;
    }
  }
  
  public static boolean OR()
  {
    AppMethodBeat.i(62260);
    if ((com.tencent.mm.m.g.Nq().getInt("ShowEmoticonCameraEntrance", 3) & 0x1) > 0)
    {
      AppMethodBeat.o(62260);
      return true;
    }
    AppMethodBeat.o(62260);
    return false;
  }
  
  public static boolean OS()
  {
    AppMethodBeat.i(62261);
    if ((com.tencent.mm.m.g.Nq().getInt("ShowEmoticonCameraEntrance", 3) & 0x2) > 0)
    {
      AppMethodBeat.o(62261);
      return true;
    }
    AppMethodBeat.o(62261);
    return false;
  }
  
  public static boolean OT()
  {
    AppMethodBeat.i(62263);
    if (com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yLN, 1) == 0)
    {
      AppMethodBeat.o(62263);
      return true;
    }
    AppMethodBeat.o(62263);
    return false;
  }
  
  public static boolean OU()
  {
    AppMethodBeat.i(62264);
    if (com.tencent.mm.m.g.Nq().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0)
    {
      AppMethodBeat.o(62264);
      return false;
    }
    AppMethodBeat.o(62264);
    return true;
  }
  
  private static boolean OV()
  {
    boolean bool = true;
    AppMethodBeat.i(62265);
    PackageManager localPackageManager = ah.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
      AppMethodBeat.o(62265);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
  
  private static boolean OW()
  {
    boolean bool = true;
    AppMethodBeat.i(62266);
    PackageManager localPackageManager = ah.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app", 1);
      AppMethodBeat.o(62266);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
  
  public static boolean isSpringFestivalEnable()
  {
    AppMethodBeat.i(62262);
    ((a)com.tencent.mm.kernel.g.E(a.class)).a(a.a.lVd, 0);
    com.tencent.mm.m.g.Nq().getInt("EmotionSpringFestivalPendantSwitch", 0);
    AppMethodBeat.o(62262);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */