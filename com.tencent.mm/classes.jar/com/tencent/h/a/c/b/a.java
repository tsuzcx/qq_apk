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
  static int ZTA;
  static int ZTB;
  static ArrayList<d> ZTC;
  static b ZTD;
  static byte[] ZTE;
  static Map<String, String> ZTF;
  static ArrayList<f> ZTz;
  public int PzG = 0;
  public String RGU = "";
  public String ZTo = "";
  public long ZTp = 0L;
  public ArrayList<f> ZTq = null;
  public long ZTr = 0L;
  public int ZTs = 0;
  public ArrayList<d> ZTt = null;
  public int ZTu = 0;
  public b ZTv = null;
  public byte[] ZTw = null;
  public String ZTx = "";
  public Map<String, String> ZTy = null;
  public String ZnN = "";
  public String ZpU = "";
  public String ZpV = "";
  public String brand = "";
  public int channelId = 0;
  public int dataType = 0;
  public int fcB = 0;
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int sdkVer = 0;
  public String vid = "";
  
  static
  {
    AppMethodBeat.i(207666);
    ZTz = new ArrayList();
    Object localObject = new f();
    ZTz.add(localObject);
    ZTA = 0;
    ZTB = 0;
    ZTC = new ArrayList();
    localObject = new d();
    ZTC.add(localObject);
    ZTD = new b();
    localObject = (byte[])new byte[1];
    ZTE = (byte[])localObject;
    ((byte[])localObject)[0] = 0;
    ZTF = new HashMap();
    ZTF.put("", "");
    AppMethodBeat.o(207666);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207664);
    this.ZTo = paramJceInputStream.readString(0, true);
    this.channelId = paramJceInputStream.read(this.channelId, 1, true);
    this.ZTp = paramJceInputStream.read(this.ZTp, 2, false);
    this.ZTq = ((ArrayList)paramJceInputStream.read(ZTz, 3, false));
    this.ZTr = paramJceInputStream.read(this.ZTr, 4, false);
    this.dataType = paramJceInputStream.read(this.dataType, 5, false);
    this.fcB = paramJceInputStream.read(this.fcB, 6, false);
    this.ZTs = paramJceInputStream.read(this.ZTs, 7, false);
    this.vid = paramJceInputStream.readString(8, false);
    this.platform = paramJceInputStream.read(this.platform, 9, false);
    this.brand = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.ZTt = ((ArrayList)paramJceInputStream.read(ZTC, 12, false));
    this.PzG = paramJceInputStream.read(this.PzG, 14, false);
    this.ZnN = paramJceInputStream.readString(15, false);
    this.ZpU = paramJceInputStream.readString(16, false);
    this.imsi = paramJceInputStream.readString(17, false);
    this.ZpV = paramJceInputStream.readString(18, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 19, false);
    this.RGU = paramJceInputStream.readString(20, false);
    this.ZTu = paramJceInputStream.read(this.ZTu, 21, false);
    this.ZTv = ((b)paramJceInputStream.read(ZTD, 22, false));
    this.imei = paramJceInputStream.readString(23, false);
    this.ZTw = ((byte[])paramJceInputStream.read(ZTE, 24, false));
    this.ZTx = paramJceInputStream.readString(25, false);
    this.ZTy = ((Map)paramJceInputStream.read(ZTF, 26, false));
    AppMethodBeat.o(207664);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207658);
    paramJceOutputStream.write(this.ZTo, 0);
    paramJceOutputStream.write(this.channelId, 1);
    paramJceOutputStream.write(this.ZTp, 2);
    if (this.ZTq != null) {
      paramJceOutputStream.write(this.ZTq, 3);
    }
    paramJceOutputStream.write(this.ZTr, 4);
    paramJceOutputStream.write(this.dataType, 5);
    paramJceOutputStream.write(this.fcB, 6);
    paramJceOutputStream.write(this.ZTs, 7);
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
    if (this.ZTt != null) {
      paramJceOutputStream.write(this.ZTt, 12);
    }
    paramJceOutputStream.write(this.PzG, 14);
    if (this.ZnN != null) {
      paramJceOutputStream.write(this.ZnN, 15);
    }
    if (this.ZpU != null) {
      paramJceOutputStream.write(this.ZpU, 16);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 17);
    }
    if (this.ZpV != null) {
      paramJceOutputStream.write(this.ZpV, 18);
    }
    paramJceOutputStream.write(this.sdkVer, 19);
    if (this.RGU != null) {
      paramJceOutputStream.write(this.RGU, 20);
    }
    paramJceOutputStream.write(this.ZTu, 21);
    if (this.ZTv != null) {
      paramJceOutputStream.write(this.ZTv, 22);
    }
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 23);
    }
    if (this.ZTw != null) {
      paramJceOutputStream.write(this.ZTw, 24);
    }
    if (this.ZTx != null) {
      paramJceOutputStream.write(this.ZTx, 25);
    }
    if (this.ZTy != null) {
      paramJceOutputStream.write(this.ZTy, 26);
    }
    AppMethodBeat.o(207658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.b.a
 * JD-Core Version:    0.7.0.1
 */