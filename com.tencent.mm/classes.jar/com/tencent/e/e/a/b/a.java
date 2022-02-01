package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<e> RNr;
  public int IFo = 0;
  public String RLg = "";
  public long RNm = 0L;
  public ArrayList<e> RNn = null;
  public String RNo = "";
  public String RNp = "";
  public int RNq = 0;
  public String brand = "";
  public int channel = 0;
  public String dGL = "";
  public String dUb = "";
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int requestType = 0;
  public int sdkVer = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138416);
    this.RNm = paramJceInputStream.read(this.RNm, 0, true);
    this.dUb = paramJceInputStream.readString(1, true);
    if (RNr == null)
    {
      RNr = new ArrayList();
      e locale = new e();
      RNr.add(locale);
    }
    this.RNn = ((ArrayList)paramJceInputStream.read(RNr, 2, true));
    this.IFo = paramJceInputStream.read(this.IFo, 3, true);
    this.RLg = paramJceInputStream.readString(4, true);
    this.channel = paramJceInputStream.read(this.channel, 5, true);
    this.requestType = paramJceInputStream.read(this.requestType, 6, true);
    this.RNo = paramJceInputStream.readString(7, true);
    this.imei = paramJceInputStream.readString(8, false);
    this.imsi = paramJceInputStream.readString(9, false);
    this.brand = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.RNp = paramJceInputStream.readString(12, false);
    this.RNq = paramJceInputStream.read(this.RNq, 13, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 14, false);
    this.dGL = paramJceInputStream.readString(15, false);
    this.platform = paramJceInputStream.read(this.platform, 16, false);
    AppMethodBeat.o(138416);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138415);
    paramJceOutputStream.write(this.RNm, 0);
    paramJceOutputStream.write(this.dUb, 1);
    paramJceOutputStream.write(this.RNn, 2);
    paramJceOutputStream.write(this.IFo, 3);
    paramJceOutputStream.write(this.RLg, 4);
    paramJceOutputStream.write(this.channel, 5);
    paramJceOutputStream.write(this.requestType, 6);
    paramJceOutputStream.write(this.RNo, 7);
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
    if (this.RNp != null) {
      paramJceOutputStream.write(this.RNp, 12);
    }
    if (this.RNq != 0) {
      paramJceOutputStream.write(this.RNq, 13);
    }
    if (this.sdkVer != 0) {
      paramJceOutputStream.write(this.sdkVer, 14);
    }
    if (this.dGL != null) {
      paramJceOutputStream.write(this.dGL, 15);
    }
    paramJceOutputStream.write(this.platform, 16);
    AppMethodBeat.o(138415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */