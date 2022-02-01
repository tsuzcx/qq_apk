package com.tencent.i.a.a.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.h.c.e;
import com.tencent.h.c.h;
import com.tencent.h.c.i;
import com.tencent.h.c.i.a;
import com.tencent.i.a.c.b.d;
import com.tencent.i.a.c.b.f;
import com.tencent.i.a.c.b.g;
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
  public static long a(com.tencent.i.a.c.b.a parama)
  {
    AppMethodBeat.i(214690);
    if ((b(parama)) && (c(parama)))
    {
      Object localObject = ((com.tencent.i.a.c.b.c)((f)parama.SrN.get(0)).kgc.get(0)).Ssd;
      parama = (g)((ArrayList)localObject).get(0);
      localObject = (g)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if ((parama == null) || (localObject == null))
      {
        AppMethodBeat.o(214690);
        return 0L;
      }
      long l = Math.abs(((g)localObject).RNA - parama.RNA);
      h.i("sensor_ConvtUtil", "[method: getReqDuration ] calculate by sensor : ".concat(String.valueOf(l)));
      AppMethodBeat.o(214690);
      return l;
    }
    AppMethodBeat.o(214690);
    return 0L;
  }
  
  public static void a(com.tencent.i.a.a.c paramc, com.tencent.i.a.c.b.a parama, com.tencent.i.a.b paramb)
  {
    AppMethodBeat.i(214695);
    if ((paramc == null) || (parama == null) || (paramb == null))
    {
      AppMethodBeat.o(214695);
      return;
    }
    parama.channelId = 301096;
    parama.SrO = 2L;
    int i;
    if (com.tencent.i.a.b.Sqi == paramb) {
      i = 0;
    }
    for (;;)
    {
      parama.dataType = i;
      parama.SrP = paramc.SqO.SqY;
      paramb = com.tencent.h.c.c.bpY(com.tencent.h.c.c.DO(true));
      String str1 = com.tencent.h.c.c.bpY(com.tencent.h.c.c.DO(false));
      String str2 = com.tencent.h.c.c.bpY(com.tencent.h.c.c.kZ(paramc.mAppContext));
      parama.vid = (paramb + "_" + str1 + "_" + str2);
      parama.platform = 2;
      parama.brand = Build.BRAND;
      parama.model = Build.MODEL;
      parama.IFo = com.tencent.h.c.c.getAppVersionCode(paramc.mAppContext);
      parama.RLg = "24C8B65CA976DDE3";
      parama.RNo = com.tencent.h.c.c.getAppPackageName(paramc.mAppContext);
      parama.imsi = com.tencent.h.c.c.kY(paramc.mAppContext);
      parama.RNp = Build.FINGERPRINT;
      parama.sdkVer = Build.VERSION.SDK_INT;
      parama.SrR = 2;
      parama.imei = com.tencent.h.c.c.getIMEI(paramc.mAppContext);
      AppMethodBeat.o(214695);
      return;
      if (com.tencent.i.a.b.Sqk == paramb) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
  
  public static void a(f paramf1, f paramf2)
  {
    AppMethodBeat.i(214691);
    if ((paramf1 == null) || (paramf2 == null))
    {
      AppMethodBeat.o(214691);
      return;
    }
    if ((paramf1.kgc == null) || (paramf1.kgc.isEmpty()) || (((com.tencent.i.a.c.b.c)paramf1.kgc.get(0)).Ssd == null))
    {
      AppMethodBeat.o(214691);
      return;
    }
    if ((paramf2.kgc == null) || (paramf2.kgc.isEmpty()) || (((com.tencent.i.a.c.b.c)paramf2.kgc.get(0)).Ssd == null))
    {
      AppMethodBeat.o(214691);
      return;
    }
    ((com.tencent.i.a.c.b.c)paramf1.kgc.get(0)).Ssd.addAll(((com.tencent.i.a.c.b.c)paramf2.kgc.get(0)).Ssd);
    AppMethodBeat.o(214691);
  }
  
  public static void b(f paramf1, f paramf2)
  {
    AppMethodBeat.i(214692);
    if ((paramf1 == null) || (paramf2 == null))
    {
      AppMethodBeat.o(214692);
      return;
    }
    if (paramf1.Ssn == null) {
      paramf1.Ssn = new ArrayList();
    }
    if (paramf2.Ssn != null) {
      paramf1.Ssn.addAll(paramf2.Ssn);
    }
    AppMethodBeat.o(214692);
  }
  
  public static boolean b(com.tencent.i.a.c.b.a parama)
  {
    AppMethodBeat.i(214693);
    if ((parama == null) || (parama.SrN == null) || (parama.SrN.isEmpty()))
    {
      AppMethodBeat.o(214693);
      return false;
    }
    parama = (f)parama.SrN.get(0);
    if ((parama == null) || (parama.kgc == null) || (parama.kgc.isEmpty()))
    {
      AppMethodBeat.o(214693);
      return false;
    }
    parama = (com.tencent.i.a.c.b.c)parama.kgc.get(0);
    if ((parama == null) || (parama.Ssd == null) || (parama.Ssd.isEmpty()))
    {
      AppMethodBeat.o(214693);
      return false;
    }
    AppMethodBeat.o(214693);
    return true;
  }
  
  public static boolean c(com.tencent.i.a.c.b.a parama)
  {
    AppMethodBeat.i(214694);
    if ((parama == null) || (parama.SrN == null) || (parama.SrN.isEmpty()))
    {
      AppMethodBeat.o(214694);
      return false;
    }
    parama = (f)parama.SrN.get(0);
    if ((parama == null) || (parama.Ssn == null) || (parama.Ssn.isEmpty()))
    {
      AppMethodBeat.o(214694);
      return false;
    }
    if ((parama.Ssn == null) || (parama.Ssn.isEmpty()))
    {
      AppMethodBeat.o(214694);
      return false;
    }
    AppMethodBeat.o(214694);
    return true;
  }
  
  public static Map<String, String> lu(Context paramContext)
  {
    AppMethodBeat.i(214696);
    HashMap localHashMap = new HashMap();
    try
    {
      Object localObject = i.a(new i.a()
      {
        public final byte[] cV(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(214687);
          paramAnonymousArrayOfByte = com.tencent.h.c.a.cV(paramAnonymousArrayOfByte);
          AppMethodBeat.o(214687);
          return paramAnonymousArrayOfByte;
        }
        
        public final byte[] q(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
        {
          AppMethodBeat.i(214686);
          paramAnonymousArrayOfByte1 = com.tencent.h.c.b.o(paramAnonymousArrayOfByte1, paramAnonymousArrayOfByte2);
          AppMethodBeat.o(214686);
          return paramAnonymousArrayOfByte1;
        }
        
        public final byte[] readFile(String paramAnonymousString)
        {
          AppMethodBeat.i(214688);
          paramAnonymousString = e.aa(new File(paramAnonymousString));
          AppMethodBeat.o(214688);
          return paramAnonymousString;
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
      localObject = com.tencent.h.c.c.hpT();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("turingSID", localObject);
      }
      localObject = com.tencent.h.c.c.hkQ();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("turingKV", localObject);
      }
      int i = com.tencent.h.c.c.getScreenWidth(paramContext);
      int j = com.tencent.h.c.c.getScreenHeight(paramContext);
      localHashMap.put("turingDPL", String.valueOf(i) + "*" + String.valueOf(j));
      return localHashMap;
    }
    catch (Throwable paramContext)
    {
      return localHashMap;
    }
    finally
    {
      AppMethodBeat.o(214696);
    }
    return localHashMap;
  }
  
  public static ArrayList<d> z(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(214689);
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(214689);
      return localArrayList;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      d locald = new d();
      locald.Ssh = ((String)localEntry.getKey());
      locald.Ssi = ((String)localEntry.getValue());
      h.i("sensor_ConvtUtil", "[method: toDetectFeatures ] [ " + locald.Ssh + ", " + locald.Ssi + " ]");
      localArrayList.add(locald);
    }
    AppMethodBeat.o(214689);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */