package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

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
  
  private com.tencent.mm.plugin.fav.a.e bxk()
  {
    AppMethodBeat.i(5423);
    com.tencent.mm.plugin.fav.a.e locale = new com.tencent.mm.plugin.fav.a.e();
    ab.d("MicroMsg.FavConfigStorage", "get fav config sql %s", new Object[] { "select * from FavConfigInfo where configId = 8216" });
    Cursor localCursor = this.db.a("select * from FavConfigInfo where configId = 8216", null, 2);
    if (localCursor != null)
    {
      if (localCursor.moveToFirst()) {
        locale.convertFrom(localCursor);
      }
      localCursor.close();
    }
    AppMethodBeat.o(5423);
    return locale;
  }
  
  public final void aW(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5422);
    com.tencent.mm.plugin.fav.a.e locale = bxk();
    if (8216 == locale.field_configId)
    {
      locale.field_value = bo.cg(paramArrayOfByte);
      bool = update(locale, new String[0]);
      ab.i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", new Object[] { locale.field_value, Boolean.valueOf(bool) });
      AppMethodBeat.o(5422);
      return;
    }
    locale.field_configId = 8216;
    locale.field_value = bo.cg(paramArrayOfByte);
    boolean bool = insert(locale);
    ab.i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", new Object[] { locale.field_value, Boolean.valueOf(bool) });
    AppMethodBeat.o(5422);
  }
  
  public final byte[] bwG()
  {
    AppMethodBeat.i(5424);
    Object localObject = bxk();
    if (8216 != ((com.tencent.mm.plugin.fav.a.e)localObject).field_configId)
    {
      ab.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
      g.RM();
      if (((Boolean)g.RL().Ru().get(8224, Boolean.FALSE)).booleanValue()) {
        ab.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
      }
    }
    else
    {
      ab.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.e)localObject).field_configId), ((com.tencent.mm.plugin.fav.a.e)localObject).field_value });
      localObject = bo.apQ(((com.tencent.mm.plugin.fav.a.e)localObject).field_value);
      AppMethodBeat.o(5424);
      return localObject;
    }
    g.RM();
    localObject = bo.nullAsNil((String)g.RL().Ru().get(8216, ""));
    ab.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", new Object[] { localObject });
    localObject = bo.apQ((String)localObject);
    aW((byte[])localObject);
    ab.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
    g.RM();
    g.RL().Ru().set(8224, Boolean.TRUE);
    AppMethodBeat.o(5424);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.b
 * JD-Core Version:    0.7.0.1
 */