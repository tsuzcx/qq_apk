package com.tencent.mm.plugin.appbrand.floatball;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends com.tencent.mm.plugin.ball.service.f
{
  o jCo;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.g kjL;
  private g.b kjM;
  
  public f(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(44997);
    this.kjM = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(44996);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (f.this.jCo != null) && (f.this.jCo.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (f.this.jCo.jwG.dPf == paramAnonymousAppBrandBackgroundRunningOperationParcel.hQh) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.beO == 2) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dkM == 1))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = f.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.bKz())
          {
            ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add passive location float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iW(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iX(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.xY(d.eH(paramAnonymousAppBrandBackgroundRunningOperationParcel.nGj.state, 1));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bKB();
            AppMethodBeat.o(44996);
            return;
          }
          ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add location state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.xY(d.eH(paramAnonymousAppBrandBackgroundRunningOperationParcel.nGj.state, 1));
        }
        AppMethodBeat.o(44996);
      }
    };
    this.jCo = paramo;
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.kjL = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    AppMethodBeat.o(44997);
  }
  
  private void sy(int paramInt)
  {
    AppMethodBeat.i(45000);
    bKG().opType = ya(paramInt);
    bKC();
    Point localPoint = this.nGl.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.nHb, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bgH()
      {
        AppMethodBeat.i(44995);
        ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        f.this.nHb.gg(true);
        AppMethodBeat.o(44995);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(44994);
        ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        f.this.nHb.gg(false);
        AppMethodBeat.o(44994);
      }
    });
    AppMethodBeat.o(45000);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(44998);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    if (this.kjL != null) {
      this.kjL.a(this.kjM);
    }
    AppMethodBeat.o(44998);
  }
  
  public final boolean bgA()
  {
    return false;
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(45002);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    if (bKx() != null) {
      V(false);
    }
    AppMethodBeat.o(45002);
  }
  
  public final void bgC()
  {
    AppMethodBeat.i(45003);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    if (bKx() != null) {
      V(true);
    }
    AppMethodBeat.o(45003);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(45004);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    this.nHb.gg(true);
    AppMethodBeat.o(45004);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(45005);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    super.bgE();
    bgO();
    AppMethodBeat.o(45005);
  }
  
  final void bgO()
  {
    AppMethodBeat.i(45006);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.jCo.mAppId;
      localMMBackgroundRunningOperationParcel.beO = 2;
      localMMBackgroundRunningOperationParcel.dkM = 2;
      ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "stopLocationBackground, appId:%s", new Object[] { this.jCo.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(45006);
  }
  
  public final boolean bgz()
  {
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(45001);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    super.onDestroy();
    if (this.kjL != null) {
      this.kjL.b(this.kjM);
    }
    AppMethodBeat.o(45001);
  }
  
  public final boolean sv(final int paramInt)
  {
    AppMethodBeat.i(44999);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    if (bKz())
    {
      if (!b.ca(this.nHb.getActivity())) {
        AppBrandFloatBallPermissionHelper.a(this.nHb.getActivity(), 7, new c.a()
        {
          public final void ge(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(44993);
            ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              f.a(f.this, paramInt);
              AppMethodBeat.o(44993);
              return;
            }
            ad.w("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, refuse permission, remove ball and stop location");
            f.this.bKA();
            f.this.bgO();
            f.this.nHb.gg(true);
            AppMethodBeat.o(44993);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(44999);
        return true;
        sy(paramInt);
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