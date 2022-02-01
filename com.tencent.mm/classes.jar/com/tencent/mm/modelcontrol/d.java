package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.systemservicecache.NetworkCache;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class d
  implements be
{
  public static boolean a(PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150453);
    paramPInt1.value = 0;
    int i = Util.getInt(((a)h.ax(a.class)).aRC().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
      AppMethodBeat.o(150453);
      return false;
    }
    boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    if ((i == 2) && (!bool))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
      AppMethodBeat.o(150453);
      return false;
    }
    if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
      AppMethodBeat.o(150453);
      return false;
    }
    paramPInt2 = ((a)h.ax(a.class)).aRC().getValue("SnsAdSightNotAutoDownloadTimeRange");
    Log.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: ".concat(String.valueOf(paramPInt2)));
    if (b.NB(paramPInt2))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        AppMethodBeat.o(150453);
        return false;
      }
    }
    Log.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
    AppMethodBeat.o(150453);
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2, PInt paramPInt3)
  {
    AppMethodBeat.i(150452);
    paramPInt1.value = 0;
    int i = Util.getInt(((a)h.ax(a.class)).aRC().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
      AppMethodBeat.o(150452);
      return false;
    }
    boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    if ((i == 2) && (!bool))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
      AppMethodBeat.o(150452);
      return false;
    }
    if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
      AppMethodBeat.o(150452);
      return false;
    }
    paramPInt2 = ((a)h.ax(a.class)).aRC().getValue("SnsSightNoAutoDownload");
    if (!Util.isNullOrNil(paramPInt2)) {
      try
      {
        Log.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq ".concat(String.valueOf(paramPInt2)));
        long l1 = Util.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0L) - ((int)b.bIb() - 8) * 60L / 1000L;
        String[] arrayOfString = paramPInt2.split(",");
        long l2 = Util.getLong(arrayOfString[0], 0L);
        if ((l1 <= Util.getLong(arrayOfString[1], 0L)) && (l1 >= l2))
        {
          Log.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
          paramPInt3.value = 1;
          AppMethodBeat.o(150452);
          return false;
        }
      }
      catch (Exception paramPInt3)
      {
        Log.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", new Object[] { paramPInt2, paramPInt3.getMessage() });
      }
    }
    paramPInt2 = ((a)h.ax(a.class)).aRC().getValue("SnsSightNotAutoDownloadTimeRange");
    Log.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(paramPInt2)));
    if (b.NB(paramPInt2))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        AppMethodBeat.o(150452);
        return false;
      }
    }
    Log.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
    AppMethodBeat.o(150452);
    return true;
  }
  
  public static boolean ae(cc paramcc)
  {
    AppMethodBeat.i(150454);
    if (paramcc == null)
    {
      Log.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
      AppMethodBeat.o(150454);
      return false;
    }
    paramcc = br.JP(paramcc.jUr);
    if (paramcc == null)
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
      AppMethodBeat.o(150454);
      return true;
    }
    paramcc = paramcc.omd;
    if (Util.isNullOrNil(paramcc))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
      AppMethodBeat.o(150454);
      return true;
    }
    if (b.NB(paramcc))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : ".concat(String.valueOf(paramcc)));
      AppMethodBeat.o(150454);
      return false;
    }
    Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: ".concat(String.valueOf(paramcc)));
    AppMethodBeat.o(150454);
    return true;
  }
  
  public static d bId()
  {
    try
    {
      AppMethodBeat.i(150449);
      d locald = (d)y.aL(d.class);
      AppMethodBeat.o(150449);
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean bIe()
  {
    AppMethodBeat.i(150450);
    if (b.bHZ())
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
      AppMethodBeat.o(150450);
      return false;
    }
    int i = Util.getInt(((a)h.ax(a.class)).aRC().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
      AppMethodBeat.o(150450);
      return false;
    }
    Context localContext = MMApplicationContext.getContext();
    if ((i == 2) && (NetworkCache.INSTANCE.isWifiFromCache(localContext)))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      AppMethodBeat.o(150450);
      return true;
    }
    if ((i == 1) && (NetworkCache.INSTANCE.isWifiFromCache(localContext)))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      AppMethodBeat.o(150450);
      return true;
    }
    long l2 = Util.getInt(((a)h.ax(a.class)).aRC().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = Util.nullAs((Long)h.baE().ban().get(at.a.acJc, null), 0L);
    long l3 = Util.safeParseLong((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = Util.nullAs((Long)h.baE().ban().get(at.a.acJd, null), 0L);
    Log.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1 + " downloadMode: " + i);
    if (l3 != l4)
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "update month %d ", new Object[] { Long.valueOf(l3) });
      h.baE().ban().set(at.a.acJc, Long.valueOf(0L));
      h.baE().ban().set(at.a.acJd, Long.valueOf(l3));
      l1 = 0L;
    }
    for (;;)
    {
      if ((l1 > l2) && (l2 > 0L))
      {
        Log.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + l1 + " C2C image, can not auto download.");
        AppMethodBeat.o(150450);
        return false;
      }
      if ((i == 1) && ((NetStatusUtil.isWifi(localContext)) || (NetStatusUtil.is3G(localContext)) || (NetStatusUtil.is4G(localContext))))
      {
        Log.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
        AppMethodBeat.o(150450);
        return true;
      }
      Log.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
      AppMethodBeat.o(150450);
      return false;
    }
  }
  
  public static boolean bIf()
  {
    AppMethodBeat.i(150451);
    String str = ((a)h.ax(a.class)).aRC().getValue("SnsImgPreLoadingAroundTimeLimit");
    Log.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: ".concat(String.valueOf(str)));
    if (b.NB(str))
    {
      Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
      AppMethodBeat.o(150451);
      return false;
    }
    Log.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.d
 * JD-Core Version:    0.7.0.1
 */