package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static b LLV;
  public String FtF = "";
  public String LLG = "";
  public String LLH = "";
  public int LLI = 0;
  public int LLJ = 0;
  public b LLK = null;
  public int LLL = 0;
  public int LLM = 0;
  public int LLN = 0;
  public int LLO = 0;
  public short LLP = 0;
  public String LLQ = "";
  public int LLR = 0;
  public String LLS = "";
  public String LLT = "";
  public String LLU = "";
  public String guid = "";
  public String hzm = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public String jgm = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String oyb = "";
  public String uuid = "";
  public String zuP = "";
  
  static
  {
    AppMethodBeat.i(138327);
    LLV = new b();
    AppMethodBeat.o(138327);
  }
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(138324);
    c localc = new c();
    AppMethodBeat.o(138324);
    return localc;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138326);
    this.imei = paramJceInputStream.readString(0, true);
    this.jgm = paramJceInputStream.readString(1, false);
    this.oyb = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.LLG = paramJceInputStream.readString(4, false);
    this.LLH = paramJceInputStream.readString(5, false);
    this.FtF = paramJceInputStream.readString(6, false);
    this.LLI = paramJceInputStream.read(this.LLI, 7, false);
    this.LLJ = paramJceInputStream.read(this.LLJ, 8, false);
    this.LLK = ((b)paramJceInputStream.read(LLV, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.LLL = paramJceInputStream.read(this.LLL, 12, false);
    this.LLM = paramJceInputStream.read(this.LLM, 13, false);
    this.LLN = paramJceInputStream.read(this.LLN, 14, false);
    this.LLO = paramJceInputStream.read(this.LLO, 15, false);
    this.uuid = paramJceInputStream.readString(16, false);
    this.LLP = paramJceInputStream.read(this.LLP, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.LLQ = paramJceInputStream.readString(20, false);
    this.LLR = paramJceInputStream.read(this.LLR, 21, false);
    this.LLS = paramJceInputStream.readString(22, false);
    this.hzm = paramJceInputStream.readString(23, false);
    this.zuP = paramJceInputStream.readString(24, false);
    this.LLT = paramJceInputStream.readString(25, false);
    this.LLU = paramJceInputStream.readString(26, false);
    AppMethodBeat.o(138326);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138325);
    paramJceOutputStream.write(this.imei, 0);
    if (this.jgm != null) {
      paramJceOutputStream.write(this.jgm, 1);
    }
    if (this.oyb != null) {
      paramJceOutputStream.write(this.oyb, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.LLG != null) {
      paramJceOutputStream.write(this.LLG, 4);
    }
    if (this.LLH != null) {
      paramJceOutputStream.write(this.LLH, 5);
    }
    if (this.FtF != null) {
      paramJceOutputStream.write(this.FtF, 6);
    }
    if (this.LLI != 0) {
      paramJceOutputStream.write(this.LLI, 7);
    }
    if (this.LLJ != 0) {
      paramJceOutputStream.write(this.LLJ, 8);
    }
    if (this.LLK != null) {
      paramJceOutputStream.write(this.LLK, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.LLL != 0) {
      paramJceOutputStream.write(this.LLL, 12);
    }
    if (this.LLM != 0) {
      paramJceOutputStream.write(this.LLM, 13);
    }
    if (this.LLN != 0) {
      paramJceOutputStream.write(this.LLN, 14);
    }
    if (this.LLO != 0) {
      paramJceOutputStream.write(this.LLO, 15);
    }
    if (this.uuid != null) {
      paramJceOutputStream.write(this.uuid, 16);
    }
    if (this.LLP != 0) {
      paramJceOutputStream.write(this.LLP, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.LLQ != null) {
      paramJceOutputStream.write(this.LLQ, 20);
    }
    if (this.LLR != 0) {
      paramJceOutputStream.write(this.LLR, 21);
    }
    if (this.LLS != null) {
      paramJceOutputStream.write(this.LLS, 22);
    }
    if (this.hzm != null) {
      paramJceOutputStream.write(this.hzm, 23);
    }
    if (this.zuP != null) {
      paramJceOutputStream.write(this.zuP, 24);
    }
    if (this.LLT != null) {
      paramJceOutputStream.write(this.LLT, 25);
    }
    if (this.LLU != null) {
      paramJceOutputStream.write(this.LLU, 26);
    }
    AppMethodBeat.o(138325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.a.c
 * JD-Core Version:    0.7.0.1
 */