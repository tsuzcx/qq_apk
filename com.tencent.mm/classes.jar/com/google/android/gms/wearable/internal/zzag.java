package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener;

final class zzag
  extends UnregisterListenerMethod<zzhg, CapabilityClient.OnCapabilityChangedListener>
{
  private final CapabilityClient.OnCapabilityChangedListener zzby;
  
  private zzag(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, ListenerHolder.ListenerKey<CapabilityClient.OnCapabilityChangedListener> paramListenerKey)
  {
    super(paramListenerKey);
    this.zzby = paramOnCapabilityChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzag
 * JD-Core Version:    0.7.0.1
 */