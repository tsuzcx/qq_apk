package com.tencent.magicbrush.gapid;

public class MagicGAPID
{
  private static boolean eIQ = false;
  public static int eIR = 25;
  public static String eIS = "/sdcard/tencent/MicroMsg/appbrand/trace";
  
  private static native int nativeAttach(String paramString1, String paramString2, int paramInt);
  
  private static native void nativeDetach();
  
  private static native int nativeSnapshotCapture();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.gapid.MagicGAPID
 * JD-Core Version:    0.7.0.1
 */