package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;

final class f$d
  extends a
{
  private f$d(f paramf) {}
  
  public final boolean execute()
  {
    g.DP().dKu.gk(null, "UPDATE rconversation SET unReadCount = 0;");
    return true;
  }
  
  public final String getName()
  {
    return "FTSClearUnReadCountTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.f.d
 * JD-Core Version:    0.7.0.1
 */