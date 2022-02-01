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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.a.m;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "appId", "", "activity", "Landroid/app/Activity;", "(Ljava/lang/String;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "activityEventInterceptor", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "getAppId", "()Ljava/lang/String;", "connectedTech", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "kotlin.jvm.PlatformType", "", "isActivityEventInterceptorAdded", "isLifeCycleListenerAdded", "isNFCDiscovering", "isNFCDiscoverySticky", "lifeCycleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1;", "nfcTagDiscoveredCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "techs", "Landroid/nfc/NdefMessage;", "ndefMessages", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCTagDiscoveredCallback;", "getNfcTagDiscoveredCallback", "()Lkotlin/jvm/functions/Function2;", "setNfcTagDiscoveredCallback", "(Lkotlin/jvm/functions/Function2;)V", "pendingIntent", "Landroid/app/PendingIntent;", "tag", "Landroid/nfc/Tag;", "addActivityEventInterceptorOnce", "addLifeCycleListenerOnce", "close", "techName", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "connect", "execTechLogic", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execTechLogicAsync", "getMaxTransceiveLength", "", "getNFCTech", "T", "getTag", "getTagTechnology", "Landroid/nfc/tech/TagTechnology;", "nfcTech", "tagSnapshot", "isConnected", "removeActivityEventInterceptorIfNecessary", "removeLifeCycleListenerIfNecessary", "setTimeout", "timeoutMs", "startNFCDiscovery", "stopNFCDiscovery", "transceive", "reqData", "", "tryDispatchNfcTagDiscovered", "intent", "tryParseMessageMap", "writeNdefMessage", "message", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class c
{
  private static final Map<String, c> kDA;
  private static final IntentFilter[] kDB;
  private static final String[][] kDC;
  public static final a kDD;
  final Activity activity;
  final String appId;
  public volatile m<? super List<String>, ? super List<NdefMessage>, y> kDr;
  private boolean kDs;
  private final d.g.a.b<Intent, Boolean> kDt;
  private boolean kDu;
  private boolean kDv;
  private boolean kDw;
  private final h kDx;
  private volatile Tag kDy;
  private final Set<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b> kDz;
  private final PendingIntent pendingIntent;
  
  static
  {
    AppMethodBeat.i(183681);
    kDD = new a((byte)0);
    kDA = (Map)new ConcurrentHashMap();
    Object localObject = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
    try
    {
      ((IntentFilter)localObject).addDataType("*/*");
      kDB = new IntentFilter[] { localObject };
      String[] arrayOfString1 = { NfcA.class.getName() };
      String[] arrayOfString2 = { NfcB.class.getName() };
      String[] arrayOfString3 = { IsoDep.class.getName() };
      localObject = NfcF.class.getName();
      String[] arrayOfString4 = { NfcV.class.getName() };
      String str1 = MifareClassic.class.getName();
      String str2 = MifareUltralight.class.getName();
      String[] arrayOfString5 = { Ndef.class.getName() };
      kDC = (String[][])new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, { localObject }, arrayOfString4, { str1 }, { str2 }, arrayOfString5 };
      AppMethodBeat.o(183681);
      return;
    }
    catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
    {
      for (;;)
      {
        ac.w("MicroMsg.AppBrand.NFCReadWriteManager", "addDataType failed");
      }
    }
  }
  
  public c(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(183680);
    this.appId = paramString;
    this.activity = paramActivity;
    paramString = new Intent((Context)this.activity, this.activity.getClass()).addFlags(536870912);
    this.pendingIntent = PendingIntent.getActivity((Context)this.activity, 0, paramString, 0);
    this.kDt = ((d.g.a.b)new b(this));
    this.kDx = new h(this);
    this.kDz = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    g.a(this.appId, (g.c)new g.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(183669);
        super.onDestroy();
        ac.d("MicroMsg.AppBrand.NFCReadWriteManager", "onDestroy");
        c.bij().remove(this.kDE.appId);
        AppMethodBeat.o(183669);
      }
    });
    AppMethodBeat.o(183680);
  }
  
  private static List<NdefMessage> E(Intent paramIntent)
  {
    AppMethodBeat.i(200906);
    ac.d("MicroMsg.AppBrand.NFCReadWriteManager", "tryParseMessageMap");
    paramIntent = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
    if (paramIntent != null)
    {
      Object localObject = new StringBuilder("tryDispatchNdefMessagesRead, rawMessages: ");
      String str = Arrays.toString(paramIntent);
      k.g(str, "java.util.Arrays.toString(this)");
      ac.i("MicroMsg.AppBrand.NFCReadWriteManager", str);
      localObject = (Collection)new ArrayList(paramIntent.length);
      int j = paramIntent.length;
      int i = 0;
      while (i < j)
      {
        str = paramIntent[i];
        if (str == null)
        {
          paramIntent = new v("null cannot be cast to non-null type android.nfc.NdefMessage");
          AppMethodBeat.o(200906);
          throw paramIntent;
        }
        ((Collection)localObject).add((NdefMessage)str);
        i += 1;
      }
      paramIntent = (List)localObject;
      AppMethodBeat.o(200906);
      return paramIntent;
    }
    AppMethodBeat.o(200906);
    return null;
  }
  
  public final void a(final NdefMessage paramNdefMessage, final d.g.a.b<? super e<y>, y> paramb)
  {
    AppMethodBeat.i(183679);
    k.h(paramNdefMessage, "message");
    k.h(paramb, "callback");
    ac.d("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage, message: ".concat(String.valueOf(paramNdefMessage)));
    h.JZN.f((Runnable)new m(this, paramb, paramNdefMessage), "NFC-IO");
    AppMethodBeat.o(183679);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion;", "", "()V", "METHOD_NAME_GET", "", "METHOD_NAME_GET_MAX_TRANSCEIVE_LENGTH", "METHOD_NAME_SET_TIMEOUT", "METHOD_NAME_TRANSCEIVE", "NFC_IO_LOOP_TAG", "TAG", "appId2ManagerMap", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "intentFiltersArray", "", "Landroid/content/IntentFilter;", "[Landroid/content/IntentFilter;", "techListsArray", "kotlin.jvm.PlatformType", "[[Ljava/lang/String;", "get", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a
  {
    public static c w(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
    {
      AppMethodBeat.i(183670);
      k.h(paramc, "component");
      Object localObject2 = (c)c.bij().get(paramc.getAppId());
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.sdk.f.a.jg(paramc.getContext());
        if (localObject1 != null)
        {
          localObject2 = paramc.getAppId();
          k.g(localObject2, "component.appId");
          k.g(localObject1, "activity");
          localObject1 = new c((String)localObject2, (Activity)localObject1);
          localObject2 = c.bij();
          paramc = paramc.getAppId();
          k.g(paramc, "component.appId");
          ((Map)localObject2).put(paramc, localObject1);
          AppMethodBeat.o(183670);
          return localObject1;
        }
        localObject1 = null;
      }
      AppMethodBeat.o(183670);
      return localObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "intent", "Landroid/content/Intent;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Intent, Boolean>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(200901);
      Object localObject1 = this.kDE;
      Object localObject3 = this.fPt;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject3).ay(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(200901);
        return;
      }
      localObject3 = this.kDF;
      d.g.a.b localb = this.fPt;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kEd;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bik().get(localObject3);
      if (localObject3 == null) {
        localb.ay(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(200901);
        return;
      }
      if (!c.g(this.kDE).contains(localObject3))
      {
        this.fPt.ay(new e.a(13023, "Tech has not connected"));
        AppMethodBeat.o(200901);
        return;
      }
      localb = this.fPt;
      Object localObject2;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bD(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).kDZ)).y("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          AppMethodBeat.o(200901);
          return;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localb.ay(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
      }
      try
      {
        localObject2.close();
        c.g(this.kDE).remove(localObject3);
        this.fPt.ay(new e.b(y.KTp));
        AppMethodBeat.o(200901);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.i("MicroMsg.AppBrand.NFCReadWriteManager", "close failed since ".concat(String.valueOf(localException2)));
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(200902);
      Object localObject1 = this.kDE;
      Object localObject3 = this.fPt;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject3).ay(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(200902);
        return;
      }
      localObject3 = this.kDF;
      d.g.a.b localb = this.fPt;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kEd;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bik().get(localObject3);
      if (localObject3 == null) {
        localb.ay(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(200902);
        return;
      }
      if (c.g(this.kDE).contains(localObject3))
      {
        this.fPt.ay(new e.a(13022, "Tech already connected"));
        AppMethodBeat.o(200902);
        return;
      }
      localb = this.fPt;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bD(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).kDZ)).y("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          AppMethodBeat.o(200902);
          return;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        for (;;)
        {
          localb.ay(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
        try
        {
          localObject2.connect();
          c.g(this.kDE).add(localObject3);
          this.fPt.ay(new e.b(y.KTp));
          AppMethodBeat.o(200902);
          return;
        }
        catch (Exception localException2)
        {
          ac.w("MicroMsg.AppBrand.NFCReadWriteManager", "connect failed since ".concat(String.valueOf(localException2)));
          this.fPt.ay(new e.a(13017, "system internal error"));
          AppMethodBeat.o(200902);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class e
    implements Runnable
  {
    public e(c paramc, d.g.a.b paramb, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(200903);
      Object localObject1 = this.kDE;
      Object localObject2 = this.fPt;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject2).ay(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(200903);
        return;
      }
      Object localObject3 = this.kDF;
      localObject2 = this.fPt;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kEd;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bik().get(localObject3);
      if (localObject3 == null) {
        ((d.g.a.b)localObject2).ay(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(200903);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).kEa;
      if (localObject2 == null)
      {
        this.fPt.ay(new e.a(13024, "function not support"));
        AppMethodBeat.o(200903);
        return;
      }
      ((a)localObject2).a((Tag)localObject1, this.kDG, this.fPt);
      AppMethodBeat.o(200903);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(183672);
      Object localObject1 = this.kDE;
      d.g.a.b localb = this.fPt;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        localb.ay(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(183672);
        return;
      }
      Object localObject3 = this.kDF;
      localb = this.fPt;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kEd;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bik().get(localObject3);
      if (localObject3 == null) {
        localb.ay(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(183672);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kDW == localObject3)
      {
        this.fPt.ay(new e.a(13024, "function not support"));
        AppMethodBeat.o(183672);
        return;
      }
      localb = this.fPt;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bD(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).kDZ)).y("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          AppMethodBeat.o(183672);
          return;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        for (;;)
        {
          localb.ay(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
        try
        {
          localObject2 = (Integer)org.a.a.gc(localObject2).aXD("getMaxTransceiveLength").object;
          localb = this.fPt;
          k.g(localObject2, "length");
          localb.ay(new e.b(localObject2));
          AppMethodBeat.o(183672);
          return;
        }
        catch (Exception localException2)
        {
          ac.w("MicroMsg.AppBrand.NFCReadWriteManager", "getMaxTransceiveLength failed since ".concat(String.valueOf(localException2)));
          this.fPt.ay(new e.a(13017, "system internal error"));
          AppMethodBeat.o(183672);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(200904);
      Object localObject1 = this.kDE;
      d.g.a.b localb = this.fPt;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        localb.ay(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(200904);
        return;
      }
      Object localObject3 = this.kDF;
      localb = this.fPt;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kEd;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bik().get(localObject3);
      if (localObject3 == null) {
        localb.ay(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(200904);
        return;
      }
      localb = this.fPt;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bD(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).kDZ)).y("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          AppMethodBeat.o(200904);
          return;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        for (;;)
        {
          localb.ay(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
        try
        {
          this.fPt.ay(new e.b(Boolean.valueOf(localObject2.isConnected())));
          AppMethodBeat.o(200904);
          return;
        }
        catch (Exception localException2)
        {
          ac.i("MicroMsg.AppBrand.NFCReadWriteManager", "check isConnected failed since ".concat(String.valueOf(localException2)));
          this.fPt.ay(new e.a(13017, "system internal error"));
          AppMethodBeat.o(200904);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onPause", "", "type", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$PauseType;", "onResume", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class h
    extends g.c
  {
    public final void a(g.d paramd)
    {
      AppMethodBeat.i(183674);
      super.a(paramd);
      ac.d("MicroMsg.AppBrand.NFCReadWriteManager", "onPause");
      if (c.a(this.kDE)) {
        ac.i("MicroMsg.AppBrand.NFCReadWriteManager", "onPause, isNFCDiscovering");
      }
      try
      {
        ac.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        paramd = NfcAdapter.getDefaultAdapter(ai.getContext());
        if (paramd != null) {
          paramd.disableForegroundDispatch(this.kDE.activity);
        }
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          ac.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(paramd)));
        }
      }
      c.a(this.kDE, false);
      c.b(this.kDE, true);
      AppMethodBeat.o(183674);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(183673);
      super.onResume();
      ac.d("MicroMsg.AppBrand.NFCReadWriteManager", "onResume");
      if (c.i(this.kDE)) {
        ac.i("MicroMsg.AppBrand.NFCReadWriteManager", "onResume, isNFCDiscoverySticky");
      }
      try
      {
        ac.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(ai.getContext());
        if (localNfcAdapter != null) {
          localNfcAdapter.enableForegroundDispatch(this.kDE.activity, c.b(this.kDE), c.bih(), c.bii());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        }
      }
      c.a(this.kDE, true);
      c.b(this.kDE, false);
      AppMethodBeat.o(183673);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class i
    implements Runnable
  {
    public i(c paramc, d.g.a.b paramb, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(200905);
      Object localObject3 = this.kDE;
      Object localObject1 = this.fPt;
      Tag localTag = c.h((c)localObject3);
      if (localTag == null) {
        ((d.g.a.b)localObject1).ay(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localTag == null)
      {
        AppMethodBeat.o(200905);
        return;
      }
      localObject3 = this.kDF;
      localObject1 = this.fPt;
      Object localObject4 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kEd;
      localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bik().get(localObject3);
      if (localObject4 == null) {
        ((d.g.a.b)localObject1).ay(new e.a(13014, "invalid tech"));
      }
      if (localObject4 == null)
      {
        AppMethodBeat.o(200905);
        return;
      }
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      k.h("setTimeout", "name");
      k.h(arrayOfClass, "parameterTypes");
      b.b localb = new b.b("setTimeout", arrayOfClass);
      localObject3 = (Boolean)((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject4).kDY.get(localb);
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = (Boolean)((d.g.a.a)new b.c(localb, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject4, "setTimeout", arrayOfClass)).invoke();
      }
      k.g(localObject1, "MethodSignature(name, pa…            }()\n        }");
      if (!((Boolean)localObject1).booleanValue())
      {
        ac.i("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, " + ((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject4).kCG + ".setTimeout is not supported");
        this.fPt.ay(new e.a(13024, "function not support"));
        AppMethodBeat.o(200905);
        return;
      }
      localObject3 = this.fPt;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bD(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject4).kDZ)).y("get", new Object[] { localTag }).object;
        if (localObject1 == null)
        {
          AppMethodBeat.o(200905);
          return;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        for (;;)
        {
          ((d.g.a.b)localObject3).ay(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
        try
        {
          org.a.a.gc(localObject2).y("setTimeout", new Object[] { Integer.valueOf(this.kDI) });
          this.fPt.ay(new e.b(y.KTp));
          AppMethodBeat.o(200905);
          return;
        }
        catch (Exception localException2)
        {
          ac.w("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout failed since ".concat(String.valueOf(localException2)));
          this.fPt.ay(new e.a(13017, "system internal error"));
          AppMethodBeat.o(200905);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(c paramc, d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(183675);
      if (c.a(this.kDE))
      {
        this.fPt.ay(new e.a(13021, "NFC discovery already started"));
        AppMethodBeat.o(183675);
        return;
      }
      try
      {
        ac.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(ai.getContext());
        if (localNfcAdapter == null) {
          k.fOy();
        }
        localNfcAdapter.enableForegroundDispatch(this.kDE.activity, c.b(this.kDE), c.bih(), c.bii());
        c.c(this.kDE);
        this.fPt.ay(new e.b(y.KTp));
        c.a(this.kDE, true);
        c.d(this.kDE);
        AppMethodBeat.o(183675);
        return;
      }
      catch (Exception localException)
      {
        ac.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        this.fPt.ay(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183675);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class k
    implements Runnable
  {
    public k(c paramc, d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(183676);
      if (!c.a(this.kDE))
      {
        this.fPt.ay(new e.a(13018, "NFC discovery has not started"));
        AppMethodBeat.o(183676);
        return;
      }
      try
      {
        ac.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(ai.getContext());
        if (localNfcAdapter == null) {
          k.fOy();
        }
        localNfcAdapter.disableForegroundDispatch(this.kDE.activity);
        c.e(this.kDE);
        this.fPt.ay(new e.b(y.KTp));
        c.a(this.kDE, false);
        c.f(this.kDE);
        AppMethodBeat.o(183676);
        return;
      }
      catch (Exception localException)
      {
        ac.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        this.fPt.ay(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183676);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(c paramc, d.g.a.b paramb, String paramString, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(183677);
      Object localObject1 = this.kDE;
      Object localObject4 = this.fPt;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject4).ay(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(183677);
        return;
      }
      Object localObject5 = this.kDF;
      localObject4 = this.fPt;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kEd;
      localObject5 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bik().get(localObject5);
      if (localObject5 == null) {
        ((d.g.a.b)localObject4).ay(new e.a(13014, "invalid tech"));
      }
      if (localObject5 == null)
      {
        AppMethodBeat.o(183677);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kDW == localObject5)
      {
        this.fPt.ay(new e.a(13024, "function not support"));
        AppMethodBeat.o(183677);
        return;
      }
      localObject4 = this.fPt;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bD(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject5).kDZ)).y("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          AppMethodBeat.o(183677);
          return;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        for (;;)
        {
          ((d.g.a.b)localObject4).ay(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
        try
        {
          localObject4 = (byte[])org.a.a.gc(localObject2).y("transceive", new Object[] { this.kDJ }).object;
          localObject5 = new StringBuilder("transceive, rspData: ");
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = Arrays.toString((byte[])localObject4);
            k.g(localObject2, "java.util.Arrays.toString(this)");
          }
          ac.d("MicroMsg.AppBrand.NFCReadWriteManager", (String)localObject2);
          localObject2 = this.fPt;
          k.g(localObject4, "rspData");
          ((d.g.a.b)localObject2).ay(new e.b(localObject4));
          AppMethodBeat.o(183677);
          return;
        }
        catch (Exception localException2)
        {
          ac.w("MicroMsg.AppBrand.NFCReadWriteManager", "transceive failed since ".concat(String.valueOf(localException2)));
          this.fPt.ay(new e.a(13017, "system internal error"));
          AppMethodBeat.o(183677);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(c paramc, d.g.a.b paramb, NdefMessage paramNdefMessage) {}
    
    public final void run()
    {
      AppMethodBeat.i(183678);
      Object localObject2 = this.kDE;
      Object localObject1 = paramb;
      localObject2 = c.h((c)localObject2);
      if (localObject2 == null) {
        ((d.g.a.b)localObject1).ay(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(183678);
        return;
      }
      localObject1 = Ndef.get((Tag)localObject2);
      if (localObject1 == null)
      {
        paramb.ay(new e.a(13015, "unavailable tech"));
        AppMethodBeat.o(183678);
        return;
      }
      try
      {
        ((Ndef)localObject1).writeNdefMessage(paramNdefMessage);
        paramb.ay(new e.b(y.KTp));
        AppMethodBeat.o(183678);
        return;
      }
      catch (Exception localException)
      {
        ac.w("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage failed since ".concat(String.valueOf(localException)));
        paramb.ay(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183678);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c
 * JD-Core Version:    0.7.0.1
 */