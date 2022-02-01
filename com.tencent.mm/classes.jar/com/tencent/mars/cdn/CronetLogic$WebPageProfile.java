package com.tencent.mars.cdn;

public class CronetLogic$WebPageProfile
{
  public long SSLconnectionEnd;
  public long SSLconnectionStart;
  public long connectEnd;
  public long connectStart;
  public long domainLookUpEnd;
  public long domainLookUpStart;
  public int downstreamThroughputKbpsEstimate;
  public long fetchStart;
  public int httpRttEstimate;
  public int networkTypeEstimate;
  public String peerIP = "";
  public int port;
  public String protocol = "";
  public long receivedBytedCount;
  public long redirectEnd;
  public long redirectStart;
  public long requestEnd;
  public long requestStart;
  public long responseEnd;
  public long responseStart;
  public int rtt;
  public long sendBytesCount;
  public boolean socketReused;
  public int statusCode;
  public int throughputKbps;
  public int transportRttEstimate;
  
  public String toString()
  {
    return "WebPageProfile{redirectStart=" + this.redirectStart + ", redirectEnd=" + this.redirectEnd + ", fetchStart=" + this.fetchStart + ", domainLookUpStart=" + this.domainLookUpStart + ", domainLookUpEnd=" + this.domainLookUpEnd + ", connectStart=" + this.connectStart + ", connectEnd=" + this.connectEnd + ", SSLconnectionStart=" + this.SSLconnectionStart + ", SSLconnectionEnd=" + this.SSLconnectionEnd + ", requestStart=" + this.requestStart + ", requestEnd=" + this.requestEnd + ", responseStart=" + this.responseStart + ", responseEnd=" + this.responseEnd + ", protocol='" + this.protocol + '\'' + ", rtt=" + this.rtt + ", statusCode=" + this.statusCode + ", networkTypeEstimate=" + this.networkTypeEstimate + ", httpRttEstimate=" + this.httpRttEstimate + ", transportRttEstimate=" + this.transportRttEstimate + ", downstreamThroughputKbpsEstimate=" + this.downstreamThroughputKbpsEstimate + ", throughputKbps=" + this.throughputKbps + ", peerIP='" + this.peerIP + '\'' + ", port=" + this.port + ", socketReused=" + this.socketReused + ", sendBytesCount=" + this.sendBytesCount + ", receivedBytedCount=" + this.receivedBytedCount + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.cdn.CronetLogic.WebPageProfile
 * JD-Core Version:    0.7.0.1
 */