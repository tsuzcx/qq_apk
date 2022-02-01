package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.ad.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mmkv.MMKV;

public class g
  extends com.tencent.mm.plugin.ball.service.f
  implements k
{
  private static com.tencent.mm.plugin.ball.c.f kmM;
  p jFm;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f knb;
  private f.b knc;
  private final String kne;
  
  static
  {
    AppMethodBeat.i(222307);
    kmM = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(222284);
        g.f(paramAnonymousBallInfo);
        AppMethodBeat.o(222284);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(222307);
  }
  
  public g(com.tencent.mm.plugin.ball.a.f paramf, p paramp)
  {
    super(paramf);
    AppMethodBeat.i(222286);
    this.kne = "has_shown_appbrand_voip_tip";
    this.knc = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(222285);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (g.e(g.this) != null) && (g.e(g.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (g.e(g.this).jzC.dQv == paramAnonymousAppBrandBackgroundRunningOperationParcel.hSZ) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.beO == 4) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dlO == 1)) {
          g.f(g.this);
        }
        AppMethodBeat.o(222285);
      }
    };
    this.jFm = paramp;
    paramp.a(this);
    ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramp.hashCode()) });
    this.knb = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(222286);
  }
  
  private void bhA()
  {
    AppMethodBeat.i(222300);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.jFm.mAppId;
      localMMBackgroundRunningOperationParcel.beO = 4;
      localMMBackgroundRunningOperationParcel.dlO = 2;
      ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.jFm.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(222300);
  }
  
  private int bhB()
  {
    AppMethodBeat.i(222301);
    if (this.jFm != null)
    {
      d locald = (d)this.jFm.as(d.class);
      if (locald != null)
      {
        boolean bool = locald.lCo;
        ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          AppMethodBeat.o(222301);
          return 32;
        }
        AppMethodBeat.o(222301);
        return 64;
      }
    }
    AppMethodBeat.o(222301);
    return 32;
  }
  
  public static void bhy()
  {
    AppMethodBeat.i(222298);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(17, kmM);
    }
    AppMethodBeat.o(222298);
  }
  
  public static void bhz()
  {
    AppMethodBeat.i(222299);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(17, kmM);
    }
    AppMethodBeat.o(222299);
  }
  
  private void sC(final int paramInt)
  {
    AppMethodBeat.i(222291);
    if (!b.cc(this.nME.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.nME.getActivity(), 17, new c.a()
      {
        public final void gd(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(222281);
          ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            g.b(g.this, paramInt);
            AppMethodBeat.o(222281);
            return;
          }
          ae.w("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          g.this.bLx();
          g.a(g.this);
          g.b(g.this).ge(true);
          AppMethodBeat.o(222281);
        }
      });
      AppMethodBeat.o(222291);
      return;
    }
    sz(paramInt);
    AppMethodBeat.o(222291);
  }
  
  private void sz(int paramInt)
  {
    AppMethodBeat.i(222292);
    bLD().opType = yd(paramInt);
    bLz();
    Point localPoint = this.nLM.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.nME, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bhp()
      {
        AppMethodBeat.i(222283);
        ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        g.d(g.this).ge(true);
        AppMethodBeat.o(222283);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(222282);
        ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        g.c(g.this).ge(false);
        AppMethodBeat.o(222282);
      }
    });
    AppMethodBeat.o(222292);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(222290);
    f.a locala = new f.a(paramContext);
    locala.aZq(paramContext.getString(2131756064));
    locala.EyN = true;
    locala.afY(2131756065);
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(222280);
        ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "showVOIPTip, has shown tip");
        MMKV.defaultMMKV().encode("has_shown_appbrand_voip_tip", true);
        if (parama != null) {
          parama.bht();
        }
        AppMethodBeat.o(222280);
      }
    });
    locala.show();
    AppMethodBeat.o(222290);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(222287);
    ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    if (this.knb != null) {
      this.knb.a(this.knc);
    }
    AppMethodBeat.o(222287);
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
    AppMethodBeat.i(222294);
    ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    if (bLu() != null) {
      V(false);
    }
    AppMethodBeat.o(222294);
  }
  
  public final void bhk()
  {
    AppMethodBeat.i(222295);
    ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    if (bLu() != null)
    {
      V(true);
      t.makeText(com.tencent.mm.sdk.f.a.jw(this.jFm.mContext), 2131756066, 0).show();
    }
    if (this.nLM != null) {
      this.nLM.r(this.nLK);
    }
    AppMethodBeat.o(222295);
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(222296);
    ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    this.nME.ge(true);
    AppMethodBeat.o(222296);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(222297);
    ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    super.bhm();
    bhA();
    AppMethodBeat.o(222297);
  }
  
  public final boolean bhx()
  {
    AppMethodBeat.i(222289);
    boolean bool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_tip", false);
    if ((bLw()) && (!bool))
    {
      AppMethodBeat.o(222289);
      return true;
    }
    AppMethodBeat.o(222289);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(222293);
    ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    super.onDestroy();
    if (this.knb != null) {
      this.knb.b(this.knc);
    }
    AppMethodBeat.o(222293);
  }
  
  public final boolean sy(final int paramInt)
  {
    AppMethodBeat.i(222288);
    ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    if (bLw())
    {
      if (!bhx()) {
        break label83;
      }
      ae.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, should show voip tip");
      a(this.nME.getActivity(), new a()
      {
        public final void bht()
        {
          AppMethodBeat.i(222279);
          g.a(g.this, paramInt);
          AppMethodBeat.o(222279);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(222288);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.g
 * JD-Core Version:    0.7.0.1
 */