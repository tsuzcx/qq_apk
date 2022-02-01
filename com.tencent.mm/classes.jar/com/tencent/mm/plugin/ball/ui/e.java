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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class e
{
  boolean htY;
  public FloatIndicatorView nHW;
  int nHX;
  int nHY;
  FrameLayout.LayoutParams nHZ;
  private com.tencent.mm.plugin.ball.a.f nHb;
  com.tencent.mm.plugin.ball.d.f nHc;
  float nHs;
  boolean nIa;
  boolean nIb;
  boolean nIc;
  long nId;
  
  public e(com.tencent.mm.plugin.ball.a.f paramf, com.tencent.mm.plugin.ball.d.f paramf1)
  {
    AppMethodBeat.i(106321);
    this.nId = -1L;
    this.nHb = paramf;
    this.nHc = paramf1;
    this.nHW = new FloatIndicatorView(this.nHb.getActivity());
    this.nHW.setOnOrientationChangedListener(new FloatIndicatorView.a()
    {
      public final void jb(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106316);
        ad.i("MicroMsg.FloatIndicatorController", "onOrientationChanged, isLandscape:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        e.this.ja(paramAnonymousBoolean);
        e.this.nHZ.bottomMargin = e.this.nHY;
        e.this.nHZ.rightMargin = e.this.nHX;
        e.this.nHW.setLayoutParams(e.this.nHZ);
        ad.i("MicroMsg.FloatIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(e.this.nHZ.rightMargin), Integer.valueOf(e.this.nHZ.bottomMargin) });
        AppMethodBeat.o(106316);
      }
    });
    if (com.tencent.mm.cc.a.ip(aj.getContext()) > com.tencent.mm.cc.a.iq(aj.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      ja(bool);
      this.nHZ = new FrameLayout.LayoutParams(-2, -2);
      this.nHZ.gravity = 8388693;
      this.nHZ.bottomMargin = this.nHY;
      this.nHZ.rightMargin = this.nHX;
      this.nHW.setLayoutParams(this.nHZ);
      ad.i("MicroMsg.FloatIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(this.nHZ.rightMargin), Integer.valueOf(this.nHZ.bottomMargin) });
      AppMethodBeat.o(106321);
      return;
    }
  }
  
  private void bLr()
  {
    AppMethodBeat.i(106328);
    ViewGroup localViewGroup;
    if (this.nHW != null)
    {
      this.nHW.setVisibility(8);
      localViewGroup = this.nHb.bJP();
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.nHW.getParent() == null)
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
          localViewGroup.addView(this.nHW, j);
          AppMethodBeat.o(106328);
          return;
        }
        ad.w("MicroMsg.FloatIndicatorController", "attachFloatIndicatorView, already attached");
        AppMethodBeat.o(106328);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.FloatIndicatorController", localException, "attachFloatIndicatorView exception:%s", new Object[] { localException });
      }
      AppMethodBeat.o(106328);
      return;
      label132:
      i += 1;
    }
  }
  
  private void bLs()
  {
    AppMethodBeat.i(106329);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106320);
        if (e.this.nHW != null) {
          try
          {
            if (e.this.nHW.getParent() != null) {
              ((ViewGroup)e.this.nHW.getParent()).removeView(e.this.nHW);
            }
            AppMethodBeat.o(106320);
            return;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.FloatIndicatorController", localException, "detachFloatIndicatorView exception:%s", new Object[] { localException });
          }
        }
        AppMethodBeat.o(106320);
      }
    });
    AppMethodBeat.o(106329);
  }
  
  final int bLp()
  {
    AppMethodBeat.i(106324);
    if (this.nHb.bJQ() >= 0)
    {
      i = this.nHb.bJQ();
      AppMethodBeat.o(106324);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.e.nIw;
    AppMethodBeat.o(106324);
    return i;
  }
  
  final void bLq()
  {
    AppMethodBeat.i(106327);
    if (!this.nIb)
    {
      AppMethodBeat.o(106327);
      return;
    }
    if (this.nHW != null)
    {
      this.nHW.setVisibility(8);
      this.nIb = false;
    }
    AppMethodBeat.o(106327);
  }
  
  final void boE()
  {
    AppMethodBeat.i(106323);
    com.tencent.mm.plugin.ball.f.e.ek(this.nHb.getActivity());
    if (this.htY)
    {
      this.nHY = (-com.tencent.mm.plugin.ball.f.e.nIr);
      this.nHX = (bLp() - com.tencent.mm.plugin.ball.f.e.nIr);
      AppMethodBeat.o(106323);
      return;
    }
    this.nHX = (-com.tencent.mm.plugin.ball.f.e.nIr);
    this.nHY = (bLp() - com.tencent.mm.plugin.ball.f.e.nIr);
    AppMethodBeat.o(106323);
  }
  
  final void ja(boolean paramBoolean)
  {
    AppMethodBeat.i(106322);
    ad.i("MicroMsg.FloatIndicatorController", "updateOrientation, isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.htY = paramBoolean;
    boE();
    AppMethodBeat.o(106322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(106325);
    ad.i("MicroMsg.FloatIndicatorController", "start FloatIndicatorController");
    bLq();
    this.nId = -1L;
    this.nIa = false;
    this.nIb = false;
    this.nIc = false;
    if (!this.nHb.bgz())
    {
      AppMethodBeat.o(106325);
      return;
    }
    this.nHb.a(new f.a()
    {
      public final void aR(float paramAnonymousFloat)
      {
        float f1 = 1.0F;
        float f2 = 0.0F;
        AppMethodBeat.i(106317);
        if (e.this.nIc)
        {
          AppMethodBeat.o(106317);
          return;
        }
        if (e.this.nId < 0L) {
          e.this.nId = bt.flT();
        }
        e locale = e.this;
        int i;
        if (((locale.nIa) || ((paramAnonymousFloat >= 0.1F) && (paramAnonymousFloat < 0.9F))) && (bt.flT() - locale.nId > 200L))
        {
          i = 1;
          if (i == 0) {
            break label348;
          }
          if (!e.this.nIb) {
            e.this.boE();
          }
          if (!e.this.nIa)
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
            i = (int)(paramAnonymousFloat * com.tencent.mm.plugin.ball.f.e.nIr);
            if (!e.this.htY) {
              break label310;
            }
            e.this.nHY = (-com.tencent.mm.plugin.ball.f.e.nIr + i);
            e.this.nHX = (i + (e.this.bLp() - com.tencent.mm.plugin.ball.f.e.nIr));
          }
        }
        for (;;)
        {
          e.this.nHZ.bottomMargin = e.this.nHY;
          e.this.nHZ.rightMargin = e.this.nHX;
          e.this.nHW.setLayoutParams(e.this.nHZ);
          locale = e.this;
          if ((!locale.nIb) && (locale.nHW != null))
          {
            locale.nHW.setVisibility(0);
            locale.nIb = true;
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
          e.this.nHX = (-com.tencent.mm.plugin.ball.f.e.nIr + i);
          e.this.nHY = (i + (e.this.bLp() - com.tencent.mm.plugin.ball.f.e.nIr));
        }
        label348:
        e.this.bLq();
        AppMethodBeat.o(106317);
      }
      
      public final int iL(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106319);
        ad.i("MicroMsg.FloatIndicatorController", "onSwipeReleased, willSwipeBack:%s, isIndicatorHit:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(e.this.nIa) });
        e.this.nId = -1L;
        e.this.nIc = paramAnonymousBoolean;
        if (!paramAnonymousBoolean)
        {
          e.this.bLq();
          e.this.nIa = false;
          AppMethodBeat.o(106319);
          return 1;
        }
        if (e.this.nIa)
        {
          e.this.bLq();
          e.this.nIa = false;
          ad.i("MicroMsg.FloatIndicatorController", "onSwipeReleased, swipe to float ball");
          int i = e.this.nHc.aS(e.this.nHs);
          if (i == 2)
          {
            e.this.nIc = false;
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
        boolean bool = e.this.nIa;
        e locale = e.this;
        if (!locale.nIb)
        {
          locale.nIa = false;
          if ((!e.this.nIb) || (e.this.nIa == bool)) {
            break label364;
          }
          if (e.this.nIa)
          {
            e.this.nHZ.bottomMargin = e.this.nHY;
            e.this.nHZ.rightMargin = e.this.nHX;
            e.this.nHW.setLayoutParams(e.this.nHZ);
            e.this.nHs = paramAnonymousMotionEvent.getRawX();
          }
          paramAnonymousMotionEvent = e.this.nHW;
          if (!e.this.nIa) {
            break label307;
          }
          if (paramAnonymousMotionEvent.nKv != null)
          {
            if (!paramAnonymousMotionEvent.nLS) {
              break label275;
            }
            paramAnonymousMotionEvent.nKv.vibrate(new long[] { 0L, 10L, 100L, 10L }, -1);
          }
          label188:
          if (!paramAnonymousMotionEvent.nLS) {
            break label288;
          }
          paramAnonymousMotionEvent.nLM.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690225));
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.nLP.isRunning()) {
            paramAnonymousMotionEvent.nLP.cancel();
          }
          if (!paramAnonymousMotionEvent.nLQ.isRunning()) {
            paramAnonymousMotionEvent.nLQ.start();
          }
          AppMethodBeat.o(106318);
          return;
          locale.nIa = d.r(locale.nHW, (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY());
          break;
          label275:
          paramAnonymousMotionEvent.nKv.vibrate(10L);
          break label188;
          label288:
          paramAnonymousMotionEvent.nLM.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690227));
        }
        label307:
        if (paramAnonymousMotionEvent.nLS) {
          paramAnonymousMotionEvent.nLM.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690224));
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.nLQ.isRunning()) {
            paramAnonymousMotionEvent.nLQ.cancel();
          }
          if (!paramAnonymousMotionEvent.nLP.isRunning()) {
            paramAnonymousMotionEvent.nLP.start();
          }
          label364:
          AppMethodBeat.o(106318);
          return;
          paramAnonymousMotionEvent.nLM.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690226));
        }
      }
    });
    bLr();
    AppMethodBeat.o(106325);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(106326);
    ad.i("MicroMsg.FloatIndicatorController", "stop FloatIndicatorController");
    bLs();
    this.nHb.a(null);
    AppMethodBeat.o(106326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.e
 * JD-Core Version:    0.7.0.1
 */