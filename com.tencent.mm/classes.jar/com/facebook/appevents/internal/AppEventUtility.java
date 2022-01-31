package com.facebook.appevents.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppEventUtility
{
  private static final String regex = "[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?";
  
  public static void assertIsMainThread() {}
  
  public static void assertIsNotMainThread() {}
  
  public static String bytesToHex(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72161);
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(72161);
    return paramArrayOfByte;
  }
  
  public static String getAppVersion()
  {
    AppMethodBeat.i(72164);
    Object localObject = FacebookSdk.getApplicationContext();
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      AppMethodBeat.o(72164);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(72164);
    }
    return "";
  }
  
  public static boolean isEmulator()
  {
    AppMethodBeat.i(72162);
    if ((Build.FINGERPRINT.startsWith("generic")) || (Build.FINGERPRINT.startsWith("unknown")) || (Build.MODEL.contains("google_sdk")) || (Build.MODEL.contains("Emulator")) || (Build.MODEL.contains("Android SDK built for x86")) || (Build.MANUFACTURER.contains("Genymotion")) || ((Build.BRAND.startsWith("generic")) && (Build.DEVICE.startsWith("generic"))) || ("google_sdk".equals(Build.PRODUCT)))
    {
      AppMethodBeat.o(72162);
      return true;
    }
    AppMethodBeat.o(72162);
    return false;
  }
  
  private static boolean isMainThread()
  {
    AppMethodBeat.i(72163);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(72163);
      return true;
    }
    AppMethodBeat.o(72163);
    return false;
  }
  
  public static double normalizePrice(String paramString)
  {
    AppMethodBeat.i(72160);
    try
    {
      paramString = Pattern.compile("[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?", 8).matcher(paramString);
      if (paramString.find())
      {
        paramString = paramString.group(0);
        double d = NumberFormat.getNumberInstance(Utility.getCurrentLocale()).parse(paramString).doubleValue();
        AppMethodBeat.o(72160);
        return d;
      }
      AppMethodBeat.o(72160);
      return 0.0D;
    }
    catch (ParseException paramString)
    {
      AppMethodBeat.o(72160);
    }
    return 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.internal.AppEventUtility
 * JD-Core Version:    0.7.0.1
 */