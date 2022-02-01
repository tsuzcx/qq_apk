package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static b JSe;
  public String JRO = "";
  public String JRP = "";
  public String JRQ = "";
  public int JRR = 0;
  public int JRS = 0;
  public b JRT = null;
  public int JRU = 0;
  public int JRV = 0;
  public int JRW = 0;
  public int JRX = 0;
  public short JRY = 0;
  public String JRZ = "";
  public int JSa = 0;
  public String JSb = "";
  public String JSc = "";
  public String JSd = "";
  public String guid = "";
  public String hhd = "";
  public String iNd = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String nUG = "";
  public String uuid = "";
  public String yeO = "";
  
  static
  {
    AppMethodBeat.i(138327);
    JSe = new b();
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
    this.iNd = paramJceInputStream.readString(1, false);
    this.nUG = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.JRO = paramJceInputStream.readString(4, false);
    this.JRP = paramJceInputStream.readString(5, false);
    this.JRQ = paramJceInputStream.readString(6, false);
    this.JRR = paramJceInputStream.read(this.JRR, 7, false);
    this.JRS = paramJceInputStream.read(this.JRS, 8, false);
    this.JRT = ((b)paramJceInputStream.read(JSe, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.JRU = paramJceInputStream.read(this.JRU, 12, false);
    this.JRV = paramJceInputStream.read(this.JRV, 13, false);
    this.JRW = paramJceInputStream.read(this.JRW, 14, false);
    this.JRX = paramJceInputStream.read(this.JRX, 15, false);
    this.uuid = paramJceInputStream.readString(16, false);
    this.JRY = paramJceInputStream.read(this.JRY, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.JRZ = paramJceInputStream.readString(20, false);
    this.JSa = paramJceInputStream.read(this.JSa, 21, false);
    this.JSb = paramJceInputStream.readString(22, false);
    this.hhd = paramJceInputStream.readString(23, false);
    this.yeO = paramJceInputStream.readString(24, false);
    this.JSc = paramJceInputStream.readString(25, false);
    this.JSd = paramJceInputStream.readString(26, false);
    AppMethodBeat.o(138326);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138325);
    paramJceOutputStream.write(this.imei, 0);
    if (this.iNd != null) {
      paramJceOutputStream.write(this.iNd, 1);
    }
    if (this.nUG != null) {
      paramJceOutputStream.write(this.nUG, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.JRO != null) {
      paramJceOutputStream.write(this.JRO, 4);
    }
    if (this.JRP != null) {
      paramJceOutputStream.write(this.JRP, 5);
    }
    if (this.JRQ != null) {
      paramJceOutputStream.write(this.JRQ, 6);
    }
    if (this.JRR != 0) {
      paramJceOutputStream.write(this.JRR, 7);
    }
    if (this.JRS != 0) {
      paramJceOutputStream.write(this.JRS, 8);
    }
    if (this.JRT != null) {
      paramJceOutputStream.write(this.JRT, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.JRU != 0) {
      paramJceOutputStream.write(this.JRU, 12);
    }
    if (this.JRV != 0) {
      paramJceOutputStream.write(this.JRV, 13);
    }
    if (this.JRW != 0) {
      paramJceOutputStream.write(this.JRW, 14);
    }
    if (this.JRX != 0) {
      paramJceOutputStream.write(this.JRX, 15);
    }
    if (this.uuid != null) {
      paramJceOutputStream.write(this.uuid, 16);
    }
    if (this.JRY != 0) {
      paramJceOutputStream.write(this.JRY, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.JRZ != null) {
      paramJceOutputStream.write(this.JRZ, 20);
    }
    if (this.JSa != 0) {
      paramJceOutputStream.write(this.JSa, 21);
    }
    if (this.JSb != null) {
      paramJceOutputStream.write(this.JSb, 22);
    }
    if (this.hhd != null) {
      paramJceOutputStream.write(this.hhd, 23);
    }
    if (this.yeO != null) {
      paramJceOutputStream.write(this.yeO, 24);
    }
    if (this.JSc != null) {
      paramJceOutputStream.write(this.JSc, 25);
    }
    if (this.JSd != null) {
      paramJceOutputStream.write(this.JSd, 26);
    }
    AppMethodBeat.o(138325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.a.c
 * JD-Core Version:    0.7.0.1
 */