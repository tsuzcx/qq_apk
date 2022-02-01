package com.tencent.kinda.framework.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class KindaCacheStg
  extends j<KindaCacheItem>
{
  public static final String[] SQL_CREATE;
  public static final String TABLE_NAME = "KindaCacheTable";
  public static final String TAG = "MicroMsg.KindaCacheStg";
  private e db;
  
  static
  {
    AppMethodBeat.i(18389);
    SQL_CREATE = new String[] { j.getCreateSQLs(KindaCacheItem.info, "KindaCacheTable") };
    AppMethodBeat.o(18389);
  }
  
  public KindaCacheStg(e parame)
  {
    super(parame, KindaCacheItem.info, "KindaCacheTable", null);
    this.db = parame;
  }
  
  public KindaCacheItem get(String paramString)
  {
    AppMethodBeat.i(18388);
    paramString = this.db.rawQuery("select * from KindaCacheTable where key=?", new String[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(18388);
      return null;
    }
    if (paramString.getCount() == 0)
    {
      paramString.close();
      AppMethodBeat.o(18388);
      return null;
    }
    paramString.moveToFirst();
    KindaCacheItem localKindaCacheItem = new KindaCacheItem();
    localKindaCacheItem.convertFrom(paramString);
    paramString.close();
    AppMethodBeat.o(18388);
    return localKindaCacheItem;
  }
  
  public void save(KindaCacheItem paramKindaCacheItem)
  {
    AppMethodBeat.i(18387);
    super.replace(paramKindaCacheItem);
    AppMethodBeat.o(18387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaCacheStg
 * JD-Core Version:    0.7.0.1
 */