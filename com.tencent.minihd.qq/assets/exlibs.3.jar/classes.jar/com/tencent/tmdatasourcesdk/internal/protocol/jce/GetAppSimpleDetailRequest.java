package com.tencent.tmdatasourcesdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAppSimpleDetailRequest
  extends JceStruct
{
  static ArrayList a;
  public ArrayList appReqList = null;
  
  public GetAppSimpleDetailRequest() {}
  
  public GetAppSimpleDetailRequest(ArrayList paramArrayList)
  {
    this.appReqList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (a == null)
    {
      a = new ArrayList();
      AppDetailParam localAppDetailParam = new AppDetailParam();
      a.add(localAppDetailParam);
    }
    this.appReqList = ((ArrayList)paramJceInputStream.read(a, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.appReqList != null) {
      paramJceOutputStream.write(this.appReqList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdatasourcesdk.internal.protocol.jce.GetAppSimpleDetailRequest
 * JD-Core Version:    0.7.0.1
 */