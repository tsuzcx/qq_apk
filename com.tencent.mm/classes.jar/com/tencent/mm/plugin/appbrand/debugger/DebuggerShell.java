package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.luggage.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DebuggerShell
  extends BroadcastReceiver
  implements a, b
{
  private static boolean fRC = false;
  private final Map<String, DebuggerShell.a> fRB = new HashMap();
  
  static
  {
    if ((com.tencent.mm.sdk.platformtools.d.IS_FLAVOR_RED) || (bl.csf())) {
      fRC = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "ENABLE_APPBRAND_DEBUGGER", 0).getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
    }
  }
  
  public static boolean aeu()
  {
    return fRC;
  }
  
  public static boolean aev()
  {
    return (fRC) || (bl.csf());
  }
  
  public static void aew()
  {
    MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "ENABLE_APPBRAND_DEBUGGER", 0).edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).apply();
    fRC = true;
  }
  
  public static void aex()
  {
    MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "ENABLE_APPBRAND_DEBUGGER", 0).edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).apply();
    fRC = false;
  }
  
  public final void Ey()
  {
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.mm.appbrand.debugger");
    ae.getContext().registerReceiver(this, (IntentFilter)localObject);
    localObject = ((d)e.i(d.class)).aey().iterator();
    while (((Iterator)localObject).hasNext())
    {
      DebuggerShell.a locala = (DebuggerShell.a)((Iterator)localObject).next();
      if ((locala != null) && (!bk.bl(locala.name()))) {
        this.fRB.put(locala.name(), locala);
      }
    }
  }
  
  public final void Ez()
  {
    ae.getContext().unregisterReceiver(this);
    this.fRB.clear();
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("action");
    if ((!bk.bl(paramContext)) && (this.fRB.containsKey(paramContext))) {
      ((DebuggerShell.a)this.fRB.get(paramContext)).l(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.DebuggerShell
 * JD-Core Version:    0.7.0.1
 */