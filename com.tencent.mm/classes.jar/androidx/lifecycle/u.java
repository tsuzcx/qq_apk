package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  implements l
{
  private static final u aaE;
  boolean aaA;
  final m aaB;
  Runnable aaC;
  v.a aaD;
  int aax;
  int aay;
  boolean aaz;
  Handler mHandler;
  
  static
  {
    AppMethodBeat.i(191221);
    aaE = new u();
    AppMethodBeat.o(191221);
  }
  
  private u()
  {
    AppMethodBeat.i(191217);
    this.aax = 0;
    this.aay = 0;
    this.aaz = true;
    this.aaA = true;
    this.aaB = new m(this);
    this.aaC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(191191);
        u localu = u.this;
        if (localu.aay == 0)
        {
          localu.aaz = true;
          localu.aaB.a(h.a.ON_PAUSE);
        }
        u.this.jm();
        AppMethodBeat.o(191191);
      }
    };
    this.aaD = new v.a()
    {
      public final void onResume()
      {
        AppMethodBeat.i(191201);
        u localu = u.this;
        localu.aay += 1;
        if (localu.aay == 1)
        {
          if (localu.aaz)
          {
            localu.aaB.a(h.a.ON_RESUME);
            localu.aaz = false;
            AppMethodBeat.o(191201);
            return;
          }
          localu.mHandler.removeCallbacks(localu.aaC);
        }
        AppMethodBeat.o(191201);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(191195);
        u localu = u.this;
        localu.aax += 1;
        if ((localu.aax == 1) && (localu.aaA))
        {
          localu.aaB.a(h.a.ON_START);
          localu.aaA = false;
        }
        AppMethodBeat.o(191195);
      }
    };
    AppMethodBeat.o(191217);
  }
  
  static void init(Context paramContext)
  {
    AppMethodBeat.i(191213);
    u localu = aaE;
    localu.mHandler = new Handler();
    localu.aaB.a(h.a.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new d()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(191206);
        v.i(paramAnonymousActivity).aaI = u.this.aaD;
        AppMethodBeat.o(191206);
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(191207);
        paramAnonymousActivity = u.this;
        paramAnonymousActivity.aay -= 1;
        if (paramAnonymousActivity.aay == 0) {
          paramAnonymousActivity.mHandler.postDelayed(paramAnonymousActivity.aaC, 700L);
        }
        AppMethodBeat.o(191207);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(191211);
        paramAnonymousActivity = u.this;
        paramAnonymousActivity.aax -= 1;
        paramAnonymousActivity.jm();
        AppMethodBeat.o(191211);
      }
    });
    AppMethodBeat.o(191213);
  }
  
  public final h getLifecycle()
  {
    return this.aaB;
  }
  
  final void jm()
  {
    AppMethodBeat.i(191215);
    if ((this.aax == 0) && (this.aaz))
    {
      this.aaB.a(h.a.ON_STOP);
      this.aaA = true;
    }
    AppMethodBeat.o(191215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.lifecycle.u
 * JD-Core Version:    0.7.0.1
 */