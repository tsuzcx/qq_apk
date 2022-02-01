package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int Ist = 0;
  public float Isu = 0.0F;
  public String cLR = "";
  public String drI = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138418);
    this.drI = paramJceInputStream.readString(0, true);
    this.Ist = paramJceInputStream.read(this.Ist, 1, true);
    this.Isu = paramJceInputStream.read(this.Isu, 2, true);
    this.cLR = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(138418);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138417);
    paramJceOutputStream.write(this.drI, 0);
    paramJceOutputStream.write(this.Ist, 1);
    paramJceOutputStream.write(this.Isu, 2);
    if (this.cLR != null) {
      paramJceOutputStream.write(this.cLR, 3);
    }
    AppMethodBeat.o(138417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */