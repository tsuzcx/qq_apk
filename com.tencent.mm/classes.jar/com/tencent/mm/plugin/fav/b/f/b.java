package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class b
  extends i<com.tencent.mm.plugin.fav.a.e>
  implements s
{
  private com.tencent.mm.sdk.e.e dXw;
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, com.tencent.mm.plugin.fav.a.e.buS, "FavConfigInfo", null);
    this.dXw = parame;
  }
  
  private com.tencent.mm.plugin.fav.a.e aQW()
  {
    com.tencent.mm.plugin.fav.a.e locale = new com.tencent.mm.plugin.fav.a.e();
    y.d("MicroMsg.FavConfigStorage", "get fav config sql %s", new Object[] { "select * from FavConfigInfo where configId = 8216" });
    Cursor localCursor = this.dXw.a("select * from FavConfigInfo where configId = 8216", null, 2);
    if (localCursor != null)
    {
      if (localCursor.moveToFirst()) {
        locale.d(localCursor);
      }
      localCursor.close();
    }
    return locale;
  }
  
  public final byte[] aQr()
  {
    Object localObject = aQW();
    if (8216 != ((com.tencent.mm.plugin.fav.a.e)localObject).field_configId)
    {
      y.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
      g.DQ();
      if (((Boolean)g.DP().Dz().get(8224, Boolean.valueOf(false))).booleanValue()) {
        y.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
      }
    }
    else
    {
      y.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.e)localObject).field_configId), ((com.tencent.mm.plugin.fav.a.e)localObject).field_value });
      return bk.ZM(((com.tencent.mm.plugin.fav.a.e)localObject).field_value);
    }
    g.DQ();
    localObject = bk.pm((String)g.DP().Dz().get(8216, ""));
    y.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", new Object[] { localObject });
    localObject = bk.ZM((String)localObject);
    ay((byte[])localObject);
    y.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
    g.DQ();
    g.DP().Dz().o(8224, Boolean.valueOf(true));
    return localObject;
  }
  
  public final void ay(byte[] paramArrayOfByte)
  {
    com.tencent.mm.plugin.fav.a.e locale = aQW();
    if (8216 == locale.field_configId)
    {
      locale.field_value = bk.bG(paramArrayOfByte);
      bool = c(locale, new String[0]);
      y.i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", new Object[] { locale.field_value, Boolean.valueOf(bool) });
      return;
    }
    locale.field_configId = 8216;
    locale.field_value = bk.bG(paramArrayOfByte);
    boolean bool = b(locale);
    y.i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", new Object[] { locale.field_value, Boolean.valueOf(bool) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.b
 * JD-Core Version:    0.7.0.1
 */