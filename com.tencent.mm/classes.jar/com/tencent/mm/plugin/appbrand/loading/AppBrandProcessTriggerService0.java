package com.tencent.mm.plugin.appbrand.loading;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.task.preload.d;
import com.tencent.mm.plugin.appbrand.w.a.a;
import com.tencent.mm.plugin.appbrand.w.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0;", "Landroid/app/Service;", "()V", "callback", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;)V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "onBind", "Landroid/os/IBinder;", "onCreate", "", "onDestroy", "onRebind", "onStartCommand", "", "flags", "startId", "onUnbind", "", "AppBrandTriggerBinder", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    s.u(paramIntent, "intent");
    this.intent = paramIntent;
    paramIntent = (IBinder)new a();
    AppMethodBeat.o(50827);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(50829);
    super.onCreate();
    AppMethodBeat.o(50829);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(50832);
    super.onDestroy();
    AppMethodBeat.o(50832);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(50828);
    super.onRebind(paramIntent);
    AppMethodBeat.o(50828);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 3;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(50830);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0$AppBrandTriggerBinder;", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCall$Stub;", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0;)V", "registerInvokeCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "request", "", "requestCode", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends a.a
  {
    public a()
    {
      AppMethodBeat.i(317016);
      AppMethodBeat.o(317016);
    }
    
    private static final void f(IPCVoid paramIPCVoid) {}
    
    public final int Cd(int paramInt)
    {
      AppMethodBeat.i(317028);
      switch (paramInt)
      {
      case 1: 
      default: 
        AppMethodBeat.o(317028);
        return -1;
      case 0: 
        AppMethodBeat.o(317028);
        return 1;
      }
      new d();
      d.a(this.tfq.getIntent(), AppBrandProcessTriggerService0.a..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(317028);
      return 1;
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(317026);
      this.tfq.setCallback(paramb);
      if (paramb != null) {
        paramb.y((IBinder)this);
      }
      AppMethodBeat.o(317026);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0
 * JD-Core Version:    0.7.0.1
 */