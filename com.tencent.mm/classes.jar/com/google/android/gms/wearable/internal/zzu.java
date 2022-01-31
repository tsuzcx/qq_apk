package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public class zzu
  extends zza
  implements Channel
{
  public static final Parcelable.Creator<zzu> CREATOR = new zzv();
  private final String mPath;
  private final String zzaiJ;
  private final String zzbSW;
  
  public zzu(String paramString1, String paramString2, String paramString3)
  {
    this.zzaiJ = ((String)zzac.zzw(paramString1));
    this.zzbSW = ((String)zzac.zzw(paramString2));
    this.mPath = ((String)zzac.zzw(paramString3));
  }
  
  private static zzb.zza<ChannelApi.ChannelListener> zza(String paramString, IntentFilter[] paramArrayOfIntentFilter)
  {
    return new zzu.7(paramString, paramArrayOfIntentFilter);
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    IntentFilter localIntentFilter = zzcv.zzip("com.google.android.gms.wearable.CHANNEL_EVENT");
    return zzb.zza(paramGoogleApiClient, zza(this.zzaiJ, new IntentFilter[] { localIntentFilter }), paramChannelListener);
  }
  
  public PendingResult<Status> close(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.zza(new zzu.1(this, paramGoogleApiClient));
  }
  
  public PendingResult<Status> close(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    return paramGoogleApiClient.zza(new zzu.2(this, paramGoogleApiClient, paramInt));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzu)) {
        return false;
      }
      paramObject = (zzu)paramObject;
    } while ((this.zzaiJ.equals(paramObject.zzaiJ)) && (zzaa.equal(paramObject.zzbSW, this.zzbSW)) && (zzaa.equal(paramObject.mPath, this.mPath)));
    return false;
  }
  
  public PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.zza(new zzu.3(this, paramGoogleApiClient));
  }
  
  public String getNodeId()
  {
    return this.zzbSW;
  }
  
  public PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.zza(new zzu.4(this, paramGoogleApiClient));
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public String getToken()
  {
    return this.zzaiJ;
  }
  
  public int hashCode()
  {
    return this.zzaiJ.hashCode();
  }
  
  public PendingResult<Status> receiveFile(GoogleApiClient paramGoogleApiClient, Uri paramUri, boolean paramBoolean)
  {
    zzac.zzb(paramGoogleApiClient, "client is null");
    zzac.zzb(paramUri, "uri is null");
    return paramGoogleApiClient.zza(new zzu.5(this, paramGoogleApiClient, paramUri, paramBoolean));
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    zzac.zzb(paramGoogleApiClient, "client is null");
    zzac.zzb(paramChannelListener, "listener is null");
    return paramGoogleApiClient.zza(new zzq.zzb(paramGoogleApiClient, paramChannelListener, this.zzaiJ));
  }
  
  public PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return sendFile(paramGoogleApiClient, paramUri, 0L, -1L);
  }
  
  public PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri, long paramLong1, long paramLong2)
  {
    zzac.zzb(paramGoogleApiClient, "client is null");
    zzac.zzb(this.zzaiJ, "token is null");
    zzac.zzb(paramUri, "uri is null");
    if (paramLong1 >= 0L)
    {
      bool = true;
      zzac.zzb(bool, "startOffset is negative: %s", new Object[] { Long.valueOf(paramLong1) });
      if ((paramLong2 < 0L) && (paramLong2 != -1L)) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "invalid length: %s", new Object[] { Long.valueOf(paramLong2) });
      return paramGoogleApiClient.zza(new zzu.6(this, paramGoogleApiClient, paramUri, paramLong1, paramLong2));
      bool = false;
      break;
    }
  }
  
  public String toString()
  {
    String str1 = this.zzaiJ;
    String str2 = this.zzbSW;
    String str3 = this.mPath;
    return String.valueOf(str1).length() + 43 + String.valueOf(str2).length() + String.valueOf(str3).length() + "ChannelImpl{, token='" + str1 + "', nodeId='" + str2 + "', path='" + str3 + "'}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzv.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzu
 * JD-Core Version:    0.7.0.1
 */