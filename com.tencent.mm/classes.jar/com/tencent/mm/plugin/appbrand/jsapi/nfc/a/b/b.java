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
import d.g.b.k;
import d.u;
import d.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "", "techName", "", "techClassName", "techLogic", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;)V", "hasMethodCache", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "getTechClassName", "()Ljava/lang/String;", "getTechLogic", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "getTechName", "hasMethod", "name", "parameterTypes", "", "Ljava/lang/Class;", "", "(Ljava/lang/String;[Ljava/lang/Class;)Z", "NFC_A", "NFC_B", "ISO_DEP", "NFC_F", "NFC_V", "MIFARE_CLASSIC", "MIFARE_ULTRALIGHT", "NDEF", "Companion", "MethodSignature", "luggage-commons-jsapi-nfc-ext_release"})
public enum b
{
  private static final Map<String, b> kdo;
  private static final Map<String, String> kdp;
  public static final a kdq;
  public final String kbT;
  public final ArrayMap<b, Boolean> kdl;
  public final String kdm;
  public final com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a kdn;
  
  static
  {
    AppMethodBeat.i(183696);
    Object localObject1 = NfcA.class.getName();
    k.g(localObject1, "NfcA::class.java.name");
    localObject1 = new b("NFC_A", 0, "NFC-A", (String)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a)f.kda);
    kdc = (b)localObject1;
    Object localObject2 = NfcB.class.getName();
    k.g(localObject2, "NfcB::class.java.name");
    localObject2 = new b("NFC_B", 1, "NFC-B", (String)localObject2, null);
    kdd = (b)localObject2;
    Object localObject3 = IsoDep.class.getName();
    k.g(localObject3, "IsoDep::class.java.name");
    localObject3 = new b("ISO_DEP", 2, "ISO-DEP", (String)localObject3, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.b.kcD);
    kde = (b)localObject3;
    Object localObject4 = NfcF.class.getName();
    k.g(localObject4, "NfcF::class.java.name");
    localObject4 = new b("NFC_F", 3, "NFC-F", (String)localObject4, null);
    kdf = (b)localObject4;
    Object localObject5 = NfcV.class.getName();
    k.g(localObject5, "NfcV::class.java.name");
    localObject5 = new b("NFC_V", 4, "NFC-V", (String)localObject5, null);
    kdg = (b)localObject5;
    Object localObject6 = MifareClassic.class.getName();
    k.g(localObject6, "MifareClassic::class.java.name");
    localObject6 = new b("MIFARE_CLASSIC", 5, "MIFARE Classic", (String)localObject6, null);
    kdh = (b)localObject6;
    Object localObject7 = MifareUltralight.class.getName();
    k.g(localObject7, "MifareUltralight::class.java.name");
    localObject7 = new b("MIFARE_ULTRALIGHT", 6, "MIFARE Ultralight", (String)localObject7, null);
    kdi = (b)localObject7;
    Object localObject8 = Ndef.class.getName();
    k.g(localObject8, "Ndef::class.java.name");
    localObject8 = new b("NDEF", 7, "NDEF", (String)localObject8, null);
    kdj = (b)localObject8;
    kdk = new b[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8 };
    kdq = new a((byte)0);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((Collection)localObject2).add(u.P(((b)localObject3).kbT, localObject3));
      i += 1;
    }
    kdo = ae.z((Iterable)localObject2);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((Collection)localObject2).add(u.P(((b)localObject3).kdm, ((b)localObject3).kbT));
      i += 1;
    }
    kdp = ae.z((Iterable)localObject2);
    AppMethodBeat.o(183696);
  }
  
  private b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a parama)
  {
    AppMethodBeat.i(194642);
    this.kbT = paramString1;
    this.kdm = paramString2;
    this.kdn = parama;
    this.kdl = new ArrayMap();
    AppMethodBeat.o(194642);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$Companion;", "", "()V", "TAG", "", "techClassName2TechNameMap", "", "getTechClassName2TechNameMap", "()Ljava/util/Map;", "techName2TechMap", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "getTechName2TechMap", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "name", "", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/String;[Ljava/lang/Class;)V", "getName", "()Ljava/lang/String;", "getParameterTypes", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "equals", "", "other", "hashCode", "", "toString", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class b
  {
    private final Class<? extends Object>[] kdr;
    private final String name;
    
    public b(String paramString, Class<? extends Object>[] paramArrayOfClass)
    {
      AppMethodBeat.i(194638);
      this.name = paramString;
      this.kdr = paramArrayOfClass;
      AppMethodBeat.o(194638);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(194636);
      if ((b)this == paramObject)
      {
        AppMethodBeat.o(194636);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (k.g(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(194636);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.model.NFCTech.MethodSignature");
        AppMethodBeat.o(194636);
        throw paramObject;
      }
      if ((k.g(this.name, ((b)paramObject).name) ^ true))
      {
        AppMethodBeat.o(194636);
        return false;
      }
      if (!Arrays.equals(this.kdr, ((b)paramObject).kdr))
      {
        AppMethodBeat.o(194636);
        return false;
      }
      AppMethodBeat.o(194636);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(194637);
      int i = this.name.hashCode();
      int j = Arrays.hashCode(this.kdr);
      AppMethodBeat.o(194637);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(194639);
      String str = "MethodSignature(name=" + this.name + ", parameterTypes=" + Arrays.toString(this.kdr) + ")";
      AppMethodBeat.o(194639);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$hasMethod$1$1"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    public c(b.b paramb, b paramb1, String paramString, Class[] paramArrayOfClass)
    {
      super();
    }
    
    private boolean hB()
    {
      AppMethodBeat.i(194641);
      try
      {
        Class localClass = Class.forName(this.kdt.kdm);
        localObject1 = this.kdu;
        localObject2 = this.kdv;
        localClass.getDeclaredMethod((String)localObject1, (Class[])Arrays.copyOf((Object[])localObject2, localObject2.length));
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = new StringBuilder("get ").append(this.kdt.kdm).append('.').append(this.kdu).append('(');
          Object localObject2 = Arrays.toString(this.kdv);
          k.g(localObject2, "java.util.Arrays.toString(this)");
          ad.i("MicroMsg.AppBrand.NFCTech", (String)localObject2 + ") failed since " + localException);
          boolean bool = false;
        }
      }
      ((Map)b.a(this.kdt)).put(this.kds, Boolean.valueOf(bool));
      AppMethodBeat.o(194641);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b
 * JD-Core Version:    0.7.0.1
 */