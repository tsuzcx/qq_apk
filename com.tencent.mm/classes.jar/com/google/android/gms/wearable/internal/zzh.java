package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.zzb;

public class zzh
  extends zza
  implements zzb
{
  public static final Parcelable.Creator<zzh> CREATOR = new zzi();
  private final String mValue;
  private byte zzbTF;
  private final byte zzbTG;
  
  public zzh(byte paramByte1, byte paramByte2, String paramString)
  {
    this.zzbTF = paramByte1;
    this.zzbTG = paramByte2;
    this.mValue = paramString;
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
      paramObject = (zzh)paramObject;
      if (this.zzbTF != paramObject.zzbTF) {
        return false;
      }
      if (this.zzbTG != paramObject.zzbTG) {
        return false;
      }
    } while (this.mValue.equals(paramObject.mValue));
    return false;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  public int hashCode()
  {
    return ((this.zzbTF + 31) * 31 + this.zzbTG) * 31 + this.mValue.hashCode();
  }
  
  public String toString()
  {
    int i = this.zzbTF;
    int j = this.zzbTG;
    String str = this.mValue;
    return String.valueOf(str).length() + 73 + "AmsEntityUpdateParcelable{, mEntityId=" + i + ", mAttributeId=" + j + ", mValue='" + str + "'}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public byte zzUj()
  {
    return this.zzbTF;
  }
  
  public byte zzUk()
  {
    return this.zzbTG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzh
 * JD-Core Version:    0.7.0.1
 */