package com.tencent.e.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  public int BiW = 0;
  public int BiX = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114480);
    this.BiW = paramJceInputStream.read(this.BiW, 0, true);
    this.BiX = paramJceInputStream.read(this.BiX, 1, false);
    AppMethodBeat.o(114480);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114479);
    paramJceOutputStream.write(this.BiW, 0);
    paramJceOutputStream.write(this.BiX, 1);
    AppMethodBeat.o(114479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.c.a.a
 * JD-Core Version:    0.7.0.1
 */