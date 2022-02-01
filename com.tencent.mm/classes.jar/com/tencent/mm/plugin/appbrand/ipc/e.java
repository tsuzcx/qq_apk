package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class e
{
  private static final HashMap<String, MMToClientEvent> kpX;
  
  static
  {
    AppMethodBeat.i(134857);
    kpX = new HashMap();
    AppMethodBeat.o(134857);
  }
  
  public static void a(MMToClientEvent paramMMToClientEvent)
  {
    AppMethodBeat.i(134852);
    ad.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", new Object[] { paramMMToClientEvent.appId, Integer.valueOf(paramMMToClientEvent.hashCode()) });
    if (paramMMToClientEvent.appId == null)
    {
      ad.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
      AppMethodBeat.o(134852);
      return;
    }
    synchronized (kpX)
    {
      if (kpX.get(paramMMToClientEvent.appId) == null)
      {
        kpX.put(paramMMToClientEvent.appId, paramMMToClientEvent);
        AppMethodBeat.o(134852);
        return;
      }
      ad.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
      kpX.remove(paramMMToClientEvent.appId);
      kpX.put(paramMMToClientEvent.appId, paramMMToClientEvent);
    }
  }
  
  public static void b(MMToClientEvent paramMMToClientEvent)
  {
    AppMethodBeat.i(134853);
    ad.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", new Object[] { paramMMToClientEvent.appId });
    synchronized (kpX)
    {
      kpX.remove(paramMMToClientEvent.appId);
      AppMethodBeat.o(134853);
      return;
    }
  }
  
  public static <T extends Parcelable> void b(String paramString, T paramT)
  {
    AppMethodBeat.i(134856);
    synchronized (kpX)
    {
      paramString = (MMToClientEvent)kpX.get(paramString);
      if (paramString == null)
      {
        ad.e("MicroMsg.MMToClientEventCenter", "notify failed, appId[%s] data[%s]");
        AppMethodBeat.o(134856);
        return;
      }
    }
    if ((paramString != null) && (paramT != null) && (paramT != null)) {
      try
      {
        paramString.kpO = 5;
        paramString.kpP = paramT.getClass().getName();
        paramString.kpQ = paramT;
        paramString.bhX();
        return;
      }
      finally
      {
        AppMethodBeat.o(134856);
      }
    }
    AppMethodBeat.o(134856);
  }
  
  public static void bA(String paramString, int paramInt)
  {
    AppMethodBeat.i(134855);
    ad.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (kpX)
    {
      paramString = (MMToClientEvent)kpX.get(paramString);
      if (paramString == null) {}
    }
    ad.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    AppMethodBeat.o(134855);
  }
  
  public static void p(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(134854);
    ad.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    MMToClientEvent localMMToClientEvent;
    synchronized (kpX)
    {
      localMMToClientEvent = (MMToClientEvent)kpX.get(paramString1);
      if (localMMToClientEvent == null) {}
    }
    ad.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    AppMethodBeat.o(134854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.e
 * JD-Core Version:    0.7.0.1
 */