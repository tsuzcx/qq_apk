package com.tencent.mm.plugin.appbrand.game.e;

import java.util.HashMap;

public final class a$3
  implements Runnable
{
  public a$3(a parama, long paramLong) {}
  
  public final void run()
  {
    if (this.gdc <= 0L) {
      return;
    }
    if (this.gdc < 5120L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(0)))
      {
        a.c(this.gdb).put(Integer.valueOf(0), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(0))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(0), Integer.valueOf(1));
      return;
    }
    if (this.gdc < 10240L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(1)))
      {
        a.c(this.gdb).put(Integer.valueOf(1), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(1))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(1), Integer.valueOf(1));
      return;
    }
    if (this.gdc < 20480L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(2)))
      {
        a.c(this.gdb).put(Integer.valueOf(2), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(2))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(2), Integer.valueOf(1));
      return;
    }
    if (this.gdc < 51200L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(3)))
      {
        a.c(this.gdb).put(Integer.valueOf(3), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(3))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(3), Integer.valueOf(1));
      return;
    }
    if (this.gdc < 102400L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(4)))
      {
        a.c(this.gdb).put(Integer.valueOf(4), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(4))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(4), Integer.valueOf(1));
      return;
    }
    if (this.gdc < 153600L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(5)))
      {
        a.c(this.gdb).put(Integer.valueOf(5), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(5))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(5), Integer.valueOf(1));
      return;
    }
    if (this.gdc < 204800L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(6)))
      {
        a.c(this.gdb).put(Integer.valueOf(6), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(6))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(6), Integer.valueOf(1));
      return;
    }
    if (this.gdc < 512000L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(7)))
      {
        a.c(this.gdb).put(Integer.valueOf(7), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(7))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(7), Integer.valueOf(1));
      return;
    }
    if (this.gdc < 1048576L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(8)))
      {
        a.c(this.gdb).put(Integer.valueOf(8), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(8))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(8), Integer.valueOf(1));
      return;
    }
    if (this.gdc < 2097152L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(9)))
      {
        a.c(this.gdb).put(Integer.valueOf(9), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(9))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(9), Integer.valueOf(1));
      return;
    }
    if (this.gdc < 3145728L)
    {
      if (a.c(this.gdb).containsKey(Integer.valueOf(10)))
      {
        a.c(this.gdb).put(Integer.valueOf(10), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(10))).intValue() + 1));
        return;
      }
      a.c(this.gdb).put(Integer.valueOf(10), Integer.valueOf(1));
      return;
    }
    if (a.c(this.gdb).containsKey(Integer.valueOf(11)))
    {
      a.c(this.gdb).put(Integer.valueOf(11), Integer.valueOf(((Integer)a.c(this.gdb).get(Integer.valueOf(11))).intValue() + 1));
      return;
    }
    a.c(this.gdb).put(Integer.valueOf(11), Integer.valueOf(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.3
 * JD-Core Version:    0.7.0.1
 */