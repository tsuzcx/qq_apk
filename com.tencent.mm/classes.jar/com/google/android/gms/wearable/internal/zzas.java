package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzas
  implements ChannelApi.ChannelListener
{
  private final ChannelClient.ChannelCallback zzch;
  
  public zzas(ChannelClient.ChannelCallback paramChannelCallback)
  {
    this.zzch = paramChannelCallback;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101017);
    if (this == paramObject)
    {
      AppMethodBeat.o(101017);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(101017);
      return false;
    }
    paramObject = (zzas)paramObject;
    boolean bool = this.zzch.equals(paramObject.zzch);
    AppMethodBeat.o(101017);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(101018);
    int i = this.zzch.hashCode();
    AppMethodBeat.o(101018);
    return i;
  }
  
  public final void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101014);
    this.zzch.onChannelClosed(zzao.zzb(paramChannel), paramInt1, paramInt2);
    AppMethodBeat.o(101014);
  }
  
  public final void onChannelOpened(Channel paramChannel)
  {
    AppMethodBeat.i(101013);
    this.zzch.onChannelOpened(zzao.zzb(paramChannel));
    AppMethodBeat.o(101013);
  }
  
  public final void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101015);
    this.zzch.onInputClosed(zzao.zzb(paramChannel), paramInt1, paramInt2);
    AppMethodBeat.o(101015);
  }
  
  public final void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101016);
    this.zzch.onOutputClosed(zzao.zzb(paramChannel), paramInt1, paramInt2);
    AppMethodBeat.o(101016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzas
 * JD-Core Version:    0.7.0.1
 */