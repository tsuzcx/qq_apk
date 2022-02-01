package com.tencent.mm.plugin.appbrand.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public abstract class e
{
  private final WeakReference<Activity> kRw;
  public final BroadcastReceiver receiver = new BroadcastReceiver()
  {
    final String kRx = "reason";
    final String kRy = "homekey";
    final String kRz = "recentapps";
    
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      AppMethodBeat.i(139837);
      if (paramAnonymousIntent == null)
      {
        AppMethodBeat.o(139837);
        return;
      }
      if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramAnonymousIntent.getAction()))
      {
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("reason");
        if (paramAnonymousContext != null)
        {
          Log.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", new Object[] { paramAnonymousIntent.getAction(), paramAnonymousContext });
          if (paramAnonymousContext.equals("homekey"))
          {
            e.this.bxc();
            AppMethodBeat.o(139837);
            return;
          }
          if (paramAnonymousContext.equals("recentapps")) {
            e.this.bxd();
          }
        }
      }
      AppMethodBeat.o(139837);
    }
  };
  
  public e(Activity paramActivity)
  {
    this.kRw = new WeakReference(paramActivity);
  }
  
  protected abstract void bxc();
  
  protected abstract void bxd();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.e
 * JD-Core Version:    0.7.0.1
 */