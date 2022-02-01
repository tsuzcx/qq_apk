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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.mm.plugin.crashfix.d.a
{
  public final boolean Fh(int paramInt)
  {
    AppMethodBeat.i(225324);
    Log.i("MicroMsg.BadBinderMonitor", "api level ".concat(String.valueOf(paramInt)));
    if (paramInt > 28)
    {
      AppMethodBeat.o(225324);
      return false;
    }
    paramInt = ((b)g.af(b.class)).a(b.a.rNT, 0);
    Log.i("MicroMsg.BadBinderMonitor", "Expt : ".concat(String.valueOf(paramInt)));
    if (paramInt == 1)
    {
      AppMethodBeat.o(225324);
      return true;
    }
    AppMethodBeat.o(225324);
    return false;
  }
  
  public final void cAM()
  {
    AppMethodBeat.i(225322);
    MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix").putBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", true).commit();
    AppMethodBeat.o(225322);
  }
  
  public final boolean cAN()
  {
    AppMethodBeat.i(225323);
    boolean bool1 = MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix").getBoolean("BAD_BINDER_MONITOR_MMKV_START_BOOLEAN", false);
    boolean bool2 = MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix").getBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", false);
    Log.i("MicroMsg.BadBinderMonitor", "start ".concat(String.valueOf(bool1)));
    Log.i("MicroMsg.BadBinderMonitor", "end ".concat(String.valueOf(bool2)));
    if (bool1 == bool2)
    {
      AppMethodBeat.o(225323);
      return false;
    }
    AppMethodBeat.o(225323);
    return true;
  }
  
  public final boolean cAO()
  {
    AppMethodBeat.i(225325);
    BinderProxyTransactNativeHook.init();
    BinderProxyTransactNativeHook.calculateOffset();
    Log.i("MicroMsg.BadBinderMonitor", "init finish");
    try
    {
      Object localObject = BinderProxyTransactNativeHook.class.getMethod("calculateOffset", new Class[0]);
      BinderProxyTransactNativeHook.hook(Class.forName("android.os.BinderProxy").getMethod("transactNative", new Class[] { Integer.TYPE, Parcel.class, Parcel.class, Integer.TYPE }), (Method)localObject);
      Log.i("MicroMsg.BadBinderMonitor", "test client hook !");
      ((WifiManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      Log.i("MicroMsg.BadBinderMonitor", "test server hook !");
      localObject = new Intent();
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.gpu.service.GpuHookServiceImpl");
      MMApplicationContext.getContext().bindService((Intent)localObject, new ServiceConnection()
      {
        public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
        {
          AppMethodBeat.i(225319);
          Log.i("MicroMsg.BadBinderMonitor", "onServiceConnected");
          AppMethodBeat.o(225319);
        }
        
        public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
        {
          AppMethodBeat.i(225320);
          Log.i("MicroMsg.BadBinderMonitor", "onServiceDisconnected");
          AppMethodBeat.o(225320);
        }
      }, 1);
      Log.i("MicroMsg.BadBinderMonitor", "hook succ ?");
      AppMethodBeat.o(225325);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.BadBinderMonitor", "hook error:" + localException.getCause());
      AppMethodBeat.o(225325);
    }
    return false;
  }
  
  public final void start()
  {
    AppMethodBeat.i(225321);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix");
    localMultiProcessMMKV.putBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", false);
    localMultiProcessMMKV.putBoolean("BAD_BINDER_MONITOR_MMKV_START_BOOLEAN", true);
    localMultiProcessMMKV.commit();
    AppMethodBeat.o(225321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.a.a
 * JD-Core Version:    0.7.0.1
 */