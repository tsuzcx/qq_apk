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
    j.sC("txmapengine");
    AppMethodBeat.o(20396);
  }
  
  public static aw yz(String paramString)
  {
    AppMethodBeat.i(20395);
    paramString = t.wg(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(20395);
      return null;
    }
    paramString = paramString.axt();
    AppMethodBeat.o(20395);
    return paramString;
  }
  
  public final boolean a(String paramString, aw paramaw)
  {
    try
    {
      AppMethodBeat.i(20394);
      t localt2 = t.wg(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bz
 * JD-Core Version:    0.7.0.1
 */