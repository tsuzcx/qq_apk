package com.tencent.liteav.basic.util;

public class TXCCommonUtil
{
  private static String mAppID = "";
  private static String mStrAppVersion = "";
  public static String pituLicencePath = "YTFaceSDK.licence";
  
  static
  {
    a.d();
  }
  
  public static String getAppID()
  {
    return mAppID;
  }
  
  public static String getAppVersion()
  {
    return mStrAppVersion;
  }
  
  public static String getFileExtension(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0)
      {
        int i = paramString.lastIndexOf('.');
        localObject1 = localObject2;
        if (i >= 0)
        {
          localObject1 = localObject2;
          if (i < paramString.length() - 1) {
            localObject1 = paramString.substring(i + 1);
          }
        }
      }
    }
    return localObject1;
  }
  
  public static int getSDKID()
  {
    return nativeGetSDKID();
  }
  
  public static int[] getSDKVersion()
  {
    String[] arrayOfString = nativeGetSDKVersion().split("\\.");
    int[] arrayOfInt = new int[arrayOfString.length];
    int i = 0;
    for (;;)
    {
      if (i < arrayOfString.length) {
        try
        {
          arrayOfInt[i] = Integer.parseInt(arrayOfString[i]);
          i += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            arrayOfInt[i] = 0;
          }
        }
      }
    }
    return arrayOfInt;
  }
  
  public static String getSDKVersionStr()
  {
    return nativeGetSDKVersion();
  }
  
  public static String getStreamIDByStreamUrl(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = null;
      return paramString;
    }
    int i = paramString.indexOf("?");
    if (i != -1) {}
    for (String str = paramString.substring(0, i);; str = paramString)
    {
      if ((str == null) || (str.length() == 0)) {
        return null;
      }
      i = str.lastIndexOf("/");
      paramString = str;
      if (i != -1) {
        paramString = str.substring(i + 1);
      }
      if ((paramString == null) || (paramString.length() == 0)) {
        return null;
      }
      i = paramString.indexOf(".");
      str = paramString;
      if (i != -1) {
        str = paramString.substring(0, i);
      }
      if (str != null)
      {
        paramString = str;
        if (str.length() != 0) {
          break;
        }
      }
      return null;
    }
  }
  
  private static native int nativeGetSDKID();
  
  private static native String nativeGetSDKVersion();
  
  public static void setAppID(String paramString)
  {
    mAppID = paramString;
  }
  
  public static void setAppVersion(String paramString)
  {
    mStrAppVersion = paramString;
  }
  
  public static void setPituLicencePath(String paramString)
  {
    pituLicencePath = paramString;
  }
  
  public static void sleep(int paramInt)
  {
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXCCommonUtil
 * JD-Core Version:    0.7.0.1
 */