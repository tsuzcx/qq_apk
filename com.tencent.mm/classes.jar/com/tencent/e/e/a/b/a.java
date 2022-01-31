package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<e> Blo;
  public String Bjb = "";
  public long Blj = 0L;
  public ArrayList<e> Blk = null;
  public String Bll = "";
  public String Blm = "";
  public int Bln = 0;
  public String bYu = "";
  public int cCy = 0;
  public String feA = "";
  public String fwM = "";
  public String imei = "";
  public String imsi = "";
  public String model = "";
  public int platform = 0;
  public int requestType = 0;
  public int sdkVer = 0;
  public int uKe = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114575);
    this.Blj = paramJceInputStream.read(this.Blj, 0, true);
    this.feA = paramJceInputStream.readString(1, true);
    if (Blo == null)
    {
      Blo = new ArrayList();
      e locale = new e();
      Blo.add(locale);
    }
    this.Blk = ((ArrayList)paramJceInputStream.read(Blo, 2, true));
    this.uKe = paramJceInputStream.read(this.uKe, 3, true);
    this.Bjb = paramJceInputStream.readString(4, true);
    this.cCy = paramJceInputStream.read(this.cCy, 5, true);
    this.requestType = paramJceInputStream.read(this.requestType, 6, true);
    this.Bll = paramJceInputStream.readString(7, true);
    this.imei = paramJceInputStream.readString(8, false);
    this.imsi = paramJceInputStream.readString(9, false);
    this.fwM = paramJceInputStream.readString(10, false);
    this.model = paramJceInputStream.readString(11, false);
    this.Blm = paramJceInputStream.readString(12, false);
    this.Bln = paramJceInputStream.read(this.Bln, 13, false);
    this.sdkVer = paramJceInputStream.read(this.sdkVer, 14, false);
    this.bYu = paramJceInputStream.readString(15, false);
    this.platform = paramJceInputStream.read(this.platform, 16, false);
    AppMethodBeat.o(114575);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114574);
    paramJceOutputStream.write(this.Blj, 0);
    paramJceOutputStream.write(this.feA, 1);
    paramJceOutputStream.write(this.Blk, 2);
    paramJceOutputStream.write(this.uKe, 3);
    paramJceOutputStream.write(this.Bjb, 4);
    paramJceOutputStream.write(this.cCy, 5);
    paramJceOutputStream.write(this.requestType, 6);
    paramJceOutputStream.write(this.Bll, 7);
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 8);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 9);
    }
    if (this.fwM != null) {
      paramJceOutputStream.write(this.fwM, 10);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 11);
    }
    if (this.Blm != null) {
      paramJceOutputStream.write(this.Blm, 12);
    }
    if (this.Bln != 0) {
      paramJceOutputStream.write(this.Bln, 13);
    }
    if (this.sdkVer != 0) {
      paramJceOutputStream.write(this.sdkVer, 14);
    }
    if (this.bYu != null) {
      paramJceOutputStream.write(this.bYu, 15);
    }
    paramJceOutputStream.write(this.platform, 16);
    AppMethodBeat.o(114574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.e.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */