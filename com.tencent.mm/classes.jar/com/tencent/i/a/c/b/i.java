package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends JceStruct
{
  static int SsA = 0;
  public int Ssv = 0;
  public long Ssw = 0L;
  public float Ssx = 0.0F;
  public float Ssy = 0.0F;
  public int Ssz = 0;
  public float gZZ = 0.0F;
  public float haa = 0.0F;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214769);
    this.Ssv = paramJceInputStream.read(this.Ssv, 0, true);
    this.gZZ = paramJceInputStream.read(this.gZZ, 1, true);
    this.haa = paramJceInputStream.read(this.haa, 2, true);
    this.Ssw = paramJceInputStream.read(this.Ssw, 3, true);
    this.Ssx = paramJceInputStream.read(this.Ssx, 4, false);
    this.Ssy = paramJceInputStream.read(this.Ssy, 5, false);
    this.Ssz = paramJceInputStream.read(this.Ssz, 6, false);
    AppMethodBeat.o(214769);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214768);
    paramJceOutputStream.write(this.Ssv, 0);
    paramJceOutputStream.write(this.gZZ, 1);
    paramJceOutputStream.write(this.haa, 2);
    paramJceOutputStream.write(this.Ssw, 3);
    paramJceOutputStream.write(this.Ssx, 4);
    paramJceOutputStream.write(this.Ssy, 5);
    paramJceOutputStream.write(this.Ssz, 6);
    AppMethodBeat.o(214768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.b.i
 * JD-Core Version:    0.7.0.1
 */