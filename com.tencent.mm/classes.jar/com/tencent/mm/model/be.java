package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public class be
{
  private static be fmr;
  public be.b fmq;
  
  public static be aaG()
  {
    AppMethodBeat.i(16330);
    try
    {
      if (fmr == null) {
        fmr = new be();
      }
      be localbe = fmr;
      AppMethodBeat.o(16330);
      return localbe;
    }
    finally
    {
      AppMethodBeat.o(16330);
    }
  }
  
  public static bd aaH()
  {
    AppMethodBeat.i(16332);
    aw.aaz();
    Object localObject = c.mC("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(16332);
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
          be.a locala;
          do
          {
            localObject = new bd(i, j, (String)localObject);
            AppMethodBeat.o(16332);
            return localObject;
            locala = aaJ();
          } while ((locala != be.a.fmu) && (locala != be.a.fmv) && (!g.abw().abu()));
          if (g.abw().abu()) {
            ab.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
          }
          for (;;)
          {
            AppMethodBeat.o(16332);
            return null;
            ab.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
          }
          ab.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
          AppMethodBeat.o(16332);
          return null;
        } while ((aaJ() != be.a.fmu) && (!g.abw().abu()));
        if (g.abw().abu()) {
          ab.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
        }
        for (;;)
        {
          AppMethodBeat.o(16332);
          return null;
          ab.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
        }
      case 10000: 
      case 57005: 
        AppMethodBeat.o(16332);
        return null;
      }
      AppMethodBeat.o(16332);
      return null;
    }
    AppMethodBeat.o(16332);
    return null;
  }
  
  private static boolean aaI()
  {
    AppMethodBeat.i(16334);
    aw.aaz();
    SharedPreferences localSharedPreferences = c.mC("banner");
    if ((localSharedPreferences != null) && (localSharedPreferences.edit().clear().commit()))
    {
      AppMethodBeat.o(16334);
      return true;
    }
    AppMethodBeat.o(16334);
    return false;
  }
  
  public static be.a aaJ()
  {
    AppMethodBeat.i(16338);
    for (;;)
    {
      try
      {
        aw.aaz();
        localObject2 = (String)c.Ru().get(4097, "");
        aw.aaz();
        String str = (String)c.Ru().get(6, "");
        boolean bool = r.ZR();
        ab.d("MicorMsg.MainFrameBannerStorage", "isUpload " + bool + " stat " + r.Zr());
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
              localObject1 = be.a.fms;
              AppMethodBeat.o(16338);
              return localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = be.a.fmt;
              AppMethodBeat.o(16338);
              return localObject1;
            }
            if (bool)
            {
              localObject1 = be.a.fmu;
              AppMethodBeat.o(16338);
              return localObject1;
            }
            localObject1 = be.a.fmv;
            AppMethodBeat.o(16338);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = be.a.fms;
        AppMethodBeat.o(16338);
        return locala;
      }
      be.a locala = null;
      continue;
      label197:
      Object localObject2 = null;
    }
  }
  
  private static boolean b(bd parambd)
  {
    AppMethodBeat.i(16335);
    boolean bool = pp("HistoryInfo").contains(Integer.valueOf(parambd.type));
    AppMethodBeat.o(16335);
    return bool;
  }
  
  private static boolean g(String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(16336);
    aw.aaz();
    Object localObject = c.mC("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(16336);
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
    AppMethodBeat.o(16336);
    return bool;
  }
  
  private static List<Integer> pp(String paramString)
  {
    AppMethodBeat.i(16337);
    aw.aaz();
    SharedPreferences localSharedPreferences = c.mC("banner");
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(16337);
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
    AppMethodBeat.o(16337);
    return localArrayList;
  }
  
  public final boolean a(bd parambd)
  {
    boolean bool = true;
    AppMethodBeat.i(16331);
    if (parambd.type == 10000)
    {
      aaI();
      if (this.fmq != null) {
        this.fmq.aaK();
      }
      AppMethodBeat.o(16331);
      return true;
    }
    if (parambd.type == 57005)
    {
      AppMethodBeat.o(16331);
      return false;
    }
    aw.aaz();
    Object localObject = c.mC("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(16331);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    bd localbd = aaH();
    if (!b(parambd)) {}
    for (;;)
    {
      if ((localbd != null) && (localbd.showType == 2))
      {
        List localList = pp("HistoryInfo");
        if (!localList.contains(Integer.valueOf(localbd.type))) {
          localList.add(Integer.valueOf(localbd.type));
        }
        g("HistoryInfo", localList);
      }
      if (bool) {
        ((SharedPreferences.Editor)localObject).putInt("CurrentType", parambd.type).putInt("CurrentShowType", parambd.showType).putString("CurrentData", parambd.data).commit();
      }
      if (this.fmq != null) {
        this.fmq.aaK();
      }
      AppMethodBeat.o(16331);
      return bool;
      bool = false;
    }
  }
  
  public final void cs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16333);
    aw.aaz();
    Object localObject = c.mC("banner");
    if (localObject == null)
    {
      AppMethodBeat.o(16333);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.fmq != null) {
        this.fmq.aaK();
      }
      AppMethodBeat.o(16333);
      return;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      continue;
      ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      localObject = pp("HistoryInfo");
      if (!((List)localObject).contains(Integer.valueOf(paramInt1))) {
        ((List)localObject).add(Integer.valueOf(paramInt1));
      }
      g("HistoryInfo", (List)localObject);
      continue;
      if (paramInt1 == 3) {
        ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.be
 * JD-Core Version:    0.7.0.1
 */