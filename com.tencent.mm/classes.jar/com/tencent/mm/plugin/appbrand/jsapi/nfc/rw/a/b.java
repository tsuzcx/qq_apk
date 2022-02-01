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
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.d;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "", "techName", "", "techClassName", "techLogic", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;)V", "hasMethodCache", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "getTechClassName", "()Ljava/lang/String;", "getTechLogic", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "getTechName", "hasMethod", "name", "parameterTypes", "", "Ljava/lang/Class;", "", "(Ljava/lang/String;[Ljava/lang/Class;)Z", "NFC_A", "NFC_B", "ISO_DEP", "NFC_F", "NFC_V", "MIFARE_CLASSIC", "MIFARE_ULTRALIGHT", "NDEF", "Companion", "MethodSignature", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  private static final Map<String, b> smD;
  private static final Map<String, String> smE;
  public static final b.a smz;
  public final String sln;
  public final String smA;
  public final c smB;
  public final ArrayMap<b.b, Boolean> smC;
  
  static
  {
    AppMethodBeat.i(183696);
    Object localObject1 = NfcA.class.getName();
    s.s(localObject1, "NfcA::class.java.name");
    smF = new b("NFC_A", 0, "NFC-A", (String)localObject1, (c)i.smw);
    localObject1 = NfcB.class.getName();
    s.s(localObject1, "NfcB::class.java.name");
    smG = new b("NFC_B", 1, "NFC-B", (String)localObject1, null);
    localObject1 = IsoDep.class.getName();
    s.s(localObject1, "IsoDep::class.java.name");
    smH = new b("ISO_DEP", 2, "ISO-DEP", (String)localObject1, (c)d.smg);
    localObject1 = NfcF.class.getName();
    s.s(localObject1, "NfcF::class.java.name");
    smI = new b("NFC_F", 3, "NFC-F", (String)localObject1, null);
    localObject1 = NfcV.class.getName();
    s.s(localObject1, "NfcV::class.java.name");
    smJ = new b("NFC_V", 4, "NFC-V", (String)localObject1, null);
    localObject1 = MifareClassic.class.getName();
    s.s(localObject1, "MifareClassic::class.java.name");
    smK = new b("MIFARE_CLASSIC", 5, "MIFARE Classic", (String)localObject1, null);
    localObject1 = MifareUltralight.class.getName();
    s.s(localObject1, "MifareUltralight::class.java.name");
    smL = new b("MIFARE_ULTRALIGHT", 6, "MIFARE Ultralight", (String)localObject1, null);
    localObject1 = Ndef.class.getName();
    s.s(localObject1, "Ndef::class.java.name");
    smM = new b("NDEF", 7, "NDEF", (String)localObject1, null);
    smN = new b[] { smF, smG, smH, smI, smJ, smK, smL, smM };
    smz = new b.a((byte)0);
    localObject1 = values();
    Collection localCollection = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = localObject1[i];
      localCollection.add(v.Y(localObject2.sln, localObject2));
      i += 1;
    }
    smD = ak.F((Iterable)localCollection);
    localObject1 = values();
    localCollection = (Collection)new ArrayList(localObject1.length);
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      localCollection.add(v.Y(localObject2.smA, localObject2.sln));
      i += 1;
    }
    smE = ak.F((Iterable)localCollection);
    AppMethodBeat.o(183696);
  }
  
  private b(String paramString1, String paramString2, c paramc)
  {
    AppMethodBeat.i(328119);
    this.sln = paramString1;
    this.smA = paramString2;
    this.smB = paramc;
    this.smC = new ArrayMap();
    AppMethodBeat.o(328119);
  }
  
  public static final boolean a(b paramb, String paramString, Class[] paramArrayOfClass, b.b paramb1)
  {
    boolean bool = true;
    AppMethodBeat.i(328136);
    s.u(paramb, "this$0");
    s.u(paramString, "$name");
    s.u(paramArrayOfClass, "$parameterTypes");
    s.u(paramb1, "$methodSignature");
    try
    {
      Class.forName(paramb.smA).getDeclaredMethod(paramString, (Class[])Arrays.copyOf(paramArrayOfClass, 1));
      ((Map)paramb.smC).put(paramb1, Boolean.valueOf(bool));
      AppMethodBeat.o(328136);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = new StringBuilder("get ").append(paramb.smA).append('.').append(paramString).append('(');
        paramArrayOfClass = Arrays.toString(paramArrayOfClass);
        s.s(paramArrayOfClass, "java.util.Arrays.toString(this)");
        Log.i("MicroMsg.AppBrand.NFCTech", paramArrayOfClass + ") failed since " + localException);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b
 * JD-Core Version:    0.7.0.1
 */