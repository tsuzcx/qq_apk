package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String ahYm = "";
  public String ahYn = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(212204);
    this.ahYm = paramJceInputStream.readString(0, true);
    this.ahYn = paramJceInputStream.readString(1, true);
    AppMethodBeat.o(212204);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(212194);
    paramJceOutputStream.write(this.ahYm, 0);
    paramJceOutputStream.write(this.ahYn, 1);
    AppMethodBeat.o(212194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.b.d
 * JD-Core Version:    0.7.0.1
 */