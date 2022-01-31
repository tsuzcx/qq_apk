package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="PutDataRequestCreator")
@SafeParcelable.Reserved({1})
@VisibleForTesting
public class PutDataRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PutDataRequest> CREATOR;
  public static final String WEAR_URI_SCHEME = "wear";
  private static final long zzt;
  private static final Random zzu;
  @SafeParcelable.Field(getter="getData", id=5)
  private byte[] data;
  @SafeParcelable.Field(getter="getUri", id=2)
  private final Uri uri;
  @SafeParcelable.Field(getter="getAssetsInternal", id=4)
  private final Bundle zzv;
  @SafeParcelable.Field(getter="getSyncDeadline", id=6)
  private long zzw;
  
  static
  {
    AppMethodBeat.i(70888);
    CREATOR = new zzh();
    zzt = TimeUnit.MINUTES.toMillis(30L);
    zzu = new SecureRandom();
    AppMethodBeat.o(70888);
  }
  
  private PutDataRequest(Uri paramUri)
  {
    this(paramUri, new Bundle(), null, zzt);
    AppMethodBeat.i(70874);
    AppMethodBeat.o(70874);
  }
  
  @SafeParcelable.Constructor
  PutDataRequest(@SafeParcelable.Param(id=2) Uri paramUri, @SafeParcelable.Param(id=4) Bundle paramBundle, @SafeParcelable.Param(id=5) byte[] paramArrayOfByte, @SafeParcelable.Param(id=6) long paramLong)
  {
    AppMethodBeat.i(70873);
    this.uri = paramUri;
    this.zzv = paramBundle;
    this.zzv.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    this.data = paramArrayOfByte;
    this.zzw = paramLong;
    AppMethodBeat.o(70873);
  }
  
  public static PutDataRequest create(String paramString)
  {
    AppMethodBeat.i(70879);
    Asserts.checkNotNull(paramString, "path must not be null");
    paramString = zza(zza(paramString));
    AppMethodBeat.o(70879);
    return paramString;
  }
  
  public static PutDataRequest createFromDataItem(DataItem paramDataItem)
  {
    AppMethodBeat.i(70876);
    Asserts.checkNotNull(paramDataItem, "source must not be null");
    PutDataRequest localPutDataRequest = zza(paramDataItem.getUri());
    Iterator localIterator = paramDataItem.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((DataItemAsset)localEntry.getValue()).getId() == null)
      {
        paramDataItem = String.valueOf((String)localEntry.getKey());
        if (paramDataItem.length() != 0) {}
        for (paramDataItem = "Cannot create an asset for a put request without a digest: ".concat(paramDataItem);; paramDataItem = new String("Cannot create an asset for a put request without a digest: "))
        {
          paramDataItem = new IllegalStateException(paramDataItem);
          AppMethodBeat.o(70876);
          throw paramDataItem;
        }
      }
      localPutDataRequest.putAsset((String)localEntry.getKey(), Asset.createFromRef(((DataItemAsset)localEntry.getValue()).getId()));
    }
    localPutDataRequest.setData(paramDataItem.getData());
    AppMethodBeat.o(70876);
    return localPutDataRequest;
  }
  
  public static PutDataRequest createWithAutoAppendedId(String paramString)
  {
    AppMethodBeat.i(70878);
    Asserts.checkNotNull(paramString, "pathPrefix must not be null");
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (!paramString.endsWith("/")) {
      localStringBuilder.append("/");
    }
    localStringBuilder.append("PN").append(zzu.nextLong());
    paramString = new PutDataRequest(zza(localStringBuilder.toString()));
    AppMethodBeat.o(70878);
    return paramString;
  }
  
  private static Uri zza(String paramString)
  {
    AppMethodBeat.i(70880);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("An empty path was supplied.");
      AppMethodBeat.o(70880);
      throw paramString;
    }
    if (!paramString.startsWith("/"))
    {
      paramString = new IllegalArgumentException("A path must start with a single / .");
      AppMethodBeat.o(70880);
      throw paramString;
    }
    if (paramString.startsWith("//"))
    {
      paramString = new IllegalArgumentException("A path must start with a single / .");
      AppMethodBeat.o(70880);
      throw paramString;
    }
    paramString = new Uri.Builder().scheme("wear").path(paramString).build();
    AppMethodBeat.o(70880);
    return paramString;
  }
  
  public static PutDataRequest zza(Uri paramUri)
  {
    AppMethodBeat.i(70877);
    Asserts.checkNotNull(paramUri, "uri must not be null");
    paramUri = new PutDataRequest(paramUri);
    AppMethodBeat.o(70877);
    return paramUri;
  }
  
  @VisibleForTesting
  public Asset getAsset(String paramString)
  {
    AppMethodBeat.i(70882);
    Asserts.checkNotNull(paramString, "key must not be null");
    paramString = (Asset)this.zzv.getParcelable(paramString);
    AppMethodBeat.o(70882);
    return paramString;
  }
  
  public Map<String, Asset> getAssets()
  {
    AppMethodBeat.i(70881);
    Object localObject = new HashMap();
    Iterator localIterator = this.zzv.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((HashMap)localObject).put(str, (Asset)this.zzv.getParcelable(str));
    }
    localObject = Collections.unmodifiableMap((Map)localObject);
    AppMethodBeat.o(70881);
    return localObject;
  }
  
  @VisibleForTesting
  public byte[] getData()
  {
    return this.data;
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
  
  public boolean hasAsset(String paramString)
  {
    AppMethodBeat.i(70883);
    Asserts.checkNotNull(paramString, "key must not be null");
    boolean bool = this.zzv.containsKey(paramString);
    AppMethodBeat.o(70883);
    return bool;
  }
  
  public boolean isUrgent()
  {
    return this.zzw == 0L;
  }
  
  public PutDataRequest putAsset(String paramString, Asset paramAsset)
  {
    AppMethodBeat.i(70884);
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramAsset);
    this.zzv.putParcelable(paramString, paramAsset);
    AppMethodBeat.o(70884);
    return this;
  }
  
  public PutDataRequest removeAsset(String paramString)
  {
    AppMethodBeat.i(70885);
    Asserts.checkNotNull(paramString, "key must not be null");
    this.zzv.remove(paramString);
    AppMethodBeat.o(70885);
    return this;
  }
  
  public PutDataRequest setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    return this;
  }
  
  public PutDataRequest setUrgent()
  {
    this.zzw = 0L;
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70886);
    String str = toString(Log.isLoggable("DataMap", 3));
    AppMethodBeat.o(70886);
    return str;
  }
  
  public String toString(boolean paramBoolean)
  {
    AppMethodBeat.i(70887);
    StringBuilder localStringBuilder = new StringBuilder("PutDataRequest[");
    if (this.data == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.data.length))
    {
      localObject = String.valueOf(localObject);
      localStringBuilder.append(String.valueOf(localObject).length() + 7 + "dataSz=" + (String)localObject);
      int i = this.zzv.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      localObject = String.valueOf(this.uri);
      localStringBuilder.append(String.valueOf(localObject).length() + 6 + ", uri=" + (String)localObject);
      long l = this.zzw;
      localStringBuilder.append(35 + ", syncDeadline=" + l);
      if (paramBoolean) {
        break;
      }
      localStringBuilder.append("]");
      localObject = localStringBuilder.toString();
      AppMethodBeat.o(70887);
      return localObject;
    }
    localStringBuilder.append("]\n  assets: ");
    localObject = this.zzv.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.valueOf(this.zzv.getParcelable(str1));
      localStringBuilder.append(String.valueOf(str1).length() + 7 + String.valueOf(str2).length() + "\n    " + str1 + ": " + str2);
    }
    localStringBuilder.append("\n  ]");
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(70887);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70875);
    Asserts.checkNotNull(paramParcel, "dest must not be null");
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getUri(), paramInt, false);
    SafeParcelWriter.writeBundle(paramParcel, 4, this.zzv, false);
    SafeParcelWriter.writeByteArray(paramParcel, 5, getData(), false);
    SafeParcelWriter.writeLong(paramParcel, 6, this.zzw);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(70875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataRequest
 * JD-Core Version:    0.7.0.1
 */