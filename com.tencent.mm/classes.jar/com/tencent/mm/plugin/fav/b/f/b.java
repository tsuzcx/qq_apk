package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ao;

public final class b
  extends MAutoStorage<com.tencent.mm.plugin.fav.a.e>
  implements s
{
  private ISQLiteDatabase db;
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.fav.a.e.info, "FavConfigInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  private com.tencent.mm.plugin.fav.a.e cVr()
  {
    AppMethodBeat.i(101683);
    com.tencent.mm.plugin.fav.a.e locale = new com.tencent.mm.plugin.fav.a.e();
    Log.d("MicroMsg.FavConfigStorage", "get fav config sql %s", new Object[] { "select * from FavConfigInfo where configId = 8216" });
    Cursor localCursor = this.db.rawQuery("select * from FavConfigInfo where configId = 8216", null, 2);
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
  
  public final void bE(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101682);
    com.tencent.mm.plugin.fav.a.e locale = cVr();
    if (8216 == locale.field_configId)
    {
      locale.field_value = Util.encodeHexString(paramArrayOfByte);
      bool = update(locale, new String[0]);
      Log.i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", new Object[] { locale.field_value, Boolean.valueOf(bool) });
      AppMethodBeat.o(101682);
      return;
    }
    locale.field_configId = 8216;
    locale.field_value = Util.encodeHexString(paramArrayOfByte);
    boolean bool = insert(locale);
    Log.i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", new Object[] { locale.field_value, Boolean.valueOf(bool) });
    AppMethodBeat.o(101682);
  }
  
  public final byte[] cUN()
  {
    AppMethodBeat.i(101684);
    Object localObject = cVr();
    if (8216 != ((com.tencent.mm.plugin.fav.a.e)localObject).field_configId)
    {
      Log.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
      g.aAi();
      if (((Boolean)g.aAh().azQ().get(8224, Boolean.FALSE)).booleanValue()) {
        Log.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
      }
    }
    else
    {
      Log.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.e)localObject).field_configId), ((com.tencent.mm.plugin.fav.a.e)localObject).field_value });
      localObject = Util.decodeHexString(((com.tencent.mm.plugin.fav.a.e)localObject).field_value);
      AppMethodBeat.o(101684);
      return localObject;
    }
    g.aAi();
    localObject = Util.nullAsNil((String)g.aAh().azQ().get(8216, ""));
    Log.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", new Object[] { localObject });
    localObject = Util.decodeHexString((String)localObject);
    bE((byte[])localObject);
    Log.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
    g.aAi();
    g.aAh().azQ().set(8224, Boolean.TRUE);
    AppMethodBeat.o(101684);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.b
 * JD-Core Version:    0.7.0.1
 */