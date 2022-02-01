package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "", "mediaId", "", "(Ljava/lang/String;)V", "averageConnectCost", "", "getAverageConnectCost", "()I", "setAverageConnectCost", "(I)V", "averageSpeed", "getAverageSpeed", "setAverageSpeed", "clientIP", "getClientIP", "()Ljava/lang/String;", "setClientIP", "enQueueTime", "", "getEnQueueTime", "()J", "setEnQueueTime", "(J)V", "endTime", "getEndTime", "setEndTime", "fileLength", "getFileLength", "setFileLength", "firstConnectCost", "getFirstConnectCost", "setFirstConnectCost", "firstRequestCompleted", "", "getFirstRequestCompleted", "()Z", "setFirstRequestCompleted", "(Z)V", "firstRequestCost", "getFirstRequestCost", "setFirstRequestCost", "firstRequestDownloadSize", "getFirstRequestDownloadSize", "setFirstRequestDownloadSize", "firstRequestSize", "getFirstRequestSize", "setFirstRequestSize", "isCrossNet", "setCrossNet", "getMediaId", "moovCompleted", "getMoovCompleted", "setMoovCompleted", "moovCost", "getMoovCost", "setMoovCost", "moovFailReason", "getMoovFailReason", "setMoovFailReason", "moovRequestTimes", "getMoovRequestTimes", "setMoovRequestTimes", "moovSize", "getMoovSize", "setMoovSize", "netConnectTimes", "getNetConnectTimes", "setNetConnectTimes", "netType", "getNetType", "setNetType", "recvedBytes", "getRecvedBytes", "setRecvedBytes", "retCode", "getRetCode", "setRetCode", "rptIpList", "getRptIpList", "setRptIpList", "startTime", "getStartTime", "setStartTime", "svrIp", "getSvrIp", "setSvrIp", "svrPort", "getSvrPort", "setSvrPort", "transportProtocol", "getTransportProtocol", "setTransportProtocol", "transportProtocolError", "getTransportProtocolError", "setTransportProtocolError", "component1", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class m$c
{
  int averageConnectCost;
  int averageSpeed;
  String clientIP;
  long enQueueTime;
  long endTime;
  int firstConnectCost;
  boolean firstRequestCompleted;
  int firstRequestCost;
  int firstRequestDownloadSize;
  int firstRequestSize;
  long ixc;
  private final String mediaId;
  boolean moovCompleted;
  int moovCost;
  int moovFailReason;
  int moovRequestTimes;
  int moovSize;
  int netConnectTimes;
  int netType;
  long recvedBytes;
  int retCode;
  String rzU;
  boolean rzV;
  String rzW;
  int rzX;
  long startTime;
  int transportProtocol;
  int transportProtocolError;
  
  public m$c(String paramString)
  {
    AppMethodBeat.i(202814);
    this.mediaId = paramString;
    this.rzU = "";
    this.clientIP = "";
    this.rzW = "";
    AppMethodBeat.o(202814);
  }
  
  public final void adQ(String paramString)
  {
    AppMethodBeat.i(202811);
    k.h(paramString, "<set-?>");
    this.rzU = paramString;
    AppMethodBeat.o(202811);
  }
  
  public final void adR(String paramString)
  {
    AppMethodBeat.i(202812);
    k.h(paramString, "<set-?>");
    this.clientIP = paramString;
    AppMethodBeat.o(202812);
  }
  
  public final void adS(String paramString)
  {
    AppMethodBeat.i(202813);
    k.h(paramString, "<set-?>");
    this.rzW = paramString;
    AppMethodBeat.o(202813);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202817);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if (!k.g(this.mediaId, paramObject.mediaId)) {}
      }
    }
    else
    {
      AppMethodBeat.o(202817);
      return true;
    }
    AppMethodBeat.o(202817);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(202816);
    String str = this.mediaId;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(202816);
      return i;
    }
    AppMethodBeat.o(202816);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202815);
    String str = "ReportSceneResult(mediaId=" + this.mediaId + ")";
    AppMethodBeat.o(202815);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.m.c
 * JD-Core Version:    0.7.0.1
 */