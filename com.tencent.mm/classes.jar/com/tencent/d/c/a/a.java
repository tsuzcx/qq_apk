package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  public int IpZ = 0;
  public int Iqa = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138321);
    this.IpZ = paramJceInputStream.read(this.IpZ, 0, true);
    this.Iqa = paramJceInputStream.read(this.Iqa, 1, false);
    AppMethodBeat.o(138321);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138320);
    paramJceOutputStream.write(this.IpZ, 0);
    paramJceOutputStream.write(this.Iqa, 1);
    AppMethodBeat.o(138320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.c.a.a
 * JD-Core Version:    0.7.0.1
 */