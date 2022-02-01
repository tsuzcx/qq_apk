package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

@Deprecated
public class bz
{
  static
  {
    AppMethodBeat.i(20396);
    bz.class.getClassLoader();
    j.pq("txmapengine");
    AppMethodBeat.o(20396);
  }
  
  public static aw ut(String paramString)
  {
    AppMethodBeat.i(20395);
    paramString = t.sd(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(20395);
      return null;
    }
    paramString = paramString.aqD();
    AppMethodBeat.o(20395);
    return paramString;
  }
  
  public final boolean a(String paramString, aw paramaw)
  {
    try
    {
      AppMethodBeat.i(20394);
      t localt2 = t.sd(paramString);
      t localt1 = localt2;
      if (localt2 == null) {
        localt1 = t.a(paramString, new t(paramaw.getClass()));
      }
      localt1.a(paramaw);
      AppMethodBeat.o(20394);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bz
 * JD-Core Version:    0.7.0.1
 */