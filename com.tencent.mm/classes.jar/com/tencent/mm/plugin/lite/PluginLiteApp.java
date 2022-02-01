package com.tencent.mm.plugin.lite;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginLiteApp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, c, com.tencent.mm.plugin.lite.a.b
{
  private com.tencent.mm.plugin.lite.b.g yDY;
  private IListener yDZ;
  private com.tencent.mm.plugin.lite.b.a yEa;
  private com.tencent.mm.plugin.lite.b.b yEb;
  
  public PluginLiteApp()
  {
    AppMethodBeat.i(198808);
    this.yDY = null;
    this.yDZ = null;
    this.yEa = new com.tencent.mm.plugin.lite.b.a();
    this.yEb = new com.tencent.mm.plugin.lite.b.b();
    AppMethodBeat.o(198808);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(198810);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiteAppInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.lite.storage.f.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("LiteAppAuthInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.lite.storage.d.SQL_CREATE;
      }
    });
    AppMethodBeat.o(198810);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146365);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.lite.a.a.class, new b());
    AppMethodBeat.o(146365);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(198809);
    Log.d("MicroMsg.AppLite.PluginLiteApp", "execute %s", new Object[] { paramg.mProcessName });
    if (MMApplicationContext.isLiteProcess()) {
      h.a(MainProcessIPCService.dkO, new Bundle(), com.tencent.mm.plugin.lite.c.a.class, new com.tencent.mm.ipcinvoker.d() {});
    }
    AppMethodBeat.o(198809);
  }
  
  public String name()
  {
    return "plugin-liteapp";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(146366);
    Log.d("MicroMsg.AppLite.PluginLiteApp", "onAccountInitialized");
    if (MMApplicationContext.isMainProcess())
    {
      if (this.yDY == null) {
        this.yDY = new com.tencent.mm.plugin.lite.b.g();
      }
      if (this.yDZ == null)
      {
        this.yDZ = new com.tencent.mm.plugin.lite.b.d();
        EventCenter.instance.add(this.yDZ);
      }
      ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("LiteAppDevPackage", this.yDY);
      this.yEa.alive();
      this.yEb.alive();
    }
    AppMethodBeat.o(146366);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(146367);
    Log.d("MicroMsg.AppLite.PluginLiteApp", "onAccountRelease");
    if (MMApplicationContext.isMainProcess())
    {
      ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("LiteAppDevPackage", this.yDY);
      this.yEa.dead();
      this.yEb.dead();
    }
    AppMethodBeat.o(146367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.PluginLiteApp
 * JD-Core Version:    0.7.0.1
 */