package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "insert", "", "item", "remove", "", "localId", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends MAutoStorage<s>
{
  public static final a FKW;
  private static final String[] SQL_CREATE;
  private static final String TABLE_NAME;
  private static final String TAG;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(339275);
    FKW = new a((byte)0);
    TAG = "Finder.FinderLocalOperationStorage";
    TABLE_NAME = "FinderLocalOperation";
    s.a locala = s.FKV;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(s.access$getInfo$cp(), "FinderLocalOperation") };
    AppMethodBeat.o(339275);
  }
  
  public t(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, s.access$getInfo$cp(), "FinderLocalOperation", cx.INDEX_CREATE);
    AppMethodBeat.i(339255);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(339255);
  }
  
  public final List<s> eZt()
  {
    AppMethodBeat.i(339290);
    Object localObject = new ArrayList();
    Cursor localCursor = this.db.rawQuery("select * from FinderLocalOperation", null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        s locals = new s();
        locals.convertFrom(localCursor);
        ((ArrayList)localObject).add(locals);
      }
      localCursor.close();
    }
    Log.i(TAG, kotlin.g.b.s.X("getAllData size:", Integer.valueOf(((ArrayList)localObject).size())));
    localObject = (List)localObject;
    AppMethodBeat.o(339290);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "getTABLE_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.t
 * JD-Core Version:    0.7.0.1
 */