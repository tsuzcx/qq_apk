package com.tencent.mm.plugin.expt.hellhound.ext.f;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public final class e
{
  public static volatile e zLw;
  public WeakReference<Activity> mActivityRef;
  private int mScrollState;
  public final f zEK;
  public com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  private int zLA;
  public c zLv;
  public final b zLx;
  private Field zLy;
  private int zLz;
  
  private e()
  {
    AppMethodBeat.i(169377);
    this.mScrollState = 0;
    this.zEK = new f()
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
        e.a(e.this, paramAnonymousViewGroup, e.Mb(paramAnonymousInt));
        AppMethodBeat.o(169374);
      }
    };
    this.zLx = new b()
    {
      public final void Ma(int paramAnonymousInt)
      {
        AppMethodBeat.i(184396);
        Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, smoothScrollToPositionFromTop: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (e.b(e.this) != null) {
          e.b(e.this).zDn = paramAnonymousInt;
        }
        AppMethodBeat.o(184396);
      }
      
      public final void dMB()
      {
        AppMethodBeat.i(184397);
        Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, scrollToTop...");
        if (e.b(e.this) != null) {
          e.b(e.this).zDn = 0;
        }
        AppMethodBeat.o(184397);
      }
      
      public final void dMC()
      {
        AppMethodBeat.i(184398);
        if (e.b(e.this) != null) {
          e.b(e.this).oO(false);
        }
        AppMethodBeat.o(184398);
      }
      
      public final void smoothScrollToPosition(int paramAnonymousInt)
      {
        AppMethodBeat.i(184395);
        Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, smoothScrollToPosition: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (e.b(e.this) != null) {
          e.b(e.this).zDn = paramAnonymousInt;
        }
        AppMethodBeat.o(184395);
      }
    };
    this.zLz = 0;
    this.zLA = 0;
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(0, "16242", "1000");
    this.zLv = new c();
    try
    {
      this.zLy = AbsListView.class.getDeclaredField("mMotionY");
      this.zLy.setAccessible(true);
      AppMethodBeat.o(169377);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SnsMonitor", localException, "SnsMonitor, crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(169377);
    }
  }
  
  public static e dME()
  {
    AppMethodBeat.i(169376);
    if (zLw == null) {}
    try
    {
      if (zLw == null) {
        zLw = new e();
      }
      e locale = zLw;
      AppMethodBeat.o(169376);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(169376);
    }
  }
  
  private static boolean dMF()
  {
    AppMethodBeat.i(169380);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (!com.tencent.mm.plugin.expt.hellhound.a.dIO()))
    {
      AppMethodBeat.o(169380);
      return true;
    }
    AppMethodBeat.o(169380);
    return false;
  }
  
  private void u(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(169379);
    try
    {
      this.zLA = (((Integer)this.zLy.get(paramViewGroup)).intValue() - this.zLz);
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
    if (dMF())
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
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().Lz(700);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().Lz(701);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().Lz(702);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().Lz(703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.f.e
 * JD-Core Version:    0.7.0.1
 */