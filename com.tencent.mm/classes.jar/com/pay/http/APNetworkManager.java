package com.pay.http;

import android.text.TextUtils;
import com.pay.network.model.APDataReportAns;
import com.pay.network.model.APDataReportReq;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APPluginDataInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class APNetworkManager
{
  public static final String HTTP_KEY_DATAREPORT = "datareport";
  public static final String HTTP_KEY_INITREPORT = "initreport";
  private static APNetworkManager gInstance = null;
  private HashMap<String, APBaseHttpReq> httpReqMap;
  
  public APNetworkManager()
  {
    AppMethodBeat.i(207509);
    this.httpReqMap = new HashMap();
    AppMethodBeat.o(207509);
  }
  
  public static void cancelRequest(String paramString)
  {
    AppMethodBeat.i(207526);
    APBaseHttpReq localAPBaseHttpReq = (APBaseHttpReq)gInstance.httpReqMap.get(paramString);
    if (localAPBaseHttpReq != null)
    {
      localAPBaseHttpReq.stopRequest();
      gInstance.httpReqMap.remove(paramString);
    }
    AppMethodBeat.o(207526);
  }
  
  public static APNetworkManager getInstance()
  {
    AppMethodBeat.i(207515);
    if (gInstance == null) {
      gInstance = APNetworkManagerHolder.INSTANCE;
    }
    APNetworkManager localAPNetworkManager = gInstance;
    AppMethodBeat.o(207515);
    return localAPNetworkManager;
  }
  
  public static void release()
  {
    gInstance = null;
  }
  
  public void cancelPreRequest()
  {
    AppMethodBeat.i(207540);
    if (gInstance.httpReqMap != null)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = gInstance.httpReqMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (localEntry != null) {
          localArrayList.add((APBaseHttpReq)localEntry.getValue());
        }
      }
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        localObject = (APBaseHttpReq)localArrayList.get(i);
        if (localObject != null) {
          ((APBaseHttpReq)localObject).stopRequest();
        }
        i += 1;
      }
      gInstance.httpReqMap.clear();
    }
    AppMethodBeat.o(207540);
  }
  
  public void dataReport(String paramString, IAPHttpAnsObserver paramIAPHttpAnsObserver)
  {
    AppMethodBeat.i(207550);
    if (TextUtils.isEmpty(APPluginDataInterface.singleton().getOfferId()))
    {
      AppMethodBeat.o(207550);
      return;
    }
    APDataReportReq localAPDataReportReq = new APDataReportReq();
    localAPDataReportReq.setHttpAns(new APDataReportAns(APHttpHandle.getIntanceHandel(), paramIAPHttpAnsObserver, this.httpReqMap, "datareport"));
    localAPDataReportReq.startService(paramString);
    AppMethodBeat.o(207550);
  }
  
  static class APNetworkManagerHolder
  {
    private static final APNetworkManager INSTANCE;
    
    static
    {
      AppMethodBeat.i(207519);
      INSTANCE = new APNetworkManager();
      AppMethodBeat.o(207519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.pay.http.APNetworkManager
 * JD-Core Version:    0.7.0.1
 */