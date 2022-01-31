package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
public abstract interface ChannelApi
{
  public static final String ACTION_CHANNEL_EVENT = "com.google.android.gms.wearable.CHANNEL_EVENT";
  
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener);
  
  public abstract PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2);
  
  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CloseReason {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.ChannelApi
 * JD-Core Version:    0.7.0.1
 */