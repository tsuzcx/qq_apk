package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mmkv.MMKV;

public final class g
  extends com.tencent.mm.plugin.ball.service.f
  implements n
{
  private static e lqt;
  private Handler handler;
  com.tencent.mm.plugin.appbrand.q kGW;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f lqJ;
  private f.b lqK;
  private final String lqM;
  
  static
  {
    AppMethodBeat.i(226607);
    lqt = new g.6();
    AppMethodBeat.o(226607);
  }
  
  public g(com.tencent.mm.plugin.ball.a.f paramf, com.tencent.mm.plugin.appbrand.q paramq)
  {
    super(paramf);
    AppMethodBeat.i(226585);
    this.lqM = "has_shown_appbrand_voip_1v1_tip";
    this.lqK = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(226584);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (g.g(g.this) != null) && (g.g(g.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (g.g(g.this).kAq.eix == paramAnonymousAppBrandBackgroundRunningOperationParcel.iOo) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.beL == 16) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dDe == 1)) {
          g.h(g.this);
        }
        AppMethodBeat.o(226584);
      }
    };
    this.kGW = paramq;
    paramq.a(this);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramq.hashCode()) });
    this.lqJ = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(226585);
  }
  
  public static void bCM()
  {
    AppMethodBeat.i(226597);
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a(19, lqt);
    }
    AppMethodBeat.o(226597);
  }
  
  public static void bCN()
  {
    AppMethodBeat.i(226598);
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b(19, lqt);
    }
    AppMethodBeat.o(226598);
  }
  
  private void bCO()
  {
    AppMethodBeat.i(226599);
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.kGW.mAppId;
      localMMBackgroundRunningOperationParcel.beL = 16;
      localMMBackgroundRunningOperationParcel.dDe = 2;
      Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.kGW.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(226599);
  }
  
  private int bCP()
  {
    AppMethodBeat.i(226600);
    if (this.kGW != null)
    {
      Object localObject = com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta;
      if (((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q)localObject).qth == q.d.quV)
      {
        localObject = ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q)localObject).qte;
        if (((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f)localObject).qrH != null)
        {
          bool = ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f)localObject).qrU;
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
        AppMethodBeat.o(226600);
        return 32;
        bool = false;
        break;
      }
      label89:
      AppMethodBeat.o(226600);
      return 64;
    }
    AppMethodBeat.o(226600);
    return 32;
  }
  
  private void wv(int paramInt)
  {
    AppMethodBeat.i(226591);
    ciw().opType = BI(paramInt);
    cit();
    Point localPoint = this.oWG.getBallPosition();
    c.a(this.oXA, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void awJ()
      {
        AppMethodBeat.i(226579);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        g.d(g.this).hb(true);
        AppMethodBeat.o(226579);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(226578);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation end");
        g.c(g.this).hb(false);
        AppMethodBeat.o(226578);
      }
    });
    AppMethodBeat.o(226591);
  }
  
  private void wy(final int paramInt)
  {
    AppMethodBeat.i(226590);
    if (!com.tencent.mm.compatible.e.b.cx(this.oXA.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.oXA.getActivity(), 19, new c.a()
      {
        public final void ha(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(226577);
          Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            g.b(g.this, paramInt);
            AppMethodBeat.o(226577);
            return;
          }
          Log.w("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          g.this.cir();
          g.a(g.this);
          g.b(g.this).hb(true);
          AppMethodBeat.o(226577);
        }
      });
      AppMethodBeat.o(226590);
      return;
    }
    wv(paramInt);
    AppMethodBeat.o(226590);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(226586);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.G(paramInt, paramString);
    if (this.lqJ != null) {
      this.lqJ.a(this.lqK);
    }
    AppMethodBeat.o(226586);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(226589);
    f.a locala = new f.a(paramContext);
    locala.bow(paramContext.getString(2131756184));
    locala.JnN = true;
    locala.apa(2131756185);
    locala.b(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(226576);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "showVOIPTip, has shown tip");
        MMKV.defaultMMKV().encode("has_shown_appbrand_voip_1v1_tip", true);
        if (parama != null) {
          parama.bCH();
        }
        AppMethodBeat.o(226576);
      }
    });
    locala.show();
    AppMethodBeat.o(226589);
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
    AppMethodBeat.i(226595);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    this.oXA.hb(true);
    AppMethodBeat.o(226595);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(226594);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    if (cin() != null)
    {
      U(true);
      u.makeText(AndroidContextUtil.castActivityOrNull(this.kGW.mContext), 2131756186, 0).show();
    }
    if (this.oWG != null) {
      this.oWG.q(this.oWE);
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226581);
        final int i = g.e(g.this);
        if (g.f(g.this) != null) {
          g.f(g.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(226580);
              g.this.BH(i);
              AppMethodBeat.o(226580);
            }
          });
        }
        AppMethodBeat.o(226581);
      }
    }, "");
    AppMethodBeat.o(226594);
  }
  
  public final void bCA()
  {
    AppMethodBeat.i(226593);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    if (cin() != null) {
      U(false);
    }
    AppMethodBeat.o(226593);
  }
  
  public final void bCB()
  {
    AppMethodBeat.i(226596);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    super.bCB();
    bCO();
    AppMethodBeat.o(226596);
  }
  
  public final boolean bCL()
  {
    AppMethodBeat.i(226588);
    boolean bool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_1v1_tip", false);
    if ((ciq()) && (!bool))
    {
      AppMethodBeat.o(226588);
      return true;
    }
    AppMethodBeat.o(226588);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(226592);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    super.onDestroy();
    if (this.lqJ != null) {
      this.lqJ.b(this.lqK);
    }
    AppMethodBeat.o(226592);
  }
  
  public final boolean wu(final int paramInt)
  {
    AppMethodBeat.i(226587);
    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    if (ciq())
    {
      if (!bCL()) {
        break label83;
      }
      Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, should show voip tip");
      a(this.oXA.getActivity(), new a()
      {
        public final void bCH()
        {
          AppMethodBeat.i(226575);
          g.a(g.this, paramInt);
          AppMethodBeat.o(226575);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(226587);
      return false;
      label83:
      wy(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bCH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.g
 * JD-Core Version:    0.7.0.1
 */