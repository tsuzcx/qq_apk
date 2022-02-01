package com.tencent.mm.plugin.ball.service;

import android.app.Activity;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.plugin.ball.ui.b.1;
import com.tencent.mm.plugin.ball.ui.e;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;

public class f
  extends a
{
  public com.tencent.mm.plugin.ball.a.f mEA;
  protected com.tencent.mm.plugin.ball.d.f mEB;
  protected e mEC;
  protected com.tencent.mm.plugin.ball.ui.b mED;
  protected com.tencent.mm.plugin.ball.d.a mEE;
  
  public f(com.tencent.mm.plugin.ball.a.f paramf)
  {
    this.mEA = paramf;
  }
  
  private void bzX()
  {
    AppMethodBeat.i(106254);
    if (this.mED != null) {
      this.mED.stop();
    }
    if (aVX())
    {
      this.mEC = new e(this.mEA, this.mEB);
      this.mEC.start();
    }
    AppMethodBeat.o(106254);
  }
  
  protected static int wD(int paramInt)
  {
    int i = 6;
    if (paramInt == 1) {
      i = 4;
    }
    do
    {
      return i;
      if (paramInt == 2) {
        return 7;
      }
    } while (paramInt != 3);
    return 5;
  }
  
  public void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(106244);
    super.Z(paramInt, paramString);
    this.mEB = new com.tencent.mm.plugin.ball.d.f()
    {
      public final int aL(float paramAnonymousFloat)
      {
        AppMethodBeat.i(106242);
        ad.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, swipePosX:%s", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if (f.this.mDJ != null)
        {
          Object localObject = f.this.byO();
          if (localObject != null) {}
          for (int i = 1; ((i == 0) || (((BallInfo)localObject).mDu)) && (!f.this.bzr()); i = 0)
          {
            FloatBallProxyUI.a(f.this.mEA.getActivity(), f.this.mDH, f.this.bzm(), new FloatBallProxyUI.a()
            {
              public final void wC(int paramAnonymous2Int)
              {
                AppMethodBeat.i(106241);
                ad.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, can not add ball, callback:%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                if (paramAnonymous2Int == 1)
                {
                  ad.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, show float menu view");
                  f.this.a(f.this.mDK);
                }
                AppMethodBeat.o(106241);
              }
            });
            AppMethodBeat.o(106242);
            return 2;
          }
          if (i != 0) {
            f.this.bzz().opType = 5;
          }
          for (;;)
          {
            f.this.bzv();
            localObject = f.this.mDJ.getBallPosition();
            com.tencent.mm.plugin.ball.ui.c.a(f.this.mEA, (Point)localObject, paramAnonymousFloat, f.this.mEE);
            if (f.this.mDJ != null) {
              f.this.mDJ.setEnableClick(false);
            }
            AppMethodBeat.o(106242);
            return 3;
            f.this.bzz().mDx = 1;
          }
        }
        AppMethodBeat.o(106242);
        return 1;
      }
      
      public final void setFloatBallAlpha(float paramAnonymousFloat)
      {
        AppMethodBeat.i(106243);
        if (f.this.mDJ != null) {
          f.this.mDJ.a(f.this.mDH, paramAnonymousFloat);
        }
        AppMethodBeat.o(106243);
      }
    };
    this.mEE = new com.tencent.mm.plugin.ball.d.a()
    {
      public final void aWf()
      {
        AppMethodBeat.i(106240);
        ad.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation cancel");
        if (f.this.mDJ != null) {
          f.this.mDJ.setEnableClick(true);
        }
        f.this.mEA.fF(true);
        f.a(f.this);
        AppMethodBeat.o(106240);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(106239);
        ad.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation end");
        if (f.this.mDJ != null) {
          f.this.mDJ.setEnableClick(true);
        }
        f.this.mEA.fF(false);
        f.a(f.this);
        AppMethodBeat.o(106239);
      }
    };
    if (aVX())
    {
      paramString = bzo();
      if ((paramString != null) && (!paramString.mDu))
      {
        this.mED = new com.tencent.mm.plugin.ball.ui.b(this.mEA, this.mEB);
        paramString = this.mED;
        ad.i("MicroMsg.FloatBallFadeInController", "start FloatBallFadeInController");
        if (paramString.mEA.aVX()) {
          paramString.mEA.a(new b.1(paramString));
        }
        AppMethodBeat.o(106244);
        return;
      }
      this.mEC = new e(this.mEA, this.mEB);
      this.mEC.start();
      paramInt = ax.aFC(a.bzn()).decodeInt("ActiveCount", 0);
      ad.i("MicroMsg.PageFloatBallHelper", "onCreate, activeCount:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.mEC.mFv != null) {
        this.mEC.mFv.xm(paramInt);
      }
      AppMethodBeat.o(106244);
      return;
    }
    ad.i("MicroMsg.PageFloatBallHelper", "onCreate, do not support swipe to float ball");
    AppMethodBeat.o(106244);
  }
  
  protected void a(a parama)
  {
    AppMethodBeat.i(190649);
    parama.proceed();
    AppMethodBeat.o(190649);
  }
  
  public void aVZ()
  {
    AppMethodBeat.i(106247);
    super.aVZ();
    AppMethodBeat.o(106247);
  }
  
  public void aWa()
  {
    AppMethodBeat.i(106249);
    super.aWa();
    AppMethodBeat.o(106249);
  }
  
  protected void aWb()
  {
    AppMethodBeat.i(106251);
    super.aWb();
    AppMethodBeat.o(106251);
  }
  
  protected void aWc()
  {
    AppMethodBeat.i(106250);
    super.aWc();
    bzX();
    AppMethodBeat.o(106250);
  }
  
  public void bzl()
  {
    AppMethodBeat.i(106248);
    super.bzl();
    AppMethodBeat.o(106248);
  }
  
  public void fE(boolean paramBoolean)
  {
    AppMethodBeat.i(106253);
    if (paramBoolean)
    {
      ad.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      a(new a()
      {
        public final void proceed()
        {
          AppMethodBeat.i(190648);
          if (!f.this.bzr())
          {
            FloatBallProxyUI.a(f.this.mEA.getActivity(), f.this.mDH, f.this.bzm(), new FloatBallProxyUI.a()
            {
              public final void wC(int paramAnonymous2Int)
              {
                AppMethodBeat.i(190647);
                ad.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, reach count limit, callback:%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                if (paramAnonymous2Int == 1)
                {
                  ad.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, show float menu view");
                  f.this.a(f.this.mDK);
                }
                AppMethodBeat.o(190647);
              }
            });
            AppMethodBeat.o(190648);
            return;
          }
          if (f.this.mDJ != null)
          {
            f.this.bzz().mDx = 2;
            f.this.bzv();
            Point localPoint = f.this.mDJ.getBallPosition();
            if (localPoint != null) {
              com.tencent.mm.plugin.ball.ui.c.a(f.this.mEA, localPoint, f.this.mEE);
            }
          }
          AppMethodBeat.o(190648);
        }
      });
      AppMethodBeat.o(106253);
      return;
    }
    ad.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    BallInfo localBallInfo = bzo();
    if (localBallInfo == null)
    {
      AppMethodBeat.o(106253);
      return;
    }
    if (localBallInfo.state != 0)
    {
      in(true);
      AppMethodBeat.o(106253);
      return;
    }
    bzz().opType = 8;
    bzv();
    bzt();
    bzX();
    if (this.mEA.getActivity() != null) {
      com.tencent.mm.ui.widget.snackbar.b.n(this.mEA.getActivity(), this.mEA.getActivity().getString(2131755252));
    }
    AppMethodBeat.o(106253);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106246);
    super.onDestroy();
    if (this.mEC != null) {
      this.mEC.stop();
    }
    AppMethodBeat.o(106246);
  }
  
  public boolean rg(int paramInt)
  {
    AppMethodBeat.i(106245);
    if ((bzs()) && (this.mDJ != null))
    {
      ad.i("MicroMsg.PageFloatBallHelper", "onClose, resume this ball");
      bzz().opType = wD(paramInt);
      bzv();
      Point localPoint = this.mDJ.getBallPosition();
      com.tencent.mm.plugin.ball.ui.c.a(this.mEA, localPoint, new com.tencent.mm.plugin.ball.d.a()
      {
        public final void aWf()
        {
          AppMethodBeat.i(106237);
          ad.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation cancel");
          f.this.mEA.fF(true);
          AppMethodBeat.o(106237);
        }
        
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(106236);
          ad.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation end");
          f.this.mEA.fF(false);
          AppMethodBeat.o(106236);
        }
      });
      AppMethodBeat.o(106245);
      return true;
    }
    AppMethodBeat.o(106245);
    return false;
  }
  
  protected final void wA(int paramInt)
  {
    AppMethodBeat.i(106252);
    super.wA(paramInt);
    if ((this.mEC != null) && (this.mEC.mFv != null)) {
      this.mEC.mFv.xm(paramInt);
    }
    AppMethodBeat.o(106252);
  }
  
  public static abstract interface a
  {
    public abstract void proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.f
 * JD-Core Version:    0.7.0.1
 */