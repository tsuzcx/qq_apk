package com.tencent.e.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static b RLv;
  public String KFF = "";
  public String RLg = "";
  public String RLh = "";
  public int RLi = 0;
  public int RLj = 0;
  public b RLk = null;
  public int RLl = 0;
  public int RLm = 0;
  public int RLn = 0;
  public int RLo = 0;
  public short RLp = 0;
  public String RLq = "";
  public int RLr = 0;
  public String RLs = "";
  public String RLt = "";
  public String RLu = "";
  public String aid = "";
  public String guid = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public String khh = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String pSm = "";
  public String uuid = "";
  public String vid = "";
  
  static
  {
    AppMethodBeat.i(138327);
    RLv = new b();
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
    this.khh = paramJceInputStream.readString(1, false);
    this.pSm = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.RLg = paramJceInputStream.readString(4, false);
    this.RLh = paramJceInputStream.readString(5, false);
    this.KFF = paramJceInputStream.readString(6, false);
    this.RLi = paramJceInputStream.read(this.RLi, 7, false);
    this.RLj = paramJceInputStream.read(this.RLj, 8, false);
    this.RLk = ((b)paramJceInputStream.read(RLv, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.RLl = paramJceInputStream.read(this.RLl, 12, false);
    this.RLm = paramJceInputStream.read(this.RLm, 13, false);
    this.RLn = paramJceInputStream.read(this.RLn, 14, false);
    this.RLo = paramJceInputStream.read(this.RLo, 15, false);
    this.uuid = paramJceInputStream.readString(16, false);
    this.RLp = paramJceInputStream.read(this.RLp, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.RLq = paramJceInputStream.readString(20, false);
    this.RLr = paramJceInputStream.read(this.RLr, 21, false);
    this.RLs = paramJceInputStream.readString(22, false);
    this.vid = paramJceInputStream.readString(23, false);
    this.aid = paramJceInputStream.readString(24, false);
    this.RLt = paramJceInputStream.readString(25, false);
    this.RLu = paramJceInputStream.readString(26, false);
    AppMethodBeat.o(138326);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138325);
    paramJceOutputStream.write(this.imei, 0);
    if (this.khh != null) {
      paramJceOutputStream.write(this.khh, 1);
    }
    if (this.pSm != null) {
      paramJceOutputStream.write(this.pSm, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.RLg != null) {
      paramJceOutputStream.write(this.RLg, 4);
    }
    if (this.RLh != null) {
      paramJceOutputStream.write(this.RLh, 5);
    }
    if (this.KFF != null) {
      paramJceOutputStream.write(this.KFF, 6);
    }
    if (this.RLi != 0) {
      paramJceOutputStream.write(this.RLi, 7);
    }
    if (this.RLj != 0) {
      paramJceOutputStream.write(this.RLj, 8);
    }
    if (this.RLk != null) {
      paramJceOutputStream.write(this.RLk, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.RLl != 0) {
      paramJceOutputStream.write(this.RLl, 12);
    }
    if (this.RLm != 0) {
      paramJceOutputStream.write(this.RLm, 13);
    }
    if (this.RLn != 0) {
      paramJceOutputStream.write(this.RLn, 14);
    }
    if (this.RLo != 0) {
      paramJceOutputStream.write(this.RLo, 15);
    }
    if (this.uuid != null) {
      paramJceOutputStream.write(this.uuid, 16);
    }
    if (this.RLp != 0) {
      paramJceOutputStream.write(this.RLp, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.RLq != null) {
      paramJceOutputStream.write(this.RLq, 20);
    }
    if (this.RLr != 0) {
      paramJceOutputStream.write(this.RLr, 21);
    }
    if (this.RLs != null) {
      paramJceOutputStream.write(this.RLs, 22);
    }
    if (this.vid != null) {
      paramJceOutputStream.write(this.vid, 23);
    }
    if (this.aid != null) {
      paramJceOutputStream.write(this.aid, 24);
    }
    if (this.RLt != null) {
      paramJceOutputStream.write(this.RLt, 25);
    }
    if (this.RLu != null) {
      paramJceOutputStream.write(this.RLu, 26);
    }
    AppMethodBeat.o(138325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.c.a.c
 * JD-Core Version:    0.7.0.1
 */