package com.tencent.mobileqq.bubble;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BubbleManager$LruLinkedHashMap
  extends LinkedHashMap
{
  private static final float a = 0.75F;
  private static final long serialVersionUID = 1L;
  private final Lock lock = new ReentrantLock();
  protected final int maxCapacity;
  
  public BubbleManager$LruLinkedHashMap(BubbleManager paramBubbleManager, int paramInt)
  {
    super(paramInt, 0.75F, true);
    this.maxCapacity = paramInt;
  }
  
  public Object get(Object paramObject)
  {
    try
    {
      this.lock.lock();
      paramObject = super.get(paramObject);
      return paramObject;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    try
    {
      this.lock.lock();
      paramObject1 = super.put(paramObject1, paramObject2);
      return paramObject1;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > this.maxCapacity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager.LruLinkedHashMap
 * JD-Core Version:    0.7.0.1
 */