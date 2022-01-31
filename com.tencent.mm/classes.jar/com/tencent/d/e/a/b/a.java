package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<e> wNQ;
  public int bUR = 0;
  public String bwK = "";
  public String egI = "";
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int qUT = 0;
  public int requestType = 0;
  public int sdkVer = 0;
  public String wLC = "";
  public long wNK = 0L;
  public String wNL = "";
  public ArrayList<e> wNM = null;
  public String wNN = "";
  public String wNO = "";
  public int wNP = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wNK = paramJceInputStream.read(this.wNK, 0, true);
    this.wNL = paramJceInputStream.readString(1, true);
    if (wNQ == null)
    {
      wNQ = new ArrayList();
      e locale = new e();
      wNQ.add(locale);
    }
    this.wNM = ((ArrayList)paramJceInputStream.read(wNQ, 2, true));
    this.qUT = paramJceInputStream.read(this.qUT, 3, true);
    this.wLC = paramJceInputStream.readString(4, true);
    this.bUR = paramJceInputStream.read(this.bUR, 5, true);
    this.requestType = paramJceInputStream.read(this.requestType, 6, true);
    this.wNN = paramJceInputStream.readString(7, true);
    this.imei = paramJceInputStream.readString(8, false);
    this.imsi = paramJceInputStream.readString(9, false);
    this.egI = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.wNO = paramJceInputStream.readString(12, false);
    this.wNP = paramJceInputStream.read(this.wNP, 13, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 14, false);
    this.bwK = paramJceInputStream.readString(15, false);
    this.platform = paramJceInputStream.read(this.platform, 16, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wNK, 0);
    paramJceOutputStream.write(this.wNL, 1);
    paramJceOutputStream.write(this.wNM, 2);
    paramJceOutputStream.write(this.qUT, 3);
    paramJceOutputStream.write(this.wLC, 4);
    paramJceOutputStream.write(this.bUR, 5);
    paramJceOutputStream.write(this.requestType, 6);
    paramJceOutputStream.write(this.wNN, 7);
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 8);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 9);
    }
    if (this.egI != null) {
      paramJceOutputStream.write(this.egI, 10);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 11);
    }
    if (this.wNO != null) {
      paramJceOutputStream.write(this.wNO, 12);
    }
    if (this.wNP != 0) {
      paramJceOutputStream.write(this.wNP, 13);
    }
    if (this.sdkVer != 0) {
      paramJceOutputStream.write(this.sdkVer, 14);
    }
    if (this.bwK != null) {
      paramJceOutputStream.write(this.bwK, 15);
    }
    paramJceOutputStream.write(this.platform, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */