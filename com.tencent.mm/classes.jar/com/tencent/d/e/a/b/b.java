package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  public int LNT = 0;
  public float LNU = 0.0F;
  public String cUi = "";
  public String dBg = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138418);
    this.dBg = paramJceInputStream.readString(0, true);
    this.LNT = paramJceInputStream.read(this.LNT, 1, true);
    this.LNU = paramJceInputStream.read(this.LNU, 2, true);
    this.cUi = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(138418);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138417);
    paramJceOutputStream.write(this.dBg, 0);
    paramJceOutputStream.write(this.LNT, 1);
    paramJceOutputStream.write(this.LNU, 2);
    if (this.cUi != null) {
      paramJceOutputStream.write(this.cUi, 3);
    }
    AppMethodBeat.o(138417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */