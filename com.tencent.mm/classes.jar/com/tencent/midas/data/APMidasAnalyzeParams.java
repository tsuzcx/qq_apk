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
    AppMethodBeat.i(253283);
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
      AppMethodBeat.o(253283);
      return;
    }
    catch (Exception paramAPMidasBaseRequest)
    {
      APLog.i("AnalyzeCommParams", paramAPMidasBaseRequest.toString());
      AppMethodBeat.o(253283);
    }
  }
  
  public static APMidasAnalyzeParams getInstance()
  {
    AppMethodBeat.i(253278);
    APMidasAnalyzeParams localAPMidasAnalyzeParams = SingletonHolder.instance;
    AppMethodBeat.o(253278);
    return localAPMidasAnalyzeParams;
  }
  
  public void AnalyzeParams(APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(253279);
    if (paramAPMidasBaseRequest != null)
    {
      AnalyzeCommParams(paramAPMidasBaseRequest);
      setSaveType(paramAPMidasBaseRequest);
    }
    AppMethodBeat.o(253279);
  }
  
  public void setSaveType(APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(253281);
    APPluginDataInterface localAPPluginDataInterface = APPluginDataInterface.singleton();
    try
    {
      if ((paramAPMidasBaseRequest instanceof APMidasGameRequest))
      {
        if (paramAPMidasBaseRequest.acctType.equals("qb"))
        {
          localAPPluginDataInterface.setSaveType(3);
          AppMethodBeat.o(253281);
          return;
        }
        localAPPluginDataInterface.setSaveType(0);
        AppMethodBeat.o(253281);
        return;
      }
    }
    catch (Exception paramAPMidasBaseRequest)
    {
      APLog.i("setSaveType", paramAPMidasBaseRequest.toString());
      AppMethodBeat.o(253281);
      return;
    }
    if ((paramAPMidasBaseRequest instanceof APMidasGoodsRequest))
    {
      localAPPluginDataInterface.setSaveType(1);
      AppMethodBeat.o(253281);
      return;
    }
    if ((paramAPMidasBaseRequest instanceof APMidasMonthRequest))
    {
      localAPPluginDataInterface.setSaveType(4);
      AppMethodBeat.o(253281);
      return;
    }
    if ((paramAPMidasBaseRequest instanceof APMidasSubscribeRequest)) {
      localAPPluginDataInterface.setSaveType(5);
    }
    AppMethodBeat.o(253281);
  }
  
  static class SingletonHolder
  {
    private static APMidasAnalyzeParams instance;
    
    static
    {
      AppMethodBeat.i(253292);
      instance = new APMidasAnalyzeParams();
      AppMethodBeat.o(253292);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.data.APMidasAnalyzeParams
 * JD-Core Version:    0.7.0.1
 */