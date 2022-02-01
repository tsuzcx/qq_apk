package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashSet;
import java.util.Set;

public final class d
{
  public static final String phE;
  private static d phG;
  private Object lock;
  private Set<String> phF;
  
  static
  {
    AppMethodBeat.i(46668);
    phE = b.aSC() + "files/wxofflinevoicenew/";
    AppMethodBeat.o(46668);
  }
  
  public d()
  {
    AppMethodBeat.i(46661);
    this.lock = new Object();
    AppMethodBeat.o(46661);
  }
  
  public static void ain(String paramString)
  {
    AppMethodBeat.i(46664);
    h.aHG().aHp().set(ar.a.Vxq, paramString);
    EventCenter.instance.publish(new rk());
    AppMethodBeat.o(46664);
  }
  
  public static String aio(String paramString)
  {
    AppMethodBeat.i(46665);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString, "");
    AppMethodBeat.o(46665);
    return paramString;
  }
  
  public static String aip(String paramString)
  {
    AppMethodBeat.i(276008);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(276008);
    return paramString;
  }
  
  public static String aiq(String paramString)
  {
    AppMethodBeat.i(276009);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_version", "");
    AppMethodBeat.o(276009);
    return paramString;
  }
  
  public static String bTO()
  {
    AppMethodBeat.i(46663);
    String str = (String)h.aHG().aHp().get(ar.a.Vxp, "");
    AppMethodBeat.o(46663);
    return str;
  }
  
  public static String bTP()
  {
    AppMethodBeat.i(46666);
    String str = (String)h.aHG().aHp().get(ar.a.Vxq, "0");
    AppMethodBeat.o(46666);
    return str;
  }
  
  public static d bTQ()
  {
    AppMethodBeat.i(46667);
    if (phG == null) {
      phG = new d();
    }
    d locald = phG;
    AppMethodBeat.o(46667);
    return locald;
  }
  
  public final boolean k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(276006);
    synchronized (this.lock)
    {
      Log.i("MicroMsg.OfflineVoice.VoiceOffLineHelper", "saveVoiceOfflineLanguageResId, resId :%s、path:%s、md5:%s,version:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
      if (this.phF == null)
      {
        this.phF = new HashSet();
        Object localObject2 = (String)h.aHG().aHp().get(ar.a.Vxp, "");
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            this.phF.add(localObject3);
            i += 1;
          }
        }
      }
      MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1, paramString2).commit();
      if (Util.isEqual(paramString1, "0"))
      {
        MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString("0-1" + "_md5", paramString3).commit();
        MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString("0-1" + "_version", Util.nullAs(paramString4, "")).commit();
        AppMethodBeat.o(276006);
        return true;
      }
      MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1 + "_md5", paramString3).commit();
      MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1 + "_version", Util.nullAs(paramString4, "")).commit();
      if (!this.phF.contains(paramString1))
      {
        paramString2 = new StringBuilder((String)h.aHG().aHp().get(ar.a.Vxp, ""));
        if (this.phF.size() <= 0)
        {
          paramString2.append(paramString1);
          h.aHG().aHp().set(ar.a.Vxp, paramString2.toString());
          boolean bool = this.phF.add(paramString1);
          AppMethodBeat.o(276006);
          return bool;
        }
        paramString2.append(",").append(paramString1);
      }
    }
    AppMethodBeat.o(276006);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.d
 * JD-Core Version:    0.7.0.1
 */