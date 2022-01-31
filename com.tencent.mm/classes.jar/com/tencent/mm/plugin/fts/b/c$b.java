package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import java.util.List;

final class c$b
  extends a
{
  private int mCount = 0;
  
  private c$b(c paramc) {}
  
  public final String afJ()
  {
    return String.format("{mCount: %d}", new Object[] { Integer.valueOf(this.mCount) });
  }
  
  public final boolean execute()
  {
    this.mCount = this.kze.kyW.f(com.tencent.mm.plugin.fts.a.c.kuN, -1).size();
    return true;
  }
  
  public final String getName()
  {
    return "DeleteAllTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.b
 * JD-Core Version:    0.7.0.1
 */