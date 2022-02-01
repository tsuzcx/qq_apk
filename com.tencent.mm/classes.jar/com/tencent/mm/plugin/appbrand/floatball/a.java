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
  final String crd;
  final o jxG;
  private final com.tencent.mm.plugin.appbrand.backgroundrunning.g kjo;
  volatile boolean kjp;
  private g.b kjq;
  
  public a(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(188128);
    this.crd = ("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper#" + hashCode());
    this.kjp = false;
    this.kjq = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(188124);
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel == null)
        {
          AppMethodBeat.o(188124);
          return;
        }
        if ((!a.this.jxG.mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) || (a.this.jxG.jwG.dPf != paramAnonymousAppBrandBackgroundRunningOperationParcel.hQh))
        {
          AppMethodBeat.o(188124);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.beO != 8)
        {
          AppMethodBeat.o(188124);
          return;
        }
        if (paramAnonymousAppBrandBackgroundRunningOperationParcel.dkM == 1)
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          if (!paramAnonymousAppBrandBackgroundRunningOperationParcel.bKz())
          {
            ad.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.crd, "onSendBackgroundRunningOperation, add passive audio of video background play float ball");
            paramAnonymousAppBrandBackgroundRunningOperationParcel.Wm(paramAnonymousAppBrandBackgroundRunningOperationParcel.bgG());
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iW(true);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.iX(false);
            paramAnonymousAppBrandBackgroundRunningOperationParcel.xY(d.eH(paramAnonymousAppBrandBackgroundRunningOperationParcel.nGj.state, 128));
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bKG().nGc = 13;
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bKC();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.bKB();
            paramAnonymousAppBrandBackgroundRunningOperationParcel.kjp = true;
            AppMethodBeat.o(188124);
            return;
          }
          ad.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.crd, "onSendBackgroundRunningOperation, add audio of video background play state to float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.xY(d.eH(paramAnonymousAppBrandBackgroundRunningOperationParcel.nGj.state, 128));
          paramAnonymousAppBrandBackgroundRunningOperationParcel.iW(true);
          AppMethodBeat.o(188124);
          return;
        }
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel.dkM == 2) || (paramAnonymousAppBrandBackgroundRunningOperationParcel.dkM == 3))
        {
          paramAnonymousAppBrandBackgroundRunningOperationParcel = a.this;
          BallInfo localBallInfo = paramAnonymousAppBrandBackgroundRunningOperationParcel.bJU();
          if (localBallInfo != null)
          {
            if (localBallInfo.nFX)
            {
              ad.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.crd, "removeBackgroundPlayAudioBall, remove passive float ball");
              paramAnonymousAppBrandBackgroundRunningOperationParcel.bKA();
              paramAnonymousAppBrandBackgroundRunningOperationParcel.kjp = false;
              AppMethodBeat.o(188124);
              return;
            }
            ad.w(paramAnonymousAppBrandBackgroundRunningOperationParcel.crd, "removeBackgroundPlayAudioBall, passive is false");
            AppMethodBeat.o(188124);
            return;
          }
          ad.i(paramAnonymousAppBrandBackgroundRunningOperationParcel.crd, "removeBackgroundPlayAudioBall, no this float ball");
          paramAnonymousAppBrandBackgroundRunningOperationParcel.xY(d.eI(paramAnonymousAppBrandBackgroundRunningOperationParcel.nGj.state, 128));
        }
        AppMethodBeat.o(188124);
      }
    };
    this.jxG = paramo;
    ad.i(this.crd, "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.kjo = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    AppMethodBeat.o(188128);
  }
  
  private void sw(int paramInt)
  {
    AppMethodBeat.i(188137);
    bKG().opType = ya(paramInt);
    bKC();
    Point localPoint = this.nGl.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.nHb, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bgH()
      {
        AppMethodBeat.i(188127);
        ad.i(a.this.crd, "onCloseWithAnimation, transform to float ball animation cancel");
        a.this.nHb.gg(true);
        AppMethodBeat.o(188127);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(188126);
        ad.i(a.this.crd, "onCloseWithAnimation, transform to float ball animation end");
        a.this.nHb.gg(false);
        AppMethodBeat.o(188126);
      }
    });
    AppMethodBeat.o(188137);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(188129);
    ad.i(this.crd, "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    if (this.kjo != null) {
      this.kjo.a(this.kjq);
    }
    AppMethodBeat.o(188129);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(188136);
    ad.i(this.crd, "onReceivedBallInfoAddedEvent, runtime:%s, type: %d, key: %s", new Object[] { Integer.valueOf(this.jxG.hashCode()), Integer.valueOf(paramInt), paramString });
    super.ad(paramInt, paramString);
    if (this.nGj != null) {
      ad.i(this.crd, "onReceivedBallInfoAddedEvent, myType: %d, myKey: %s", new Object[] { Integer.valueOf(this.nGj.type), this.nGj.key });
    }
    if ((this.nGj != null) && (paramInt == this.nGj.type) && (Objects.equals(paramString, this.nGj.key)))
    {
      ad.i(this.crd, "onReceivedBallInfoAddedEvent, myself");
      AppMethodBeat.o(188136);
      return;
    }
    if ((6 == paramInt) || (18 == paramInt) || (9 == paramInt) || (17 == paramInt))
    {
      bKA();
      this.kjp = false;
    }
    AppMethodBeat.o(188136);
  }
  
  public final boolean bgA()
  {
    return false;
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(188132);
    ad.i(this.crd, "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jxG.hashCode()) });
    if (bKx() != null) {
      V(false);
    }
    AppMethodBeat.o(188132);
  }
  
  public final void bgC()
  {
    AppMethodBeat.i(188133);
    ad.i(this.crd, "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jxG.hashCode()) });
    if (bKx() != null) {
      V(true);
    }
    AppMethodBeat.o(188133);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(188134);
    ad.i(this.crd, "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jxG.hashCode()) });
    this.nHb.gg(true);
    AppMethodBeat.o(188134);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(188135);
    ad.i(this.crd, "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jxG.hashCode()) });
    super.bgE();
    this.kjp = false;
    bgF();
    AppMethodBeat.o(188135);
  }
  
  final void bgF()
  {
    AppMethodBeat.i(188138);
    if (this.kjo == null)
    {
      AppMethodBeat.o(188138);
      return;
    }
    MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
    localMMBackgroundRunningOperationParcel.appId = this.jxG.mAppId;
    localMMBackgroundRunningOperationParcel.beO = 8;
    localMMBackgroundRunningOperationParcel.dkM = 2;
    ad.i(this.crd, "maybeStopBackgroundPlayAudio, appId:%s", new Object[] { this.jxG.mAppId });
    this.kjo.a(localMMBackgroundRunningOperationParcel);
    AppMethodBeat.o(188138);
  }
  
  final String bgG()
  {
    AppMethodBeat.i(188139);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.ac.a)this.jxG.as(com.tencent.mm.plugin.appbrand.jsapi.ac.a.class);
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.ac.a)localObject1).bpy();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = this.jxG.aXc().doD;
      }
      AppMethodBeat.o(188139);
      return localObject2;
    }
  }
  
  public final boolean bgz()
  {
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(188131);
    ad.i(this.crd, "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jxG.hashCode()) });
    super.onDestroy();
    if (this.kjo != null) {
      this.kjo.b(this.kjq);
    }
    AppMethodBeat.o(188131);
  }
  
  public final boolean sv(final int paramInt)
  {
    AppMethodBeat.i(188130);
    ad.i(this.crd, "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jxG.hashCode()) });
    g.d locald = com.tencent.mm.plugin.appbrand.g.Kv(this.jxG.mAppId);
    ad.i(this.crd, "onRuntimeBackground, type: ".concat(String.valueOf(locald)));
    com.tencent.mm.plugin.appbrand.jsapi.ac.a locala = (com.tencent.mm.plugin.appbrand.jsapi.ac.a)this.jxG.as(com.tencent.mm.plugin.appbrand.jsapi.ac.a.class);
    if (locala == null)
    {
      ad.w(this.crd, "onRuntimeBackground, audioOfVideoBackgroundPlayManager is null");
      if ((!bKz()) && (!this.kjp)) {
        break label164;
      }
      if (b.ca(this.nHb.getActivity())) {
        break label156;
      }
      AppBrandFloatBallPermissionHelper.a(this.nHb.getActivity(), 18, new c.a()
      {
        public final void ge(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(188125);
          ad.i(a.this.crd, "onClose, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            a.a(a.this, paramInt);
            a.a(a.this, true);
            AppMethodBeat.o(188125);
            return;
          }
          ad.w(a.this.crd, "onClose, refuse permission, remove ball and stop background play");
          a.this.bKA();
          a.this.kjp = false;
          a.this.bgF();
          a.a(a.this, false);
          a.this.nHb.gg(true);
          AppMethodBeat.o(188125);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(188130);
      return true;
      locala.c(locald);
      break;
      label156:
      sw(paramInt);
    }
    label164:
    AppMethodBeat.o(188130);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.a
 * JD-Core Version:    0.7.0.1
 */