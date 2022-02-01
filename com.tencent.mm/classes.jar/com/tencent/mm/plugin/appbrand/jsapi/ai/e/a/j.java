package com.tencent.mm.plugin.appbrand.jsapi.ai.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.a.a;
import com.tencent.mm.sdk.platformtools.InetUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.n;
import kotlin.x;
import rx.d;
import rx.internal.a.f;
import rx.schedulers.Schedulers;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "", "()V", "<set-?>", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "currentSelectedDevice", "getCurrentSelectedDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "setCurrentSelectedDevice", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "currentSelectedDevice$delegate", "Lkotlin/properties/ReadWriteProperty;", "deviceDataChanged", "Lkotlin/Function0;", "", "getDeviceDataChanged", "()Lkotlin/jvm/functions/Function0;", "setDeviceDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "deviceSearchEventListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1;", "dummyMRDevice", "recentDevices", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "getRecentDevices", "()Ljava/util/ArrayList;", "reconnectCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isReconnectSuccess", "getReconnectCallback", "()Lkotlin/jvm/functions/Function1;", "setReconnectCallback", "(Lkotlin/jvm/functions/Function1;)V", "reconnectListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1;", "scannedDevices", "getScannedDevices", "subscription", "Lrx/subscriptions/CompositeSubscription;", "getSubscription", "()Lrx/subscriptions/CompositeSubscription;", "clear", "playError", "playSuccess", "prepareAndSearchDevice", "reconnect", "callback", "search", "searchReleaseTimer", "onTimeOut", "tryInit", "Companion", "luggage-xweb-ext_release"})
public final class j
{
  public static final j.b pNT;
  private final com.tencent.mm.plugin.appbrand.g.b.c pNK;
  private final kotlin.i.c pNL;
  final ArrayList<e> pNM;
  final ArrayList<e> pNN;
  kotlin.g.a.a<x> pNO;
  final rx.f.b pNP;
  kotlin.g.a.b<? super Boolean, x> pNQ;
  private final j.d pNR;
  private final j.c pNS;
  
  static
  {
    AppMethodBeat.i(139796);
    cMt = new n[] { (n)ab.a(new v(ab.bO(j.class), "currentSelectedDevice", "getCurrentSelectedDevice()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;")) };
    pNT = new j.b((byte)0);
    AppMethodBeat.o(139796);
  }
  
  public j()
  {
    AppMethodBeat.i(139807);
    this.pNK = new com.tencent.mm.plugin.appbrand.g.b.c(null);
    Object localObject = kotlin.i.a.aaBH;
    localObject = this.pNK;
    this.pNL = ((kotlin.i.c)new j.a(localObject, localObject, this));
    this.pNM = new ArrayList();
    this.pNN = new ArrayList();
    this.pNP = new rx.f.b();
    this.pNR = new j.d(this);
    this.pNS = new j.c(this);
    AppMethodBeat.o(139807);
  }
  
  private void bYL()
  {
    AppMethodBeat.i(139800);
    String str1 = com.tencent.luggage.k.h.SH();
    MMApplicationContext.getContext();
    String str2 = com.tencent.luggage.k.h.SG();
    if ((InetUtil.isIPv6Address(str1)) && (InetUtil.isIPv6Address(str2))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "searchDevice: selfIp = [%s], wifiIp = [%s], ipv6 = [%b]", new Object[] { str1, str2, Boolean.valueOf(bool) });
      this.pNP.b(d.a(TimeUnit.MILLISECONDS, Schedulers.computation()).iVI().a(com.tencent.mm.plugin.appbrand.g.d.a.bNb()).a((rx.b.b)new e(bool)));
      AppMethodBeat.o(139800);
      return;
    }
  }
  
  private final void bYM()
  {
    AppMethodBeat.i(139801);
    rx.j localj = d.a(new f(TimeUnit.SECONDS, Schedulers.computation())).a((rx.b.b)new g(this));
    this.pNP.b(localj);
    AppMethodBeat.o(139801);
  }
  
  private static boolean bYN()
  {
    AppMethodBeat.i(228390);
    try
    {
      com.tencent.mm.plugin.appbrand.g.a.a("MicroMsg.VideoCast.", (com.tencent.mm.plugin.appbrand.g.b)new j.h());
      com.tencent.mm.plugin.appbrand.g.c.h.bMX().bFu();
      com.tencent.mm.plugin.appbrand.g.c.c.bMR().bFu();
      AppMethodBeat.o(228390);
      return true;
    }
    catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala)
    {
      Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "prepareAndSearchDevice: RouterException = " + locala.getMessage());
      AppMethodBeat.o(228390);
    }
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.g.b.c bYJ()
  {
    AppMethodBeat.i(139797);
    com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)this.pNL.a(cMt[0]);
    AppMethodBeat.o(139797);
    return localc;
  }
  
  public final void bYK()
  {
    AppMethodBeat.i(139799);
    Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "prepare");
    if (!bYN())
    {
      AppMethodBeat.o(139799);
      return;
    }
    com.tencent.mm.plugin.appbrand.g.b.a.bMG().a((a.a)this.pNS);
    bYL();
    a(this);
    AppMethodBeat.o(139799);
  }
  
  public final void bYO()
  {
    AppMethodBeat.i(139805);
    Iterator localIterator = ((Iterable)this.pNM).iterator();
    e locale;
    label57:
    Object localObject2;
    label108:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.pMy.bMJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeD;
        localObject2 = bYJ().bMJ();
        if (localObject2 == null) {
          break label108;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).oeD;; localObject2 = null)
      {
        if (!p.h(localObject1, localObject2)) {
          break label111;
        }
        locale.jYF = false;
        locale.pMx = false;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label57;
      }
    }
    localIterator = ((Iterable)this.pNN).iterator();
    label164:
    label215:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.pMy.bMJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeD;
        localObject2 = bYJ().bMJ();
        if (localObject2 == null) {
          break label215;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).oeD;; localObject2 = null)
      {
        if (!p.h(localObject1, localObject2)) {
          break label218;
        }
        locale.jYF = false;
        locale.pMx = false;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label164;
      }
    }
    Object localObject1 = this.pNO;
    if (localObject1 != null)
    {
      ((kotlin.g.a.a)localObject1).invoke();
      AppMethodBeat.o(139805);
      return;
    }
    AppMethodBeat.o(139805);
  }
  
  public final void bYP()
  {
    AppMethodBeat.i(139806);
    Iterator localIterator = ((Iterable)this.pNM).iterator();
    e locale;
    label57:
    Object localObject2;
    label108:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.pMy.bMJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeD;
        localObject2 = bYJ().bMJ();
        if (localObject2 == null) {
          break label108;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).oeD;; localObject2 = null)
      {
        if (!p.h(localObject1, localObject2)) {
          break label111;
        }
        locale.jYF = false;
        locale.pMx = true;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label57;
      }
    }
    localIterator = ((Iterable)this.pNN).iterator();
    label164:
    label215:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.pMy.bMJ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeD;
        localObject2 = bYJ().bMJ();
        if (localObject2 == null) {
          break label215;
        }
      }
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).oeD;; localObject2 = null)
      {
        if (!p.h(localObject1, localObject2)) {
          break label218;
        }
        locale.jYF = false;
        locale.pMx = true;
        locale.isSelected = true;
        break;
        localObject1 = null;
        break label164;
      }
    }
    Object localObject1 = this.pNO;
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
      this.pNP.clear();
      this.pNN.clear();
      this.pNM.clear();
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
      localException.b((a.a)this.pNS);
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + localException.getMessage());
      AppMethodBeat.o(139804);
      return;
    }
    localException.b((a.a)this.pNR);
    localException.destroy();
    try
    {
      com.tencent.mm.plugin.appbrand.g.c.h.bMX().bMS();
      label153:
      com.tencent.mm.plugin.appbrand.g.c.c.bMR().bMS();
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
    p.k(paramc, "<set-?>");
    this.pNL.a(cMt[0], paramc);
    AppMethodBeat.o(139798);
  }
  
  public final void v(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(178860);
    p.k(paramb, "callback");
    try
    {
      this.pNP.clear();
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
        continue;
        if (bYN()) {
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
      localException.b((a.a)this.pNS);
      localException.b((a.a)this.pNR);
      localException.destroy();
      try
      {
        com.tencent.mm.plugin.appbrand.g.c.h.bMX().bMS();
        label164:
        com.tencent.mm.plugin.appbrand.g.c.c.bMR().bMS();
        continue;
        label174:
        this.pNQ = paramb;
        com.tencent.mm.plugin.appbrand.g.b.a.bMG().a((a.a)this.pNR);
        bYL();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
  static final class e<T>
    implements rx.b.b<Long>
  {
    e(boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
  static final class g<T>
    implements rx.b.b<Long>
  {
    g(j paramj) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.j
 * JD-Core Version:    0.7.0.1
 */