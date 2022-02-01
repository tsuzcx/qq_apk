package com.tencent.luggage.sdk.customize.impl;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.luggage.n.b.a;
import com.tencent.luggage.n.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.BaseActivity;

public class FullSdkExternalToolsHelper$SimpleWebViewActivity
  extends BaseActivity
{
  private WebView eqw;
  
  private void j(Intent paramIntent)
  {
    AppMethodBeat.i(146712);
    paramIntent = paramIntent.getStringExtra("_url_");
    this.eqw.stopLoading();
    this.eqw.loadUrl(paramIntent);
    AppMethodBeat.o(146712);
  }
  
  public final int getLayoutId()
  {
    return b.b.luggage_activity_simple_webview;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(220379);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(220379);
    return localResources;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(146710);
    super.onCreate(paramBundle);
    this.eqw = ((WebView)findViewById(b.a.webview));
    j(getIntent());
    AppMethodBeat.o(146710);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(146711);
    super.onNewIntent(paramIntent);
    j(paramIntent);
    AppMethodBeat.o(146711);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper.SimpleWebViewActivity
 * JD-Core Version:    0.7.0.1
 */