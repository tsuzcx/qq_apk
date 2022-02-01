package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int MkS = 0;
  public float MkT = 0.0F;
  public String cVh = "";
  public String dCl = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138418);
    this.dCl = paramJceInputStream.readString(0, true);
    this.MkS = paramJceInputStream.read(this.MkS, 1, true);
    this.MkT = paramJceInputStream.read(this.MkT, 2, true);
    this.cVh = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(138418);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138417);
    paramJceOutputStream.write(this.dCl, 0);
    paramJceOutputStream.write(this.MkS, 1);
    paramJceOutputStream.write(this.MkT, 2);
    if (this.cVh != null) {
      paramJceOutputStream.write(this.cVh, 3);
    }
    AppMethodBeat.o(138417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */