package com.tencent.component.network.downloader.strategy;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.protocol.HttpContext;

public class DownloadConnectionReuseStrategy
  extends DefaultConnectionReuseStrategy
{
  public boolean keepAlive(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (paramHttpContext != null)
    {
      Object localObject = (HttpRequest)paramHttpContext.getAttribute("http.request");
      if (localObject != null)
      {
        localObject = ((HttpRequest)localObject).headerIterator("Connection");
        if (((HeaderIterator)localObject).hasNext()) {
          try
          {
            localObject = createTokenIterator((HeaderIterator)localObject);
            while (((TokenIterator)localObject).hasNext())
            {
              boolean bool = "Close".equalsIgnoreCase(((TokenIterator)localObject).nextToken());
              if (bool) {
                return false;
              }
            }
          }
          catch (ParseException localParseException) {}
        }
      }
    }
    return super.keepAlive(paramHttpResponse, paramHttpContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadConnectionReuseStrategy
 * JD-Core Version:    0.7.0.1
 */