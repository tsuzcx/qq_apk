package com.tencent.e.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int ahss = 0;
  public int ahst = 0;
  public int ahsu = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138323);
    this.ahss = paramJceInputStream.read(this.ahss, 1, true);
    this.ahst = paramJceInputStream.read(this.ahst, 2, true);
    this.ahsu = paramJceInputStream.read(this.ahsu, 3, true);
    AppMethodBeat.o(138323);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138322);
    paramJceOutputStream.write(this.ahss, 1);
    paramJceOutputStream.write(this.ahst, 2);
    paramJceOutputStream.write(this.ahsu, 3);
    AppMethodBeat.o(138322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.c.a.b
 * JD-Core Version:    0.7.0.1
 */