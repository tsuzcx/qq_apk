package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.TagTechnology;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.b;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.threadpool.i;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "appId", "", "nfcDiscoverable", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCDiscoverable;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCDiscoverable;)V", "connectedTech", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "getConnectedTech", "()Ljava/util/Set;", "value", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "id", "", "techs", "Landroid/nfc/NdefMessage;", "ndefMessages", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/OnDiscovery;", "nfcTagDiscoveredCallback", "getNfcTagDiscoveredCallback", "()Lkotlin/jvm/functions/Function3;", "setNfcTagDiscoveredCallback", "(Lkotlin/jvm/functions/Function3;)V", "tag", "Landroid/nfc/Tag;", "getTag", "()Landroid/nfc/Tag;", "close", "techName", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "connect", "execTechLogic", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execTechLogicAsync", "getMaxTransceiveLength", "", "getNFCTech", "T", "getTagTechnology", "Landroid/nfc/tech/TagTechnology;", "nfcTech", "tagSnapshot", "isConnected", "", "setRequireForegroundDispatch", "requireForegroundDispatch", "setTimeout", "timeoutMs", "startNFCDiscovery", "stopNFCDiscovery", "transceive", "reqData", "writeNdefMessage", "message", "wrappedThrowable", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a smq;
  private static final Map<String, g> sms;
  private static g.a.a smt;
  private final String appId;
  public final b smr;
  
  static
  {
    AppMethodBeat.i(183681);
    smq = new a((byte)0);
    sms = (Map)new ConcurrentHashMap();
    smt = (g.a.a)new b();
    AppMethodBeat.o(183681);
  }
  
  public g(String paramString, b paramb)
  {
    AppMethodBeat.i(328103);
    this.appId = paramString;
    this.smr = paramb;
    k.a(this.appId, (k.c)new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(183669);
        super.onDestroy();
        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "onDestroy");
        g.ctY().remove(g.b(this.smu));
        AppMethodBeat.o(183669);
      }
    });
    AppMethodBeat.o(328103);
  }
  
  private static final void a(g paramg, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(328130);
    s.u(paramg, "this$0");
    s.u(paramb, "$callback");
    paramg = paramg.smr.ctU();
    switch (c.$EnumSwitchMapping$0[paramg.ordinal()])
    {
    default: 
      paramb.invoke(new h.a(13017, "system internal error"));
      AppMethodBeat.o(328130);
      return;
    case 1: 
      paramb.invoke(new h.b(ah.aiuX));
      AppMethodBeat.o(328130);
      return;
    }
    paramb.invoke(new h.a(13021, "NFC discovery already started"));
    AppMethodBeat.o(328130);
  }
  
  private static final void a(g paramg, kotlin.g.a.b paramb, NdefMessage paramNdefMessage)
  {
    AppMethodBeat.i(328181);
    s.u(paramg, "this$0");
    s.u(paramb, "$callback");
    s.u(paramNdefMessage, "$message");
    paramg = paramg.ctW();
    if (paramg == null) {
      paramb.invoke(new h.a(13013, "NFC tag has not been discovered"));
    }
    if (paramg == null)
    {
      AppMethodBeat.o(328181);
      return;
    }
    paramg = Ndef.get(paramg);
    if (paramg == null)
    {
      paramb.invoke(new h.a(13015, "unavailable tech"));
      AppMethodBeat.o(328181);
      return;
    }
    try
    {
      paramg.writeNdefMessage(paramNdefMessage);
      paramb.invoke(new h.b(ah.aiuX));
      AppMethodBeat.o(328181);
      return;
    }
    catch (Exception paramg)
    {
      Log.w("MicroMsg.AppBrand.NFCReadWriteManager", s.X("writeNdefMessage failed since ", paramg));
      paramb.invoke(new h.a(13017, s.X("system internal error: ", paramg.getMessage())));
      AppMethodBeat.o(328181);
    }
  }
  
  private static final void a(g paramg, kotlin.g.a.b paramb, String paramString)
  {
    AppMethodBeat.i(328154);
    s.u(paramg, "this$0");
    s.u(paramb, "$callback");
    s.u(paramString, "$techName");
    Tag localTag = paramg.ctW();
    if (localTag == null) {
      paramb.invoke(new h.a(13013, "NFC tag has not been discovered"));
    }
    if (localTag == null)
    {
      AppMethodBeat.o(328154);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smz;
    localObject = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.ctZ().get(paramString);
    if (localObject == null) {
      paramb.invoke(new h.a(13014, "invalid tech"));
    }
    if (localObject == null)
    {
      AppMethodBeat.o(328154);
      return;
    }
    if (paramg.ctO().contains(localObject))
    {
      paramb.invoke(new h.a(13022, "Tech already connected"));
      AppMethodBeat.o(328154);
      return;
    }
    try
    {
      paramString = org.a.a.cQ(org.a.a.bLw(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject).smA)).y("get", new Object[] { localTag }).object;
      if (paramString == null)
      {
        paramString = (Throwable)new IllegalArgumentException("Required value was null.".toString());
        AppMethodBeat.o(328154);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      paramb.invoke(new h.a(13015, "unavailable tech"));
      for (paramString = null; paramString == null; paramString = (TagTechnology)paramString)
      {
        AppMethodBeat.o(328154);
        return;
      }
      try
      {
        paramString.connect();
        paramg.ctO().add(localObject);
        paramb.invoke(new h.b(ah.aiuX));
        AppMethodBeat.o(328154);
        return;
      }
      catch (Exception paramg)
      {
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", s.X("connect failed since ", paramg));
        paramb.invoke(new h.a(13017, s.X("system internal error: ", paramg.getMessage())));
        AppMethodBeat.o(328154);
      }
    }
  }
  
  private static final void a(g paramg, kotlin.g.a.b paramb, String paramString, int paramInt)
  {
    AppMethodBeat.i(328211);
    s.u(paramg, "this$0");
    s.u(paramb, "$callback");
    s.u(paramString, "$techName");
    Tag localTag = paramg.ctW();
    if (localTag == null) {
      paramb.invoke(new h.a(13013, "NFC tag has not been discovered"));
    }
    if (localTag == null)
    {
      AppMethodBeat.o(328211);
      return;
    }
    paramg = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smz;
    com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b localb = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.ctZ().get(paramString);
    if (localb == null) {
      paramb.invoke(new h.a(13014, "invalid tech"));
    }
    if (localb == null)
    {
      AppMethodBeat.o(328211);
      return;
    }
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Integer.TYPE;
    s.u("setTimeout", "name");
    s.u(arrayOfClass, "parameterTypes");
    b.b localb1 = new b.b("setTimeout", arrayOfClass);
    paramString = (Boolean)localb.smC.get(localb1);
    paramg = paramString;
    if (paramString == null) {
      paramg = Boolean.valueOf(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.a(localb, "setTimeout", arrayOfClass, localb1));
    }
    if (!paramg.booleanValue())
    {
      Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, " + localb.sln + ".setTimeout is not supported");
      paramb.invoke(new h.a(13024, "function not support"));
      AppMethodBeat.o(328211);
      return;
    }
    try
    {
      paramg = org.a.a.cQ(org.a.a.bLw(localb.smA)).y("get", new Object[] { localTag }).object;
      if (paramg == null)
      {
        paramg = (Throwable)new IllegalArgumentException("Required value was null.".toString());
        AppMethodBeat.o(328211);
        throw paramg;
      }
    }
    catch (Exception paramg)
    {
      paramb.invoke(new h.a(13015, "unavailable tech"));
      for (paramg = null; paramg == null; paramg = (TagTechnology)paramg)
      {
        AppMethodBeat.o(328211);
        return;
      }
      try
      {
        org.a.a.jP(paramg).y("setTimeout", new Object[] { Integer.valueOf(paramInt) });
        paramb.invoke(new h.b(ah.aiuX));
        AppMethodBeat.o(328211);
        return;
      }
      catch (Exception paramg)
      {
        paramg = q((Throwable)paramg);
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", s.X("setTimeout failed since ", paramg));
        if (paramg != null) {
          break label476;
        }
      }
      paramg = null;
    }
    for (;;)
    {
      paramb.invoke(new h.a(13017, s.X("system internal error: ", paramg)));
      AppMethodBeat.o(328211);
      return;
      label476:
      paramg = paramg.getMessage();
    }
  }
  
  private static final void a(g paramg, kotlin.g.a.b paramb, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.a parama)
  {
    AppMethodBeat.i(328234);
    s.u(paramg, "this$0");
    s.u(paramb, "$callback");
    s.u(paramString1, "$techName");
    s.u(paramString2, "$function");
    paramg = paramg.ctW();
    if (paramg == null) {
      paramb.invoke(new h.a(13013, "NFC tag has not been discovered"));
    }
    if (paramg == null)
    {
      AppMethodBeat.o(328234);
      return;
    }
    parama = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smz;
    paramString1 = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.ctZ().get(paramString1);
    if (paramString1 == null) {
      paramb.invoke(new h.a(13014, "invalid tech"));
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(328234);
      return;
    }
    paramString1 = paramString1.smB;
    if (paramString1 == null)
    {
      paramb.invoke(new h.a(13024, "function not support"));
      AppMethodBeat.o(328234);
      return;
    }
    paramString1.a(paramg, paramString2, paramb);
    AppMethodBeat.o(328234);
  }
  
  private static final void a(g paramg, kotlin.g.a.b paramb, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(328226);
    s.u(paramg, "this$0");
    s.u(paramb, "$callback");
    s.u(paramString, "$techName");
    s.u(paramArrayOfByte, "$reqData");
    paramg = paramg.ctW();
    if (paramg == null) {
      paramb.invoke(new h.a(13013, "NFC tag has not been discovered"));
    }
    if (paramg == null)
    {
      AppMethodBeat.o(328226);
      return;
    }
    b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smz;
    paramString = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.ctZ().get(paramString);
    if (paramString == null) {
      paramb.invoke(new h.a(13014, "invalid tech"));
    }
    if (paramString == null)
    {
      AppMethodBeat.o(328226);
      return;
    }
    if (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smM == paramString)
    {
      paramb.invoke(new h.a(13024, "function not support"));
      AppMethodBeat.o(328226);
      return;
    }
    try
    {
      paramg = org.a.a.cQ(org.a.a.bLw(paramString.smA)).y("get", new Object[] { paramg }).object;
      if (paramg == null)
      {
        paramg = (Throwable)new IllegalArgumentException("Required value was null.".toString());
        AppMethodBeat.o(328226);
        throw paramg;
      }
    }
    catch (Exception paramg)
    {
      paramb.invoke(new h.a(13015, "unavailable tech"));
      for (paramg = null; paramg == null; paramg = (TagTechnology)paramg)
      {
        AppMethodBeat.o(328226);
        return;
      }
      try
      {
        paramString = (byte[])org.a.a.jP(paramg).y("transceive", new Object[] { paramArrayOfByte }).object;
        if (paramString == null) {
          paramg = null;
        }
        for (;;)
        {
          Log.d("MicroMsg.AppBrand.NFCReadWriteManager", s.X("transceive, rspData: ", paramg));
          s.s(paramString, "rspData");
          paramb.invoke(new h.b(paramString));
          AppMethodBeat.o(328226);
          return;
          paramg = Arrays.toString(paramString);
          s.s(paramg, "java.util.Arrays.toString(this)");
        }
        paramg = null;
      }
      catch (Exception paramg)
      {
        paramg = q((Throwable)paramg);
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", s.X("transceive failed since ", paramg));
        if (paramg != null) {}
      }
    }
    for (;;)
    {
      paramb.invoke(new h.a(13017, s.X("system internal error: ", paramg)));
      AppMethodBeat.o(328226);
      return;
      paramg = paramg.getMessage();
    }
  }
  
  private static final void b(g paramg, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(328141);
    s.u(paramg, "this$0");
    s.u(paramb, "$callback");
    paramg = paramg.smr.ctV();
    switch (c.$EnumSwitchMapping$0[paramg.ordinal()])
    {
    case 2: 
    default: 
      paramb.invoke(new h.a(13017, "system internal error"));
      AppMethodBeat.o(328141);
      return;
    case 1: 
      paramb.invoke(new h.b(ah.aiuX));
      AppMethodBeat.o(328141);
      return;
    }
    paramb.invoke(new h.a(13018, "NFC discovery has not started"));
    AppMethodBeat.o(328141);
  }
  
  private static final void b(g paramg, kotlin.g.a.b paramb, String paramString)
  {
    AppMethodBeat.i(328165);
    s.u(paramg, "this$0");
    s.u(paramb, "$callback");
    s.u(paramString, "$techName");
    Tag localTag = paramg.ctW();
    if (localTag == null) {
      paramb.invoke(new h.a(13013, "NFC tag has not been discovered"));
    }
    if (localTag == null)
    {
      AppMethodBeat.o(328165);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smz;
    localObject = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.ctZ().get(paramString);
    if (localObject == null) {
      paramb.invoke(new h.a(13014, "invalid tech"));
    }
    if (localObject == null)
    {
      AppMethodBeat.o(328165);
      return;
    }
    if (!paramg.ctO().contains(localObject))
    {
      paramb.invoke(new h.a(13023, "Tech has not connected"));
      AppMethodBeat.o(328165);
      return;
    }
    try
    {
      paramString = org.a.a.cQ(org.a.a.bLw(((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)localObject).smA)).y("get", new Object[] { localTag }).object;
      if (paramString == null)
      {
        paramString = (Throwable)new IllegalArgumentException("Required value was null.".toString());
        AppMethodBeat.o(328165);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      paramb.invoke(new h.a(13015, "unavailable tech"));
      for (paramString = null; paramString == null; paramString = (TagTechnology)paramString)
      {
        AppMethodBeat.o(328165);
        return;
      }
    }
    try
    {
      paramString.close();
      paramg.ctO().remove(localObject);
      paramb.invoke(new h.b(ah.aiuX));
      AppMethodBeat.o(328165);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", s.X("close failed since ", paramString));
      }
    }
  }
  
  private static final void c(g paramg, kotlin.g.a.b paramb, String paramString)
  {
    AppMethodBeat.i(328175);
    s.u(paramg, "this$0");
    s.u(paramb, "$callback");
    s.u(paramString, "$techName");
    paramg = paramg.ctW();
    if (paramg == null) {
      paramb.invoke(new h.a(13013, "NFC tag has not been discovered"));
    }
    if (paramg == null)
    {
      AppMethodBeat.o(328175);
      return;
    }
    b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smz;
    paramString = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.ctZ().get(paramString);
    if (paramString == null) {
      paramb.invoke(new h.a(13014, "invalid tech"));
    }
    if (paramString == null)
    {
      AppMethodBeat.o(328175);
      return;
    }
    try
    {
      paramg = org.a.a.cQ(org.a.a.bLw(paramString.smA)).y("get", new Object[] { paramg }).object;
      if (paramg == null)
      {
        paramg = (Throwable)new IllegalArgumentException("Required value was null.".toString());
        AppMethodBeat.o(328175);
        throw paramg;
      }
    }
    catch (Exception paramg)
    {
      paramb.invoke(new h.a(13015, "unavailable tech"));
      for (paramg = null; paramg == null; paramg = (TagTechnology)paramg)
      {
        AppMethodBeat.o(328175);
        return;
      }
      try
      {
        paramb.invoke(new h.b(Boolean.valueOf(paramg.isConnected())));
        AppMethodBeat.o(328175);
        return;
      }
      catch (Exception paramg)
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", s.X("check isConnected failed since ", paramg));
        paramb.invoke(new h.a(13017, s.X("system internal error: ", paramg.getMessage())));
        AppMethodBeat.o(328175);
      }
    }
  }
  
  private final Set<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b> ctO()
  {
    AppMethodBeat.i(328115);
    Set localSet = this.smr.ctO();
    AppMethodBeat.o(328115);
    return localSet;
  }
  
  private final Tag ctW()
  {
    AppMethodBeat.i(328108);
    Tag localTag = this.smr.ctW();
    AppMethodBeat.o(328108);
    return localTag;
  }
  
  private static final void d(g paramg, kotlin.g.a.b paramb, String paramString)
  {
    AppMethodBeat.i(328195);
    s.u(paramg, "this$0");
    s.u(paramb, "$callback");
    s.u(paramString, "$techName");
    paramg = paramg.ctW();
    if (paramg == null) {
      paramb.invoke(new h.a(13013, "NFC tag has not been discovered"));
    }
    if (paramg == null)
    {
      AppMethodBeat.o(328195);
      return;
    }
    b.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smz;
    paramString = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.ctZ().get(paramString);
    if (paramString == null) {
      paramb.invoke(new h.a(13014, "invalid tech"));
    }
    if (paramString == null)
    {
      AppMethodBeat.o(328195);
      return;
    }
    if (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smM == paramString)
    {
      paramb.invoke(new h.a(13024, "function not support"));
      AppMethodBeat.o(328195);
      return;
    }
    try
    {
      paramg = org.a.a.cQ(org.a.a.bLw(paramString.smA)).y("get", new Object[] { paramg }).object;
      if (paramg == null)
      {
        paramg = (Throwable)new IllegalArgumentException("Required value was null.".toString());
        AppMethodBeat.o(328195);
        throw paramg;
      }
    }
    catch (Exception paramg)
    {
      paramb.invoke(new h.a(13015, "unavailable tech"));
      for (paramg = null; paramg == null; paramg = (TagTechnology)paramg)
      {
        AppMethodBeat.o(328195);
        return;
      }
      try
      {
        paramg = (Integer)org.a.a.jP(paramg).bLv("getMaxTransceiveLength").object;
        s.s(paramg, "length");
        paramb.invoke(new h.b(paramg));
        AppMethodBeat.o(328195);
        return;
      }
      catch (Exception paramg)
      {
        paramg = q((Throwable)paramg);
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", s.X("getMaxTransceiveLength failed since ", paramg));
        if (paramg != null) {
          break label355;
        }
      }
      paramg = null;
    }
    for (;;)
    {
      paramb.invoke(new h.a(13017, s.X("system internal error: ", paramg)));
      AppMethodBeat.o(328195);
      return;
      label355:
      paramg = paramg.getMessage();
    }
  }
  
  private static Throwable q(Throwable paramThrowable)
  {
    AppMethodBeat.i(328123);
    if ((paramThrowable instanceof org.a.b))
    {
      paramThrowable = paramThrowable.getCause();
      if (paramThrowable == null)
      {
        AppMethodBeat.o(328123);
        return null;
      }
      paramThrowable = paramThrowable.getCause();
      AppMethodBeat.o(328123);
      return paramThrowable;
    }
    AppMethodBeat.o(328123);
    return paramThrowable;
  }
  
  public static final boolean z(f paramf)
  {
    AppMethodBeat.i(328242);
    boolean bool = a.z(paramf);
    AppMethodBeat.o(328242);
    return bool;
  }
  
  public final void R(kotlin.g.a.b<? super h<ah>, ah> paramb)
  {
    AppMethodBeat.i(328451);
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "startNFCDiscovery");
    com.tencent.threadpool.h.ahAA.bk(new g..ExternalSyntheticLambda0(this, paramb));
    AppMethodBeat.o(328451);
  }
  
  public final void S(kotlin.g.a.b<? super h<ah>, ah> paramb)
  {
    AppMethodBeat.i(328465);
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "stopNFCDiscovery");
    com.tencent.threadpool.h.ahAA.bk(new g..ExternalSyntheticLambda1(this, paramb));
    AppMethodBeat.o(328465);
  }
  
  public final void a(NdefMessage paramNdefMessage, kotlin.g.a.b<? super h<ah>, ah> paramb)
  {
    AppMethodBeat.i(183679);
    s.u(paramNdefMessage, "message");
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", s.X("writeNdefMessage, message: ", paramNdefMessage));
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda2(this, paramb, paramNdefMessage), "NFC-IO");
    AppMethodBeat.o(183679);
  }
  
  public final void a(String paramString1, String paramString2, kotlin.g.a.b<? super h<Object>, ah> paramb)
  {
    AppMethodBeat.i(328566);
    s.u(paramString1, "techName");
    s.u(paramString2, "function");
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "execTechLogicAsync, techName: " + paramString1 + ", function: " + paramString2 + ", params: " + null);
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda8(this, paramb, paramString1, paramString2, null), "NFC-IO");
    AppMethodBeat.o(328566);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte, kotlin.g.a.b<? super h<byte[]>, ah> paramb)
  {
    AppMethodBeat.i(328553);
    s.u(paramString, "techName");
    s.u(paramArrayOfByte, "reqData");
    s.u(paramb, "callback");
    StringBuilder localStringBuilder = new StringBuilder("transceive, techName: ").append(paramString).append(", reqData: ");
    String str = Arrays.toString(paramArrayOfByte);
    s.s(str, "java.util.Arrays.toString(this)");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", str);
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda9(this, paramb, paramString, paramArrayOfByte), "NFC-IO");
    AppMethodBeat.o(328553);
  }
  
  public final void c(String paramString, int paramInt, kotlin.g.a.b<? super h<ah>, ah> paramb)
  {
    AppMethodBeat.i(328537);
    s.u(paramString, "techName");
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, techName: " + paramString + ", timeoutMs: " + paramInt);
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda7(this, paramb, paramString, paramInt), "NFC-IO");
    AppMethodBeat.o(328537);
  }
  
  public final void g(String paramString, kotlin.g.a.b<? super h<ah>, ah> paramb)
  {
    AppMethodBeat.i(328480);
    s.u(paramString, "techName");
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", s.X("connect, techName: ", paramString));
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda3(this, paramb, paramString), "NFC-IO");
    AppMethodBeat.o(328480);
  }
  
  public final void g(q<? super byte[], ? super List<String>, ? super List<NdefMessage>, ah> paramq)
  {
    AppMethodBeat.i(328440);
    this.smr.f(paramq);
    AppMethodBeat.o(328440);
  }
  
  public final void h(String paramString, kotlin.g.a.b<? super h<ah>, ah> paramb)
  {
    AppMethodBeat.i(328492);
    s.u(paramString, "techName");
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", s.X("close, techName: ", paramString));
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda4(this, paramb, paramString), "NFC-IO");
    AppMethodBeat.o(328492);
  }
  
  public final void i(String paramString, kotlin.g.a.b<? super h<Boolean>, ah> paramb)
  {
    AppMethodBeat.i(328501);
    s.u(paramString, "techName");
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", s.X("isConnected, techName: ", paramString));
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda6(this, paramb, paramString), "NFC-IO");
    AppMethodBeat.o(328501);
  }
  
  public final void j(String paramString, kotlin.g.a.b<? super h<Integer>, ah> paramb)
  {
    AppMethodBeat.i(328523);
    s.u(paramString, "techName");
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", s.X("getMaxTransceiveLength, techName: ", paramString));
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda5(this, paramb, paramString), "NFC-IO");
    AppMethodBeat.o(328523);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion;", "", "()V", "METHOD_NAME_GET", "", "METHOD_NAME_GET_MAX_TRANSCEIVE_LENGTH", "METHOD_NAME_SET_TIMEOUT", "METHOD_NAME_TRANSCEIVE", "NFC_IO_LOOP_TAG", "TAG", "appId2ManagerMap", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "factory", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "getFactory", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "setFactory", "(Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;)V", "get", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isNFCUsing", "", "appId", "IFactory", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static g B(f paramf)
    {
      AppMethodBeat.i(183670);
      s.u(paramf, "component");
      Object localObject1 = (g)g.ctY().get(paramf.getAppId());
      if (localObject1 == null)
      {
        localObject1 = AndroidContextUtil.castActivityOrNull(paramf.getContext());
        if (localObject1 == null)
        {
          AppMethodBeat.o(183670);
          return null;
        }
        Object localObject2 = g.smq;
        localObject2 = g.ctX();
        String str = paramf.getAppId();
        s.s(str, "component.appId");
        localObject1 = ((a)localObject2).a(str, (Activity)localObject1, paramf);
        localObject2 = g.ctY();
        paramf = paramf.getAppId();
        s.s(paramf, "component.appId");
        ((Map)localObject2).put(paramf, localObject1);
        AppMethodBeat.o(183670);
        return localObject1;
      }
      AppMethodBeat.o(183670);
      return localObject1;
    }
    
    public static void b(a parama)
    {
      AppMethodBeat.i(328073);
      s.u(parama, "<set-?>");
      g.a(parama);
      AppMethodBeat.o(328073);
    }
    
    public static boolean z(f paramf)
    {
      AppMethodBeat.i(328091);
      s.u(paramf, "component");
      paramf = B(paramf);
      if (paramf == null)
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "isNFCUsing, manager is null, not using");
        AppMethodBeat.o(328091);
        return false;
      }
      boolean bool = g.a(paramf).ctT();
      AppMethodBeat.o(328091);
      return bool;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static abstract interface a
    {
      public abstract g a(String paramString, Activity paramActivity, f paramf);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$factory$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.a.a
  {
    public final g a(String paramString, Activity paramActivity, f paramf)
    {
      AppMethodBeat.i(328066);
      s.u(paramString, "appId");
      s.u(paramActivity, "activity");
      s.u(paramf, "component");
      paramString = new g(paramString, (b)new e(paramString, paramActivity));
      AppMethodBeat.o(328066);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g
 * JD-Core Version:    0.7.0.1
 */