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
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.z.c.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mmkv.MMKV;

public class g
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
    AppMethodBeat.i(186485);
    jPm = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(186462);
        g.f(paramAnonymousBallInfo);
        AppMethodBeat.o(186462);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(186485);
  }
  
  public g(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(186464);
    this.jPE = "has_shown_appbrand_voip_tip";
    this.jPC = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(186463);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (g.e(g.this) != null) && (g.e(g.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (g.e(g.this).jdx.joY == paramAnonymousAppBrandBackgroundRunningOperationParcel.hxM) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.aUu == 4) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.cZu == 1)) {
          g.f(g.this);
        }
        AppMethodBeat.o(186463);
      }
    };
    this.jPl = paramo;
    paramo.a(this);
    ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.jPB = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    AppMethodBeat.o(186464);
  }
  
  public static void bdm()
  {
    AppMethodBeat.i(186476);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(17, jPm);
    }
    AppMethodBeat.o(186476);
  }
  
  public static void bdn()
  {
    AppMethodBeat.i(186477);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(17, jPm);
    }
    AppMethodBeat.o(186477);
  }
  
  private void bdo()
  {
    AppMethodBeat.i(186478);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.jPl.mAppId;
      localMMBackgroundRunningOperationParcel.aUu = 4;
      localMMBackgroundRunningOperationParcel.cZu = 2;
      ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.jPl.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(186478);
  }
  
  private int bdp()
  {
    AppMethodBeat.i(186479);
    if (this.jPl != null)
    {
      d locald = (d)this.jPl.as(d.class);
      if (locald != null)
      {
        boolean bool = locald.laQ;
        ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          AppMethodBeat.o(186479);
          return 32;
        }
        AppMethodBeat.o(186479);
        return 64;
      }
    }
    AppMethodBeat.o(186479);
    return 32;
  }
  
  private void rU(int paramInt)
  {
    AppMethodBeat.i(186470);
    bGv().opType = xu(paramInt);
    bGr();
    Point localPoint = this.nfP.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.ngF, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bdd()
      {
        AppMethodBeat.i(186461);
        ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        g.d(g.this).gb(true);
        AppMethodBeat.o(186461);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(186460);
        ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        g.c(g.this).gb(false);
        AppMethodBeat.o(186460);
      }
    });
    AppMethodBeat.o(186470);
  }
  
  private void rX(final int paramInt)
  {
    AppMethodBeat.i(186469);
    if (!b.cc(this.ngF.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.ngF.getActivity(), 17, new c.a()
      {
        public final void fZ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(186459);
          ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            g.b(g.this, paramInt);
            AppMethodBeat.o(186459);
            return;
          }
          ac.w("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          g.this.bGp();
          g.a(g.this);
          g.b(g.this).gb(true);
          AppMethodBeat.o(186459);
        }
      });
      AppMethodBeat.o(186469);
      return;
    }
    rU(paramInt);
    AppMethodBeat.o(186469);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(186468);
    f.a locala = new f.a(paramContext);
    locala.aRQ(paramContext.getString(2131756064));
    locala.JfY = true;
    locala.acQ(2131756065);
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(186458);
        ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "showVOIPTip, has shown tip");
        MMKV.defaultMMKV().encode("has_shown_appbrand_voip_tip", true);
        if (parama != null) {
          parama.bdh();
        }
        AppMethodBeat.o(186458);
      }
    });
    locala.show();
    AppMethodBeat.o(186468);
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(186465);
    ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.aa(paramInt, paramString);
    if (this.jPB != null) {
      this.jPB.a(this.jPC);
    }
    AppMethodBeat.o(186465);
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
    AppMethodBeat.i(186472);
    ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    if (bGm() != null) {
      V(false);
    }
    AppMethodBeat.o(186472);
  }
  
  public final void bcY()
  {
    AppMethodBeat.i(186473);
    ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    if (bGm() != null)
    {
      V(true);
      t.makeText(com.tencent.mm.sdk.f.a.jg(this.jPl.mContext), 2131756066, 0).show();
    }
    if (this.nfP != null) {
      this.nfP.q(this.nfN);
    }
    AppMethodBeat.o(186473);
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(186474);
    ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    this.ngF.gb(true);
    AppMethodBeat.o(186474);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(186475);
    ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    super.bda();
    bdo();
    AppMethodBeat.o(186475);
  }
  
  public final boolean bdl()
  {
    AppMethodBeat.i(186467);
    boolean bool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_tip", false);
    if ((bGo()) && (!bool))
    {
      AppMethodBeat.o(186467);
      return true;
    }
    AppMethodBeat.o(186467);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186471);
    ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    super.onDestroy();
    if (this.jPB != null) {
      this.jPB.b(this.jPC);
    }
    AppMethodBeat.o(186471);
  }
  
  public final boolean rT(final int paramInt)
  {
    AppMethodBeat.i(186466);
    ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    if (bGo())
    {
      if (!bdl()) {
        break label83;
      }
      ac.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, should show voip tip");
      a(this.ngF.getActivity(), new a()
      {
        public final void bdh()
        {
          AppMethodBeat.i(186457);
          g.a(g.this, paramInt);
          AppMethodBeat.o(186457);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(186466);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.g
 * JD-Core Version:    0.7.0.1
 */