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
    AppMethodBeat.i(207768);
    if ((b(parama)) && (c(parama)))
    {
      Object localObject = ((com.tencent.h.a.c.b.c)((f)parama.ZTq.get(0)).mXB.get(0)).ZTI;
      parama = (g)((ArrayList)localObject).get(0);
      localObject = (g)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if ((parama == null) || (localObject == null))
      {
        AppMethodBeat.o(207768);
        return 0L;
      }
      long l = Math.abs(((g)localObject).Zqg - parama.Zqg);
      i.i("sensor_ConvtUtil", "[method: getReqDuration ] calculate by sensor : ".concat(String.valueOf(l)));
      AppMethodBeat.o(207768);
      return l;
    }
    AppMethodBeat.o(207768);
    return 0L;
  }
  
  public static void a(com.tencent.h.a.a.c paramc, com.tencent.h.a.c.b.a parama, com.tencent.h.a.b paramb)
  {
    AppMethodBeat.i(207774);
    if ((paramc == null) || (parama == null) || (paramb == null))
    {
      AppMethodBeat.o(207774);
      return;
    }
    parama.channelId = 301096;
    parama.ZTr = 2L;
    int i;
    if (com.tencent.h.a.b.ZRL == paramb) {
      i = 0;
    }
    for (;;)
    {
      parama.dataType = i;
      parama.ZTs = paramc.ZSr.ZSB;
      paramb = com.tencent.g.c.c.bCQ("");
      String str1 = com.tencent.g.c.c.bCQ("");
      String str2 = com.tencent.g.c.c.bCQ(com.tencent.g.c.c.lX(paramc.mAppContext));
      parama.vid = (paramb + "_" + str1 + "_" + str2);
      parama.platform = 2;
      parama.brand = Build.BRAND;
      parama.model = Build.MODEL;
      parama.PzG = com.tencent.g.c.c.getAppVersionCode(paramc.mAppContext);
      parama.ZnN = "24C8B65CA976DDE3";
      parama.ZpU = com.tencent.g.c.c.getAppPackageName(paramc.mAppContext);
      parama.imsi = "";
      parama.ZpV = Build.FINGERPRINT;
      parama.sdkVer = Build.VERSION.SDK_INT;
      parama.ZTu = 2;
      parama.imei = "1234567890ABCDEF";
      AppMethodBeat.o(207774);
      return;
      if (com.tencent.h.a.b.ZRN == paramb) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
  
  public static void a(f paramf1, f paramf2)
  {
    AppMethodBeat.i(207769);
    if ((paramf1 == null) || (paramf2 == null))
    {
      AppMethodBeat.o(207769);
      return;
    }
    if ((paramf1.mXB == null) || (paramf1.mXB.isEmpty()) || (((com.tencent.h.a.c.b.c)paramf1.mXB.get(0)).ZTI == null))
    {
      AppMethodBeat.o(207769);
      return;
    }
    if ((paramf2.mXB == null) || (paramf2.mXB.isEmpty()) || (((com.tencent.h.a.c.b.c)paramf2.mXB.get(0)).ZTI == null))
    {
      AppMethodBeat.o(207769);
      return;
    }
    ((com.tencent.h.a.c.b.c)paramf1.mXB.get(0)).ZTI.addAll(((com.tencent.h.a.c.b.c)paramf2.mXB.get(0)).ZTI);
    AppMethodBeat.o(207769);
  }
  
  public static void b(f paramf1, f paramf2)
  {
    AppMethodBeat.i(207770);
    if ((paramf1 == null) || (paramf2 == null))
    {
      AppMethodBeat.o(207770);
      return;
    }
    if (paramf1.ZTQ == null) {
      paramf1.ZTQ = new ArrayList();
    }
    if (paramf2.ZTQ != null) {
      paramf1.ZTQ.addAll(paramf2.ZTQ);
    }
    AppMethodBeat.o(207770);
  }
  
  public static boolean b(com.tencent.h.a.c.b.a parama)
  {
    AppMethodBeat.i(207771);
    if ((parama == null) || (parama.ZTq == null) || (parama.ZTq.isEmpty()))
    {
      AppMethodBeat.o(207771);
      return false;
    }
    parama = (f)parama.ZTq.get(0);
    if ((parama == null) || (parama.mXB == null) || (parama.mXB.isEmpty()))
    {
      AppMethodBeat.o(207771);
      return false;
    }
    parama = (com.tencent.h.a.c.b.c)parama.mXB.get(0);
    if ((parama == null) || (parama.ZTI == null) || (parama.ZTI.isEmpty()))
    {
      AppMethodBeat.o(207771);
      return false;
    }
    AppMethodBeat.o(207771);
    return true;
  }
  
  public static boolean c(com.tencent.h.a.c.b.a parama)
  {
    AppMethodBeat.i(207773);
    if ((parama == null) || (parama.ZTq == null) || (parama.ZTq.isEmpty()))
    {
      AppMethodBeat.o(207773);
      return false;
    }
    parama = (f)parama.ZTq.get(0);
    if ((parama == null) || (parama.ZTQ == null) || (parama.ZTQ.isEmpty()))
    {
      AppMethodBeat.o(207773);
      return false;
    }
    if ((parama.ZTQ == null) || (parama.ZTQ.isEmpty()))
    {
      AppMethodBeat.o(207773);
      return false;
    }
    AppMethodBeat.o(207773);
    return true;
  }
  
  public static Map<String, String> ms(Context paramContext)
  {
    AppMethodBeat.i(207776);
    HashMap localHashMap = new HashMap();
    try
    {
      Object localObject = j.a(new j.a()
      {
        public final byte[] dt(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(207799);
          paramAnonymousArrayOfByte = com.tencent.g.c.a.dt(paramAnonymousArrayOfByte);
          AppMethodBeat.o(207799);
          return paramAnonymousArrayOfByte;
        }
        
        public final byte[] readFile(String paramAnonymousString)
        {
          AppMethodBeat.i(207800);
          paramAnonymousString = e.T(new File(paramAnonymousString));
          AppMethodBeat.o(207800);
          return paramAnonymousString;
        }
        
        public final byte[] s(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
        {
          AppMethodBeat.i(207797);
          paramAnonymousArrayOfByte1 = com.tencent.g.c.b.q(paramAnonymousArrayOfByte1, paramAnonymousArrayOfByte2);
          AppMethodBeat.o(207797);
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
      localObject = com.tencent.g.c.c.ity();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("turingSID", localObject);
      }
      localObject = com.tencent.g.c.c.ioo();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("turingKV", localObject);
      }
      int i = com.tencent.g.c.c.getScreenWidth(paramContext);
      int j = com.tencent.g.c.c.getScreenHeight(paramContext);
      localHashMap.put("turingDPL", String.valueOf(i) + "*" + String.valueOf(j));
      return localHashMap;
    }
    catch (Throwable paramContext)
    {
      return localHashMap;
    }
    finally
    {
      AppMethodBeat.o(207776);
    }
    return localHashMap;
  }
  
  public static ArrayList<d> w(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(207767);
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(207767);
      return localArrayList;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      d locald = new d();
      locald.ZTM = ((String)localEntry.getKey());
      locald.ZTN = ((String)localEntry.getValue());
      i.i("sensor_ConvtUtil", "[method: toDetectFeatures ] [ " + locald.ZTM + ", " + locald.ZTN + " ]");
      localArrayList.add(locald);
    }
    AppMethodBeat.o(207767);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */