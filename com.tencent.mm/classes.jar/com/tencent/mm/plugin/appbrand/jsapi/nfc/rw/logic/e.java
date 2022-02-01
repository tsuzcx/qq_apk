package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCDiscoverableForegroundDispatchImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/AbsNFCDiscoverable;", "appId", "", "activity", "Landroid/app/Activity;", "(Ljava/lang/String;Landroid/app/Activity;)V", "activityEventInterceptor", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "isActivityEventInterceptorAdded", "pendingIntent", "Landroid/app/PendingIntent;", "kotlin.jvm.PlatformType", "tag", "Landroid/nfc/Tag;", "getTag", "()Landroid/nfc/Tag;", "setTag", "(Landroid/nfc/Tag;)V", "addActivityEventInterceptorOnce", "", "doStartDiscovery", "doStopDiscovery", "onAppPause", "onAppResume", "removeActivityEventInterceptorIfNecessary", "tryDispatchNfcTagDiscovered", "intent", "tryParseMessageMap", "", "Landroid/nfc/NdefMessage;", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e
  extends a
{
  public static final e.a smh;
  private static final IntentFilter[] sml;
  private static final String[][] smm;
  private final PendingIntent pendingIntent;
  private boolean smi;
  private final kotlin.g.a.b<Intent, Boolean> smj;
  volatile Tag smk;
  
  static
  {
    AppMethodBeat.i(328106);
    smh = new e.a((byte)0);
    IntentFilter localIntentFilter = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
    try
    {
      localIntentFilter.addDataType("*/*");
      ah localah = ah.aiuX;
      sml = new IntentFilter[] { localIntentFilter };
      smm = new String[][] { { NfcA.class.getName() }, { NfcB.class.getName() }, { IsoDep.class.getName() }, { NfcF.class.getName() }, { NfcV.class.getName() }, { MifareClassic.class.getName() }, { MifareUltralight.class.getName() }, { Ndef.class.getName() } };
      AppMethodBeat.o(328106);
      return;
    }
    catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "addDataType failed");
      }
    }
  }
  
  public e(String paramString, Activity paramActivity)
  {
    super(paramString, paramActivity);
    AppMethodBeat.i(328087);
    paramString = new Intent((Context)paramActivity, paramActivity.getClass()).addFlags(536870912);
    this.pendingIntent = PendingIntent.getActivity((Context)paramActivity, 0, paramString, 0);
    this.smj = ((kotlin.g.a.b)new b(this));
    AppMethodBeat.o(328087);
  }
  
  private static List<NdefMessage> J(Intent paramIntent)
  {
    AppMethodBeat.i(328094);
    Log.d("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "tryParseMessageMap");
    paramIntent = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
    if (paramIntent == null)
    {
      AppMethodBeat.o(328094);
      return null;
    }
    Object localObject1 = Arrays.toString(paramIntent);
    s.s(localObject1, "java.util.Arrays.toString(this)");
    Log.i("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", s.X("tryDispatchNdefMessagesRead, rawMessages: ", localObject1));
    localObject1 = (Collection)new ArrayList(paramIntent.length);
    int j = paramIntent.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramIntent[i];
      if (localObject2 == null)
      {
        paramIntent = new NullPointerException("null cannot be cast to non-null type android.nfc.NdefMessage");
        AppMethodBeat.o(328094);
        throw paramIntent;
      }
      ((Collection)localObject1).add((NdefMessage)localObject2);
      i += 1;
    }
    paramIntent = (List)localObject1;
    AppMethodBeat.o(328094);
    return paramIntent;
  }
  
  private static final boolean a(kotlin.g.a.b paramb, Intent paramIntent)
  {
    AppMethodBeat.i(328097);
    s.u(paramb, "$tmp0");
    s.u(paramIntent, "p0");
    boolean bool = ((Boolean)paramb.invoke(paramIntent)).booleanValue();
    AppMethodBeat.o(328097);
    return bool;
  }
  
  private static final boolean b(kotlin.g.a.b paramb, Intent paramIntent)
  {
    AppMethodBeat.i(328100);
    s.u(paramb, "$tmp0");
    s.u(paramIntent, "p0");
    boolean bool = ((Boolean)paramb.invoke(paramIntent)).booleanValue();
    AppMethodBeat.o(328100);
    return bool;
  }
  
  public void I(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(328144);
    s.u(paramIntent, "intent");
    Log.d("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "tryDispatchNfcTagDiscovered");
    q localq = ctN();
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (localq != null)
    {
      localObject1 = this.smk;
      if (localObject1 != null)
      {
        localObject1 = ((Tag)localObject1).getTechList();
        if (localObject1 != null)
        {
          localObject3 = (Collection)new ArrayList();
          int j = localObject1.length;
          i = 0;
          while (i < j)
          {
            localObject4 = localObject1[i];
            localObject5 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smz;
            localObject4 = (String)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.cua().get(localObject4);
            if (localObject4 != null) {
              ((Collection)localObject3).add(localObject4);
            }
            i += 1;
          }
          localObject3 = (List)localObject3;
          localObject4 = paramIntent.getByteArrayExtra("android.nfc.extra.ID");
          Object localObject5 = new StringBuilder("tryDispatchNfcTagDiscovered, id: ");
          if (localObject4 != null) {
            break label257;
          }
          localObject1 = null;
          Log.i("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", localObject1 + ", techs: " + localObject3);
          if (((Collection)localObject3).isEmpty()) {
            break label274;
          }
        }
      }
    }
    label257:
    label274:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = localObject2;
        if (((List)localObject3).contains(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.smM.sln)) {
          localObject1 = J(paramIntent);
        }
        localq.invoke(localObject4, localObject3, localObject1);
      }
      AppMethodBeat.o(328144);
      return;
      localObject1 = Arrays.toString((byte[])localObject4);
      s.s(localObject1, "java.util.Arrays.toString(this)");
      break;
    }
  }
  
  protected final void ctP()
  {
    AppMethodBeat.i(328120);
    Log.i("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "enableForegroundDispatch");
    NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
    s.checkNotNull(localNfcAdapter);
    localNfcAdapter.enableForegroundDispatch(this.activity, this.pendingIntent, sml, smm);
    Log.d("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "addActivityEventInterceptorOnce");
    if (!this.smi)
    {
      k.a(getAppId(), new e..ExternalSyntheticLambda1(this.smj));
      this.smi = true;
    }
    AppMethodBeat.o(328120);
  }
  
  protected final void ctQ()
  {
    AppMethodBeat.i(328125);
    Log.i("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "disableForegroundDispatch");
    NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
    s.checkNotNull(localNfcAdapter);
    localNfcAdapter.disableForegroundDispatch(this.activity);
    Log.d("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "removeActivityEventInterceptorIfNecessary");
    if (this.smi)
    {
      k.b(getAppId(), new e..ExternalSyntheticLambda0(this.smj));
      this.smi = false;
    }
    AppMethodBeat.o(328125);
  }
  
  protected final void ctR()
  {
    AppMethodBeat.i(328128);
    super.ctR();
    if (this.slX.getAndSet(false)) {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "onPause, isNFCDiscovering");
    }
    try
    {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "disableForegroundDispatch");
      NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
      if (localNfcAdapter != null) {
        localNfcAdapter.disableForegroundDispatch(this.activity);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", s.X("disableForegroundDispatch failed since ", localException));
      }
    }
    this.slY = true;
    AppMethodBeat.o(328128);
  }
  
  protected final void ctS()
  {
    AppMethodBeat.i(328138);
    super.ctS();
    NfcAdapter localNfcAdapter;
    if (this.slY)
    {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "onResume, isNFCDiscoverySticky");
      if ((this.activity instanceof com.tencent.mm.plugin.appbrand.jsapi.nfc.b)) {
        ((com.tencent.mm.plugin.appbrand.jsapi.nfc.b)this.activity).ctx();
      }
      localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
      if ((localNfcAdapter != null) && (true == localNfcAdapter.isEnabled())) {}
      for (int i = 1; i == 0; i = 0)
      {
        Log.i("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "onResume, nfc is not enabled");
        AppMethodBeat.o(328138);
        return;
      }
    }
    try
    {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", "enableForegroundDispatch");
      localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
      if (localNfcAdapter != null) {
        localNfcAdapter.enableForegroundDispatch(this.activity, this.pendingIntent, sml, smm);
      }
      this.slX.set(true);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.NFCDiscoverableForegroundDispatchImpl", s.X("enableForegroundDispatch failed since ", localException));
      }
    }
    this.slY = false;
    AppMethodBeat.o(328138);
  }
  
  public final Tag ctW()
  {
    return this.smk;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "intent", "Landroid/content/Intent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Intent, Boolean>
  {
    b(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e
 * JD-Core Version:    0.7.0.1
 */