package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.y;

public class ShortCutPermissionDetailUI
  extends WebViewUI
{
  private long mStartTime = 0L;
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  public void onStart()
  {
    super.onStart();
    this.mStartTime = System.currentTimeMillis();
  }
  
  protected void onStop()
  {
    super.onStop();
    y.i("MicroMsg.ShortCutPermissionDetailUI", "onStop");
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      String str = localIntent.getStringExtra("extra_app_id");
      int i = localIntent.getIntExtra("extra_permission_and_jump_status", 0);
      h.nFQ.f(15786, new Object[] { Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(i), Integer.valueOf(0), str });
    }
    this.mStartTime = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ShortCutPermissionDetailUI
 * JD-Core Version:    0.7.0.1
 */