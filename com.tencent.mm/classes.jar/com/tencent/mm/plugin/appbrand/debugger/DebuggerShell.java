package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.o;
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
  private static boolean lhB;
  private static boolean lhC;
  private final Map<String, a> lhA;
  
  static
  {
    AppMethodBeat.i(44944);
    lhB = true;
    bAA();
    AppMethodBeat.o(44944);
  }
  
  public DebuggerShell()
  {
    AppMethodBeat.i(44937);
    this.lhA = new HashMap();
    AppMethodBeat.o(44937);
  }
  
  static void bAA()
  {
    AppMethodBeat.i(226505);
    lhC = false;
    Log.d("MicroMsg.DebuggerShell", "<clinit> BuildConfig.ENABLE_APPBRAND_MONKEY_TEST=%b", new Object[] { Boolean.valueOf(lhC) });
    if ((!lhC) && ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())))
    {
      lhC = MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
      Log.d("MicroMsg.DebuggerShell", "<clinit> ENABLE_MONKEY from mmkv = %b", new Object[] { Boolean.valueOf(lhC) });
    }
    if (lhC) {
      lhB = MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").getBoolean("KEY_SKIP_APPBRAND_PROCESS_SUICIDE", true);
    }
    AppMethodBeat.o(226505);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void bAB()
  {
    AppMethodBeat.i(44942);
    MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).commit();
    lhC = true;
    o.bVl();
    b.bAE();
    AppMethodBeat.o(44942);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void bAC()
  {
    AppMethodBeat.i(44943);
    MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).commit();
    lhC = false;
    AppMethodBeat.o(44943);
  }
  
  public static boolean bAx()
  {
    return lhC;
  }
  
  public static boolean bAy()
  {
    AppMethodBeat.i(44941);
    if ((lhC) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(44941);
      return true;
    }
    AppMethodBeat.o(44941);
    return false;
  }
  
  public static boolean bAz()
  {
    return lhB;
  }
  
  public static void gV(boolean paramBoolean)
  {
    AppMethodBeat.i(226504);
    lhB = paramBoolean;
    MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").putBoolean("KEY_SKIP_APPBRAND_PROCESS_SUICIDE", paramBoolean);
    b.bAE();
    AppMethodBeat.o(226504);
  }
  
  public final void aBc()
  {
    AppMethodBeat.i(44939);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.mm.appbrand.debugger");
    MMApplicationContext.getContext().registerReceiver(this, (IntentFilter)localObject);
    localObject = a.lhz.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (!Util.isNullOrNil(locala.name()))) {
        this.lhA.put(locala.name(), locala);
      }
    }
    AppMethodBeat.o(44939);
  }
  
  public final void aBd()
  {
    AppMethodBeat.i(44940);
    MMApplicationContext.getContext().unregisterReceiver(this);
    this.lhA.clear();
    AppMethodBeat.o(44940);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(44938);
    paramContext = paramIntent.getStringExtra("action");
    if ((!Util.isNullOrNil(paramContext)) && (this.lhA.containsKey(paramContext))) {
      ((a)this.lhA.get(paramContext)).A(paramIntent);
    }
    AppMethodBeat.o(44938);
  }
  
  public static abstract interface a
  {
    public abstract void A(Intent paramIntent);
    
    public abstract String name();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.DebuggerShell
 * JD-Core Version:    0.7.0.1
 */