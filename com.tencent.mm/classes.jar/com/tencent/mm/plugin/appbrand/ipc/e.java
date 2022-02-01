package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class e
{
  private static final HashMap<String, MMToClientEvent> orF;
  
  static
  {
    AppMethodBeat.i(134857);
    orF = new HashMap();
    AppMethodBeat.o(134857);
  }
  
  public static void a(MMToClientEvent paramMMToClientEvent)
  {
    AppMethodBeat.i(134852);
    Log.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", new Object[] { paramMMToClientEvent.appId, Integer.valueOf(paramMMToClientEvent.hashCode()) });
    if (paramMMToClientEvent.appId == null)
    {
      Log.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
      AppMethodBeat.o(134852);
      return;
    }
    synchronized (orF)
    {
      if (orF.get(paramMMToClientEvent.appId) == null)
      {
        orF.put(paramMMToClientEvent.appId, paramMMToClientEvent);
        AppMethodBeat.o(134852);
        return;
      }
      Log.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
      orF.remove(paramMMToClientEvent.appId);
      orF.put(paramMMToClientEvent.appId, paramMMToClientEvent);
    }
  }
  
  public static void b(MMToClientEvent paramMMToClientEvent)
  {
    AppMethodBeat.i(134853);
    Log.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", new Object[] { paramMMToClientEvent.appId });
    synchronized (orF)
    {
      orF.remove(paramMMToClientEvent.appId);
      AppMethodBeat.o(134853);
      return;
    }
  }
  
  public static <T extends Parcelable> void b(String paramString, T paramT)
  {
    AppMethodBeat.i(134856);
    MMToClientEvent localMMToClientEvent;
    synchronized (orF)
    {
      localMMToClientEvent = (MMToClientEvent)orF.get(paramString);
      if (localMMToClientEvent == null)
      {
        Log.e("MicroMsg.MMToClientEventCenter", "notify failed, appId[%s] data[%s]", new Object[] { paramString, paramT });
        AppMethodBeat.o(134856);
        return;
      }
    }
    if ((localMMToClientEvent != null) && (paramT != null) && (paramT != null)) {
      try
      {
        localMMToClientEvent.orw = 5;
        localMMToClientEvent.orx = paramT.getClass().getName();
        localMMToClientEvent.ory = paramT;
        localMMToClientEvent.bPt();
        return;
      }
      finally
      {
        AppMethodBeat.o(134856);
      }
    }
    AppMethodBeat.o(134856);
  }
  
  public static void cd(String paramString, int paramInt)
  {
    AppMethodBeat.i(134855);
    Log.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (orF)
    {
      paramString = (MMToClientEvent)orF.get(paramString);
      if (paramString == null) {}
    }
    Log.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    AppMethodBeat.o(134855);
  }
  
  public static void x(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(134854);
    Log.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    MMToClientEvent localMMToClientEvent;
    synchronized (orF)
    {
      localMMToClientEvent = (MMToClientEvent)orF.get(paramString1);
      if (localMMToClientEvent == null) {}
    }
    Log.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    AppMethodBeat.o(134854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.e
 * JD-Core Version:    0.7.0.1
 */