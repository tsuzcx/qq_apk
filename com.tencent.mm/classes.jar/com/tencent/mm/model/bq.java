package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.List;

public class bq
{
  private static bq olz;
  public b oly;
  
  private static List<Integer> JF(String paramString)
  {
    AppMethodBeat.i(20383);
    bh.bCz();
    SharedPreferences localSharedPreferences = c.Fz("banner");
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
  
  private static boolean b(bp parambp)
  {
    AppMethodBeat.i(20381);
    boolean bool = JF("HistoryInfo").contains(Integer.valueOf(parambp.type));
    AppMethodBeat.o(20381);
    return bool;
  }
  
  public static bq bCF()
  {
    AppMethodBeat.i(20376);
    try
    {
      if (olz == null) {
        olz = new bq();
      }
      bq localbq = olz;
      AppMethodBeat.o(20376);
      return localbq;
    }
    finally
    {
      AppMethodBeat.o(20376);
    }
  }
  
  public static bp bCG()
  {
    AppMethodBeat.i(20378);
    bh.bCz();
    Object localObject = c.Fz("banner");
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
            localObject = new bp(i, j, (String)localObject);
            AppMethodBeat.o(20378);
            return localObject;
            locala = bCH();
          } while ((locala != a.olC) && (locala != a.olD) && (!g.bDR().bDP()));
          if (g.bDR().bDP()) {
            Log.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
          }
          for (;;)
          {
            AppMethodBeat.o(20378);
            return null;
            Log.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
          }
          Log.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
          AppMethodBeat.o(20378);
          return null;
        } while ((bCH() != a.olC) && (!g.bDR().bDP()));
        if (g.bDR().bDP()) {
          Log.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
        }
        for (;;)
        {
          AppMethodBeat.o(20378);
          return null;
          Log.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
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
  
  public static a bCH()
  {
    AppMethodBeat.i(20384);
    for (;;)
    {
      try
      {
        bh.bCz();
        localObject2 = (String)c.ban().d(4097, "");
        bh.bCz();
        String str = (String)c.ban().d(6, "");
        boolean bool = z.bBC();
        Log.d("MicorMsg.MainFrameBannerStorage", "isUpload " + bool + " stat " + z.bAQ());
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
              localObject1 = a.olA;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = a.olB;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            if (bool)
            {
              localObject1 = a.olC;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            localObject1 = a.olD;
            AppMethodBeat.o(20384);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = a.olA;
        AppMethodBeat.o(20384);
        return locala;
      }
      a locala = null;
      continue;
      label197:
      Object localObject2 = null;
    }
  }
  
  private static boolean clearAll()
  {
    AppMethodBeat.i(20380);
    bh.bCz();
    SharedPreferences localSharedPreferences = c.Fz("banner");
    if ((localSharedPreferences != null) && (localSharedPreferences.edit().clear().commit()))
    {
      AppMethodBeat.o(20380);
      return true;
    }
    AppMethodBeat.o(20380);
    return false;
  }
  
  private static boolean e(String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(20382);
    bh.bCz();
    Object localObject = c.Fz("banner");
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
  
  public final boolean a(bp parambp)
  {
    boolean bool = true;
    AppMethodBeat.i(20377);
    if (parambp.type == 10000)
    {
      clearAll();
      if (this.oly != null) {
        this.oly.onNotify();
      }
      AppMethodBeat.o(20377);
      return true;
    }
    if (parambp.type == 57005)
    {
      AppMethodBeat.o(20377);
      return false;
    }
    bh.bCz();
    Object localObject = c.Fz("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(20377);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    bp localbp = bCG();
    if (!b(parambp)) {}
    for (;;)
    {
      if ((localbp != null) && (localbp.hAN == 2))
      {
        List localList = JF("HistoryInfo");
        if (!localList.contains(Integer.valueOf(localbp.type))) {
          localList.add(Integer.valueOf(localbp.type));
        }
        e("HistoryInfo", localList);
      }
      if (bool) {
        ((SharedPreferences.Editor)localObject).putInt("CurrentType", parambp.type).putInt("CurrentShowType", parambp.hAN).putString("CurrentData", parambp.data).commit();
      }
      if (this.oly != null) {
        this.oly.onNotify();
      }
      AppMethodBeat.o(20377);
      return bool;
      bool = false;
    }
  }
  
  public final void eD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20379);
    bh.bCz();
    Object localObject = c.Fz("banner");
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
      if (this.oly != null) {
        this.oly.onNotify();
      }
      AppMethodBeat.o(20379);
      return;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      continue;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      localObject = JF("HistoryInfo");
      if (!((List)localObject).contains(Integer.valueOf(paramInt1))) {
        ((List)localObject).add(Integer.valueOf(paramInt1));
      }
      e("HistoryInfo", (List)localObject);
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
      olA = new a("NO_INIT", 0);
      olB = new a("SET_MOBILE", 1);
      olC = new a("SUCC", 2);
      olD = new a("SUCC_UNLOAD", 3);
      olE = new a[] { olA, olB, olC, olD };
      AppMethodBeat.o(20375);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onNotify();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bq
 * JD-Core Version:    0.7.0.1
 */