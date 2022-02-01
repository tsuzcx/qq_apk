package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c
{
  private static Map<String, IListener> tis;
  private static ArrayList<String> tit;
  private static boolean tiu;
  
  static
  {
    AppMethodBeat.i(146148);
    tis = new HashMap();
    tit = new ArrayList();
    tiu = false;
    AppMethodBeat.o(146148);
  }
  
  public static void adF(String paramString)
  {
    AppMethodBeat.i(146145);
    if (!tis.containsKey(paramString))
    {
      Log.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(146145);
      return;
    }
    Log.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", new Object[] { paramString });
    tit.remove(paramString);
    paramString = (IListener)tis.remove(paramString);
    if (paramString != null) {
      paramString.dead();
    }
    AppMethodBeat.o(146145);
  }
  
  public static void b(String paramString, IListener paramIListener)
  {
    AppMethodBeat.i(146144);
    if (tis.containsKey(paramString))
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
    tis.put(paramString, paramIListener);
    if (!tit.contains(paramString)) {
      tit.add(paramString);
    }
    paramIListener.alive();
    AppMethodBeat.o(146144);
  }
  
  public static void cBC()
  {
    AppMethodBeat.i(146146);
    if (tiu)
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
    Object localObject1 = tit.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (IListener)tis.remove(localObject2);
      if (localObject2 != null) {
        ((IListener)localObject2).dead();
      }
    }
    tis.clear();
    tit.clear();
    localObject1 = g.cBK();
    Log.i("MicroMsg.Record.AudioRecordMgr", "destroy");
    if ((((g)localObject1).tiA == g.a.tiQ) || (((g)localObject1).tiA == g.a.tiR) || (((g)localObject1).tiA == g.a.tiU)) {
      ((g)localObject1).aGH();
    }
    if (((g)localObject1).tiH)
    {
      if ((((g)localObject1).tiz != null) && (((g)localObject1).tiz.tjC != null))
      {
        ((g)localObject1).tiz.tjC.a(null);
        ((g)localObject1).tiz.tjC.cBJ();
      }
      ((g)localObject1).tiH = false;
    }
    AppMethodBeat.o(146143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.c
 * JD-Core Version:    0.7.0.1
 */