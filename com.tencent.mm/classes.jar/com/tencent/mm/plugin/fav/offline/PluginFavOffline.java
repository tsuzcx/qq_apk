package com.tencent.mm.plugin.fav.offline;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public class PluginFavOffline
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c<gq> ruF;
  private com.tencent.mm.plugin.fav.offline.b.b ruG;
  private com.tencent.mm.plugin.fav.offline.a.b ruH;
  
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
    this.ruF = new com.tencent.mm.sdk.b.c() {};
    this.ruG = null;
    this.ruH = null;
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
    if (paramg.akw()) {
      o.an("favoffline", "favoffline", 3);
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
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.fav.offline.a.b localb = this.ruH;
    AppMethodBeat.o(73536);
    return localb;
  }
  
  public com.tencent.mm.plugin.fav.offline.b.b getFavOfflineStorage()
  {
    AppMethodBeat.i(73535);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.fav.offline.b.b localb = this.ruG;
    AppMethodBeat.o(73535);
    return localb;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(73530);
    this.ruG = new com.tencent.mm.plugin.fav.offline.b.b(com.tencent.mm.kernel.g.ajC().gBq);
    this.ruH = new com.tencent.mm.plugin.fav.offline.a.b();
    this.ruF.alive();
    AppMethodBeat.o(73530);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(73531);
    if (this.ruH != null)
    {
      com.tencent.mm.plugin.fav.offline.a.b localb = this.ruH;
      com.tencent.mm.kernel.g.ajB().b(localb.hTD);
      this.ruH = null;
    }
    this.ruF.dead();
    AppMethodBeat.o(73531);
  }
  
  public boolean useOffline(String paramString, long paramLong)
  {
    AppMethodBeat.i(73534);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(73534);
      return false;
    }
    com.tencent.mm.plugin.fav.offline.b.a locala = getFavOfflineStorage().agF(paramString);
    if (locala == null)
    {
      ad.i("MicroMsg.offline.PluginFavOffline", "useOffline url(%s) favOffline is null", new Object[] { paramString });
      AppMethodBeat.o(73534);
      return false;
    }
    if (!getFavOfflineService().ruL)
    {
      ad.i("MicroMsg.offline.PluginFavOffline", "useOffline url:%s status:%s", new Object[] { locala.field_url, Integer.valueOf(locala.field_status) });
      if (locala.field_status != 0)
      {
        paramString = new Intent();
        paramString.putExtra("key_path", locala.field_url);
        paramString.putExtra("key_detail_info_id", paramLong);
        d.b(aj.getContext(), "fav.offline", ".ui.FavOfflineWebViewUI", paramString);
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