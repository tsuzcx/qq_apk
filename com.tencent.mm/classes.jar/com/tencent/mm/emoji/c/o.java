package com.tencent.mm.emoji.c;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class o
{
  private static boolean mid = false;
  private static boolean mie = false;
  private static boolean mif = false;
  private static boolean mig = false;
  private static boolean mih = false;
  private static boolean mii = false;
  
  public static boolean aUN()
  {
    AppMethodBeat.i(104462);
    if ((i.aRC().getInt("EmotionRewardOption", 0) & 0x1) == 1)
    {
      AppMethodBeat.o(104462);
      return false;
    }
    AppMethodBeat.o(104462);
    return true;
  }
  
  public static boolean aUO()
  {
    AppMethodBeat.i(104463);
    if ((i.aRC().getInt("EmotionRewardOption", 0) & 0x2) == 2)
    {
      AppMethodBeat.o(104463);
      return false;
    }
    AppMethodBeat.o(104463);
    return true;
  }
  
  public static boolean aUP()
  {
    AppMethodBeat.i(104464);
    if ((i.aRC().getInt("EmotionRewardOption", 0) & 0x4) == 4)
    {
      AppMethodBeat.o(104464);
      return true;
    }
    AppMethodBeat.o(104464);
    return false;
  }
  
  public static int aUQ()
  {
    AppMethodBeat.i(104465);
    int i = Util.getInt(i.aRC().getValue("CustomEmojiMaxSize"), 999);
    AppMethodBeat.o(104465);
    return i;
  }
  
  public static int aUR()
  {
    AppMethodBeat.i(104466);
    int i = Util.getInt(i.aRC().getValue("CaptureEmojiMaxSize"), 300);
    AppMethodBeat.o(104466);
    return i;
  }
  
  public static String aUS()
  {
    AppMethodBeat.i(104467);
    String str = i.aRC().getValue("C2CEmojiNotAutoDownloadTimeRange");
    AppMethodBeat.o(104467);
    return str;
  }
  
  public static String aUT()
  {
    AppMethodBeat.i(104468);
    String str = i.aRC().getValue("EmotionPanelConfigName");
    AppMethodBeat.o(104468);
    return str;
  }
  
  public static boolean aUU()
  {
    AppMethodBeat.i(104469);
    if (!mid)
    {
      int i = i.aRC().getInt("EnableEmoticonExternUrl", 0);
      int j = MMWXGFJNI.getErrorCode();
      if ((i & 0x1) != 1) {
        break label138;
      }
      if ((aVb()) || (aVc())) {
        break label131;
      }
      mig = true;
      if (j < 0)
      {
        mig = false;
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      mid = true;
      Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[] { Boolean.valueOf(mig) });
      boolean bool = mig;
      AppMethodBeat.o(104469);
      return bool;
      label131:
      mig = false;
      break;
      label138:
      mig = false;
      break;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 5L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 6L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 7L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 8L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 9L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 10L, 1L, false);
    }
  }
  
  public static boolean aUV()
  {
    AppMethodBeat.i(104470);
    int j;
    if (!mie)
    {
      int i = i.aRC().getInt("EnableEmoticonExternUrl", 0);
      j = MMWXGFJNI.getErrorCode();
      if ((i & 0x2) != 2) {
        break label115;
      }
      if ((aVb()) || (aVc())) {
        break label103;
      }
      mih = true;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 1L, 1L, false);
    }
    for (;;)
    {
      if (j < 0) {
        mih = false;
      }
      mie = true;
      Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[] { Boolean.valueOf(mih) });
      boolean bool = mih;
      AppMethodBeat.o(104470);
      return bool;
      label103:
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 0L, 1L, false);
      label115:
      mih = false;
    }
  }
  
  public static boolean aUW()
  {
    AppMethodBeat.i(104471);
    if (!mif) {
      if ((i.aRC().getInt("EnableEmoticonExternUrl", 0) & 0x4) != 4) {
        break label65;
      }
    }
    label65:
    for (mii = true;; mii = false)
    {
      mif = true;
      Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", new Object[] { Boolean.valueOf(mii) });
      boolean bool = mii;
      AppMethodBeat.o(104471);
      return bool;
    }
  }
  
  public static boolean aUX()
  {
    AppMethodBeat.i(104472);
    if ((i.aRC().getInt("ShowEmoticonCameraEntrance", 3) & 0x1) > 0)
    {
      AppMethodBeat.o(104472);
      return true;
    }
    AppMethodBeat.o(104472);
    return false;
  }
  
  public static boolean aUY()
  {
    AppMethodBeat.i(104473);
    if ((i.aRC().getInt("ShowEmoticonCameraEntrance", 3) & 0x2) > 0)
    {
      AppMethodBeat.o(104473);
      return true;
    }
    AppMethodBeat.o(104473);
    return false;
  }
  
  public static boolean aUZ()
  {
    AppMethodBeat.i(104475);
    if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acYQ, 1) == 0)
    {
      AppMethodBeat.o(104475);
      return true;
    }
    AppMethodBeat.o(104475);
    return false;
  }
  
  public static boolean aVa()
  {
    AppMethodBeat.i(104476);
    if (i.aRC().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0)
    {
      AppMethodBeat.o(104476);
      return false;
    }
    AppMethodBeat.o(104476);
    return true;
  }
  
  private static boolean aVb()
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
  
  private static boolean aVc()
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
  
  public static boolean isSpringFestivalEnable()
  {
    AppMethodBeat.i(104474);
    ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yRi, 0);
    i.aRC().getInt("EmotionSpringFestivalPendantSwitch", 0);
    AppMethodBeat.o(104474);
    return false;
  }
  
  public static boolean isStickerEnable()
  {
    AppMethodBeat.i(104477);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acYW, 0);
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
    int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yRv, 9);
    AppMethodBeat.o(177029);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.o
 * JD-Core Version:    0.7.0.1
 */