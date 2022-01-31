package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient.Channel;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="ChannelImplCreator")
@SafeParcelable.Reserved({1})
public final class zzay
  extends AbstractSafeParcelable
  implements Channel, ChannelClient.Channel
{
  public static final Parcelable.Creator<zzay> CREATOR;
  @SafeParcelable.Field(getter="getToken", id=2)
  private final String zzce;
  @SafeParcelable.Field(getter="getPath", id=4)
  private final String zzcl;
  @SafeParcelable.Field(getter="getNodeId", id=3)
  private final String zzo;
  
  static
  {
    AppMethodBeat.i(71057);
    CREATOR = new zzbi();
    AppMethodBeat.o(71057);
  }
  
  @SafeParcelable.Constructor
  public zzay(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3)
  {
    AppMethodBeat.i(71043);
    this.zzce = ((String)Preconditions.checkNotNull(paramString1));
    this.zzo = ((String)Preconditions.checkNotNull(paramString2));
    this.zzcl = ((String)Preconditions.checkNotNull(paramString3));
    AppMethodBeat.o(71043);
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    AppMethodBeat.i(71055);
    IntentFilter localIntentFilter = zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT");
    paramGoogleApiClient = zzb.zza(paramGoogleApiClient, new zzbf(this.zzce, new IntentFilter[] { localIntentFilter }), paramChannelListener);
    AppMethodBeat.o(71055);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> close(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(71048);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzaz(this, paramGoogleApiClient));
    AppMethodBeat.o(71048);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> close(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    AppMethodBeat.i(71049);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzba(this, paramGoogleApiClient, paramInt));
    AppMethodBeat.o(71049);
    return paramGoogleApiClient;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(71046);
    if (paramObject == this)
    {
      AppMethodBeat.o(71046);
      return true;
    }
    if (!(paramObject instanceof zzay))
    {
      AppMethodBeat.o(71046);
      return false;
    }
    paramObject = (zzay)paramObject;
    if ((this.zzce.equals(paramObject.zzce)) && (Objects.equal(paramObject.zzo, this.zzo)) && (Objects.equal(paramObject.zzcl, this.zzcl)))
    {
      AppMethodBeat.o(71046);
      return true;
    }
    AppMethodBeat.o(71046);
    return false;
  }
  
  public final PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(71050);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzbb(this, paramGoogleApiClient));
    AppMethodBeat.o(71050);
    return paramGoogleApiClient;
  }
  
  public final String getNodeId()
  {
    return this.zzo;
  }
  
  public final PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(71051);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzbc(this, paramGoogleApiClient));
    AppMethodBeat.o(71051);
    return paramGoogleApiClient;
  }
  
  public final String getPath()
  {
    return this.zzcl;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(71047);
    int i = this.zzce.hashCode();
    AppMethodBeat.o(71047);
    return i;
  }
  
  public final PendingResult<Status> receiveFile(GoogleApiClient paramGoogleApiClient, Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(71052);
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(paramUri, "uri is null");
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzbd(this, paramGoogleApiClient, paramUri, paramBoolean));
    AppMethodBeat.o(71052);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    AppMethodBeat.i(71056);
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(paramChannelListener, "listener is null");
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzan(paramGoogleApiClient, paramChannelListener, this.zzce));
    AppMethodBeat.o(71056);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    AppMethodBeat.i(71053);
    paramGoogleApiClient = sendFile(paramGoogleApiClient, paramUri, 0L, -1L);
    AppMethodBeat.o(71053);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(71054);
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(this.zzce, "token is null");
    Preconditions.checkNotNull(paramUri, "uri is null");
    if (paramLong1 >= 0L)
    {
      bool = true;
      Preconditions.checkArgument(bool, "startOffset is negative: %s", new Object[] { Long.valueOf(paramLong1) });
      if ((paramLong2 < 0L) && (paramLong2 != -1L)) {
        break label125;
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid length: %s", new Object[] { Long.valueOf(paramLong2) });
      paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzbe(this, paramGoogleApiClient, paramUri, paramLong1, paramLong2));
      AppMethodBeat.o(71054);
      return paramGoogleApiClient;
      bool = false;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(71045);
    Object localObject = this.zzce.toCharArray();
    int k = localObject.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      i += localObject[j];
      j += 1;
    }
    String str1 = this.zzce.trim();
    j = str1.length();
    localObject = str1;
    if (j > 25)
    {
      localObject = str1.substring(0, 10);
      str1 = str1.substring(j - 10, j);
      localObject = String.valueOf(localObject).length() + 16 + String.valueOf(str1).length() + (String)localObject + "..." + str1 + "::" + i;
    }
    str1 = this.zzo;
    String str2 = this.zzcl;
    localObject = String.valueOf(localObject).length() + 31 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Channel{token=" + (String)localObject + ", nodeId=" + str1 + ", path=" + str2 + "}";
    AppMethodBeat.o(71045);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(71044);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzce, false);
    SafeParcelWriter.writeString(paramParcel, 3, getNodeId(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getPath(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(71044);
  }
  
  public final String zzc()
  {
    return this.zzce;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzay
 * JD-Core Version:    0.7.0.1
 */