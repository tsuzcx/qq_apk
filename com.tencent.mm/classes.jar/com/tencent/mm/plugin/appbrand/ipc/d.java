package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class d
{
  private static final HashMap<String, MMToClientEvent> hwA;
  
  static
  {
    AppMethodBeat.i(86953);
    hwA = new HashMap();
    AppMethodBeat.o(86953);
  }
  
  public static <T extends Parcelable> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(86952);
    synchronized (hwA)
    {
      paramString = (MMToClientEvent)hwA.get(paramString);
      if ((paramString == null) || (paramT == null) || (paramT == null)) {}
    }
    AppMethodBeat.o(86952);
  }
  
  public static void b(MMToClientEvent paramMMToClientEvent)
  {
    AppMethodBeat.i(86948);
    ab.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", new Object[] { paramMMToClientEvent.appId, Integer.valueOf(paramMMToClientEvent.hashCode()) });
    if (paramMMToClientEvent.appId == null)
    {
      ab.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
      AppMethodBeat.o(86948);
      return;
    }
    synchronized (hwA)
    {
      if (hwA.get(paramMMToClientEvent.appId) == null)
      {
        hwA.put(paramMMToClientEvent.appId, paramMMToClientEvent);
        AppMethodBeat.o(86948);
        return;
      }
      ab.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
      hwA.remove(paramMMToClientEvent.appId);
      hwA.put(paramMMToClientEvent.appId, paramMMToClientEvent);
    }
  }
  
  public static void be(String paramString, int paramInt)
  {
    AppMethodBeat.i(86951);
    ab.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (hwA)
    {
      paramString = (MMToClientEvent)hwA.get(paramString);
      if (paramString == null) {}
    }
    ab.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    AppMethodBeat.o(86951);
  }
  
  public static void c(MMToClientEvent paramMMToClientEvent)
  {
    AppMethodBeat.i(86949);
    ab.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", new Object[] { paramMMToClientEvent.appId });
    synchronized (hwA)
    {
      hwA.remove(paramMMToClientEvent.appId);
      AppMethodBeat.o(86949);
      return;
    }
  }
  
  public static void j(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(86950);
    ab.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    MMToClientEvent localMMToClientEvent;
    synchronized (hwA)
    {
      localMMToClientEvent = (MMToClientEvent)hwA.get(paramString1);
      if (localMMToClientEvent == null) {}
    }
    ab.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    AppMethodBeat.o(86950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.d
 * JD-Core Version:    0.7.0.1
 */