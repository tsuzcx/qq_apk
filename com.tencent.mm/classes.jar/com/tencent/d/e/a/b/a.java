package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<e> Iss;
  public int AHj = 0;
  public String Iqe = "";
  public long Isn = 0L;
  public ArrayList<e> Iso = null;
  public String Isp = "";
  public String Isq = "";
  public int Isr = 0;
  public String cLR = "";
  public int channel = 0;
  public String drI = "";
  public String gXN = "";
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int requestType = 0;
  public int sdkVer = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138416);
    this.Isn = paramJceInputStream.read(this.Isn, 0, true);
    this.drI = paramJceInputStream.readString(1, true);
    if (Iss == null)
    {
      Iss = new ArrayList();
      e locale = new e();
      Iss.add(locale);
    }
    this.Iso = ((ArrayList)paramJceInputStream.read(Iss, 2, true));
    this.AHj = paramJceInputStream.read(this.AHj, 3, true);
    this.Iqe = paramJceInputStream.readString(4, true);
    this.channel = paramJceInputStream.read(this.channel, 5, true);
    this.requestType = paramJceInputStream.read(this.requestType, 6, true);
    this.Isp = paramJceInputStream.readString(7, true);
    this.imei = paramJceInputStream.readString(8, false);
    this.imsi = paramJceInputStream.readString(9, false);
    this.gXN = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.Isq = paramJceInputStream.readString(12, false);
    this.Isr = paramJceInputStream.read(this.Isr, 13, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 14, false);
    this.cLR = paramJceInputStream.readString(15, false);
    this.platform = paramJceInputStream.read(this.platform, 16, false);
    AppMethodBeat.o(138416);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138415);
    paramJceOutputStream.write(this.Isn, 0);
    paramJceOutputStream.write(this.drI, 1);
    paramJceOutputStream.write(this.Iso, 2);
    paramJceOutputStream.write(this.AHj, 3);
    paramJceOutputStream.write(this.Iqe, 4);
    paramJceOutputStream.write(this.channel, 5);
    paramJceOutputStream.write(this.requestType, 6);
    paramJceOutputStream.write(this.Isp, 7);
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 8);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 9);
    }
    if (this.gXN != null) {
      paramJceOutputStream.write(this.gXN, 10);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 11);
    }
    if (this.Isq != null) {
      paramJceOutputStream.write(this.Isq, 12);
    }
    if (this.Isr != 0) {
      paramJceOutputStream.write(this.Isr, 13);
    }
    if (this.sdkVer != 0) {
      paramJceOutputStream.write(this.sdkVer, 14);
    }
    if (this.cLR != null) {
      paramJceOutputStream.write(this.cLR, 15);
    }
    paramJceOutputStream.write(this.platform, 16);
    AppMethodBeat.o(138415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */