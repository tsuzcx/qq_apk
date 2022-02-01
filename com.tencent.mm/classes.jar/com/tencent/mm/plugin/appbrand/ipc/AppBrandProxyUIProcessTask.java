package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public abstract class AppBrandProxyUIProcessTask
  implements MMActivity.a
{
  public c kpz;
  
  protected static String getString(int paramInt)
  {
    return aj.getResources().getString(paramInt);
  }
  
  protected abstract void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest);
  
  public final void b(final AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    paramProcessResult = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45412);
        if (AppBrandProxyUIProcessTask.this.kpz == null)
        {
          AppMethodBeat.o(45412);
          return;
        }
        AppBrandProxyUIProcessTask.this.kpz.b(paramProcessResult);
        AppMethodBeat.o(45412);
      }
    };
    if (this.kpz == null) {
      return;
    }
    this.kpz.runOnUiThread(paramProcessResult);
  }
  
  public final MMActivity bhJ()
  {
    return this.kpz.bhJ();
  }
  
  public final boolean bhK()
  {
    if (this.kpz == null) {
      return true;
    }
    return this.kpz.bhK();
  }
  
  public final AppBrandTaskProxyUI bhP()
  {
    if ((this.kpz instanceof AppBrandTaskProxyUI)) {
      return (AppBrandTaskProxyUI)this.kpz;
    }
    return null;
  }
  
  protected void bhQ() {}
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void t(int[] paramArrayOfInt) {}
  
  public static class DefaultProcessResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<DefaultProcessResult> CREATOR;
    
    static
    {
      AppMethodBeat.i(188242);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(188242);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    protected final void j(Parcel paramParcel) {}
    
    public void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
 * JD-Core Version:    0.7.0.1
 */