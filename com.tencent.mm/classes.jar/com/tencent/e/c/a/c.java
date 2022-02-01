package com.tencent.e.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static b ahsK;
  public String YDY = "";
  public int ahsA = 0;
  public int ahsB = 0;
  public int ahsC = 0;
  public int ahsD = 0;
  public short ahsE = 0;
  public String ahsF = "";
  public int ahsG = 0;
  public String ahsH = "";
  public String ahsI = "";
  public String ahsJ = "";
  public String ahsv = "";
  public String ahsw = "";
  public int ahsx = 0;
  public int ahsy = 0;
  public b ahsz = null;
  public String aid = "";
  public String guid = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String pVo = "";
  public String uuid = "";
  public String vid = "";
  public String wsM = "";
  
  static
  {
    AppMethodBeat.i(138327);
    ahsK = new b();
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
    this.pVo = paramJceInputStream.readString(1, false);
    this.wsM = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.ahsv = paramJceInputStream.readString(4, false);
    this.ahsw = paramJceInputStream.readString(5, false);
    this.YDY = paramJceInputStream.readString(6, false);
    this.ahsx = paramJceInputStream.read(this.ahsx, 7, false);
    this.ahsy = paramJceInputStream.read(this.ahsy, 8, false);
    this.ahsz = ((b)paramJceInputStream.read(ahsK, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.ahsA = paramJceInputStream.read(this.ahsA, 12, false);
    this.ahsB = paramJceInputStream.read(this.ahsB, 13, false);
    this.ahsC = paramJceInputStream.read(this.ahsC, 14, false);
    this.ahsD = paramJceInputStream.read(this.ahsD, 15, false);
    this.uuid = paramJceInputStream.readString(16, false);
    this.ahsE = paramJceInputStream.read(this.ahsE, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.ahsF = paramJceInputStream.readString(20, false);
    this.ahsG = paramJceInputStream.read(this.ahsG, 21, false);
    this.ahsH = paramJceInputStream.readString(22, false);
    this.vid = paramJceInputStream.readString(23, false);
    this.aid = paramJceInputStream.readString(24, false);
    this.ahsI = paramJceInputStream.readString(25, false);
    this.ahsJ = paramJceInputStream.readString(26, false);
    AppMethodBeat.o(138326);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138325);
    paramJceOutputStream.write(this.imei, 0);
    if (this.pVo != null) {
      paramJceOutputStream.write(this.pVo, 1);
    }
    if (this.wsM != null) {
      paramJceOutputStream.write(this.wsM, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.ahsv != null) {
      paramJceOutputStream.write(this.ahsv, 4);
    }
    if (this.ahsw != null) {
      paramJceOutputStream.write(this.ahsw, 5);
    }
    if (this.YDY != null) {
      paramJceOutputStream.write(this.YDY, 6);
    }
    if (this.ahsx != 0) {
      paramJceOutputStream.write(this.ahsx, 7);
    }
    if (this.ahsy != 0) {
      paramJceOutputStream.write(this.ahsy, 8);
    }
    if (this.ahsz != null) {
      paramJceOutputStream.write(this.ahsz, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.ahsA != 0) {
      paramJceOutputStream.write(this.ahsA, 12);
    }
    if (this.ahsB != 0) {
      paramJceOutputStream.write(this.ahsB, 13);
    }
    if (this.ahsC != 0) {
      paramJceOutputStream.write(this.ahsC, 14);
    }
    if (this.ahsD != 0) {
      paramJceOutputStream.write(this.ahsD, 15);
    }
    if (this.uuid != null) {
      paramJceOutputStream.write(this.uuid, 16);
    }
    if (this.ahsE != 0) {
      paramJceOutputStream.write(this.ahsE, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.ahsF != null) {
      paramJceOutputStream.write(this.ahsF, 20);
    }
    if (this.ahsG != 0) {
      paramJceOutputStream.write(this.ahsG, 21);
    }
    if (this.ahsH != null) {
      paramJceOutputStream.write(this.ahsH, 22);
    }
    if (this.vid != null) {
      paramJceOutputStream.write(this.vid, 23);
    }
    if (this.aid != null) {
      paramJceOutputStream.write(this.aid, 24);
    }
    if (this.ahsI != null) {
      paramJceOutputStream.write(this.ahsI, 25);
    }
    if (this.ahsJ != null) {
      paramJceOutputStream.write(this.ahsJ, 26);
    }
    AppMethodBeat.o(138325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.c.a.c
 * JD-Core Version:    0.7.0.1
 */