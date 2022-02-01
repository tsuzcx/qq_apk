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
  public int beO;
  public int jSh;
  
  static
  {
    AppMethodBeat.i(44790);
    jSc = new d("LOCATION", 0, 2, 2131755346);
    jSd = new d("APPBRAND_VOIP", 1, 4, 2131755351);
    jSe = new d("AUDIO_OF_VIDEO_BACKGROUND_PLAY", 2, 8, 2131755342);
    jSf = new d("APPBRAND_VOIP_1v1", 3, 16, 2131755351);
    jSg = new d("ALL", 4, 65535, -1);
    jSi = new d[] { jSc, jSd, jSe, jSf, jSg };
    AppMethodBeat.o(44790);
  }
  
  private d(int paramInt1, int paramInt2)
  {
    this.beO = paramInt1;
    this.jSh = paramInt2;
  }
  
  public static String aZ(List<AppBrandBackgroundRunningApp> paramList)
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
        if (contains(localAppBrandBackgroundRunningApp.beO, jSd.beO))
        {
          if (localAppBrandBackgroundRunningApp.beO != jSd.beO) {
            localArrayList.add(localAppBrandBackgroundRunningApp);
          }
          paramList = localAppBrandBackgroundRunningApp;
        }
        if (contains(localAppBrandBackgroundRunningApp.beO, jSf.beO))
        {
          if (localAppBrandBackgroundRunningApp.beO != jSf.beO)
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
          paramList = String.format("%s %s", new Object[] { String.format("%s %s", new Object[] { String.format(aj.getContext().getString(2131755348), new Object[] { paramList.name }), aj.getContext().getString(2131755351) }), ba(localArrayList) });
          AppMethodBeat.o(44788);
          return paramList;
        }
        paramList = ba(localArrayList);
        AppMethodBeat.o(44788);
        return paramList;
      }
      paramList = localAppBrandBackgroundRunningApp;
    }
  }
  
  private static String ba(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(188084);
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
      AppMethodBeat.o(188084);
      return str;
    }
  }
  
  public static String bb(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(44789);
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((AppBrandBackgroundRunningApp)paramList.next()).beO | i) {}
    Object localObject = null;
    d[] arrayOfd = values();
    int k = arrayOfd.length;
    int j = 0;
    if (j < k)
    {
      d locald = arrayOfd[j];
      paramList = (List<AppBrandBackgroundRunningApp>)localObject;
      if (locald.beO != jSg.beO)
      {
        paramList = (List<AppBrandBackgroundRunningApp>)localObject;
        if (locald.beO != jSd.beO)
        {
          paramList = (List<AppBrandBackgroundRunningApp>)localObject;
          if (locald.beO != jSf.beO)
          {
            paramList = (List<AppBrandBackgroundRunningApp>)localObject;
            if (contains(i, locald.beO)) {
              if (!bt.isNullOrNil((String)localObject)) {
                break label162;
              }
            }
          }
        }
      }
      label162:
      for (paramList = aj.getContext().getString(locald.jSh);; paramList = String.format("%s、%s", new Object[] { localObject, aj.getContext().getString(locald.jSh) }))
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
  
  public static int dF(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int dG(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.d
 * JD-Core Version:    0.7.0.1
 */