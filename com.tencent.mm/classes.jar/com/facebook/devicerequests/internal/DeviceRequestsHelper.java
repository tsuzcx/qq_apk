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
import com.google.c.a;
import com.google.c.b.b;
import com.google.c.c;
import com.google.c.e;
import com.google.c.h;
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
    AppMethodBeat.i(7632);
    TAG = DeviceRequestsHelper.class.getCanonicalName();
    deviceRequestsListeners = new HashMap();
    AppMethodBeat.o(7632);
  }
  
  public static void cleanUpAdvertisementService(String paramString)
  {
    AppMethodBeat.i(7629);
    cleanUpAdvertisementServiceImpl(paramString);
    AppMethodBeat.o(7629);
  }
  
  @TargetApi(16)
  private static void cleanUpAdvertisementServiceImpl(String paramString)
  {
    AppMethodBeat.i(7631);
    NsdManager.RegistrationListener localRegistrationListener = (NsdManager.RegistrationListener)deviceRequestsListeners.get(paramString);
    NsdManager localNsdManager;
    if (localRegistrationListener != null) {
      localNsdManager = (NsdManager)FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
    }
    try
    {
      localNsdManager.unregisterService(localRegistrationListener);
      deviceRequestsListeners.remove(paramString);
      AppMethodBeat.o(7631);
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
    AppMethodBeat.i(7628);
    Object localObject = new EnumMap(c.class);
    ((Map)localObject).put(c.bRt, Integer.valueOf(2));
    int m;
    int n;
    int i;
    int j;
    int k;
    try
    {
      paramString = new e().a(paramString, a.bRh, 200, 200, (Map)localObject);
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
          label128:
          AppMethodBeat.o(7628);
          return paramString;
          paramString = paramString;
          paramString = null;
        }
      }
      catch (h localh)
      {
        break label128;
      }
    }
    if (j < n) {
      if (paramString.bI(j, i)) {
        k = -16777216;
      }
    }
    label185:
    for (;;)
    {
      paramString = Bitmap.createBitmap(n, m, Bitmap.Config.ARGB_8888);
      for (;;)
      {
        if (i >= m) {
          break label185;
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
    AppMethodBeat.i(7625);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("device", Build.DEVICE);
      ((JSONObject)localObject).put("model", Build.MODEL);
      label34:
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(7625);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label34;
    }
  }
  
  public static boolean isAvailable()
  {
    AppMethodBeat.i(7627);
    if ((Build.VERSION.SDK_INT >= 16) && (FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.Enabled)))
    {
      AppMethodBeat.o(7627);
      return true;
    }
    AppMethodBeat.o(7627);
    return false;
  }
  
  public static boolean startAdvertisementService(String paramString)
  {
    AppMethodBeat.i(7626);
    if (isAvailable())
    {
      boolean bool = startAdvertisementServiceImpl(paramString);
      AppMethodBeat.o(7626);
      return bool;
    }
    AppMethodBeat.o(7626);
    return false;
  }
  
  @TargetApi(16)
  private static boolean startAdvertisementServiceImpl(final String paramString)
  {
    AppMethodBeat.i(7630);
    if (deviceRequestsListeners.containsKey(paramString))
    {
      AppMethodBeat.o(7630);
      return true;
    }
    Object localObject = String.format("%s_%s_%s", new Object[] { "fbsdk", String.format("%s-%s", new Object[] { "android", FacebookSdk.getSdkVersion().replace('.', '|') }), paramString });
    NsdServiceInfo localNsdServiceInfo = new NsdServiceInfo();
    localNsdServiceInfo.setServiceType("_fb._tcp.");
    localNsdServiceInfo.setServiceName((String)localObject);
    localNsdServiceInfo.setPort(80);
    NsdManager localNsdManager = (NsdManager)FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
    localObject = new NsdManager.RegistrationListener()
    {
      public final void onRegistrationFailed(NsdServiceInfo paramAnonymousNsdServiceInfo, int paramAnonymousInt)
      {
        AppMethodBeat.i(7624);
        DeviceRequestsHelper.cleanUpAdvertisementService(paramString);
        AppMethodBeat.o(7624);
      }
      
      public final void onServiceRegistered(NsdServiceInfo paramAnonymousNsdServiceInfo)
      {
        AppMethodBeat.i(7623);
        if (!this.val$nsdServiceName.equals(paramAnonymousNsdServiceInfo.getServiceName())) {
          DeviceRequestsHelper.cleanUpAdvertisementService(paramString);
        }
        AppMethodBeat.o(7623);
      }
      
      public final void onServiceUnregistered(NsdServiceInfo paramAnonymousNsdServiceInfo) {}
      
      public final void onUnregistrationFailed(NsdServiceInfo paramAnonymousNsdServiceInfo, int paramAnonymousInt) {}
    };
    deviceRequestsListeners.put(paramString, localObject);
    localNsdManager.registerService(localNsdServiceInfo, 1, (NsdManager.RegistrationListener)localObject);
    AppMethodBeat.o(7630);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.devicerequests.internal.DeviceRequestsHelper
 * JD-Core Version:    0.7.0.1
 */