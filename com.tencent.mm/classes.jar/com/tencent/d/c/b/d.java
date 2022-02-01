package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String MjJ = "";
  public String MjK = "";
  public int MjL = 0;
  public String MjM = "";
  public int MjN = 0;
  public String hTy = "";
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
    this.MjJ = paramJceInputStream.readString(0, false);
    this.MjK = paramJceInputStream.readString(1, false);
    this.hTy = paramJceInputStream.readString(2, false);
    this.model = paramJceInputStream.readString(3, false);
    this.MjL = paramJceInputStream.read(this.MjL, 4, false);
    this.MjM = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, false);
    this.MjN = paramJceInputStream.read(this.MjN, 7, false);
    AppMethodBeat.o(138341);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138340);
    if (this.MjJ != null) {
      paramJceOutputStream.write(this.MjJ, 0);
    }
    if (this.MjK != null) {
      paramJceOutputStream.write(this.MjK, 1);
    }
    if (this.hTy != null) {
      paramJceOutputStream.write(this.hTy, 2);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 3);
    }
    if (this.MjL != 0) {
      paramJceOutputStream.write(this.MjL, 4);
    }
    if (this.MjM != null) {
      paramJceOutputStream.write(this.MjM, 5);
    }
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 6);
    }
    if (this.MjN != 0) {
      paramJceOutputStream.write(this.MjN, 7);
    }
    AppMethodBeat.o(138340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.d
 * JD-Core Version:    0.7.0.1
 */