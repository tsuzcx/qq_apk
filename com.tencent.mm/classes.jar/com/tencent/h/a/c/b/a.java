package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends JceStruct
{
  static ArrayList<f> ahXZ;
  static int ahYa;
  static int ahYb;
  static ArrayList<d> ahYc;
  static b ahYd;
  static byte[] ahYe;
  static Map<String, String> ahYf;
  public int WpO = 0;
  public String YDW = "";
  public String ahXO = "";
  public long ahXP = 0L;
  public ArrayList<f> ahXQ = null;
  public long ahXR = 0L;
  public int ahXS = 0;
  public ArrayList<d> ahXT = null;
  public int ahXU = 0;
  public b ahXV = null;
  public byte[] ahXW = null;
  public String ahXX = "";
  public Map<String, String> ahXY = null;
  public String ahsv = "";
  public String ahuC = "";
  public String brand = "";
  public int channelId = 0;
  public int dataType = 0;
  public int hgj = 0;
  public String hyE = "";
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int sdkVer = 0;
  public String vid = "";
  
  static
  {
    AppMethodBeat.i(212207);
    ahXZ = new ArrayList();
    Object localObject = new f();
    ahXZ.add(localObject);
    ahYa = 0;
    ahYb = 0;
    ahYc = new ArrayList();
    localObject = new d();
    ahYc.add(localObject);
    ahYd = new b();
    localObject = new byte[1];
    ahYe = (byte[])localObject;
    localObject[0] = 0;
    ahYf = new HashMap();
    ahYf.put("", "");
    AppMethodBeat.o(212207);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(212222);
    this.ahXO = paramJceInputStream.readString(0, true);
    this.channelId = paramJceInputStream.read(this.channelId, 1, true);
    this.ahXP = paramJceInputStream.read(this.ahXP, 2, false);
    this.ahXQ = ((ArrayList)paramJceInputStream.read(ahXZ, 3, false));
    this.ahXR = paramJceInputStream.read(this.ahXR, 4, false);
    this.dataType = paramJceInputStream.read(this.dataType, 5, false);
    this.hgj = paramJceInputStream.read(this.hgj, 6, false);
    this.ahXS = paramJceInputStream.read(this.ahXS, 7, false);
    this.vid = paramJceInputStream.readString(8, false);
    this.platform = paramJceInputStream.read(this.platform, 9, false);
    this.brand = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.ahXT = ((ArrayList)paramJceInputStream.read(ahYc, 12, false));
    this.WpO = paramJceInputStream.read(this.WpO, 14, false);
    this.ahsv = paramJceInputStream.readString(15, false);
    this.ahuC = paramJceInputStream.readString(16, false);
    this.imsi = paramJceInputStream.readString(17, false);
    this.hyE = paramJceInputStream.readString(18, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 19, false);
    this.YDW = paramJceInputStream.readString(20, false);
    this.ahXU = paramJceInputStream.read(this.ahXU, 21, false);
    this.ahXV = ((b)paramJceInputStream.read(ahYd, 22, false));
    this.imei = paramJceInputStream.readString(23, false);
    this.ahXW = paramJceInputStream.read(ahYe, 24, false);
    this.ahXX = paramJceInputStream.readString(25, false);
    this.ahXY = ((Map)paramJceInputStream.read(ahYf, 26, false));
    AppMethodBeat.o(212222);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(212215);
    paramJceOutputStream.write(this.ahXO, 0);
    paramJceOutputStream.write(this.channelId, 1);
    paramJceOutputStream.write(this.ahXP, 2);
    if (this.ahXQ != null) {
      paramJceOutputStream.write(this.ahXQ, 3);
    }
    paramJceOutputStream.write(this.ahXR, 4);
    paramJceOutputStream.write(this.dataType, 5);
    paramJceOutputStream.write(this.hgj, 6);
    paramJceOutputStream.write(this.ahXS, 7);
    if (this.vid != null) {
      paramJceOutputStream.write(this.vid, 8);
    }
    paramJceOutputStream.write(this.platform, 9);
    if (this.brand != null) {
      paramJceOutputStream.write(this.brand, 10);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 11);
    }
    if (this.ahXT != null) {
      paramJceOutputStream.write(this.ahXT, 12);
    }
    paramJceOutputStream.write(this.WpO, 14);
    if (this.ahsv != null) {
      paramJceOutputStream.write(this.ahsv, 15);
    }
    if (this.ahuC != null) {
      paramJceOutputStream.write(this.ahuC, 16);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 17);
    }
    if (this.hyE != null) {
      paramJceOutputStream.write(this.hyE, 18);
    }
    paramJceOutputStream.write(this.sdkVer, 19);
    if (this.YDW != null) {
      paramJceOutputStream.write(this.YDW, 20);
    }
    paramJceOutputStream.write(this.ahXU, 21);
    if (this.ahXV != null) {
      paramJceOutputStream.write(this.ahXV, 22);
    }
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 23);
    }
    if (this.ahXW != null) {
      paramJceOutputStream.write(this.ahXW, 24);
    }
    if (this.ahXX != null) {
      paramJceOutputStream.write(this.ahXX, 25);
    }
    if (this.ahXY != null) {
      paramJceOutputStream.write(this.ahXY, 26);
    }
    AppMethodBeat.o(212215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.b.a
 * JD-Core Version:    0.7.0.1
 */