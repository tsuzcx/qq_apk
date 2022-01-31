package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c
  implements com.tencent.mm.model.at
{
  public static boolean a(PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(78096);
    paramPInt1.value = 0;
    int i = bo.getInt(((a)g.E(a.class)).Nq().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
      AppMethodBeat.o(78096);
      return false;
    }
    boolean bool = com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext());
    if ((i == 2) && (!bool))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
      AppMethodBeat.o(78096);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.at.is2G(ah.getContext()))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
      AppMethodBeat.o(78096);
      return false;
    }
    paramPInt2 = ((a)g.E(a.class)).Nq().getValue("SnsAdSightNotAutoDownloadTimeRange");
    ab.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: ".concat(String.valueOf(paramPInt2)));
    if (b.sM(paramPInt2))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        AppMethodBeat.o(78096);
        return false;
      }
    }
    ab.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
    AppMethodBeat.o(78096);
    return true;
  }
  
  public static boolean a(PInt paramPInt1, PInt paramPInt2, PInt paramPInt3)
  {
    AppMethodBeat.i(78095);
    paramPInt1.value = 0;
    int i = bo.getInt(((a)g.E(a.class)).Nq().getValue("SIGHTAutoLoadNetwork"), 1);
    paramPInt2.value = i;
    if (i == 3)
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
      AppMethodBeat.o(78095);
      return false;
    }
    boolean bool = com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext());
    if ((i == 2) && (!bool))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
      AppMethodBeat.o(78095);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.at.is2G(ah.getContext()))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
      AppMethodBeat.o(78095);
      return false;
    }
    paramPInt2 = ((a)g.E(a.class)).Nq().getValue("SnsSightNoAutoDownload");
    if (!bo.isNullOrNil(paramPInt2)) {
      try
      {
        ab.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq ".concat(String.valueOf(paramPInt2)));
        long l1 = bo.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0L) - ((int)b.afS() - 8) * 60L / 1000L;
        String[] arrayOfString = paramPInt2.split(",");
        long l2 = bo.getLong(arrayOfString[0], 0L);
        if ((l1 <= bo.getLong(arrayOfString[1], 0L)) && (l1 >= l2))
        {
          ab.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
          paramPInt3.value = 1;
          AppMethodBeat.o(78095);
          return false;
        }
      }
      catch (Exception paramPInt3)
      {
        ab.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", new Object[] { paramPInt2, paramPInt3.getMessage() });
      }
    }
    paramPInt2 = ((a)g.E(a.class)).Nq().getValue("SnsSightNotAutoDownloadTimeRange");
    ab.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(paramPInt2)));
    if (b.sM(paramPInt2))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
      if (i == 2) {}
      for (i = 2;; i = 1)
      {
        paramPInt1.value = i;
        AppMethodBeat.o(78095);
        return false;
      }
    }
    ab.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
    AppMethodBeat.o(78095);
    return true;
  }
  
  public static c afT()
  {
    try
    {
      AppMethodBeat.i(78091);
      c localc = (c)q.S(c.class);
      AppMethodBeat.o(78091);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean afU()
  {
    AppMethodBeat.i(78093);
    if (b.afQ())
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
      AppMethodBeat.o(78093);
      return false;
    }
    int i = bo.getInt(((a)g.E(a.class)).Nq().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
      AppMethodBeat.o(78093);
      return false;
    }
    Context localContext = ah.getContext();
    if ((i == 2) && (com.tencent.mm.sdk.platformtools.at.isWifi(localContext)))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      AppMethodBeat.o(78093);
      return true;
    }
    if ((i == 1) && (com.tencent.mm.sdk.platformtools.at.isWifi(localContext)))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
      AppMethodBeat.o(78093);
      return true;
    }
    long l2 = bo.getInt(((a)g.E(a.class)).Nq().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bo.a((Long)g.RL().Ru().get(ac.a.yyI, null), 0L);
    long l3 = bo.apW((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bo.a((Long)g.RL().Ru().get(ac.a.yyJ, null), 0L);
    ab.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1 + " downloadMode: " + i);
    if (l3 != l4)
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "update month %d ", new Object[] { Long.valueOf(l3) });
      g.RL().Ru().set(ac.a.yyI, Long.valueOf(0L));
      g.RL().Ru().set(ac.a.yyJ, Long.valueOf(l3));
      l1 = 0L;
    }
    for (;;)
    {
      if ((l1 > l2) && (l2 > 0L))
      {
        ab.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + l1 + " C2C image, can not auto download.");
        AppMethodBeat.o(78093);
        return false;
      }
      if ((i == 1) && ((com.tencent.mm.sdk.platformtools.at.isWifi(localContext)) || (com.tencent.mm.sdk.platformtools.at.is3G(localContext)) || (com.tencent.mm.sdk.platformtools.at.is4G(localContext))))
      {
        ab.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
        AppMethodBeat.o(78093);
        return true;
      }
      ab.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
      AppMethodBeat.o(78093);
      return false;
    }
  }
  
  public static boolean afV()
  {
    AppMethodBeat.i(78094);
    String str = ((a)g.E(a.class)).Nq().getValue("SnsImgPreLoadingAroundTimeLimit");
    ab.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: ".concat(String.valueOf(str)));
    if (b.sM(str))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
      AppMethodBeat.o(78094);
      return false;
    }
    ab.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
    AppMethodBeat.o(78094);
    return true;
  }
  
  public static boolean u(bi parambi)
  {
    AppMethodBeat.i(78092);
    if (parambi == null)
    {
      ab.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
      AppMethodBeat.o(78092);
      return false;
    }
    if (!parambi.dvX())
    {
      ab.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
      AppMethodBeat.o(78092);
      return false;
    }
    if (!v(parambi))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
      AppMethodBeat.o(78092);
      return false;
    }
    boolean bool = afU();
    AppMethodBeat.o(78092);
    return bool;
  }
  
  public static boolean v(bi parambi)
  {
    AppMethodBeat.i(78097);
    if (parambi == null)
    {
      ab.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
      AppMethodBeat.o(78097);
      return false;
    }
    parambi = bf.pA(parambi.dns);
    if (parambi == null)
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
      AppMethodBeat.o(78097);
      return true;
    }
    parambi = parambi.fmR;
    if (bo.isNullOrNil(parambi))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
      AppMethodBeat.o(78097);
      return true;
    }
    if (b.sM(parambi))
    {
      ab.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : ".concat(String.valueOf(parambi)));
      AppMethodBeat.o(78097);
      return false;
    }
    ab.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: ".concat(String.valueOf(parambi)));
    AppMethodBeat.o(78097);
    return true;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.c
 * JD-Core Version:    0.7.0.1
 */