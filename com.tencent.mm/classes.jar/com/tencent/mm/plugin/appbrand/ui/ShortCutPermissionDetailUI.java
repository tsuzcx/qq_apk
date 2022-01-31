package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ab;

public class ShortCutPermissionDetailUI
  extends WebViewUI
{
  private long mStartTime = 0L;
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(17097);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    AppMethodBeat.o(17097);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(17096);
    super.onStart();
    this.mStartTime = System.currentTimeMillis();
    AppMethodBeat.o(17096);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(17098);
    super.onStop();
    ab.i("MicroMsg.ShortCutPermissionDetailUI", "onStop");
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      String str = localIntent.getStringExtra("extra_app_id");
      int i = localIntent.getIntExtra("extra_permission_and_jump_status", 0);
      h.qsU.e(15786, new Object[] { Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(i), Integer.valueOf(0), str });
    }
    this.mStartTime = 0L;
    AppMethodBeat.o(17098);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ShortCutPermissionDetailUI
 * JD-Core Version:    0.7.0.1
 */