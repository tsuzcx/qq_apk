package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.Node;

public class zzcc
  extends zza
  implements Node
{
  public static final Parcelable.Creator<zzcc> CREATOR = new zzcd();
  private final String zzGV;
  private final String zzakb;
  private final int zzbUR;
  private final boolean zzbUS;
  
  public zzcc(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.zzGV = paramString1;
    this.zzakb = paramString2;
    this.zzbUR = paramInt;
    this.zzbUS = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzcc)) {
      return false;
    }
    return ((zzcc)paramObject).zzGV.equals(this.zzGV);
  }
  
  public String getDisplayName()
  {
    return this.zzakb;
  }
  
  public int getHopCount()
  {
    return this.zzbUR;
  }
  
  public String getId()
  {
    return this.zzGV;
  }
  
  public int hashCode()
  {
    return this.zzGV.hashCode();
  }
  
  public boolean isNearby()
  {
    return this.zzbUS;
  }
  
  public String toString()
  {
    String str1 = this.zzakb;
    String str2 = this.zzGV;
    int i = this.zzbUR;
    boolean bool = this.zzbUS;
    return String.valueOf(str1).length() + 45 + String.valueOf(str2).length() + "Node{" + str1 + ", id=" + str2 + ", hops=" + i + ", isNearby=" + bool + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzcd.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcc
 * JD-Core Version:    0.7.0.1
 */