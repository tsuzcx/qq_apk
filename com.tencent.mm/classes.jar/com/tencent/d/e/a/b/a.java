package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<e> ZpX;
  public int PzG = 0;
  public String ZnN = "";
  public long ZpS = 0L;
  public ArrayList<e> ZpT = null;
  public String ZpU = "";
  public String ZpV = "";
  public int ZpW = 0;
  public String brand = "";
  public int channel = 0;
  public String fND = "";
  public String fzB = "";
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int requestType = 0;
  public int sdkVer = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138416);
    this.ZpS = paramJceInputStream.read(this.ZpS, 0, true);
    this.fND = paramJceInputStream.readString(1, true);
    if (ZpX == null)
    {
      ZpX = new ArrayList();
      e locale = new e();
      ZpX.add(locale);
    }
    this.ZpT = ((ArrayList)paramJceInputStream.read(ZpX, 2, true));
    this.PzG = paramJceInputStream.read(this.PzG, 3, true);
    this.ZnN = paramJceInputStream.readString(4, true);
    this.channel = paramJceInputStream.read(this.channel, 5, true);
    this.requestType = paramJceInputStream.read(this.requestType, 6, true);
    this.ZpU = paramJceInputStream.readString(7, true);
    this.imei = paramJceInputStream.readString(8, false);
    this.imsi = paramJceInputStream.readString(9, false);
    this.brand = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.ZpV = paramJceInputStream.readString(12, false);
    this.ZpW = paramJceInputStream.read(this.ZpW, 13, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 14, false);
    this.fzB = paramJceInputStream.readString(15, false);
    this.platform = paramJceInputStream.read(this.platform, 16, false);
    AppMethodBeat.o(138416);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138415);
    paramJceOutputStream.write(this.ZpS, 0);
    paramJceOutputStream.write(this.fND, 1);
    paramJceOutputStream.write(this.ZpT, 2);
    paramJceOutputStream.write(this.PzG, 3);
    paramJceOutputStream.write(this.ZnN, 4);
    paramJceOutputStream.write(this.channel, 5);
    paramJceOutputStream.write(this.requestType, 6);
    paramJceOutputStream.write(this.ZpU, 7);
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 8);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 9);
    }
    if (this.brand != null) {
      paramJceOutputStream.write(this.brand, 10);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 11);
    }
    if (this.ZpV != null) {
      paramJceOutputStream.write(this.ZpV, 12);
    }
    if (this.ZpW != 0) {
      paramJceOutputStream.write(this.ZpW, 13);
    }
    if (this.sdkVer != 0) {
      paramJceOutputStream.write(this.sdkVer, 14);
    }
    if (this.fzB != null) {
      paramJceOutputStream.write(this.fzB, 15);
    }
    paramJceOutputStream.write(this.platform, 16);
    AppMethodBeat.o(138415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */