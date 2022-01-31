package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class d
{
  private static final HashMap<String, MMToClientEvent> geB = new HashMap();
  
  public static <T extends Parcelable> void a(String paramString, T paramT)
  {
    synchronized (geB)
    {
      paramString = (MMToClientEvent)geB.get(paramString);
      if ((paramString == null) || (paramT == null) || (paramT == null)) {}
    }
  }
  
  public static void aO(String paramString, int paramInt)
  {
    y.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (geB)
    {
      paramString = (MMToClientEvent)geB.get(paramString);
      if (paramString == null) {}
    }
    y.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
  }
  
  public static void b(MMToClientEvent paramMMToClientEvent)
  {
    y.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", new Object[] { paramMMToClientEvent.appId, Integer.valueOf(paramMMToClientEvent.hashCode()) });
    if (paramMMToClientEvent.appId == null)
    {
      y.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
      return;
    }
    for (;;)
    {
      synchronized (geB)
      {
        if (geB.get(paramMMToClientEvent.appId) == null)
        {
          geB.put(paramMMToClientEvent.appId, paramMMToClientEvent);
          return;
        }
      }
      y.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
      geB.remove(paramMMToClientEvent.appId);
      geB.put(paramMMToClientEvent.appId, paramMMToClientEvent);
    }
  }
  
  public static void c(MMToClientEvent paramMMToClientEvent)
  {
    y.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", new Object[] { paramMMToClientEvent.appId });
    synchronized (geB)
    {
      geB.remove(paramMMToClientEvent.appId);
      return;
    }
  }
  
  public static void j(String paramString1, int paramInt, String paramString2)
  {
    y.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    MMToClientEvent localMMToClientEvent;
    synchronized (geB)
    {
      localMMToClientEvent = (MMToClientEvent)geB.get(paramString1);
      if (localMMToClientEvent == null) {}
    }
    y.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.d
 * JD-Core Version:    0.7.0.1
 */