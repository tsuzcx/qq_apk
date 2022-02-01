package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends JceStruct
{
  static int Ssl = 0;
  public float Ssj = 0.0F;
  public float Ssk = 0.0F;
  public int screenOrientation = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214759);
    this.screenOrientation = paramJceInputStream.read(this.screenOrientation, 0, false);
    this.Ssj = paramJceInputStream.read(this.Ssj, 1, false);
    this.Ssk = paramJceInputStream.read(this.Ssk, 2, false);
    AppMethodBeat.o(214759);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214758);
    paramJceOutputStream.write(this.screenOrientation, 0);
    paramJceOutputStream.write(this.Ssj, 1);
    paramJceOutputStream.write(this.Ssk, 2);
    AppMethodBeat.o(214758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.b.e
 * JD-Core Version:    0.7.0.1
 */