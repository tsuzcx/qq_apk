package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cg;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "insert", "", "item", "remove", "", "localId", "", "Companion", "plugin-finder_release"})
public final class p
  extends j<o>
{
  private static final String[] SQL_CREATE;
  private static final String TABLE_NAME = "FinderLocalOperation";
  public static final String TAG = "Finder.FinderLocalOperationStorage";
  public static final a syB;
  public final e db;
  
  static
  {
    AppMethodBeat.i(203713);
    syB = new a((byte)0);
    TAG = "Finder.FinderLocalOperationStorage";
    TABLE_NAME = "FinderLocalOperation";
    o.a locala = o.syA;
    SQL_CREATE = new String[] { j.getCreateSQLs(o.access$getInfo$cp(), "FinderLocalOperation") };
    AppMethodBeat.o(203713);
  }
  
  public p(e parame)
  {
    super(parame, o.access$getInfo$cp(), "FinderLocalOperation", cg.INDEX_CREATE);
    AppMethodBeat.i(203712);
    this.db = parame;
    AppMethodBeat.o(203712);
  }
  
  public final boolean a(o paramo)
  {
    AppMethodBeat.i(203710);
    d.g.b.p.h(paramo, "item");
    boolean bool = super.insert((c)paramo);
    ad.i(TAG, "insert " + paramo.field_localId + ", ret:" + bool);
    AppMethodBeat.o(203710);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "getTABLE_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.p
 * JD-Core Version:    0.7.0.1
 */