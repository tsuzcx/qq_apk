package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/AbsNFCDiscoverable;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCDiscoverable;", "appId", "", "activity", "Landroid/app/Activity;", "(Ljava/lang/String;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "getAppId", "()Ljava/lang/String;", "connectedTech", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "kotlin.jvm.PlatformType", "", "getConnectedTech", "()Ljava/util/Set;", "isNFCDiscovering", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isNFCDiscoverySticky", "", "()Z", "setNFCDiscoverySticky", "(Z)V", "onDiscoveryListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "id", "", "techs", "Landroid/nfc/NdefMessage;", "ndefMessages", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/OnDiscovery;", "getOnDiscoveryListener", "()Lkotlin/jvm/functions/Function3;", "setOnDiscoveryListener", "(Lkotlin/jvm/functions/Function3;)V", "sysNfcSwitchToggleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/AbsNFCDiscoverable$sysNfcSwitchToggleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/AbsNFCDiscoverable$sysNfcSwitchToggleListener$1;", "doStartDiscovery", "doStopDiscovery", "isNFCUsing", "onAppDestroy", "onAppPause", "onAppResume", "setRequireCallbackOnForeground", "requireCallbackOnForeground", "startDiscovery", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCDiscoverable$DiscoveryResult;", "stopDiscovery", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements b
{
  public static final a.a slU = new a.a((byte)0);
  final Activity activity;
  private final String appId;
  private volatile q<? super byte[], ? super List<String>, ? super List<NdefMessage>, ah> slV;
  final Set<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b> slW;
  final AtomicBoolean slX;
  boolean slY;
  private final AbsNFCDiscoverable.sysNfcSwitchToggleListener.1 slZ;
  
  public a(String paramString, Activity paramActivity)
  {
    this.appId = paramString;
    this.activity = paramActivity;
    this.slW = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    this.slX = new AtomicBoolean(false);
    this.slZ = new AbsNFCDiscoverable.sysNfcSwitchToggleListener.1(this);
    paramString = this.activity.getApplicationContext();
    if (paramString != null) {
      paramString.registerReceiver((BroadcastReceiver)this.slZ, new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
    }
    k.a(this.appId, (k.c)new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(328071);
        super.a(paramAnonymousd);
        Log.d("MicroMsg.AppBrand.AbsNFCDiscoverable", "onPause");
        this.sma.ctR();
        AppMethodBeat.o(328071);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(328080);
        super.onDestroy();
        Log.d("MicroMsg.AppBrand.AbsNFCDiscoverable", "onDestroy");
        Context localContext = this.sma.activity.getApplicationContext();
        if (localContext != null) {
          localContext.unregisterReceiver((BroadcastReceiver)a.a(this.sma));
        }
        AppMethodBeat.o(328080);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(328074);
        super.onResume();
        Log.d("MicroMsg.AppBrand.AbsNFCDiscoverable", "onResume");
        this.sma.ctS();
        AppMethodBeat.o(328074);
      }
    });
  }
  
  public final q<byte[], List<String>, List<NdefMessage>, ah> ctN()
  {
    return this.slV;
  }
  
  public final Set<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b> ctO()
  {
    return this.slW;
  }
  
  protected abstract void ctP();
  
  protected abstract void ctQ();
  
  protected void ctR() {}
  
  protected void ctS() {}
  
  public final boolean ctT()
  {
    if (this.slX.get())
    {
      Log.i("MicroMsg.AppBrand.AbsNFCDiscoverable", "isNFCUsing, isDiscovering, using");
      return true;
    }
    Set localSet = this.slW;
    s.s(localSet, "connectedTech");
    if (!((Collection)localSet).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.AppBrand.AbsNFCDiscoverable", "isNFCUsing, connected, using");
      return true;
    }
    Log.i("MicroMsg.AppBrand.AbsNFCDiscoverable", "isNFCUsing, not using");
    return false;
  }
  
  public final b.a ctU()
  {
    if (this.slX.get()) {
      return b.a.smd;
    }
    try
    {
      ctP();
      this.slX.set(true);
      b.a locala = b.a.smb;
      return locala;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AppBrand.AbsNFCDiscoverable", s.X("startDiscovery failed since ", localException));
    }
    return b.a.smc;
  }
  
  public final b.a ctV()
  {
    this.slY = false;
    if (!this.slX.get()) {
      return b.a.sme;
    }
    try
    {
      ctQ();
      this.slX.set(false);
      b.a locala = b.a.smb;
      return locala;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AppBrand.AbsNFCDiscoverable", s.X("stopDiscovery failed since ", localException));
    }
    return b.a.smc;
  }
  
  public final void f(q<? super byte[], ? super List<String>, ? super List<NdefMessage>, ah> paramq)
  {
    this.slV = paramq;
  }
  
  public final String getAppId()
  {
    return this.appId;
  }
  
  public void jE(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a
 * JD-Core Version:    0.7.0.1
 */