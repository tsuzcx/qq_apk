package com.alibaba.android.patronus;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Patrons
{
  private static volatile boolean hasInit = false;
  
  public static String dumpNativeLogs()
  {
    AppMethodBeat.i(207002);
    String str = _Patrons.dumpNativeLogs();
    AppMethodBeat.o(207002);
    return str;
  }
  
  public static long getCurrentMaxAvailableVMAddr()
  {
    AppMethodBeat.i(206985);
    if (_Patrons.isNativeLibLoaded())
    {
      long l = _Patrons.getCurrentMaxAvailableVmAddr();
      AppMethodBeat.o(206985);
      return l;
    }
    AppMethodBeat.o(206985);
    return 4294967296L;
  }
  
  public static long getRegionSpaceSize()
  {
    AppMethodBeat.i(206998);
    if (!hasInit)
    {
      AppMethodBeat.o(206998);
      return -1L;
    }
    long l = _Patrons.getCurrentRegionSpaceSize();
    AppMethodBeat.o(206998);
    return l;
  }
  
  public static void inBackground()
  {
    AppMethodBeat.i(206973);
    if (hasInit) {
      _Patrons.inBackground();
    }
    AppMethodBeat.o(206973);
  }
  
  public static int init(Context paramContext, PatronsConfig paramPatronsConfig)
  {
    boolean bool = false;
    AppMethodBeat.i(206969);
    if (!hasInit)
    {
      int i = _Patrons.init(paramContext, paramPatronsConfig);
      if (i == 0) {
        bool = true;
      }
      hasInit = bool;
      AppMethodBeat.o(206969);
      return i;
    }
    AppMethodBeat.o(206969);
    return 0;
  }
  
  public static long readVssSize()
  {
    AppMethodBeat.i(206994);
    long l = _Patrons.readVssSize();
    AppMethodBeat.o(206994);
    return l;
  }
  
  public static boolean shrinkRegionSpace(int paramInt)
  {
    AppMethodBeat.i(207003);
    if (hasInit)
    {
      boolean bool = _Patrons.shrinkRegionSpace(paramInt);
      AppMethodBeat.o(207003);
      return bool;
    }
    AppMethodBeat.o(207003);
    return false;
  }
  
  public static void toForeground()
  {
    AppMethodBeat.i(206979);
    if (hasInit) {
      _Patrons.toForeground();
    }
    AppMethodBeat.o(206979);
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
      AppMethodBeat.i(206947);
      String str = "{ debuggable=" + this.debuggable + ", auto=" + this.auto + ", periodOfShrink=" + this.periodOfShrink + ", shrinkStep=" + this.shrinkStep + ", periodOfCheck=" + this.periodOfCheck + ", lowerLimit=" + this.lowerLimit + ", recordInitResult=" + this.recordInitResult + " }";
      AppMethodBeat.o(206947);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.alibaba.android.patronus.Patrons
 * JD-Core Version:    0.7.0.1
 */