package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public abstract class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  private boolean a(Context paramContext, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramJSONObject = new a(paramContext, paramh, paramInt, paramString, paramJSONObject);
    paramh = null;
    paramInt = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        if (paramh == null) {
          break;
        }
      case 0: 
        try
        {
          bool = paramContext.bindService(paramh, paramJSONObject, 1);
          return bool;
          if (!paramString.equals("HUAWEI")) {
            continue;
          }
          paramInt = 0;
          continue;
          paramh = new Intent("com.huawei.nfc.action.TRANSIT_OPEN_SERVICE");
          paramh.setPackage("com.huawei.wallet");
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            ae.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "bind remote service exception [%s]", new Object[] { paramContext.getMessage() });
            boolean bool = false;
          }
        }
      }
    }
  }
  
  protected abstract void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, com.b.a.a.a.a parama, JSONObject paramJSONObject);
  
  public final class a
    implements ServiceConnection
  {
    private int cgA;
    private com.tencent.mm.plugin.appbrand.jsapi.h lnB;
    private JSONObject lnC;
    private Context mContext;
    private String mDeviceType;
    
    public a(Context paramContext, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, String paramString, JSONObject paramJSONObject)
    {
      this.mContext = paramContext;
      this.lnB = paramh;
      this.cgA = paramInt;
      this.mDeviceType = paramString;
      this.lnC = paramJSONObject;
    }
    
    public final void onServiceConnected(final ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(222682);
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
        AppMethodBeat.o(222682);
        return;
        if (!paramComponentName.equals("HUAWEI")) {
          break;
        }
        i = 0;
        break;
        paramComponentName = com.b.a.a.a.a.a.h(paramIBinder);
        com.tencent.e.h.MqF.aO(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(222681);
            a.this.a(a.a.a(a.a.this), a.a.b(a.a.this), paramComponentName, a.a.c(a.a.this));
            a.a.d(a.a.this).unbindService(a.a.this);
            AppMethodBeat.o(222681);
          }
        });
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a
 * JD-Core Version:    0.7.0.1
 */