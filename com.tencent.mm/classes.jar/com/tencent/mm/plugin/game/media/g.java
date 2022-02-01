package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends MAutoStorage<e>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(40975);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(e.info, "GameHaowanPublishEdition") };
    AppMethodBeat.o(40975);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, e.info, "GameHaowanPublishEdition", null);
  }
  
  public final e aGw(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(40968);
    paramString = String.format("select * from %s where %s=\"%s\"", new Object[] { "GameHaowanPublishEdition", "taskId", paramString });
    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "query, sql : %s", new Object[] { paramString });
    Cursor localCursor = rawQuery(paramString, new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(40968);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToNext())
    {
      paramString = new e();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(40968);
    return paramString;
  }
  
  public final boolean aGx(String paramString)
  {
    AppMethodBeat.i(40971);
    paramString = String.format("update %s set %s=%d where %s=\"%s\"", new Object[] { "GameHaowanPublishEdition", "publishState", Integer.valueOf(1), "taskId", paramString });
    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updatePublishState, sql : %s", new Object[] { paramString });
    boolean bool = execSQL("GameHaowanPublishEdition", paramString);
    AppMethodBeat.o(40971);
    return bool;
  }
  
  public final void br(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(40974);
    Object localObject = bs(paramLinkedList);
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LinkedList localLinkedList = c.aHo(((e)((Iterator)localObject).next()).field_localIdList);
        ((f)h.ax(f.class)).fCl().br(localLinkedList);
      }
      paramLinkedList = String.format("delete from %s where %s in %s", new Object[] { "GameHaowanPublishEdition", "taskId", c.by(paramLinkedList) });
      Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "batchDelete, sql : %s", new Object[] { paramLinkedList });
      execSQL("GameHaowanPublishEdition", paramLinkedList);
    }
    AppMethodBeat.o(40974);
  }
  
  public final LinkedList<e> bs(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(40973);
    paramLinkedList = String.format("select * from %s where %s in %s", new Object[] { "GameHaowanPublishEdition", "taskId", c.by(paramLinkedList) });
    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "batchQuery, sql : %s", new Object[] { paramLinkedList });
    paramLinkedList = rawQuery(paramLinkedList, new String[0]);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(40973);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    while (paramLinkedList.moveToNext())
    {
      e locale = new e();
      locale.convertFrom(paramLinkedList);
      localLinkedList.add(locale);
    }
    paramLinkedList.close();
    AppMethodBeat.o(40973);
    return localLinkedList;
  }
  
  public final LinkedList<e> fFn()
  {
    AppMethodBeat.i(40972);
    Object localObject = String.format("select * from %s where %s<>%d", new Object[] { "GameHaowanPublishEdition", "publishState", Integer.valueOf(2) });
    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAllNotFinished, sql : %s", new Object[] { localObject });
    localObject = rawQuery((String)localObject, new String[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(40972);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext())
    {
      e locale = new e();
      locale.convertFrom((Cursor)localObject);
      localLinkedList.add(locale);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(40972);
    return localLinkedList;
  }
  
  public final boolean ft(String paramString, int paramInt)
  {
    AppMethodBeat.i(40969);
    paramString = String.format("update %s set %s=%d where %s=\"%s\"", new Object[] { "GameHaowanPublishEdition", "mixState", Integer.valueOf(paramInt), "taskId", paramString });
    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updateMixState, sql : %s", new Object[] { paramString });
    boolean bool = execSQL("GameHaowanPublishEdition", paramString);
    AppMethodBeat.o(40969);
    return bool;
  }
  
  public final boolean fu(String paramString, int paramInt)
  {
    AppMethodBeat.i(40970);
    paramString = String.format("update %s set %s=%d where %s=\"%s\"", new Object[] { "GameHaowanPublishEdition", "uploadState", Integer.valueOf(paramInt), "taskId", paramString });
    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updateMediaUploadState, sql : %s", new Object[] { paramString });
    boolean bool = execSQL("GameHaowanPublishEdition", paramString);
    AppMethodBeat.o(40970);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.g
 * JD-Core Version:    0.7.0.1
 */