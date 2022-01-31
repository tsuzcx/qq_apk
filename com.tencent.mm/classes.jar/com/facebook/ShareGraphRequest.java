package com.facebook;

import android.os.Bundle;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.ShareOpenGraphObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareGraphRequest
{
  public static GraphRequest createOpenGraphObject(ShareOpenGraphObject paramShareOpenGraphObject)
  {
    AppMethodBeat.i(96596);
    String str = paramShareOpenGraphObject.getString("type");
    if (str == null) {
      str = paramShareOpenGraphObject.getString("og:type");
    }
    for (;;)
    {
      if (str == null)
      {
        paramShareOpenGraphObject = new FacebookException("Open graph object type cannot be null");
        AppMethodBeat.o(96596);
        throw paramShareOpenGraphObject;
      }
      try
      {
        JSONObject localJSONObject = (JSONObject)OpenGraphJSONUtility.toJSONValue(paramShareOpenGraphObject, new ShareGraphRequest.1());
        paramShareOpenGraphObject = new Bundle();
        paramShareOpenGraphObject.putString("object", localJSONObject.toString());
        str = String.format(Locale.ROOT, "%s/%s", new Object[] { "me", "objects/".concat(String.valueOf(str)) });
        paramShareOpenGraphObject = new GraphRequest(AccessToken.getCurrentAccessToken(), str, paramShareOpenGraphObject, HttpMethod.POST);
        AppMethodBeat.o(96596);
        return paramShareOpenGraphObject;
      }
      catch (JSONException paramShareOpenGraphObject)
      {
        paramShareOpenGraphObject = new FacebookException(paramShareOpenGraphObject.getMessage());
        AppMethodBeat.o(96596);
        throw paramShareOpenGraphObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.ShareGraphRequest
 * JD-Core Version:    0.7.0.1
 */