package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

@SuppressLint({"DefaultLocale"})
public class aq
  extends a
{
  aq(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this(String.format("WxaPkg_%s_%d", new Object[] { paramString1, Integer.valueOf(paramInt2) }), ar(paramString1, paramInt2), paramString2, paramString1, paramInt2, paramInt1);
    AppMethodBeat.i(59512);
    AppMethodBeat.o(59512);
  }
  
  private aq(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2);
  }
  
  public static String ar(String paramString, int paramInt)
  {
    AppMethodBeat.i(59510);
    String str = ap.avQ();
    paramString = str + String.format("_%d_%d.wxapkg", new Object[] { Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(59510);
    return paramString;
  }
  
  static String yx(String paramString)
  {
    AppMethodBeat.i(59511);
    String str = ap.avQ();
    paramString = str + String.format("_%s.wxapkg", new Object[] { paramString });
    AppMethodBeat.o(59511);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aq
 * JD-Core Version:    0.7.0.1
 */