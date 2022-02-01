package com.tencent.mm.plugin.expt.h;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class b
{
  private static b rjL;
  private String rjJ = null;
  private String rjK = null;
  
  private int agy(String paramString)
  {
    AppMethodBeat.i(196724);
    try
    {
      int i = ctd().getInt(paramString, 0);
      AppMethodBeat.o(196724);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(196724);
    }
    return 0;
  }
  
  public static b ctb()
  {
    AppMethodBeat.i(196717);
    if (rjL == null) {
      rjL = new b();
    }
    b localb = rjL;
    AppMethodBeat.o(196717);
    return localb;
  }
  
  private String info()
  {
    AppMethodBeat.i(196725);
    String str = hashCode();
    AppMethodBeat.o(196725);
    return str;
  }
  
  public final a DN(int paramInt)
  {
    AppMethodBeat.i(196722);
    Object localObject = ctc();
    if (localObject == null)
    {
      AppMethodBeat.o(196722);
      return null;
    }
    localObject = ((ay)localObject).getString(String.valueOf(paramInt), "");
    if (!bu.isNullOrNil((String)localObject))
    {
      a locala = new a();
      if (locala.agx((String)localObject))
      {
        AppMethodBeat.o(196722);
        return locala;
      }
    }
    AppMethodBeat.o(196722);
    return null;
  }
  
  public final int a(String paramString1, String paramString2, PString paramPString)
  {
    AppMethodBeat.i(196723);
    int i = agy(paramString1);
    a locala;
    if (i > 0)
    {
      locala = DN(i);
      if ((locala != null) && (locala.isReady()))
      {
        HashMap localHashMap = locala.cta();
        if ((localHashMap != null) && (!localHashMap.isEmpty()))
        {
          paramPString.value = ((String)localHashMap.get(paramString1));
          if (bu.isNullOrNil(paramPString.value)) {}
        }
      }
    }
    for (i = locala.rjD;; i = 0)
    {
      if (i <= 0) {
        paramPString.value = paramString2;
      }
      AppMethodBeat.o(196723);
      return i;
    }
  }
  
  public final ay ctc()
  {
    AppMethodBeat.i(196718);
    d.ctr();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(196718);
      return null;
    }
    Object localObject = i + "_WxExptAppIdMmkv";
    if (!bu.lX(this.rjJ, (String)localObject))
    {
      ae.i("MicroMsg.ExptAppManager", "%s get exptId mmkv change uin old[%s] new[%s]", new Object[] { info(), this.rjJ, localObject });
      this.rjJ = ((String)localObject);
    }
    localObject = ay.aRW(this.rjJ);
    AppMethodBeat.o(196718);
    return localObject;
  }
  
  public final ay ctd()
  {
    AppMethodBeat.i(196719);
    d.ctr();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(196719);
      return null;
    }
    Object localObject = i + "_WxExptAppKeyMmkv";
    if (!bu.lX(this.rjK, (String)localObject))
    {
      ae.i("MicroMsg.ExptAppManager", "%s get exptKey mmkv change uin old[%s] new[%s]", new Object[] { info(), this.rjK, localObject });
      this.rjK = ((String)localObject);
    }
    localObject = ay.aRW(this.rjK);
    AppMethodBeat.o(196719);
    return localObject;
  }
  
  public final List<a> cte()
  {
    AppMethodBeat.i(196721);
    ArrayList localArrayList = new ArrayList();
    ay localay = ctc();
    if (localay == null)
    {
      AppMethodBeat.o(196721);
      return localArrayList;
    }
    String[] arrayOfString = localay.allKeys();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = localay.getString(arrayOfString[i], "");
        if (!bu.isNullOrNil(str))
        {
          a locala = new a();
          if (locala.agx(str)) {
            localArrayList.add(locala);
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(196721);
    return localArrayList;
  }
  
  public final boolean removeAll()
  {
    AppMethodBeat.i(196720);
    try
    {
      ctc().clear().commit();
      ctd().clear().commit();
      label31:
      AppMethodBeat.o(196720);
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