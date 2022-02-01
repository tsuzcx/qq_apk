package com.tencent.midas.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasBaseRequest.APMidasMPInfo;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.midas.api.request.APMidasSubscribeRequest;
import com.tencent.midas.comm.APLog;

public class APMidasAnalyzeParams
{
  private void AnalyzeCommParams(APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(193023);
    try
    {
      APPluginDataInterface localAPPluginDataInterface = APPluginDataInterface.singleton();
      localAPPluginDataInterface.setOfferId(paramAPMidasBaseRequest.offerId);
      localAPPluginDataInterface.setOpenId(paramAPMidasBaseRequest.openId);
      localAPPluginDataInterface.setOpenKey(paramAPMidasBaseRequest.openKey);
      localAPPluginDataInterface.setSessionId(paramAPMidasBaseRequest.sessionId);
      localAPPluginDataInterface.setSessionType(paramAPMidasBaseRequest.sessionType);
      localAPPluginDataInterface.setPf(paramAPMidasBaseRequest.pf);
      localAPPluginDataInterface.setPfKey(paramAPMidasBaseRequest.pfKey);
      localAPPluginDataInterface.setZoneId(paramAPMidasBaseRequest.zoneId);
      localAPPluginDataInterface.setDiscountUrl(paramAPMidasBaseRequest.mpInfo.discountUrl);
      localAPPluginDataInterface.setReserv(paramAPMidasBaseRequest.reserv);
      AppMethodBeat.o(193023);
      return;
    }
    catch (Exception paramAPMidasBaseRequest)
    {
      APLog.i("AnalyzeCommParams", paramAPMidasBaseRequest.toString());
      AppMethodBeat.o(193023);
    }
  }
  
  public static APMidasAnalyzeParams getInstance()
  {
    AppMethodBeat.i(193020);
    APMidasAnalyzeParams localAPMidasAnalyzeParams = SingletonHolder.instance;
    AppMethodBeat.o(193020);
    return localAPMidasAnalyzeParams;
  }
  
  public void AnalyzeParams(APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(193021);
    if (paramAPMidasBaseRequest != null)
    {
      AnalyzeCommParams(paramAPMidasBaseRequest);
      setSaveType(paramAPMidasBaseRequest);
    }
    AppMethodBeat.o(193021);
  }
  
  public void setSaveType(APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(193022);
    APPluginDataInterface localAPPluginDataInterface = APPluginDataInterface.singleton();
    try
    {
      if ((paramAPMidasBaseRequest instanceof APMidasGameRequest))
      {
        if (paramAPMidasBaseRequest.acctType.equals("qb"))
        {
          localAPPluginDataInterface.setSaveType(3);
          AppMethodBeat.o(193022);
          return;
        }
        localAPPluginDataInterface.setSaveType(0);
        AppMethodBeat.o(193022);
        return;
      }
    }
    catch (Exception paramAPMidasBaseRequest)
    {
      APLog.i("setSaveType", paramAPMidasBaseRequest.toString());
      AppMethodBeat.o(193022);
      return;
    }
    if ((paramAPMidasBaseRequest instanceof APMidasGoodsRequest))
    {
      localAPPluginDataInterface.setSaveType(1);
      AppMethodBeat.o(193022);
      return;
    }
    if ((paramAPMidasBaseRequest instanceof APMidasMonthRequest))
    {
      localAPPluginDataInterface.setSaveType(4);
      AppMethodBeat.o(193022);
      return;
    }
    if ((paramAPMidasBaseRequest instanceof APMidasSubscribeRequest)) {
      localAPPluginDataInterface.setSaveType(5);
    }
    AppMethodBeat.o(193022);
  }
  
  static class SingletonHolder
  {
    private static APMidasAnalyzeParams instance;
    
    static
    {
      AppMethodBeat.i(192996);
      instance = new APMidasAnalyzeParams();
      AppMethodBeat.o(192996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.midas.data.APMidasAnalyzeParams
 * JD-Core Version:    0.7.0.1
 */