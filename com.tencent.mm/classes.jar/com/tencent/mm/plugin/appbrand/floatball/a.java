package com.tencent.mm.plugin.appbrand.floatball;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class a
  extends e
{
  final String exO;
  final w qts;
  private final com.tencent.mm.plugin.appbrand.backgroundrunning.f roC;
  volatile boolean roD;
  private f.b roE;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf, w paramw)
  {
    super(paramf);
    AppMethodBeat.i(318229);
    this.exO = ("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper#" + hashCode());
    this.roD = false;
    this.roE = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(318270);
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel == null)
        {
          AppMethodBeat.o(318270);
          return;
        }
        if ((!a.this.qts.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) || (a.this.qts.qsh.eul != paramAnonymousAppBrandBackgroundRunningOperationParcel.euz))
        {
          AppMethodBeat.o(318270);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.cIi != 8)
        {
          AppMethodBeat.o(318270);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.hAf == 1)
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.cYo())
          {
            Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.exO, "onSendBackgroundRunningOperation, add passive audio of video background play float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.ahU(paramAnonymousAppBrandBackgroundRunningOperationParcel.col());
            paramAnonymousAppBrandBackgroundRunningOperationParcel.mr(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.ms(false);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.FJ(d.gm(paramAnonymousAppBrandBackgroundRunningOperationParcel.vjV.state, 128));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cYv().mUU = 13;
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cYr();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cYq();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.roD = true;
            AppMethodBeat.o(318270);
            return;
          }
          Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.exO, "onSendBackgroundRunningOperation, add audio of video background play state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.FJ(d.gm(paramAnonymousAppBrandBackgroundRunningOperationParcel.vjV.state, 128));
          paramAnonymousAppBrandBackgroundRunningOperationParcel.mr(true);
          AppMethodBeat.o(318270);
          return;
        }
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel.hAf == 2) || (paramAnonymousAppBrandBackgroundRunningOperationParcel.hAf == 3))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          BallInfo localBallInfo = paramAnonymousAppBrandBackgroundRunningOperationParcel.cYi();
          if (localBallInfo != null)
          {
            if (localBallInfo.vjH)
            {
              Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.exO, "removeBackgroundPlayAudioBall, remove passive float ball");
              paramAnonymousAppBrandBackgroundRunningOperationParcel.cYp();
              paramAnonymousAppBrandBackgroundRunningOperationParcel.roD = false;
              AppMethodBeat.o(318270);
              return;
            }
            Log.w(paramAnonymousAppBrandBackgroundRunningOperationParcel.exO, "removeBackgroundPlayAudioBall, passive is false");
            AppMethodBeat.o(318270);
            return;
          }
          Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.exO, "removeBackgroundPlayAudioBall, no this float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.FJ(d.gn(paramAnonymousAppBrandBackgroundRunningOperationParcel.vjV.state, 128));
        }
        AppMethodBeat.o(318270);
      }
    };
    this.qts = paramw;
    Log.i(this.exO, "create, runtime:%s", new Object[] { Integer.valueOf(paramw.hashCode()) });
    this.roC = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(318229);
  }
  
  private void zY(int paramInt)
  {
    AppMethodBeat.i(318234);
    cYv().opType = FK(paramInt);
    cYr();
    Point localPoint = this.vjX.getBallPosition();
    c.a(this.vkT, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void aXe()
      {
        AppMethodBeat.i(318250);
        Log.i(a.this.exO, "onCloseWithAnimation, transform to float ball animation cancel");
        a.this.vkT.iR(true);
        AppMethodBeat.o(318250);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(318242);
        Log.i(a.this.exO, "onCloseWithAnimation, transform to float ball animation end");
        a.this.vkT.iR(false);
        AppMethodBeat.o(318242);
      }
    });
    AppMethodBeat.o(318234);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(318269);
    Log.i(this.exO, "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.J(paramInt, paramString);
    if (this.roC != null) {
      this.roC.a(this.roE);
    }
    AppMethodBeat.o(318269);
  }
  
  public final void as(int paramInt, String paramString)
  {
    AppMethodBeat.i(318325);
    Log.i(this.exO, "onReceivedBallInfoAddedEvent, runtime:%s, type: %d, key: %s", new Object[] { Integer.valueOf(this.qts.hashCode()), Integer.valueOf(paramInt), paramString });
    super.as(paramInt, paramString);
    if (this.vjV != null) {
      Log.i(this.exO, "onReceivedBallInfoAddedEvent, myType: %d, myKey: %s", new Object[] { Integer.valueOf(this.vjV.type), this.vjV.key });
    }
    if ((this.vjV != null) && (paramInt == this.vjV.type) && (Objects.equals(paramString, this.vjV.key)))
    {
      Log.i(this.exO, "onReceivedBallInfoAddedEvent, myself");
      AppMethodBeat.o(318325);
      return;
    }
    if ((6 == paramInt) || (18 == paramInt) || (9 == paramInt) || (17 == paramInt))
    {
      cYp();
      this.roD = false;
    }
    AppMethodBeat.o(318325);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(318313);
    Log.i(this.exO, "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.qts.hashCode()) });
    this.vkT.iR(true);
    AppMethodBeat.o(318313);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(318309);
    Log.i(this.exO, "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.qts.hashCode()) });
    if (cYl() != null) {
      E(true);
    }
    AppMethodBeat.o(318309);
  }
  
  public final void coi()
  {
    AppMethodBeat.i(318302);
    Log.i(this.exO, "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.qts.hashCode()) });
    if (cYl() != null) {
      E(false);
    }
    AppMethodBeat.o(318302);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(318317);
    Log.i(this.exO, "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.qts.hashCode()) });
    super.coj();
    this.roD = false;
    cok();
    AppMethodBeat.o(318317);
  }
  
  final void cok()
  {
    AppMethodBeat.i(318331);
    if (this.roC == null)
    {
      AppMethodBeat.o(318331);
      return;
    }
    MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
    localMMBackgroundRunningOperationParcel.appId = this.qts.mAppId;
    localMMBackgroundRunningOperationParcel.cIi = 8;
    localMMBackgroundRunningOperationParcel.hAf = 2;
    Log.i(this.exO, "maybeStopBackgroundPlayAudio, appId:%s", new Object[] { this.qts.mAppId });
    this.roC.a(localMMBackgroundRunningOperationParcel);
    AppMethodBeat.o(318331);
  }
  
  final String col()
  {
    AppMethodBeat.i(318337);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.al.a)this.qts.aO(com.tencent.mm.plugin.appbrand.jsapi.al.a.class);
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.al.a)localObject1).cyx();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = this.qts.getInitConfig().hEy;
      }
      AppMethodBeat.o(318337);
      return localObject2;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(318293);
    Log.i(this.exO, "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.qts.hashCode()) });
    super.onDestroy();
    if (this.roC != null) {
      this.roC.b(this.roE);
    }
    AppMethodBeat.o(318293);
  }
  
  public final boolean zX(final int paramInt)
  {
    AppMethodBeat.i(318283);
    Log.i(this.exO, "onClose, runtime:%s", new Object[] { Integer.valueOf(this.qts.hashCode()) });
    k.d locald = k.Uo(this.qts.mAppId);
    Log.i(this.exO, "onRuntimeBackground, type: ".concat(String.valueOf(locald)));
    com.tencent.mm.plugin.appbrand.jsapi.al.a locala = (com.tencent.mm.plugin.appbrand.jsapi.al.a)this.qts.aO(com.tencent.mm.plugin.appbrand.jsapi.al.a.class);
    if (locala == null)
    {
      Log.w(this.exO, "onRuntimeBackground, audioOfVideoBackgroundPlayManager is null");
      if ((!cYo()) && (!this.roD)) {
        break label164;
      }
      if (com.tencent.mm.compatible.e.b.dh(this.vkT.getActivity())) {
        break label156;
      }
      AppBrandFloatBallPermissionHelper.a(this.vkT.getActivity(), 18, new c.a()
      {
        public final void onCheckResult(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(318255);
          Log.i(a.this.exO, "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            a.a(a.this, paramInt);
            a.a(a.this, true);
            AppMethodBeat.o(318255);
            return;
          }
          Log.w(a.this.exO, "onClose, refuse permission, remove ball and stop background play");
          a.this.cYp();
          a.this.roD = false;
          a.this.cok();
          a.a(a.this, false);
          a.this.vkT.iR(true);
          AppMethodBeat.o(318255);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(318283);
      return true;
      locala.c(locald);
      break;
      label156:
      zY(paramInt);
    }
    label164:
    AppMethodBeat.o(318283);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.a
 * JD-Core Version:    0.7.0.1
 */