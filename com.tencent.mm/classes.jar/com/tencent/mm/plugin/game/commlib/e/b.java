package com.tencent.mm.plugin.game.commlib.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.g;
import java.util.HashSet;
import java.util.Set;

public final class b
{
  private static volatile MMHandler Itf;
  private static Set<String> Itg;
  private static final Object uqi;
  
  static
  {
    AppMethodBeat.i(89962);
    uqi = new Object();
    Itg = new HashSet();
    AppMethodBeat.o(89962);
  }
  
  public static boolean aFM(String paramString)
  {
    AppMethodBeat.i(275373);
    boolean bool = Itg.contains(paramString);
    AppMethodBeat.o(275373);
    return bool;
  }
  
  public static void cNl()
  {
    AppMethodBeat.i(89960);
    if (Itf == null)
    {
      AppMethodBeat.o(89960);
      return;
    }
    synchronized (uqi)
    {
      if (Itf != null)
      {
        g.bDQ("GameCommLib#WorkThread");
        Itf.quit();
        Itf = null;
      }
      AppMethodBeat.o(89960);
      return;
    }
  }
  
  public static void fM(Object paramObject)
  {
    AppMethodBeat.i(275363);
    Bundle localBundle = new Bundle();
    localBundle.putInt("action_id", 1);
    localBundle.putString("action_param", paramObject.getClass().getName());
    j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class, null);
    AppMethodBeat.o(275363);
  }
  
  public static void fN(Object paramObject)
  {
    AppMethodBeat.i(275368);
    Bundle localBundle = new Bundle();
    localBundle.putInt("action_id", 2);
    localBundle.putString("action_param", paramObject.getClass().getName());
    j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class, null);
    AppMethodBeat.o(275368);
  }
  
  public static MMHandler getWorkerHandler()
  {
    AppMethodBeat.i(184541);
    if (Itf == null) {}
    synchronized (uqi)
    {
      if (Itf == null)
      {
        Itf = new MMHandler("GameCommLib#WorkThread");
        g.a("GameCommLib#WorkThread", new com.tencent.mm.cf.a("GameCommLib#WorkThread"));
      }
      ??? = Itf;
      AppMethodBeat.o(184541);
      return ???;
    }
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e.b
 * JD-Core Version:    0.7.0.1
 */