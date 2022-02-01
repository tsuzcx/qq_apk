package com.tencent.e.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int RLd = 0;
  public int RLe = 0;
  public int RLf = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138323);
    this.RLd = paramJceInputStream.read(this.RLd, 1, true);
    this.RLe = paramJceInputStream.read(this.RLe, 2, true);
    this.RLf = paramJceInputStream.read(this.RLf, 3, true);
    AppMethodBeat.o(138323);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138322);
    paramJceOutputStream.write(this.RLd, 1);
    paramJceOutputStream.write(this.RLe, 2);
    paramJceOutputStream.write(this.RLf, 3);
    AppMethodBeat.o(138322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.c.a.b
 * JD-Core Version:    0.7.0.1
 */