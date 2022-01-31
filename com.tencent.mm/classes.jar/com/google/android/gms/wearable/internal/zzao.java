package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelClient;
import com.google.android.gms.wearable.ChannelClient.Channel;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzao
  extends ChannelClient
{
  private final zzaj zzcg;
  
  public zzao(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, paramSettings);
    AppMethodBeat.i(71007);
    this.zzcg = new zzaj();
    AppMethodBeat.o(71007);
  }
  
  public zzao(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, paramSettings);
    AppMethodBeat.i(71006);
    this.zzcg = new zzaj();
    AppMethodBeat.o(71006);
  }
  
  private static zzay zza(Channel paramChannel)
  {
    AppMethodBeat.i(71012);
    Preconditions.checkNotNull(paramChannel, "channel must not be null");
    paramChannel = (zzay)paramChannel;
    AppMethodBeat.o(71012);
    return paramChannel;
  }
  
  private static zzay zza(ChannelClient.Channel paramChannel)
  {
    AppMethodBeat.i(71011);
    Preconditions.checkNotNull(paramChannel, "channel must not be null");
    paramChannel = (zzay)paramChannel;
    AppMethodBeat.o(71011);
    return paramChannel;
  }
  
  public final Task<Void> close(ChannelClient.Channel paramChannel)
  {
    AppMethodBeat.i(71013);
    paramChannel = PendingResultUtil.toVoidTask(zza(paramChannel).close(asGoogleApiClient()));
    AppMethodBeat.o(71013);
    return paramChannel;
  }
  
  public final Task<Void> close(ChannelClient.Channel paramChannel, int paramInt)
  {
    AppMethodBeat.i(71014);
    paramChannel = PendingResultUtil.toVoidTask(zza(paramChannel).close(asGoogleApiClient(), paramInt));
    AppMethodBeat.o(71014);
    return paramChannel;
  }
  
  public final Task<InputStream> getInputStream(ChannelClient.Channel paramChannel)
  {
    AppMethodBeat.i(71015);
    paramChannel = PendingResultUtil.toTask(zza(paramChannel).getInputStream(asGoogleApiClient()), zzaq.zzbx);
    AppMethodBeat.o(71015);
    return paramChannel;
  }
  
  public final Task<OutputStream> getOutputStream(ChannelClient.Channel paramChannel)
  {
    AppMethodBeat.i(71016);
    paramChannel = PendingResultUtil.toTask(zza(paramChannel).getOutputStream(asGoogleApiClient()), zzar.zzbx);
    AppMethodBeat.o(71016);
    return paramChannel;
  }
  
  public final Task<ChannelClient.Channel> openChannel(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71008);
    paramString1 = PendingResultUtil.toTask(this.zzcg.openChannel(asGoogleApiClient(), paramString1, paramString2), zzap.zzbx);
    AppMethodBeat.o(71008);
    return paramString1;
  }
  
  public final Task<Void> receiveFile(ChannelClient.Channel paramChannel, Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(71017);
    paramChannel = PendingResultUtil.toVoidTask(zza(paramChannel).receiveFile(asGoogleApiClient(), paramUri, paramBoolean));
    AppMethodBeat.o(71017);
    return paramChannel;
  }
  
  public final Task<Void> registerChannelCallback(ChannelClient.Channel paramChannel, ChannelClient.ChannelCallback paramChannelCallback)
  {
    AppMethodBeat.i(71020);
    String str = ((zzay)paramChannel).zzc();
    Preconditions.checkNotNull(paramChannelCallback, "listener is null");
    Object localObject = getLooper();
    paramChannel = String.valueOf(str);
    if (paramChannel.length() != 0) {}
    for (paramChannel = "ChannelListener:".concat(paramChannel);; paramChannel = new String("ChannelListener:"))
    {
      paramChannel = ListenerHolders.createListenerHolder(paramChannelCallback, (Looper)localObject, paramChannel);
      localObject = zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT");
      paramChannelCallback = new zzas(paramChannelCallback);
      ListenerHolder localListenerHolder = ListenerHolders.createListenerHolder(paramChannelCallback, getLooper(), "ChannelListener");
      paramChannel = doRegisterEventListener(new zzat(paramChannelCallback, str, new IntentFilter[] { localObject }, paramChannel, localListenerHolder), new zzau(paramChannelCallback, str, paramChannel.getListenerKey()));
      AppMethodBeat.o(71020);
      return paramChannel;
    }
  }
  
  public final Task<Void> registerChannelCallback(ChannelClient.ChannelCallback paramChannelCallback)
  {
    AppMethodBeat.i(71009);
    Preconditions.checkNotNull(paramChannelCallback, "listener is null");
    ListenerHolder localListenerHolder1 = ListenerHolders.createListenerHolder(paramChannelCallback, getLooper(), "ChannelListener");
    IntentFilter localIntentFilter = zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT");
    paramChannelCallback = new zzas(paramChannelCallback);
    ListenerHolder localListenerHolder2 = ListenerHolders.createListenerHolder(paramChannelCallback, getLooper(), "ChannelListener");
    paramChannelCallback = doRegisterEventListener(new zzat(paramChannelCallback, null, new IntentFilter[] { localIntentFilter }, localListenerHolder1, localListenerHolder2), new zzau(paramChannelCallback, null, localListenerHolder1.getListenerKey()));
    AppMethodBeat.o(71009);
    return paramChannelCallback;
  }
  
  public final Task<Void> sendFile(ChannelClient.Channel paramChannel, Uri paramUri)
  {
    AppMethodBeat.i(71018);
    paramChannel = PendingResultUtil.toVoidTask(zza(paramChannel).sendFile(asGoogleApiClient(), paramUri));
    AppMethodBeat.o(71018);
    return paramChannel;
  }
  
  public final Task<Void> sendFile(ChannelClient.Channel paramChannel, Uri paramUri, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(71019);
    paramChannel = PendingResultUtil.toVoidTask(zza(paramChannel).sendFile(asGoogleApiClient(), paramUri, paramLong1, paramLong2));
    AppMethodBeat.o(71019);
    return paramChannel;
  }
  
  public final Task<Boolean> unregisterChannelCallback(ChannelClient.Channel paramChannel, ChannelClient.ChannelCallback paramChannelCallback)
  {
    AppMethodBeat.i(71021);
    paramChannel = zza(paramChannel).zzc();
    Looper localLooper = getLooper();
    paramChannel = String.valueOf(paramChannel);
    if (paramChannel.length() != 0) {}
    for (paramChannel = "ChannelListener:".concat(paramChannel);; paramChannel = new String("ChannelListener:"))
    {
      paramChannel = doUnregisterEventListener(ListenerHolders.createListenerHolder(paramChannelCallback, localLooper, paramChannel).getListenerKey());
      AppMethodBeat.o(71021);
      return paramChannel;
    }
  }
  
  public final Task<Boolean> unregisterChannelCallback(ChannelClient.ChannelCallback paramChannelCallback)
  {
    AppMethodBeat.i(71010);
    paramChannelCallback = doUnregisterEventListener(ListenerHolders.createListenerHolder(paramChannelCallback, getLooper(), "ChannelListener").getListenerKey());
    AppMethodBeat.o(71010);
    return paramChannelCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzao
 * JD-Core Version:    0.7.0.1
 */