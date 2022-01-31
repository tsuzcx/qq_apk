package com.facebook.appevents;

import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppEventQueue$5
  implements GraphRequest.Callback
{
  AppEventQueue$5(AccessTokenAppIdPair paramAccessTokenAppIdPair, GraphRequest paramGraphRequest, SessionEventsState paramSessionEventsState, FlushStatistics paramFlushStatistics) {}
  
  public final void onCompleted(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(71888);
    AppEventQueue.access$400(this.val$accessTokenAppId, this.val$postRequest, paramGraphResponse, this.val$appEvents, this.val$flushState);
    AppMethodBeat.o(71888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.AppEventQueue.5
 * JD-Core Version:    0.7.0.1
 */