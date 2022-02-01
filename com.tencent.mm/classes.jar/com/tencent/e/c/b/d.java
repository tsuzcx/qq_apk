package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String RMk = "";
  public String RMl = "";
  public int RMm = 0;
  public String RMn = "";
  public int RMo = 0;
  public String brand = "";
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
    this.RMk = paramJceInputStream.readString(0, false);
    this.RMl = paramJceInputStream.readString(1, false);
    this.brand = paramJceInputStream.readString(2, false);
    this.model = paramJceInputStream.readString(3, false);
    this.RMm = paramJceInputStream.read(this.RMm, 4, false);
    this.RMn = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, false);
    this.RMo = paramJceInputStream.read(this.RMo, 7, false);
    AppMethodBeat.o(138341);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138340);
    if (this.RMk != null) {
      paramJceOutputStream.write(this.RMk, 0);
    }
    if (this.RMl != null) {
      paramJceOutputStream.write(this.RMl, 1);
    }
    if (this.brand != null) {
      paramJceOutputStream.write(this.brand, 2);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 3);
    }
    if (this.RMm != 0) {
      paramJceOutputStream.write(this.RMm, 4);
    }
    if (this.RMn != null) {
      paramJceOutputStream.write(this.RMn, 5);
    }
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 6);
    }
    if (this.RMo != 0) {
      paramJceOutputStream.write(this.RMo, 7);
    }
    AppMethodBeat.o(138340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.c.b.d
 * JD-Core Version:    0.7.0.1
 */