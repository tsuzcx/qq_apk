package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int MiC = 0;
  public int MiD = 0;
  public int MiE = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138323);
    this.MiC = paramJceInputStream.read(this.MiC, 1, true);
    this.MiD = paramJceInputStream.read(this.MiD, 2, true);
    this.MiE = paramJceInputStream.read(this.MiE, 3, true);
    AppMethodBeat.o(138323);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138322);
    paramJceOutputStream.write(this.MiC, 1);
    paramJceOutputStream.write(this.MiD, 2);
    paramJceOutputStream.write(this.MiE, 3);
    AppMethodBeat.o(138322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.a.b
 * JD-Core Version:    0.7.0.1
 */