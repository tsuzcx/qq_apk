package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.HashSet;
import java.util.Set;

public final class d
{
  public static final String kdE;
  private static d kdG;
  private Set<String> kdF;
  private Object lock;
  
  static
  {
    AppMethodBeat.i(46668);
    kdE = b.ahY() + "files/wxofflinevoicenew/";
    AppMethodBeat.o(46668);
  }
  
  public d()
  {
    AppMethodBeat.i(46661);
    this.lock = new Object();
    AppMethodBeat.o(46661);
  }
  
  public static void IO(String paramString)
  {
    AppMethodBeat.i(46664);
    g.afB().afk().set(ae.a.Fvv, paramString);
    a.ESL.l(new oy());
    AppMethodBeat.o(46664);
  }
  
  public static String IP(String paramString)
  {
    AppMethodBeat.i(46665);
    paramString = ax.aFC("voice_offline_res_new").getString(paramString, "");
    AppMethodBeat.o(46665);
    return paramString;
  }
  
  public static String IQ(String paramString)
  {
    AppMethodBeat.i(195923);
    paramString = ax.aFC("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(195923);
    return paramString;
  }
  
  public static String bbu()
  {
    AppMethodBeat.i(46663);
    String str = (String)g.afB().afk().get(ae.a.Fvu, "");
    AppMethodBeat.o(46663);
    return str;
  }
  
  public static String bbv()
  {
    AppMethodBeat.i(46666);
    String str = (String)g.afB().afk().get(ae.a.Fvv, "0");
    AppMethodBeat.o(46666);
    return str;
  }
  
  public static d bbw()
  {
    AppMethodBeat.i(46667);
    if (kdG == null) {
      kdG = new d();
    }
    d locald = kdG;
    AppMethodBeat.o(46667);
    return locald;
  }
  
  public final boolean C(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(46662);
    synchronized (this.lock)
    {
      if (this.kdF == null)
      {
        this.kdF = new HashSet();
        Object localObject2 = (String)g.afB().afk().get(ae.a.Fvu, "");
        if (!bt.isNullOrNil((String)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            this.kdF.add(localObject3);
            i += 1;
          }
        }
      }
      ax.aFC("voice_offline_res_new").edit().putString(paramString1, paramString2).commit();
      ax.aFC("voice_offline_res_new").edit().putString(paramString1 + "_md5", paramString3).commit();
      if (!this.kdF.contains(paramString1))
      {
        paramString2 = new StringBuilder((String)g.afB().afk().get(ae.a.Fvu, ""));
        if (this.kdF.size() <= 0)
        {
          paramString2.append(paramString1);
          g.afB().afk().set(ae.a.Fvu, paramString2.toString());
          boolean bool = this.kdF.add(paramString1);
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