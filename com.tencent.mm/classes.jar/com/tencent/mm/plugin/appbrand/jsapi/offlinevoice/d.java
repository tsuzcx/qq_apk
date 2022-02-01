package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.HashSet;
import java.util.Set;

public final class d
{
  public static final String kEr;
  private static d kEt;
  private Set<String> kEs;
  private Object lock;
  
  static
  {
    AppMethodBeat.i(46668);
    kEr = b.aoY() + "files/wxofflinevoicenew/";
    AppMethodBeat.o(46668);
  }
  
  public d()
  {
    AppMethodBeat.i(46661);
    this.lock = new Object();
    AppMethodBeat.o(46661);
  }
  
  public static void MP(String paramString)
  {
    AppMethodBeat.i(46664);
    g.agR().agA().set(ah.a.GTp, paramString);
    a.GpY.l(new ph());
    AppMethodBeat.o(46664);
  }
  
  public static String MQ(String paramString)
  {
    AppMethodBeat.i(46665);
    paramString = aw.aKT("voice_offline_res_new").getString(paramString, "");
    AppMethodBeat.o(46665);
    return paramString;
  }
  
  public static String MR(String paramString)
  {
    AppMethodBeat.i(186713);
    paramString = aw.aKT("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(186713);
    return paramString;
  }
  
  public static String bim()
  {
    AppMethodBeat.i(46663);
    String str = (String)g.agR().agA().get(ah.a.GTo, "");
    AppMethodBeat.o(46663);
    return str;
  }
  
  public static String bin()
  {
    AppMethodBeat.i(46666);
    String str = (String)g.agR().agA().get(ah.a.GTp, "0");
    AppMethodBeat.o(46666);
    return str;
  }
  
  public static d bio()
  {
    AppMethodBeat.i(46667);
    if (kEt == null) {
      kEt = new d();
    }
    d locald = kEt;
    AppMethodBeat.o(46667);
    return locald;
  }
  
  public final boolean C(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(46662);
    synchronized (this.lock)
    {
      if (this.kEs == null)
      {
        this.kEs = new HashSet();
        Object localObject2 = (String)g.agR().agA().get(ah.a.GTo, "");
        if (!bs.isNullOrNil((String)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            this.kEs.add(localObject3);
            i += 1;
          }
        }
      }
      aw.aKT("voice_offline_res_new").edit().putString(paramString1, paramString2).commit();
      aw.aKT("voice_offline_res_new").edit().putString(paramString1 + "_md5", paramString3).commit();
      if (!this.kEs.contains(paramString1))
      {
        paramString2 = new StringBuilder((String)g.agR().agA().get(ah.a.GTo, ""));
        if (this.kEs.size() <= 0)
        {
          paramString2.append(paramString1);
          g.agR().agA().set(ah.a.GTo, paramString2.toString());
          boolean bool = this.kEs.add(paramString1);
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