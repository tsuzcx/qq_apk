package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookGraphResponseException
  extends FacebookException
{
  private final GraphResponse graphResponse;
  
  public FacebookGraphResponseException(GraphResponse paramGraphResponse, String paramString)
  {
    super(paramString);
    this.graphResponse = paramGraphResponse;
  }
  
  public final GraphResponse getGraphResponse()
  {
    return this.graphResponse;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(17017);
    if (this.graphResponse != null) {}
    for (Object localObject = this.graphResponse.getError();; localObject = null)
    {
      StringBuilder localStringBuilder = new StringBuilder("{FacebookGraphResponseException: ");
      String str = getMessage();
      if (str != null)
      {
        localStringBuilder.append(str);
        localStringBuilder.append(" ");
      }
      if (localObject != null) {
        localStringBuilder.append("httpResponseCode: ").append(((FacebookRequestError)localObject).getRequestStatusCode()).append(", facebookErrorCode: ").append(((FacebookRequestError)localObject).getErrorCode()).append(", facebookErrorType: ").append(((FacebookRequestError)localObject).getErrorType()).append(", message: ").append(((FacebookRequestError)localObject).getErrorMessage()).append("}");
      }
      localObject = localStringBuilder.toString();
      AppMethodBeat.o(17017);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.FacebookGraphResponseException
 * JD-Core Version:    0.7.0.1
 */