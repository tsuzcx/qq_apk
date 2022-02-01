package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
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
  public static final String mjC;
  private static d mjE;
  private Object lock;
  private Set<String> mjD;
  
  static
  {
    AppMethodBeat.i(46668);
    mjC = b.aKA() + "files/wxofflinevoicenew/";
    AppMethodBeat.o(46668);
  }
  
  public d()
  {
    AppMethodBeat.i(46661);
    this.lock = new Object();
    AppMethodBeat.o(46661);
  }
  
  public static void aaw(String paramString)
  {
    AppMethodBeat.i(46664);
    g.aAh().azQ().set(ar.a.Oja, paramString);
    EventCenter.instance.publish(new qk());
    AppMethodBeat.o(46664);
  }
  
  public static String aax(String paramString)
  {
    AppMethodBeat.i(46665);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString, "");
    AppMethodBeat.o(46665);
    return paramString;
  }
  
  public static String aay(String paramString)
  {
    AppMethodBeat.i(226915);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(226915);
    return paramString;
  }
  
  public static String aaz(String paramString)
  {
    AppMethodBeat.i(226916);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_version", "");
    AppMethodBeat.o(226916);
    return paramString;
  }
  
  public static String bIf()
  {
    AppMethodBeat.i(46663);
    String str = (String)g.aAh().azQ().get(ar.a.OiZ, "");
    AppMethodBeat.o(46663);
    return str;
  }
  
  public static String bIg()
  {
    AppMethodBeat.i(46666);
    String str = (String)g.aAh().azQ().get(ar.a.Oja, "0");
    AppMethodBeat.o(46666);
    return str;
  }
  
  public static d bIh()
  {
    AppMethodBeat.i(46667);
    if (mjE == null) {
      mjE = new d();
    }
    d locald = mjE;
    AppMethodBeat.o(46667);
    return locald;
  }
  
  public final boolean h(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(226914);
    synchronized (this.lock)
    {
      Log.i("MicroMsg.OfflineVoice.VoiceOffLineHelper", "saveVoiceOfflineLanguageResId, resId :%s、path:%s、md5:%s,version:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
      if (this.mjD == null)
      {
        this.mjD = new HashSet();
        Object localObject2 = (String)g.aAh().azQ().get(ar.a.OiZ, "");
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            this.mjD.add(localObject3);
            i += 1;
          }
        }
      }
      MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1, paramString2).commit();
      if (Util.isEqual(paramString1, "0"))
      {
        MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString("0-1" + "_md5", paramString3).commit();
        MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString("0-1" + "_version", Util.nullAs(paramString4, "")).commit();
        AppMethodBeat.o(226914);
        return true;
      }
      MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1 + "_md5", paramString3).commit();
      MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1 + "_version", Util.nullAs(paramString4, "")).commit();
      if (!this.mjD.contains(paramString1))
      {
        paramString2 = new StringBuilder((String)g.aAh().azQ().get(ar.a.OiZ, ""));
        if (this.mjD.size() <= 0)
        {
          paramString2.append(paramString1);
          g.aAh().azQ().set(ar.a.OiZ, paramString2.toString());
          boolean bool = this.mjD.add(paramString1);
          AppMethodBeat.o(226914);
          return bool;
        }
        paramString2.append(",").append(paramString1);
      }
    }
    AppMethodBeat.o(226914);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.d
 * JD-Core Version:    0.7.0.1
 */