package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.ReaderCallback;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCDiscoverableReaderModeImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/AbsNFCDiscoverable;", "appId", "", "activity", "Landroid/app/Activity;", "(Ljava/lang/String;Landroid/app/Activity;)V", "readerCallback", "Landroid/nfc/NfcAdapter$ReaderCallback;", "tag", "Landroid/nfc/Tag;", "getTag", "()Landroid/nfc/Tag;", "setTag", "(Landroid/nfc/Tag;)V", "doStartDiscovery", "", "doStopDiscovery", "onAppPause", "onAppResume", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  private static final Bundle extras;
  public static final f.a smo;
  private volatile Tag smk;
  private final NfcAdapter.ReaderCallback smp;
  
  static
  {
    AppMethodBeat.i(328089);
    smo = new f.a((byte)0);
    AppMethodBeat.o(328089);
  }
  
  public f(String paramString, Activity paramActivity)
  {
    super(paramString, paramActivity);
    AppMethodBeat.i(328075);
    this.smp = new f..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(328075);
  }
  
  private static final void a(f paramf, Tag paramTag)
  {
    Object localObject1 = null;
    AppMethodBeat.i(328086);
    s.u(paramf, "this$0");
    paramf.slW.clear();
    paramf.smk = paramTag;
    if (paramTag == null)
    {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onTagDiscovered, discoveredTag is null");
      AppMethodBeat.o(328086);
      return;
    }
    q localq = paramf.ctN();
    if (localq == null)
    {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onTagDiscovered, onDiscoveryListener is null");
      AppMethodBeat.o(328086);
      return;
    }
    byte[] arrayOfByte = paramTag.getId();
    paramf = paramTag.getTechList();
    Object localObject2;
    if (paramf == null)
    {
      paramf = null;
      localObject2 = (Collection)paramf;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label204;
      }
    }
    label204:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label209;
      }
      Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onTagDiscovered, techs is empty");
      AppMethodBeat.o(328086);
      return;
      localObject2 = (Collection)new ArrayList();
      int j = paramf.length;
      i = 0;
      while (i < j)
      {
        Object localObject3 = paramf[i];
        b.a locala = b.smz;
        localObject3 = (String)b.cua().get(localObject3);
        if (localObject3 != null) {
          ((Collection)localObject2).add(localObject3);
        }
        i += 1;
      }
      paramf = (List)localObject2;
      break;
    }
    label209:
    if (paramf.contains(b.smM.sln))
    {
      paramTag = Ndef.get(paramTag);
      if (paramTag != null)
      {
        paramTag = paramTag.getCachedNdefMessage();
        if (paramTag != null)
        {
          paramTag = p.listOf(paramTag);
          localObject2 = new StringBuilder("onTagDiscovered, id: ");
          if (arrayOfByte != null) {
            break label310;
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", localObject1 + ", techs: " + paramf);
      localq.invoke(arrayOfByte, paramf, paramTag);
      AppMethodBeat.o(328086);
      return;
      paramTag = null;
      break;
      label310:
      localObject1 = Arrays.toString(arrayOfByte);
      s.s(localObject1, "java.util.Arrays.toString(this)");
    }
  }
  
  protected final void ctP()
  {
    AppMethodBeat.i(328101);
    Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "enableReaderMode");
    NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
    s.checkNotNull(localNfcAdapter);
    localNfcAdapter.enableReaderMode(this.activity, this.smp, 15, extras);
    AppMethodBeat.o(328101);
  }
  
  protected final void ctQ()
  {
    AppMethodBeat.i(328104);
    Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "disableReaderMode");
    NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
    s.checkNotNull(localNfcAdapter);
    localNfcAdapter.disableReaderMode(this.activity);
    AppMethodBeat.o(328104);
  }
  
  protected final void ctR()
  {
    AppMethodBeat.i(328109);
    super.ctR();
    if (this.slX.getAndSet(false)) {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onPause, isNFCDiscovering");
    }
    try
    {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "disableReaderMode");
      NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
      if (localNfcAdapter != null) {
        localNfcAdapter.disableReaderMode(this.activity);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", s.X("disableReaderMode failed since ", localException));
      }
    }
    this.slY = true;
    AppMethodBeat.o(328109);
  }
  
  protected final void ctS()
  {
    int i = 1;
    AppMethodBeat.i(328114);
    super.ctS();
    NfcAdapter localNfcAdapter;
    if (this.slY)
    {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onResume, isNFCDiscoverySticky");
      localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
      if ((localNfcAdapter != null) && (true == localNfcAdapter.isEnabled())) {}
      while (i == 0)
      {
        Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onResume, nfc is not enabled");
        AppMethodBeat.o(328114);
        return;
        i = 0;
      }
    }
    try
    {
      Log.i("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "enableReaderMode");
      localNfcAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
      if (localNfcAdapter != null) {
        localNfcAdapter.enableReaderMode(this.activity, this.smp, 15, extras);
      }
      this.slX.set(true);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", s.X("enableReaderMode failed since ", localException));
      }
    }
    this.slY = false;
    AppMethodBeat.o(328114);
  }
  
  public final Tag ctW()
  {
    return this.smk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.f
 * JD-Core Version:    0.7.0.1
 */