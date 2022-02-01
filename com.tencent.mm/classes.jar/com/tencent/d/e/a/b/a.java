package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<e> LNS;
  public int DCw = 0;
  public String LLG = "";
  public long LNN = 0L;
  public ArrayList<e> LNO = null;
  public String LNP = "";
  public String LNQ = "";
  public int LNR = 0;
  public String cUi = "";
  public int channel = 0;
  public String dBg = "";
  public String hQG = "";
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int requestType = 0;
  public int sdkVer = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138416);
    this.LNN = paramJceInputStream.read(this.LNN, 0, true);
    this.dBg = paramJceInputStream.readString(1, true);
    if (LNS == null)
    {
      LNS = new ArrayList();
      e locale = new e();
      LNS.add(locale);
    }
    this.LNO = ((ArrayList)paramJceInputStream.read(LNS, 2, true));
    this.DCw = paramJceInputStream.read(this.DCw, 3, true);
    this.LLG = paramJceInputStream.readString(4, true);
    this.channel = paramJceInputStream.read(this.channel, 5, true);
    this.requestType = paramJceInputStream.read(this.requestType, 6, true);
    this.LNP = paramJceInputStream.readString(7, true);
    this.imei = paramJceInputStream.readString(8, false);
    this.imsi = paramJceInputStream.readString(9, false);
    this.hQG = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.LNQ = paramJceInputStream.readString(12, false);
    this.LNR = paramJceInputStream.read(this.LNR, 13, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 14, false);
    this.cUi = paramJceInputStream.readString(15, false);
    this.platform = paramJceInputStream.read(this.platform, 16, false);
    AppMethodBeat.o(138416);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138415);
    paramJceOutputStream.write(this.LNN, 0);
    paramJceOutputStream.write(this.dBg, 1);
    paramJceOutputStream.write(this.LNO, 2);
    paramJceOutputStream.write(this.DCw, 3);
    paramJceOutputStream.write(this.LLG, 4);
    paramJceOutputStream.write(this.channel, 5);
    paramJceOutputStream.write(this.requestType, 6);
    paramJceOutputStream.write(this.LNP, 7);
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 8);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 9);
    }
    if (this.hQG != null) {
      paramJceOutputStream.write(this.hQG, 10);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 11);
    }
    if (this.LNQ != null) {
      paramJceOutputStream.write(this.LNQ, 12);
    }
    if (this.LNR != 0) {
      paramJceOutputStream.write(this.LNR, 13);
    }
    if (this.sdkVer != 0) {
      paramJceOutputStream.write(this.sdkVer, 14);
    }
    if (this.cUi != null) {
      paramJceOutputStream.write(this.cUi, 15);
    }
    paramJceOutputStream.write(this.platform, 16);
    AppMethodBeat.o(138415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */