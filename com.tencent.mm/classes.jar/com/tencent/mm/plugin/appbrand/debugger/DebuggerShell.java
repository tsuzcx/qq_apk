package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DebuggerShell
  extends BroadcastReceiver
  implements com.tencent.mm.kernel.c.a, b
{
  private static boolean hkZ;
  private final Map<String, DebuggerShell.a> hkY;
  
  static
  {
    AppMethodBeat.i(129939);
    hkZ = false;
    ab.d("MicroMsg.DebuggerShell", "<clinit> BuildConfig.ENABLE_APPBRAND_MONKEY_TEST=%b", new Object[] { Boolean.valueOf(hkZ) });
    if ((!hkZ) && ((f.IS_FLAVOR_RED) || (bp.dud())))
    {
      hkZ = as.apq("ENABLE_APPBRAND_DEBUGGER").getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
      ab.d("MicroMsg.DebuggerShell", "<clinit> ENABLE_MONKEY from mmkv = %b", new Object[] { Boolean.valueOf(hkZ) });
    }
    AppMethodBeat.o(129939);
  }
  
  public DebuggerShell()
  {
    AppMethodBeat.i(129932);
    this.hkY = new HashMap();
    AppMethodBeat.o(129932);
  }
  
  public static boolean ayQ()
  {
    return hkZ;
  }
  
  public static boolean ayR()
  {
    AppMethodBeat.i(129936);
    if ((hkZ) || (bp.dud()))
    {
      AppMethodBeat.o(129936);
      return true;
    }
    AppMethodBeat.o(129936);
    return false;
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void ayS()
  {
    AppMethodBeat.i(129937);
    as.apq("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).commit();
    hkZ = true;
    AppMethodBeat.o(129937);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void ayT()
  {
    AppMethodBeat.i(129938);
    as.apq("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).commit();
    hkZ = false;
    AppMethodBeat.o(129938);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(129933);
    paramContext = paramIntent.getStringExtra("action");
    if ((!bo.isNullOrNil(paramContext)) && (this.hkY.containsKey(paramContext))) {
      ((DebuggerShell.a)this.hkY.get(paramContext)).B(paramIntent);
    }
    AppMethodBeat.o(129933);
  }
  
  public final void xM()
  {
    AppMethodBeat.i(129934);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.mm.appbrand.debugger");
    ah.getContext().registerReceiver(this, (IntentFilter)localObject);
    localObject = a.hkX.iterator();
    while (((Iterator)localObject).hasNext())
    {
      DebuggerShell.a locala = (DebuggerShell.a)((Iterator)localObject).next();
      if ((locala != null) && (!bo.isNullOrNil(locala.name()))) {
        this.hkY.put(locala.name(), locala);
      }
    }
    AppMethodBeat.o(129934);
  }
  
  public final void xN()
  {
    AppMethodBeat.i(129935);
    ah.getContext().unregisterReceiver(this);
    this.hkY.clear();
    AppMethodBeat.o(129935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.DebuggerShell
 * JD-Core Version:    0.7.0.1
 */