package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.b;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final int cZP()
  {
    return 0;
  }
  
  public final void j(String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193026);
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(193025);
        Context localContext = ak.getContext();
        JSONArray localJSONArray = paramJSONObject.optJSONArray("packageName");
        Object localObject3;
        Object localObject4;
        int m;
        int j;
        int k;
        if (localJSONArray != null)
        {
          localObject3 = new JSONObject();
          localObject4 = new JSONObject();
          m = 0;
          i = 0;
          j = i;
          k = i;
        }
        for (;;)
        {
          try
          {
            if (m >= localJSONArray.length()) {
              continue;
            }
            j = i;
            String str = localJSONArray.optString(m);
            j = i;
            localObject1 = b.getPackageInfo(localContext, str);
            if (localObject1 == null)
            {
              n = 0;
              break label484;
              j = i;
              ae.i("LiteAppJsApiGetInstallState", "getInstallState, packageName = " + str + ", version = " + n + ", versionName = " + (String)localObject1);
              k = i;
              if (i == 0)
              {
                k = i;
                if (n > 0) {
                  k = 1;
                }
              }
              j = k;
              ((JSONObject)localObject3).put(str, n);
              j = k;
              ((JSONObject)localObject4).put(str, localObject1);
              m += 1;
              i = k;
              break;
            }
            j = i;
            int n = ((PackageInfo)localObject1).versionCode;
          }
          catch (Exception localException)
          {
            Object localObject1;
            k = j;
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("result", ((JSONObject)localObject3).toString());
            ((HashMap)localObject2).put("versionName", ((JSONObject)localObject4).toString());
            if (k == 0) {
              continue;
            }
            e.a(e.this).ao((Map)localObject2);
            AppMethodBeat.o(193025);
            return;
            e.b(e.this).ZC("get_install_state:no");
            AppMethodBeat.o(193025);
            return;
          }
          j = i;
          localObject1 = ((PackageInfo)localObject1).versionName;
          continue;
          localObject3 = paramJSONObject.optString("packageName");
          if (bu.isNullOrNil((String)localObject3))
          {
            ae.i("LiteAppJsApiGetInstallState", "packageName is null or nil");
            e.c(e.this).ZC("get_install_state:no_null_packageName");
            AppMethodBeat.o(193025);
            return;
          }
          localObject4 = b.getPackageInfo(localContext, (String)localObject3);
          if (localObject4 == null) {
            if (localObject4 != null) {
              break label435;
            }
          }
          label435:
          for (Object localObject2 = "null";; localObject2 = ((PackageInfo)localObject4).versionName)
          {
            ae.i("LiteAppJsApiGetInstallState", "doGetInstallState, packageName = " + (String)localObject3 + ", version = " + i + ", versionName = " + (String)localObject2);
            if (localObject4 != null) {
              break label445;
            }
            e.d(e.this).ZC("get_install_state:no");
            AppMethodBeat.o(193025);
            return;
            i = ((PackageInfo)localObject4).versionCode;
            break;
          }
          label445:
          localObject3 = new HashMap();
          ((Map)localObject3).put("versionName", localObject2);
          e.e(e.this).ao((Map)localObject3);
          AppMethodBeat.o(193025);
          return;
          label484:
          if (localObject2 == null) {
            localObject2 = "null";
          }
        }
      }
    });
    AppMethodBeat.o(193026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.e
 * JD-Core Version:    0.7.0.1
 */