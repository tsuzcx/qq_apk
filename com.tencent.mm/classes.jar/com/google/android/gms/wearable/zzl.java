package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl
  implements Runnable
{
  zzl(WearableListenerService.zzd paramzzd, DataHolder paramDataHolder) {}
  
  public final void run()
  {
    AppMethodBeat.i(101465);
    DataEventBuffer localDataEventBuffer = new DataEventBuffer(this.zzan);
    try
    {
      this.zzao.zzak.onDataChanged(localDataEventBuffer);
      return;
    }
    finally
    {
      localDataEventBuffer.release();
      AppMethodBeat.o(101465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.zzl
 * JD-Core Version:    0.7.0.1
 */