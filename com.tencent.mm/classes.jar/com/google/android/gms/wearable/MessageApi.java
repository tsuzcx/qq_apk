package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

@Deprecated
public abstract interface MessageApi
{
  public static final String ACTION_MESSAGE_RECEIVED = "com.google.android.gms.wearable.MESSAGE_RECEIVED";
  public static final int FILTER_LITERAL = 0;
  public static final int FILTER_PREFIX = 1;
  public static final int UNKNOWN_REQUEST_ID = -1;
  
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener);
  
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener, Uri paramUri, int paramInt);
  
  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener);
  
  public abstract PendingResult<SendMessageResult> sendMessage(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  @Deprecated
  public static abstract interface MessageListener
  {
    public abstract void onMessageReceived(MessageEvent paramMessageEvent);
  }
  
  @Deprecated
  public static abstract interface SendMessageResult
    extends Result
  {
    public abstract int getRequestId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.MessageApi
 * JD-Core Version:    0.7.0.1
 */