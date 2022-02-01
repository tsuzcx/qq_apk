package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "insert", "", "item", "remove", "", "localId", "", "Companion", "plugin-finder_release"})
public final class s
  extends MAutoStorage<r>
{
  public static final a Alw;
  private static final String[] SQL_CREATE;
  private static final String TABLE_NAME = "FinderLocalOperation";
  public static final String TAG = "Finder.FinderLocalOperationStorage";
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(280090);
    Alw = new a((byte)0);
    TAG = "Finder.FinderLocalOperationStorage";
    TABLE_NAME = "FinderLocalOperation";
    r.a locala = r.Alv;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(r.access$getInfo$cp(), "FinderLocalOperation") };
    AppMethodBeat.o(280090);
  }
  
  public s(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, r.access$getInfo$cp(), "FinderLocalOperation", cp.INDEX_CREATE);
    AppMethodBeat.i(280089);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(280089);
  }
  
  public final boolean a(r paramr)
  {
    AppMethodBeat.i(280087);
    p.k(paramr, "item");
    boolean bool = super.insert((IAutoDBItem)paramr);
    Log.i(TAG, "insert " + paramr.field_localId + ", ret:" + bool);
    AppMethodBeat.o(280087);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "getTABLE_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.s
 * JD-Core Version:    0.7.0.1
 */