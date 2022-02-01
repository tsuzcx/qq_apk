package com.tencent.g.d.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  static a ZRK;
  public String RGW = "";
  public a ZRJ = null;
  public String ZnN = "";
  public String ZnO = "";
  public int ZnP = 0;
  public int ZnQ = 0;
  public int ZnS = 0;
  public int ZnT = 0;
  public int ZnU = 0;
  public int ZnV = 0;
  public short ZnW = 0;
  public String ZnX = "";
  public int ZnY = 0;
  public String ZnZ = "";
  public String Zoa = "";
  public String Zob = "";
  public String aid = "";
  public String guid = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String mYG = "";
  public String tol = "";
  public String uuid = "";
  public String vid = "";
  
  static
  {
    AppMethodBeat.i(207969);
    ZRK = new a();
    AppMethodBeat.o(207969);
  }
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(207963);
    b localb = new b();
    AppMethodBeat.o(207963);
    return localb;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207968);
    this.imei = paramJceInputStream.readString(0, true);
    this.mYG = paramJceInputStream.readString(1, false);
    this.tol = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.ZnN = paramJceInputStream.readString(4, false);
    this.ZnO = paramJceInputStream.readString(5, false);
    this.RGW = paramJceInputStream.readString(6, false);
    this.ZnP = paramJceInputStream.read(this.ZnP, 7, false);
    this.ZnQ = paramJceInputStream.read(this.ZnQ, 8, false);
    this.ZRJ = ((a)paramJceInputStream.read(ZRK, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.ZnS = paramJceInputStream.read(this.ZnS, 12, false);
    this.ZnT = paramJceInputStream.read(this.ZnT, 13, false);
    this.ZnU = paramJceInputStream.read(this.ZnU, 14, false);
    this.ZnV = paramJceInputStream.read(this.ZnV, 15, false);
    this.uuid = paramJceInputStream.readString(16, false);
    this.ZnW = paramJceInputStream.read(this.ZnW, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.ZnX = paramJceInputStream.readString(20, false);
    this.ZnY = paramJceInputStream.read(this.ZnY, 21, false);
    this.ZnZ = paramJceInputStream.readString(22, false);
    this.vid = paramJceInputStream.readString(23, false);
    this.aid = paramJceInputStream.readString(24, false);
    this.Zoa = paramJceInputStream.readString(25, false);
    this.Zob = paramJceInputStream.readString(26, false);
    AppMethodBeat.o(207968);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207966);
    paramJceOutputStream.write(this.imei, 0);
    if (this.mYG != null) {
      paramJceOutputStream.write(this.mYG, 1);
    }
    if (this.tol != null) {
      paramJceOutputStream.write(this.tol, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.ZnN != null) {
      paramJceOutputStream.write(this.ZnN, 4);
    }
    if (this.ZnO != null) {
      paramJceOutputStream.write(this.ZnO, 5);
    }
    if (this.RGW != null) {
      paramJceOutputStream.write(this.RGW, 6);
    }
    if (this.ZnP != 0) {
      paramJceOutputStream.write(this.ZnP, 7);
    }
    if (this.ZnQ != 0) {
      paramJceOutputStream.write(this.ZnQ, 8);
    }
    if (this.ZRJ != null) {
      paramJceOutputStream.write(this.ZRJ, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.ZnS != 0) {
      paramJceOutputStream.write(this.ZnS, 12);
    }
    if (this.ZnT != 0) {
      paramJceOutputStream.write(this.ZnT, 13);
    }
    if (this.ZnU != 0) {
      paramJceOutputStream.write(this.ZnU, 14);
    }
    if (this.ZnV != 0) {
      paramJceOutputStream.write(this.ZnV, 15);
    }
    if (this.uuid != null) {
      paramJceOutputStream.write(this.uuid, 16);
    }
    if (this.ZnW != 0) {
      paramJceOutputStream.write(this.ZnW, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.ZnX != null) {
      paramJceOutputStream.write(this.ZnX, 20);
    }
    if (this.ZnY != 0) {
      paramJceOutputStream.write(this.ZnY, 21);
    }
    if (this.ZnZ != null) {
      paramJceOutputStream.write(this.ZnZ, 22);
    }
    if (this.vid != null) {
      paramJceOutputStream.write(this.vid, 23);
    }
    if (this.aid != null) {
      paramJceOutputStream.write(this.aid, 24);
    }
    if (this.Zoa != null) {
      paramJceOutputStream.write(this.Zoa, 25);
    }
    if (this.Zob != null) {
      paramJceOutputStream.write(this.Zob, 26);
    }
    AppMethodBeat.o(207966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.d.a.b
 * JD-Core Version:    0.7.0.1
 */