package com.tencent.mm.plugin.appbrand.floatball;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends com.tencent.mm.plugin.ball.service.f
{
  q kGW;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f lqJ;
  private f.b lqK;
  
  public e(com.tencent.mm.plugin.ball.a.f paramf, q paramq)
  {
    super(paramf);
    AppMethodBeat.i(44997);
    this.lqK = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(44996);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (e.this.kGW != null) && (e.this.kGW.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (e.this.kGW.kAq.eix == paramAnonymousAppBrandBackgroundRunningOperationParcel.iOo) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.beL == 2) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dDe == 1))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = e.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.ciq())
          {
            Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add passive location float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.jT(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.jU(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.BH(d.eV(paramAnonymousAppBrandBackgroundRunningOperationParcel.oWE.state, 1));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cis();
            AppMethodBeat.o(44996);
            return;
          }
          Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add location state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.BH(d.eV(paramAnonymousAppBrandBackgroundRunningOperationParcel.oWE.state, 1));
        }
        AppMethodBeat.o(44996);
      }
    };
    this.kGW = paramq;
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramq.hashCode()) });
    this.lqJ = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(44997);
  }
  
  private void wx(int paramInt)
  {
    AppMethodBeat.i(45000);
    ciw().opType = BI(paramInt);
    cit();
    Point localPoint = this.oWG.getBallPosition();
    c.a(this.oXA, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void awJ()
      {
        AppMethodBeat.i(44995);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        e.this.oXA.hb(true);
        AppMethodBeat.o(44995);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(44994);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        e.this.oXA.hb(false);
        AppMethodBeat.o(44994);
      }
    });
    AppMethodBeat.o(45000);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(44998);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.G(paramInt, paramString);
    if (this.lqJ != null) {
      this.lqJ.a(this.lqK);
    }
    AppMethodBeat.o(44998);
  }
  
  public final boolean aGg()
  {
    return false;
  }
  
  public final boolean aGh()
  {
    return false;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(45004);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    this.oXA.hb(true);
    AppMethodBeat.o(45004);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(45003);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    if (cin() != null) {
      U(true);
    }
    AppMethodBeat.o(45003);
  }
  
  public final void bCA()
  {
    AppMethodBeat.i(45002);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    if (cin() != null) {
      U(false);
    }
    AppMethodBeat.o(45002);
  }
  
  public final void bCB()
  {
    AppMethodBeat.i(45005);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    super.bCB();
    bCK();
    AppMethodBeat.o(45005);
  }
  
  final void bCK()
  {
    AppMethodBeat.i(45006);
    if (g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.kGW.mAppId;
      localMMBackgroundRunningOperationParcel.beL = 2;
      localMMBackgroundRunningOperationParcel.dDe = 2;
      Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "stopLocationBackground, appId:%s", new Object[] { this.kGW.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(45006);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(45001);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    super.onDestroy();
    if (this.lqJ != null) {
      this.lqJ.b(this.lqK);
    }
    AppMethodBeat.o(45001);
  }
  
  public final boolean wu(final int paramInt)
  {
    AppMethodBeat.i(44999);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    if (ciq())
    {
      if (!com.tencent.mm.compatible.e.b.cx(this.oXA.getActivity())) {
        AppBrandFloatBallPermissionHelper.a(this.oXA.getActivity(), 7, new c.a()
        {
          public final void ha(boolean paramAnonymousBoolean)
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
            e.this.cir();
            e.this.bCK();
            e.this.oXA.hb(true);
            AppMethodBeat.o(44993);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(44999);
        return true;
        wx(paramInt);
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