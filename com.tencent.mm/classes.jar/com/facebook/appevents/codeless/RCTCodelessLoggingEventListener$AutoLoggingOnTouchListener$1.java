package com.facebook.appevents.codeless;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.tencent.matrix.trace.core.AppMethodBeat;

class RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener$1
  implements Runnable
{
  RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener$1(RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener paramAutoLoggingOnTouchListener, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    AppMethodBeat.i(72069);
    AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(this.val$eventName, this.val$params);
    AppMethodBeat.o(72069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener.1
 * JD-Core Version:    0.7.0.1
 */