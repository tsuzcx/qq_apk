package com.tencent.mm.plugin.appbrand.floatball;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  final String cDW;
  final q kBw;
  private final com.tencent.mm.plugin.appbrand.backgroundrunning.f lqo;
  volatile boolean lqp;
  private f.b lqq;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf, q paramq)
  {
    super(paramf);
    AppMethodBeat.i(226517);
    this.cDW = ("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper#" + hashCode());
    this.lqp = false;
    this.lqq = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(226513);
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel == null)
        {
          AppMethodBeat.o(226513);
          return;
        }
        if ((!a.this.kBw.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) || (a.this.kBw.kAq.eix != paramAnonymousAppBrandBackgroundRunningOperationParcel.iOo))
        {
          AppMethodBeat.o(226513);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.beL != 8)
        {
          AppMethodBeat.o(226513);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.dDe == 1)
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.ciq())
          {
            Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.cDW, "onSendBackgroundRunningOperation, add passive audio of video background play float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.agT(paramAnonymousAppBrandBackgroundRunningOperationParcel.bCD());
            paramAnonymousAppBrandBackgroundRunningOperationParcel.jT(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.jU(false);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.BH(d.eV(paramAnonymousAppBrandBackgroundRunningOperationParcel.oWE.state, 128));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.ciw().hDa = 13;
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cit();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.cis();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.lqp = true;
            AppMethodBeat.o(226513);
            return;
          }
          Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.cDW, "onSendBackgroundRunningOperation, add audio of video background play state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.BH(d.eV(paramAnonymousAppBrandBackgroundRunningOperationParcel.oWE.state, 128));
          paramAnonymousAppBrandBackgroundRunningOperationParcel.jT(true);
          AppMethodBeat.o(226513);
          return;
        }
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel.dDe == 2) || (paramAnonymousAppBrandBackgroundRunningOperationParcel.dDe == 3))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          BallInfo localBallInfo = paramAnonymousAppBrandBackgroundRunningOperationParcel.cil();
          if (localBallInfo != null)
          {
            if (localBallInfo.oWr)
            {
              Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.cDW, "removeBackgroundPlayAudioBall, remove passive float ball");
              paramAnonymousAppBrandBackgroundRunningOperationParcel.cir();
              paramAnonymousAppBrandBackgroundRunningOperationParcel.lqp = false;
              AppMethodBeat.o(226513);
              return;
            }
            Log.w(paramAnonymousAppBrandBackgroundRunningOperationParcel.cDW, "removeBackgroundPlayAudioBall, passive is false");
            AppMethodBeat.o(226513);
            return;
          }
          Log.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.cDW, "removeBackgroundPlayAudioBall, no this float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.BH(d.eW(paramAnonymousAppBrandBackgroundRunningOperationParcel.oWE.state, 128));
        }
        AppMethodBeat.o(226513);
      }
    };
    this.kBw = paramq;
    Log.i(this.cDW, "create, runtime:%s", new Object[] { Integer.valueOf(paramq.hashCode()) });
    this.lqo = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(226517);
  }
  
  private void wv(int paramInt)
  {
    AppMethodBeat.i(226526);
    ciw().opType = BI(paramInt);
    cit();
    Point localPoint = this.oWG.getBallPosition();
    c.a(this.oXA, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void awJ()
      {
        AppMethodBeat.i(226516);
        Log.i(a.this.cDW, "onCloseWithAnimation, transform to float ball animation cancel");
        a.this.oXA.hb(true);
        AppMethodBeat.o(226516);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(226515);
        Log.i(a.this.cDW, "onCloseWithAnimation, transform to float ball animation end");
        a.this.oXA.hb(false);
        AppMethodBeat.o(226515);
      }
    });
    AppMethodBeat.o(226526);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(226518);
    Log.i(this.cDW, "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.G(paramInt, paramString);
    if (this.lqo != null) {
      this.lqo.a(this.lqq);
    }
    AppMethodBeat.o(226518);
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
    AppMethodBeat.i(226523);
    Log.i(this.cDW, "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.kBw.hashCode()) });
    this.oXA.hb(true);
    AppMethodBeat.o(226523);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(226522);
    Log.i(this.cDW, "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.kBw.hashCode()) });
    if (cin() != null) {
      U(true);
    }
    AppMethodBeat.o(226522);
  }
  
  public final void ag(int paramInt, String paramString)
  {
    AppMethodBeat.i(226525);
    Log.i(this.cDW, "onReceivedBallInfoAddedEvent, runtime:%s, type: %d, key: %s", new Object[] { Integer.valueOf(this.kBw.hashCode()), Integer.valueOf(paramInt), paramString });
    super.ag(paramInt, paramString);
    if (this.oWE != null) {
      Log.i(this.cDW, "onReceivedBallInfoAddedEvent, myType: %d, myKey: %s", new Object[] { Integer.valueOf(this.oWE.type), this.oWE.key });
    }
    if ((this.oWE != null) && (paramInt == this.oWE.type) && (Objects.equals(paramString, this.oWE.key)))
    {
      Log.i(this.cDW, "onReceivedBallInfoAddedEvent, myself");
      AppMethodBeat.o(226525);
      return;
    }
    if ((6 == paramInt) || (18 == paramInt) || (9 == paramInt) || (17 == paramInt))
    {
      cir();
      this.lqp = false;
    }
    AppMethodBeat.o(226525);
  }
  
  public final void bCA()
  {
    AppMethodBeat.i(226521);
    Log.i(this.cDW, "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.kBw.hashCode()) });
    if (cin() != null) {
      U(false);
    }
    AppMethodBeat.o(226521);
  }
  
  public final void bCB()
  {
    AppMethodBeat.i(226524);
    Log.i(this.cDW, "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.kBw.hashCode()) });
    super.bCB();
    this.lqp = false;
    bCC();
    AppMethodBeat.o(226524);
  }
  
  final void bCC()
  {
    AppMethodBeat.i(226527);
    if (this.lqo == null)
    {
      AppMethodBeat.o(226527);
      return;
    }
    MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
    localMMBackgroundRunningOperationParcel.appId = this.kBw.mAppId;
    localMMBackgroundRunningOperationParcel.beL = 8;
    localMMBackgroundRunningOperationParcel.dDe = 2;
    Log.i(this.cDW, "maybeStopBackgroundPlayAudio, appId:%s", new Object[] { this.kBw.mAppId });
    this.lqo.a(localMMBackgroundRunningOperationParcel);
    AppMethodBeat.o(226527);
  }
  
  final String bCD()
  {
    AppMethodBeat.i(226528);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.ag.a)this.kBw.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.ag.a)localObject1).bLQ();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = this.kBw.bsC().brandName;
      }
      AppMethodBeat.o(226528);
      return localObject2;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(226520);
    Log.i(this.cDW, "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.kBw.hashCode()) });
    super.onDestroy();
    if (this.lqo != null) {
      this.lqo.b(this.lqq);
    }
    AppMethodBeat.o(226520);
  }
  
  public final boolean wu(final int paramInt)
  {
    AppMethodBeat.i(226519);
    Log.i(this.cDW, "onClose, runtime:%s", new Object[] { Integer.valueOf(this.kBw.hashCode()) });
    h.d locald = h.Uc(this.kBw.mAppId);
    Log.i(this.cDW, "onRuntimeBackground, type: ".concat(String.valueOf(locald)));
    com.tencent.mm.plugin.appbrand.jsapi.ag.a locala = (com.tencent.mm.plugin.appbrand.jsapi.ag.a)this.kBw.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
    if (locala == null)
    {
      Log.w(this.cDW, "onRuntimeBackground, audioOfVideoBackgroundPlayManager is null");
      if ((!ciq()) && (!this.lqp)) {
        break label164;
      }
      if (com.tencent.mm.compatible.e.b.cx(this.oXA.getActivity())) {
        break label156;
      }
      AppBrandFloatBallPermissionHelper.a(this.oXA.getActivity(), 18, new c.a()
      {
        public final void ha(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(226514);
          Log.i(a.this.cDW, "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            a.a(a.this, paramInt);
            a.a(a.this, true);
            AppMethodBeat.o(226514);
            return;
          }
          Log.w(a.this.cDW, "onClose, refuse permission, remove ball and stop background play");
          a.this.cir();
          a.this.lqp = false;
          a.this.bCC();
          a.a(a.this, false);
          a.this.oXA.hb(true);
          AppMethodBeat.o(226514);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(226519);
      return true;
      locala.c(locald);
      break;
      label156:
      wv(paramInt);
    }
    label164:
    AppMethodBeat.o(226519);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.a
 * JD-Core Version:    0.7.0.1
 */