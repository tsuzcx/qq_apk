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
import com.tencent.mm.ui.base.aa;

public class e
  extends FloatBallHelper
{
  public f vkT;
  protected com.tencent.mm.plugin.ball.d.e vkU;
  protected com.tencent.mm.plugin.ball.ui.e vkV;
  protected com.tencent.mm.plugin.ball.ui.b vkW;
  protected a vkX;
  
  public e(f paramf)
  {
    this.vkT = paramf;
  }
  
  protected static int FK(int paramInt)
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
  
  private void cYS()
  {
    AppMethodBeat.i(106254);
    if (this.vkW != null) {
      this.vkW.stop();
    }
    if (bhU())
    {
      this.vkV = new com.tencent.mm.plugin.ball.ui.e(this.vkT, this.vkU);
      this.vkV.start();
    }
    AppMethodBeat.o(106254);
  }
  
  public void B(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(288443);
    if (paramBoolean)
    {
      Log.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      a(new a()
      {
        public final void proceed()
        {
          AppMethodBeat.i(288384);
          if (!e.this.cYm())
          {
            FloatBallProxyUI.a(e.this.vkT.getActivity(), 1, e.this.vjV, e.this.cYg(), e.this.vjY);
            AppMethodBeat.o(288384);
            return;
          }
          if (e.this.vjX != null)
          {
            e.this.cYv().mUT = paramInt;
            e.this.cYr();
            Point localPoint = e.this.vjX.getBallPosition();
            if (localPoint != null) {
              c.a(e.this.vkT, localPoint, e.this.vkX);
            }
          }
          AppMethodBeat.o(288384);
        }
      });
      AppMethodBeat.o(288443);
      return;
    }
    Log.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    BallInfo localBallInfo = cYj();
    if (localBallInfo == null)
    {
      AppMethodBeat.o(288443);
      return;
    }
    if (localBallInfo.state != 0)
    {
      mr(true);
      AppMethodBeat.o(288443);
      return;
    }
    cYv().opType = 8;
    cYr();
    cYp();
    cYS();
    if (this.vkT.getActivity() != null) {
      aa.db(this.vkT.getActivity(), this.vkT.getActivity().getString(a.h.alert_remove_float_ball));
    }
    AppMethodBeat.o(288443);
  }
  
  protected final void FI(int paramInt)
  {
    AppMethodBeat.i(106252);
    super.FI(paramInt);
    if ((this.vkV != null) && (this.vkV.vlM != null)) {
      this.vkV.vlM.GE(paramInt);
    }
    AppMethodBeat.o(106252);
  }
  
  public void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(106244);
    super.J(paramInt, paramString);
    this.vkU = new com.tencent.mm.plugin.ball.d.e() {};
    this.vkX = new a()
    {
      public final void aXe()
      {
        AppMethodBeat.i(106240);
        Log.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation cancel");
        if (e.this.vjX != null) {
          e.this.vjX.setEnableClick(true);
        }
        e.this.vkT.iR(true);
        e.a(e.this);
        AppMethodBeat.o(106240);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(106239);
        Log.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation end");
        if (e.this.vjX != null) {
          e.this.vjX.setEnableClick(true);
        }
        e.this.vkT.iR(false);
        e.a(e.this);
        AppMethodBeat.o(106239);
      }
    };
    if (bhU())
    {
      paramString = cYj();
      if ((paramString != null) && (!paramString.vjH))
      {
        this.vkW = new com.tencent.mm.plugin.ball.ui.b(this.vkT, this.vkU);
        paramString = this.vkW;
        Log.i("MicroMsg.FloatBallFadeInController", "start FloatBallFadeInController");
        if (paramString.vkT.bhU()) {
          paramString.vkT.a(new b.1(paramString));
        }
        AppMethodBeat.o(106244);
        return;
      }
      this.vkV = new com.tencent.mm.plugin.ball.ui.e(this.vkT, this.vkU);
      this.vkV.start();
      paramInt = cYn();
      Log.i("MicroMsg.PageFloatBallHelper", "onCreate, activeCount:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.vkV.vlM != null) {
        this.vkV.vlM.GE(paramInt);
      }
      AppMethodBeat.o(106244);
      return;
    }
    Log.i("MicroMsg.PageFloatBallHelper", "onCreate, do not support swipe to float ball");
    AppMethodBeat.o(106244);
  }
  
  protected void a(a parama)
  {
    AppMethodBeat.i(288446);
    parama.proceed();
    AppMethodBeat.o(288446);
  }
  
  public void bhT()
  {
    AppMethodBeat.i(106248);
    super.bhT();
    AppMethodBeat.o(106248);
  }
  
  protected void bhV()
  {
    AppMethodBeat.i(106251);
    super.bhV();
    AppMethodBeat.o(106251);
  }
  
  public void bhW()
  {
    AppMethodBeat.i(106249);
    super.bhW();
    AppMethodBeat.o(106249);
  }
  
  public void coi()
  {
    AppMethodBeat.i(106247);
    super.coi();
    AppMethodBeat.o(106247);
  }
  
  protected void coj()
  {
    AppMethodBeat.i(106250);
    super.coj();
    cYS();
    AppMethodBeat.o(106250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106246);
    super.onDestroy();
    if (this.vkV != null)
    {
      com.tencent.mm.plugin.ball.ui.e locale = this.vkV;
      Log.i("MicroMsg.FloatIndicatorController", "stop FloatIndicatorController");
      MMHandlerThread.postToMainThread(new com.tencent.mm.plugin.ball.ui.e.3(locale));
      locale.vkT.a(null);
    }
    AppMethodBeat.o(106246);
  }
  
  public boolean zX(int paramInt)
  {
    AppMethodBeat.i(106245);
    if ((cYo()) && (this.vjX != null))
    {
      Log.i("MicroMsg.PageFloatBallHelper", "onClose, resume this ball");
      cYv().opType = FK(paramInt);
      cYr();
      Point localPoint = this.vjX.getBallPosition();
      c.a(this.vkT, localPoint, new a()
      {
        public final void aXe()
        {
          AppMethodBeat.i(106237);
          Log.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation cancel");
          e.this.vkT.iR(true);
          AppMethodBeat.o(106237);
        }
        
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(106236);
          Log.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation end");
          e.this.vkT.iR(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.e
 * JD-Core Version:    0.7.0.1
 */