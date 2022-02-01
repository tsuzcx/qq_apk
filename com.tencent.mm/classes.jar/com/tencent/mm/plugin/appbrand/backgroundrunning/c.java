package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;>;

public enum c
{
  public int beL;
  public int kYu;
  
  static
  {
    AppMethodBeat.i(44790);
    kYp = new c("LOCATION", 0, 2, 2131755383);
    kYq = new c("APPBRAND_VOIP", 1, 4, 2131755388);
    kYr = new c("AUDIO_OF_VIDEO_BACKGROUND_PLAY", 2, 8, 2131755379);
    kYs = new c("APPBRAND_VOIP_1v1", 3, 16, 2131755388);
    kYt = new c("ALL", 4, 65535, -1);
    kYv = new c[] { kYp, kYq, kYr, kYs, kYt };
    AppMethodBeat.o(44790);
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.beL = paramInt1;
    this.kYu = paramInt2;
  }
  
  public static String bm(List<AppBrandBackgroundRunningApp> paramList)
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
        if (contains(localAppBrandBackgroundRunningApp.beL, kYq.beL))
        {
          if (localAppBrandBackgroundRunningApp.beL != kYq.beL) {
            localArrayList.add(localAppBrandBackgroundRunningApp);
          }
          paramList = localAppBrandBackgroundRunningApp;
        }
        if (contains(localAppBrandBackgroundRunningApp.beL, kYs.beL))
        {
          if (localAppBrandBackgroundRunningApp.beL != kYs.beL)
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
          paramList = String.format("%s %s", new Object[] { String.format("%s %s", new Object[] { String.format(MMApplicationContext.getContext().getString(2131755385), new Object[] { paramList.name }), MMApplicationContext.getContext().getString(2131755388) }), bn(localArrayList) });
          AppMethodBeat.o(44788);
          return paramList;
        }
        paramList = bn(localArrayList);
        AppMethodBeat.o(44788);
        return paramList;
      }
      paramList = localAppBrandBackgroundRunningApp;
    }
  }
  
  private static String bn(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(226445);
    String str = "";
    if (!paramList.isEmpty())
    {
      if (paramList.size() != 1) {
        break label91;
      }
      paramList = (AppBrandBackgroundRunningApp)paramList.get(0);
    }
    label91:
    for (str = String.format("%s %s", new Object[] { String.format(MMApplicationContext.getContext().getString(2131755385), new Object[] { paramList.name }), MMApplicationContext.getContext().getString(2131755382) });; str = String.format("%s %s", new Object[] { String.format(MMApplicationContext.getContext().getString(2131755384), new Object[] { Integer.valueOf(paramList.size()) }), MMApplicationContext.getContext().getString(2131755382) }))
    {
      AppMethodBeat.o(226445);
      return str;
    }
  }
  
  public static String bo(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(44789);
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((AppBrandBackgroundRunningApp)paramList.next()).beL | i) {}
    Object localObject = null;
    c[] arrayOfc = values();
    int k = arrayOfc.length;
    int j = 0;
    if (j < k)
    {
      c localc = arrayOfc[j];
      paramList = (List<AppBrandBackgroundRunningApp>)localObject;
      if (localc.beL != kYt.beL)
      {
        paramList = (List<AppBrandBackgroundRunningApp>)localObject;
        if (localc.beL != kYq.beL)
        {
          paramList = (List<AppBrandBackgroundRunningApp>)localObject;
          if (localc.beL != kYs.beL)
          {
            paramList = (List<AppBrandBackgroundRunningApp>)localObject;
            if (contains(i, localc.beL)) {
              if (!Util.isNullOrNil((String)localObject)) {
                break label162;
              }
            }
          }
        }
      }
      label162:
      for (paramList = MMApplicationContext.getContext().getString(localc.kYu);; paramList = String.format("%s、%s", new Object[] { localObject, MMApplicationContext.getContext().getString(localc.kYu) }))
      {
        j += 1;
        localObject = paramList;
        break;
      }
    }
    AppMethodBeat.o(44789);
    return localObject;
  }
  
  public static boolean contains(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static int dQ(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int dR(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.c
 * JD-Core Version:    0.7.0.1
 */