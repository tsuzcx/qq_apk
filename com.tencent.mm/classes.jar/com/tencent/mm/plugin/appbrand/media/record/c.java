package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c
{
  private static Map<String, com.tencent.mm.sdk.b.c> ipp;
  private static ArrayList<String> ipq;
  private static boolean ipr;
  
  static
  {
    AppMethodBeat.i(105595);
    ipp = new HashMap();
    ipq = new ArrayList();
    ipr = false;
    AppMethodBeat.o(105595);
  }
  
  public static void DB(String paramString)
  {
    AppMethodBeat.i(105592);
    if (!ipp.containsKey(paramString))
    {
      ab.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(105592);
      return;
    }
    ab.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", new Object[] { paramString });
    ipq.remove(paramString);
    paramString = (com.tencent.mm.sdk.b.c)ipp.remove(paramString);
    if (paramString != null) {
      a.ymk.d(paramString);
    }
    AppMethodBeat.o(105592);
  }
  
  public static void aHL()
  {
    AppMethodBeat.i(105593);
    if (ipr)
    {
      ab.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
      AppMethodBeat.o(105593);
      return;
    }
    d.post(new c.1(), "record_update_device_info");
    AppMethodBeat.o(105593);
  }
  
  public static void b(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(105591);
    if (ipp.containsKey(paramString))
    {
      ab.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", new Object[] { paramString });
      AppMethodBeat.o(105591);
      return;
    }
    if (paramc == null)
    {
      ab.e("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
      AppMethodBeat.o(105591);
      return;
    }
    ab.i("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", new Object[] { paramString });
    ipp.put(paramString, paramc);
    if (!ipq.contains(paramString)) {
      ipq.add(paramString);
    }
    a.ymk.b(paramc);
    AppMethodBeat.o(105591);
  }
  
  public static void onCreate() {}
  
  public static void onDestroy()
  {
    AppMethodBeat.i(105590);
    ab.i("MicroMsg.Record.AppBrandRecordClientService", "onDestroy");
    Object localObject1 = ipq.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (com.tencent.mm.sdk.b.c)ipp.remove(localObject2);
      if (localObject2 != null) {
        a.ymk.d((com.tencent.mm.sdk.b.c)localObject2);
      }
    }
    ipp.clear();
    ipq.clear();
    localObject1 = g.aHT();
    ab.i("MicroMsg.Record.AudioRecordMgr", "destroy");
    if ((((g)localObject1).ipx == g.a.ipL) || (((g)localObject1).ipx == g.a.ipM) || (((g)localObject1).ipx == g.a.ipP)) {
      ((g)localObject1).Et();
    }
    if (((g)localObject1).ipD)
    {
      if ((((g)localObject1).ipw != null) && (((g)localObject1).ipw.iqt != null))
      {
        ((g)localObject1).ipw.iqt.a(null);
        ((g)localObject1).ipw.iqt.aHS();
      }
      ((g)localObject1).ipD = false;
    }
    AppMethodBeat.o(105590);
  }
  
  static final class a
    implements i<IPCVoid, IPCString>
  {
    private static IPCString aHM()
    {
      AppMethodBeat.i(105588);
      try
      {
        ab.i("MicroMsg.Record.AppBrandRecordClientService", "ipc updateDeviceInfo");
        IPCString localIPCString1 = new IPCString(com.tencent.mm.kernel.g.RL().Rv().dyM());
        AppMethodBeat.o(105588);
        return localIPCString1;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Record.AppBrandRecordClientService", localException, "ipc updateDeviceInfo task", new Object[0]);
        IPCString localIPCString2 = new IPCString("");
        AppMethodBeat.o(105588);
        return localIPCString2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.c
 * JD-Core Version:    0.7.0.1
 */