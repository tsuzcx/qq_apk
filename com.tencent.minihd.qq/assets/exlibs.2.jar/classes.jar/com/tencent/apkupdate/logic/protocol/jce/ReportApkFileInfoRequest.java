package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReportApkFileInfoRequest
  extends JceStruct
{
  static ArrayList cache_apkFileInfoList;
  public ArrayList apkFileInfoList = null;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_apkFileInfoList == null)
    {
      cache_apkFileInfoList = new ArrayList();
      ApkFileInfo localApkFileInfo = new ApkFileInfo();
      cache_apkFileInfoList.add(localApkFileInfo);
    }
    this.apkFileInfoList = ((ArrayList)paramJceInputStream.read(cache_apkFileInfoList, 0, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.apkFileInfoList, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.ReportApkFileInfoRequest
 * JD-Core Version:    0.7.0.1
 */