package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public class bc
{
  private static bc dWh;
  public bc.b dWg;
  
  public static bc HI()
  {
    try
    {
      if (dWh == null) {
        dWh = new bc();
      }
      return dWh;
    }
    finally {}
  }
  
  public static bb HJ()
  {
    au.Hx();
    Object localObject = c.gh("banner");
    if (localObject == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = ((SharedPreferences)localObject).getInt("CurrentType", -1);
      j = ((SharedPreferences)localObject).getInt("CurrentShowType", -1);
      localObject = ((SharedPreferences)localObject).getString("CurrentData", "");
    } while (i == -1);
    switch (i)
    {
    }
    do
    {
      bc.a locala;
      do
      {
        return new bb(i, j, (String)localObject);
        locala = HK();
      } while ((locala != bc.a.dWk) && (locala != bc.a.dWl) && (!g.Iy().Iw()));
      if (g.Iy().Iw())
      {
        y.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
        return null;
      }
      y.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
      return null;
      y.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
      return null;
    } while ((HK() != bc.a.dWk) && (!g.Iy().Iw()));
    if (g.Iy().Iw())
    {
      y.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
      return null;
    }
    y.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
    return null;
  }
  
  public static bc.a HK()
  {
    for (;;)
    {
      try
      {
        au.Hx();
        localObject3 = (String)c.Dz().get(4097, "");
        au.Hx();
        String str = (String)c.Dz().get(6, "");
        boolean bool = q.GN();
        y.d("MicorMsg.MainFrameBannerStorage", "isUpload " + bool + " stat " + q.Gn());
        if (localObject3 != null)
        {
          Object localObject1 = localObject3;
          if (((String)localObject3).length() > 0)
          {
            if (str == null) {
              break label153;
            }
            localObject3 = str;
            if (str.length() <= 0) {
              break label153;
            }
            if ((localObject1 == null) && (localObject3 == null)) {
              return bc.a.dWi;
            }
            if ((localObject1 != null) && (localObject3 == null)) {
              return bc.a.dWj;
            }
            if (bool) {
              return bc.a.dWk;
            }
            localObject1 = bc.a.dWl;
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        return bc.a.dWi;
      }
      Object localObject2 = null;
      continue;
      label153:
      Object localObject3 = null;
    }
  }
  
  private static boolean f(String paramString, List<Integer> paramList)
  {
    au.Hx();
    Object localObject = c.gh("banner");
    if (localObject == null) {
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
    return ((SharedPreferences.Editor)localObject).commit();
  }
  
  private static List<Integer> iG(String paramString)
  {
    au.Hx();
    SharedPreferences localSharedPreferences = c.gh("banner");
    Object localObject;
    if (localSharedPreferences == null)
    {
      localObject = null;
      return localObject;
    }
    int j = localSharedPreferences.getInt(paramString + "ArraySize", 0);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(Integer.valueOf(localSharedPreferences.getInt(paramString + i, 0)));
      i += 1;
    }
  }
  
  public final boolean a(bb parambb)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambb.type == 10000)
    {
      au.Hx();
      parambb = c.gh("banner");
      if (parambb != null) {
        parambb.edit().clear().commit();
      }
      bool2 = bool1;
      if (this.dWg != null)
      {
        this.dWg.HL();
        bool2 = bool1;
      }
      return bool2;
    }
    if (parambb.type == 57005) {
      return false;
    }
    au.Hx();
    Object localObject = c.gh("banner");
    if (localObject == null) {
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    bb localbb = HJ();
    if (!iG("HistoryInfo").contains(Integer.valueOf(parambb.type))) {}
    for (bool1 = bool2;; bool1 = false)
    {
      if ((localbb != null) && (localbb.showType == 2))
      {
        List localList = iG("HistoryInfo");
        if (!localList.contains(Integer.valueOf(localbb.type))) {
          localList.add(Integer.valueOf(localbb.type));
        }
        f("HistoryInfo", localList);
      }
      if (bool1) {
        ((SharedPreferences.Editor)localObject).putInt("CurrentType", parambb.type).putInt("CurrentShowType", parambb.showType).putString("CurrentData", parambb.data).commit();
      }
      bool2 = bool1;
      if (this.dWg == null) {
        break;
      }
      this.dWg.HL();
      return bool1;
    }
  }
  
  public final void bi(int paramInt1, int paramInt2)
  {
    au.Hx();
    Object localObject = c.gh("banner");
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((SharedPreferences)localObject).edit();
      switch (paramInt2)
      {
      }
      while (this.dWg != null)
      {
        this.dWg.HL();
        return;
        ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
        continue;
        ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
        localObject = iG("HistoryInfo");
        if (!((List)localObject).contains(Integer.valueOf(paramInt1))) {
          ((List)localObject).add(Integer.valueOf(paramInt1));
        }
        f("HistoryInfo", (List)localObject);
        continue;
        if (paramInt1 == 3) {
          ((SharedPreferences.Editor)localObject).remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.bc
 * JD-Core Version:    0.7.0.1
 */