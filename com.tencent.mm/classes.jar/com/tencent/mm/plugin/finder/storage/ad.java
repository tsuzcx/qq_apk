package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ci;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderNewXmlDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderConsumeNewXmlData;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends MAutoStorage<ci>
{
  public static final a FLZ;
  private static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(339453);
    FLZ = new a((byte)0);
    aw.a locala = aw.FMG;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(aw.access$getInfo$cp(), "FinderConsumeNewXmlData") };
    AppMethodBeat.o(339453);
  }
  
  public ad(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aw.access$getInfo$cp(), "FinderConsumeNewXmlData", ci.INDEX_CREATE);
    AppMethodBeat.i(339428);
    AppMethodBeat.o(339428);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderNewXmlDataStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ad
 * JD-Core Version:    0.7.0.1
 */