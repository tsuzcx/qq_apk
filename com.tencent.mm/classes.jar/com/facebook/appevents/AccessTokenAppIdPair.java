package com.facebook.appevents;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

class AccessTokenAppIdPair
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final String accessTokenString;
  private final String applicationId;
  
  public AccessTokenAppIdPair(AccessToken paramAccessToken)
  {
    this(paramAccessToken.getToken(), FacebookSdk.getApplicationId());
    AppMethodBeat.i(17288);
    AppMethodBeat.o(17288);
  }
  
  public AccessTokenAppIdPair(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17289);
    String str = paramString1;
    if (Utility.isNullOrEmpty(paramString1)) {
      str = null;
    }
    this.accessTokenString = str;
    this.applicationId = paramString2;
    AppMethodBeat.o(17289);
  }
  
  private Object writeReplace()
  {
    AppMethodBeat.i(17292);
    SerializationProxyV1 localSerializationProxyV1 = new SerializationProxyV1(this.accessTokenString, this.applicationId, null);
    AppMethodBeat.o(17292);
    return localSerializationProxyV1;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(17291);
    if (!(paramObject instanceof AccessTokenAppIdPair))
    {
      AppMethodBeat.o(17291);
      return false;
    }
    paramObject = (AccessTokenAppIdPair)paramObject;
    if ((Utility.areObjectsEqual(paramObject.accessTokenString, this.accessTokenString)) && (Utility.areObjectsEqual(paramObject.applicationId, this.applicationId)))
    {
      AppMethodBeat.o(17291);
      return true;
    }
    AppMethodBeat.o(17291);
    return false;
  }
  
  public String getAccessTokenString()
  {
    return this.accessTokenString;
  }
  
  public String getApplicationId()
  {
    return this.applicationId;
  }
  
  public int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(17290);
    int i;
    if (this.accessTokenString == null)
    {
      i = 0;
      if (this.applicationId != null) {
        break label45;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(17290);
      return i ^ j;
      i = this.accessTokenString.hashCode();
      break;
      label45:
      j = this.applicationId.hashCode();
    }
  }
  
  static class SerializationProxyV1
    implements Serializable
  {
    private static final long serialVersionUID = -2488473066578201069L;
    private final String accessTokenString;
    private final String appId;
    
    private SerializationProxyV1(String paramString1, String paramString2)
    {
      this.accessTokenString = paramString1;
      this.appId = paramString2;
    }
    
    private Object readResolve()
    {
      AppMethodBeat.i(17287);
      AccessTokenAppIdPair localAccessTokenAppIdPair = new AccessTokenAppIdPair(this.accessTokenString, this.appId);
      AppMethodBeat.o(17287);
      return localAccessTokenAppIdPair;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.appevents.AccessTokenAppIdPair
 * JD-Core Version:    0.7.0.1
 */