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
  public com.tencent.mm.plugin.ball.a.f nHb;
  protected com.tencent.mm.plugin.ball.d.f nHc;
  protected e nHd;
  protected com.tencent.mm.plugin.ball.ui.b nHe;
  protected com.tencent.mm.plugin.ball.d.a nHf;
  
  public f(com.tencent.mm.plugin.ball.a.f paramf)
  {
    this.nHb = paramf;
  }
  
  private void bLd()
  {
    AppMethodBeat.i(106254);
    if (this.nHe != null) {
      this.nHe.stop();
    }
    if (bgz())
    {
      this.nHd = new e(this.nHb, this.nHc);
      this.nHd.start();
    }
    AppMethodBeat.o(106254);
  }
  
  protected static int ya(int paramInt)
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
    AppMethodBeat.i(217298);
    parama.proceed();
    AppMethodBeat.o(217298);
  }
  
  public void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(106244);
    super.ac(paramInt, paramString);
    this.nHc = new com.tencent.mm.plugin.ball.d.f()
    {
      public final int aS(float paramAnonymousFloat)
      {
        AppMethodBeat.i(106242);
        ad.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, swipePosX:%s", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if (f.this.nGl != null)
        {
          Object localObject = f.this.bJU();
          if (localObject != null) {}
          for (int i = 1; ((i == 0) || (((BallInfo)localObject).nFX)) && (!f.this.bKy()); i = 0)
          {
            FloatBallProxyUI.a(f.this.nHb.getActivity(), f.this.nGj, f.this.bKt(), new FloatBallProxyUI.a()
            {
              public final void xZ(int paramAnonymous2Int)
              {
                AppMethodBeat.i(106241);
                ad.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, can not add ball, callback:%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                if (paramAnonymous2Int == 1)
                {
                  ad.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, show float menu view");
                  f.this.a(f.this.nGm);
                }
                AppMethodBeat.o(106241);
              }
            });
            AppMethodBeat.o(106242);
            return 2;
          }
          if (i != 0) {
            f.this.bKG().opType = 5;
          }
          for (;;)
          {
            f.this.bKC();
            localObject = f.this.nGl.getBallPosition();
            com.tencent.mm.plugin.ball.ui.c.a(f.this.nHb, (Point)localObject, paramAnonymousFloat, f.this.nHf);
            if (f.this.nGl != null) {
              f.this.nGl.setEnableClick(false);
            }
            AppMethodBeat.o(106242);
            return 3;
            f.this.bKG().nGa = 1;
          }
        }
        AppMethodBeat.o(106242);
        return 1;
      }
      
      public final void setFloatBallAlpha(float paramAnonymousFloat)
      {
        AppMethodBeat.i(106243);
        if (f.this.nGl != null) {
          f.this.nGl.a(f.this.nGj, paramAnonymousFloat);
        }
        AppMethodBeat.o(106243);
      }
    };
    this.nHf = new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bgH()
      {
        AppMethodBeat.i(106240);
        ad.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation cancel");
        if (f.this.nGl != null) {
          f.this.nGl.setEnableClick(true);
        }
        f.this.nHb.gg(true);
        f.a(f.this);
        AppMethodBeat.o(106240);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(106239);
        ad.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation end");
        if (f.this.nGl != null) {
          f.this.nGl.setEnableClick(true);
        }
        f.this.nHb.gg(false);
        f.a(f.this);
        AppMethodBeat.o(106239);
      }
    };
    if (bgz())
    {
      paramString = bKv();
      if ((paramString != null) && (!paramString.nFX))
      {
        this.nHe = new com.tencent.mm.plugin.ball.ui.b(this.nHb, this.nHc);
        paramString = this.nHe;
        ad.i("MicroMsg.FloatBallFadeInController", "start FloatBallFadeInController");
        if (paramString.nHb.bgz()) {
          paramString.nHb.a(new b.1(paramString));
        }
        AppMethodBeat.o(106244);
        return;
      }
      this.nHd = new e(this.nHb, this.nHc);
      this.nHd.start();
      paramInt = ax.aQz(a.bKu()).decodeInt("ActiveCount", 0);
      ad.i("MicroMsg.PageFloatBallHelper", "onCreate, activeCount:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.nHd.nHW != null) {
        this.nHd.nHW.yN(paramInt);
      }
      AppMethodBeat.o(106244);
      return;
    }
    ad.i("MicroMsg.PageFloatBallHelper", "onCreate, do not support swipe to float ball");
    AppMethodBeat.o(106244);
  }
  
  public void bKs()
  {
    AppMethodBeat.i(106248);
    super.bKs();
    AppMethodBeat.o(106248);
  }
  
  public void bgB()
  {
    AppMethodBeat.i(106247);
    super.bgB();
    AppMethodBeat.o(106247);
  }
  
  public void bgC()
  {
    AppMethodBeat.i(106249);
    super.bgC();
    AppMethodBeat.o(106249);
  }
  
  protected void bgD()
  {
    AppMethodBeat.i(106251);
    super.bgD();
    AppMethodBeat.o(106251);
  }
  
  protected void bgE()
  {
    AppMethodBeat.i(106250);
    super.bgE();
    bLd();
    AppMethodBeat.o(106250);
  }
  
  public void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(106253);
    if (paramBoolean)
    {
      ad.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      a(new a()
      {
        public final void proceed()
        {
          AppMethodBeat.i(217297);
          if (!f.this.bKy())
          {
            FloatBallProxyUI.a(f.this.nHb.getActivity(), f.this.nGj, f.this.bKt(), new FloatBallProxyUI.a()
            {
              public final void xZ(int paramAnonymous2Int)
              {
                AppMethodBeat.i(217296);
                ad.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, reach count limit, callback:%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                if (paramAnonymous2Int == 1)
                {
                  ad.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, show float menu view");
                  f.this.a(f.this.nGm);
                }
                AppMethodBeat.o(217296);
              }
            });
            AppMethodBeat.o(217297);
            return;
          }
          if (f.this.nGl != null)
          {
            f.this.bKG().nGa = 2;
            f.this.bKC();
            Point localPoint = f.this.nGl.getBallPosition();
            if (localPoint != null) {
              com.tencent.mm.plugin.ball.ui.c.a(f.this.nHb, localPoint, f.this.nHf);
            }
          }
          AppMethodBeat.o(217297);
        }
      });
      AppMethodBeat.o(106253);
      return;
    }
    ad.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    BallInfo localBallInfo = bKv();
    if (localBallInfo == null)
    {
      AppMethodBeat.o(106253);
      return;
    }
    if (localBallInfo.state != 0)
    {
      iW(true);
      AppMethodBeat.o(106253);
      return;
    }
    bKG().opType = 8;
    bKC();
    bKA();
    bLd();
    if (this.nHb.getActivity() != null) {
      com.tencent.mm.ui.widget.snackbar.b.n(this.nHb.getActivity(), this.nHb.getActivity().getString(2131755252));
    }
    AppMethodBeat.o(106253);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106246);
    super.onDestroy();
    if (this.nHd != null) {
      this.nHd.stop();
    }
    AppMethodBeat.o(106246);
  }
  
  public boolean sv(int paramInt)
  {
    AppMethodBeat.i(106245);
    if ((bKz()) && (this.nGl != null))
    {
      ad.i("MicroMsg.PageFloatBallHelper", "onClose, resume this ball");
      bKG().opType = ya(paramInt);
      bKC();
      Point localPoint = this.nGl.getBallPosition();
      com.tencent.mm.plugin.ball.ui.c.a(this.nHb, localPoint, new com.tencent.mm.plugin.ball.d.a()
      {
        public final void bgH()
        {
          AppMethodBeat.i(106237);
          ad.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation cancel");
          f.this.nHb.gg(true);
          AppMethodBeat.o(106237);
        }
        
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(106236);
          ad.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation end");
          f.this.nHb.gg(false);
          AppMethodBeat.o(106236);
        }
      });
      AppMethodBeat.o(106245);
      return true;
    }
    AppMethodBeat.o(106245);
    return false;
  }
  
  protected final void xX(int paramInt)
  {
    AppMethodBeat.i(106252);
    super.xX(paramInt);
    if ((this.nHd != null) && (this.nHd.nHW != null)) {
      this.nHd.nHW.yN(paramInt);
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