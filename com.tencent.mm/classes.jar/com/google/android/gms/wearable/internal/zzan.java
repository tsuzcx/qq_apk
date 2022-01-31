package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

final class zzan
  extends zzn<Status>
{
  private final String zzce;
  private ChannelApi.ChannelListener zzcf;
  
  zzan(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener, @Nullable String paramString)
  {
    super(paramGoogleApiClient);
    AppMethodBeat.i(71004);
    this.zzcf = ((ChannelApi.ChannelListener)Preconditions.checkNotNull(paramChannelListener));
    this.zzce = paramString;
    AppMethodBeat.o(71004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzan
 * JD-Core Version:    0.7.0.1
 */