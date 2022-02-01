package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IInterface;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a
  extends com.tencent.mm.plugin.appbrand.jsapi.c<k>
{
  private static String sxF = null;
  private String mAppId = null;
  
  private boolean a(Context paramContext, k paramk, int paramInt, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramContext == null) {
      return false;
    }
    paramJSONObject = new a.a(this, paramContext, paramk, paramInt, paramBoolean, paramJSONObject);
    paramk = null;
    if (paramBoolean)
    {
      paramk = new Intent("com.huawei.nfc.action.TRANSIT_OPEN_SERVICE");
      paramk.setPackage("com.huawei.wallet");
    }
    while (paramk != null) {
      try
      {
        paramBoolean = paramContext.bindService(paramk, paramJSONObject, 1);
        return paramBoolean;
        if (TextUtils.isEmpty(sxF)) {
          continue;
        }
        paramk = new Intent("com.tencent.mm.sdk.trafficcard.action.TRANSIT_OPEN_SERVICE");
        paramk.setPackage(sxF);
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          Log.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "bind remote service exception [%s]", new Object[] { paramContext.getMessage() });
          paramBoolean = false;
        }
      }
    }
  }
  
  private static boolean ac(Context paramContext, String paramString)
  {
    String str = Build.BRAND;
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(str))) {
      return false;
    }
    Log.i("MicroMsg.AppBrandTrafficCardBaseJsApi", "isOtherDevices, packageName: %s", new Object[] { sxF });
    if (sxF == null)
    {
      Object localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zll, "");
      Log.i("MicroMsg.AppBrandTrafficCardBaseJsApi", "isOtherDevices, nfcCardCfg: %s", new Object[] { localObject1 });
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return false;
      }
      Object localObject3 = null;
      String[] arrayOfString2 = null;
      String[] arrayOfString1 = arrayOfString2;
      try
      {
        Object localObject4 = new JSONObject((String)localObject1);
        arrayOfString1 = arrayOfString2;
        localObject1 = localObject3;
        if (((JSONObject)localObject4).getBoolean("isSupport"))
        {
          arrayOfString1 = arrayOfString2;
          localObject4 = ((JSONObject)localObject4).getJSONArray("packageName");
          localObject1 = localObject3;
          if (localObject4 != null)
          {
            arrayOfString1 = arrayOfString2;
            localObject1 = localObject3;
            if (((JSONArray)localObject4).length() > 0)
            {
              arrayOfString1 = arrayOfString2;
              int j = ((JSONArray)localObject4).length();
              arrayOfString1 = arrayOfString2;
              arrayOfString2 = new String[j];
              int i = 0;
              for (;;)
              {
                localObject1 = arrayOfString2;
                if (i >= j) {
                  break;
                }
                arrayOfString1 = arrayOfString2;
                arrayOfString2[i] = ((JSONArray)localObject4).getString(i);
                i += 1;
              }
            }
          }
        }
        Object localObject2;
        if (TextUtils.isEmpty(sxF)) {
          break label315;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "parse nfc card config Exception:%s", new Object[] { localException.getMessage() });
        localObject2 = arrayOfString1;
        paramContext = b(paramContext, localObject2);
        Log.i("MicroMsg.AppBrandTrafficCardBaseJsApi", "update OPPOPackage= %s", new Object[] { paramContext });
        if (!TextUtils.isEmpty(paramContext)) {
          sxF = paramContext;
        }
      }
    }
    else
    {
      if (paramString.equals("Default")) {
        return true;
      }
      return str.toLowerCase().equals(paramString.toLowerCase());
    }
  }
  
  private static String b(Context paramContext, String[] paramArrayOfString)
  {
    if ((paramContext == null) || (paramArrayOfString == null)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (getPackageInfo(paramContext, paramArrayOfString[i]) != null) {
        return paramArrayOfString[i];
      }
      i += 1;
    }
    return null;
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "getPackageInfo exception: [%s]", new Object[] { paramContext.getMessage() });
    }
    return null;
  }
  
  protected abstract void a(k paramk, int paramInt, IInterface paramIInterface, JSONObject paramJSONObject);
  
  protected final void t(int paramInt1, int paramInt2, String paramString)
  {
    com.tencent.mm.plugin.report.service.h.OAn.b(22506, new Object[] { this.mAppId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.a
 * JD-Core Version:    0.7.0.1
 */