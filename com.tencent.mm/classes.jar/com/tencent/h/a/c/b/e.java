package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends JceStruct
{
  static int ahYo = 0;
  public float PSS = 0.0F;
  public float PST = 0.0F;
  public int Wzx = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(212208);
    this.Wzx = paramJceInputStream.read(this.Wzx, 0, false);
    this.PSS = paramJceInputStream.read(this.PSS, 1, false);
    this.PST = paramJceInputStream.read(this.PST, 2, false);
    AppMethodBeat.o(212208);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(212200);
    paramJceOutputStream.write(this.Wzx, 0);
    paramJceOutputStream.write(this.PSS, 1);
    paramJceOutputStream.write(this.PST, 2);
    AppMethodBeat.o(212200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.b.e
 * JD-Core Version:    0.7.0.1
 */