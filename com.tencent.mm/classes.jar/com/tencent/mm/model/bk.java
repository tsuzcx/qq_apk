package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.List;

public class bk
{
  private static bk hJp;
  public b hJo;
  
  private static List<Integer> BI(String paramString)
  {
    AppMethodBeat.i(20383);
    bc.aCg();
    SharedPreferences localSharedPreferences = c.xF("banner");
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
  
  public static bk aCm()
  {
    AppMethodBeat.i(20376);
    try
    {
      if (hJp == null) {
        hJp = new bk();
      }
      bk localbk = hJp;
      AppMethodBeat.o(20376);
      return localbk;
    }
    finally
    {
      AppMethodBeat.o(20376);
    }
  }
  
  public static bj aCn()
  {
    AppMethodBeat.i(20378);
    bc.aCg();
    Object localObject = c.xF("banner");
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
            localObject = new bj(i, j, (String)localObject);
            AppMethodBeat.o(20378);
            return localObject;
            locala = aCp();
          } while ((locala != a.hJs) && (locala != a.hJt) && (!g.aDh().aDf()));
          if (g.aDh().aDf()) {
            ae.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
          }
          for (;;)
          {
            AppMethodBeat.o(20378);
            return null;
            ae.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
          }
          ae.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
          AppMethodBeat.o(20378);
          return null;
        } while ((aCp() != a.hJs) && (!g.aDh().aDf()));
        if (g.aDh().aDf()) {
          ae.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
        }
        for (;;)
        {
          AppMethodBeat.o(20378);
          return null;
          ae.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
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
  
  private static boolean aCo()
  {
    AppMethodBeat.i(20380);
    bc.aCg();
    SharedPreferences localSharedPreferences = c.xF("banner");
    if ((localSharedPreferences != null) && (localSharedPreferences.edit().clear().commit()))
    {
      AppMethodBeat.o(20380);
      return true;
    }
    AppMethodBeat.o(20380);
    return false;
  }
  
  public static a aCp()
  {
    AppMethodBeat.i(20384);
    for (;;)
    {
      try
      {
        bc.aCg();
        localObject2 = (String)c.ajA().get(4097, "");
        bc.aCg();
        String str = (String)c.ajA().get(6, "");
        boolean bool = v.aBl();
        ae.d("MicorMsg.MainFrameBannerStorage", "isUpload " + bool + " stat " + v.aAG());
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
              localObject1 = a.hJq;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = a.hJr;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            if (bool)
            {
              localObject1 = a.hJs;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            localObject1 = a.hJt;
            AppMethodBeat.o(20384);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = a.hJq;
        AppMethodBeat.o(20384);
        return locala;
      }
      a locala = null;
      continue;
      label197:
      Object localObject2 = null;
    }
  }
  
  private static boolean b(bj parambj)
  {
    AppMethodBeat.i(20381);
    boolean bool = BI("HistoryInfo").contains(Integer.valueOf(parambj.type));
    AppMethodBeat.o(20381);
    return bool;
  }
  
  private static boolean c(String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(20382);
    bc.aCg();
    Object localObject = c.xF("banner");
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
  
  public final boolean a(bj parambj)
  {
    boolean bool = true;
    AppMethodBeat.i(20377);
    if (parambj.type == 10000)
    {
      aCo();
      if (this.hJo != null) {
        this.hJo.onNotify();
      }
      AppMethodBeat.o(20377);
      return true;
    }
    if (parambj.type == 57005)
    {
      AppMethodBeat.o(20377);
      return false;
    }
    bc.aCg();
    Object localObject = c.xF("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(20377);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    bj localbj = aCn();
    if (!b(parambj)) {}
    for (;;)
    {
      if ((localbj != null) && (localbj.dmr == 2))
      {
        List localList = BI("HistoryInfo");
        if (!localList.contains(Integer.valueOf(localbj.type))) {
          localList.add(Integer.valueOf(localbj.type));
        }
        c("HistoryInfo", localList);
      }
      if (bool) {
        ((SharedPreferences.Editor)localObject).putInt("CurrentType", parambj.type).putInt("CurrentShowType", parambj.dmr).putString("CurrentData", parambj.data).commit();
      }
      if (this.hJo != null) {
        this.hJo.onNotify();
      }
      AppMethodBeat.o(20377);
      return bool;
      bool = false;
    }
  }
  
  public final void dd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20379);
    bc.aCg();
    Object localObject = c.xF("banner");
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
      if (this.hJo != null) {
        this.hJo.onNotify();
      }
      AppMethodBeat.o(20379);
      return;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      continue;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      localObject = BI("HistoryInfo");
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
      hJq = new a("NO_INIT", 0);
      hJr = new a("SET_MOBILE", 1);
      hJs = new a("SUCC", 2);
      hJt = new a("SUCC_UNLOAD", 3);
      hJu = new a[] { hJq, hJr, hJs, hJt };
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
 * Qualified Name:     com.tencent.mm.model.bk
 * JD-Core Version:    0.7.0.1
 */