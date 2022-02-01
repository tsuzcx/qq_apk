package com.tencent.mm.plugin.ball.service;

import android.app.Activity;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.b;
import com.tencent.mm.plugin.ball.ui.b.1;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.base.t;

public class f
  extends a
{
  public com.tencent.mm.plugin.ball.a.f nME;
  protected com.tencent.mm.plugin.ball.d.e nMF;
  protected com.tencent.mm.plugin.ball.ui.e nMG;
  protected b nMH;
  protected com.tencent.mm.plugin.ball.d.a nMI;
  
  public f(com.tencent.mm.plugin.ball.a.f paramf)
  {
    this.nME = paramf;
  }
  
  private void bMa()
  {
    AppMethodBeat.i(106254);
    if (this.nMH != null) {
      this.nMH.stop();
    }
    if (bhh())
    {
      this.nMG = new com.tencent.mm.plugin.ball.ui.e(this.nME, this.nMF);
      this.nMG.start();
    }
    AppMethodBeat.o(106254);
  }
  
  protected static int yd(int paramInt)
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
  
  protected void a(a parama)
  {
    AppMethodBeat.i(209488);
    parama.proceed();
    AppMethodBeat.o(209488);
  }
  
  public void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(106244);
    super.ac(paramInt, paramString);
    this.nMF = new com.tencent.mm.plugin.ball.d.e()
    {
      public final int aS(float paramAnonymousFloat)
      {
        AppMethodBeat.i(106242);
        ae.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, swipePosX:%s", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if (f.this.nLM != null)
        {
          Object localObject = f.this.bKS();
          if (localObject != null) {}
          for (int i = 1; ((i == 0) || (((BallInfo)localObject).nLu)) && (!f.this.bLv()); i = 0)
          {
            FloatBallProxyUI.a(f.this.nME.getActivity(), f.this.nLK, f.this.bLq(), f.this.nLN);
            AppMethodBeat.o(106242);
            return 2;
          }
          if (i != 0) {
            f.this.bLD().opType = 5;
          }
          for (;;)
          {
            f.this.bLz();
            localObject = f.this.nLM.getBallPosition();
            com.tencent.mm.plugin.ball.ui.c.a(f.this.nME, (Point)localObject, paramAnonymousFloat, f.this.nMI);
            if (f.this.nLM != null) {
              f.this.nLM.setEnableClick(false);
            }
            AppMethodBeat.o(106242);
            return 3;
            f.this.bLD().nLA = 1;
          }
        }
        AppMethodBeat.o(106242);
        return 1;
      }
      
      public final void setFloatBallAlpha(float paramAnonymousFloat)
      {
        AppMethodBeat.i(106243);
        if (f.this.nLM != null) {
          f.this.nLM.a(f.this.nLK, paramAnonymousFloat);
        }
        AppMethodBeat.o(106243);
      }
    };
    this.nMI = new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bhp()
      {
        AppMethodBeat.i(106240);
        ae.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation cancel");
        if (f.this.nLM != null) {
          f.this.nLM.setEnableClick(true);
        }
        f.this.nME.ge(true);
        f.a(f.this);
        AppMethodBeat.o(106240);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(106239);
        ae.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation end");
        if (f.this.nLM != null) {
          f.this.nLM.setEnableClick(true);
        }
        f.this.nME.ge(false);
        f.a(f.this);
        AppMethodBeat.o(106239);
      }
    };
    if (bhh())
    {
      paramString = bLs();
      if ((paramString != null) && (!paramString.nLu))
      {
        this.nMH = new b(this.nME, this.nMF);
        paramString = this.nMH;
        ae.i("MicroMsg.FloatBallFadeInController", "start FloatBallFadeInController");
        if (paramString.nME.bhh()) {
          paramString.nME.a(new b.1(paramString));
        }
        AppMethodBeat.o(106244);
        return;
      }
      this.nMG = new com.tencent.mm.plugin.ball.ui.e(this.nME, this.nMF);
      this.nMG.start();
      paramInt = ay.aRW(a.bLr()).decodeInt("ActiveCount", 0);
      ae.i("MicroMsg.PageFloatBallHelper", "onCreate, activeCount:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.nMG.nNz != null) {
        this.nMG.nNz.yW(paramInt);
      }
      AppMethodBeat.o(106244);
      return;
    }
    ae.i("MicroMsg.PageFloatBallHelper", "onCreate, do not support swipe to float ball");
    AppMethodBeat.o(106244);
  }
  
  public void bLp()
  {
    AppMethodBeat.i(106248);
    super.bLp();
    AppMethodBeat.o(106248);
  }
  
  public void bhj()
  {
    AppMethodBeat.i(106247);
    super.bhj();
    AppMethodBeat.o(106247);
  }
  
  public void bhk()
  {
    AppMethodBeat.i(106249);
    super.bhk();
    AppMethodBeat.o(106249);
  }
  
  protected void bhl()
  {
    AppMethodBeat.i(106251);
    super.bhl();
    AppMethodBeat.o(106251);
  }
  
  protected void bhm()
  {
    AppMethodBeat.i(106250);
    super.bhm();
    bMa();
    AppMethodBeat.o(106250);
  }
  
  public void o(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(209487);
    if (paramBoolean)
    {
      ae.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      a(new a()
      {
        public final void proceed()
        {
          AppMethodBeat.i(209486);
          if (!f.this.bLv())
          {
            FloatBallProxyUI.a(f.this.nME.getActivity(), f.this.nLK, f.this.bLq(), f.this.nLN);
            AppMethodBeat.o(209486);
            return;
          }
          if (f.this.nLM != null)
          {
            f.this.bLD().nLA = paramInt;
            f.this.bLz();
            Point localPoint = f.this.nLM.getBallPosition();
            if (localPoint != null) {
              com.tencent.mm.plugin.ball.ui.c.a(f.this.nME, localPoint, f.this.nMI);
            }
          }
          AppMethodBeat.o(209486);
        }
      });
      AppMethodBeat.o(209487);
      return;
    }
    ae.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    BallInfo localBallInfo = bLs();
    if (localBallInfo == null)
    {
      AppMethodBeat.o(209487);
      return;
    }
    if (localBallInfo.state != 0)
    {
      iV(true);
      AppMethodBeat.o(209487);
      return;
    }
    bLD().opType = 8;
    bLz();
    bLx();
    bMa();
    if (this.nME.getActivity() != null) {
      t.cn(this.nME.getActivity(), this.nME.getActivity().getString(2131755252));
    }
    AppMethodBeat.o(209487);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106246);
    super.onDestroy();
    if (this.nMG != null) {
      this.nMG.stop();
    }
    AppMethodBeat.o(106246);
  }
  
  public boolean sy(int paramInt)
  {
    AppMethodBeat.i(106245);
    if ((bLw()) && (this.nLM != null))
    {
      ae.i("MicroMsg.PageFloatBallHelper", "onClose, resume this ball");
      bLD().opType = yd(paramInt);
      bLz();
      Point localPoint = this.nLM.getBallPosition();
      com.tencent.mm.plugin.ball.ui.c.a(this.nME, localPoint, new com.tencent.mm.plugin.ball.d.a()
      {
        public final void bhp()
        {
          AppMethodBeat.i(106237);
          ae.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation cancel");
          f.this.nME.ge(true);
          AppMethodBeat.o(106237);
        }
        
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(106236);
          ae.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation end");
          f.this.nME.ge(false);
          AppMethodBeat.o(106236);
        }
      });
      AppMethodBeat.o(106245);
      return true;
    }
    AppMethodBeat.o(106245);
    return false;
  }
  
  protected final void yb(int paramInt)
  {
    AppMethodBeat.i(106252);
    super.yb(paramInt);
    if ((this.nMG != null) && (this.nMG.nNz != null)) {
      this.nMG.nNz.yW(paramInt);
    }
    AppMethodBeat.o(106252);
  }
  
  public static abstract interface a
  {
    public abstract void proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.f
 * JD-Core Version:    0.7.0.1
 */