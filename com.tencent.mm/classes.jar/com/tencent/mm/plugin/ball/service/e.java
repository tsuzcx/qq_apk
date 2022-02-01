package com.tencent.mm.plugin.ball.service;

import android.app.Activity;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.h;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.b.1;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.w;

public class e
  extends FloatBallHelper
{
  public f rZC;
  protected com.tencent.mm.plugin.ball.d.e rZD;
  protected com.tencent.mm.plugin.ball.ui.e rZE;
  protected com.tencent.mm.plugin.ball.ui.b rZF;
  protected a rZG;
  
  public e(f paramf)
  {
    this.rZC = paramf;
  }
  
  protected static int Fj(int paramInt)
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
  
  private void cwi()
  {
    AppMethodBeat.i(106254);
    if (this.rZF != null) {
      this.rZF.stop();
    }
    if (aOg())
    {
      this.rZE = new com.tencent.mm.plugin.ball.ui.e(this.rZC, this.rZD);
      this.rZE.start();
    }
    AppMethodBeat.o(106254);
  }
  
  public void D(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(189289);
    if (paramBoolean)
    {
      Log.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      a(new a()
      {
        public final void proceed()
        {
          AppMethodBeat.i(187611);
          if (!e.this.cvB())
          {
            FloatBallProxyUI.a(e.this.rZC.getActivity(), 1, e.this.rYE, e.this.bOb(), e.this.rYH);
            AppMethodBeat.o(187611);
            return;
          }
          if (e.this.rYG != null)
          {
            e.this.cvL().kqY = paramInt;
            e.this.cvG();
            Point localPoint = e.this.rYG.getBallPosition();
            if (localPoint != null) {
              c.a(e.this.rZC, localPoint, e.this.rZG);
            }
          }
          AppMethodBeat.o(187611);
        }
      });
      AppMethodBeat.o(189289);
      return;
    }
    Log.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    BallInfo localBallInfo = cvy();
    if (localBallInfo == null)
    {
      AppMethodBeat.o(189289);
      return;
    }
    if (localBallInfo.state != 0)
    {
      le(true);
      AppMethodBeat.o(189289);
      return;
    }
    cvL().opType = 8;
    cvG();
    cvE();
    cwi();
    if (this.rZC.getActivity() != null) {
      w.cR(this.rZC.getActivity(), this.rZC.getActivity().getString(a.h.alert_remove_float_ball));
    }
    AppMethodBeat.o(189289);
  }
  
  protected final void Fh(int paramInt)
  {
    AppMethodBeat.i(106252);
    super.Fh(paramInt);
    if ((this.rZE != null) && (this.rZE.sav != null)) {
      this.rZE.sav.Gf(paramInt);
    }
    AppMethodBeat.o(106252);
  }
  
  public void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(106244);
    super.I(paramInt, paramString);
    this.rZD = new com.tencent.mm.plugin.ball.d.e() {};
    this.rZG = new a()
    {
      public final void aEa()
      {
        AppMethodBeat.i(106240);
        Log.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation cancel");
        if (e.this.rYG != null) {
          e.this.rYG.setEnableClick(true);
        }
        e.this.rZC.hS(true);
        e.a(e.this);
        AppMethodBeat.o(106240);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(106239);
        Log.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation end");
        if (e.this.rYG != null) {
          e.this.rYG.setEnableClick(true);
        }
        e.this.rZC.hS(false);
        e.a(e.this);
        AppMethodBeat.o(106239);
      }
    };
    if (aOg())
    {
      paramString = cvy();
      if ((paramString != null) && (!paramString.rYr))
      {
        this.rZF = new com.tencent.mm.plugin.ball.ui.b(this.rZC, this.rZD);
        paramString = this.rZF;
        Log.i("MicroMsg.FloatBallFadeInController", "start FloatBallFadeInController");
        if (paramString.rZC.aOg()) {
          paramString.rZC.a(new b.1(paramString));
        }
        AppMethodBeat.o(106244);
        return;
      }
      this.rZE = new com.tencent.mm.plugin.ball.ui.e(this.rZC, this.rZD);
      this.rZE.start();
      paramInt = cvC();
      Log.i("MicroMsg.PageFloatBallHelper", "onCreate, activeCount:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.rZE.sav != null) {
        this.rZE.sav.Gf(paramInt);
      }
      AppMethodBeat.o(106244);
      return;
    }
    Log.i("MicroMsg.PageFloatBallHelper", "onCreate, do not support swipe to float ball");
    AppMethodBeat.o(106244);
  }
  
  protected void a(a parama)
  {
    AppMethodBeat.i(189290);
    parama.proceed();
    AppMethodBeat.o(189290);
  }
  
  public void aOf()
  {
    AppMethodBeat.i(106248);
    super.aOf();
    AppMethodBeat.o(106248);
  }
  
  protected void aOi()
  {
    AppMethodBeat.i(106251);
    super.aOi();
    AppMethodBeat.o(106251);
  }
  
  public void aOj()
  {
    AppMethodBeat.i(106249);
    super.aOj();
    AppMethodBeat.o(106249);
  }
  
  public void bNV()
  {
    AppMethodBeat.i(106247);
    super.bNV();
    AppMethodBeat.o(106247);
  }
  
  protected void bNW()
  {
    AppMethodBeat.i(106250);
    super.bNW();
    cwi();
    AppMethodBeat.o(106250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106246);
    super.onDestroy();
    if (this.rZE != null)
    {
      com.tencent.mm.plugin.ball.ui.e locale = this.rZE;
      Log.i("MicroMsg.FloatIndicatorController", "stop FloatIndicatorController");
      MMHandlerThread.postToMainThread(new com.tencent.mm.plugin.ball.ui.e.3(locale));
      locale.rZC.a(null);
    }
    AppMethodBeat.o(106246);
  }
  
  public boolean zH(int paramInt)
  {
    AppMethodBeat.i(106245);
    if ((cvD()) && (this.rYG != null))
    {
      Log.i("MicroMsg.PageFloatBallHelper", "onClose, resume this ball");
      cvL().opType = Fj(paramInt);
      cvG();
      Point localPoint = this.rYG.getBallPosition();
      c.a(this.rZC, localPoint, new a()
      {
        public final void aEa()
        {
          AppMethodBeat.i(106237);
          Log.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation cancel");
          e.this.rZC.hS(true);
          AppMethodBeat.o(106237);
        }
        
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(106236);
          Log.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation end");
          e.this.rZC.hS(false);
          AppMethodBeat.o(106236);
        }
      });
      AppMethodBeat.o(106245);
      return true;
    }
    AppMethodBeat.o(106245);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.e
 * JD-Core Version:    0.7.0.1
 */