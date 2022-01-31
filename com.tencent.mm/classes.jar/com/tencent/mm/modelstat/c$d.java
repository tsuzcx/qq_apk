package com.tencent.mm.modelstat;

import java.io.Serializable;
import java.util.Locale;

final class c$d
  implements Serializable, Comparable<d>
{
  String eCA = null;
  int left;
  long time = 0L;
  int top;
  int type = 0;
  
  public final String toString()
  {
    return String.format(Locale.getDefault(), "[%s,%s]", new Object[] { this.eCA, c.cf(this.time) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.d
 * JD-Core Version:    0.7.0.1
 */