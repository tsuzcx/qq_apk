package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CodelessLoggingEventListener
{
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(72046);
    TAG = CodelessLoggingEventListener.class.getCanonicalName();
    AppMethodBeat.o(72046);
  }
  
  public static CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate getAccessibilityDelegate(EventBinding paramEventBinding, View paramView1, View paramView2)
  {
    AppMethodBeat.i(72045);
    paramEventBinding = new CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate(paramEventBinding, paramView1, paramView2);
    AppMethodBeat.o(72045);
    return paramEventBinding;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.appevents.codeless.CodelessLoggingEventListener
 * JD-Core Version:    0.7.0.1
 */