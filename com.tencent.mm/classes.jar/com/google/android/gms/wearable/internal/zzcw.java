package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.wearable.DataClient.OnDataChangedListener;

final class zzcw
  extends UnregisterListenerMethod<zzhg, DataClient.OnDataChangedListener>
{
  private final DataClient.OnDataChangedListener zzdk;
  
  private zzcw(DataClient.OnDataChangedListener paramOnDataChangedListener, ListenerHolder.ListenerKey<DataClient.OnDataChangedListener> paramListenerKey)
  {
    super(paramListenerKey);
    this.zzdk = paramOnDataChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcw
 * JD-Core Version:    0.7.0.1
 */