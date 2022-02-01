package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.h;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/storage/FTS5ChatroomMemberStorage;", "Lcom/tencent/mm/plugin/fts/api/BaseFTS5NativeStorage;", "()V", "getCreateMetaTableSql", "", "getLogTag", "getName", "getPriority", "", "getTableName", "getType", "needReCreateTable", "", "onCreateTableAndStatement", "", "queryCommonChatroom", "Landroid/database/Cursor;", "ftsQuery", "Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "memberCount", "queryCommonChatroomWithMaxMemberCount", "memberLimit", "Companion", "plugin-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public static final a.a Hwu;
  
  static
  {
    AppMethodBeat.i(265420);
    Hwu = new a.a((byte)0);
    AppMethodBeat.o(265420);
  }
  
  public final void aXv()
  {
    AppMethodBeat.i(265422);
    if (aXw()) {
      this.HqR.aG(-110L, 3L);
    }
    AppMethodBeat.o(265422);
  }
  
  public final boolean aXw()
  {
    AppMethodBeat.i(265438);
    if (!iV(-110, 3))
    {
      AppMethodBeat.o(265438);
      return true;
    }
    AppMethodBeat.o(265438);
    return false;
  }
  
  public final String dRh()
  {
    AppMethodBeat.i(265436);
    Object localObject = am.aixg;
    localObject = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", Arrays.copyOf(new Object[] { fxn() }, 1));
    s.s(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(265436);
    return localObject;
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.FTS.FTS5ChatroomMemberStorage";
  }
  
  public final String getName()
  {
    return "FTS5ChatroomMemberStorage";
  }
  
  public final int getPriority()
  {
    return 5;
  }
  
  public final String getTableName()
  {
    return "ChatroomMember";
  }
  
  public final int getType()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a
 * JD-Core Version:    0.7.0.1
 */