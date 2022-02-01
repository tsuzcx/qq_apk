package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<e> JUc;
  public int BZA = 0;
  public String JRO = "";
  public long JTX = 0L;
  public ArrayList<e> JTY = null;
  public String JTZ = "";
  public String JUa = "";
  public int JUb = 0;
  public String cIZ = "";
  public int channel = 0;
  public String dpt = "";
  public String hym = "";
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int requestType = 0;
  public int sdkVer = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138416);
    this.JTX = paramJceInputStream.read(this.JTX, 0, true);
    this.dpt = paramJceInputStream.readString(1, true);
    if (JUc == null)
    {
      JUc = new ArrayList();
      e locale = new e();
      JUc.add(locale);
    }
    this.JTY = ((ArrayList)paramJceInputStream.read(JUc, 2, true));
    this.BZA = paramJceInputStream.read(this.BZA, 3, true);
    this.JRO = paramJceInputStream.readString(4, true);
    this.channel = paramJceInputStream.read(this.channel, 5, true);
    this.requestType = paramJceInputStream.read(this.requestType, 6, true);
    this.JTZ = paramJceInputStream.readString(7, true);
    this.imei = paramJceInputStream.readString(8, false);
    this.imsi = paramJceInputStream.readString(9, false);
    this.hym = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.JUa = paramJceInputStream.readString(12, false);
    this.JUb = paramJceInputStream.read(this.JUb, 13, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 14, false);
    this.cIZ = paramJceInputStream.readString(15, false);
    this.platform = paramJceInputStream.read(this.platform, 16, false);
    AppMethodBeat.o(138416);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138415);
    paramJceOutputStream.write(this.JTX, 0);
    paramJceOutputStream.write(this.dpt, 1);
    paramJceOutputStream.write(this.JTY, 2);
    paramJceOutputStream.write(this.BZA, 3);
    paramJceOutputStream.write(this.JRO, 4);
    paramJceOutputStream.write(this.channel, 5);
    paramJceOutputStream.write(this.requestType, 6);
    paramJceOutputStream.write(this.JTZ, 7);
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 8);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 9);
    }
    if (this.hym != null) {
      paramJceOutputStream.write(this.hym, 10);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 11);
    }
    if (this.JUa != null) {
      paramJceOutputStream.write(this.JUa, 12);
    }
    if (this.JUb != 0) {
      paramJceOutputStream.write(this.JUb, 13);
    }
    if (this.sdkVer != 0) {
      paramJceOutputStream.write(this.sdkVer, 14);
    }
    if (this.cIZ != null) {
      paramJceOutputStream.write(this.cIZ, 15);
    }
    paramJceOutputStream.write(this.platform, 16);
    AppMethodBeat.o(138415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */