package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.tasks.Task;
import java.io.InputStream;
import java.io.OutputStream;

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
  
  public abstract Task<Void> close(Channel paramChannel);
  
  public abstract Task<Void> close(Channel paramChannel, int paramInt);
  
  public abstract Task<InputStream> getInputStream(Channel paramChannel);
  
  public abstract Task<OutputStream> getOutputStream(Channel paramChannel);
  
  public abstract Task<Channel> openChannel(String paramString1, String paramString2);
  
  public abstract Task<Void> receiveFile(Channel paramChannel, Uri paramUri, boolean paramBoolean);
  
  public abstract Task<Void> registerChannelCallback(Channel paramChannel, ChannelCallback paramChannelCallback);
  
  public abstract Task<Void> registerChannelCallback(ChannelCallback paramChannelCallback);
  
  public abstract Task<Void> sendFile(Channel paramChannel, Uri paramUri);
  
  public abstract Task<Void> sendFile(Channel paramChannel, Uri paramUri, long paramLong1, long paramLong2);
  
  public abstract Task<Boolean> unregisterChannelCallback(Channel paramChannel, ChannelCallback paramChannelCallback);
  
  public abstract Task<Boolean> unregisterChannelCallback(ChannelCallback paramChannelCallback);
  
  public static abstract interface Channel
    extends Parcelable
  {
    public abstract String getNodeId();
    
    public abstract String getPath();
  }
  
  public static class ChannelCallback
  {
    public static final int CLOSE_REASON_DISCONNECTED = 1;
    public static final int CLOSE_REASON_LOCAL_CLOSE = 3;
    public static final int CLOSE_REASON_NORMAL = 0;
    public static final int CLOSE_REASON_REMOTE_CLOSE = 2;
    
    public void onChannelClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2) {}
    
    public void onChannelOpened(ChannelClient.Channel paramChannel) {}
    
    public void onInputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2) {}
    
    public void onOutputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.ChannelClient
 * JD-Core Version:    0.7.0.1
 */