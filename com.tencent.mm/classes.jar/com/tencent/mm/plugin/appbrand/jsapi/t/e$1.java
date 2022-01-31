package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class e$1
  extends m
{
  e$1(e parame) {}
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: " + paramString2);
    if ((this.gGA.gGt == null) || (paramString1 == null) || (!paramString1.equals(this.gGA.gGt.riI))) {}
    do
    {
      do
      {
        return;
      } while (paramInt1 != 22);
      if (this.gGA.gGt != null) {
        this.gGA.gGt.ccQ();
      }
      this.gGA.gGr = paramInt1;
      this.gGA.gGs = paramInt2;
    } while ((paramString2 == null) || (e.g(this.gGA) == null));
    e.b(this.gGA).runOnUiThread(new e.1.1(this, paramString2));
  }
  
  public final Bundle f(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_webview_container_env", "miniProgram");
    switch (paramInt)
    {
    default: 
      return localBundle;
    case 139: 
      paramBundle = paramBundle.getString("info");
      try
      {
        paramBundle = new JSONObject(paramBundle);
        e.b(this.gGA).B(paramBundle);
        return localBundle;
      }
      catch (Exception paramBundle)
      {
        return localBundle;
      }
    case 101: 
      paramBundle.setClassLoader(e.class.getClassLoader());
      d.b(e.f(this.gGA), paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")));
      return localBundle;
    case 140: 
      localBundle.putInt("key_webview_preverify_info_scene", 1);
      localBundle.putString("key_webview_preverify_info_source_appid", e.b(this.gGA).getAppId());
      return localBundle;
    }
    localBundle.putStringArray("key_webview_apbrand_jsapi_report_args", e.b(this.gGA).getJsApiReportArgs());
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.1
 * JD-Core Version:    0.7.0.1
 */