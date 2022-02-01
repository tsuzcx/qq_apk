package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cg;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "insert", "", "item", "remove", "", "localId", "", "Companion", "plugin-finder_release"})
public final class p
  extends j<o>
{
  private static final String[] SQL_CREATE;
  private static final String TABLE_NAME = "FinderLocalOperation";
  public static final String TAG = "Finder.FinderLocalOperationStorage";
  public static final a sJs;
  public final e db;
  
  static
  {
    AppMethodBeat.i(204281);
    sJs = new a((byte)0);
    TAG = "Finder.FinderLocalOperationStorage";
    TABLE_NAME = "FinderLocalOperation";
    o.a locala = o.sJr;
    SQL_CREATE = new String[] { j.getCreateSQLs(o.access$getInfo$cp(), "FinderLocalOperation") };
    AppMethodBeat.o(204281);
  }
  
  public p(e parame)
  {
    super(parame, o.access$getInfo$cp(), "FinderLocalOperation", cg.INDEX_CREATE);
    AppMethodBeat.i(204280);
    this.db = parame;
    AppMethodBeat.o(204280);
  }
  
  public final boolean a(o paramo)
  {
    AppMethodBeat.i(204278);
    d.g.b.p.h(paramo, "item");
    boolean bool = super.insert((c)paramo);
    ae.i(TAG, "insert " + paramo.field_localId + ", ret:" + bool);
    AppMethodBeat.o(204278);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "getTABLE_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.p
 * JD-Core Version:    0.7.0.1
 */