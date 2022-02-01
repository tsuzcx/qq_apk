package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.vfs.y;

public final class i
{
  public static String NV(String paramString)
  {
    AppMethodBeat.i(150559);
    if (!y.ZC(paramString))
    {
      AppMethodBeat.o(150559);
      return null;
    }
    long l = y.bEl(paramString);
    paramString = g.getMessageDigest((paramString + "-" + l).getBytes());
    AppMethodBeat.o(150559);
    return paramString;
  }
  
  public static h a(h paramh)
  {
    AppMethodBeat.i(150554);
    if (paramh == null)
    {
      AppMethodBeat.o(150554);
      return null;
    }
    if (paramh.bJE())
    {
      h localh = r.bKa().wq(paramh.oGB);
      if (localh == null)
      {
        AppMethodBeat.o(150554);
        return paramh;
      }
      AppMethodBeat.o(150554);
      return localh;
    }
    AppMethodBeat.o(150554);
    return paramh;
  }
  
  public static boolean b(h paramh)
  {
    AppMethodBeat.i(150555);
    if (paramh == null)
    {
      AppMethodBeat.o(150555);
      return false;
    }
    int j = paramh.offset;
    int i = paramh.osy;
    long l = paramh.hTh;
    if (paramh.bJE())
    {
      paramh = r.bKa().wq(paramh.oGB);
      j = paramh.offset;
      i = paramh.osy;
      l = paramh.hTh;
    }
    if (i == 0)
    {
      AppMethodBeat.o(150555);
      return true;
    }
    if (((j == i) && (i != 0)) || (l != 0L))
    {
      AppMethodBeat.o(150555);
      return true;
    }
    AppMethodBeat.o(150555);
    return false;
  }
  
  public static String c(h paramh)
  {
    AppMethodBeat.i(150556);
    if (paramh == null)
    {
      AppMethodBeat.o(150556);
      return "";
    }
    if (paramh.bJE())
    {
      paramh = r.bKa().wq(paramh.oGB);
      if (paramh == null)
      {
        AppMethodBeat.o(150556);
        return "";
      }
      paramh = paramh.oGr;
      AppMethodBeat.o(150556);
      return paramh;
    }
    paramh = paramh.oGr;
    AppMethodBeat.o(150556);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.i
 * JD-Core Version:    0.7.0.1
 */