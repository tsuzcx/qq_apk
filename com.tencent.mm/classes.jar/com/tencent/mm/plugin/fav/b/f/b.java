package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class b
  extends j<com.tencent.mm.plugin.fav.a.e>
  implements s
{
  private com.tencent.mm.sdk.e.e db;
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, com.tencent.mm.plugin.fav.a.e.info, "FavConfigInfo", null);
    this.db = parame;
  }
  
  private com.tencent.mm.plugin.fav.a.e ciA()
  {
    AppMethodBeat.i(101683);
    com.tencent.mm.plugin.fav.a.e locale = new com.tencent.mm.plugin.fav.a.e();
    ad.d("MicroMsg.FavConfigStorage", "get fav config sql %s", new Object[] { "select * from FavConfigInfo where configId = 8216" });
    Cursor localCursor = this.db.a("select * from FavConfigInfo where configId = 8216", null, 2);
    if (localCursor != null)
    {
      if (localCursor.moveToFirst()) {
        locale.convertFrom(localCursor);
      }
      localCursor.close();
    }
    AppMethodBeat.o(101683);
    return locale;
  }
  
  public final void bm(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101682);
    com.tencent.mm.plugin.fav.a.e locale = ciA();
    if (8216 == locale.field_configId)
    {
      locale.field_value = bt.cy(paramArrayOfByte);
      bool = update(locale, new String[0]);
      ad.i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", new Object[] { locale.field_value, Boolean.valueOf(bool) });
      AppMethodBeat.o(101682);
      return;
    }
    locale.field_configId = 8216;
    locale.field_value = bt.cy(paramArrayOfByte);
    boolean bool = insert(locale);
    ad.i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", new Object[] { locale.field_value, Boolean.valueOf(bool) });
    AppMethodBeat.o(101682);
  }
  
  public final byte[] chW()
  {
    AppMethodBeat.i(101684);
    Object localObject = ciA();
    if (8216 != ((com.tencent.mm.plugin.fav.a.e)localObject).field_configId)
    {
      ad.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
      g.afC();
      if (((Boolean)g.afB().afk().get(8224, Boolean.FALSE)).booleanValue()) {
        ad.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
      }
    }
    else
    {
      ad.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.e)localObject).field_configId), ((com.tencent.mm.plugin.fav.a.e)localObject).field_value });
      localObject = bt.aGd(((com.tencent.mm.plugin.fav.a.e)localObject).field_value);
      AppMethodBeat.o(101684);
      return localObject;
    }
    g.afC();
    localObject = bt.nullAsNil((String)g.afB().afk().get(8216, ""));
    ad.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", new Object[] { localObject });
    localObject = bt.aGd((String)localObject);
    bm((byte[])localObject);
    ad.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
    g.afC();
    g.afB().afk().set(8224, Boolean.TRUE);
    AppMethodBeat.o(101684);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.b
 * JD-Core Version:    0.7.0.1
 */