package com.tencent.map.tools.sheet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.map.tools.internal.q;
import com.tencent.map.tools.internal.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SheetNetworkStateMonitor
  extends BroadcastReceiver
{
  private final String TAG;
  private Context context;
  private boolean mStarted;
  private Handler mhandler;
  
  public SheetNetworkStateMonitor(Context paramContext)
  {
    AppMethodBeat.i(180965);
    this.TAG = SheetNetworkStateMonitor.class.getSimpleName();
    this.context = paramContext;
    AppMethodBeat.o(180965);
  }
  
  private void listenNetworkState(Handler paramHandler)
  {
    AppMethodBeat.i(180968);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      this.context.registerReceiver(this, localIntentFilter, null, paramHandler);
      AppMethodBeat.o(180968);
      return;
    }
    catch (Exception paramHandler)
    {
      AppMethodBeat.o(180968);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(180969);
    if (paramIntent == null)
    {
      AppMethodBeat.o(180969);
      return;
    }
    try
    {
      if (paramIntent.getBooleanExtra("noConnectivity", false))
      {
        q.a(this.mhandler, 10010, 0L);
        AppMethodBeat.o(180969);
        return;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(180969);
      return;
    }
    if (x.f(paramContext))
    {
      q.a(this.mhandler, 10009, 0L);
      AppMethodBeat.o(180969);
      return;
    }
    q.a(this.mhandler, 10008, 0L);
    AppMethodBeat.o(180969);
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(180967);
    if (!this.mStarted)
    {
      AppMethodBeat.o(180967);
      return;
    }
    this.mStarted = false;
    try
    {
      this.context.unregisterReceiver(this);
      AppMethodBeat.o(180967);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(180967);
    }
  }
  
  public void startup(Handler paramHandler)
  {
    AppMethodBeat.i(180966);
    if (this.mStarted)
    {
      AppMethodBeat.o(180966);
      return;
    }
    this.mStarted = true;
    this.mhandler = paramHandler;
    listenNetworkState(paramHandler);
    AppMethodBeat.o(180966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.tools.sheet.SheetNetworkStateMonitor
 * JD-Core Version:    0.7.0.1
 */