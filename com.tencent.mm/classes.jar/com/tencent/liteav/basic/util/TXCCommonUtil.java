package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public class TXCCommonUtil
{
  private static String mAppID;
  private static String mStrAppVersion;
  public static String pituLicencePath;
  
  static
  {
    AppMethodBeat.i(66029);
    mAppID = "";
    mStrAppVersion = "";
    pituLicencePath = "YTFaceSDK.licence";
    b.f();
    AppMethodBeat.o(66029);
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
    AppMethodBeat.i(66026);
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
    AppMethodBeat.o(66026);
    return localObject1;
  }
  
  public static String getMD5(String paramString)
  {
    AppMethodBeat.i(146626);
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuffer localStringBuffer = new StringBuffer("");
      int i = 0;
      while (i < localObject.length)
      {
        int k = localObject[i];
        int j = k;
        if (k < 0) {
          j = k + 256;
        }
        if (j < 16) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(Integer.toHexString(j));
        i += 1;
      }
      localObject = localStringBuffer.toString();
      AppMethodBeat.o(146626);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(146626);
    }
    return paramString;
  }
  
  public static byte[] getMD5(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(146627);
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      AppMethodBeat.o(146627);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(146627);
    }
    return null;
  }
  
  public static int getSDKID()
  {
    AppMethodBeat.i(66025);
    int i = nativeGetSDKID();
    AppMethodBeat.o(66025);
    return i;
  }
  
  public static int[] getSDKVersion()
  {
    AppMethodBeat.i(66023);
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
    AppMethodBeat.o(66023);
    return arrayOfInt;
  }
  
  public static String getSDKVersionStr()
  {
    AppMethodBeat.i(66024);
    String str = nativeGetSDKVersion();
    AppMethodBeat.o(66024);
    return str;
  }
  
  public static String getStreamIDByStreamUrl(String paramString)
  {
    AppMethodBeat.i(66028);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(66028);
      return null;
    }
    int i = paramString.indexOf("?");
    if (i != -1) {}
    for (String str = paramString.substring(0, i);; str = paramString)
    {
      if ((str == null) || (str.length() == 0))
      {
        AppMethodBeat.o(66028);
        return null;
      }
      i = str.lastIndexOf("/");
      paramString = str;
      if (i != -1) {
        paramString = str.substring(i + 1);
      }
      if ((paramString == null) || (paramString.length() == 0))
      {
        AppMethodBeat.o(66028);
        return null;
      }
      i = paramString.indexOf(".");
      str = paramString;
      if (i != -1) {
        str = paramString.substring(0, i);
      }
      if ((str == null) || (str.length() == 0))
      {
        AppMethodBeat.o(66028);
        return null;
      }
      AppMethodBeat.o(66028);
      return str;
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
    AppMethodBeat.i(66027);
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      AppMethodBeat.o(66027);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(66027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXCCommonUtil
 * JD-Core Version:    0.7.0.1
 */