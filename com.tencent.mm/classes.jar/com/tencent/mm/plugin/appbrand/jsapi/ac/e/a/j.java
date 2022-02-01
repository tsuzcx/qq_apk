package com.tencent.mm.plugin.appbrand.jsapi.ac.e.a;

import com.tencent.e.i;
import com.tencent.luggage.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.v;
import d.g.b.p;
import d.g.b.u;
import d.l;
import d.l.k;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.internal.a.f;
import rx.schedulers.Schedulers;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "", "()V", "<set-?>", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "currentSelectedDevice", "getCurrentSelectedDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "setCurrentSelectedDevice", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "currentSelectedDevice$delegate", "Lkotlin/properties/ReadWriteProperty;", "deviceDataChanged", "Lkotlin/Function0;", "", "getDeviceDataChanged", "()Lkotlin/jvm/functions/Function0;", "setDeviceDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "deviceSearchEventListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1;", "dummyMRDevice", "recentDevices", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "getRecentDevices", "()Ljava/util/ArrayList;", "reconnectCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isReconnectSuccess", "getReconnectCallback", "()Lkotlin/jvm/functions/Function1;", "setReconnectCallback", "(Lkotlin/jvm/functions/Function1;)V", "reconnectListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1;", "scannedDevices", "getScannedDevices", "subscription", "Lrx/subscriptions/CompositeSubscription;", "getSubscription", "()Lrx/subscriptions/CompositeSubscription;", "clear", "playError", "playSuccess", "prepareAndSearchDevice", "reconnect", "callback", "search", "searchReleaseTimer", "onTimeOut", "tryInit", "Companion", "luggage-xweb-ext_release"})
public final class j
{
  public static final j.b lAU;
  private final com.tencent.mm.plugin.appbrand.g.b.c lAL;
  private final d.i.c lAM;
  final ArrayList<e> lAN;
  final ArrayList<e> lAO;
  d.g.a.a<d.z> lAP;
  final rx.f.b lAQ;
  d.g.a.b<? super Boolean, d.z> lAR;
  private final d lAS;
  private final c lAT;
  
  static
  {
    AppMethodBeat.i(139796);
    cwV = new k[] { (k)d.g.b.z.a(new u(d.g.b.z.bp(j.class), "currentSelectedDevice", "getCurrentSelectedDevice()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;")) };
    lAU = new j.b((byte)0);
    AppMethodBeat.o(139796);
  }
  
  public j()
  {
    AppMethodBeat.i(139807);
    this.lAL = new com.tencent.mm.plugin.appbrand.g.b.c(null);
    Object localObject = d.i.a.MMa;
    localObject = this.lAL;
    this.lAM = ((d.i.c)new a(localObject, localObject, this));
    this.lAN = new ArrayList();
    this.lAO = new ArrayList();
    this.lAQ = new rx.f.b();
    this.lAS = new d(this);
    this.lAT = new c(this);
    AppMethodBeat.o(139807);
  }
  
  private void bpZ()
  {
    AppMethodBeat.i(139800);
    String str1 = g.Fs();
    String str2 = g.aD(aj.getContext());
    if ((v.isIPv6Address(str1)) && (v.isIPv6Address(str2))) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "searchDevice: selfIp = [%s], wifiIp = [%s], ipv6 = [%b]", new Object[] { str1, str2, Boolean.valueOf(bool) });
      this.lAQ.b(d.a(TimeUnit.MILLISECONDS, Schedulers.computation()).gyP().a(com.tencent.mm.plugin.appbrand.g.d.a.bfE()).a((rx.b.b)new e(bool)));
      AppMethodBeat.o(139800);
      return;
    }
  }
  
  private final void bqa()
  {
    AppMethodBeat.i(139801);
    rx.j localj = d.a(new f(TimeUnit.SECONDS, Schedulers.computation())).a((rx.b.b)new g(this));
    this.lAQ.b(localj);
    AppMethodBeat.o(139801);
  }
  
  private static boolean bqb()
  {
    AppMethodBeat.i(186962);
    try
    {
      com.tencent.mm.plugin.appbrand.g.a.a("MicroMsg.VideoCast.", (com.tencent.mm.plugin.appbrand.g.b)new j.h());
      com.tencent.mm.plugin.appbrand.g.c.h.bfA().enable();
      com.tencent.mm.plugin.appbrand.g.c.c.bfv().enable();
      AppMethodBeat.o(186962);
      return true;
    }
    catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala)
    {
      ad.e("MicroMsg.VideoCast.VideoCastDeviceManager", "prepareAndSearchDevice: RouterException = " + locala.getMessage());
      AppMethodBeat.o(186962);
    }
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.g.b.c bpX()
  {
    AppMethodBeat.i(139797);
    com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)this.lAM.a(cwV[0]);
    AppMethodBeat.o(139797);
    return localc;
  }
  
  public final void bpY()
  {
    AppMethodBeat.i(139799);
    ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "prepare");
    if (!bqb())
    {
      AppMethodBeat.o(139799);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.b.a.bfk().a((a.a)this.lAT);
    bpZ();
    a(this);
    AppMethodBeat.o(139799);
  }
  
  public final void bqc()
  {
    AppMethodBeat.i(139805);
    Iterator localIterator = ((Iterable)this.lAN).iterator();
    e locale;
    label57:
    Object localObject2;
    label108:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.lzz.bfn();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).kcS;
        localObject2 = bpX().bfn();
        if (localObject2 == null) {
          break label108;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).kcS;; localObject2 = null)
      {
        if (!p.i(localObject1, localObject2)) {
          break label111;
        }
        locale.gxz = false;
        locale.lzy = false;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label57;
      }
    }
    localIterator = ((Iterable)this.lAO).iterator();
    label164:
    label215:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.lzz.bfn();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).kcS;
        localObject2 = bpX().bfn();
        if (localObject2 == null) {
          break label215;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).kcS;; localObject2 = null)
      {
        if (!p.i(localObject1, localObject2)) {
          break label218;
        }
        locale.gxz = false;
        locale.lzy = false;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label164;
      }
    }
    Object localObject1 = this.lAP;
    if (localObject1 != null)
    {
      ((d.g.a.a)localObject1).invoke();
      AppMethodBeat.o(139805);
      return;
    }
    AppMethodBeat.o(139805);
  }
  
  public final void bqd()
  {
    AppMethodBeat.i(139806);
    Iterator localIterator = ((Iterable)this.lAN).iterator();
    e locale;
    label57:
    Object localObject2;
    label108:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.lzz.bfn();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).kcS;
        localObject2 = bpX().bfn();
        if (localObject2 == null) {
          break label108;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).kcS;; localObject2 = null)
      {
        if (!p.i(localObject1, localObject2)) {
          break label111;
        }
        locale.gxz = false;
        locale.lzy = true;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label57;
      }
    }
    localIterator = ((Iterable)this.lAO).iterator();
    label164:
    label215:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.lzz.bfn();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).kcS;
        localObject2 = bpX().bfn();
        if (localObject2 == null) {
          break label215;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).kcS;; localObject2 = null)
      {
        if (!p.i(localObject1, localObject2)) {
          break label218;
        }
        locale.gxz = false;
        locale.lzy = true;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label164;
      }
    }
    Object localObject1 = this.lAP;
    if (localObject1 != null)
    {
      ((d.g.a.a)localObject1).invoke();
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
      this.lAQ.clear();
      this.lAO.clear();
      this.lAN.clear();
      com.tencent.mm.plugin.appbrand.g.b.a locala = com.tencent.mm.plugin.appbrand.g.b.a.bfk();
      locala.bfm();
      p.g(locala, "deviceManager");
      Iterator localIterator = locala.bfl().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)localIterator.next();
        localc.bfr();
        localc.bfs();
        localc.a(null);
      }
      localException.b((a.a)this.lAT);
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + localException.getMessage());
      AppMethodBeat.o(139804);
      return;
    }
    localException.b((a.a)this.lAS);
    localException.destroy();
    try
    {
      com.tencent.mm.plugin.appbrand.g.c.h.bfA().disable();
      label153:
      com.tencent.mm.plugin.appbrand.g.c.c.bfv().disable();
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
    this.lAM.a(cwV[0], paramc);
    AppMethodBeat.o(139798);
  }
  
  public final void u(d.g.a.b<? super Boolean, d.z> paramb)
  {
    AppMethodBeat.i(178860);
    p.h(paramb, "callback");
    try
    {
      this.lAQ.clear();
      com.tencent.mm.plugin.appbrand.g.b.a locala = com.tencent.mm.plugin.appbrand.g.b.a.bfk();
      locala.bfm();
      p.g(locala, "deviceManager");
      Iterator localIterator = locala.bfl().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)localIterator.next();
        localc.bfr();
        localc.bfs();
        localc.a(null);
        continue;
        if (bqb()) {
          break label174;
        }
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + localException.getMessage());
    }
    for (;;)
    {
      ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: not enableRouter");
      AppMethodBeat.o(178860);
      return;
      localException.b((a.a)this.lAT);
      localException.b((a.a)this.lAS);
      localException.destroy();
      try
      {
        com.tencent.mm.plugin.appbrand.g.c.h.bfA().disable();
        label164:
        com.tencent.mm.plugin.appbrand.g.c.c.bfv().disable();
        continue;
        label174:
        this.lAR = paramb;
        com.tencent.mm.plugin.appbrand.g.b.a.bfk().a((a.a)this.lAS);
        bpZ();
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends d.i.b<com.tencent.mm.plugin.appbrand.g.b.c>
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
      if (((p.i((com.tencent.mm.plugin.appbrand.g.b.c)paramc1, paramk) ^ true)) && (paramk.bfn() != null))
      {
        p.h(paramk, "$this$saveDevice");
        paramc1 = ax.flg();
        com.tencent.e.h.LTJ.aR((Runnable)new k.a(paramk, paramc1));
        paramc2 = ((Iterable)jdField_this.lAN).iterator();
        e locale;
        label133:
        label187:
        label190:
        while (paramc2.hasNext())
        {
          locale = (e)paramc2.next();
          locale.isSelected = false;
          locale.gxz = false;
          paramk = locale.lzz.bfn();
          if (paramk != null)
          {
            paramk = paramk.kcS;
            paramc1 = jdField_this.bpX().bfn();
            if (paramc1 == null) {
              break label187;
            }
          }
          for (paramc1 = paramc1.kcS;; paramc1 = null)
          {
            if (!p.i(paramk, paramc1)) {
              break label190;
            }
            locale.gxz = true;
            locale.lzy = false;
            locale.isSelected = true;
            break;
            paramk = null;
            break label133;
          }
        }
        paramc2 = ((Iterable)jdField_this.lAO).iterator();
        label258:
        label312:
        label315:
        while (paramc2.hasNext())
        {
          locale = (e)paramc2.next();
          locale.isSelected = false;
          locale.gxz = false;
          paramk = locale.lzz.bfn();
          if (paramk != null)
          {
            paramk = paramk.kcS;
            paramc1 = jdField_this.bpX().bfn();
            if (paramc1 == null) {
              break label312;
            }
          }
          for (paramc1 = paramc1.kcS;; paramc1 = null)
          {
            if (!p.i(paramk, paramc1)) {
              break label315;
            }
            locale.gxz = true;
            locale.lzy = false;
            locale.isSelected = true;
            break;
            paramk = null;
            break label258;
          }
        }
        paramk = jdField_this.lAP;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
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
          ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: ".concat(String.valueOf(paramc)));
          p.h(paramc, "$this$isRecentDevice");
          localObject4 = ax.flg();
          Object localObject1 = paramc.bfn();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).kcS;
            if (((ax)localObject4).getLong((String)localObject1, 0L) == 0L) {
              continue;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            localObject1 = (Iterable)this.lAV.lAO;
            if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
              continue;
            }
            localObject1 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject4 = ((e)((Iterator)localObject1).next()).lzz.bfn();
            if (localObject4 == null) {
              p.gfZ();
            }
            localObject4 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject4).kcS;
            localb = paramc.bfn();
            if (localb == null) {
              p.gfZ();
            }
            if (!p.i(localObject4, localb.kcS)) {
              continue;
            }
            i = j;
            if (i != 0) {
              this.lAV.lAO.add(new e(paramc));
            }
            localObject1 = this.lAV.lAP;
            if (localObject1 != null) {
              ((d.g.a.a)localObject1).invoke();
            }
            localObject1 = new StringBuilder("onAddDevice: ");
            localObject4 = paramc.bfn();
            paramc = localObject3;
            if (localObject4 != null) {
              paramc = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject4).kcP;
            }
            ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", paramc);
            AppMethodBeat.o(139788);
          }
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice", new Object[] { localException });
          continue;
          localObject2 = null;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
          localObject2 = (Iterable)this.lAV.lAN;
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
            localObject4 = ((e)((Iterator)localObject2).next()).lzz.bfn();
            if (localObject4 == null) {
              p.gfZ();
            }
            localObject4 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject4).kcS;
            localb = paramc.bfn();
            if (localb == null) {
              p.gfZ();
            }
          } while (!p.i(localObject4, localb.kcS));
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label468;
          }
          this.lAV.lAN.add(new e(paramc));
          break;
        }
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139789);
      p.h(paramc, "device");
      this.lAV.lAN.remove(new e(paramc));
      this.lAV.lAO.remove(new e(paramc));
      Object localObject = this.lAV.lAP;
      if (localObject != null) {
        ((d.g.a.a)localObject).invoke();
      }
      localObject = new StringBuilder("onRemoveDevice: ");
      paramc = paramc.bfn();
      if (paramc != null) {}
      for (paramc = paramc.kcP;; paramc = null)
      {
        ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", paramc);
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
        ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice: ".concat(String.valueOf(paramc)));
        AppMethodBeat.o(139790);
        return;
      }
      catch (Exception paramc)
      {
        ad.e("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice", new Object[] { paramc });
        AppMethodBeat.o(139790);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
  public static final class d
    implements a.a
  {
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139791);
      if (paramc != null)
      {
        localObject1 = paramc.bfn();
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).kcS;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label32;
          }
        }
      }
      Object localObject1 = "";
      label32:
      ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: udn = ".concat(String.valueOf(localObject1)));
      if ((paramc == null) || (n.aE((CharSequence)localObject1)))
      {
        paramc = this.lAV.lAR;
        if (paramc != null)
        {
          paramc.invoke(Boolean.FALSE);
          AppMethodBeat.o(139791);
          return;
        }
        AppMethodBeat.o(139791);
        return;
      }
      Object localObject2 = this.lAV.bpX().bfn();
      if (localObject2 != null) {}
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).kcS;; localObject2 = null)
      {
        if (p.i(localObject1, localObject2))
        {
          localObject1 = this.lAV.lAR;
          if (localObject1 != null) {
            ((d.g.a.b)localObject1).invoke(Boolean.TRUE);
          }
          this.lAV.g(paramc);
        }
        AppMethodBeat.o(139791);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(161190);
      ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onRemoveDevice");
      AppMethodBeat.o(161190);
    }
    
    public final void c(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(161191);
      ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onUpdateDevice");
      AppMethodBeat.o(161191);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
  static final class e<T>
    implements rx.b.b<Long>
  {
    e(boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
  static final class g<T>
    implements rx.b.b<Long>
  {
    g(j paramj) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.j
 * JD-Core Version:    0.7.0.1
 */