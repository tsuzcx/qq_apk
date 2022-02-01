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
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends com.tencent.mm.plugin.ball.service.f
{
  private com.tencent.mm.plugin.appbrand.backgroundrunning.g jPB;
  private g.b jPC;
  o jPl;
  
  public f(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(44997);
    this.jPC = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(44996);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (f.this.jPl != null) && (f.this.jPl.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (f.this.jPl.jdx.joY == paramAnonymousAppBrandBackgroundRunningOperationParcel.hxM) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.aUu == 2) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.cZu == 1))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = f.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.bGo())
          {
            ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add passive location float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iN(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iO(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.xs(d.eE(paramAnonymousAppBrandBackgroundRunningOperationParcel.nfN.state, 1));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bGq();
            AppMethodBeat.o(44996);
            return;
          }
          ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add location state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.xs(d.eE(paramAnonymousAppBrandBackgroundRunningOperationParcel.nfN.state, 1));
        }
        AppMethodBeat.o(44996);
      }
    };
    this.jPl = paramo;
    ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.jPB = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    AppMethodBeat.o(44997);
  }
  
  private void rW(int paramInt)
  {
    AppMethodBeat.i(45000);
    bGv().opType = xu(paramInt);
    bGr();
    Point localPoint = this.nfP.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.ngF, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bdd()
      {
        AppMethodBeat.i(44995);
        ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        f.this.ngF.gb(true);
        AppMethodBeat.o(44995);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(44994);
        ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        f.this.ngF.gb(false);
        AppMethodBeat.o(44994);
      }
    });
    AppMethodBeat.o(45000);
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(44998);
    ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.aa(paramInt, paramString);
    if (this.jPB != null) {
      this.jPB.a(this.jPC);
    }
    AppMethodBeat.o(44998);
  }
  
  public final boolean bcV()
  {
    return false;
  }
  
  public final boolean bcW()
  {
    return false;
  }
  
  public final void bcX()
  {
    AppMethodBeat.i(45002);
    ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    if (bGm() != null) {
      V(false);
    }
    AppMethodBeat.o(45002);
  }
  
  public final void bcY()
  {
    AppMethodBeat.i(45003);
    ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    if (bGm() != null) {
      V(true);
    }
    AppMethodBeat.o(45003);
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(45004);
    ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    this.ngF.gb(true);
    AppMethodBeat.o(45004);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(45005);
    ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    super.bda();
    bdk();
    AppMethodBeat.o(45005);
  }
  
  final void bdk()
  {
    AppMethodBeat.i(45006);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.jPl.mAppId;
      localMMBackgroundRunningOperationParcel.aUu = 2;
      localMMBackgroundRunningOperationParcel.cZu = 2;
      ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "stopLocationBackground, appId:%s", new Object[] { this.jPl.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(45006);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(45001);
    ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    super.onDestroy();
    if (this.jPB != null) {
      this.jPB.b(this.jPC);
    }
    AppMethodBeat.o(45001);
  }
  
  public final boolean rT(final int paramInt)
  {
    AppMethodBeat.i(44999);
    ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    if (bGo())
    {
      if (!b.cc(this.ngF.getActivity())) {
        AppBrandFloatBallPermissionHelper.a(this.ngF.getActivity(), 7, new c.a()
        {
          public final void fZ(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(44993);
            ac.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              f.a(f.this, paramInt);
              AppMethodBeat.o(44993);
              return;
            }
            ac.w("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, refuse permission, remove ball and stop location");
            f.this.bGp();
            f.this.bdk();
            f.this.ngF.gb(true);
            AppMethodBeat.o(44993);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(44999);
        return true;
        rW(paramInt);
      }
    }
    AppMethodBeat.o(44999);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.f
 * JD-Core Version:    0.7.0.1
 */