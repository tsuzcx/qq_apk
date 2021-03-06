package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;

final class zzau
  extends UnregisterListenerMethod<zzhg, ChannelClient.ChannelCallback>
{
  private final String zzce;
  private final ChannelApi.ChannelListener zzcf;
  
  zzau(ChannelApi.ChannelListener paramChannelListener, String paramString, ListenerHolder.ListenerKey<ChannelClient.ChannelCallback> paramListenerKey)
  {
    super(paramListenerKey);
    this.zzcf = paramChannelListener;
    this.zzce = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzau
 * JD-Core Version:    0.7.0.1
 */