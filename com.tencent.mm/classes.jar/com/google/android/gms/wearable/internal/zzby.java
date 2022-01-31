package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzabh;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzby
  implements MessageApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return paramGoogleApiClient.zza(new zza(paramGoogleApiClient, paramMessageListener, paramGoogleApiClient.zzr(paramMessageListener), paramArrayOfIntentFilter, null));
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    return zza(paramGoogleApiClient, paramMessageListener, new IntentFilter[] { zzcv.zzip("com.google.android.gms.wearable.MESSAGE_RECEIVED") });
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, Uri paramUri, int paramInt)
  {
    if (paramUri != null)
    {
      bool = true;
      zzac.zzb(bool, "uri must not be null");
      if ((paramInt != 0) && (paramInt != 1)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "invalid filter type");
      return zza(paramGoogleApiClient, paramMessageListener, new IntentFilter[] { zzcv.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", paramUri, paramInt) });
      bool = false;
      break;
    }
  }
  
  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    return paramGoogleApiClient.zza(new zzby.2(this, paramGoogleApiClient, paramMessageListener));
  }
  
  public final PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return paramGoogleApiClient.zza(new zzby.1(this, paramGoogleApiClient, paramString1, paramString2, paramArrayOfByte));
  }
  
  private static final class zza
    extends zzm<Status>
  {
    private zzabh<MessageApi.MessageListener> zzaDf;
    private MessageApi.MessageListener zzbUM;
    private IntentFilter[] zzbUN;
    
    private zza(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, zzabh<MessageApi.MessageListener> paramzzabh, IntentFilter[] paramArrayOfIntentFilter)
    {
      super();
      this.zzbUM = ((MessageApi.MessageListener)zzac.zzw(paramMessageListener));
      this.zzaDf = ((zzabh)zzac.zzw(paramzzabh));
      this.zzbUN = ((IntentFilter[])zzac.zzw(paramArrayOfIntentFilter));
    }
    
    protected final void zza(zzcx paramzzcx)
    {
      paramzzcx.zza(this, this.zzbUM, this.zzaDf, this.zzbUN);
      this.zzbUM = null;
      this.zzaDf = null;
      this.zzbUN = null;
    }
    
    public final Status zzb(Status paramStatus)
    {
      this.zzbUM = null;
      this.zzaDf = null;
      this.zzbUN = null;
      return paramStatus;
    }
  }
  
  public static class zzb
    implements MessageApi.SendMessageResult
  {
    private final int zzaKE;
    private final Status zzair;
    
    public zzb(Status paramStatus, int paramInt)
    {
      this.zzair = paramStatus;
      this.zzaKE = paramInt;
    }
    
    public int getRequestId()
    {
      return this.zzaKE;
    }
    
    public Status getStatus()
    {
      return this.zzair;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzby
 * JD-Core Version:    0.7.0.1
 */