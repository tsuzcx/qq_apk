package com.tencent.mm.plugin.appbrand.jsapi.al.e.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.luggage.xweb_ext.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.plugin.appbrand.g.b.a.a;
import com.tencent.mm.plugin.appbrand.g.b.d;
import com.tencent.mm.plugin.appbrand.g.b.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "eventHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "videoCastHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentPosMs", "", "interruptDetectorTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "interruptDetectorTimerInterrupted", "", "onDeviceSelectedListener", "Lkotlin/Function0;", "", "getOnDeviceSelectedListener", "()Lkotlin/jvm/functions/Function0;", "setOnDeviceSelectedListener", "(Lkotlin/jvm/functions/Function0;)V", "playRequestTimeOutTimer", "playRequestTimeOutTimerInterrupted", "postWhenPlayedAction", "progressTimer", "getProgressTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "reportHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "reportType", "getReportType", "()I", "setReportType", "(I)V", "selectDeviceBottomSheet", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "subEventListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$subEventListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$subEventListener$1;", "videoCastDeviceManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "destroy", "getProgressTimeMs", "getVolume", "action", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/RequestedAction;", "handleBroadcast", "msg", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$Event;", "lookupDeviceStatus", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRState$PlayState;", "pause", "Lkotlin/ParameterName;", "name", "success", "play", "initSeekToMs", "reconnect", "searchDevice", "needCloseBottomSheet", "isSearchForSwitch", "seek", "moment", "", "sendMessage", "setVolume", "volume", "startInterruptDetector", "stop", "stopInterruptDetector", "stopTimers", "switch", "unSubscribeDeviceEvent", "Companion", "Event", "WXControlCallback", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h.a sRS;
  private final com.tencent.mm.plugin.appbrand.jsapi.al.e.b eDp;
  public int hYb;
  private final com.tencent.luggage.xweb_ext.extendplugin.a sQs;
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a sRT;
  private g sRU;
  private c sRV;
  public kotlin.g.a.a<ah> sRW;
  private int sRX;
  private boolean sRY;
  private final MTimerHandler sRZ;
  public final i sRq;
  private kotlin.g.a.a<ah> sSa;
  private final v sSb;
  final MTimerHandler sSc;
  private boolean sSd;
  private final MTimerHandler sSe;
  
  static
  {
    AppMethodBeat.i(139781);
    sRS = new h.a((byte)0);
    AppMethodBeat.o(139781);
  }
  
  public h(com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama1, com.tencent.mm.plugin.appbrand.jsapi.al.e.b paramb)
  {
    AppMethodBeat.i(139780);
    this.sQs = parama;
    this.sRT = parama1;
    this.eDp = paramb;
    this.hYb = -1;
    this.sRq = new i();
    this.sRV = ((c)com.tencent.luggage.a.e.T(c.class));
    this.sRZ = new MTimerHandler(new h..ExternalSyntheticLambda1(this), false);
    this.sSb = new v(this);
    this.sSc = new MTimerHandler(new h..ExternalSyntheticLambda2(this), true);
    this.sSe = new MTimerHandler(new h..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(139780);
  }
  
  private static final void a(h paramh, e.a parama)
  {
    AppMethodBeat.i(327253);
    paramh.sRq.cza().a(parama);
    AppMethodBeat.o(327253);
  }
  
  private static final void a(h paramh, b paramb)
  {
    AppMethodBeat.i(327242);
    s.u(paramh, "this$0");
    s.u(paramb, "$msg");
    Log.i("MicroMsg.VideoCast.VideoCastController", s.X("handleBroadcast: ", paramb.sSf.name()));
    Object localObject1 = paramb.sSf;
    switch (d.$EnumSwitchMapping$0[localObject1.ordinal()])
    {
    }
    Object localObject2;
    Object localObject3;
    label241:
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(327242);
          return;
          AppMethodBeat.o(327242);
          return;
          paramh.sRq.cza().a(e.a.riB);
          paramh.cyY();
          a(paramh, e.a.riB);
          paramh.sRZ.stopTimer();
          paramh.sRY = true;
          paramh.sRT.onVideoPlay();
          paramh.sSc.startTimer(1000L);
          paramh.eDp.jV(true);
          paramh.sRT.cZ(true);
          localObject2 = paramh.sRq;
          localObject3 = ((Iterable)((i)localObject2).sSr).iterator();
          e locale;
          while (((Iterator)localObject3).hasNext())
          {
            locale = (e)((Iterator)localObject3).next();
            paramb = locale.sRn.cmY();
            if (paramb == null)
            {
              paramb = null;
              localObject1 = ((i)localObject2).cza().cmY();
              if (localObject1 != null) {
                break label293;
              }
            }
            for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rii)
            {
              if (!s.p(paramb, localObject1)) {
                break label299;
              }
              locale.myA = false;
              locale.sRo = true;
              locale.isSelected = true;
              break;
              paramb = paramb.rii;
              break label241;
            }
          }
          localObject3 = ((Iterable)((i)localObject2).sSs).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            locale = (e)((Iterator)localObject3).next();
            paramb = locale.sRn.cmY();
            if (paramb == null)
            {
              paramb = null;
              localObject1 = ((i)localObject2).cza().cmY();
              if (localObject1 != null) {
                break label405;
              }
            }
            for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rii)
            {
              if (!s.p(paramb, localObject1)) {
                break label411;
              }
              locale.myA = false;
              locale.sRo = true;
              locale.isSelected = true;
              break;
              paramb = paramb.rii;
              break label353;
            }
          }
          paramb = ((i)localObject2).sSt;
          if (paramb != null) {
            paramb.invoke();
          }
          if (paramh.sSa != null)
          {
            paramb = paramh.sSa;
            if (paramb != null) {
              paramb.invoke();
            }
            paramh.sSa = null;
          }
          if (paramh.hYb == 3)
          {
            localObject3 = paramh.sRV;
            if (localObject3 != null)
            {
              paramb = paramh.sRq.cza().cmY();
              if (paramb != null) {
                break label541;
              }
              paramb = "";
              localObject1 = paramh.sRq.cza().cmY();
              if (localObject1 != null) {
                break label559;
              }
              localObject1 = "";
              ((c)localObject3).a(true, paramb, (String)localObject1, paramh.hYb);
            }
          }
          for (;;)
          {
            paramh.hYb = -1;
            AppMethodBeat.o(327242);
            return;
            localObject1 = paramb.rih;
            paramb = (b)localObject1;
            if (localObject1 != null) {
              break;
            }
            paramb = "";
            break;
            localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rig;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label515;
            }
            localObject1 = "";
            break label515;
            if ((paramh.hYb == 5) || (paramh.hYb == 8))
            {
              paramb = paramh.sRV;
              if (paramb != null) {
                c.a.a(paramb, true, paramh.hYb);
              }
            }
            else if (paramh.hYb == 8)
            {
              paramb = paramh.sRV;
              if (paramb != null) {
                c.a.a(paramb, true, paramh.hYb);
              }
            }
          }
          paramh.sRq.cza().a(e.a.riC);
          a(paramh, e.a.riC);
          paramh.sRT.onVideoPause();
          paramh.eDp.jV(true);
          AppMethodBeat.o(327242);
          return;
          paramh.sRq.cza().a(e.a.riz);
          a(paramh, e.a.riz);
          paramh.sRT.onVideoEnded();
          paramh.eDp.jV(false);
          AppMethodBeat.o(327242);
          return;
        } while ((paramb.obj == null) || (!(paramb.obj instanceof Integer)));
        paramh = paramb.obj;
        if (paramh == null)
        {
          paramh = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(327242);
          throw paramh;
        }
        Log.i("MicroMsg.VideoCast.VideoCastController", s.X("Receive Action : Volume = ", Integer.valueOf(((Integer)paramh).intValue())));
        AppMethodBeat.o(327242);
        return;
      } while ((paramb.obj == null) || (!(paramb.obj instanceof Boolean)));
      paramh = paramb.obj;
      if (paramh == null)
      {
        paramh = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(327242);
        throw paramh;
      }
      Log.i("MicroMsg.VideoCast.VideoCastController", s.X("Receive Action : Mute = ", Boolean.valueOf(((Boolean)paramh).booleanValue())));
      AppMethodBeat.o(327242);
      return;
    } while (paramh.sRq.cza().cmZ() == e.a.riz);
    label293:
    label299:
    label353:
    paramh.sRT.cZ(false);
    label405:
    label411:
    label541:
    label559:
    a(paramh, e.a.riz);
    label515:
    paramh.sRq.czd();
    if ((paramb.obj != null) && ((paramb.obj instanceof Integer)))
    {
      paramb = paramb.obj;
      if (paramb == null)
      {
        paramh = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(327242);
        throw paramh;
      }
    }
    for (int i = ((Integer)paramb).intValue();; i = -1)
    {
      switch (i)
      {
      }
      for (;;)
      {
        paramh.sRq.cza().cnc();
        paramh.sRq.cza().cnd();
        paramh.sRq.cza().a(null);
        paramh.eDp.jV(false);
        paramh.sSc.stopTimer();
        paramh.sSe.stopTimer();
        paramh.sRZ.stopTimer();
        break;
        localObject3 = paramh.sRV;
        if (localObject3 != null)
        {
          paramb = paramh.sRq.cza().cmY();
          if (paramb == null)
          {
            paramb = "";
            label1109:
            localObject1 = paramh.sRq.cza().cmY();
            if (localObject1 != null) {
              break label1160;
            }
            localObject1 = "";
          }
          for (;;)
          {
            ((c)localObject3).a(false, paramb, (String)localObject1, i);
            break;
            localObject1 = paramb.rih;
            paramb = (b)localObject1;
            if (localObject1 != null) {
              break label1109;
            }
            paramb = "";
            break label1109;
            label1160:
            localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rig;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
          paramb = paramh.sRV;
          if (paramb != null) {
            c.a.a(paramb, false, i);
          }
        }
      }
    }
  }
  
  private static final void a(final h paramh, boolean paramBoolean1, final boolean paramBoolean2)
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(327232);
    s.u(paramh, "this$0");
    paramh.sRU = new g(paramh.getContext(), paramh.eDp, paramh.sRq, paramBoolean1, (byte)0);
    Object localObject1 = paramh.sRU;
    label99:
    Object localObject3;
    if (localObject1 == null)
    {
      s.bIx("selectDeviceBottomSheet");
      localObject1 = null;
      ((g)localObject1).sRF = ((kotlin.g.a.a)new n(paramh));
      localObject1 = paramh.sRU;
      if (localObject1 != null) {
        break label268;
      }
      s.bIx("selectDeviceBottomSheet");
      localObject1 = null;
      localObject3 = (kotlin.g.a.b)new o(paramBoolean1, paramh);
      s.u(localObject3, "<set-?>");
      ((g)localObject1).sRE = ((kotlin.g.a.b)localObject3);
      localObject1 = paramh.sRU;
      if (localObject1 != null) {
        break label271;
      }
      s.bIx("selectDeviceBottomSheet");
      localObject1 = null;
    }
    label268:
    label271:
    for (;;)
    {
      ((g)localObject1).sRC = ((m)new p(paramh, paramBoolean2));
      localObject1 = paramh.sRU;
      paramh = (h)localObject1;
      if (localObject1 == null)
      {
        s.bIx("selectDeviceBottomSheet");
        paramh = null;
      }
      paramh.sRw = paramh.isLandscape();
      paramh.sRx = paramh.getRotation();
      if (paramh.sRs == null) {
        break label1102;
      }
      localObject3 = paramh.rootView;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("rootView");
        localObject1 = null;
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 != null) {
        break label274;
      }
      paramh = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(327232);
      throw paramh;
      break;
      break label99;
    }
    label274:
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localObject1;
    if (paramh.sRA) {
      paramh.sRu = ((int)(bd.bs(paramh.mContext, a.d.bottomsheet_list_item_height) * 6.5D));
    }
    localLayoutParams.height = paramh.sRu;
    if ((paramh.sRw) && (paramh.mF != null))
    {
      localObject1 = new Rect();
      localObject3 = paramh.mF;
      s.checkNotNull(localObject3);
      ((View)localObject3).getWindowVisibleDisplayFrame((Rect)localObject1);
      if (!paramh.sRA) {
        break label852;
      }
      localLayoutParams.width = ((int)(((Rect)localObject1).right * 1.0F * 4.0F / 10.0F));
      if (paramh.sRB != 0) {
        localLayoutParams.width = paramh.sRB;
      }
      if (bf.nc(paramh.mContext)) {
        localLayoutParams.height = (((Rect)localObject1).bottom - bf.be(paramh.mContext));
      }
    }
    else
    {
      localObject3 = paramh.rootView;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("rootView");
        localObject1 = null;
      }
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject3 = paramh.sRs;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("mBottomSheetDialog");
          localObject1 = null;
        }
        localObject1 = ((Dialog)localObject1).getWindow();
        if (localObject1 != null) {
          ((Window)localObject1).addFlags(-2147483648);
        }
      }
      if (paramh.sRy)
      {
        localObject3 = paramh.sRs;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("mBottomSheetDialog");
          localObject1 = null;
        }
        localObject1 = ((Dialog)localObject1).getWindow();
        if (localObject1 != null) {
          ((Window)localObject1).addFlags(1024);
        }
      }
      if (!paramh.sRz) {
        break label875;
      }
      localObject3 = paramh.sRs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mBottomSheetDialog");
        localObject1 = null;
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 != null) {
        ((Window)localObject1).setFlags(8, 8);
      }
      localObject3 = paramh.sRs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mBottomSheetDialog");
        localObject1 = null;
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 != null) {
        ((Window)localObject1).addFlags(131200);
      }
      localObject3 = paramh.sRs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mBottomSheetDialog");
        localObject1 = null;
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 != null) {
        break label865;
      }
      localObject1 = null;
      label703:
      if (localObject1 != null) {
        ((View)localObject1).setSystemUiVisibility(6);
      }
    }
    label1067:
    for (;;)
    {
      if (paramh.sRv != null)
      {
        localObject1 = paramh.sRv;
        if (localObject1 != null) {
          ((BottomSheetBehavior)localObject1).dqC = false;
        }
      }
      if (paramh.mF != null)
      {
        if (paramh.mP == null) {
          i = 1;
        }
        localObject1 = paramh.mF;
        s.checkNotNull(localObject1);
        paramh.mP = ((View)localObject1).getViewTreeObserver();
        if (i != 0)
        {
          localObject1 = paramh.mP;
          s.checkNotNull(localObject1);
          ((ViewTreeObserver)localObject1).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)paramh);
        }
      }
      if (!(paramh.mContext instanceof Activity)) {
        break label1102;
      }
      localObject1 = paramh.mContext;
      if (localObject1 != null) {
        break label1069;
      }
      paramh = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(327232);
      throw paramh;
      localLayoutParams.height = ((Rect)localObject1).bottom;
      break;
      label852:
      localLayoutParams.width = ((Rect)localObject1).right;
      break;
      label865:
      localObject1 = ((Window)localObject1).getDecorView();
      break label703;
      label875:
      localObject3 = paramh.sRs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mBottomSheetDialog");
        localObject1 = null;
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 != null) {
        ((Window)localObject1).clearFlags(8);
      }
      localObject3 = paramh.sRs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mBottomSheetDialog");
        localObject1 = null;
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 != null) {
        ((Window)localObject1).clearFlags(131072);
      }
      localObject3 = paramh.sRs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mBottomSheetDialog");
        localObject1 = null;
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 != null) {
        ((Window)localObject1).clearFlags(128);
      }
      localObject3 = paramh.sRs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mBottomSheetDialog");
        localObject1 = null;
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((Window)localObject1).getDecorView())
      {
        if (localObject1 == null) {
          break label1067;
        }
        ((View)localObject1).setSystemUiVisibility(0);
        break;
      }
    }
    label1069:
    if (!((Activity)localObject1).isFinishing())
    {
      paramh = paramh.sRs;
      if (paramh != null) {
        break label1109;
      }
      s.bIx("mBottomSheetDialog");
      paramh = localObject2;
    }
    label1102:
    label1109:
    for (;;)
    {
      paramh.show();
      AppMethodBeat.o(327232);
      return;
    }
  }
  
  private final void cyX()
  {
    AppMethodBeat.i(139774);
    this.sRq.cza().cnc();
    this.sRq.cza().cnd();
    this.sRq.cza().a(null);
    AppMethodBeat.o(139774);
  }
  
  private static final boolean e(h paramh)
  {
    AppMethodBeat.i(327235);
    s.u(paramh, "this$0");
    if (paramh.sRY)
    {
      AppMethodBeat.o(327235);
      return false;
    }
    paramh.sRT.cZ(false);
    AppMethodBeat.o(327235);
    return true;
  }
  
  private static final boolean f(h paramh)
  {
    AppMethodBeat.i(327245);
    s.u(paramh, "this$0");
    paramh.sRq.cza().e((com.tencent.mm.plugin.appbrand.g.c.a.a)new e(paramh));
    AppMethodBeat.o(327245);
    return true;
  }
  
  private static final void g(h paramh)
  {
    AppMethodBeat.i(327248);
    s.u(paramh, "this$0");
    if (paramh.sRU != null)
    {
      g localg = paramh.sRU;
      paramh = localg;
      if (localg == null)
      {
        s.bIx("selectDeviceBottomSheet");
        paramh = null;
      }
      paramh.cyW();
    }
    AppMethodBeat.o(327248);
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(327202);
    Context localContext = this.sQs.getContext();
    s.s(localContext, "invokeContext.context");
    AppMethodBeat.o(327202);
    return localContext;
  }
  
  private static final boolean h(h paramh)
  {
    AppMethodBeat.i(327257);
    s.u(paramh, "this$0");
    paramh.sRq.cza().f((com.tencent.mm.plugin.appbrand.g.c.a.a)new g(paramh));
    AppMethodBeat.o(327257);
    return true;
  }
  
  public final void E(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(139768);
    MMHandlerThread.postToMainThread(new h..ExternalSyntheticLambda4(this, paramBoolean2, paramBoolean1));
    if (!paramBoolean2) {
      this.sRq.clear();
    }
    this.sRq.sSt = ((kotlin.g.a.a)new h.q(this));
    MMApplicationContext.getContext();
    Object localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
      if (localObject == null) {}
    }
    for (paramBoolean1 = ((NetworkInfo)localObject).isConnected();; paramBoolean1 = false)
    {
      if (!paramBoolean1)
      {
        Toast.makeText(getContext(), (CharSequence)com.tencent.mm.cd.a.bt(getContext(), a.e.app_brand_video_cast_search_fail_hint), 0).show();
        Log.w("MicroMsg.VideoCast.VideoCastController", "searchDevice: wifi is not connected");
      }
      localObject = this.sRq;
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "prepare");
      if (i.czc())
      {
        com.tencent.mm.plugin.appbrand.g.b.a.cmW().a((a.a)((i)localObject).sSx);
        ((i)localObject).czb();
        i.a((i)localObject);
      }
      AppMethodBeat.o(139768);
      return;
    }
  }
  
  public final void U(final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(184885);
    s.u(paramb, "action");
    this.sRq.cza().c((com.tencent.mm.plugin.appbrand.g.c.a.a)new u(this, paramb));
    AppMethodBeat.o(184885);
  }
  
  public final void V(kotlin.g.a.b<? super f<Integer>, ah> paramb)
  {
    AppMethodBeat.i(139777);
    s.u(paramb, "action");
    this.sRq.cza().d((com.tencent.mm.plugin.appbrand.g.c.a.a)new f(paramb, this));
    AppMethodBeat.o(139777);
  }
  
  public final void acK(String paramString)
  {
    AppMethodBeat.i(139772);
    s.u(paramString, "moment");
    this.sRq.cza().b(paramString, (com.tencent.mm.plugin.appbrand.g.c.a.a)new r(paramString, this));
    AppMethodBeat.o(139772);
  }
  
  public final void cyY()
  {
    AppMethodBeat.i(139778);
    if (this.sSe.stopped())
    {
      this.sSd = false;
      this.sSe.startTimer(5000L);
    }
    AppMethodBeat.o(139778);
  }
  
  public final void cyZ()
  {
    AppMethodBeat.i(139779);
    if (this.sSe.stopped())
    {
      AppMethodBeat.o(139779);
      return;
    }
    this.sSe.stopTimer();
    this.sSd = true;
    AppMethodBeat.o(139779);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(139775);
    Log.i("MicroMsg.VideoCast.VideoCastController", "onDestroy");
    MMHandlerThread.postToMainThread(new h..ExternalSyntheticLambda3(this));
    cyX();
    this.sSc.stopTimer();
    this.sRq.clear();
    cyZ();
    this.sRZ.stopTimer();
    AppMethodBeat.o(139775);
  }
  
  public final void fJ(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(139770);
    this.hYb = paramInt2;
    this.sRY = false;
    if (this.sRq.cza().cmZ() == e.a.riC)
    {
      Log.i("MicroMsg.VideoCast.VideoCastController", "play: continue");
      this.sRq.cza().a((com.tencent.mm.plugin.appbrand.g.c.a.a)new j(this, paramInt1, paramInt2));
      this.sRT.onVideoWaiting();
      AppMethodBeat.o(139770);
      return;
    }
    Log.i("MicroMsg.VideoCast.VideoCastController", "play: playNew");
    this.sRq.cza().c((com.tencent.mm.plugin.appbrand.g.c.a.a)new k(this, paramInt1, paramInt2));
    this.sRT.onVideoWaiting();
    AppMethodBeat.o(139770);
  }
  
  public final void setVolume(int paramInt)
  {
    AppMethodBeat.i(139776);
    Log.i("MicroMsg.VideoCast.VideoCastController", s.X("setVolume: ", Integer.valueOf(paramInt)));
    this.sRq.cza().a(paramInt, (com.tencent.mm.plugin.appbrand.g.c.a.a)new s(this));
    AppMethodBeat.o(139776);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$Event;", "", "eventType", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/EventType;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/EventType;)V", "obj", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/EventType;Ljava/lang/Object;)V", "getEventType$luggage_xweb_ext_release", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/EventType;", "setEventType$luggage_xweb_ext_release", "getObj$luggage_xweb_ext_release", "()Ljava/lang/Object;", "setObj$luggage_xweb_ext_release", "(Ljava/lang/Object;)V", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    Object obj;
    a sSf;
    
    public b(a parama)
    {
      AppMethodBeat.i(139712);
      this.sSf = parama;
      AppMethodBeat.o(139712);
    }
    
    public b(a parama, Object paramObject)
    {
      AppMethodBeat.i(139713);
      this.sSf = parama;
      this.obj = paramObject;
      AppMethodBeat.o(139713);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;)V", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class c
    implements com.tencent.mm.plugin.appbrand.g.c.a.a
  {
    public c()
    {
      AppMethodBeat.i(327231);
      AppMethodBeat.o(327231);
    }
    
    public void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame) {}
    
    public void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139714);
      s.u(parame, "response");
      AppMethodBeat.o(139714);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$getProgressTimeMs$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends h.c
  {
    e(h paramh)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139718);
      super.a(parame);
      if (parame == null) {}
      for (parame = "";; parame = Integer.valueOf(parame.responseCode))
      {
        Log.e("MicroMsg.VideoCast.VideoCastController", s.X("get position  fail", parame));
        parame = new h.b(a.sRl);
        this.sSg.sSc.stopTimer();
        h.b(this.sSg, parame);
        AppMethodBeat.o(139718);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139717);
      s.u(parame, "response");
      parame = parame.rjG;
      if ((parame == null) || (parame.isEmpty()))
      {
        AppMethodBeat.o(139717);
        return;
      }
      if ((parame.containsKey("RelTime")) && (parame.containsKey("TrackDuration")))
      {
        Object localObject1 = ((com.tencent.mm.plugin.appbrand.g.c.b.a)ak.e(parame, "RelTime")).value;
        parame = ((com.tencent.mm.plugin.appbrand.g.c.b.a)ak.e(parame, "TrackDuration")).value;
        Log.i("MicroMsg.VideoCast.VideoCastController", "getProgressTimeMs: relTime = " + localObject1 + ", duration =  " + parame);
        Object localObject2 = com.tencent.mm.plugin.appbrand.jsapi.al.e.b.sQr;
        int i = (int)b.a.acI((String)localObject1);
        localObject2 = com.tencent.mm.plugin.appbrand.jsapi.al.e.b.sQr;
        int j = (int)b.a.acI(parame);
        h.a(this.sSg, i);
        h.j(this.sSg).dh(i, j);
        h.j(this.sSg).mJ((int)(i / j * 100.0D));
        localObject2 = new StringBuilder("get position success, relTime: ");
        b.a locala = com.tencent.mm.plugin.appbrand.jsapi.al.e.b.sQr;
        localObject1 = ((StringBuilder)localObject2).append((int)b.a.acI((String)localObject1)).append(" duration: ");
        localObject2 = com.tencent.mm.plugin.appbrand.jsapi.al.e.b.sQr;
        Log.i("MicroMsg.VideoCast.VideoCastController", (int)b.a.acI(parame));
      }
      AppMethodBeat.o(139717);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$getVolume$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends h.c
  {
    f(kotlin.g.a.b<? super f<Integer>, ah> paramb, h paramh)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139720);
      super.a(parame);
      if (parame != null) {
        Log.e("MicroMsg.VideoCast.VideoCastController", s.X("get volume  fail", Integer.valueOf(parame.responseCode)));
      }
      AppMethodBeat.o(139720);
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      f localf = null;
      AppMethodBeat.i(139719);
      s.u(parame, "response");
      parame = parame.rjG;
      if (parame == null) {
        parame = localf;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)parame))
        {
          localf = new f();
          s.checkNotNull(parame);
          localf.value = Integer.valueOf(Integer.parseInt(parame));
          this.mUv.invoke(localf);
        }
        Log.i("MicroMsg.VideoCast.VideoCastController", s.X("get volume success : ", parame));
        AppMethodBeat.o(139719);
        return;
        com.tencent.mm.plugin.appbrand.g.c.b.a locala = (com.tencent.mm.plugin.appbrand.g.c.b.a)parame.get("CurrentVolume");
        parame = localf;
        if (locala != null) {
          parame = locala.value;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$interruptDetectorTimer$1$1", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.plugin.appbrand.g.c.a.a
  {
    g(h paramh) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139724);
      Log.i("MicroMsg.VideoCast.VideoCastController", "getMediaInfo fail");
      h.s(this.sSg);
      AppMethodBeat.o(139724);
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139723);
      if (h.r(this.sSg))
      {
        AppMethodBeat.o(139723);
        return;
      }
      if (parame == null) {
        parame = null;
      }
      for (;;)
      {
        parame = String.valueOf(parame);
        Log.i("MicroMsg.VideoCast.VideoCastController", s.X("getMediaInfo: currentUrl = ", parame));
        if (parame != null) {
          break;
        }
        parame = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(139723);
        throw parame;
        parame = parame.rjG;
        if (parame == null)
        {
          parame = null;
        }
        else
        {
          parame = (com.tencent.mm.plugin.appbrand.g.c.b.a)parame.get("CurrentURI");
          if (parame == null) {
            parame = null;
          } else {
            parame = parame.value;
          }
        }
      }
      if ((n.bp((CharSequence)n.bq((CharSequence)parame).toString())) || (s.p(parame, "null")))
      {
        AppMethodBeat.o(139723);
        return;
      }
      if (!s.p(parame, h.p(this.sSg).videoPath)) {
        h.j(this.sSg).auL();
      }
      AppMethodBeat.o(139723);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$pause$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends h.c
  {
    i(h paramh, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139729);
      super.a(parame);
      if (parame == null) {}
      for (parame = "";; parame = Integer.valueOf(parame.responseCode))
      {
        Log.e("MicroMsg.VideoCast.VideoCastController", s.X("pause fail", parame));
        this.mUv.invoke(Boolean.FALSE);
        AppMethodBeat.o(139729);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139728);
      s.u(parame, "response");
      Log.i("MicroMsg.VideoCast.VideoCastController", "pause success");
      h.k(this.sSg).cza().a(e.a.riC);
      this.mUv.invoke(Boolean.TRUE);
      AppMethodBeat.o(139728);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$play$playContinue$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends h.c
  {
    j(h paramh, int paramInt1, int paramInt2)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(327251);
      super.a(parame);
      Log.e("MicroMsg.VideoCast.VideoCastController", "play fail");
      parame = new h.b(a.sRl);
      parame.obj = Integer.valueOf(paramInt2);
      h.b(this.sSg, parame);
      AppMethodBeat.o(327251);
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(327244);
      s.u(parame, "response");
      Log.i("MicroMsg.VideoCast.VideoCastController", "play success, url = [%s]", new Object[] { h.p(this.sSg).videoPath });
      h.a(paramInt1, this.sSg);
      AppMethodBeat.o(327244);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$play$playNew$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends h.c
  {
    k(h paramh, int paramInt1, int paramInt2)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(327243);
      super.a(parame);
      if (parame == null) {}
      for (parame = "";; parame = Integer.valueOf(parame.responseCode))
      {
        Log.e("MicroMsg.VideoCast.VideoCastController", s.X("stop fail before play new", parame));
        AppMethodBeat.o(327243);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(327239);
      s.u(parame, "response");
      Log.i("MicroMsg.VideoCast.VideoCastController", "playNew: stop success");
      h.k(this.sSg).cza().a(e.a.riz);
      h.k(this.sSg).cza().a(h.p(this.sSg).videoPath, (com.tencent.mm.plugin.appbrand.g.c.a.a)new a(this.sSg, paramInt1, paramInt2));
      AppMethodBeat.o(327239);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$play$playNew$1$success$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends h.c
    {
      a(h paramh, int paramInt1, int paramInt2)
      {
        super();
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
      {
        AppMethodBeat.i(327193);
        super.a(parame);
        if (parame == null) {}
        for (parame = "";; parame = Integer.valueOf(parame.responseCode))
        {
          Log.e("MicroMsg.VideoCast.VideoCastController", s.X("set AVTransportURI fail", parame));
          parame = new h.b(a.sRl);
          parame.obj = Integer.valueOf(this.sSj);
          h.b(this.sSg, parame);
          AppMethodBeat.o(327193);
          return;
        }
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
      {
        AppMethodBeat.i(327190);
        s.u(parame, "response");
        Log.i("MicroMsg.VideoCast.VideoCastController", "playNew: setAvTransUrl success");
        h.k(this.sSg).cza().a(e.a.riA);
        h.k(this.sSg).cza().a((com.tencent.mm.plugin.appbrand.g.c.a.a)new a(this.sSg, this.sSi, this.sSj));
        AppMethodBeat.o(327190);
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$play$playNew$1$success$1$success$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        extends h.c
      {
        a(h paramh, int paramInt1, int paramInt2)
        {
          super();
        }
        
        public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
        {
          AppMethodBeat.i(327234);
          super.a(parame);
          if (parame == null) {}
          for (parame = "";; parame = Integer.valueOf(parame.responseCode))
          {
            Log.e("MicroMsg.VideoCast.VideoCastController", s.X("play new fail", parame));
            parame = new h.b(a.sRl);
            parame.obj = Integer.valueOf(this.sSj);
            h.b(this.sSg, parame);
            AppMethodBeat.o(327234);
            return;
          }
        }
        
        public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
        {
          AppMethodBeat.i(327230);
          s.u(parame, "response");
          Log.i("MicroMsg.VideoCast.VideoCastController", "play new success");
          h.k(this.sSg).cza().a((d)h.q(this.sSg));
          h.k(this.sSg).cza().a(e.a.riB);
          h.k(this.sSg).cza().cna();
          h.k(this.sSg).cza().cnb();
          h.a(this.sSi, this.sSg);
          AppMethodBeat.o(327230);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<ah>
  {
    l(h paramh, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<ah>
  {
    n(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "devicesCount", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    o(boolean paramBoolean, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements m<com.tencent.mm.plugin.appbrand.g.b.c, Integer, ah>
  {
    p(h paramh, boolean paramBoolean)
    {
      super();
    }
    
    private static final void t(h paramh)
    {
      AppMethodBeat.i(327246);
      s.u(paramh, "this$0");
      g localg = h.i(paramh);
      paramh = localg;
      if (localg == null)
      {
        s.bIx("selectDeviceBottomSheet");
        paramh = null;
      }
      paramh.cyW();
      AppMethodBeat.o(327246);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$seek$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class r
    extends h.c
  {
    r(String paramString, h paramh)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139756);
      super.a(parame);
      Log.i("MicroMsg.VideoCast.VideoCastController", "seek fail");
      AppMethodBeat.o(139756);
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139755);
      s.u(parame, "response");
      Log.i("MicroMsg.VideoCast.VideoCastController", "seek to " + this.sSm + " success");
      AppMethodBeat.o(139755);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$setVolume$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    extends h.c
  {
    s(h paramh)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139759);
      super.a(parame);
      if (parame != null)
      {
        Log.e("MicroMsg.VideoCast.VideoCastController", s.X("setVolume fail:", Integer.valueOf(parame.responseCode)));
        Log.e("MicroMsg.VideoCast.VideoCastController", s.X("setVolume fail:", Integer.valueOf(parame.responseCode)));
      }
      AppMethodBeat.o(139759);
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(139758);
      s.u(parame, "response");
      Log.i("MicroMsg.VideoCast.VideoCastController", "setVolume success");
      AppMethodBeat.o(139758);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$stop$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class u
    extends h.c
  {
    u(h paramh, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(184884);
      super.a(parame);
      if (parame == null) {}
      for (parame = "";; parame = Integer.valueOf(parame.responseCode))
      {
        Log.e("MicroMsg.VideoCast.VideoCastController", s.X("stop fail", parame));
        paramb.invoke(Boolean.FALSE);
        AppMethodBeat.o(184884);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(184883);
      s.u(parame, "response");
      Log.i("MicroMsg.VideoCast.VideoCastController", "stop success");
      h.k(this.sSg).cza().a(e.a.riz);
      h.l(this.sSg);
      this.sSg.sSc.stopTimer();
      paramb.invoke(Boolean.TRUE);
      AppMethodBeat.o(184883);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$subEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MREventListener;", "onMute", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "mute", "", "onPause", "onPlay", "onProgress", "progress", "", "onStop", "onVolume", "vol", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class v
    implements d
  {
    v(h paramh) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc, int paramInt)
    {
      AppMethodBeat.i(139765);
      s.u(paramc, "device");
      if (s.p(paramc, h.k(this.sSg).cza())) {
        h.b(this.sSg, new h.b(a.sRi, Integer.valueOf(paramInt)));
      }
      AppMethodBeat.o(139765);
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc, boolean paramBoolean)
    {
      AppMethodBeat.i(139766);
      s.u(paramc, "device");
      if (s.p(paramc, h.k(this.sSg).cza())) {
        h.b(this.sSg, new h.b(a.sRj, Boolean.valueOf(paramBoolean)));
      }
      AppMethodBeat.o(139766);
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.b.c paramc, int paramInt)
    {
      AppMethodBeat.i(139767);
      s.u(paramc, "device");
      if (s.p(paramc, h.k(this.sSg).cza())) {
        h.b(this.sSg, new h.b(a.sRk, Integer.valueOf(paramInt)));
      }
      AppMethodBeat.o(139767);
    }
    
    public final void d(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139762);
      s.u(paramc, "device");
      if (s.p(paramc, h.k(this.sSg).cza())) {
        h.b(this.sSg, new h.b(a.sRf));
      }
      AppMethodBeat.o(139762);
    }
    
    public final void e(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139763);
      s.u(paramc, "device");
      if (s.p(paramc, h.k(this.sSg).cza())) {
        h.b(this.sSg, new h.b(a.sRg));
      }
      AppMethodBeat.o(139763);
    }
    
    public final void f(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139764);
      s.u(paramc, "device");
      if (s.p(paramc, h.k(this.sSg).cza())) {
        h.b(this.sSg, new h.b(a.sRh));
      }
      AppMethodBeat.o(139764);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.a.h
 * JD-Core Version:    0.7.0.1
 */