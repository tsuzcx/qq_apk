package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public abstract class AppBrandProxyUIProcessTask
  implements MMActivity.a
{
  public b ger;
  
  public abstract void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest);
  
  public final void a(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    paramProcessResult = new AppBrandProxyUIProcessTask.1(this, paramProcessResult);
    if (this.ger == null) {
      return;
    }
    this.ger.runOnUiThread(paramProcessResult);
  }
  
  public void ahE() {}
  
  public final MMActivity ahy()
  {
    return this.ger.ahy();
  }
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
 * JD-Core Version:    0.7.0.1
 */