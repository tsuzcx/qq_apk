package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.sdk.platformtools.bo;

final class e$6
  implements MenuItem.OnMenuItemClickListener
{
  e$6(e parame, String paramString1, String paramString2) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(17034);
    paramMenuItem = this.ihi;
    String str1 = this.ihp;
    String str2 = e.c(this.ihi);
    String str3 = this.ihq;
    int i = this.ihi.igY;
    int j = this.ihi.igZ;
    if (str1 != null)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramMenuItem.igR.getContext(), WebviewScanImageActivity.class);
      localIntent.putExtra("key_string_for_scan", str1);
      localIntent.putExtra("key_string_for_url", str2);
      localIntent.putExtra("key_string_for_image_url", str3);
      localIntent.putExtra("key_codetype_for_scan", i);
      localIntent.putExtra("key_codeversion_for_scan", j);
      if ((paramMenuItem.ihe != null) && (!bo.isNullOrNil(paramMenuItem.ihe.getAppId()))) {
        localIntent.putExtra("key_string_for_wxapp_id", paramMenuItem.ihe.getAppId());
      }
      paramMenuItem.igR.getContext().startActivity(localIntent);
    }
    AppMethodBeat.o(17034);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e.6
 * JD-Core Version:    0.7.0.1
 */