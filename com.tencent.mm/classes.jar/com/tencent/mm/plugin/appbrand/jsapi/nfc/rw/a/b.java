package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a;

import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "", "techName", "", "techClassName", "techLogic", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;)V", "hasMethodCache", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "getTechClassName", "()Ljava/lang/String;", "getTechLogic", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "getTechName", "hasMethod", "name", "parameterTypes", "", "Ljava/lang/Class;", "", "(Ljava/lang/String;[Ljava/lang/Class;)Z", "NFC_A", "NFC_B", "ISO_DEP", "NFC_F", "NFC_V", "MIFARE_CLASSIC", "MIFARE_ULTRALIGHT", "NDEF", "Companion", "MethodSignature", "luggage-commons-jsapi-nfc-ext_release"})
public enum b
{
  private static final Map<String, b> mjm;
  private static final Map<String, String> mjn;
  public static final a mjo;
  public final String mhN;
  public final ArrayMap<b.b, Boolean> mjj;
  public final String mjk;
  public final com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a mjl;
  
  static
  {
    AppMethodBeat.i(183696);
    Object localObject1 = NfcA.class.getName();
    p.g(localObject1, "NfcA::class.java.name");
    localObject1 = new b("NFC_A", 0, "NFC-A", (String)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a)f.miY);
    mja = (b)localObject1;
    Object localObject2 = NfcB.class.getName();
    p.g(localObject2, "NfcB::class.java.name");
    localObject2 = new b("NFC_B", 1, "NFC-B", (String)localObject2, null);
    mjb = (b)localObject2;
    Object localObject3 = IsoDep.class.getName();
    p.g(localObject3, "IsoDep::class.java.name");
    localObject3 = new b("ISO_DEP", 2, "ISO-DEP", (String)localObject3, (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.b.miy);
    mjc = (b)localObject3;
    Object localObject4 = NfcF.class.getName();
    p.g(localObject4, "NfcF::class.java.name");
    localObject4 = new b("NFC_F", 3, "NFC-F", (String)localObject4, null);
    mjd = (b)localObject4;
    Object localObject5 = NfcV.class.getName();
    p.g(localObject5, "NfcV::class.java.name");
    localObject5 = new b("NFC_V", 4, "NFC-V", (String)localObject5, null);
    mje = (b)localObject5;
    Object localObject6 = MifareClassic.class.getName();
    p.g(localObject6, "MifareClassic::class.java.name");
    localObject6 = new b("MIFARE_CLASSIC", 5, "MIFARE Classic", (String)localObject6, null);
    mjf = (b)localObject6;
    Object localObject7 = MifareUltralight.class.getName();
    p.g(localObject7, "MifareUltralight::class.java.name");
    localObject7 = new b("MIFARE_ULTRALIGHT", 6, "MIFARE Ultralight", (String)localObject7, null);
    mjg = (b)localObject7;
    Object localObject8 = Ndef.class.getName();
    p.g(localObject8, "Ndef::class.java.name");
    localObject8 = new b("NDEF", 7, "NDEF", (String)localObject8, null);
    mjh = (b)localObject8;
    mji = new b[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8 };
    mjo = new a((byte)0);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((Collection)localObject2).add(s.U(((b)localObject3).mhN, localObject3));
      i += 1;
    }
    mjm = ae.E((Iterable)localObject2);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((Collection)localObject2).add(s.U(((b)localObject3).mjk, ((b)localObject3).mhN));
      i += 1;
    }
    mjn = ae.E((Iterable)localObject2);
    AppMethodBeat.o(183696);
  }
  
  private b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a parama)
  {
    AppMethodBeat.i(207171);
    this.mhN = paramString1;
    this.mjk = paramString2;
    this.mjl = parama;
    this.mjj = new ArrayMap();
    AppMethodBeat.o(207171);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$Companion;", "", "()V", "TAG", "", "techClassName2TechNameMap", "", "getTechClassName2TechNameMap", "()Ljava/util/Map;", "techName2TechMap", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "getTechName2TechMap", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$hasMethod$1$1"})
  public static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public c(b.b paramb, b paramb1, String paramString, Class[] paramArrayOfClass)
    {
      super();
    }
    
    private boolean ij()
    {
      AppMethodBeat.i(207170);
      try
      {
        Class localClass = Class.forName(this.mjr.mjk);
        localObject1 = this.mjs;
        localObject2 = this.mjt;
        localClass.getDeclaredMethod((String)localObject1, (Class[])Arrays.copyOf((Object[])localObject2, localObject2.length));
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = new StringBuilder("get ").append(this.mjr.mjk).append('.').append(this.mjs).append('(');
          Object localObject2 = Arrays.toString(this.mjt);
          p.g(localObject2, "java.util.Arrays.toString(this)");
          Log.i("MicroMsg.AppBrand.NFCTech", (String)localObject2 + ") failed since " + localException);
          boolean bool = false;
        }
      }
      ((Map)b.a(this.mjr)).put(this.mjq, Boolean.valueOf(bool));
      AppMethodBeat.o(207170);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b
 * JD-Core Version:    0.7.0.1
 */