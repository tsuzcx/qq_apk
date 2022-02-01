package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int Iqb = 0;
  public int Iqc = 0;
  public int Iqd = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138323);
    this.Iqb = paramJceInputStream.read(this.Iqb, 1, true);
    this.Iqc = paramJceInputStream.read(this.Iqc, 2, true);
    this.Iqd = paramJceInputStream.read(this.Iqd, 3, true);
    AppMethodBeat.o(138323);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138322);
    paramJceOutputStream.write(this.Iqb, 1);
    paramJceOutputStream.write(this.Iqc, 2);
    paramJceOutputStream.write(this.Iqd, 3);
    AppMethodBeat.o(138322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.c.a.b
 * JD-Core Version:    0.7.0.1
 */