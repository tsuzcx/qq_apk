package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.y;

public final class AppBrandInToolsUI
  extends AppBrandUI
{
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    try
    {
      KVCommCrossProcessReceiver.bwU();
      d.a(f.hbU, true, null);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AppBrandInToolsUI", localException, "sendKV", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandInToolsUI
 * JD-Core Version:    0.7.0.1
 */