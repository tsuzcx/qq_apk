package com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.nfc.tech.TagTechnology;
import android.util.ArrayMap;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Ljava/lang/String;Landroid/app/Activity;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getActivity", "()Landroid/app/Activity;", "activityEventInterceptor", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "connectedTech", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "kotlin.jvm.PlatformType", "", "isActivityEventInterceptorAdded", "isLifeCycleListenerAdded", "isNFCDiscovering", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isNFCDiscoverySticky", "lifeCycleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1;", "nfcTagDiscoveredCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "id", "", "techs", "Landroid/nfc/NdefMessage;", "ndefMessages", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCTagDiscoveredCallback;", "getNfcTagDiscoveredCallback", "()Lkotlin/jvm/functions/Function3;", "setNfcTagDiscoveredCallback", "(Lkotlin/jvm/functions/Function3;)V", "pendingIntent", "Landroid/app/PendingIntent;", "requireForegroundDispatch", "getRequireForegroundDispatch", "()Z", "setRequireForegroundDispatch", "(Z)V", "tag", "Landroid/nfc/Tag;", "addActivityEventInterceptorOnce", "addLifeCycleListenerOnce", "close", "techName", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "connect", "execTechLogic", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execTechLogicAsync", "getMaxTransceiveLength", "", "getNFCTech", "T", "getTag", "getTagTechnology", "Landroid/nfc/tech/TagTechnology;", "nfcTech", "tagSnapshot", "isConnected", "removeActivityEventInterceptorIfNecessary", "removeLifeCycleListenerIfNecessary", "setTimeout", "timeoutMs", "startNFCDiscovery", "stopNFCDiscovery", "transceive", "reqData", "tryDispatchNfcTagDiscovered", "intent", "tryParseMessageMap", "writeNdefMessage", "message", "messageToString", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public class c
{
  private static final Map<String, c> ldr;
  private static final IntentFilter[] lds;
  private static final String[][] ldt;
  private static c.a.a ldu;
  public static final a ldv;
  final Activity activity;
  public final String appId;
  protected final com.tencent.mm.plugin.appbrand.jsapi.c kmw;
  private volatile boolean ldh;
  public volatile d.g.a.q<? super byte[], ? super List<String>, ? super List<NdefMessage>, z> ldi;
  private boolean ldj;
  private final d.g.a.b<Intent, Boolean> ldk;
  private final AtomicBoolean ldl;
  private boolean ldm;
  private boolean ldn;
  private final i ldo;
  private volatile Tag ldp;
  private final Set<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b> ldq;
  private final PendingIntent pendingIntent;
  
  static
  {
    AppMethodBeat.i(183681);
    ldv = new a((byte)0);
    ldr = (Map)new ConcurrentHashMap();
    Object localObject = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
    try
    {
      ((IntentFilter)localObject).addDataType("*/*");
      lds = new IntentFilter[] { localObject };
      localObject = NfcA.class.getName();
      String[] arrayOfString = { NfcB.class.getName() };
      String str1 = IsoDep.class.getName();
      String str2 = NfcF.class.getName();
      String str3 = NfcV.class.getName();
      String str4 = MifareClassic.class.getName();
      String str5 = MifareUltralight.class.getName();
      String str6 = Ndef.class.getName();
      ldt = (String[][])new String[][] { { localObject }, arrayOfString, { str1 }, { str2 }, { str3 }, { str4 }, { str5 }, { str6 } };
      ldu = (c.a.a)new b();
      AppMethodBeat.o(183681);
      return;
    }
    catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
    {
      for (;;)
      {
        ae.w("MicroMsg.AppBrand.NFCReadWriteManager", "addDataType failed");
      }
    }
  }
  
  public c(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(208222);
    this.appId = paramString;
    this.activity = paramActivity;
    this.kmw = paramc;
    paramString = new Intent((Context)this.activity, this.activity.getClass()).addFlags(536870912);
    this.pendingIntent = PendingIntent.getActivity((Context)this.activity, 0, paramString, 0);
    this.ldk = ((d.g.a.b)new c(this));
    this.ldl = new AtomicBoolean(false);
    this.ldo = new i(this);
    this.ldq = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    com.tencent.mm.plugin.appbrand.h.a(this.appId, (h.c)new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(183669);
        super.onDestroy();
        ae.d("MicroMsg.AppBrand.NFCReadWriteManager", "onDestroy");
        c.bmC().remove(this.ldw.appId);
        AppMethodBeat.o(183669);
      }
    });
    AppMethodBeat.o(208222);
  }
  
  private static List<NdefMessage> F(Intent paramIntent)
  {
    AppMethodBeat.i(208221);
    ae.d("MicroMsg.AppBrand.NFCReadWriteManager", "tryParseMessageMap");
    paramIntent = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
    if (paramIntent != null)
    {
      Object localObject = new StringBuilder("tryDispatchNdefMessagesRead, rawMessages: ");
      String str = Arrays.toString(paramIntent);
      p.g(str, "java.util.Arrays.toString(this)");
      ae.i("MicroMsg.AppBrand.NFCReadWriteManager", str);
      localObject = (Collection)new ArrayList(paramIntent.length);
      int j = paramIntent.length;
      int i = 0;
      while (i < j)
      {
        str = paramIntent[i];
        if (str == null)
        {
          paramIntent = new v("null cannot be cast to non-null type android.nfc.NdefMessage");
          AppMethodBeat.o(208221);
          throw paramIntent;
        }
        ((Collection)localObject).add((NdefMessage)str);
        i += 1;
      }
      paramIntent = (List)localObject;
      AppMethodBeat.o(208221);
      return paramIntent;
    }
    AppMethodBeat.o(208221);
    return null;
  }
  
  public static final boolean u(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(208224);
    boolean bool = a.u(paramc);
    AppMethodBeat.o(208224);
    return bool;
  }
  
  public void E(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(208220);
    p.h(paramIntent, "intent");
    ae.d("MicroMsg.AppBrand.NFCReadWriteManager", "tryDispatchNfcTagDiscovered");
    d.g.a.q localq = this.ldi;
    if (localq != null)
    {
      Object localObject1 = this.ldp;
      if (localObject1 != null)
      {
        localObject1 = ((Tag)localObject1).getTechList();
        if (localObject1 != null)
        {
          Object localObject3 = (Collection)new ArrayList();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            localObject4 = localObject1[i];
            localObject5 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldV;
            localObject4 = (String)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bmF().get(localObject4);
            if (localObject4 != null) {
              ((Collection)localObject3).add(localObject4);
            }
            i += 1;
          }
          localObject3 = (List)localObject3;
          Object localObject4 = paramIntent.getByteArrayExtra("android.nfc.extra.ID");
          Object localObject5 = new StringBuilder("tryDispatchNfcTagDiscovered, id: ");
          if (localObject4 != null)
          {
            localObject1 = Arrays.toString((byte[])localObject4);
            p.g(localObject1, "java.util.Arrays.toString(this)");
            ae.i("MicroMsg.AppBrand.NFCReadWriteManager", (String)localObject1 + ", techs: " + localObject3);
            if (((Collection)localObject3).isEmpty()) {
              break label275;
            }
          }
          label275:
          for (i = 1;; i = 0)
          {
            if (i != 0)
            {
              localObject1 = localObject2;
              if (((List)localObject3).contains(com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldO.lcw)) {
                localObject1 = F(paramIntent);
              }
              localq.d(localObject4, localObject3, localObject1);
            }
            AppMethodBeat.o(208220);
            return;
            localObject1 = null;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(208220);
  }
  
  public final void a(final NdefMessage paramNdefMessage, final d.g.a.b<? super e<z>, z> paramb)
  {
    AppMethodBeat.i(183679);
    p.h(paramNdefMessage, "message");
    p.h(paramb, "callback");
    ae.d("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage, message: ".concat(String.valueOf(paramNdefMessage)));
    com.tencent.e.h.MqF.f((Runnable)new n(this, paramb, paramNdefMessage), "NFC-IO");
    AppMethodBeat.o(183679);
  }
  
  public void gN(boolean paramBoolean)
  {
    this.ldh = paramBoolean;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion;", "", "()V", "METHOD_NAME_GET", "", "METHOD_NAME_GET_MAX_TRANSCEIVE_LENGTH", "METHOD_NAME_SET_TIMEOUT", "METHOD_NAME_TRANSCEIVE", "NFC_IO_LOOP_TAG", "TAG", "appId2ManagerMap", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "factory", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "getFactory", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "setFactory", "(Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;)V", "intentFiltersArray", "", "Landroid/content/IntentFilter;", "[Landroid/content/IntentFilter;", "techListsArray", "kotlin.jvm.PlatformType", "[[Ljava/lang/String;", "get", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isNFCUsing", "", "manager", "appId", "IFactory", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a
  {
    public static void b(a parama)
    {
      AppMethodBeat.i(208212);
      p.h(parama, "<set-?>");
      c.a(parama);
      AppMethodBeat.o(208212);
    }
    
    private static boolean j(c paramc)
    {
      AppMethodBeat.i(208214);
      if (c.a(paramc).get())
      {
        ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, isDiscovering, using");
        AppMethodBeat.o(208214);
        return true;
      }
      paramc = c.h(paramc);
      p.g(paramc, "manager.connectedTech");
      if (!((Collection)paramc).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, connected, using");
        AppMethodBeat.o(208214);
        return true;
      }
      ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, not using");
      AppMethodBeat.o(208214);
      return false;
    }
    
    public static boolean u(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
    {
      AppMethodBeat.i(208213);
      p.h(paramc, "component");
      paramc = w(paramc);
      if (paramc == null)
      {
        ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, manager is null, not using");
        AppMethodBeat.o(208213);
        return false;
      }
      boolean bool = j(paramc);
      AppMethodBeat.o(208213);
      return bool;
    }
    
    public static c w(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
    {
      AppMethodBeat.i(183670);
      p.h(paramc, "component");
      Object localObject2 = (c)c.bmC().get(paramc.getAppId());
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.sdk.f.a.jw(paramc.getContext());
        if (localObject1 != null)
        {
          localObject2 = c.ldv;
          localObject2 = c.bmD();
          String str = paramc.getAppId();
          p.g(str, "component.appId");
          p.g(localObject1, "activity");
          localObject1 = ((a)localObject2).a(str, (Activity)localObject1, paramc);
          localObject2 = c.bmC();
          paramc = paramc.getAppId();
          p.g(paramc, "component.appId");
          ((Map)localObject2).put(paramc, localObject1);
          AppMethodBeat.o(183670);
          return localObject1;
        }
        localObject1 = null;
      }
      AppMethodBeat.o(183670);
      return localObject1;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"})
    public static abstract interface a
    {
      public abstract c a(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.c paramc);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$factory$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class b
    implements c.a.a
  {
    public final c a(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
    {
      AppMethodBeat.i(208211);
      p.h(paramString, "appId");
      p.h(paramActivity, "activity");
      p.h(paramc, "component");
      paramString = new c(paramString, paramActivity, paramc);
      AppMethodBeat.o(208211);
      return paramString;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "intent", "Landroid/content/Intent;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.b<Intent, Boolean>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(208215);
      Object localObject1 = this.ldw;
      Object localObject2 = this.gll;
      localObject1 = c.e((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(208215);
        return;
      }
      localObject2 = this.ldx;
      d.g.a.b localb = this.gll;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldV;
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bmE().get(localObject2);
      if (localObject2 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(208215);
        return;
      }
      if (!c.h(this.ldw).contains(localObject2))
      {
        this.gll.invoke(new e.a(13023, "Tech has not connected"));
        AppMethodBeat.o(208215);
        return;
      }
      localb = this.gll;
      TagTechnology localTagTechnology;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject2).ldR)).A("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(208215);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localb.invoke(new e.a(13015, "unavailable tech"));
        for (localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(208215);
          return;
        }
      }
      try
      {
        localTagTechnology.close();
        c.h(this.ldw).remove(localObject2);
        this.gll.invoke(new e.b(z.Nhr));
        AppMethodBeat.o(208215);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "close failed since ".concat(String.valueOf(localException2)));
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class e
    implements Runnable
  {
    public e(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(208216);
      Object localObject1 = this.ldw;
      Object localObject2 = this.gll;
      localObject1 = c.e((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(208216);
        return;
      }
      localObject2 = this.ldx;
      d.g.a.b localb = this.gll;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldV;
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bmE().get(localObject2);
      if (localObject2 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(208216);
        return;
      }
      if (c.h(this.ldw).contains(localObject2))
      {
        this.gll.invoke(new e.a(13022, "Tech already connected"));
        AppMethodBeat.o(208216);
        return;
      }
      localb = this.gll;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject2).ldR)).A("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(208216);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localb.invoke(new e.a(13015, "unavailable tech"));
        for (TagTechnology localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(208216);
          return;
        }
        try
        {
          localTagTechnology.connect();
          c.h(this.ldw).add(localObject2);
          this.gll.invoke(new e.b(z.Nhr));
          AppMethodBeat.o(208216);
          return;
        }
        catch (Exception localException2)
        {
          ae.w("MicroMsg.AppBrand.NFCReadWriteManager", "connect failed since ".concat(String.valueOf(localException2)));
          this.gll.invoke(new e.a(13017, "system internal error"));
          AppMethodBeat.o(208216);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(c paramc, d.g.a.b paramb, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(208217);
      Object localObject1 = this.ldw;
      Object localObject2 = this.gll;
      localObject1 = c.e((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(208217);
        return;
      }
      Object localObject3 = this.ldx;
      localObject2 = this.gll;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldV;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bmE().get(localObject3);
      if (localObject3 == null) {
        ((d.g.a.b)localObject2).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(208217);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).ldS;
      if (localObject2 == null)
      {
        this.gll.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(208217);
        return;
      }
      ((a)localObject2).a((Tag)localObject1, this.ldy, this.gll);
      AppMethodBeat.o(208217);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(183672);
      Object localObject1 = this.ldw;
      d.g.a.b localb = this.gll;
      localObject1 = c.e((c)localObject1);
      if (localObject1 == null) {
        localb.invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(183672);
        return;
      }
      Object localObject3 = this.ldx;
      localb = this.gll;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldV;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bmE().get(localObject3);
      if (localObject3 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(183672);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldO == localObject3)
      {
        this.gll.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(183672);
        return;
      }
      localb = this.gll;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).ldR)).A("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(183672);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localb.invoke(new e.a(13015, "unavailable tech"));
        for (Object localObject2 = null; localObject2 == null; localObject2 = (TagTechnology)localObject2)
        {
          AppMethodBeat.o(183672);
          return;
        }
        try
        {
          localObject2 = (Integer)org.a.a.gB(localObject2).bfD("getMaxTransceiveLength").object;
          localb = this.gll;
          p.g(localObject2, "length");
          localb.invoke(new e.b(localObject2));
          AppMethodBeat.o(183672);
          return;
        }
        catch (Exception localException2)
        {
          ae.w("MicroMsg.AppBrand.NFCReadWriteManager", "getMaxTransceiveLength failed since " + c.g((Throwable)localException2));
          this.gll.invoke(new e.a(13017, "system internal error"));
          AppMethodBeat.o(183672);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class h
    implements Runnable
  {
    public h(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(208218);
      Object localObject1 = this.ldw;
      d.g.a.b localb = this.gll;
      localObject1 = c.e((c)localObject1);
      if (localObject1 == null) {
        localb.invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(208218);
        return;
      }
      Object localObject2 = this.ldx;
      localb = this.gll;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldV;
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bmE().get(localObject2);
      if (localObject2 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(208218);
        return;
      }
      localb = this.gll;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject2).ldR)).A("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(208218);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localb.invoke(new e.a(13015, "unavailable tech"));
        for (TagTechnology localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(208218);
          return;
        }
        try
        {
          this.gll.invoke(new e.b(Boolean.valueOf(localTagTechnology.isConnected())));
          AppMethodBeat.o(208218);
          return;
        }
        catch (Exception localException2)
        {
          ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "check isConnected failed since ".concat(String.valueOf(localException2)));
          this.gll.invoke(new e.a(13017, "system internal error"));
          AppMethodBeat.o(208218);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onPause", "", "type", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$PauseType;", "onResume", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class i
    extends h.c
  {
    public final void a(h.d paramd)
    {
      AppMethodBeat.i(183674);
      super.a(paramd);
      ae.d("MicroMsg.AppBrand.NFCReadWriteManager", "onPause");
      if (c.a(this.ldw).getAndSet(false)) {
        ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "onPause, isNFCDiscovering");
      }
      try
      {
        ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        paramd = NfcAdapter.getDefaultAdapter(ak.getContext());
        if (paramd != null) {
          paramd.disableForegroundDispatch(this.ldw.activity);
        }
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          ae.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(paramd)));
        }
      }
      c.a(this.ldw, true);
      AppMethodBeat.o(183674);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(183673);
      super.onResume();
      ae.d("MicroMsg.AppBrand.NFCReadWriteManager", "onResume");
      if (c.i(this.ldw))
      {
        ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "onResume, isNFCDiscoverySticky");
        if ((this.ldw.activity instanceof com.tencent.mm.plugin.appbrand.jsapi.nfc.b)) {
          ((com.tencent.mm.plugin.appbrand.jsapi.nfc.b)this.ldw.activity).bmk();
        }
      }
      try
      {
        ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(ak.getContext());
        if (localNfcAdapter != null) {
          localNfcAdapter.enableForegroundDispatch(this.ldw.activity, c.b(this.ldw), c.bmA(), c.bmB());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        }
      }
      c.a(this.ldw).set(true);
      c.a(this.ldw, false);
      AppMethodBeat.o(183673);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(c paramc, d.g.a.b paramb, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(208219);
      Object localObject2 = this.ldw;
      Object localObject1 = this.gll;
      Tag localTag = c.e((c)localObject2);
      if (localTag == null) {
        ((d.g.a.b)localObject1).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localTag == null)
      {
        AppMethodBeat.o(208219);
        return;
      }
      localObject2 = this.ldx;
      localObject1 = this.gll;
      Object localObject3 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldV;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bmE().get(localObject2);
      if (localObject3 == null) {
        ((d.g.a.b)localObject1).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(208219);
        return;
      }
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      p.h("setTimeout", "name");
      p.h(arrayOfClass, "parameterTypes");
      b.b localb = new b.b("setTimeout", arrayOfClass);
      localObject2 = (Boolean)((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).ldQ.get(localb);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (Boolean)((d.g.a.a)new b.c(localb, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3, "setTimeout", arrayOfClass)).invoke();
      }
      p.g(localObject1, "MethodSignature(name, pa…            }()\n        }");
      if (!((Boolean)localObject1).booleanValue())
      {
        ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, " + ((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).lcw + ".setTimeout is not supported");
        this.gll.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(208219);
        return;
      }
      localObject2 = this.gll;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).ldR)).A("get", new Object[] { localTag }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(208219);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        ((d.g.a.b)localObject2).invoke(new e.a(13015, "unavailable tech"));
        for (TagTechnology localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(208219);
          return;
        }
        try
        {
          org.a.a.gB(localTagTechnology).A("setTimeout", new Object[] { Integer.valueOf(this.ldA) });
          this.gll.invoke(new e.b(z.Nhr));
          AppMethodBeat.o(208219);
          return;
        }
        catch (Exception localException2)
        {
          ae.w("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout failed since " + c.g((Throwable)localException2));
          this.gll.invoke(new e.a(13017, "system internal error"));
          AppMethodBeat.o(208219);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class k
    implements Runnable
  {
    public k(c paramc, d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(183675);
      if (c.a(this.ldw).get())
      {
        this.gll.invoke(new e.a(13021, "NFC discovery already started"));
        AppMethodBeat.o(183675);
        return;
      }
      try
      {
        ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(ak.getContext());
        if (localNfcAdapter == null) {
          p.gkB();
        }
        localNfcAdapter.enableForegroundDispatch(this.ldw.activity, c.b(this.ldw), c.bmA(), c.bmB());
        c.c(this.ldw);
        this.gll.invoke(new e.b(z.Nhr));
        c.a(this.ldw).set(true);
        c.d(this.ldw);
        AppMethodBeat.o(183675);
        return;
      }
      catch (Exception localException)
      {
        ae.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        this.gll.invoke(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183675);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(c paramc, d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(183676);
      if (!c.a(this.ldw).get())
      {
        this.gll.invoke(new e.a(13018, "NFC discovery has not started"));
        AppMethodBeat.o(183676);
        return;
      }
      try
      {
        ae.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(ak.getContext());
        if (localNfcAdapter == null) {
          p.gkB();
        }
        localNfcAdapter.disableForegroundDispatch(this.ldw.activity);
        c.a(this.ldw, null);
        c.f(this.ldw);
        this.gll.invoke(new e.b(z.Nhr));
        c.a(this.ldw).set(false);
        c.g(this.ldw);
        AppMethodBeat.o(183676);
        return;
      }
      catch (Exception localException)
      {
        ae.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        this.gll.invoke(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183676);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class m
    implements Runnable
  {
    public m(c paramc, d.g.a.b paramb, String paramString, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(183677);
      Object localObject1 = this.ldw;
      Object localObject4 = this.gll;
      localObject1 = c.e((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject4).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(183677);
        return;
      }
      Object localObject5 = this.ldx;
      localObject4 = this.gll;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldV;
      localObject5 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bmE().get(localObject5);
      if (localObject5 == null) {
        ((d.g.a.b)localObject4).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject5 == null)
      {
        AppMethodBeat.o(183677);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.ldO == localObject5)
      {
        this.gll.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(183677);
        return;
      }
      localObject4 = this.gll;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject5).ldR)).A("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(183677);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        ((d.g.a.b)localObject4).invoke(new e.a(13015, "unavailable tech"));
        for (Object localObject2 = null; localObject2 == null; localObject2 = (TagTechnology)localObject2)
        {
          AppMethodBeat.o(183677);
          return;
        }
        try
        {
          localObject4 = (byte[])org.a.a.gB(localObject2).A("transceive", new Object[] { this.ldB }).object;
          localObject5 = new StringBuilder("transceive, rspData: ");
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = Arrays.toString((byte[])localObject4);
            p.g(localObject2, "java.util.Arrays.toString(this)");
          }
          ae.d("MicroMsg.AppBrand.NFCReadWriteManager", (String)localObject2);
          localObject2 = this.gll;
          p.g(localObject4, "rspData");
          ((d.g.a.b)localObject2).invoke(new e.b(localObject4));
          AppMethodBeat.o(183677);
          return;
        }
        catch (Exception localException2)
        {
          ae.w("MicroMsg.AppBrand.NFCReadWriteManager", "transceive failed since " + c.g((Throwable)localException2));
          this.gll.invoke(new e.a(13017, "system internal error"));
          AppMethodBeat.o(183677);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(c paramc, d.g.a.b paramb, NdefMessage paramNdefMessage) {}
    
    public final void run()
    {
      AppMethodBeat.i(183678);
      Object localObject2 = this.ldw;
      Object localObject1 = paramb;
      localObject2 = c.e((c)localObject2);
      if (localObject2 == null) {
        ((d.g.a.b)localObject1).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(183678);
        return;
      }
      localObject1 = Ndef.get((Tag)localObject2);
      if (localObject1 == null)
      {
        paramb.invoke(new e.a(13015, "unavailable tech"));
        AppMethodBeat.o(183678);
        return;
      }
      try
      {
        ((Ndef)localObject1).writeNdefMessage(paramNdefMessage);
        paramb.invoke(new e.b(z.Nhr));
        AppMethodBeat.o(183678);
        return;
      }
      catch (Exception localException)
      {
        ae.w("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage failed since ".concat(String.valueOf(localException)));
        paramb.invoke(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183678);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c
 * JD-Core Version:    0.7.0.1
 */