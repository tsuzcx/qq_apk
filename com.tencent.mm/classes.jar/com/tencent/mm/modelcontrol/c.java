package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c
  implements com.tencent.mm.model.az
{
  public static boolean K(bv parambv)
  {
    AppMethodBeat.i(150454);
    if (parambv == null)
    {
      ae.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
      AppMethodBeat.o(150454);
      return false;
    }
    parambv = bl.BS(parambv.eNd);
    if (parambv == null)
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
      AppMethodBeat.o(150454);
      return true;
    }
    parambv = parambv.hJT;
    if (bu.isNullOrNil(parambv))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
      AppMethodBeat.o(150454);
      return true;
    }
    if (b.Fv(parambv))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : ".concat(String.valueOf(parambv)));
      AppMethodBeat.o(150454);
      return false;
    }
    ae.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: ".concat(String.valueOf(parambv)));
    AppMethodBeat.o(150454);
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150453);
    paramPInt1.value = 0;
    int i = bu.getInt(((a)g.ab(a.class)).acL().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
      AppMethodBeat.o(150453);
      return false;
    }
    boolean bool = com.tencent.mm.sdk.platformtools.az.isWifi(ak.getContext());
    if ((i == 2) && (!bool))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
      AppMethodBeat.o(150453);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.az.is2G(ak.getContext()))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
      AppMethodBeat.o(150453);
      return false;
    }
    paramPInt2 = ((a)g.ab(a.class)).acL().getValue("SnsAdSightNotAutoDownloadTimeRange");
    ae.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: ".concat(String.valueOf(paramPInt2)));
    if (b.Fv(paramPInt2))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        AppMethodBeat.o(150453);
        return false;
      }
    }
    ae.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
    AppMethodBeat.o(150453);
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2, PInt paramPInt3)
  {
    AppMethodBeat.i(150452);
    paramPInt1.value = 0;
    int i = bu.getInt(((a)g.ab(a.class)).acL().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
      AppMethodBeat.o(150452);
      return false;
    }
    boolean bool = com.tencent.mm.sdk.platformtools.az.isWifi(ak.getContext());
    if ((i == 2) && (!bool))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
      AppMethodBeat.o(150452);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.az.is2G(ak.getContext()))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
      AppMethodBeat.o(150452);
      return false;
    }
    paramPInt2 = ((a)g.ab(a.class)).acL().getValue("SnsSightNoAutoDownload");
    if (!bu.isNullOrNil(paramPInt2)) {
      try
      {
        ae.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq ".concat(String.valueOf(paramPInt2)));
        long l1 = bu.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0L) - ((int)b.aHd() - 8) * 60L / 1000L;
        String[] arrayOfString = paramPInt2.split(",");
        long l2 = bu.getLong(arrayOfString[0], 0L);
        if ((l1 <= bu.getLong(arrayOfString[1], 0L)) && (l1 >= l2))
        {
          ae.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
          paramPInt3.value = 1;
          AppMethodBeat.o(150452);
          return false;
        }
      }
      catch (Exception paramPInt3)
      {
        ae.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", new Object[] { paramPInt2, paramPInt3.getMessage() });
      }
    }
    paramPInt2 = ((a)g.ab(a.class)).acL().getValue("SnsSightNotAutoDownloadTimeRange");
    ae.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(paramPInt2)));
    if (b.Fv(paramPInt2))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        AppMethodBeat.o(150452);
        return false;
      }
    }
    ae.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
    AppMethodBeat.o(150452);
    return true;
  }
  
  public static c aHe()
  {
    try
    {
      AppMethodBeat.i(150449);
      c localc = (c)u.ap(c.class);
      AppMethodBeat.o(150449);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean aHf()
  {
    AppMethodBeat.i(150450);
    if (b.aHb())
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
      AppMethodBeat.o(150450);
      return false;
    }
    int i = bu.getInt(((a)g.ab(a.class)).acL().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
      AppMethodBeat.o(150450);
      return false;
    }
    Context localContext = ak.getContext();
    if ((i == 2) && (com.tencent.mm.sdk.platformtools.az.isWifi(localContext)))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      AppMethodBeat.o(150450);
      return true;
    }
    if ((i == 1) && (com.tencent.mm.sdk.platformtools.az.isWifi(localContext)))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      AppMethodBeat.o(150450);
      return true;
    }
    long l2 = bu.getInt(((a)g.ab(a.class)).acL().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bu.a((Long)g.ajR().ajA().get(am.a.ILG, null), 0L);
    long l3 = bu.aSC((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bu.a((Long)g.ajR().ajA().get(am.a.ILH, null), 0L);
    ae.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1 + " downloadMode: " + i);
    if (l3 != l4)
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "update month %d ", new Object[] { Long.valueOf(l3) });
      g.ajR().ajA().set(am.a.ILG, Long.valueOf(0L));
      g.ajR().ajA().set(am.a.ILH, Long.valueOf(l3));
      l1 = 0L;
    }
    for (;;)
    {
      if ((l1 > l2) && (l2 > 0L))
      {
        ae.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + l1 + " C2C image, can not auto download.");
        AppMethodBeat.o(150450);
        return false;
      }
      if ((i == 1) && ((com.tencent.mm.sdk.platformtools.az.isWifi(localContext)) || (com.tencent.mm.sdk.platformtools.az.is3G(localContext)) || (com.tencent.mm.sdk.platformtools.az.is4G(localContext))))
      {
        ae.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
        AppMethodBeat.o(150450);
        return true;
      }
      ae.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
      AppMethodBeat.o(150450);
      return false;
    }
  }
  
  public static boolean aHg()
  {
    AppMethodBeat.i(150451);
    String str = ((a)g.ab(a.class)).acL().getValue("SnsImgPreLoadingAroundTimeLimit");
    ae.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: ".concat(String.valueOf(str)));
    if (b.Fv(str))
    {
      ae.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
      AppMethodBeat.o(150451);
      return false;
    }
    ae.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
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