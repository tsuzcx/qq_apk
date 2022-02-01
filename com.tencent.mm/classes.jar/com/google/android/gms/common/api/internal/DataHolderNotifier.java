package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
public abstract class DataHolderNotifier<L>
  implements ListenerHolder.Notifier<L>
{
  private final DataHolder mDataHolder;
  
  @KeepForSdk
  protected DataHolderNotifier(DataHolder paramDataHolder)
  {
    this.mDataHolder = paramDataHolder;
  }
  
  @KeepForSdk
  public final void notifyListener(L paramL)
  {
    notifyListener(paramL, this.mDataHolder);
  }
  
  @KeepForSdk
  protected abstract void notifyListener(L paramL, DataHolder paramDataHolder);
  
  @KeepForSdk
  public void onNotifyListenerFailed()
  {
    if (this.mDataHolder != null) {
      this.mDataHolder.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.DataHolderNotifier
 * JD-Core Version:    0.7.0.1
 */