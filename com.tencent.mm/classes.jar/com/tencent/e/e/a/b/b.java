package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int ahuF = 0;
  public float ahuG = 0.0F;
  public String hEl = "";
  public String hTs = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138418);
    this.hTs = paramJceInputStream.readString(0, true);
    this.ahuF = paramJceInputStream.read(this.ahuF, 1, true);
    this.ahuG = paramJceInputStream.read(this.ahuG, 2, true);
    this.hEl = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(138418);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138417);
    paramJceOutputStream.write(this.hTs, 0);
    paramJceOutputStream.write(this.ahuF, 1);
    paramJceOutputStream.write(this.ahuG, 2);
    if (this.hEl != null) {
      paramJceOutputStream.write(this.hEl, 3);
    }
    AppMethodBeat.o(138417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */