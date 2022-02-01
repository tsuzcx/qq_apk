package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String Irj = "";
  public String Irk = "";
  public int Irl = 0;
  public String Irm = "";
  public int Irn = 0;
  public String gXN = "";
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
    this.Irj = paramJceInputStream.readString(0, false);
    this.Irk = paramJceInputStream.readString(1, false);
    this.gXN = paramJceInputStream.readString(2, false);
    this.model = paramJceInputStream.readString(3, false);
    this.Irl = paramJceInputStream.read(this.Irl, 4, false);
    this.Irm = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, false);
    this.Irn = paramJceInputStream.read(this.Irn, 7, false);
    AppMethodBeat.o(138341);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138340);
    if (this.Irj != null) {
      paramJceOutputStream.write(this.Irj, 0);
    }
    if (this.Irk != null) {
      paramJceOutputStream.write(this.Irk, 1);
    }
    if (this.gXN != null) {
      paramJceOutputStream.write(this.gXN, 2);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 3);
    }
    if (this.Irl != 0) {
      paramJceOutputStream.write(this.Irl, 4);
    }
    if (this.Irm != null) {
      paramJceOutputStream.write(this.Irm, 5);
    }
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 6);
    }
    if (this.Irn != 0) {
      paramJceOutputStream.write(this.Irn, 7);
    }
    AppMethodBeat.o(138340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.c.b.d
 * JD-Core Version:    0.7.0.1
 */