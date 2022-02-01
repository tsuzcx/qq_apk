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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.c;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Ljava/lang/String;Landroid/app/Activity;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getActivity", "()Landroid/app/Activity;", "activityEventInterceptor", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "connectedTech", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "kotlin.jvm.PlatformType", "", "isActivityEventInterceptorAdded", "isLifeCycleListenerAdded", "isNFCDiscovering", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isNFCDiscoverySticky", "lifeCycleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1;", "nfcTagDiscoveredCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "id", "", "techs", "Landroid/nfc/NdefMessage;", "ndefMessages", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCTagDiscoveredCallback;", "getNfcTagDiscoveredCallback", "()Lkotlin/jvm/functions/Function3;", "setNfcTagDiscoveredCallback", "(Lkotlin/jvm/functions/Function3;)V", "pendingIntent", "Landroid/app/PendingIntent;", "requireForegroundDispatch", "getRequireForegroundDispatch", "()Z", "setRequireForegroundDispatch", "(Z)V", "sysNfcSwitchToggleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1;", "tag", "Landroid/nfc/Tag;", "addActivityEventInterceptorOnce", "addLifeCycleListenerOnce", "close", "techName", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "connect", "execTechLogic", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execTechLogicAsync", "getMaxTransceiveLength", "", "getNFCTech", "T", "getTag", "getTagTechnology", "Landroid/nfc/tech/TagTechnology;", "nfcTech", "tagSnapshot", "isConnected", "removeActivityEventInterceptorIfNecessary", "removeLifeCycleListenerIfNecessary", "setTimeout", "timeoutMs", "startNFCDiscovery", "stopNFCDiscovery", "transceive", "reqData", "tryDispatchNfcTagDiscovered", "intent", "tryParseMessageMap", "writeNdefMessage", "message", "wrappedThrowable", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public class c
{
  private static final Map<String, c> pgM;
  private static final IntentFilter[] pgN;
  private static final String[][] pgO;
  private static c.a.a pgP;
  public static final a pgQ;
  final Activity activity;
  public final String appId;
  private final com.tencent.mm.plugin.appbrand.jsapi.e okQ;
  private final PendingIntent pendingIntent;
  private volatile boolean pgB;
  public volatile kotlin.g.a.q<? super byte[], ? super List<String>, ? super List<NdefMessage>, x> pgC;
  private boolean pgD;
  private final kotlin.g.a.b<Intent, Boolean> pgE;
  private final AtomicBoolean pgF;
  private boolean pgG;
  private boolean pgH;
  private final i pgI;
  private volatile Tag pgJ;
  private final Set<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b> pgK;
  private final NFCReadWriteManager.sysNfcSwitchToggleListener.1 pgL;
  
  static
  {
    AppMethodBeat.i(183681);
    pgQ = new a((byte)0);
    pgM = (Map)new ConcurrentHashMap();
    Object localObject = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
    try
    {
      ((IntentFilter)localObject).addDataType("*/*");
      pgN = new IntentFilter[] { localObject };
      String[] arrayOfString1 = { NfcA.class.getName() };
      String[] arrayOfString2 = { NfcB.class.getName() };
      String[] arrayOfString3 = { IsoDep.class.getName() };
      String[] arrayOfString4 = { NfcF.class.getName() };
      String[] arrayOfString5 = { NfcV.class.getName() };
      localObject = MifareClassic.class.getName();
      String[] arrayOfString6 = { MifareUltralight.class.getName() };
      String[] arrayOfString7 = { Ndef.class.getName() };
      pgO = (String[][])new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, { localObject }, arrayOfString6, arrayOfString7 };
      pgP = (c.a.a)new b();
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
  
  public c(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(242116);
    this.appId = paramString;
    this.activity = paramActivity;
    this.okQ = parame;
    paramString = new Intent((Context)this.activity, this.activity.getClass()).addFlags(536870912);
    this.pendingIntent = PendingIntent.getActivity((Context)this.activity, 0, paramString, 0);
    this.pgE = ((kotlin.g.a.b)new c(this));
    this.pgF = new AtomicBoolean(false);
    this.pgI = new i(this);
    this.pgK = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    this.pgL = new NFCReadWriteManager.sysNfcSwitchToggleListener.1(this);
    this.activity.registerReceiver((BroadcastReceiver)this.pgL, new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
    k.a(this.appId, (k.c)new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(183669);
        super.onDestroy();
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onDestroy");
        this.pgR.activity.unregisterReceiver((BroadcastReceiver)c.j(this.pgR));
        c.bTK().remove(this.pgR.appId);
        AppMethodBeat.o(183669);
      }
    });
    AppMethodBeat.o(242116);
  }
  
  private static List<NdefMessage> G(Intent paramIntent)
  {
    AppMethodBeat.i(242114);
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "tryParseMessageMap");
    paramIntent = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
    if (paramIntent != null)
    {
      Object localObject = new StringBuilder("tryDispatchNdefMessagesRead, rawMessages: ");
      String str = Arrays.toString(paramIntent);
      p.j(str, "java.util.Arrays.toString(this)");
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
          AppMethodBeat.o(242114);
          throw paramIntent;
        }
        ((Collection)localObject).add((NdefMessage)str);
        i += 1;
      }
      paramIntent = (List)localObject;
      AppMethodBeat.o(242114);
      return paramIntent;
    }
    AppMethodBeat.o(242114);
    return null;
  }
  
  public static final boolean x(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(242137);
    boolean bool = a.x(parame);
    AppMethodBeat.o(242137);
    return bool;
  }
  
  public void F(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(242112);
    p.k(paramIntent, "intent");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "tryDispatchNfcTagDiscovered");
    kotlin.g.a.q localq = this.pgC;
    if (localq != null)
    {
      Object localObject1 = this.pgJ;
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
            localObject5 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phq;
            localObject4 = (String)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bTN().get(localObject4);
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
            p.j(localObject1, "java.util.Arrays.toString(this)");
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
              if (((List)localObject3).contains(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phj.pfR)) {
                localObject1 = G(paramIntent);
              }
              localq.c(localObject4, localObject3, localObject1);
            }
            AppMethodBeat.o(242112);
            return;
            localObject1 = null;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(242112);
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsapi.e QK()
  {
    return this.okQ;
  }
  
  public final void a(final NdefMessage paramNdefMessage, final kotlin.g.a.b<? super e<x>, x> paramb)
  {
    AppMethodBeat.i(183679);
    p.k(paramNdefMessage, "message");
    p.k(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage, message: ".concat(String.valueOf(paramNdefMessage)));
    h.ZvG.d((Runnable)new n(this, paramb, paramNdefMessage), "NFC-IO");
    AppMethodBeat.o(183679);
  }
  
  public void iA(boolean paramBoolean)
  {
    this.pgB = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion;", "", "()V", "INVALID_NFC_ADAPTER_STATE", "", "METHOD_NAME_GET", "", "METHOD_NAME_GET_MAX_TRANSCEIVE_LENGTH", "METHOD_NAME_SET_TIMEOUT", "METHOD_NAME_TRANSCEIVE", "NFC_IO_LOOP_TAG", "TAG", "appId2ManagerMap", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "factory", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "getFactory", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "setFactory", "(Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;)V", "intentFiltersArray", "", "Landroid/content/IntentFilter;", "[Landroid/content/IntentFilter;", "techListsArray", "[[Ljava/lang/String;", "get", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isNFCUsing", "", "manager", "appId", "IFactory", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a
  {
    public static void b(a parama)
    {
      AppMethodBeat.i(241719);
      p.k(parama, "<set-?>");
      c.a(parama);
      AppMethodBeat.o(241719);
    }
    
    private static boolean k(c paramc)
    {
      AppMethodBeat.i(241721);
      if (c.a(paramc).get())
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, isDiscovering, using");
        AppMethodBeat.o(241721);
        return true;
      }
      paramc = c.h(paramc);
      p.j(paramc, "manager.connectedTech");
      if (!((Collection)paramc).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, connected, using");
        AppMethodBeat.o(241721);
        return true;
      }
      Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, not using");
      AppMethodBeat.o(241721);
      return false;
    }
    
    public static boolean x(com.tencent.mm.plugin.appbrand.jsapi.e parame)
    {
      AppMethodBeat.i(241720);
      p.k(parame, "component");
      parame = z(parame);
      if (parame == null)
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, manager is null, not using");
        AppMethodBeat.o(241720);
        return false;
      }
      boolean bool = k(parame);
      AppMethodBeat.o(241720);
      return bool;
    }
    
    public static c z(com.tencent.mm.plugin.appbrand.jsapi.e parame)
    {
      AppMethodBeat.i(183670);
      p.k(parame, "component");
      Object localObject2 = (c)c.bTK().get(parame.getAppId());
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = AndroidContextUtil.castActivityOrNull(parame.getContext());
        if (localObject1 != null)
        {
          localObject2 = c.pgQ;
          localObject2 = c.bTL();
          String str = parame.getAppId();
          p.j(str, "component.appId");
          p.j(localObject1, "activity");
          localObject1 = ((a)localObject2).a(str, (Activity)localObject1, parame);
          localObject2 = c.bTK();
          parame = parame.getAppId();
          p.j(parame, "component.appId");
          ((Map)localObject2).put(parame, localObject1);
          AppMethodBeat.o(183670);
          return localObject1;
        }
        localObject1 = null;
      }
      AppMethodBeat.o(183670);
      return localObject1;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"})
    public static abstract interface a
    {
      public abstract c a(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.e parame);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$factory$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class b
    implements c.a.a
  {
    public final c a(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.e parame)
    {
      AppMethodBeat.i(241795);
      p.k(paramString, "appId");
      p.k(paramActivity, "activity");
      p.k(parame, "component");
      paramString = new c(paramString, paramActivity, parame);
      AppMethodBeat.o(241795);
      return paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "intent", "Landroid/content/Intent;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Intent, Boolean>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(c paramc, kotlin.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(241997);
      Object localObject1 = this.pgR;
      Object localObject2 = this.jFa;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        ((kotlin.g.a.b)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(241997);
        return;
      }
      localObject2 = this.pgS;
      kotlin.g.a.b localb = this.jFa;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phq;
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bTM().get(localObject2);
      if (localObject2 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(241997);
        return;
      }
      if (!c.h(this.pgR).contains(localObject2))
      {
        this.jFa.invoke(new e.a(13023, "Tech has not connected"));
        AppMethodBeat.o(241997);
        return;
      }
      localb = this.jFa;
      TagTechnology localTagTechnology;
      try
      {
        localObject1 = org.a.a.ce(org.a.a.bIA(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject2).phm)).t("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(241997);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localb.invoke(new e.a(13015, "unavailable tech"));
        for (localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(241997);
          return;
        }
      }
      try
      {
        localTagTechnology.close();
        c.h(this.pgR).remove(localObject2);
        this.jFa.invoke(new e.b(x.aazN));
        AppMethodBeat.o(241997);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class e
    implements Runnable
  {
    public e(c paramc, kotlin.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(241608);
      Object localObject1 = this.pgR;
      Object localObject2 = this.jFa;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        ((kotlin.g.a.b)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(241608);
        return;
      }
      localObject2 = this.pgS;
      kotlin.g.a.b localb = this.jFa;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phq;
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bTM().get(localObject2);
      if (localObject2 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(241608);
        return;
      }
      if (c.h(this.pgR).contains(localObject2))
      {
        this.jFa.invoke(new e.a(13022, "Tech already connected"));
        AppMethodBeat.o(241608);
        return;
      }
      localb = this.jFa;
      try
      {
        localObject1 = org.a.a.ce(org.a.a.bIA(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject2).phm)).t("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(241608);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localb.invoke(new e.a(13015, "unavailable tech"));
        for (TagTechnology localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(241608);
          return;
        }
        try
        {
          localTagTechnology.connect();
          c.h(this.pgR).add(localObject2);
          this.jFa.invoke(new e.b(x.aazN));
          AppMethodBeat.o(241608);
          return;
        }
        catch (Exception localException2)
        {
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "connect failed since ".concat(String.valueOf(localException2)));
          this.jFa.invoke(new e.a(13017, "system internal error"));
          AppMethodBeat.o(241608);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(c paramc, kotlin.g.a.b paramb, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(241914);
      Object localObject1 = this.pgR;
      Object localObject2 = this.jFa;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        ((kotlin.g.a.b)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(241914);
        return;
      }
      Object localObject3 = this.pgS;
      localObject2 = this.jFa;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phq;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bTM().get(localObject3);
      if (localObject3 == null) {
        ((kotlin.g.a.b)localObject2).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(241914);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject3).phn;
      if (localObject2 == null)
      {
        this.jFa.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(241914);
        return;
      }
      ((a)localObject2).a((Tag)localObject1, this.pgT, this.jFa);
      AppMethodBeat.o(241914);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(c paramc, kotlin.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(183672);
      Object localObject1 = this.pgR;
      kotlin.g.a.b localb = this.jFa;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        localb.invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(183672);
        return;
      }
      Object localObject4 = this.pgS;
      localb = this.jFa;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phq;
      localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bTM().get(localObject4);
      if (localObject4 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject4 == null)
      {
        AppMethodBeat.o(183672);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phj == localObject4)
      {
        this.jFa.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(183672);
        return;
      }
      localb = this.jFa;
      Object localObject3;
      try
      {
        localObject1 = org.a.a.ce(org.a.a.bIA(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject4).phm)).t("get", new Object[] { localObject1 }).object;
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
          localObject2 = (Integer)org.a.a.gY(localObject2).bIz("getMaxTransceiveLength").object;
          localb = this.jFa;
          p.j(localObject2, "length");
          localb.invoke(new e.b(localObject2));
          AppMethodBeat.o(183672);
          return;
        }
        catch (Exception localException2)
        {
          localObject3 = c.g((Throwable)localException2);
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "getMaxTransceiveLength failed since ".concat(String.valueOf(localObject3)));
          localb = this.jFa;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class h
    implements Runnable
  {
    public h(c paramc, kotlin.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(241815);
      Object localObject1 = this.pgR;
      kotlin.g.a.b localb = this.jFa;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        localb.invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(241815);
        return;
      }
      Object localObject2 = this.pgS;
      localb = this.jFa;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phq;
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bTM().get(localObject2);
      if (localObject2 == null) {
        localb.invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(241815);
        return;
      }
      localb = this.jFa;
      try
      {
        localObject1 = org.a.a.ce(org.a.a.bIA(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject2).phm)).t("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(241815);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localb.invoke(new e.a(13015, "unavailable tech"));
        for (TagTechnology localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(241815);
          return;
        }
        try
        {
          this.jFa.invoke(new e.b(Boolean.valueOf(localTagTechnology.isConnected())));
          AppMethodBeat.o(241815);
          return;
        }
        catch (Exception localException2)
        {
          Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "check isConnected failed since ".concat(String.valueOf(localException2)));
          this.jFa.invoke(new e.a(13017, "system internal error"));
          AppMethodBeat.o(241815);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onPause", "", "type", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$PauseType;", "onResume", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class i
    extends k.c
  {
    public final void a(k.d paramd)
    {
      AppMethodBeat.i(183674);
      super.a(paramd);
      Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onPause");
      if (c.a(this.pgR).getAndSet(false)) {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "onPause, isNFCDiscovering");
      }
      try
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        paramd = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
        if (paramd != null) {
          paramd.disableForegroundDispatch(this.pgR.activity);
        }
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(paramd)));
        }
      }
      c.a(this.pgR, true);
      AppMethodBeat.o(183674);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(183673);
      super.onResume();
      Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onResume");
      NfcAdapter localNfcAdapter;
      if (c.e(this.pgR))
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "onResume, isNFCDiscoverySticky");
        if ((this.pgR.activity instanceof com.tencent.mm.plugin.appbrand.jsapi.nfc.b)) {
          ((com.tencent.mm.plugin.appbrand.jsapi.nfc.b)this.pgR.activity).bTs();
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
          localNfcAdapter.enableForegroundDispatch(this.pgR.activity, c.b(this.pgR), c.bTI(), c.bTJ());
        }
        c.a(this.pgR).set(true);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        }
      }
      c.a(this.pgR, false);
      AppMethodBeat.o(183673);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(c paramc, kotlin.g.a.b paramb, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(241640);
      Object localObject3 = this.pgR;
      Object localObject1 = this.jFa;
      Object localObject4 = c.i((c)localObject3);
      if (localObject4 == null) {
        ((kotlin.g.a.b)localObject1).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject4 == null)
      {
        AppMethodBeat.o(241640);
        return;
      }
      localObject3 = this.pgS;
      localObject1 = this.jFa;
      Object localObject5 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phq;
      localObject5 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bTM().get(localObject3);
      if (localObject5 == null) {
        ((kotlin.g.a.b)localObject1).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject5 == null)
      {
        AppMethodBeat.o(241640);
        return;
      }
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      p.k("setTimeout", "name");
      p.k(arrayOfClass, "parameterTypes");
      b.b localb = new b.b("setTimeout", arrayOfClass);
      localObject3 = (Boolean)((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject5).phl.get(localb);
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = (Boolean)((kotlin.g.a.a)new b.c(localb, (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject5, "setTimeout", arrayOfClass)).invoke();
      }
      p.j(localObject1, "MethodSignature(name, pa…            }()\n        }");
      if (!((Boolean)localObject1).booleanValue())
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, " + ((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject5).pfR + ".setTimeout is not supported");
        this.jFa.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(241640);
        return;
      }
      localObject3 = this.jFa;
      Object localObject2;
      try
      {
        localObject1 = org.a.a.ce(org.a.a.bIA(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject5).phm)).t("get", new Object[] { localObject4 }).object;
        if (localObject1 == null)
        {
          localObject1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(241640);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        ((kotlin.g.a.b)localObject3).invoke(new e.a(13015, "unavailable tech"));
        for (TagTechnology localTagTechnology = null; localTagTechnology == null; localTagTechnology = (TagTechnology)localTagTechnology)
        {
          AppMethodBeat.o(241640);
          return;
        }
        try
        {
          org.a.a.gY(localTagTechnology).t("setTimeout", new Object[] { Integer.valueOf(this.pgV) });
          this.jFa.invoke(new e.b(x.aazN));
          AppMethodBeat.o(241640);
          return;
        }
        catch (Exception localException2)
        {
          localObject2 = c.g((Throwable)localException2);
          Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout failed since ".concat(String.valueOf(localObject2)));
          localObject3 = this.jFa;
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
        AppMethodBeat.o(241640);
        return;
        label503:
        localObject2 = null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class k
    implements Runnable
  {
    public k(c paramc, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(183675);
      if (c.a(this.pgR).get())
      {
        this.jFa.invoke(new e.a(13021, "NFC discovery already started"));
        AppMethodBeat.o(183675);
        return;
      }
      try
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
        if (localNfcAdapter == null) {
          p.iCn();
        }
        localNfcAdapter.enableForegroundDispatch(this.pgR.activity, c.b(this.pgR), c.bTI(), c.bTJ());
        c.c(this.pgR);
        this.jFa.invoke(new e.b(x.aazN));
        c.a(this.pgR).set(true);
        c.d(this.pgR);
        AppMethodBeat.o(183675);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        this.jFa.invoke(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183675);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(c paramc, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(183676);
      c.a(this.pgR, false);
      if (!c.a(this.pgR).get())
      {
        this.jFa.invoke(new e.a(13018, "NFC discovery has not started"));
        AppMethodBeat.o(183676);
        return;
      }
      try
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
        if (localNfcAdapter == null) {
          p.iCn();
        }
        localNfcAdapter.disableForegroundDispatch(this.pgR.activity);
        c.f(this.pgR);
        this.jFa.invoke(new e.b(x.aazN));
        c.a(this.pgR).set(false);
        c.g(this.pgR);
        AppMethodBeat.o(183676);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        this.jFa.invoke(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183676);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class m
    implements Runnable
  {
    public m(c paramc, kotlin.g.a.b paramb, String paramString, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(183677);
      Object localObject1 = this.pgR;
      Object localObject4 = this.jFa;
      localObject1 = c.i((c)localObject1);
      if (localObject1 == null) {
        ((kotlin.g.a.b)localObject4).invoke(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(183677);
        return;
      }
      Object localObject5 = this.pgS;
      localObject4 = this.jFa;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phq;
      localObject5 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.bTM().get(localObject5);
      if (localObject5 == null) {
        ((kotlin.g.a.b)localObject4).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject5 == null)
      {
        AppMethodBeat.o(183677);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.phj == localObject5)
      {
        this.jFa.invoke(new e.a(13024, "function not support"));
        AppMethodBeat.o(183677);
        return;
      }
      localObject4 = this.jFa;
      Object localObject3;
      try
      {
        localObject1 = org.a.a.ce(org.a.a.bIA(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject5).phm)).t("get", new Object[] { localObject1 }).object;
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
          localObject4 = (byte[])org.a.a.gY(localObject2).t("transceive", new Object[] { this.pgW }).object;
          localObject5 = new StringBuilder("transceive, rspData: ");
          if (localObject4 != null)
          {
            localObject2 = Arrays.toString((byte[])localObject4);
            p.j(localObject2, "java.util.Arrays.toString(this)");
          }
          for (;;)
          {
            Log.d("MicroMsg.AppBrand.NFCReadWriteManager", (String)localObject2);
            localObject2 = this.jFa;
            p.j(localObject4, "rspData");
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
          localObject4 = this.jFa;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(c paramc, kotlin.g.a.b paramb, NdefMessage paramNdefMessage) {}
    
    public final void run()
    {
      AppMethodBeat.i(183678);
      Object localObject2 = this.pgR;
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
        paramb.invoke(new e.b(x.aazN));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c
 * JD-Core Version:    0.7.0.1
 */