package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.reflect.Constructor;

public abstract class AppBrandProxyUIProcessTask
  implements MMActivity.a
{
  private e mProxyUI;
  
  final void attach(e parame)
  {
    this.mProxyUI = parame;
    if ((this instanceof p)) {
      getActivityContext().getLifecycle().addObserver((p)this);
    }
  }
  
  public final void finishProcess(final AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45412);
        if (AppBrandProxyUIProcessTask.this.mProxyUI == null)
        {
          AppMethodBeat.o(45412);
          return;
        }
        AppBrandProxyUIProcessTask.this.mProxyUI.finishProcess(paramProcessResult);
        AppMethodBeat.o(45412);
      }
    });
  }
  
  public final MMActivity getActivityContext()
  {
    return this.mProxyUI.getActivityContext();
  }
  
  public AppBrandTaskProxyUI getAppBrandTaskProxyUI()
  {
    if ((this.mProxyUI instanceof AppBrandTaskProxyUI)) {
      return (AppBrandTaskProxyUI)this.mProxyUI;
    }
    return null;
  }
  
  public final String getString(int paramInt)
  {
    return MMApplicationContext.getResources().getString(paramInt);
  }
  
  protected abstract void handleRequest(ProcessRequest paramProcessRequest);
  
  public final boolean isProcessTerminated()
  {
    if (this.mProxyUI == null) {
      return true;
    }
    return this.mProxyUI.isProcessTerminated();
  }
  
  public void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected boolean onInterceptFinishActivityAction()
  {
    return false;
  }
  
  protected void onProcessInterrupted() {}
  
  protected void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  protected final void runOnUiThread(Runnable paramRunnable)
  {
    if (this.mProxyUI == null) {
      return;
    }
    this.mProxyUI.runOnUiThread(paramRunnable);
  }
  
  public final void sendResult(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    if (this.mProxyUI != null) {
      this.mProxyUI.sendResult(paramProcessResult);
    }
  }
  
  protected final void startActivity(String paramString1, String paramString2)
  {
    c.ai(getActivityContext(), paramString1, paramString2);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    getActivityContext().mmSetOnActivityResultCallback(this);
    getActivityContext().startActivityForResult(paramIntent, paramInt);
  }
  
  public final void startActivityForResult(String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    getActivityContext().mmSetOnActivityResultCallback(this);
    c.b(getActivityContext(), paramString1, paramString2, paramIntent, paramInt);
  }
  
  public static abstract class ProcessRequest
    implements Parcelable
  {
    public ProcessRequest() {}
    
    public ProcessRequest(Parcel paramParcel)
    {
      readParcel(paramParcel);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    protected int getStartActivityRequestCode()
    {
      return -1;
    }
    
    protected abstract Class<? extends AppBrandProxyUIProcessTask> getTaskClass();
    
    protected String getUIAlias()
    {
      return null;
    }
    
    protected boolean needParams()
    {
      return true;
    }
    
    protected boolean oneShotForeground()
    {
      return false;
    }
    
    protected void readParcel(Parcel paramParcel) {}
    
    protected boolean useLandscape()
    {
      return false;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
  
  static final class a
  {
    static <_Model extends AppBrandProxyUIProcessTask> _Model ZE(String paramString)
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
    public abstract void onReceiveResult(R paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
 * JD-Core Version:    0.7.0.1
 */