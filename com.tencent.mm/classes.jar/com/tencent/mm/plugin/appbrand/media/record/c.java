package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c
{
  private static Map<String, IListener> qdC;
  private static ArrayList<String> qdD;
  private static boolean qdE;
  
  static
  {
    AppMethodBeat.i(146148);
    qdC = new HashMap();
    qdD = new ArrayList();
    qdE = false;
    AppMethodBeat.o(146148);
  }
  
  public static void akz(String paramString)
  {
    AppMethodBeat.i(146145);
    if (!qdC.containsKey(paramString))
    {
      Log.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(146145);
      return;
    }
    Log.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", new Object[] { paramString });
    qdD.remove(paramString);
    paramString = (IListener)qdC.remove(paramString);
    if (paramString != null) {
      EventCenter.instance.removeListener(paramString);
    }
    AppMethodBeat.o(146145);
  }
  
  public static void b(String paramString, IListener paramIListener)
  {
    AppMethodBeat.i(146144);
    if (qdC.containsKey(paramString))
    {
      Log.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", new Object[] { paramString });
      AppMethodBeat.o(146144);
      return;
    }
    if (paramIListener == null)
    {
      Log.e("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
      AppMethodBeat.o(146144);
      return;
    }
    Log.i("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", new Object[] { paramString });
    qdC.put(paramString, paramIListener);
    if (!qdD.contains(paramString)) {
      qdD.add(paramString);
    }
    EventCenter.instance.add(paramIListener);
    AppMethodBeat.o(146144);
  }
  
  public static void cbi()
  {
    AppMethodBeat.i(146146);
    if (qdE)
    {
      Log.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
      AppMethodBeat.o(146146);
      return;
    }
    ThreadPool.post(new Runnable()
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
    Log.i("MicroMsg.Record.AppBrandRecordClientService", "onDestroy");
    Object localObject1 = qdD.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (IListener)qdC.remove(localObject2);
      if (localObject2 != null) {
        EventCenter.instance.removeListener((IListener)localObject2);
      }
    }
    qdC.clear();
    qdD.clear();
    localObject1 = g.cbq();
    Log.i("MicroMsg.Record.AudioRecordMgr", "destroy");
    if ((((g)localObject1).qdL == g.a.qeb) || (((g)localObject1).qdL == g.a.qec) || (((g)localObject1).qdL == g.a.qef)) {
      ((g)localObject1).aeJ();
    }
    if (((g)localObject1).qdS)
    {
      if ((((g)localObject1).qdK != null) && (((g)localObject1).qdK.qeO != null))
      {
        ((g)localObject1).qdK.qeO.a(null);
        ((g)localObject1).qdK.qeO.cbp();
      }
      ((g)localObject1).qdS = false;
    }
    AppMethodBeat.o(146143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.c
 * JD-Core Version:    0.7.0.1
 */