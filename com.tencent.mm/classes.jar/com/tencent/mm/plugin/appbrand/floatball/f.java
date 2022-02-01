package com.tencent.mm.plugin.appbrand.floatball;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends e
{
  w qxC;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f rpc;
  private f.b rpd;
  
  public f(com.tencent.mm.plugin.ball.a.f paramf, w paramw)
  {
    super(paramf);
    AppMethodBeat.i(44997);
    this.rpd = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(44996);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (f.this.qxC != null) && (f.this.qxC.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (f.this.qxC.qsh.eul == paramAnonymousAppBrandBackgroundRunningOperationParcel.euz) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.cIi == 2) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.hAf == 1))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = f.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.cYo())
          {
            Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add passive location float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.mr(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.ms(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.FJ(d.gm(paramAnonymousAppBrandBackgroundRunningOperationParcel.vjV.state, 1));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cYq();
            AppMethodBeat.o(44996);
            return;
          }
          Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add location state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.FJ(d.gm(paramAnonymousAppBrandBackgroundRunningOperationParcel.vjV.state, 1));
        }
        AppMethodBeat.o(44996);
      }
    };
    this.qxC = paramw;
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramw.hashCode()) });
    this.rpc = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(44997);
  }
  
  private void Ab(int paramInt)
  {
    AppMethodBeat.i(45000);
    cYv().opType = FK(paramInt);
    cYr();
    Point localPoint = this.vjX.getBallPosition();
    c.a(this.vkT, localPoint, new a()
    {
      public final void aXe()
      {
        AppMethodBeat.i(44995);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        f.this.vkT.iR(true);
        AppMethodBeat.o(44995);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(44994);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        f.this.vkT.iR(false);
        AppMethodBeat.o(44994);
      }
    });
    AppMethodBeat.o(45000);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(44998);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.J(paramInt, paramString);
    if (this.rpc != null) {
      this.rpc.a(this.rpd);
    }
    AppMethodBeat.o(44998);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(45004);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    this.vkT.iR(true);
    AppMethodBeat.o(45004);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(45003);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    if (cYl() != null) {
      E(true);
    }
    AppMethodBeat.o(45003);
  }
  
  public final void coi()
  {
    AppMethodBeat.i(45002);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    if (cYl() != null) {
      E(false);
    }
    AppMethodBeat.o(45002);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(45005);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    super.coj();
    cos();
    AppMethodBeat.o(45005);
  }
  
  final void cos()
  {
    AppMethodBeat.i(45006);
    if (h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.qxC.mAppId;
      localMMBackgroundRunningOperationParcel.cIi = 2;
      localMMBackgroundRunningOperationParcel.hAf = 2;
      Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "stopLocationBackground, appId:%s", new Object[] { this.qxC.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(45006);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(45001);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    super.onDestroy();
    if (this.rpc != null) {
      this.rpc.b(this.rpd);
    }
    AppMethodBeat.o(45001);
  }
  
  public final boolean zX(final int paramInt)
  {
    AppMethodBeat.i(44999);
    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    if (cYo())
    {
      if (!com.tencent.mm.compatible.e.b.dh(this.vkT.getActivity())) {
        AppBrandFloatBallPermissionHelper.a(this.vkT.getActivity(), 7, new c.a()
        {
          public final void onCheckResult(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(44993);
            Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              f.a(f.this, paramInt);
              AppMethodBeat.o(44993);
              return;
            }
            Log.w("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, refuse permission, remove ball and stop location");
            f.this.cYp();
            f.this.cos();
            f.this.vkT.iR(true);
            AppMethodBeat.o(44993);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(44999);
        return true;
        Ab(paramInt);
      }
    }
    AppMethodBeat.o(44999);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.f
 * JD-Core Version:    0.7.0.1
 */