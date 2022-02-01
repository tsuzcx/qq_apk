package com.facebook.appevents.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AppEventsLoggerUtility$GraphAPIActivityType
{
  static
  {
    AppMethodBeat.i(17604);
    MOBILE_INSTALL_EVENT = new GraphAPIActivityType("MOBILE_INSTALL_EVENT", 0);
    CUSTOM_APP_EVENTS = new GraphAPIActivityType("CUSTOM_APP_EVENTS", 1);
    $VALUES = new GraphAPIActivityType[] { MOBILE_INSTALL_EVENT, CUSTOM_APP_EVENTS };
    AppMethodBeat.o(17604);
  }
  
  private AppEventsLoggerUtility$GraphAPIActivityType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType
 * JD-Core Version:    0.7.0.1
 */