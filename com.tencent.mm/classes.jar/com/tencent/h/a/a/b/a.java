package com.tencent.h.a.a.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.g.c.e;
import com.tencent.g.c.i;
import com.tencent.g.c.j;
import com.tencent.g.c.j.a;
import com.tencent.h.a.c.b.d;
import com.tencent.h.a.c.b.f;
import com.tencent.h.a.c.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  public static long a(com.tencent.h.a.c.b.a parama)
  {
    AppMethodBeat.i(212119);
    if ((b(parama)) && (c(parama)))
    {
      Object localObject = ((com.tencent.h.a.c.b.c)((f)parama.ahXQ.get(0)).pUj.get(0)).ahYi;
      parama = (g)((ArrayList)localObject).get(0);
      localObject = (g)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if ((parama == null) || (localObject == null))
      {
        AppMethodBeat.o(212119);
        return 0L;
      }
      long l = Math.abs(((g)localObject).ahuN - parama.ahuN);
      i.i("sensor_ConvtUtil", "[method: getReqDuration ] calculate by sensor : ".concat(String.valueOf(l)));
      AppMethodBeat.o(212119);
      return l;
    }
    AppMethodBeat.o(212119);
    return 0L;
  }
  
  public static void a(com.tencent.h.a.a.c paramc, com.tencent.h.a.c.b.a parama, com.tencent.h.a.b paramb)
  {
    AppMethodBeat.i(212142);
    if ((paramc == null) || (parama == null) || (paramb == null))
    {
      AppMethodBeat.o(212142);
      return;
    }
    parama.channelId = 301096;
    parama.ahXR = 3L;
    int i;
    if (com.tencent.h.a.b.ahWi == paramb) {
      i = 0;
    }
    for (;;)
    {
      parama.dataType = i;
      parama.ahXS = paramc.ahWP.ahXb;
      paramb = com.tencent.g.c.c.bFv(com.tencent.g.c.c.kcS());
      String str1 = com.tencent.g.c.c.bFv(com.tencent.g.c.c.kcS());
      String str2 = com.tencent.g.c.c.bFv(com.tencent.g.c.c.jXA());
      parama.vid = (paramb + "_" + str1 + "_" + str2);
      parama.platform = 2;
      parama.brand = Build.BRAND;
      parama.model = com.tencent.g.c.c.getModelName();
      parama.WpO = com.tencent.g.c.c.getAppVersionCode(paramc.mAppContext);
      parama.ahsv = "5MBQ49B5AM14YYWJ";
      parama.ahuC = com.tencent.g.c.c.getAppPackageName(paramc.mAppContext);
      parama.imsi = com.tencent.g.c.c.kcR();
      parama.hyE = Build.FINGERPRINT;
      parama.sdkVer = Build.VERSION.SDK_INT;
      parama.ahXU = 3;
      parama.imei = com.tencent.g.c.c.kcQ();
      AppMethodBeat.o(212142);
      return;
      if (com.tencent.h.a.b.ahWk == paramb) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
  
  public static void a(f paramf1, f paramf2)
  {
    AppMethodBeat.i(212124);
    if ((paramf1 == null) || (paramf2 == null))
    {
      AppMethodBeat.o(212124);
      return;
    }
    if ((paramf1.pUj == null) || (paramf1.pUj.isEmpty()) || (((com.tencent.h.a.c.b.c)paramf1.pUj.get(0)).ahYi == null))
    {
      AppMethodBeat.o(212124);
      return;
    }
    if ((paramf2.pUj == null) || (paramf2.pUj.isEmpty()) || (((com.tencent.h.a.c.b.c)paramf2.pUj.get(0)).ahYi == null))
    {
      AppMethodBeat.o(212124);
      return;
    }
    ((com.tencent.h.a.c.b.c)paramf1.pUj.get(0)).ahYi.addAll(((com.tencent.h.a.c.b.c)paramf2.pUj.get(0)).ahYi);
    AppMethodBeat.o(212124);
  }
  
  public static void b(f paramf1, f paramf2)
  {
    AppMethodBeat.i(212129);
    if ((paramf1 == null) || (paramf2 == null))
    {
      AppMethodBeat.o(212129);
      return;
    }
    if (paramf1.ahYq == null) {
      paramf1.ahYq = new ArrayList();
    }
    if (paramf2.ahYq != null) {
      paramf1.ahYq.addAll(paramf2.ahYq);
    }
    AppMethodBeat.o(212129);
  }
  
  public static boolean b(com.tencent.h.a.c.b.a parama)
  {
    AppMethodBeat.i(212135);
    if ((parama == null) || (parama.ahXQ == null) || (parama.ahXQ.isEmpty()))
    {
      AppMethodBeat.o(212135);
      return false;
    }
    parama = (f)parama.ahXQ.get(0);
    if ((parama == null) || (parama.pUj == null) || (parama.pUj.isEmpty()))
    {
      AppMethodBeat.o(212135);
      return false;
    }
    parama = (com.tencent.h.a.c.b.c)parama.pUj.get(0);
    if ((parama == null) || (parama.ahYi == null) || (parama.ahYi.isEmpty()))
    {
      AppMethodBeat.o(212135);
      return false;
    }
    AppMethodBeat.o(212135);
    return true;
  }
  
  public static boolean c(com.tencent.h.a.c.b.a parama)
  {
    AppMethodBeat.i(212136);
    if ((parama == null) || (parama.ahXQ == null) || (parama.ahXQ.isEmpty()))
    {
      AppMethodBeat.o(212136);
      return false;
    }
    parama = (f)parama.ahXQ.get(0);
    if ((parama == null) || (parama.ahYq == null) || (parama.ahYq.isEmpty()))
    {
      AppMethodBeat.o(212136);
      return false;
    }
    if ((parama.ahYq == null) || (parama.ahYq.isEmpty()))
    {
      AppMethodBeat.o(212136);
      return false;
    }
    AppMethodBeat.o(212136);
    return true;
  }
  
  public static Map<String, String> oI(Context paramContext)
  {
    AppMethodBeat.i(212151);
    HashMap localHashMap = new HashMap();
    try
    {
      Object localObject = j.a(new j.a()
      {
        public final byte[] dv(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(212118);
          paramAnonymousArrayOfByte = com.tencent.g.c.a.dv(paramAnonymousArrayOfByte);
          AppMethodBeat.o(212118);
          return paramAnonymousArrayOfByte;
        }
        
        public final byte[] readFile(String paramAnonymousString)
        {
          AppMethodBeat.i(212122);
          paramAnonymousString = e.Y(new File(paramAnonymousString));
          AppMethodBeat.o(212122);
          return paramAnonymousString;
        }
        
        public final byte[] t(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
        {
          AppMethodBeat.i(212113);
          paramAnonymousArrayOfByte1 = com.tencent.g.c.b.r(paramAnonymousArrayOfByte1, paramAnonymousArrayOfByte2);
          AppMethodBeat.o(212113);
          return paramAnonymousArrayOfByte1;
        }
      });
      if (localObject != null)
      {
        String str = (String)((Map)localObject).get("1");
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put("turingU", str);
        }
        localObject = (String)((Map)localObject).get("2");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put("turingO", localObject);
        }
      }
      localObject = com.tencent.g.c.c.kcT();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("turingSID", localObject);
      }
      localObject = com.tencent.g.c.c.jXB();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("turingKV", localObject);
      }
      int i = com.tencent.g.c.c.getScreenWidth(paramContext);
      int j = com.tencent.g.c.c.getScreenHeight(paramContext);
      localHashMap.put("turingDPL", String.valueOf(i) + "*" + String.valueOf(j));
      return localHashMap;
    }
    finally
    {
      AppMethodBeat.o(212151);
    }
    return localHashMap;
  }
  
  public static ArrayList<d> z(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(212111);
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(212111);
      return localArrayList;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      d locald = new d();
      locald.ahYm = ((String)localEntry.getKey());
      locald.ahYn = ((String)localEntry.getValue());
      i.i("sensor_ConvtUtil", "[method: toDetectFeatures ] [ " + locald.ahYm + ", " + locald.ahYn + " ]");
      localArrayList.add(locald);
    }
    AppMethodBeat.o(212111);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */