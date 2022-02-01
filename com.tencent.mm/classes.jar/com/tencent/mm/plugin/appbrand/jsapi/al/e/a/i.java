package com.tencent.mm.plugin.appbrand.jsapi.al.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.a.a;
import com.tencent.mm.plugin.appbrand.g.c.c.b;
import com.tencent.mm.sdk.platformtools.InetUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.z;
import kotlin.l.o;
import kotlin.n.n;
import rx.d;
import rx.internal.a.g;
import rx.internal.a.m;
import rx.schedulers.Schedulers;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "", "()V", "<set-?>", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "currentSelectedDevice", "getCurrentSelectedDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "setCurrentSelectedDevice", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "currentSelectedDevice$delegate", "Lkotlin/properties/ReadWriteProperty;", "deviceDataChanged", "Lkotlin/Function0;", "", "getDeviceDataChanged", "()Lkotlin/jvm/functions/Function0;", "setDeviceDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "deviceSearchEventListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1;", "dummyMRDevice", "recentDevices", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "getRecentDevices", "()Ljava/util/ArrayList;", "reconnectCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isReconnectSuccess", "getReconnectCallback", "()Lkotlin/jvm/functions/Function1;", "setReconnectCallback", "(Lkotlin/jvm/functions/Function1;)V", "reconnectListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1;", "scannedDevices", "getScannedDevices", "subscription", "Lrx/subscriptions/CompositeSubscription;", "getSubscription", "()Lrx/subscriptions/CompositeSubscription;", "clear", "playError", "playSuccess", "prepareAndSearchDevice", "reconnect", "callback", "search", "searchReleaseTimer", "onTimeOut", "tryInit", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a sSo;
  private final com.tencent.mm.plugin.appbrand.g.b.c sSp;
  private final kotlin.i.c sSq;
  final ArrayList<e> sSr;
  final ArrayList<e> sSs;
  kotlin.g.a.a<ah> sSt;
  final rx.f.b sSu;
  kotlin.g.a.b<? super Boolean, ah> sSv;
  private final c sSw;
  final b sSx;
  
  static
  {
    AppMethodBeat.i(139796);
    aYe = new o[] { (o)ai.a((z)new aa(i.class, "currentSelectedDevice", "getCurrentSelectedDevice()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", 0)) };
    sSo = new i.a((byte)0);
    AppMethodBeat.o(139796);
  }
  
  public i()
  {
    AppMethodBeat.i(139807);
    this.sSp = new com.tencent.mm.plugin.appbrand.g.b.c(null);
    Object localObject = kotlin.i.a.aixi;
    localObject = this.sSp;
    this.sSq = ((kotlin.i.c)new e(localObject, localObject, this));
    this.sSr = new ArrayList();
    this.sSs = new ArrayList();
    this.sSu = new rx.f.b();
    this.sSw = new c(this);
    this.sSx = new b(this);
    AppMethodBeat.o(139807);
  }
  
  private static final void a(i parami, Long paramLong)
  {
    AppMethodBeat.i(327208);
    s.u(parami, "this$0");
    Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "search time out");
    parami.sSu.clear();
    AppMethodBeat.o(327208);
  }
  
  private static final void a(boolean paramBoolean, Long paramLong)
  {
    AppMethodBeat.i(327203);
    com.tencent.mm.plugin.appbrand.g.c.h.cnm().iP(paramBoolean);
    Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "prepareAndSearchDevice: searching...");
    AppMethodBeat.o(327203);
  }
  
  static boolean czc()
  {
    AppMethodBeat.i(327197);
    try
    {
      com.tencent.mm.plugin.appbrand.g.a.a("MicroMsg.VideoCast.", (com.tencent.mm.plugin.appbrand.g.b)new i.f());
      com.tencent.mm.plugin.appbrand.g.c.h.cnm().ceR();
      c.b.cnh().ceR();
      AppMethodBeat.o(327197);
      return true;
    }
    catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala)
    {
      Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", s.X("prepareAndSearchDevice: RouterException = ", locala.getMessage()));
      AppMethodBeat.o(327197);
    }
    return false;
  }
  
  public final void W(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(178860);
    s.u(paramb, "callback");
    try
    {
      this.sSu.clear();
      com.tencent.mm.plugin.appbrand.g.b.a locala = com.tencent.mm.plugin.appbrand.g.b.a.cmW();
      locala.rib = true;
      Iterator localIterator = locala.cmX().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)localIterator.next();
        localc.cnc();
        localc.cnd();
        localc.a(null);
        continue;
        if (czc()) {
          break label158;
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", s.X("Error happen while cleaning up ", localException.getMessage()));
    }
    for (;;)
    {
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: not enableRouter");
      AppMethodBeat.o(178860);
      return;
      localException.b((a.a)this.sSx);
      localException.b((a.a)this.sSw);
      localException.destroy();
      try
      {
        com.tencent.mm.plugin.appbrand.g.c.h.cnm().cng();
        label148:
        c.b.cnh().cng();
        continue;
        label158:
        this.sSv = paramb;
        com.tencent.mm.plugin.appbrand.g.b.a.cmW().a((a.a)this.sSw);
        czb();
        a(this);
        AppMethodBeat.o(178860);
        return;
      }
      catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala1)
      {
        break label148;
      }
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(139804);
    try
    {
      this.sSu.clear();
      this.sSs.clear();
      this.sSr.clear();
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
      localException.b((a.a)this.sSx);
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", s.X("Error happen while cleaning up ", localException.getMessage()));
      AppMethodBeat.o(139804);
      return;
    }
    localException.b((a.a)this.sSw);
    localException.destroy();
    try
    {
      com.tencent.mm.plugin.appbrand.g.c.h.cnm().cng();
      label137:
      c.b.cnh().cng();
      AppMethodBeat.o(139804);
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.g.c.c.a locala1)
    {
      break label137;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.g.b.c cza()
  {
    AppMethodBeat.i(139797);
    com.tencent.mm.plugin.appbrand.g.b.c localc = (com.tencent.mm.plugin.appbrand.g.b.c)this.sSq.a(aYe[0]);
    AppMethodBeat.o(139797);
    return localc;
  }
  
  public final void czb()
  {
    AppMethodBeat.i(139800);
    String str1 = com.tencent.luggage.l.h.atl();
    MMApplicationContext.getContext();
    String str2 = com.tencent.luggage.l.h.atk();
    if ((InetUtil.isIPv6Address(str1)) && (InetUtil.isIPv6Address(str2))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "searchDevice: selfIp = [%s], wifiIp = [%s], ipv6 = [%b]", new Object[] { str1, str2, Boolean.valueOf(bool) });
      this.sSu.b(d.a(new g(0L, 1000L, TimeUnit.MILLISECONDS, Schedulers.computation())).a(new m()).a(com.tencent.mm.plugin.appbrand.g.d.a.cnq()).a(new i..ExternalSyntheticLambda1(bool)));
      AppMethodBeat.o(139800);
      return;
    }
  }
  
  public final void czd()
  {
    AppMethodBeat.i(139805);
    Iterator localIterator = ((Iterable)this.sSr).iterator();
    e locale;
    label54:
    Object localObject2;
    label105:
    label111:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.sRn.cmY();
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = cza().cmY();
        if (localObject2 != null) {
          break label105;
        }
      }
      for (localObject2 = null;; localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).rii)
      {
        if (!s.p(localObject1, localObject2)) {
          break label111;
        }
        locale.myA = false;
        locale.sRo = false;
        locale.isSelected = true;
        break;
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rii;
        break label54;
      }
    }
    localIterator = ((Iterable)this.sSs).iterator();
    label161:
    label212:
    label218:
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.sRn.cmY();
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = cza().cmY();
        if (localObject2 != null) {
          break label212;
        }
      }
      for (localObject2 = null;; localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).rii)
      {
        if (!s.p(localObject1, localObject2)) {
          break label218;
        }
        locale.myA = false;
        locale.sRo = false;
        locale.isSelected = true;
        break;
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rii;
        break label161;
      }
    }
    Object localObject1 = this.sSt;
    if (localObject1 != null) {
      ((kotlin.g.a.a)localObject1).invoke();
    }
    AppMethodBeat.o(139805);
  }
  
  public final void g(com.tencent.mm.plugin.appbrand.g.b.c paramc)
  {
    AppMethodBeat.i(139798);
    s.u(paramc, "<set-?>");
    this.sSq.a(aYe[0], paramc);
    AppMethodBeat.o(139798);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a.a
  {
    b(i parami) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      Object localObject3 = null;
      int j = 0;
      AppMethodBeat.i(139788);
      s.u(paramc, "device");
      try
      {
        Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", s.X("onAddDevice: ", paramc));
        s.u(paramc, "<this>");
        localObject4 = MultiProcessMMKV.getSingleDefault();
        Object localObject1 = paramc.cmY();
        if (localObject1 == null)
        {
          localObject1 = null;
          if (((MultiProcessMMKV)localObject4).getLong((String)localObject1, 0L) == 0L) {
            break label284;
          }
          i = 1;
          if (i == 0) {
            break label294;
          }
          localObject1 = (Iterable)this.sSy.sSs;
          if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
            break label289;
          }
          localObject1 = ((Iterable)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject4 = ((e)((Iterator)localObject1).next()).sRn.cmY();
            s.checkNotNull(localObject4);
            localObject4 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject4).rii;
            localb = paramc.cmY();
            s.checkNotNull(localb);
          } while (!s.p(localObject4, localb.rii));
          i = j;
          if (i != 0) {
            this.sSy.sSs.add(new e(paramc));
          }
          localObject1 = this.sSy.sSt;
          if (localObject1 != null) {
            ((kotlin.g.a.a)localObject1).invoke();
          }
          paramc = paramc.cmY();
          if (paramc != null) {
            break label433;
          }
          paramc = localObject3;
          Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", s.X("onAddDevice: ", paramc));
          AppMethodBeat.o(139788);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject4;
          com.tencent.mm.plugin.appbrand.g.b.b localb;
          Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice", new Object[] { localException });
          continue;
          Object localObject2 = localException.rii;
          continue;
          label284:
          int i = 0;
          continue;
          label289:
          i = 1;
          continue;
          label294:
          localObject2 = (Iterable)this.sSy.sSr;
          if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
          {
            localObject2 = ((Iterable)localObject2).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject4 = ((e)((Iterator)localObject2).next()).sRn.cmY();
              s.checkNotNull(localObject4);
              localObject4 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject4).rii;
              localb = paramc.cmY();
              s.checkNotNull(localb);
            } while (!s.p(localObject4, localb.rii));
          }
          for (i = 0; i != 0; i = 1)
          {
            this.sSy.sSr.add(new e(paramc));
            break;
          }
          label433:
          paramc = paramc.rif;
        }
      }
    }
    
    public final void b(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139789);
      s.u(paramc, "device");
      this.sSy.sSr.remove(new e(paramc));
      this.sSy.sSs.remove(new e(paramc));
      kotlin.g.a.a locala = this.sSy.sSt;
      if (locala != null) {
        locala.invoke();
      }
      paramc = paramc.cmY();
      if (paramc == null) {}
      for (paramc = null;; paramc = paramc.rif)
      {
        Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", s.X("onRemoveDevice: ", paramc));
        AppMethodBeat.o(139789);
        return;
      }
    }
    
    public final void c(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139790);
      s.u(paramc, "device");
      try
      {
        Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", s.X("onUpdateDevice: ", paramc));
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a.a
  {
    c(i parami) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.g.b.c paramc)
    {
      AppMethodBeat.i(139791);
      Object localObject1;
      if (paramc == null) {
        localObject1 = "";
      }
      for (;;)
      {
        Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", s.X("onAddDevice: udn = ", localObject1));
        if ((paramc != null) && (!n.bp((CharSequence)localObject1))) {
          break;
        }
        paramc = this.sSy.sSv;
        if (paramc != null) {
          paramc.invoke(Boolean.FALSE);
        }
        AppMethodBeat.o(139791);
        return;
        localObject1 = paramc.cmY();
        if (localObject1 == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).rii;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
      }
      Object localObject2 = this.sSy.cza().cmY();
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).rii)
      {
        if (s.p(localObject1, localObject2))
        {
          localObject1 = this.sSy.sSv;
          if (localObject1 != null) {
            ((kotlin.g.a.b)localObject1).invoke(Boolean.TRUE);
          }
          this.sSy.g(paramc);
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
  
  @Metadata(d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class e
    extends kotlin.i.b<com.tencent.mm.plugin.appbrand.g.b.c>
  {
    public e(Object paramObject1, Object paramObject2, i parami)
    {
      super();
    }
    
    public final void a(o<?> paramo, com.tencent.mm.plugin.appbrand.g.b.c paramc1, com.tencent.mm.plugin.appbrand.g.b.c paramc2)
    {
      AppMethodBeat.i(327200);
      s.u(paramo, "property");
      paramo = (com.tencent.mm.plugin.appbrand.g.b.c)paramc2;
      if ((!s.p((com.tencent.mm.plugin.appbrand.g.b.c)paramc1, paramo)) && (paramo.cmY() != null))
      {
        j.h(paramo);
        paramc2 = ((Iterable)jdField_this.sSr).iterator();
        e locale;
        label155:
        label161:
        while (paramc2.hasNext())
        {
          locale = (e)paramc2.next();
          locale.isSelected = false;
          locale.myA = false;
          paramo = locale.sRn.cmY();
          if (paramo == null)
          {
            paramo = null;
            label101:
            paramc1 = jdField_this.cza().cmY();
            if (paramc1 != null) {
              break label155;
            }
          }
          for (paramc1 = null;; paramc1 = paramc1.rii)
          {
            if (!s.p(paramo, paramc1)) {
              break label161;
            }
            locale.myA = true;
            locale.sRo = false;
            locale.isSelected = true;
            break;
            paramo = paramo.rii;
            break label101;
          }
        }
        paramc2 = ((Iterable)jdField_this.sSs).iterator();
        label280:
        label286:
        while (paramc2.hasNext())
        {
          locale = (e)paramc2.next();
          locale.isSelected = false;
          locale.myA = false;
          paramo = locale.sRn.cmY();
          if (paramo == null)
          {
            paramo = null;
            label226:
            paramc1 = jdField_this.cza().cmY();
            if (paramc1 != null) {
              break label280;
            }
          }
          for (paramc1 = null;; paramc1 = paramc1.rii)
          {
            if (!s.p(paramo, paramc1)) {
              break label286;
            }
            locale.myA = true;
            locale.sRo = false;
            locale.isSelected = true;
            break;
            paramo = paramo.rii;
            break label226;
          }
        }
        paramo = jdField_this.sSt;
        if (paramo != null) {
          paramo.invoke();
        }
      }
      AppMethodBeat.o(327200);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.a.i
 * JD-Core Version:    0.7.0.1
 */