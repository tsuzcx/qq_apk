package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
  extends MAutoStorage<c>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(40950);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "GameHaowanMedia") };
    AppMethodBeat.o(40950);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "GameHaowanMedia", null);
  }
  
  public final c aGu(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(40947);
    paramString = String.format("select * from %s where %s=\"%s\"", new Object[] { "GameHaowanMedia", "localId", paramString });
    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "get, sql: ".concat(String.valueOf(paramString)));
    Cursor localCursor = rawQuery(paramString, new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(40947);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToNext())
    {
      paramString = new c();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(40947);
    return paramString;
  }
  
  public final Map<String, c> bq(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(40948);
    paramLinkedList = String.format("select * from %s where %s in %s", new Object[] { "GameHaowanMedia", "localId", com.tencent.mm.plugin.game.d.c.by(paramLinkedList) });
    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "batchGet, sql: ".concat(String.valueOf(paramLinkedList)));
    paramLinkedList = rawQuery(paramLinkedList, new String[0]);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(40948);
      return null;
    }
    HashMap localHashMap = new HashMap();
    while (paramLinkedList.moveToNext())
    {
      c localc = new c();
      localc.convertFrom(paramLinkedList);
      localHashMap.put(localc.field_localId, localc);
    }
    paramLinkedList.close();
    AppMethodBeat.o(40948);
    return localHashMap;
  }
  
  public final void br(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(40949);
    Object localObject = String.format("select * from %s where %s in %s", new Object[] { "GameHaowanMedia", "localId", com.tencent.mm.plugin.game.d.c.by(paramLinkedList) });
    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "batchGet, sql: ".concat(String.valueOf(localObject)));
    Cursor localCursor = rawQuery((String)localObject, new String[0]);
    if (localCursor == null) {
      localObject = null;
    }
    for (;;)
    {
      if (!Util.isNullOrNil((List)localObject)) {
        a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(40946);
            Iterator localIterator = this.Iyt.iterator();
            while (localIterator.hasNext())
            {
              c localc = (c)localIterator.next();
              if (localc != null)
              {
                com.tencent.mm.plugin.game.commlib.e.c.remove(localc.field_filePath);
                com.tencent.mm.plugin.game.commlib.e.c.remove(localc.field_thumbPath);
                com.tencent.mm.plugin.game.commlib.e.c.remove(localc.field_compressPath);
              }
            }
            AppMethodBeat.o(40946);
          }
        });
      }
      paramLinkedList = String.format("delete from %s where %s in %s", new Object[] { "GameHaowanMedia", "localId", com.tencent.mm.plugin.game.d.c.by(paramLinkedList) });
      Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "batchDelete, sql: ".concat(String.valueOf(paramLinkedList)));
      execSQL("GameHaowanMedia", paramLinkedList);
      AppMethodBeat.o(40949);
      return;
      localObject = new LinkedList();
      while (localCursor.moveToNext())
      {
        c localc = new c();
        localc.convertFrom(localCursor);
        ((LinkedList)localObject).add(localc);
      }
      localCursor.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.d
 * JD-Core Version:    0.7.0.1
 */