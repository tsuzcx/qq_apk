package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.tasks.Task;

public abstract class MessageClient
  extends GoogleApi<Wearable.WearableOptions>
{
  public static final String ACTION_MESSAGE_RECEIVED = "com.google.android.gms.wearable.MESSAGE_RECEIVED";
  public static final int FILTER_LITERAL = 0;
  public static final int FILTER_PREFIX = 1;
  
  public MessageClient(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, Wearable.API, null, paramSettings);
  }
  
  public MessageClient(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, Wearable.API, null, paramSettings);
  }
  
  public abstract Task<Void> addListener(OnMessageReceivedListener paramOnMessageReceivedListener);
  
  public abstract Task<Void> addListener(OnMessageReceivedListener paramOnMessageReceivedListener, Uri paramUri, int paramInt);
  
  public abstract Task<Boolean> removeListener(OnMessageReceivedListener paramOnMessageReceivedListener);
  
  public abstract Task<Integer> sendMessage(String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  public static abstract interface OnMessageReceivedListener
    extends MessageApi.MessageListener
  {
    public abstract void onMessageReceived(MessageEvent paramMessageEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.MessageClient
 * JD-Core Version:    0.7.0.1
 */