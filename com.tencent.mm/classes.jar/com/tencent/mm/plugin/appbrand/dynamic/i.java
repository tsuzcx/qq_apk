package com.tencent.mm.plugin.appbrand.dynamic;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  private static final i kiy;
  private Map<String, String> kix;
  
  static
  {
    AppMethodBeat.i(121183);
    kiy = new i();
    AppMethodBeat.o(121183);
  }
  
  public i()
  {
    AppMethodBeat.i(121178);
    this.kix = new HashMap();
    AppMethodBeat.o(121178);
  }
  
  public static i bgs()
  {
    return kiy;
  }
  
  public final String Pc(String paramString)
  {
    AppMethodBeat.i(121180);
    paramString = (String)this.kix.get(paramString);
    AppMethodBeat.o(121180);
    return paramString;
  }
  
  public final void Pd(String paramString)
  {
    AppMethodBeat.i(121181);
    this.kix.remove(paramString);
    AppMethodBeat.o(121181);
  }
  
  public final Collection<String> bgt()
  {
    AppMethodBeat.i(121182);
    Collection localCollection = this.kix.values();
    AppMethodBeat.o(121182);
    return localCollection;
  }
  
  public final void cK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121179);
    if (TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(121179);
      return;
    }
    this.kix.put(paramString1, paramString2);
    AppMethodBeat.o(121179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i
 * JD-Core Version:    0.7.0.1
 */