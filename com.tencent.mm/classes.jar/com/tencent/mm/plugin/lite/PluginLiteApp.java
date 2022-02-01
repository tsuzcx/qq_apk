package com.tencent.mm.plugin.lite;

import android.os.Bundle;
import com.tencent.liteapp.report.WxaLiteAppStartReport;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.lite.api.d;
import com.tencent.mm.plugin.lite.logic.LiteAppCheckerListener;
import com.tencent.mm.plugin.lite.logic.LiteAppDevQrCodeListener;
import com.tencent.mm.plugin.lite.storage.i;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginLiteApp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, d
{
  private com.tencent.mm.plugin.lite.logic.e JZb;
  private IListener JZc;
  private com.tencent.mm.plugin.lite.logic.a JZd;
  private LiteAppCheckerListener JZe;
  
  public PluginLiteApp()
  {
    AppMethodBeat.i(271350);
    this.JZb = null;
    this.JZc = null;
    this.JZd = new com.tencent.mm.plugin.lite.logic.a();
    this.JZe = new LiteAppCheckerListener();
    AppMethodBeat.o(271350);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(271386);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiteAppInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return i.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("LiteAppAuthInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.lite.storage.e.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("LiteAppBaselibInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.lite.storage.g.SQL_CREATE;
      }
    });
    AppMethodBeat.o(271386);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146365);
    h.b(com.tencent.mm.plugin.lite.api.c.class, new b());
    AppMethodBeat.o(146365);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(271359);
    Log.d("MicroMsg.AppLite.PluginLiteApp", "execute %s", new Object[] { paramg.mProcessName });
    if (MMApplicationContext.isLiteProcess()) {
      j.a(MainProcessIPCService.PROCESS_NAME, new Bundle(), com.tencent.mm.plugin.lite.b.a.class, new com.tencent.mm.ipcinvoker.f() {});
    }
    AppMethodBeat.o(271359);
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
      if (this.JZb == null) {
        this.JZb = new com.tencent.mm.plugin.lite.logic.e();
      }
      if (this.JZc == null)
      {
        this.JZc = new LiteAppDevQrCodeListener();
        this.JZc.alive();
      }
      ((v)h.az(v.class)).getSysCmdMsgExtension().a("LiteAppDevPackage", this.JZb);
      this.JZd.alive();
      this.JZe.alive();
    }
    AppMethodBeat.o(146366);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(146367);
    Log.d("MicroMsg.AppLite.PluginLiteApp", "onAccountRelease");
    if (MMApplicationContext.isMainProcess())
    {
      ((v)h.az(v.class)).getSysCmdMsgExtension().b("LiteAppDevPackage", this.JZb);
      this.JZd.dead();
      this.JZe.dead();
    }
    AppMethodBeat.o(146367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.PluginLiteApp
 * JD-Core Version:    0.7.0.1
 */