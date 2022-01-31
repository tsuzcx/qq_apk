package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PutDataRequest
  extends zza
{
  public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzh();
  public static final String WEAR_URI_SCHEME = "wear";
  private static final long zzbSZ = TimeUnit.MINUTES.toMillis(30L);
  private static final Random zzbTa = new SecureRandom();
  private final Uri mUri;
  private final Bundle zzbTb;
  private long zzbTc;
  private byte[] zzbeL;
  
  private PutDataRequest(Uri paramUri)
  {
    this(paramUri, new Bundle(), null, zzbSZ);
  }
  
  PutDataRequest(Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte, long paramLong)
  {
    this.mUri = paramUri;
    this.zzbTb = paramBundle;
    this.zzbTb.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    this.zzbeL = paramArrayOfByte;
    this.zzbTc = paramLong;
  }
  
  public static PutDataRequest create(String paramString)
  {
    return zzy(zzin(paramString));
  }
  
  public static PutDataRequest createFromDataItem(DataItem paramDataItem)
  {
    PutDataRequest localPutDataRequest = zzy(paramDataItem.getUri());
    Iterator localIterator = paramDataItem.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((DataItemAsset)localEntry.getValue()).getId() == null)
      {
        paramDataItem = String.valueOf((String)localEntry.getKey());
        if (paramDataItem.length() != 0) {}
        for (paramDataItem = "Cannot create an asset for a put request without a digest: ".concat(paramDataItem);; paramDataItem = new String("Cannot create an asset for a put request without a digest: ")) {
          throw new IllegalStateException(paramDataItem);
        }
      }
      localPutDataRequest.putAsset((String)localEntry.getKey(), Asset.createFromRef(((DataItemAsset)localEntry.getValue()).getId()));
    }
    localPutDataRequest.setData(paramDataItem.getData());
    return localPutDataRequest;
  }
  
  public static PutDataRequest createWithAutoAppendedId(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (!paramString.endsWith("/")) {
      localStringBuilder.append("/");
    }
    localStringBuilder.append("PN").append(zzbTa.nextLong());
    return new PutDataRequest(zzin(localStringBuilder.toString()));
  }
  
  private static Uri zzin(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("An empty path was supplied.");
    }
    if (!paramString.startsWith("/")) {
      throw new IllegalArgumentException("A path must start with a single / .");
    }
    if (paramString.startsWith("//")) {
      throw new IllegalArgumentException("A path must start with a single / .");
    }
    return new Uri.Builder().scheme("wear").path(paramString).build();
  }
  
  public static PutDataRequest zzy(Uri paramUri)
  {
    return new PutDataRequest(paramUri);
  }
  
  public Asset getAsset(String paramString)
  {
    return (Asset)this.zzbTb.getParcelable(paramString);
  }
  
  public Map<String, Asset> getAssets()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzbTb.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, (Asset)this.zzbTb.getParcelable(str));
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public byte[] getData()
  {
    return this.zzbeL;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean hasAsset(String paramString)
  {
    return this.zzbTb.containsKey(paramString);
  }
  
  public boolean isUrgent()
  {
    return this.zzbTc == 0L;
  }
  
  public PutDataRequest putAsset(String paramString, Asset paramAsset)
  {
    zzac.zzw(paramString);
    zzac.zzw(paramAsset);
    this.zzbTb.putParcelable(paramString, paramAsset);
    return this;
  }
  
  public PutDataRequest removeAsset(String paramString)
  {
    this.zzbTb.remove(paramString);
    return this;
  }
  
  public PutDataRequest setData(byte[] paramArrayOfByte)
  {
    this.zzbeL = paramArrayOfByte;
    return this;
  }
  
  public PutDataRequest setUrgent()
  {
    this.zzbTc = 0L;
    return this;
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataMap", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("PutDataRequest[");
    if (this.zzbeL == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.zzbeL.length))
    {
      localObject = String.valueOf(localObject);
      localStringBuilder.append(String.valueOf(localObject).length() + 7 + "dataSz=" + (String)localObject);
      int i = this.zzbTb.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      localObject = String.valueOf(this.mUri);
      localStringBuilder.append(String.valueOf(localObject).length() + 6 + ", uri=" + (String)localObject);
      long l = this.zzbTc;
      localStringBuilder.append(35 + ", syncDeadline=" + l);
      if (paramBoolean) {
        break;
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("]\n  assets: ");
    localObject = this.zzbTb.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.valueOf(this.zzbTb.getParcelable(str1));
      localStringBuilder.append(String.valueOf(str1).length() + 7 + String.valueOf(str2).length() + "\n    " + str1 + ": " + str2);
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public Bundle zzUf()
  {
    return this.zzbTb;
  }
  
  public long zzUg()
  {
    return this.zzbTc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataRequest
 * JD-Core Version:    0.7.0.1
 */