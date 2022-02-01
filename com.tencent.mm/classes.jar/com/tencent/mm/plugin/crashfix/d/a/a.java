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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.mm.plugin.crashfix.d.a
{
  public final boolean Bz(int paramInt)
  {
    AppMethodBeat.i(190280);
    ae.i("MicroMsg.BadBinderMonitor", "api level ".concat(String.valueOf(paramInt)));
    if (paramInt > 28)
    {
      AppMethodBeat.o(190280);
      return false;
    }
    paramInt = ((b)g.ab(b.class)).a(b.a.qwi, 0);
    ae.i("MicroMsg.BadBinderMonitor", "Expt : ".concat(String.valueOf(paramInt)));
    if (paramInt == 1)
    {
      AppMethodBeat.o(190280);
      return true;
    }
    AppMethodBeat.o(190280);
    return false;
  }
  
  public final void ccR()
  {
    AppMethodBeat.i(190278);
    ay.aRX("bad_binder_monitor_fix").putBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", true).commit();
    AppMethodBeat.o(190278);
  }
  
  public final boolean ccS()
  {
    AppMethodBeat.i(190279);
    boolean bool1 = ay.aRX("bad_binder_monitor_fix").getBoolean("BAD_BINDER_MONITOR_MMKV_START_BOOLEAN", false);
    boolean bool2 = ay.aRX("bad_binder_monitor_fix").getBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", false);
    ae.i("MicroMsg.BadBinderMonitor", "start ".concat(String.valueOf(bool1)));
    ae.i("MicroMsg.BadBinderMonitor", "end ".concat(String.valueOf(bool2)));
    if (bool1 == bool2)
    {
      AppMethodBeat.o(190279);
      return false;
    }
    AppMethodBeat.o(190279);
    return true;
  }
  
  public final boolean ccT()
  {
    AppMethodBeat.i(190281);
    BinderProxyTransactNativeHook.init();
    BinderProxyTransactNativeHook.calculateOffset();
    ae.i("MicroMsg.BadBinderMonitor", "init finish");
    try
    {
      Object localObject = BinderProxyTransactNativeHook.class.getMethod("calculateOffset", new Class[0]);
      BinderProxyTransactNativeHook.hook(Class.forName("android.os.BinderProxy").getMethod("transactNative", new Class[] { Integer.TYPE, Parcel.class, Parcel.class, Integer.TYPE }), (Method)localObject);
      ae.i("MicroMsg.BadBinderMonitor", "test client hook !");
      ((WifiManager)ak.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      ae.i("MicroMsg.BadBinderMonitor", "test server hook !");
      localObject = new Intent();
      ((Intent)localObject).setClassName(ak.getPackageName(), "com.tencent.mm.gpu.service.GpuHookServiceImpl");
      ak.getContext().bindService((Intent)localObject, new ServiceConnection()
      {
        public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
        {
          AppMethodBeat.i(190275);
          ae.i("MicroMsg.BadBinderMonitor", "onServiceConnected");
          AppMethodBeat.o(190275);
        }
        
        public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
        {
          AppMethodBeat.i(190276);
          ae.i("MicroMsg.BadBinderMonitor", "onServiceDisconnected");
          AppMethodBeat.o(190276);
        }
      }, 1);
      ae.i("MicroMsg.BadBinderMonitor", "hook succ ?");
      AppMethodBeat.o(190281);
      return true;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.BadBinderMonitor", "hook error:" + localException.getCause());
      AppMethodBeat.o(190281);
    }
    return false;
  }
  
  public final void start()
  {
    AppMethodBeat.i(190277);
    ay localay = ay.aRX("bad_binder_monitor_fix");
    localay.putBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", false);
    localay.putBoolean("BAD_BINDER_MONITOR_MMKV_START_BOOLEAN", true);
    localay.commit();
    AppMethodBeat.o(190277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.a.a
 * JD-Core Version:    0.7.0.1
 */