package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhl
  implements ListenerHolder.Notifier<DataApi.DataListener>
{
  zzhl(DataHolder paramDataHolder) {}
  
  public final void onNotifyListenerFailed()
  {
    AppMethodBeat.i(101413);
    this.zzan.close();
    AppMethodBeat.o(101413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhl
 * JD-Core Version:    0.7.0.1
 */