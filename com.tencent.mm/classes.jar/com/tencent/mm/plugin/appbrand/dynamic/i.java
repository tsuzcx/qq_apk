package com.tencent.mm.plugin.appbrand.dynamic;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  private static final i hnC;
  private Map<String, String> hnB;
  
  static
  {
    AppMethodBeat.i(10702);
    hnC = new i();
    AppMethodBeat.o(10702);
  }
  
  public i()
  {
    AppMethodBeat.i(10697);
    this.hnB = new HashMap();
    AppMethodBeat.o(10697);
  }
  
  public static i azB()
  {
    return hnC;
  }
  
  public final String AY(String paramString)
  {
    AppMethodBeat.i(10699);
    paramString = (String)this.hnB.get(paramString);
    AppMethodBeat.o(10699);
    return paramString;
  }
  
  public final void AZ(String paramString)
  {
    AppMethodBeat.i(10700);
    this.hnB.remove(paramString);
    AppMethodBeat.o(10700);
  }
  
  public final Collection<String> azC()
  {
    AppMethodBeat.i(10701);
    Collection localCollection = this.hnB.values();
    AppMethodBeat.o(10701);
    return localCollection;
  }
  
  public final void bN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10698);
    if (TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(10698);
      return;
    }
    this.hnB.put(paramString1, paramString2);
    AppMethodBeat.o(10698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i
 * JD-Core Version:    0.7.0.1
 */