package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.e;
import com.google.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceRequestsHelper
{
  static final String DEVICE_INFO_DEVICE = "device";
  static final String DEVICE_INFO_MODEL = "model";
  public static final String DEVICE_INFO_PARAM = "device_info";
  public static final String DEVICE_TARGET_USER_ID = "target_user_id";
  static final String SDK_FLAVOR = "android";
  static final String SDK_HEADER = "fbsdk";
  static final String SERVICE_TYPE = "_fb._tcp.";
  private static final String TAG;
  private static HashMap<String, NsdManager.RegistrationListener> deviceRequestsListeners;
  
  static
  {
    AppMethodBeat.i(96608);
    TAG = DeviceRequestsHelper.class.getCanonicalName();
    deviceRequestsListeners = new HashMap();
    AppMethodBeat.o(96608);
  }
  
  public static void cleanUpAdvertisementService(String paramString)
  {
    AppMethodBeat.i(96605);
    cleanUpAdvertisementServiceImpl(paramString);
    AppMethodBeat.o(96605);
  }
  
  @TargetApi(16)
  private static void cleanUpAdvertisementServiceImpl(String paramString)
  {
    AppMethodBeat.i(96607);
    NsdManager.RegistrationListener localRegistrationListener = (NsdManager.RegistrationListener)deviceRequestsListeners.get(paramString);
    NsdManager localNsdManager;
    if (localRegistrationListener != null) {
      localNsdManager = (NsdManager)FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
    }
    try
    {
      localNsdManager.unregisterService(localRegistrationListener);
      deviceRequestsListeners.remove(paramString);
      AppMethodBeat.o(96607);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Utility.logd(TAG, localIllegalArgumentException);
      }
    }
  }
  
  public static Bitmap generateQRCode(String paramString)
  {
    AppMethodBeat.i(96604);
    Object localObject = new EnumMap(c.class);
    ((Map)localObject).put(c.bhD, Integer.valueOf(2));
    int m;
    int n;
    int i;
    int j;
    int k;
    try
    {
      paramString = new e().a(paramString, a.bhr, 200, 200, (Map)localObject);
      m = paramString.height;
      n = paramString.width;
      localObject = new int[m * n];
      i = 0;
    }
    catch (h paramString)
    {
      try
      {
        paramString.setPixels((int[])localObject, 0, n, 0, 0, n, m);
        for (;;)
        {
          label127:
          AppMethodBeat.o(96604);
          return paramString;
          paramString = paramString;
          paramString = null;
        }
      }
      catch (h localh)
      {
        break label127;
      }
    }
    if (j < n) {
      if (paramString.bu(j, i)) {
        k = -16777216;
      }
    }
    label183:
    for (;;)
    {
      paramString = Bitmap.createBitmap(n, m, Bitmap.Config.ARGB_8888);
      for (;;)
      {
        if (i >= m) {
          break label183;
        }
        j = 0;
        break;
        for (;;)
        {
          localh[(i * n + j)] = k;
          j += 1;
          break;
          k = -1;
        }
        i += 1;
      }
    }
  }
  
  public static String getDeviceInfo()
  {
    AppMethodBeat.i(96601);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("device", Build.DEVICE);
      ((JSONObject)localObject).put("model", Build.MODEL);
      label33:
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(96601);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label33;
    }
  }
  
  public static boolean isAvailable()
  {
    AppMethodBeat.i(96603);
    if ((Build.VERSION.SDK_INT >= 16) && (FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.Enabled)))
    {
      AppMethodBeat.o(96603);
      return true;
    }
    AppMethodBeat.o(96603);
    return false;
  }
  
  public static boolean startAdvertisementService(String paramString)
  {
    AppMethodBeat.i(96602);
    if (isAvailable())
    {
      boolean bool = startAdvertisementServiceImpl(paramString);
      AppMethodBeat.o(96602);
      return bool;
    }
    AppMethodBeat.o(96602);
    return false;
  }
  
  @TargetApi(16)
  private static boolean startAdvertisementServiceImpl(String paramString)
  {
    AppMethodBeat.i(96606);
    if (deviceRequestsListeners.containsKey(paramString))
    {
      AppMethodBeat.o(96606);
      return true;
    }
    Object localObject = String.format("%s_%s_%s", new Object[] { "fbsdk", String.format("%s-%s", new Object[] { "android", FacebookSdk.getSdkVersion().replace('.', '|') }), paramString });
    NsdServiceInfo localNsdServiceInfo = new NsdServiceInfo();
    localNsdServiceInfo.setServiceType("_fb._tcp.");
    localNsdServiceInfo.setServiceName((String)localObject);
    localNsdServiceInfo.setPort(80);
    NsdManager localNsdManager = (NsdManager)FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
    localObject = new DeviceRequestsHelper.1((String)localObject, paramString);
    deviceRequestsListeners.put(paramString, localObject);
    localNsdManager.registerService(localNsdServiceInfo, 1, (NsdManager.RegistrationListener)localObject);
    AppMethodBeat.o(96606);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.devicerequests.internal.DeviceRequestsHelper
 * JD-Core Version:    0.7.0.1
 */