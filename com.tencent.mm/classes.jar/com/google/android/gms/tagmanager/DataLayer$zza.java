package com.google.android.gms.tagmanager;

import java.util.Arrays;

final class DataLayer$zza
{
  public final Object mValue;
  public final String zzAX;
  
  DataLayer$zza(String paramString, Object paramObject)
  {
    this.zzAX = paramString;
    this.mValue = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zza)) {}
    do
    {
      return false;
      paramObject = (zza)paramObject;
    } while ((!this.zzAX.equals(paramObject.zzAX)) || (!this.mValue.equals(paramObject.mValue)));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Integer[] { Integer.valueOf(this.zzAX.hashCode()), Integer.valueOf(this.mValue.hashCode()) });
  }
  
  public final String toString()
  {
    String str1 = this.zzAX;
    String str2 = String.valueOf(this.mValue.toString());
    return String.valueOf(str1).length() + 13 + String.valueOf(str2).length() + "Key: " + str1 + " value: " + str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.DataLayer.zza
 * JD-Core Version:    0.7.0.1
 */