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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Objects;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private final com.tencent.mm.plugin.appbrand.backgroundrunning.g jPd;
  volatile boolean jPe;
  private g.b jPf;
  final o jez;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(186432);
    this.jPe = false;
    this.jPf = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(186428);
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel == null)
        {
          AppMethodBeat.o(186428);
          return;
        }
        if ((!a.this.jez.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) || (a.this.jez.jdx.joY != paramAnonymousAppBrandBackgroundRunningOperationParcel.hxM))
        {
          AppMethodBeat.o(186428);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.aUu != 8)
        {
          AppMethodBeat.o(186428);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.cZu == 1)
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.bGo())
          {
            ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onSendBackgroundRunningOperation, add passive audio of video background play float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.SO(paramAnonymousAppBrandBackgroundRunningOperationParcel.bdc());
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iN(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iO(false);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.xs(d.eE(paramAnonymousAppBrandBackgroundRunningOperationParcel.nfN.state, 128));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bGv().nfG = 13;
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bGr();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bGq();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.jPe = true;
            AppMethodBeat.o(186428);
            return;
          }
          ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onSendBackgroundRunningOperation, add audio of video background play state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.xs(d.eE(paramAnonymousAppBrandBackgroundRunningOperationParcel.nfN.state, 128));
          paramAnonymousAppBrandBackgroundRunningOperationParcel.iN(true);
          AppMethodBeat.o(186428);
          return;
        }
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel.cZu == 2) || (paramAnonymousAppBrandBackgroundRunningOperationParcel.cZu == 3))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          BallInfo localBallInfo = paramAnonymousAppBrandBackgroundRunningOperationParcel.bFK();
          if (localBallInfo != null)
          {
            if (localBallInfo.nfB)
            {
              ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "removeBackgroundPlayAudioBall, remove passive float ball");
              paramAnonymousAppBrandBackgroundRunningOperationParcel.bGp();
              paramAnonymousAppBrandBackgroundRunningOperationParcel.jPe = false;
              AppMethodBeat.o(186428);
              return;
            }
            ac.w("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "removeBackgroundPlayAudioBall, passive is false");
            AppMethodBeat.o(186428);
            return;
          }
          ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "removeBackgroundPlayAudioBall, no this float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.xs(d.eF(paramAnonymousAppBrandBackgroundRunningOperationParcel.nfN.state, 128));
        }
        AppMethodBeat.o(186428);
      }
    };
    this.jez = paramo;
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.jPd = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    AppMethodBeat.o(186432);
  }
  
  private void rU(int paramInt)
  {
    AppMethodBeat.i(186441);
    bGv().opType = xu(paramInt);
    bGr();
    Point localPoint = this.nfP.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.ngF, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bdd()
      {
        AppMethodBeat.i(186431);
        ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onCloseWithAnimation, transform to float ball animation cancel");
        a.this.ngF.gb(true);
        AppMethodBeat.o(186431);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(186430);
        ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onCloseWithAnimation, transform to float ball animation end");
        a.this.ngF.gb(false);
        AppMethodBeat.o(186430);
      }
    });
    AppMethodBeat.o(186441);
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(186433);
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.aa(paramInt, paramString);
    if (this.jPd != null) {
      this.jPd.a(this.jPf);
    }
    AppMethodBeat.o(186433);
  }
  
  public final void ab(int paramInt, String paramString)
  {
    AppMethodBeat.i(186440);
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onReceivedBallInfoAddedEvent, runtime:%s, type: %d, key: %s", new Object[] { Integer.valueOf(this.jez.hashCode()), Integer.valueOf(paramInt), paramString });
    super.ab(paramInt, paramString);
    if (this.nfN != null) {
      ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onReceivedBallInfoAddedEvent, myType: %d, myKey: %s", new Object[] { Integer.valueOf(this.nfN.type), this.nfN.key });
    }
    if ((this.nfN != null) && (paramInt == this.nfN.type) && (Objects.equals(paramString, this.nfN.key)))
    {
      ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onReceivedBallInfoAddedEvent, myself");
      AppMethodBeat.o(186440);
      return;
    }
    if ((6 == paramInt) || (18 == paramInt) || (9 == paramInt) || (17 == paramInt))
    {
      bGp();
      this.jPe = false;
    }
    AppMethodBeat.o(186440);
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
    AppMethodBeat.i(186436);
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jez.hashCode()) });
    if (bGm() != null) {
      V(false);
    }
    AppMethodBeat.o(186436);
  }
  
  public final void bcY()
  {
    AppMethodBeat.i(186437);
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jez.hashCode()) });
    if (bGm() != null) {
      V(true);
    }
    AppMethodBeat.o(186437);
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(186438);
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jez.hashCode()) });
    this.ngF.gb(true);
    AppMethodBeat.o(186438);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(186439);
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jez.hashCode()) });
    super.bda();
    this.jPe = false;
    bdb();
    AppMethodBeat.o(186439);
  }
  
  final void bdb()
  {
    AppMethodBeat.i(186442);
    if (this.jPd == null)
    {
      AppMethodBeat.o(186442);
      return;
    }
    MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
    localMMBackgroundRunningOperationParcel.appId = this.jez.mAppId;
    localMMBackgroundRunningOperationParcel.aUu = 8;
    localMMBackgroundRunningOperationParcel.cZu = 2;
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "maybeStopBackgroundPlayAudio, appId:%s", new Object[] { this.jez.mAppId });
    this.jPd.a(localMMBackgroundRunningOperationParcel);
    AppMethodBeat.o(186442);
  }
  
  final String bdc()
  {
    AppMethodBeat.i(186443);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.z.a)this.jez.as(com.tencent.mm.plugin.appbrand.jsapi.z.a.class);
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.z.a)localObject1).blN();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1)) {
        localObject2 = this.jez.aTS().ddh;
      }
      AppMethodBeat.o(186443);
      return localObject2;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186435);
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jez.hashCode()) });
    super.onDestroy();
    if (this.jPd != null) {
      this.jPd.b(this.jPf);
    }
    AppMethodBeat.o(186435);
  }
  
  public final boolean rT(final int paramInt)
  {
    AppMethodBeat.i(186434);
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jez.hashCode()) });
    g.d locald = com.tencent.mm.plugin.appbrand.g.Hg(this.jez.mAppId);
    ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onRuntimeBackground, type: ".concat(String.valueOf(locald)));
    com.tencent.mm.plugin.appbrand.jsapi.z.a locala = (com.tencent.mm.plugin.appbrand.jsapi.z.a)this.jez.as(com.tencent.mm.plugin.appbrand.jsapi.z.a.class);
    if (locala == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onRuntimeBackground, audioOfVideoBackgroundPlayManager is null");
      if ((!bGo()) && (!this.jPe)) {
        break label158;
      }
      if (b.cc(this.ngF.getActivity())) {
        break label150;
      }
      AppBrandFloatBallPermissionHelper.a(this.ngF.getActivity(), 18, new c.a()
      {
        public final void fZ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(186429);
          ac.i("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            a.a(a.this, paramInt);
            a.a(a.this, true);
            AppMethodBeat.o(186429);
            return;
          }
          ac.w("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper", "onClose, refuse permission, remove ball and stop background play");
          a.this.bGp();
          a.this.jPe = false;
          a.this.bdb();
          a.a(a.this, false);
          a.this.ngF.gb(true);
          AppMethodBeat.o(186429);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(186434);
      return true;
      locala.c(locald);
      break;
      label150:
      rU(paramInt);
    }
    label158:
    AppMethodBeat.o(186434);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.a
 * JD-Core Version:    0.7.0.1
 */