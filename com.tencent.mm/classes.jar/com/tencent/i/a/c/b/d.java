package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String Ssh = "";
  public String Ssi = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214757);
    this.Ssh = paramJceInputStream.readString(0, true);
    this.Ssi = paramJceInputStream.readString(1, true);
    AppMethodBeat.o(214757);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214756);
    paramJceOutputStream.write(this.Ssh, 0);
    paramJceOutputStream.write(this.Ssi, 1);
    AppMethodBeat.o(214756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.b.d
 * JD-Core Version:    0.7.0.1
 */