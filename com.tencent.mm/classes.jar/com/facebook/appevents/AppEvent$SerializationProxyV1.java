package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

class AppEvent$SerializationProxyV1
  implements Serializable
{
  private static final long serialVersionUID = -2488473066578201069L;
  private final boolean isImplicit;
  private final String jsonString;
  
  private AppEvent$SerializationProxyV1(String paramString, boolean paramBoolean)
  {
    this.jsonString = paramString;
    this.isImplicit = paramBoolean;
  }
  
  private Object readResolve()
  {
    AppMethodBeat.i(17301);
    AppEvent localAppEvent = new AppEvent(this.jsonString, this.isImplicit, null, null);
    AppMethodBeat.o(17301);
    return localAppEvent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.appevents.AppEvent.SerializationProxyV1
 * JD-Core Version:    0.7.0.1
 */