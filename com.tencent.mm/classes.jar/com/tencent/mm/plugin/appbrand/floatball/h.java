package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;

public final class h
  extends com.tencent.mm.plugin.ball.service.e
  implements n
{
  private static com.tencent.mm.plugin.ball.c.e roL;
  private Handler handler;
  w qxC;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f rpc;
  private f.b rpd;
  private final String rpf;
  
  static
  {
    AppMethodBeat.i(318353);
    roL = new com.tencent.mm.plugin.ball.c.e()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(318214);
        h.f(paramAnonymousBallInfo);
        AppMethodBeat.o(318214);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(318221);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.type == 19))
        {
          Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "handleBallInfoClicked, appbrand voip float ball");
          paramAnonymousBallInfo = paramAnonymousBallInfo.oSS.getString("appId");
          AppBrandVoIP1v1FloatBallEvent localAppBrandVoIP1v1FloatBallEvent = new AppBrandVoIP1v1FloatBallEvent();
          localAppBrandVoIP1v1FloatBallEvent.hQm = 1;
          com.tencent.mm.plugin.appbrand.ipc.f.b(paramAnonymousBallInfo, localAppBrandVoIP1v1FloatBallEvent);
        }
        AppMethodBeat.o(318221);
      }
      
      public final boolean coy()
      {
        return false;
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void g(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(318353);
  }
  
  public h(com.tencent.mm.plugin.ball.a.f paramf, w paramw)
  {
    super(paramf);
    AppMethodBeat.i(318227);
    this.rpf = "has_shown_appbrand_voip_1v1_tip";
    this.rpd = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(318204);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (h.g(h.this) != null) && (h.g(h.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (h.g(h.this).qsh.eul == paramAnonymousAppBrandBackgroundRunningOperationParcel.euz) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.cIi == 16) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.hAf == 1)) {
          h.h(h.this);
        }
        AppMethodBeat.o(318204);
      }
    };
    this.qxC = paramw;
    paramw.a(this);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramw.hashCode()) });
    this.rpc = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(318227);
  }
  
  private void Ac(final int paramInt)
  {
    AppMethodBeat.i(318232);
    if (!com.tencent.mm.compatible.e.b.dh(this.vkT.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.vkT.getActivity(), 19, new c.a()
      {
        public final void onCheckResult(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(318189);
          Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            h.b(h.this, paramInt);
            AppMethodBeat.o(318189);
            return;
          }
          Log.w("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          h.this.cYp();
          h.a(h.this);
          h.b(h.this).iR(true);
          AppMethodBeat.o(318189);
        }
      });
      AppMethodBeat.o(318232);
      return;
    }
    zY(paramInt);
    AppMethodBeat.o(318232);
  }
  
  public static void cou()
  {
    AppMethodBeat.i(318247);
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).a(19, roL);
    }
    AppMethodBeat.o(318247);
  }
  
  public static void cov()
  {
    AppMethodBeat.i(318256);
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).b(19, roL);
    }
    AppMethodBeat.o(318256);
  }
  
  private void cow()
  {
    AppMethodBeat.i(318264);
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.qxC.mAppId;
      localMMBackgroundRunningOperationParcel.cIi = 16;
      localMMBackgroundRunningOperationParcel.hAf = 2;
      Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.qxC.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(318264);
  }
  
  private int cox()
  {
    AppMethodBeat.i(318276);
    if (this.qxC != null)
    {
      Object localObject = q.wVc;
      if (((q)localObject).wVj == q.d.wWY)
      {
        localObject = ((q)localObject).wVg;
        if (((com.tencent.mm.plugin.cloudvoip.cloudvoice.service.f)localObject).wTG != null)
        {
          bool = ((com.tencent.mm.plugin.cloudvoip.cloudvoice.service.f)localObject).wTT;
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
        AppMethodBeat.o(318276);
        return 32;
        bool = false;
        break;
      }
      label89:
      AppMethodBeat.o(318276);
      return 64;
    }
    AppMethodBeat.o(318276);
    return 32;
  }
  
  private void zY(int paramInt)
  {
    AppMethodBeat.i(318240);
    cYv().opType = FK(paramInt);
    cYr();
    Point localPoint = this.vjX.getBallPosition();
    c.a(this.vkT, localPoint, new a()
    {
      public final void aXe()
      {
        AppMethodBeat.i(318187);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        h.d(h.this).iR(true);
        AppMethodBeat.o(318187);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(318182);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation end");
        h.c(h.this).iR(false);
        AppMethodBeat.o(318182);
      }
    });
    AppMethodBeat.o(318240);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(318359);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.J(paramInt, paramString);
    if (this.rpc != null) {
      this.rpc.a(this.rpd);
    }
    AppMethodBeat.o(318359);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(318368);
    g.a locala = new g.a(paramContext);
    locala.bDE(paramContext.getString(ba.i.appbrand_voip_float_ball_confirm_msg));
    locala.Xdm = true;
    locala.aEX(ba.i.appbrand_voip_float_ball_confirm_ok);
    locala.b(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(318193);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "showVOIPTip, has shown tip");
        MultiProcessMMKV.getDefault().encode("has_shown_appbrand_voip_1v1_tip", true);
        if (parama != null) {
          parama.coq();
        }
        AppMethodBeat.o(318193);
      }
    });
    locala.show();
    AppMethodBeat.o(318368);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(318375);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    this.vkT.iR(true);
    AppMethodBeat.o(318375);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(318372);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    if (cYl() != null)
    {
      E(true);
      aa.makeText(AndroidContextUtil.castActivityOrNull(this.qxC.mContext), ba.i.appbrand_voip_float_ball_toast_msg, 0).show();
    }
    if (this.vjX != null) {
      this.vjX.q(this.vjV);
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(318181);
        final int i = h.e(h.this);
        if (h.f(h.this) != null) {
          h.f(h.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(318282);
              h.this.FJ(i);
              AppMethodBeat.o(318282);
            }
          });
        }
        AppMethodBeat.o(318181);
      }
    }, "");
    AppMethodBeat.o(318372);
  }
  
  public final void coi()
  {
    AppMethodBeat.i(318370);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    if (cYl() != null) {
      E(false);
    }
    AppMethodBeat.o(318370);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(318376);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    super.coj();
    cow();
    AppMethodBeat.o(318376);
  }
  
  public final boolean cot()
  {
    AppMethodBeat.i(318365);
    boolean bool = MultiProcessMMKV.getDefault().decodeBool("has_shown_appbrand_voip_1v1_tip", false);
    if ((cYo()) && (!bool))
    {
      AppMethodBeat.o(318365);
      return true;
    }
    AppMethodBeat.o(318365);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(318369);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    super.onDestroy();
    if (this.rpc != null) {
      this.rpc.b(this.rpd);
    }
    AppMethodBeat.o(318369);
  }
  
  public final boolean zX(final int paramInt)
  {
    AppMethodBeat.i(318363);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    if (cYo())
    {
      if (!cot()) {
        break label83;
      }
      Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, should show voip tip");
      a(this.vkT.getActivity(), new a()
      {
        public final void coq()
        {
          AppMethodBeat.i(318194);
          h.a(h.this, paramInt);
          AppMethodBeat.o(318194);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(318363);
      return false;
      label83:
      Ac(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void coq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.h
 * JD-Core Version:    0.7.0.1
 */