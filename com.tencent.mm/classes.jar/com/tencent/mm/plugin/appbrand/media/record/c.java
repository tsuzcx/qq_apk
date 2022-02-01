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
  private static Map<String, com.tencent.mm.sdk.b.c> lRl;
  private static ArrayList<String> lRm;
  private static boolean lRn;
  
  static
  {
    AppMethodBeat.i(146148);
    lRl = new HashMap();
    lRm = new ArrayList();
    lRn = false;
    AppMethodBeat.o(146148);
  }
  
  public static void Ss(String paramString)
  {
    AppMethodBeat.i(146145);
    if (!lRl.containsKey(paramString))
    {
      ad.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(146145);
      return;
    }
    ad.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", new Object[] { paramString });
    lRm.remove(paramString);
    paramString = (com.tencent.mm.sdk.b.c)lRl.remove(paramString);
    if (paramString != null) {
      a.IbL.d(paramString);
    }
    AppMethodBeat.o(146145);
  }
  
  public static void b(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(146144);
    if (lRl.containsKey(paramString))
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
    lRl.put(paramString, paramc);
    if (!lRm.contains(paramString)) {
      lRm.add(paramString);
    }
    a.IbL.b(paramc);
    AppMethodBeat.o(146144);
  }
  
  public static void bsE()
  {
    AppMethodBeat.i(146146);
    if (lRn)
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
    Object localObject1 = lRm.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (com.tencent.mm.sdk.b.c)lRl.remove(localObject2);
      if (localObject2 != null) {
        a.IbL.d((com.tencent.mm.sdk.b.c)localObject2);
      }
    }
    lRl.clear();
    lRm.clear();
    localObject1 = g.bsM();
    ad.i("MicroMsg.Record.AudioRecordMgr", "destroy");
    if ((((g)localObject1).lRs == g.a.lRH) || (((g)localObject1).lRs == g.a.lRI) || (((g)localObject1).lRs == g.a.lRL)) {
      ((g)localObject1).PG();
    }
    if (((g)localObject1).lRy)
    {
      if ((((g)localObject1).lRr != null) && (((g)localObject1).lRr.lSr != null))
      {
        ((g)localObject1).lRr.lSr.a(null);
        ((g)localObject1).lRr.lSr.bsL();
      }
      ((g)localObject1).lRy = false;
    }
    AppMethodBeat.o(146143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.c
 * JD-Core Version:    0.7.0.1
 */