package com.tencent.mm.plugin.appbrand.jsapi;

import a.d.b.g;
import android.content.Context;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public final class JsApiProfile
  extends a<c>
{
  private static final int CTRL_INDEX = 508;
  private static final String NAME = "profile";
  public static final JsApiProfile.a ggY = new JsApiProfile.a((byte)0);
  
  static
  {
    NAME = "profile";
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    g.k(paramc, "env");
    g.k(paramJSONObject, "data");
    final String str = paramJSONObject.optString("username");
    Object localObject = paramc.getContext();
    final int i = paramJSONObject.optInt("scene", 122);
    paramJSONObject = paramJSONObject.optString("profileReportInfo");
    if (bk.bl(str))
    {
      Toast.makeText(ae.getContext(), (CharSequence)((Context)localObject).getString(y.j.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
      return;
    }
    localObject = new JsApiProfile.ProfileRequest();
    ((JsApiProfile.ProfileRequest)localObject).username = str;
    ((JsApiProfile.ProfileRequest)localObject).scene = i;
    paramJSONObject = (AppBrandProxyUIProcessTask.b)new c(this, paramc, paramInt, paramJSONObject, i, str);
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramc.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)localObject, paramJSONObject);
  }
  
  public static final class ProfileResult$a
    implements Parcelable.Creator<JsApiProfile.ProfileResult>
  {}
  
  static final class c<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<JsApiProfile.ProfileResult>
  {
    c(JsApiProfile paramJsApiProfile, c paramc, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiProfile
 * JD-Core Version:    0.7.0.1
 */