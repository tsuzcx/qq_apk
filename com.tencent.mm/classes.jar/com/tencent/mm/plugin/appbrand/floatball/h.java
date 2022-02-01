package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mmkv.MMKV;

public final class h
  extends com.tencent.mm.plugin.ball.service.f
  implements k
{
  private static com.tencent.mm.plugin.ball.c.f kmM;
  private Handler handler;
  com.tencent.mm.plugin.appbrand.p jFm;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f knb;
  private f.b knc;
  private final String kne;
  
  static
  {
    AppMethodBeat.i(222340);
    kmM = new com.tencent.mm.plugin.ball.c.f()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(222315);
        h.g(paramAnonymousBallInfo);
        AppMethodBeat.o(222315);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(222316);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.type == 19))
        {
          ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "handleBallInfoClicked, appbrand voip float ball");
          paramAnonymousBallInfo = paramAnonymousBallInfo.ioY.getString("appId");
          AppBrandVoIP1v1FloatBallEvent localAppBrandVoIP1v1FloatBallEvent = new AppBrandVoIP1v1FloatBallEvent();
          localAppBrandVoIP1v1FloatBallEvent.dzC = 1;
          com.tencent.mm.plugin.appbrand.ipc.e.b(paramAnonymousBallInfo, localAppBrandVoIP1v1FloatBallEvent);
        }
        AppMethodBeat.o(222316);
      }
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
      
      public final void h(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(222340);
  }
  
  public h(com.tencent.mm.plugin.ball.a.f paramf, com.tencent.mm.plugin.appbrand.p paramp)
  {
    super(paramf);
    AppMethodBeat.i(222318);
    this.kne = "has_shown_appbrand_voip_1v1_tip";
    this.knc = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(222317);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (h.g(h.this) != null) && (h.g(h.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (h.g(h.this).jzC.dQv == paramAnonymousAppBrandBackgroundRunningOperationParcel.hSZ) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.beO == 16) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dlO == 1)) {
          h.h(h.this);
        }
        AppMethodBeat.o(222317);
      }
    };
    this.jFm = paramp;
    paramp.a(this);
    ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramp.hashCode()) });
    this.knb = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(222318);
  }
  
  private void bhA()
  {
    AppMethodBeat.i(222332);
    if (g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.jFm.mAppId;
      localMMBackgroundRunningOperationParcel.beO = 16;
      localMMBackgroundRunningOperationParcel.dlO = 2;
      ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.jFm.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(222332);
  }
  
  private int bhB()
  {
    AppMethodBeat.i(222333);
    if (this.jFm != null)
    {
      Object localObject = com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.pdY;
      if (((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p)localObject).pee == p.d.pfR)
      {
        localObject = ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p)localObject).peb;
        if (((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.e)localObject).pcI != null)
        {
          bool = ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.e)localObject).pcU;
          if (bool) {
            break label84;
          }
        }
      }
      label84:
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label89;
        }
        AppMethodBeat.o(222333);
        return 32;
        bool = false;
        break;
      }
      label89:
      AppMethodBeat.o(222333);
      return 64;
    }
    AppMethodBeat.o(222333);
    return 32;
  }
  
  public static void bhy()
  {
    AppMethodBeat.i(222330);
    if (g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(19, kmM);
    }
    AppMethodBeat.o(222330);
  }
  
  public static void bhz()
  {
    AppMethodBeat.i(222331);
    if (g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(19, kmM);
    }
    AppMethodBeat.o(222331);
  }
  
  private void sC(final int paramInt)
  {
    AppMethodBeat.i(222323);
    if (!com.tencent.mm.compatible.d.b.cc(this.nME.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.nME.getActivity(), 19, new c.a()
      {
        public final void gd(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(222310);
          ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            h.b(h.this, paramInt);
            AppMethodBeat.o(222310);
            return;
          }
          ae.w("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          h.this.bLx();
          h.a(h.this);
          h.b(h.this).ge(true);
          AppMethodBeat.o(222310);
        }
      });
      AppMethodBeat.o(222323);
      return;
    }
    sz(paramInt);
    AppMethodBeat.o(222323);
  }
  
  private void sz(int paramInt)
  {
    AppMethodBeat.i(222324);
    bLD().opType = yd(paramInt);
    bLz();
    Point localPoint = this.nLM.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.nME, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bhp()
      {
        AppMethodBeat.i(222312);
        ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        h.d(h.this).ge(true);
        AppMethodBeat.o(222312);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(222311);
        ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation end");
        h.c(h.this).ge(false);
        AppMethodBeat.o(222311);
      }
    });
    AppMethodBeat.o(222324);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(222322);
    f.a locala = new f.a(paramContext);
    locala.aZq(paramContext.getString(2131756064));
    locala.EyN = true;
    locala.afY(2131756065);
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(222309);
        ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "showVOIPTip, has shown tip");
        MMKV.defaultMMKV().encode("has_shown_appbrand_voip_1v1_tip", true);
        if (parama != null) {
          parama.bht();
        }
        AppMethodBeat.o(222309);
      }
    });
    locala.show();
    AppMethodBeat.o(222322);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(222319);
    ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    if (this.knb != null) {
      this.knb.a(this.knc);
    }
    AppMethodBeat.o(222319);
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
    AppMethodBeat.i(222326);
    ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    if (bLu() != null) {
      V(false);
    }
    AppMethodBeat.o(222326);
  }
  
  public final void bhk()
  {
    AppMethodBeat.i(222327);
    ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    if (bLu() != null)
    {
      V(true);
      t.makeText(com.tencent.mm.sdk.f.a.jw(this.jFm.mContext), 2131756066, 0).show();
    }
    if (this.nLM != null) {
      this.nLM.r(this.nLK);
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222314);
        final int i = h.e(h.this);
        if (h.f(h.this) != null) {
          h.f(h.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(222313);
              h.this.yc(i);
              AppMethodBeat.o(222313);
            }
          });
        }
        AppMethodBeat.o(222314);
      }
    }, "");
    AppMethodBeat.o(222327);
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(222328);
    ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    this.nME.ge(true);
    AppMethodBeat.o(222328);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(222329);
    ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    super.bhm();
    bhA();
    AppMethodBeat.o(222329);
  }
  
  public final boolean bhx()
  {
    AppMethodBeat.i(222321);
    boolean bool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_1v1_tip", false);
    if ((bLw()) && (!bool))
    {
      AppMethodBeat.o(222321);
      return true;
    }
    AppMethodBeat.o(222321);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(222325);
    ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    super.onDestroy();
    if (this.knb != null) {
      this.knb.b(this.knc);
    }
    AppMethodBeat.o(222325);
  }
  
  public final boolean sy(final int paramInt)
  {
    AppMethodBeat.i(222320);
    ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    if (bLw())
    {
      if (!bhx()) {
        break label83;
      }
      ae.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, should show voip tip");
      a(this.nME.getActivity(), new a()
      {
        public final void bht()
        {
          AppMethodBeat.i(222308);
          h.a(h.this, paramInt);
          AppMethodBeat.o(222308);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(222320);
      return false;
      label83:
      sC(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bht();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.h
 * JD-Core Version:    0.7.0.1
 */