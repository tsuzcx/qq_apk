package com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b;

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
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.ae;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "", "techName", "", "techClassName", "techLogic", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;)V", "hasMethodCache", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "getTechClassName", "()Ljava/lang/String;", "getTechLogic", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "getTechName", "hasMethod", "name", "parameterTypes", "", "Ljava/lang/Class;", "", "(Ljava/lang/String;[Ljava/lang/Class;)Z", "NFC_A", "NFC_B", "ISO_DEP", "NFC_F", "NFC_V", "MIFARE_CLASSIC", "MIFARE_ULTRALIGHT", "NDEF", "Companion", "MethodSignature", "luggage-commons-jsapi-nfc-ext_release"})
public enum b
{
  private static final Map<String, b> lak;
  private static final Map<String, String> lal;
  public static final a lam;
  public final String kYN;
  public final ArrayMap<b.b, Boolean> lah;
  public final String lai;
  public final com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a laj;
  
  static
  {
    AppMethodBeat.i(183696);
    Object localObject1 = NfcA.class.getName();
    p.g(localObject1, "NfcA::class.java.name");
    localObject1 = new b("NFC_A", 0, "NFC-A", (String)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a)f.kZW);
    kZY = (b)localObject1;
    Object localObject2 = NfcB.class.getName();
    p.g(localObject2, "NfcB::class.java.name");
    localObject2 = new b("NFC_B", 1, "NFC-B", (String)localObject2, null);
    kZZ = (b)localObject2;
    Object localObject3 = IsoDep.class.getName();
    p.g(localObject3, "IsoDep::class.java.name");
    localObject3 = new b("ISO_DEP", 2, "ISO-DEP", (String)localObject3, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.b.kZx);
    laa = (b)localObject3;
    Object localObject4 = NfcF.class.getName();
    p.g(localObject4, "NfcF::class.java.name");
    localObject4 = new b("NFC_F", 3, "NFC-F", (String)localObject4, null);
    lab = (b)localObject4;
    Object localObject5 = NfcV.class.getName();
    p.g(localObject5, "NfcV::class.java.name");
    localObject5 = new b("NFC_V", 4, "NFC-V", (String)localObject5, null);
    lac = (b)localObject5;
    Object localObject6 = MifareClassic.class.getName();
    p.g(localObject6, "MifareClassic::class.java.name");
    localObject6 = new b("MIFARE_CLASSIC", 5, "MIFARE Classic", (String)localObject6, null);
    lad = (b)localObject6;
    Object localObject7 = MifareUltralight.class.getName();
    p.g(localObject7, "MifareUltralight::class.java.name");
    localObject7 = new b("MIFARE_ULTRALIGHT", 6, "MIFARE Ultralight", (String)localObject7, null);
    lae = (b)localObject7;
    Object localObject8 = Ndef.class.getName();
    p.g(localObject8, "Ndef::class.java.name");
    localObject8 = new b("NDEF", 7, "NDEF", (String)localObject8, null);
    laf = (b)localObject8;
    lag = new b[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8 };
    lam = new a((byte)0);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((Collection)localObject2).add(u.S(((b)localObject3).kYN, localObject3));
      i += 1;
    }
    lak = ae.A((Iterable)localObject2);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((Collection)localObject2).add(u.S(((b)localObject3).lai, ((b)localObject3).kYN));
      i += 1;
    }
    lal = ae.A((Iterable)localObject2);
    AppMethodBeat.o(183696);
  }
  
  private b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a parama)
  {
    AppMethodBeat.i(199719);
    this.kYN = paramString1;
    this.lai = paramString2;
    this.laj = parama;
    this.lah = new ArrayMap();
    AppMethodBeat.o(199719);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$Companion;", "", "()V", "TAG", "", "techClassName2TechNameMap", "", "getTechClassName2TechNameMap", "()Ljava/util/Map;", "techName2TechMap", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "getTechName2TechMap", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$hasMethod$1$1"})
  public static final class c
    extends q
    implements d.g.a.a<Boolean>
  {
    public c(b.b paramb, b paramb1, String paramString, Class[] paramArrayOfClass)
    {
      super();
    }
    
    private boolean hZ()
    {
      AppMethodBeat.i(199718);
      try
      {
        Class localClass = Class.forName(this.lap.lai);
        localObject1 = this.laq;
        localObject2 = this.lar;
        localClass.getDeclaredMethod((String)localObject1, (Class[])Arrays.copyOf((Object[])localObject2, localObject2.length));
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = new StringBuilder("get ").append(this.lap.lai).append('.').append(this.laq).append('(');
          Object localObject2 = Arrays.toString(this.lar);
          p.g(localObject2, "java.util.Arrays.toString(this)");
          ad.i("MicroMsg.AppBrand.NFCTech", (String)localObject2 + ") failed since " + localException);
          boolean bool = false;
        }
      }
      ((Map)b.a(this.lap)).put(this.lao, Boolean.valueOf(bool));
      AppMethodBeat.o(199718);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b
 * JD-Core Version:    0.7.0.1
 */