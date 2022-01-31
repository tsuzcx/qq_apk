package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c
  implements ar
{
  public static c Ni()
  {
    try
    {
      c localc = (c)p.B(c.class);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean Nj()
  {
    Object localObject = ((a)g.r(a.class)).AA().getValue("C2CImgNotAutoDownloadTimeRange");
    y.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: " + (String)localObject);
    if (b.lO((String)localObject))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
      return false;
    }
    int i = bk.getInt(((a)g.r(a.class)).AA().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      y.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : " + i);
      return false;
    }
    localObject = ae.getContext();
    if ((i == 2) && (aq.isWifi((Context)localObject)))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      return true;
    }
    if ((i == 1) && (aq.isWifi((Context)localObject)))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      return true;
    }
    long l2 = bk.getInt(((a)g.r(a.class)).AA().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bk.a((Long)g.DP().Dz().get(ac.a.uoM, null), 0L);
    long l3 = bk.ZS((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bk.a((Long)g.DP().Dz().get(ac.a.uoN, null), 0L);
    y.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1 + " downloadMode: " + i);
    if (l3 != l4)
    {
      y.i("MicroMsg.SubCoreAutoDownload", "update month %d ", new Object[] { Long.valueOf(l3) });
      g.DP().Dz().c(ac.a.uoM, Long.valueOf(0L));
      g.DP().Dz().c(ac.a.uoN, Long.valueOf(l3));
      l1 = 0L;
    }
    for (;;)
    {
      if ((l1 > l2) && (l2 > 0L))
      {
        y.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + l1 + " C2C image, can not auto download.");
        return false;
      }
      if ((i == 1) && ((aq.isWifi((Context)localObject)) || (aq.is3G((Context)localObject)) || (aq.is4G((Context)localObject))))
      {
        y.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
        return true;
      }
      y.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
      return false;
    }
  }
  
  public static boolean Nk()
  {
    String str = ((a)g.r(a.class)).AA().getValue("SnsImgPreLoadingAroundTimeLimit");
    y.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: " + str);
    if (b.lO(str))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
      return false;
    }
    y.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2)
  {
    paramPInt1.value = 0;
    int i = bk.getInt(((a)g.r(a.class)).AA().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      y.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
      return false;
    }
    boolean bool = aq.isWifi(ae.getContext());
    if ((i == 2) && (!bool))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
      return false;
    }
    if (aq.is2G(ae.getContext()))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
      return false;
    }
    paramPInt2 = ((a)g.r(a.class)).AA().getValue("SnsAdSightNotAutoDownloadTimeRange");
    y.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: " + paramPInt2);
    if (b.lO(paramPInt2))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        return false;
      }
    }
    y.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2, PInt paramPInt3)
  {
    paramPInt1.value = 0;
    int i = bk.getInt(((a)g.r(a.class)).AA().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      y.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
      return false;
    }
    boolean bool = aq.isWifi(ae.getContext());
    if ((i == 2) && (!bool))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
      return false;
    }
    if (aq.is2G(ae.getContext()))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
      return false;
    }
    paramPInt2 = ((a)g.r(a.class)).AA().getValue("SnsSightNoAutoDownload");
    if (!bk.bl(paramPInt2)) {
      try
      {
        y.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq " + paramPInt2);
        long l1 = bk.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0L) - ((int)b.Nh() - 8) * 60L / 1000L;
        String[] arrayOfString = paramPInt2.split(",");
        long l2 = bk.getLong(arrayOfString[0], 0L);
        if ((l1 <= bk.getLong(arrayOfString[1], 0L)) && (l1 >= l2))
        {
          y.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
          paramPInt3.value = 1;
          return false;
        }
      }
      catch (Exception paramPInt3)
      {
        y.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", new Object[] { paramPInt2, paramPInt3.getMessage() });
      }
    }
    paramPInt2 = ((a)g.r(a.class)).AA().getValue("SnsSightNotAutoDownloadTimeRange");
    y.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: " + paramPInt2);
    if (b.lO(paramPInt2))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        return false;
      }
    }
    y.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
    return true;
  }
  
  public static boolean o(bi parambi)
  {
    if (parambi == null)
    {
      y.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
      return false;
    }
    if (!parambi.ctB())
    {
      y.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
      return false;
    }
    if (!p(parambi))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
      return false;
    }
    return Nj();
  }
  
  public static boolean p(bi parambi)
  {
    if (parambi == null)
    {
      y.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
      return false;
    }
    parambi = bd.iM(parambi.czr);
    if (parambi == null)
    {
      y.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
      return true;
    }
    parambi = parambi.dWJ;
    if (bk.bl(parambi))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
      return true;
    }
    if (b.lO(parambi))
    {
      y.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : " + parambi);
      return false;
    }
    y.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: " + parambi);
    return true;
  }
  
  public final void bh(boolean paramBoolean) {}
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease() {}
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.c
 * JD-Core Version:    0.7.0.1
 */