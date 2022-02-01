package com.tencent.mm.plugin.ball.ui;

import android.animation.Animator;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class e
{
  boolean iqo;
  private f oXA;
  com.tencent.mm.plugin.ball.d.e oXB;
  float oXQ;
  boolean oYA;
  long oYB;
  public FloatIndicatorView oYu;
  int oYv;
  int oYw;
  FrameLayout.LayoutParams oYx;
  boolean oYy;
  boolean oYz;
  
  public e(f paramf, com.tencent.mm.plugin.ball.d.e parame)
  {
    AppMethodBeat.i(106321);
    this.oYB = -1L;
    this.oXA = paramf;
    this.oXB = parame;
    this.oYu = new FloatIndicatorView(this.oXA.getActivity());
    this.oYu.setOnOrientationChangedListener(new FloatIndicatorView.a()
    {
      public final void jY(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106316);
        Log.i("MicroMsg.FloatIndicatorController", "onOrientationChanged, isLandscape:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        e.this.jX(paramAnonymousBoolean);
        e.this.oYx.bottomMargin = e.this.oYw;
        e.this.oYx.rightMargin = e.this.oYv;
        e.this.oYu.setLayoutParams(e.this.oYx);
        Log.i("MicroMsg.FloatIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(e.this.oYx.rightMargin), Integer.valueOf(e.this.oYx.bottomMargin) });
        AppMethodBeat.o(106316);
      }
    });
    if (com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()) > com.tencent.mm.cb.a.jo(MMApplicationContext.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      jX(bool);
      this.oYx = new FrameLayout.LayoutParams(-2, -2);
      this.oYx.gravity = 8388693;
      this.oYx.bottomMargin = this.oYw;
      this.oYx.rightMargin = this.oYv;
      this.oYu.setLayoutParams(this.oYx);
      Log.i("MicroMsg.FloatIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(this.oYx.rightMargin), Integer.valueOf(this.oYx.bottomMargin) });
      AppMethodBeat.o(106321);
      return;
    }
  }
  
  private void cje()
  {
    AppMethodBeat.i(106328);
    ViewGroup localViewGroup;
    if (this.oYu != null)
    {
      this.oYu.setVisibility(8);
      localViewGroup = this.oXA.chG();
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.oYu.getParent() == null)
        {
          int k = localViewGroup.getChildCount();
          i = 0;
          int j = k;
          if (i < localViewGroup.getChildCount())
          {
            if (!(localViewGroup.getChildAt(i) instanceof SwipeBackLayout)) {
              break label132;
            }
            j = i + 1;
          }
          localViewGroup.addView(this.oYu, j);
          AppMethodBeat.o(106328);
          return;
        }
        Log.w("MicroMsg.FloatIndicatorController", "attachFloatIndicatorView, already attached");
        AppMethodBeat.o(106328);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.FloatIndicatorController", localException, "attachFloatIndicatorView exception:%s", new Object[] { localException });
      }
      AppMethodBeat.o(106328);
      return;
      label132:
      i += 1;
    }
  }
  
  private void gEz()
  {
    AppMethodBeat.i(258578);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106320);
        if (e.this.oYu != null) {
          try
          {
            if (e.this.oYu.getParent() != null) {
              ((ViewGroup)e.this.oYu.getParent()).removeView(e.this.oYu);
            }
            AppMethodBeat.o(106320);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.FloatIndicatorController", localException, "detachFloatIndicatorView exception:%s", new Object[] { localException });
          }
        }
        AppMethodBeat.o(106320);
      }
    });
    AppMethodBeat.o(258578);
  }
  
  final void bKU()
  {
    AppMethodBeat.i(106323);
    com.tencent.mm.plugin.ball.f.e.eG(this.oXA.getActivity());
    if (this.iqo)
    {
      this.oYw = (-com.tencent.mm.plugin.ball.f.e.oYP);
      this.oYv = (cjc() - com.tencent.mm.plugin.ball.f.e.oYP);
      AppMethodBeat.o(106323);
      return;
    }
    this.oYv = (-com.tencent.mm.plugin.ball.f.e.oYP);
    this.oYw = (cjc() - com.tencent.mm.plugin.ball.f.e.oYP);
    AppMethodBeat.o(106323);
  }
  
  final int cjc()
  {
    AppMethodBeat.i(106324);
    if (this.oXA.chH() >= 0)
    {
      i = this.oXA.chH();
      AppMethodBeat.o(106324);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.e.oYU;
    AppMethodBeat.o(106324);
    return i;
  }
  
  final void cjd()
  {
    AppMethodBeat.i(106327);
    if (!this.oYz)
    {
      AppMethodBeat.o(106327);
      return;
    }
    if (this.oYu != null)
    {
      this.oYu.setVisibility(8);
      this.oYz = false;
    }
    AppMethodBeat.o(106327);
  }
  
  final void jX(boolean paramBoolean)
  {
    AppMethodBeat.i(106322);
    Log.i("MicroMsg.FloatIndicatorController", "updateOrientation, isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.iqo = paramBoolean;
    bKU();
    AppMethodBeat.o(106322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(106325);
    Log.i("MicroMsg.FloatIndicatorController", "start FloatIndicatorController");
    cjd();
    this.oYB = -1L;
    this.oYy = false;
    this.oYz = false;
    this.oYA = false;
    if (!this.oXA.aGg())
    {
      AppMethodBeat.o(106325);
      return;
    }
    this.oXA.a(new f.a()
    {
      public final void aY(float paramAnonymousFloat)
      {
        float f1 = 1.0F;
        float f2 = 0.0F;
        AppMethodBeat.i(106317);
        if (e.this.oYA)
        {
          AppMethodBeat.o(106317);
          return;
        }
        if (e.this.oYB < 0L) {
          e.this.oYB = Util.nowMilliSecond();
        }
        e locale = e.this;
        int i;
        if (((locale.oYy) || ((paramAnonymousFloat >= 0.1F) && (paramAnonymousFloat < 0.9F))) && (Util.nowMilliSecond() - locale.oYB > 200L))
        {
          i = 1;
          if (i == 0) {
            break label348;
          }
          if (!e.this.oYz) {
            e.this.bKU();
          }
          if (!e.this.oYy)
          {
            paramAnonymousFloat = (paramAnonymousFloat - 0.1F) / 0.3F;
            if (paramAnonymousFloat >= 0.0F) {
              break label304;
            }
            paramAnonymousFloat = f2;
            label142:
            if (paramAnonymousFloat <= 1.0F) {
              break label307;
            }
            paramAnonymousFloat = f1;
            label150:
            i = (int)(paramAnonymousFloat * com.tencent.mm.plugin.ball.f.e.oYP);
            if (!e.this.iqo) {
              break label310;
            }
            e.this.oYw = (-com.tencent.mm.plugin.ball.f.e.oYP + i);
            e.this.oYv = (i + (e.this.cjc() - com.tencent.mm.plugin.ball.f.e.oYP));
          }
        }
        for (;;)
        {
          e.this.oYx.bottomMargin = e.this.oYw;
          e.this.oYx.rightMargin = e.this.oYv;
          e.this.oYu.setLayoutParams(e.this.oYx);
          locale = e.this;
          if ((!locale.oYz) && (locale.oYu != null))
          {
            locale.oYu.setVisibility(0);
            locale.oYz = true;
          }
          AppMethodBeat.o(106317);
          return;
          i = 0;
          break;
          label304:
          break label142;
          label307:
          break label150;
          label310:
          e.this.oYv = (-com.tencent.mm.plugin.ball.f.e.oYP + i);
          e.this.oYw = (i + (e.this.cjc() - com.tencent.mm.plugin.ball.f.e.oYP));
        }
        label348:
        e.this.cjd();
        AppMethodBeat.o(106317);
      }
      
      public final int jJ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106319);
        Log.i("MicroMsg.FloatIndicatorController", "onSwipeReleased, willSwipeBack:%s, isIndicatorHit:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(e.this.oYy) });
        e.this.oYB = -1L;
        e.this.oYA = paramAnonymousBoolean;
        if (!paramAnonymousBoolean)
        {
          e.this.cjd();
          e.this.oYy = false;
          AppMethodBeat.o(106319);
          return 1;
        }
        if (e.this.oYy)
        {
          e.this.cjd();
          e.this.oYy = false;
          Log.i("MicroMsg.FloatIndicatorController", "onSwipeReleased, swipe to float ball");
          int i = e.this.oXB.aZ(e.this.oXQ);
          if (i == 2)
          {
            e.this.oYA = false;
            AppMethodBeat.o(106319);
            return 2;
          }
          AppMethodBeat.o(106319);
          return i;
        }
        AppMethodBeat.o(106319);
        return 1;
      }
      
      public final void n(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106318);
        boolean bool = e.this.oYy;
        e locale = e.this;
        if (!locale.oYz)
        {
          locale.oYy = false;
          if ((!e.this.oYz) || (e.this.oYy == bool)) {
            break label364;
          }
          if (e.this.oYy)
          {
            e.this.oYx.bottomMargin = e.this.oYw;
            e.this.oYx.rightMargin = e.this.oYv;
            e.this.oYu.setLayoutParams(e.this.oYx);
            e.this.oXQ = paramAnonymousMotionEvent.getRawX();
          }
          paramAnonymousMotionEvent = e.this.oYu;
          if (!e.this.oYy) {
            break label307;
          }
          if (paramAnonymousMotionEvent.paT != null)
          {
            if (!paramAnonymousMotionEvent.pcn) {
              break label275;
            }
            paramAnonymousMotionEvent.paT.vibrate(new long[] { 0L, 10L, 100L, 10L }, -1);
          }
          label188:
          if (!paramAnonymousMotionEvent.pcn) {
            break label288;
          }
          paramAnonymousMotionEvent.pch.setImageDrawable(com.tencent.mm.svg.a.a.h(paramAnonymousMotionEvent.getResources(), 2131690321));
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.pck.isRunning()) {
            paramAnonymousMotionEvent.pck.cancel();
          }
          if (!paramAnonymousMotionEvent.pcl.isRunning()) {
            paramAnonymousMotionEvent.pcl.start();
          }
          AppMethodBeat.o(106318);
          return;
          locale.oYy = d.q(locale.oYu, (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY());
          break;
          label275:
          paramAnonymousMotionEvent.paT.vibrate(10L);
          break label188;
          label288:
          paramAnonymousMotionEvent.pch.setImageDrawable(com.tencent.mm.svg.a.a.h(paramAnonymousMotionEvent.getResources(), 2131690323));
        }
        label307:
        if (paramAnonymousMotionEvent.pcn) {
          paramAnonymousMotionEvent.pch.setImageDrawable(com.tencent.mm.svg.a.a.h(paramAnonymousMotionEvent.getResources(), 2131690320));
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.pcl.isRunning()) {
            paramAnonymousMotionEvent.pcl.cancel();
          }
          if (!paramAnonymousMotionEvent.pck.isRunning()) {
            paramAnonymousMotionEvent.pck.start();
          }
          label364:
          AppMethodBeat.o(106318);
          return;
          paramAnonymousMotionEvent.pch.setImageDrawable(com.tencent.mm.svg.a.a.h(paramAnonymousMotionEvent.getResources(), 2131690322));
        }
      }
    });
    cje();
    AppMethodBeat.o(106325);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(258577);
    Log.i("MicroMsg.FloatIndicatorController", "stop FloatIndicatorController");
    gEz();
    this.oXA.a(null);
    AppMethodBeat.o(258577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.e
 * JD-Core Version:    0.7.0.1
 */