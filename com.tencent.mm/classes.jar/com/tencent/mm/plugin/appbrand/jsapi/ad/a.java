package com.tencent.mm.plugin.appbrand.jsapi.ad;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.p;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  protected abstract void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, com.b.b.a.a.a parama, JSONObject paramJSONObject);
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.h paramh, final JSONObject paramJSONObject, final int paramInt)
  {
    Activity localActivity = com.tencent.mm.sdk.f.a.jq(paramh.getRuntime().mContext);
    if (localActivity == null)
    {
      paramh.h(paramInt, e("fail:internal error invalid android context", null));
      ad.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "mmActivity is null, invoke fail! with appId[%s] callbackId[%d]", new Object[] { paramh.getAppId(), Integer.valueOf(paramInt) });
    }
    label412:
    label478:
    label490:
    for (;;)
    {
      return;
      String str = paramJSONObject.optString("deviceType");
      Object localObject = paramJSONObject.optJSONObject("deviceData");
      if (TextUtils.isEmpty(str))
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(b.mSZ.errorCode));
        paramh.h(paramInt, m("fail:" + b.mSZ.errorMsg, paramJSONObject));
        ad.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "deviceType is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", new Object[] { b.mSZ.errorMsg, paramh.getAppId(), Integer.valueOf(paramInt) });
        return;
      }
      boolean bool1;
      if ("HUAWEI".equals(str))
      {
        p.a(paramh.getAppId(), new android.support.v4.app.a.a()
        {
          public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
          {
            AppMethodBeat.i(221284);
            if (paramAnonymousInt != 147)
            {
              AppMethodBeat.o(221284);
              return;
            }
            if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
            {
              a.this.a(paramh, paramJSONObject, paramInt);
              AppMethodBeat.o(221284);
              return;
            }
            paramh.h(paramInt, a.this.e("fail:system permission denied", null));
            AppMethodBeat.o(221284);
          }
        });
        paramJSONObject = com.tencent.mm.sdk.f.a.jq(paramh.getRuntime().mContext);
        if ((paramJSONObject == null) || (!(paramJSONObject instanceof Activity)))
        {
          paramh.h(paramInt, e("fail", null));
          bool1 = false;
          label252:
          if (!bool1) {
            break label363;
          }
        }
      }
      else
      {
        if ((localActivity != null) && (str != null)) {
          break label365;
        }
        bool1 = false;
      }
      for (;;)
      {
        if (bool1) {
          break label490;
        }
        paramh.h(paramInt, e("fail:null system service", null));
        ad.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "null system service, invoke fail! with deviceType[%s] appId[%s] callbackId[%d]", new Object[] { str, paramh.getAppId(), Integer.valueOf(paramInt) });
        return;
        boolean bool2 = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "com.huawei.wallet.permission.QUERY_TRAFFIC_CARD_INFO", 147, "", "");
        bool1 = bool2;
        if (!bool2) {
          break label252;
        }
        p.TS(paramh.getAppId());
        bool1 = bool2;
        break label252;
        label363:
        break;
        label365:
        localObject = new a(localActivity, paramh, paramInt, str, (JSONObject)localObject);
        paramJSONObject = null;
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          }
          break;
        }
        for (;;)
        {
          if (paramJSONObject != null) {
            break label478;
          }
          bool1 = false;
          break;
          if (!str.equals("HUAWEI")) {
            break label412;
          }
          i = 0;
          break label412;
          paramJSONObject = new Intent("com.huawei.nfc.action.TRANSIT_OPEN_SERVICE");
          paramJSONObject.setPackage("com.huawei.wallet");
        }
        bool1 = localActivity.bindService(paramJSONObject, (ServiceConnection)localObject, 1);
      }
    }
  }
  
  public final class a
    implements ServiceConnection
  {
    private int cgA;
    private Context mContext;
    private String mDeviceType;
    private JSONObject mSU;
    private com.tencent.mm.plugin.appbrand.jsapi.h mhH;
    
    public a(Context paramContext, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, String paramString, JSONObject paramJSONObject)
    {
      this.mContext = paramContext;
      this.mhH = paramh;
      this.cgA = paramInt;
      this.mDeviceType = paramString;
      this.mSU = paramJSONObject;
    }
    
    public final void onServiceConnected(final ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(221286);
      paramComponentName = this.mDeviceType;
      int i = -1;
      switch (paramComponentName.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(221286);
        return;
        if (!paramComponentName.equals("HUAWEI")) {
          break;
        }
        i = 0;
        break;
        paramComponentName = com.b.b.a.a.a.a.Q(paramIBinder);
        com.tencent.e.h.LTJ.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221285);
            a.this.a(a.a.a(a.a.this), a.a.b(a.a.this), paramComponentName, a.a.c(a.a.this));
            a.a.d(a.a.this).unbindService(a.a.this);
            AppMethodBeat.o(221285);
          }
        });
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a
 * JD-Core Version:    0.7.0.1
 */