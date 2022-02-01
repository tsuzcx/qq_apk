package com.tencent.mm.plugin.ai.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ah;
import com.tencent.mm.autogen.mmdata.rpt.ai;
import com.tencent.mm.plugin.ai.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  private static String TAG = "MicroMsg.AiMMKV";
  private String name = null;
  
  public static ai TV(String paramString)
  {
    AppMethodBeat.i(267386);
    int i = a.caw();
    Object localObject = null;
    String str = e.caH().qpt.O(paramString, "");
    paramString = (String)localObject;
    if (!Util.isNullOrNil(str)) {
      paramString = new ai(str);
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.iob == i) {}
    }
    else
    {
      localObject = new ai();
      ((ai)localObject).iob = i;
    }
    AppMethodBeat.o(267386);
    return localObject;
  }
  
  public static ah TW(String paramString)
  {
    AppMethodBeat.i(267399);
    int i = a.caw();
    Object localObject = null;
    String str = e.caH().qpt.O(paramString, "");
    paramString = (String)localObject;
    if (!Util.isNullOrNil(str)) {
      paramString = new ah(str);
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.iob == i) {}
    }
    else
    {
      localObject = new ah();
      ((ah)localObject).iob = i;
    }
    AppMethodBeat.o(267399);
    return localObject;
  }
  
  public static void a(String paramString, ah paramah)
  {
    AppMethodBeat.i(267403);
    e.caH().qpt.save(paramString, paramah.aIE());
    AppMethodBeat.o(267403);
  }
  
  public static void a(String paramString, ai paramai)
  {
    AppMethodBeat.i(267393);
    e.caH().qpt.save(paramString, paramai.aIE());
    AppMethodBeat.o(267393);
  }
  
  private String info()
  {
    AppMethodBeat.i(267376);
    String str = hashCode();
    AppMethodBeat.o(267376);
    return str;
  }
  
  public final String O(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267443);
    MultiProcessMMKV localMultiProcessMMKV = atj();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(267443);
      return paramString2;
    }
    paramString1 = localMultiProcessMMKV.getString(paramString1, paramString2);
    AppMethodBeat.o(267443);
    return paramString1;
  }
  
  public final void Q(String paramString, long paramLong)
  {
    AppMethodBeat.i(267420);
    MultiProcessMMKV localMultiProcessMMKV = atj();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(267420);
      return;
    }
    localMultiProcessMMKV.putLong(paramString, paramLong);
    AppMethodBeat.o(267420);
  }
  
  public final long TT(String paramString)
  {
    AppMethodBeat.i(267427);
    MultiProcessMMKV localMultiProcessMMKV = atj();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(267427);
      return 0L;
    }
    long l = localMultiProcessMMKV.getLong(paramString, 0L);
    AppMethodBeat.o(267427);
    return l;
  }
  
  public final int TU(String paramString)
  {
    AppMethodBeat.i(267436);
    MultiProcessMMKV localMultiProcessMMKV = atj();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(267436);
      return 0;
    }
    int i = localMultiProcessMMKV.getInt(paramString, 0);
    AppMethodBeat.o(267436);
    return i;
  }
  
  public final MultiProcessMMKV atj()
  {
    AppMethodBeat.i(267416);
    com.tencent.mm.plugin.expt.e.d.dNI();
    int i = com.tencent.mm.plugin.expt.e.d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(267416);
      return null;
    }
    Object localObject = i + "_WxExptAiMMKV";
    if (!Util.isEqual(this.name, (String)localObject))
    {
      Log.i(TAG, "%s get mmkv change uin old[%s] new[%s]", new Object[] { info(), this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.name);
    AppMethodBeat.o(267416);
    return localObject;
  }
  
  public final void bt(String paramString, int paramInt)
  {
    AppMethodBeat.i(267431);
    MultiProcessMMKV localMultiProcessMMKV = atj();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(267431);
      return;
    }
    localMultiProcessMMKV.putInt(paramString, paramInt);
    AppMethodBeat.o(267431);
  }
  
  public final void save(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267439);
    MultiProcessMMKV localMultiProcessMMKV = atj();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(267439);
      return;
    }
    localMultiProcessMMKV.putString(paramString1, paramString2);
    AppMethodBeat.o(267439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.d
 * JD-Core Version:    0.7.0.1
 */