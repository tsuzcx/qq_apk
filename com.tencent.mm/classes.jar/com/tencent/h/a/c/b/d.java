package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String ZTM = "";
  public String ZTN = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207898);
    this.ZTM = paramJceInputStream.readString(0, true);
    this.ZTN = paramJceInputStream.readString(1, true);
    AppMethodBeat.o(207898);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207895);
    paramJceOutputStream.write(this.ZTM, 0);
    paramJceOutputStream.write(this.ZTN, 1);
    AppMethodBeat.o(207895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.b.d
 * JD-Core Version:    0.7.0.1
 */