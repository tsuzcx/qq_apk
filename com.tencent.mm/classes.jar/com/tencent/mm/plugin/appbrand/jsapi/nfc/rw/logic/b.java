package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.nfc.NdefMessage;
import android.nfc.Tag;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCDiscoverable;", "", "connectedTech", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "getConnectedTech", "()Ljava/util/Set;", "onDiscoveryListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "id", "", "", "techs", "Landroid/nfc/NdefMessage;", "ndefMessages", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/OnDiscovery;", "getOnDiscoveryListener", "()Lkotlin/jvm/functions/Function3;", "setOnDiscoveryListener", "(Lkotlin/jvm/functions/Function3;)V", "tag", "Landroid/nfc/Tag;", "getTag", "()Landroid/nfc/Tag;", "setTag", "(Landroid/nfc/Tag;)V", "isNFCUsing", "", "setRequireCallbackOnForeground", "requireCallbackOnForeground", "startDiscovery", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCDiscoverable$DiscoveryResult;", "stopDiscovery", "DiscoveryResult", "IFactory", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract Set<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b> ctO();
  
  public abstract boolean ctT();
  
  public abstract a ctU();
  
  public abstract a ctV();
  
  public abstract Tag ctW();
  
  public abstract void f(q<? super byte[], ? super List<String>, ? super List<NdefMessage>, ah> paramq);
  
  public abstract void jE(boolean paramBoolean);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCDiscoverable$DiscoveryResult;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAIL_SYSTEM_INTERNAL_ERROR", "FAIL_ALREADY_STARTED", "FAIL_NOT_STARTED", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(328112);
      smb = new a("SUCCESS", 0);
      smc = new a("FAIL_SYSTEM_INTERNAL_ERROR", 1);
      smd = new a("FAIL_ALREADY_STARTED", 2);
      sme = new a("FAIL_NOT_STARTED", 3);
      smf = new a[] { smb, smc, smd, sme };
      AppMethodBeat.o(328112);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.b
 * JD-Core Version:    0.7.0.1
 */