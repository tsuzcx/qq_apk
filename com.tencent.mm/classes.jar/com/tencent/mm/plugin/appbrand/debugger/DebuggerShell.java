package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DebuggerShell
  extends BroadcastReceiver
  implements com.tencent.mm.kernel.c.a, b
{
  private static boolean jgg;
  private final Map<String, a> jgf;
  
  static
  {
    AppMethodBeat.i(44944);
    jgg = false;
    ad.d("MicroMsg.DebuggerShell", "<clinit> BuildConfig.ENABLE_APPBRAND_MONKEY_TEST=%b", new Object[] { Boolean.valueOf(jgg) });
    if ((!jgg) && ((h.IS_FLAVOR_RED) || (bu.eGT())))
    {
      jgg = ax.aFC("ENABLE_APPBRAND_DEBUGGER").getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
      ad.d("MicroMsg.DebuggerShell", "<clinit> ENABLE_MONKEY from mmkv = %b", new Object[] { Boolean.valueOf(jgg) });
    }
    AppMethodBeat.o(44944);
  }
  
  public DebuggerShell()
  {
    AppMethodBeat.i(44937);
    this.jgf = new HashMap();
    AppMethodBeat.o(44937);
  }
  
  public static boolean aTY()
  {
    return jgg;
  }
  
  public static boolean aTZ()
  {
    AppMethodBeat.i(44941);
    if ((jgg) || (bu.eGT()))
    {
      AppMethodBeat.o(44941);
      return true;
    }
    AppMethodBeat.o(44941);
    return false;
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void aUa()
  {
    AppMethodBeat.i(44942);
    ax.aFC("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).commit();
    jgg = true;
    AppMethodBeat.o(44942);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void aUb()
  {
    AppMethodBeat.i(44943);
    ax.aFC("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).commit();
    jgg = false;
    AppMethodBeat.o(44943);
  }
  
  public final void agv()
  {
    AppMethodBeat.i(44939);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.mm.appbrand.debugger");
    aj.getContext().registerReceiver(this, (IntentFilter)localObject);
    localObject = a.jge.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (!bt.isNullOrNil(locala.name()))) {
        this.jgf.put(locala.name(), locala);
      }
    }
    AppMethodBeat.o(44939);
  }
  
  public final void agw()
  {
    AppMethodBeat.i(44940);
    aj.getContext().unregisterReceiver(this);
    this.jgf.clear();
    AppMethodBeat.o(44940);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(44938);
    paramContext = paramIntent.getStringExtra("action");
    if ((!bt.isNullOrNil(paramContext)) && (this.jgf.containsKey(paramContext))) {
      ((a)this.jgf.get(paramContext)).A(paramIntent);
    }
    AppMethodBeat.o(44938);
  }
  
  public static abstract interface a
  {
    public abstract void A(Intent paramIntent);
    
    public abstract String name();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.DebuggerShell
 * JD-Core Version:    0.7.0.1
 */