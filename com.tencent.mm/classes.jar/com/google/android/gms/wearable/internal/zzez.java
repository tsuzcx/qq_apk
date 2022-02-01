package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.core.f.f;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.MessageClient.OnMessageReceivedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzez
  extends MessageClient
{
  private final MessageApi zzei;
  
  public zzez(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, paramSettings);
    AppMethodBeat.i(101281);
    this.zzei = new zzeu();
    AppMethodBeat.o(101281);
  }
  
  public zzez(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, paramSettings);
    AppMethodBeat.i(101280);
    this.zzei = new zzeu();
    AppMethodBeat.o(101280);
  }
  
  private final Task<Void> zza(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101285);
    ListenerHolder localListenerHolder = ListenerHolders.createListenerHolder(paramOnMessageReceivedListener, getLooper(), "MessageListener");
    paramOnMessageReceivedListener = doRegisterEventListener(new zzfc(paramOnMessageReceivedListener, paramArrayOfIntentFilter, localListenerHolder, null), new zzfd(paramOnMessageReceivedListener, localListenerHolder.getListenerKey(), null));
    AppMethodBeat.o(101285);
    return paramOnMessageReceivedListener;
  }
  
  public final Task<Void> addListener(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener)
  {
    AppMethodBeat.i(101283);
    paramOnMessageReceivedListener = zza(paramOnMessageReceivedListener, new IntentFilter[] { zzgj.zzc("com.google.android.gms.wearable.MESSAGE_RECEIVED") });
    AppMethodBeat.o(101283);
    return paramOnMessageReceivedListener;
  }
  
  public final Task<Void> addListener(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(101284);
    f.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      paramOnMessageReceivedListener = zza(paramOnMessageReceivedListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", paramUri, paramInt) });
      AppMethodBeat.o(101284);
      return paramOnMessageReceivedListener;
    }
  }
  
  public final Task<Boolean> removeListener(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener)
  {
    AppMethodBeat.i(101286);
    paramOnMessageReceivedListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(paramOnMessageReceivedListener, getLooper(), "MessageListener").getListenerKey());
    AppMethodBeat.o(101286);
    return paramOnMessageReceivedListener;
  }
  
  public final Task<Integer> sendMessage(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101282);
    paramString1 = PendingResultUtil.toTask(this.zzei.sendMessage(asGoogleApiClient(), paramString1, paramString2, paramArrayOfByte), zzfa.zzbx);
    AppMethodBeat.o(101282);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzez
 * JD-Core Version:    0.7.0.1
 */