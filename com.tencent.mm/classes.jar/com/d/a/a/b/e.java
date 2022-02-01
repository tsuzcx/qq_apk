package com.d.a.a.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e<K, V>
  extends a<K, V>
{
  private transient int bVN = 3;
  
  private e()
  {
    super(new HashMap());
  }
  
  public static <K, V> e<K, V> zR()
  {
    return new e();
  }
  
  final List<V> zA()
  {
    return new ArrayList(this.bVN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.b.e
 * JD-Core Version:    0.7.0.1
 */