package com.tencent.mm.plugin.appbrand.loading;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v.a.a;
import com.tencent.mm.plugin.appbrand.v.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0;", "Landroid/app/Service;", "()V", "callback", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;)V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "onBind", "Landroid/os/IBinder;", "onCreate", "", "onDestroy", "onRebind", "onStartCommand", "", "flags", "startId", "onUnbind", "", "AppBrandTriggerBinder", "Companion", "plugin-appbrand-integration_release"})
@Keep
public class AppBrandProcessTriggerService0
  extends Service
{
  public static final AppBrandProcessTriggerService0.b Companion;
  public static final int IPC_TRIGGER_PRELOAD = 2;
  private static final String TAG = "MicroMsg.AppBrand.AppBrandProcessTriggerService";
  private b callback;
  private Intent intent;
  
  static
  {
    AppMethodBeat.i(50833);
    Companion = new AppBrandProcessTriggerService0.b((byte)0);
    AppMethodBeat.o(50833);
  }
  
  public final b getCallback()
  {
    return this.callback;
  }
  
  public final Intent getIntent()
  {
    return this.intent;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(50827);
    p.h(paramIntent, "intent");
    Log.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "onBind: " + paramIntent.getPackage());
    this.intent = paramIntent;
    paramIntent = (IBinder)new a();
    AppMethodBeat.o(50827);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(50829);
    super.onCreate();
    Log.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "onCreate: ");
    AppMethodBeat.o(50829);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(50832);
    super.onDestroy();
    Log.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "onDestroy: ");
    AppMethodBeat.o(50832);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(50828);
    super.onRebind(paramIntent);
    Log.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "onRebind: ");
    AppMethodBeat.o(50828);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 3;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(50830);
    Log.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "onUnbind: ");
    AppMethodBeat.o(50830);
    return true;
  }
  
  public final void setCallback(b paramb)
  {
    this.callback = paramb;
  }
  
  public final void setIntent(Intent paramIntent)
  {
    this.intent = paramIntent;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0$AppBrandTriggerBinder;", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCall$Stub;", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0;)V", "registerInvokeCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "request", "", "requestCode", "plugin-appbrand-integration_release"})
  public final class a
    extends a.a
  {
    public final void a(b paramb)
    {
      AppMethodBeat.i(228824);
      this.mZV.setCallback(paramb);
      if (paramb != null)
      {
        paramb.t((IBinder)this);
        AppMethodBeat.o(228824);
        return;
      }
      AppMethodBeat.o(228824);
    }
    
    public final int yo(int paramInt)
    {
      AppMethodBeat.i(228825);
      Log.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "request: reqCode = ".concat(String.valueOf(paramInt)));
      switch (paramInt)
      {
      case 1: 
      default: 
        AppMethodBeat.o(228825);
        return -1;
      case 0: 
        AppMethodBeat.o(228825);
        return 1;
      }
      new com.tencent.mm.plugin.appbrand.task.preload.d();
      com.tencent.mm.plugin.appbrand.task.preload.d.a(this.mZV.getIntent(), (com.tencent.mm.ipcinvoker.d)AppBrandProcessTriggerService0.a.a.mZW);
      AppMethodBeat.o(228825);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0
 * JD-Core Version:    0.7.0.1
 */