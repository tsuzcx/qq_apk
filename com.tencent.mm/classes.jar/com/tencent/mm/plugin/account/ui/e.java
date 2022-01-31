package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

public final class e
{
  public static void M(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
    localIntent.putExtra("KFromLoginHistory", false);
    d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.e
 * JD-Core Version:    0.7.0.1
 */