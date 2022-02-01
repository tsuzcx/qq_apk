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
import com.tencent.mm.plugin.appbrand.jsapi.ac.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mmkv.MMKV;

public class g
  extends com.tencent.mm.plugin.ball.service.f
  implements k
{
  private static com.tencent.mm.plugin.ball.c.f kjw;
  o jCo;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.g kjL;
  private g.b kjM;
  private final String kjO;
  
  static
  {
    AppMethodBeat.i(188181);
    kjw = new g.5();
    AppMethodBeat.o(188181);
  }
  
  public g(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(188160);
    this.kjO = "has_shown_appbrand_voip_tip";
    this.kjM = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(188159);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (g.e(g.this) != null) && (g.e(g.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (g.e(g.this).jwG.dPf == paramAnonymousAppBrandBackgroundRunningOperationParcel.hQh) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.beO == 4) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dkM == 1)) {
          g.f(g.this);
        }
        AppMethodBeat.o(188159);
      }
    };
    this.jCo = paramo;
    paramo.a(this);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.kjL = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    AppMethodBeat.o(188160);
  }
  
  public static void bgQ()
  {
    AppMethodBeat.i(188172);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(17, kjw);
    }
    AppMethodBeat.o(188172);
  }
  
  public static void bgR()
  {
    AppMethodBeat.i(188173);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(17, kjw);
    }
    AppMethodBeat.o(188173);
  }
  
  private void bgS()
  {
    AppMethodBeat.i(188174);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.jCo.mAppId;
      localMMBackgroundRunningOperationParcel.beO = 4;
      localMMBackgroundRunningOperationParcel.dkM = 2;
      ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.jCo.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(188174);
  }
  
  private int bgT()
  {
    AppMethodBeat.i(188175);
    if (this.jCo != null)
    {
      d locald = (d)this.jCo.as(d.class);
      if (locald != null)
      {
        boolean bool = locald.lxQ;
        ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          AppMethodBeat.o(188175);
          return 32;
        }
        AppMethodBeat.o(188175);
        return 64;
      }
    }
    AppMethodBeat.o(188175);
    return 32;
  }
  
  private void sw(int paramInt)
  {
    AppMethodBeat.i(188166);
    bKG().opType = ya(paramInt);
    bKC();
    Point localPoint = this.nGl.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.nHb, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bgH()
      {
        AppMethodBeat.i(188157);
        ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        g.d(g.this).gg(true);
        AppMethodBeat.o(188157);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(188156);
        ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        g.c(g.this).gg(false);
        AppMethodBeat.o(188156);
      }
    });
    AppMethodBeat.o(188166);
  }
  
  private void sz(final int paramInt)
  {
    AppMethodBeat.i(188165);
    if (!b.ca(this.nHb.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.nHb.getActivity(), 17, new c.a()
      {
        public final void ge(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(188155);
          ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            g.b(g.this, paramInt);
            AppMethodBeat.o(188155);
            return;
          }
          ad.w("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          g.this.bKA();
          g.a(g.this);
          g.b(g.this).gg(true);
          AppMethodBeat.o(188155);
        }
      });
      AppMethodBeat.o(188165);
      return;
    }
    sw(paramInt);
    AppMethodBeat.o(188165);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(188164);
    f.a locala = new f.a(paramContext);
    locala.aXO(paramContext.getString(2131756064));
    locala.EgK = true;
    locala.afp(2131756065);
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(188154);
        ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "showVOIPTip, has shown tip");
        MMKV.defaultMMKV().encode("has_shown_appbrand_voip_tip", true);
        if (parama != null) {
          parama.bgL();
        }
        AppMethodBeat.o(188154);
      }
    });
    locala.show();
    AppMethodBeat.o(188164);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(188161);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    if (this.kjL != null) {
      this.kjL.a(this.kjM);
    }
    AppMethodBeat.o(188161);
  }
  
  public final boolean bgA()
  {
    return false;
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(188168);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    if (bKx() != null) {
      V(false);
    }
    AppMethodBeat.o(188168);
  }
  
  public final void bgC()
  {
    AppMethodBeat.i(188169);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    if (bKx() != null)
    {
      V(true);
      t.makeText(com.tencent.mm.sdk.f.a.jq(this.jCo.mContext), 2131756066, 0).show();
    }
    if (this.nGl != null) {
      this.nGl.r(this.nGj);
    }
    AppMethodBeat.o(188169);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(188170);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    this.nHb.gg(true);
    AppMethodBeat.o(188170);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(188171);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    super.bgE();
    bgS();
    AppMethodBeat.o(188171);
  }
  
  public final boolean bgP()
  {
    AppMethodBeat.i(188163);
    boolean bool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_tip", false);
    if ((bKz()) && (!bool))
    {
      AppMethodBeat.o(188163);
      return true;
    }
    AppMethodBeat.o(188163);
    return false;
  }
  
  public final boolean bgz()
  {
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(188167);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    super.onDestroy();
    if (this.kjL != null) {
      this.kjL.b(this.kjM);
    }
    AppMethodBeat.o(188167);
  }
  
  public final boolean sv(final int paramInt)
  {
    AppMethodBeat.i(188162);
    ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    if (bKz())
    {
      if (!bgP()) {
        break label83;
      }
      ad.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, should show voip tip");
      a(this.nHb.getActivity(), new a()
      {
        public final void bgL()
        {
          AppMethodBeat.i(188153);
          g.a(g.this, paramInt);
          AppMethodBeat.o(188153);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(188162);
      return false;
      label83:
      sz(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bgL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.g
 * JD-Core Version:    0.7.0.1
 */