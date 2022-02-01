package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mmkv.MMKV;

public class g
  extends com.tencent.mm.plugin.ball.service.f
  implements k
{
  private static com.tencent.mm.plugin.ball.c.f jpa;
  o joZ;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.g jpo;
  private g.b jpp;
  private final String jpr;
  
  static
  {
    AppMethodBeat.i(195763);
    jpa = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(195740);
        g.f(paramAnonymousBallInfo);
        AppMethodBeat.o(195740);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(195763);
  }
  
  public g(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(195742);
    this.jpr = "has_shown_appbrand_voip_tip";
    this.jpp = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(195741);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (g.e(g.this) != null) && (g.e(g.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (g.e(g.this).iDx.iOP == paramAnonymousAppBrandBackgroundRunningOperationParcel.gXn) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.aTC == 4) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dbV == 1)) {
          g.f(g.this);
        }
        AppMethodBeat.o(195741);
      }
    };
    this.joZ = paramo;
    paramo.a(this);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.jpo = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    AppMethodBeat.o(195742);
  }
  
  public static void aWo()
  {
    AppMethodBeat.i(195754);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(17, jpa);
    }
    AppMethodBeat.o(195754);
  }
  
  public static void aWp()
  {
    AppMethodBeat.i(195755);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(17, jpa);
    }
    AppMethodBeat.o(195755);
  }
  
  private void aWq()
  {
    AppMethodBeat.i(195756);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.joZ.mAppId;
      localMMBackgroundRunningOperationParcel.aTC = 4;
      localMMBackgroundRunningOperationParcel.dbV = 2;
      ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.joZ.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(195756);
  }
  
  private int aWr()
  {
    AppMethodBeat.i(195757);
    if (this.joZ != null)
    {
      d locald = (d)this.joZ.as(d.class);
      if (locald != null)
      {
        boolean bool = locald.kzz;
        ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          AppMethodBeat.o(195757);
          return 32;
        }
        AppMethodBeat.o(195757);
        return 64;
      }
    }
    AppMethodBeat.o(195757);
    return 32;
  }
  
  private void rh(int paramInt)
  {
    AppMethodBeat.i(195748);
    bzz().opType = wD(paramInt);
    bzv();
    Point localPoint = this.mDJ.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.mEA, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void aWf()
      {
        AppMethodBeat.i(195739);
        ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        g.d(g.this).fF(true);
        AppMethodBeat.o(195739);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(195738);
        ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        g.c(g.this).fF(false);
        AppMethodBeat.o(195738);
      }
    });
    AppMethodBeat.o(195748);
  }
  
  private void rk(final int paramInt)
  {
    AppMethodBeat.i(195747);
    if (!b.bZ(this.mEA.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.mEA.getActivity(), 17, new c.a()
      {
        public final void fD(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(195737);
          ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            g.b(g.this, paramInt);
            AppMethodBeat.o(195737);
            return;
          }
          ad.w("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          g.this.bzt();
          g.a(g.this);
          g.b(g.this).fF(true);
          AppMethodBeat.o(195737);
        }
      });
      AppMethodBeat.o(195747);
      return;
    }
    rh(paramInt);
    AppMethodBeat.o(195747);
  }
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(195743);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.Z(paramInt, paramString);
    if (this.jpo != null) {
      this.jpo.a(this.jpp);
    }
    AppMethodBeat.o(195743);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(195746);
    f.a locala = new f.a(paramContext);
    locala.aMo(paramContext.getString(2131756064));
    locala.HFB = true;
    locala.aaF(2131756065);
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(195736);
        ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "showVOIPTip, has shown tip");
        MMKV.defaultMMKV().encode("has_shown_appbrand_voip_tip", true);
        if (parama != null) {
          parama.aWj();
        }
        AppMethodBeat.o(195736);
      }
    });
    locala.show();
    AppMethodBeat.o(195746);
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
    AppMethodBeat.i(195750);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    if (bzq() != null) {
      V(false);
    }
    AppMethodBeat.o(195750);
  }
  
  public final void aWa()
  {
    AppMethodBeat.i(195751);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    if (bzq() != null)
    {
      V(true);
      t.makeText(com.tencent.mm.sdk.f.a.iV(this.joZ.mContext), 2131756066, 0).show();
    }
    if (this.mDJ != null) {
      this.mDJ.p(this.mDH);
    }
    AppMethodBeat.o(195751);
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(195752);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    this.mEA.fF(true);
    AppMethodBeat.o(195752);
  }
  
  public final void aWc()
  {
    AppMethodBeat.i(195753);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    super.aWc();
    aWq();
    AppMethodBeat.o(195753);
  }
  
  public final boolean aWn()
  {
    AppMethodBeat.i(195745);
    boolean bool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_tip", false);
    if ((bzs()) && (!bool))
    {
      AppMethodBeat.o(195745);
      return true;
    }
    AppMethodBeat.o(195745);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(195749);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    super.onDestroy();
    if (this.jpo != null) {
      this.jpo.b(this.jpp);
    }
    AppMethodBeat.o(195749);
  }
  
  public final boolean rg(final int paramInt)
  {
    AppMethodBeat.i(195744);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    if (bzs())
    {
      if (!aWn()) {
        break label83;
      }
      ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, should show voip tip");
      a(this.mEA.getActivity(), new a()
      {
        public final void aWj()
        {
          AppMethodBeat.i(195735);
          g.a(g.this, paramInt);
          AppMethodBeat.o(195735);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(195744);
      return false;
      label83:
      rk(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aWj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.g
 * JD-Core Version:    0.7.0.1
 */