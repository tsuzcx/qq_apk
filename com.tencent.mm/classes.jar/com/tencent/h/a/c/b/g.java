package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends JceStruct
{
  static int ahYx = 0;
  public float QWn = 0.0F;
  public float QWo = 0.0F;
  public float QWp = 0.0F;
  public long ahuN = 0L;
  public int ahuv = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(212210);
    this.ahuv = paramJceInputStream.read(this.ahuv, 0, true);
    this.QWn = paramJceInputStream.read(this.QWn, 1, false);
    this.QWo = paramJceInputStream.read(this.QWo, 2, false);
    this.QWp = paramJceInputStream.read(this.QWp, 3, false);
    this.ahuN = paramJceInputStream.read(this.ahuN, 4, false);
    AppMethodBeat.o(212210);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(212198);
    paramJceOutputStream.write(this.ahuv, 0);
    paramJceOutputStream.write(this.QWn, 1);
    paramJceOutputStream.write(this.QWo, 2);
    paramJceOutputStream.write(this.QWp, 3);
    paramJceOutputStream.write(this.ahuN, 4);
    AppMethodBeat.o(212198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.b.g
 * JD-Core Version:    0.7.0.1
 */