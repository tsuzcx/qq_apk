package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String JST = "";
  public String JSU = "";
  public int JSV = 0;
  public String JSW = "";
  public int JSX = 0;
  public String hym = "";
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
    this.JST = paramJceInputStream.readString(0, false);
    this.JSU = paramJceInputStream.readString(1, false);
    this.hym = paramJceInputStream.readString(2, false);
    this.model = paramJceInputStream.readString(3, false);
    this.JSV = paramJceInputStream.read(this.JSV, 4, false);
    this.JSW = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, false);
    this.JSX = paramJceInputStream.read(this.JSX, 7, false);
    AppMethodBeat.o(138341);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138340);
    if (this.JST != null) {
      paramJceOutputStream.write(this.JST, 0);
    }
    if (this.JSU != null) {
      paramJceOutputStream.write(this.JSU, 1);
    }
    if (this.hym != null) {
      paramJceOutputStream.write(this.hym, 2);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 3);
    }
    if (this.JSV != 0) {
      paramJceOutputStream.write(this.JSV, 4);
    }
    if (this.JSW != null) {
      paramJceOutputStream.write(this.JSW, 5);
    }
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 6);
    }
    if (this.JSX != 0) {
      paramJceOutputStream.write(this.JSX, 7);
    }
    AppMethodBeat.o(138340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.d
 * JD-Core Version:    0.7.0.1
 */