package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;

@Deprecated
public class ci
{
  static
  {
    AppMethodBeat.i(20396);
    ci.class.getClassLoader();
    k.DA("tencentlocsapp");
    AppMethodBeat.o(20396);
  }
  
  public static be Ka(String paramString)
  {
    AppMethodBeat.i(20395);
    paramString = y.Ix(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(20395);
      return null;
    }
    paramString = paramString.bAJ();
    AppMethodBeat.o(20395);
    return paramString;
  }
  
  public final boolean a(String paramString, be parambe)
  {
    try
    {
      AppMethodBeat.i(20394);
      y localy2 = y.Ix(paramString);
      y localy1 = localy2;
      if (localy2 == null) {
        localy1 = y.a(paramString, new y(parambe.getClass()));
      }
      localy1.a(parambe);
      AppMethodBeat.o(20394);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ci
 * JD-Core Version:    0.7.0.1
 */