package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import java.util.ArrayList;
import java.util.List;

public class bh
{
  private static bh hof;
  public b hoe;
  
  public static bh ayS()
  {
    AppMethodBeat.i(20376);
    try
    {
      if (hof == null) {
        hof = new bh();
      }
      bh localbh = hof;
      AppMethodBeat.o(20376);
      return localbh;
    }
    finally
    {
      AppMethodBeat.o(20376);
    }
  }
  
  public static bg ayT()
  {
    AppMethodBeat.i(20378);
    az.ayM();
    Object localObject = c.ug("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(20378);
      return null;
    }
    int i = ((SharedPreferences)localObject).getInt("CurrentType", -1);
    int j = ((SharedPreferences)localObject).getInt("CurrentShowType", -1);
    localObject = ((SharedPreferences)localObject).getString("CurrentData", "");
    if (i != -1)
    {
      switch (i)
      {
      case 4: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      default: 
      case 1: 
      case 3: 
      case 2: 
        do
        {
          a locala;
          do
          {
            localObject = new bg(i, j, (String)localObject);
            AppMethodBeat.o(20378);
            return localObject;
            locala = ayV();
          } while ((locala != a.hoi) && (locala != a.hoj) && (!g.azO().azM()));
          if (g.azO().azM()) {
            ac.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
          }
          for (;;)
          {
            AppMethodBeat.o(20378);
            return null;
            ac.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
          }
          ac.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
          AppMethodBeat.o(20378);
          return null;
        } while ((ayV() != a.hoi) && (!g.azO().azM()));
        if (g.azO().azM()) {
          ac.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
        }
        for (;;)
        {
          AppMethodBeat.o(20378);
          return null;
          ac.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
        }
      case 10000: 
      case 57005: 
        AppMethodBeat.o(20378);
        return null;
      }
      AppMethodBeat.o(20378);
      return null;
    }
    AppMethodBeat.o(20378);
    return null;
  }
  
  private static boolean ayU()
  {
    AppMethodBeat.i(20380);
    az.ayM();
    SharedPreferences localSharedPreferences = c.ug("banner");
    if ((localSharedPreferences != null) && (localSharedPreferences.edit().clear().commit()))
    {
      AppMethodBeat.o(20380);
      return true;
    }
    AppMethodBeat.o(20380);
    return false;
  }
  
  public static a ayV()
  {
    AppMethodBeat.i(20384);
    for (;;)
    {
      try
      {
        az.ayM();
        localObject2 = (String)c.agA().get(4097, "");
        az.ayM();
        String str = (String)c.agA().get(6, "");
        boolean bool = u.ayb();
        ac.d("MicorMsg.MainFrameBannerStorage", "isUpload " + bool + " stat " + u.axA());
        if (localObject2 != null)
        {
          Object localObject1 = localObject2;
          if (((String)localObject2).length() > 0)
          {
            if (str == null) {
              break label197;
            }
            localObject2 = str;
            if (str.length() <= 0) {
              break label197;
            }
            if ((localObject1 == null) && (localObject2 == null))
            {
              localObject1 = a.hog;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = a.hoh;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            if (bool)
            {
              localObject1 = a.hoi;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            localObject1 = a.hoj;
            AppMethodBeat.o(20384);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = a.hog;
        AppMethodBeat.o(20384);
        return locala;
      }
      a locala = null;
      continue;
      label197:
      Object localObject2 = null;
    }
  }
  
  private static boolean b(bg parambg)
  {
    AppMethodBeat.i(20381);
    boolean bool = yh("HistoryInfo").contains(Integer.valueOf(parambg.type));
    AppMethodBeat.o(20381);
    return bool;
  }
  
  private static boolean d(String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(20382);
    az.ayM();
    Object localObject = c.ug("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(20382);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString + "ArraySize", paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      ((SharedPreferences.Editor)localObject).putInt(paramString + i, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    AppMethodBeat.o(20382);
    return bool;
  }
  
  private static List<Integer> yh(String paramString)
  {
    AppMethodBeat.i(20383);
    az.ayM();
    SharedPreferences localSharedPreferences = c.ug("banner");
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(20383);
      return null;
    }
    int j = localSharedPreferences.getInt(paramString + "ArraySize", 0);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Integer.valueOf(localSharedPreferences.getInt(paramString + i, 0)));
      i += 1;
    }
    AppMethodBeat.o(20383);
    return localArrayList;
  }
  
  public final boolean a(bg parambg)
  {
    boolean bool = true;
    AppMethodBeat.i(20377);
    if (parambg.type == 10000)
    {
      ayU();
      if (this.hoe != null) {
        this.hoe.onNotify();
      }
      AppMethodBeat.o(20377);
      return true;
    }
    if (parambg.type == 57005)
    {
      AppMethodBeat.o(20377);
      return false;
    }
    az.ayM();
    Object localObject = c.ug("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(20377);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    bg localbg = ayT();
    if (!b(parambg)) {}
    for (;;)
    {
      if ((localbg != null) && (localbg.cZX == 2))
      {
        List localList = yh("HistoryInfo");
        if (!localList.contains(Integer.valueOf(localbg.type))) {
          localList.add(Integer.valueOf(localbg.type));
        }
        d("HistoryInfo", localList);
      }
      if (bool) {
        ((SharedPreferences.Editor)localObject).putInt("CurrentType", parambg.type).putInt("CurrentShowType", parambg.cZX).putString("CurrentData", parambg.data).commit();
      }
      if (this.hoe != null) {
        this.hoe.onNotify();
      }
      AppMethodBeat.o(20377);
      return bool;
      bool = false;
    }
  }
  
  public final void db(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20379);
    az.ayM();
    Object localObject = c.ug("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(20379);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.hoe != null) {
        this.hoe.onNotify();
      }
      AppMethodBeat.o(20379);
      return;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      continue;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      localObject = yh("HistoryInfo");
      if (!((List)localObject).contains(Integer.valueOf(paramInt1))) {
        ((List)localObject).add(Integer.valueOf(paramInt1));
      }
      d("HistoryInfo", (List)localObject);
      continue;
      if (paramInt1 == 3) {
        ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      }
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(20375);
      hog = new a("NO_INIT", 0);
      hoh = new a("SET_MOBILE", 1);
      hoi = new a("SUCC", 2);
      hoj = new a("SUCC_UNLOAD", 3);
      hok = new a[] { hog, hoh, hoi, hoj };
      AppMethodBeat.o(20375);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onNotify();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bh
 * JD-Core Version:    0.7.0.1
 */