package com.weiyun.sdk.util;

import com.weiyun.sdk.job.af.AddressFetcher.SimpleHttpAddress;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpReader
{
  public static final int DEFAULT_CONNECT_TIMEOUT = 15000;
  public static final int DEFAULT_READ_TIMEOUT = 15000;
  protected final AddressFetcher.TransferAddress mAddress;
  protected final String mCookie;
  protected HttpURLConnection mHttpUrlConnection;
  
  public HttpReader(AddressFetcher.TransferAddress paramTransferAddress, String paramString)
  {
    this.mAddress = paramTransferAddress;
    this.mCookie = paramString;
  }
  
  public HttpReader(String paramString1, String paramString2)
    throws MalformedURLException
  {
    this(new AddressFetcher.SimpleHttpAddress(paramString1), paramString2);
  }
  
  public int getContentLength()
    throws IOException
  {
    if (this.mHttpUrlConnection == null) {
      getHttpUrlConnection();
    }
    return this.mHttpUrlConnection.getContentLength();
  }
  
  public HttpURLConnection getHttpUrlConnection()
    throws IOException
  {
    if (this.mHttpUrlConnection != null) {
      return this.mHttpUrlConnection;
    }
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("http", this.mAddress.getHost(), this.mAddress.getPort(), this.mAddress.getFile()).openConnection();
    setHttpHeader(localHttpURLConnection);
    this.mHttpUrlConnection = localHttpURLConnection;
    return this.mHttpUrlConnection;
  }
  
  public int getResponseCode()
    throws IOException
  {
    if (this.mHttpUrlConnection == null) {
      getHttpUrlConnection();
    }
    return this.mHttpUrlConnection.getResponseCode();
  }
  
  InputStream getStream()
    throws IOException
  {
    if (this.mHttpUrlConnection == null) {
      getHttpUrlConnection();
    }
    return this.mHttpUrlConnection.getInputStream();
  }
  
  public String getUrl()
  {
    return this.mAddress.toString();
  }
  
  protected void setHttpHeader(URLConnection paramURLConnection)
  {
    paramURLConnection.setConnectTimeout(15000);
    paramURLConnection.setReadTimeout(15000);
    if (this.mCookie != null) {
      paramURLConnection.addRequestProperty("Cookie", this.mCookie);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.HttpReader
 * JD-Core Version:    0.7.0.1
 */