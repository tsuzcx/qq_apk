package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

@Deprecated
public class cc
{
  static
  {
    AppMethodBeat.i(20396);
    cc.class.getClassLoader();
    j.vN("tencentlocsapp");
    AppMethodBeat.o(20396);
  }
  
  public static az Ca(String paramString)
  {
    AppMethodBeat.i(20395);
    paramString = u.zJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(20395);
      return null;
    }
    paramString = paramString.aAz();
    AppMethodBeat.o(20395);
    return paramString;
  }
  
  public final boolean a(String paramString, az paramaz)
  {
    try
    {
      AppMethodBeat.i(20394);
      u localu2 = u.zJ(paramString);
      u localu1 = localu2;
      if (localu2 == null) {
        localu1 = u.a(paramString, new u(paramaz.getClass()));
      }
      localu1.a(paramaz);
      AppMethodBeat.o(20394);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.cc
 * JD-Core Version:    0.7.0.1
 */