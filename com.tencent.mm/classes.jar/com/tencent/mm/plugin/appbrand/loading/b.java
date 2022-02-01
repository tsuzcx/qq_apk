package com.tencent.mm.plugin.appbrand.loading;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w.a.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "Landroid/content/ServiceConnection;", "pendingIntentKey", "", "TAG", "", "onProgressLoadSuccess", "Lkotlin/Function0;", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getOnProgressLoadSuccess", "()Lkotlin/jvm/functions/Function0;", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements ServiceConnection
{
  private final String TAG;
  private final int tfj;
  private final kotlin.g.a.a<ah> tfo;
  
  public b(int paramInt, String paramString, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(50822);
    this.tfj = paramInt;
    this.tfo = parama;
    this.TAG = ("AppBrandPreLoadingServiceConnection[" + paramString + ']');
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
      if (this.tfj <= 0) {
        break label89;
      }
    }
    label89:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      AppMethodBeat.o(50822);
      return;
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(50821);
    Log.i(this.TAG, s.X("onServiceConnected: name = ", paramComponentName));
    paramComponentName = a.a.x(paramIBinder);
    try
    {
      if (paramComponentName.Cd(0) == 1)
      {
        this.tfo.invoke();
        Log.i(this.TAG, "onServiceConnected: IPC_TRIGGER_PROGRESS_SUCCESS");
        AppMethodBeat.o(50821);
        return;
      }
    }
    catch (Exception paramComponentName)
    {
      Log.e(this.TAG, "onServiceConnected: ", new Object[] { paramComponentName });
      c.tfr.Cg(this.tfj);
      AppMethodBeat.o(50821);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(50820);
    Log.i(this.TAG, "disconnected");
    AppMethodBeat.o(50820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.b
 * JD-Core Version:    0.7.0.1
 */