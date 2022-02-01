package com.facebook.appevents.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class AppEventsLoggerUtility$1
  extends HashMap<AppEventsLoggerUtility.GraphAPIActivityType, String>
{
  AppEventsLoggerUtility$1()
  {
    AppMethodBeat.i(17601);
    put(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
    put(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
    AppMethodBeat.o(17601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.appevents.internal.AppEventsLoggerUtility.1
 * JD-Core Version:    0.7.0.1
 */