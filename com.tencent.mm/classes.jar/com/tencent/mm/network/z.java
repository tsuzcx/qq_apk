package com.tencent.mm.network;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public abstract interface z
{
  public abstract void Rx(String paramString);
  
  public abstract void Ry(String paramString);
  
  public abstract int bRd();
  
  public abstract String bRe();
  
  public abstract Map<String, List<String>> bRf();
  
  public abstract String bRg();
  
  public abstract int bRh();
  
  public abstract int bk(String paramString, int paramInt);
  
  public abstract void disconnect();
  
  public abstract String getHeaderField(String paramString);
  
  public abstract String getHost();
  
  public abstract InputStream getInputStream();
  
  public abstract int getResponseCode();
  
  public abstract void hB(boolean paramBoolean);
  
  public abstract void setRequestProperty(String paramString1, String paramString2);
  
  public abstract void xx(int paramInt);
  
  public abstract void xy(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.z
 * JD-Core Version:    0.7.0.1
 */