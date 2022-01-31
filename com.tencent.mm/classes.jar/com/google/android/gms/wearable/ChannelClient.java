package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.tasks.Task;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class ChannelClient
  extends GoogleApi<Wearable.WearableOptions>
{
  public static final String ACTION_CHANNEL_EVENT = "com.google.android.gms.wearable.CHANNEL_EVENT";
  
  public ChannelClient(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, Wearable.API, null, paramSettings);
  }
  
  public ChannelClient(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, Wearable.API, null, paramSettings);
  }
  
  public abstract Task<Void> close(ChannelClient.Channel paramChannel);
  
  public abstract Task<Void> close(ChannelClient.Channel paramChannel, int paramInt);
  
  public abstract Task<InputStream> getInputStream(ChannelClient.Channel paramChannel);
  
  public abstract Task<OutputStream> getOutputStream(ChannelClient.Channel paramChannel);
  
  public abstract Task<ChannelClient.Channel> openChannel(String paramString1, String paramString2);
  
  public abstract Task<Void> receiveFile(ChannelClient.Channel paramChannel, Uri paramUri, boolean paramBoolean);
  
  public abstract Task<Void> registerChannelCallback(ChannelClient.Channel paramChannel, ChannelClient.ChannelCallback paramChannelCallback);
  
  public abstract Task<Void> registerChannelCallback(ChannelClient.ChannelCallback paramChannelCallback);
  
  public abstract Task<Void> sendFile(ChannelClient.Channel paramChannel, Uri paramUri);
  
  public abstract Task<Void> sendFile(ChannelClient.Channel paramChannel, Uri paramUri, long paramLong1, long paramLong2);
  
  public abstract Task<Boolean> unregisterChannelCallback(ChannelClient.Channel paramChannel, ChannelClient.ChannelCallback paramChannelCallback);
  
  public abstract Task<Boolean> unregisterChannelCallback(ChannelClient.ChannelCallback paramChannelCallback);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CloseReason {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.ChannelClient
 * JD-Core Version:    0.7.0.1
 */