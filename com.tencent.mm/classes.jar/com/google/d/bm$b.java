package com.google.d;

import java.util.Iterator;
import java.util.Map.Entry;

final class bm$b<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> atq;
  
  public bm$b(Iterator<Map.Entry<K, Object>> paramIterator)
  {
    this.atq = paramIterator;
  }
  
  public final boolean hasNext()
  {
    return this.atq.hasNext();
  }
  
  public final void remove()
  {
    this.atq.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bm.b
 * JD-Core Version:    0.7.0.1
 */