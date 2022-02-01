package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public String ZTG = "";
  public String ZTH = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207793);
    this.ZTG = paramJceInputStream.readString(0, true);
    this.ZTH = paramJceInputStream.readString(1, false);
    AppMethodBeat.o(207793);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207791);
    paramJceOutputStream.write(this.ZTG, 0);
    if (this.ZTH != null) {
      paramJceOutputStream.write(this.ZTH, 1);
    }
    AppMethodBeat.o(207791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.b.b
 * JD-Core Version:    0.7.0.1
 */