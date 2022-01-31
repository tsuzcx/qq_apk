package com.tencent.mm.am;

import java.io.Serializable;

final class c$a
  implements Serializable
{
  long eke = 0L;
  long time = 0L;
  int type = 0;
  
  c$a(long paramLong1, long paramLong2, int paramInt)
  {
    this.eke = paramLong1;
    this.time = paramLong2;
    this.type = paramInt;
  }
  
  public final String toString()
  {
    return String.format("serverTime:%s,time:%s,type:%s", new Object[] { a.bU(this.eke), a.bU(this.time), Integer.valueOf(this.type) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.am.c.a
 * JD-Core Version:    0.7.0.1
 */