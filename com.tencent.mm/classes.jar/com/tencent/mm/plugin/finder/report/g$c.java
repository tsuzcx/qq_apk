package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportSceneResult;", "", "mediaId", "", "(Ljava/lang/String;)V", "averageConnectCost", "", "getAverageConnectCost", "()I", "setAverageConnectCost", "(I)V", "averageSpeed", "getAverageSpeed", "setAverageSpeed", "clientIP", "getClientIP", "()Ljava/lang/String;", "setClientIP", "enQueueTime", "", "getEnQueueTime", "()J", "setEnQueueTime", "(J)V", "endTime", "getEndTime", "setEndTime", "fileLength", "getFileLength", "setFileLength", "firstConnectCost", "getFirstConnectCost", "setFirstConnectCost", "firstRequestCompleted", "", "getFirstRequestCompleted", "()Z", "setFirstRequestCompleted", "(Z)V", "firstRequestCost", "getFirstRequestCost", "setFirstRequestCost", "firstRequestDownloadSize", "getFirstRequestDownloadSize", "setFirstRequestDownloadSize", "firstRequestSize", "getFirstRequestSize", "setFirstRequestSize", "isCrossNet", "setCrossNet", "getMediaId", "moovCompleted", "getMoovCompleted", "setMoovCompleted", "moovCost", "getMoovCost", "setMoovCost", "moovFailReason", "getMoovFailReason", "setMoovFailReason", "moovRequestTimes", "getMoovRequestTimes", "setMoovRequestTimes", "moovSize", "getMoovSize", "setMoovSize", "netConnectTimes", "getNetConnectTimes", "setNetConnectTimes", "netType", "getNetType", "setNetType", "recvedBytes", "getRecvedBytes", "setRecvedBytes", "retCode", "getRetCode", "setRetCode", "rptIpList", "getRptIpList", "setRptIpList", "startTime", "getStartTime", "setStartTime", "svrIp", "getSvrIp", "setSvrIp", "svrPort", "getSvrPort", "setSvrPort", "transportProtocol", "getTransportProtocol", "setTransportProtocol", "transportProtocolError", "getTransportProtocolError", "setTransportProtocolError", "component1", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class g$c
{
  String DkV;
  int DkW;
  String KVI;
  boolean KVJ;
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
  long hWY;
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
  long startTime;
  int transportProtocol;
  int transportProtocolError;
  
  public g$c(String paramString)
  {
    AppMethodBeat.i(198861);
    this.mediaId = paramString;
    this.KVI = "";
    this.clientIP = "";
    this.DkV = "";
    AppMethodBeat.o(198861);
  }
  
  public final void aVw(String paramString)
  {
    AppMethodBeat.i(198858);
    k.h(paramString, "<set-?>");
    this.KVI = paramString;
    AppMethodBeat.o(198858);
  }
  
  public final void aVx(String paramString)
  {
    AppMethodBeat.i(198859);
    k.h(paramString, "<set-?>");
    this.clientIP = paramString;
    AppMethodBeat.o(198859);
  }
  
  public final void aVy(String paramString)
  {
    AppMethodBeat.i(198860);
    k.h(paramString, "<set-?>");
    this.DkV = paramString;
    AppMethodBeat.o(198860);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198864);
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
      AppMethodBeat.o(198864);
      return true;
    }
    AppMethodBeat.o(198864);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198863);
    String str = this.mediaId;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(198863);
      return i;
    }
    AppMethodBeat.o(198863);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198862);
    String str = "ReportSceneResult(mediaId=" + this.mediaId + ")";
    AppMethodBeat.o(198862);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.g.c
 * JD-Core Version:    0.7.0.1
 */