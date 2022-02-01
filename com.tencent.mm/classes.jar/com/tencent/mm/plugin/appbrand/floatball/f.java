package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.c;

public class f
  extends com.tencent.mm.plugin.ball.service.e
  implements m
{
  private static com.tencent.mm.plugin.ball.c.e old;
  t nAH;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f olt;
  private f.b olu;
  private final String olw;
  
  static
  {
    AppMethodBeat.i(275360);
    old = new com.tencent.mm.plugin.ball.c.f()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(267359);
        f.e(paramAnonymousBallInfo);
        AppMethodBeat.o(267359);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(275360);
  }
  
  public f(com.tencent.mm.plugin.ball.a.f paramf, t paramt)
  {
    super(paramf);
    AppMethodBeat.i(275333);
    this.olw = "has_shown_appbrand_voip_tip";
    this.olu = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(249710);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (f.e(f.this) != null) && (f.e(f.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (f.e(f.this).ntz.cBI == paramAnonymousAppBrandBackgroundRunningOperationParcel.cBU) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.aOm == 4) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.fvK == 1)) {
          f.f(f.this);
        }
        AppMethodBeat.o(249710);
      }
    };
    this.nAH = paramt;
    paramt.a(this);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramt.hashCode()) });
    this.olt = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(275333);
  }
  
  public static void bOh()
  {
    AppMethodBeat.i(275350);
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(17, old);
    }
    AppMethodBeat.o(275350);
  }
  
  public static void bOi()
  {
    AppMethodBeat.i(275351);
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(17, old);
    }
    AppMethodBeat.o(275351);
  }
  
  private void bOj()
  {
    AppMethodBeat.i(275352);
    if (h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.nAH.mAppId;
      localMMBackgroundRunningOperationParcel.aOm = 4;
      localMMBackgroundRunningOperationParcel.fvK = 2;
      Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.nAH.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(275352);
  }
  
  private int bOk()
  {
    AppMethodBeat.i(275354);
    if (this.nAH != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.ai.c.e locale = (com.tencent.mm.plugin.appbrand.jsapi.ai.c.e)this.nAH.av(com.tencent.mm.plugin.appbrand.jsapi.ai.c.e.class);
      if (locale != null)
      {
        boolean bool = locale.pKF;
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          AppMethodBeat.o(275354);
          return 32;
        }
        AppMethodBeat.o(275354);
        return 64;
      }
    }
    AppMethodBeat.o(275354);
    return 32;
  }
  
  private void zI(int paramInt)
  {
    AppMethodBeat.i(275342);
    cvL().opType = Fj(paramInt);
    cvG();
    Point localPoint = this.rYG.getBallPosition();
    c.a(this.rZC, localPoint, new a()
    {
      public final void aEa()
      {
        AppMethodBeat.i(278580);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        f.d(f.this).hS(true);
        AppMethodBeat.o(278580);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(278578);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        f.c(f.this).hS(false);
        AppMethodBeat.o(278578);
      }
    });
    AppMethodBeat.o(275342);
  }
  
  private void zL(final int paramInt)
  {
    AppMethodBeat.i(275341);
    if (!com.tencent.mm.compatible.e.b.ct(this.rZC.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.rZC.getActivity(), 17, new c.a()
      {
        public final void hR(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(278366);
          Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            f.b(f.this, paramInt);
            AppMethodBeat.o(278366);
            return;
          }
          Log.w("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          f.this.cvE();
          f.a(f.this);
          f.b(f.this).hS(true);
          AppMethodBeat.o(278366);
        }
      });
      AppMethodBeat.o(275341);
      return;
    }
    zI(paramInt);
    AppMethodBeat.o(275341);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(275334);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.I(paramInt, paramString);
    if (this.olt != null) {
      this.olt.a(this.olu);
    }
    AppMethodBeat.o(275334);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(275339);
    com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(paramContext);
    locala.bBl(paramContext.getString(au.i.appbrand_voip_float_ball_confirm_msg));
    locala.Qlf = true;
    locala.ayp(au.i.appbrand_voip_float_ball_confirm_ok);
    locala.b(new f.c()
    {
      public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(280504);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "showVOIPTip, has shown tip");
        MultiProcessMMKV.getDefault().encode("has_shown_appbrand_voip_tip", true);
        if (parama != null) {
          parama.bOc();
        }
        AppMethodBeat.o(280504);
      }
    });
    locala.show();
    AppMethodBeat.o(275339);
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
    AppMethodBeat.i(275348);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    this.rZC.hS(true);
    AppMethodBeat.o(275348);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(275347);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    if (cvA() != null)
    {
      A(true);
      w.makeText(AndroidContextUtil.castActivityOrNull(this.nAH.mContext), au.i.appbrand_voip_float_ball_toast_msg, 0).show();
    }
    if (this.rYG != null) {
      this.rYG.q(this.rYE);
    }
    AppMethodBeat.o(275347);
  }
  
  public final void bNV()
  {
    AppMethodBeat.i(275345);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    if (cvA() != null) {
      A(false);
    }
    AppMethodBeat.o(275345);
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(275349);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    super.bNW();
    bOj();
    AppMethodBeat.o(275349);
  }
  
  public final boolean bOg()
  {
    AppMethodBeat.i(275337);
    boolean bool = MultiProcessMMKV.getDefault().decodeBool("has_shown_appbrand_voip_tip", false);
    if ((cvD()) && (!bool))
    {
      AppMethodBeat.o(275337);
      return true;
    }
    AppMethodBeat.o(275337);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(275344);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    super.onDestroy();
    if (this.olt != null) {
      this.olt.b(this.olu);
    }
    AppMethodBeat.o(275344);
  }
  
  public final boolean zH(final int paramInt)
  {
    AppMethodBeat.i(275336);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    if (cvD())
    {
      if (!bOg()) {
        break label83;
      }
      Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, should show voip tip");
      a(this.rZC.getActivity(), new a()
      {
        public final void bOc()
        {
          AppMethodBeat.i(243178);
          f.a(f.this, paramInt);
          AppMethodBeat.o(243178);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(275336);
      return false;
      label83:
      zL(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bOc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.f
 * JD-Core Version:    0.7.0.1
 */