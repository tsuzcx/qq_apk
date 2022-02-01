package com.tencent.mm.plugin.biz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.ac;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.q;
import com.tencent.mm.api.j;
import com.tencent.mm.api.n;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.i;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.biz.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginBiz
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, b
{
  public static long startTime = 0L;
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(124342);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return r.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("BIZ_TIME_LINE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return x.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("BIZ_TIME_LINE_SINGLE_MSG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return z.SQL_CREATE;
      }
    });
    AppMethodBeat.o(124342);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124340);
    if (paramg.akL())
    {
      com.tencent.mm.kernel.g.a(q.class, new e(new com.tencent.mm.al.m()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.biz.a.a.class, new a());
      paramg = com.tencent.mm.msgsubscription.storage.f.iEK;
      com.tencent.mm.msgsubscription.storage.f.a("name_biz", new PluginBiz.1(this));
      com.tencent.mm.vfs.u.a("bizimg/", "bizimg/", 536870912L, 75);
      ae.i("VFS.Debug", "bizimg FS registered");
      com.tencent.mm.vfs.u.b("brandicon/", "brandicon/", 7776000000L, 3);
      com.tencent.mm.vfs.u.b("bizcache/", "bizcache/", 2592000000L, 67);
      com.tencent.mm.vfs.u.b("webcanvascache/", "webcanvascache/", 2592000000L, 67);
      com.tencent.mm.vfs.u.ap("openapi/", "openapi/", 3);
      com.tencent.mm.vfs.u.b("openapi_cache/", "openapi_cache/", 7776000000L, 67);
      com.tencent.mm.sdk.b.a.IvT.b(new ac());
    }
    com.tencent.mm.pluginsdk.ui.applet.x.a.Fpn = new d();
    AppMethodBeat.o(124340);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(124339);
    dependsOn(s.class);
    AppMethodBeat.o(124339);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124341);
    if (paramg.akL())
    {
      pin(new com.tencent.mm.model.u(ag.class));
      com.tencent.mm.kernel.g.b(j.class, new com.tencent.mm.model.g());
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.k.class, new i());
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.m.class, new com.tencent.mm.model.k());
      com.tencent.mm.kernel.g.a(n.class, new e(new l()));
    }
    startTime = System.currentTimeMillis();
    AppMethodBeat.o(124341);
  }
  
  public void installed()
  {
    AppMethodBeat.i(124338);
    alias(b.class);
    AppMethodBeat.o(124338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.PluginBiz
 * JD-Core Version:    0.7.0.1
 */