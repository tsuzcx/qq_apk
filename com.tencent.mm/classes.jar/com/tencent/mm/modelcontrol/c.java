package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c
  implements ax
{
  public static boolean K(bu parambu)
  {
    AppMethodBeat.i(150454);
    if (parambu == null)
    {
      ad.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
      AppMethodBeat.o(150454);
      return false;
    }
    parambu = bj.Bq(parambu.eLs);
    if (parambu == null)
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
      AppMethodBeat.o(150454);
      return true;
    }
    parambu = parambu.hHb;
    if (bt.isNullOrNil(parambu))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
      AppMethodBeat.o(150454);
      return true;
    }
    if (b.ET(parambu))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : ".concat(String.valueOf(parambu)));
      AppMethodBeat.o(150454);
      return false;
    }
    ad.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: ".concat(String.valueOf(parambu)));
    AppMethodBeat.o(150454);
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150453);
    paramPInt1.value = 0;
    int i = bt.getInt(((a)g.ab(a.class)).acA().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
      AppMethodBeat.o(150453);
      return false;
    }
    boolean bool = ay.isWifi(aj.getContext());
    if ((i == 2) && (!bool))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
      AppMethodBeat.o(150453);
      return false;
    }
    if (ay.is2G(aj.getContext()))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
      AppMethodBeat.o(150453);
      return false;
    }
    paramPInt2 = ((a)g.ab(a.class)).acA().getValue("SnsAdSightNotAutoDownloadTimeRange");
    ad.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: ".concat(String.valueOf(paramPInt2)));
    if (b.ET(paramPInt2))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        AppMethodBeat.o(150453);
        return false;
      }
    }
    ad.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
    AppMethodBeat.o(150453);
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2, PInt paramPInt3)
  {
    AppMethodBeat.i(150452);
    paramPInt1.value = 0;
    int i = bt.getInt(((a)g.ab(a.class)).acA().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
      AppMethodBeat.o(150452);
      return false;
    }
    boolean bool = ay.isWifi(aj.getContext());
    if ((i == 2) && (!bool))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
      AppMethodBeat.o(150452);
      return false;
    }
    if (ay.is2G(aj.getContext()))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
      AppMethodBeat.o(150452);
      return false;
    }
    paramPInt2 = ((a)g.ab(a.class)).acA().getValue("SnsSightNoAutoDownload");
    if (!bt.isNullOrNil(paramPInt2)) {
      try
      {
        ad.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq ".concat(String.valueOf(paramPInt2)));
        long l1 = bt.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0L) - ((int)b.aGM() - 8) * 60L / 1000L;
        String[] arrayOfString = paramPInt2.split(",");
        long l2 = bt.getLong(arrayOfString[0], 0L);
        if ((l1 <= bt.getLong(arrayOfString[1], 0L)) && (l1 >= l2))
        {
          ad.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
          paramPInt3.value = 1;
          AppMethodBeat.o(150452);
          return false;
        }
      }
      catch (Exception paramPInt3)
      {
        ad.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", new Object[] { paramPInt2, paramPInt3.getMessage() });
      }
    }
    paramPInt2 = ((a)g.ab(a.class)).acA().getValue("SnsSightNotAutoDownloadTimeRange");
    ad.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(paramPInt2)));
    if (b.ET(paramPInt2))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        AppMethodBeat.o(150452);
        return false;
      }
    }
    ad.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
    AppMethodBeat.o(150452);
    return true;
  }
  
  public static c aGN()
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
  
  public static boolean aGO()
  {
    AppMethodBeat.i(150450);
    if (b.aGK())
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
      AppMethodBeat.o(150450);
      return false;
    }
    int i = bt.getInt(((a)g.ab(a.class)).acA().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
      AppMethodBeat.o(150450);
      return false;
    }
    Context localContext = aj.getContext();
    if ((i == 2) && (ay.isWifi(localContext)))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      AppMethodBeat.o(150450);
      return true;
    }
    if ((i == 1) && (ay.isWifi(localContext)))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      AppMethodBeat.o(150450);
      return true;
    }
    long l2 = bt.getInt(((a)g.ab(a.class)).acA().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bt.a((Long)g.ajC().ajl().get(al.a.Irk, null), 0L);
    long l3 = bt.aRf((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bt.a((Long)g.ajC().ajl().get(al.a.Irl, null), 0L);
    ad.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1 + " downloadMode: " + i);
    if (l3 != l4)
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "update month %d ", new Object[] { Long.valueOf(l3) });
      g.ajC().ajl().set(al.a.Irk, Long.valueOf(0L));
      g.ajC().ajl().set(al.a.Irl, Long.valueOf(l3));
      l1 = 0L;
    }
    for (;;)
    {
      if ((l1 > l2) && (l2 > 0L))
      {
        ad.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + l1 + " C2C image, can not auto download.");
        AppMethodBeat.o(150450);
        return false;
      }
      if ((i == 1) && ((ay.isWifi(localContext)) || (ay.is3G(localContext)) || (ay.is4G(localContext))))
      {
        ad.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
        AppMethodBeat.o(150450);
        return true;
      }
      ad.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
      AppMethodBeat.o(150450);
      return false;
    }
  }
  
  public static boolean aGP()
  {
    AppMethodBeat.i(150451);
    String str = ((a)g.ab(a.class)).acA().getValue("SnsImgPreLoadingAroundTimeLimit");
    ad.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: ".concat(String.valueOf(str)));
    if (b.ET(str))
    {
      ad.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
      AppMethodBeat.o(150451);
      return false;
    }
    ad.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
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