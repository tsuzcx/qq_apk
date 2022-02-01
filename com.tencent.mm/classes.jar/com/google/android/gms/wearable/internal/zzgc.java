package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgc
  implements ChannelApi.ChannelListener
{
  private final String zzce;
  private final ChannelApi.ChannelListener zzeq;
  
  zzgc(String paramString, ChannelApi.ChannelListener paramChannelListener)
  {
    AppMethodBeat.i(101337);
    this.zzce = ((String)Preconditions.checkNotNull(paramString));
    this.zzeq = ((ChannelApi.ChannelListener)Preconditions.checkNotNull(paramChannelListener));
    AppMethodBeat.o(101337);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101342);
    if (this == paramObject)
    {
      AppMethodBeat.o(101342);
      return true;
    }
    if (!(paramObject instanceof zzgc))
    {
      AppMethodBeat.o(101342);
      return false;
    }
    paramObject = (zzgc)paramObject;
    if ((this.zzeq.equals(paramObject.zzeq)) && (this.zzce.equals(paramObject.zzce)))
    {
      AppMethodBeat.o(101342);
      return true;
    }
    AppMethodBeat.o(101342);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(101343);
    int i = this.zzce.hashCode();
    int j = this.zzeq.hashCode();
    AppMethodBeat.o(101343);
    return i * 31 + j;
  }
  
  public final void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101339);
    this.zzeq.onChannelClosed(paramChannel, paramInt1, paramInt2);
    AppMethodBeat.o(101339);
  }
  
  public final void onChannelOpened(Channel paramChannel)
  {
    AppMethodBeat.i(101338);
    this.zzeq.onChannelOpened(paramChannel);
    AppMethodBeat.o(101338);
  }
  
  public final void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101340);
    this.zzeq.onInputClosed(paramChannel, paramInt1, paramInt2);
    AppMethodBeat.o(101340);
  }
  
  public final void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101341);
    this.zzeq.onOutputClosed(paramChannel, paramInt1, paramInt2);
    AppMethodBeat.o(101341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgc
 * JD-Core Version:    0.7.0.1
 */