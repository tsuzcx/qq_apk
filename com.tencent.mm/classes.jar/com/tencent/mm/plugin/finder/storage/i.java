package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"})
public final class i
  extends j<cd>
{
  private static final String[] INDEX_CREATE;
  public static final a KWu;
  private static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(198974);
    KWu = new a((byte)0);
    Object localObject = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    l.a locala = l.qKi;
    INDEX_CREATE = new String[] { l.cqD() + " ON " + cd.qnP + " ( id, flag, type, userVersion)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Id ON " + cd.qnP + "(id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + cd.qnP + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + cd.qnP + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + cd.qnP + "(commentId)" };
    localObject = l.qKi;
    SQL_CREATE = new String[] { j.getCreateSQLs(l.access$getInfo$cp(), cd.qnP) };
    AppMethodBeat.o(198974);
  }
  
  public i(e parame)
  {
    super(parame, l.access$getInfo$cp(), cd.qnP, INDEX_CREATE);
    AppMethodBeat.i(198973);
    AppMethodBeat.o(198973);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.i
 * JD-Core Version:    0.7.0.1
 */