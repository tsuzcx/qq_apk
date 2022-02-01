package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;>;

public enum d
{
  public int aUu;
  public int jyk;
  
  static
  {
    AppMethodBeat.i(44790);
    jyf = new d("LOCATION", 0, 2, 2131755346);
    jyg = new d("APPBRAND_VOIP", 1, 4, 2131755351);
    jyh = new d("AUDIO_OF_VIDEO_BACKGROUND_PLAY", 2, 8, 2131755342);
    jyi = new d("APPBRAND_VOIP_1v1", 3, 16, 2131755351);
    jyj = new d("ALL", 4, 65535, -1);
    jyl = new d[] { jyf, jyg, jyh, jyi, jyj };
    AppMethodBeat.o(44790);
  }
  
  private d(int paramInt1, int paramInt2)
  {
    this.aUu = paramInt1;
    this.jyk = paramInt2;
  }
  
  public static String aX(List<AppBrandBackgroundRunningApp> paramList)
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
        if (contains(localAppBrandBackgroundRunningApp.aUu, jyg.aUu))
        {
          if (localAppBrandBackgroundRunningApp.aUu != jyg.aUu) {
            localArrayList.add(localAppBrandBackgroundRunningApp);
          }
          paramList = localAppBrandBackgroundRunningApp;
        }
        if (contains(localAppBrandBackgroundRunningApp.aUu, jyi.aUu))
        {
          if (localAppBrandBackgroundRunningApp.aUu != jyi.aUu)
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
          paramList = String.format("%s %s", new Object[] { String.format("%s %s", new Object[] { String.format(ai.getContext().getString(2131755348), new Object[] { paramList.name }), ai.getContext().getString(2131755351) }), aY(localArrayList) });
          AppMethodBeat.o(44788);
          return paramList;
        }
        paramList = aY(localArrayList);
        AppMethodBeat.o(44788);
        return paramList;
      }
      paramList = localAppBrandBackgroundRunningApp;
    }
  }
  
  private static String aY(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(186391);
    String str = "";
    if (!paramList.isEmpty())
    {
      if (paramList.size() != 1) {
        break label91;
      }
      paramList = (AppBrandBackgroundRunningApp)paramList.get(0);
    }
    label91:
    for (str = String.format("%s %s", new Object[] { String.format(ai.getContext().getString(2131755348), new Object[] { paramList.name }), ai.getContext().getString(2131755345) });; str = String.format("%s %s", new Object[] { String.format(ai.getContext().getString(2131755347), new Object[] { Integer.valueOf(paramList.size()) }), ai.getContext().getString(2131755345) }))
    {
      AppMethodBeat.o(186391);
      return str;
    }
  }
  
  public static String aZ(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(44789);
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((AppBrandBackgroundRunningApp)paramList.next()).aUu | i) {}
    Object localObject = null;
    d[] arrayOfd = values();
    int k = arrayOfd.length;
    int j = 0;
    if (j < k)
    {
      d locald = arrayOfd[j];
      paramList = (List<AppBrandBackgroundRunningApp>)localObject;
      if (locald.aUu != jyj.aUu)
      {
        paramList = (List<AppBrandBackgroundRunningApp>)localObject;
        if (locald.aUu != jyg.aUu)
        {
          paramList = (List<AppBrandBackgroundRunningApp>)localObject;
          if (locald.aUu != jyi.aUu)
          {
            paramList = (List<AppBrandBackgroundRunningApp>)localObject;
            if (contains(i, locald.aUu)) {
              if (!bs.isNullOrNil((String)localObject)) {
                break label162;
              }
            }
          }
        }
      }
      label162:
      for (paramList = ai.getContext().getString(locald.jyk);; paramList = String.format("%s、%s", new Object[] { localObject, ai.getContext().getString(locald.jyk) }))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.d
 * JD-Core Version:    0.7.0.1
 */