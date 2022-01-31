package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.MessageEvent;

public class zzbz
  extends zza
  implements MessageEvent
{
  public static final Parcelable.Creator<zzbz> CREATOR = new zzca();
  private final String mPath;
  private final int zzaKE;
  private final String zzacO;
  private final byte[] zzbeL;
  
  public zzbz(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.zzaKE = paramInt;
    this.mPath = paramString1;
    this.zzbeL = paramArrayOfByte;
    this.zzacO = paramString2;
  }
  
  public byte[] getData()
  {
    return this.zzbeL;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public int getRequestId()
  {
    return this.zzaKE;
  }
  
  public String getSourceNodeId()
  {
    return this.zzacO;
  }
  
  public String toString()
  {
    int i = this.zzaKE;
    String str = this.mPath;
    if (this.zzbeL == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.zzbeL.length))
    {
      localObject = String.valueOf(localObject);
      return String.valueOf(str).length() + 43 + String.valueOf(localObject).length() + "MessageEventParcelable[" + i + "," + str + ", size=" + (String)localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzca.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbz
 * JD-Core Version:    0.7.0.1
 */