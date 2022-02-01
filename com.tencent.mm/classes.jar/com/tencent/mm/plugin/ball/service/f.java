package com.tencent.mm.plugin.ball.service;

import android.app.Activity;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.b.1;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public class f
  extends a
{
  public com.tencent.mm.plugin.ball.a.f oXA;
  protected com.tencent.mm.plugin.ball.d.e oXB;
  protected com.tencent.mm.plugin.ball.ui.e oXC;
  protected com.tencent.mm.plugin.ball.ui.b oXD;
  protected com.tencent.mm.plugin.ball.d.a oXE;
  
  public f(com.tencent.mm.plugin.ball.a.f paramf)
  {
    this.oXA = paramf;
  }
  
  protected static int BI(int paramInt)
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
  
  private void ciQ()
  {
    AppMethodBeat.i(106254);
    if (this.oXD != null) {
      this.oXD.stop();
    }
    if (aGg())
    {
      this.oXC = new com.tencent.mm.plugin.ball.ui.e(this.oXA, this.oXB);
      this.oXC.start();
    }
    AppMethodBeat.o(106254);
  }
  
  protected final void BG(int paramInt)
  {
    AppMethodBeat.i(106252);
    super.BG(paramInt);
    if ((this.oXC != null) && (this.oXC.oYu != null)) {
      this.oXC.oYu.CC(paramInt);
    }
    AppMethodBeat.o(106252);
  }
  
  public void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(106244);
    super.G(paramInt, paramString);
    this.oXB = new com.tencent.mm.plugin.ball.d.e()
    {
      public final int aZ(float paramAnonymousFloat)
      {
        AppMethodBeat.i(106242);
        Log.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, swipePosX:%s", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if (f.this.oWG != null)
        {
          Object localObject = f.this.cil();
          if (localObject != null) {}
          for (int i = 1; ((i == 0) || (((BallInfo)localObject).oWr)) && (!f.this.cio()); i = 0)
          {
            FloatBallProxyUI.a(f.this.oXA.getActivity(), 1, f.this.oWE, f.this.cij(), f.this.oWH);
            AppMethodBeat.o(106242);
            return 2;
          }
          if (i != 0) {
            f.this.ciw().opType = 5;
          }
          for (;;)
          {
            f.this.cit();
            localObject = f.this.oWG.getBallPosition();
            c.a(f.this.oXA, (Point)localObject, paramAnonymousFloat, f.this.oXE);
            if (f.this.oWG != null) {
              f.this.oWG.setEnableClick(false);
            }
            AppMethodBeat.o(106242);
            return 3;
            f.this.ciw().hCZ = 1;
          }
        }
        AppMethodBeat.o(106242);
        return 1;
      }
      
      public final void setFloatBallAlpha(float paramAnonymousFloat)
      {
        AppMethodBeat.i(106243);
        if (f.this.oWG != null) {
          f.this.oWG.a(f.this.oWE, paramAnonymousFloat);
        }
        AppMethodBeat.o(106243);
      }
    };
    this.oXE = new com.tencent.mm.plugin.ball.d.a()
    {
      public final void awJ()
      {
        AppMethodBeat.i(106240);
        Log.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation cancel");
        if (f.this.oWG != null) {
          f.this.oWG.setEnableClick(true);
        }
        f.this.oXA.hb(true);
        f.a(f.this);
        AppMethodBeat.o(106240);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(106239);
        Log.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation end");
        if (f.this.oWG != null) {
          f.this.oWG.setEnableClick(true);
        }
        f.this.oXA.hb(false);
        f.a(f.this);
        AppMethodBeat.o(106239);
      }
    };
    if (aGg())
    {
      paramString = cim();
      if ((paramString != null) && (!paramString.oWr))
      {
        this.oXD = new com.tencent.mm.plugin.ball.ui.b(this.oXA, this.oXB);
        paramString = this.oXD;
        Log.i("MicroMsg.FloatBallFadeInController", "start FloatBallFadeInController");
        if (paramString.oXA.aGg()) {
          paramString.oXA.a(new b.1(paramString));
        }
        AppMethodBeat.o(106244);
        return;
      }
      this.oXC = new com.tencent.mm.plugin.ball.ui.e(this.oXA, this.oXB);
      this.oXC.start();
      paramInt = cip();
      Log.i("MicroMsg.PageFloatBallHelper", "onCreate, activeCount:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.oXC.oYu != null) {
        this.oXC.oYu.CC(paramInt);
      }
      AppMethodBeat.o(106244);
      return;
    }
    Log.i("MicroMsg.PageFloatBallHelper", "onCreate, do not support swipe to float ball");
    AppMethodBeat.o(106244);
  }
  
  protected void a(a parama)
  {
    AppMethodBeat.i(217040);
    parama.proceed();
    AppMethodBeat.o(217040);
  }
  
  public void aGf()
  {
    AppMethodBeat.i(106248);
    super.aGf();
    AppMethodBeat.o(106248);
  }
  
  protected void aGi()
  {
    AppMethodBeat.i(106251);
    super.aGi();
    AppMethodBeat.o(106251);
  }
  
  public void aGj()
  {
    AppMethodBeat.i(106249);
    super.aGj();
    AppMethodBeat.o(106249);
  }
  
  public void bCA()
  {
    AppMethodBeat.i(106247);
    super.bCA();
    AppMethodBeat.o(106247);
  }
  
  protected void bCB()
  {
    AppMethodBeat.i(106250);
    super.bCB();
    ciQ();
    AppMethodBeat.o(106250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106246);
    super.onDestroy();
    if (this.oXC != null) {
      this.oXC.stop();
    }
    AppMethodBeat.o(106246);
  }
  
  public boolean wu(int paramInt)
  {
    AppMethodBeat.i(106245);
    if ((ciq()) && (this.oWG != null))
    {
      Log.i("MicroMsg.PageFloatBallHelper", "onClose, resume this ball");
      ciw().opType = BI(paramInt);
      cit();
      Point localPoint = this.oWG.getBallPosition();
      c.a(this.oXA, localPoint, new com.tencent.mm.plugin.ball.d.a()
      {
        public final void awJ()
        {
          AppMethodBeat.i(106237);
          Log.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation cancel");
          f.this.oXA.hb(true);
          AppMethodBeat.o(106237);
        }
        
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(106236);
          Log.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation end");
          f.this.oXA.hb(false);
          AppMethodBeat.o(106236);
        }
      });
      AppMethodBeat.o(106245);
      return true;
    }
    AppMethodBeat.o(106245);
    return false;
  }
  
  public void y(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(217039);
    if (paramBoolean)
    {
      Log.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      a(new a()
      {
        public final void proceed()
        {
          AppMethodBeat.i(217038);
          if (!f.this.cio())
          {
            FloatBallProxyUI.a(f.this.oXA.getActivity(), 1, f.this.oWE, f.this.cij(), f.this.oWH);
            AppMethodBeat.o(217038);
            return;
          }
          if (f.this.oWG != null)
          {
            f.this.ciw().hCZ = paramInt;
            f.this.cit();
            Point localPoint = f.this.oWG.getBallPosition();
            if (localPoint != null) {
              c.a(f.this.oXA, localPoint, f.this.oXE);
            }
          }
          AppMethodBeat.o(217038);
        }
      });
      AppMethodBeat.o(217039);
      return;
    }
    Log.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    BallInfo localBallInfo = cim();
    if (localBallInfo == null)
    {
      AppMethodBeat.o(217039);
      return;
    }
    if (localBallInfo.state != 0)
    {
      jT(true);
      AppMethodBeat.o(217039);
      return;
    }
    ciw().opType = 8;
    cit();
    cir();
    ciQ();
    if (this.oXA.getActivity() != null) {
      u.cG(this.oXA.getActivity(), this.oXA.getActivity().getString(2131755287));
    }
    AppMethodBeat.o(217039);
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