package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.graphics.Point;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.g.c;

public class g
  extends com.tencent.mm.plugin.ball.service.e
  implements n
{
  private static com.tencent.mm.plugin.ball.c.e roL;
  w qxC;
  private com.tencent.mm.plugin.appbrand.backgroundrunning.f rpc;
  private f.b rpd;
  private final String rpf;
  
  static
  {
    AppMethodBeat.i(318338);
    roL = new g.5();
    AppMethodBeat.o(318338);
  }
  
  public g(com.tencent.mm.plugin.ball.a.f paramf, w paramw)
  {
    super(paramf);
    AppMethodBeat.i(318225);
    this.rpf = "has_shown_appbrand_voip_tip";
    this.rpd = new f.b()
    {
      public final void b(AppBrandBackgroundRunningOperationParcel paramAnonymousAppBrandBackgroundRunningOperationParcel)
      {
        AppMethodBeat.i(318323);
        if ((paramAnonymousAppBrandBackgroundRunningOperationParcel != null) && (g.e(g.this) != null) && (g.e(g.this).mAppId.equals(paramAnonymousAppBrandBackgroundRunningOperationParcel.appId)) && (g.e(g.this).qsh.eul == paramAnonymousAppBrandBackgroundRunningOperationParcel.euz) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.cIi == 4) && (paramAnonymousAppBrandBackgroundRunningOperationParcel.hAf == 1)) {
          g.f(g.this);
        }
        AppMethodBeat.o(318323);
      }
    };
    this.qxC = paramw;
    paramw.a(this);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramw.hashCode()) });
    this.rpc = ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class));
    AppMethodBeat.o(318225);
  }
  
  private void Ac(final int paramInt)
  {
    AppMethodBeat.i(318231);
    if (!com.tencent.mm.compatible.e.b.dh(this.vkT.getActivity()))
    {
      AppBrandFloatBallPermissionHelper.a(this.vkT.getActivity(), 17, new c.a()
      {
        public final void onCheckResult(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(318310);
          Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            g.b(g.this, paramInt);
            AppMethodBeat.o(318310);
            return;
          }
          Log.w("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
          g.this.cYp();
          g.a(g.this);
          g.b(g.this).iR(true);
          AppMethodBeat.o(318310);
        }
      });
      AppMethodBeat.o(318231);
      return;
    }
    zY(paramInt);
    AppMethodBeat.o(318231);
  }
  
  public static void cou()
  {
    AppMethodBeat.i(318245);
    if (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).a(17, roL);
    }
    AppMethodBeat.o(318245);
  }
  
  public static void cov()
  {
    AppMethodBeat.i(318253);
    if (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).b(17, roL);
    }
    AppMethodBeat.o(318253);
  }
  
  private void cow()
  {
    AppMethodBeat.i(318263);
    if (h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null)
    {
      MMBackgroundRunningOperationParcel localMMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
      localMMBackgroundRunningOperationParcel.appId = this.qxC.mAppId;
      localMMBackgroundRunningOperationParcel.cIi = 4;
      localMMBackgroundRunningOperationParcel.hAf = 2;
      Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "stopVOIP, appId:%s", new Object[] { this.qxC.mAppId });
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.f)h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(localMMBackgroundRunningOperationParcel);
    }
    AppMethodBeat.o(318263);
  }
  
  private int cox()
  {
    AppMethodBeat.i(318271);
    if (this.qxC != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.al.c.e locale = (com.tencent.mm.plugin.appbrand.jsapi.al.c.e)this.qxC.aO(com.tencent.mm.plugin.appbrand.jsapi.al.c.e.class);
      if (locale != null)
      {
        boolean bool = locale.sPy;
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "getCurrentVOIPState, enableMic:%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          AppMethodBeat.o(318271);
          return 32;
        }
        AppMethodBeat.o(318271);
        return 64;
      }
    }
    AppMethodBeat.o(318271);
    return 32;
  }
  
  private void zY(int paramInt)
  {
    AppMethodBeat.i(318238);
    cYv().opType = FK(paramInt);
    cYr();
    Point localPoint = this.vjX.getBallPosition();
    c.a(this.vkT, localPoint, new a()
    {
      public final void aXe()
      {
        AppMethodBeat.i(318329);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
        g.d(g.this).iR(true);
        AppMethodBeat.o(318329);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(318324);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation end");
        g.c(g.this).iR(false);
        AppMethodBeat.o(318324);
      }
    });
    AppMethodBeat.o(318238);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(318345);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.J(paramInt, paramString);
    if (this.rpc != null) {
      this.rpc.a(this.rpd);
    }
    AppMethodBeat.o(318345);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(318355);
    com.tencent.mm.ui.widget.a.g.a locala = new com.tencent.mm.ui.widget.a.g.a(paramContext);
    locala.bDE(paramContext.getString(ba.i.appbrand_voip_float_ball_confirm_msg));
    locala.Xdm = true;
    locala.aEX(ba.i.appbrand_voip_float_ball_confirm_ok);
    locala.b(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(318305);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "showVOIPTip, has shown tip");
        MultiProcessMMKV.getDefault().encode("has_shown_appbrand_voip_tip", true);
        if (parama != null) {
          parama.coq();
        }
        AppMethodBeat.o(318305);
      }
    });
    locala.show();
    AppMethodBeat.o(318355);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(318366);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    this.vkT.iR(true);
    AppMethodBeat.o(318366);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(318364);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    if (cYl() != null)
    {
      E(true);
      aa.makeText(AndroidContextUtil.castActivityOrNull(this.qxC.mContext), ba.i.appbrand_voip_float_ball_toast_msg, 0).show();
    }
    if (this.vjX != null) {
      this.vjX.q(this.vjV);
    }
    AppMethodBeat.o(318364);
  }
  
  public final void coi()
  {
    AppMethodBeat.i(318360);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    if (cYl() != null) {
      E(false);
    }
    AppMethodBeat.o(318360);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(318367);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    super.coj();
    cow();
    AppMethodBeat.o(318367);
  }
  
  public final boolean cot()
  {
    AppMethodBeat.i(318352);
    boolean bool = MultiProcessMMKV.getDefault().decodeBool("has_shown_appbrand_voip_tip", false);
    if ((cYo()) && (!bool))
    {
      AppMethodBeat.o(318352);
      return true;
    }
    AppMethodBeat.o(318352);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(318358);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    super.onDestroy();
    if (this.rpc != null) {
      this.rpc.b(this.rpd);
    }
    AppMethodBeat.o(318358);
  }
  
  public final boolean zX(final int paramInt)
  {
    AppMethodBeat.i(318349);
    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    if (cYo())
    {
      if (!cot()) {
        break label83;
      }
      Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, should show voip tip");
      a(this.vkT.getActivity(), new a()
      {
        public final void coq()
        {
          AppMethodBeat.i(318306);
          g.a(g.this, paramInt);
          AppMethodBeat.o(318306);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(318349);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.g
 * JD-Core Version:    0.7.0.1
 */