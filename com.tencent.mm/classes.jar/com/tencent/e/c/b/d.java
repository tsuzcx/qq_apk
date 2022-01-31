package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends JceStruct
{
  public String Bkg = "";
  public String Bkh = "";
  public int Bki = 0;
  public String Bkj = "";
  public int Bkk = 0;
  public String fwM = "";
  public String model = "";
  public String platform = "";
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(114498);
    d locald = new d();
    AppMethodBeat.o(114498);
    return locald;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114500);
    this.Bkg = paramJceInputStream.readString(0, false);
    this.Bkh = paramJceInputStream.readString(1, false);
    this.fwM = paramJceInputStream.readString(2, false);
    this.model = paramJceInputStream.readString(3, false);
    this.Bki = paramJceInputStream.read(this.Bki, 4, false);
    this.Bkj = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, false);
    this.Bkk = paramJceInputStream.read(this.Bkk, 7, false);
    AppMethodBeat.o(114500);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114499);
    if (this.Bkg != null) {
      paramJceOutputStream.write(this.Bkg, 0);
    }
    if (this.Bkh != null) {
      paramJceOutputStream.write(this.Bkh, 1);
    }
    if (this.fwM != null) {
      paramJceOutputStream.write(this.fwM, 2);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 3);
    }
    if (this.Bki != 0) {
      paramJceOutputStream.write(this.Bki, 4);
    }
    if (this.Bkj != null) {
      paramJceOutputStream.write(this.Bkj, 5);
    }
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 6);
    }
    if (this.Bkk != 0) {
      paramJceOutputStream.write(this.Bkk, 7);
    }
    AppMethodBeat.o(114499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.e.c.b.d
 * JD-Core Version:    0.7.0.1
 */