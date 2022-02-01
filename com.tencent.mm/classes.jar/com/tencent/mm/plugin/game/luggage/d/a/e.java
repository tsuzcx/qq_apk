package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends com.tencent.mm.plugin.lite.jsapi.b
{
  public final void a(String paramString, final JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(231232);
    a.post(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(231900);
        Object localObject5 = MMApplicationContext.getContext();
        Object localObject6 = paramJSONObject.optJSONArray("packageName");
        Object localObject3;
        Object localObject4;
        boolean bool1;
        boolean bool2;
        boolean bool3;
        if (localObject6 != null)
        {
          localObject3 = new JSONObject();
          localObject4 = new JSONObject();
          i = 0;
          bool1 = false;
          bool2 = bool1;
          bool3 = bool1;
        }
        for (;;)
        {
          try
          {
            if (i >= ((JSONArray)localObject6).length()) {
              continue;
            }
            bool2 = bool1;
            String str2 = ((JSONArray)localObject6).optString(i);
            bool2 = bool1;
            localObject1 = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo((Context)localObject5, str2);
            if (localObject1 == null)
            {
              j = 0;
              break label568;
              bool2 = bool1;
              Log.i("LiteAppJsApiGetInstallState", "getInstallState, packageName = " + str2 + ", version = " + j + ", versionName = " + (String)localObject1);
              bool3 = bool1;
              if (!bool1)
              {
                bool3 = bool1;
                if (j > 0) {
                  bool3 = true;
                }
              }
              bool2 = bool3;
              ((JSONObject)localObject3).put(str2, j);
              bool2 = bool3;
              ((JSONObject)localObject4).put(str2, localObject1);
              i += 1;
              bool1 = bool3;
              break;
            }
            bool2 = bool1;
            int j = ((PackageInfo)localObject1).versionCode;
          }
          catch (Exception localException)
          {
            Object localObject1;
            bool3 = bool2;
            localObject2 = new HashMap();
            if (!bool3) {
              continue;
            }
            ((HashMap)localObject2).put("versionCode", localObject3);
            ((HashMap)localObject2).put("versionName", localObject4);
            ((HashMap)localObject2).put("state", Boolean.valueOf(bool3));
            e.a(e.this).aj((Map)localObject2);
            AppMethodBeat.o(231900);
            return;
          }
          bool2 = bool1;
          localObject1 = ((PackageInfo)localObject1).versionName;
          continue;
          localObject3 = paramJSONObject.optString("packageName");
          if (Util.isNullOrNil((String)localObject3))
          {
            Log.i("LiteAppJsApiGetInstallState", "packageName is null or nil");
            e.b(e.this).aNa("get_install_state:no_null_packageName");
            AppMethodBeat.o(231900);
            return;
          }
          localObject4 = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo((Context)localObject5, (String)localObject3);
          if (localObject4 == null) {
            if (localObject4 != null) {
              break label452;
            }
          }
          label452:
          for (Object localObject2 = "null";; localObject2 = ((PackageInfo)localObject4).versionName)
          {
            Log.i("LiteAppJsApiGetInstallState", "doGetInstallState, packageName = " + (String)localObject3 + ", version = " + i + ", versionName = " + (String)localObject2);
            if (localObject4 != null) {
              break label462;
            }
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("state", Boolean.FALSE);
            e.c(e.this).aj((Map)localObject2);
            AppMethodBeat.o(231900);
            return;
            i = ((PackageInfo)localObject4).versionCode;
            break;
          }
          label462:
          localObject4 = new HashMap();
          localObject5 = new JSONObject();
          localObject6 = new JSONObject();
          try
          {
            ((JSONObject)localObject5).put((String)localObject3, i);
            ((JSONObject)localObject6).put((String)localObject3, localObject2);
            label508:
            ((Map)localObject4).put("versionCode", localObject5);
            ((Map)localObject4).put("versionName", localObject6);
            ((Map)localObject4).put("state", Boolean.TRUE);
            e.d(e.this).aj((Map)localObject4);
            AppMethodBeat.o(231900);
            return;
          }
          catch (JSONException localJSONException)
          {
            break label508;
          }
          label568:
          if (localJSONException == null) {
            String str1 = "null";
          }
        }
      }
    });
    AppMethodBeat.o(231232);
  }
  
  public final int ewF()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.e
 * JD-Core Version:    0.7.0.1
 */