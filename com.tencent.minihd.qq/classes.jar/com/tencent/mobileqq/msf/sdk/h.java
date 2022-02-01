package com.tencent.mobileqq.msf.sdk;

import android.os.RemoteException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;

class h
  extends IMsfServiceCallbacker.Stub
{
  h(g paramg) {}
  
  public void onRecvPushResp(FromServiceMsg paramFromServiceMsg)
    throws RemoteException
  {
    g.a(this.a, paramFromServiceMsg);
  }
  
  public void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
    throws RemoteException
  {
    g.a(this.a, paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.h
 * JD-Core Version:    0.7.0.1
 */