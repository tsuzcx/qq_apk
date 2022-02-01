package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DebuggerShell
  extends BroadcastReceiver
  implements com.tencent.mm.kernel.c.a, com.tencent.mm.kernel.c.b
{
  private static boolean kaE;
  private static boolean kaF;
  private final Map<String, a> kaD;
  
  static
  {
    AppMethodBeat.i(44944);
    kaE = true;
    bez();
    AppMethodBeat.o(44944);
  }
  
  public DebuggerShell()
  {
    AppMethodBeat.i(44937);
    this.kaD = new HashMap();
    AppMethodBeat.o(44937);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void beA()
  {
    AppMethodBeat.i(44942);
    ax.aQz("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).commit();
    kaF = true;
    n.bxZ();
    b.beD();
    AppMethodBeat.o(44942);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void beB()
  {
    AppMethodBeat.i(44943);
    ax.aQz("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).commit();
    kaF = false;
    AppMethodBeat.o(44943);
  }
  
  public static boolean bew()
  {
    return kaF;
  }
  
  public static boolean bex()
  {
    AppMethodBeat.i(44941);
    if ((kaF) || (bu.flY()))
    {
      AppMethodBeat.o(44941);
      return true;
    }
    AppMethodBeat.o(44941);
    return false;
  }
  
  public static boolean bey()
  {
    return kaE;
  }
  
  static void bez()
  {
    AppMethodBeat.i(188121);
    kaF = false;
    ad.d("MicroMsg.DebuggerShell", "<clinit> BuildConfig.ENABLE_APPBRAND_MONKEY_TEST=%b", new Object[] { Boolean.valueOf(kaF) });
    if ((!kaF) && ((i.IS_FLAVOR_RED) || (bu.flY())))
    {
      kaF = ax.aQz("ENABLE_APPBRAND_DEBUGGER").getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
      ad.d("MicroMsg.DebuggerShell", "<clinit> ENABLE_MONKEY from mmkv = %b", new Object[] { Boolean.valueOf(kaF) });
    }
    if (kaF) {
      kaE = ax.aQz("ENABLE_APPBRAND_DEBUGGER").getBoolean("KEY_SKIP_APPBRAND_PROCESS_SUICIDE", true);
    }
    AppMethodBeat.o(188121);
  }
  
  public static void fZ(boolean paramBoolean)
  {
    AppMethodBeat.i(188120);
    kaE = paramBoolean;
    ax.aQz("ENABLE_APPBRAND_DEBUGGER").putBoolean("KEY_SKIP_APPBRAND_PROCESS_SUICIDE", paramBoolean);
    b.beD();
    AppMethodBeat.o(188120);
  }
  
  public final void akx()
  {
    AppMethodBeat.i(44939);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.mm.appbrand.debugger");
    aj.getContext().registerReceiver(this, (IntentFilter)localObject);
    localObject = a.kaC.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (!bt.isNullOrNil(locala.name()))) {
        this.kaD.put(locala.name(), locala);
      }
    }
    AppMethodBeat.o(44939);
  }
  
  public final void aky()
  {
    AppMethodBeat.i(44940);
    aj.getContext().unregisterReceiver(this);
    this.kaD.clear();
    AppMethodBeat.o(44940);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(44938);
    paramContext = paramIntent.getStringExtra("action");
    if ((!bt.isNullOrNil(paramContext)) && (this.kaD.containsKey(paramContext))) {
      ((a)this.kaD.get(paramContext)).A(paramIntent);
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