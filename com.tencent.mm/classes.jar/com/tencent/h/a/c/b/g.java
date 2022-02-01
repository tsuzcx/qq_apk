package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends JceStruct
{
  static int ZTX = 0;
  public float KxF = 0.0F;
  public float KxG = 0.0F;
  public float KxH = 0.0F;
  public int ZpN = 0;
  public long Zqg = 0L;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(208189);
    this.ZpN = paramJceInputStream.read(this.ZpN, 0, true);
    this.KxF = paramJceInputStream.read(this.KxF, 1, false);
    this.KxG = paramJceInputStream.read(this.KxG, 2, false);
    this.KxH = paramJceInputStream.read(this.KxH, 3, false);
    this.Zqg = paramJceInputStream.read(this.Zqg, 4, false);
    AppMethodBeat.o(208189);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(208188);
    paramJceOutputStream.write(this.ZpN, 0);
    paramJceOutputStream.write(this.KxF, 1);
    paramJceOutputStream.write(this.KxG, 2);
    paramJceOutputStream.write(this.KxH, 3);
    paramJceOutputStream.write(this.Zqg, 4);
    AppMethodBeat.o(208188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.b.g
 * JD-Core Version:    0.7.0.1
 */