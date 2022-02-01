package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int ZpY = 0;
  public float ZpZ = 0.0F;
  public String fND = "";
  public String fzB = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138418);
    this.fND = paramJceInputStream.readString(0, true);
    this.ZpY = paramJceInputStream.read(this.ZpY, 1, true);
    this.ZpZ = paramJceInputStream.read(this.ZpZ, 2, true);
    this.fzB = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(138418);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138417);
    paramJceOutputStream.write(this.fND, 0);
    paramJceOutputStream.write(this.ZpY, 1);
    paramJceOutputStream.write(this.ZpZ, 2);
    if (this.fzB != null) {
      paramJceOutputStream.write(this.fzB, 3);
    }
    AppMethodBeat.o(138417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */