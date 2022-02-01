package com.tencent.mm.plugin.ball.ui;

import android.animation.Animator;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class e
{
  boolean hbQ;
  private com.tencent.mm.plugin.ball.a.f ngF;
  com.tencent.mm.plugin.ball.d.f ngG;
  float ngW;
  public FloatIndicatorView nhA;
  int nhB;
  int nhC;
  FrameLayout.LayoutParams nhD;
  boolean nhE;
  boolean nhF;
  boolean nhG;
  long nhH;
  
  public e(com.tencent.mm.plugin.ball.a.f paramf, com.tencent.mm.plugin.ball.d.f paramf1)
  {
    AppMethodBeat.i(106321);
    this.nhH = -1L;
    this.ngF = paramf;
    this.ngG = paramf1;
    this.nhA = new FloatIndicatorView(this.ngF.getActivity());
    this.nhA.setOnOrientationChangedListener(new FloatIndicatorView.a()
    {
      public final void iS(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106316);
        ac.i("MicroMsg.FloatIndicatorController", "onOrientationChanged, isLandscape:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        e.this.iR(paramAnonymousBoolean);
        e.this.nhD.bottomMargin = e.this.nhC;
        e.this.nhD.rightMargin = e.this.nhB;
        e.this.nhA.setLayoutParams(e.this.nhD);
        ac.i("MicroMsg.FloatIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(e.this.nhD.rightMargin), Integer.valueOf(e.this.nhD.bottomMargin) });
        AppMethodBeat.o(106316);
      }
    });
    if (com.tencent.mm.cc.a.ig(ai.getContext()) > com.tencent.mm.cc.a.ih(ai.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      iR(bool);
      this.nhD = new FrameLayout.LayoutParams(-2, -2);
      this.nhD.gravity = 8388693;
      this.nhD.bottomMargin = this.nhC;
      this.nhD.rightMargin = this.nhB;
      this.nhA.setLayoutParams(this.nhD);
      ac.i("MicroMsg.FloatIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(this.nhD.rightMargin), Integer.valueOf(this.nhD.bottomMargin) });
      AppMethodBeat.o(106321);
      return;
    }
  }
  
  private void bHh()
  {
    AppMethodBeat.i(106328);
    ViewGroup localViewGroup;
    if (this.nhA != null)
    {
      this.nhA.setVisibility(8);
      localViewGroup = this.ngF.bFF();
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.nhA.getParent() == null)
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
          localViewGroup.addView(this.nhA, j);
          AppMethodBeat.o(106328);
          return;
        }
        ac.w("MicroMsg.FloatIndicatorController", "attachFloatIndicatorView, already attached");
        AppMethodBeat.o(106328);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.FloatIndicatorController", localException, "attachFloatIndicatorView exception:%s", new Object[] { localException });
      }
      AppMethodBeat.o(106328);
      return;
      label132:
      i += 1;
    }
  }
  
  private void bHi()
  {
    AppMethodBeat.i(106329);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106320);
        if (e.this.nhA != null) {
          try
          {
            if (e.this.nhA.getParent() != null) {
              ((ViewGroup)e.this.nhA.getParent()).removeView(e.this.nhA);
            }
            AppMethodBeat.o(106320);
            return;
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.FloatIndicatorController", localException, "detachFloatIndicatorView exception:%s", new Object[] { localException });
          }
        }
        AppMethodBeat.o(106320);
      }
    });
    AppMethodBeat.o(106329);
  }
  
  final int bHf()
  {
    AppMethodBeat.i(106324);
    if (this.ngF.bFG() >= 0)
    {
      i = this.ngF.bFG();
      AppMethodBeat.o(106324);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.e.nia;
    AppMethodBeat.o(106324);
    return i;
  }
  
  final void bHg()
  {
    AppMethodBeat.i(106327);
    if (!this.nhF)
    {
      AppMethodBeat.o(106327);
      return;
    }
    if (this.nhA != null)
    {
      this.nhA.setVisibility(8);
      this.nhF = false;
    }
    AppMethodBeat.o(106327);
  }
  
  final void bkT()
  {
    AppMethodBeat.i(106323);
    com.tencent.mm.plugin.ball.f.e.ek(this.ngF.getActivity());
    if (this.hbQ)
    {
      this.nhC = (-com.tencent.mm.plugin.ball.f.e.nhV);
      this.nhB = (bHf() - com.tencent.mm.plugin.ball.f.e.nhV);
      AppMethodBeat.o(106323);
      return;
    }
    this.nhB = (-com.tencent.mm.plugin.ball.f.e.nhV);
    this.nhC = (bHf() - com.tencent.mm.plugin.ball.f.e.nhV);
    AppMethodBeat.o(106323);
  }
  
  final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(106322);
    ac.i("MicroMsg.FloatIndicatorController", "updateOrientation, isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.hbQ = paramBoolean;
    bkT();
    AppMethodBeat.o(106322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(106325);
    ac.i("MicroMsg.FloatIndicatorController", "start FloatIndicatorController");
    bHg();
    this.nhH = -1L;
    this.nhE = false;
    this.nhF = false;
    this.nhG = false;
    if (!this.ngF.bcV())
    {
      AppMethodBeat.o(106325);
      return;
    }
    this.ngF.a(new f.a()
    {
      public final void aO(float paramAnonymousFloat)
      {
        float f1 = 1.0F;
        float f2 = 0.0F;
        AppMethodBeat.i(106317);
        if (e.this.nhG)
        {
          AppMethodBeat.o(106317);
          return;
        }
        if (e.this.nhH < 0L) {
          e.this.nhH = bs.eWj();
        }
        e locale = e.this;
        int i;
        if (((locale.nhE) || ((paramAnonymousFloat >= 0.1F) && (paramAnonymousFloat < 0.9F))) && (bs.eWj() - locale.nhH > 200L))
        {
          i = 1;
          if (i == 0) {
            break label348;
          }
          if (!e.this.nhF) {
            e.this.bkT();
          }
          if (!e.this.nhE)
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
            i = (int)(paramAnonymousFloat * com.tencent.mm.plugin.ball.f.e.nhV);
            if (!e.this.hbQ) {
              break label310;
            }
            e.this.nhC = (-com.tencent.mm.plugin.ball.f.e.nhV + i);
            e.this.nhB = (i + (e.this.bHf() - com.tencent.mm.plugin.ball.f.e.nhV));
          }
        }
        for (;;)
        {
          e.this.nhD.bottomMargin = e.this.nhC;
          e.this.nhD.rightMargin = e.this.nhB;
          e.this.nhA.setLayoutParams(e.this.nhD);
          locale = e.this;
          if ((!locale.nhF) && (locale.nhA != null))
          {
            locale.nhA.setVisibility(0);
            locale.nhF = true;
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
          e.this.nhB = (-com.tencent.mm.plugin.ball.f.e.nhV + i);
          e.this.nhC = (i + (e.this.bHf() - com.tencent.mm.plugin.ball.f.e.nhV));
        }
        label348:
        e.this.bHg();
        AppMethodBeat.o(106317);
      }
      
      public final int iC(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106319);
        ac.i("MicroMsg.FloatIndicatorController", "onSwipeReleased, willSwipeBack:%s, isIndicatorHit:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(e.this.nhE) });
        e.this.nhH = -1L;
        e.this.nhG = paramAnonymousBoolean;
        if (!paramAnonymousBoolean)
        {
          e.this.bHg();
          e.this.nhE = false;
          AppMethodBeat.o(106319);
          return 1;
        }
        if (e.this.nhE)
        {
          e.this.bHg();
          e.this.nhE = false;
          ac.i("MicroMsg.FloatIndicatorController", "onSwipeReleased, swipe to float ball");
          int i = e.this.ngG.aP(e.this.ngW);
          if (i == 2)
          {
            e.this.nhG = false;
            AppMethodBeat.o(106319);
            return 2;
          }
          AppMethodBeat.o(106319);
          return i;
        }
        AppMethodBeat.o(106319);
        return 1;
      }
      
      public final void k(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106318);
        boolean bool = e.this.nhE;
        e locale = e.this;
        if (!locale.nhF)
        {
          locale.nhE = false;
          if ((!e.this.nhF) || (e.this.nhE == bool)) {
            break label364;
          }
          if (e.this.nhE)
          {
            e.this.nhD.bottomMargin = e.this.nhC;
            e.this.nhD.rightMargin = e.this.nhB;
            e.this.nhA.setLayoutParams(e.this.nhD);
            e.this.ngW = paramAnonymousMotionEvent.getRawX();
          }
          paramAnonymousMotionEvent = e.this.nhA;
          if (!e.this.nhE) {
            break label307;
          }
          if (paramAnonymousMotionEvent.njY != null)
          {
            if (!paramAnonymousMotionEvent.nll) {
              break label275;
            }
            paramAnonymousMotionEvent.njY.vibrate(new long[] { 0L, 10L, 100L, 10L }, -1);
          }
          label188:
          if (!paramAnonymousMotionEvent.nll) {
            break label288;
          }
          paramAnonymousMotionEvent.nlf.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690225));
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.nli.isRunning()) {
            paramAnonymousMotionEvent.nli.cancel();
          }
          if (!paramAnonymousMotionEvent.nlj.isRunning()) {
            paramAnonymousMotionEvent.nlj.start();
          }
          AppMethodBeat.o(106318);
          return;
          locale.nhE = d.r(locale.nhA, (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY());
          break;
          label275:
          paramAnonymousMotionEvent.njY.vibrate(10L);
          break label188;
          label288:
          paramAnonymousMotionEvent.nlf.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690227));
        }
        label307:
        if (paramAnonymousMotionEvent.nll) {
          paramAnonymousMotionEvent.nlf.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690224));
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.nlj.isRunning()) {
            paramAnonymousMotionEvent.nlj.cancel();
          }
          if (!paramAnonymousMotionEvent.nli.isRunning()) {
            paramAnonymousMotionEvent.nli.start();
          }
          label364:
          AppMethodBeat.o(106318);
          return;
          paramAnonymousMotionEvent.nlf.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690226));
        }
      }
    });
    bHh();
    AppMethodBeat.o(106325);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(106326);
    ac.i("MicroMsg.FloatIndicatorController", "stop FloatIndicatorController");
    bHi();
    this.ngF.a(null);
    AppMethodBeat.o(106326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.e
 * JD-Core Version:    0.7.0.1
 */