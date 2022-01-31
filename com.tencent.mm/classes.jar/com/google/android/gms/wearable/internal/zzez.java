package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.e.l;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.MessageClient.OnMessageReceivedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzez
  extends MessageClient
{
  @VisibleForTesting
  private final MessageApi zzei;
  
  public zzez(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, paramSettings);
    AppMethodBeat.i(71298);
    this.zzei = new zzeu();
    AppMethodBeat.o(71298);
  }
  
  public zzez(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, paramSettings);
    AppMethodBeat.i(71297);
    this.zzei = new zzeu();
    AppMethodBeat.o(71297);
  }
  
  private final Task<Void> zza(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(71302);
    ListenerHolder localListenerHolder = ListenerHolders.createListenerHolder(paramOnMessageReceivedListener, getLooper(), "MessageListener");
    paramOnMessageReceivedListener = doRegisterEventListener(new zzfc(paramOnMessageReceivedListener, paramArrayOfIntentFilter, localListenerHolder, null), new zzfd(paramOnMessageReceivedListener, localListenerHolder.getListenerKey(), null));
    AppMethodBeat.o(71302);
    return paramOnMessageReceivedListener;
  }
  
  public final Task<Void> addListener(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener)
  {
    AppMethodBeat.i(71300);
    paramOnMessageReceivedListener = zza(paramOnMessageReceivedListener, new IntentFilter[] { zzgj.zzc("com.google.android.gms.wearable.MESSAGE_RECEIVED") });
    AppMethodBeat.o(71300);
    return paramOnMessageReceivedListener;
  }
  
  public final Task<Void> addListener(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(71301);
    l.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      paramOnMessageReceivedListener = zza(paramOnMessageReceivedListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", paramUri, paramInt) });
      AppMethodBeat.o(71301);
      return paramOnMessageReceivedListener;
    }
  }
  
  public final Task<Boolean> removeListener(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener)
  {
    AppMethodBeat.i(71303);
    paramOnMessageReceivedListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(paramOnMessageReceivedListener, getLooper(), "MessageListener").getListenerKey());
    AppMethodBeat.o(71303);
    return paramOnMessageReceivedListener;
  }
  
  public final Task<Integer> sendMessage(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71299);
    paramString1 = PendingResultUtil.toTask(this.zzei.sendMessage(asGoogleApiClient(), paramString1, paramString2, paramArrayOfByte), zzfa.zzbx);
    AppMethodBeat.o(71299);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzez
 * JD-Core Version:    0.7.0.1
 */