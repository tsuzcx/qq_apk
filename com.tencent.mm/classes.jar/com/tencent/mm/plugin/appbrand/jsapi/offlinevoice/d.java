package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.sz;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashSet;
import java.util.Set;

public final class d
{
  public static final String smX;
  private static d smZ;
  private Object lock;
  private Set<String> smY;
  
  static
  {
    AppMethodBeat.i(46668);
    smX = b.bmq() + "files/wxofflinevoicenew/";
    AppMethodBeat.o(46668);
  }
  
  public d()
  {
    AppMethodBeat.i(46661);
    this.lock = new Object();
    AppMethodBeat.o(46661);
  }
  
  public static void abl(String paramString)
  {
    AppMethodBeat.i(46664);
    h.baE().ban().set(at.a.acZc, paramString);
    new sz().publish();
    AppMethodBeat.o(46664);
  }
  
  public static String abm(String paramString)
  {
    AppMethodBeat.i(46665);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString, "");
    AppMethodBeat.o(46665);
    return paramString;
  }
  
  public static String abn(String paramString)
  {
    AppMethodBeat.i(325921);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_md5", "");
    AppMethodBeat.o(325921);
    return paramString;
  }
  
  public static String abo(String paramString)
  {
    AppMethodBeat.i(325924);
    paramString = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(paramString + "_version", "");
    AppMethodBeat.o(325924);
    return paramString;
  }
  
  public static String cub()
  {
    AppMethodBeat.i(46663);
    String str = (String)h.baE().ban().get(at.a.acZb, "");
    AppMethodBeat.o(46663);
    return str;
  }
  
  public static String cuc()
  {
    AppMethodBeat.i(46666);
    String str = (String)h.baE().ban().get(at.a.acZc, "0");
    AppMethodBeat.o(46666);
    return str;
  }
  
  public static d cud()
  {
    AppMethodBeat.i(46667);
    if (smZ == null) {
      smZ = new d();
    }
    d locald = smZ;
    AppMethodBeat.o(46667);
    return locald;
  }
  
  public final boolean j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(325930);
    synchronized (this.lock)
    {
      Log.i("MicroMsg.OfflineVoice.VoiceOffLineHelper", "saveVoiceOfflineLanguageResId, resId :%s、path:%s、md5:%s,version:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
      if (this.smY == null)
      {
        this.smY = new HashSet();
        Object localObject2 = (String)h.baE().ban().get(at.a.acZb, "");
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            this.smY.add(localObject3);
            i += 1;
          }
        }
      }
      MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1, paramString2).commit();
      if (Util.isEqual(paramString1, "0"))
      {
        MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString("0-1" + "_md5", paramString3).commit();
        MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString("0-1" + "_version", Util.nullAs(paramString4, "")).commit();
        AppMethodBeat.o(325930);
        return true;
      }
      MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1 + "_md5", paramString3).commit();
      MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(paramString1 + "_version", Util.nullAs(paramString4, "")).commit();
      if (!this.smY.contains(paramString1))
      {
        paramString2 = new StringBuilder((String)h.baE().ban().get(at.a.acZb, ""));
        if (this.smY.size() <= 0)
        {
          paramString2.append(paramString1);
          h.baE().ban().set(at.a.acZb, paramString2.toString());
          boolean bool = this.smY.add(paramString1);
          AppMethodBeat.o(325930);
          return bool;
        }
        paramString2.append(",").append(paramString1);
      }
    }
    AppMethodBeat.o(325930);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.d
 * JD-Core Version:    0.7.0.1
 */