package com.tencent.e.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static b Bjr;
  public String Bjb = "";
  public String Bjc = "";
  public String Bjd = "";
  public int Bje = 0;
  public int Bjf = 0;
  public b Bjg = null;
  public int Bjh = 0;
  public int Bji = 0;
  public int Bjj = 0;
  public int Bjk = 0;
  public short Bjl = 0;
  public String Bjm = "";
  public int Bjn = 0;
  public String Bjo = "";
  public String Bjp = "";
  public String Bjq = "";
  public String eAx = "";
  public String fgl = "";
  public String guid = "";
  public String gzN = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public String kmA = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String rpv = "";
  
  static
  {
    AppMethodBeat.i(114486);
    Bjr = new b();
    AppMethodBeat.o(114486);
  }
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(114483);
    c localc = new c();
    AppMethodBeat.o(114483);
    return localc;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114485);
    this.imei = paramJceInputStream.readString(0, true);
    this.gzN = paramJceInputStream.readString(1, false);
    this.kmA = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.Bjb = paramJceInputStream.readString(4, false);
    this.Bjc = paramJceInputStream.readString(5, false);
    this.Bjd = paramJceInputStream.readString(6, false);
    this.Bje = paramJceInputStream.read(this.Bje, 7, false);
    this.Bjf = paramJceInputStream.read(this.Bjf, 8, false);
    this.Bjg = ((b)paramJceInputStream.read(Bjr, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.Bjh = paramJceInputStream.read(this.Bjh, 12, false);
    this.Bji = paramJceInputStream.read(this.Bji, 13, false);
    this.Bjj = paramJceInputStream.read(this.Bjj, 14, false);
    this.Bjk = paramJceInputStream.read(this.Bjk, 15, false);
    this.eAx = paramJceInputStream.readString(16, false);
    this.Bjl = paramJceInputStream.read(this.Bjl, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.Bjm = paramJceInputStream.readString(20, false);
    this.Bjn = paramJceInputStream.read(this.Bjn, 21, false);
    this.Bjo = paramJceInputStream.readString(22, false);
    this.fgl = paramJceInputStream.readString(23, false);
    this.rpv = paramJceInputStream.readString(24, false);
    this.Bjp = paramJceInputStream.readString(25, false);
    this.Bjq = paramJceInputStream.readString(26, false);
    AppMethodBeat.o(114485);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114484);
    paramJceOutputStream.write(this.imei, 0);
    if (this.gzN != null) {
      paramJceOutputStream.write(this.gzN, 1);
    }
    if (this.kmA != null) {
      paramJceOutputStream.write(this.kmA, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.Bjb != null) {
      paramJceOutputStream.write(this.Bjb, 4);
    }
    if (this.Bjc != null) {
      paramJceOutputStream.write(this.Bjc, 5);
    }
    if (this.Bjd != null) {
      paramJceOutputStream.write(this.Bjd, 6);
    }
    if (this.Bje != 0) {
      paramJceOutputStream.write(this.Bje, 7);
    }
    if (this.Bjf != 0) {
      paramJceOutputStream.write(this.Bjf, 8);
    }
    if (this.Bjg != null) {
      paramJceOutputStream.write(this.Bjg, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.Bjh != 0) {
      paramJceOutputStream.write(this.Bjh, 12);
    }
    if (this.Bji != 0) {
      paramJceOutputStream.write(this.Bji, 13);
    }
    if (this.Bjj != 0) {
      paramJceOutputStream.write(this.Bjj, 14);
    }
    if (this.Bjk != 0) {
      paramJceOutputStream.write(this.Bjk, 15);
    }
    if (this.eAx != null) {
      paramJceOutputStream.write(this.eAx, 16);
    }
    if (this.Bjl != 0) {
      paramJceOutputStream.write(this.Bjl, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.Bjm != null) {
      paramJceOutputStream.write(this.Bjm, 20);
    }
    if (this.Bjn != 0) {
      paramJceOutputStream.write(this.Bjn, 21);
    }
    if (this.Bjo != null) {
      paramJceOutputStream.write(this.Bjo, 22);
    }
    if (this.fgl != null) {
      paramJceOutputStream.write(this.fgl, 23);
    }
    if (this.rpv != null) {
      paramJceOutputStream.write(this.rpv, 24);
    }
    if (this.Bjp != null) {
      paramJceOutputStream.write(this.Bjp, 25);
    }
    if (this.Bjq != null) {
      paramJceOutputStream.write(this.Bjq, 26);
    }
    AppMethodBeat.o(114484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.e.c.a.c
 * JD-Core Version:    0.7.0.1
 */