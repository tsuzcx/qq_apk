package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.sdk.platformtools.bk;

final class e$6
  implements MenuItem.OnMenuItemClickListener
{
  e$6(e parame, String paramString1, String paramString2) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.gGA;
    String str1 = this.gGH;
    String str2 = e.i(this.gGA);
    String str3 = this.gGI;
    int i = this.gGA.gGr;
    int j = this.gGA.gGs;
    if (str1 != null)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramMenuItem.gGk.getContext(), WebviewScanImageActivity.class);
      localIntent.putExtra("key_string_for_scan", str1);
      localIntent.putExtra("key_string_for_url", str2);
      localIntent.putExtra("key_string_for_image_url", str3);
      localIntent.putExtra("key_codetype_for_scan", i);
      localIntent.putExtra("key_codeversion_for_scan", j);
      if ((paramMenuItem.gGx != null) && (!bk.bl(paramMenuItem.gGx.getAppId()))) {
        localIntent.putExtra("key_string_for_wxapp_id", paramMenuItem.gGx.getAppId());
      }
      paramMenuItem.gGk.getContext().startActivity(localIntent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.6
 * JD-Core Version:    0.7.0.1
 */