package com.tencent.mm.plugin.appbrand.jsapi.z.e.a;

import com.tencent.e.i;
import com.tencent.luggage.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.u;
import d.g.b.o;
import d.g.b.w;
import d.l;
import d.n.n;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.internal.a.f;
import rx.schedulers.Schedulers;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "", "()V", "<set-?>", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "currentSelectedDevice", "getCurrentSelectedDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "setCurrentSelectedDevice", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "currentSelectedDevice$delegate", "Lkotlin/properties/ReadWriteProperty;", "deviceDataChanged", "Lkotlin/Function0;", "", "getDeviceDataChanged", "()Lkotlin/jvm/functions/Function0;", "setDeviceDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "deviceSearchEventListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1;", "dummyMRDevice", "recentDevices", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "getRecentDevices", "()Ljava/util/ArrayList;", "reconnectCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isReconnectSuccess", "getReconnectCallback", "()Lkotlin/jvm/functions/Function1;", "setReconnectCallback", "(Lkotlin/jvm/functions/Function1;)V", "reconnectListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1;", "scannedDevices", "getScannedDevices", "subscription", "Lrx/subscriptions/CompositeSubscription;", "getSubscription", "()Lrx/subscriptions/CompositeSubscription;", "clear", "playError", "playSuccess", "prepareAndSearchDevice", "reconnect", "callback", "search", "searchReleaseTimer", "onTimeOut", "tryInit", "Companion", "luggage-xweb-ext_release"})
public final class j
{
  public static final j.b ldU;
  private final com.tencent.mm.plugin.appbrand.h.b.c ldL;
  private final d.i.c ldM;
  final ArrayList<e> ldN;
  final ArrayList<e> ldO;
  d.g.a.a<y> ldP;
  final rx.f.b ldQ;
  d.g.a.b<? super Boolean, y> ldR;
  private final d ldS;
  private final c ldT;
  
  static
  {
    AppMethodBeat.i(139796);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new o(w.bn(j.class), "currentSelectedDevice", "getCurrentSelectedDevice()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;")) };
    ldU = new j.b((byte)0);
    AppMethodBeat.o(139796);
  }
  
  public j()
  {
    AppMethodBeat.i(139807);
    this.ldL = new com.tencent.mm.plugin.appbrand.h.b.c(null);
    Object localObject = d.i.a.KUU;
    localObject = this.ldL;
    this.ldM = ((d.i.c)new a(localObject, localObject, this));
    this.ldN = new ArrayList();
    this.ldO = new ArrayList();
    this.ldQ = new rx.f.b();
    this.ldS = new d(this);
    this.ldT = new c(this);
    AppMethodBeat.o(139807);
  }
  
  private void bmo()
  {
    AppMethodBeat.i(139800);
    String str1 = g.DS();
    String str2 = g.aD(ai.getContext());
    if ((u.isIPv6Address(str1)) && (u.isIPv6Address(str2))) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.VideoCast.VideoCastDeviceManager", "searchDevice: selfIp = [%s], wifiIp = [%s], ipv6 = [%b]", new Object[] { str1, str2, Boolean.valueOf(bool) });
      this.ldQ.b(d.a(TimeUnit.MILLISECONDS, Schedulers.computation()).ggl().a(com.tencent.mm.plugin.appbrand.h.d.a.bca()).a((rx.b.b)new e(bool)));
      AppMethodBeat.o(139800);
      return;
    }
  }
  
  private final void bmp()
  {
    AppMethodBeat.i(139801);
    rx.j localj = d.a(new f(TimeUnit.SECONDS, Schedulers.computation())).a((rx.b.b)new g(this));
    this.ldQ.b(localj);
    AppMethodBeat.o(139801);
  }
  
  private static boolean bmq()
  {
    AppMethodBeat.i(206501);
    try
    {
      com.tencent.mm.plugin.appbrand.h.a.a("MicroMsg.VideoCast.", (com.tencent.mm.plugin.appbrand.h.b)new j.h());
      com.tencent.mm.plugin.appbrand.h.c.h.bbW().enable();
      com.tencent.mm.plugin.appbrand.h.c.c.bbR().enable();
      AppMethodBeat.o(206501);
      return true;
    }
    catch (com.tencent.mm.plugin.appbrand.h.c.c.a locala)
    {
      ac.e("MicroMsg.VideoCast.VideoCastDeviceManager", "prepareAndSearchDevice: RouterException = " + locala.getMessage());
      AppMethodBeat.o(206501);
    }
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.h.b.c bmm()
  {
    AppMethodBeat.i(139797);
    com.tencent.mm.plugin.appbrand.h.b.c localc = (com.tencent.mm.plugin.appbrand.h.b.c)this.ldM.a($$delegatedProperties[0]);
    AppMethodBeat.o(139797);
    return localc;
  }
  
  public final void bmn()
  {
    AppMethodBeat.i(139799);
    ac.i("MicroMsg.VideoCast.VideoCastDeviceManager", "prepare");
    if (!bmq())
    {
      AppMethodBeat.o(139799);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.b.a.bbG().a((a.a)this.ldT);
    bmo();
    a(this);
    AppMethodBeat.o(139799);
  }
  
  public final void bmr()
  {
    AppMethodBeat.i(139805);
    Iterator localIterator = ((Iterable)this.ldN).iterator();
    e locale;
    label57:
    Object localObject2;
    label108:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.lcz.bbJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jIG;
        localObject2 = bmm().bbJ();
        if (localObject2 == null) {
          break label108;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jIG;; localObject2 = null)
      {
        if (!d.g.b.k.g(localObject1, localObject2)) {
          break label111;
        }
        locale.gdP = false;
        locale.lcy = false;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label57;
      }
    }
    localIterator = ((Iterable)this.ldO).iterator();
    label164:
    label215:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.lcz.bbJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jIG;
        localObject2 = bmm().bbJ();
        if (localObject2 == null) {
          break label215;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jIG;; localObject2 = null)
      {
        if (!d.g.b.k.g(localObject1, localObject2)) {
          break label218;
        }
        locale.gdP = false;
        locale.lcy = false;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label164;
      }
    }
    Object localObject1 = this.ldP;
    if (localObject1 != null)
    {
      ((d.g.a.a)localObject1).invoke();
      AppMethodBeat.o(139805);
      return;
    }
    AppMethodBeat.o(139805);
  }
  
  public final void bms()
  {
    AppMethodBeat.i(139806);
    Iterator localIterator = ((Iterable)this.ldN).iterator();
    e locale;
    label57:
    Object localObject2;
    label108:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.lcz.bbJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jIG;
        localObject2 = bmm().bbJ();
        if (localObject2 == null) {
          break label108;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jIG;; localObject2 = null)
      {
        if (!d.g.b.k.g(localObject1, localObject2)) {
          break label111;
        }
        locale.gdP = false;
        locale.lcy = true;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label57;
      }
    }
    localIterator = ((Iterable)this.ldO).iterator();
    label164:
    label215:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.lcz.bbJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jIG;
        localObject2 = bmm().bbJ();
        if (localObject2 == null) {
          break label215;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jIG;; localObject2 = null)
      {
        if (!d.g.b.k.g(localObject1, localObject2)) {
          break label218;
        }
        locale.gdP = false;
        locale.lcy = true;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label164;
      }
    }
    Object localObject1 = this.ldP;
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
      this.ldQ.clear();
      this.ldO.clear();
      this.ldN.clear();
      com.tencent.mm.plugin.appbrand.h.b.a locala = com.tencent.mm.plugin.appbrand.h.b.a.bbG();
      locala.bbI();
      d.g.b.k.g(locala, "deviceManager");
      Iterator localIterator = locala.bbH().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.h.b.c localc = (com.tencent.mm.plugin.appbrand.h.b.c)localIterator.next();
        localc.bbN();
        localc.bbO();
        localc.a(null);
      }
      localException.b((a.a)this.ldT);
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + localException.getMessage());
      AppMethodBeat.o(139804);
      return;
    }
    localException.b((a.a)this.ldS);
    localException.destroy();
    try
    {
      com.tencent.mm.plugin.appbrand.h.c.h.bbW().disable();
      label153:
      com.tencent.mm.plugin.appbrand.h.c.c.bbR().disable();
      AppMethodBeat.o(139804);
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.h.c.c.a locala1)
    {
      break label153;
    }
  }
  
  public final void g(com.tencent.mm.plugin.appbrand.h.b.c paramc)
  {
    AppMethodBeat.i(139798);
    d.g.b.k.h(paramc, "<set-?>");
    this.ldM.a($$delegatedProperties[0], paramc);
    AppMethodBeat.o(139798);
  }
  
  public final void t(d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(178860);
    d.g.b.k.h(paramb, "callback");
    try
    {
      this.ldQ.clear();
      com.tencent.mm.plugin.appbrand.h.b.a locala = com.tencent.mm.plugin.appbrand.h.b.a.bbG();
      locala.bbI();
      d.g.b.k.g(locala, "deviceManager");
      Iterator localIterator = locala.bbH().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.h.b.c localc = (com.tencent.mm.plugin.appbrand.h.b.c)localIterator.next();
        localc.bbN();
        localc.bbO();
        localc.a(null);
        continue;
        if (bmq()) {
          break label174;
        }
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + localException.getMessage());
    }
    for (;;)
    {
      ac.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: not enableRouter");
      AppMethodBeat.o(178860);
      return;
      localException.b((a.a)this.ldT);
      localException.b((a.a)this.ldS);
      localException.destroy();
      try
      {
        com.tencent.mm.plugin.appbrand.h.c.h.bbW().disable();
        label164:
        com.tencent.mm.plugin.appbrand.h.c.c.bbR().disable();
        continue;
        label174:
        this.ldR = paramb;
        com.tencent.mm.plugin.appbrand.h.b.a.bbG().a((a.a)this.ldS);
        bmo();
        a(this);
        AppMethodBeat.o(178860);
        return;
      }
      catch (com.tencent.mm.plugin.appbrand.h.c.c.a locala1)
      {
        break label164;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends d.i.b<com.tencent.mm.plugin.appbrand.h.b.c>
  {
    public a(Object paramObject1, Object paramObject2, j paramj)
    {
      super();
    }
    
    public final void a(d.l.k<?> paramk, com.tencent.mm.plugin.appbrand.h.b.c paramc1, com.tencent.mm.plugin.appbrand.h.b.c paramc2)
    {
      AppMethodBeat.i(139787);
      d.g.b.k.h(paramk, "property");
      paramk = (com.tencent.mm.plugin.appbrand.h.b.c)paramc2;
      if (((d.g.b.k.g((com.tencent.mm.plugin.appbrand.h.b.c)paramc1, paramk) ^ true)) && (paramk.bbJ() != null))
      {
        d.g.b.k.h(paramk, "$this$saveDevice");
        paramc1 = aw.eVz();
        com.tencent.e.h.JZN.aS((Runnable)new k.a(paramk, paramc1));
        paramc2 = ((Iterable)jdField_this.ldN).iterator();
        e locale;
        label133:
        label187:
        label190:
        while (paramc2.hasNext())
        {
          locale = (e)paramc2.next();
          locale.isSelected = false;
          locale.gdP = false;
          paramk = locale.lcz.bbJ();
          if (paramk != null)
          {
            paramk = paramk.jIG;
            paramc1 = jdField_this.bmm().bbJ();
            if (paramc1 == null) {
              break label187;
            }
          }
          for (paramc1 = paramc1.jIG;; paramc1 = null)
          {
            if (!d.g.b.k.g(paramk, paramc1)) {
              break label190;
            }
            locale.gdP = true;
            locale.lcy = false;
            locale.isSelected = true;
            break;
            paramk = null;
            break label133;
          }
        }
        paramc2 = ((Iterable)jdField_this.ldO).iterator();
        label258:
        label312:
        label315:
        while (paramc2.hasNext())
        {
          locale = (e)paramc2.next();
          locale.isSelected = false;
          locale.gdP = false;
          paramk = locale.lcz.bbJ();
          if (paramk != null)
          {
            paramk = paramk.jIG;
            paramc1 = jdField_this.bmm().bbJ();
            if (paramc1 == null) {
              break label312;
            }
          }
          for (paramc1 = paramc1.jIG;; paramc1 = null)
          {
            if (!d.g.b.k.g(paramk, paramc1)) {
              break label315;
            }
            locale.gdP = true;
            locale.lcy = false;
            locale.isSelected = true;
            break;
            paramk = null;
            break label258;
          }
        }
        paramk = jdField_this.ldP;
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
  public static final class c
    implements a.a
  {
    public final void a(com.tencent.mm.plugin.appbrand.h.b.c paramc)
    {
      Object localObject3 = null;
      int j = 0;
      AppMethodBeat.i(139788);
      d.g.b.k.h(paramc, "device");
      label468:
      for (;;)
      {
        Object localObject4;
        com.tencent.mm.plugin.appbrand.h.b.b localb;
        Object localObject2;
        try
        {
          ac.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: ".concat(String.valueOf(paramc)));
          d.g.b.k.h(paramc, "$this$isRecentDevice");
          localObject4 = aw.eVz();
          Object localObject1 = paramc.bbJ();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jIG;
            if (((aw)localObject4).getLong((String)localObject1, 0L) == 0L) {
              continue;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            localObject1 = (Iterable)this.ldV.ldO;
            if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
              continue;
            }
            localObject1 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject4 = ((e)((Iterator)localObject1).next()).lcz.bbJ();
            if (localObject4 == null) {
              d.g.b.k.fOy();
            }
            localObject4 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject4).jIG;
            localb = paramc.bbJ();
            if (localb == null) {
              d.g.b.k.fOy();
            }
            if (!d.g.b.k.g(localObject4, localb.jIG)) {
              continue;
            }
            i = j;
            if (i != 0) {
              this.ldV.ldO.add(new e(paramc));
            }
            localObject1 = this.ldV.ldP;
            if (localObject1 != null) {
              ((d.g.a.a)localObject1).invoke();
            }
            localObject1 = new StringBuilder("onAddDevice: ");
            localObject4 = paramc.bbJ();
            paramc = localObject3;
            if (localObject4 != null) {
              paramc = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject4).jID;
            }
            ac.i("MicroMsg.VideoCast.VideoCastDeviceManager", paramc);
            AppMethodBeat.o(139788);
          }
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice", new Object[] { localException });
          continue;
          localObject2 = null;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
          localObject2 = (Iterable)this.ldV.ldN;
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
            localObject4 = ((e)((Iterator)localObject2).next()).lcz.bbJ();
            if (localObject4 == null) {
              d.g.b.k.fOy();
            }
            localObject4 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject4).jIG;
            localb = paramc.bbJ();
            if (localb == null) {
              d.g.b.k.fOy();
            }
          } while (!d.g.b.k.g(localObject4, localb.jIG));
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label468;
          }
          this.ldV.ldN.add(new e(paramc));
          break;
        }
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.h.b.c paramc)
    {
      AppMethodBeat.i(139789);
      d.g.b.k.h(paramc, "device");
      this.ldV.ldN.remove(new e(paramc));
      this.ldV.ldO.remove(new e(paramc));
      Object localObject = this.ldV.ldP;
      if (localObject != null) {
        ((d.g.a.a)localObject).invoke();
      }
      localObject = new StringBuilder("onRemoveDevice: ");
      paramc = paramc.bbJ();
      if (paramc != null) {}
      for (paramc = paramc.jID;; paramc = null)
      {
        ac.i("MicroMsg.VideoCast.VideoCastDeviceManager", paramc);
        AppMethodBeat.o(139789);
        return;
      }
    }
    
    public final void c(com.tencent.mm.plugin.appbrand.h.b.c paramc)
    {
      AppMethodBeat.i(139790);
      d.g.b.k.h(paramc, "device");
      try
      {
        ac.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice: ".concat(String.valueOf(paramc)));
        AppMethodBeat.o(139790);
        return;
      }
      catch (Exception paramc)
      {
        ac.e("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice", new Object[] { paramc });
        AppMethodBeat.o(139790);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
  public static final class d
    implements a.a
  {
    public final void a(com.tencent.mm.plugin.appbrand.h.b.c paramc)
    {
      AppMethodBeat.i(139791);
      if (paramc != null)
      {
        localObject1 = paramc.bbJ();
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jIG;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label32;
          }
        }
      }
      Object localObject1 = "";
      label32:
      ac.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: udn = ".concat(String.valueOf(localObject1)));
      if ((paramc == null) || (n.aD((CharSequence)localObject1)))
      {
        paramc = this.ldV.ldR;
        if (paramc != null)
        {
          paramc.ay(Boolean.FALSE);
          AppMethodBeat.o(139791);
          return;
        }
        AppMethodBeat.o(139791);
        return;
      }
      Object localObject2 = this.ldV.bmm().bbJ();
      if (localObject2 != null) {}
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jIG;; localObject2 = null)
      {
        if (d.g.b.k.g(localObject1, localObject2))
        {
          localObject1 = this.ldV.ldR;
          if (localObject1 != null) {
            ((d.g.a.b)localObject1).ay(Boolean.TRUE);
          }
          this.ldV.g(paramc);
        }
        AppMethodBeat.o(139791);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.h.b.c paramc)
    {
      AppMethodBeat.i(161190);
      ac.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onRemoveDevice");
      AppMethodBeat.o(161190);
    }
    
    public final void c(com.tencent.mm.plugin.appbrand.h.b.c paramc)
    {
      AppMethodBeat.i(161191);
      ac.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onUpdateDevice");
      AppMethodBeat.o(161191);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
  static final class e<T>
    implements rx.b.b<Long>
  {
    e(boolean paramBoolean) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
  static final class g<T>
    implements rx.b.b<Long>
  {
    g(j paramj) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.a.j
 * JD-Core Version:    0.7.0.1
 */