package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int ZnK = 0;
  public int ZnL = 0;
  public int ZnM = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138323);
    this.ZnK = paramJceInputStream.read(this.ZnK, 1, true);
    this.ZnL = paramJceInputStream.read(this.ZnL, 2, true);
    this.ZnM = paramJceInputStream.read(this.ZnM, 3, true);
    AppMethodBeat.o(138323);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138322);
    paramJceOutputStream.write(this.ZnK, 1);
    paramJceOutputStream.write(this.ZnL, 2);
    paramJceOutputStream.write(this.ZnM, 3);
    AppMethodBeat.o(138322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.a.b
 * JD-Core Version:    0.7.0.1
 */