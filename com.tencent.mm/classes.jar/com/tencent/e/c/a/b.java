package com.tencent.e.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int BiY = 0;
  public int BiZ = 0;
  public int Bja = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114482);
    this.BiY = paramJceInputStream.read(this.BiY, 1, true);
    this.BiZ = paramJceInputStream.read(this.BiZ, 2, true);
    this.Bja = paramJceInputStream.read(this.Bja, 3, true);
    AppMethodBeat.o(114482);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114481);
    paramJceOutputStream.write(this.BiY, 1);
    paramJceOutputStream.write(this.BiZ, 2);
    paramJceOutputStream.write(this.Bja, 3);
    AppMethodBeat.o(114481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.e.c.a.b
 * JD-Core Version:    0.7.0.1
 */