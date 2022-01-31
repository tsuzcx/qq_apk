package com.samsung.android.sdk.look.bezelinteraction;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.samsung.android.bezelinteraction.BezelEvent;
import com.samsung.android.bezelinteraction.IBezelCallback.Stub;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SlookBezelInteraction$BezelListenerDelegate
  extends IBezelCallback.Stub
{
  public Handler mHandler;
  public SlookBezelInteraction.BezelListener mListener;
  
  SlookBezelInteraction$BezelListenerDelegate(SlookBezelInteraction.BezelListener paramBezelListener, Handler paramHandler)
  {
    AppMethodBeat.i(117209);
    this.mListener = paramBezelListener;
    if (paramHandler == null) {}
    for (paramBezelListener = SlookBezelInteraction.access$000().getMainLooper();; paramBezelListener = paramHandler.getLooper())
    {
      this.mHandler = new SlookBezelInteraction.BezelListenerDelegate.ListenerHandler(paramBezelListener, this.mListener);
      AppMethodBeat.o(117209);
      return;
    }
  }
  
  public SlookBezelInteraction.BezelListener getListener()
  {
    return this.mListener;
  }
  
  public String getListenerInfo()
  {
    AppMethodBeat.i(117211);
    String str = this.mListener.toString();
    AppMethodBeat.o(117211);
    return str;
  }
  
  public void onBezelCallback(BezelEvent paramBezelEvent)
  {
    AppMethodBeat.i(117210);
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramBezelEvent;
    this.mHandler.sendMessage(localMessage);
    AppMethodBeat.o(117210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction.BezelListenerDelegate
 * JD-Core Version:    0.7.0.1
 */