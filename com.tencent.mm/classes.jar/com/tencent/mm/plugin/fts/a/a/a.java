package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public final class a
{
  public static final Column Hsp;
  public static final Column Hsq;
  public static final Column Hsr;
  public static final Column ROWID;
  public static final Column SUBTYPE;
  public static final SingleTable TABLE;
  public static final Column TYPE;
  public static final Column jIz;
  public static final Column kkd;
  
  static
  {
    AppMethodBeat.i(265529);
    TABLE = new SingleTable("FTS5MetaChatroomMember");
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    Hsp = new Column("docid", "int", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    SUBTYPE = new Column("subtype", "int", TABLE.getName(), "");
    Hsq = new Column("entity_id", "long", TABLE.getName(), "");
    Hsr = new Column("aux_index", "string", TABLE.getName(), "");
    kkd = new Column("timestamp", "long", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    AppMethodBeat.o(265529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.a
 * JD-Core Version:    0.7.0.1
 */