package com.tencent.tmdatasourcesdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ApkDownUrl
  extends JceStruct
{
  static ArrayList a;
  public byte type = 0;
  public ArrayList urlList = null;
  
  public ApkDownUrl() {}
  
  public ApkDownUrl(byte paramByte, ArrayList paramArrayList)
  {
    this.type = paramByte;
    this.urlList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    if (a == null)
    {
      a = new ArrayList();
      a.add("");
    }
    this.urlList = ((ArrayList)paramJceInputStream.read(a, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.urlList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdatasourcesdk.internal.protocol.jce.ApkDownUrl
 * JD-Core Version:    0.7.0.1
 */