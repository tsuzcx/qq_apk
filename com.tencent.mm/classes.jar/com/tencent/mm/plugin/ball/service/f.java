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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;

public class f
  extends a
{
  public com.tencent.mm.plugin.ball.a.f ngF;
  protected com.tencent.mm.plugin.ball.d.f ngG;
  protected e ngH;
  protected com.tencent.mm.plugin.ball.ui.b ngI;
  protected com.tencent.mm.plugin.ball.d.a ngJ;
  
  public f(com.tencent.mm.plugin.ball.a.f paramf)
  {
    this.ngF = paramf;
  }
  
  private void bGT()
  {
    AppMethodBeat.i(106254);
    if (this.ngI != null) {
      this.ngI.stop();
    }
    if (bcV())
    {
      this.ngH = new e(this.ngF, this.ngG);
      this.ngH.start();
    }
    AppMethodBeat.o(106254);
  }
  
  protected static int xu(int paramInt)
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
  
  protected void a(f.a parama)
  {
    AppMethodBeat.i(208014);
    parama.proceed();
    AppMethodBeat.o(208014);
  }
  
  public void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(106244);
    super.aa(paramInt, paramString);
    this.ngG = new com.tencent.mm.plugin.ball.d.f()
    {
      public final int aP(float paramAnonymousFloat)
      {
        AppMethodBeat.i(106242);
        ac.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, swipePosX:%s", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if (f.this.nfP != null)
        {
          Object localObject = f.this.bFK();
          if (localObject != null) {}
          for (int i = 1; ((i == 0) || (((BallInfo)localObject).nfB)) && (!f.this.bGn()); i = 0)
          {
            FloatBallProxyUI.a(f.this.ngF.getActivity(), f.this.nfN, f.this.bGi(), new FloatBallProxyUI.a()
            {
              public final void xt(int paramAnonymous2Int)
              {
                AppMethodBeat.i(106241);
                ac.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, can not add ball, callback:%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                if (paramAnonymous2Int == 1)
                {
                  ac.i("MicroMsg.PageFloatBallHelper", "swipePageToFloatBall, show float menu view");
                  f.this.a(f.this.nfQ);
                }
                AppMethodBeat.o(106241);
              }
            });
            AppMethodBeat.o(106242);
            return 2;
          }
          if (i != 0) {
            f.this.bGv().opType = 5;
          }
          for (;;)
          {
            f.this.bGr();
            localObject = f.this.nfP.getBallPosition();
            com.tencent.mm.plugin.ball.ui.c.a(f.this.ngF, (Point)localObject, paramAnonymousFloat, f.this.ngJ);
            if (f.this.nfP != null) {
              f.this.nfP.setEnableClick(false);
            }
            AppMethodBeat.o(106242);
            return 3;
            f.this.bGv().nfE = 1;
          }
        }
        AppMethodBeat.o(106242);
        return 1;
      }
      
      public final void setFloatBallAlpha(float paramAnonymousFloat)
      {
        AppMethodBeat.i(106243);
        if (f.this.nfP != null) {
          f.this.nfP.a(f.this.nfN, paramAnonymousFloat);
        }
        AppMethodBeat.o(106243);
      }
    };
    this.ngJ = new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bdd()
      {
        AppMethodBeat.i(106240);
        ac.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation cancel");
        if (f.this.nfP != null) {
          f.this.nfP.setEnableClick(true);
        }
        f.this.ngF.gb(true);
        f.a(f.this);
        AppMethodBeat.o(106240);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(106239);
        ac.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation end");
        if (f.this.nfP != null) {
          f.this.nfP.setEnableClick(true);
        }
        f.this.ngF.gb(false);
        f.a(f.this);
        AppMethodBeat.o(106239);
      }
    };
    if (bcV())
    {
      paramString = bGk();
      if ((paramString != null) && (!paramString.nfB))
      {
        this.ngI = new com.tencent.mm.plugin.ball.ui.b(this.ngF, this.ngG);
        paramString = this.ngI;
        ac.i("MicroMsg.FloatBallFadeInController", "start FloatBallFadeInController");
        if (paramString.ngF.bcV()) {
          paramString.ngF.a(new b.1(paramString));
        }
        AppMethodBeat.o(106244);
        return;
      }
      this.ngH = new e(this.ngF, this.ngG);
      this.ngH.start();
      paramInt = aw.aKT(a.bGj()).decodeInt("ActiveCount", 0);
      ac.i("MicroMsg.PageFloatBallHelper", "onCreate, activeCount:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.ngH.nhA != null) {
        this.ngH.nhA.ye(paramInt);
      }
      AppMethodBeat.o(106244);
      return;
    }
    ac.i("MicroMsg.PageFloatBallHelper", "onCreate, do not support swipe to float ball");
    AppMethodBeat.o(106244);
  }
  
  public void bGh()
  {
    AppMethodBeat.i(106248);
    super.bGh();
    AppMethodBeat.o(106248);
  }
  
  public void bcX()
  {
    AppMethodBeat.i(106247);
    super.bcX();
    AppMethodBeat.o(106247);
  }
  
  public void bcY()
  {
    AppMethodBeat.i(106249);
    super.bcY();
    AppMethodBeat.o(106249);
  }
  
  protected void bcZ()
  {
    AppMethodBeat.i(106251);
    super.bcZ();
    AppMethodBeat.o(106251);
  }
  
  protected void bda()
  {
    AppMethodBeat.i(106250);
    super.bda();
    bGT();
    AppMethodBeat.o(106250);
  }
  
  public void ga(boolean paramBoolean)
  {
    AppMethodBeat.i(106253);
    if (paramBoolean)
    {
      ac.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      a(new f.a()
      {
        public final void proceed()
        {
          AppMethodBeat.i(208013);
          if (!f.this.bGn())
          {
            FloatBallProxyUI.a(f.this.ngF.getActivity(), f.this.nfN, f.this.bGi(), new FloatBallProxyUI.a()
            {
              public final void xt(int paramAnonymous2Int)
              {
                AppMethodBeat.i(208012);
                ac.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, reach count limit, callback:%s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                if (paramAnonymous2Int == 1)
                {
                  ac.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, show float menu view");
                  f.this.a(f.this.nfQ);
                }
                AppMethodBeat.o(208012);
              }
            });
            AppMethodBeat.o(208013);
            return;
          }
          if (f.this.nfP != null)
          {
            f.this.bGv().nfE = 2;
            f.this.bGr();
            Point localPoint = f.this.nfP.getBallPosition();
            if (localPoint != null) {
              com.tencent.mm.plugin.ball.ui.c.a(f.this.ngF, localPoint, f.this.ngJ);
            }
          }
          AppMethodBeat.o(208013);
        }
      });
      AppMethodBeat.o(106253);
      return;
    }
    ac.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    BallInfo localBallInfo = bGk();
    if (localBallInfo == null)
    {
      AppMethodBeat.o(106253);
      return;
    }
    if (localBallInfo.state != 0)
    {
      iN(true);
      AppMethodBeat.o(106253);
      return;
    }
    bGv().opType = 8;
    bGr();
    bGp();
    bGT();
    if (this.ngF.getActivity() != null) {
      com.tencent.mm.ui.widget.snackbar.b.n(this.ngF.getActivity(), this.ngF.getActivity().getString(2131755252));
    }
    AppMethodBeat.o(106253);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106246);
    super.onDestroy();
    if (this.ngH != null) {
      this.ngH.stop();
    }
    AppMethodBeat.o(106246);
  }
  
  public boolean rT(int paramInt)
  {
    AppMethodBeat.i(106245);
    if ((bGo()) && (this.nfP != null))
    {
      ac.i("MicroMsg.PageFloatBallHelper", "onClose, resume this ball");
      bGv().opType = xu(paramInt);
      bGr();
      Point localPoint = this.nfP.getBallPosition();
      com.tencent.mm.plugin.ball.ui.c.a(this.ngF, localPoint, new com.tencent.mm.plugin.ball.d.a()
      {
        public final void bdd()
        {
          AppMethodBeat.i(106237);
          ac.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation cancel");
          f.this.ngF.gb(true);
          AppMethodBeat.o(106237);
        }
        
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(106236);
          ac.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation end");
          f.this.ngF.gb(false);
          AppMethodBeat.o(106236);
        }
      });
      AppMethodBeat.o(106245);
      return true;
    }
    AppMethodBeat.o(106245);
    return false;
  }
  
  protected final void xr(int paramInt)
  {
    AppMethodBeat.i(106252);
    super.xr(paramInt);
    if ((this.ngH != null) && (this.ngH.nhA != null)) {
      this.ngH.nhA.ye(paramInt);
    }
    AppMethodBeat.o(106252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.f
 * JD-Core Version:    0.7.0.1
 */