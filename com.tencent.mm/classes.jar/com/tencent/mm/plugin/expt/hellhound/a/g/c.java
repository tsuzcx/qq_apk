package com.tencent.mm.plugin.expt.hellhound.a.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public final class c
{
  @SuppressLint({"StaticFieldLeak"})
  public static volatile c qqF;
  public WeakReference<Activity> mActivityRef;
  private int mScrollState;
  public com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  public final e qlm;
  public b qqE;
  public final a qqG;
  private Field qqH;
  private int qqI;
  private int qqJ;
  
  @SuppressLint({"NewApi"})
  private c()
  {
    AppMethodBeat.i(169377);
    this.mScrollState = 0;
    this.qlm = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(169375);
        if (c.a(c.this) == null)
        {
          AppMethodBeat.o(169375);
          return;
        }
        Activity localActivity = (Activity)c.a(c.this).get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ac.m("HABBYGE-MALI.SnsMonitor", "SnsMonitor onScroll is NULL or finishing", new Object[0]);
          AppMethodBeat.o(169375);
          return;
        }
        c.a(c.this, localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(169375);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(169374);
        c.a(c.this, paramAnonymousViewGroup, c.CF(paramAnonymousInt));
        AppMethodBeat.o(169374);
      }
    };
    this.qqG = new a()
    {
      public final void CE(int paramAnonymousInt)
      {
        AppMethodBeat.i(184396);
        ac.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, smoothScrollToPositionFromTop: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (c.b(c.this) != null) {
          c.b(c.this).qkg = paramAnonymousInt;
        }
        AppMethodBeat.o(184396);
      }
      
      public final void clt()
      {
        AppMethodBeat.i(184397);
        ac.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, scrollToTop...");
        if (c.b(c.this) != null) {
          c.b(c.this).qkg = 0;
        }
        AppMethodBeat.o(184397);
      }
      
      public final void clu()
      {
        AppMethodBeat.i(184398);
        if (c.b(c.this) != null) {
          c.b(c.this).kG(false);
        }
        AppMethodBeat.o(184398);
      }
      
      public final void smoothScrollToPosition(int paramAnonymousInt)
      {
        AppMethodBeat.i(184395);
        ac.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, smoothScrollToPosition: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (c.b(c.this) != null) {
          c.b(c.this).qkg = paramAnonymousInt;
        }
        AppMethodBeat.o(184395);
      }
    };
    this.qqI = 0;
    this.qqJ = 0;
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(0, "16242", "1000");
    this.qqE = new b();
    try
    {
      this.qqH = AbsListView.class.getDeclaredField("mMotionY");
      this.qqH.setAccessible(true);
      AppMethodBeat.o(169377);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("HABBYGE-MALI.SnsMonitor", localException, "SnsMonitor, crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(169377);
    }
  }
  
  public static c clv()
  {
    AppMethodBeat.i(169376);
    if (qqF == null) {}
    try
    {
      if (qqF == null) {
        qqF = new c();
      }
      c localc = qqF;
      AppMethodBeat.o(169376);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(169376);
    }
  }
  
  private static boolean clw()
  {
    AppMethodBeat.i(169380);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (!com.tencent.mm.plugin.expt.hellhound.a.ciA()))
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
      this.qqJ = (((Integer)this.qqH.get(paramViewGroup)).intValue() - this.qqI);
      AppMethodBeat.o(169379);
      return;
    }
    catch (Exception paramViewGroup)
    {
      ac.printErrStackTrace("HABBYGE-MALI.SnsMonitor", paramViewGroup, "SnsMonitor, beginFlingState, crash: %s", new Object[] { paramViewGroup.getMessage() });
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
    if (clw())
    {
      ac.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, monitor, dontNeedMonitorTimeline true !!");
      AppMethodBeat.o(169378);
      return;
    }
    ac.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169378);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().Cg(700);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().Cg(701);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().Cg(702);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().Cg(703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.g.c
 * JD-Core Version:    0.7.0.1
 */