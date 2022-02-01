package com.tencent.g.d.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  public int ZnK = 0;
  public int ZnL = 0;
  public int ZnM = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207472);
    this.ZnK = paramJceInputStream.read(this.ZnK, 1, true);
    this.ZnL = paramJceInputStream.read(this.ZnL, 2, true);
    this.ZnM = paramJceInputStream.read(this.ZnM, 3, true);
    AppMethodBeat.o(207472);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207471);
    paramJceOutputStream.write(this.ZnK, 1);
    paramJceOutputStream.write(this.ZnL, 2);
    paramJceOutputStream.write(this.ZnM, 3);
    AppMethodBeat.o(207471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.d.a.a
 * JD-Core Version:    0.7.0.1
 */