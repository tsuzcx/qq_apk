package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzeu
  implements MessageApi
{
  private static PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101273);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzex(paramGoogleApiClient, paramMessageListener, paramGoogleApiClient.registerListener(paramMessageListener), paramArrayOfIntentFilter, null));
    AppMethodBeat.o(101273);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    AppMethodBeat.i(101271);
    paramGoogleApiClient = zza(paramGoogleApiClient, paramMessageListener, new IntentFilter[] { zzgj.zzc("com.google.android.gms.wearable.MESSAGE_RECEIVED") });
    AppMethodBeat.o(101271);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(101272);
    Preconditions.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      paramGoogleApiClient = zza(paramGoogleApiClient, paramMessageListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", paramUri, paramInt) });
      AppMethodBeat.o(101272);
      return paramGoogleApiClient;
    }
  }
  
  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    AppMethodBeat.i(101274);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzew(this, paramGoogleApiClient, paramMessageListener));
    AppMethodBeat.o(101274);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101270);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzev(this, paramGoogleApiClient, paramString1, paramString2, paramArrayOfByte));
    AppMethodBeat.o(101270);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzeu
 * JD-Core Version:    0.7.0.1
 */