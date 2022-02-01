package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mmkv.MMKV;

public final class h
  extends com.tencent.mm.plugin.ball.service.f
  implements k
{
  private static com.tencent.mm.plugin.ball.c.f jPm;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.g jPB;
  private g.b jPC;
  private final String jPE;
  o jPl;
  
  static
  {
    AppMethodBeat.i(186515);
    jPm = new com.tencent.mm.plugin.ball.c.f()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(186491);
        h.f(paramAnonymousBallInfo);
        AppMethodBeat.o(186491);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(186492);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.type == 19))
        {
          ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "handleBallInfoClicked, appbrand voip float ball");
          paramAnonymousBallInfo = paramAnonymousBallInfo.hSN.getString("appId");
          AppBrandVoIP1v1FloatBallEvent localAppBrandVoIP1v1FloatBallEvent = new AppBrandVoIP1v1FloatBallEvent();
          localAppBrandVoIP1v1FloatBallEvent.dmJ = 1;
          e.b(paramAnonymousBallInfo, localAppBrandVoIP1v1FloatBallEvent);
        }
        AppMethodBeat.o(186492);
      }
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
      
      public final void g(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(186515);
  }
  
  public h(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(186494);
    this.jPE = "has_shown_appbrand_voip_1v1_tip";
    this.jPC = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(186493);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (h.e(h.this) != null) && (h.e(h.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (h.e(h.this).jdx.joY == paramAnonymousAppBrandBackgroundRunningOperationParcel.hxM) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.aUu == 16) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.cZu == 1)) {
          h.f(h.this);
        }
        AppMethodBeat.o(186493);
      }
    };
    this.jPl = paramo;
    paramo.a(this);
    ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.jPB = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    AppMethodBeat.o(186494);
  }
  
  public static void bdm()
  {
    AppMethodBeat.i(186506);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(19, jPm);
    }
    AppMethodBeat.o(186506);
  }
  
  public static void bdn()
  {
    AppMethodBeat.i(186507);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(19, jPm);
    }
    AppMethodBeat.o(186507);
  }
  
  private void bdo()
  {
    AppMethodBeat.i(186508);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.jPl.mAppId;
      localMMBackgroundRunningOperationParcel.aUu = 16;
      localMMBackgroundRunningOperationParcel.cZu = 2;
      ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.jPl.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(186508);
  }
  
  private int bdp()
  {
    AppMethodBeat.i(186509);
    if (this.jPl != null)
    {
      if (!p.otZ.bVz()) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        AppMethodBeat.o(186509);
        return 32;
      }
      AppMethodBeat.o(186509);
      return 64;
    }
    AppMethodBeat.o(186509);
    return 32;
  }
  
  private void rU(int paramInt)
  {
    AppMethodBeat.i(186500);
    bGv().opType = xu(paramInt);
    bGr();
    Point localPoint = this.nfP.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.ngF, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bdd()
      {
        AppMethodBeat.i(186490);
        ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        h.d(h.this).gb(true);
        AppMethodBeat.o(186490);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(186489);
        ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation end");
        h.c(h.this).gb(false);
        AppMethodBeat.o(186489);
      }
    });
    AppMethodBeat.o(186500);
  }
  
  private void rX(final int paramInt)
  {
    AppMethodBeat.i(186499);
    if (!b.cc(this.ngF.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.ngF.getActivity(), 19, new c.a()
      {
        public final void fZ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(186488);
          ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            h.b(h.this, paramInt);
            AppMethodBeat.o(186488);
            return;
          }
          ac.w("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          h.this.bGp();
          h.a(h.this);
          h.b(h.this).gb(true);
          AppMethodBeat.o(186488);
        }
      });
      AppMethodBeat.o(186499);
      return;
    }
    rU(paramInt);
    AppMethodBeat.o(186499);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(186498);
    f.a locala = new f.a(paramContext);
    locala.aRQ(paramContext.getString(2131756064));
    locala.JfY = true;
    locala.acQ(2131756065);
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(186487);
        ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "showVOIPTip, has shown tip");
        MMKV.defaultMMKV().encode("has_shown_appbrand_voip_1v1_tip", true);
        if (parama != null) {
          parama.bdh();
        }
        AppMethodBeat.o(186487);
      }
    });
    locala.show();
    AppMethodBeat.o(186498);
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(186495);
    ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.aa(paramInt, paramString);
    if (this.jPB != null) {
      this.jPB.a(this.jPC);
    }
    AppMethodBeat.o(186495);
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
    AppMethodBeat.i(186502);
    ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    if (bGm() != null) {
      V(false);
    }
    AppMethodBeat.o(186502);
  }
  
  public final void bcY()
  {
    AppMethodBeat.i(186503);
    ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    if (bGm() != null)
    {
      V(true);
      t.makeText(com.tencent.mm.sdk.f.a.jg(this.jPl.mContext), 2131756066, 0).show();
    }
    if (this.nfP != null) {
      this.nfP.q(this.nfN);
    }
    xs(bdp());
    AppMethodBeat.o(186503);
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(186504);
    ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    this.ngF.gb(true);
    AppMethodBeat.o(186504);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(186505);
    ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    super.bda();
    bdo();
    AppMethodBeat.o(186505);
  }
  
  public final boolean bdl()
  {
    AppMethodBeat.i(186497);
    boolean bool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_1v1_tip", false);
    if ((bGo()) && (!bool))
    {
      AppMethodBeat.o(186497);
      return true;
    }
    AppMethodBeat.o(186497);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186501);
    ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    super.onDestroy();
    if (this.jPB != null) {
      this.jPB.b(this.jPC);
    }
    AppMethodBeat.o(186501);
  }
  
  public final boolean rT(final int paramInt)
  {
    AppMethodBeat.i(186496);
    ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    if (bGo())
    {
      if (!bdl()) {
        break label83;
      }
      ac.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, should show voip tip");
      a(this.ngF.getActivity(), new a()
      {
        public final void bdh()
        {
          AppMethodBeat.i(186486);
          h.a(h.this, paramInt);
          AppMethodBeat.o(186486);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(186496);
      return false;
      label83:
      rX(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bdh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.h
 * JD-Core Version:    0.7.0.1
 */