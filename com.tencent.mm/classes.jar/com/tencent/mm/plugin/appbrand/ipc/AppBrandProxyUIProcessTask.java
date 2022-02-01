package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public abstract class AppBrandProxyUIProcessTask
  implements MMActivity.a
{
  public d orj;
  
  protected abstract void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest);
  
  public final void b(final ProcessResult paramProcessResult)
  {
    paramProcessResult = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45412);
        if (AppBrandProxyUIProcessTask.a(AppBrandProxyUIProcessTask.this) == null)
        {
          AppMethodBeat.o(45412);
          return;
        }
        AppBrandProxyUIProcessTask.a(AppBrandProxyUIProcessTask.this).b(paramProcessResult);
        AppMethodBeat.o(45412);
      }
    };
    if (this.orj == null) {
      return;
    }
    this.orj.runOnUiThread(paramProcessResult);
  }
  
  public final MMActivity bPf()
  {
    return this.orj.bPf();
  }
  
  public final boolean bPg()
  {
    if (this.orj == null) {
      return true;
    }
    return this.orj.bPg();
  }
  
  public final AppBrandTaskProxyUI bPl()
  {
    if ((this.orj instanceof AppBrandTaskProxyUI)) {
      return (AppBrandTaskProxyUI)this.orj;
    }
    return null;
  }
  
  protected void bPm() {}
  
  public void d(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void u(int[] paramArrayOfInt) {}
  
  public static class DefaultProcessResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<DefaultProcessResult> CREATOR;
    
    static
    {
      AppMethodBeat.i(276974);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(276974);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    protected final void k(Parcel paramParcel) {}
    
    public void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
  
  public static abstract class ProcessResult
    implements Parcelable
  {
    public ProcessResult() {}
    
    public ProcessResult(Parcel paramParcel)
    {
      k(paramParcel);
    }
    
    protected abstract void k(Parcel paramParcel);
  }
  
  public static abstract interface b<R extends AppBrandProxyUIProcessTask.ProcessResult>
  {
    public abstract void a(R paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
 * JD-Core Version:    0.7.0.1
 */