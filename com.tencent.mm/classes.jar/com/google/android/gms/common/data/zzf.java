package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T>
  extends AbstractDataBuffer<T>
{
  private boolean zzaEc = false;
  private ArrayList<Integer> zzaEd;
  
  public zzf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void zzxo()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (this.zzaEc) {
          break label204;
        }
        int j = this.zzaBi.getCount();
        this.zzaEd = new ArrayList();
        if (j <= 0) {
          break label199;
        }
        this.zzaEd.add(Integer.valueOf(0));
        String str3 = zzxn();
        i = this.zzaBi.zzcI(0);
        String str1 = this.zzaBi.zzd(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label199;
        }
        int k = this.zzaBi.zzcI(i);
        str2 = this.zzaBi.zzd(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException(String.valueOf(str3).length() + 78 + "Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        this.zzaEd.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label207;
        label199:
        this.zzaEc = true;
        label204:
        return;
      }
      label207:
      i += 1;
    }
  }
  
  public final T get(int paramInt)
  {
    zzxo();
    return zzo(zzcM(paramInt), zzcN(paramInt));
  }
  
  public int getCount()
  {
    zzxo();
    return this.zzaEd.size();
  }
  
  int zzcM(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.zzaEd.size())) {
      throw new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.zzaEd.get(paramInt)).intValue();
  }
  
  protected int zzcN(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == this.zzaEd.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == this.zzaEd.size() - 1) {}
    for (int i = this.zzaBi.getCount() - ((Integer)this.zzaEd.get(paramInt)).intValue();; i = ((Integer)this.zzaEd.get(paramInt + 1)).intValue() - ((Integer)this.zzaEd.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = zzcM(paramInt);
      int k = this.zzaBi.zzcI(paramInt);
      String str = zzxp();
      j = i;
      if (str == null) {
        break;
      }
      j = i;
      if (this.zzaBi.zzd(str, paramInt, k) != null) {
        break;
      }
      return 0;
    }
  }
  
  public abstract T zzo(int paramInt1, int paramInt2);
  
  public abstract String zzxn();
  
  protected String zzxp()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.data.zzf
 * JD-Core Version:    0.7.0.1
 */