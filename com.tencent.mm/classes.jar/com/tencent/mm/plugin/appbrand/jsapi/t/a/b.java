package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import android.app.Activity;
import com.tencent.luggage.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public abstract class b
  extends a
{
  protected static String cP(String paramString)
  {
    if (bo.isNullOrNil(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if (i == -1) {
      return "";
    }
    return paramString.substring(i);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    Activity localActivity;
    if ((paramc.getContext() instanceof Activity))
    {
      localActivity = (Activity)paramc.getContext();
      if (localActivity != null) {
        break label82;
      }
      ab.e("MicroMsg.BaseRecordJsApi", "operateRecorder, pageContext is null");
      paramc.h(paramInt, j("fail:internal error invalid android context", null));
    }
    label82:
    for (boolean bool = false;; bool = e.at(localActivity).a("android.permission.RECORD_AUDIO", new b.1(this, paramc, paramJSONObject, paramInt)))
    {
      if (bool) {
        break label108;
      }
      ab.e("MicroMsg.BaseRecordJsApi", "%s requestPermission fail", new Object[] { getName() });
      return;
      localActivity = null;
      break;
    }
    label108:
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.BaseRecordJsApi", "%s invalid data", new Object[] { getName() });
      paramc.h(paramInt, j("fail:invalid data", null));
      return;
    }
    c(paramc, paramJSONObject, paramInt);
  }
  
  protected abstract void c(c paramc, JSONObject paramJSONObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.b
 * JD-Core Version:    0.7.0.1
 */