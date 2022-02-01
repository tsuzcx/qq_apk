package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends JceStruct
{
  static int ZUd = 0;
  public int ZTY = 0;
  public long ZTZ = 0L;
  public float ZUa = 0.0F;
  public float ZUb = 0.0F;
  public int ZUc = 0;
  public float jLa = 0.0F;
  public float jLb = 0.0F;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207523);
    this.ZTY = paramJceInputStream.read(this.ZTY, 0, true);
    this.jLa = paramJceInputStream.read(this.jLa, 1, true);
    this.jLb = paramJceInputStream.read(this.jLb, 2, true);
    this.ZTZ = paramJceInputStream.read(this.ZTZ, 3, true);
    this.ZUa = paramJceInputStream.read(this.ZUa, 4, false);
    this.ZUb = paramJceInputStream.read(this.ZUb, 5, false);
    this.ZUc = paramJceInputStream.read(this.ZUc, 6, false);
    AppMethodBeat.o(207523);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207520);
    paramJceOutputStream.write(this.ZTY, 0);
    paramJceOutputStream.write(this.jLa, 1);
    paramJceOutputStream.write(this.jLb, 2);
    paramJceOutputStream.write(this.ZTZ, 3);
    paramJceOutputStream.write(this.ZUa, 4);
    paramJceOutputStream.write(this.ZUb, 5);
    paramJceOutputStream.write(this.ZUc, 6);
    AppMethodBeat.o(207520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.b.i
 * JD-Core Version:    0.7.0.1
 */