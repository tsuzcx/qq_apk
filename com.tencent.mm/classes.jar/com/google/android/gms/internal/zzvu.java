package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

class zzvu
  implements ProxyApi.ProxyResult
{
  private Status zzair;
  private ProxyResponse zzajY;
  
  public zzvu(ProxyResponse paramProxyResponse)
  {
    this.zzajY = paramProxyResponse;
    this.zzair = Status.zzazx;
  }
  
  public zzvu(Status paramStatus)
  {
    this.zzair = paramStatus;
  }
  
  public ProxyResponse getResponse()
  {
    return this.zzajY;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzvu
 * JD-Core Version:    0.7.0.1
 */