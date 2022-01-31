package com.facebook.share.internal;

import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.share.widget.LikeView.ObjectType;

abstract class LikeActionController$AbstractRequestWrapper
  implements LikeActionController.RequestWrapper
{
  protected FacebookRequestError error;
  protected String objectId;
  protected LikeView.ObjectType objectType;
  private GraphRequest request;
  
  protected LikeActionController$AbstractRequestWrapper(LikeActionController paramLikeActionController, String paramString, LikeView.ObjectType paramObjectType)
  {
    this.objectId = paramString;
    this.objectType = paramObjectType;
  }
  
  public void addToBatch(GraphRequestBatch paramGraphRequestBatch)
  {
    paramGraphRequestBatch.add(this.request);
  }
  
  public FacebookRequestError getError()
  {
    return this.error;
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error running request for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
  }
  
  protected abstract void processSuccess(GraphResponse paramGraphResponse);
  
  protected void setRequest(GraphRequest paramGraphRequest)
  {
    this.request = paramGraphRequest;
    paramGraphRequest.setVersion(FacebookSdk.getGraphApiVersion());
    paramGraphRequest.setCallback(new LikeActionController.AbstractRequestWrapper.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
 * JD-Core Version:    0.7.0.1
 */