package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;>;

public enum c
{
  public int aOm;
  public int info;
  
  static
  {
    AppMethodBeat.i(44790);
    nSB = new c("LOCATION", 0, 2, au.i.app_brand_background_location);
    nSC = new c("APPBRAND_VOIP", 1, 4, au.i.app_brand_background_voip);
    nSD = new c("AUDIO_OF_VIDEO_BACKGROUND_PLAY", 2, 8, au.i.app_brand_background_audio_of_video_play);
    nSE = new c("APPBRAND_VOIP_1v1", 3, 16, au.i.app_brand_background_voip);
    nSF = new c("ALL", 4, 65535, -1);
    nSG = new c[] { nSB, nSC, nSD, nSE, nSF };
    AppMethodBeat.o(44790);
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.aOm = paramInt1;
    this.info = paramInt2;
  }
  
  public static String bk(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(44788);
    AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = localAppBrandBackgroundRunningApp;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
        if (eo(localAppBrandBackgroundRunningApp.aOm, nSC.aOm))
        {
          if (localAppBrandBackgroundRunningApp.aOm != nSC.aOm) {
            localArrayList.add(localAppBrandBackgroundRunningApp);
          }
          paramList = localAppBrandBackgroundRunningApp;
        }
        if (eo(localAppBrandBackgroundRunningApp.aOm, nSE.aOm))
        {
          if (localAppBrandBackgroundRunningApp.aOm != nSE.aOm)
          {
            localArrayList.add(localAppBrandBackgroundRunningApp);
            paramList = localAppBrandBackgroundRunningApp;
          }
        }
        else {
          localArrayList.add(localAppBrandBackgroundRunningApp);
        }
      }
      else
      {
        if (paramList != null)
        {
          paramList = String.format("%s %s", new Object[] { String.format("%s %s", new Object[] { String.format(MMApplicationContext.getContext().getString(au.i.app_brand_background_notification_single_wxapp), new Object[] { paramList.name }), MMApplicationContext.getContext().getString(au.i.app_brand_background_voip) }), bl(localArrayList) });
          AppMethodBeat.o(44788);
          return paramList;
        }
        paramList = bl(localArrayList);
        AppMethodBeat.o(44788);
        return paramList;
      }
      paramList = localAppBrandBackgroundRunningApp;
    }
  }
  
  private static String bl(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(246522);
    String str = "";
    if (!paramList.isEmpty())
    {
      if (paramList.size() != 1) {
        break label93;
      }
      paramList = (AppBrandBackgroundRunningApp)paramList.get(0);
    }
    label93:
    for (str = String.format("%s %s", new Object[] { String.format(MMApplicationContext.getContext().getString(au.i.app_brand_background_notification_single_wxapp), new Object[] { paramList.name }), MMApplicationContext.getContext().getString(au.i.app_brand_background_is_using) });; str = String.format("%s %s", new Object[] { String.format(MMApplicationContext.getContext().getString(au.i.app_brand_background_many_wxapp), new Object[] { Integer.valueOf(paramList.size()) }), MMApplicationContext.getContext().getString(au.i.app_brand_background_is_using) }))
    {
      AppMethodBeat.o(246522);
      return str;
    }
  }
  
  public static String bm(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(44789);
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((AppBrandBackgroundRunningApp)paramList.next()).aOm | i) {}
    Object localObject = null;
    c[] arrayOfc = values();
    int k = arrayOfc.length;
    int j = 0;
    if (j < k)
    {
      c localc = arrayOfc[j];
      paramList = (List<AppBrandBackgroundRunningApp>)localObject;
      if (localc.aOm != nSF.aOm)
      {
        paramList = (List<AppBrandBackgroundRunningApp>)localObject;
        if (localc.aOm != nSC.aOm)
        {
          paramList = (List<AppBrandBackgroundRunningApp>)localObject;
          if (localc.aOm != nSE.aOm)
          {
            paramList = (List<AppBrandBackgroundRunningApp>)localObject;
            if (eo(i, localc.aOm)) {
              if (!Util.isNullOrNil((String)localObject)) {
                break label162;
              }
            }
          }
        }
      }
      label162:
      for (paramList = MMApplicationContext.getContext().getString(localc.info);; paramList = String.format("%s、%s", new Object[] { localObject, MMApplicationContext.getContext().getString(localc.info) }))
      {
        j += 1;
        localObject = paramList;
        break;
      }
    }
    AppMethodBeat.o(44789);
    return localObject;
  }
  
  public static boolean eo(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static int ep(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int eq(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.c
 * JD-Core Version:    0.7.0.1
 */