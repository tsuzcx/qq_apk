package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class PendantInfo$AnimationLruCache
  extends AvatarPendantManager.LruLinkedHashMap
{
  private static final long serialVersionUID = 1L;
  
  public PendantInfo$AnimationLruCache(PendantInfo paramPendantInfo, int paramInt)
  {
    super(paramInt);
  }
  
  public void clear()
  {
    Iterator localIterator = values().iterator();
    while (localIterator.hasNext()) {
      ((VipPendantDrawable)localIterator.next()).a();
    }
    super.clear();
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    if (size() > this.maxCapacity)
    {
      ((VipPendantDrawable)paramEntry.getValue()).a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo.AnimationLruCache
 * JD-Core Version:    0.7.0.1
 */