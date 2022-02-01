package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<e> MkR;
  public int DUt = 0;
  public String MiF = "";
  public long MkM = 0L;
  public ArrayList<e> MkN = null;
  public String MkO = "";
  public String MkP = "";
  public int MkQ = 0;
  public String cVh = "";
  public int channel = 0;
  public String dCl = "";
  public String hTy = "";
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int requestType = 0;
  public int sdkVer = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138416);
    this.MkM = paramJceInputStream.read(this.MkM, 0, true);
    this.dCl = paramJceInputStream.readString(1, true);
    if (MkR == null)
    {
      MkR = new ArrayList();
      e locale = new e();
      MkR.add(locale);
    }
    this.MkN = ((ArrayList)paramJceInputStream.read(MkR, 2, true));
    this.DUt = paramJceInputStream.read(this.DUt, 3, true);
    this.MiF = paramJceInputStream.readString(4, true);
    this.channel = paramJceInputStream.read(this.channel, 5, true);
    this.requestType = paramJceInputStream.read(this.requestType, 6, true);
    this.MkO = paramJceInputStream.readString(7, true);
    this.imei = paramJceInputStream.readString(8, false);
    this.imsi = paramJceInputStream.readString(9, false);
    this.hTy = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.MkP = paramJceInputStream.readString(12, false);
    this.MkQ = paramJceInputStream.read(this.MkQ, 13, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 14, false);
    this.cVh = paramJceInputStream.readString(15, false);
    this.platform = paramJceInputStream.read(this.platform, 16, false);
    AppMethodBeat.o(138416);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138415);
    paramJceOutputStream.write(this.MkM, 0);
    paramJceOutputStream.write(this.dCl, 1);
    paramJceOutputStream.write(this.MkN, 2);
    paramJceOutputStream.write(this.DUt, 3);
    paramJceOutputStream.write(this.MiF, 4);
    paramJceOutputStream.write(this.channel, 5);
    paramJceOutputStream.write(this.requestType, 6);
    paramJceOutputStream.write(this.MkO, 7);
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 8);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 9);
    }
    if (this.hTy != null) {
      paramJceOutputStream.write(this.hTy, 10);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 11);
    }
    if (this.MkP != null) {
      paramJceOutputStream.write(this.MkP, 12);
    }
    if (this.MkQ != 0) {
      paramJceOutputStream.write(this.MkQ, 13);
    }
    if (this.sdkVer != 0) {
      paramJceOutputStream.write(this.sdkVer, 14);
    }
    if (this.cVh != null) {
      paramJceOutputStream.write(this.cVh, 15);
    }
    paramJceOutputStream.write(this.platform, 16);
    AppMethodBeat.o(138415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */