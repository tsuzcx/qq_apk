package com.tencent.mm.plugin.crashfix.d.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.crashfix.jni.BinderProxyTransactNativeHook;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.mm.plugin.crashfix.d.a
{
  public final boolean Bn(int paramInt)
  {
    AppMethodBeat.i(187007);
    ad.i("MicroMsg.BadBinderMonitor", "api level ".concat(String.valueOf(paramInt)));
    if (paramInt > 28)
    {
      AppMethodBeat.o(187007);
      return false;
    }
    paramInt = ((b)g.ab(b.class)).a(b.a.qpB, 0);
    ad.i("MicroMsg.BadBinderMonitor", "Expt : ".concat(String.valueOf(paramInt)));
    if (paramInt == 1)
    {
      AppMethodBeat.o(187007);
      return true;
    }
    AppMethodBeat.o(187007);
    return false;
  }
  
  public final void cbC()
  {
    AppMethodBeat.i(187005);
    ax.aQA("bad_binder_monitor_fix").putBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", true).commit();
    AppMethodBeat.o(187005);
  }
  
  public final boolean cbD()
  {
    AppMethodBeat.i(187006);
    boolean bool1 = ax.aQA("bad_binder_monitor_fix").getBoolean("BAD_BINDER_MONITOR_MMKV_START_BOOLEAN", false);
    boolean bool2 = ax.aQA("bad_binder_monitor_fix").getBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", false);
    ad.i("MicroMsg.BadBinderMonitor", "start ".concat(String.valueOf(bool1)));
    ad.i("MicroMsg.BadBinderMonitor", "end ".concat(String.valueOf(bool2)));
    if (bool1 == bool2)
    {
      AppMethodBeat.o(187006);
      return false;
    }
    AppMethodBeat.o(187006);
    return true;
  }
  
  public final boolean cbE()
  {
    AppMethodBeat.i(187008);
    BinderProxyTransactNativeHook.init();
    BinderProxyTransactNativeHook.calculateOffset();
    ad.i("MicroMsg.BadBinderMonitor", "init finish");
    try
    {
      Object localObject = BinderProxyTransactNativeHook.class.getMethod("calculateOffset", new Class[0]);
      BinderProxyTransactNativeHook.hook(Class.forName("android.os.BinderProxy").getMethod("transactNative", new Class[] { Integer.TYPE, Parcel.class, Parcel.class, Integer.TYPE }), (Method)localObject);
      ad.i("MicroMsg.BadBinderMonitor", "test client hook !");
      ((WifiManager)aj.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      ad.i("MicroMsg.BadBinderMonitor", "test server hook !");
      localObject = new Intent();
      ((Intent)localObject).setClassName(aj.getPackageName(), "com.tencent.mm.gpu.service.GpuHookServiceImpl");
      aj.getContext().bindService((Intent)localObject, new ServiceConnection()
      {
        public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
        {
          AppMethodBeat.i(187002);
          ad.i("MicroMsg.BadBinderMonitor", "onServiceConnected");
          AppMethodBeat.o(187002);
        }
        
        public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
        {
          AppMethodBeat.i(187003);
          ad.i("MicroMsg.BadBinderMonitor", "onServiceDisconnected");
          AppMethodBeat.o(187003);
        }
      }, 1);
      ad.i("MicroMsg.BadBinderMonitor", "hook succ ?");
      AppMethodBeat.o(187008);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.BadBinderMonitor", "hook error:" + localException.getCause());
      AppMethodBeat.o(187008);
    }
    return false;
  }
  
  public final void start()
  {
    AppMethodBeat.i(187004);
    ax localax = ax.aQA("bad_binder_monitor_fix");
    localax.putBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", false);
    localax.putBoolean("BAD_BINDER_MONITOR_MMKV_START_BOOLEAN", true);
    localax.commit();
    AppMethodBeat.o(187004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.a.a
 * JD-Core Version:    0.7.0.1
 */