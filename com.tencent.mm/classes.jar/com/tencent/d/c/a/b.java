package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int JRL = 0;
  public int JRM = 0;
  public int JRN = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138323);
    this.JRL = paramJceInputStream.read(this.JRL, 1, true);
    this.JRM = paramJceInputStream.read(this.JRM, 2, true);
    this.JRN = paramJceInputStream.read(this.JRN, 3, true);
    AppMethodBeat.o(138323);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138322);
    paramJceOutputStream.write(this.JRL, 1);
    paramJceOutputStream.write(this.JRM, 2);
    paramJceOutputStream.write(this.JRN, 3);
    AppMethodBeat.o(138322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.a.b
 * JD-Core Version:    0.7.0.1
 */