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
  o joZ;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.g jpo;
  private g.b jpp;
  
  public f(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(44997);
    this.jpp = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(44996);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (f.this.joZ != null) && (f.this.joZ.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (f.this.joZ.iDx.iOP == paramAnonymousAppBrandBackgroundRunningOperationParcel.gXn) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.aTC == 2) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dbV == 1))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = f.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.bzs())
          {
            ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add passive location float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.in(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.io(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.wB(d.eB(paramAnonymousAppBrandBackgroundRunningOperationParcel.mDH.state, 1));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bzu();
            AppMethodBeat.o(44996);
            return;
          }
          ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add location state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.wB(d.eB(paramAnonymousAppBrandBackgroundRunningOperationParcel.mDH.state, 1));
        }
        AppMethodBeat.o(44996);
      }
    };
    this.joZ = paramo;
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.jpo = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    AppMethodBeat.o(44997);
  }
  
  private void rj(int paramInt)
  {
    AppMethodBeat.i(45000);
    bzz().opType = wD(paramInt);
    bzv();
    Point localPoint = this.mDJ.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.mEA, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void aWf()
      {
        AppMethodBeat.i(44995);
        ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        f.this.mEA.fF(true);
        AppMethodBeat.o(44995);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(44994);
        ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        f.this.mEA.fF(false);
        AppMethodBeat.o(44994);
      }
    });
    AppMethodBeat.o(45000);
  }
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(44998);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.Z(paramInt, paramString);
    if (this.jpo != null) {
      this.jpo.a(this.jpp);
    }
    AppMethodBeat.o(44998);
  }
  
  public final boolean aVX()
  {
    return false;
  }
  
  public final boolean aVY()
  {
    return false;
  }
  
  public final void aVZ()
  {
    AppMethodBeat.i(45002);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    if (bzq() != null) {
      V(false);
    }
    AppMethodBeat.o(45002);
  }
  
  public final void aWa()
  {
    AppMethodBeat.i(45003);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    if (bzq() != null) {
      V(true);
    }
    AppMethodBeat.o(45003);
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(45004);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    this.mEA.fF(true);
    AppMethodBeat.o(45004);
  }
  
  public final void aWc()
  {
    AppMethodBeat.i(45005);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    super.aWc();
    aWm();
    AppMethodBeat.o(45005);
  }
  
  final void aWm()
  {
    AppMethodBeat.i(45006);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.joZ.mAppId;
      localMMBackgroundRunningOperationParcel.aTC = 2;
      localMMBackgroundRunningOperationParcel.dbV = 2;
      ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "stopLocationBackground, appId:%s", new Object[] { this.joZ.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(45006);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(45001);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    super.onDestroy();
    if (this.jpo != null) {
      this.jpo.b(this.jpp);
    }
    AppMethodBeat.o(45001);
  }
  
  public final boolean rg(final int paramInt)
  {
    AppMethodBeat.i(44999);
    ad.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    if (bzs())
    {
      if (!b.bZ(this.mEA.getActivity())) {
        AppBrandFloatBallPermissionHelper.a(this.mEA.getActivity(), 7, new c.a()
        {
          public final void fD(boolean paramAnonymousBoolean)
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
            f.this.bzt();
            f.this.aWm();
            f.this.mEA.fF(true);
            AppMethodBeat.o(44993);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(44999);
        return true;
        rj(paramInt);
      }
    }
    AppMethodBeat.o(44999);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.f
 * JD-Core Version:    0.7.0.1
 */