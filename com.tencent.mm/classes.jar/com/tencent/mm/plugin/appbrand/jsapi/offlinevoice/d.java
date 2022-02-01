package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.HashSet;
import java.util.Set;

public final class d
{
  public static final String lej;
  private static d lel;
  private Set<String> lek;
  private Object lock;
  
  static
  {
    AppMethodBeat.i(46668);
    lej = b.asa() + "files/wxofflinevoicenew/";
    AppMethodBeat.o(46668);
  }
  
  public d()
  {
    AppMethodBeat.i(46661);
    this.lock = new Object();
    AppMethodBeat.o(46661);
  }
  
  public static void QV(String paramString)
  {
    AppMethodBeat.i(46664);
    g.ajR().ajA().set(am.a.Jau, paramString);
    a.IvT.l(new ps());
    AppMethodBeat.o(46664);
  }
  
  public static String QW(String paramString)
  {
    AppMethodBeat.i(46665);
    paramString = ay.aRW("voice_offline_res_new").getString(paramString, "");
    AppMethodBeat.o(46665);
    return paramString;
  }
  
  public static String QX(String paramString)
  {
    AppMethodBeat.i(222607);
    paramString = ay.aRW("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(222607);
    return paramString;
  }
  
  public static String bmG()
  {
    AppMethodBeat.i(46663);
    String str = (String)g.ajR().ajA().get(am.a.Jat, "");
    AppMethodBeat.o(46663);
    return str;
  }
  
  public static String bmH()
  {
    AppMethodBeat.i(46666);
    String str = (String)g.ajR().ajA().get(am.a.Jau, "0");
    AppMethodBeat.o(46666);
    return str;
  }
  
  public static d bmI()
  {
    AppMethodBeat.i(46667);
    if (lel == null) {
      lel = new d();
    }
    d locald = lel;
    AppMethodBeat.o(46667);
    return locald;
  }
  
  public final boolean B(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(46662);
    synchronized (this.lock)
    {
      if (this.lek == null)
      {
        this.lek = new HashSet();
        Object localObject2 = (String)g.ajR().ajA().get(am.a.Jat, "");
        if (!bu.isNullOrNil((String)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            this.lek.add(localObject3);
            i += 1;
          }
        }
      }
      ay.aRW("voice_offline_res_new").edit().putString(paramString1, paramString2).commit();
      ay.aRW("voice_offline_res_new").edit().putString(paramString1 + "_md5", paramString3).commit();
      if (!this.lek.contains(paramString1))
      {
        paramString2 = new StringBuilder((String)g.ajR().ajA().get(am.a.Jat, ""));
        if (this.lek.size() <= 0)
        {
          paramString2.append(paramString1);
          g.ajR().ajA().set(am.a.Jat, paramString2.toString());
          boolean bool = this.lek.add(paramString1);
          AppMethodBeat.o(46662);
          return bool;
        }
        paramString2.append(",").append(paramString1);
      }
    }
    AppMethodBeat.o(46662);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.d
 * JD-Core Version:    0.7.0.1
 */