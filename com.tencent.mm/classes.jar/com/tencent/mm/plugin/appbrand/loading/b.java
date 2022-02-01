package com.tencent.mm.plugin.appbrand.loading;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.q;
import d.l;
import d.z;
import junit.framework.Assert;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "Landroid/content/ServiceConnection;", "pendingIntentKey", "", "TAG", "", "onProgressLoadSuccess", "Lkotlin/Function0;", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getTAG", "()Ljava/lang/String;", "getOnProgressLoadSuccess", "()Lkotlin/jvm/functions/Function0;", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "plugin-appbrand-integration_release"})
public final class b
  implements ServiceConnection
{
  private final String TAG;
  private final int lSl;
  private final d.g.a.a<z> lSt;
  
  public b(int paramInt, String paramString, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(50822);
    this.lSl = paramInt;
    this.TAG = paramString;
    this.lSt = parama;
    if (j.IS_FLAVOR_RED) {
      if (this.lSl <= 0) {
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
    ae.i(this.TAG, "onServiceConnected: name = ".concat(String.valueOf(paramComponentName)));
    paramComponentName = a.a.s(paramIBinder);
    try
    {
      if (paramComponentName.ux(0) == 1)
      {
        this.lSt.invoke();
        ae.i(this.TAG, "onServiceConnected: IPC_TRIGGER_PROGRESS_SUCCESS");
        AppMethodBeat.o(50821);
        return;
      }
    }
    catch (Exception paramComponentName)
    {
      ae.e(this.TAG, "onServiceConnected: ", new Object[] { paramComponentName });
      c.lSy.uA(this.lSl);
      AppMethodBeat.o(50821);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(50820);
    ae.i(this.TAG, "disconnected");
    AppMethodBeat.o(50820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.b
 * JD-Core Version:    0.7.0.1
 */