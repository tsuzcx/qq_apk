package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.BaseActivity;

public class FullSdkExternalToolsHelper$SimpleWebViewActivity
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
    return 2131495397;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(229830);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(229830);
    return localResources;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(146710);
    super.onCreate(paramBundle);
    this.webView = ((WebView)findViewById(2131310382));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper.SimpleWebViewActivity
 * JD-Core Version:    0.7.0.1
 */