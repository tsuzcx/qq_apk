package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class Utility$1
  implements GraphRequest.Callback
{
  Utility$1(Utility.GraphMeRequestWithCacheCallback paramGraphMeRequestWithCacheCallback, String paramString) {}
  
  public final void onCompleted(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(72490);
    if (paramGraphResponse.getError() != null)
    {
      this.val$callback.onFailure(paramGraphResponse.getError().getException());
      AppMethodBeat.o(72490);
      return;
    }
    ProfileInformationCache.putProfileInformation(this.val$accessToken, paramGraphResponse.getJSONObject());
    this.val$callback.onSuccess(paramGraphResponse.getJSONObject());
    AppMethodBeat.o(72490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.Utility.1
 * JD-Core Version:    0.7.0.1
 */