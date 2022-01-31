package com.tencent.mm.plugin.biz;

import com.tencent.mm.ai.l;
import com.tencent.mm.ai.z;
import com.tencent.mm.api.i;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.j;
import com.tencent.mm.plugin.biz.a.b;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.sdk.platformtools.y;
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
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return com.tencent.mm.storage.o.dXp;
      }
    });
    localHashMap.put(Integer.valueOf("BIZ_TIME_LINE_TABLE".hashCode()), new PluginBiz.2(this));
    localHashMap.put(Integer.valueOf("BIZ_TIME_LINE_SINGLE_MSG_TABLE".hashCode()), new PluginBiz.3(this));
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      FileSystemManager.cVw().cVy().a("bizimg", new RC4EncryptedFileSystem("${storage}/tencent/MicroMsg/${account}/bizimg", "mmbiz")).gA("${storage}/tencent/MicroMsg/${account}/bizimg", "bizimg").commit();
      y.i("VFS.Debug", "bizimg FS registered");
      com.tencent.mm.kernel.g.a(com.tencent.mm.ai.o.class, new e(new l()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.biz.a.a.class, new a());
    }
    com.tencent.mm.pluginsdk.ui.applet.p.a.sdn = new d();
  }
  
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.messenger.foundation.a.p.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      pin(new com.tencent.mm.model.p(z.class));
      com.tencent.mm.kernel.g.a(com.tencent.mm.api.g.class, new com.tencent.mm.model.g());
      com.tencent.mm.kernel.g.a(com.tencent.mm.api.h.class, new com.tencent.mm.model.h());
      com.tencent.mm.kernel.g.a(i.class, new j());
    }
  }
  
  public void installed()
  {
    alias(b.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.PluginBiz
 * JD-Core Version:    0.7.0.1
 */