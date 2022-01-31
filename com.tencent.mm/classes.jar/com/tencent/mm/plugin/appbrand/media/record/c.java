package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c
{
  private static Map<String, com.tencent.mm.sdk.b.c> gNw = new HashMap();
  private static ArrayList<String> gNx = new ArrayList();
  private static boolean gNy = false;
  
  public static void ame()
  {
    if (gNy)
    {
      y.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
      return;
    }
    com.tencent.mm.sdk.f.e.post(new c.1(), "record_update_device_info");
  }
  
  public static void b(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    if (gNw.containsKey(paramString))
    {
      y.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", new Object[] { paramString });
      return;
    }
    if (paramc == null)
    {
      y.e("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
      return;
    }
    y.i("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", new Object[] { paramString });
    gNw.put(paramString, paramc);
    if (!gNx.contains(paramString)) {
      gNx.add(paramString);
    }
    a.udP.b(paramc);
  }
  
  public static void onCreate() {}
  
  public static void onDestroy()
  {
    y.i("MicroMsg.Record.AppBrandRecordClientService", "onDestroy");
    Object localObject1 = gNx.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (com.tencent.mm.sdk.b.c)gNw.remove(localObject2);
      if (localObject2 != null) {
        a.udP.d((com.tencent.mm.sdk.b.c)localObject2);
      }
    }
    gNw.clear();
    gNx.clear();
    localObject1 = g.amm();
    y.i("MicroMsg.Record.AudioRecordMgr", "destroy");
    if ((((g)localObject1).gNK == g.a.gOa) || (((g)localObject1).gNK == g.a.gOb) || (((g)localObject1).gNK == g.a.gOe)) {
      ((g)localObject1).uh();
    }
    if (((g)localObject1).gNR)
    {
      if ((((g)localObject1).gNJ != null) && (((g)localObject1).gNJ.gOK != null))
      {
        ((g)localObject1).gNJ.gOK.a(null);
        ((g)localObject1).gNJ.gOK.aml();
      }
      ((g)localObject1).gNR = false;
    }
  }
  
  public static void ve(String paramString)
  {
    if (!gNw.containsKey(paramString)) {
      y.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
    }
    do
    {
      return;
      y.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", new Object[] { paramString });
      gNx.remove(paramString);
      paramString = (com.tencent.mm.sdk.b.c)gNw.remove(paramString);
    } while (paramString == null);
    a.udP.d(paramString);
  }
  
  private static final class a
    implements i<IPCVoid, IPCString>
  {
    private static IPCString amf()
    {
      try
      {
        y.i("MicroMsg.Record.AppBrandRecordClientService", "ipc updateDeviceInfo");
        IPCString localIPCString = new IPCString(com.tencent.mm.kernel.g.DP().DA().cwa());
        return localIPCString;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.Record.AppBrandRecordClientService", localException, "ipc updateDeviceInfo task", new Object[0]);
      }
      return new IPCString("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.c
 * JD-Core Version:    0.7.0.1
 */