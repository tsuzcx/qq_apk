package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cr;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"})
public final class ai
  extends MAutoStorage<cr>
{
  public static final a AmH;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(266962);
    AmH = new a((byte)0);
    Object localObject = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    an.a locala = an.AmM;
    INDEX_CREATE = new String[] { an.dZl() + " ON " + cr.hUo + " ( id, flag, type, userVersion)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Id_Create_Time ON " + cr.hUn + "(createTime, id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + cr.hUo + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + cr.hUo + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + cr.hUo + "(commentId)" };
    localObject = an.AmM;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(an.access$getInfo$cp(), cr.hUo) };
    AppMethodBeat.o(266962);
  }
  
  public ai(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, an.access$getInfo$cp(), cr.hUo, INDEX_CREATE);
    AppMethodBeat.i(266961);
    AppMethodBeat.o(266961);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ai
 * JD-Core Version:    0.7.0.1
 */