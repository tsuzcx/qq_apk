package com.tencent.mm.plugin.biz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.l;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.api.i;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.biz.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.a;
import com.tencent.mm.vfs.RC4EncryptedFileSystem;
import java.util.HashMap;

public class PluginBiz
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, b
{
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(11654);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new PluginBiz.1(this));
    localHashMap.put(Integer.valueOf("BIZ_TIME_LINE_TABLE".hashCode()), new PluginBiz.2(this));
    localHashMap.put(Integer.valueOf("BIZ_TIME_LINE_SINGLE_MSG_TABLE".hashCode()), new PluginBiz.3(this));
    AppMethodBeat.o(11654);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(11652);
    if (paramg.SD())
    {
      FileSystemManager.dQE().erS().a("bizimg", new RC4EncryptedFileSystem("${storage}/tencent/MicroMsg/${account}/bizimg", "mmbiz")).iD("${storage}/tencent/MicroMsg/${account}/bizimg", "bizimg").commit();
      ab.i("VFS.Debug", "bizimg FS registered");
      com.tencent.mm.kernel.g.a(o.class, new e(new l()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.biz.a.a.class, new a());
    }
    com.tencent.mm.pluginsdk.ui.applet.p.a.vUq = new d();
    AppMethodBeat.o(11652);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(11651);
    dependsOn(p.class);
    AppMethodBeat.o(11651);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(11653);
    if (paramg.SD())
    {
      pin(new q(z.class));
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.h.class, new com.tencent.mm.model.g());
      com.tencent.mm.kernel.g.b(i.class, new com.tencent.mm.model.h());
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.j.class, new com.tencent.mm.model.j());
    }
    AppMethodBeat.o(11653);
  }
  
  public void installed()
  {
    AppMethodBeat.i(11650);
    alias(b.class);
    AppMethodBeat.o(11650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.PluginBiz
 * JD-Core Version:    0.7.0.1
 */