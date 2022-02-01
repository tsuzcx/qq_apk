package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzdd
  extends AbstractSafeParcelable
  implements DataItem
{
  public static final Parcelable.Creator<zzdd> CREATOR;
  private byte[] data;
  private final Uri uri;
  private final Map<String, DataItemAsset> zzdo;
  
  static
  {
    AppMethodBeat.i(101180);
    CREATOR = new zzde();
    AppMethodBeat.o(101180);
  }
  
  zzdd(Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101177);
    this.uri = paramUri;
    paramUri = new HashMap();
    paramBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramUri.put(str, (DataItemAssetParcelable)paramBundle.getParcelable(str));
    }
    this.zzdo = paramUri;
    this.data = paramArrayOfByte;
    AppMethodBeat.o(101177);
  }
  
  public final Map<String, DataItemAsset> getAssets()
  {
    return this.zzdo;
  }
  
  public final byte[] getData()
  {
    return this.data;
  }
  
  public final Uri getUri()
  {
    return this.uri;
  }
  
  public final boolean isDataValid()
  {
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101179);
    boolean bool = Log.isLoggable("DataItem", 3);
    StringBuilder localStringBuilder = new StringBuilder("DataItemParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.data == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.data.length))
    {
      localObject = String.valueOf(localObject);
      localStringBuilder.append(String.valueOf(localObject).length() + 8 + ",dataSz=" + (String)localObject);
      int i = this.zzdo.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      localObject = String.valueOf(this.uri);
      localStringBuilder.append(String.valueOf(localObject).length() + 6 + ", uri=" + (String)localObject);
      if (bool) {
        break;
      }
      localStringBuilder.append("]");
      localObject = localStringBuilder.toString();
      AppMethodBeat.o(101179);
      return localObject;
    }
    localStringBuilder.append("]\n  assets: ");
    localObject = this.zzdo.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.valueOf(this.zzdo.get(str1));
      localStringBuilder.append(String.valueOf(str1).length() + 7 + String.valueOf(str2).length() + "\n    " + str1 + ": " + str2);
    }
    localStringBuilder.append("\n  ]");
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(101179);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101178);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getUri(), paramInt, false);
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = this.zzdo.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putParcelable((String)localEntry.getKey(), new DataItemAssetParcelable((DataItemAsset)localEntry.getValue()));
    }
    SafeParcelWriter.writeBundle(paramParcel, 4, localBundle, false);
    SafeParcelWriter.writeByteArray(paramParcel, 5, getData(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(101178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdd
 * JD-Core Version:    0.7.0.1
 */