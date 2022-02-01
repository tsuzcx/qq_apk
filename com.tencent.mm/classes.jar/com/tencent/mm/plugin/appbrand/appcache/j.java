package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;

public abstract interface j
{
  public static final int[] kKu = { 0, 10002, 10102, 6 };
  public static final int[] kKv = { 1, 2, 999, 10000, 10001, 10100, 10101 };
  
  public static enum a
  {
    public static boolean isValid(int paramInt)
    {
      AppMethodBeat.i(225275);
      if ((a.contains(j.kKu, paramInt)) || (a.contains(j.kKv, paramInt)))
      {
        AppMethodBeat.o(225275);
        return true;
      }
      AppMethodBeat.o(225275);
      return false;
    }
    
    public static boolean sE(int paramInt)
    {
      AppMethodBeat.i(123489);
      boolean bool = a.contains(j.kKv, paramInt);
      AppMethodBeat.o(123489);
      return bool;
    }
    
    public static boolean vP(int paramInt)
    {
      AppMethodBeat.i(123488);
      boolean bool = a.contains(j.kKu, paramInt);
      AppMethodBeat.o(123488);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.j
 * JD-Core Version:    0.7.0.1
 */