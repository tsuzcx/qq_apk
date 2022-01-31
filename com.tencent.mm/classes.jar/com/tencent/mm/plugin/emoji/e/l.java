package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class l
{
  private static boolean iXK = false;
  private static boolean iXL = false;
  private static boolean iXM = false;
  private static boolean iXN = false;
  private static boolean iXO = false;
  private static boolean iXP = false;
  
  public static boolean aHA()
  {
    return (g.AA().getInt("EmotionRewardOption", 0) & 0x2) != 2;
  }
  
  public static boolean aHB()
  {
    boolean bool = false;
    if ((g.AA().getInt("EmotionRewardOption", 0) & 0x4) == 4) {
      bool = true;
    }
    return bool;
  }
  
  public static int aHC()
  {
    return bk.getInt(g.AA().getValue("CustomEmojiMaxSize"), 150);
  }
  
  public static String aHD()
  {
    return g.AA().getValue("C2CEmojiNotAutoDownloadTimeRange");
  }
  
  public static String aHE()
  {
    return g.AA().getValue("EmotionPanelConfigName");
  }
  
  public static boolean aHF()
  {
    com.tencent.mm.storage.c localc;
    if (!iXK)
    {
      localc = com.tencent.mm.model.c.c.IX().fJ("100296");
      if (!localc.isValid()) {
        break label276;
      }
    }
    label276:
    for (int i = bk.getInt((String)localc.ctr().get("EnableEmoticonExternUrl"), 0);; i = 0)
    {
      int j = g.AA().getInt("EnableEmoticonExternUrl", 0);
      int k = MMWXGFJNI.getErrorCode();
      if (((j & 0x1) == 1) || ((i & 0x1) == 1)) {
        if ((!aHI()) && (!aHJ()))
        {
          iXN = true;
          if (k < 0)
          {
            iXN = false;
            switch (k)
            {
            }
          }
        }
      }
      for (;;)
      {
        iXK = true;
        y.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[] { Boolean.valueOf(iXN) });
        return iXN;
        iXN = false;
        break;
        iXN = false;
        break;
        h.nFQ.a(711L, 5L, 1L, false);
        continue;
        h.nFQ.a(711L, 6L, 1L, false);
        continue;
        h.nFQ.a(711L, 7L, 1L, false);
        continue;
        h.nFQ.a(711L, 8L, 1L, false);
        continue;
        h.nFQ.a(711L, 9L, 1L, false);
        continue;
        h.nFQ.a(711L, 10L, 1L, false);
      }
    }
  }
  
  public static boolean aHG()
  {
    int k;
    if (!iXL)
    {
      int i = 0;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100296");
      if (localc.isValid()) {
        i = bk.getInt((String)localc.ctr().get("EnableEmoticonExternUrl"), 0);
      }
      int j = g.AA().getInt("EnableEmoticonExternUrl", 0);
      k = MMWXGFJNI.getErrorCode();
      if (((j & 0x2) != 2) && ((i & 0x2) != 2)) {
        break label147;
      }
      if ((aHI()) || (aHJ())) {
        break label135;
      }
      iXO = true;
      h.nFQ.a(711L, 1L, 1L, false);
    }
    for (;;)
    {
      if (k < 0) {
        iXO = false;
      }
      iXL = true;
      y.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[] { Boolean.valueOf(iXO) });
      return iXO;
      label135:
      h.nFQ.a(711L, 0L, 1L, false);
      label147:
      iXO = false;
    }
  }
  
  public static boolean aHH()
  {
    boolean bool = false;
    if ((g.AA().getInt("ShowEmoticonCameraEntrance", 0) & 0x2) > 0) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean aHI()
  {
    PackageManager localPackageManager = ae.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  private static boolean aHJ()
  {
    PackageManager localPackageManager = ae.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app", 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public static boolean aHt()
  {
    com.tencent.mm.storage.c localc;
    if (!iXM)
    {
      localc = com.tencent.mm.model.c.c.IX().fJ("100296");
      if (!localc.isValid()) {
        break label104;
      }
    }
    label104:
    for (int i = bk.getInt((String)localc.ctr().get("EnableEmoticonExternUrl"), 0);; i = 0)
    {
      if (((g.AA().getInt("EnableEmoticonExternUrl", 0) & 0x4) == 4) || ((i & 0x4) == 4)) {}
      for (iXP = aHG();; iXP = false)
      {
        iXM = true;
        y.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", new Object[] { Boolean.valueOf(iXP) });
        return iXP;
      }
    }
  }
  
  public static boolean aHu()
  {
    boolean bool = false;
    if ((g.AA().getInt("ShowEmoticonCameraEntrance", 0) & 0x1) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean aHz()
  {
    return (g.AA().getInt("EmotionRewardOption", 0) & 0x1) != 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.l
 * JD-Core Version:    0.7.0.1
 */