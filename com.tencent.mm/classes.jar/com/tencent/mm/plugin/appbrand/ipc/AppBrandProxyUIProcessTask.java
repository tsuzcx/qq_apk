package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public abstract class AppBrandProxyUIProcessTask
  implements MMActivity.a
{
  public c juQ;
  
  protected static String getString(int paramInt)
  {
    return aj.getResources().getString(paramInt);
  }
  
  protected abstract void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest);
  
  public final MMActivity aXi()
  {
    return this.juQ.aXi();
  }
  
  public final boolean aXj()
  {
    if (this.juQ == null) {
      return true;
    }
    return this.juQ.aXj();
  }
  
  public final AppBrandTaskProxyUI aXo()
  {
    if ((this.juQ instanceof AppBrandTaskProxyUI)) {
      return (AppBrandTaskProxyUI)this.juQ;
    }
    return null;
  }
  
  protected void aXp() {}
  
  public final void b(final AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    paramProcessResult = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45412);
        if (AppBrandProxyUIProcessTask.this.juQ == null)
        {
          AppMethodBeat.o(45412);
          return;
        }
        AppBrandProxyUIProcessTask.this.juQ.b(paramProcessResult);
        AppMethodBeat.o(45412);
      }
    };
    if (this.juQ == null) {
      return;
    }
    this.juQ.runOnUiThread(paramProcessResult);
  }
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void s(int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
 * JD-Core Version:    0.7.0.1
 */