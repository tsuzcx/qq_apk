package com.facebook.internal;

import com.facebook.FacebookException;
import org.json.JSONObject;

public abstract interface Utility$GraphMeRequestWithCacheCallback
{
  public abstract void onFailure(FacebookException paramFacebookException);
  
  public abstract void onSuccess(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
 * JD-Core Version:    0.7.0.1
 */