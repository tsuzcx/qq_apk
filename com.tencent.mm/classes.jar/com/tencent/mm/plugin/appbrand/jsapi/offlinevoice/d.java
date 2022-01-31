package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Set;

public final class d
{
  public static final String hVk;
  private static d hVm;
  private Set<String> hVl;
  private Object lock;
  
  static
  {
    AppMethodBeat.i(131382);
    hVk = com.tencent.mm.compatible.util.e.eQu + "files/wxofflinevoice/";
    AppMethodBeat.o(131382);
  }
  
  public d()
  {
    AppMethodBeat.i(131375);
    this.lock = new Object();
    AppMethodBeat.o(131375);
  }
  
  public static void CI(String paramString)
  {
    AppMethodBeat.i(131378);
    g.RL().Ru().set(ac.a.yLU, paramString);
    a.ymk.l(new nl());
    AppMethodBeat.o(131378);
  }
  
  public static String CJ(String paramString)
  {
    AppMethodBeat.i(131379);
    paramString = as.apq("voice_offline_res").getString(paramString, "");
    AppMethodBeat.o(131379);
    return paramString;
  }
  
  public static String aEn()
  {
    AppMethodBeat.i(131377);
    String str = (String)g.RL().Ru().get(ac.a.yLT, "");
    AppMethodBeat.o(131377);
    return str;
  }
  
  public static String aEo()
  {
    AppMethodBeat.i(131380);
    String str = (String)g.RL().Ru().get(ac.a.yLU, "0");
    AppMethodBeat.o(131380);
    return str;
  }
  
  public static d aEp()
  {
    AppMethodBeat.i(131381);
    if (hVm == null) {
      hVm = new d();
    }
    d locald = hVm;
    AppMethodBeat.o(131381);
    return locald;
  }
  
  public final boolean D(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(154329);
    synchronized (this.lock)
    {
      if (this.hVl == null)
      {
        this.hVl = new HashSet();
        Object localObject2 = (String)g.RL().Ru().get(ac.a.yLT, "");
        if (!bo.isNullOrNil((String)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            this.hVl.add(localObject3);
            i += 1;
          }
        }
      }
      as.apq("voice_offline_res").edit().putString(paramString1, paramString2).commit();
      as.apq("voice_offline_res").edit().putString(paramString1 + "_md5", paramString3).commit();
      if (!this.hVl.contains(paramString1))
      {
        paramString2 = new StringBuilder((String)g.RL().Ru().get(ac.a.yLT, ""));
        if (this.hVl.size() <= 0)
        {
          paramString2.append(paramString1);
          g.RL().Ru().set(ac.a.yLT, paramString2.toString());
          boolean bool = this.hVl.add(paramString1);
          AppMethodBeat.o(154329);
          return bool;
        }
        paramString2.append(",").append(paramString1);
      }
    }
    AppMethodBeat.o(154329);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.d
 * JD-Core Version:    0.7.0.1
 */