package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;

public abstract interface j
{
  public static final int[] nEk = { 0, 10002, 10102, 6 };
  public static final int[] nEl = { 1, 2, 999, 10000, 10001, 10100, 10101 };
  
  public static enum a
  {
    public static boolean uB(int paramInt)
    {
      AppMethodBeat.i(187045);
      if ((a.contains(j.nEk, paramInt)) || (a.contains(j.nEl, paramInt)))
      {
        AppMethodBeat.o(187045);
        return true;
      }
      AppMethodBeat.o(187045);
      return false;
    }
    
    public static boolean vB(int paramInt)
    {
      AppMethodBeat.i(123489);
      boolean bool = a.contains(j.nEl, paramInt);
      AppMethodBeat.o(123489);
      return bool;
    }
    
    public static boolean za(int paramInt)
    {
      AppMethodBeat.i(123488);
      boolean bool = a.contains(j.nEk, paramInt);
      AppMethodBeat.o(123488);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.j
 * JD-Core Version:    0.7.0.1
 */