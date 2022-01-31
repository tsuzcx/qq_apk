package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  static b Bls;
  public b Blr = null;
  public int errorCode = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114581);
    this.errorCode = paramJceInputStream.read(this.errorCode, 0, true);
    if (Bls == null) {
      Bls = new b();
    }
    this.Blr = ((b)paramJceInputStream.read(Bls, 1, false));
    AppMethodBeat.o(114581);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114580);
    paramJceOutputStream.write(this.errorCode, 0);
    if (this.Blr != null) {
      paramJceOutputStream.write(this.Blr, 1);
    }
    AppMethodBeat.o(114580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.b.d
 * JD-Core Version:    0.7.0.1
 */