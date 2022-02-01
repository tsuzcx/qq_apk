package com.tencent.mm.plugin.expt.e;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
{
  private static b zNl;
  private String zNj = null;
  private String zNk = null;
  
  private int atq(String paramString)
  {
    AppMethodBeat.i(299512);
    try
    {
      int i = dNt().getInt(paramString, 0);
      AppMethodBeat.o(299512);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(299512);
    }
    return 0;
  }
  
  public static b dNr()
  {
    AppMethodBeat.i(299495);
    if (zNl == null) {
      zNl = new b();
    }
    b localb = zNl;
    AppMethodBeat.o(299495);
    return localb;
  }
  
  private MultiProcessMMKV dNs()
  {
    AppMethodBeat.i(299503);
    d.dNI();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(299503);
      return null;
    }
    Object localObject = i + "_WxExptAppIdMmkv";
    if (!Util.isEqual(this.zNj, (String)localObject))
    {
      Log.i("MicroMsg.ExptAppManager", "%s get exptId mmkv change uin old[%s] new[%s]", new Object[] { info(), this.zNj, localObject });
      this.zNj = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.zNj);
    AppMethodBeat.o(299503);
    return localObject;
  }
  
  private MultiProcessMMKV dNt()
  {
    AppMethodBeat.i(299508);
    d.dNI();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(299508);
      return null;
    }
    Object localObject = i + "_WxExptAppKeyMmkv";
    if (!Util.isEqual(this.zNk, (String)localObject))
    {
      Log.i("MicroMsg.ExptAppManager", "%s get exptKey mmkv change uin old[%s] new[%s]", new Object[] { info(), this.zNk, localObject });
      this.zNk = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.zNk);
    AppMethodBeat.o(299508);
    return localObject;
  }
  
  private String info()
  {
    AppMethodBeat.i(299516);
    String str = hashCode();
    AppMethodBeat.o(299516);
    return str;
  }
  
  public final a Mh(int paramInt)
  {
    AppMethodBeat.i(299545);
    Object localObject = dNs();
    if (localObject == null)
    {
      AppMethodBeat.o(299545);
      return null;
    }
    localObject = ((MultiProcessMMKV)localObject).getString(String.valueOf(paramInt), "");
    if (!Util.isNullOrNil((String)localObject))
    {
      a locala = new a();
      if (locala.TZ((String)localObject))
      {
        AppMethodBeat.o(299545);
        return locala;
      }
    }
    AppMethodBeat.o(299545);
    return null;
  }
  
  public final int a(String paramString1, String paramString2, PString paramPString)
  {
    AppMethodBeat.i(299549);
    int i = atq(paramString1);
    a locala;
    if (i > 0)
    {
      locala = Mh(i);
      if ((locala != null) && (locala.isReady()))
      {
        HashMap localHashMap = locala.dNo();
        if ((localHashMap != null) && (!localHashMap.isEmpty()))
        {
          paramPString.value = ((String)localHashMap.get(paramString1));
          if (Util.isNullOrNil(paramPString.value)) {}
        }
      }
    }
    for (i = locala.zNd;; i = 0)
    {
      if (i <= 0) {
        paramPString.value = paramString2;
      }
      AppMethodBeat.o(299549);
      return i;
    }
  }
  
  public final boolean dNu()
  {
    AppMethodBeat.i(299520);
    try
    {
      dNs().clear().commit();
      dNt().clear().commit();
      label31:
      AppMethodBeat.o(299520);
      return true;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public final List<a> dNv()
  {
    AppMethodBeat.i(299539);
    ArrayList localArrayList = new ArrayList();
    MultiProcessMMKV localMultiProcessMMKV = dNs();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299539);
      return localArrayList;
    }
    String[] arrayOfString = localMultiProcessMMKV.allKeys();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = localMultiProcessMMKV.getString(arrayOfString[i], "");
        if (!Util.isNullOrNil(str))
        {
          a locala = new a();
          if (locala.TZ(str)) {
            localArrayList.add(locala);
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(299539);
    return localArrayList;
  }
  
  public final int fv(List<a> paramList)
  {
    AppMethodBeat.i(299526);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(299526);
      return 0;
    }
    MultiProcessMMKV localMultiProcessMMKV1 = dNs();
    MultiProcessMMKV localMultiProcessMMKV2 = dNt();
    if ((localMultiProcessMMKV1 == null) || (localMultiProcessMMKV2 == null))
    {
      AppMethodBeat.o(299526);
      return 0;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if ((locala == null) || (Util.isNullOrNil(locala.zNf))) {
        break label205;
      }
      Object localObject = locala.dNo();
      if ((localObject == null) || (((HashMap)localObject).size() <= 0)) {
        break label205;
      }
      localObject = ((HashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localMultiProcessMMKV2.putInt((String)((Iterator)localObject).next(), locala.zNd);
      }
      localMultiProcessMMKV1.putString(locala.zNd, locala.zNf);
      i += 1;
    }
    label205:
    for (;;)
    {
      break;
      AppMethodBeat.o(299526);
      return i;
    }
  }
  
  public final int fw(List<Integer> paramList)
  {
    AppMethodBeat.i(299532);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(299532);
      return 0;
    }
    MultiProcessMMKV localMultiProcessMMKV = dNs();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299532);
      return 0;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      int j = ((Integer)paramList.next()).intValue();
      if (!localMultiProcessMMKV.contains(String.valueOf(j))) {
        break label110;
      }
      localMultiProcessMMKV.remove(String.valueOf(j));
      i += 1;
    }
    label110:
    for (;;)
    {
      break;
      AppMethodBeat.o(299532);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.b
 * JD-Core Version:    0.7.0.1
 */