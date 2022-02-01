package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;>;

public enum c
{
  public int cIi;
  public int info;
  
  static
  {
    AppMethodBeat.i(44790);
    qSm = new c("LOCATION", 0, 2, ba.i.app_brand_background_location);
    qSn = new c("APPBRAND_VOIP", 1, 4, ba.i.app_brand_background_voip);
    qSo = new c("AUDIO_OF_VIDEO_BACKGROUND_PLAY", 2, 8, ba.i.app_brand_background_audio_of_video_play);
    qSp = new c("APPBRAND_VOIP_1v1", 3, 16, ba.i.app_brand_background_voip);
    qSq = new c("BLUETOOTH", 4, 32, ba.i.app_brand_background_bluetooth);
    qSr = new c("ALL", 5, 65535, -1);
    qSs = new c[] { qSm, qSn, qSo, qSp, qSq, qSr };
    AppMethodBeat.o(44790);
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.cIi = paramInt1;
    this.info = paramInt2;
  }
  
  public static String cV(List<AppBrandBackgroundRunningApp> paramList)
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
        if (fh(localAppBrandBackgroundRunningApp.cIi, qSn.cIi))
        {
          if (localAppBrandBackgroundRunningApp.cIi != qSn.cIi) {
            localArrayList.add(localAppBrandBackgroundRunningApp);
          }
          paramList = localAppBrandBackgroundRunningApp;
        }
        if (fh(localAppBrandBackgroundRunningApp.cIi, qSp.cIi))
        {
          if (localAppBrandBackgroundRunningApp.cIi != qSp.cIi)
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
          paramList = String.format("%s %s", new Object[] { String.format("%s %s", new Object[] { String.format(MMApplicationContext.getContext().getString(ba.i.app_brand_background_notification_single_wxapp), new Object[] { paramList.name }), MMApplicationContext.getContext().getString(ba.i.app_brand_background_voip) }), cW(localArrayList) });
          AppMethodBeat.o(44788);
          return paramList;
        }
        paramList = cW(localArrayList);
        AppMethodBeat.o(44788);
        return paramList;
      }
      paramList = localAppBrandBackgroundRunningApp;
    }
  }
  
  private static String cW(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(318216);
    String str = "";
    if (!paramList.isEmpty())
    {
      if (paramList.size() != 1) {
        break label93;
      }
      paramList = (AppBrandBackgroundRunningApp)paramList.get(0);
    }
    label93:
    for (str = String.format("%s %s", new Object[] { String.format(MMApplicationContext.getContext().getString(ba.i.app_brand_background_notification_single_wxapp), new Object[] { paramList.name }), MMApplicationContext.getContext().getString(ba.i.app_brand_background_is_using) });; str = String.format("%s %s", new Object[] { String.format(MMApplicationContext.getContext().getString(ba.i.app_brand_background_many_wxapp), new Object[] { Integer.valueOf(paramList.size()) }), MMApplicationContext.getContext().getString(ba.i.app_brand_background_is_using) }))
    {
      AppMethodBeat.o(318216);
      return str;
    }
  }
  
  public static String cX(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(44789);
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((AppBrandBackgroundRunningApp)paramList.next()).cIi | i) {}
    Object localObject = null;
    c[] arrayOfc = values();
    int k = arrayOfc.length;
    int j = 0;
    if (j < k)
    {
      c localc = arrayOfc[j];
      paramList = (List<AppBrandBackgroundRunningApp>)localObject;
      if (localc.cIi != qSr.cIi)
      {
        paramList = (List<AppBrandBackgroundRunningApp>)localObject;
        if (localc.cIi != qSn.cIi)
        {
          paramList = (List<AppBrandBackgroundRunningApp>)localObject;
          if (localc.cIi != qSp.cIi)
          {
            paramList = (List<AppBrandBackgroundRunningApp>)localObject;
            if (fh(i, localc.cIi)) {
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
  
  public static boolean fh(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static int fi(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int fj(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.c
 * JD-Core Version:    0.7.0.1
 */