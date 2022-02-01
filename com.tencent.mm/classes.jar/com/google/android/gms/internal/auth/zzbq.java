package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

final class zzbq
  implements ProxyApi.ProxyResult
{
  private Status mStatus;
  private ProxyResponse zzee;
  
  public zzbq(ProxyResponse paramProxyResponse)
  {
    this.zzee = paramProxyResponse;
    this.mStatus = Status.RESULT_SUCCESS;
  }
  
  public zzbq(Status paramStatus)
  {
    this.mStatus = paramStatus;
  }
  
  public final ProxyResponse getResponse()
  {
    return this.zzee;
  }
  
  public final Status getStatus()
  {
    return this.mStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzbq
 * JD-Core Version:    0.7.0.1
 */