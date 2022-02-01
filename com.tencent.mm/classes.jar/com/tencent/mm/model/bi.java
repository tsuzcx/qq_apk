package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.List;

public class bi
{
  private static bi hGx;
  public b hGw;
  
  private static List<Integer> Bg(String paramString)
  {
    AppMethodBeat.i(20383);
    ba.aBQ();
    SharedPreferences localSharedPreferences = c.wW("banner");
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
  
  public static bi aBW()
  {
    AppMethodBeat.i(20376);
    try
    {
      if (hGx == null) {
        hGx = new bi();
      }
      bi localbi = hGx;
      AppMethodBeat.o(20376);
      return localbi;
    }
    finally
    {
      AppMethodBeat.o(20376);
    }
  }
  
  public static bh aBX()
  {
    AppMethodBeat.i(20378);
    ba.aBQ();
    Object localObject = c.wW("banner");
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
            localObject = new bh(i, j, (String)localObject);
            AppMethodBeat.o(20378);
            return localObject;
            locala = aBZ();
          } while ((locala != a.hGA) && (locala != a.hGB) && (!g.aCR().aCP()));
          if (g.aCR().aCP()) {
            ad.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
          }
          for (;;)
          {
            AppMethodBeat.o(20378);
            return null;
            ad.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
          }
          ad.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
          AppMethodBeat.o(20378);
          return null;
        } while ((aBZ() != a.hGA) && (!g.aCR().aCP()));
        if (g.aCR().aCP()) {
          ad.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
        }
        for (;;)
        {
          AppMethodBeat.o(20378);
          return null;
          ad.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
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
  
  private static boolean aBY()
  {
    AppMethodBeat.i(20380);
    ba.aBQ();
    SharedPreferences localSharedPreferences = c.wW("banner");
    if ((localSharedPreferences != null) && (localSharedPreferences.edit().clear().commit()))
    {
      AppMethodBeat.o(20380);
      return true;
    }
    AppMethodBeat.o(20380);
    return false;
  }
  
  public static a aBZ()
  {
    AppMethodBeat.i(20384);
    for (;;)
    {
      try
      {
        ba.aBQ();
        localObject2 = (String)c.ajl().get(4097, "");
        ba.aBQ();
        String str = (String)c.ajl().get(6, "");
        boolean bool = u.aAV();
        ad.d("MicorMsg.MainFrameBannerStorage", "isUpload " + bool + " stat " + u.aAq());
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
              localObject1 = a.hGy;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = a.hGz;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            if (bool)
            {
              localObject1 = a.hGA;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            localObject1 = a.hGB;
            AppMethodBeat.o(20384);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = a.hGy;
        AppMethodBeat.o(20384);
        return locala;
      }
      a locala = null;
      continue;
      label197:
      Object localObject2 = null;
    }
  }
  
  private static boolean b(bh parambh)
  {
    AppMethodBeat.i(20381);
    boolean bool = Bg("HistoryInfo").contains(Integer.valueOf(parambh.type));
    AppMethodBeat.o(20381);
    return bool;
  }
  
  private static boolean c(String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(20382);
    ba.aBQ();
    Object localObject = c.wW("banner");
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
  
  public final boolean a(bh parambh)
  {
    boolean bool = true;
    AppMethodBeat.i(20377);
    if (parambh.type == 10000)
    {
      aBY();
      if (this.hGw != null) {
        this.hGw.onNotify();
      }
      AppMethodBeat.o(20377);
      return true;
    }
    if (parambh.type == 57005)
    {
      AppMethodBeat.o(20377);
      return false;
    }
    ba.aBQ();
    Object localObject = c.wW("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(20377);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    bh localbh = aBX();
    if (!b(parambh)) {}
    for (;;)
    {
      if ((localbh != null) && (localbh.dlp == 2))
      {
        List localList = Bg("HistoryInfo");
        if (!localList.contains(Integer.valueOf(localbh.type))) {
          localList.add(Integer.valueOf(localbh.type));
        }
        c("HistoryInfo", localList);
      }
      if (bool) {
        ((SharedPreferences.Editor)localObject).putInt("CurrentType", parambh.type).putInt("CurrentShowType", parambh.dlp).putString("CurrentData", parambh.data).commit();
      }
      if (this.hGw != null) {
        this.hGw.onNotify();
      }
      AppMethodBeat.o(20377);
      return bool;
      bool = false;
    }
  }
  
  public final void dd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20379);
    ba.aBQ();
    Object localObject = c.wW("banner");
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
      if (this.hGw != null) {
        this.hGw.onNotify();
      }
      AppMethodBeat.o(20379);
      return;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      continue;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      localObject = Bg("HistoryInfo");
      if (!((List)localObject).contains(Integer.valueOf(paramInt1))) {
        ((List)localObject).add(Integer.valueOf(paramInt1));
      }
      c("HistoryInfo", (List)localObject);
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
      hGy = new a("NO_INIT", 0);
      hGz = new a("SET_MOBILE", 1);
      hGA = new a("SUCC", 2);
      hGB = new a("SUCC_UNLOAD", 3);
      hGC = new a[] { hGy, hGz, hGA, hGB };
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
 * Qualified Name:     com.tencent.mm.model.bi
 * JD-Core Version:    0.7.0.1
 */