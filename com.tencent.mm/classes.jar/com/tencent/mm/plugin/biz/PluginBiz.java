package com.tencent.mm.plugin.biz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.api.j;
import com.tencent.mm.api.m;
import com.tencent.mm.api.n;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.i;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.biz.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.w;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public class PluginBiz
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, b
{
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(124342);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.p.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("BIZ_TIME_LINE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return u.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("BIZ_TIME_LINE_SINGLE_MSG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return w.SQL_CREATE;
      }
    });
    AppMethodBeat.o(124342);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124340);
    if (paramg.ahL())
    {
      com.tencent.mm.kernel.g.a(com.tencent.mm.al.p.class, new e(new com.tencent.mm.al.l()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.biz.a.a.class, new a());
      paramg = com.tencent.mm.msgsubscription.storage.f.iix;
      com.tencent.mm.msgsubscription.storage.f.a("name_biz", new PluginBiz.1(this));
      o.a("bizimg/", "bizimg/", 536870912L, 75);
      ac.i("VFS.Debug", "bizimg FS registered");
      o.b("brandicon/", "brandicon/", 7776000000L, 3);
      o.b("bizcache/", "bizcache/", 2592000000L, 67);
      o.aj("openapi/", "openapi/", 3);
      o.b("openapi_cache/", "openapi_cache/", 7776000000L, 67);
    }
    com.tencent.mm.pluginsdk.ui.applet.x.a.DrP = new d();
    AppMethodBeat.o(124340);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(124339);
    dependsOn(q.class);
    AppMethodBeat.o(124339);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124341);
    if (paramg.ahL())
    {
      pin(new t(af.class));
      com.tencent.mm.kernel.g.b(j.class, new com.tencent.mm.model.g());
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.k.class, new i());
      com.tencent.mm.kernel.g.b(m.class, new com.tencent.mm.model.k());
      com.tencent.mm.kernel.g.a(n.class, new e(new com.tencent.mm.model.l()));
    }
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