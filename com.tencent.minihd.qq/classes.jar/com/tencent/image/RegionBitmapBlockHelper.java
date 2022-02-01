package com.tencent.image;

import android.graphics.Rect;
import java.util.Iterator;
import java.util.LinkedList;

public class RegionBitmapBlockHelper
{
  static final int REGION_BLOCK_SIZE = 400;
  private Rect mImageRect;
  
  public RegionBitmapBlockHelper(Rect paramRect)
  {
    this.mImageRect = paramRect;
  }
  
  public LinkedList<Rect> getBlocks(Rect paramRect)
  {
    if ((paramRect == null) || (paramRect.isEmpty())) {
      paramRect = null;
    }
    int k;
    int m;
    int i;
    int n;
    LinkedList localLinkedList;
    do
    {
      return paramRect;
      k = paramRect.left / 400;
      m = paramRect.right / 400 + 1;
      i = paramRect.top / 400;
      n = paramRect.bottom / 400 + 1;
      localLinkedList = new LinkedList();
      paramRect = localLinkedList;
    } while (i >= n);
    int j = k;
    for (;;)
    {
      if (j >= m)
      {
        i += 1;
        break;
      }
      paramRect = new Rect();
      paramRect.left = (j * 400);
      paramRect.right = (paramRect.left + 400);
      paramRect.top = (i * 400);
      paramRect.bottom = (paramRect.top + 400);
      if ((j + 1 == m) || (i + 1 == n)) {
        paramRect.intersect(this.mImageRect);
      }
      localLinkedList.add(paramRect);
      j += 1;
    }
  }
  
  public LinkedList<Rect> getBlocksExceptRegion(Rect paramRect, LinkedList<Rect> paramLinkedList)
  {
    if ((paramRect == null) || (paramRect.isEmpty()))
    {
      paramLinkedList = null;
      return paramLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    for (;;)
    {
      paramLinkedList = localLinkedList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramLinkedList = (Rect)localIterator.next();
      if (!Rect.intersects(paramRect, paramLinkedList)) {
        localLinkedList.add(paramLinkedList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.image.RegionBitmapBlockHelper
 * JD-Core Version:    0.7.0.1
 */