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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "appId", "", "activity", "Landroid/app/Activity;", "(Ljava/lang/String;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "activityEventInterceptor", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "getAppId", "()Ljava/lang/String;", "connectedTech", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "kotlin.jvm.PlatformType", "", "isActivityEventInterceptorAdded", "isLifeCycleListenerAdded", "isNFCDiscovering", "isNFCDiscoverySticky", "lifeCycleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1;", "nfcTagDiscoveredCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "techs", "Landroid/nfc/NdefMessage;", "ndefMessages", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCTagDiscoveredCallback;", "getNfcTagDiscoveredCallback", "()Lkotlin/jvm/functions/Function2;", "setNfcTagDiscoveredCallback", "(Lkotlin/jvm/functions/Function2;)V", "pendingIntent", "Landroid/app/PendingIntent;", "tag", "Landroid/nfc/Tag;", "addActivityEventInterceptorOnce", "addLifeCycleListenerOnce", "close", "techName", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "connect", "execTechLogic", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execTechLogicAsync", "getMaxTransceiveLength", "", "getNFCTech", "T", "getTag", "getTagTechnology", "Landroid/nfc/tech/TagTechnology;", "nfcTech", "tagSnapshot", "isConnected", "removeActivityEventInterceptorIfNecessary", "removeLifeCycleListenerIfNecessary", "setTimeout", "timeoutMs", "startNFCDiscovery", "stopNFCDiscovery", "transceive", "reqData", "", "tryDispatchNfcTagDiscovered", "intent", "tryParseMessageMap", "writeNdefMessage", "message", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class c
{
  private static final Map<String, c> kcN;
  private static final IntentFilter[] kcO;
  private static final String[][] kcP;
  public static final a kcQ;
  final Activity activity;
  final String appId;
  public volatile m<? super List<String>, ? super List<NdefMessage>, y> kcE;
  private boolean kcF;
  private final d.g.a.b<Intent, Boolean> kcG;
  private boolean kcH;
  private boolean kcI;
  private boolean kcJ;
  private final h kcK;
  private volatile Tag kcL;
  private final Set<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b> kcM;
  private final PendingIntent pendingIntent;
  
  static
  {
    AppMethodBeat.i(183681);
    kcQ = new a((byte)0);
    kcN = (Map)new ConcurrentHashMap();
    Object localObject = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
    try
    {
      ((IntentFilter)localObject).addDataType("*/*");
      kcO = new IntentFilter[] { localObject };
      localObject = NfcA.class.getName();
      String str1 = NfcB.class.getName();
      String str2 = IsoDep.class.getName();
      String str3 = NfcF.class.getName();
      String str4 = NfcV.class.getName();
      String str5 = MifareClassic.class.getName();
      String[] arrayOfString = { MifareUltralight.class.getName() };
      String str6 = Ndef.class.getName();
      kcP = (String[][])new String[][] { { localObject }, { str1 }, { str2 }, { str3 }, { str4 }, { str5 }, arrayOfString, { str6 } };
      AppMethodBeat.o(183681);
      return;
    }
    catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
    {
      for (;;)
      {
        ad.w("MicroMsg.AppBrand.NFCReadWriteManager", "addDataType failed");
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
    this.kcG = ((d.g.a.b)new b(this));
    this.kcK = new h(this);
    this.kcM = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    g.a(this.appId, (g.c)new g.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(183669);
        super.onDestroy();
        ad.d("MicroMsg.AppBrand.NFCReadWriteManager", "onDestroy");
        c.bbr().remove(this.kcR.appId);
        AppMethodBeat.o(183669);
      }
    });
    AppMethodBeat.o(183680);
  }
  
  private static List<NdefMessage> E(Intent paramIntent)
  {
    AppMethodBeat.i(194631);
    ad.d("MicroMsg.AppBrand.NFCReadWriteManager", "tryParseMessageMap");
    paramIntent = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
    if (paramIntent != null)
    {
      Object localObject = new StringBuilder("tryDispatchNdefMessagesRead, rawMessages: ");
      String str = Arrays.toString(paramIntent);
      k.g(str, "java.util.Arrays.toString(this)");
      ad.i("MicroMsg.AppBrand.NFCReadWriteManager", str);
      localObject = (Collection)new ArrayList(paramIntent.length);
      int j = paramIntent.length;
      int i = 0;
      while (i < j)
      {
        str = paramIntent[i];
        if (str == null)
        {
          paramIntent = new v("null cannot be cast to non-null type android.nfc.NdefMessage");
          AppMethodBeat.o(194631);
          throw paramIntent;
        }
        ((Collection)localObject).add((NdefMessage)str);
        i += 1;
      }
      paramIntent = (List)localObject;
      AppMethodBeat.o(194631);
      return paramIntent;
    }
    AppMethodBeat.o(194631);
    return null;
  }
  
  public final void a(final NdefMessage paramNdefMessage, final d.g.a.b<? super e<y>, y> paramb)
  {
    AppMethodBeat.i(183679);
    k.h(paramNdefMessage, "message");
    k.h(paramb, "callback");
    ad.d("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage, message: ".concat(String.valueOf(paramNdefMessage)));
    h.Iye.f((Runnable)new m(this, paramb, paramNdefMessage), "NFC-IO");
    AppMethodBeat.o(183679);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion;", "", "()V", "METHOD_NAME_GET", "", "METHOD_NAME_GET_MAX_TRANSCEIVE_LENGTH", "METHOD_NAME_SET_TIMEOUT", "METHOD_NAME_TRANSCEIVE", "NFC_IO_LOOP_TAG", "TAG", "appId2ManagerMap", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "intentFiltersArray", "", "Landroid/content/IntentFilter;", "[Landroid/content/IntentFilter;", "techListsArray", "kotlin.jvm.PlatformType", "[[Ljava/lang/String;", "get", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a
  {
    public static c w(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
    {
      AppMethodBeat.i(183670);
      k.h(paramc, "component");
      Object localObject2 = (c)c.bbr().get(paramc.getAppId());
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.sdk.f.a.iV(paramc.getContext());
        if (localObject1 != null)
        {
          localObject2 = paramc.getAppId();
          k.g(localObject2, "component.appId");
          k.g(localObject1, "activity");
          localObject1 = new c((String)localObject2, (Activity)localObject1);
          localObject2 = c.bbr();
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "intent", "Landroid/content/Intent;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Intent, Boolean>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(194626);
      Object localObject1 = this.kcR;
      Object localObject3 = this.fLH;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject3).aA(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(194626);
        return;
      }
      localObject3 = this.kcS;
      d.g.a.b localb = this.fLH;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kdq;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bbs().get(localObject3);
      if (localObject3 == null) {
        localb.aA(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(194626);
        return;
      }
      if (!c.g(this.kcR).contains(localObject3))
      {
        this.fLH.aA(new e.a(13023, "Tech has not connected"));
        AppMethodBeat.o(194626);
        return;
      }
      localb = this.fLH;
      Object localObject2;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bA(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).kdm)).x("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          AppMethodBeat.o(194626);
          return;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localb.aA(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
      }
      try
      {
        localObject2.close();
        c.g(this.kcR).remove(localObject3);
        this.fLH.aA(new e.b(y.JfV));
        AppMethodBeat.o(194626);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.i("MicroMsg.AppBrand.NFCReadWriteManager", "close failed since ".concat(String.valueOf(localException2)));
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(194627);
      Object localObject1 = this.kcR;
      Object localObject3 = this.fLH;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject3).aA(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(194627);
        return;
      }
      localObject3 = this.kcS;
      d.g.a.b localb = this.fLH;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kdq;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bbs().get(localObject3);
      if (localObject3 == null) {
        localb.aA(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(194627);
        return;
      }
      if (c.g(this.kcR).contains(localObject3))
      {
        this.fLH.aA(new e.a(13022, "Tech already connected"));
        AppMethodBeat.o(194627);
        return;
      }
      localb = this.fLH;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bA(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).kdm)).x("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          AppMethodBeat.o(194627);
          return;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        for (;;)
        {
          localb.aA(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
        try
        {
          localObject2.connect();
          c.g(this.kcR).add(localObject3);
          this.fLH.aA(new e.b(y.JfV));
          AppMethodBeat.o(194627);
          return;
        }
        catch (Exception localException2)
        {
          ad.w("MicroMsg.AppBrand.NFCReadWriteManager", "connect failed since ".concat(String.valueOf(localException2)));
          this.fLH.aA(new e.a(13017, "system internal error"));
          AppMethodBeat.o(194627);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class e
    implements Runnable
  {
    public e(c paramc, d.g.a.b paramb, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(194628);
      Object localObject1 = this.kcR;
      Object localObject2 = this.fLH;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject2).aA(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(194628);
        return;
      }
      Object localObject3 = this.kcS;
      localObject2 = this.fLH;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kdq;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bbs().get(localObject3);
      if (localObject3 == null) {
        ((d.g.a.b)localObject2).aA(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(194628);
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).kdn;
      if (localObject2 == null)
      {
        this.fLH.aA(new e.a(13024, "function not support"));
        AppMethodBeat.o(194628);
        return;
      }
      ((a)localObject2).a((Tag)localObject1, this.kcT, this.fLH);
      AppMethodBeat.o(194628);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(183672);
      Object localObject1 = this.kcR;
      d.g.a.b localb = this.fLH;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        localb.aA(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(183672);
        return;
      }
      Object localObject3 = this.kcS;
      localb = this.fLH;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kdq;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bbs().get(localObject3);
      if (localObject3 == null) {
        localb.aA(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(183672);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kdj == localObject3)
      {
        this.fLH.aA(new e.a(13024, "function not support"));
        AppMethodBeat.o(183672);
        return;
      }
      localb = this.fLH;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bA(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).kdm)).x("get", new Object[] { localObject1 }).object;
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
          localb.aA(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
        try
        {
          localObject2 = (Integer)org.a.a.fU(localObject2).aRD("getMaxTransceiveLength").object;
          localb = this.fLH;
          k.g(localObject2, "length");
          localb.aA(new e.b(localObject2));
          AppMethodBeat.o(183672);
          return;
        }
        catch (Exception localException2)
        {
          ad.w("MicroMsg.AppBrand.NFCReadWriteManager", "getMaxTransceiveLength failed since ".concat(String.valueOf(localException2)));
          this.fLH.aA(new e.a(13017, "system internal error"));
          AppMethodBeat.o(183672);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(c paramc, d.g.a.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(194629);
      Object localObject1 = this.kcR;
      d.g.a.b localb = this.fLH;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        localb.aA(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(194629);
        return;
      }
      Object localObject3 = this.kcS;
      localb = this.fLH;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kdq;
      localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bbs().get(localObject3);
      if (localObject3 == null) {
        localb.aA(new e.a(13014, "invalid tech"));
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(194629);
        return;
      }
      localb = this.fLH;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bA(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject3).kdm)).x("get", new Object[] { localObject1 }).object;
        if (localObject1 == null)
        {
          AppMethodBeat.o(194629);
          return;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        for (;;)
        {
          localb.aA(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
        try
        {
          this.fLH.aA(new e.b(Boolean.valueOf(localObject2.isConnected())));
          AppMethodBeat.o(194629);
          return;
        }
        catch (Exception localException2)
        {
          ad.i("MicroMsg.AppBrand.NFCReadWriteManager", "check isConnected failed since ".concat(String.valueOf(localException2)));
          this.fLH.aA(new e.a(13017, "system internal error"));
          AppMethodBeat.o(194629);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onPause", "", "type", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$PauseType;", "onResume", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class h
    extends g.c
  {
    public final void a(g.d paramd)
    {
      AppMethodBeat.i(183674);
      super.a(paramd);
      ad.d("MicroMsg.AppBrand.NFCReadWriteManager", "onPause");
      if (c.a(this.kcR)) {
        ad.i("MicroMsg.AppBrand.NFCReadWriteManager", "onPause, isNFCDiscovering");
      }
      try
      {
        ad.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        paramd = NfcAdapter.getDefaultAdapter(aj.getContext());
        if (paramd != null) {
          paramd.disableForegroundDispatch(this.kcR.activity);
        }
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          ad.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(paramd)));
        }
      }
      c.a(this.kcR, false);
      c.b(this.kcR, true);
      AppMethodBeat.o(183674);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(183673);
      super.onResume();
      ad.d("MicroMsg.AppBrand.NFCReadWriteManager", "onResume");
      if (c.i(this.kcR)) {
        ad.i("MicroMsg.AppBrand.NFCReadWriteManager", "onResume, isNFCDiscoverySticky");
      }
      try
      {
        ad.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(aj.getContext());
        if (localNfcAdapter != null) {
          localNfcAdapter.enableForegroundDispatch(this.kcR.activity, c.b(this.kcR), c.bbp(), c.bbq());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        }
      }
      c.a(this.kcR, true);
      c.b(this.kcR, false);
      AppMethodBeat.o(183673);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class i
    implements Runnable
  {
    public i(c paramc, d.g.a.b paramb, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(194630);
      Object localObject3 = this.kcR;
      Object localObject1 = this.fLH;
      Tag localTag = c.h((c)localObject3);
      if (localTag == null) {
        ((d.g.a.b)localObject1).aA(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localTag == null)
      {
        AppMethodBeat.o(194630);
        return;
      }
      localObject3 = this.kcS;
      localObject1 = this.fLH;
      Object localObject4 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kdq;
      localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bbs().get(localObject3);
      if (localObject4 == null) {
        ((d.g.a.b)localObject1).aA(new e.a(13014, "invalid tech"));
      }
      if (localObject4 == null)
      {
        AppMethodBeat.o(194630);
        return;
      }
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      k.h("setTimeout", "name");
      k.h(arrayOfClass, "parameterTypes");
      b.b localb = new b.b("setTimeout", arrayOfClass);
      localObject3 = (Boolean)((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject4).kdl.get(localb);
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = (Boolean)((d.g.a.a)new b.c(localb, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject4, "setTimeout", arrayOfClass)).invoke();
      }
      k.g(localObject1, "MethodSignature(name, pa…            }()\n        }");
      if (!((Boolean)localObject1).booleanValue())
      {
        ad.i("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, " + ((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject4).kbT + ".setTimeout is not supported");
        this.fLH.aA(new e.a(13024, "function not support"));
        AppMethodBeat.o(194630);
        return;
      }
      localObject3 = this.fLH;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bA(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject4).kdm)).x("get", new Object[] { localTag }).object;
        if (localObject1 == null)
        {
          AppMethodBeat.o(194630);
          return;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        for (;;)
        {
          ((d.g.a.b)localObject3).aA(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
        try
        {
          org.a.a.fU(localObject2).x("setTimeout", new Object[] { Integer.valueOf(this.kcV) });
          this.fLH.aA(new e.b(y.JfV));
          AppMethodBeat.o(194630);
          return;
        }
        catch (Exception localException2)
        {
          ad.w("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout failed since ".concat(String.valueOf(localException2)));
          this.fLH.aA(new e.a(13017, "system internal error"));
          AppMethodBeat.o(194630);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class j
    implements Runnable
  {
    public j(c paramc, d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(183675);
      if (c.a(this.kcR))
      {
        this.fLH.aA(new e.a(13021, "NFC discovery already started"));
        AppMethodBeat.o(183675);
        return;
      }
      try
      {
        ad.i("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(aj.getContext());
        if (localNfcAdapter == null) {
          k.fvU();
        }
        localNfcAdapter.enableForegroundDispatch(this.kcR.activity, c.b(this.kcR), c.bbp(), c.bbq());
        c.c(this.kcR);
        this.fLH.aA(new e.b(y.JfV));
        c.a(this.kcR, true);
        c.d(this.kcR);
        AppMethodBeat.o(183675);
        return;
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        this.fLH.aA(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183675);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class k
    implements Runnable
  {
    public k(c paramc, d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(183676);
      if (!c.a(this.kcR))
      {
        this.fLH.aA(new e.a(13018, "NFC discovery has not started"));
        AppMethodBeat.o(183676);
        return;
      }
      try
      {
        ad.i("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(aj.getContext());
        if (localNfcAdapter == null) {
          k.fvU();
        }
        localNfcAdapter.disableForegroundDispatch(this.kcR.activity);
        c.e(this.kcR);
        this.fLH.aA(new e.b(y.JfV));
        c.a(this.kcR, false);
        c.f(this.kcR);
        AppMethodBeat.o(183676);
        return;
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch failed since ".concat(String.valueOf(localException)));
        this.fLH.aA(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183676);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class l
    implements Runnable
  {
    public l(c paramc, d.g.a.b paramb, String paramString, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(183677);
      Object localObject1 = this.kcR;
      Object localObject4 = this.fLH;
      localObject1 = c.h((c)localObject1);
      if (localObject1 == null) {
        ((d.g.a.b)localObject4).aA(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(183677);
        return;
      }
      Object localObject5 = this.kcS;
      localObject4 = this.fLH;
      b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kdq;
      localObject5 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.bbs().get(localObject5);
      if (localObject5 == null) {
        ((d.g.a.b)localObject4).aA(new e.a(13014, "invalid tech"));
      }
      if (localObject5 == null)
      {
        AppMethodBeat.o(183677);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.kdj == localObject5)
      {
        this.fLH.aA(new e.a(13024, "function not support"));
        AppMethodBeat.o(183677);
        return;
      }
      localObject4 = this.fLH;
      try
      {
        localObject1 = (TagTechnology)org.a.a.bA(org.a.a.forName(((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b)localObject5).kdm)).x("get", new Object[] { localObject1 }).object;
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
          ((d.g.a.b)localObject4).aA(new e.a(13015, "unavailable tech"));
          localObject2 = null;
        }
        try
        {
          localObject4 = (byte[])org.a.a.fU(localObject2).x("transceive", new Object[] { this.kcW }).object;
          localObject5 = new StringBuilder("transceive, rspData: ");
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = Arrays.toString((byte[])localObject4);
            k.g(localObject2, "java.util.Arrays.toString(this)");
          }
          ad.d("MicroMsg.AppBrand.NFCReadWriteManager", (String)localObject2);
          localObject2 = this.fLH;
          k.g(localObject4, "rspData");
          ((d.g.a.b)localObject2).aA(new e.b(localObject4));
          AppMethodBeat.o(183677);
          return;
        }
        catch (Exception localException2)
        {
          ad.w("MicroMsg.AppBrand.NFCReadWriteManager", "transceive failed since ".concat(String.valueOf(localException2)));
          this.fLH.aA(new e.a(13017, "system internal error"));
          AppMethodBeat.o(183677);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(c paramc, d.g.a.b paramb, NdefMessage paramNdefMessage) {}
    
    public final void run()
    {
      AppMethodBeat.i(183678);
      Object localObject2 = this.kcR;
      Object localObject1 = paramb;
      localObject2 = c.h((c)localObject2);
      if (localObject2 == null) {
        ((d.g.a.b)localObject1).aA(new e.a(13013, "NFC tag has not been discovered"));
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(183678);
        return;
      }
      localObject1 = Ndef.get((Tag)localObject2);
      if (localObject1 == null)
      {
        paramb.aA(new e.a(13015, "unavailable tech"));
        AppMethodBeat.o(183678);
        return;
      }
      try
      {
        ((Ndef)localObject1).writeNdefMessage(paramNdefMessage);
        paramb.aA(new e.b(y.JfV));
        AppMethodBeat.o(183678);
        return;
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage failed since ".concat(String.valueOf(localException)));
        paramb.aA(new e.a(13017, "system internal error"));
        AppMethodBeat.o(183678);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c
 * JD-Core Version:    0.7.0.1
 */