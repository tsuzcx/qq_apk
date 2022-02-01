package com.tencent.mm.plugin.appbrand.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

public abstract class e
{
  private final WeakReference<Activity> jOO;
  public final BroadcastReceiver receiver = new BroadcastReceiver()
  {
    final String jOP = "reason";
    final String jOQ = "homekey";
    final String jOR = "recentapps";
    
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
          ae.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", new Object[] { paramAnonymousIntent.getAction(), paramAnonymousContext });
          if (paramAnonymousContext.equals("homekey"))
          {
            e.this.bbM();
            AppMethodBeat.o(139837);
            return;
          }
          if (paramAnonymousContext.equals("recentapps")) {
            e.this.bbN();
          }
        }
      }
      AppMethodBeat.o(139837);
    }
  };
  
  public e(Activity paramActivity)
  {
    this.jOO = new WeakReference(paramActivity);
  }
  
  protected abstract void bbM();
  
  protected abstract void bbN();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.e
 * JD-Core Version:    0.7.0.1
 */