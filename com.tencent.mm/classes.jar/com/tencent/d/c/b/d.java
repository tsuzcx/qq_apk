package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String ZoR = "";
  public String ZoS = "";
  public int ZoT = 0;
  public String ZoU = "";
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
    this.ZoR = paramJceInputStream.readString(0, false);
    this.ZoS = paramJceInputStream.readString(1, false);
    this.brand = paramJceInputStream.readString(2, false);
    this.model = paramJceInputStream.readString(3, false);
    this.ZoT = paramJceInputStream.read(this.ZoT, 4, false);
    this.ZoU = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, false);
    this.root = paramJceInputStream.read(this.root, 7, false);
    AppMethodBeat.o(138341);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138340);
    if (this.ZoR != null) {
      paramJceOutputStream.write(this.ZoR, 0);
    }
    if (this.ZoS != null) {
      paramJceOutputStream.write(this.ZoS, 1);
    }
    if (this.brand != null) {
      paramJceOutputStream.write(this.brand, 2);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 3);
    }
    if (this.ZoT != 0) {
      paramJceOutputStream.write(this.ZoT, 4);
    }
    if (this.ZoU != null) {
      paramJceOutputStream.write(this.ZoU, 5);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.d
 * JD-Core Version:    0.7.0.1
 */