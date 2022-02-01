package com.tencent.kinda.modularize;

public class KindaDebugConfig
{
  private static boolean sLibReloading = false;
  
  public static boolean isLibReloading()
  {
    return sLibReloading;
  }
  
  public static void markLibReloading()
  {
    sLibReloading = true;
  }
  
  public static void resetLibReloading()
  {
    sLibReloading = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.modularize.KindaDebugConfig
 * JD-Core Version:    0.7.0.1
 */