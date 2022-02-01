package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DebuggerShell
  extends BroadcastReceiver
  implements com.tencent.mm.kernel.c.a, b
{
  private static boolean jGv;
  private final Map<String, a> jGu;
  
  static
  {
    AppMethodBeat.i(44944);
    jGv = false;
    ac.d("MicroMsg.DebuggerShell", "<clinit> BuildConfig.ENABLE_APPBRAND_MONKEY_TEST=%b", new Object[] { Boolean.valueOf(jGv) });
    if ((!jGv) && ((h.IS_FLAVOR_RED) || (bt.eWo())))
    {
      jGv = aw.aKT("ENABLE_APPBRAND_DEBUGGER").getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
      ac.d("MicroMsg.DebuggerShell", "<clinit> ENABLE_MONKEY from mmkv = %b", new Object[] { Boolean.valueOf(jGv) });
    }
    AppMethodBeat.o(44944);
  }
  
  public DebuggerShell()
  {
    AppMethodBeat.i(44937);
    this.jGu = new HashMap();
    AppMethodBeat.o(44937);
  }
  
  public static boolean baW()
  {
    return jGv;
  }
  
  public static boolean baX()
  {
    AppMethodBeat.i(44941);
    if ((jGv) || (bt.eWo()))
    {
      AppMethodBeat.o(44941);
      return true;
    }
    AppMethodBeat.o(44941);
    return false;
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void baY()
  {
    AppMethodBeat.i(44942);
    aw.aKT("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).commit();
    jGv = true;
    AppMethodBeat.o(44942);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void baZ()
  {
    AppMethodBeat.i(44943);
    aw.aKT("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).commit();
    jGv = false;
    AppMethodBeat.o(44943);
  }
  
  public final void ahM()
  {
    AppMethodBeat.i(44939);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.mm.appbrand.debugger");
    ai.getContext().registerReceiver(this, (IntentFilter)localObject);
    localObject = a.jGt.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (!bs.isNullOrNil(locala.name()))) {
        this.jGu.put(locala.name(), locala);
      }
    }
    AppMethodBeat.o(44939);
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(44940);
    ai.getContext().unregisterReceiver(this);
    this.jGu.clear();
    AppMethodBeat.o(44940);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(44938);
    paramContext = paramIntent.getStringExtra("action");
    if ((!bs.isNullOrNil(paramContext)) && (this.jGu.containsKey(paramContext))) {
      ((a)this.jGu.get(paramContext)).A(paramIntent);
    }
    AppMethodBeat.o(44938);
  }
  
  public static abstract interface a
  {
    public abstract void A(Intent paramIntent);
    
    public abstract String name();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.DebuggerShell
 * JD-Core Version:    0.7.0.1
 */