package com.samsung.android.sdk.look.bezelinteraction;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.samsung.android.bezelinteraction.BezelEvent;
import com.samsung.android.bezelinteraction.IBezelCallback.Stub;

class SlookBezelInteraction$BezelListenerDelegate
  extends IBezelCallback.Stub
{
  public Handler mHandler;
  public SlookBezelInteraction.BezelListener mListener;
  
  SlookBezelInteraction$BezelListenerDelegate(SlookBezelInteraction.BezelListener paramBezelListener, Handler paramHandler)
  {
    this.mListener = paramBezelListener;
    if (paramHandler == null) {}
    for (paramBezelListener = SlookBezelInteraction.access$000().getMainLooper();; paramBezelListener = paramHandler.getLooper())
    {
      this.mHandler = new SlookBezelInteraction.BezelListenerDelegate.ListenerHandler(paramBezelListener, this.mListener);
      return;
    }
  }
  
  public SlookBezelInteraction.BezelListener getListener()
  {
    return this.mListener;
  }
  
  public String getListenerInfo()
  {
    return this.mListener.toString();
  }
  
  public void onBezelCallback(BezelEvent paramBezelEvent)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramBezelEvent;
    this.mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction.BezelListenerDelegate
 * JD-Core Version:    0.7.0.1
 */