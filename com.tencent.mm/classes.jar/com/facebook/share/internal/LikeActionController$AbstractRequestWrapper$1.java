package com.facebook.share.internal;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LikeActionController$AbstractRequestWrapper$1
  implements GraphRequest.Callback
{
  LikeActionController$AbstractRequestWrapper$1(LikeActionController.AbstractRequestWrapper paramAbstractRequestWrapper) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96996);
    this.this$1.error = paramGraphResponse.getError();
    if (this.this$1.error != null)
    {
      this.this$1.processError(this.this$1.error);
      AppMethodBeat.o(96996);
      return;
    }
    this.this$1.processSuccess(paramGraphResponse);
    AppMethodBeat.o(96996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.AbstractRequestWrapper.1
 * JD-Core Version:    0.7.0.1
 */