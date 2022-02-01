package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.List;

public class bo
{
  private static bo iDZ;
  public b iDY;
  
  private static List<Integer> Ko(String paramString)
  {
    AppMethodBeat.i(20383);
    bg.aVF();
    SharedPreferences localSharedPreferences = c.FQ("banner");
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
  
  public static bo aVL()
  {
    AppMethodBeat.i(20376);
    try
    {
      if (iDZ == null) {
        iDZ = new bo();
      }
      bo localbo = iDZ;
      AppMethodBeat.o(20376);
      return localbo;
    }
    finally
    {
      AppMethodBeat.o(20376);
    }
  }
  
  public static bn aVM()
  {
    AppMethodBeat.i(20378);
    bg.aVF();
    Object localObject = c.FQ("banner");
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
            localObject = new bn(i, j, (String)localObject);
            AppMethodBeat.o(20378);
            return localObject;
            locala = aVN();
          } while ((locala != a.iEc) && (locala != a.iEd) && (!g.aWT().aWR()));
          if (g.aWT().aWR()) {
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
        } while ((aVN() != a.iEc) && (!g.aWT().aWR()));
        if (g.aWT().aWR()) {
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
  
  public static a aVN()
  {
    AppMethodBeat.i(20384);
    for (;;)
    {
      try
      {
        bg.aVF();
        localObject2 = (String)c.azQ().get(4097, "");
        bg.aVF();
        String str = (String)c.azQ().get(6, "");
        boolean bool = z.aUI();
        Log.d("MicorMsg.MainFrameBannerStorage", "isUpload " + bool + " stat " + z.aUc());
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
              localObject1 = a.iEa;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = a.iEb;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            if (bool)
            {
              localObject1 = a.iEc;
              AppMethodBeat.o(20384);
              return localObject1;
            }
            localObject1 = a.iEd;
            AppMethodBeat.o(20384);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = a.iEa;
        AppMethodBeat.o(20384);
        return locala;
      }
      a locala = null;
      continue;
      label197:
      Object localObject2 = null;
    }
  }
  
  private static boolean b(bn parambn)
  {
    AppMethodBeat.i(20381);
    boolean bool = Ko("HistoryInfo").contains(Integer.valueOf(parambn.type));
    AppMethodBeat.o(20381);
    return bool;
  }
  
  private static boolean c(String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(20382);
    bg.aVF();
    Object localObject = c.FQ("banner");
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
  
  private static boolean clearAll()
  {
    AppMethodBeat.i(20380);
    bg.aVF();
    SharedPreferences localSharedPreferences = c.FQ("banner");
    if ((localSharedPreferences != null) && (localSharedPreferences.edit().clear().commit()))
    {
      AppMethodBeat.o(20380);
      return true;
    }
    AppMethodBeat.o(20380);
    return false;
  }
  
  public final boolean a(bn parambn)
  {
    boolean bool = true;
    AppMethodBeat.i(20377);
    if (parambn.type == 10000)
    {
      clearAll();
      if (this.iDY != null) {
        this.iDY.onNotify();
      }
      AppMethodBeat.o(20377);
      return true;
    }
    if (parambn.type == 57005)
    {
      AppMethodBeat.o(20377);
      return false;
    }
    bg.aVF();
    Object localObject = c.FQ("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(20377);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    bn localbn = aVM();
    if (!b(parambn)) {}
    for (;;)
    {
      if ((localbn != null) && (localbn.dDG == 2))
      {
        List localList = Ko("HistoryInfo");
        if (!localList.contains(Integer.valueOf(localbn.type))) {
          localList.add(Integer.valueOf(localbn.type));
        }
        c("HistoryInfo", localList);
      }
      if (bool) {
        ((SharedPreferences.Editor)localObject).putInt("CurrentType", parambn.type).putInt("CurrentShowType", parambn.dDG).putString("CurrentData", parambn.data).commit();
      }
      if (this.iDY != null) {
        this.iDY.onNotify();
      }
      AppMethodBeat.o(20377);
      return bool;
      bool = false;
    }
  }
  
  public final void dn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20379);
    bg.aVF();
    Object localObject = c.FQ("banner");
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
      if (this.iDY != null) {
        this.iDY.onNotify();
      }
      AppMethodBeat.o(20379);
      return;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      continue;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      localObject = Ko("HistoryInfo");
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
      iEa = new a("NO_INIT", 0);
      iEb = new a("SET_MOBILE", 1);
      iEc = new a("SUCC", 2);
      iEd = new a("SUCC_UNLOAD", 3);
      iEe = new a[] { iEa, iEb, iEc, iEd };
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
 * Qualified Name:     com.tencent.mm.model.bo
 * JD-Core Version:    0.7.0.1
 */