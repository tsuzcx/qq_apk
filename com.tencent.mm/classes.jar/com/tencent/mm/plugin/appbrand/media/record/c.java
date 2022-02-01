package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c
{
  private static Map<String, com.tencent.mm.sdk.b.c> lVM;
  private static ArrayList<String> lVN;
  private static boolean lVO;
  
  static
  {
    AppMethodBeat.i(146148);
    lVM = new HashMap();
    lVN = new ArrayList();
    lVO = false;
    AppMethodBeat.o(146148);
  }
  
  public static void Tb(String paramString)
  {
    AppMethodBeat.i(146145);
    if (!lVM.containsKey(paramString))
    {
      ae.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(146145);
      return;
    }
    ae.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", new Object[] { paramString });
    lVN.remove(paramString);
    paramString = (com.tencent.mm.sdk.b.c)lVM.remove(paramString);
    if (paramString != null) {
      a.IvT.d(paramString);
    }
    AppMethodBeat.o(146145);
  }
  
  public static void b(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(146144);
    if (lVM.containsKey(paramString))
    {
      ae.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", new Object[] { paramString });
      AppMethodBeat.o(146144);
      return;
    }
    if (paramc == null)
    {
      ae.e("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
      AppMethodBeat.o(146144);
      return;
    }
    ae.i("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", new Object[] { paramString });
    lVM.put(paramString, paramc);
    if (!lVN.contains(paramString)) {
      lVN.add(paramString);
    }
    a.IvT.b(paramc);
    AppMethodBeat.o(146144);
  }
  
  public static void btp()
  {
    AppMethodBeat.i(146146);
    if (lVO)
    {
      ae.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
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
    ae.i("MicroMsg.Record.AppBrandRecordClientService", "onDestroy");
    Object localObject1 = lVN.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (com.tencent.mm.sdk.b.c)lVM.remove(localObject2);
      if (localObject2 != null) {
        a.IvT.d((com.tencent.mm.sdk.b.c)localObject2);
      }
    }
    lVM.clear();
    lVN.clear();
    localObject1 = g.btx();
    ae.i("MicroMsg.Record.AudioRecordMgr", "destroy");
    if ((((g)localObject1).lVT == g.a.lWi) || (((g)localObject1).lVT == g.a.lWj) || (((g)localObject1).lVT == g.a.lWm)) {
      ((g)localObject1).PF();
    }
    if (((g)localObject1).lVZ)
    {
      if ((((g)localObject1).lVS != null) && (((g)localObject1).lVS.lWS != null))
      {
        ((g)localObject1).lVS.lWS.a(null);
        ((g)localObject1).lVS.lWS.btw();
      }
      ((g)localObject1).lVZ = false;
    }
    AppMethodBeat.o(146143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.c
 * JD-Core Version:    0.7.0.1
 */