package com.tencent.mm.plugin.appbrand.dynamic;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  private static final i rkw;
  private Map<String, String> rkv;
  
  static
  {
    AppMethodBeat.i(121183);
    rkw = new i();
    AppMethodBeat.o(121183);
  }
  
  public i()
  {
    AppMethodBeat.i(121178);
    this.rkv = new HashMap();
    AppMethodBeat.o(121178);
  }
  
  public static i cnw()
  {
    return rkw;
  }
  
  public final String YX(String paramString)
  {
    AppMethodBeat.i(121180);
    paramString = (String)this.rkv.get(paramString);
    AppMethodBeat.o(121180);
    return paramString;
  }
  
  public final void YY(String paramString)
  {
    AppMethodBeat.i(121181);
    this.rkv.remove(paramString);
    AppMethodBeat.o(121181);
  }
  
  public final Collection<String> cnx()
  {
    AppMethodBeat.i(121182);
    Collection localCollection = this.rkv.values();
    AppMethodBeat.o(121182);
    return localCollection;
  }
  
  public final void dB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121179);
    if (TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(121179);
      return;
    }
    this.rkv.put(paramString1, paramString2);
    AppMethodBeat.o(121179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i
 * JD-Core Version:    0.7.0.1
 */