package com.pay.network.model;

import com.pay.http.APBaseHttpAns;
import com.pay.http.APBaseHttpReq;
import com.pay.http.APHttpHandle;
import com.pay.http.IAPHttpAnsObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class APDataReportAns
  extends APBaseHttpAns
{
  public APDataReportAns(APHttpHandle paramAPHttpHandle, IAPHttpAnsObserver paramIAPHttpAnsObserver, HashMap<String, APBaseHttpReq> paramHashMap, String paramString)
  {
    super(paramAPHttpHandle, paramIAPHttpAnsObserver, paramHashMap, paramString);
  }
  
  private void progressJson(byte[] paramArrayOfByte, APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(193302);
    APLog.i("MidasPlugin.jar APDataReportAns", "report ok");
    AppMethodBeat.o(193302);
  }
  
  public void onErrorAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onFinishAns(byte[] paramArrayOfByte, APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(193301);
    progressJson(paramArrayOfByte, paramAPBaseHttpReq);
    AppMethodBeat.o(193301);
  }
  
  public void onReceiveAns(byte[] paramArrayOfByte, int paramInt, long paramLong, APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onStartAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onStopAns(APBaseHttpReq paramAPBaseHttpReq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.pay.network.model.APDataReportAns
 * JD-Core Version:    0.7.0.1
 */