package com.tencent.mm.plugin.fav.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.e;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.aq;

public final class b
  extends MAutoStorage<e>
  implements t
{
  private ISQLiteDatabase db;
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, e.info, "FavConfigInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  private e dRn()
  {
    AppMethodBeat.i(101683);
    e locale = new e();
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
  
  public final void bS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101682);
    e locale = dRn();
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
  
  public final byte[] dQD()
  {
    AppMethodBeat.i(101684);
    Object localObject = dRn();
    if (8216 != ((e)localObject).field_configId)
    {
      Log.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
      h.baF();
      if (((Boolean)h.baE().ban().d(8224, Boolean.FALSE)).booleanValue()) {
        Log.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
      }
    }
    else
    {
      Log.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", new Object[] { Integer.valueOf(((e)localObject).field_configId), ((e)localObject).field_value });
      localObject = Util.decodeHexString(((e)localObject).field_value);
      AppMethodBeat.o(101684);
      return localObject;
    }
    h.baF();
    localObject = Util.nullAsNil((String)h.baE().ban().d(8216, ""));
    Log.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", new Object[] { localObject });
    localObject = Util.decodeHexString((String)localObject);
    bS((byte[])localObject);
    Log.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
    h.baF();
    h.baE().ban().B(8224, Boolean.TRUE);
    AppMethodBeat.o(101684);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.e.b
 * JD-Core Version:    0.7.0.1
 */