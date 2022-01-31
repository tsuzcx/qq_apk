package com.tencent.mm.loader.j;

import android.os.Build.VERSION;
import android.os.Bundle;

public final class a
{
  public static String BUILD_TAG;
  public static String CLIENT_VERSION;
  public static String COMMAND;
  public static String HOSTNAME;
  public static String OWNER;
  public static String PATCH_ENABLED;
  public static String REV;
  public static String SVNPATH;
  public static String TIME;
  public static String eQs = "android-" + Build.VERSION.SDK_INT;
  public static String eQt;
  
  public static String Ui()
  {
    if (eQt == null) {
      return REV;
    }
    return REV + "." + eQt;
  }
  
  public static String Uj()
  {
    return REV;
  }
  
  public static boolean Uk()
  {
    return !"false".equalsIgnoreCase(PATCH_ENABLED);
  }
  
  public static void p(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getBoolean("com.tencent.mm.BuildInfo.PATCH_ENABLED")) {}
    for (String str = "true";; str = "false")
    {
      PATCH_ENABLED = str;
      REV = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_REV");
      CLIENT_VERSION = "0x" + Integer.toHexString(paramBundle.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION"));
      TIME = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_TIME");
      HOSTNAME = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_HOSTNAME");
      BUILD_TAG = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_TAG");
      OWNER = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_OWNER");
      COMMAND = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_COMMAND");
      SVNPATH = paramBundle.getString("com.tencent.mm.BuildInfo.BUILD_SVNPATH");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.j.a
 * JD-Core Version:    0.7.0.1
 */