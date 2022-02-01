package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

@Deprecated
public class ca
{
  static
  {
    AppMethodBeat.i(20396);
    ca.class.getClassLoader();
    j.vr("tencentlocsapp");
    AppMethodBeat.o(20396);
  }
  
  public static ax By(String paramString)
  {
    AppMethodBeat.i(20395);
    paramString = t.yZ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(20395);
      return null;
    }
    paramString = paramString.aAj();
    AppMethodBeat.o(20395);
    return paramString;
  }
  
  public final boolean a(String paramString, ax paramax)
  {
    try
    {
      AppMethodBeat.i(20394);
      t localt2 = t.yZ(paramString);
      t localt1 = localt2;
      if (localt2 == null) {
        localt1 = t.a(paramString, new t(paramax.getClass()));
      }
      localt1.a(paramax);
      AppMethodBeat.o(20394);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ca
 * JD-Core Version:    0.7.0.1
 */