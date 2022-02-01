package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int JUd = 0;
  public float JUe = 0.0F;
  public String cIZ = "";
  public String dpt = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138418);
    this.dpt = paramJceInputStream.readString(0, true);
    this.JUd = paramJceInputStream.read(this.JUd, 1, true);
    this.JUe = paramJceInputStream.read(this.JUe, 2, true);
    this.cIZ = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(138418);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138417);
    paramJceOutputStream.write(this.dpt, 0);
    paramJceOutputStream.write(this.JUd, 1);
    paramJceOutputStream.write(this.JUe, 2);
    if (this.cIZ != null) {
      paramJceOutputStream.write(this.cIZ, 3);
    }
    AppMethodBeat.o(138417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */