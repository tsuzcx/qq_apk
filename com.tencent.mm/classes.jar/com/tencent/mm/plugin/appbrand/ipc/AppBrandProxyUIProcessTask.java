package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public abstract class AppBrandProxyUIProcessTask
  implements MMActivity.a
{
  public c ksP;
  
  protected static String getString(int paramInt)
  {
    return ak.getResources().getString(paramInt);
  }
  
  protected abstract void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest);
  
  public final void b(final AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    paramProcessResult = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45412);
        if (AppBrandProxyUIProcessTask.this.ksP == null)
        {
          AppMethodBeat.o(45412);
          return;
        }
        AppBrandProxyUIProcessTask.this.ksP.b(paramProcessResult);
        AppMethodBeat.o(45412);
      }
    };
    if (this.ksP == null) {
      return;
    }
    this.ksP.runOnUiThread(paramProcessResult);
  }
  
  public final MMActivity bis()
  {
    return this.ksP.bis();
  }
  
  public final boolean bit()
  {
    if (this.ksP == null) {
      return true;
    }
    return this.ksP.bit();
  }
  
  public final AppBrandTaskProxyUI biy()
  {
    if ((this.ksP instanceof AppBrandTaskProxyUI)) {
      return (AppBrandTaskProxyUI)this.ksP;
    }
    return null;
  }
  
  protected void biz() {}
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void t(int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
 * JD-Core Version:    0.7.0.1
 */