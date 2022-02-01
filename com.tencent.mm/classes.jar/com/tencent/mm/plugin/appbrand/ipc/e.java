package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class e
{
  private static final HashMap<String, MMToClientEvent> jvn;
  
  static
  {
    AppMethodBeat.i(134857);
    jvn = new HashMap();
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
    synchronized (jvn)
    {
      if (jvn.get(paramMMToClientEvent.appId) == null)
      {
        jvn.put(paramMMToClientEvent.appId, paramMMToClientEvent);
        AppMethodBeat.o(134852);
        return;
      }
      ad.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
      jvn.remove(paramMMToClientEvent.appId);
      jvn.put(paramMMToClientEvent.appId, paramMMToClientEvent);
    }
  }
  
  public static void b(MMToClientEvent paramMMToClientEvent)
  {
    AppMethodBeat.i(134853);
    ad.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", new Object[] { paramMMToClientEvent.appId });
    synchronized (jvn)
    {
      jvn.remove(paramMMToClientEvent.appId);
      AppMethodBeat.o(134853);
      return;
    }
  }
  
  public static <T extends Parcelable> void b(String paramString, T paramT)
  {
    AppMethodBeat.i(134856);
    synchronized (jvn)
    {
      paramString = (MMToClientEvent)jvn.get(paramString);
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
        paramString.jve = 5;
        paramString.jvf = paramT.getClass().getName();
        paramString.jvg = paramT;
        paramString.aXw();
        return;
      }
      finally
      {
        AppMethodBeat.o(134856);
      }
    }
    AppMethodBeat.o(134856);
  }
  
  public static void bu(String paramString, int paramInt)
  {
    AppMethodBeat.i(134855);
    ad.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (jvn)
    {
      paramString = (MMToClientEvent)jvn.get(paramString);
      if (paramString == null) {}
    }
    ad.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    AppMethodBeat.o(134855);
  }
  
  public static void o(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(134854);
    ad.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    MMToClientEvent localMMToClientEvent;
    synchronized (jvn)
    {
      localMMToClientEvent = (MMToClientEvent)jvn.get(paramString1);
      if (localMMToClientEvent == null) {}
    }
    ad.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    AppMethodBeat.o(134854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.e
 * JD-Core Version:    0.7.0.1
 */