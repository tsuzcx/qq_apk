package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends j<b>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(151805);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "GameHaowanMedia") };
    AppMethodBeat.o(151805);
  }
  
  public c(e parame)
  {
    super(parame, b.info, "GameHaowanMedia", null);
  }
  
  public final b PX(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(151802);
    paramString = String.format("select * from %s where %s=\"%s\"", new Object[] { "GameHaowanMedia", "localId", paramString });
    ab.i("MicroMsg.GameHaowanPublishStorage", "get, sql: ".concat(String.valueOf(paramString)));
    Cursor localCursor = rawQuery(paramString, new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(151802);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToNext())
    {
      paramString = new b();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(151802);
    return paramString;
  }
  
  public final Map<String, b> X(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151803);
    paramLinkedList = String.format("select * from %s where %s in %s", new Object[] { "GameHaowanMedia", "localId", com.tencent.mm.plugin.game.f.c.af(paramLinkedList) });
    ab.i("MicroMsg.GameHaowanPublishStorage", "batchGet, sql: ".concat(String.valueOf(paramLinkedList)));
    paramLinkedList = rawQuery(paramLinkedList, new String[0]);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(151803);
      return null;
    }
    HashMap localHashMap = new HashMap();
    while (paramLinkedList.moveToNext())
    {
      b localb = new b();
      localb.convertFrom(paramLinkedList);
      localHashMap.put(localb.field_localId, localb);
    }
    paramLinkedList.close();
    AppMethodBeat.o(151803);
    return localHashMap;
  }
  
  public final void Y(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151804);
    paramLinkedList = String.format("delete from %s where %s in %s", new Object[] { "GameHaowanMedia", "localId", com.tencent.mm.plugin.game.f.c.af(paramLinkedList) });
    ab.i("MicroMsg.GameHaowanPublishStorage", "batchDelete, sql: ".concat(String.valueOf(paramLinkedList)));
    execSQL("GameHaowanMedia", paramLinkedList);
    AppMethodBeat.o(151804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.c
 * JD-Core Version:    0.7.0.1
 */