package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public abstract class AppBrandProxyUIProcessTask
  implements MMActivity.a
{
  public c jVl;
  
  protected static String getString(int paramInt)
  {
    return ai.getResources().getString(paramInt);
  }
  
  protected abstract void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest);
  
  public final void b(final AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    paramProcessResult = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45412);
        if (AppBrandProxyUIProcessTask.this.jVl == null)
        {
          AppMethodBeat.o(45412);
          return;
        }
        AppBrandProxyUIProcessTask.this.jVl.b(paramProcessResult);
        AppMethodBeat.o(45412);
      }
    };
    if (this.jVl == null) {
      return;
    }
    this.jVl.runOnUiThread(paramProcessResult);
  }
  
  public final MMActivity bef()
  {
    return this.jVl.bef();
  }
  
  public final boolean beg()
  {
    if (this.jVl == null) {
      return true;
    }
    return this.jVl.beg();
  }
  
  public final AppBrandTaskProxyUI bel()
  {
    if ((this.jVl instanceof AppBrandTaskProxyUI)) {
      return (AppBrandTaskProxyUI)this.jVl;
    }
    return null;
  }
  
  protected void bem() {}
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void t(int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
 * JD-Core Version:    0.7.0.1
 */