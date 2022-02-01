package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

final class zzam
  implements ChannelApi.OpenChannelResult
{
  private final Channel zzcd;
  private final Status zzp;
  
  zzam(Status paramStatus, @Nullable Channel paramChannel)
  {
    AppMethodBeat.i(100986);
    this.zzp = ((Status)Preconditions.checkNotNull(paramStatus));
    this.zzcd = paramChannel;
    AppMethodBeat.o(100986);
  }
  
  @Nullable
  public final Channel getChannel()
  {
    return this.zzcd;
  }
  
  public final Status getStatus()
  {
    return this.zzp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzam
 * JD-Core Version:    0.7.0.1
 */