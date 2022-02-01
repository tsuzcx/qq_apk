package com.tencent.mm.plugin.expt.h;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class b
{
  private static b sLn;
  private String sLl = null;
  private String sLm = null;
  
  private int ari(String paramString)
  {
    AppMethodBeat.i(215266);
    try
    {
      int i = cRK().getInt(paramString, 0);
      AppMethodBeat.o(215266);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(215266);
    }
    return 0;
  }
  
  public static b cRI()
  {
    AppMethodBeat.i(215259);
    if (sLn == null) {
      sLn = new b();
    }
    b localb = sLn;
    AppMethodBeat.o(215259);
    return localb;
  }
  
  private String info()
  {
    AppMethodBeat.i(215267);
    String str = hashCode();
    AppMethodBeat.o(215267);
    return str;
  }
  
  public final a HA(int paramInt)
  {
    AppMethodBeat.i(215264);
    Object localObject = cRJ();
    if (localObject == null)
    {
      AppMethodBeat.o(215264);
      return null;
    }
    localObject = ((MultiProcessMMKV)localObject).getString(String.valueOf(paramInt), "");
    if (!Util.isNullOrNil((String)localObject))
    {
      a locala = new a();
      if (locala.TN((String)localObject))
      {
        AppMethodBeat.o(215264);
        return locala;
      }
    }
    AppMethodBeat.o(215264);
    return null;
  }
  
  public final int a(String paramString1, String paramString2, PString paramPString)
  {
    AppMethodBeat.i(215265);
    int i = ari(paramString1);
    a locala;
    if (i > 0)
    {
      locala = HA(i);
      if ((locala != null) && (locala.isReady()))
      {
        HashMap localHashMap = locala.cRH();
        if ((localHashMap != null) && (!localHashMap.isEmpty()))
        {
          paramPString.value = ((String)localHashMap.get(paramString1));
          if (Util.isNullOrNil(paramPString.value)) {}
        }
      }
    }
    for (i = locala.sLf;; i = 0)
    {
      if (i <= 0) {
        paramPString.value = paramString2;
      }
      AppMethodBeat.o(215265);
      return i;
    }
  }
  
  public final MultiProcessMMKV cRJ()
  {
    AppMethodBeat.i(215260);
    d.cRY();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(215260);
      return null;
    }
    Object localObject = i + "_WxExptAppIdMmkv";
    if (!Util.isEqual(this.sLl, (String)localObject))
    {
      Log.i("MicroMsg.ExptAppManager", "%s get exptId mmkv change uin old[%s] new[%s]", new Object[] { info(), this.sLl, localObject });
      this.sLl = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.sLl);
    AppMethodBeat.o(215260);
    return localObject;
  }
  
  public MultiProcessMMKV cRK()
  {
    AppMethodBeat.i(215261);
    d.cRY();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(215261);
      return null;
    }
    Object localObject = i + "_WxExptAppKeyMmkv";
    if (!Util.isEqual(this.sLm, (String)localObject))
    {
      Log.i("MicroMsg.ExptAppManager", "%s get exptKey mmkv change uin old[%s] new[%s]", new Object[] { info(), this.sLm, localObject });
      this.sLm = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.sLm);
    AppMethodBeat.o(215261);
    return localObject;
  }
  
  public final List<a> cRL()
  {
    AppMethodBeat.i(215263);
    ArrayList localArrayList = new ArrayList();
    MultiProcessMMKV localMultiProcessMMKV = cRJ();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(215263);
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
          if (locala.TN(str)) {
            localArrayList.add(locala);
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(215263);
    return localArrayList;
  }
  
  public final boolean removeAll()
  {
    AppMethodBeat.i(215262);
    try
    {
      cRJ().clear().commit();
      cRK().clear().commit();
      label31:
      AppMethodBeat.o(215262);
      return true;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.h.b
 * JD-Core Version:    0.7.0.1
 */