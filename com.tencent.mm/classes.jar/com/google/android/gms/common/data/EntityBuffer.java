package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class EntityBuffer<T>
  extends AbstractDataBuffer<T>
{
  private boolean zzoa = false;
  private ArrayList<Integer> zzob;
  
  protected EntityBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private final void zzck()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (this.zzoa) {
          break label204;
        }
        int j = this.mDataHolder.getCount();
        this.zzob = new ArrayList();
        if (j <= 0) {
          break label199;
        }
        this.zzob.add(Integer.valueOf(0));
        String str3 = getPrimaryDataMarkerColumn();
        i = this.mDataHolder.getWindowIndex(0);
        String str1 = this.mDataHolder.getString(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label199;
        }
        int k = this.mDataHolder.getWindowIndex(i);
        str2 = this.mDataHolder.getString(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException(String.valueOf(str3).length() + 78 + "Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        this.zzob.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label207;
        label199:
        this.zzoa = true;
        label204:
        return;
      }
      label207:
      i += 1;
    }
  }
  
  public final T get(int paramInt)
  {
    zzck();
    return getEntry(zzi(paramInt), getChildCount(paramInt));
  }
  
  protected int getChildCount(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == this.zzob.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == this.zzob.size() - 1) {}
    for (int i = this.mDataHolder.getCount() - ((Integer)this.zzob.get(paramInt)).intValue();; i = ((Integer)this.zzob.get(paramInt + 1)).intValue() - ((Integer)this.zzob.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = zzi(paramInt);
      int k = this.mDataHolder.getWindowIndex(paramInt);
      String str = getChildDataMarkerColumn();
      j = i;
      if (str == null) {
        break;
      }
      j = i;
      if (this.mDataHolder.getString(str, paramInt, k) != null) {
        break;
      }
      return 0;
    }
  }
  
  protected String getChildDataMarkerColumn()
  {
    return null;
  }
  
  public int getCount()
  {
    zzck();
    return this.zzob.size();
  }
  
  protected abstract T getEntry(int paramInt1, int paramInt2);
  
  protected abstract String getPrimaryDataMarkerColumn();
  
  final int zzi(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.zzob.size())) {
      throw new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.zzob.get(paramInt)).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.data.EntityBuffer
 * JD-Core Version:    0.7.0.1
 */