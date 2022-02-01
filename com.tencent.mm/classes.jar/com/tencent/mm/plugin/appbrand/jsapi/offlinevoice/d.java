package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.HashSet;
import java.util.Set;

public final class d
{
  public static final String laB;
  private static d laD;
  private Set<String> laC;
  private Object lock;
  
  static
  {
    AppMethodBeat.i(46668);
    laB = b.arL() + "files/wxofflinevoicenew/";
    AppMethodBeat.o(46668);
  }
  
  public d()
  {
    AppMethodBeat.i(46661);
    this.lock = new Object();
    AppMethodBeat.o(46661);
  }
  
  public static void Qm(String paramString)
  {
    AppMethodBeat.i(46664);
    g.ajC().ajl().set(al.a.IFU, paramString);
    a.IbL.l(new pr());
    AppMethodBeat.o(46664);
  }
  
  public static String Qn(String paramString)
  {
    AppMethodBeat.i(46665);
    paramString = ax.aQz("voice_offline_res_new").getString(paramString, "");
    AppMethodBeat.o(46665);
    return paramString;
  }
  
  public static String Qo(String paramString)
  {
    AppMethodBeat.i(188457);
    paramString = ax.aQz("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(188457);
    return paramString;
  }
  
  public static String blX()
  {
    AppMethodBeat.i(46663);
    String str = (String)g.ajC().ajl().get(al.a.IFT, "");
    AppMethodBeat.o(46663);
    return str;
  }
  
  public static String blY()
  {
    AppMethodBeat.i(46666);
    String str = (String)g.ajC().ajl().get(al.a.IFU, "0");
    AppMethodBeat.o(46666);
    return str;
  }
  
  public static d blZ()
  {
    AppMethodBeat.i(46667);
    if (laD == null) {
      laD = new d();
    }
    d locald = laD;
    AppMethodBeat.o(46667);
    return locald;
  }
  
  public final boolean B(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(46662);
    synchronized (this.lock)
    {
      if (this.laC == null)
      {
        this.laC = new HashSet();
        Object localObject2 = (String)g.ajC().ajl().get(al.a.IFT, "");
        if (!bt.isNullOrNil((String)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            this.laC.add(localObject3);
            i += 1;
          }
        }
      }
      ax.aQz("voice_offline_res_new").edit().putString(paramString1, paramString2).commit();
      ax.aQz("voice_offline_res_new").edit().putString(paramString1 + "_md5", paramString3).commit();
      if (!this.laC.contains(paramString1))
      {
        paramString2 = new StringBuilder((String)g.ajC().ajl().get(al.a.IFT, ""));
        if (this.laC.size() <= 0)
        {
          paramString2.append(paramString1);
          g.ajC().ajl().set(al.a.IFT, paramString2.toString());
          boolean bool = this.laC.add(paramString1);
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