package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int RNs = 0;
  public float RNt = 0.0F;
  public String dGL = "";
  public String dUb = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138418);
    this.dUb = paramJceInputStream.readString(0, true);
    this.RNs = paramJceInputStream.read(this.RNs, 1, true);
    this.RNt = paramJceInputStream.read(this.RNt, 2, true);
    this.dGL = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(138418);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138417);
    paramJceOutputStream.write(this.dUb, 0);
    paramJceOutputStream.write(this.RNs, 1);
    paramJceOutputStream.write(this.RNt, 2);
    if (this.dGL != null) {
      paramJceOutputStream.write(this.dGL, 3);
    }
    AppMethodBeat.o(138417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */