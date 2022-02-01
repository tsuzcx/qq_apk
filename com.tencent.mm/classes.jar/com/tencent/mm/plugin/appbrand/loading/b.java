package com.tencent.mm.plugin.appbrand.loading;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v.a.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.Assert;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "Landroid/content/ServiceConnection;", "pendingIntentKey", "", "TAG", "", "onProgressLoadSuccess", "Lkotlin/Function0;", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getTAG", "()Ljava/lang/String;", "getOnProgressLoadSuccess", "()Lkotlin/jvm/functions/Function0;", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "plugin-appbrand-integration_release"})
public final class b
  implements ServiceConnection
{
  private final String TAG;
  private final int mZL;
  private final kotlin.g.a.a<x> mZT;
  
  public b(int paramInt, String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(50822);
    this.mZL = paramInt;
    this.TAG = paramString;
    this.mZT = parama;
    if (BuildInfo.IS_FLAVOR_RED) {
      if (this.mZL <= 0) {
        break label63;
      }
    }
    label63:
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
    Log.i(this.TAG, "onServiceConnected: name = ".concat(String.valueOf(paramComponentName)));
    paramComponentName = a.a.s(paramIBinder);
    try
    {
      if (paramComponentName.yo(0) == 1)
      {
        this.mZT.invoke();
        Log.i(this.TAG, "onServiceConnected: IPC_TRIGGER_PROGRESS_SUCCESS");
        AppMethodBeat.o(50821);
        return;
      }
    }
    catch (Exception paramComponentName)
    {
      Log.e(this.TAG, "onServiceConnected: ", new Object[] { paramComponentName });
      c.mZY.yr(this.mZL);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.b
 * JD-Core Version:    0.7.0.1
 */