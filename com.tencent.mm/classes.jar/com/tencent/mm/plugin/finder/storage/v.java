package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ck;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "insert", "", "item", "remove", "", "localId", "", "Companion", "plugin-finder_release"})
public final class v
  extends MAutoStorage<u>
{
  private static final String[] SQL_CREATE;
  private static final String TABLE_NAME = "FinderLocalOperation";
  public static final String TAG = "Finder.FinderLocalOperationStorage";
  public static final a vEl;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(251808);
    vEl = new a((byte)0);
    TAG = "Finder.FinderLocalOperationStorage";
    TABLE_NAME = "FinderLocalOperation";
    u.a locala = u.vEk;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(u.access$getInfo$cp(), "FinderLocalOperation") };
    AppMethodBeat.o(251808);
  }
  
  public v(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, u.access$getInfo$cp(), "FinderLocalOperation", ck.INDEX_CREATE);
    AppMethodBeat.i(251807);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(251807);
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(251805);
    p.h(paramu, "item");
    boolean bool = super.insert((IAutoDBItem)paramu);
    Log.i(TAG, "insert " + paramu.field_localId + ", ret:" + bool);
    AppMethodBeat.o(251805);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "getTABLE_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.v
 * JD-Core Version:    0.7.0.1
 */