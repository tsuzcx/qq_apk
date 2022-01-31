package com.tencent.mars.smc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IDKey
  implements Parcelable
{
  public static final Parcelable.Creator<IDKey> CREATOR = new Parcelable.Creator()
  {
    public final IDKey createFromParcel(Parcel paramAnonymousParcel)
    {
      return new IDKey(paramAnonymousParcel);
    }
    
    public final IDKey[] newArray(int paramAnonymousInt)
    {
      return new IDKey[paramAnonymousInt];
    }
  };
  private long id;
  private long key;
  private long value;
  
  public IDKey()
  {
    this.id = 0L;
    this.key = 0L;
    this.value = 0L;
  }
  
  public IDKey(int paramInt1, int paramInt2, int paramInt3)
  {
    this.id = paramInt1;
    this.key = paramInt2;
    this.value = paramInt3;
  }
  
  public IDKey(long paramLong1, long paramLong2, long paramLong3)
  {
    this.id = paramLong1;
    this.key = paramLong2;
    this.value = paramLong3;
  }
  
  protected IDKey(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.key = paramParcel.readLong();
    this.value = paramParcel.readLong();
  }
  
  public long GetID()
  {
    return this.id;
  }
  
  public long GetKey()
  {
    return this.key;
  }
  
  public long GetValue()
  {
    return this.value;
  }
  
  public void SetID(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void SetKey(int paramInt)
  {
    this.key = paramInt;
  }
  
  public void SetValue(long paramLong)
  {
    this.value = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeLong(this.key);
    paramParcel.writeLong(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.smc.IDKey
 * JD-Core Version:    0.7.0.1
 */