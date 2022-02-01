package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;>;

public enum c
{
  public int beO;
  public int jVy;
  
  static
  {
    AppMethodBeat.i(44790);
    jVt = new c("LOCATION", 0, 2, 2131755346);
    jVu = new c("APPBRAND_VOIP", 1, 4, 2131755351);
    jVv = new c("AUDIO_OF_VIDEO_BACKGROUND_PLAY", 2, 8, 2131755342);
    jVw = new c("APPBRAND_VOIP_1v1", 3, 16, 2131755351);
    jVx = new c("ALL", 4, 65535, -1);
    jVz = new c[] { jVt, jVu, jVv, jVw, jVx };
    AppMethodBeat.o(44790);
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.beO = paramInt1;
    this.jVy = paramInt2;
  }
  
  public static String bb(List<AppBrandBackgroundRunningApp> paramList)
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
        if (contains(localAppBrandBackgroundRunningApp.beO, jVu.beO))
        {
          if (localAppBrandBackgroundRunningApp.beO != jVu.beO) {
            localArrayList.add(localAppBrandBackgroundRunningApp);
          }
          paramList = localAppBrandBackgroundRunningApp;
        }
        if (contains(localAppBrandBackgroundRunningApp.beO, jVw.beO))
        {
          if (localAppBrandBackgroundRunningApp.beO != jVw.beO)
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
          paramList = String.format("%s %s", new Object[] { String.format("%s %s", new Object[] { String.format(ak.getContext().getString(2131755348), new Object[] { paramList.name }), ak.getContext().getString(2131755351) }), bc(localArrayList) });
          AppMethodBeat.o(44788);
          return paramList;
        }
        paramList = bc(localArrayList);
        AppMethodBeat.o(44788);
        return paramList;
      }
      paramList = localAppBrandBackgroundRunningApp;
    }
  }
  
  private static String bc(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(222204);
    String str = "";
    if (!paramList.isEmpty())
    {
      if (paramList.size() != 1) {
        break label91;
      }
      paramList = (AppBrandBackgroundRunningApp)paramList.get(0);
    }
    label91:
    for (str = String.format("%s %s", new Object[] { String.format(ak.getContext().getString(2131755348), new Object[] { paramList.name }), ak.getContext().getString(2131755345) });; str = String.format("%s %s", new Object[] { String.format(ak.getContext().getString(2131755347), new Object[] { Integer.valueOf(paramList.size()) }), ak.getContext().getString(2131755345) }))
    {
      AppMethodBeat.o(222204);
      return str;
    }
  }
  
  public static String bd(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(44789);
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((AppBrandBackgroundRunningApp)paramList.next()).beO | i) {}
    Object localObject = null;
    c[] arrayOfc = values();
    int k = arrayOfc.length;
    int j = 0;
    if (j < k)
    {
      c localc = arrayOfc[j];
      paramList = (List<AppBrandBackgroundRunningApp>)localObject;
      if (localc.beO != jVx.beO)
      {
        paramList = (List<AppBrandBackgroundRunningApp>)localObject;
        if (localc.beO != jVu.beO)
        {
          paramList = (List<AppBrandBackgroundRunningApp>)localObject;
          if (localc.beO != jVw.beO)
          {
            paramList = (List<AppBrandBackgroundRunningApp>)localObject;
            if (contains(i, localc.beO)) {
              if (!bu.isNullOrNil((String)localObject)) {
                break label162;
              }
            }
          }
        }
      }
      label162:
      for (paramList = ak.getContext().getString(localc.jVy);; paramList = String.format("%s、%s", new Object[] { localObject, ak.getContext().getString(localc.jVy) }))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.c
 * JD-Core Version:    0.7.0.1
 */