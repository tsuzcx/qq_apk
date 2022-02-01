package com.tencent.mm.plugin.appbrand.loading;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.t.a.a;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.plugin.appbrand.task.preload.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0;", "Landroid/app/Service;", "()V", "callback", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;)V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "onBind", "Landroid/os/IBinder;", "onCreate", "", "onDestroy", "onRebind", "onStartCommand", "", "flags", "startId", "onUnbind", "", "AppBrandTriggerBinder", "Companion", "plugin-appbrand-integration_release"})
@Keep
public class AppBrandProcessTriggerService0
  extends Service
{
  public static final b Companion;
  public static final int IPC_TRIGGER_PRELOAD = 2;
  private static final String TAG = "MicroMsg.AppBrand.AppBrandProcessTriggerService";
  private b callback;
  private Intent intent;
  
  static
  {
    AppMethodBeat.i(50833);
    Companion = new b((byte)0);
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
    k.h(paramIntent, "intent");
    ad.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "onBind: " + paramIntent.getPackage());
    this.intent = paramIntent;
    paramIntent = (IBinder)new a();
    AppMethodBeat.o(50827);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(50829);
    super.onCreate();
    ad.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "onCreate: ");
    AppMethodBeat.o(50829);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(50832);
    super.onDestroy();
    ad.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "onDestroy: ");
    AppMethodBeat.o(50832);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(50828);
    super.onRebind(paramIntent);
    ad.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "onRebind: ");
    AppMethodBeat.o(50828);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 3;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(50830);
    ad.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "onUnbind: ");
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0$AppBrandTriggerBinder;", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCall$Stub;", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0;)V", "registerInvokeCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "request", "", "requestCode", "plugin-appbrand-integration_release"})
  public final class a
    extends a.a
  {
    public final void a(b paramb)
    {
      AppMethodBeat.i(196405);
      this.kOX.setCallback(paramb);
      if (paramb != null)
      {
        paramb.s((IBinder)this);
        AppMethodBeat.o(196405);
        return;
      }
      AppMethodBeat.o(196405);
    }
    
    public final int sW(int paramInt)
    {
      AppMethodBeat.i(196406);
      ad.i("MicroMsg.AppBrand.AppBrandProcessTriggerService", "request: reqCode = ".concat(String.valueOf(paramInt)));
      switch (paramInt)
      {
      case 1: 
      default: 
        AppMethodBeat.o(196406);
        return -1;
      case 0: 
        AppMethodBeat.o(196406);
        return 1;
      }
      new c();
      c.a(this.kOX.getIntent(), (d)a.kOY);
      AppMethodBeat.o(196406);
      return 1;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class a<T>
      implements d<IPCVoid>
    {
      public static final a kOY;
      
      static
      {
        AppMethodBeat.i(196404);
        kOY = new a();
        AppMethodBeat.o(196404);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0$Companion;", "", "()V", "IPC_TRIGGER_PRELOAD", "", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0
 * JD-Core Version:    0.7.0.1
 */