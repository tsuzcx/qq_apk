package com.tencent.mm.plugin.lite;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.v;
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
  private com.tencent.mm.plugin.lite.b.g EfL;
  private IListener EfM;
  private com.tencent.mm.plugin.lite.b.a EfN;
  private com.tencent.mm.plugin.lite.b.b EfO;
  
  public PluginLiteApp()
  {
    AppMethodBeat.i(234255);
    this.EfL = null;
    this.EfM = null;
    this.EfN = new com.tencent.mm.plugin.lite.b.a();
    this.EfO = new com.tencent.mm.plugin.lite.b.b();
    AppMethodBeat.o(234255);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(234262);
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
    AppMethodBeat.o(234262);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146365);
    h.b(com.tencent.mm.plugin.lite.a.a.class, new b());
    AppMethodBeat.o(146365);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(234257);
    Log.d("MicroMsg.AppLite.PluginLiteApp", "execute %s", new Object[] { paramg.mProcessName });
    if (MMApplicationContext.isLiteProcess()) {
      j.a(MainProcessIPCService.PROCESS_NAME, new Bundle(), com.tencent.mm.plugin.lite.c.a.class, new com.tencent.mm.ipcinvoker.f() {});
    }
    AppMethodBeat.o(234257);
  }
  
  public String name()
  {
    return "plugin-liteapp";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(146366);
    Log.d("MicroMsg.AppLite.PluginLiteApp", "onAccountInitialized");
    if (MMApplicationContext.isMainProcess())
    {
      if (this.EfL == null) {
        this.EfL = new com.tencent.mm.plugin.lite.b.g();
      }
      if (this.EfM == null)
      {
        this.EfM = new com.tencent.mm.plugin.lite.b.d();
        EventCenter.instance.add(this.EfM);
      }
      ((v)h.ag(v.class)).getSysCmdMsgExtension().a("LiteAppDevPackage", this.EfL);
      this.EfN.alive();
      this.EfO.alive();
    }
    AppMethodBeat.o(146366);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(146367);
    Log.d("MicroMsg.AppLite.PluginLiteApp", "onAccountRelease");
    if (MMApplicationContext.isMainProcess())
    {
      ((v)h.ag(v.class)).getSysCmdMsgExtension().b("LiteAppDevPackage", this.EfL);
      this.EfN.dead();
      this.EfO.dead();
    }
    AppMethodBeat.o(146367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.PluginLiteApp
 * JD-Core Version:    0.7.0.1
 */