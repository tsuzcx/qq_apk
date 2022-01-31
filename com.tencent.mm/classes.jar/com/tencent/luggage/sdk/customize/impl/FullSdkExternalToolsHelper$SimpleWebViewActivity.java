package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BaseActivity;

public class FullSdkExternalToolsHelper$SimpleWebViewActivity
  extends BaseActivity
{
  private WebView webView;
  
  private void j(Intent paramIntent)
  {
    AppMethodBeat.i(101629);
    paramIntent = paramIntent.getStringExtra("_url_");
    this.webView.stopLoading();
    this.webView.loadUrl(paramIntent);
    AppMethodBeat.o(101629);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(101627);
    super.onCreate(paramBundle);
    this.webView = ((WebView)findViewById(2131822422));
    j(getIntent());
    AppMethodBeat.o(101627);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(101628);
    super.onNewIntent(paramIntent);
    j(paramIntent);
    AppMethodBeat.o(101628);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper.SimpleWebViewActivity
 * JD-Core Version:    0.7.0.1
 */