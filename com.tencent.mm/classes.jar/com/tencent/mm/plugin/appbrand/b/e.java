package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public abstract class e
{
  private final WeakReference<Activity> iRx;
  public final BroadcastReceiver receiver = new BroadcastReceiver()
  {
    final String iRA = "recentapps";
    final String iRy = "reason";
    final String iRz = "homekey";
    
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
          ad.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", new Object[] { paramAnonymousIntent.getAction(), paramAnonymousContext });
          if (paramAnonymousContext.equals("homekey"))
          {
            e.this.aQR();
            AppMethodBeat.o(139837);
            return;
          }
          if (paramAnonymousContext.equals("recentapps")) {
            e.this.aQS();
          }
        }
      }
      AppMethodBeat.o(139837);
    }
  };
  
  public e(Activity paramActivity)
  {
    this.iRx = new WeakReference(paramActivity);
  }
  
  protected abstract void aQR();
  
  protected abstract void aQS();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.e
 * JD-Core Version:    0.7.0.1
 */