package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Arrays;

public class Asset
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR = new zze();
  public Uri uri;
  private String zzbSP;
  public ParcelFileDescriptor zzbSQ;
  private byte[] zzbeL;
  
  Asset(byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri)
  {
    this.zzbeL = paramArrayOfByte;
    this.zzbSP = paramString;
    this.zzbSQ = paramParcelFileDescriptor;
    this.uri = paramUri;
  }
  
  public static Asset createFromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Asset data cannot be null");
    }
    return new Asset(paramArrayOfByte, null, null, null);
  }
  
  public static Asset createFromFd(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null) {
      throw new IllegalArgumentException("Asset fd cannot be null");
    }
    return new Asset(null, null, paramParcelFileDescriptor, null);
  }
  
  public static Asset createFromRef(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Asset digest cannot be null");
    }
    return new Asset(null, paramString, null, null);
  }
  
  public static Asset createFromUri(Uri paramUri)
  {
    if (paramUri == null) {
      throw new IllegalArgumentException("Asset uri cannot be null");
    }
    return new Asset(null, null, null, paramUri);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Asset)) {
        return false;
      }
      paramObject = (Asset)paramObject;
    } while ((Arrays.equals(this.zzbeL, paramObject.zzbeL)) && (zzaa.equal(this.zzbSP, paramObject.zzbSP)) && (zzaa.equal(this.zzbSQ, paramObject.zzbSQ)) && (zzaa.equal(this.uri, paramObject.uri)));
    return false;
  }
  
  public byte[] getData()
  {
    return this.zzbeL;
  }
  
  public String getDigest()
  {
    return this.zzbSP;
  }
  
  public ParcelFileDescriptor getFd()
  {
    return this.zzbSQ;
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
  
  public int hashCode()
  {
    return Arrays.deepHashCode(new Object[] { this.zzbeL, this.zzbSP, this.zzbSQ, this.uri });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.zzbSP == null) {
      localStringBuilder.append(", nodigest");
    }
    for (;;)
    {
      if (this.zzbeL != null)
      {
        localStringBuilder.append(", size=");
        localStringBuilder.append(this.zzbeL.length);
      }
      if (this.zzbSQ != null)
      {
        localStringBuilder.append(", fd=");
        localStringBuilder.append(this.zzbSQ);
      }
      if (this.uri != null)
      {
        localStringBuilder.append(", uri=");
        localStringBuilder.append(this.uri);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(", ");
      localStringBuilder.append(this.zzbSP);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.Asset
 * JD-Core Version:    0.7.0.1
 */