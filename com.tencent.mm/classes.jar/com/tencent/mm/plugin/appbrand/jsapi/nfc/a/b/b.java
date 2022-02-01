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
import com.tencent.mm.sdk.platformtools.ac;
import d.a.ae;
import d.g.b.k;
import d.u;
import d.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "", "techName", "", "techClassName", "techLogic", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;)V", "hasMethodCache", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "getTechClassName", "()Ljava/lang/String;", "getTechLogic", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "getTechName", "hasMethod", "name", "parameterTypes", "", "Ljava/lang/Class;", "", "(Ljava/lang/String;[Ljava/lang/Class;)Z", "NFC_A", "NFC_B", "ISO_DEP", "NFC_F", "NFC_V", "MIFARE_CLASSIC", "MIFARE_ULTRALIGHT", "NDEF", "Companion", "MethodSignature", "luggage-commons-jsapi-nfc-ext_release"})
public enum b
{
  private static final Map<String, b> kEb;
  private static final Map<String, String> kEc;
  public static final a kEd;
  public final String kCG;
  public final ArrayMap<b, Boolean> kDY;
  public final String kDZ;
  public final com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a kEa;
  
  static
  {
    AppMethodBeat.i(183696);
    Object localObject1 = NfcA.class.getName();
    k.g(localObject1, "NfcA::class.java.name");
    localObject1 = new b("NFC_A", 0, "NFC-A", (String)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a)f.kDN);
    kDP = (b)localObject1;
    Object localObject2 = NfcB.class.getName();
    k.g(localObject2, "NfcB::class.java.name");
    localObject2 = new b("NFC_B", 1, "NFC-B", (String)localObject2, null);
    kDQ = (b)localObject2;
    Object localObject3 = IsoDep.class.getName();
    k.g(localObject3, "IsoDep::class.java.name");
    localObject3 = new b("ISO_DEP", 2, "ISO-DEP", (String)localObject3, (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a)com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.b.kDq);
    kDR = (b)localObject3;
    Object localObject4 = NfcF.class.getName();
    k.g(localObject4, "NfcF::class.java.name");
    localObject4 = new b("NFC_F", 3, "NFC-F", (String)localObject4, null);
    kDS = (b)localObject4;
    Object localObject5 = NfcV.class.getName();
    k.g(localObject5, "NfcV::class.java.name");
    localObject5 = new b("NFC_V", 4, "NFC-V", (String)localObject5, null);
    kDT = (b)localObject5;
    Object localObject6 = MifareClassic.class.getName();
    k.g(localObject6, "MifareClassic::class.java.name");
    localObject6 = new b("MIFARE_CLASSIC", 5, "MIFARE Classic", (String)localObject6, null);
    kDU = (b)localObject6;
    Object localObject7 = MifareUltralight.class.getName();
    k.g(localObject7, "MifareUltralight::class.java.name");
    localObject7 = new b("MIFARE_ULTRALIGHT", 6, "MIFARE Ultralight", (String)localObject7, null);
    kDV = (b)localObject7;
    Object localObject8 = Ndef.class.getName();
    k.g(localObject8, "Ndef::class.java.name");
    localObject8 = new b("NDEF", 7, "NDEF", (String)localObject8, null);
    kDW = (b)localObject8;
    kDX = new b[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8 };
    kEd = new a((byte)0);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((Collection)localObject2).add(u.Q(((b)localObject3).kCG, localObject3));
      i += 1;
    }
    kEb = ae.y((Iterable)localObject2);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((Collection)localObject2).add(u.Q(((b)localObject3).kDZ, ((b)localObject3).kCG));
      i += 1;
    }
    kEc = ae.y((Iterable)localObject2);
    AppMethodBeat.o(183696);
  }
  
  private b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.a parama)
  {
    AppMethodBeat.i(200917);
    this.kCG = paramString1;
    this.kDZ = paramString2;
    this.kEa = parama;
    this.kDY = new ArrayMap();
    AppMethodBeat.o(200917);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$Companion;", "", "()V", "TAG", "", "techClassName2TechNameMap", "", "getTechClassName2TechNameMap", "()Ljava/util/Map;", "techName2TechMap", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "getTechName2TechMap", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "name", "", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/String;[Ljava/lang/Class;)V", "getName", "()Ljava/lang/String;", "getParameterTypes", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "equals", "", "other", "hashCode", "", "toString", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class b
  {
    private final Class<? extends Object>[] kEe;
    private final String name;
    
    public b(String paramString, Class<? extends Object>[] paramArrayOfClass)
    {
      AppMethodBeat.i(200913);
      this.name = paramString;
      this.kEe = paramArrayOfClass;
      AppMethodBeat.o(200913);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(200911);
      if ((b)this == paramObject)
      {
        AppMethodBeat.o(200911);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (k.g(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(200911);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.model.NFCTech.MethodSignature");
        AppMethodBeat.o(200911);
        throw paramObject;
      }
      if ((k.g(this.name, ((b)paramObject).name) ^ true))
      {
        AppMethodBeat.o(200911);
        return false;
      }
      if (!Arrays.equals(this.kEe, ((b)paramObject).kEe))
      {
        AppMethodBeat.o(200911);
        return false;
      }
      AppMethodBeat.o(200911);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(200912);
      int i = this.name.hashCode();
      int j = Arrays.hashCode(this.kEe);
      AppMethodBeat.o(200912);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200914);
      String str = "MethodSignature(name=" + this.name + ", parameterTypes=" + Arrays.toString(this.kEe) + ")";
      AppMethodBeat.o(200914);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$hasMethod$1$1"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    public c(b.b paramb, b paramb1, String paramString, Class[] paramArrayOfClass)
    {
      super();
    }
    
    private boolean hJ()
    {
      AppMethodBeat.i(200916);
      try
      {
        Class localClass = Class.forName(this.kEg.kDZ);
        localObject1 = this.kEh;
        localObject2 = this.kEi;
        localClass.getDeclaredMethod((String)localObject1, (Class[])Arrays.copyOf((Object[])localObject2, localObject2.length));
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = new StringBuilder("get ").append(this.kEg.kDZ).append('.').append(this.kEh).append('(');
          Object localObject2 = Arrays.toString(this.kEi);
          k.g(localObject2, "java.util.Arrays.toString(this)");
          ac.i("MicroMsg.AppBrand.NFCTech", (String)localObject2 + ") failed since " + localException);
          boolean bool = false;
        }
      }
      ((Map)b.a(this.kEg)).put(this.kEf, Boolean.valueOf(bool));
      AppMethodBeat.o(200916);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b
 * JD-Core Version:    0.7.0.1
 */