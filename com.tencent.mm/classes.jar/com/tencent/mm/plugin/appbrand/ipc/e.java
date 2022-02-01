package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public final class e
{
  private static final HashMap<String, MMToClientEvent> ktm;
  
  static
  {
    AppMethodBeat.i(134857);
    ktm = new HashMap();
    AppMethodBeat.o(134857);
  }
  
  public static void a(MMToClientEvent paramMMToClientEvent)
  {
    AppMethodBeat.i(134852);
    ae.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", new Object[] { paramMMToClientEvent.appId, Integer.valueOf(paramMMToClientEvent.hashCode()) });
    if (paramMMToClientEvent.appId == null)
    {
      ae.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
      AppMethodBeat.o(134852);
      return;
    }
    synchronized (ktm)
    {
      if (ktm.get(paramMMToClientEvent.appId) == null)
      {
        ktm.put(paramMMToClientEvent.appId, paramMMToClientEvent);
        AppMethodBeat.o(134852);
        return;
      }
      ae.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
      ktm.remove(paramMMToClientEvent.appId);
      ktm.put(paramMMToClientEvent.appId, paramMMToClientEvent);
    }
  }
  
  public static void b(MMToClientEvent paramMMToClientEvent)
  {
    AppMethodBeat.i(134853);
    ae.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", new Object[] { paramMMToClientEvent.appId });
    synchronized (ktm)
    {
      ktm.remove(paramMMToClientEvent.appId);
      AppMethodBeat.o(134853);
      return;
    }
  }
  
  public static <T extends Parcelable> void b(String paramString, T paramT)
  {
    AppMethodBeat.i(134856);
    MMToClientEvent localMMToClientEvent;
    synchronized (ktm)
    {
      localMMToClientEvent = (MMToClientEvent)ktm.get(paramString);
      if (localMMToClientEvent == null)
      {
        ae.e("MicroMsg.MMToClientEventCenter", "notify failed, appId[%s] data[%s]", new Object[] { paramString, paramT });
        AppMethodBeat.o(134856);
        return;
      }
    }
    if ((localMMToClientEvent != null) && (paramT != null) && (paramT != null)) {
      try
      {
        localMMToClientEvent.ktd = 5;
        localMMToClientEvent.kte = paramT.getClass().getName();
        localMMToClientEvent.ktf = paramT;
        localMMToClientEvent.biG();
        return;
      }
      finally
      {
        AppMethodBeat.o(134856);
      }
    }
    AppMethodBeat.o(134856);
  }
  
  public static void bD(String paramString, int paramInt)
  {
    AppMethodBeat.i(134855);
    ae.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (ktm)
    {
      paramString = (MMToClientEvent)ktm.get(paramString);
      if (paramString == null) {}
    }
    ae.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    AppMethodBeat.o(134855);
  }
  
  public static void r(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(134854);
    ae.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    MMToClientEvent localMMToClientEvent;
    synchronized (ktm)
    {
      localMMToClientEvent = (MMToClientEvent)ktm.get(paramString1);
      if (localMMToClientEvent == null) {}
    }
    ae.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    AppMethodBeat.o(134854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.e
 * JD-Core Version:    0.7.0.1
 */