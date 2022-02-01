package com.tencent.mm.plugin.appbrand.floatball;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends com.tencent.mm.plugin.ball.service.f
{
  p jFm;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f knb;
  private f.b knc;
  
  public f(com.tencent.mm.plugin.ball.a.f paramf, p paramp)
  {
    super(paramf);
    AppMethodBeat.i(44997);
    this.knc = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(44996);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (f.this.jFm != null) && (f.this.jFm.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (f.this.jFm.jzC.dQv == paramAnonymousAppBrandBackgroundRunningOperationParcel.hSZ) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.beO == 2) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dlO == 1))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = f.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.bLw())
          {
            ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add passive location float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iV(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iW(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.yc(d.eI(paramAnonymousAppBrandBackgroundRunningOperationParcel.nLK.state, 1));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bLy();
            AppMethodBeat.o(44996);
            return;
          }
          ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add location state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.yc(d.eI(paramAnonymousAppBrandBackgroundRunningOperationParcel.nLK.state, 1));
        }
        AppMethodBeat.o(44996);
      }
    };
    this.jFm = paramp;
    ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramp.hashCode()) });
    this.knb = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(44997);
  }
  
  private void sB(int paramInt)
  {
    AppMethodBeat.i(45000);
    bLD().opType = yd(paramInt);
    bLz();
    Point localPoint = this.nLM.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.nME, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bhp()
      {
        AppMethodBeat.i(44995);
        ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        f.this.nME.ge(true);
        AppMethodBeat.o(44995);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(44994);
        ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        f.this.nME.ge(false);
        AppMethodBeat.o(44994);
      }
    });
    AppMethodBeat.o(45000);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(44998);
    ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    if (this.knb != null) {
      this.knb.a(this.knc);
    }
    AppMethodBeat.o(44998);
  }
  
  public final boolean bhh()
  {
    return false;
  }
  
  public final boolean bhi()
  {
    return false;
  }
  
  public final void bhj()
  {
    AppMethodBeat.i(45002);
    ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    if (bLu() != null) {
      V(false);
    }
    AppMethodBeat.o(45002);
  }
  
  public final void bhk()
  {
    AppMethodBeat.i(45003);
    ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    if (bLu() != null) {
      V(true);
    }
    AppMethodBeat.o(45003);
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(45004);
    ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    this.nME.ge(true);
    AppMethodBeat.o(45004);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(45005);
    ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    super.bhm();
    bhw();
    AppMethodBeat.o(45005);
  }
  
  final void bhw()
  {
    AppMethodBeat.i(45006);
    if (g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.jFm.mAppId;
      localMMBackgroundRunningOperationParcel.beO = 2;
      localMMBackgroundRunningOperationParcel.dlO = 2;
      ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "stopLocationBackground, appId:%s", new Object[] { this.jFm.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(45006);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(45001);
    ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    super.onDestroy();
    if (this.knb != null) {
      this.knb.b(this.knc);
    }
    AppMethodBeat.o(45001);
  }
  
  public final boolean sy(final int paramInt)
  {
    AppMethodBeat.i(44999);
    ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    if (bLw())
    {
      if (!b.cc(this.nME.getActivity())) {
        AppBrandFloatBallPermissionHelper.a(this.nME.getActivity(), 7, new c.a()
        {
          public final void gd(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(44993);
            ae.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              f.a(f.this, paramInt);
              AppMethodBeat.o(44993);
              return;
            }
            ae.w("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, refuse permission, remove ball and stop location");
            f.this.bLx();
            f.this.bhw();
            f.this.nME.ge(true);
            AppMethodBeat.o(44993);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(44999);
        return true;
        sB(paramInt);
      }
    }
    AppMethodBeat.o(44999);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.f
 * JD-Core Version:    0.7.0.1
 */