package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.a.a;
import com.tencent.mm.sdk.platformtools.InetUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.n.n;
import kotlin.x;
import rx.d;
import rx.internal.a.f;
import rx.schedulers.Schedulers;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "", "()V", "<set-?>", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "currentSelectedDevice", "getCurrentSelectedDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "setCurrentSelectedDevice", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "currentSelectedDevice$delegate", "Lkotlin/properties/ReadWriteProperty;", "deviceDataChanged", "Lkotlin/Function0;", "", "getDeviceDataChanged", "()Lkotlin/jvm/functions/Function0;", "setDeviceDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "deviceSearchEventListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1;", "dummyMRDevice", "recentDevices", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "getRecentDevices", "()Ljava/util/ArrayList;", "reconnectCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isReconnectSuccess", "getReconnectCallback", "()Lkotlin/jvm/functions/Function1;", "setReconnectCallback", "(Lkotlin/jvm/functions/Function1;)V", "reconnectListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1;", "scannedDevices", "getScannedDevices", "subscription", "Lrx/subscriptions/CompositeSubscription;", "getSubscription", "()Lrx/subscriptions/CompositeSubscription;", "clear", "playError", "playSuccess", "prepareAndSearchDevice", "reconnect", "callback", "search", "searchReleaseTimer", "onTimeOut", "tryInit", "Companion", "luggage-xweb-ext_release"})
public final class j
{
  public static final j.b mNb;
  private final com.tencent.mm.plugin.appbrand.g.b.c mMS;
  private final kotlin.i.c mMT;
  final ArrayList<e> mMU;
  final ArrayList<e> mMV;
  kotlin.g.a.a<x> mMW;
  final rx.f.b mMX;
  kotlin.g.a.b<? super Boolean, x> mMY;
  private final d mMZ;
  private final c mNa;
  
  static
  {
    AppMethodBeat.i(139796);
    cLI = new k[] { (k)aa.a(new v(aa.bp(j.class), "currentSelectedDevice", "getCurrentSelectedDevice()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;")) };
    mNb = new j.b((byte)0);
    AppMethodBeat.o(139796);
  }
  
  public j()
  {
    AppMethodBeat.i(139807);
    this.mMS = new com.tencent.mm.plugin.appbrand.g.b.c(null);
    Object localObject = kotlin.i.a.SYL;
    localObject = this.mMS;
    this.mMT = ((kotlin.i.c)new a(localObject, localObject, this));
    this.mMU = new ArrayList();
    this.mMV = new ArrayList();
    this.mMX = new rx.f.b();
    this.mMZ = new d(this);
    this.mNa = new c(this);
    AppMethodBeat.o(139807);
  }
  
  private void bMu()
  {
    AppMethodBeat.i(139800);
    String str1 = com.tencent.luggage.h.h.Ph();
    String str2 = com.tencent.luggage.h.h.aN(MMApplicationContext.getContext());
    if ((InetUtil.isIPv6Address(str1)) && (InetUtil.isIPv6Address(str2))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "searchDevice: selfIp = [%s], wifiIp = [%s], ipv6 = [%b]", new Object[] { str1, str2, Boolean.valueOf(bool) });
      this.mMX.b(d.a(TimeUnit.MILLISECONDS, Schedulers.computation()).hQz().a(com.tencent.mm.plugin.appbrand.g.d.a.bBF()).a((rx.b.b)new e(bool)));
      AppMethodBeat.o(139800);
      return;
    }
  }
  
  private final void bMv()
  {
    AppMethodBeat.i(139801);
    rx.j localj = d.a(new f(TimeUnit.SECONDS, Schedulers.computation())).a((rx.b.b)new g(this));
    this.mMX.b(localj);
    AppMethodBeat.o(139801);
  }
  
  private static boolean bMw()
  {
    AppMethodBeat.i(216011);
    try
    {
      com.tencent.mm.plugin.appbrand.g.a.a("MicroMsg.VideoCast.", (com.tencent.mm.plugin.appbrand.g.b)new j.h());
      com.tencent.mm.plugin.appbrand.g.c.h.bBB().enable();
      com.tencent.mm.plugin.appbrand.g.c.c.bBw().enable();
      AppMethodBeat.o(216011);
      return true;
    }
    catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala)
    {
      Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "prepareAndSearchDevice: RouterException = " + locala.getMessage());
      AppMethodBeat.o(216011);
    }
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.g.b.c bMs()
  {
    AppMethodBeat.i(139797);
    com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)this.mMT.a(cLI[0]);
    AppMethodBeat.o(139797);
    return localc;
  }
  
  public final void bMt()
  {
    AppMethodBeat.i(139799);
    Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "prepare");
    if (!bMw())
    {
      AppMethodBeat.o(139799);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.b.a.bBl().a((a.a)this.mNa);
    bMu();
    a(this);
    AppMethodBeat.o(139799);
  }
  
  public final void bMx()
  {
    AppMethodBeat.i(139805);
    Iterator localIterator = ((Iterable)this.mMU).iterator();
    e locale;
    label57:
    Object localObject2;
    label108:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.mLG.bBo();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).ljS;
        localObject2 = bMs().bBo();
        if (localObject2 == null) {
          break label108;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).ljS;; localObject2 = null)
      {
        if (!p.j(localObject1, localObject2)) {
          break label111;
        }
        locale.hmV = false;
        locale.mLF = false;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label57;
      }
    }
    localIterator = ((Iterable)this.mMV).iterator();
    label164:
    label215:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.mLG.bBo();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).ljS;
        localObject2 = bMs().bBo();
        if (localObject2 == null) {
          break label215;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).ljS;; localObject2 = null)
      {
        if (!p.j(localObject1, localObject2)) {
          break label218;
        }
        locale.hmV = false;
        locale.mLF = false;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label164;
      }
    }
    Object localObject1 = this.mMW;
    if (localObject1 != null)
    {
      ((kotlin.g.a.a)localObject1).invoke();
      AppMethodBeat.o(139805);
      return;
    }
    AppMethodBeat.o(139805);
  }
  
  public final void bMy()
  {
    AppMethodBeat.i(139806);
    Iterator localIterator = ((Iterable)this.mMU).iterator();
    e locale;
    label57:
    Object localObject2;
    label108:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.mLG.bBo();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).ljS;
        localObject2 = bMs().bBo();
        if (localObject2 == null) {
          break label108;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).ljS;; localObject2 = null)
      {
        if (!p.j(localObject1, localObject2)) {
          break label111;
        }
        locale.hmV = false;
        locale.mLF = true;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label57;
      }
    }
    localIterator = ((Iterable)this.mMV).iterator();
    label164:
    label215:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.mLG.bBo();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).ljS;
        localObject2 = bMs().bBo();
        if (localObject2 == null) {
          break label215;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).ljS;; localObject2 = null)
      {
        if (!p.j(localObject1, localObject2)) {
          break label218;
        }
        locale.hmV = false;
        locale.mLF = true;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label164;
      }
    }
    Object localObject1 = this.mMW;
    if (localObject1 != null)
    {
      ((kotlin.g.a.a)localObject1).invoke();
      AppMethodBeat.o(139806);
      return;
    }
    AppMethodBeat.o(139806);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(139804);
    try
    {
      this.mMX.clear();
      this.mMV.clear();
      this.mMU.clear();
      com.tencent.mm.plugin.appbrand.g.b.a locala = com.tencent.mm.plugin.appbrand.g.b.a.bBl();
      locala.bBn();
      p.g(locala, "deviceManager");
      Iterator localIterator = locala.bBm().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)localIterator.next();
        localc.bBs();
        localc.bBt();
        localc.a(null);
      }
      localException.b((a.a)this.mNa);
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + localException.getMessage());
      AppMethodBeat.o(139804);
      return;
    }
    localException.b((a.a)this.mMZ);
    localException.destroy();
    try
    {
      com.tencent.mm.plugin.appbrand.g.c.h.bBB().disable();
      label153:
      com.tencent.mm.plugin.appbrand.g.c.c.bBw().disable();
      AppMethodBeat.o(139804);
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala1)
    {
      break label153;
    }
  }
  
  public final void g(com.tencent.mm.plugin.appbrand.g.b.c paramc)
  {
    AppMethodBeat.i(139798);
    p.h(paramc, "<set-?>");
    this.mMT.a(cLI[0], paramc);
    AppMethodBeat.o(139798);
  }
  
  public final void v(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(178860);
    p.h(paramb, "callback");
    try
    {
      this.mMX.clear();
      com.tencent.mm.plugin.appbrand.g.b.a locala = com.tencent.mm.plugin.appbrand.g.b.a.bBl();
      locala.bBn();
      p.g(locala, "deviceManager");
      Iterator localIterator = locala.bBm().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)localIterator.next();
        localc.bBs();
        localc.bBt();
        localc.a(null);
        continue;
        if (bMw()) {
          break label174;
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + localException.getMessage());
    }
    for (;;)
    {
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: not enableRouter");
      AppMethodBeat.o(178860);
      return;
      localException.b((a.a)this.mNa);
      localException.b((a.a)this.mMZ);
      localException.destroy();
      try
      {
        com.tencent.mm.plugin.appbrand.g.c.h.bBB().disable();
        label164:
        com.tencent.mm.plugin.appbrand.g.c.c.bBw().disable();
        continue;
        label174:
        this.mMY = paramb;
        com.tencent.mm.plugin.appbrand.g.b.a.bBl().a((a.a)this.mMZ);
        bMu();
        a(this);
        AppMethodBeat.o(178860);
        return;
      }
      catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala1)
      {
        break label164;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends kotlin.i.b<com.tencent.mm.plugin.appbrand.g.b.c>
  {
    public a(Object paramObject1, Object paramObject2, j paramj)
    {
      super();
    }
    
    public final void a(k<?> paramk, com.tencent.mm.plugin.appbrand.g.b.c paramc1, com.tencent.mm.plugin.appbrand.g.b.c paramc2)
    {
      AppMethodBeat.i(139787);
      p.h(paramk, "property");
      paramk = (com.tencent.mm.plugin.appbrand.g.b.c)paramc2;
      if (((p.j((com.tencent.mm.plugin.appbrand.g.b.c)paramc1, paramk) ^ true)) && (paramk.bBo() != null))
      {
        p.h(paramk, "$this$saveDevice");
        paramc1 = MultiProcessMMKV.getSingleDefault();
        com.tencent.f.h.RTc.aX((Runnable)new k.a(paramk, paramc1));
        paramc2 = ((Iterable)jdField_this.mMU).iterator();
        e locale;
        label133:
        label187:
        label190:
        while (paramc2.hasNext())
        {
          locale = (e)paramc2.next();
          locale.isSelected = false;
          locale.hmV = false;
          paramk = locale.mLG.bBo();
          if (paramk != null)
          {
            paramk = paramk.ljS;
            paramc1 = jdField_this.bMs().bBo();
            if (paramc1 == null) {
              break label187;
            }
          }
          for (paramc1 = paramc1.ljS;; paramc1 = null)
          {
            if (!p.j(paramk, paramc1)) {
              break label190;
            }
            locale.hmV = true;
            locale.mLF = false;
            locale.isSelected = true;
            break;
            paramk = null;
            break label133;
          }
        }
        paramc2 = ((Iterable)jdField_this.mMV).iterator();
        label258:
        label312:
        label315:
        while (paramc2.hasNext())
        {
          locale = (e)paramc2.next();
          locale.isSelected = false;
          locale.hmV = false;
          paramk = locale.mLG.bBo();
          if (paramk != null)
          {
            paramk = paramk.ljS;
            paramc1 = jdField_this.bMs().bBo();
            if (paramc1 == null) {
              break label312;
            }
          }
          for (paramc1 = paramc1.ljS;; paramc1 = null)
          {
            if (!p.j(paramk, paramc1)) {
              break label315;
            }
            locale.hmV = true;
            locale.mLF = false;
            locale.isSelected = true;
            break;
            paramk = null;
            break label258;
          }
        }
        paramk = jdField_this.mMW;
        if (paramk != null)
        {
          paramk.invoke();
          AppMethodBeat.o(139787);
          return;
        }
      }
      AppMethodBeat.o(139787);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
  public static final class c
    implements a.a
  {
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      Object localObject3 = null;
      int j = 0;
      AppMethodBeat.i(139788);
      p.h(paramc, "device");
      label468:
      for (;;)
      {
        Object localObject4;
        com.tencent.mm.plugin.appbrand.g.b.b localb;
        Object localObject2;
        try
        {
          Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: ".concat(String.valueOf(paramc)));
          p.h(paramc, "$this$isRecentDevice");
          localObject4 = MultiProcessMMKV.getSingleDefault();
          Object localObject1 = paramc.bBo();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).ljS;
            if (((MultiProcessMMKV)localObject4).getLong((String)localObject1, 0L) == 0L) {
              continue;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            localObject1 = (Iterable)this.mNc.mMV;
            if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
              continue;
            }
            localObject1 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject4 = ((e)((Iterator)localObject1).next()).mLG.bBo();
            if (localObject4 == null) {
              p.hyc();
            }
            localObject4 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject4).ljS;
            localb = paramc.bBo();
            if (localb == null) {
              p.hyc();
            }
            if (!p.j(localObject4, localb.ljS)) {
              continue;
            }
            i = j;
            if (i != 0) {
              this.mNc.mMV.add(new e(paramc));
            }
            localObject1 = this.mNc.mMW;
            if (localObject1 != null) {
              ((kotlin.g.a.a)localObject1).invoke();
            }
            localObject1 = new StringBuilder("onAddDevice: ");
            localObject4 = paramc.bBo();
            paramc = localObject3;
            if (localObject4 != null) {
              paramc = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject4).ljP;
            }
            Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", paramc);
            AppMethodBeat.o(139788);
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice", new Object[] { localException });
          continue;
          localObject2 = null;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
          localObject2 = (Iterable)this.mNc.mMU;
          if (!(localObject2 instanceof Collection)) {
            break label358;
          }
        }
        if (!((Collection)localObject2).isEmpty())
        {
          label358:
          localObject2 = ((Iterable)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject4 = ((e)((Iterator)localObject2).next()).mLG.bBo();
            if (localObject4 == null) {
              p.hyc();
            }
            localObject4 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject4).ljS;
            localb = paramc.bBo();
            if (localb == null) {
              p.hyc();
            }
          } while (!p.j(localObject4, localb.ljS));
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label468;
          }
          this.mNc.mMU.add(new e(paramc));
          break;
        }
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139789);
      p.h(paramc, "device");
      this.mNc.mMU.remove(new e(paramc));
      this.mNc.mMV.remove(new e(paramc));
      Object localObject = this.mNc.mMW;
      if (localObject != null) {
        ((kotlin.g.a.a)localObject).invoke();
      }
      localObject = new StringBuilder("onRemoveDevice: ");
      paramc = paramc.bBo();
      if (paramc != null) {}
      for (paramc = paramc.ljP;; paramc = null)
      {
        Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", paramc);
        AppMethodBeat.o(139789);
        return;
      }
    }
    
    public final void c(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139790);
      p.h(paramc, "device");
      try
      {
        Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice: ".concat(String.valueOf(paramc)));
        AppMethodBeat.o(139790);
        return;
      }
      catch (Exception paramc)
      {
        Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice", new Object[] { paramc });
        AppMethodBeat.o(139790);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
  public static final class d
    implements a.a
  {
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139791);
      if (paramc != null)
      {
        localObject1 = paramc.bBo();
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).ljS;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label32;
          }
        }
      }
      Object localObject1 = "";
      label32:
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: udn = ".concat(String.valueOf(localObject1)));
      if ((paramc == null) || (n.aL((CharSequence)localObject1)))
      {
        paramc = this.mNc.mMY;
        if (paramc != null)
        {
          paramc.invoke(Boolean.FALSE);
          AppMethodBeat.o(139791);
          return;
        }
        AppMethodBeat.o(139791);
        return;
      }
      Object localObject2 = this.mNc.bMs().bBo();
      if (localObject2 != null) {}
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).ljS;; localObject2 = null)
      {
        if (p.j(localObject1, localObject2))
        {
          localObject1 = this.mNc.mMY;
          if (localObject1 != null) {
            ((kotlin.g.a.b)localObject1).invoke(Boolean.TRUE);
          }
          this.mNc.g(paramc);
        }
        AppMethodBeat.o(139791);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(161190);
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onRemoveDevice");
      AppMethodBeat.o(161190);
    }
    
    public final void c(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(161191);
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onUpdateDevice");
      AppMethodBeat.o(161191);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
  static final class e<T>
    implements rx.b.b<Long>
  {
    e(boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
  static final class g<T>
    implements rx.b.b<Long>
  {
    g(j paramj) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.j
 * JD-Core Version:    0.7.0.1
 */