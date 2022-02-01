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
  boolean gBu;
  private com.tencent.mm.plugin.ball.a.f mEA;
  com.tencent.mm.plugin.ball.d.f mEB;
  float mER;
  boolean mFA;
  boolean mFB;
  long mFC;
  public FloatIndicatorView mFv;
  int mFw;
  int mFx;
  FrameLayout.LayoutParams mFy;
  boolean mFz;
  
  public e(com.tencent.mm.plugin.ball.a.f paramf, com.tencent.mm.plugin.ball.d.f paramf1)
  {
    AppMethodBeat.i(106321);
    this.mFC = -1L;
    this.mEA = paramf;
    this.mEB = paramf1;
    this.mFv = new FloatIndicatorView(this.mEA.getActivity());
    this.mFv.setOnOrientationChangedListener(new FloatIndicatorView.a()
    {
      public final void is(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106316);
        ad.i("MicroMsg.FloatIndicatorController", "onOrientationChanged, isLandscape:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        e.this.ir(paramAnonymousBoolean);
        e.this.mFy.bottomMargin = e.this.mFx;
        e.this.mFy.rightMargin = e.this.mFw;
        e.this.mFv.setLayoutParams(e.this.mFy);
        ad.i("MicroMsg.FloatIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(e.this.mFy.rightMargin), Integer.valueOf(e.this.mFy.bottomMargin) });
        AppMethodBeat.o(106316);
      }
    });
    if (com.tencent.mm.cd.a.hV(aj.getContext()) > com.tencent.mm.cd.a.hW(aj.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      ir(bool);
      this.mFy = new FrameLayout.LayoutParams(-2, -2);
      this.mFy.gravity = 8388693;
      this.mFy.bottomMargin = this.mFx;
      this.mFy.rightMargin = this.mFw;
      this.mFv.setLayoutParams(this.mFy);
      ad.i("MicroMsg.FloatIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", new Object[] { Integer.valueOf(this.mFy.rightMargin), Integer.valueOf(this.mFy.bottomMargin) });
      AppMethodBeat.o(106321);
      return;
    }
  }
  
  private void bAl()
  {
    AppMethodBeat.i(106328);
    ViewGroup localViewGroup;
    if (this.mFv != null)
    {
      this.mFv.setVisibility(8);
      localViewGroup = this.mEA.byJ();
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.mFv.getParent() == null)
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
          localViewGroup.addView(this.mFv, j);
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
  
  private void bAm()
  {
    AppMethodBeat.i(106329);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106320);
        if (e.this.mFv != null) {
          try
          {
            if (e.this.mFv.getParent() != null) {
              ((ViewGroup)e.this.mFv.getParent()).removeView(e.this.mFv);
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
  
  final int bAj()
  {
    AppMethodBeat.i(106324);
    if (this.mEA.byK() >= 0)
    {
      i = this.mEA.byK();
      AppMethodBeat.o(106324);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.e.mFV;
    AppMethodBeat.o(106324);
    return i;
  }
  
  final void bAk()
  {
    AppMethodBeat.i(106327);
    if (!this.mFA)
    {
      AppMethodBeat.o(106327);
      return;
    }
    if (this.mFv != null)
    {
      this.mFv.setVisibility(8);
      this.mFA = false;
    }
    AppMethodBeat.o(106327);
  }
  
  final void bdZ()
  {
    AppMethodBeat.i(106323);
    com.tencent.mm.plugin.ball.f.e.ec(this.mEA.getActivity());
    if (this.gBu)
    {
      this.mFx = (-com.tencent.mm.plugin.ball.f.e.mFQ);
      this.mFw = (bAj() - com.tencent.mm.plugin.ball.f.e.mFQ);
      AppMethodBeat.o(106323);
      return;
    }
    this.mFw = (-com.tencent.mm.plugin.ball.f.e.mFQ);
    this.mFx = (bAj() - com.tencent.mm.plugin.ball.f.e.mFQ);
    AppMethodBeat.o(106323);
  }
  
  final void ir(boolean paramBoolean)
  {
    AppMethodBeat.i(106322);
    ad.i("MicroMsg.FloatIndicatorController", "updateOrientation, isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gBu = paramBoolean;
    bdZ();
    AppMethodBeat.o(106322);
  }
  
  public final void start()
  {
    AppMethodBeat.i(106325);
    ad.i("MicroMsg.FloatIndicatorController", "start FloatIndicatorController");
    bAk();
    this.mFC = -1L;
    this.mFz = false;
    this.mFA = false;
    this.mFB = false;
    if (!this.mEA.aVX())
    {
      AppMethodBeat.o(106325);
      return;
    }
    this.mEA.a(new f.a()
    {
      public final void aK(float paramAnonymousFloat)
      {
        float f1 = 1.0F;
        float f2 = 0.0F;
        AppMethodBeat.i(106317);
        if (e.this.mFB)
        {
          AppMethodBeat.o(106317);
          return;
        }
        if (e.this.mFC < 0L) {
          e.this.mFC = bt.eGO();
        }
        e locale = e.this;
        int i;
        if (((locale.mFz) || ((paramAnonymousFloat >= 0.1F) && (paramAnonymousFloat < 0.9F))) && (bt.eGO() - locale.mFC > 200L))
        {
          i = 1;
          if (i == 0) {
            break label348;
          }
          if (!e.this.mFA) {
            e.this.bdZ();
          }
          if (!e.this.mFz)
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
            i = (int)(paramAnonymousFloat * com.tencent.mm.plugin.ball.f.e.mFQ);
            if (!e.this.gBu) {
              break label310;
            }
            e.this.mFx = (-com.tencent.mm.plugin.ball.f.e.mFQ + i);
            e.this.mFw = (i + (e.this.bAj() - com.tencent.mm.plugin.ball.f.e.mFQ));
          }
        }
        for (;;)
        {
          e.this.mFy.bottomMargin = e.this.mFx;
          e.this.mFy.rightMargin = e.this.mFw;
          e.this.mFv.setLayoutParams(e.this.mFy);
          locale = e.this;
          if ((!locale.mFA) && (locale.mFv != null))
          {
            locale.mFv.setVisibility(0);
            locale.mFA = true;
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
          e.this.mFw = (-com.tencent.mm.plugin.ball.f.e.mFQ + i);
          e.this.mFx = (i + (e.this.bAj() - com.tencent.mm.plugin.ball.f.e.mFQ));
        }
        label348:
        e.this.bAk();
        AppMethodBeat.o(106317);
      }
      
      public final int ic(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(106319);
        ad.i("MicroMsg.FloatIndicatorController", "onSwipeReleased, willSwipeBack:%s, isIndicatorHit:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(e.this.mFz) });
        e.this.mFC = -1L;
        e.this.mFB = paramAnonymousBoolean;
        if (!paramAnonymousBoolean)
        {
          e.this.bAk();
          e.this.mFz = false;
          AppMethodBeat.o(106319);
          return 1;
        }
        if (e.this.mFz)
        {
          e.this.bAk();
          e.this.mFz = false;
          ad.i("MicroMsg.FloatIndicatorController", "onSwipeReleased, swipe to float ball");
          int i = e.this.mEB.aL(e.this.mER);
          if (i == 2)
          {
            e.this.mFB = false;
            AppMethodBeat.o(106319);
            return 2;
          }
          AppMethodBeat.o(106319);
          return i;
        }
        AppMethodBeat.o(106319);
        return 1;
      }
      
      public final void m(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106318);
        boolean bool = e.this.mFz;
        e locale = e.this;
        if (!locale.mFA)
        {
          locale.mFz = false;
          if ((!e.this.mFA) || (e.this.mFz == bool)) {
            break label364;
          }
          if (e.this.mFz)
          {
            e.this.mFy.bottomMargin = e.this.mFx;
            e.this.mFy.rightMargin = e.this.mFw;
            e.this.mFv.setLayoutParams(e.this.mFy);
            e.this.mER = paramAnonymousMotionEvent.getRawX();
          }
          paramAnonymousMotionEvent = e.this.mFv;
          if (!e.this.mFz) {
            break label307;
          }
          if (paramAnonymousMotionEvent.mHT != null)
          {
            if (!paramAnonymousMotionEvent.mJi) {
              break label275;
            }
            paramAnonymousMotionEvent.mHT.vibrate(new long[] { 0L, 10L, 100L, 10L }, -1);
          }
          label188:
          if (!paramAnonymousMotionEvent.mJi) {
            break label288;
          }
          paramAnonymousMotionEvent.mJc.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690225));
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.mJf.isRunning()) {
            paramAnonymousMotionEvent.mJf.cancel();
          }
          if (!paramAnonymousMotionEvent.mJg.isRunning()) {
            paramAnonymousMotionEvent.mJg.start();
          }
          AppMethodBeat.o(106318);
          return;
          locale.mFz = d.r(locale.mFv, (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY());
          break;
          label275:
          paramAnonymousMotionEvent.mHT.vibrate(10L);
          break label188;
          label288:
          paramAnonymousMotionEvent.mJc.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690227));
        }
        label307:
        if (paramAnonymousMotionEvent.mJi) {
          paramAnonymousMotionEvent.mJc.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690224));
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent.mJg.isRunning()) {
            paramAnonymousMotionEvent.mJg.cancel();
          }
          if (!paramAnonymousMotionEvent.mJf.isRunning()) {
            paramAnonymousMotionEvent.mJf.start();
          }
          label364:
          AppMethodBeat.o(106318);
          return;
          paramAnonymousMotionEvent.mJc.setImageDrawable(com.tencent.mm.svg.a.a.g(paramAnonymousMotionEvent.getResources(), 2131690226));
        }
      }
    });
    bAl();
    AppMethodBeat.o(106325);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(106326);
    ad.i("MicroMsg.FloatIndicatorController", "stop FloatIndicatorController");
    bAm();
    this.mEA.a(null);
    AppMethodBeat.o(106326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.e
 * JD-Core Version:    0.7.0.1
 */