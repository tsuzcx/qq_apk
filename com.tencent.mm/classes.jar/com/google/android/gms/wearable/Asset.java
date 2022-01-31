package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

@SafeParcelable.Class(creator="AssetCreator")
@SafeParcelable.Reserved({1})
@VisibleForTesting
public class Asset
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR;
  @SafeParcelable.Field(getter="getData", id=2)
  private byte[] data;
  @SafeParcelable.Field(id=5)
  private Uri uri;
  @SafeParcelable.Field(getter="getDigest", id=3)
  private String zze;
  @SafeParcelable.Field(id=4)
  private ParcelFileDescriptor zzf;
  
  static
  {
    AppMethodBeat.i(70793);
    CREATOR = new zze();
    AppMethodBeat.o(70793);
  }
  
  @SafeParcelable.Constructor
  Asset(@SafeParcelable.Param(id=2) byte[] paramArrayOfByte, @SafeParcelable.Param(id=3) String paramString, @SafeParcelable.Param(id=4) ParcelFileDescriptor paramParcelFileDescriptor, @SafeParcelable.Param(id=5) Uri paramUri)
  {
    this.data = paramArrayOfByte;
    this.zze = paramString;
    this.zzf = paramParcelFileDescriptor;
    this.uri = paramUri;
  }
  
  @VisibleForTesting
  public static Asset createFromBytes(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70787);
    Asserts.checkNotNull(paramArrayOfByte);
    paramArrayOfByte = new Asset(paramArrayOfByte, null, null, null);
    AppMethodBeat.o(70787);
    return paramArrayOfByte;
  }
  
  @VisibleForTesting
  public static Asset createFromFd(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(70788);
    Asserts.checkNotNull(paramParcelFileDescriptor);
    paramParcelFileDescriptor = new Asset(null, null, paramParcelFileDescriptor, null);
    AppMethodBeat.o(70788);
    return paramParcelFileDescriptor;
  }
  
  public static Asset createFromRef(String paramString)
  {
    AppMethodBeat.i(70786);
    Asserts.checkNotNull(paramString);
    paramString = new Asset(null, paramString, null, null);
    AppMethodBeat.o(70786);
    return paramString;
  }
  
  @VisibleForTesting
  public static Asset createFromUri(Uri paramUri)
  {
    AppMethodBeat.i(70789);
    Asserts.checkNotNull(paramUri);
    paramUri = new Asset(null, null, null, paramUri);
    AppMethodBeat.o(70789);
    return paramUri;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70791);
    if (this == paramObject)
    {
      AppMethodBeat.o(70791);
      return true;
    }
    if (!(paramObject instanceof Asset))
    {
      AppMethodBeat.o(70791);
      return false;
    }
    paramObject = (Asset)paramObject;
    if ((Arrays.equals(this.data, paramObject.data)) && (Objects.equal(this.zze, paramObject.zze)) && (Objects.equal(this.zzf, paramObject.zzf)) && (Objects.equal(this.uri, paramObject.uri)))
    {
      AppMethodBeat.o(70791);
      return true;
    }
    AppMethodBeat.o(70791);
    return false;
  }
  
  public final byte[] getData()
  {
    return this.data;
  }
  
  public String getDigest()
  {
    return this.zze;
  }
  
  public ParcelFileDescriptor getFd()
  {
    return this.zzf;
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(70790);
    int i = Arrays.deepHashCode(new Object[] { this.data, this.zze, this.zzf, this.uri });
    AppMethodBeat.o(70790);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70792);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Asset[@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    if (this.zze == null) {
      ((StringBuilder)localObject).append(", nodigest");
    }
    for (;;)
    {
      if (this.data != null)
      {
        ((StringBuilder)localObject).append(", size=");
        ((StringBuilder)localObject).append(this.data.length);
      }
      if (this.zzf != null)
      {
        ((StringBuilder)localObject).append(", fd=");
        ((StringBuilder)localObject).append(this.zzf);
      }
      if (this.uri != null)
      {
        ((StringBuilder)localObject).append(", uri=");
        ((StringBuilder)localObject).append(this.uri);
      }
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(70792);
      return localObject;
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.zze);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70785);
    Asserts.checkNotNull(paramParcel);
    paramInt |= 0x1;
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeByteArray(paramParcel, 2, this.data, false);
    SafeParcelWriter.writeString(paramParcel, 3, getDigest(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzf, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, this.uri, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(70785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.Asset
 * JD-Core Version:    0.7.0.1
 */