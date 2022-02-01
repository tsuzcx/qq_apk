package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mmkv.MMKV;

public class f
  extends com.tencent.mm.plugin.ball.service.f
  implements n
{
  private static com.tencent.mm.plugin.ball.c.e lqt;
  q kGW;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f lqJ;
  private f.b lqK;
  private final String lqM;
  
  static
  {
    AppMethodBeat.i(226574);
    lqt = new f.5();
    AppMethodBeat.o(226574);
  }
  
  public f(com.tencent.mm.plugin.ball.a.f paramf, q paramq)
  {
    super(paramf);
    AppMethodBeat.i(226553);
    this.lqM = "has_shown_appbrand_voip_tip";
    this.lqK = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(226552);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (f.e(f.this) != null) && (f.e(f.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (f.e(f.this).kAq.eix == paramAnonymousAppBrandBackgroundRunningOperationParcel.iOo) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.beL == 4) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.dDe == 1)) {
          f.f(f.this);
        }
        AppMethodBeat.o(226552);
      }
    };
    this.kGW = paramq;
    paramq.a(this);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramq.hashCode()) });
    this.lqJ = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(226553);
  }
  
  public static void bCM()
  {
    AppMethodBeat.i(226565);
    if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).a(17, lqt);
    }
    AppMethodBeat.o(226565);
  }
  
  public static void bCN()
  {
    AppMethodBeat.i(226566);
    if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).b(17, lqt);
    }
    AppMethodBeat.o(226566);
  }
  
  private void bCO()
  {
    AppMethodBeat.i(226567);
    if (g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.kGW.mAppId;
      localMMBackgroundRunningOperationParcel.beL = 4;
      localMMBackgroundRunningOperationParcel.dDe = 2;
      Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.kGW.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(226567);
  }
  
  private int bCP()
  {
    AppMethodBeat.i(226568);
    if (this.kGW != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.ag.c.e locale = (com.tencent.mm.plugin.appbrand.jsapi.ag.c.e)this.kGW.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.c.e.class);
      if (locale != null)
      {
        boolean bool = locale.mJN;
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          AppMethodBeat.o(226568);
          return 32;
        }
        AppMethodBeat.o(226568);
        return 64;
      }
    }
    AppMethodBeat.o(226568);
    return 32;
  }
  
  private void wv(int paramInt)
  {
    AppMethodBeat.i(226559);
    ciw().opType = BI(paramInt);
    cit();
    Point localPoint = this.oWG.getBallPosition();
    c.a(this.oXA, localPoint, new com.tencent.mm.plugin.ball.d.a()
    {
      public final void awJ()
      {
        AppMethodBeat.i(226550);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        f.d(f.this).hb(true);
        AppMethodBeat.o(226550);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(226549);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        f.c(f.this).hb(false);
        AppMethodBeat.o(226549);
      }
    });
    AppMethodBeat.o(226559);
  }
  
  private void wy(final int paramInt)
  {
    AppMethodBeat.i(226558);
    if (!com.tencent.mm.compatible.e.b.cx(this.oXA.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.oXA.getActivity(), 17, new c.a()
      {
        public final void ha(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(226548);
          Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            f.b(f.this, paramInt);
            AppMethodBeat.o(226548);
            return;
          }
          Log.w("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          f.this.cir();
          f.a(f.this);
          f.b(f.this).hb(true);
          AppMethodBeat.o(226548);
        }
      });
      AppMethodBeat.o(226558);
      return;
    }
    wv(paramInt);
    AppMethodBeat.o(226558);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(226554);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.G(paramInt, paramString);
    if (this.lqJ != null) {
      this.lqJ.a(this.lqK);
    }
    AppMethodBeat.o(226554);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(226557);
    com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(paramContext);
    locala.bow(paramContext.getString(2131756184));
    locala.JnN = true;
    locala.apa(2131756185);
    locala.b(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(226547);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "showVOIPTip, has shown tip");
        MMKV.defaultMMKV().encode("has_shown_appbrand_voip_tip", true);
        if (parama != null) {
          parama.bCH();
        }
        AppMethodBeat.o(226547);
      }
    });
    locala.show();
    AppMethodBeat.o(226557);
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
    AppMethodBeat.i(226563);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    this.oXA.hb(true);
    AppMethodBeat.o(226563);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(226562);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    if (cin() != null)
    {
      U(true);
      u.makeText(AndroidContextUtil.castActivityOrNull(this.kGW.mContext), 2131756186, 0).show();
    }
    if (this.oWG != null) {
      this.oWG.q(this.oWE);
    }
    AppMethodBeat.o(226562);
  }
  
  public final void bCA()
  {
    AppMethodBeat.i(226561);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    if (cin() != null) {
      U(false);
    }
    AppMethodBeat.o(226561);
  }
  
  public final void bCB()
  {
    AppMethodBeat.i(226564);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    super.bCB();
    bCO();
    AppMethodBeat.o(226564);
  }
  
  public final boolean bCL()
  {
    AppMethodBeat.i(226556);
    boolean bool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_tip", false);
    if ((ciq()) && (!bool))
    {
      AppMethodBeat.o(226556);
      return true;
    }
    AppMethodBeat.o(226556);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(226560);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    super.onDestroy();
    if (this.lqJ != null) {
      this.lqJ.b(this.lqK);
    }
    AppMethodBeat.o(226560);
  }
  
  public final boolean wu(final int paramInt)
  {
    AppMethodBeat.i(226555);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    if (ciq())
    {
      if (!bCL()) {
        break label83;
      }
      Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, should show voip tip");
      a(this.oXA.getActivity(), new a()
      {
        public final void bCH()
        {
          AppMethodBeat.i(226546);
          f.a(f.this, paramInt);
          AppMethodBeat.o(226546);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(226555);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.f
 * JD-Core Version:    0.7.0.1
 */