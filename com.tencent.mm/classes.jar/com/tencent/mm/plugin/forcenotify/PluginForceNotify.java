package com.tencent.mm.plugin.forcenotify;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginForceNotify
  extends f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.forcenotify.a.c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  
  static
  {
    AppMethodBeat.i(149133);
    baseDBFactories = new HashMap();
    String str = MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.forcenotify.c.h.info, "ForceNotifyData");
    baseDBFactories.put(Integer.valueOf("ForceNotifyData".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return PluginForceNotify.this;
      }
    });
    AppMethodBeat.o(149133);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void configure(g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(149130);
    dependsOn(v.class);
    AppMethodBeat.o(149130);
  }
  
  public void execute(g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(149129);
    alias(com.tencent.mm.plugin.forcenotify.a.c.class);
    AppMethodBeat.o(149129);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(149131);
    long l = SystemClock.uptimeMillis();
    Log.i("MicroMsg.PluginForceNotify", "[transformOldData] count:%s cost:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.forcenotify.d.b.Hoz.fwP()), Long.valueOf(SystemClock.uptimeMillis() - l) });
    com.tencent.mm.plugin.forcenotify.core.c.Hoc.start();
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.forcenotify.a.b.class, com.tencent.mm.plugin.forcenotify.core.c.Hoc);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.forcenotify.a.a.class, com.tencent.mm.plugin.forcenotify.core.b.Hob);
    AppMethodBeat.o(149131);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(149132);
    com.tencent.mm.plugin.forcenotify.core.c.Hoc.release();
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.forcenotify.a.b.class);
    AppMethodBeat.o(149132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.PluginForceNotify
 * JD-Core Version:    0.7.0.1
 */