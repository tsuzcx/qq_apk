package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mmkv.MMKV;

public final class h
  extends com.tencent.mm.plugin.ball.service.f
  implements k
{
  private static com.tencent.mm.plugin.ball.c.f kjw;
  private Handler handler;
  o jCo;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.g kjL;
  private g.b kjM;
  private final String kjO;
  
  static
  {
    AppMethodBeat.i(188214);
    kjw = new com.tencent.mm.plugin.ball.c.f()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(188189);
        h.g(paramAnonymousBallInfo);
        AppMethodBeat.o(188189);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(188190);
        if ((paramAnonymousBallInfo != null) && (paramAnonymousBallInfo.type == 19))
        {
          ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "handleBallInfoClicked, appbrand voip float ball");
          paramAnonymousBallInfo = paramAnonymousBallInfo.ime.getString("appId");
          AppBrandVoIP1v1FloatBallEvent localAppBrandVoIP1v1FloatBallEvent = new AppBrandVoIP1v1FloatBallEvent();
          localAppBrandVoIP1v1FloatBallEvent.dyx = 1;
          com.tencent.mm.plugin.appbrand.ipc.e.b(paramAnonymousBallInfo, localAppBrandVoIP1v1FloatBallEvent);
        }
        AppMethodBeat.o(188190);
      }
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
      
      public final void h(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(188214);
  }
  
  public h(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(188192);
    this.kjO = "has_shown_appbrand_voip_1v1_tip";
    this.kjM = new g.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(188191);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (h.g(h.this) != null) && (h.g(h.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (h.g(h.this).jwG.dPf == paramAnonymousAppBrandBackgroundRunningOperationParcel.hQh) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.beO == 16) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dkM == 1)) {
          h.h(h.this);
        }
        AppMethodBeat.o(188191);
      }
    };
    this.jCo = paramo;
    paramo.a(this);
    ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    this.kjL = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class));
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(188192);
  }
  
  public static void bgQ()
  {
    AppMethodBeat.i(188204);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(19, kjw);
    }
    AppMethodBeat.o(188204);
  }
  
  public static void bgR()
  {
    AppMethodBeat.i(188205);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(19, kjw);
    }
    AppMethodBeat.o(188205);
  }
  
  private void bgS()
  {
    AppMethodBeat.i(188206);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.jCo.mAppId;
      localMMBackgroundRunningOperationParcel.beO = 16;
      localMMBackgroundRunningOperationParcel.dkM = 2;
      ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.jCo.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(188206);
  }
  
  private int bgT()
  {
    AppMethodBeat.i(188207);
    if (this.jCo != null)
    {
      Object localObject = p.oXv;
      if (((p)localObject).oXB == p.d.oZn)
      {
        localObject = ((p)localObject).oXy;
        if (((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.e)localObject).oWf != null)
        {
          bool = ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.e)localObject).oWr;
          if (bool) {
            break label84;
          }
        }
      }
      label84:
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label89;
        }
        AppMethodBeat.o(188207);
        return 32;
        bool = false;
        break;
      }
      label89:
      AppMethodBeat.o(188207);
      return 64;
    }
    AppMethodBeat.o(188207);
    return 32;
  }
  
  private void sw(int paramInt)
  {
    AppMethodBeat.i(188198);
    bKG().opType = ya(paramInt);
    bKC();
    Point localPoint = this.nGl.getBallPosition();
    com.tencent.mm.plugin.ball.ui.c.a(this.nHb, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void bgH()
      {
        AppMethodBeat.i(188186);
        ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        h.d(h.this).gg(true);
        AppMethodBeat.o(188186);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(188185);
        ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation end");
        h.c(h.this).gg(false);
        AppMethodBeat.o(188185);
      }
    });
    AppMethodBeat.o(188198);
  }
  
  private void sz(final int paramInt)
  {
    AppMethodBeat.i(188197);
    if (!com.tencent.mm.compatible.d.b.ca(this.nHb.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.nHb.getActivity(), 19, new c.a()
      {
        public final void ge(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(188184);
          ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            h.b(h.this, paramInt);
            AppMethodBeat.o(188184);
            return;
          }
          ad.w("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          h.this.bKA();
          h.a(h.this);
          h.b(h.this).gg(true);
          AppMethodBeat.o(188184);
        }
      });
      AppMethodBeat.o(188197);
      return;
    }
    sw(paramInt);
    AppMethodBeat.o(188197);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(188196);
    f.a locala = new f.a(paramContext);
    locala.aXO(paramContext.getString(2131756064));
    locala.EgK = true;
    locala.afp(2131756065);
    locala.b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(188183);
        ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "showVOIPTip, has shown tip");
        MMKV.defaultMMKV().encode("has_shown_appbrand_voip_1v1_tip", true);
        if (parama != null) {
          parama.bgL();
        }
        AppMethodBeat.o(188183);
      }
    });
    locala.show();
    AppMethodBeat.o(188196);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(188193);
    ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    if (this.kjL != null) {
      this.kjL.a(this.kjM);
    }
    AppMethodBeat.o(188193);
  }
  
  public final boolean bgA()
  {
    return false;
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(188200);
    ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    if (bKx() != null) {
      V(false);
    }
    AppMethodBeat.o(188200);
  }
  
  public final void bgC()
  {
    AppMethodBeat.i(188201);
    ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    if (bKx() != null)
    {
      V(true);
      t.makeText(com.tencent.mm.sdk.f.a.jq(this.jCo.mContext), 2131756066, 0).show();
    }
    if (this.nGl != null) {
      this.nGl.r(this.nGj);
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188188);
        final int i = h.e(h.this);
        if (h.f(h.this) != null) {
          h.f(h.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(188187);
              h.this.xY(i);
              AppMethodBeat.o(188187);
            }
          });
        }
        AppMethodBeat.o(188188);
      }
    }, "");
    AppMethodBeat.o(188201);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(188202);
    ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    this.nHb.gg(true);
    AppMethodBeat.o(188202);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(188203);
    ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    super.bgE();
    bgS();
    AppMethodBeat.o(188203);
  }
  
  public final boolean bgP()
  {
    AppMethodBeat.i(188195);
    boolean bool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_1v1_tip", false);
    if ((bKz()) && (!bool))
    {
      AppMethodBeat.o(188195);
      return true;
    }
    AppMethodBeat.o(188195);
    return false;
  }
  
  public final boolean bgz()
  {
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(188199);
    ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    super.onDestroy();
    if (this.kjL != null) {
      this.kjL.b(this.kjM);
    }
    AppMethodBeat.o(188199);
  }
  
  public final boolean sv(final int paramInt)
  {
    AppMethodBeat.i(188194);
    ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    if (bKz())
    {
      if (!bgP()) {
        break label83;
      }
      ad.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, should show voip tip");
      a(this.nHb.getActivity(), new a()
      {
        public final void bgL()
        {
          AppMethodBeat.i(188182);
          h.a(h.this, paramInt);
          AppMethodBeat.o(188182);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(188194);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.h
 * JD-Core Version:    0.7.0.1
 */