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
import com.tencent.mm.plugin.appbrand.t;
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
  final String cED;
  final t nuJ;
  private final com.tencent.mm.plugin.appbrand.backgroundrunning.f okY;
  volatile boolean okZ;
  private f.b ola;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf, t paramt)
  {
    super(paramf);
    AppMethodBeat.i(270222);
    this.cED = ("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper#" + hashCode());
    this.okZ = false;
    this.ola = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(278723);
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel == null)
        {
          AppMethodBeat.o(278723);
          return;
        }
        if ((!a.this.nuJ.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) || (a.this.nuJ.ntz.cBI != paramAnonymousAppBrandBackgroundRunningOperationParcel.cBU))
        {
          AppMethodBeat.o(278723);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.aOm != 8)
        {
          AppMethodBeat.o(278723);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.fvK == 1)
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.cvD())
          {
            Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.cED, "onSendBackgroundRunningOperation, add passive audio of video background play float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.aoy(paramAnonymousAppBrandBackgroundRunningOperationParcel.bNY());
            paramAnonymousAppBrandBackgroundRunningOperationParcel.le(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.lf(false);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.Fi(d.fu(paramAnonymousAppBrandBackgroundRunningOperationParcel.rYE.state, 128));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cvL().kqZ = 13;
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cvG();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cvF();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.okZ = true;
            AppMethodBeat.o(278723);
            return;
          }
          Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.cED, "onSendBackgroundRunningOperation, add audio of video background play state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.Fi(d.fu(paramAnonymousAppBrandBackgroundRunningOperationParcel.rYE.state, 128));
          paramAnonymousAppBrandBackgroundRunningOperationParcel.le(true);
          AppMethodBeat.o(278723);
          return;
        }
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel.fvK == 2) || (paramAnonymousAppBrandBackgroundRunningOperationParcel.fvK == 3))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          BallInfo localBallInfo = paramAnonymousAppBrandBackgroundRunningOperationParcel.cvx();
          if (localBallInfo != null)
          {
            if (localBallInfo.rYr)
            {
              Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.cED, "removeBackgroundPlayAudioBall, remove passive float ball");
              paramAnonymousAppBrandBackgroundRunningOperationParcel.cvE();
              paramAnonymousAppBrandBackgroundRunningOperationParcel.okZ = false;
              AppMethodBeat.o(278723);
              return;
            }
            Log.w(paramAnonymousAppBrandBackgroundRunningOperationParcel.cED, "removeBackgroundPlayAudioBall, passive is false");
            AppMethodBeat.o(278723);
            return;
          }
          Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.cED, "removeBackgroundPlayAudioBall, no this float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.Fi(d.fv(paramAnonymousAppBrandBackgroundRunningOperationParcel.rYE.state, 128));
        }
        AppMethodBeat.o(278723);
      }
    };
    this.nuJ = paramt;
    Log.i(this.cED, "create, runtime:%s", new Object[] { Integer.valueOf(paramt.hashCode()) });
    this.okY = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(270222);
  }
  
  private void zI(int paramInt)
  {
    AppMethodBeat.i(270233);
    cvL().opType = Fj(paramInt);
    cvG();
    Point localPoint = this.rYG.getBallPosition();
    c.a(this.rZC, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void aEa()
      {
        AppMethodBeat.i(267377);
        Log.i(a.this.cED, "onCloseWithAnimation, transform to float ball animation cancel");
        a.this.rZC.hS(true);
        AppMethodBeat.o(267377);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(267376);
        Log.i(a.this.cED, "onCloseWithAnimation, transform to float ball animation end");
        a.this.rZC.hS(false);
        AppMethodBeat.o(267376);
      }
    });
    AppMethodBeat.o(270233);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(270225);
    Log.i(this.cED, "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.I(paramInt, paramString);
    if (this.okY != null) {
      this.okY.a(this.ola);
    }
    AppMethodBeat.o(270225);
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
    AppMethodBeat.i(270230);
    Log.i(this.cED, "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.nuJ.hashCode()) });
    this.rZC.hS(true);
    AppMethodBeat.o(270230);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(270229);
    Log.i(this.cED, "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.nuJ.hashCode()) });
    if (cvA() != null) {
      A(true);
    }
    AppMethodBeat.o(270229);
  }
  
  public final void ai(int paramInt, String paramString)
  {
    AppMethodBeat.i(270232);
    Log.i(this.cED, "onReceivedBallInfoAddedEvent, runtime:%s, type: %d, key: %s", new Object[] { Integer.valueOf(this.nuJ.hashCode()), Integer.valueOf(paramInt), paramString });
    super.ai(paramInt, paramString);
    if (this.rYE != null) {
      Log.i(this.cED, "onReceivedBallInfoAddedEvent, myType: %d, myKey: %s", new Object[] { Integer.valueOf(this.rYE.type), this.rYE.key });
    }
    if ((this.rYE != null) && (paramInt == this.rYE.type) && (Objects.equals(paramString, this.rYE.key)))
    {
      Log.i(this.cED, "onReceivedBallInfoAddedEvent, myself");
      AppMethodBeat.o(270232);
      return;
    }
    if ((6 == paramInt) || (18 == paramInt) || (9 == paramInt) || (17 == paramInt))
    {
      cvE();
      this.okZ = false;
    }
    AppMethodBeat.o(270232);
  }
  
  public final void bNV()
  {
    AppMethodBeat.i(270228);
    Log.i(this.cED, "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.nuJ.hashCode()) });
    if (cvA() != null) {
      A(false);
    }
    AppMethodBeat.o(270228);
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(270231);
    Log.i(this.cED, "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.nuJ.hashCode()) });
    super.bNW();
    this.okZ = false;
    bNX();
    AppMethodBeat.o(270231);
  }
  
  final void bNX()
  {
    AppMethodBeat.i(270234);
    if (this.okY == null)
    {
      AppMethodBeat.o(270234);
      return;
    }
    MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
    localMMBackgroundRunningOperationParcel.appId = this.nuJ.mAppId;
    localMMBackgroundRunningOperationParcel.aOm = 8;
    localMMBackgroundRunningOperationParcel.fvK = 2;
    Log.i(this.cED, "maybeStopBackgroundPlayAudio, appId:%s", new Object[] { this.nuJ.mAppId });
    this.okY.a(localMMBackgroundRunningOperationParcel);
    AppMethodBeat.o(270234);
  }
  
  final String bNY()
  {
    AppMethodBeat.i(270235);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.ai.a)this.nuJ.av(com.tencent.mm.plugin.appbrand.jsapi.ai.a.class);
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.ai.a)localObject1).bYh();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = this.nuJ.bDy().fzM;
      }
      AppMethodBeat.o(270235);
      return localObject2;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(270227);
    Log.i(this.cED, "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.nuJ.hashCode()) });
    super.onDestroy();
    if (this.okY != null) {
      this.okY.b(this.ola);
    }
    AppMethodBeat.o(270227);
  }
  
  public final boolean zH(final int paramInt)
  {
    AppMethodBeat.i(270226);
    Log.i(this.cED, "onClose, runtime:%s", new Object[] { Integer.valueOf(this.nuJ.hashCode()) });
    k.d locald = k.abM(this.nuJ.mAppId);
    Log.i(this.cED, "onRuntimeBackground, type: ".concat(String.valueOf(locald)));
    com.tencent.mm.plugin.appbrand.jsapi.ai.a locala = (com.tencent.mm.plugin.appbrand.jsapi.ai.a)this.nuJ.av(com.tencent.mm.plugin.appbrand.jsapi.ai.a.class);
    if (locala == null)
    {
      Log.w(this.cED, "onRuntimeBackground, audioOfVideoBackgroundPlayManager is null");
      if ((!cvD()) && (!this.okZ)) {
        break label164;
      }
      if (com.tencent.mm.compatible.e.b.ct(this.rZC.getActivity())) {
        break label156;
      }
      AppBrandFloatBallPermissionHelper.a(this.rZC.getActivity(), 18, new c.a()
      {
        public final void hR(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(266769);
          Log.i(a.this.cED, "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            a.a(a.this, paramInt);
            a.a(a.this, true);
            AppMethodBeat.o(266769);
            return;
          }
          Log.w(a.this.cED, "onClose, refuse permission, remove ball and stop background play");
          a.this.cvE();
          a.this.okZ = false;
          a.this.bNX();
          a.a(a.this, false);
          a.this.rZC.hS(true);
          AppMethodBeat.o(266769);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(270226);
      return true;
      locala.c(locald);
      break;
      label156:
      zI(paramInt);
    }
    label164:
    AppMethodBeat.o(270226);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.a
 * JD-Core Version:    0.7.0.1
 */