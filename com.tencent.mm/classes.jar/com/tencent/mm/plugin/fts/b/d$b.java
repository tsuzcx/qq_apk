package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.h;

public final class d$b
  extends a
{
  public d$b(d paramd) {}
  
  public final boolean execute()
  {
    this.kzu.kzs.kuE.execSQL(String.format("DELETE FROM %s ;", new Object[] { "FTS5MetaSOSHistory" }));
    return true;
  }
  
  public final String getName()
  {
    return "DeleteSOSHistoryTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.d.b
 * JD-Core Version:    0.7.0.1
 */