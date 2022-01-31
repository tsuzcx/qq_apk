package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends JceStruct
{
  public long Blx = 0L;
  public float x = 0.0F;
  public float y = 0.0F;
  public float z = 0.0F;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114585);
    this.Blx = paramJceInputStream.read(this.Blx, 0, true);
    this.x = paramJceInputStream.read(this.x, 1, true);
    this.y = paramJceInputStream.read(this.y, 2, true);
    this.z = paramJceInputStream.read(this.z, 3, true);
    AppMethodBeat.o(114585);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114584);
    paramJceOutputStream.write(this.Blx, 0);
    paramJceOutputStream.write(this.x, 1);
    paramJceOutputStream.write(this.y, 2);
    paramJceOutputStream.write(this.z, 3);
    AppMethodBeat.o(114584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.e.e.a.b.f
 * JD-Core Version:    0.7.0.1
 */