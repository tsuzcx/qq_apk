package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.BaseActivity;

public final class FullSdkExternalToolsHelper
  implements ac
{
  public final void a(Context paramContext, String paramString, dfj paramdfj)
  {
    AppMethodBeat.i(146713);
    ae.d("Luggage.FullSdkExternalToolsHelper", "open webview activity url: %s", new Object[] { paramString });
    paramdfj = new Intent(paramContext, SimpleWebViewActivity.class);
    paramdfj.putExtra("_url_", paramString);
    if (!(paramContext instanceof Activity)) {
      paramdfj.addFlags(268435456);
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramdfj);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahE(), "com/tencent/luggage/sdk/customize/impl/FullSdkExternalToolsHelper", "openWebViewActivity", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/SimpleWebViewLaunchParams;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/luggage/sdk/customize/impl/FullSdkExternalToolsHelper", "openWebViewActivity", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/SimpleWebViewLaunchParams;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(146713);
  }
  
  public static class SimpleWebViewActivity
    extends BaseActivity
  {
    private WebView webView;
    
    private void i(Intent paramIntent)
    {
      AppMethodBeat.i(146712);
      paramIntent = paramIntent.getStringExtra("_url_");
      this.webView.stopLoading();
      this.webView.loadUrl(paramIntent);
      AppMethodBeat.o(146712);
    }
    
    public final int getLayoutId()
    {
      return 2131494672;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(146710);
      super.onCreate(paramBundle);
      this.webView = ((WebView)findViewById(2131306909));
      i(getIntent());
      AppMethodBeat.o(146710);
    }
    
    public void onNewIntent(Intent paramIntent)
    {
      AppMethodBeat.i(146711);
      super.onNewIntent(paramIntent);
      i(paramIntent);
      AppMethodBeat.o(146711);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      AppMethodBeat.at(this, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper
 * JD-Core Version:    0.7.0.1
 */