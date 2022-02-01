package com.tencent.magicbrush.gapid;

import androidx.annotation.Keep;

public class MagicGAPID
{
  private static boolean cNv = false;
  public static int cNw = 25;
  public static String cNx = "/sdcard/tencent/MicroMsg/appbrand/trace";
  
  @Keep
  private static native int nativeAttach(String paramString1, String paramString2, int paramInt);
  
  @Keep
  private static native void nativeDetach();
  
  @Keep
  private static native int nativeSnapshotCapture();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.gapid.MagicGAPID
 * JD-Core Version:    0.7.0.1
 */