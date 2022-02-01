package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import java.net.Proxy.Type;

public final class RequestLine
{
  static String get(Request paramRequest, Proxy.Type paramType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRequest.method());
    localStringBuilder.append(' ');
    if (includeAuthorityInRequestLine(paramRequest, paramType)) {
      localStringBuilder.append(paramRequest.httpUrl());
    }
    for (;;)
    {
      localStringBuilder.append(" HTTP/1.1");
      return localStringBuilder.toString();
      localStringBuilder.append(requestPath(paramRequest.httpUrl()));
    }
  }
  
  private static boolean includeAuthorityInRequestLine(Request paramRequest, Proxy.Type paramType)
  {
    return (!paramRequest.isHttps()) && (paramType == Proxy.Type.HTTP);
  }
  
  public static String requestPath(HttpUrl paramHttpUrl)
  {
    String str1 = paramHttpUrl.encodedPath();
    String str2 = paramHttpUrl.encodedQuery();
    paramHttpUrl = str1;
    if (str2 != null) {
      paramHttpUrl = str1 + '?' + str2;
    }
    return paramHttpUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.RequestLine
 * JD-Core Version:    0.7.0.1
 */