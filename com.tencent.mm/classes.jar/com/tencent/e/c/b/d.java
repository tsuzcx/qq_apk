package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String ahtA = "";
  public int ahtB = 0;
  public String ahtC = "";
  public String ahtz = "";
  public String brand = "";
  public String model = "";
  public String platform = "";
  public int root = 0;
  
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
    this.ahtz = paramJceInputStream.readString(0, false);
    this.ahtA = paramJceInputStream.readString(1, false);
    this.brand = paramJceInputStream.readString(2, false);
    this.model = paramJceInputStream.readString(3, false);
    this.ahtB = paramJceInputStream.read(this.ahtB, 4, false);
    this.ahtC = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, false);
    this.root = paramJceInputStream.read(this.root, 7, false);
    AppMethodBeat.o(138341);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138340);
    if (this.ahtz != null) {
      paramJceOutputStream.write(this.ahtz, 0);
    }
    if (this.ahtA != null) {
      paramJceOutputStream.write(this.ahtA, 1);
    }
    if (this.brand != null) {
      paramJceOutputStream.write(this.brand, 2);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 3);
    }
    if (this.ahtB != 0) {
      paramJceOutputStream.write(this.ahtB, 4);
    }
    if (this.ahtC != null) {
      paramJceOutputStream.write(this.ahtC, 5);
    }
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 6);
    }
    if (this.root != 0) {
      paramJceOutputStream.write(this.root, 7);
    }
    AppMethodBeat.o(138340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.c.b.d
 * JD-Core Version:    0.7.0.1
 */