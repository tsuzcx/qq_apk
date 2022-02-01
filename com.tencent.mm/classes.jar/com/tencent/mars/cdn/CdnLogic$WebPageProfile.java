package com.tencent.mars.cdn;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CdnLogic$WebPageProfile
  implements Parcelable
{
  public static final Parcelable.Creator<WebPageProfile> CREATOR = new Parcelable.Creator()
  {
    public CdnLogic.WebPageProfile createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CdnLogic.WebPageProfile(paramAnonymousParcel);
    }
    
    public CdnLogic.WebPageProfile[] newArray(int paramAnonymousInt)
    {
      return new CdnLogic.WebPageProfile[paramAnonymousInt];
    }
  };
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
  
  public CdnLogic$WebPageProfile() {}
  
  protected CdnLogic$WebPageProfile(Parcel paramParcel)
  {
    this.redirectStart = paramParcel.readLong();
    this.redirectEnd = paramParcel.readLong();
    this.fetchStart = paramParcel.readLong();
    this.domainLookUpStart = paramParcel.readLong();
    this.domainLookUpEnd = paramParcel.readLong();
    this.connectStart = paramParcel.readLong();
    this.connectEnd = paramParcel.readLong();
    this.SSLconnectionStart = paramParcel.readLong();
    this.SSLconnectionEnd = paramParcel.readLong();
    this.requestStart = paramParcel.readLong();
    this.requestEnd = paramParcel.readLong();
    this.responseStart = paramParcel.readLong();
    this.responseEnd = paramParcel.readLong();
    this.protocol = paramParcel.readString();
    this.rtt = paramParcel.readInt();
    this.statusCode = paramParcel.readInt();
    this.networkTypeEstimate = paramParcel.readInt();
    this.httpRttEstimate = paramParcel.readInt();
    this.transportRttEstimate = paramParcel.readInt();
    this.downstreamThroughputKbpsEstimate = paramParcel.readInt();
    this.throughputKbps = paramParcel.readInt();
    this.peerIP = paramParcel.readString();
    this.port = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.socketReused = bool;
      this.sendBytesCount = paramParcel.readLong();
      this.receivedBytedCount = paramParcel.readLong();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WebPageProfile{redirectStart=" + this.redirectStart + ", redirectEnd=" + this.redirectEnd + ", fetchStart=" + this.fetchStart + ", domainLookUpStart=" + this.domainLookUpStart + ", domainLookUpEnd=" + this.domainLookUpEnd + ", connectStart=" + this.connectStart + ", connectEnd=" + this.connectEnd + ", SSLconnectionStart=" + this.SSLconnectionStart + ", SSLconnectionEnd=" + this.SSLconnectionEnd + ", requestStart=" + this.requestStart + ", requestEnd=" + this.requestEnd + ", responseStart=" + this.responseStart + ", responseEnd=" + this.responseEnd + ", protocol='" + this.protocol + '\'' + ", rtt=" + this.rtt + ", statusCode=" + this.statusCode + ", networkTypeEstimate=" + this.networkTypeEstimate + ", httpRttEstimate=" + this.httpRttEstimate + ", transportRttEstimate=" + this.transportRttEstimate + ", downstreamThroughputKbpsEstimate=" + this.downstreamThroughputKbpsEstimate + ", throughputKbps=" + this.throughputKbps + ", peerIP='" + this.peerIP + '\'' + ", port=" + this.port + ", socketReused=" + this.socketReused + ", sendBytesCount=" + this.sendBytesCount + ", receivedBytedCount=" + this.receivedBytedCount + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.redirectStart);
    paramParcel.writeLong(this.redirectEnd);
    paramParcel.writeLong(this.fetchStart);
    paramParcel.writeLong(this.domainLookUpStart);
    paramParcel.writeLong(this.domainLookUpEnd);
    paramParcel.writeLong(this.connectStart);
    paramParcel.writeLong(this.connectEnd);
    paramParcel.writeLong(this.SSLconnectionStart);
    paramParcel.writeLong(this.SSLconnectionEnd);
    paramParcel.writeLong(this.requestStart);
    paramParcel.writeLong(this.requestEnd);
    paramParcel.writeLong(this.responseStart);
    paramParcel.writeLong(this.responseEnd);
    paramParcel.writeString(this.protocol);
    paramParcel.writeInt(this.rtt);
    paramParcel.writeInt(this.statusCode);
    paramParcel.writeInt(this.networkTypeEstimate);
    paramParcel.writeInt(this.httpRttEstimate);
    paramParcel.writeInt(this.transportRttEstimate);
    paramParcel.writeInt(this.downstreamThroughputKbpsEstimate);
    paramParcel.writeInt(this.throughputKbps);
    paramParcel.writeString(this.peerIP);
    paramParcel.writeInt(this.port);
    if (this.socketReused) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.sendBytesCount);
      paramParcel.writeLong(this.receivedBytedCount);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic.WebPageProfile
 * JD-Core Version:    0.7.0.1
 */