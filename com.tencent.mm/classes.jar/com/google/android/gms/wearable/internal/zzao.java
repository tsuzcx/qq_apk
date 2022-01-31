package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzao
  extends zza
  implements DataItem
{
  public static final Parcelable.Creator<zzao> CREATOR = new zzap();
  private final Uri mUri;
  private final Map<String, DataItemAsset> zzbUv;
  private byte[] zzbeL;
  
  zzao(Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this.mUri = paramUri;
    paramUri = new HashMap();
    paramBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramUri.put(str, (DataItemAssetParcelable)paramBundle.getParcelable(str));
    }
    this.zzbUv = paramUri;
    this.zzbeL = paramArrayOfByte;
  }
  
  public Map<String, DataItemAsset> getAssets()
  {
    return this.zzbUv;
  }
  
  public byte[] getData()
  {
    return this.zzbeL;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataItem", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DataItemParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.zzbeL == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.zzbeL.length))
    {
      localObject = String.valueOf(localObject);
      localStringBuilder.append(String.valueOf(localObject).length() + 8 + ",dataSz=" + (String)localObject);
      int i = this.zzbUv.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      localObject = String.valueOf(this.mUri);
      localStringBuilder.append(String.valueOf(localObject).length() + 6 + ", uri=" + (String)localObject);
      if (paramBoolean) {
        break;
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("]\n  assets: ");
    localObject = this.zzbUv.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.valueOf(this.zzbUv.get(str1));
      localStringBuilder.append(String.valueOf(str1).length() + 7 + String.valueOf(str2).length() + "\n    " + str1 + ": " + str2);
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzap.zza(this, paramParcel, paramInt);
  }
  
  public zzao zzR(byte[] paramArrayOfByte)
  {
    this.zzbeL = paramArrayOfByte;
    return this;
  }
  
  public Bundle zzUf()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = this.zzbUv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putParcelable((String)localEntry.getKey(), new DataItemAssetParcelable((DataItemAsset)localEntry.getValue()));
    }
    return localBundle;
  }
  
  public zzao zzUx()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzao
 * JD-Core Version:    0.7.0.1
 */