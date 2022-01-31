package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;

@Deprecated
public class bw
{
  static
  {
    AppMethodBeat.i(16350);
    k.a("txmapengine", bw.class.getClassLoader());
    AppMethodBeat.o(16350);
  }
  
  public static at pF(String paramString)
  {
    AppMethodBeat.i(16349);
    paramString = q.nA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(16349);
      return null;
    }
    paramString = paramString.Zk();
    AppMethodBeat.o(16349);
    return paramString;
  }
  
  public final boolean a(String paramString, at paramat)
  {
    try
    {
      AppMethodBeat.i(16348);
      q localq2 = q.nA(paramString);
      q localq1 = localq2;
      if (localq2 == null) {
        localq1 = q.a(paramString, new q(paramat.getClass()));
      }
      localq1.a(paramat);
      AppMethodBeat.o(16348);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.bw
 * JD-Core Version:    0.7.0.1
 */