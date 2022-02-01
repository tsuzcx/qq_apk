package com.tencent.mm.plugin.appbrand.jsapi.aa.e.a;

import com.tencent.e.i;
import com.tencent.luggage.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.v;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "", "()V", "<set-?>", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "currentSelectedDevice", "getCurrentSelectedDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "setCurrentSelectedDevice", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "currentSelectedDevice$delegate", "Lkotlin/properties/ReadWriteProperty;", "deviceDataChanged", "Lkotlin/Function0;", "", "getDeviceDataChanged", "()Lkotlin/jvm/functions/Function0;", "setDeviceDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "deviceSearchEventListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1;", "dummyMRDevice", "recentDevices", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "getRecentDevices", "()Ljava/util/ArrayList;", "reconnectCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isReconnectSuccess", "getReconnectCallback", "()Lkotlin/jvm/functions/Function1;", "setReconnectCallback", "(Lkotlin/jvm/functions/Function1;)V", "reconnectListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1;", "scannedDevices", "getScannedDevices", "subscription", "Lrx/subscriptions/CompositeSubscription;", "getSubscription", "()Lrx/subscriptions/CompositeSubscription;", "clear", "playError", "playSuccess", "prepareAndSearchDevice", "reconnect", "callback", "search", "searchReleaseTimer", "onTimeOut", "tryInit", "Companion", "luggage-xweb-ext_release"})
public final class j
{
  public static final j.b kCD;
  d.g.a.b<? super Boolean, y> kCA;
  private final d kCB;
  private final c kCC;
  private final com.tencent.mm.plugin.appbrand.h.b.c kCu;
  private final d.i.c kCv;
  final ArrayList<e> kCw;
  final ArrayList<e> kCx;
  d.g.a.a<y> kCy;
  final rx.f.b kCz;
  
  static
  {
    AppMethodBeat.i(139796);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new o(w.bk(j.class), "currentSelectedDevice", "getCurrentSelectedDevice()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;")) };
    kCD = new j.b((byte)0);
    AppMethodBeat.o(139796);
  }
  
  public j()
  {
    AppMethodBeat.i(139807);
    this.kCu = new com.tencent.mm.plugin.appbrand.h.b.c(null);
    Object localObject = d.i.a.JhA;
    localObject = this.kCu;
    this.kCv = ((d.i.c)new a(localObject, localObject, this));
    this.kCw = new ArrayList();
    this.kCx = new ArrayList();
    this.kCz = new rx.f.b();
    this.kCB = new d(this);
    this.kCC = new c(this);
    AppMethodBeat.o(139807);
  }
  
  private void bfu()
  {
    AppMethodBeat.i(139800);
    String str1 = g.Ep();
    String str2 = g.aC(aj.getContext());
    if ((v.isIPv6Address(str1)) && (v.isIPv6Address(str2))) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "searchDevice: selfIp = [%s], wifiIp = [%s], ipv6 = [%b]", new Object[] { str1, str2, Boolean.valueOf(bool) });
      this.kCz.b(d.a(TimeUnit.MILLISECONDS, Schedulers.computation()).fNv().a(com.tencent.mm.plugin.appbrand.h.d.a.aVc()).a((rx.b.b)new e(bool)));
      AppMethodBeat.o(139800);
      return;
    }
  }
  
  private final void bfv()
  {
    AppMethodBeat.i(139801);
    rx.j localj = d.a(new f(TimeUnit.SECONDS, Schedulers.computation())).a((rx.b.b)new g(this));
    this.kCz.b(localj);
    AppMethodBeat.o(139801);
  }
  
  private static boolean bfw()
  {
    AppMethodBeat.i(195130);
    try
    {
      com.tencent.mm.plugin.appbrand.h.a.a("MicroMsg.VideoCast.", (com.tencent.mm.plugin.appbrand.h.b)new j.h());
      com.tencent.mm.plugin.appbrand.h.c.h.aUY().enable();
      com.tencent.mm.plugin.appbrand.h.c.c.aUT().enable();
      AppMethodBeat.o(195130);
      return true;
    }
    catch (com.tencent.mm.plugin.appbrand.h.c.c.a locala)
    {
      ad.e("MicroMsg.VideoCast.VideoCastDeviceManager", "prepareAndSearchDevice: RouterException = " + locala.getMessage());
      AppMethodBeat.o(195130);
    }
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.h.b.c bfs()
  {
    AppMethodBeat.i(139797);
    com.tencent.mm.plugin.appbrand.h.b.c localc = (com.tencent.mm.plugin.appbrand.h.b.c)this.kCv.a($$delegatedProperties[0]);
    AppMethodBeat.o(139797);
    return localc;
  }
  
  public final void bft()
  {
    AppMethodBeat.i(139799);
    ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "prepare");
    if (!bfw())
    {
      AppMethodBeat.o(139799);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.b.a.aUI().a((a.a)this.kCC);
    bfu();
    a(this);
    AppMethodBeat.o(139799);
  }
  
  public final void bfx()
  {
    AppMethodBeat.i(139805);
    Iterator localIterator = ((Iterable)this.kCw).iterator();
    e locale;
    label57:
    Object localObject2;
    label108:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.kBh.aUL();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jis;
        localObject2 = bfs().aUL();
        if (localObject2 == null) {
          break label108;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jis;; localObject2 = null)
      {
        if (!d.g.b.k.g(localObject1, localObject2)) {
          break label111;
        }
        locale.fZj = false;
        locale.kBg = false;
        locale.ira = true;
        break;
        localObject1 = null;
        break label57;
      }
    }
    localIterator = ((Iterable)this.kCx).iterator();
    label164:
    label215:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.kBh.aUL();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jis;
        localObject2 = bfs().aUL();
        if (localObject2 == null) {
          break label215;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jis;; localObject2 = null)
      {
        if (!d.g.b.k.g(localObject1, localObject2)) {
          break label218;
        }
        locale.fZj = false;
        locale.kBg = false;
        locale.ira = true;
        break;
        localObject1 = null;
        break label164;
      }
    }
    Object localObject1 = this.kCy;
    if (localObject1 != null)
    {
      ((d.g.a.a)localObject1).invoke();
      AppMethodBeat.o(139805);
      return;
    }
    AppMethodBeat.o(139805);
  }
  
  public final void bfy()
  {
    AppMethodBeat.i(139806);
    Iterator localIterator = ((Iterable)this.kCw).iterator();
    e locale;
    label57:
    Object localObject2;
    label108:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.kBh.aUL();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jis;
        localObject2 = bfs().aUL();
        if (localObject2 == null) {
          break label108;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jis;; localObject2 = null)
      {
        if (!d.g.b.k.g(localObject1, localObject2)) {
          break label111;
        }
        locale.fZj = false;
        locale.kBg = true;
        locale.ira = true;
        break;
        localObject1 = null;
        break label57;
      }
    }
    localIterator = ((Iterable)this.kCx).iterator();
    label164:
    label215:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.kBh.aUL();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jis;
        localObject2 = bfs().aUL();
        if (localObject2 == null) {
          break label215;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jis;; localObject2 = null)
      {
        if (!d.g.b.k.g(localObject1, localObject2)) {
          break label218;
        }
        locale.fZj = false;
        locale.kBg = true;
        locale.ira = true;
        break;
        localObject1 = null;
        break label164;
      }
    }
    Object localObject1 = this.kCy;
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
      this.kCz.clear();
      this.kCx.clear();
      this.kCw.clear();
      com.tencent.mm.plugin.appbrand.h.b.a locala = com.tencent.mm.plugin.appbrand.h.b.a.aUI();
      locala.aUK();
      d.g.b.k.g(locala, "deviceManager");
      Iterator localIterator = locala.aUJ().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.h.b.c localc = (com.tencent.mm.plugin.appbrand.h.b.c)localIterator.next();
        localc.aUP();
        localc.aUQ();
        localc.a(null);
      }
      localException.b((a.a)this.kCC);
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + localException.getMessage());
      AppMethodBeat.o(139804);
      return;
    }
    localException.b((a.a)this.kCB);
    localException.destroy();
    try
    {
      com.tencent.mm.plugin.appbrand.h.c.h.aUY().disable();
      label153:
      com.tencent.mm.plugin.appbrand.h.c.c.aUT().disable();
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
    this.kCv.a($$delegatedProperties[0], paramc);
    AppMethodBeat.o(139798);
  }
  
  public final void p(d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(178860);
    d.g.b.k.h(paramb, "callback");
    try
    {
      this.kCz.clear();
      com.tencent.mm.plugin.appbrand.h.b.a locala = com.tencent.mm.plugin.appbrand.h.b.a.aUI();
      locala.aUK();
      d.g.b.k.g(locala, "deviceManager");
      Iterator localIterator = locala.aUJ().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.h.b.c localc = (com.tencent.mm.plugin.appbrand.h.b.c)localIterator.next();
        localc.aUP();
        localc.aUQ();
        localc.a(null);
        continue;
        if (bfw()) {
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
      localException.b((a.a)this.kCC);
      localException.b((a.a)this.kCB);
      localException.destroy();
      try
      {
        com.tencent.mm.plugin.appbrand.h.c.h.aUY().disable();
        label164:
        com.tencent.mm.plugin.appbrand.h.c.c.aUT().disable();
        continue;
        label174:
        this.kCA = paramb;
        com.tencent.mm.plugin.appbrand.h.b.a.aUI().a((a.a)this.kCB);
        bfu();
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
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
      if (((d.g.b.k.g((com.tencent.mm.plugin.appbrand.h.b.c)paramc1, paramk) ^ true)) && (paramk.aUL() != null))
      {
        d.g.b.k.h(paramk, "$this$saveDevice");
        paramc1 = ax.eGe();
        com.tencent.e.h.Iye.aP((Runnable)new k.a(paramk, paramc1));
        paramc2 = ((Iterable)jdField_this.kCw).iterator();
        e locale;
        label133:
        label187:
        label190:
        while (paramc2.hasNext())
        {
          locale = (e)paramc2.next();
          locale.ira = false;
          locale.fZj = false;
          paramk = locale.kBh.aUL();
          if (paramk != null)
          {
            paramk = paramk.jis;
            paramc1 = jdField_this.bfs().aUL();
            if (paramc1 == null) {
              break label187;
            }
          }
          for (paramc1 = paramc1.jis;; paramc1 = null)
          {
            if (!d.g.b.k.g(paramk, paramc1)) {
              break label190;
            }
            locale.fZj = true;
            locale.kBg = false;
            locale.ira = true;
            break;
            paramk = null;
            break label133;
          }
        }
        paramc2 = ((Iterable)jdField_this.kCx).iterator();
        label258:
        label312:
        label315:
        while (paramc2.hasNext())
        {
          locale = (e)paramc2.next();
          locale.ira = false;
          locale.fZj = false;
          paramk = locale.kBh.aUL();
          if (paramk != null)
          {
            paramk = paramk.jis;
            paramc1 = jdField_this.bfs().aUL();
            if (paramc1 == null) {
              break label312;
            }
          }
          for (paramc1 = paramc1.jis;; paramc1 = null)
          {
            if (!d.g.b.k.g(paramk, paramc1)) {
              break label315;
            }
            locale.fZj = true;
            locale.kBg = false;
            locale.ira = true;
            break;
            paramk = null;
            break label258;
          }
        }
        paramk = jdField_this.kCy;
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
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
          ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: ".concat(String.valueOf(paramc)));
          d.g.b.k.h(paramc, "$this$isRecentDevice");
          localObject4 = ax.eGe();
          Object localObject1 = paramc.aUL();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jis;
            if (((ax)localObject4).getLong((String)localObject1, 0L) == 0L) {
              continue;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            localObject1 = (Iterable)this.kCE.kCx;
            if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
              continue;
            }
            localObject1 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject4 = ((e)((Iterator)localObject1).next()).kBh.aUL();
            if (localObject4 == null) {
              d.g.b.k.fvU();
            }
            localObject4 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject4).jis;
            localb = paramc.aUL();
            if (localb == null) {
              d.g.b.k.fvU();
            }
            if (!d.g.b.k.g(localObject4, localb.jis)) {
              continue;
            }
            i = j;
            if (i != 0) {
              this.kCE.kCx.add(new e(paramc));
            }
            localObject1 = this.kCE.kCy;
            if (localObject1 != null) {
              ((d.g.a.a)localObject1).invoke();
            }
            localObject1 = new StringBuilder("onAddDevice: ");
            localObject4 = paramc.aUL();
            paramc = localObject3;
            if (localObject4 != null) {
              paramc = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject4).jip;
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
          localObject2 = (Iterable)this.kCE.kCw;
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
            localObject4 = ((e)((Iterator)localObject2).next()).kBh.aUL();
            if (localObject4 == null) {
              d.g.b.k.fvU();
            }
            localObject4 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject4).jis;
            localb = paramc.aUL();
            if (localb == null) {
              d.g.b.k.fvU();
            }
          } while (!d.g.b.k.g(localObject4, localb.jis));
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label468;
          }
          this.kCE.kCw.add(new e(paramc));
          break;
        }
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.h.b.c paramc)
    {
      AppMethodBeat.i(139789);
      d.g.b.k.h(paramc, "device");
      this.kCE.kCw.remove(new e(paramc));
      this.kCE.kCx.remove(new e(paramc));
      Object localObject = this.kCE.kCy;
      if (localObject != null) {
        ((d.g.a.a)localObject).invoke();
      }
      localObject = new StringBuilder("onRemoveDevice: ");
      paramc = paramc.aUL();
      if (paramc != null) {}
      for (paramc = paramc.jip;; paramc = null)
      {
        ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", paramc);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
  public static final class d
    implements a.a
  {
    public final void a(com.tencent.mm.plugin.appbrand.h.b.c paramc)
    {
      AppMethodBeat.i(139791);
      if (paramc != null)
      {
        localObject1 = paramc.aUL();
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject1).jis;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label32;
          }
        }
      }
      Object localObject1 = "";
      label32:
      ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: udn = ".concat(String.valueOf(localObject1)));
      if ((paramc == null) || (n.aC((CharSequence)localObject1)))
      {
        paramc = this.kCE.kCA;
        if (paramc != null)
        {
          paramc.aA(Boolean.FALSE);
          AppMethodBeat.o(139791);
          return;
        }
        AppMethodBeat.o(139791);
        return;
      }
      Object localObject2 = this.kCE.bfs().aUL();
      if (localObject2 != null) {}
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jis;; localObject2 = null)
      {
        if (d.g.b.k.g(localObject1, localObject2))
        {
          localObject1 = this.kCE.kCA;
          if (localObject1 != null) {
            ((d.g.a.b)localObject1).aA(Boolean.TRUE);
          }
          this.kCE.g(paramc);
        }
        AppMethodBeat.o(139791);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.h.b.c paramc)
    {
      AppMethodBeat.i(161190);
      ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onRemoveDevice");
      AppMethodBeat.o(161190);
    }
    
    public final void c(com.tencent.mm.plugin.appbrand.h.b.c paramc)
    {
      AppMethodBeat.i(161191);
      ad.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onUpdateDevice");
      AppMethodBeat.o(161191);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
  static final class e<T>
    implements rx.b.b<Long>
  {
    e(boolean paramBoolean) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
  static final class g<T>
    implements rx.b.b<Long>
  {
    g(j paramj) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.j
 * JD-Core Version:    0.7.0.1
 */