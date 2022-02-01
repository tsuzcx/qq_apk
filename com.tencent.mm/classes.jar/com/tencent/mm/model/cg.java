package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

@Deprecated
public class cg
{
  static
  {
    AppMethodBeat.i(20396);
    cg.class.getClassLoader();
    j.Ed("tencentlocsapp");
    AppMethodBeat.o(20396);
  }
  
  public static bd KG(String paramString)
  {
    AppMethodBeat.i(20395);
    paramString = y.Il(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(20395);
      return null;
    }
    paramString = paramString.aTV();
    AppMethodBeat.o(20395);
    return paramString;
  }
  
  public final boolean a(String paramString, bd parambd)
  {
    try
    {
      AppMethodBeat.i(20394);
      y localy2 = y.Il(paramString);
      y localy1 = localy2;
      if (localy2 == null) {
        localy1 = y.a(paramString, new y(parambd.getClass()));
      }
      localy1.a(parambd);
      AppMethodBeat.o(20394);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.cg
 * JD-Core Version:    0.7.0.1
 */