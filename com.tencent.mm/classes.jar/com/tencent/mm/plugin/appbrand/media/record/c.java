package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c
{
  private static Map<String, com.tencent.mm.sdk.b.c> lsb;
  private static ArrayList<String> lsc;
  private static boolean lsd;
  
  static
  {
    AppMethodBeat.i(146148);
    lsb = new HashMap();
    lsc = new ArrayList();
    lsd = false;
    AppMethodBeat.o(146148);
  }
  
  public static void OP(String paramString)
  {
    AppMethodBeat.i(146145);
    if (!lsb.containsKey(paramString))
    {
      ac.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(146145);
      return;
    }
    ac.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", new Object[] { paramString });
    lsc.remove(paramString);
    paramString = (com.tencent.mm.sdk.b.c)lsb.remove(paramString);
    if (paramString != null) {
      a.GpY.d(paramString);
    }
    AppMethodBeat.o(146145);
  }
  
  public static void b(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(146144);
    if (lsb.containsKey(paramString))
    {
      ac.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", new Object[] { paramString });
      AppMethodBeat.o(146144);
      return;
    }
    if (paramc == null)
    {
      ac.e("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
      AppMethodBeat.o(146144);
      return;
    }
    ac.i("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", new Object[] { paramString });
    lsb.put(paramString, paramc);
    if (!lsc.contains(paramString)) {
      lsc.add(paramString);
    }
    a.GpY.b(paramc);
    AppMethodBeat.o(146144);
  }
  
  public static void boF()
  {
    AppMethodBeat.i(146146);
    if (lsd)
    {
      ac.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
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
    ac.i("MicroMsg.Record.AppBrandRecordClientService", "onDestroy");
    Object localObject1 = lsc.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (com.tencent.mm.sdk.b.c)lsb.remove(localObject2);
      if (localObject2 != null) {
        a.GpY.d((com.tencent.mm.sdk.b.c)localObject2);
      }
    }
    lsb.clear();
    lsc.clear();
    localObject1 = g.boN();
    ac.i("MicroMsg.Record.AudioRecordMgr", "destroy");
    if ((((g)localObject1).lsj == g.a.lsy) || (((g)localObject1).lsj == g.a.lsz) || (((g)localObject1).lsj == g.a.lsC)) {
      ((g)localObject1).NX();
    }
    if (((g)localObject1).lsp)
    {
      if ((((g)localObject1).lsi != null) && (((g)localObject1).lsi.lti != null))
      {
        ((g)localObject1).lsi.lti.a(null);
        ((g)localObject1).lsi.lti.boM();
      }
      ((g)localObject1).lsp = false;
    }
    AppMethodBeat.o(146143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.c
 * JD-Core Version:    0.7.0.1
 */