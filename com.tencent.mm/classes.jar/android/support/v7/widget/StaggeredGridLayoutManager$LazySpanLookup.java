package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class StaggeredGridLayoutManager$LazySpanLookup
{
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> akE;
  int[] mData;
  
  public final void a(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem paramFullSpanItem)
  {
    if (this.akE == null) {
      this.akE = new ArrayList();
    }
    int j = this.akE.size();
    int i = 0;
    while (i < j)
    {
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.akE.get(i);
      if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
        this.akE.remove(i);
      }
      if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition)
      {
        this.akE.add(i, paramFullSpanItem);
        return;
      }
      i += 1;
    }
    this.akE.add(paramFullSpanItem);
  }
  
  final void ax(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {}
    do
    {
      return;
      ck(paramInt1 + paramInt2);
      System.arraycopy(this.mData, paramInt1 + paramInt2, this.mData, paramInt1, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, this.mData.length - paramInt2, this.mData.length, -1);
    } while (this.akE == null);
    int i = this.akE.size() - 1;
    label87:
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    if (i >= 0)
    {
      localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.akE.get(i);
      if (localFullSpanItem.mPosition >= paramInt1)
      {
        if (localFullSpanItem.mPosition >= paramInt1 + paramInt2) {
          break label144;
        }
        this.akE.remove(i);
      }
    }
    for (;;)
    {
      i -= 1;
      break label87;
      break;
      label144:
      localFullSpanItem.mPosition -= paramInt2;
    }
  }
  
  final void ay(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {}
    for (;;)
    {
      return;
      ck(paramInt1 + paramInt2);
      System.arraycopy(this.mData, paramInt1, this.mData, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
      if (this.akE != null)
      {
        int i = this.akE.size() - 1;
        while (i >= 0)
        {
          StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.akE.get(i);
          if (localFullSpanItem.mPosition >= paramInt1) {
            localFullSpanItem.mPosition += paramInt2;
          }
          i -= 1;
        }
      }
    }
  }
  
  final int ci(int paramInt)
  {
    if (this.akE != null)
    {
      int i = this.akE.size() - 1;
      while (i >= 0)
      {
        if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.akE.get(i)).mPosition >= paramInt) {
          this.akE.remove(i);
        }
        i -= 1;
      }
    }
    return cj(paramInt);
  }
  
  final int cj(int paramInt)
  {
    if (this.mData == null) {
      return -1;
    }
    if (paramInt >= this.mData.length) {
      return -1;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    int i;
    if (this.akE != null)
    {
      localFullSpanItem = cl(paramInt);
      if (localFullSpanItem != null) {
        this.akE.remove(localFullSpanItem);
      }
      int j = this.akE.size();
      i = 0;
      if (i >= j) {
        break label178;
      }
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.akE.get(i)).mPosition < paramInt) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.akE.get(i);
        this.akE.remove(i);
      }
      for (i = localFullSpanItem.mPosition;; i = -1)
      {
        if (i != -1) {
          break label162;
        }
        Arrays.fill(this.mData, paramInt, this.mData.length, -1);
        return this.mData.length;
        i += 1;
        break;
      }
      label162:
      Arrays.fill(this.mData, paramInt, i + 1, -1);
      return i + 1;
      label178:
      i = -1;
    }
  }
  
  final void ck(int paramInt)
  {
    if (this.mData == null)
    {
      this.mData = new int[Math.max(paramInt, 10) + 1];
      Arrays.fill(this.mData, -1);
    }
    while (paramInt < this.mData.length) {
      return;
    }
    int[] arrayOfInt = this.mData;
    int i = this.mData.length;
    while (i <= paramInt) {
      i *= 2;
    }
    this.mData = new int[i];
    System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
    Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
  }
  
  public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cl(int paramInt)
  {
    Object localObject;
    if (this.akE == null)
    {
      localObject = null;
      return localObject;
    }
    int i = this.akE.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label61;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.akE.get(i);
      localObject = localFullSpanItem;
      if (localFullSpanItem.mPosition == paramInt) {
        break;
      }
      i -= 1;
    }
    label61:
    return null;
  }
  
  final void clear()
  {
    if (this.mData != null) {
      Arrays.fill(this.mData, -1);
    }
    this.akE = null;
  }
  
  public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem p(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (this.akE == null)
    {
      localObject = null;
      return localObject;
    }
    int j = this.akE.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label112;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.akE.get(i);
      if (localFullSpanItem.mPosition >= paramInt2) {
        return null;
      }
      if (localFullSpanItem.mPosition >= paramInt1)
      {
        localObject = localFullSpanItem;
        if (paramInt3 == 0) {
          break;
        }
        localObject = localFullSpanItem;
        if (localFullSpanItem.akF == paramInt3) {
          break;
        }
        localObject = localFullSpanItem;
        if (localFullSpanItem.akH) {
          break;
        }
      }
      i += 1;
    }
    label112:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup
 * JD-Core Version:    0.7.0.1
 */