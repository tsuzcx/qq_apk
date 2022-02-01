package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String LMK = "";
  public String LML = "";
  public int LMM = 0;
  public String LMN = "";
  public int LMO = 0;
  public String hQG = "";
  public String model = "";
  public String platform = "";
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(138339);
    d locald = new d();
    AppMethodBeat.o(138339);
    return locald;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138341);
    this.LMK = paramJceInputStream.readString(0, false);
    this.LML = paramJceInputStream.readString(1, false);
    this.hQG = paramJceInputStream.readString(2, false);
    this.model = paramJceInputStream.readString(3, false);
    this.LMM = paramJceInputStream.read(this.LMM, 4, false);
    this.LMN = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, false);
    this.LMO = paramJceInputStream.read(this.LMO, 7, false);
    AppMethodBeat.o(138341);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138340);
    if (this.LMK != null) {
      paramJceOutputStream.write(this.LMK, 0);
    }
    if (this.LML != null) {
      paramJceOutputStream.write(this.LML, 1);
    }
    if (this.hQG != null) {
      paramJceOutputStream.write(this.hQG, 2);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 3);
    }
    if (this.LMM != 0) {
      paramJceOutputStream.write(this.LMM, 4);
    }
    if (this.LMN != null) {
      paramJceOutputStream.write(this.LMN, 5);
    }
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 6);
    }
    if (this.LMO != 0) {
      paramJceOutputStream.write(this.LMO, 7);
    }
    AppMethodBeat.o(138340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.d
 * JD-Core Version:    0.7.0.1
 */