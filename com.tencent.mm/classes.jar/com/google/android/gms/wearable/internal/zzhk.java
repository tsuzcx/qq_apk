package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import javax.annotation.Nullable;

@VisibleForTesting
public final class zzhk<T>
  extends zzen
{
  private final IntentFilter[] zzba;
  @Nullable
  private final String zzbb;
  private ListenerHolder<Object> zzfj;
  private ListenerHolder<Object> zzfk;
  private ListenerHolder<DataApi.DataListener> zzfl;
  private ListenerHolder<MessageApi.MessageListener> zzfm;
  private ListenerHolder<Object> zzfn;
  private ListenerHolder<Object> zzfo;
  private ListenerHolder<ChannelApi.ChannelListener> zzfp;
  private ListenerHolder<CapabilityApi.CapabilityListener> zzfq;
  
  private zzhk(IntentFilter[] paramArrayOfIntentFilter, @Nullable String paramString)
  {
    AppMethodBeat.i(101406);
    this.zzba = ((IntentFilter[])Preconditions.checkNotNull(paramArrayOfIntentFilter));
    this.zzbb = paramString;
    AppMethodBeat.o(101406);
  }
  
  public static zzhk<ChannelApi.ChannelListener> zza(ListenerHolder<ChannelApi.ChannelListener> paramListenerHolder, String paramString, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101404);
    paramString = new zzhk(paramArrayOfIntentFilter, (String)Preconditions.checkNotNull(paramString));
    paramString.zzfp = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    AppMethodBeat.o(101404);
    return paramString;
  }
  
  public static zzhk<DataApi.DataListener> zza(ListenerHolder<DataApi.DataListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101401);
    paramArrayOfIntentFilter = new zzhk(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzfl = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    AppMethodBeat.o(101401);
    return paramArrayOfIntentFilter;
  }
  
  private static void zza(ListenerHolder<?> paramListenerHolder)
  {
    AppMethodBeat.i(101412);
    if (paramListenerHolder != null) {
      paramListenerHolder.clear();
    }
    AppMethodBeat.o(101412);
  }
  
  public static zzhk<MessageApi.MessageListener> zzb(ListenerHolder<MessageApi.MessageListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101402);
    paramArrayOfIntentFilter = new zzhk(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzfm = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    AppMethodBeat.o(101402);
    return paramArrayOfIntentFilter;
  }
  
  public static zzhk<ChannelApi.ChannelListener> zzc(ListenerHolder<ChannelApi.ChannelListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101403);
    paramArrayOfIntentFilter = new zzhk(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzfp = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    AppMethodBeat.o(101403);
    return paramArrayOfIntentFilter;
  }
  
  public static zzhk<CapabilityApi.CapabilityListener> zzd(ListenerHolder<CapabilityApi.CapabilityListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    AppMethodBeat.i(101405);
    paramArrayOfIntentFilter = new zzhk(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzfq = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    AppMethodBeat.o(101405);
    return paramArrayOfIntentFilter;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(101407);
    zza(null);
    this.zzfj = null;
    zza(null);
    this.zzfk = null;
    zza(this.zzfl);
    this.zzfl = null;
    zza(this.zzfm);
    this.zzfm = null;
    zza(null);
    this.zzfn = null;
    zza(null);
    this.zzfo = null;
    zza(this.zzfp);
    this.zzfp = null;
    zza(this.zzfq);
    this.zzfq = null;
    AppMethodBeat.o(101407);
  }
  
  public final void onConnectedNodes(List<zzfo> paramList) {}
  
  public final void zza(DataHolder paramDataHolder)
  {
    AppMethodBeat.i(101408);
    if (this.zzfl != null)
    {
      this.zzfl.notifyListener(new zzhl(paramDataHolder));
      AppMethodBeat.o(101408);
      return;
    }
    paramDataHolder.close();
    AppMethodBeat.o(101408);
  }
  
  public final void zza(zzah paramzzah)
  {
    AppMethodBeat.i(101411);
    if (this.zzfq != null) {
      this.zzfq.notifyListener(new zzho(paramzzah));
    }
    AppMethodBeat.o(101411);
  }
  
  public final void zza(zzaw paramzzaw)
  {
    AppMethodBeat.i(101410);
    if (this.zzfp != null) {
      this.zzfp.notifyListener(new zzhn(paramzzaw));
    }
    AppMethodBeat.o(101410);
  }
  
  public final void zza(zzfe paramzzfe)
  {
    AppMethodBeat.i(101409);
    if (this.zzfm != null) {
      this.zzfm.notifyListener(new zzhm(paramzzfe));
    }
    AppMethodBeat.o(101409);
  }
  
  public final void zza(zzfo paramzzfo) {}
  
  public final void zza(zzi paramzzi) {}
  
  public final void zza(zzl paramzzl) {}
  
  public final void zzb(zzfo paramzzfo) {}
  
  public final IntentFilter[] zze()
  {
    return this.zzba;
  }
  
  @Nullable
  public final String zzf()
  {
    return this.zzbb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhk
 * JD-Core Version:    0.7.0.1
 */