package com.tencent.mm.plugin.gamelife.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.do;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.Closeable;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clearUnreadCount", "", "sessionId", "", "get", "getHistoryConversation", "getLatestUnreadConversation", "getTotalUnreadCount", "", "getUnreadCount", "markUnread", "query", "", "offset", "nextCount", "queryLimit", "limitCount", "replace", "item", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends MAutoStorage<a>
{
  public static final e.a Jbw;
  private static final String[] SQL_CREATE;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(268143);
    Jbw = new e.a((byte)0);
    a.a locala = a.Jbr;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "GameLifeConversation") };
    AppMethodBeat.o(268143);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "GameLifeConversation", do.INDEX_CREATE);
    AppMethodBeat.i(268120);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(268120);
  }
  
  private final List<a> ji(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(268130);
    LinkedList localLinkedList = new LinkedList();
    localObject1 = "select *, rowid from GameLifeConversation ORDER BY updateTime DESC limit " + paramInt2 + " offset " + paramInt1;
    localObject1 = (Closeable)this.db.rawQuery((String)localObject1, null);
    try
    {
      Cursor localCursor = (Cursor)localObject1;
      if (localCursor.moveToFirst()) {
        while (!localCursor.isAfterLast())
        {
          a locala = new a();
          locala.convertFrom(localCursor);
          localLinkedList.add(locala);
          localCursor.moveToNext();
        }
      }
      ah localah;
      return localObject1;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(268130);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(268130);
      }
      localah = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject1, null);
      localObject1 = (List)localThrowable;
      AppMethodBeat.o(268130);
    }
  }
  
  public final boolean aAB(String paramString)
  {
    AppMethodBeat.i(268183);
    s.u(paramString, "sessionId");
    Object localObject = com.tencent.mm.plugin.gamelife.b.IYX;
    if (!b.a.aHt(paramString))
    {
      AppMethodBeat.o(268183);
      return false;
    }
    localObject = aHD(paramString);
    int i = ((a)localObject).field_unReadCount;
    ((a)localObject).field_unReadCount = 0;
    ((a)localObject).field_digestFlag = 0L;
    ((a)localObject).field_digestPrefix = null;
    boolean bool = update(((a)localObject).systemRowid, (IAutoDBItem)localObject, false);
    doNotify("single", 4, localObject);
    Log.i("GameLife.ConversationStorage", "[clearUnreadCount] ret=" + bool + ' ' + i + " => " + ((a)localObject).field_unReadCount + " sessionId=" + paramString);
    AppMethodBeat.o(268183);
    return bool;
  }
  
  public final int aAs(String paramString)
  {
    AppMethodBeat.i(268192);
    s.u(paramString, "sessionId");
    Object localObject1 = com.tencent.mm.plugin.gamelife.b.IYX;
    if (!b.a.aHt(paramString))
    {
      AppMethodBeat.o(268192);
      return 0;
    }
    localObject1 = "SELECT sessionId from GameLifeConversation WHERE sessionId='" + paramString + '\'';
    localObject1 = (Closeable)this.db.rawQuery((String)localObject1, null);
    try
    {
      Object localObject2 = (Cursor)localObject1;
      if ((((Cursor)localObject2).moveToFirst()) && (!((Cursor)localObject2).isAfterLast()))
      {
        i = ((Cursor)localObject2).getInt(0);
        localObject2 = ah.aiuX;
        kotlin.f.b.a((Closeable)localObject1, null);
        Log.i("GameLife.ConversationStorage", "[getUnreadCount] " + paramString + ' ' + i);
        AppMethodBeat.o(268192);
        return i;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.o(268192);
          throw paramString;
        }
        finally
        {
          kotlin.f.b.a((Closeable)localObject1, paramString);
          AppMethodBeat.o(268192);
        }
        int i = 0;
      }
    }
  }
  
  public final a aHD(String paramString)
  {
    AppMethodBeat.i(268154);
    s.u(paramString, "sessionId");
    Object localObject = "select *, rowid from GameLifeConversation where sessionId = '" + paramString + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    a locala = new a();
    locala.field_sessionId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        locala.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(268154);
    return locala;
  }
  
  public final int fIi()
  {
    AppMethodBeat.i(268204);
    Closeable localCloseable = (Closeable)this.db.rawQuery("SELECT SUM(unReadCount) FROM GameLifeConversation WHERE sessionId<>'@gamelifehistory'", null);
    try
    {
      Object localObject1 = (Cursor)localCloseable;
      if ((((Cursor)localObject1).moveToFirst()) && (!((Cursor)localObject1).isAfterLast()))
      {
        i = ((Cursor)localObject1).getInt(0);
        localObject1 = ah.aiuX;
        kotlin.f.b.a(localCloseable, null);
        Log.i("GameLife.ConversationStorage", s.X("[getTotalUnreadCount] ", Integer.valueOf(i)));
        AppMethodBeat.o(268204);
        return i;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.o(268204);
          throw localThrowable;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, localThrowable);
          AppMethodBeat.o(268204);
        }
        int i = 0;
      }
    }
  }
  
  public final a fIt()
  {
    AppMethodBeat.i(268221);
    Closeable localCloseable = (Closeable)this.db.rawQuery("SELECT *, rowid FROM GameLifeConversation WHERE unReadCount>0 ORDER BY updateTime DESC LIMIT 1", null);
    try
    {
      Object localObject1 = (Cursor)localCloseable;
      if ((((Cursor)localObject1).moveToFirst()) && (!((Cursor)localObject1).isAfterLast()))
      {
        a locala = new a();
        locala.convertFrom((Cursor)localObject1);
        kotlin.f.b.a(localCloseable, null);
        AppMethodBeat.o(268221);
        return locala;
      }
      localObject1 = ah.aiuX;
      kotlin.f.b.a(localCloseable, null);
      AppMethodBeat.o(268221);
      return null;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(268221);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a(localCloseable, localThrowable);
        AppMethodBeat.o(268221);
      }
    }
  }
  
  public final a fIu()
  {
    AppMethodBeat.i(268232);
    a locala = new a();
    Closeable localCloseable = (Closeable)this.db.rawQuery("SELECT *, rowid FROM GameLifeConversation WHERE sessionId='@gamelifehistory'", null);
    try
    {
      Object localObject1 = (Cursor)localCloseable;
      if (((Cursor)localObject1).moveToFirst())
      {
        locala.convertFrom((Cursor)localObject1);
        kotlin.f.b.a(localCloseable, null);
        AppMethodBeat.o(268232);
        return locala;
      }
      localObject1 = ah.aiuX;
      kotlin.f.b.a(localCloseable, null);
      AppMethodBeat.o(268232);
      return locala;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(268232);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a(localCloseable, localThrowable);
        AppMethodBeat.o(268232);
      }
    }
  }
  
  public final List<a> fg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(268168);
    List localList = ji(paramInt1, paramInt2);
    Log.i("GameLife.ConversationStorage", "[query] offset=" + paramInt1 + " pageCount=" + paramInt2 + " list size=" + localList.size());
    AppMethodBeat.o(268168);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.e
 * JD-Core Version:    0.7.0.1
 */