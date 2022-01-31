package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public abstract class AppBrandProxyUIProcessTask
  implements MMActivity.a
{
  public b hwr;
  
  protected static String getString(int paramInt)
  {
    return ah.getResources().getString(paramInt);
  }
  
  protected abstract void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest);
  
  public final void a(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    paramProcessResult = new AppBrandProxyUIProcessTask.1(this, paramProcessResult);
    if (this.hwr == null) {
      return;
    }
    this.hwr.runOnUiThread(paramProcessResult);
  }
  
  public final MMActivity aBf()
  {
    return this.hwr.aBf();
  }
  
  protected void aBl() {}
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
 * JD-Core Version:    0.7.0.1
 */