package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DebuggerShell
  extends BroadcastReceiver
  implements com.tencent.mm.kernel.c.a, com.tencent.mm.kernel.c.b
{
  private static boolean kdU;
  private static boolean kdV;
  private final Map<String, a> kdT;
  
  static
  {
    AppMethodBeat.i(44944);
    kdU = true;
    bfh();
    AppMethodBeat.o(44944);
  }
  
  public DebuggerShell()
  {
    AppMethodBeat.i(44937);
    this.kdT = new HashMap();
    AppMethodBeat.o(44937);
  }
  
  public static boolean bfe()
  {
    return kdV;
  }
  
  public static boolean bff()
  {
    AppMethodBeat.i(44941);
    if ((kdV) || (bv.fpT()))
    {
      AppMethodBeat.o(44941);
      return true;
    }
    AppMethodBeat.o(44941);
    return false;
  }
  
  public static boolean bfg()
  {
    return kdU;
  }
  
  static void bfh()
  {
    AppMethodBeat.i(222246);
    kdV = false;
    ae.d("MicroMsg.DebuggerShell", "<clinit> BuildConfig.ENABLE_APPBRAND_MONKEY_TEST=%b", new Object[] { Boolean.valueOf(kdV) });
    if ((!kdV) && ((j.IS_FLAVOR_RED) || (bv.fpT())))
    {
      kdV = ay.aRW("ENABLE_APPBRAND_DEBUGGER").getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
      ae.d("MicroMsg.DebuggerShell", "<clinit> ENABLE_MONKEY from mmkv = %b", new Object[] { Boolean.valueOf(kdV) });
    }
    if (kdV) {
      kdU = ay.aRW("ENABLE_APPBRAND_DEBUGGER").getBoolean("KEY_SKIP_APPBRAND_PROCESS_SUICIDE", true);
    }
    AppMethodBeat.o(222246);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void bfi()
  {
    AppMethodBeat.i(44942);
    ay.aRW("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).commit();
    kdV = true;
    n.byS();
    b.bfl();
    AppMethodBeat.o(44942);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void bfj()
  {
    AppMethodBeat.i(44943);
    ay.aRW("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).commit();
    kdV = false;
    AppMethodBeat.o(44943);
  }
  
  public static void fY(boolean paramBoolean)
  {
    AppMethodBeat.i(222245);
    kdU = paramBoolean;
    ay.aRW("ENABLE_APPBRAND_DEBUGGER").putBoolean("KEY_SKIP_APPBRAND_PROCESS_SUICIDE", paramBoolean);
    b.bfl();
    AppMethodBeat.o(222245);
  }
  
  public final void akM()
  {
    AppMethodBeat.i(44939);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.mm.appbrand.debugger");
    ak.getContext().registerReceiver(this, (IntentFilter)localObject);
    localObject = a.kdS.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (!bu.isNullOrNil(locala.name()))) {
        this.kdT.put(locala.name(), locala);
      }
    }
    AppMethodBeat.o(44939);
  }
  
  public final void akN()
  {
    AppMethodBeat.i(44940);
    ak.getContext().unregisterReceiver(this);
    this.kdT.clear();
    AppMethodBeat.o(44940);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(44938);
    paramContext = paramIntent.getStringExtra("action");
    if ((!bu.isNullOrNil(paramContext)) && (this.kdT.containsKey(paramContext))) {
      ((a)this.kdT.get(paramContext)).A(paramIntent);
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