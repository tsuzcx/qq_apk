package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

final class zzcq
  implements ChannelApi.ChannelListener
{
  private final String zzaiJ;
  private final ChannelApi.ChannelListener zzbUU;
  
  zzcq(String paramString, ChannelApi.ChannelListener paramChannelListener)
  {
    this.zzaiJ = ((String)zzac.zzw(paramString));
    this.zzbUU = ((ChannelApi.ChannelListener)zzac.zzw(paramChannelListener));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzcq)) {
        return false;
      }
      paramObject = (zzcq)paramObject;
    } while ((this.zzbUU.equals(paramObject.zzbUU)) && (this.zzaiJ.equals(paramObject.zzaiJ)));
    return false;
  }
  
  public final int hashCode()
  {
    return this.zzaiJ.hashCode() * 31 + this.zzbUU.hashCode();
  }
  
  public final void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzbUU.onChannelClosed(paramChannel, paramInt1, paramInt2);
  }
  
  public final void onChannelOpened(Channel paramChannel)
  {
    this.zzbUU.onChannelOpened(paramChannel);
  }
  
  public final void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzbUU.onInputClosed(paramChannel, paramInt1, paramInt2);
  }
  
  public final void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzbUU.onOutputClosed(paramChannel, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcq
 * JD-Core Version:    0.7.0.1
 */