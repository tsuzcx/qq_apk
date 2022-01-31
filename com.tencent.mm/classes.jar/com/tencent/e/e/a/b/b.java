package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int Blp = 0;
  public float Blq = 0.0F;
  public String bYu = "";
  public String feA = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114577);
    this.feA = paramJceInputStream.readString(0, true);
    this.Blp = paramJceInputStream.read(this.Blp, 1, true);
    this.Blq = paramJceInputStream.read(this.Blq, 2, true);
    this.bYu = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(114577);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114576);
    paramJceOutputStream.write(this.feA, 0);
    paramJceOutputStream.write(this.Blp, 1);
    paramJceOutputStream.write(this.Blq, 2);
    if (this.bYu != null) {
      paramJceOutputStream.write(this.bYu, 3);
    }
    AppMethodBeat.o(114576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.e.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */