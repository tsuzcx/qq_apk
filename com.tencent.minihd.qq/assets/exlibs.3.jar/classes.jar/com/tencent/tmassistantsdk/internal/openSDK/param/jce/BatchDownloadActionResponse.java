package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BatchDownloadActionResponse
  extends JceStruct
{
  static ArrayList a;
  public ArrayList batchData = null;
  public int batchRequestType = 0;
  
  public BatchDownloadActionResponse() {}
  
  public BatchDownloadActionResponse(int paramInt, ArrayList paramArrayList)
  {
    this.batchRequestType = paramInt;
    this.batchData = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.batchRequestType = paramJceInputStream.read(this.batchRequestType, 0, true);
    if (a == null)
    {
      a = new ArrayList();
      IPCQueryDownloadInfo localIPCQueryDownloadInfo = new IPCQueryDownloadInfo();
      a.add(localIPCQueryDownloadInfo);
    }
    this.batchData = ((ArrayList)paramJceInputStream.read(a, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.batchRequestType, 0);
    if (this.batchData != null) {
      paramJceOutputStream.write(this.batchData, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionResponse
 * JD-Core Version:    0.7.0.1
 */