package com.facebook.appevents.codeless;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ViewIndexer$4
  implements GraphRequest.Callback
{
  public final void onCompleted(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(72078);
    Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.access$100(), "App index sent to FB!");
    AppMethodBeat.o(72078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.codeless.ViewIndexer.4
 * JD-Core Version:    0.7.0.1
 */