package com.c.a.a.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e<K, V>
  extends a<K, V>
{
  private transient int com = 3;
  
  private e()
  {
    super(new HashMap());
  }
  
  public static <K, V> e<K, V> JV()
  {
    return new e();
  }
  
  final List<V> JE()
  {
    return new ArrayList(this.com);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.a.b.e
 * JD-Core Version:    0.7.0.1
 */