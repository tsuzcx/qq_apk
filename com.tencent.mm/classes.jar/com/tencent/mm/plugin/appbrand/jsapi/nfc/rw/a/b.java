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
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "", "techName", "", "techClassName", "techLogic", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;)V", "hasMethodCache", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "getTechClassName", "()Ljava/lang/String;", "getTechLogic", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "getTechName", "hasMethod", "name", "parameterTypes", "", "Ljava/lang/Class;", "", "(Ljava/lang/String;[Ljava/lang/Class;)Z", "NFC_A", "NFC_B", "ISO_DEP", "NFC_F", "NFC_V", "MIFARE_CLASSIC", "MIFARE_ULTRALIGHT", "NDEF", "Companion", "MethodSignature", "luggage-commons-jsapi-nfc-ext_release"})
public enum b
{
  private static final Map<String, b> pho;
  private static final Map<String, String> php;
  public static final a phq;
  public final String pfR;
  public final ArrayMap<b, Boolean> phl;
  public final String phm;
  public final com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a phn;
  
  static
  {
    AppMethodBeat.i(183696);
    Object localObject1 = NfcA.class.getName();
    p.j(localObject1, "NfcA::class.java.name");
    localObject1 = new b("NFC_A", 0, "NFC-A", (String)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a)f.pha);
    phc = (b)localObject1;
    Object localObject2 = NfcB.class.getName();
    p.j(localObject2, "NfcB::class.java.name");
    localObject2 = new b("NFC_B", 1, "NFC-B", (String)localObject2, null);
    phd = (b)localObject2;
    Object localObject3 = IsoDep.class.getName();
    p.j(localObject3, "IsoDep::class.java.name");
    localObject3 = new b("ISO_DEP", 2, "ISO-DEP", (String)localObject3, (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a)com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.b.pgA);
    phe = (b)localObject3;
    Object localObject4 = NfcF.class.getName();
    p.j(localObject4, "NfcF::class.java.name");
    localObject4 = new b("NFC_F", 3, "NFC-F", (String)localObject4, null);
    phf = (b)localObject4;
    Object localObject5 = NfcV.class.getName();
    p.j(localObject5, "NfcV::class.java.name");
    localObject5 = new b("NFC_V", 4, "NFC-V", (String)localObject5, null);
    phg = (b)localObject5;
    Object localObject6 = MifareClassic.class.getName();
    p.j(localObject6, "MifareClassic::class.java.name");
    localObject6 = new b("MIFARE_CLASSIC", 5, "MIFARE Classic", (String)localObject6, null);
    phh = (b)localObject6;
    Object localObject7 = MifareUltralight.class.getName();
    p.j(localObject7, "MifareUltralight::class.java.name");
    localObject7 = new b("MIFARE_ULTRALIGHT", 6, "MIFARE Ultralight", (String)localObject7, null);
    phi = (b)localObject7;
    Object localObject8 = Ndef.class.getName();
    p.j(localObject8, "Ndef::class.java.name");
    localObject8 = new b("NDEF", 7, "NDEF", (String)localObject8, null);
    phj = (b)localObject8;
    phk = new b[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8 };
    phq = new a((byte)0);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((Collection)localObject2).add(s.M(((b)localObject3).pfR, localObject3));
      i += 1;
    }
    pho = ae.E((Iterable)localObject2);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((Collection)localObject2).add(s.M(((b)localObject3).phm, ((b)localObject3).pfR));
      i += 1;
    }
    php = ae.E((Iterable)localObject2);
    AppMethodBeat.o(183696);
  }
  
  private b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a parama)
  {
    AppMethodBeat.i(242227);
    this.pfR = paramString1;
    this.phm = paramString2;
    this.phn = parama;
    this.phl = new ArrayMap();
    AppMethodBeat.o(242227);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$Companion;", "", "()V", "TAG", "", "techClassName2TechNameMap", "", "getTechClassName2TechNameMap", "()Ljava/util/Map;", "techName2TechMap", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "getTechName2TechMap", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "name", "", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/String;[Ljava/lang/Class;)V", "getName", "()Ljava/lang/String;", "getParameterTypes", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "equals", "", "other", "hashCode", "", "toString", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class b
  {
    private final String name;
    private final Class<? extends Object>[] phr;
    
    public b(String paramString, Class<? extends Object>[] paramArrayOfClass)
    {
      AppMethodBeat.i(241982);
      this.name = paramString;
      this.phr = paramArrayOfClass;
      AppMethodBeat.o(241982);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(241978);
      if ((b)this == paramObject)
      {
        AppMethodBeat.o(241978);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (p.h(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(241978);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.model.NFCTech.MethodSignature");
        AppMethodBeat.o(241978);
        throw paramObject;
      }
      if ((p.h(this.name, ((b)paramObject).name) ^ true))
      {
        AppMethodBeat.o(241978);
        return false;
      }
      if (!Arrays.equals(this.phr, ((b)paramObject).phr))
      {
        AppMethodBeat.o(241978);
        return false;
      }
      AppMethodBeat.o(241978);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(241981);
      int i = this.name.hashCode();
      int j = Arrays.hashCode(this.phr);
      AppMethodBeat.o(241981);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(241984);
      String str = "MethodSignature(name=" + this.name + ", parameterTypes=" + Arrays.toString(this.phr) + ")";
      AppMethodBeat.o(241984);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$hasMethod$1$1"})
  public static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public c(b.b paramb, b paramb1, String paramString, Class[] paramArrayOfClass)
    {
      super();
    }
    
    private boolean cm()
    {
      AppMethodBeat.i(241708);
      try
      {
        Class localClass = Class.forName(this.pht.phm);
        localObject1 = this.phu;
        localObject2 = this.phv;
        localClass.getDeclaredMethod((String)localObject1, (Class[])Arrays.copyOf((Object[])localObject2, localObject2.length));
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = new StringBuilder("get ").append(this.pht.phm).append('.').append(this.phu).append('(');
          Object localObject2 = Arrays.toString(this.phv);
          p.j(localObject2, "java.util.Arrays.toString(this)");
          Log.i("MicroMsg.AppBrand.NFCTech", (String)localObject2 + ") failed since " + localException);
          boolean bool = false;
        }
      }
      ((Map)b.a(this.pht)).put(this.phs, Boolean.valueOf(bool));
      AppMethodBeat.o(241708);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b
 * JD-Core Version:    0.7.0.1
 */