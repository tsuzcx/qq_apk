package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;

public abstract interface k
{
  public static final int[] qEf = { 0, 10002, 10102, 6 };
  public static final int[] qEg = { 1, 2, 999, 10000, 10001, 10100, 10101 };
  
  public static enum a
  {
    public static boolean uB(int paramInt)
    {
      AppMethodBeat.i(320363);
      if ((a.contains(k.qEf, paramInt)) || (a.contains(k.qEg, paramInt)))
      {
        AppMethodBeat.o(320363);
        return true;
      }
      AppMethodBeat.o(320363);
      return false;
    }
    
    public static boolean vK(int paramInt)
    {
      AppMethodBeat.i(123489);
      boolean bool = a.contains(k.qEg, paramInt);
      AppMethodBeat.o(123489);
      return bool;
    }
    
    public static boolean zn(int paramInt)
    {
      AppMethodBeat.i(123488);
      boolean bool = a.contains(k.qEf, paramInt);
      AppMethodBeat.o(123488);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.k
 * JD-Core Version:    0.7.0.1
 */