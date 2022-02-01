package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;

public abstract interface j
{
  public static final int[] jIy = { 0, 10002, 10102, 6 };
  public static final int[] jIz = { 1, 2, 999, 10000, 10001, 10100, 10101 };
  
  public static enum a
  {
    public static boolean isValid(int paramInt)
    {
      AppMethodBeat.i(200319);
      if ((a.contains(j.jIy, paramInt)) || (a.contains(j.jIz, paramInt)))
      {
        AppMethodBeat.o(200319);
        return true;
      }
      AppMethodBeat.o(200319);
      return false;
    }
    
    public static boolean oQ(int paramInt)
    {
      AppMethodBeat.i(123489);
      boolean bool = a.contains(j.jIz, paramInt);
      AppMethodBeat.o(123489);
      return bool;
    }
    
    public static boolean rT(int paramInt)
    {
      AppMethodBeat.i(123488);
      boolean bool = a.contains(j.jIy, paramInt);
      AppMethodBeat.o(123488);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.j
 * JD-Core Version:    0.7.0.1
 */