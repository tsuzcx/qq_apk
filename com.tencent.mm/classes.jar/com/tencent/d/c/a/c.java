package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static b MiU;
  public String FMd = "";
  public String MiF = "";
  public String MiG = "";
  public int MiH = 0;
  public int MiI = 0;
  public b MiJ = null;
  public int MiK = 0;
  public int MiL = 0;
  public int MiM = 0;
  public int MiN = 0;
  public short MiO = 0;
  public String MiP = "";
  public int MiQ = 0;
  public String MiR = "";
  public String MiS = "";
  public String MiT = "";
  public String guid = "";
  public String hCa = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public String jjf = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String oED = "";
  public String uuid = "";
  public String zMk = "";
  
  static
  {
    AppMethodBeat.i(138327);
    MiU = new b();
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
    this.jjf = paramJceInputStream.readString(1, false);
    this.oED = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.MiF = paramJceInputStream.readString(4, false);
    this.MiG = paramJceInputStream.readString(5, false);
    this.FMd = paramJceInputStream.readString(6, false);
    this.MiH = paramJceInputStream.read(this.MiH, 7, false);
    this.MiI = paramJceInputStream.read(this.MiI, 8, false);
    this.MiJ = ((b)paramJceInputStream.read(MiU, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.MiK = paramJceInputStream.read(this.MiK, 12, false);
    this.MiL = paramJceInputStream.read(this.MiL, 13, false);
    this.MiM = paramJceInputStream.read(this.MiM, 14, false);
    this.MiN = paramJceInputStream.read(this.MiN, 15, false);
    this.uuid = paramJceInputStream.readString(16, false);
    this.MiO = paramJceInputStream.read(this.MiO, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.MiP = paramJceInputStream.readString(20, false);
    this.MiQ = paramJceInputStream.read(this.MiQ, 21, false);
    this.MiR = paramJceInputStream.readString(22, false);
    this.hCa = paramJceInputStream.readString(23, false);
    this.zMk = paramJceInputStream.readString(24, false);
    this.MiS = paramJceInputStream.readString(25, false);
    this.MiT = paramJceInputStream.readString(26, false);
    AppMethodBeat.o(138326);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138325);
    paramJceOutputStream.write(this.imei, 0);
    if (this.jjf != null) {
      paramJceOutputStream.write(this.jjf, 1);
    }
    if (this.oED != null) {
      paramJceOutputStream.write(this.oED, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.MiF != null) {
      paramJceOutputStream.write(this.MiF, 4);
    }
    if (this.MiG != null) {
      paramJceOutputStream.write(this.MiG, 5);
    }
    if (this.FMd != null) {
      paramJceOutputStream.write(this.FMd, 6);
    }
    if (this.MiH != 0) {
      paramJceOutputStream.write(this.MiH, 7);
    }
    if (this.MiI != 0) {
      paramJceOutputStream.write(this.MiI, 8);
    }
    if (this.MiJ != null) {
      paramJceOutputStream.write(this.MiJ, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.MiK != 0) {
      paramJceOutputStream.write(this.MiK, 12);
    }
    if (this.MiL != 0) {
      paramJceOutputStream.write(this.MiL, 13);
    }
    if (this.MiM != 0) {
      paramJceOutputStream.write(this.MiM, 14);
    }
    if (this.MiN != 0) {
      paramJceOutputStream.write(this.MiN, 15);
    }
    if (this.uuid != null) {
      paramJceOutputStream.write(this.uuid, 16);
    }
    if (this.MiO != 0) {
      paramJceOutputStream.write(this.MiO, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.MiP != null) {
      paramJceOutputStream.write(this.MiP, 20);
    }
    if (this.MiQ != 0) {
      paramJceOutputStream.write(this.MiQ, 21);
    }
    if (this.MiR != null) {
      paramJceOutputStream.write(this.MiR, 22);
    }
    if (this.hCa != null) {
      paramJceOutputStream.write(this.hCa, 23);
    }
    if (this.zMk != null) {
      paramJceOutputStream.write(this.zMk, 24);
    }
    if (this.MiS != null) {
      paramJceOutputStream.write(this.MiS, 25);
    }
    if (this.MiT != null) {
      paramJceOutputStream.write(this.MiT, 26);
    }
    AppMethodBeat.o(138325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.a.c
 * JD-Core Version:    0.7.0.1
 */