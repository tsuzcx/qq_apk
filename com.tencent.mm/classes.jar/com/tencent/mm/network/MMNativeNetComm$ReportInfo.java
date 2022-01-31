package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMNativeNetComm$ReportInfo
{
  public long actionId = 0L;
  public long beginTime = 0L;
  public String clientIp = "";
  public long connCostTime = 0L;
  public long connTotalCostTime = 0L;
  public long dnsCostTime = 0L;
  public int dnsErrType = 0;
  public String dnsSvrIp = "";
  public int endFlag = 0;
  public int endStep = 0;
  public long endTime = 0L;
  public int errCode = 0;
  public int errType = 0;
  public long expand1 = 0L;
  public long expand2 = 0L;
  public String extraInfo = "";
  public long firstPkgTime = 0L;
  public String host = "";
  public String ip = "";
  public int ipType = 0;
  public boolean isSocket = false;
  public int localIp = 0;
  public long netSignal = 0L;
  public int netType = 0;
  public int newNetType = 0;
  public long newdnsCostTime = 0L;
  public int newdnsErrCode = 0;
  public int newdnsErrType = 0;
  public int port = 0;
  public long recvSize = 0L;
  public int refTime1 = 0;
  public int refTime2 = 0;
  public int refTime3 = 0;
  public int retryCount = 0;
  public long rtType = 0L;
  public long sendSize = 0L;
  public int subNetType = 0;
  public int usedIpIndex = 0;
  
  public String toString()
  {
    AppMethodBeat.i(58641);
    String str = String.format("actionId:%d, rtType:%d, begin:%d, end:%d, cost:%d, ip:%s, port:%d, isSocket:%b, netType:%d, ipType:%d, sendSize:%d, recvSize:%d, errType:%d, errCode:%d, netSignal:%d, retryCount:%d, expand1:%d, clientip:%s, expand2:%d, newNetType:%d, subNetType:%d, extraInfo:%s, host:%s, endStep:%d, endFlag:%d", new Object[] { Long.valueOf(this.actionId), Long.valueOf(this.rtType), Long.valueOf(this.beginTime), Long.valueOf(this.endTime), Long.valueOf(this.endTime - this.beginTime), this.ip, Integer.valueOf(this.port), Boolean.valueOf(this.isSocket), Integer.valueOf(this.netType), Integer.valueOf(this.ipType), Long.valueOf(this.sendSize), Long.valueOf(this.recvSize), Integer.valueOf(this.errType), Integer.valueOf(this.errCode), Long.valueOf(this.netSignal), Integer.valueOf(this.retryCount), Long.valueOf(this.expand1), this.clientIp, Long.valueOf(this.expand2), Integer.valueOf(this.newNetType), Integer.valueOf(this.subNetType), this.extraInfo, this.host, Integer.valueOf(this.endStep), Integer.valueOf(this.endFlag) });
    AppMethodBeat.o(58641);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.MMNativeNetComm.ReportInfo
 * JD-Core Version:    0.7.0.1
 */