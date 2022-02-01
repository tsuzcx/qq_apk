package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;>;

public enum d
{
  public int aTC;
  public int iXT;
  
  static
  {
    AppMethodBeat.i(44790);
    iXP = new d("LOCATION", 0, 2, 2131755346);
    iXQ = new d("APPBRAND_VOIP", 1, 4, 2131755351);
    iXR = new d("AUDIO_OF_VIDEO_BACKGROUND_PLAY", 2, 8, 2131755342);
    iXS = new d("ALL", 3, 65535, -1);
    iXU = new d[] { iXP, iXQ, iXR, iXS };
    AppMethodBeat.o(44790);
  }
  
  private d(int paramInt1, int paramInt2)
  {
    this.aTC = paramInt1;
    this.iXT = paramInt2;
  }
  
  public static String aZ(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(44788);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      if (contains(localAppBrandBackgroundRunningApp.aTC, iXQ.aTC))
      {
        paramList = localAppBrandBackgroundRunningApp;
        if (localAppBrandBackgroundRunningApp.aTC != iXQ.aTC)
        {
          localArrayList.add(localAppBrandBackgroundRunningApp);
          paramList = localAppBrandBackgroundRunningApp;
        }
      }
      else
      {
        localArrayList.add(localAppBrandBackgroundRunningApp);
      }
    }
    if (paramList != null)
    {
      paramList = String.format("%s %s", new Object[] { String.format("%s %s", new Object[] { String.format(aj.getContext().getString(2131755348), new Object[] { paramList.name }), aj.getContext().getString(2131755351) }), ba(localArrayList) });
      AppMethodBeat.o(44788);
      return paramList;
    }
    paramList = ba(localArrayList);
    AppMethodBeat.o(44788);
    return paramList;
  }
  
  private static String ba(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(195672);
    String str = "";
    if (!paramList.isEmpty())
    {
      if (paramList.size() != 1) {
        break label91;
      }
      paramList = (AppBrandBackgroundRunningApp)paramList.get(0);
    }
    label91:
    for (str = String.format("%s %s", new Object[] { String.format(aj.getContext().getString(2131755348), new Object[] { paramList.name }), aj.getContext().getString(2131755345) });; str = String.format("%s %s", new Object[] { String.format(aj.getContext().getString(2131755347), new Object[] { Integer.valueOf(paramList.size()) }), aj.getContext().getString(2131755345) }))
    {
      AppMethodBeat.o(195672);
      return str;
    }
  }
  
  public static String bb(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(44789);
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((AppBrandBackgroundRunningApp)paramList.next()).aTC | i) {}
    Object localObject = null;
    d[] arrayOfd = values();
    int k = arrayOfd.length;
    int j = 0;
    if (j < k)
    {
      d locald = arrayOfd[j];
      paramList = (List<AppBrandBackgroundRunningApp>)localObject;
      if (locald.aTC != iXS.aTC)
      {
        paramList = (List<AppBrandBackgroundRunningApp>)localObject;
        if (locald.aTC != iXQ.aTC)
        {
          paramList = (List<AppBrandBackgroundRunningApp>)localObject;
          if (contains(i, locald.aTC)) {
            if (!bt.isNullOrNil((String)localObject)) {
              break label145;
            }
          }
        }
      }
      label145:
      for (paramList = aj.getContext().getString(locald.iXT);; paramList = String.format("%s、%s", new Object[] { localObject, aj.getContext().getString(locald.iXT) }))
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
  
  public static int dD(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int dE(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.d
 * JD-Core Version:    0.7.0.1
 */