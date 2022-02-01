package com.tencent.mm.plugin.fav.offline;

import android.content.Intent;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hn;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.af;
import java.util.HashMap;

public class PluginFavOffline
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private IListener<hn> AeW;
  private com.tencent.mm.plugin.fav.offline.b.b AeX;
  private com.tencent.mm.plugin.fav.offline.a.b AeY;
  
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
    this.AeW = new IListener(com.tencent.mm.app.f.hfK) {};
    this.AeX = null;
    this.AeY = null;
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
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(73533);
    if (paramg.bbA()) {
      af.aR("favoffline", "favoffline", 1);
    }
    AppMethodBeat.o(73533);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(73532);
    h.b(ag.class, new com.tencent.mm.plugin.fav.offline.a.c());
    AppMethodBeat.o(73532);
  }
  
  public com.tencent.mm.plugin.fav.offline.a.b getFavOfflineService()
  {
    AppMethodBeat.i(73536);
    h.baC().aZJ();
    com.tencent.mm.plugin.fav.offline.a.b localb = this.AeY;
    AppMethodBeat.o(73536);
    return localb;
  }
  
  public com.tencent.mm.plugin.fav.offline.b.b getFavOfflineStorage()
  {
    AppMethodBeat.i(73535);
    h.baC().aZJ();
    com.tencent.mm.plugin.fav.offline.b.b localb = this.AeX;
    AppMethodBeat.o(73535);
    return localb;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(73530);
    this.AeX = new com.tencent.mm.plugin.fav.offline.b.b(h.baE().mCN);
    this.AeY = new com.tencent.mm.plugin.fav.offline.a.b();
    this.AeW.alive();
    AppMethodBeat.o(73530);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(73531);
    if (this.AeY != null)
    {
      com.tencent.mm.plugin.fav.offline.a.b localb = this.AeY;
      h.baD().b(localb.oAk);
      this.AeY = null;
    }
    this.AeW.dead();
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
    com.tencent.mm.plugin.fav.offline.b.a locala = getFavOfflineStorage().aus(paramString);
    if (locala == null)
    {
      Log.i("MicroMsg.offline.PluginFavOffline", "useOffline url(%s) favOffline is null", new Object[] { paramString });
      AppMethodBeat.o(73534);
      return false;
    }
    if (!getFavOfflineService().Afi)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.PluginFavOffline
 * JD-Core Version:    0.7.0.1
 */