package com.tencent.mm.plugin.game.chatroom.f;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/db/GameChatRoomContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/game/chatroom/db/GameChatRoomContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/game/chatroom/callback/IGameChatRoomContact;", "userName", "", "", "userNameList", "", "insertContact", "", "contact", "replaceContact", "", "updateContact", "Companion", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MAutoStorage<a>
{
  public static final b.a IkA;
  public static final String[] SQL_CREATE;
  private final ISQLiteDatabase psb;
  
  static
  {
    AppMethodBeat.i(275702);
    IkA = new b.a((byte)0);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.nVV, "GameChatRoomContact") };
    AppMethodBeat.o(275702);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.nVV, "GameChatRoomContact", a.INDEX_CREATE);
    AppMethodBeat.i(275683);
    this.psb = paramISQLiteDatabase;
    AppMethodBeat.o(275683);
  }
  
  private final int b(a parama)
  {
    AppMethodBeat.i(275691);
    ContentValues localContentValues = parama.convertTo();
    int i = this.psb.update("GameChatRoomContact", localContentValues, "userName=?", new String[] { parama.field_userName });
    Log.i("GameChatRoom.GameChatRoomContactStorage", "updateContact[" + i + "] " + parama.print());
    if (i > 0) {
      doNotify("single", 3, parama.field_userName);
    }
    AppMethodBeat.o(275691);
    return i;
  }
  
  private final int c(a parama)
  {
    AppMethodBeat.i(275698);
    ContentValues localContentValues = parama.convertTo();
    int i = (int)this.psb.insert("GameChatRoomContact", "userName", localContentValues);
    Log.i("GameChatRoom.GameChatRoomContactStorage", "insertContact[" + i + "] " + parama.print());
    if (i > 0) {
      doNotify("single", 2, parama.field_userName);
    }
    AppMethodBeat.o(275698);
    return i;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(275728);
    s.u(parama, "contact");
    if (parama.field_userName == null)
    {
      AppMethodBeat.o(275728);
      return false;
    }
    parama.field_updateTime = cn.bDw();
    String str = parama.field_userName;
    s.s(str, "contact.userName");
    if (aFv(str) == null) {}
    for (int i = c(parama); i > 0; i = b(parama))
    {
      AppMethodBeat.o(275728);
      return true;
    }
    AppMethodBeat.o(275728);
    return false;
  }
  
  public final c aFv(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(275710);
    s.u(paramString, "userName");
    paramString = s.X("SELECT * FROM GameChatRoomContact WHERE userName = ", h.EQ(paramString));
    localCloseable = (Closeable)this.psb.rawQuery(paramString, null, 2);
    for (;;)
    {
      try
      {
        localObject1 = (Cursor)localCloseable;
        if ((localObject1 == null) || (((Cursor)localObject1).moveToFirst() != true)) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramString = new a();
        paramString.convertFrom((Cursor)localObject1);
      }
      finally
      {
        try
        {
          Object localObject1;
          AppMethodBeat.o(275710);
          throw paramString;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, paramString);
          AppMethodBeat.o(275710);
        }
        paramString = null;
        continue;
      }
      localObject1 = ah.aiuX;
      kotlin.f.b.a(localCloseable, null);
      paramString = (c)paramString;
      AppMethodBeat.o(275710);
      return paramString;
      i = 0;
    }
  }
  
  public final Map<String, c> ij(List<String> paramList)
  {
    AppMethodBeat.i(275718);
    s.u(paramList, "userNameList");
    paramList = s.X("SELECT * FROM GameChatRoomContact WHERE userName IN ", e.ig(paramList));
    HashMap localHashMap = new HashMap();
    paramList = (Closeable)this.psb.rawQuery(paramList, null, 2);
    try
    {
      Cursor localCursor = (Cursor)paramList;
      if (localCursor.moveToFirst()) {
        while (!localCursor.isAfterLast())
        {
          a locala = new a();
          locala.convertFrom(localCursor);
          Map localMap = (Map)localHashMap;
          String str = locala.field_userName;
          s.s(str, "field_userName");
          localMap.put(str, locala);
          localCursor.moveToNext();
        }
      }
      ah localah;
      return paramList;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(275718);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a(paramList, localThrowable);
        AppMethodBeat.o(275718);
      }
      localah = ah.aiuX;
      kotlin.f.b.a(paramList, null);
      paramList = (Map)localThrowable;
      AppMethodBeat.o(275718);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.f.b
 * JD-Core Version:    0.7.0.1
 */