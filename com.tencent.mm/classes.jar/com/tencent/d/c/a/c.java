package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static b Iqu;
  public String Iqe = "";
  public String Iqf = "";
  public String Iqg = "";
  public int Iqh = 0;
  public int Iqi = 0;
  public b Iqj = null;
  public int Iqk = 0;
  public int Iql = 0;
  public int Iqm = 0;
  public int Iqn = 0;
  public short Iqo = 0;
  public String Iqp = "";
  public int Iqq = 0;
  public String Iqr = "";
  public String Iqs = "";
  public String Iqt = "";
  public String gGC = "";
  public String guid = "";
  public String imX = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String nrG = "";
  public String uuid = "";
  public String wSi = "";
  
  static
  {
    AppMethodBeat.i(138327);
    Iqu = new b();
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
    this.imX = paramJceInputStream.readString(1, false);
    this.nrG = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.Iqe = paramJceInputStream.readString(4, false);
    this.Iqf = paramJceInputStream.readString(5, false);
    this.Iqg = paramJceInputStream.readString(6, false);
    this.Iqh = paramJceInputStream.read(this.Iqh, 7, false);
    this.Iqi = paramJceInputStream.read(this.Iqi, 8, false);
    this.Iqj = ((b)paramJceInputStream.read(Iqu, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.Iqk = paramJceInputStream.read(this.Iqk, 12, false);
    this.Iql = paramJceInputStream.read(this.Iql, 13, false);
    this.Iqm = paramJceInputStream.read(this.Iqm, 14, false);
    this.Iqn = paramJceInputStream.read(this.Iqn, 15, false);
    this.uuid = paramJceInputStream.readString(16, false);
    this.Iqo = paramJceInputStream.read(this.Iqo, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.Iqp = paramJceInputStream.readString(20, false);
    this.Iqq = paramJceInputStream.read(this.Iqq, 21, false);
    this.Iqr = paramJceInputStream.readString(22, false);
    this.gGC = paramJceInputStream.readString(23, false);
    this.wSi = paramJceInputStream.readString(24, false);
    this.Iqs = paramJceInputStream.readString(25, false);
    this.Iqt = paramJceInputStream.readString(26, false);
    AppMethodBeat.o(138326);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138325);
    paramJceOutputStream.write(this.imei, 0);
    if (this.imX != null) {
      paramJceOutputStream.write(this.imX, 1);
    }
    if (this.nrG != null) {
      paramJceOutputStream.write(this.nrG, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.Iqe != null) {
      paramJceOutputStream.write(this.Iqe, 4);
    }
    if (this.Iqf != null) {
      paramJceOutputStream.write(this.Iqf, 5);
    }
    if (this.Iqg != null) {
      paramJceOutputStream.write(this.Iqg, 6);
    }
    if (this.Iqh != 0) {
      paramJceOutputStream.write(this.Iqh, 7);
    }
    if (this.Iqi != 0) {
      paramJceOutputStream.write(this.Iqi, 8);
    }
    if (this.Iqj != null) {
      paramJceOutputStream.write(this.Iqj, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.Iqk != 0) {
      paramJceOutputStream.write(this.Iqk, 12);
    }
    if (this.Iql != 0) {
      paramJceOutputStream.write(this.Iql, 13);
    }
    if (this.Iqm != 0) {
      paramJceOutputStream.write(this.Iqm, 14);
    }
    if (this.Iqn != 0) {
      paramJceOutputStream.write(this.Iqn, 15);
    }
    if (this.uuid != null) {
      paramJceOutputStream.write(this.uuid, 16);
    }
    if (this.Iqo != 0) {
      paramJceOutputStream.write(this.Iqo, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.Iqp != null) {
      paramJceOutputStream.write(this.Iqp, 20);
    }
    if (this.Iqq != 0) {
      paramJceOutputStream.write(this.Iqq, 21);
    }
    if (this.Iqr != null) {
      paramJceOutputStream.write(this.Iqr, 22);
    }
    if (this.gGC != null) {
      paramJceOutputStream.write(this.gGC, 23);
    }
    if (this.wSi != null) {
      paramJceOutputStream.write(this.wSi, 24);
    }
    if (this.Iqs != null) {
      paramJceOutputStream.write(this.Iqs, 25);
    }
    if (this.Iqt != null) {
      paramJceOutputStream.write(this.Iqt, 26);
    }
    AppMethodBeat.o(138325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.c.a.c
 * JD-Core Version:    0.7.0.1
 */