package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.reflect.Constructor;

public abstract class AppBrandProxyUIProcessTask
  implements MMActivity.a
{
  public c lwz;
  
  protected static String getString(int paramInt)
  {
    return MMApplicationContext.getResources().getString(paramInt);
  }
  
  protected abstract void a(ProcessRequest paramProcessRequest);
  
  public final void b(final ProcessResult paramProcessResult)
  {
    paramProcessResult = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45412);
        if (AppBrandProxyUIProcessTask.this.lwz == null)
        {
          AppMethodBeat.o(45412);
          return;
        }
        AppBrandProxyUIProcessTask.this.lwz.b(paramProcessResult);
        AppMethodBeat.o(45412);
      }
    };
    if (this.lwz == null) {
      return;
    }
    this.lwz.runOnUiThread(paramProcessResult);
  }
  
  public final MMActivity bDF()
  {
    return this.lwz.bDF();
  }
  
  public final boolean bDG()
  {
    if (this.lwz == null) {
      return true;
    }
    return this.lwz.bDG();
  }
  
  public final AppBrandTaskProxyUI bDL()
  {
    if ((this.lwz instanceof AppBrandTaskProxyUI)) {
      return (AppBrandTaskProxyUI)this.lwz;
    }
    return null;
  }
  
  protected void bDM() {}
  
  public void d(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void u(int[] paramArrayOfInt) {}
  
  public static abstract class ProcessRequest
    implements Parcelable
  {
    public ProcessRequest() {}
    
    public ProcessRequest(Parcel paramParcel)
    {
      k(paramParcel);
    }
    
    protected abstract Class<? extends AppBrandProxyUIProcessTask> bCJ();
    
    protected boolean bDN()
    {
      return false;
    }
    
    protected String bDO()
    {
      return null;
    }
    
    protected int bDP()
    {
      return -1;
    }
    
    protected boolean bDQ()
    {
      return false;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    protected void k(Parcel paramParcel) {}
    
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
  
  static final class a
  {
    static <_Model extends AppBrandProxyUIProcessTask> _Model YX(String paramString)
    {
      AppMethodBeat.i(45413);
      try
      {
        Object localObject = Class.forName(paramString).getDeclaredConstructor(new Class[0]);
        ((Constructor)localObject).setAccessible(true);
        localObject = (AppBrandProxyUIProcessTask)((Constructor)localObject).newInstance(new Object[0]);
        AppMethodBeat.o(45413);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", new Object[] { paramString, Util.stackTraceToString(localException) });
        AppMethodBeat.o(45413);
      }
      return null;
    }
  }
  
  public static abstract interface b<R extends AppBrandProxyUIProcessTask.ProcessResult>
  {
    public abstract void a(R paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
 * JD-Core Version:    0.7.0.1
 */