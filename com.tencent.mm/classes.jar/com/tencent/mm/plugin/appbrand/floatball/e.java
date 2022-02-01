package com.tencent.mm.plugin.appbrand.floatball;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends com.tencent.mm.plugin.ball.service.e
{
  t nAH;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f olt;
  private f.b olu;
  
  public e(com.tencent.mm.plugin.ball.a.f paramf, t paramt)
  {
    super(paramf);
    AppMethodBeat.i(44997);
    this.olu = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(44996);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (e.this.nAH != null) && (e.this.nAH.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (e.this.nAH.ntz.cBI == paramAnonymousAppBrandBackgroundRunningOperationParcel.cBU) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.aOm == 2) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.fvK == 1))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = e.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.cvD())
          {
            Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add passive location float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.le(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.lf(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.Fi(d.fu(paramAnonymousAppBrandBackgroundRunningOperationParcel.rYE.state, 1));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cvF();
            AppMethodBeat.o(44996);
            return;
          }
          Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add location state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.Fi(d.fu(paramAnonymousAppBrandBackgroundRunningOperationParcel.rYE.state, 1));
        }
        AppMethodBeat.o(44996);
      }
    };
    this.nAH = paramt;
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramt.hashCode()) });
    this.olt = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(44997);
  }
  
  private void zK(int paramInt)
  {
    AppMethodBeat.i(45000);
    cvL().opType = Fj(paramInt);
    cvG();
    Point localPoint = this.rYG.getBallPosition();
    c.a(this.rZC, localPoint, new a()
    {
      public final void aEa()
      {
        AppMethodBeat.i(44995);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        e.this.rZC.hS(true);
        AppMethodBeat.o(44995);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(44994);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        e.this.rZC.hS(false);
        AppMethodBeat.o(44994);
      }
    });
    AppMethodBeat.o(45000);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(44998);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.I(paramInt, paramString);
    if (this.olt != null) {
      this.olt.a(this.olu);
    }
    AppMethodBeat.o(44998);
  }
  
  public final boolean aOg()
  {
    return false;
  }
  
  public final boolean aOh()
  {
    return false;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(45004);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    this.rZC.hS(true);
    AppMethodBeat.o(45004);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(45003);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    if (cvA() != null) {
      A(true);
    }
    AppMethodBeat.o(45003);
  }
  
  public final void bNV()
  {
    AppMethodBeat.i(45002);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    if (cvA() != null) {
      A(false);
    }
    AppMethodBeat.o(45002);
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(45005);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    super.bNW();
    bOf();
    AppMethodBeat.o(45005);
  }
  
  final void bOf()
  {
    AppMethodBeat.i(45006);
    if (h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.nAH.mAppId;
      localMMBackgroundRunningOperationParcel.aOm = 2;
      localMMBackgroundRunningOperationParcel.fvK = 2;
      Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "stopLocationBackground, appId:%s", new Object[] { this.nAH.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(45006);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(45001);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    super.onDestroy();
    if (this.olt != null) {
      this.olt.b(this.olu);
    }
    AppMethodBeat.o(45001);
  }
  
  public final boolean zH(final int paramInt)
  {
    AppMethodBeat.i(44999);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    if (cvD())
    {
      if (!com.tencent.mm.compatible.e.b.ct(this.rZC.getActivity())) {
        AppBrandFloatBallPermissionHelper.a(this.rZC.getActivity(), 7, new c.a()
        {
          public final void hR(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(44993);
            Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              e.a(e.this, paramInt);
              AppMethodBeat.o(44993);
              return;
            }
            Log.w("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, refuse permission, remove ball and stop location");
            e.this.cvE();
            e.this.bOf();
            e.this.rZC.hS(true);
            AppMethodBeat.o(44993);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(44999);
        return true;
        zK(paramInt);
      }
    }
    AppMethodBeat.o(44999);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.e
 * JD-Core Version:    0.7.0.1
 */