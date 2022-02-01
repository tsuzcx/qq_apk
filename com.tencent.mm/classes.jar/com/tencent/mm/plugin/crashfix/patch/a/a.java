package com.tencent.mm.plugin.crashfix.patch.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.crashfix.jni.BinderProxyTransactNativeHook;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.mm.plugin.crashfix.patch.a
{
  public final boolean Js(int paramInt)
  {
    AppMethodBeat.i(261587);
    Log.i("MicroMsg.BadBinderMonitor", "api level ".concat(String.valueOf(paramInt)));
    if (paramInt > 28)
    {
      AppMethodBeat.o(261587);
      return false;
    }
    paramInt = ((c)h.ax(c.class)).a(c.a.yGr, 0);
    Log.i("MicroMsg.BadBinderMonitor", "Expt : ".concat(String.valueOf(paramInt)));
    if (paramInt == 1)
    {
      AppMethodBeat.o(261587);
      return true;
    }
    AppMethodBeat.o(261587);
    return false;
  }
  
  public final long dsZ()
  {
    return 0L;
  }
  
  public final void dta()
  {
    AppMethodBeat.i(261580);
    MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix").putBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", true).commit();
    AppMethodBeat.o(261580);
  }
  
  public final boolean dtb()
  {
    AppMethodBeat.i(261584);
    boolean bool1 = MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix").getBoolean("BAD_BINDER_MONITOR_MMKV_START_BOOLEAN", false);
    boolean bool2 = MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix").getBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", false);
    Log.i("MicroMsg.BadBinderMonitor", "start ".concat(String.valueOf(bool1)));
    Log.i("MicroMsg.BadBinderMonitor", "end ".concat(String.valueOf(bool2)));
    if (bool1 == bool2)
    {
      AppMethodBeat.o(261584);
      return false;
    }
    AppMethodBeat.o(261584);
    return true;
  }
  
  public final boolean dtc()
  {
    AppMethodBeat.i(261592);
    BinderProxyTransactNativeHook.init();
    BinderProxyTransactNativeHook.calculateOffset();
    Log.i("MicroMsg.BadBinderMonitor", "init finish");
    try
    {
      Object localObject = BinderProxyTransactNativeHook.class.getMethod("calculateOffset", new Class[0]);
      BinderProxyTransactNativeHook.hook(Class.forName("android.os.BinderProxy").getMethod("transactNative", new Class[] { Integer.TYPE, Parcel.class, Parcel.class, Integer.TYPE }), (Method)localObject);
      Log.i("MicroMsg.BadBinderMonitor", "test client hook !");
      Log.i("MicroMsg.BadBinderMonitor", "test server hook !");
      localObject = new Intent();
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.gpu.service.GpuHookServiceImpl");
      MMApplicationContext.getContext().bindService((Intent)localObject, new ServiceConnection()
      {
        public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
        {
          AppMethodBeat.i(261561);
          Log.i("MicroMsg.BadBinderMonitor", "onServiceConnected");
          AppMethodBeat.o(261561);
        }
        
        public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
        {
          AppMethodBeat.i(261568);
          Log.i("MicroMsg.BadBinderMonitor", "onServiceDisconnected");
          AppMethodBeat.o(261568);
        }
      }, 1);
      Log.i("MicroMsg.BadBinderMonitor", "hook succ ?");
      AppMethodBeat.o(261592);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.BadBinderMonitor", "hook error:" + localException.getCause());
      AppMethodBeat.o(261592);
    }
    return false;
  }
  
  public final void start()
  {
    AppMethodBeat.i(261573);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix");
    localMultiProcessMMKV.putBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", false);
    localMultiProcessMMKV.putBoolean("BAD_BINDER_MONITOR_MMKV_START_BOOLEAN", true);
    localMultiProcessMMKV.commit();
    AppMethodBeat.o(261573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.patch.a.a
 * JD-Core Version:    0.7.0.1
 */