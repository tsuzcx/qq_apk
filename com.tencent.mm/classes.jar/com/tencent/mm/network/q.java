package com.tencent.mm.network;

import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

public abstract interface q
{
  public abstract boolean getIsLongPolling();
  
  public abstract boolean getIsUserCmd();
  
  public abstract int getLongPollingTimeout();
  
  public abstract int getNewExtFlags();
  
  public abstract int getOptions();
  
  public abstract l.d getReqObj();
  
  public abstract l.e getRespObj();
  
  public abstract int getTimeOut();
  
  public abstract byte[] getTransHeader();
  
  public abstract int getType();
  
  public abstract String getUri();
  
  public abstract boolean isSingleSession();
  
  public abstract void setConnectionInfo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.q
 * JD-Core Version:    0.7.0.1
 */