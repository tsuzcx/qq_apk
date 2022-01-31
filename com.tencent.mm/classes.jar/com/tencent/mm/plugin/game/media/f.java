package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends j<d>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(151826);
    SQL_CREATE = new String[] { j.getCreateSQLs(d.info, "GameHaowanPublishEdition") };
    AppMethodBeat.o(151826);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.info, "GameHaowanPublishEdition", null);
  }
  
  public final d PY(String paramString)
  {
    AppMethodBeat.i(151820);
    paramString = String.format("select * from %s where %s=\"%s\"", new Object[] { "GameHaowanPublishEdition", "taskId", paramString });
    ab.i("MicroMsg.GameHaowanPublishStorage", "query, sql : %s", new Object[] { paramString });
    paramString = rawQuery(paramString, new String[0]);
    if (paramString == null)
    {
      AppMethodBeat.o(151820);
      return null;
    }
    d locald = new d();
    if (paramString.moveToNext()) {
      locald.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(151820);
    return locald;
  }
  
  public final boolean PZ(String paramString)
  {
    AppMethodBeat.i(151822);
    paramString = String.format("update %s set %s=%d where %s=\"%s\"", new Object[] { "GameHaowanPublishEdition", "publishState", Integer.valueOf(1), "taskId", paramString });
    ab.i("MicroMsg.GameHaowanPublishStorage", "updatePublishState, sql : %s", new Object[] { paramString });
    boolean bool = execSQL("GameHaowanPublishEdition", paramString);
    AppMethodBeat.o(151822);
    return bool;
  }
  
  public final void Y(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151825);
    Object localObject = Z(paramLinkedList);
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LinkedList localLinkedList = com.tencent.mm.plugin.game.f.c.QC(((d)((Iterator)localObject).next()).field_localIdList);
        ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bEW().Y(localLinkedList);
      }
      paramLinkedList = String.format("delete from %s where %s in %s", new Object[] { "GameHaowanPublishEdition", "taskId", com.tencent.mm.plugin.game.f.c.af(paramLinkedList) });
      ab.i("MicroMsg.GameHaowanPublishStorage", "batchDelete, sql : %s", new Object[] { paramLinkedList });
      execSQL("GameHaowanPublishEdition", paramLinkedList);
    }
    AppMethodBeat.o(151825);
  }
  
  public final LinkedList<d> Z(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151824);
    paramLinkedList = String.format("select * from %s where %s in %s", new Object[] { "GameHaowanPublishEdition", "taskId", com.tencent.mm.plugin.game.f.c.af(paramLinkedList) });
    ab.i("MicroMsg.GameHaowanPublishStorage", "batchQuery, sql : %s", new Object[] { paramLinkedList });
    paramLinkedList = rawQuery(paramLinkedList, new String[0]);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(151824);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    while (paramLinkedList.moveToNext())
    {
      d locald = new d();
      locald.convertFrom(paramLinkedList);
      localLinkedList.add(locald);
    }
    paramLinkedList.close();
    AppMethodBeat.o(151824);
    return localLinkedList;
  }
  
  public final LinkedList<d> bFG()
  {
    AppMethodBeat.i(151823);
    Object localObject = String.format("select * from %s where %s<>%d", new Object[] { "GameHaowanPublishEdition", "publishState", Integer.valueOf(2) });
    ab.i("MicroMsg.GameHaowanPublishStorage", "queryAllNotFinished, sql : %s", new Object[] { localObject });
    localObject = rawQuery((String)localObject, new String[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(151823);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext())
    {
      d locald = new d();
      locald.convertFrom((Cursor)localObject);
      localLinkedList.add(locald);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(151823);
    return localLinkedList;
  }
  
  public final boolean ct(String paramString, int paramInt)
  {
    AppMethodBeat.i(151821);
    paramString = String.format("update %s set %s=%d where %s=\"%s\"", new Object[] { "GameHaowanPublishEdition", "uploadState", Integer.valueOf(paramInt), "taskId", paramString });
    ab.i("MicroMsg.GameHaowanPublishStorage", "updateMediaUploadState, sql : %s", new Object[] { paramString });
    boolean bool = execSQL("GameHaowanPublishEdition", paramString);
    AppMethodBeat.o(151821);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.f
 * JD-Core Version:    0.7.0.1
 */