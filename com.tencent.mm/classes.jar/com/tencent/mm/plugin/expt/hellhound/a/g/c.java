package com.tencent.mm.plugin.expt.hellhound.a.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public final class c
{
  @SuppressLint({"StaticFieldLeak"})
  public static volatile c qZJ;
  public WeakReference<Activity> mActivityRef;
  private int mScrollState;
  public com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  public final e qUj;
  public b qZI;
  public final a qZK;
  private Field qZL;
  private int qZM;
  private int qZN;
  
  @SuppressLint({"NewApi"})
  private c()
  {
    AppMethodBeat.i(169377);
    this.mScrollState = 0;
    this.qUj = new e()
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
          ad.m("HABBYGE-MALI.SnsMonitor", "SnsMonitor onScroll is NULL or finishing", new Object[0]);
          AppMethodBeat.o(169375);
          return;
        }
        c.a(c.this, localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(169375);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(169374);
        c.a(c.this, paramAnonymousViewGroup, c.Ds(paramAnonymousInt));
        AppMethodBeat.o(169374);
      }
    };
    this.qZK = new a()
    {
      public final void Dr(int paramAnonymousInt)
      {
        AppMethodBeat.i(184396);
        ad.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, smoothScrollToPositionFromTop: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (c.b(c.this) != null) {
          c.b(c.this).qTc = paramAnonymousInt;
        }
        AppMethodBeat.o(184396);
      }
      
      public final void cqI()
      {
        AppMethodBeat.i(184397);
        ad.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, scrollToTop...");
        if (c.b(c.this) != null) {
          c.b(c.this).qTc = 0;
        }
        AppMethodBeat.o(184397);
      }
      
      public final void cqJ()
      {
        AppMethodBeat.i(184398);
        if (c.b(c.this) != null) {
          c.b(c.this).kY(false);
        }
        AppMethodBeat.o(184398);
      }
      
      public final void smoothScrollToPosition(int paramAnonymousInt)
      {
        AppMethodBeat.i(184395);
        ad.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, smoothScrollToPosition: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (c.b(c.this) != null) {
          c.b(c.this).qTc = paramAnonymousInt;
        }
        AppMethodBeat.o(184395);
      }
    };
    this.qZM = 0;
    this.qZN = 0;
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(0, "16242", "1000");
    this.qZI = new b();
    try
    {
      this.qZL = AbsListView.class.getDeclaredField("mMotionY");
      this.qZL.setAccessible(true);
      AppMethodBeat.o(169377);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.SnsMonitor", localException, "SnsMonitor, crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(169377);
    }
  }
  
  public static c cqK()
  {
    AppMethodBeat.i(169376);
    if (qZJ == null) {}
    try
    {
      if (qZJ == null) {
        qZJ = new c();
      }
      c localc = qZJ;
      AppMethodBeat.o(169376);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(169376);
    }
  }
  
  private static boolean cqL()
  {
    AppMethodBeat.i(169380);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cnt()) || (!com.tencent.mm.plugin.expt.hellhound.a.cnx()))
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
      this.qZN = (((Integer)this.qZL.get(paramViewGroup)).intValue() - this.qZM);
      AppMethodBeat.o(169379);
      return;
    }
    catch (Exception paramViewGroup)
    {
      ad.printErrStackTrace("HABBYGE-MALI.SnsMonitor", paramViewGroup, "SnsMonitor, beginFlingState, crash: %s", new Object[] { paramViewGroup.getMessage() });
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
    if (cqL())
    {
      ad.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, monitor, dontNeedMonitorTimeline true !!");
      AppMethodBeat.o(169378);
      return;
    }
    ad.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169378);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().CR(700);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().CR(701);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().CR(702);
      AppMethodBeat.o(169378);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().CR(703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.g.c
 * JD-Core Version:    0.7.0.1
 */