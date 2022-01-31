package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  static b wLT = new b();
  public String dCX = "";
  public String fig = "";
  public String guid = "";
  public String ilD = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String oAl = "";
  public String wLC = "";
  public String wLD = "";
  public String wLE = "";
  public int wLF = 0;
  public int wLG = 0;
  public b wLH = null;
  public int wLI = 0;
  public int wLJ = 0;
  public int wLK = 0;
  public int wLL = 0;
  public short wLM = 0;
  public String wLN = "";
  public int wLO = 0;
  public String wLP = "";
  public String wLQ = "";
  public String wLR = "";
  public String wLS = "";
  
  public final JceStruct newInit()
  {
    return new c();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, true);
    this.fig = paramJceInputStream.readString(1, false);
    this.ilD = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.wLC = paramJceInputStream.readString(4, false);
    this.wLD = paramJceInputStream.readString(5, false);
    this.wLE = paramJceInputStream.readString(6, false);
    this.wLF = paramJceInputStream.read(this.wLF, 7, false);
    this.wLG = paramJceInputStream.read(this.wLG, 8, false);
    this.wLH = ((b)paramJceInputStream.read(wLT, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.wLI = paramJceInputStream.read(this.wLI, 12, false);
    this.wLJ = paramJceInputStream.read(this.wLJ, 13, false);
    this.wLK = paramJceInputStream.read(this.wLK, 14, false);
    this.wLL = paramJceInputStream.read(this.wLL, 15, false);
    this.dCX = paramJceInputStream.readString(16, false);
    this.wLM = paramJceInputStream.read(this.wLM, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.wLN = paramJceInputStream.readString(20, false);
    this.wLO = paramJceInputStream.read(this.wLO, 21, false);
    this.wLP = paramJceInputStream.readString(22, false);
    this.wLQ = paramJceInputStream.readString(23, false);
    this.oAl = paramJceInputStream.readString(24, false);
    this.wLR = paramJceInputStream.readString(25, false);
    this.wLS = paramJceInputStream.readString(26, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imei, 0);
    if (this.fig != null) {
      paramJceOutputStream.write(this.fig, 1);
    }
    if (this.ilD != null) {
      paramJceOutputStream.write(this.ilD, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.wLC != null) {
      paramJceOutputStream.write(this.wLC, 4);
    }
    if (this.wLD != null) {
      paramJceOutputStream.write(this.wLD, 5);
    }
    if (this.wLE != null) {
      paramJceOutputStream.write(this.wLE, 6);
    }
    if (this.wLF != 0) {
      paramJceOutputStream.write(this.wLF, 7);
    }
    if (this.wLG != 0) {
      paramJceOutputStream.write(this.wLG, 8);
    }
    if (this.wLH != null) {
      paramJceOutputStream.write(this.wLH, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.wLI != 0) {
      paramJceOutputStream.write(this.wLI, 12);
    }
    if (this.wLJ != 0) {
      paramJceOutputStream.write(this.wLJ, 13);
    }
    if (this.wLK != 0) {
      paramJceOutputStream.write(this.wLK, 14);
    }
    if (this.wLL != 0) {
      paramJceOutputStream.write(this.wLL, 15);
    }
    if (this.dCX != null) {
      paramJceOutputStream.write(this.dCX, 16);
    }
    if (this.wLM != 0) {
      paramJceOutputStream.write(this.wLM, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.wLN != null) {
      paramJceOutputStream.write(this.wLN, 20);
    }
    if (this.wLO != 0) {
      paramJceOutputStream.write(this.wLO, 21);
    }
    if (this.wLP != null) {
      paramJceOutputStream.write(this.wLP, 22);
    }
    if (this.wLQ != null) {
      paramJceOutputStream.write(this.wLQ, 23);
    }
    if (this.oAl != null) {
      paramJceOutputStream.write(this.oAl, 24);
    }
    if (this.wLR != null) {
      paramJceOutputStream.write(this.wLR, 25);
    }
    if (this.wLS != null) {
      paramJceOutputStream.write(this.wLS, 26);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.c.a.c
 * JD-Core Version:    0.7.0.1
 */