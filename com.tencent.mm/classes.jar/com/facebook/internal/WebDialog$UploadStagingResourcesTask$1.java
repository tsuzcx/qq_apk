package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

class WebDialog$UploadStagingResourcesTask$1
  implements GraphRequest.Callback
{
  WebDialog$UploadStagingResourcesTask$1(WebDialog.UploadStagingResourcesTask paramUploadStagingResourcesTask, String[] paramArrayOfString, int paramInt, CountDownLatch paramCountDownLatch) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96668);
    try
    {
      Object localObject = paramGraphResponse.getError();
      if (localObject != null)
      {
        String str = ((FacebookRequestError)localObject).getErrorMessage();
        localObject = str;
        if (str == null) {
          localObject = "Error staging photo.";
        }
        paramGraphResponse = new FacebookGraphResponseException(paramGraphResponse, (String)localObject);
        AppMethodBeat.o(96668);
        throw paramGraphResponse;
      }
    }
    catch (Exception paramGraphResponse)
    {
      WebDialog.UploadStagingResourcesTask.access$800(this.this$1)[this.val$writeIndex] = paramGraphResponse;
    }
    for (;;)
    {
      this.val$latch.countDown();
      AppMethodBeat.o(96668);
      return;
      paramGraphResponse = paramGraphResponse.getJSONObject();
      if (paramGraphResponse == null)
      {
        paramGraphResponse = new FacebookException("Error staging photo.");
        AppMethodBeat.o(96668);
        throw paramGraphResponse;
      }
      paramGraphResponse = paramGraphResponse.optString("uri");
      if (paramGraphResponse == null)
      {
        paramGraphResponse = new FacebookException("Error staging photo.");
        AppMethodBeat.o(96668);
        throw paramGraphResponse;
      }
      this.val$results[this.val$writeIndex] = paramGraphResponse;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.WebDialog.UploadStagingResourcesTask.1
 * JD-Core Version:    0.7.0.1
 */