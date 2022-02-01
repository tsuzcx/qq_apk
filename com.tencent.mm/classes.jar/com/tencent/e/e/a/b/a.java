package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<e> ahuE;
  public int WpO = 0;
  public String ahsv = "";
  public long ahuA = 0L;
  public ArrayList<e> ahuB = null;
  public String ahuC = "";
  public int ahuD = 0;
  public String brand = "";
  public int channel = 0;
  public String hEl = "";
  public String hTs = "";
  public String hyE = "";
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int requestType = 0;
  public int sdkVer = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138416);
    this.ahuA = paramJceInputStream.read(this.ahuA, 0, true);
    this.hTs = paramJceInputStream.readString(1, true);
    if (ahuE == null)
    {
      ahuE = new ArrayList();
      e locale = new e();
      ahuE.add(locale);
    }
    this.ahuB = ((ArrayList)paramJceInputStream.read(ahuE, 2, true));
    this.WpO = paramJceInputStream.read(this.WpO, 3, true);
    this.ahsv = paramJceInputStream.readString(4, true);
    this.channel = paramJceInputStream.read(this.channel, 5, true);
    this.requestType = paramJceInputStream.read(this.requestType, 6, true);
    this.ahuC = paramJceInputStream.readString(7, true);
    this.imei = paramJceInputStream.readString(8, false);
    this.imsi = paramJceInputStream.readString(9, false);
    this.brand = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.hyE = paramJceInputStream.readString(12, false);
    this.ahuD = paramJceInputStream.read(this.ahuD, 13, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 14, false);
    this.hEl = paramJceInputStream.readString(15, false);
    this.platform = paramJceInputStream.read(this.platform, 16, false);
    AppMethodBeat.o(138416);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138415);
    paramJceOutputStream.write(this.ahuA, 0);
    paramJceOutputStream.write(this.hTs, 1);
    paramJceOutputStream.write(this.ahuB, 2);
    paramJceOutputStream.write(this.WpO, 3);
    paramJceOutputStream.write(this.ahsv, 4);
    paramJceOutputStream.write(this.channel, 5);
    paramJceOutputStream.write(this.requestType, 6);
    paramJceOutputStream.write(this.ahuC, 7);
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
    if (this.hyE != null) {
      paramJceOutputStream.write(this.hyE, 12);
    }
    if (this.ahuD != 0) {
      paramJceOutputStream.write(this.ahuD, 13);
    }
    if (this.sdkVer != 0) {
      paramJceOutputStream.write(this.sdkVer, 14);
    }
    if (this.hEl != null) {
      paramJceOutputStream.write(this.hEl, 15);
    }
    paramJceOutputStream.write(this.platform, 16);
    AppMethodBeat.o(138415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */