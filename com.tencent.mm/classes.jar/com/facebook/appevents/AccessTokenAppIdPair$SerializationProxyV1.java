package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

class AccessTokenAppIdPair$SerializationProxyV1
  implements Serializable
{
  private static final long serialVersionUID = -2488473066578201069L;
  private final String accessTokenString;
  private final String appId;
  
  private AccessTokenAppIdPair$SerializationProxyV1(String paramString1, String paramString2)
  {
    this.accessTokenString = paramString1;
    this.appId = paramString2;
  }
  
  private Object readResolve()
  {
    AppMethodBeat.i(71851);
    AccessTokenAppIdPair localAccessTokenAppIdPair = new AccessTokenAppIdPair(this.accessTokenString, this.appId);
    AppMethodBeat.o(71851);
    return localAccessTokenAppIdPair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.appevents.AccessTokenAppIdPair.SerializationProxyV1
 * JD-Core Version:    0.7.0.1
 */