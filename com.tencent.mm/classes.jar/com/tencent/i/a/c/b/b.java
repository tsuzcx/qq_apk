package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public String Sqg = "";
  public String Sqh = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214752);
    this.Sqg = paramJceInputStream.readString(0, true);
    this.Sqh = paramJceInputStream.readString(1, false);
    AppMethodBeat.o(214752);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214751);
    paramJceOutputStream.write(this.Sqg, 0);
    if (this.Sqh != null) {
      paramJceOutputStream.write(this.Sqh, 1);
    }
    AppMethodBeat.o(214751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.b.b
 * JD-Core Version:    0.7.0.1
 */