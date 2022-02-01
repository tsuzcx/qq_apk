package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public String ahYg = "";
  public String ahYh = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(212199);
    this.ahYg = paramJceInputStream.readString(0, true);
    this.ahYh = paramJceInputStream.readString(1, false);
    AppMethodBeat.o(212199);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(212192);
    paramJceOutputStream.write(this.ahYg, 0);
    if (this.ahYh != null) {
      paramJceOutputStream.write(this.ahYh, 1);
    }
    AppMethodBeat.o(212192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.b.b
 * JD-Core Version:    0.7.0.1
 */