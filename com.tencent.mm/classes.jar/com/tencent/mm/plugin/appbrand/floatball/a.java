package com.tencent.mm.plugin.appbrand.floatball;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Objects;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  final o iEx;
  private final com.tencent.mm.plugin.appbrand.backgroundrunning.g joR;
  volatile boolean joS;
  private g.b joT;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(195711);
    this.joS = false;
    this.joT = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(195707);
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel == null)
        {
          AppMethodBeat.o(195707);
          return;
        }
        if ((!a.this.iEx.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) || (a.this.iEx.iDx.iOP != paramAnonymousAppBrandBackgroundRunningOperationParcel.gXn))
        {
          AppMethodBeat.o(195707);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.aTC != 8)
        {
          AppMethodBeat.o(195707);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.dbV == 1)
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.bzs())
          {
            ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onSendBackgroundRunningOperation, add passive audio of video background play float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.OE(paramAnonymousAppBrandBackgroundRunningOperationParcel.aWe());
            paramAnonymousAppBrandBackgroundRunningOperationParcel.in(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.io(false);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.wB(d.eB(paramAnonymousAppBrandBackgroundRunningOperationParcel.mDH.state, 128));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bzz().mDz = 13;
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bzv();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bzu();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.joS = true;
            AppMethodBeat.o(195707);
            return;
          }
          ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onSendBackgroundRunningOperation, add audio of video background play state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.wB(d.eB(paramAnonymousAppBrandBackgroundRunningOperationParcel.mDH.state, 128));
          paramAnonymousAppBrandBackgroundRunningOperationParcel.in(true);
          AppMethodBeat.o(195707);
          return;
        }
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel.dbV == 2) || (paramAnonymousAppBrandBackgroundRunningOperationParcel.dbV == 3))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          BallInfo localBallInfo = paramAnonymousAppBrandBackgroundRunningOperationParcel.byO();
          if (localBallInfo != null)
          {
            if (localBallInfo.mDu)
            {
              ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "removeBackgroundPlayAudioBall, remove passive float ball");
              paramAnonymousAppBrandBackgroundRunningOperationParcel.bzt();
              paramAnonymousAppBrandBackgroundRunningOperationParcel.joS = false;
              AppMethodBeat.o(195707);
              return;
            }
            ad.w("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "removeBackgroundPlayAudioBall, passive is false");
            AppMethodBeat.o(195707);
            return;
          }
          ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "removeBackgroundPlayAudioBall, no this float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.wB(d.eC(paramAnonymousAppBrandBackgroundRunningOperationParcel.mDH.state, 128));
        }
        AppMethodBeat.o(195707);
      }
    };
    this.iEx = paramo;
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.joR = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    AppMethodBeat.o(195711);
  }
  
  private void rh(int paramInt)
  {
    AppMethodBeat.i(195720);
    bzz().opType = wD(paramInt);
    bzv();
    Point localPoint = this.mDJ.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.mEA, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void aWf()
      {
        AppMethodBeat.i(195710);
        ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onCloseWithAnimation, transform to float ball animation cancel");
        a.this.mEA.fF(true);
        AppMethodBeat.o(195710);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(195709);
        ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onCloseWithAnimation, transform to float ball animation end");
        a.this.mEA.fF(false);
        AppMethodBeat.o(195709);
      }
    });
    AppMethodBeat.o(195720);
  }
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(195712);
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.Z(paramInt, paramString);
    if (this.joR != null) {
      this.joR.a(this.joT);
    }
    AppMethodBeat.o(195712);
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
    AppMethodBeat.i(195715);
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.iEx.hashCode()) });
    if (bzq() != null) {
      V(false);
    }
    AppMethodBeat.o(195715);
  }
  
  public final void aWa()
  {
    AppMethodBeat.i(195716);
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.iEx.hashCode()) });
    if (bzq() != null) {
      V(true);
    }
    AppMethodBeat.o(195716);
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(195717);
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.iEx.hashCode()) });
    this.mEA.fF(true);
    AppMethodBeat.o(195717);
  }
  
  public final void aWc()
  {
    AppMethodBeat.i(195718);
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.iEx.hashCode()) });
    super.aWc();
    this.joS = false;
    aWd();
    AppMethodBeat.o(195718);
  }
  
  final void aWd()
  {
    AppMethodBeat.i(195721);
    if (this.joR == null)
    {
      AppMethodBeat.o(195721);
      return;
    }
    MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
    localMMBackgroundRunningOperationParcel.appId = this.iEx.mAppId;
    localMMBackgroundRunningOperationParcel.aTC = 8;
    localMMBackgroundRunningOperationParcel.dbV = 2;
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "maybeStopBackgroundPlayAudio, appId:%s", new Object[] { this.iEx.mAppId });
    this.joR.a(localMMBackgroundRunningOperationParcel);
    AppMethodBeat.o(195721);
  }
  
  final String aWe()
  {
    AppMethodBeat.i(195722);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.aa.a)this.iEx.as(com.tencent.mm.plugin.appbrand.jsapi.aa.a.class);
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.aa.a)localObject1).beT();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = this.iEx.aNc().dfM;
      }
      AppMethodBeat.o(195722);
      return localObject2;
    }
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(195719);
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onReceivedBallInfoAddedEvent, runtime:%s, type: %d, key: %s", new Object[] { Integer.valueOf(this.iEx.hashCode()), Integer.valueOf(paramInt), paramString });
    super.aa(paramInt, paramString);
    if (this.mDH != null) {
      ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onReceivedBallInfoAddedEvent, myType: %d, myKey: %s", new Object[] { Integer.valueOf(this.mDH.type), this.mDH.key });
    }
    if ((this.mDH != null) && (paramInt == this.mDH.type) && (Objects.equals(paramString, this.mDH.key)))
    {
      ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onReceivedBallInfoAddedEvent, myself");
      AppMethodBeat.o(195719);
      return;
    }
    if ((6 == paramInt) || (18 == paramInt) || (9 == paramInt) || (17 == paramInt))
    {
      bzt();
      this.joS = false;
    }
    AppMethodBeat.o(195719);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(195714);
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.iEx.hashCode()) });
    super.onDestroy();
    if (this.joR != null) {
      this.joR.b(this.joT);
    }
    AppMethodBeat.o(195714);
  }
  
  public final boolean rg(final int paramInt)
  {
    AppMethodBeat.i(195713);
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.iEx.hashCode()) });
    g.d locald = com.tencent.mm.plugin.appbrand.g.Dd(this.iEx.mAppId);
    ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onRuntimeBackground, type: ".concat(String.valueOf(locald)));
    com.tencent.mm.plugin.appbrand.jsapi.aa.a locala = (com.tencent.mm.plugin.appbrand.jsapi.aa.a)this.iEx.as(com.tencent.mm.plugin.appbrand.jsapi.aa.a.class);
    if (locala == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onRuntimeBackground, audioOfVideoBackgroundPlayManager is null");
      if ((!bzs()) && (!this.joS)) {
        break label158;
      }
      if (b.bZ(this.mEA.getActivity())) {
        break label150;
      }
      AppBrandFloatBallPermissionHelper.a(this.mEA.getActivity(), 18, new c.a()
      {
        public final void fD(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(195708);
          ad.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            a.a(a.this, paramInt);
            a.a(a.this, true);
            AppMethodBeat.o(195708);
            return;
          }
          ad.w("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onClose, refuse permission, remove ball and stop background play");
          a.this.bzt();
          a.this.joS = false;
          a.this.aWd();
          a.a(a.this, false);
          a.this.mEA.fF(true);
          AppMethodBeat.o(195708);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(195713);
      return true;
      locala.c(locald);
      break;
      label150:
      rh(paramInt);
    }
    label158:
    AppMethodBeat.o(195713);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.a
 * JD-Core Version:    0.7.0.1
 */