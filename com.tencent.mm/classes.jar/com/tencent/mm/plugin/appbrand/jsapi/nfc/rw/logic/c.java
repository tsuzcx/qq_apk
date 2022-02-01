package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Ljava/lang/String;Landroid/app/Activity;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getActivity", "()Landroid/app/Activity;", "activityEventInterceptor", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "connectedTech", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "kotlin.jvm.PlatformType", "", "isActivityEventInterceptorAdded", "isLifeCycleListenerAdded", "isNFCDiscovering", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isNFCDiscoverySticky", "lifeCycleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1;", "nfcTagDiscoveredCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "id", "", "techs", "Landroid/nfc/NdefMessage;", "ndefMessages", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCTagDiscoveredCallback;", "getNfcTagDiscoveredCallback", "()Lkotlin/jvm/functions/Function3;", "setNfcTagDiscoveredCallback", "(Lkotlin/jvm/functions/Function3;)V", "pendingIntent", "Landroid/app/PendingIntent;", "requireForegroundDispatch", "getRequireForegroundDispatch", "()Z", "setRequireForegroundDispatch", "(Z)V", "sysNfcSwitchToggleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1;", "tag", "Landroid/nfc/Tag;", "addActivityEventInterceptorOnce", "addLifeCycleListenerOnce", "close", "techName", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "connect", "execTechLogic", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execTechLogicAsync", "getMaxTransceiveLength", "", "getNFCTech", "T", "getTag", "getTagTechnology", "Landroid/nfc/tech/TagTechnology;", "nfcTech", "tagSnapshot", "isConnected", "removeActivityEventInterceptorIfNecessary", "removeLifeCycleListenerIfNecessary", "setTimeout", "timeoutMs", "startNFCDiscovery", "stopNFCDiscovery", "transceive", "reqData", "tryDispatchNfcTagDiscovered", "intent", "tryParseMessageMap", "writeNdefMessage", "message", "wrappedThrowable", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public class c
{
  private static final Map<String, c> miK;
  private static final IntentFilter[] miL;
  private static final String[][] miM;
  private static c.a.a miN;
  public static final a miO;
  final Activity activity;
  public final String appId;
  protected final f lqg;
  public volatile kotlin.g.a.q<? super byte[], ? super List<String>, ? super List<NdefMessage>, x> miA;
  private boolean miB;
  private final kotlin.g.a.b<Intent, Boolean> miC;
  private final AtomicBoolean miD;
  private boolean miE;
  private boolean miF;
  private final i miG;
  private volatile Tag miH;
  private final Set<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b> miI;
  private final NFCReadWriteManager.sysNfcSwitchToggleListener.1 miJ;
  private volatile boolean miz;
  private final PendingIntent pendingIntent;
  
  static
  {
    AppMethodBeat.i(183681);
    miO = new a((byte)0);
    miK = (Map)new ConcurrentHashMap();
    Object localObject = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
    try
    {
      ((IntentFilter)localObject).addDataType("*/*");
      miL = new IntentFilter[] { localObject };
      localObject = NfcA.class.getName();
      String str1 = NfcB.class.getName();
      String str2 = IsoDep.class.getName();
      String str3 = NfcF.class.getName();
      String str4 = NfcV.class.getName();
      String str5 = MifareClassic.class.getName();
      String str6 = MifareUltralight.class.getName();
      String str7 = Ndef.class.getName();
      miM = (String[][])new String[][] { { localObject }, { str1 }, { str2 }, { str3 }, { str4 }, { str5 }, { str6 }, { str7 } };
      miN = (c.a.a)new b();
      AppMethodBeat.o(183681);
      return;
    }
    catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "addDataType failed");
      }
    }
  }
  
  public c(String paramString, Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(207159);
    this.appId = paramString;
    this.activity = paramActivity;
    this.lqg = paramf;
    paramString = new Intent((Context)this.activity, this.activity.getClass()).addFlags(536870912);
    this.pendingIntent = PendingIntent.getActivity((Context)this.activity, 0, paramString, 0);
    this.miC = ((kotlin.g.a.b)new c(this));
    this.miD = new AtomicBoolean(false);
    this.miG = new i(this);
    this.miI = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    this.miJ = new NFCReadWriteManager.sysNfcSwitchToggleListener.1(this);
    this.activity.registerReceiver((BroadcastReceiver)this.miJ, new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
    com.tencent.mm.plugin.appbrand.h.a(this.appId, (h.c)new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(183669);
        super.onDestroy();
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onDestroy");
        this.miP.activity.unregisterReceiver((BroadcastReceiver)c.j(this.miP));
        c.bIb().remove(this.miP.appId);
        AppMethodBeat.o(183669);
      }
    });
    AppMethodBeat.o(207159);
  }
  
  private static List<NdefMessage> F(Intent paramIntent)
  {
    AppMethodBeat.i(207158);
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "tryParseMessageMap");
    paramIntent = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
    if (paramIntent != null)
    {
      Object localObject = new StringBuilder("tryDispatchNdefMessagesRead, rawMessages: ");
      String str = Arrays.toString(paramIntent);
      p.g(str, "java.util.Arrays.toString(this)");
      Log.i("MicroMsg.AppBrand.NFCReadWriteManager", str);
      localObject = (Collection)new ArrayList(paramIntent.length);
      int j = paramIntent.length;
      int i = 0;
      while (i < j)
      {
        str = paramIntent[i];
        if (str == null)
        {
          paramIntent = new t("null cannot be cast to non-null type android.nfc.NdefMessage");
          AppMethodBeat.o(207158);
          throw paramIntent;
        }
        ((Collection)localObject).add((NdefMessage)str);
        i += 1;
      }
      paramIntent = (List)localObject;
      AppMethodBeat.o(207158);
      return paramIntent;
    }
    AppMethodBeat.o(207158);
    return null;
  }
  
  public static final boolean u(f paramf)
  {
    AppMethodBeat.i(207161);
    boolean bool = a.u(paramf);
    AppMethodBeat.o(207161);
    return bool;
  }
  
  public void E(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(207157);
    p.h(paramIntent, "intent");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "tryDispatchNfcTagDiscovered");
    kotlin.g.a.q localq = this.miA;
    if (localq != null)
    {
      Object localObject1 = this.miH;
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
            localObject5 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
            localObject4 = (String)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bIe().get(localObject4);
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
            Log.i("MicroMsg.AppBrand.NFCReadWriteManager", (String)localObject1 + ", techs: " + localObject3);
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
              if (((List)localObject3).contains(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjh.mhN)) {
                localObject1 = F(paramIntent);
              }
              localq.d(localObject4, localObject3, localObject1);
            }
            AppMethodBeat.o(207157);
            return;
            localObject1 = null;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(207157);
  }
  
  public final void a(final NdefMessage paramNdefMessage, final kotlin.g.a.b<? super e<x>, x> paramb)
  {
    AppMethodBeat.i(183679);
    p.h(paramNdefMessage, "message");
    p.h(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage, message: ".concat(String.valueOf(paramNdefMessage)));
    com.tencent.f.h.RTc.b((Runnable)new n(this, paramb, paramNdefMessage), "NFC-IO");
    AppMethodBeat.o(183679);
  }
  
  public void hK(boolean paramBoolean)
  {
    this.miz = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion;", "", "()V", "INVALID_NFC_ADAPTER_STATE", "", "METHOD_NAME_GET", "", "METHOD_NAME_GET_MAX_TRANSCEIVE_LENGTH", "METHOD_NAME_SET_TIMEOUT", "METHOD_NAME_TRANSCEIVE", "NFC_IO_LOOP_TAG", "TAG", "appId2ManagerMap", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "factory", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "getFactory", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "setFactory", "(Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;)V", "intentFiltersArray", "", "Landroid/content/IntentFilter;", "[Landroid/content/IntentFilter;", "techListsArray", "[[Ljava/lang/String;", "get", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isNFCUsing", "", "manager", "appId", "IFactory", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a
  {
    public static void b(a parama)
    {
      AppMethodBeat.i(207148);
      p.h(parama, "<set-?>");
      c.a(parama);
      AppMethodBeat.o(207148);
    }
    
    private static boolean k(c paramc)
    {
      AppMethodBeat.i(207150);
      if (c.a(paramc).get())
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, isDiscovering, using");
        AppMethodBeat.o(207150);
        return true;
      }
      paramc = c.h(paramc);
      p.g(paramc, "manager.connectedTech");
      if (!((Collection)paramc).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, connected, using");
        AppMethodBeat.o(207150);
        return true;
      }
      Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, not using");
      AppMethodBeat.o(207150);
      return false;
    }
    
    public static boolean u(f paramf)
    {
      AppMethodBeat.i(207149);
      p.h(paramf, "component");
      paramf = w(paramf);
      if (paramf == null)
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, manager is null, not using");
        AppMethodBeat.o(207149);
        return false;
      }
      boolean bool = k(paramf);
      AppMethodBeat.o(207149);
      return bool;
    }
    
    public static c w(f paramf)
    {
      AppMethodBeat.i(183670);
      p.h(paramf, "component");
      Object localObject2 = (c)c.bIb().get(paramf.getAppId());
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = AndroidContextUtil.castActivityOrNull(paramf.getContext());
        if (localObject1 != null)
        {
          localObject2 = c.miO;
          localObject2 = c.bIc();
          String str = paramf.getAppId();
          p.g(str, "component.appId");
          p.g(localObject1, "activity");
          localObject1 = ((a)localObject2).a(str, (Activity)localObject1, paramf);
          localObject2 = c.bIb();
          paramf = paramf.getAppId();
          p.g(paramf, "component.appId");
          ((Map)localObject2).put(paramf, localObject1);
          AppMethodBeat.o(183670);
          return localObject1;
        }
        localObject1 = null;
      }
      AppMethodBeat.o(183670);
      return localObject1;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"})
    public static abstract interface a
    {
      public abstract c a(String paramString, Activity paramActivity, f paramf);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$factory$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class b
    implements c.a.a
  {
    public final c a(String paramString, Activity paramActivity, f paramf)
    {
      AppMethodBeat.i(207147);
      p.h(paramString, "appId");
      p.h(paramActivity, "activity");
      p.h(paramf, "component");
      paramString = new c(paramString, paramActivity, paramf);
      AppMethodBeat.o(207147);
      return paramString;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "intent", "Landroid/content/Intent;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Intent, Boolean>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(c paramc, kotlin.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(207151);
      Object localObject1 = this.miP;
      Object localObject2 = this.gWe;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        ((kotlin.g.a.b)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(207151);
        return;
      }
      localObject2 = this.miQ;
      kotlin.g.a.b localb = this.gWe;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(localObject2);
      if (localObject2 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(207151);
        return;
      }
      if (!c.h(this.miP).contains(localObject2))
      {
        this.gWe.invoke(new e.a(13023, "Tech has not connected"));
        AppMethodBeat.o(207151);
        return;
      }
      localb = this.gWe;
      TagTechnology localTagTechnology;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject2).mjk)).u("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(207151);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localb.invoke(new e.a(13015, "unavailable tech"));
        for (localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(207151);
          return;
        }
      }
      try
      {
        localTagTechnology.close();
        c.h(this.miP).remove(localObject2);
        this.gWe.invoke(new e.b(x.SXb));
        AppMethodBeat.o(207151);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "close failed since ".concat(String.valueOf(localException2)));
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class e
    implements Runnable
  {
    public e(c paramc, kotlin.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(207152);
      Object localObject1 = this.miP;
      Object localObject2 = this.gWe;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        ((kotlin.g.a.b)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(207152);
        return;
      }
      localObject2 = this.miQ;
      kotlin.g.a.b localb = this.gWe;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(localObject2);
      if (localObject2 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(207152);
        return;
      }
      if (c.h(this.miP).contains(localObject2))
      {
        this.gWe.invoke(new e.a(13022, "Tech already connected"));
        AppMethodBeat.o(207152);
        return;
      }
      localb = this.gWe;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject2).mjk)).u("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(207152);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localb.invoke(new e.a(13015, "unavailable tech"));
        for (TagTechnology localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(207152);
          return;
        }
        try
        {
          localTagTechnology.connect();
          c.h(this.miP).add(localObject2);
          this.gWe.invoke(new e.b(x.SXb));
          AppMethodBeat.o(207152);
          return;
        }
        catch (Exception localException2)
        {
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "connect failed since ".concat(String.valueOf(localException2)));
          this.gWe.invoke(new e.a(13017, "system internal error"));
          AppMethodBeat.o(207152);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(c paramc, kotlin.g.a.b paramb, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(207153);
      Object localObject1 = this.miP;
      Object localObject2 = this.gWe;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        ((kotlin.g.a.b)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(207153);
        return;
      }
      Object localObject3 = this.miQ;
      localObject2 = this.gWe;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(localObject3);
      if (localObject3 == null) {
        ((kotlin.g.a.b)localObject2).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(207153);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject3).mjl;
      if (localObject2 == null)
      {
        this.gWe.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(207153);
        return;
      }
      ((a)localObject2).a((Tag)localObject1, this.miR, this.gWe);
      AppMethodBeat.o(207153);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(c paramc, kotlin.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(183672);
      Object localObject1 = this.miP;
      kotlin.g.a.b localb = this.gWe;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        localb.invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(183672);
        return;
      }
      Object localObject4 = this.miQ;
      localb = this.gWe;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
      localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(localObject4);
      if (localObject4 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject4 == null)
      {
        AppMethodBeat.o(183672);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjh == localObject4)
      {
        this.gWe.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(183672);
        return;
      }
      localb = this.gWe;
      Object localObject3;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject4).mjk)).u("get", new Object[] { localObject1 }).object;
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
          localObject2 = (Integer)org.a.a.gG(localObject2).bvt("getMaxTransceiveLength").object;
          localb = this.gWe;
          p.g(localObject2, "length");
          localb.invoke(new e.b(localObject2));
          AppMethodBeat.o(183672);
          return;
        }
        catch (Exception localException2)
        {
          localObject3 = c.g((Throwable)localException2);
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "getMaxTransceiveLength failed since ".concat(String.valueOf(localObject3)));
          localb = this.gWe;
          localObject4 = new StringBuilder("system internal error: ");
          if (localObject3 == null) {
            break label374;
          }
        }
        localObject3 = ((Throwable)localObject3).getMessage();
      }
      for (;;)
      {
        localb.invoke(new e.a(13017, (String)localObject3));
        AppMethodBeat.o(183672);
        return;
        label374:
        localObject3 = null;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class h
    implements Runnable
  {
    public h(c paramc, kotlin.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(207154);
      Object localObject1 = this.miP;
      kotlin.g.a.b localb = this.gWe;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        localb.invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(207154);
        return;
      }
      Object localObject2 = this.miQ;
      localb = this.gWe;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(localObject2);
      if (localObject2 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(207154);
        return;
      }
      localb = this.gWe;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject2).mjk)).u("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(207154);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localb.invoke(new e.a(13015, "unavailable tech"));
        for (TagTechnology localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(207154);
          return;
        }
        try
        {
          this.gWe.invoke(new e.b(Boolean.valueOf(localTagTechnology.isConnected())));
          AppMethodBeat.o(207154);
          return;
        }
        catch (Exception localException2)
        {
          Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "check isConnected failed since ".concat(String.valueOf(localException2)));
          this.gWe.invoke(new e.a(13017, "system internal error"));
          AppMethodBeat.o(207154);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onPause", "", "type", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$PauseType;", "onResume", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class i
    extends h.c
  {
    public final void a(h.d paramd)
    {
      AppMethodBeat.i(183674);
      super.a(paramd);
      Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onPause");
      if (c.a(this.miP).getAndSet(false)) {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "onPause, isNFCDiscovering");
      }
      try
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        paramd = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
        if (paramd != null) {
          paramd.disableForegroundDispatch(this.miP.activity);
        }
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(paramd)));
        }
      }
      c.a(this.miP, true);
      AppMethodBeat.o(183674);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(183673);
      super.onResume();
      Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onResume");
      NfcAdapter localNfcAdapter;
      if (c.e(this.miP))
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "onResume, isNFCDiscoverySticky");
        if ((this.miP.activity instanceof com.tencent.mm.plugin.appbrand.jsapi.nfc.b)) {
          ((com.tencent.mm.plugin.appbrand.jsapi.nfc.b)this.miP.activity).bHJ();
        }
        localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
        if ((localNfcAdapter == null) || (true != localNfcAdapter.isEnabled()))
        {
          Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "onResume, nfc is not enabled");
          AppMethodBeat.o(183673);
          return;
        }
      }
      try
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
        localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
        if (localNfcAdapter != null) {
          localNfcAdapter.enableForegroundDispatch(this.miP.activity, c.b(this.miP), c.bHZ(), c.bIa());
        }
        c.a(this.miP).set(true);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        }
      }
      c.a(this.miP, false);
      AppMethodBeat.o(183673);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(c paramc, kotlin.g.a.b paramb, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(207155);
      Object localObject3 = this.miP;
      Object localObject1 = this.gWe;
      Object localObject4 = c.i((c)localObject3);
      if (localObject4 == null) {
        ((kotlin.g.a.b)localObject1).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject4 == null)
      {
        AppMethodBeat.o(207155);
        return;
      }
      localObject3 = this.miQ;
      localObject1 = this.gWe;
      Object localObject5 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
      localObject5 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(localObject3);
      if (localObject5 == null) {
        ((kotlin.g.a.b)localObject1).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject5 == null)
      {
        AppMethodBeat.o(207155);
        return;
      }
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      p.h("setTimeout", "name");
      p.h(arrayOfClass, "parameterTypes");
      b.b localb = new b.b("setTimeout", arrayOfClass);
      localObject3 = (Boolean)((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject5).mjj.get(localb);
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = (Boolean)((kotlin.g.a.a)new b.c(localb, (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject5, "setTimeout", arrayOfClass)).invoke();
      }
      p.g(localObject1, "MethodSignature(name, pa…            }()\n        }");
      if (!((Boolean)localObject1).booleanValue())
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, " + ((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject5).mhN + ".setTimeout is not supported");
        this.gWe.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(207155);
        return;
      }
      localObject3 = this.gWe;
      Object localObject2;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject5).mjk)).u("get", new Object[] { localObject4 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(207155);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        ((kotlin.g.a.b)localObject3).invoke(new e.a(13015, "unavailable tech"));
        for (TagTechnology localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(207155);
          return;
        }
        try
        {
          org.a.a.gG(localTagTechnology).u("setTimeout", new Object[] { Integer.valueOf(this.miT) });
          this.gWe.invoke(new e.b(x.SXb));
          AppMethodBeat.o(207155);
          return;
        }
        catch (Exception localException2)
        {
          localObject2 = c.g((Throwable)localException2);
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout failed since ".concat(String.valueOf(localObject2)));
          localObject3 = this.gWe;
          localObject4 = new StringBuilder("system internal error: ");
          if (localObject2 == null) {
            break label503;
          }
        }
        localObject2 = ((Throwable)localObject2).getMessage();
      }
      for (;;)
      {
        ((kotlin.g.a.b)localObject3).invoke(new e.a(13017, (String)localObject2));
        AppMethodBeat.o(207155);
        return;
        label503:
        localObject2 = null;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class k
    implements Runnable
  {
    public k(c paramc, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(183675);
      if (c.a(this.miP).get())
      {
        this.gWe.invoke(new e.a(13021, "NFC discovery already started"));
        AppMethodBeat.o(183675);
        return;
      }
      try
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
        if (localNfcAdapter == null) {
          p.hyc();
        }
        localNfcAdapter.enableForegroundDispatch(this.miP.activity, c.b(this.miP), c.bHZ(), c.bIa());
        c.c(this.miP);
        this.gWe.invoke(new e.b(x.SXb));
        c.a(this.miP).set(true);
        c.d(this.miP);
        AppMethodBeat.o(183675);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        this.gWe.invoke(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183675);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(c paramc, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(183676);
      c.a(this.miP, false);
      if (!c.a(this.miP).get())
      {
        this.gWe.invoke(new e.a(13018, "NFC discovery has not started"));
        AppMethodBeat.o(183676);
        return;
      }
      try
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
        if (localNfcAdapter == null) {
          p.hyc();
        }
        localNfcAdapter.disableForegroundDispatch(this.miP.activity);
        c.f(this.miP);
        this.gWe.invoke(new e.b(x.SXb));
        c.a(this.miP).set(false);
        c.g(this.miP);
        AppMethodBeat.o(183676);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        this.gWe.invoke(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183676);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class m
    implements Runnable
  {
    public m(c paramc, kotlin.g.a.b paramb, String paramString, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(183677);
      Object localObject1 = this.miP;
      Object localObject4 = this.gWe;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        ((kotlin.g.a.b)localObject4).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(183677);
        return;
      }
      Object localObject5 = this.miQ;
      localObject4 = this.gWe;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjo;
      localObject5 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bId().get(localObject5);
      if (localObject5 == null) {
        ((kotlin.g.a.b)localObject4).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject5 == null)
      {
        AppMethodBeat.o(183677);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.mjh == localObject5)
      {
        this.gWe.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(183677);
        return;
      }
      localObject4 = this.gWe;
      Object localObject3;
      try
      {
        localObject1 = org.a.a.bF(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject5).mjk)).u("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(183677);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        ((kotlin.g.a.b)localObject4).invoke(new e.a(13015, "unavailable tech"));
        for (Object localObject2 = null; localObject2 == null; localObject2 = (TagTechnology)localObject2)
        {
          AppMethodBeat.o(183677);
          return;
        }
        try
        {
          localObject4 = (byte[])org.a.a.gG(localObject2).u("transceive", new Object[] { this.miU }).object;
          localObject5 = new StringBuilder("transceive, rspData: ");
          if (localObject4 != null)
          {
            localObject2 = Arrays.toString((byte[])localObject4);
            p.g(localObject2, "java.util.Arrays.toString(this)");
          }
          for (;;)
          {
            Log.d("MicroMsg.AppBrand.NFCReadWriteManager", (String)localObject2);
            localObject2 = this.gWe;
            p.g(localObject4, "rspData");
            ((kotlin.g.a.b)localObject2).invoke(new e.b(localObject4));
            AppMethodBeat.o(183677);
            return;
            localObject2 = null;
          }
          localObject3 = ((Throwable)localObject3).getMessage();
        }
        catch (Exception localException2)
        {
          localObject3 = c.g((Throwable)localException2);
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "transceive failed since ".concat(String.valueOf(localObject3)));
          localObject4 = this.gWe;
          localObject5 = new StringBuilder("system internal error: ");
          if (localObject3 == null) {}
        }
      }
      for (;;)
      {
        ((kotlin.g.a.b)localObject4).invoke(new e.a(13017, (String)localObject3));
        AppMethodBeat.o(183677);
        return;
        localObject3 = null;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(c paramc, kotlin.g.a.b paramb, NdefMessage paramNdefMessage) {}
    
    public final void run()
    {
      AppMethodBeat.i(183678);
      Object localObject2 = this.miP;
      Object localObject1 = paramb;
      localObject2 = c.i((c)localObject2);
      if (localObject2 == null) {
        ((kotlin.g.a.b)localObject1).invoke(new e.a(13013, "NFC tag has not been discovered"));
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
        paramb.invoke(new e.b(x.SXb));
        AppMethodBeat.o(183678);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage failed since ".concat(String.valueOf(localException)));
        paramb.invoke(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183678);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c
 * JD-Core Version:    0.7.0.1
 */