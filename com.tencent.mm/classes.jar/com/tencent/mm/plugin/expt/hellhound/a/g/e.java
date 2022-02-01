package com.tencent.mm.plugin.expt.hellhound.a.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public final class e
{
  @SuppressLint({"StaticFieldLeak"})
  public static volatile e sJt;
  public WeakReference<Activity> mActivityRef;
  private int mScrollState;
  public final f sCN;
  public com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  public c sJs;
  public final b sJu;
  private Field sJv;
  private int sJw;
  private int sJx;
  
  @SuppressLint({"NewApi"})
  private e()
  {
    AppMethodBeat.i(169377);
    this.mScrollState = 0;
    this.sCN = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(169375);
        if (e.a(e.this) == null)
        {
          AppMethodBeat.o(169375);
          return;
        }
        Activity localActivity = (Activity)e.a(e.this).get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.SnsMonitor", "SnsMonitor onScroll is NULL or finishing", new Object[0]);
          AppMethodBeat.o(169375);
          return;
        }
        e.a(e.this, localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(169375);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(169374);
        e.a(e.this, paramAnonymousViewGroup, e.Hs(paramAnonymousInt));
        AppMethodBeat.o(169374);
      }
    };
    this.sJu = new b()
    {
      public final void Hr(int paramAnonymousInt)
      {
        AppMethodBeat.i(184396);
        Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, smoothScrollToPositionFromTop: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (e.b(e.this) != null) {
          e.b(e.this).sBr = paramAnonymousInt;
        }
        AppMethodBeat.o(184396);
      }
      
      public final void cQS()
      {
        AppMethodBeat.i(184397);
        Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, scrollToTop...");
        if (e.b(e.this) != null) {
          e.b(e.this).sBr = 0;
        }
        AppMethodBeat.o(184397);
      }
      
      public final void cQT()
      {
        AppMethodBeat.i(184398);
        if (e.b(e.this) != null) {
          e.b(e.this).mc(false);
        }
        AppMethodBeat.o(184398);
      }
      
      public final void smoothScrollToPosition(int paramAnonymousInt)
      {
        AppMethodBeat.i(184395);
        Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, smoothScrollToPosition: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (e.b(e.this) != null) {
          e.b(e.this).sBr = paramAnonymousInt;
        }
        AppMethodBeat.o(184395);
      }
    };
    this.sJw = 0;
    this.sJx = 0;
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(0, "16242", "1000");
    this.sJs = new c();
    try
    {
      this.sJv = AbsListView.class.getDeclaredField("mMotionY");
      this.sJv.setAccessible(true);
      AppMethodBeat.o(169377);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SnsMonitor", localException, "SnsMonitor, crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(169377);
    }
  }
  
  public static e cQV()
  {
    AppMethodBeat.i(169376);
    if (sJt == null) {}
    try
    {
      if (sJt == null) {
        sJt = new e();
      }
      e locale = sJt;
      AppMethodBeat.o(169376);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(169376);
    }
  }
  
  private static boolean cQW()
  {
    AppMethodBeat.i(169380);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (!com.tencent.mm.plugin.expt.hellhound.a.cNs()))
    {
      AppMethodBeat.o(169380);
      return true;
    }
    AppMethodBeat.o(169380);
    return false;
  }
  
  private void p(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(169379);
    try
    {
      this.sJx = (((Integer)this.sJv.get(paramViewGroup)).intValue() - this.sJw);
      AppMethodBeat.o(169379);
      return;
    }
    catch (Exception paramViewGroup)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SnsMonitor", paramViewGroup, "SnsMonitor, beginFlingState, crash: %s", new Object[] { paramViewGroup.getMessage() });
      AppMethodBeat.o(169379);
    }
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(169378);
    if (!"com.tencent.mm.plugin.sns.ui.SnsTimeLineUI".equals(paramString))
    {
      AppMethodBeat.o(169378);
      return;
    }
    if (cQW())
    {
      Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, monitor, dontNeedMonitorTimeline true !!");
      AppMethodBeat.o(169378);
      return;
    }
    Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169378);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(700);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(701);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(702);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.g.e
 * JD-Core Version:    0.7.0.1
 */