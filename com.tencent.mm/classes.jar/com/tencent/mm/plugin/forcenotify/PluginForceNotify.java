package com.tencent.mm.plugin.forcenotify;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class PluginForceNotify
  extends f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.forcenotify.a.c
{
  public static HashMap<Integer, h.d> baseDBFactories;
  
  static
  {
    AppMethodBeat.i(51014);
    baseDBFactories = new HashMap();
    String str = j.getCreateSQLs(d.info, "ForceNotifyData");
    baseDBFactories.put(Integer.valueOf("ForceNotifyData".hashCode()), new PluginForceNotify.1(new String[] { str }));
    AppMethodBeat.o(51014);
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(51011);
    dependsOn(p.class);
    AppMethodBeat.o(51011);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(51010);
    alias(com.tencent.mm.plugin.forcenotify.a.c.class);
    AppMethodBeat.o(51010);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(51012);
    long l = SystemClock.uptimeMillis();
    ab.i("MicroMsg.PluginForceNotify", "[transformOldData] count:%s cost:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.forcenotify.d.a.mHw.bzM()), Long.valueOf(SystemClock.uptimeMillis() - l) });
    com.tencent.mm.plugin.forcenotify.b.c.mHu.start();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.forcenotify.a.b.class, com.tencent.mm.plugin.forcenotify.b.c.mHu);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.forcenotify.a.a.class, com.tencent.mm.plugin.forcenotify.b.b.mHq);
    AppMethodBeat.o(51012);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51013);
    com.tencent.mm.plugin.forcenotify.b.c.mHu.release();
    com.tencent.mm.kernel.g.F(com.tencent.mm.plugin.forcenotify.a.b.class);
    AppMethodBeat.o(51013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.PluginForceNotify
 * JD-Core Version:    0.7.0.1
 */