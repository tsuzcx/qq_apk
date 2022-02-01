package com.tencent.tmdownloader.internal.a;

import java.util.Comparator;

class i
  implements Comparator
{
  i(h paramh) {}
  
  public int a(g paramg1, g paramg2)
  {
    if (paramg1.d() > paramg2.d()) {
      return 1;
    }
    if (paramg1.d() == paramg2.d()) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.i
 * JD-Core Version:    0.7.0.1
 */