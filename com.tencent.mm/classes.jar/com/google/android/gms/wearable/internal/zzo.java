package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzo
  extends zza
  implements CapabilityInfo
{
  public static final Parcelable.Creator<zzo> CREATOR = new zzp();
  private final String mName;
  private Set<Node> zzbTR;
  private final List<zzcc> zzbTU;
  private final Object zzrJ = new Object();
  
  public zzo(String paramString, List<zzcc> paramList)
  {
    this.mName = paramString;
    this.zzbTU = paramList;
    this.zzbTR = null;
    zzUr();
  }
  
  private void zzUr()
  {
    zzac.zzw(this.mName);
    zzac.zzw(this.zzbTU);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (zzo)paramObject;
      if (this.mName != null)
      {
        if (this.mName.equals(paramObject.mName)) {}
      }
      else {
        while (paramObject.mName != null) {
          return false;
        }
      }
      if (this.zzbTU == null) {
        break;
      }
    } while (this.zzbTU.equals(paramObject.zzbTU));
    for (;;)
    {
      return false;
      if (paramObject.zzbTU == null) {
        break;
      }
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public Set<Node> getNodes()
  {
    synchronized (this.zzrJ)
    {
      if (this.zzbTR == null) {
        this.zzbTR = new HashSet(this.zzbTU);
      }
      Set localSet = this.zzbTR;
      return localSet;
    }
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.mName != null) {}
    for (int i = this.mName.hashCode();; i = 0)
    {
      if (this.zzbTU != null) {
        j = this.zzbTU.hashCode();
      }
      return (i + 31) * 31 + j;
    }
  }
  
  public String toString()
  {
    String str1 = this.mName;
    String str2 = String.valueOf(this.zzbTU);
    return String.valueOf(str1).length() + 18 + String.valueOf(str2).length() + "CapabilityInfo{" + str1 + ", " + str2 + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
  
  public List<zzcc> zzUs()
  {
    return this.zzbTU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzo
 * JD-Core Version:    0.7.0.1
 */