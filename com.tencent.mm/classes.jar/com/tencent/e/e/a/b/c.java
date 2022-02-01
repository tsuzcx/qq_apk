package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  public int errCode = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138420);
    this.errCode = paramJceInputStream.read(this.errCode, 0, false);
    AppMethodBeat.o(138420);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138419);
    if (this.errCode != 0) {
      paramJceOutputStream.write(this.errCode, 0);
    }
    AppMethodBeat.o(138419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.b.c
 * JD-Core Version:    0.7.0.1
 */