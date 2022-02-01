package com.alibaba.android.patronus;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Patrons
{
  private static volatile boolean hasInit = false;
  
  public static String dumpNativeLogs()
  {
    AppMethodBeat.i(293096);
    String str = _Patrons.dumpNativeLogs();
    AppMethodBeat.o(293096);
    return str;
  }
  
  public static long getRegionSpaceSize()
  {
    AppMethodBeat.i(293095);
    if (!hasInit)
    {
      AppMethodBeat.o(293095);
      return -1L;
    }
    long l = _Patrons.getCurrentRegionSpaceSize();
    AppMethodBeat.o(293095);
    return l;
  }
  
  public static void inBackground()
  {
    AppMethodBeat.i(293092);
    if (hasInit) {
      _Patrons.inBackground();
    }
    AppMethodBeat.o(293092);
  }
  
  public static int init(Context paramContext, PatronsConfig paramPatronsConfig)
  {
    boolean bool = false;
    AppMethodBeat.i(293091);
    if (!hasInit)
    {
      int i = _Patrons.init(paramContext, paramPatronsConfig);
      if (i == 0) {
        bool = true;
      }
      hasInit = bool;
      AppMethodBeat.o(293091);
      return i;
    }
    AppMethodBeat.o(293091);
    return 0;
  }
  
  public static long readVssSize()
  {
    AppMethodBeat.i(293094);
    long l = _Patrons.readVssSize();
    AppMethodBeat.o(293094);
    return l;
  }
  
  public static boolean shrinkRegionSpace(int paramInt)
  {
    AppMethodBeat.i(293097);
    if (hasInit)
    {
      boolean bool = _Patrons.shrinkRegionSpace(paramInt);
      AppMethodBeat.o(293097);
      return bool;
    }
    AppMethodBeat.o(293097);
    return false;
  }
  
  public static void toForeground()
  {
    AppMethodBeat.i(293093);
    if (hasInit) {
      _Patrons.toForeground();
    }
    AppMethodBeat.o(293093);
  }
  
  public static class PatronsConfig
  {
    public boolean auto = true;
    public boolean debuggable = false;
    public boolean fixHuaweiBinderAbort = false;
    public int lowerLimit = 384;
    public int periodOfCheck = 30;
    public float periodOfShrink = 0.76F;
    public boolean recordInitResult = true;
    public int shrinkStep = 125;
    
    public String toString()
    {
      AppMethodBeat.i(293090);
      String str = "{ debuggable=" + this.debuggable + ", auto=" + this.auto + ", periodOfShrink=" + this.periodOfShrink + ", shrinkStep=" + this.shrinkStep + ", periodOfCheck=" + this.periodOfCheck + ", lowerLimit=" + this.lowerLimit + ", recordInitResult=" + this.recordInitResult + " }";
      AppMethodBeat.o(293090);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.alibaba.android.patronus.Patrons
 * JD-Core Version:    0.7.0.1
 */