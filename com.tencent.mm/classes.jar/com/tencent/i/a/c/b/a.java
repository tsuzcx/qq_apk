package com.tencent.i.a.c.b;

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
  static ArrayList<f> SrW;
  static int SrX;
  static int SrY;
  static ArrayList<d> SrZ;
  static b Ssa;
  static byte[] Ssb;
  static Map<String, String> Ssc;
  public int IFo = 0;
  public String KFD = "";
  public String RLg = "";
  public String RNo = "";
  public String RNp = "";
  public String SrL = "";
  public long SrM = 0L;
  public ArrayList<f> SrN = null;
  public long SrO = 0L;
  public int SrP = 0;
  public ArrayList<d> SrQ = null;
  public int SrR = 0;
  public b SrS = null;
  public byte[] SrT = null;
  public String SrU = "";
  public Map<String, String> SrV = null;
  public String brand = "";
  public int channelId = 0;
  public int dataType = 0;
  public int dkT = 0;
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int sdkVer = 0;
  public String vid = "";
  
  static
  {
    AppMethodBeat.i(214750);
    SrW = new ArrayList();
    Object localObject = new f();
    SrW.add(localObject);
    SrX = 0;
    SrY = 0;
    SrZ = new ArrayList();
    localObject = new d();
    SrZ.add(localObject);
    Ssa = new b();
    localObject = (byte[])new byte[1];
    Ssb = (byte[])localObject;
    ((byte[])localObject)[0] = 0;
    Ssc = new HashMap();
    Ssc.put("", "");
    AppMethodBeat.o(214750);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214749);
    this.SrL = paramJceInputStream.readString(0, true);
    this.channelId = paramJceInputStream.read(this.channelId, 1, true);
    this.SrM = paramJceInputStream.read(this.SrM, 2, false);
    this.SrN = ((ArrayList)paramJceInputStream.read(SrW, 3, false));
    this.SrO = paramJceInputStream.read(this.SrO, 4, false);
    this.dataType = paramJceInputStream.read(this.dataType, 5, false);
    this.dkT = paramJceInputStream.read(this.dkT, 6, false);
    this.SrP = paramJceInputStream.read(this.SrP, 7, false);
    this.vid = paramJceInputStream.readString(8, false);
    this.platform = paramJceInputStream.read(this.platform, 9, false);
    this.brand = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.SrQ = ((ArrayList)paramJceInputStream.read(SrZ, 12, false));
    this.IFo = paramJceInputStream.read(this.IFo, 14, false);
    this.RLg = paramJceInputStream.readString(15, false);
    this.RNo = paramJceInputStream.readString(16, false);
    this.imsi = paramJceInputStream.readString(17, false);
    this.RNp = paramJceInputStream.readString(18, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 19, false);
    this.KFD = paramJceInputStream.readString(20, false);
    this.SrR = paramJceInputStream.read(this.SrR, 21, false);
    this.SrS = ((b)paramJceInputStream.read(Ssa, 22, false));
    this.imei = paramJceInputStream.readString(23, false);
    this.SrT = ((byte[])paramJceInputStream.read(Ssb, 24, false));
    this.SrU = paramJceInputStream.readString(25, false);
    this.SrV = ((Map)paramJceInputStream.read(Ssc, 26, false));
    AppMethodBeat.o(214749);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214748);
    paramJceOutputStream.write(this.SrL, 0);
    paramJceOutputStream.write(this.channelId, 1);
    paramJceOutputStream.write(this.SrM, 2);
    if (this.SrN != null) {
      paramJceOutputStream.write(this.SrN, 3);
    }
    paramJceOutputStream.write(this.SrO, 4);
    paramJceOutputStream.write(this.dataType, 5);
    paramJceOutputStream.write(this.dkT, 6);
    paramJceOutputStream.write(this.SrP, 7);
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
    if (this.SrQ != null) {
      paramJceOutputStream.write(this.SrQ, 12);
    }
    paramJceOutputStream.write(this.IFo, 14);
    if (this.RLg != null) {
      paramJceOutputStream.write(this.RLg, 15);
    }
    if (this.RNo != null) {
      paramJceOutputStream.write(this.RNo, 16);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 17);
    }
    if (this.RNp != null) {
      paramJceOutputStream.write(this.RNp, 18);
    }
    paramJceOutputStream.write(this.sdkVer, 19);
    if (this.KFD != null) {
      paramJceOutputStream.write(this.KFD, 20);
    }
    paramJceOutputStream.write(this.SrR, 21);
    if (this.SrS != null) {
      paramJceOutputStream.write(this.SrS, 22);
    }
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 23);
    }
    if (this.SrT != null) {
      paramJceOutputStream.write(this.SrT, 24);
    }
    if (this.SrU != null) {
      paramJceOutputStream.write(this.SrU, 25);
    }
    if (this.SrV != null) {
      paramJceOutputStream.write(this.SrV, 26);
    }
    AppMethodBeat.o(214748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.b.a
 * JD-Core Version:    0.7.0.1
 */