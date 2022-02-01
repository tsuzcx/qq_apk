package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageClient.OnMessageReceivedListener;

final class zzfc
  extends RegisterListenerMethod<zzhg, MessageClient.OnMessageReceivedListener>
{
  private final IntentFilter[] zzba;
  private final ListenerHolder<MessageApi.MessageListener> zzbz;
  private final MessageClient.OnMessageReceivedListener zzej;
  
  private zzfc(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener, IntentFilter[] paramArrayOfIntentFilter, ListenerHolder<MessageClient.OnMessageReceivedListener> paramListenerHolder)
  {
    super(paramListenerHolder);
    this.zzej = paramOnMessageReceivedListener;
    this.zzba = paramArrayOfIntentFilter;
    this.zzbz = paramListenerHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfc
 * JD-Core Version:    0.7.0.1
 */