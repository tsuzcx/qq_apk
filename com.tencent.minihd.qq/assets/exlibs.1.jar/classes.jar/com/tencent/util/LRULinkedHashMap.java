package com.tencent.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRULinkedHashMap
  extends LinkedHashMap
{
  private static final float a = 0.75F;
  private static final long serialVersionUID = 1L;
  private final int maxCapacity;
  
  public LRULinkedHashMap(int paramInt)
  {
    super(paramInt, 0.75F, true);
    this.maxCapacity = paramInt;
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > this.maxCapacity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.LRULinkedHashMap
 * JD-Core Version:    0.7.0.1
 */