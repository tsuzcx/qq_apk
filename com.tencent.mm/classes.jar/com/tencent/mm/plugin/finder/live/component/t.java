package com.tencent.mm.plugin.finder.live.component;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.plugin.appbrand.g.b.a.a;
import com.tencent.mm.plugin.appbrand.g.b.d;
import com.tencent.mm.plugin.appbrand.g.b.e.a;
import com.tencent.mm.plugin.appbrand.g.c.c.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.o;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.sdk.platformtools.InetUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "ACTION_ERROR", "", "ACTION_FINISH", "ACTION_MUTE", "ACTION_PAUSED", "ACTION_PLAYING", "ACTION_PROGRESS", "ACTION_STOPPED", "ACTION_VOLUME", "SEARCH_TIMES", "TAG", "", "deviceSearchTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "msgHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "selectedDevice", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "subEventListener", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MREventListener;", "times", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$ViewCallback;", "breakDevice", "", "cleanUp", "onAddDevice", "device", "onAttach", "callback", "onDetach", "onRemoveDevice", "onUpdateDevice", "playNew", "videoUrl", "prepare", "search", "selectDevice", "mrDevice", "stop", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  implements a.a, s.a
{
  private final int ACTION_FINISH;
  final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final int CxB;
  private final int CxC;
  private final int CxD;
  private final int CxE;
  private final int CxF;
  final int CxG;
  private final int CxH;
  s.b CxI;
  MMHandler CxJ;
  com.tencent.mm.plugin.appbrand.g.b.c CxK;
  final d CxL;
  final MTimerHandler CxM;
  final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private int oZt;
  
  public t(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(352879);
    this.CvU = parama;
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveCastScreenPresenter";
    this.CxB = 1;
    this.CxC = 2;
    this.ACTION_FINISH = 3;
    this.CxD = 4;
    this.CxE = 5;
    this.CxF = 6;
    this.CxG = 7;
    this.CxH = 10;
    this.CxJ = new MMHandler(Looper.getMainLooper(), new t..ExternalSyntheticLambda0(this));
    this.CxL = ((d)new c(this));
    this.CxM = new MTimerHandler("finder_live_device_search", new t..ExternalSyntheticLambda1(this), true);
    AppMethodBeat.o(352879);
  }
  
  private static final boolean a(t paramt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(352904);
    s.u(paramt, "this$0");
    Log.i(paramt.TAG, s.X("search device times:", Integer.valueOf(paramt.oZt)));
    if (paramt.oZt >= paramt.CxH)
    {
      paramt.oZt = 0;
      paramt = paramt.CxI;
      if (paramt != null) {
        paramt.ehY();
      }
      AppMethodBeat.o(352904);
      return false;
    }
    paramt.oZt += 1;
    paramt = com.tencent.luggage.l.h.atl();
    MMApplicationContext.getContext();
    String str = com.tencent.luggage.l.h.atk();
    com.tencent.mm.plugin.appbrand.g.c.h localh = com.tencent.mm.plugin.appbrand.g.c.h.cnm();
    boolean bool1 = bool2;
    if (InetUtil.isIPv6Address(paramt))
    {
      bool1 = bool2;
      if (InetUtil.isIPv6Address(str)) {
        bool1 = true;
      }
    }
    localh.iP(bool1);
    AppMethodBeat.o(352904);
    return true;
  }
  
  private static final boolean a(t paramt, Message paramMessage)
  {
    AppMethodBeat.i(352892);
    s.u(paramt, "this$0");
    s.u(paramMessage, "it");
    if (paramMessage.what == paramt.CxG)
    {
      com.tencent.mm.plugin.appbrand.g.b.c localc = paramt.CxK;
      if (localc != null) {
        localc.a(e.a.riz);
      }
      localc = paramt.CxK;
      if (localc != null) {
        localc.cnc();
      }
      localc = paramt.CxK;
      if (localc != null) {
        localc.cnd();
      }
      localc = paramt.CxK;
      if (localc != null) {
        localc.a(null);
      }
      paramt = paramt.CxI;
      if (paramt != null) {
        paramt.OD(paramMessage.arg1);
      }
    }
    AppMethodBeat.o(352892);
    return true;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc)
  {
    AppMethodBeat.i(352998);
    Log.i(this.TAG, s.X("onAddDevice ", paramc));
    s.b localb = this.CxI;
    if (localb != null) {
      localb.a(paramc);
    }
    AppMethodBeat.o(352998);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.g.b.c paramc)
  {
    AppMethodBeat.i(353007);
    Log.i(this.TAG, s.X("onRemoveDevice ", paramc));
    s.b localb = this.CxI;
    if (localb != null) {
      localb.b(paramc);
    }
    AppMethodBeat.o(353007);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.g.b.c paramc)
  {
    AppMethodBeat.i(353013);
    Log.i(this.TAG, s.X("onUpdateDevice ", paramc));
    s.b localb = this.CxI;
    if (localb != null) {
      localb.c(paramc);
    }
    AppMethodBeat.o(353013);
  }
  
  public final void cIf()
  {
    AppMethodBeat.i(352944);
    Log.i(this.TAG, "cleanUp");
    try
    {
      this.CxM.stopTimer();
      com.tencent.mm.plugin.appbrand.g.b.a locala = com.tencent.mm.plugin.appbrand.g.b.a.cmW();
      locala.rib = true;
      Iterator localIterator = locala.cmX().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)localIterator.next();
        localc.cnc();
        localc.cnd();
        localc.a(null);
      }
      localException.b((a.a)this);
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, s.X("Error happen while cleaning up ", localException.getMessage()));
      AppMethodBeat.o(352944);
      return;
    }
    localException.destroy();
    try
    {
      com.tencent.mm.plugin.appbrand.g.c.h.cnm().cng();
      label121:
      c.b.cnh().cng();
      AppMethodBeat.o(352944);
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala1)
    {
      break label121;
    }
  }
  
  public final void czb()
  {
    AppMethodBeat.i(352955);
    this.CxM.stopTimer();
    this.CxM.startTimer(0L, 3000L);
    AppMethodBeat.o(352955);
  }
  
  public final void ehU()
  {
    AppMethodBeat.i(352979);
    Log.i(this.TAG, s.X("breakDevice: ", this.CxK));
    if (this.CxK != null)
    {
      com.tencent.mm.plugin.appbrand.g.b.c localc = this.CxK;
      if (localc != null) {
        localc.c((com.tencent.mm.plugin.appbrand.g.c.a.a)new b(this));
      }
    }
    AppMethodBeat.o(352979);
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g.b.c paramc)
  {
    CharSequence localCharSequence = null;
    AppMethodBeat.i(352971);
    Object localObject1 = ((f)this.CvU.business(f.class)).mZu;
    if (localObject1 == null)
    {
      localObject1 = localCharSequence;
      localCharSequence = (CharSequence)localObject1;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label115;
      }
    }
    label115:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label120;
      }
      Log.i(this.TAG, "hlsUrl is nullOrNil!!, return");
      AppMethodBeat.o(352971);
      return;
      Object localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject1).mJH;
      localObject1 = localCharSequence;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((g)localObject2).mNv;
      localObject1 = localCharSequence;
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((diw)localObject2).aaNV;
      break;
    }
    label120:
    this.CxK = paramc;
    paramc = this.CxK;
    if (paramc != null) {
      paramc.c((com.tencent.mm.plugin.appbrand.g.c.a.a)new a(this, (String)localObject1));
    }
    Log.i(this.TAG, s.X("selectDevice: ", this.CxK));
    AppMethodBeat.o(352971);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(352989);
    Log.i(this.TAG, "onDetach");
    cIf();
    this.CxI = null;
    AppMethodBeat.o(352989);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(352932);
    Log.i(this.TAG, "prepare");
    try
    {
      com.tencent.mm.plugin.appbrand.g.c.h.cnm().ceR();
      c.b.cnh().ceR();
      com.tencent.mm.plugin.appbrand.g.b.a.cmW().a((a.a)this);
      AppMethodBeat.o(352932);
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala)
    {
      Log.w(this.TAG, s.X("RouterException: ", locala.getMessage()));
      AppMethodBeat.o(352932);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter$playNew$1", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.appbrand.g.c.a.a
  {
    a(t paramt, String paramString) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(352494);
      String str = this.CxN.TAG;
      Object localObject;
      if (parame == null)
      {
        localObject = null;
        Log.e(str, s.X("stop fail before play new ", localObject));
        localObject = this.CxN.CxJ.obtainMessage(this.CxN.CxG);
        if (parame != null) {
          break label81;
        }
      }
      label81:
      for (int i = 0;; i = parame.responseCode)
      {
        ((Message)localObject).arg1 = i;
        ((Message)localObject).sendToTarget();
        AppMethodBeat.o(352494);
        return;
        localObject = Integer.valueOf(parame.responseCode);
        break;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(352485);
      parame = this.CxN.CxK;
      if (parame != null) {
        parame.a(e.a.riz);
      }
      parame = this.CxN.CxK;
      if (parame != null) {
        parame.a(this.CxO, (com.tencent.mm.plugin.appbrand.g.c.a.a)new a(this.CxN));
      }
      AppMethodBeat.o(352485);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter$playNew$1$success$1", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.appbrand.g.c.a.a
    {
      a(t paramt) {}
      
      public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
      {
        AppMethodBeat.i(353039);
        String str = this.CxN.TAG;
        Object localObject;
        if (parame == null)
        {
          localObject = null;
          Log.e(str, s.X("set AVTransportURI fail ", localObject));
          localObject = this.CxN.CxJ.obtainMessage(this.CxN.CxG);
          if (parame != null) {
            break label81;
          }
        }
        label81:
        for (int i = 0;; i = parame.responseCode)
        {
          ((Message)localObject).arg1 = i;
          ((Message)localObject).sendToTarget();
          AppMethodBeat.o(353039);
          return;
          localObject = Integer.valueOf(parame.responseCode);
          break;
        }
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
      {
        AppMethodBeat.i(353031);
        parame = this.CxN.CxK;
        if (parame != null) {
          parame.a(e.a.riA);
        }
        parame = this.CxN.CxI;
        if (parame != null) {
          parame.k(this.CxN.CxK);
        }
        parame = this.CxN.CxK;
        if (parame != null) {
          parame.a((com.tencent.mm.plugin.appbrand.g.c.a.a)new a(this.CxN));
        }
        AppMethodBeat.o(353031);
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter$playNew$1$success$1$success$1", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements com.tencent.mm.plugin.appbrand.g.c.a.a
      {
        a(t paramt) {}
        
        public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
        {
          AppMethodBeat.i(353026);
          String str = this.CxN.TAG;
          Object localObject;
          if (parame == null)
          {
            localObject = null;
            Log.e(str, s.X("play new fail ", localObject));
            localObject = this.CxN.CxJ.obtainMessage(this.CxN.CxG);
            if (parame != null) {
              break label81;
            }
          }
          label81:
          for (int i = 0;; i = parame.responseCode)
          {
            ((Message)localObject).arg1 = i;
            ((Message)localObject).sendToTarget();
            AppMethodBeat.o(353026);
            return;
            localObject = Integer.valueOf(parame.responseCode);
            break;
          }
        }
        
        public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
        {
          String str = null;
          AppMethodBeat.i(353016);
          Log.d(this.CxN.TAG, "play new success");
          parame = this.CxN.CxK;
          if (parame != null) {
            parame.a(e.a.riB);
          }
          parame = this.CxN.CxK;
          if (parame != null) {
            parame.cna();
          }
          parame = this.CxN.CxK;
          if (parame != null) {
            parame.cnb();
          }
          parame = this.CxN.CxK;
          if (parame != null) {
            parame.a(this.CxN.CxL);
          }
          com.tencent.mm.plugin.finder.live.viewmodel.data.business.e locale = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CxN.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          parame = this.CxN.CxK;
          Object localObject;
          if (parame == null)
          {
            parame = null;
            localObject = this.CxN.CxK;
            if (localObject != null) {
              break label213;
            }
          }
          for (;;)
          {
            locale.Eed = new o(parame, str);
            parame = this.CxN.CxI;
            if (parame != null) {
              parame.j(this.CxN.CxK);
            }
            this.CxN.CxM.stopTimer();
            AppMethodBeat.o(353016);
            return;
            parame = parame.cmY();
            if (parame == null)
            {
              parame = null;
              break;
            }
            parame = parame.rif;
            break;
            label213:
            localObject = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject).cmY();
            if (localObject != null) {
              str = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject).rii;
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter$stop$1", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.appbrand.g.c.a.a
  {
    b(t paramt) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(352512);
      String str = this.CxN.TAG;
      if (parame == null) {}
      for (parame = null;; parame = Integer.valueOf(parame.responseCode))
      {
        Log.e(str, s.X("stop fail ", parame));
        AppMethodBeat.o(352512);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e parame)
    {
      AppMethodBeat.i(352502);
      Log.d(this.CxN.TAG, "stop success");
      parame = this.CxN.CxK;
      if (parame != null) {
        parame.a(e.a.riz);
      }
      parame = this.CxN.CxK;
      if (parame != null) {
        parame.cnc();
      }
      parame = this.CxN.CxK;
      if (parame != null) {
        parame.cnd();
      }
      parame = this.CxN.CxK;
      if (parame != null) {
        parame.a(null);
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CxN.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eed = null;
      parame = this.CxN.CxI;
      if (parame != null) {
        parame.l(this.CxN.CxK);
      }
      this.CxN.CxK = null;
      AppMethodBeat.o(352502);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenPresenter$subEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MREventListener;", "onMute", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "mute", "", "onPause", "onPlay", "onProgress", "progress", "", "onStop", "onVolume", "vol", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements d
  {
    c(t paramt) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(352538);
      String str = this.CxN.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onVolume vol:").append(paramInt).append(" device[");
      Object localObject1 = paramc.cmY();
      if (localObject1 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        localObject1 = paramc.cmY();
        if (localObject1 != null) {
          break label172;
        }
        localObject1 = null;
        label72:
        localStringBuilder = localStringBuilder.append(localObject1).append("] selectedDevice[");
        localObject1 = this.CxN.CxK;
        if (localObject1 != null) {
          break label180;
        }
        localObject1 = null;
        label99:
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        localObject1 = this.CxN.CxK;
        if (localObject1 != null) {
          break label202;
        }
        localObject1 = localObject2;
      }
      for (;;)
      {
        Log.i(str, localObject1 + ']');
        s.p(paramc, this.CxN.CxK);
        AppMethodBeat.o(352538);
        return;
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rif;
        break;
        label172:
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rii;
        break label72;
        label180:
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).cmY();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label99;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rif;
        break label99;
        label202:
        com.tencent.mm.plugin.appbrand.g.b.b localb = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).cmY();
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.rii;
        }
      }
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc, boolean paramBoolean)
    {
      Object localObject2 = null;
      AppMethodBeat.i(352550);
      String str = this.CxN.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onMute mute:").append(paramBoolean).append(" device[");
      Object localObject1 = paramc.cmY();
      if (localObject1 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        localObject1 = paramc.cmY();
        if (localObject1 != null) {
          break label172;
        }
        localObject1 = null;
        label72:
        localStringBuilder = localStringBuilder.append(localObject1).append("] selectedDevice[");
        localObject1 = this.CxN.CxK;
        if (localObject1 != null) {
          break label180;
        }
        localObject1 = null;
        label99:
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        localObject1 = this.CxN.CxK;
        if (localObject1 != null) {
          break label202;
        }
        localObject1 = localObject2;
      }
      for (;;)
      {
        Log.i(str, localObject1 + ']');
        s.p(paramc, this.CxN.CxK);
        AppMethodBeat.o(352550);
        return;
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rif;
        break;
        label172:
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rii;
        break label72;
        label180:
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).cmY();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label99;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rif;
        break label99;
        label202:
        com.tencent.mm.plugin.appbrand.g.b.b localb = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).cmY();
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.rii;
        }
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.b.c paramc, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(352561);
      String str = this.CxN.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onProgress progress:").append(paramInt).append(" device[");
      Object localObject1 = paramc.cmY();
      if (localObject1 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        localObject1 = paramc.cmY();
        if (localObject1 != null) {
          break label172;
        }
        localObject1 = null;
        label72:
        localStringBuilder = localStringBuilder.append(localObject1).append("] selectedDevice[");
        localObject1 = this.CxN.CxK;
        if (localObject1 != null) {
          break label180;
        }
        localObject1 = null;
        label99:
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        localObject1 = this.CxN.CxK;
        if (localObject1 != null) {
          break label202;
        }
        localObject1 = localObject2;
      }
      for (;;)
      {
        Log.i(str, localObject1 + ']');
        s.p(paramc, this.CxN.CxK);
        AppMethodBeat.o(352561);
        return;
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rif;
        break;
        label172:
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rii;
        break label72;
        label180:
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).cmY();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label99;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rif;
        break label99;
        label202:
        com.tencent.mm.plugin.appbrand.g.b.b localb = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).cmY();
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.rii;
        }
      }
    }
    
    public final void d(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      Object localObject2 = null;
      AppMethodBeat.i(352501);
      String str = this.CxN.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onPlay device[");
      Object localObject1 = paramc.cmY();
      if (localObject1 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        localObject1 = paramc.cmY();
        if (localObject1 != null) {
          break label161;
        }
        localObject1 = null;
        label62:
        localStringBuilder = localStringBuilder.append(localObject1).append("] selectedDevice[");
        localObject1 = this.CxN.CxK;
        if (localObject1 != null) {
          break label169;
        }
        localObject1 = null;
        label89:
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        localObject1 = this.CxN.CxK;
        if (localObject1 != null) {
          break label191;
        }
        localObject1 = localObject2;
      }
      for (;;)
      {
        Log.i(str, localObject1 + ']');
        s.p(paramc, this.CxN.CxK);
        AppMethodBeat.o(352501);
        return;
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rif;
        break;
        label161:
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rii;
        break label62;
        label169:
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).cmY();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label89;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rif;
        break label89;
        label191:
        com.tencent.mm.plugin.appbrand.g.b.b localb = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).cmY();
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.rii;
        }
      }
    }
    
    public final void e(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      Object localObject2 = null;
      AppMethodBeat.i(352514);
      String str = this.CxN.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onPause device[");
      Object localObject1 = paramc.cmY();
      if (localObject1 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        localObject1 = paramc.cmY();
        if (localObject1 != null) {
          break label161;
        }
        localObject1 = null;
        label62:
        localStringBuilder = localStringBuilder.append(localObject1).append("] selectedDevice[");
        localObject1 = this.CxN.CxK;
        if (localObject1 != null) {
          break label169;
        }
        localObject1 = null;
        label89:
        localStringBuilder = localStringBuilder.append(localObject1).append(',');
        localObject1 = this.CxN.CxK;
        if (localObject1 != null) {
          break label191;
        }
        localObject1 = localObject2;
      }
      for (;;)
      {
        Log.i(str, localObject1 + ']');
        s.p(paramc, this.CxN.CxK);
        AppMethodBeat.o(352514);
        return;
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rif;
        break;
        label161:
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rii;
        break label62;
        label169:
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).cmY();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label89;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rif;
        break label89;
        label191:
        com.tencent.mm.plugin.appbrand.g.b.b localb = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject1).cmY();
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.rii;
        }
      }
    }
    
    public final void f(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(352529);
      String str = this.CxN.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onStop device[");
      Object localObject = paramc.cmY();
      if (localObject == null)
      {
        localObject = null;
        localStringBuilder = localStringBuilder.append(localObject).append(',');
        localObject = paramc.cmY();
        if (localObject != null) {
          break label230;
        }
        localObject = null;
        label59:
        localStringBuilder = localStringBuilder.append(localObject).append("] selectedDevice[");
        localObject = this.CxN.CxK;
        if (localObject != null) {
          break label238;
        }
        localObject = null;
        label86:
        localStringBuilder = localStringBuilder.append(localObject).append(',');
        localObject = this.CxN.CxK;
        if (localObject != null) {
          break label260;
        }
        localObject = null;
      }
      for (;;)
      {
        Log.i(str, localObject + ']');
        if (s.p(paramc, this.CxN.CxK))
        {
          paramc = this.CxN.CxK;
          if (paramc != null) {
            paramc.a(e.a.riz);
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CxN.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eed = null;
          paramc = this.CxN.CxI;
          if (paramc != null) {
            paramc.l(this.CxN.CxK);
          }
          this.CxN.CxK = null;
        }
        AppMethodBeat.o(352529);
        return;
        localObject = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject).rif;
        break;
        label230:
        localObject = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject).rii;
        break label59;
        label238:
        localObject = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject).cmY();
        if (localObject == null)
        {
          localObject = null;
          break label86;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject).rif;
        break label86;
        label260:
        localObject = ((com.tencent.mm.plugin.appbrand.g.b.c)localObject).cmY();
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject).rii;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.t
 * JD-Core Version:    0.7.0.1
 */