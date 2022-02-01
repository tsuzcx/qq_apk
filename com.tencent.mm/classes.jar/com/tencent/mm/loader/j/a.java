package com.tencent.mm.loader.j;

import android.os.Build.VERSION;
import android.os.Bundle;

public final class a
{
  public static String BUILD_TAG;
  public static String CLIENT_VERSION;
  public static String COMMAND;
  public static String HOSTNAME;
  public static boolean IS_ARM64;
  public static String OWNER;
  public static String REV;
  public static String SVNPATH;
  public static String TIME;
  public static String TINKER_ID;
  public static String kQY;
  public static String kQZ = "android-" + Build.VERSION.SDK_INT;
  public static String kRa;
  public static String kRb;
  
  public static void F(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getBoolean("com.tencent.mm.BuildInfo.PATCH_ENABLED")) {}
    for (String str = "true";; str = "false")
    {
      kQY = str;
      REV = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_REV");
      CLIENT_VERSION = "0x" + Integer.toHexString(paramBundle.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION"));
      TIME = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_TIME");
      HOSTNAME = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_HOSTNAME");
      BUILD_TAG = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_TAG");
      OWNER = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_OWNER");
      COMMAND = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_COMMAND");
      SVNPATH = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_SVNPATH");
      IS_ARM64 = paramBundle.getBoolean("com.tencent.mm.BuildInfo.BUILD_IS_ARM64", false);
      TINKER_ID = paramBundle.getString("TINKER_ID");
      return;
    }
  }
  
  public static boolean aSA()
  {
    return !"false".equalsIgnoreCase(kQY);
  }
  
  public static String aSx()
  {
    if (kRa == null) {
      return REV;
    }
    return REV + "." + kRa;
  }
  
  public static String aSy()
  {
    return TINKER_ID;
  }
  
  public static String aSz()
  {
    if (kRb == null) {
      return "";
    }
    return kRb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.j.a
 * JD-Core Version:    0.7.0.1
 */