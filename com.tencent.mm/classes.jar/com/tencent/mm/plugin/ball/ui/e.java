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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class e
{
  boolean hwM;
  private f nME;
  com.tencent.mm.plugin.ball.d.e nMF;
  float nMU;
  int nNA;
  int nNB;
  FrameLayout.LayoutParams nNC;
  boolean nND;
  boolean nNE;
  boolean nNF;
  long nNG;
  public FloatIndicatorView nNz;
  
  public e(f paramf, com.tencent.mm.plugin.ball.d.e parame)
  {
    AppMethodBeat.i(106321);
    this.nNG = -1L;
    this.nME = paramf;
    this.nMF = parame;
    this.nNz = new FloatIndicatorView(this.nME.getActivity());
    this.nNz.setOnOrientationChangedListener(new FloatIndicatorView.a()
    {
      public final void ja(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106316);
        ae.i("MicroMsg.FloatIndicatorController", "onOrientationChanged, isLandscape:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        e.this.iZ(paramAnonymousBoolean);
        e.this.nNC.bottomMargin = e.this.nNB;
        e.this.nNC.rightMargin = e.this.nNA;
        e.this.nNz.setLayoutParams(e.this.nNC);
        ae.i("MicroMsg.FloatIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(e.this.nNC.rightMargin), Integer.valueOf(e.this.nNC.bottomMargin) });
        AppMethodBeat.o(106316);
      }
    });
    if (com.tencent.mm.cb.a.iu(ak.getContext()) > com.tencent.mm.cb.a.iv(ak.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      iZ(bool);
      this.nNC = new FrameLayout.LayoutParams(-2, -2);
      this.nNC.gravity = 8388693;
      this.nNC.bottomMargin = this.nNB;
      this.nNC.rightMargin = this.nNA;
      this.nNz.setLayoutParams(this.nNC);
      ae.i("MicroMsg.FloatIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(this.nNC.rightMargin), Integer.valueOf(this.nNC.bottomMargin) });
      AppMethodBeat.o(106321);
      return;
    }
  }
  
  private void bMo()
  {
    AppMethodBeat.i(106328);
    ViewGroup localViewGroup;
    if (this.nNz != null)
    {
      this.nNz.setVisibility(8);
      localViewGroup = this.nME.bKN();
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.nNz.getParent() == null)
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
          localViewGroup.addView(this.nNz, j);
          AppMethodBeat.o(106328);
          return;
        }
        ae.w("MicroMsg.FloatIndicatorController", "attachFloatIndicatorView, already attached");
        AppMethodBeat.o(106328);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.FloatIndicatorController", localException, "attachFloatIndicatorView exception:%s", new Object[] { localException });
      }
      AppMethodBeat.o(106328);
      return;
      label132:
      i += 1;
    }
  }
  
  private void bMp()
  {
    AppMethodBeat.i(106329);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106320);
        if (e.this.nNz != null) {
          try
          {
            if (e.this.nNz.getParent() != null) {
              ((ViewGroup)e.this.nNz.getParent()).removeView(e.this.nNz);
            }
            AppMethodBeat.o(106320);
            return;
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace("MicroMsg.FloatIndicatorController", localException, "detachFloatIndicatorView exception:%s", new Object[] { localException });
          }
        }
        AppMethodBeat.o(106320);
      }
    });
    AppMethodBeat.o(106329);
  }
  
  final int bMm()
  {
    AppMethodBeat.i(106324);
    if (this.nME.bKO() >= 0)
    {
      i = this.nME.bKO();
      AppMethodBeat.o(106324);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.e.nNZ;
    AppMethodBeat.o(106324);
    return i;
  }
  
  final void bMn()
  {
    AppMethodBeat.i(106327);
    if (!this.nNE)
    {
      AppMethodBeat.o(106327);
      return;
    }
    if (this.nNz != null)
    {
      this.nNz.setVisibility(8);
      this.nNE = false;
    }
    AppMethodBeat.o(106327);
  }
  
  final void bpo()
  {
    AppMethodBeat.i(106323);
    com.tencent.mm.plugin.ball.f.e.eo(this.nME.getActivity());
    if (this.hwM)
    {
      this.nNB = (-com.tencent.mm.plugin.ball.f.e.nNU);
      this.nNA = (bMm() - com.tencent.mm.plugin.ball.f.e.nNU);
      AppMethodBeat.o(106323);
      return;
    }
    this.nNA = (-com.tencent.mm.plugin.ball.f.e.nNU);
    this.nNB = (bMm() - com.tencent.mm.plugin.ball.f.e.nNU);
    AppMethodBeat.o(106323);
  }
  
  final void iZ(boolean paramBoolean)
  {
    AppMethodBeat.i(106322);
    ae.i("MicroMsg.FloatIndicatorController", "updateOrientation, isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.hwM = paramBoolean;
    bpo();
    AppMethodBeat.o(106322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(106325);
    ae.i("MicroMsg.FloatIndicatorController", "start FloatIndicatorController");
    bMn();
    this.nNG = -1L;
    this.nND = false;
    this.nNE = false;
    this.nNF = false;
    if (!this.nME.bhh())
    {
      AppMethodBeat.o(106325);
      return;
    }
    this.nME.a(new f.a()
    {
      public final void aR(float paramAnonymousFloat)
      {
        float f1 = 1.0F;
        float f2 = 0.0F;
        AppMethodBeat.i(106317);
        if (e.this.nNF)
        {
          AppMethodBeat.o(106317);
          return;
        }
        if (e.this.nNG < 0L) {
          e.this.nNG = bu.fpO();
        }
        e locale = e.this;
        int i;
        if (((locale.nND) || ((paramAnonymousFloat >= 0.1F) && (paramAnonymousFloat < 0.9F))) && (bu.fpO() - locale.nNG > 200L))
        {
          i = 1;
          if (i == 0) {
            break label348;
          }
          if (!e.this.nNE) {
            e.this.bpo();
          }
          if (!e.this.nND)
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
            i = (int)(paramAnonymousFloat * com.tencent.mm.plugin.ball.f.e.nNU);
            if (!e.this.hwM) {
              break label310;
            }
            e.this.nNB = (-com.tencent.mm.plugin.ball.f.e.nNU + i);
            e.this.nNA = (i + (e.this.bMm() - com.tencent.mm.plugin.ball.f.e.nNU));
          }
        }
        for (;;)
        {
          e.this.nNC.bottomMargin = e.this.nNB;
          e.this.nNC.rightMargin = e.this.nNA;
          e.this.nNz.setLayoutParams(e.this.nNC);
          locale = e.this;
          if ((!locale.nNE) && (locale.nNz != null))
          {
            locale.nNz.setVisibility(0);
            locale.nNE = true;
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
          e.this.nNA = (-com.tencent.mm.plugin.ball.f.e.nNU + i);
          e.this.nNB = (i + (e.this.bMm() - com.tencent.mm.plugin.ball.f.e.nNU));
        }
        label348:
        e.this.bMn();
        AppMethodBeat.o(106317);
      }
      
      public final int iJ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106319);
        ae.i("MicroMsg.FloatIndicatorController", "onSwipeReleased, willSwipeBack:%s, isIndicatorHit:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(e.this.nND) });
        e.this.nNG = -1L;
        e.this.nNF = paramAnonymousBoolean;
        if (!paramAnonymousBoolean)
        {
          e.this.bMn();
          e.this.nND = false;
          AppMethodBeat.o(106319);
          return 1;
        }
        if (e.this.nND)
        {
          e.this.bMn();
          e.this.nND = false;
          ae.i("MicroMsg.FloatIndicatorController", "onSwipeReleased, swipe to float ball");
          int i = e.this.nMF.aS(e.this.nMU);
          if (i == 2)
          {
            e.this.nNF = false;
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
        boolean bool = e.this.nND;
        e locale = e.this;
        if (!locale.nNE)
        {
          locale.nND = false;
          if ((!e.this.nNE) || (e.this.nND == bool)) {
            break label364;
          }
          if (e.this.nND)
          {
            e.this.nNC.bottomMargin = e.this.nNB;
            e.this.nNC.rightMargin = e.this.nNA;
            e.this.nNz.setLayoutParams(e.this.nNC);
            e.this.nMU = paramAnonymousMotionEvent.getRawX();
          }
          paramAnonymousMotionEvent = e.this.nNz;
          if (!e.this.nND) {
            break label307;
          }
          if (paramAnonymousMotionEvent.nQa != null)
          {
            if (!paramAnonymousMotionEvent.nRx) {
              break label275;
            }
            paramAnonymousMotionEvent.nQa.vibrate(new long[] { 0L, 10L, 100L, 10L }, -1);
          }
          label188:
          if (!paramAnonymousMotionEvent.nRx) {
            break label288;
          }
          paramAnonymousMotionEvent.nRr.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690225));
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.nRu.isRunning()) {
            paramAnonymousMotionEvent.nRu.cancel();
          }
          if (!paramAnonymousMotionEvent.nRv.isRunning()) {
            paramAnonymousMotionEvent.nRv.start();
          }
          AppMethodBeat.o(106318);
          return;
          locale.nND = d.q(locale.nNz, (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY());
          break;
          label275:
          paramAnonymousMotionEvent.nQa.vibrate(10L);
          break label188;
          label288:
          paramAnonymousMotionEvent.nRr.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690227));
        }
        label307:
        if (paramAnonymousMotionEvent.nRx) {
          paramAnonymousMotionEvent.nRr.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690224));
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.nRv.isRunning()) {
            paramAnonymousMotionEvent.nRv.cancel();
          }
          if (!paramAnonymousMotionEvent.nRu.isRunning()) {
            paramAnonymousMotionEvent.nRu.start();
          }
          label364:
          AppMethodBeat.o(106318);
          return;
          paramAnonymousMotionEvent.nRr.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690226));
        }
      }
    });
    bMo();
    AppMethodBeat.o(106325);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(106326);
    ae.i("MicroMsg.FloatIndicatorController", "stop FloatIndicatorController");
    bMp();
    this.nME.a(null);
    AppMethodBeat.o(106326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.e
 * JD-Core Version:    0.7.0.1
 */