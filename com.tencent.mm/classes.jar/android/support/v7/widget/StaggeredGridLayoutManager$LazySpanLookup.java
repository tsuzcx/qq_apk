package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class StaggeredGridLayoutManager$LazySpanLookup
{
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> amX;
  int[] mData;
  
  private void aJ(int paramInt1, int paramInt2)
  {
    if (this.amX == null) {
      return;
    }
    int i = this.amX.size() - 1;
    label20:
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    if (i >= 0)
    {
      localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.amX.get(i);
      if (localFullSpanItem.mPosition >= paramInt1)
      {
        if (localFullSpanItem.mPosition >= paramInt1 + paramInt2) {
          break label77;
        }
        this.amX.remove(i);
      }
    }
    for (;;)
    {
      i -= 1;
      break label20;
      break;
      label77:
      localFullSpanItem.mPosition -= paramInt2;
    }
  }
  
  private void aL(int paramInt1, int paramInt2)
  {
    if (this.amX == null) {}
    for (;;)
    {
      return;
      int i = this.amX.size() - 1;
      while (i >= 0)
      {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.amX.get(i);
        if (localFullSpanItem.mPosition >= paramInt1) {
          localFullSpanItem.mPosition += paramInt2;
        }
        i -= 1;
      }
    }
  }
  
  private int cA(int paramInt)
  {
    if (this.amX == null) {
      return -1;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = cB(paramInt);
    if (localFullSpanItem != null) {
      this.amX.remove(localFullSpanItem);
    }
    int j = this.amX.size();
    int i = 0;
    if (i < j) {
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.amX.get(i)).mPosition < paramInt) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.amX.get(i);
        this.amX.remove(i);
        return localFullSpanItem.mPosition;
        i += 1;
        break;
      }
      return -1;
      i = -1;
    }
  }
  
  private int cy(int paramInt)
  {
    int i = this.mData.length;
    while (i <= paramInt) {
      i *= 2;
    }
    return i;
  }
  
  private void cz(int paramInt)
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
    this.mData = new int[cy(paramInt)];
    System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
    Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
  }
  
  final void a(int paramInt, StaggeredGridLayoutManager.b paramb)
  {
    cz(paramInt);
    this.mData[paramInt] = paramb.mIndex;
  }
  
  public final void a(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem paramFullSpanItem)
  {
    if (this.amX == null) {
      this.amX = new ArrayList();
    }
    int j = this.amX.size();
    int i = 0;
    while (i < j)
    {
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.amX.get(i);
      if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
        this.amX.remove(i);
      }
      if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition)
      {
        this.amX.add(i, paramFullSpanItem);
        return;
      }
      i += 1;
    }
    this.amX.add(paramFullSpanItem);
  }
  
  final void aI(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
      return;
    }
    cz(paramInt1 + paramInt2);
    int[] arrayOfInt1 = this.mData;
    int[] arrayOfInt2 = this.mData;
    System.arraycopy(arrayOfInt1, paramInt1 + paramInt2, arrayOfInt2, paramInt1, arrayOfInt2.length - paramInt1 - paramInt2);
    Arrays.fill(this.mData, this.mData.length - paramInt2, this.mData.length, -1);
    aJ(paramInt1, paramInt2);
  }
  
  final void aK(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
      return;
    }
    cz(paramInt1 + paramInt2);
    int[] arrayOfInt = this.mData;
    System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
    Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
    aL(paramInt1, paramInt2);
  }
  
  public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cB(int paramInt)
  {
    Object localObject;
    if (this.amX == null)
    {
      localObject = null;
      return localObject;
    }
    int i = this.amX.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label61;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.amX.get(i);
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
    this.amX = null;
  }
  
  final int cv(int paramInt)
  {
    if (this.amX != null)
    {
      int i = this.amX.size() - 1;
      while (i >= 0)
      {
        if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.amX.get(i)).mPosition >= paramInt) {
          this.amX.remove(i);
        }
        i -= 1;
      }
    }
    return cw(paramInt);
  }
  
  final int cw(int paramInt)
  {
    if (this.mData == null) {}
    while (paramInt >= this.mData.length) {
      return -1;
    }
    int i = cA(paramInt);
    if (i == -1)
    {
      int[] arrayOfInt = this.mData;
      Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
      return this.mData.length;
    }
    Arrays.fill(this.mData, paramInt, i + 1, -1);
    return i + 1;
  }
  
  final int cx(int paramInt)
  {
    if ((this.mData == null) || (paramInt >= this.mData.length)) {
      return -1;
    }
    return this.mData[paramInt];
  }
  
  public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem p(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (this.amX == null)
    {
      localObject = null;
      return localObject;
    }
    int j = this.amX.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label112;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.amX.get(i);
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
        if (localFullSpanItem.amY == paramInt3) {
          break;
        }
        localObject = localFullSpanItem;
        if (localFullSpanItem.ana) {
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