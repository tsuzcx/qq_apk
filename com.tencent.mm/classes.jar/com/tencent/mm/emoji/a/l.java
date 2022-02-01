package com.tencent.mm.emoji.a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class l
{
  private static boolean fNq = false;
  private static boolean fNr = false;
  private static boolean fNs = false;
  private static boolean fNt = false;
  private static boolean fNu = false;
  private static boolean fNv = false;
  
  public static boolean abA()
  {
    AppMethodBeat.i(104472);
    if ((com.tencent.mm.m.g.Zd().getInt("ShowEmoticonCameraEntrance", 3) & 0x1) > 0)
    {
      AppMethodBeat.o(104472);
      return true;
    }
    AppMethodBeat.o(104472);
    return false;
  }
  
  public static boolean abB()
  {
    AppMethodBeat.i(104473);
    if ((com.tencent.mm.m.g.Zd().getInt("ShowEmoticonCameraEntrance", 3) & 0x2) > 0)
    {
      AppMethodBeat.o(104473);
      return true;
    }
    AppMethodBeat.o(104473);
    return false;
  }
  
  public static boolean abC()
  {
    AppMethodBeat.i(104475);
    if (com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.Fvk, 1) == 0)
    {
      AppMethodBeat.o(104475);
      return true;
    }
    AppMethodBeat.o(104475);
    return false;
  }
  
  public static boolean abD()
  {
    AppMethodBeat.i(104476);
    if (com.tencent.mm.m.g.Zd().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0)
    {
      AppMethodBeat.o(104476);
      return false;
    }
    AppMethodBeat.o(104476);
    return true;
  }
  
  private static boolean abE()
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
  
  private static boolean abF()
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
  
  public static boolean abG()
  {
    AppMethodBeat.i(104480);
    int i = com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.Fvl, 0);
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
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.poA, false);
    AppMethodBeat.o(104480);
    return bool;
  }
  
  public static boolean abq()
  {
    AppMethodBeat.i(104462);
    if ((com.tencent.mm.m.g.Zd().getInt("EmotionRewardOption", 0) & 0x1) == 1)
    {
      AppMethodBeat.o(104462);
      return false;
    }
    AppMethodBeat.o(104462);
    return true;
  }
  
  public static boolean abr()
  {
    AppMethodBeat.i(104463);
    if ((com.tencent.mm.m.g.Zd().getInt("EmotionRewardOption", 0) & 0x2) == 2)
    {
      AppMethodBeat.o(104463);
      return false;
    }
    AppMethodBeat.o(104463);
    return true;
  }
  
  public static boolean abs()
  {
    AppMethodBeat.i(104464);
    if ((com.tencent.mm.m.g.Zd().getInt("EmotionRewardOption", 0) & 0x4) == 4)
    {
      AppMethodBeat.o(104464);
      return true;
    }
    AppMethodBeat.o(104464);
    return false;
  }
  
  public static int abt()
  {
    AppMethodBeat.i(104465);
    int i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104465);
    return i;
  }
  
  public static int abu()
  {
    AppMethodBeat.i(104466);
    int i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("CustomEmojiMaxSize"), 300);
    AppMethodBeat.o(104466);
    return i;
  }
  
  public static String abv()
  {
    AppMethodBeat.i(104467);
    String str = com.tencent.mm.m.g.Zd().getValue("C2CEmojiNotAutoDownloadTimeRange");
    AppMethodBeat.o(104467);
    return str;
  }
  
  public static String abw()
  {
    AppMethodBeat.i(104468);
    String str = com.tencent.mm.m.g.Zd().getValue("EmotionPanelConfigName");
    AppMethodBeat.o(104468);
    return str;
  }
  
  public static boolean abx()
  {
    AppMethodBeat.i(104469);
    if (!fNq)
    {
      int i = com.tencent.mm.m.g.Zd().getInt("EnableEmoticonExternUrl", 0);
      int j = MMWXGFJNI.getErrorCode();
      if ((i & 0x1) != 1) {
        break label138;
      }
      if ((abE()) || (abF())) {
        break label131;
      }
      fNt = true;
      if (j < 0)
      {
        fNt = false;
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      fNq = true;
      ad.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[] { Boolean.valueOf(fNt) });
      boolean bool = fNt;
      AppMethodBeat.o(104469);
      return bool;
      label131:
      fNt = false;
      break;
      label138:
      fNt = false;
      break;
      h.vKh.idkeyStat(711L, 5L, 1L, false);
      continue;
      h.vKh.idkeyStat(711L, 6L, 1L, false);
      continue;
      h.vKh.idkeyStat(711L, 7L, 1L, false);
      continue;
      h.vKh.idkeyStat(711L, 8L, 1L, false);
      continue;
      h.vKh.idkeyStat(711L, 9L, 1L, false);
      continue;
      h.vKh.idkeyStat(711L, 10L, 1L, false);
    }
  }
  
  public static boolean aby()
  {
    AppMethodBeat.i(104470);
    int j;
    if (!fNr)
    {
      int i = com.tencent.mm.m.g.Zd().getInt("EnableEmoticonExternUrl", 0);
      j = MMWXGFJNI.getErrorCode();
      if ((i & 0x2) != 2) {
        break label115;
      }
      if ((abE()) || (abF())) {
        break label103;
      }
      fNu = true;
      h.vKh.idkeyStat(711L, 1L, 1L, false);
    }
    for (;;)
    {
      if (j < 0) {
        fNu = false;
      }
      fNr = true;
      ad.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[] { Boolean.valueOf(fNu) });
      boolean bool = fNu;
      AppMethodBeat.o(104470);
      return bool;
      label103:
      h.vKh.idkeyStat(711L, 0L, 1L, false);
      label115:
      fNu = false;
    }
  }
  
  public static boolean abz()
  {
    AppMethodBeat.i(104471);
    if (!fNs) {
      if ((com.tencent.mm.m.g.Zd().getInt("EnableEmoticonExternUrl", 0) & 0x4) != 4) {
        break label65;
      }
    }
    label65:
    for (fNv = true;; fNv = false)
    {
      fNs = true;
      ad.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", new Object[] { Boolean.valueOf(fNv) });
      boolean bool = fNv;
      AppMethodBeat.o(104471);
      return bool;
    }
  }
  
  public static boolean isSpringFestivalEnable()
  {
    AppMethodBeat.i(104474);
    ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.poo, 0);
    com.tencent.mm.m.g.Zd().getInt("EmotionSpringFestivalPendantSwitch", 0);
    AppMethodBeat.o(104474);
    return false;
  }
  
  public static boolean isStickerEnable()
  {
    AppMethodBeat.i(104477);
    int i = com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.Fvp, 0);
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
    int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.poC, 9);
    AppMethodBeat.o(177029);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.l
 * JD-Core Version:    0.7.0.1
 */