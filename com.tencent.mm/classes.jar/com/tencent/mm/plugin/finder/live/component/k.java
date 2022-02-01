package com.tencent.mm.plugin.finder.live.component;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.plugin.appbrand.g.b.a.a;
import com.tencent.mm.plugin.appbrand.g.b.d;
import com.tencent.mm.plugin.appbrand.g.b.e.a;
import com.tencent.mm.plugin.appbrand.g.c.b.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.n;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.sdk.platformtools.InetUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "ACTION_ERROR", "", "ACTION_FINISH", "ACTION_MUTE", "ACTION_PAUSED", "ACTION_PLAYING", "ACTION_PROGRESS", "ACTION_STOPPED", "ACTION_VOLUME", "SEARCH_TIMES", "TAG", "", "deviceSearchTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "msgHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "selectedDevice", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "subEventListener", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MREventListener;", "times", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$ViewCallback;", "breakDevice", "", "cleanUp", "onAddDevice", "device", "onAttach", "callback", "onDetach", "onRemoveDevice", "onUpdateDevice", "playNew", "videoUrl", "prepare", "search", "selectDevice", "mrDevice", "stop", "plugin-finder_release"})
public final class k
  implements a.a, j.a
{
  private final int ACTION_FINISH;
  final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  int mgw;
  final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  final int xZA;
  j.b xZB;
  MMHandler xZC;
  com.tencent.mm.plugin.appbrand.g.b.c xZD;
  final d xZE;
  final MTimerHandler xZF;
  private final int xZu;
  private final int xZv;
  private final int xZw;
  private final int xZx;
  private final int xZy;
  final int xZz;
  
  public k(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.c.b paramb)
  {
    AppMethodBeat.i(284083);
    this.xYp = parama;
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveCastScreenPresenter";
    this.xZu = 1;
    this.xZv = 2;
    this.ACTION_FINISH = 3;
    this.xZw = 4;
    this.xZx = 5;
    this.xZy = 6;
    this.xZz = 7;
    this.xZA = 10;
    this.xZC = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new b(this));
    this.xZE = ((d)new e(this));
    this.xZF = new MTimerHandler("finder_live_device_search", (MTimerHandler.CallBack)new a(this), true);
    AppMethodBeat.o(284083);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc)
  {
    AppMethodBeat.i(284077);
    Log.i(this.TAG, "onAddDevice ".concat(String.valueOf(paramc)));
    j.b localb = this.xZB;
    if (localb != null)
    {
      localb.a(paramc);
      AppMethodBeat.o(284077);
      return;
    }
    AppMethodBeat.o(284077);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.g.b.c paramc)
  {
    AppMethodBeat.i(284079);
    Log.i(this.TAG, "onRemoveDevice ".concat(String.valueOf(paramc)));
    j.b localb = this.xZB;
    if (localb != null)
    {
      localb.b(paramc);
      AppMethodBeat.o(284079);
      return;
    }
    AppMethodBeat.o(284079);
  }
  
  public final void bYL()
  {
    AppMethodBeat.i(284070);
    this.xZF.stopTimer();
    this.xZF.startTimer(0L, 3000L);
    AppMethodBeat.o(284070);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.g.b.c paramc)
  {
    AppMethodBeat.i(284081);
    Log.i(this.TAG, "onUpdateDevice ".concat(String.valueOf(paramc)));
    j.b localb = this.xZB;
    if (localb != null)
    {
      localb.c(paramc);
      AppMethodBeat.o(284081);
      return;
    }
    AppMethodBeat.o(284081);
  }
  
  public final void chi()
  {
    AppMethodBeat.i(284069);
    Log.i(this.TAG, "cleanUp");
    try
    {
      this.xZF.stopTimer();
      com.tencent.mm.plugin.appbrand.g.b.a locala = com.tencent.mm.plugin.appbrand.g.b.a.bMG();
      locala.bMI();
      p.j(locala, "deviceManager");
      Iterator localIterator = locala.bMH().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)localIterator.next();
        localc.bMN();
        localc.bMO();
        localc.a(null);
      }
      localException.b((a.a)this);
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "Error happen while cleaning up " + localException.getMessage());
      AppMethodBeat.o(284069);
      return;
    }
    localException.destroy();
    try
    {
      com.tencent.mm.plugin.appbrand.g.c.h.bMX().bMS();
      label133:
      com.tencent.mm.plugin.appbrand.g.c.c.bMR().bMS();
      AppMethodBeat.o(284069);
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala1)
    {
      break label133;
    }
  }
  
  public final void dxn()
  {
    AppMethodBeat.i(284072);
    Log.i(this.TAG, "breakDevice: " + this.xZD);
    if (this.xZD != null)
    {
      com.tencent.mm.plugin.appbrand.g.b.c localc = this.xZD;
      if (localc != null)
      {
        localc.c((com.tencent.mm.plugin.appbrand.g.c.a.a)new d(this));
        AppMethodBeat.o(284072);
        return;
      }
    }
    AppMethodBeat.o(284072);
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.g.b.c paramc)
  {
    AppMethodBeat.i(284071);
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvS;
    if (localObject != null)
    {
      localObject = ((g)localObject).kjd;
      if (localObject != null)
      {
        localObject = ((f)localObject).kmo;
        if (localObject != null)
        {
          localObject = ((crv)localObject).Tzg;
          CharSequence localCharSequence = (CharSequence)localObject;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label99;
          }
        }
      }
    }
    label99:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label104;
      }
      Log.i(this.TAG, "hlsUrl is nullOrNil!!, return");
      AppMethodBeat.o(284071);
      return;
      localObject = null;
      break;
    }
    label104:
    this.xZD = paramc;
    paramc = this.xZD;
    if (paramc != null) {
      paramc.c((com.tencent.mm.plugin.appbrand.g.c.a.a)new c(this, (String)localObject));
    }
    Log.i(this.TAG, "selectDevice: " + this.xZD);
    AppMethodBeat.o(284071);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(284076);
    Log.i(this.TAG, "onDetach");
    chi();
    this.xZB = null;
    AppMethodBeat.o(284076);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(284068);
    Log.i(this.TAG, "prepare");
    try
    {
      com.tencent.mm.plugin.appbrand.g.c.h.bMX().bFu();
      com.tencent.mm.plugin.appbrand.g.c.c.bMR().bFu();
      com.tencent.mm.plugin.appbrand.g.b.a.bMG().a((a.a)this);
      AppMethodBeat.o(284068);
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala)
    {
      Log.w(this.TAG, "RouterException: " + locala.getMessage());
      AppMethodBeat.o(284068);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    a(k paramk) {}
    
    public final boolean onTimerExpired()
    {
      boolean bool2 = false;
      AppMethodBeat.i(292186);
      Log.i(this.xZG.TAG, "search device times:" + this.xZG.mgw);
      if (this.xZG.mgw >= this.xZG.xZA)
      {
        this.xZG.mgw = 0;
        localObject = this.xZG.xZB;
        if (localObject != null) {
          ((j.b)localObject).dxr();
        }
        AppMethodBeat.o(292186);
        return false;
      }
      Object localObject = this.xZG;
      ((k)localObject).mgw += 1;
      localObject = com.tencent.luggage.k.h.SH();
      MMApplicationContext.getContext();
      String str = com.tencent.luggage.k.h.SG();
      com.tencent.mm.plugin.appbrand.g.c.h localh = com.tencent.mm.plugin.appbrand.g.c.h.bMX();
      boolean bool1 = bool2;
      if (InetUtil.isIPv6Address((String)localObject))
      {
        bool1 = bool2;
        if (InetUtil.isIPv6Address(str)) {
          bool1 = true;
        }
      }
      localh.hQ(bool1);
      AppMethodBeat.o(292186);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    b(k paramk) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(283809);
      if (paramMessage.what == this.xZG.xZz)
      {
        Object localObject = this.xZG.xZD;
        if (localObject != null) {
          ((com.tencent.mm.plugin.appbrand.g.b.c)localObject).a(e.a.oeU);
        }
        localObject = this.xZG.xZD;
        if (localObject != null) {
          ((com.tencent.mm.plugin.appbrand.g.b.c)localObject).bMN();
        }
        localObject = this.xZG.xZD;
        if (localObject != null) {
          ((com.tencent.mm.plugin.appbrand.g.b.c)localObject).bMO();
        }
        localObject = this.xZG.xZD;
        if (localObject != null) {
          ((com.tencent.mm.plugin.appbrand.g.b.c)localObject).a(null);
        }
        localObject = this.xZG.xZB;
        if (localObject != null) {
          ((j.b)localObject).Nc(paramMessage.arg1);
        }
      }
      AppMethodBeat.o(283809);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter$playNew$1", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.appbrand.g.c.a.a
  {
    c(String paramString) {}
    
    public final void a(e parame)
    {
      AppMethodBeat.i(224400);
      String str = this.xZG.TAG;
      StringBuilder localStringBuilder = new StringBuilder("stop fail before play new ");
      Object localObject;
      if (parame != null)
      {
        localObject = Integer.valueOf(parame.bpg);
        Log.e(str, localObject);
        localObject = this.xZG.xZC.obtainMessage(this.xZG.xZz);
        if (parame == null) {
          break label98;
        }
      }
      label98:
      for (int i = parame.bpg;; i = 0)
      {
        ((Message)localObject).arg1 = i;
        ((Message)localObject).sendToTarget();
        AppMethodBeat.o(224400);
        return;
        localObject = null;
        break;
      }
    }
    
    public final void b(e parame)
    {
      AppMethodBeat.i(224399);
      parame = this.xZG.xZD;
      if (parame != null) {
        parame.a(e.a.oeU);
      }
      parame = this.xZG.xZD;
      if (parame != null)
      {
        parame.a(this.xZH, (com.tencent.mm.plugin.appbrand.g.c.a.a)new a(this));
        AppMethodBeat.o(224399);
        return;
      }
      AppMethodBeat.o(224399);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter$playNew$1$success$1", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.appbrand.g.c.a.a
    {
      public final void a(e parame)
      {
        AppMethodBeat.i(285923);
        String str = this.xZI.xZG.TAG;
        StringBuilder localStringBuilder = new StringBuilder("set AVTransportURI fail ");
        Object localObject;
        if (parame != null)
        {
          localObject = Integer.valueOf(parame.bpg);
          Log.e(str, localObject);
          localObject = this.xZI.xZG.xZC.obtainMessage(this.xZI.xZG.xZz);
          if (parame == null) {
            break label107;
          }
        }
        label107:
        for (int i = parame.bpg;; i = 0)
        {
          ((Message)localObject).arg1 = i;
          ((Message)localObject).sendToTarget();
          AppMethodBeat.o(285923);
          return;
          localObject = null;
          break;
        }
      }
      
      public final void b(e parame)
      {
        AppMethodBeat.i(285921);
        parame = this.xZI.xZG.xZD;
        if (parame != null) {
          parame.a(e.a.oeV);
        }
        parame = this.xZI.xZG.xZB;
        if (parame != null) {
          parame.j(this.xZI.xZG.xZD);
        }
        parame = this.xZI.xZG.xZD;
        if (parame != null)
        {
          parame.a((com.tencent.mm.plugin.appbrand.g.c.a.a)new a(this));
          AppMethodBeat.o(285921);
          return;
        }
        AppMethodBeat.o(285921);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter$playNew$1$success$1$success$1", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "plugin-finder_release"})
      public static final class a
        implements com.tencent.mm.plugin.appbrand.g.c.a.a
      {
        public final void a(e parame)
        {
          AppMethodBeat.i(273597);
          String str = this.xZJ.xZI.xZG.TAG;
          StringBuilder localStringBuilder = new StringBuilder("play new fail ");
          Object localObject;
          if (parame != null)
          {
            localObject = Integer.valueOf(parame.bpg);
            Log.e(str, localObject);
            localObject = this.xZJ.xZI.xZG.xZC.obtainMessage(this.xZJ.xZI.xZG.xZz);
            if (parame == null) {
              break label116;
            }
          }
          label116:
          for (int i = parame.bpg;; i = 0)
          {
            ((Message)localObject).arg1 = i;
            ((Message)localObject).sendToTarget();
            AppMethodBeat.o(273597);
            return;
            localObject = null;
            break;
          }
        }
        
        public final void b(e parame)
        {
          Object localObject2 = null;
          AppMethodBeat.i(273596);
          Log.d(this.xZJ.xZI.xZG.TAG, "play new success");
          parame = this.xZJ.xZI.xZG.xZD;
          if (parame != null) {
            parame.a(e.a.oeW);
          }
          parame = this.xZJ.xZI.xZG.xZD;
          if (parame != null) {
            parame.bML();
          }
          parame = this.xZJ.xZI.xZG.xZD;
          if (parame != null) {
            parame.bMM();
          }
          parame = this.xZJ.xZI.xZG.xZD;
          if (parame != null) {
            parame.a(this.xZJ.xZI.xZG.xZE);
          }
          com.tencent.mm.plugin.finder.live.viewmodel.data.business.b localb = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xZJ.xZI.xZG.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          parame = this.xZJ.xZI.xZG.xZD;
          if (parame != null)
          {
            parame = parame.bMJ();
            if (parame == null) {}
          }
          for (parame = parame.oeA;; parame = null)
          {
            Object localObject3 = this.xZJ.xZI.xZG.xZD;
            Object localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject3).bMJ();
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject3).oeD;
              }
            }
            localb.zgi = new n(parame, (String)localObject1);
            parame = this.xZJ.xZI.xZG.xZB;
            if (parame != null) {
              parame.i(this.xZJ.xZI.xZG.xZD);
            }
            this.xZJ.xZI.xZG.xZF.stopTimer();
            AppMethodBeat.o(273596);
            return;
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter$stop$1", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.appbrand.g.c.a.a
  {
    public final void a(e parame)
    {
      AppMethodBeat.i(268573);
      String str = this.xZG.TAG;
      StringBuilder localStringBuilder = new StringBuilder("stop fail ");
      if (parame != null) {}
      for (parame = Integer.valueOf(parame.bpg);; parame = null)
      {
        Log.e(str, parame);
        AppMethodBeat.o(268573);
        return;
      }
    }
    
    public final void b(e parame)
    {
      AppMethodBeat.i(268572);
      Log.d(this.xZG.TAG, "stop success");
      parame = this.xZG.xZD;
      if (parame != null) {
        parame.a(e.a.oeU);
      }
      parame = this.xZG.xZD;
      if (parame != null) {
        parame.bMN();
      }
      parame = this.xZG.xZD;
      if (parame != null) {
        parame.bMO();
      }
      parame = this.xZG.xZD;
      if (parame != null) {
        parame.a(null);
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xZG.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgi = null;
      parame = this.xZG.xZB;
      if (parame != null) {
        parame.k(this.xZG.xZD);
      }
      this.xZG.xZD = null;
      AppMethodBeat.o(268572);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter$subEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MREventListener;", "onMute", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "mute", "", "onPause", "onPlay", "onProgress", "progress", "", "onStop", "onVolume", "vol", "plugin-finder_release"})
  public static final class e
    implements d
  {
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(291546);
      String str = this.xZG.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onVolume vol:").append(paramInt).append(" device[");
      Object localObject1 = paramc.bMJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeA;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
        localObject1 = paramc.bMJ();
        if (localObject1 == null) {
          break label210;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeD;
        label78:
        localStringBuilder = localStringBuilder.append((String)localObject1).append("] selectedDevice[");
        localObject1 = this.xZG.xZD;
        if (localObject1 == null) {
          break label215;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).bMJ();
        if (localObject1 == null) {
          break label215;
        }
      }
      label210:
      label215:
      for (localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeA;; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
        Object localObject3 = this.xZG.xZD;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject3).bMJ();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject3).oeD;
          }
        }
        Log.i(str, (String)localObject1 + ']');
        p.h(paramc, this.xZG.xZD);
        AppMethodBeat.o(291546);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label78;
      }
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc, boolean paramBoolean)
    {
      Object localObject2 = null;
      AppMethodBeat.i(291547);
      String str = this.xZG.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onMute mute:").append(paramBoolean).append(" device[");
      Object localObject1 = paramc.bMJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeA;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
        localObject1 = paramc.bMJ();
        if (localObject1 == null) {
          break label210;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeD;
        label78:
        localStringBuilder = localStringBuilder.append((String)localObject1).append("] selectedDevice[");
        localObject1 = this.xZG.xZD;
        if (localObject1 == null) {
          break label215;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).bMJ();
        if (localObject1 == null) {
          break label215;
        }
      }
      label210:
      label215:
      for (localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeA;; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
        Object localObject3 = this.xZG.xZD;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject3).bMJ();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject3).oeD;
          }
        }
        Log.i(str, (String)localObject1 + ']');
        p.h(paramc, this.xZG.xZD);
        AppMethodBeat.o(291547);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label78;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.b.c paramc, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(291549);
      String str = this.xZG.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onProgress progress:").append(paramInt).append(" device[");
      Object localObject1 = paramc.bMJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeA;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
        localObject1 = paramc.bMJ();
        if (localObject1 == null) {
          break label210;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeD;
        label78:
        localStringBuilder = localStringBuilder.append((String)localObject1).append("] selectedDevice[");
        localObject1 = this.xZG.xZD;
        if (localObject1 == null) {
          break label215;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).bMJ();
        if (localObject1 == null) {
          break label215;
        }
      }
      label210:
      label215:
      for (localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeA;; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
        Object localObject3 = this.xZG.xZD;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject3).bMJ();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject3).oeD;
          }
        }
        Log.i(str, (String)localObject1 + ']');
        p.h(paramc, this.xZG.xZD);
        AppMethodBeat.o(291549);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label78;
      }
    }
    
    public final void d(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      Object localObject2 = null;
      AppMethodBeat.i(291543);
      String str = this.xZG.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onPlay device[");
      Object localObject1 = paramc.bMJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeA;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
        localObject1 = paramc.bMJ();
        if (localObject1 == null) {
          break label198;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeD;
        label68:
        localStringBuilder = localStringBuilder.append((String)localObject1).append("] selectedDevice[");
        localObject1 = this.xZG.xZD;
        if (localObject1 == null) {
          break label203;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).bMJ();
        if (localObject1 == null) {
          break label203;
        }
      }
      label198:
      label203:
      for (localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeA;; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
        Object localObject3 = this.xZG.xZD;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject3).bMJ();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject3).oeD;
          }
        }
        Log.i(str, (String)localObject1 + ']');
        p.h(paramc, this.xZG.xZD);
        AppMethodBeat.o(291543);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label68;
      }
    }
    
    public final void e(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      Object localObject2 = null;
      AppMethodBeat.i(291544);
      String str = this.xZG.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onPause device[");
      Object localObject1 = paramc.bMJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeA;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
        localObject1 = paramc.bMJ();
        if (localObject1 == null) {
          break label198;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeD;
        label68:
        localStringBuilder = localStringBuilder.append((String)localObject1).append("] selectedDevice[");
        localObject1 = this.xZG.xZD;
        if (localObject1 == null) {
          break label203;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).bMJ();
        if (localObject1 == null) {
          break label203;
        }
      }
      label198:
      label203:
      for (localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeA;; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
        Object localObject3 = this.xZG.xZD;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject3).bMJ();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject3).oeD;
          }
        }
        Log.i(str, (String)localObject1 + ']');
        p.h(paramc, this.xZG.xZD);
        AppMethodBeat.o(291544);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label68;
      }
    }
    
    public final void f(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(291545);
      String str = this.xZG.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onStop device[");
      Object localObject = paramc.bMJ();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject).oeA;
        localStringBuilder = localStringBuilder.append((String)localObject).append(',');
        localObject = paramc.bMJ();
        if (localObject == null) {
          break label257;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject).oeD;
        label65:
        localStringBuilder = localStringBuilder.append((String)localObject).append("] selectedDevice[");
        localObject = this.xZG.xZD;
        if (localObject == null) {
          break label262;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject).bMJ();
        if (localObject == null) {
          break label262;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject).oeA;
        label104:
        localStringBuilder = localStringBuilder.append((String)localObject).append(',');
        localObject = this.xZG.xZD;
        if (localObject == null) {
          break label267;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject).bMJ();
        if (localObject == null) {
          break label267;
        }
      }
      label257:
      label262:
      label267:
      for (localObject = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject).oeD;; localObject = null)
      {
        Log.i(str, (String)localObject + ']');
        if (p.h(paramc, this.xZG.xZD))
        {
          paramc = this.xZG.xZD;
          if (paramc != null) {
            paramc.a(e.a.oeU);
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xZG.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgi = null;
          paramc = this.xZG.xZB;
          if (paramc != null) {
            paramc.k(this.xZG.xZD);
          }
          this.xZG.xZD = null;
        }
        AppMethodBeat.o(291545);
        return;
        localObject = null;
        break;
        localObject = null;
        break label65;
        localObject = null;
        break label104;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.k
 * JD-Core Version:    0.7.0.1
 */