package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends JceStruct
{
  static int ZTO = 0;
  public float JCu = 0.0F;
  public float JCv = 0.0F;
  public int PJe = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207817);
    this.PJe = paramJceInputStream.read(this.PJe, 0, false);
    this.JCu = paramJceInputStream.read(this.JCu, 1, false);
    this.JCv = paramJceInputStream.read(this.JCv, 2, false);
    AppMethodBeat.o(207817);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207814);
    paramJceOutputStream.write(this.PJe, 0);
    paramJceOutputStream.write(this.JCu, 1);
    paramJceOutputStream.write(this.JCv, 2);
    AppMethodBeat.o(207814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.b.e
 * JD-Core Version:    0.7.0.1
 */