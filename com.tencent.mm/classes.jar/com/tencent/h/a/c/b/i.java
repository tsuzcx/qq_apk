package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends JceStruct
{
  static int ahYD = 0;
  public float ahYA = 0.0F;
  public float ahYB = 0.0F;
  public int ahYC = 0;
  public int ahYy = 0;
  public long ahYz = 0L;
  public float mkm = 0.0F;
  public float mkn = 0.0F;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(212180);
    this.ahYy = paramJceInputStream.read(this.ahYy, 0, true);
    this.mkm = paramJceInputStream.read(this.mkm, 1, true);
    this.mkn = paramJceInputStream.read(this.mkn, 2, true);
    this.ahYz = paramJceInputStream.read(this.ahYz, 3, true);
    this.ahYA = paramJceInputStream.read(this.ahYA, 4, false);
    this.ahYB = paramJceInputStream.read(this.ahYB, 5, false);
    this.ahYC = paramJceInputStream.read(this.ahYC, 6, false);
    AppMethodBeat.o(212180);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(212174);
    paramJceOutputStream.write(this.ahYy, 0);
    paramJceOutputStream.write(this.mkm, 1);
    paramJceOutputStream.write(this.mkn, 2);
    paramJceOutputStream.write(this.ahYz, 3);
    paramJceOutputStream.write(this.ahYA, 4);
    paramJceOutputStream.write(this.ahYB, 5);
    paramJceOutputStream.write(this.ahYC, 6);
    AppMethodBeat.o(212174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.b.i
 * JD-Core Version:    0.7.0.1
 */