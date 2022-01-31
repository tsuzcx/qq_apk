package com.google.android.gms.common.util;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public final class PlatformVersion
{
  public static boolean isAtLeastFroyo()
  {
    return true;
  }
  
  public static boolean isAtLeastGingerbread()
  {
    return true;
  }
  
  public static boolean isAtLeastGingerbreadMR1()
  {
    return true;
  }
  
  public static boolean isAtLeastHoneycomb()
  {
    return true;
  }
  
  public static boolean isAtLeastHoneycombMR1()
  {
    return true;
  }
  
  public static boolean isAtLeastHoneycombMR2()
  {
    return true;
  }
  
  public static boolean isAtLeastIceCreamSandwich()
  {
    return true;
  }
  
  public static boolean isAtLeastIceCreamSandwichMR1()
  {
    return Build.VERSION.SDK_INT >= 15;
  }
  
  public static boolean isAtLeastJellyBean()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean isAtLeastJellyBeanMR1()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean isAtLeastJellyBeanMR2()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  @Deprecated
  public static boolean isAtLeastKeyLimePie()
  {
    AppMethodBeat.i(90253);
    boolean bool = isAtLeastKitKat();
    AppMethodBeat.o(90253);
    return bool;
  }
  
  public static boolean isAtLeastKitKat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean isAtLeastKitKatWatch()
  {
    return Build.VERSION.SDK_INT >= 20;
  }
  
  @Deprecated
  public static boolean isAtLeastL()
  {
    AppMethodBeat.i(90254);
    boolean bool = isAtLeastLollipop();
    AppMethodBeat.o(90254);
    return bool;
  }
  
  public static boolean isAtLeastLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public static boolean isAtLeastLollipopMR1()
  {
    return Build.VERSION.SDK_INT >= 22;
  }
  
  public static boolean isAtLeastM()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isAtLeastN()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public static boolean isAtLeastNMR1()
  {
    return Build.VERSION.SDK_INT >= 25;
  }
  
  public static boolean isAtLeastO()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public static boolean isAtLeastOMR1()
  {
    return Build.VERSION.SDK_INT >= 27;
  }
  
  public static boolean isAtLeastP()
  {
    AppMethodBeat.i(90255);
    if (Build.VERSION.SDK_INT >= 28)
    {
      AppMethodBeat.o(90255);
      return true;
    }
    AppMethodBeat.o(90255);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.PlatformVersion
 * JD-Core Version:    0.7.0.1
 */