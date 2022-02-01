package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c
{
  private static Map<String, com.tencent.mm.sdk.b.c> kQC;
  private static ArrayList<String> kQD;
  private static boolean kQE;
  
  static
  {
    AppMethodBeat.i(146148);
    kQC = new HashMap();
    kQD = new ArrayList();
    kQE = false;
    AppMethodBeat.o(146148);
  }
  
  public static void KI(String paramString)
  {
    AppMethodBeat.i(146145);
    if (!kQC.containsKey(paramString))
    {
      ad.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(146145);
      return;
    }
    ad.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", new Object[] { paramString });
    kQD.remove(paramString);
    paramString = (com.tencent.mm.sdk.b.c)kQC.remove(paramString);
    if (paramString != null) {
      a.ESL.d(paramString);
    }
    AppMethodBeat.o(146145);
  }
  
  public static void b(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(146144);
    if (kQC.containsKey(paramString))
    {
      ad.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", new Object[] { paramString });
      AppMethodBeat.o(146144);
      return;
    }
    if (paramc == null)
    {
      ad.e("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
      AppMethodBeat.o(146144);
      return;
    }
    ad.i("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", new Object[] { paramString });
    kQC.put(paramString, paramc);
    if (!kQD.contains(paramString)) {
      kQD.add(paramString);
    }
    a.ESL.b(paramc);
    AppMethodBeat.o(146144);
  }
  
  public static void bhL()
  {
    AppMethodBeat.i(146146);
    if (kQE)
    {
      ad.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
      AppMethodBeat.o(146146);
      return;
    }
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146140);
        c.access$000();
        AppMethodBeat.o(146140);
      }
    }, "record_update_device_info");
    AppMethodBeat.o(146146);
  }
  
  public static void onCreate() {}
  
  public static void onDestroy()
  {
    AppMethodBeat.i(146143);
    ad.i("MicroMsg.Record.AppBrandRecordClientService", "onDestroy");
    Object localObject1 = kQD.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (com.tencent.mm.sdk.b.c)kQC.remove(localObject2);
      if (localObject2 != null) {
        a.ESL.d((com.tencent.mm.sdk.b.c)localObject2);
      }
    }
    kQC.clear();
    kQD.clear();
    localObject1 = g.bhT();
    ad.i("MicroMsg.Record.AudioRecordMgr", "destroy");
    if ((((g)localObject1).kQJ == g.a.kQY) || (((g)localObject1).kQJ == g.a.kQZ) || (((g)localObject1).kQJ == g.a.kRc)) {
      ((g)localObject1).Ob();
    }
    if (((g)localObject1).kQP)
    {
      if ((((g)localObject1).kQI != null) && (((g)localObject1).kQI.kRI != null))
      {
        ((g)localObject1).kQI.kRI.a(null);
        ((g)localObject1).kQI.kRI.bhS();
      }
      ((g)localObject1).kQP = false;
    }
    AppMethodBeat.o(146143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.c
 * JD-Core Version:    0.7.0.1
 */