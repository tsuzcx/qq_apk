package com.tencent.mm.plugin.appbrand.floatball;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Objects;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  final String crG;
  final p jAF;
  private final com.tencent.mm.plugin.appbrand.backgroundrunning.f kmE;
  volatile boolean kmF;
  private f.b kmG;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf, p paramp)
  {
    super(paramf);
    AppMethodBeat.i(222253);
    this.crG = ("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper#" + hashCode());
    this.kmF = false;
    this.kmG = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(222249);
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel == null)
        {
          AppMethodBeat.o(222249);
          return;
        }
        if ((!a.this.jAF.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) || (a.this.jAF.jzC.dQv != paramAnonymousAppBrandBackgroundRunningOperationParcel.hSZ))
        {
          AppMethodBeat.o(222249);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.beO != 8)
        {
          AppMethodBeat.o(222249);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.dlO == 1)
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.bLw())
          {
            ae.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.crG, "onSendBackgroundRunningOperation, add passive audio of video background play float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.WY(paramAnonymousAppBrandBackgroundRunningOperationParcel.bho());
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iV(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iW(false);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.yc(d.eI(paramAnonymousAppBrandBackgroundRunningOperationParcel.nLK.state, 128));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bLD().nLC = 13;
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bLz();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bLy();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.kmF = true;
            AppMethodBeat.o(222249);
            return;
          }
          ae.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.crG, "onSendBackgroundRunningOperation, add audio of video background play state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.yc(d.eI(paramAnonymousAppBrandBackgroundRunningOperationParcel.nLK.state, 128));
          paramAnonymousAppBrandBackgroundRunningOperationParcel.iV(true);
          AppMethodBeat.o(222249);
          return;
        }
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel.dlO == 2) || (paramAnonymousAppBrandBackgroundRunningOperationParcel.dlO == 3))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          BallInfo localBallInfo = paramAnonymousAppBrandBackgroundRunningOperationParcel.bKS();
          if (localBallInfo != null)
          {
            if (localBallInfo.nLu)
            {
              ae.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.crG, "removeBackgroundPlayAudioBall, remove passive float ball");
              paramAnonymousAppBrandBackgroundRunningOperationParcel.bLx();
              paramAnonymousAppBrandBackgroundRunningOperationParcel.kmF = false;
              AppMethodBeat.o(222249);
              return;
            }
            ae.w(paramAnonymousAppBrandBackgroundRunningOperationParcel.crG, "removeBackgroundPlayAudioBall, passive is false");
            AppMethodBeat.o(222249);
            return;
          }
          ae.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.crG, "removeBackgroundPlayAudioBall, no this float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.yc(d.eJ(paramAnonymousAppBrandBackgroundRunningOperationParcel.nLK.state, 128));
        }
        AppMethodBeat.o(222249);
      }
    };
    this.jAF = paramp;
    ae.i(this.crG, "create, runtime:%s", new Object[] { Integer.valueOf(paramp.hashCode()) });
    this.kmE = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(222253);
  }
  
  private void sz(int paramInt)
  {
    AppMethodBeat.i(222262);
    bLD().opType = yd(paramInt);
    bLz();
    Point localPoint = this.nLM.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.nME, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bhp()
      {
        AppMethodBeat.i(222252);
        ae.i(a.this.crG, "onCloseWithAnimation, transform to float ball animation cancel");
        a.this.nME.ge(true);
        AppMethodBeat.o(222252);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(222251);
        ae.i(a.this.crG, "onCloseWithAnimation, transform to float ball animation end");
        a.this.nME.ge(false);
        AppMethodBeat.o(222251);
      }
    });
    AppMethodBeat.o(222262);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(222254);
    ae.i(this.crG, "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    if (this.kmE != null) {
      this.kmE.a(this.kmG);
    }
    AppMethodBeat.o(222254);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(222261);
    ae.i(this.crG, "onReceivedBallInfoAddedEvent, runtime:%s, type: %d, key: %s", new Object[] { Integer.valueOf(this.jAF.hashCode()), Integer.valueOf(paramInt), paramString });
    super.ad(paramInt, paramString);
    if (this.nLK != null) {
      ae.i(this.crG, "onReceivedBallInfoAddedEvent, myType: %d, myKey: %s", new Object[] { Integer.valueOf(this.nLK.type), this.nLK.key });
    }
    if ((this.nLK != null) && (paramInt == this.nLK.type) && (Objects.equals(paramString, this.nLK.key)))
    {
      ae.i(this.crG, "onReceivedBallInfoAddedEvent, myself");
      AppMethodBeat.o(222261);
      return;
    }
    if ((6 == paramInt) || (18 == paramInt) || (9 == paramInt) || (17 == paramInt))
    {
      bLx();
      this.kmF = false;
    }
    AppMethodBeat.o(222261);
  }
  
  public final boolean bhh()
  {
    return false;
  }
  
  public final boolean bhi()
  {
    return false;
  }
  
  public final void bhj()
  {
    AppMethodBeat.i(222257);
    ae.i(this.crG, "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jAF.hashCode()) });
    if (bLu() != null) {
      V(false);
    }
    AppMethodBeat.o(222257);
  }
  
  public final void bhk()
  {
    AppMethodBeat.i(222258);
    ae.i(this.crG, "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jAF.hashCode()) });
    if (bLu() != null) {
      V(true);
    }
    AppMethodBeat.o(222258);
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(222259);
    ae.i(this.crG, "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jAF.hashCode()) });
    this.nME.ge(true);
    AppMethodBeat.o(222259);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(222260);
    ae.i(this.crG, "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jAF.hashCode()) });
    super.bhm();
    this.kmF = false;
    bhn();
    AppMethodBeat.o(222260);
  }
  
  final void bhn()
  {
    AppMethodBeat.i(222263);
    if (this.kmE == null)
    {
      AppMethodBeat.o(222263);
      return;
    }
    MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
    localMMBackgroundRunningOperationParcel.appId = this.jAF.mAppId;
    localMMBackgroundRunningOperationParcel.beO = 8;
    localMMBackgroundRunningOperationParcel.dlO = 2;
    ae.i(this.crG, "maybeStopBackgroundPlayAudio, appId:%s", new Object[] { this.jAF.mAppId });
    this.kmE.a(localMMBackgroundRunningOperationParcel);
    AppMethodBeat.o(222263);
  }
  
  final String bho()
  {
    AppMethodBeat.i(222264);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.ad.a)this.jAF.as(com.tencent.mm.plugin.appbrand.jsapi.ad.a.class);
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.ad.a)localObject1).bqi();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (bu.isNullOrNil((String)localObject1)) {
        localObject2 = this.jAF.aXx().dpI;
      }
      AppMethodBeat.o(222264);
      return localObject2;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(222256);
    ae.i(this.crG, "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jAF.hashCode()) });
    super.onDestroy();
    if (this.kmE != null) {
      this.kmE.b(this.kmG);
    }
    AppMethodBeat.o(222256);
  }
  
  public final boolean sy(final int paramInt)
  {
    AppMethodBeat.i(222255);
    ae.i(this.crG, "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jAF.hashCode()) });
    h.d locald = h.KU(this.jAF.mAppId);
    ae.i(this.crG, "onRuntimeBackground, type: ".concat(String.valueOf(locald)));
    com.tencent.mm.plugin.appbrand.jsapi.ad.a locala = (com.tencent.mm.plugin.appbrand.jsapi.ad.a)this.jAF.as(com.tencent.mm.plugin.appbrand.jsapi.ad.a.class);
    if (locala == null)
    {
      ae.w(this.crG, "onRuntimeBackground, audioOfVideoBackgroundPlayManager is null");
      if ((!bLw()) && (!this.kmF)) {
        break label164;
      }
      if (b.cc(this.nME.getActivity())) {
        break label156;
      }
      AppBrandFloatBallPermissionHelper.a(this.nME.getActivity(), 18, new c.a()
      {
        public final void gd(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(222250);
          ae.i(a.this.crG, "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            a.a(a.this, paramInt);
            a.a(a.this, true);
            AppMethodBeat.o(222250);
            return;
          }
          ae.w(a.this.crG, "onClose, refuse permission, remove ball and stop background play");
          a.this.bLx();
          a.this.kmF = false;
          a.this.bhn();
          a.a(a.this, false);
          a.this.nME.ge(true);
          AppMethodBeat.o(222250);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(222255);
      return true;
      locala.c(locald);
      break;
      label156:
      sz(paramInt);
    }
    label164:
    AppMethodBeat.o(222255);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.a
 * JD-Core Version:    0.7.0.1
 */