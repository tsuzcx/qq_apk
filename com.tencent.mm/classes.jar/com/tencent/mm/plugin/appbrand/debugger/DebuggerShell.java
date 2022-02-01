package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DebuggerShell
  extends BroadcastReceiver
  implements com.tencent.mm.kernel.c.a, com.tencent.mm.kernel.c.b
{
  private static boolean rdb;
  private static boolean rdc;
  private final Map<String, a> rda;
  
  static
  {
    AppMethodBeat.i(44944);
    rdb = true;
    clv();
    AppMethodBeat.o(44944);
  }
  
  public DebuggerShell()
  {
    AppMethodBeat.i(44937);
    this.rda = new HashMap();
    AppMethodBeat.o(44937);
  }
  
  public static boolean cls()
  {
    return rdc;
  }
  
  public static boolean clt()
  {
    AppMethodBeat.i(44941);
    if ((rdc) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(44941);
      return true;
    }
    AppMethodBeat.o(44941);
    return false;
  }
  
  public static boolean clu()
  {
    return rdb;
  }
  
  static void clv()
  {
    AppMethodBeat.i(319716);
    rdc = false;
    Log.d("MicroMsg.DebuggerShell", "<clinit> BuildConfig.ENABLE_APPBRAND_MONKEY_TEST=%b", new Object[] { Boolean.valueOf(rdc) });
    if ((!rdc) && ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())))
    {
      rdc = MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
      Log.d("MicroMsg.DebuggerShell", "<clinit> ENABLE_MONKEY from mmkv = %b", new Object[] { Boolean.valueOf(rdc) });
    }
    if (rdc) {
      rdb = MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").getBoolean("KEY_SKIP_APPBRAND_PROCESS_SUICIDE", true);
    }
    AppMethodBeat.o(319716);
  }
  
  public static void clw()
  {
    AppMethodBeat.i(44942);
    MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).commit();
    rdc = true;
    n.cJn();
    b.clz();
    AppMethodBeat.o(44942);
  }
  
  public static void clx()
  {
    AppMethodBeat.i(44943);
    MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).commit();
    rdc = false;
    AppMethodBeat.o(44943);
  }
  
  public static void iJ(boolean paramBoolean)
  {
    AppMethodBeat.i(319709);
    rdb = paramBoolean;
    MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").putBoolean("KEY_SKIP_APPBRAND_PROCESS_SUICIDE", paramBoolean);
    b.clz();
    AppMethodBeat.o(319709);
  }
  
  public final void bbB()
  {
    AppMethodBeat.i(44939);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.mm.appbrand.debugger");
    MMApplicationContext.getContext().registerReceiver(this, (IntentFilter)localObject);
    localObject = a.rcZ.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (!Util.isNullOrNil(locala.name()))) {
        this.rda.put(locala.name(), locala);
      }
    }
    AppMethodBeat.o(44939);
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(44940);
    MMApplicationContext.getContext().unregisterReceiver(this);
    this.rda.clear();
    AppMethodBeat.o(44940);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(44938);
    paramContext = paramIntent.getStringExtra("action");
    if ((!Util.isNullOrNil(paramContext)) && (this.rda.containsKey(paramContext))) {
      ((a)this.rda.get(paramContext)).D(paramIntent);
    }
    AppMethodBeat.o(44938);
  }
  
  public static abstract interface a
  {
    public abstract void D(Intent paramIntent);
    
    public abstract String name();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.DebuggerShell
 * JD-Core Version:    0.7.0.1
 */