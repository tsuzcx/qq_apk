package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  public int ZnI = 0;
  public int ZnJ = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138321);
    this.ZnI = paramJceInputStream.read(this.ZnI, 0, true);
    this.ZnJ = paramJceInputStream.read(this.ZnJ, 1, false);
    AppMethodBeat.o(138321);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138320);
    paramJceOutputStream.write(this.ZnI, 0);
    paramJceOutputStream.write(this.ZnJ, 1);
    AppMethodBeat.o(138320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.a.a
 * JD-Core Version:    0.7.0.1
 */