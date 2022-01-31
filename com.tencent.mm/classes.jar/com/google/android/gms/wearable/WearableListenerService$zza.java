package com.google.android.gms.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class WearableListenerService$zza
  extends ChannelClient.ChannelCallback
{
  private WearableListenerService$zza(WearableListenerService paramWearableListenerService) {}
  
  public final void onChannelClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70915);
    this.zzak.onChannelClosed(paramChannel, paramInt1, paramInt2);
    AppMethodBeat.o(70915);
  }
  
  public final void onChannelOpened(ChannelClient.Channel paramChannel)
  {
    AppMethodBeat.i(70914);
    this.zzak.onChannelOpened(paramChannel);
    AppMethodBeat.o(70914);
  }
  
  public final void onInputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70916);
    this.zzak.onInputClosed(paramChannel, paramInt1, paramInt2);
    AppMethodBeat.o(70916);
  }
  
  public final void onOutputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70917);
    this.zzak.onOutputClosed(paramChannel, paramInt1, paramInt2);
    AppMethodBeat.o(70917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService.zza
 * JD-Core Version:    0.7.0.1
 */