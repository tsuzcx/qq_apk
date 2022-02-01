package com.tencent.mm.plugin.expt.h;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class b
{
  private static b rbF;
  private String rbD = null;
  private String rbE = null;
  
  private int afC(String paramString)
  {
    AppMethodBeat.i(195162);
    try
    {
      int i = crB().getInt(paramString, 0);
      AppMethodBeat.o(195162);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(195162);
    }
    return 0;
  }
  
  public static b crz()
  {
    AppMethodBeat.i(195155);
    if (rbF == null) {
      rbF = new b();
    }
    b localb = rbF;
    AppMethodBeat.o(195155);
    return localb;
  }
  
  private String info()
  {
    AppMethodBeat.i(195163);
    String str = hashCode();
    AppMethodBeat.o(195163);
    return str;
  }
  
  public final a DA(int paramInt)
  {
    AppMethodBeat.i(195160);
    Object localObject = crA();
    if (localObject == null)
    {
      AppMethodBeat.o(195160);
      return null;
    }
    localObject = ((ax)localObject).getString(String.valueOf(paramInt), "");
    if (!bt.isNullOrNil((String)localObject))
    {
      a locala = new a();
      if (locala.afB((String)localObject))
      {
        AppMethodBeat.o(195160);
        return locala;
      }
    }
    AppMethodBeat.o(195160);
    return null;
  }
  
  public final int a(String paramString1, String paramString2, PString paramPString)
  {
    AppMethodBeat.i(195161);
    int i = afC(paramString1);
    a locala;
    if (i > 0)
    {
      locala = DA(i);
      if ((locala != null) && (locala.isReady()))
      {
        HashMap localHashMap = locala.cry();
        if ((localHashMap != null) && (!localHashMap.isEmpty()))
        {
          paramPString.value = ((String)localHashMap.get(paramString1));
          if (bt.isNullOrNil(paramPString.value)) {}
        }
      }
    }
    for (i = locala.rbx;; i = 0)
    {
      if (i <= 0) {
        paramPString.value = paramString2;
      }
      AppMethodBeat.o(195161);
      return i;
    }
  }
  
  public final ax crA()
  {
    AppMethodBeat.i(195156);
    d.crP();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(195156);
      return null;
    }
    Object localObject = i + "_WxExptAppIdMmkv";
    if (!bt.lQ(this.rbD, (String)localObject))
    {
      ad.i("MicroMsg.ExptAppManager", "%s get exptId mmkv change uin old[%s] new[%s]", new Object[] { info(), this.rbD, localObject });
      this.rbD = ((String)localObject);
    }
    localObject = ax.aQz(this.rbD);
    AppMethodBeat.o(195156);
    return localObject;
  }
  
  public final ax crB()
  {
    AppMethodBeat.i(195157);
    d.crP();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(195157);
      return null;
    }
    Object localObject = i + "_WxExptAppKeyMmkv";
    if (!bt.lQ(this.rbE, (String)localObject))
    {
      ad.i("MicroMsg.ExptAppManager", "%s get exptKey mmkv change uin old[%s] new[%s]", new Object[] { info(), this.rbE, localObject });
      this.rbE = ((String)localObject);
    }
    localObject = ax.aQz(this.rbE);
    AppMethodBeat.o(195157);
    return localObject;
  }
  
  public final List<a> crC()
  {
    AppMethodBeat.i(195159);
    ArrayList localArrayList = new ArrayList();
    ax localax = crA();
    if (localax == null)
    {
      AppMethodBeat.o(195159);
      return localArrayList;
    }
    String[] arrayOfString = localax.allKeys();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = localax.getString(arrayOfString[i], "");
        if (!bt.isNullOrNil(str))
        {
          a locala = new a();
          if (locala.afB(str)) {
            localArrayList.add(locala);
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(195159);
    return localArrayList;
  }
  
  public final boolean removeAll()
  {
    AppMethodBeat.i(195158);
    try
    {
      crA().clear().commit();
      crB().clear().commit();
      label31:
      AppMethodBeat.o(195158);
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