package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;

final class c$c
  extends a
{
  private long djE;
  
  public c$c(c paramc, long paramLong)
  {
    this.djE = paramLong;
  }
  
  public final String afJ()
  {
    return String.format("{MsgId: %d}", new Object[] { Long.valueOf(this.djE) });
  }
  
  public final boolean execute()
  {
    this.kze.kyW.c(com.tencent.mm.plugin.fts.a.c.kuN, this.djE);
    return true;
  }
  
  public final String getName()
  {
    return "DeleteMessageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.c
 * JD-Core Version:    0.7.0.1
 */