package com.samsung.android.sdk.look.bezelinteraction;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.bezelinteraction.BezelEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SlookBezelInteraction$BezelListenerDelegate$ListenerHandler
  extends Handler
{
  public SlookBezelInteraction.BezelListener mListener = null;
  
  public SlookBezelInteraction$BezelListenerDelegate$ListenerHandler(Looper paramLooper, SlookBezelInteraction.BezelListener paramBezelListener)
  {
    super(paramLooper);
    this.mListener = paramBezelListener;
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(117212);
    if (this.mListener != null)
    {
      paramMessage = (BezelEvent)paramMessage.obj;
      if (paramMessage != null) {
        this.mListener.onItemSelected(paramMessage);
      }
    }
    AppMethodBeat.o(117212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction.BezelListenerDelegate.ListenerHandler
 * JD-Core Version:    0.7.0.1
 */