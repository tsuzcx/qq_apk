package com.tencent.e.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  public int ahsq = 0;
  public int ahsr = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138321);
    this.ahsq = paramJceInputStream.read(this.ahsq, 0, true);
    this.ahsr = paramJceInputStream.read(this.ahsr, 1, false);
    AppMethodBeat.o(138321);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138320);
    paramJceOutputStream.write(this.ahsq, 0);
    paramJceOutputStream.write(this.ahsr, 1);
    AppMethodBeat.o(138320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.c.a.a
 * JD-Core Version:    0.7.0.1
 */