package com.tencent.mm.plugin.fav.offline;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.y;
import java.util.HashMap;

public class PluginFavOffline
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private IListener<gv> tcw;
  private com.tencent.mm.plugin.fav.offline.b.b tcx;
  private com.tencent.mm.plugin.fav.offline.a.b tcy;
  
  static
  {
    AppMethodBeat.i(73537);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("GROUPSOLITAIRE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.fav.offline.b.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(73537);
  }
  
  public PluginFavOffline()
  {
    AppMethodBeat.i(73529);
    this.tcw = new IListener() {};
    this.tcx = null;
    this.tcy = null;
    AppMethodBeat.o(73529);
  }
  
  public static String getFavOfflinePath()
  {
    return "wcf://favoffline";
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(73533);
    if (paramg.aBb()) {
      y.at("favoffline", "favoffline", 3);
    }
    AppMethodBeat.o(73533);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(73532);
    com.tencent.mm.kernel.g.b(ae.class, new com.tencent.mm.plugin.fav.offline.a.c());
    AppMethodBeat.o(73532);
  }
  
  public com.tencent.mm.plugin.fav.offline.a.b getFavOfflineService()
  {
    AppMethodBeat.i(73536);
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.plugin.fav.offline.a.b localb = this.tcy;
    AppMethodBeat.o(73536);
    return localb;
  }
  
  public com.tencent.mm.plugin.fav.offline.b.b getFavOfflineStorage()
  {
    AppMethodBeat.i(73535);
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.plugin.fav.offline.b.b localb = this.tcx;
    AppMethodBeat.o(73535);
    return localb;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(73530);
    this.tcx = new com.tencent.mm.plugin.fav.offline.b.b(com.tencent.mm.kernel.g.aAh().hqK);
    this.tcy = new com.tencent.mm.plugin.fav.offline.a.b();
    this.tcw.alive();
    AppMethodBeat.o(73530);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(73531);
    if (this.tcy != null)
    {
      com.tencent.mm.plugin.fav.offline.a.b localb = this.tcy;
      com.tencent.mm.kernel.g.aAg().b(localb.iRt);
      this.tcy = null;
    }
    this.tcw.dead();
    AppMethodBeat.o(73531);
  }
  
  public boolean useOffline(String paramString, long paramLong)
  {
    AppMethodBeat.i(73534);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73534);
      return false;
    }
    com.tencent.mm.plugin.fav.offline.b.a locala = getFavOfflineStorage().ask(paramString);
    if (locala == null)
    {
      Log.i("MicroMsg.offline.PluginFavOffline", "useOffline url(%s) favOffline is null", new Object[] { paramString });
      AppMethodBeat.o(73534);
      return false;
    }
    if (!getFavOfflineService().tcC)
    {
      Log.i("MicroMsg.offline.PluginFavOffline", "useOffline url:%s status:%s", new Object[] { locala.field_url, Integer.valueOf(locala.field_status) });
      if (locala.field_status != 0)
      {
        paramString = new Intent();
        paramString.putExtra("key_path", locala.field_url);
        paramString.putExtra("key_detail_info_id", paramLong);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "fav.offline", ".ui.FavOfflineWebViewUI", paramString);
        AppMethodBeat.o(73534);
        return true;
      }
    }
    AppMethodBeat.o(73534);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.PluginFavOffline
 * JD-Core Version:    0.7.0.1
 */