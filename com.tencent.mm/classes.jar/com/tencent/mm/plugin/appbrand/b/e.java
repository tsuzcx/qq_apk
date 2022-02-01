package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

public abstract class e
{
  private final WeakReference<Activity> jrI;
  public final BroadcastReceiver receiver = new BroadcastReceiver()
  {
    final String jrJ = "reason";
    final String jrK = "homekey";
    final String jrL = "recentapps";
    
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
          ac.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", new Object[] { paramAnonymousIntent.getAction(), paramAnonymousContext });
          if (paramAnonymousContext.equals("homekey"))
          {
            e.this.aXM();
            AppMethodBeat.o(139837);
            return;
          }
          if (paramAnonymousContext.equals("recentapps")) {
            e.this.aXN();
          }
        }
      }
      AppMethodBeat.o(139837);
    }
  };
  
  public e(Activity paramActivity)
  {
    this.jrI = new WeakReference(paramActivity);
  }
  
  protected abstract void aXM();
  
  protected abstract void aXN();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.e
 * JD-Core Version:    0.7.0.1
 */