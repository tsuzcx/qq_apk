package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class OperateDownloadTaskRequest
  extends JceStruct
{
  static IPCBaseParam a;
  public String actionFlag = "";
  public IPCBaseParam baseParam = null;
  public String opList = "";
  public int requestType = 0;
  public String verifyType = "";
  
  public OperateDownloadTaskRequest() {}
  
  public OperateDownloadTaskRequest(int paramInt, IPCBaseParam paramIPCBaseParam, String paramString1, String paramString2, String paramString3)
  {
    this.requestType = paramInt;
    this.baseParam = paramIPCBaseParam;
    this.opList = paramString1;
    this.actionFlag = paramString2;
    this.verifyType = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.requestType = paramJceInputStream.read(this.requestType, 0, true);
    if (a == null) {
      a = new IPCBaseParam();
    }
    this.baseParam = ((IPCBaseParam)paramJceInputStream.read(a, 1, true));
    this.opList = paramJceInputStream.readString(2, false);
    this.actionFlag = paramJceInputStream.readString(3, false);
    this.verifyType = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.requestType, 0);
    paramJceOutputStream.write(this.baseParam, 1);
    if (this.opList != null) {
      paramJceOutputStream.write(this.opList, 2);
    }
    if (this.actionFlag != null) {
      paramJceOutputStream.write(this.actionFlag, 3);
    }
    if (this.verifyType != null) {
      paramJceOutputStream.write(this.verifyType, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.OperateDownloadTaskRequest
 * JD-Core Version:    0.7.0.1
 */