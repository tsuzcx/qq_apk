package com.tencent.mm.network;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public abstract interface y
{
  public abstract void RU(String paramString);
  
  public abstract String bjP();
  
  public abstract int bjQ();
  
  public abstract void disconnect();
  
  public abstract int getContentLength();
  
  public abstract String getContentType();
  
  public abstract String getHeaderField(String paramString);
  
  public abstract int getHeaderFieldInt(String paramString, int paramInt);
  
  public abstract Map<String, List<String>> getHeaderFields();
  
  public abstract String getHost();
  
  public abstract InputStream getInputStream();
  
  public abstract int getResponseCode();
  
  public abstract void setConnectTimeout(int paramInt);
  
  public abstract void setReadTimeout(int paramInt);
  
  public abstract void setRequestMethod(String paramString);
  
  public abstract void setRequestProperty(String paramString1, String paramString2);
  
  public abstract void setUseCaches(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.network.y
 * JD-Core Version:    0.7.0.1
 */