package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
  implements q
{
  private static final aa bHY;
  int bHR;
  int bHS;
  boolean bHT;
  boolean bHU;
  final s bHV;
  Runnable bHW;
  ab.a bHX;
  Handler mHandler;
  
  static
  {
    AppMethodBeat.i(194470);
    bHY = new aa();
    AppMethodBeat.o(194470);
  }
  
  private aa()
  {
    AppMethodBeat.i(194463);
    this.bHR = 0;
    this.bHS = 0;
    this.bHT = true;
    this.bHU = true;
    this.bHV = new s(this);
    this.bHW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194354);
        aa localaa = aa.this;
        if (localaa.bHS == 0)
        {
          localaa.bHT = true;
          localaa.bHV.a(j.a.ON_PAUSE);
        }
        aa.this.Hp();
        AppMethodBeat.o(194354);
      }
    };
    this.bHX = new ab.a()
    {
      public final void onResume()
      {
        AppMethodBeat.i(194394);
        aa localaa = aa.this;
        localaa.bHS += 1;
        if (localaa.bHS == 1)
        {
          if (localaa.bHT)
          {
            localaa.bHV.a(j.a.ON_RESUME);
            localaa.bHT = false;
            AppMethodBeat.o(194394);
            return;
          }
          localaa.mHandler.removeCallbacks(localaa.bHW);
        }
        AppMethodBeat.o(194394);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(194387);
        aa localaa = aa.this;
        localaa.bHR += 1;
        if ((localaa.bHR == 1) && (localaa.bHU))
        {
          localaa.bHV.a(j.a.ON_START);
          localaa.bHU = false;
        }
        AppMethodBeat.o(194387);
      }
    };
    AppMethodBeat.o(194463);
  }
  
  static void init(Context paramContext)
  {
    AppMethodBeat.i(194456);
    aa localaa = bHY;
    localaa.mHandler = new Handler();
    localaa.bHV.a(j.a.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new f()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(194382);
        ab.k(paramAnonymousActivity).bIc = aa.this.bHX;
        AppMethodBeat.o(194382);
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(194390);
        paramAnonymousActivity = aa.this;
        paramAnonymousActivity.bHS -= 1;
        if (paramAnonymousActivity.bHS == 0) {
          paramAnonymousActivity.mHandler.postDelayed(paramAnonymousActivity.bHW, 700L);
        }
        AppMethodBeat.o(194390);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(194396);
        paramAnonymousActivity = aa.this;
        paramAnonymousActivity.bHR -= 1;
        paramAnonymousActivity.Hp();
        AppMethodBeat.o(194396);
      }
    });
    AppMethodBeat.o(194456);
  }
  
  final void Hp()
  {
    AppMethodBeat.i(194479);
    if ((this.bHR == 0) && (this.bHT))
    {
      this.bHV.a(j.a.ON_STOP);
      this.bHU = true;
    }
    AppMethodBeat.o(194479);
  }
  
  public final j getLifecycle()
  {
    return this.bHV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.lifecycle.aa
 * JD-Core Version:    0.7.0.1
 */