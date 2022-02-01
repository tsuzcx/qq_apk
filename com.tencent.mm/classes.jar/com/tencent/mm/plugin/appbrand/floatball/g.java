package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public final class g
  extends com.tencent.mm.plugin.ball.service.e
  implements m
{
  private static com.tencent.mm.plugin.ball.c.e old;
  private Handler handler;
  t nAH;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f olt;
  private f.b olu;
  private final String olw;
  
  static
  {
    AppMethodBeat.i(247188);
    old = new com.tencent.mm.plugin.ball.c.e()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(279694);
        g.f(paramAnonymousBallInfo);
        AppMethodBeat.o(279694);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(279695);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.type == 19))
        {
          Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "handleBallInfoClicked, appbrand voip float ball");
          paramAnonymousBallInfo = paramAnonymousBallInfo.mab.getString("appId");
          AppBrandVoIP1v1FloatBallEvent localAppBrandVoIP1v1FloatBallEvent = new AppBrandVoIP1v1FloatBallEvent();
          localAppBrandVoIP1v1FloatBallEvent.fKG = 1;
          com.tencent.mm.plugin.appbrand.ipc.e.b(paramAnonymousBallInfo, localAppBrandVoIP1v1FloatBallEvent);
        }
        AppMethodBeat.o(279695);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void g(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(247188);
  }
  
  public g(com.tencent.mm.plugin.ball.a.f paramf, t paramt)
  {
    super(paramf);
    AppMethodBeat.i(247134);
    this.olw = "has_shown_appbrand_voip_1v1_tip";
    this.olu = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(278958);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (g.g(g.this) != null) && (g.g(g.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (g.g(g.this).ntz.cBI == paramAnonymousAppBrandBackgroundRunningOperationParcel.cBU) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.aOm == 16) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.fvK == 1)) {
          g.h(g.this);
        }
        AppMethodBeat.o(278958);
      }
    };
    this.nAH = paramt;
    paramt.a(this);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramt.hashCode()) });
    this.olt = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(247134);
  }
  
  public static void bOh()
  {
    AppMethodBeat.i(247162);
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(19, old);
    }
    AppMethodBeat.o(247162);
  }
  
  public static void bOi()
  {
    AppMethodBeat.i(247163);
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(19, old);
    }
    AppMethodBeat.o(247163);
  }
  
  private void bOj()
  {
    AppMethodBeat.i(247165);
    if (h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.nAH.mAppId;
      localMMBackgroundRunningOperationParcel.aOm = 16;
      localMMBackgroundRunningOperationParcel.fvK = 2;
      Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.nAH.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(247165);
  }
  
  private int bOk()
  {
    AppMethodBeat.i(247168);
    if (this.nAH != null)
    {
      Object localObject = q.tRM;
      if (((q)localObject).tRT == q.d.tTH)
      {
        localObject = ((q)localObject).tRQ;
        if (((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f)localObject).tQq != null)
        {
          bool = ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f)localObject).tQD;
          if (bool) {
            break label84;
          }
        }
      }
      label84:
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label89;
        }
        AppMethodBeat.o(247168);
        return 32;
        bool = false;
        break;
      }
      label89:
      AppMethodBeat.o(247168);
      return 64;
    }
    AppMethodBeat.o(247168);
    return 32;
  }
  
  private void zI(int paramInt)
  {
    AppMethodBeat.i(247149);
    cvL().opType = Fj(paramInt);
    cvG();
    Point localPoint = this.rYG.getBallPosition();
    c.a(this.rZC, localPoint, new a()
    {
      public final void aEa()
      {
        AppMethodBeat.i(269158);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        g.d(g.this).hS(true);
        AppMethodBeat.o(269158);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(269157);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation end");
        g.c(g.this).hS(false);
        AppMethodBeat.o(269157);
      }
    });
    AppMethodBeat.o(247149);
  }
  
  private void zL(final int paramInt)
  {
    AppMethodBeat.i(247147);
    if (!com.tencent.mm.compatible.e.b.ct(this.rZC.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.rZC.getActivity(), 19, new c.a()
      {
        public final void hR(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(268987);
          Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            g.b(g.this, paramInt);
            AppMethodBeat.o(268987);
            return;
          }
          Log.w("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          g.this.cvE();
          g.a(g.this);
          g.b(g.this).hS(true);
          AppMethodBeat.o(268987);
        }
      });
      AppMethodBeat.o(247147);
      return;
    }
    zI(paramInt);
    AppMethodBeat.o(247147);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(247136);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.I(paramInt, paramString);
    if (this.olt != null) {
      this.olt.a(this.olu);
    }
    AppMethodBeat.o(247136);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(247145);
    f.a locala = new f.a(paramContext);
    locala.bBl(paramContext.getString(au.i.appbrand_voip_float_ball_confirm_msg));
    locala.Qlf = true;
    locala.ayp(au.i.appbrand_voip_float_ball_confirm_ok);
    locala.b(new f.c()
    {
      public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(278751);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "showVOIPTip, has shown tip");
        MultiProcessMMKV.getDefault().encode("has_shown_appbrand_voip_1v1_tip", true);
        if (parama != null) {
          parama.bOc();
        }
        AppMethodBeat.o(278751);
      }
    });
    locala.show();
    AppMethodBeat.o(247145);
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
    AppMethodBeat.i(247159);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    this.rZC.hS(true);
    AppMethodBeat.o(247159);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(247157);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    if (cvA() != null)
    {
      A(true);
      w.makeText(AndroidContextUtil.castActivityOrNull(this.nAH.mContext), au.i.appbrand_voip_float_ball_toast_msg, 0).show();
    }
    if (this.rYG != null) {
      this.rYG.q(this.rYE);
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(279386);
        final int i = g.e(g.this);
        if (g.f(g.this) != null) {
          g.f(g.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(273506);
              g.this.Fi(i);
              AppMethodBeat.o(273506);
            }
          });
        }
        AppMethodBeat.o(279386);
      }
    }, "");
    AppMethodBeat.o(247157);
  }
  
  public final void bNV()
  {
    AppMethodBeat.i(247155);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    if (cvA() != null) {
      A(false);
    }
    AppMethodBeat.o(247155);
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(247160);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    super.bNW();
    bOj();
    AppMethodBeat.o(247160);
  }
  
  public final boolean bOg()
  {
    AppMethodBeat.i(247142);
    boolean bool = MultiProcessMMKV.getDefault().decodeBool("has_shown_appbrand_voip_1v1_tip", false);
    if ((cvD()) && (!bool))
    {
      AppMethodBeat.o(247142);
      return true;
    }
    AppMethodBeat.o(247142);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(247152);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    super.onDestroy();
    if (this.olt != null) {
      this.olt.b(this.olu);
    }
    AppMethodBeat.o(247152);
  }
  
  public final boolean zH(final int paramInt)
  {
    AppMethodBeat.i(247138);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    if (cvD())
    {
      if (!bOg()) {
        break label83;
      }
      Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, should show voip tip");
      a(this.rZC.getActivity(), new a()
      {
        public final void bOc()
        {
          AppMethodBeat.i(275235);
          g.a(g.this, paramInt);
          AppMethodBeat.o(275235);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(247138);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.g
 * JD-Core Version:    0.7.0.1
 */