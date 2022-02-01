package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public abstract class a
  extends d<k>
{
  private boolean a(Context paramContext, k paramk, int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramJSONObject = new a(paramContext, paramk, paramInt, paramString, paramJSONObject);
    paramk = null;
    paramInt = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        if (paramk == null) {
          break;
        }
      case 0: 
        try
        {
          bool = paramContext.bindService(paramk, paramJSONObject, 1);
          return bool;
          if (!paramString.equals("HUAWEI")) {
            continue;
          }
          paramInt = 0;
          continue;
          paramk = new Intent("com.huawei.nfc.action.TRANSIT_OPEN_SERVICE");
          paramk.setPackage("com.huawei.wallet");
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            Log.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "bind remote service exception [%s]", new Object[] { paramContext.getMessage() });
            boolean bool = false;
          }
        }
      }
    }
  }
  
  protected abstract void a(k paramk, int paramInt, com.huawei.a.a.a.a parama, JSONObject paramJSONObject);
  
  public final class a
    implements ServiceConnection
  {
    private int csv;
    private Context mContext;
    private String mDeviceType;
    private k mui;
    private JSONObject muj;
    
    public a(Context paramContext, k paramk, int paramInt, String paramString, JSONObject paramJSONObject)
    {
      this.mContext = paramContext;
      this.mui = paramk;
      this.csv = paramInt;
      this.mDeviceType = paramString;
      this.muj = paramJSONObject;
    }
    
    public final void onServiceConnected(final ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(226993);
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
        AppMethodBeat.o(226993);
        return;
        if (!paramComponentName.equals("HUAWEI")) {
          break;
        }
        i = 0;
        break;
        paramComponentName = com.huawei.a.a.a.a.a.h(paramIBinder);
        h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(226992);
            a.this.a(a.a.a(a.a.this), a.a.b(a.a.this), paramComponentName, a.a.c(a.a.this));
            a.a.d(a.a.this).unbindService(a.a.this);
            AppMethodBeat.o(226992);
          }
        });
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.a
 * JD-Core Version:    0.7.0.1
 */