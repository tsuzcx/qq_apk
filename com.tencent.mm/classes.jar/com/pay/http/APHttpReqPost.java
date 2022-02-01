package com.pay.http;

import java.net.HttpURLConnection;

public abstract class APHttpReqPost
  extends APBaseHttpReq
{
  public APHttpReqPost()
  {
    this.httpParam.setReqWithHttps();
    this.httpParam.setSendWithPost();
  }
  
  private void setPostMothod()
  {
    try
    {
      this.httpURLConnection.setRequestMethod("POST");
      this.httpURLConnection.setRequestProperty("Charset", "UTF-8");
      this.httpURLConnection.setDoInput(true);
      this.httpURLConnection.setDoOutput(true);
      this.httpURLConnection.setRequestProperty("Content-Length", String.valueOf(this.httpParam.urlParams.getBytes().length));
      this.httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void setBody()
  {
    super.setBody();
  }
  
  protected void setHeader()
  {
    setPostMothod();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.pay.http.APHttpReqPost
 * JD-Core Version:    0.7.0.1
 */