package com.tencent.mm.am;

import java.io.Serializable;

final class c$c
  implements Serializable
{
  long eke = 0L;
  long ekj = 0L;
  long ekk = 0L;
  long ekl = 0L;
  long ekz = 0L;
  int pid = 0;
  
  c$c(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.pid = paramInt;
    this.eke = paramLong1;
    this.ekz = paramLong2;
    this.ekj = paramLong3;
    this.ekk = paramLong4;
    this.ekl = paramLong5;
  }
  
  public final String toString()
  {
    return String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s", new Object[] { Integer.valueOf(this.pid), a.bU(this.eke), a.bU(this.ekz), a.bU(this.ekj), Long.valueOf(this.ekk), Long.valueOf(this.ekl) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.am.c.c
 * JD-Core Version:    0.7.0.1
 */