package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  static b ahuI;
  public b ahuH = null;
  public int errorCode = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138422);
    this.errorCode = paramJceInputStream.read(this.errorCode, 0, true);
    if (ahuI == null) {
      ahuI = new b();
    }
    this.ahuH = ((b)paramJceInputStream.read(ahuI, 1, false));
    AppMethodBeat.o(138422);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138421);
    paramJceOutputStream.write(this.errorCode, 0);
    if (this.ahuH != null) {
      paramJceOutputStream.write(this.ahuH, 1);
    }
    AppMethodBeat.o(138421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.b.d
 * JD-Core Version:    0.7.0.1
 */