package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storagebase.h.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c
  implements aw
{
  public static boolean H(bo parambo)
  {
    AppMethodBeat.i(150454);
    if (parambo == null)
    {
      ac.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
      AppMethodBeat.o(150454);
      return false;
    }
    parambo = bi.yr(parambo.eul);
    if (parambo == null)
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
      AppMethodBeat.o(150454);
      return true;
    }
    parambo = parambo.hoJ;
    if (bs.isNullOrNil(parambo))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
      AppMethodBeat.o(150454);
      return true;
    }
    if (b.BU(parambo))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : ".concat(String.valueOf(parambo)));
      AppMethodBeat.o(150454);
      return false;
    }
    ac.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: ".concat(String.valueOf(parambo)));
    AppMethodBeat.o(150454);
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150453);
    paramPInt1.value = 0;
    int i = bs.getInt(((a)g.ab(a.class)).ZY().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
      AppMethodBeat.o(150453);
      return false;
    }
    boolean bool = ax.isWifi(ai.getContext());
    if ((i == 2) && (!bool))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
      AppMethodBeat.o(150453);
      return false;
    }
    if (ax.is2G(ai.getContext()))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
      AppMethodBeat.o(150453);
      return false;
    }
    paramPInt2 = ((a)g.ab(a.class)).ZY().getValue("SnsAdSightNotAutoDownloadTimeRange");
    ac.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: ".concat(String.valueOf(paramPInt2)));
    if (b.BU(paramPInt2))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        AppMethodBeat.o(150453);
        return false;
      }
    }
    ac.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
    AppMethodBeat.o(150453);
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2, PInt paramPInt3)
  {
    AppMethodBeat.i(150452);
    paramPInt1.value = 0;
    int i = bs.getInt(((a)g.ab(a.class)).ZY().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
      AppMethodBeat.o(150452);
      return false;
    }
    boolean bool = ax.isWifi(ai.getContext());
    if ((i == 2) && (!bool))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
      AppMethodBeat.o(150452);
      return false;
    }
    if (ax.is2G(ai.getContext()))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
      AppMethodBeat.o(150452);
      return false;
    }
    paramPInt2 = ((a)g.ab(a.class)).ZY().getValue("SnsSightNoAutoDownload");
    if (!bs.isNullOrNil(paramPInt2)) {
      try
      {
        ac.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq ".concat(String.valueOf(paramPInt2)));
        long l1 = bs.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0L) - ((int)b.aDH() - 8) * 60L / 1000L;
        String[] arrayOfString = paramPInt2.split(",");
        long l2 = bs.getLong(arrayOfString[0], 0L);
        if ((l1 <= bs.getLong(arrayOfString[1], 0L)) && (l1 >= l2))
        {
          ac.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
          paramPInt3.value = 1;
          AppMethodBeat.o(150452);
          return false;
        }
      }
      catch (Exception paramPInt3)
      {
        ac.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", new Object[] { paramPInt2, paramPInt3.getMessage() });
      }
    }
    paramPInt2 = ((a)g.ab(a.class)).ZY().getValue("SnsSightNotAutoDownloadTimeRange");
    ac.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(paramPInt2)));
    if (b.BU(paramPInt2))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        AppMethodBeat.o(150452);
        return false;
      }
    }
    ac.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
    AppMethodBeat.o(150452);
    return true;
  }
  
  public static c aDI()
  {
    try
    {
      AppMethodBeat.i(150449);
      c localc = (c)t.ap(c.class);
      AppMethodBeat.o(150449);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean aDJ()
  {
    AppMethodBeat.i(150450);
    if (b.aDF())
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
      AppMethodBeat.o(150450);
      return false;
    }
    int i = bs.getInt(((a)g.ab(a.class)).ZY().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
      AppMethodBeat.o(150450);
      return false;
    }
    Context localContext = ai.getContext();
    if ((i == 2) && (ax.isWifi(localContext)))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      AppMethodBeat.o(150450);
      return true;
    }
    if ((i == 1) && (ax.isWifi(localContext)))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      AppMethodBeat.o(150450);
      return true;
    }
    long l2 = bs.getInt(((a)g.ab(a.class)).ZY().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bs.a((Long)g.agR().agA().get(ah.a.GER, null), 0L);
    long l3 = bs.aLz((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bs.a((Long)g.agR().agA().get(ah.a.GES, null), 0L);
    ac.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1 + " downloadMode: " + i);
    if (l3 != l4)
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "update month %d ", new Object[] { Long.valueOf(l3) });
      g.agR().agA().set(ah.a.GER, Long.valueOf(0L));
      g.agR().agA().set(ah.a.GES, Long.valueOf(l3));
      l1 = 0L;
    }
    for (;;)
    {
      if ((l1 > l2) && (l2 > 0L))
      {
        ac.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + l1 + " C2C image, can not auto download.");
        AppMethodBeat.o(150450);
        return false;
      }
      if ((i == 1) && ((ax.isWifi(localContext)) || (ax.is3G(localContext)) || (ax.is4G(localContext))))
      {
        ac.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
        AppMethodBeat.o(150450);
        return true;
      }
      ac.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
      AppMethodBeat.o(150450);
      return false;
    }
  }
  
  public static boolean aDK()
  {
    AppMethodBeat.i(150451);
    String str = ((a)g.ab(a.class)).ZY().getValue("SnsImgPreLoadingAroundTimeLimit");
    ac.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: ".concat(String.valueOf(str)));
    if (b.BU(str))
    {
      ac.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
      AppMethodBeat.o(150451);
      return false;
    }
    ac.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
    AppMethodBeat.o(150451);
    return true;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.c
 * JD-Core Version:    0.7.0.1
 */